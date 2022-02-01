package com.tencent.biz.qqcircle.viewmodels;

import altq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import pea;
import peb;

public class QCircleMessageNoticeViewModel$1
  implements Runnable
{
  public QCircleMessageNoticeViewModel$1(pea parampea) {}
  
  public void run()
  {
    altq localaltq = (altq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    try
    {
      localaltq.a(new peb(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleMessageNoticeViewModel", 1, "updateQQCircleRedFlag  updateRedDot" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1
 * JD-Core Version:    0.7.0.1
 */