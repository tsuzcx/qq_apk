package com.tencent.mobileqq.addon;

import abgl;
import android.graphics.Typeface;
import aqgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import kt;
import mqq.app.AppRuntime;

public class DiyPendantFetcher$4
  implements Runnable
{
  public DiyPendantFetcher$4(abgl paramabgl, int paramInt, String paramString) {}
  
  public void run()
  {
    if (aqgm.rm(String.valueOf(this.iI))) {
      if (this.iI == 1) {}
    }
    AppRuntime localAppRuntime;
    do
    {
      try
      {
        ((kt)this.this$0.h.get(Integer.valueOf(this.iI))).mTypeface = Typeface.createFromFile(this.vs);
        this.this$0.cBt();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          QLog.e("DiyPendantFetcher", 1, "Typeface createFromFile Exception path:" + this.vs + "  Message:" + localRuntimeException.getMessage());
        }
      }
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localAppRuntime instanceof QQAppInterface));
    ((VasQuickUpdateManager)((QQAppInterface)localAppRuntime).getManager(184)).downloadItem(4L, "faceAddon.stickerFont.android." + this.iI, "DiyPendantFetcher");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher.4
 * JD-Core Version:    0.7.0.1
 */