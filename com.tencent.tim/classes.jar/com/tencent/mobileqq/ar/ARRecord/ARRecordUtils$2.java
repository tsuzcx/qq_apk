package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class ARRecordUtils$2
  implements Runnable
{
  public ARRecordUtils$2(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!this.val$success)
    {
      QQToast.a(BaseApplicationImpl.getContext(), this.val$content, 0).show();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.val$content, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.2
 * JD-Core Version:    0.7.0.1
 */