package model.layout;

import model.html.ElementNode;

public class BlockLayout extends Layout {

    public BlockLayout(ElementNode node, Layout parent) {
        super(node, parent);
    }

    // recursively construct the layout tree
    public void layout() {
        this.location.x = this.parent.location.x;
        this.location.y = this.previousSibling
            .map(sibling -> sibling.location.y + sibling.dimension.height)
            .orElseGet(() -> this.parent.location.y);

        for (Layout child : this.children) {
            child.layout();
            this.dimension.height = Math.max(this.dimension.height, (child.location.y + child.dimension.height) - this.location.y);
            this.dimension.width = Math.max(this.dimension.width, (child.location.x + child.dimension.width) - this.location.x);
        }
    }
}
