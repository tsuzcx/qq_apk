package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription
  implements Subscription
{
  static final State EMPTY_STATE = new State(false, 0);
  private final Subscription actual;
  final AtomicReference<State> state = new AtomicReference(EMPTY_STATE);
  
  public RefCountSubscription(Subscription paramSubscription)
  {
    if (paramSubscription == null) {
      throw new IllegalArgumentException("s");
    }
    this.actual = paramSubscription;
  }
  
  private void unsubscribeActualIfApplicable(State paramState)
  {
    if ((paramState.isUnsubscribed) && (paramState.children == 0)) {
      this.actual.unsubscribe();
    }
  }
  
  public Subscription get()
  {
    AtomicReference localAtomicReference = this.state;
    State localState;
    do
    {
      localState = (State)localAtomicReference.get();
      if (localState.isUnsubscribed) {
        return Subscriptions.unsubscribed();
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.addChild()));
    return new InnerSubscription(this);
  }
  
  public boolean isUnsubscribed()
  {
    return ((State)this.state.get()).isUnsubscribed;
  }
  
  public void unsubscribe()
  {
    AtomicReference localAtomicReference = this.state;
    State localState1;
    State localState2;
    do
    {
      localState1 = (State)localAtomicReference.get();
      if (localState1.isUnsubscribed) {
        return;
      }
      localState2 = localState1.unsubscribe();
    } while (!localAtomicReference.compareAndSet(localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
  
  void unsubscribeAChild()
  {
    AtomicReference localAtomicReference = this.state;
    State localState1;
    State localState2;
    do
    {
      localState1 = (State)localAtomicReference.get();
      localState2 = localState1.removeChild();
    } while (!localAtomicReference.compareAndSet(localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
  
  static final class InnerSubscription
    extends AtomicInteger
    implements Subscription
  {
    final RefCountSubscription parent;
    
    public InnerSubscription(RefCountSubscription paramRefCountSubscription)
    {
      this.parent = paramRefCountSubscription;
    }
    
    public boolean isUnsubscribed()
    {
      return get() != 0;
    }
    
    public void unsubscribe()
    {
      if (compareAndSet(0, 1)) {
        this.parent.unsubscribeAChild();
      }
    }
  }
  
  static final class State
  {
    final int children;
    final boolean isUnsubscribed;
    
    State(boolean paramBoolean, int paramInt)
    {
      this.isUnsubscribed = paramBoolean;
      this.children = paramInt;
    }
    
    State addChild()
    {
      return new State(this.isUnsubscribed, this.children + 1);
    }
    
    State removeChild()
    {
      return new State(this.isUnsubscribed, this.children - 1);
    }
    
    State unsubscribe()
    {
      return new State(true, this.children);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.subscriptions.RefCountSubscription
 * JD-Core Version:    0.7.0.1
 */