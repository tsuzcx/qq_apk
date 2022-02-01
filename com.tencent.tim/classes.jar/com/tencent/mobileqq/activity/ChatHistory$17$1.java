package com.tencent.mobileqq.activity;

import android.app.Dialog;
import com.tencent.qphone.base.util.QLog;
import umu;

public class ChatHistory$17$1
  implements Runnable
{
  public ChatHistory$17$1(umu paramumu) {}
  
  public void run()
  {
    try
    {
      this.a.this$0.ch(this.a.this$0.mUin, this.a.this$0.mType);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord Exception", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord OOM", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.a.this$0.F.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.17.1
 * JD-Core Version:    0.7.0.1
 */