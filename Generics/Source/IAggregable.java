package project1;

public interface IAggregable<TElement extends IAggregable<TElement, TResult>, TResult> {

	TResult aggregate(TResult intermediateResult);
}
