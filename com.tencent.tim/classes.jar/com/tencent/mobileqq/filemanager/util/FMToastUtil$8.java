package com.tencent.mobileqq.filemanager.util;

import ahao;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class FMToastUtil$8
  implements Runnable
{
  public FMToastUtil$8(int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.val$iconType, this.val$msg, this.val$duration).show(ahao.access$000());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.8
 * JD-Core Version:    0.7.0.1
 */