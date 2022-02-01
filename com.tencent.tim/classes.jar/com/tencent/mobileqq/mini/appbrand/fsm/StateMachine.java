package com.tencent.mobileqq.mini.appbrand.fsm;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StateMachine<T, E>
{
  private static final String TAG = "StateMachine";
  private StateMachine<T, E>.State<T> mCurrState;
  private List<E> mEvents = new ArrayList();
  private List<OnStateChangeListener> mStateListeners = new ArrayList();
  private Map<State, List<StateTransfer>> mStateTransferMap = new HashMap();
  
  private void autoConsumeCacheEvents()
  {
    Object localObject1 = new ArrayList(this.mEvents);
    if (((List)localObject1).size() <= 0) {
      label21:
      return;
    } else {
      localObject1 = ((List)localObject1).iterator();
    }
    label182:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label21;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label182;
        }
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject4 = (State)((Map.Entry)localObject3).getKey();
        if (this.mCurrState == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (StateTransfer)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(((StateTransfer)localObject4).event))) {
              break;
            }
            setCurrState(((StateTransfer)localObject4).nextState);
            this.mEvents.remove(localObject2);
          }
        }
      }
    }
  }
  
  public void addStateChangeListener(OnStateChangeListener paramOnStateChangeListener)
  {
    try
    {
      if (!this.mStateListeners.contains(paramOnStateChangeListener)) {
        this.mStateListeners.add(paramOnStateChangeListener);
      }
      return;
    }
    finally
    {
      paramOnStateChangeListener = finally;
      throw paramOnStateChangeListener;
    }
  }
  
  public void addStateTransfer(StateMachine<T, E>.StateTransfer<E> paramStateMachine)
  {
    if ((paramStateMachine == null) || (paramStateMachine.fromState == null)) {
      return;
    }
    List localList = (List)this.mStateTransferMap.get(paramStateMachine.from());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mStateTransferMap.put(paramStateMachine.fromState, localObject);
    }
    ((List)localObject).add(paramStateMachine);
  }
  
  public void appendEvent(E paramE)
  {
    if ((paramE == null) || (this.mCurrState == null)) {}
    label156:
    label157:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (State)((Map.Entry)localObject1).getKey();
        if (this.mCurrState != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (StateTransfer)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(((StateTransfer)localObject2).event)))
          {
            setCurrState(((StateTransfer)localObject2).nextState);
            i = 1;
          }
        }
      }
      for (;;)
      {
        break;
        if (i != 0) {
          break label157;
        }
        this.mEvents.add(paramE);
        return;
      }
    }
  }
  
  public State getCurrState()
  {
    return this.mCurrState;
  }
  
  protected void notifyStateChange(State paramState1, State paramState2)
  {
    try
    {
      paramState1 = this.mStateListeners.iterator();
      while (paramState1.hasNext())
      {
        paramState2 = (OnStateChangeListener)paramState1.next();
        if (paramState2 != null) {
          paramState2.onStateChanged();
        }
      }
    }
    finally {}
  }
  
  public boolean removeStateChangeListener(OnStateChangeListener paramOnStateChangeListener)
  {
    try
    {
      boolean bool = this.mStateListeners.remove(paramOnStateChangeListener);
      return bool;
    }
    finally
    {
      paramOnStateChangeListener = finally;
      throw paramOnStateChangeListener;
    }
  }
  
  public void sendEvent(E paramE)
  {
    if ((paramE == null) || (this.mCurrState == null)) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (State)((Map.Entry)localObject1).getKey();
        if (this.mCurrState == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StateTransfer)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(((StateTransfer)localObject2).event))) {
              break;
            }
            setCurrState(((StateTransfer)localObject2).nextState);
          }
        }
      }
    }
  }
  
  public void setCurrState(State paramState)
  {
    if ((paramState == null) || (paramState == this.mCurrState)) {
      return;
    }
    State localState = getCurrState();
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.mCurrState != null) {}
    for (Object localObject = this.mCurrState.id;; localObject = "N/A")
    {
      QLog.i("StateMachine", 1, localObject + " to " + paramState.id);
      this.mCurrState = paramState;
      this.mCurrState.onStart();
      autoConsumeCacheEvents();
      if (paramState == localState) {
        break;
      }
      notifyStateChange(localState, paramState);
      return;
    }
  }
  
  public static abstract interface OnStateChangeListener
  {
    public abstract void onStateChanged();
  }
  
  public class State<T>
  {
    public T id;
    
    public State()
    {
      Object localObject;
      this.id = localObject;
    }
    
    public void onEnd() {}
    
    public void onStart() {}
  }
  
  public class StateTransfer<E>
  {
    private E event;
    private StateMachine<T, E>.State<T> fromState;
    private StateMachine<T, E>.State<T> nextState;
    
    public StateTransfer() {}
    
    public StateMachine<T, E>.State<T> from()
    {
      return this.fromState;
    }
    
    public StateTransfer from(StateMachine<T, E>.State<T> paramStateMachine)
    {
      this.fromState = paramStateMachine;
      return this;
    }
    
    public StateMachine<T, E>.State<T> next()
    {
      return this.nextState;
    }
    
    public StateTransfer next(StateMachine<T, E>.State<T> paramStateMachine)
    {
      this.nextState = paramStateMachine;
      return this;
    }
    
    public StateTransfer registEvent(E paramE)
    {
      this.event = paramE;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.fsm.StateMachine
 * JD-Core Version:    0.7.0.1
 */