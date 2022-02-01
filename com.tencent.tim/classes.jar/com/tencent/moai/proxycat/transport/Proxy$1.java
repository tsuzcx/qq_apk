package com.tencent.moai.proxycat.transport;

class Proxy$1
  extends SessionMap<S>
{
  Proxy$1(Proxy paramProxy, int paramInt)
  {
    super(paramInt);
  }
  
  protected void onRemoved(S paramS)
  {
    if (paramS == null) {
      return;
    }
    paramS.finish();
  }
  
  protected boolean shouldRecycle(S paramS)
  {
    if (paramS == null) {
      return false;
    }
    return this.this$0.shouldRecycleSession(paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.transport.Proxy.1
 * JD-Core Version:    0.7.0.1
 */