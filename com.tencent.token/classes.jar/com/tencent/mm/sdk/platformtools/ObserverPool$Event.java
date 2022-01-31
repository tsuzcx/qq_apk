package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import junit.framework.Assert;

public class ObserverPool$Event
{
  public static final int FLAG_ORDER_EXE = 1;
  private final String aB;
  private int aC;
  public final Bundle data = new Bundle();
  
  public ObserverPool$Event(String paramString)
  {
    Assert.assertNotNull(paramString);
    this.aB = paramString;
  }
  
  public int getFlag()
  {
    return this.aC;
  }
  
  public String getId()
  {
    return this.aB;
  }
  
  public void onComplete() {}
  
  public Event setFlag(int paramInt)
  {
    this.aC = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool.Event
 * JD-Core Version:    0.7.0.1
 */