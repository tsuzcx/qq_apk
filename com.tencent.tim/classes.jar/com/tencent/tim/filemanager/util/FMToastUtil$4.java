package com.tencent.tim.filemanager.util;

import auds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$4
  implements Runnable
{
  public FMToastUtil$4(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.val$msg, 0).show(auds.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FMToastUtil.4
 * JD-Core Version:    0.7.0.1
 */