package com.tencent.qapmsdk.impl.appstate;

import android.os.Looper;
import com.tencent.qapmsdk.impl.instrumentation.QAPMUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceStack;

public class MonitorThreadLocal
{
  protected QAPMUnit mainThreadQapmUnit;
  protected ThreadLocal<QAPMUnit> methodEventThreadLocal = new ThreadLocal();
  protected ThreadLocal<TraceStack<QAPMUnit>> traceStackThreadLocal = new ThreadLocal();
  
  public void clear()
  {
    this.methodEventThreadLocal.remove();
    if (this.traceStackThreadLocal.get() != null) {
      ((TraceStack)this.traceStackThreadLocal.get()).clear();
    }
  }
  
  public QAPMUnit getMainThreadQapmUnit()
  {
    return this.mainThreadQapmUnit;
  }
  
  protected TraceStack<QAPMUnit> getTraceStack()
  {
    TraceStack localTraceStack2 = (TraceStack)this.traceStackThreadLocal.get();
    TraceStack localTraceStack1 = localTraceStack2;
    if (localTraceStack2 == null) {
      localTraceStack1 = new TraceStack();
    }
    return localTraceStack1;
  }
  
  public void pop()
  {
    this.methodEventThreadLocal.remove();
    if (this.traceStackThreadLocal.get() != null) {
      ((TraceStack)this.traceStackThreadLocal.get()).pop();
    }
    resetThreadUnit();
  }
  
  public void push(QAPMUnit paramQAPMUnit, Boolean paramBoolean)
  {
    if (paramQAPMUnit == null) {}
    do
    {
      do
      {
        return;
      } while (getTraceStack() == null);
      this.traceStackThreadLocal.set(getTraceStack());
      if ((getTraceStack().isEmpty()) || (getTraceStack().peek() != paramQAPMUnit)) {
        getTraceStack().push(paramQAPMUnit);
      }
      this.methodEventThreadLocal.set(paramQAPMUnit);
    } while (!paramBoolean.booleanValue());
    this.mainThreadQapmUnit = paramQAPMUnit;
  }
  
  public void resetThreadUnit()
  {
    if ((this.traceStackThreadLocal.get() == null) || (((TraceStack)this.traceStackThreadLocal.get()).isEmpty())) {
      this.methodEventThreadLocal.set(null);
    }
    QAPMUnit localQAPMUnit;
    do
    {
      return;
      localQAPMUnit = (QAPMUnit)((TraceStack)this.traceStackThreadLocal.get()).peek();
      this.methodEventThreadLocal.set(localQAPMUnit);
    } while (Looper.myLooper() != Looper.getMainLooper());
    this.mainThreadQapmUnit = localQAPMUnit;
  }
  
  public int stackSize()
  {
    if ((TraceStack)this.traceStackThreadLocal.get() == null) {
      return 0;
    }
    return ((TraceStack)this.traceStackThreadLocal.get()).size();
  }
  
  public QAPMUnit threadQapmUnit()
  {
    return (QAPMUnit)this.methodEventThreadLocal.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.MonitorThreadLocal
 * JD-Core Version:    0.7.0.1
 */