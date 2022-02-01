package com.tencent.mobileqq.filemanager.util;

import ahao;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$7
  implements Runnable
{
  public FMToastUtil$7(int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, this.bDv, 0).show(ahao.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.7
 * JD-Core Version:    0.7.0.1
 */