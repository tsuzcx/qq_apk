package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.producers.SingleDelayedProducer;

class OperatorToObservableList$1
  extends Subscriber<T>
{
  boolean completed = false;
  List<T> list = new LinkedList();
  
  OperatorToObservableList$1(OperatorToObservableList paramOperatorToObservableList, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.completed) {
      this.completed = true;
    }
    try
    {
      ArrayList localArrayList = new ArrayList(this.list);
      this.list = null;
      this.val$producer.setValue(localArrayList);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!this.completed) {
      this.list.add(paramT);
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorToObservableList.1
 * JD-Core Version:    0.7.0.1
 */