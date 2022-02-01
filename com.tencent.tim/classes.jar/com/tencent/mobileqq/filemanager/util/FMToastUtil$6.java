package com.tencent.mobileqq.filemanager.util;

import ahao;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$6
  implements Runnable
{
  public FMToastUtil$6(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 0, this.val$msg, 0).show(ahao.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.6
 * JD-Core Version:    0.7.0.1
 */