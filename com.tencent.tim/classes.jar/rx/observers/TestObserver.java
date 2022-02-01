package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;

public class TestObserver<T>
  implements Observer<T>
{
  private static Observer<Object> INERT = new TestObserver.1();
  private final Observer<T> delegate;
  private final ArrayList<Notification<T>> onCompletedEvents = new ArrayList();
  private final ArrayList<Throwable> onErrorEvents = new ArrayList();
  private final ArrayList<T> onNextEvents = new ArrayList();
  
  public TestObserver()
  {
    this.delegate = INERT;
  }
  
  public TestObserver(Observer<T> paramObserver)
  {
    this.delegate = paramObserver;
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    if (this.onNextEvents.size() != paramList.size()) {
      throw new AssertionError("Number of items does not match. Provided: " + paramList.size() + "  Actual: " + this.onNextEvents.size());
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = paramList.get(i);
      Object localObject2 = this.onNextEvents.get(i);
      if (localObject1 == null)
      {
        if (localObject2 != null) {
          throw new AssertionError("Value at index: " + i + " expected to be [null] but was: [" + localObject2 + "]");
        }
      }
      else if (!localObject1.equals(localObject2))
      {
        localObject1 = new StringBuilder().append("Value at index: ").append(i).append(" expected to be [").append(localObject1).append("] (").append(localObject1.getClass().getSimpleName()).append(") but was: [").append(localObject2).append("] (");
        if (localObject2 != null) {}
        for (paramList = localObject2.getClass().getSimpleName();; paramList = "null") {
          throw new AssertionError(paramList + ")");
        }
      }
      i += 1;
    }
  }
  
  public void assertTerminalEvent()
  {
    if (this.onErrorEvents.size() > 1) {
      throw new AssertionError("Too many onError events: " + this.onErrorEvents.size());
    }
    if (this.onCompletedEvents.size() > 1) {
      throw new AssertionError("Too many onCompleted events: " + this.onCompletedEvents.size());
    }
    if ((this.onCompletedEvents.size() == 1) && (this.onErrorEvents.size() == 1)) {
      throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
    }
    if ((this.onCompletedEvents.size() == 0) && (this.onErrorEvents.size() == 0)) {
      throw new AssertionError("No terminal events received.");
    }
  }
  
  public List<Object> getEvents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.onNextEvents);
    localArrayList.add(this.onErrorEvents);
    localArrayList.add(this.onCompletedEvents);
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return Collections.unmodifiableList(this.onCompletedEvents);
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return Collections.unmodifiableList(this.onErrorEvents);
  }
  
  public List<T> getOnNextEvents()
  {
    return Collections.unmodifiableList(this.onNextEvents);
  }
  
  public void onCompleted()
  {
    this.onCompletedEvents.add(Notification.createOnCompleted());
    this.delegate.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.onErrorEvents.add(paramThrowable);
    this.delegate.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.onNextEvents.add(paramT);
    this.delegate.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.observers.TestObserver
 * JD-Core Version:    0.7.0.1
 */