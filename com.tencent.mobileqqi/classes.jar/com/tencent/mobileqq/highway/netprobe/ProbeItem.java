package com.tencent.mobileqq.highway.netprobe;

public abstract class ProbeItem
  implements Comparable<ProbeItem>
{
  public ProbeCallback cb;
  protected ProbeRequest mRequest;
  public ProbeResult mResult;
  int priority = 5;
  protected ProbeItem successor = null;
  
  public ProbeItem() {}
  
  public ProbeItem(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public int compareTo(ProbeItem paramProbeItem)
  {
    return this.priority - paramProbeItem.priority;
  }
  
  public abstract void doProbe();
  
  public abstract String getProbeName();
  
  public ProbeResult getProbeResult(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    return new ProbeResult(getProbeName(), paramProbeCallback);
  }
  
  public ProbeItem getSuccessor()
  {
    return this.successor;
  }
  
  public void probe(ProbeRequest paramProbeRequest, ProbeCallback paramProbeCallback)
  {
    this.mRequest = paramProbeRequest;
    this.cb = paramProbeCallback;
    this.mResult = getProbeResult(paramProbeRequest, paramProbeCallback);
    doProbe();
    transferReqToNext(this.mResult.success);
  }
  
  public void setSuccessor(ProbeItem paramProbeItem)
  {
    this.successor = paramProbeItem;
  }
  
  public void transferReqToNext(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.successor != null)) {
      this.successor.probe(this.mRequest, this.cb);
    }
  }
  
  public static class ProbeResult
  {
    public ProbeCallback cb;
    public int errCode;
    public String errDesc;
    public Object extra;
    public String probeName;
    protected StringBuilder result = new StringBuilder();
    public boolean success = false;
    
    public ProbeResult(String paramString, ProbeCallback paramProbeCallback)
    {
      this.cb = paramProbeCallback;
      this.probeName = paramString;
      this.errCode = 0;
    }
    
    public ProbeResult appendResult(String paramString)
    {
      this.result.append(paramString);
      if (this.cb != null) {
        this.cb.onProbeProgress(paramString);
      }
      return this;
    }
    
    public String getRdmReportMsg()
    {
      String str1 = "<" + this.probeName + " start>";
      String str2 = "<" + this.probeName + " end>";
      return str1 + "succ:" + this.success + ",result:" + this.result.toString() + ",errDesc:" + this.errDesc + str2;
    }
    
    public String getResult()
    {
      return this.result.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.ProbeItem
 * JD-Core Version:    0.7.0.1
 */