package com.tencent.mobileqq.activity.aio.doodle;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import wrq;

public class DoodleResHelper$2
  implements Runnable
{
  public DoodleResHelper$2(wrq paramwrq, int paramInt1, int paramInt2, View paramView, ScribbleResMgr.b paramb) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (this.bRh == 0) {
      ScribbleResMgr.a().a(localQQAppInterface, 1, this.bRi, this.val$view, this.a);
    }
    while ((this.bRh != 1) && (this.bRh != 2)) {
      return;
    }
    ScribbleResMgr.a().a(localQQAppInterface, 2, this.bRi, this.val$view, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper.2
 * JD-Core Version:    0.7.0.1
 */