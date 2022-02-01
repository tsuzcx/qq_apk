package rx.internal.operators;

import java.util.Collection;
import java.util.Map;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class OperatorToMultimap$1
  extends Subscriber<T>
{
  private Map<K, Collection<V>> map = this.val$fLocalMap;
  
  OperatorToMultimap$1(OperatorToMultimap paramOperatorToMultimap, Subscriber paramSubscriber1, Map paramMap, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    Map localMap = this.map;
    this.map = null;
    this.val$subscriber.onNext(localMap);
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.map = null;
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Object localObject1 = this.this$0.keySelector.call(paramT);
      Object localObject2 = this.this$0.valueSelector.call(paramT);
      Collection localCollection = (Collection)this.map.get(localObject1);
      paramT = localCollection;
      if (localCollection == null) {}
      return;
    }
    catch (Throwable paramT)
    {
      try
      {
        paramT = (Collection)this.this$0.collectionFactory.call(localObject1);
        this.map.put(localObject1, paramT);
        paramT.add(localObject2);
        return;
      }
      catch (Throwable paramT)
      {
        Exceptions.throwOrReport(paramT, this.val$subscriber);
      }
      paramT = paramT;
      Exceptions.throwOrReport(paramT, this.val$subscriber);
      return;
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OperatorToMultimap.1
 * JD-Core Version:    0.7.0.1
 */