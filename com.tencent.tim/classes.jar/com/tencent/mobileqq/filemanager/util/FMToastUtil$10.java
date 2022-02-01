package com.tencent.mobileqq.filemanager.util;

import ahao;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$10
  implements Runnable
{
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.setToastIcon(2130840061);
    localQQToast.setDuration(3000);
    localQQToast.setToastMsg(this.bDv);
    localQQToast.show(ahao.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.10
 * JD-Core Version:    0.7.0.1
 */