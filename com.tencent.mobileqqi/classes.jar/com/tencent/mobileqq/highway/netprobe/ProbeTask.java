package com.tencent.mobileqq.highway.netprobe;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ProbeTask
{
  public ProbeCallback cb;
  WeakReference<WeakNetLearner> learner;
  public ProbeRequest req;
  public ProbeResponse resp;
  
  public ProbeTask(ProbeRequest paramProbeRequest)
  {
    this(paramProbeRequest, null);
  }
  
  public ProbeTask(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    this.req = paramProbeRequest;
    this.cb = paramProbeCallback;
    this.resp = new ProbeResponse(paramProbeRequest.trigglePoint, paramProbeCallback);
  }
  
  public void collectResult()
  {
    this.resp.success = true;
    for (ProbeItem localProbeItem = this.req.root;; localProbeItem = localProbeItem.getSuccessor()) {
      if (localProbeItem != null)
      {
        this.resp.mProbeItemResults.put(localProbeItem, localProbeItem.mResult);
        if (!localProbeItem.mResult.success)
        {
          this.resp.success = false;
          this.resp.errDesc = (localProbeItem.getProbeName() + ":" + localProbeItem.mResult.errDesc);
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public String getKey()
  {
    return this.req.toString();
  }
  
  public void onTaskFinish()
  {
    if ((this.cb != null) && (this.resp != null)) {
      this.cb.onProbeFinish(this.resp);
    }
    if (this.learner.get() != null) {
      ((WeakNetLearner)this.learner.get()).onTaskFinish(this);
    }
  }
  
  public void startProbe()
  {
    try
    {
      if (this.req.root != null)
      {
        this.req.root.probe(this.req, this.cb);
        collectResult();
        onTaskFinish();
        return;
      }
      throw new Exception("at lease one probe item need！");
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        this.resp.success = false;
        this.resp.errDesc = localThrowable.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeTask
 * JD-Core Version:    0.7.0.1
 */