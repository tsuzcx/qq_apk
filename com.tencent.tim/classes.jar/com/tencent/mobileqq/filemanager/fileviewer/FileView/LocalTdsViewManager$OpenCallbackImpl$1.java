package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import agrj.a;
import agrj.b;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class LocalTdsViewManager$OpenCallbackImpl$1
  implements Runnable
{
  public LocalTdsViewManager$OpenCallbackImpl$1(agrj.b paramb, Integer paramInteger, Object paramObject, Bundle paramBundle) {}
  
  public void run()
  {
    boolean bool2 = true;
    switch (this.Q.intValue())
    {
    default: 
    case 2001: 
      do
      {
        return;
        QLog.w("TdsReaderView_LocalTdsViewManager", 1, "showErrorCode:" + this.val$params);
      } while (agrj.b.a(this.this$0) == null);
      agrj.b.a(this.this$0).Jy(false);
      return;
    }
    boolean bool1;
    if (!((Boolean)this.val$params).booleanValue())
    {
      bool1 = true;
      if ((this.N == null) || (this.N.getInt("result_", -1) != 0)) {
        break label144;
      }
    }
    for (;;)
    {
      agrj.b.a(this.this$0).bY(bool1, bool2);
      return;
      bool1 = false;
      break;
      label144:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTdsViewManager.OpenCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */