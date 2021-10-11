package BST;

import java.util.function.BiFunction;

public class BST<T> {
    Node<T> root;
    BiFunction<T, T, Integer> compareFn;

    public BST(BiFunction<T, T, Integer> compareFn) {
        this.compareFn = compareFn;
    }

    public void add(T value) {
        if(this.root == null) {
            this.root = new Node<>(value);
        } else {
            add(value, this.root);
        }
    }

    private void add(T value, Node<T> node) {
        if(this.compareFn.apply(node.value, value) > 0) {
            if(node.left == null) {
                node.left = new Node<>(value);
                node.left.parent = node;
            } else {
                add(value, node.left);
            }
        } else if (this.compareFn.apply(node.value, value) < 0) {
            if(node.right == null) {
                node.right = new Node<>(value);
                node.right.parent = node;
            } else {
                add(value, node.right);
            }
        }
    }

    public T delete(T value) {
        Node<T> node = find(value);
        return delete(node);
    }

    private T delete(Node<T> node) {

        if(node.parent == null) {
            // root
            if(node.left == null && node.right == null) {
                // node had no descendants
                T value = node.value;
                this.root = null;
                return value;
            }

            if(node.left == null) {
                // node right alone has a value
                T value = node.value;
                node.right.parent = null;
                this.root = node.right;
                return value;
            }

            if(node.right == null) {
                // node left alone has a value
                T value = node.value;
                node.left.parent = null;
                this.root = node.left;
                return value;
            }
        } else {
            boolean isRightOfParent = true;

            if(node.parent.left != null && this.compareFn.apply(node.parent.left.value, node.value) == 0) {
                isRightOfParent = false;
            }

            if(node.left == null && node.right == null) {
                // node had no descendants
                T value = node.value;

                if(isRightOfParent) {
                    node.parent.right = null;
                } else {
                    node.parent.left = null;
                }

                return value;
            }

            if(node.left == null) {
                // node right alone has a value
                T value = node.value;

                // set the replacement node's parent to the deleted node's parent
                node.right.parent = node.parent;
                if(isRightOfParent) {
                    node.parent.right = node.right;
                } else {
                    node.parent.left = node.right;
                }
                return value;
            }

            if(node.right == null) {
                // node left alone has a value
                T value = node.value;
                node.left.parent = node.parent;
                if(isRightOfParent) {
                    node.parent.right = node.left;
                } else {
                    node.parent.left = node.left;
                }
                return value;
            }
        }
        // has descendants on both sides
        Node<T> smallestAfter = findMinimum(node.right);
        T temp = node.value;
        node.value = delete(smallestAfter);

        return temp;
    }

    public Node<T> find(T value) {
        if(this.root == null) {
            return null;
        }

        return find(value, this.root);
    }

    private Node<T> find(T value, Node<T> node) {

        if(node == null) {
            return null;
        }

        if(this.compareFn.apply(node.value, value) == 0) {
            return node;
        } else if (this.compareFn.apply(node.value, value) > 0) {
            return find(value, node.left);
        } else {
            return find(value, node.right);
        }
    }

    public Node<T> findMinimum(Node<T> start) {
        Node<T> node = start;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void traverseInOrder() {
        if(this.root == null) return;
        traverseInOrder(this.root);
    }

    private void traverseInOrder(Node<T> node) {
        if(node.left != null) {
            traverseInOrder(node.left);
        }
        System.out.println(node.value);
        if (node.right != null) {
            traverseInOrder(node.right);
        }
    }

    public void traverseInOrderDesc() {
        if(this.root == null) return;
        traverseInOrderDesc(this.root);
    }

    private void traverseInOrderDesc(Node<T> node) {
        if (node.right != null) {
            traverseInOrderDesc(node.right);
        }
        System.out.println(node.value);
        if(node.left != null) {
            traverseInOrderDesc(node.left);
        }
    }

    public void traversePostOrder() {
        if(this.root == null) return;
        traversePostOrder(this.root);
    }

    private void traversePostOrder(Node<T> node) {

        if(node.left != null) {
            traversePostOrder(node.left);
        }

        if (node.right != null) {
            traversePostOrder(node.right);
        }

        System.out.println(node.value);
    }



    public void traversePreOrder() {
        if(this.root == null) return;
        traversePreOrder(this.root);
    }

    private void traversePreOrder(Node<T> node) {
        System.out.println(node.value);

        if (node.right != null) {
            traversePreOrder(node.right);
        }

        if(node.left != null) {
            traversePreOrder(node.left);
        }
    }
}
