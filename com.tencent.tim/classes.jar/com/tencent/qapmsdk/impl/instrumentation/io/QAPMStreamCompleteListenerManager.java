package com.tencent.qapmsdk.impl.instrumentation.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QAPMStreamCompleteListenerManager
{
  private boolean streamComplete = false;
  private ArrayList<QAPMStreamCompleteListener> streamCompleteListeners = new ArrayList();
  
  private boolean checkComplete()
  {
    try
    {
      boolean bool = isComplete();
      if (!bool) {
        this.streamComplete = true;
      }
      return bool;
    }
    finally {}
  }
  
  private List<QAPMStreamCompleteListener> getStreamCompleteListeners()
  {
    synchronized (this.streamCompleteListeners)
    {
      ArrayList localArrayList2 = new ArrayList(this.streamCompleteListeners);
      this.streamCompleteListeners.clear();
      return localArrayList2;
    }
  }
  
  public void addStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    synchronized (this.streamCompleteListeners)
    {
      this.streamCompleteListeners.add(paramQAPMStreamCompleteListener);
      return;
    }
  }
  
  public boolean isComplete()
  {
    try
    {
      boolean bool = this.streamComplete;
      return bool;
    }
    finally {}
  }
  
  public void notifyStreamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    if (!checkComplete())
    {
      Iterator localIterator = getStreamCompleteListeners().iterator();
      while (localIterator.hasNext()) {
        ((QAPMStreamCompleteListener)localIterator.next()).streamComplete(paramQAPMStreamCompleteEvent);
      }
    }
  }
  
  public void notifyStreamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    if (!checkComplete())
    {
      Iterator localIterator = getStreamCompleteListeners().iterator();
      while (localIterator.hasNext()) {
        ((QAPMStreamCompleteListener)localIterator.next()).streamError(paramQAPMStreamCompleteEvent);
      }
    }
  }
  
  public void removeStreamCompleteListener(QAPMStreamCompleteListener paramQAPMStreamCompleteListener)
  {
    synchronized (this.streamCompleteListeners)
    {
      this.streamCompleteListeners.remove(paramQAPMStreamCompleteListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListenerManager
 * JD-Core Version:    0.7.0.1
 */