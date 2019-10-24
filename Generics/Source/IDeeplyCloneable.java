package project1;

public interface IDeeplyCloneable<TElement extends IDeeplyCloneable<TElement>> {

	TElement deepClone();
}
