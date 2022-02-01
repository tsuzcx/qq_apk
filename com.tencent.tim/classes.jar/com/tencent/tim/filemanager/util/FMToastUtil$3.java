package com.tencent.tim.filemanager.util;

import auds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$3
  implements Runnable
{
  public FMToastUtil$3(int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.bDv, 0).show(auds.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FMToastUtil.3
 * JD-Core Version:    0.7.0.1
 */