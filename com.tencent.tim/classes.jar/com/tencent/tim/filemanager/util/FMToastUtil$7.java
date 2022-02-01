package com.tencent.tim.filemanager.util;

import auds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$7
  implements Runnable
{
  public FMToastUtil$7(int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.val$iconType, this.val$msg, this.val$duration).show(auds.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FMToastUtil.7
 * JD-Core Version:    0.7.0.1
 */