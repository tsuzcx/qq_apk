package com.tencent.mobileqq.config;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import mqq.os.MqqHandler;

public class ResourcePluginListener
{
  public static void a(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    BaseApplicationImpl.sUiHandler.post(new CallbackRunner(paramResourcePluginListener, paramByte, paramInt));
  }
  
  public void e(byte paramByte) {}
  
  public void h(byte paramByte) {}
  
  public static class CallbackRunner
    implements Runnable
  {
    private byte bn;
    private int cNe;
    private SoftReference<ResourcePluginListener> p;
    
    public CallbackRunner(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
    {
      this.p = new SoftReference(paramResourcePluginListener);
      this.bn = paramByte;
      this.cNe = paramInt;
    }
    
    public void run()
    {
      ResourcePluginListener localResourcePluginListener = (ResourcePluginListener)this.p.get();
      if ((localResourcePluginListener == null) && (QLog.isColorLevel())) {
        QLog.d("LebaHelper", 2, "ResourcePluginListener is null");
      }
      if (localResourcePluginListener != null)
      {
        if (this.cNe != 2) {
          break label50;
        }
        localResourcePluginListener.h(this.bn);
      }
      label50:
      while (this.cNe != 1) {
        return;
      }
      localResourcePluginListener.e(this.bn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ResourcePluginListener
 * JD-Core Version:    0.7.0.1
 */