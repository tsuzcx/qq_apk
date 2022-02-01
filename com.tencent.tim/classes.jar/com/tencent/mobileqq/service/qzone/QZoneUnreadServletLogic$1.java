package com.tencent.mobileqq.service.qzone;

import android.content.ContentResolver;
import ands;
import aneo;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import sxc;

public final class QZoneUnreadServletLogic$1
  implements Runnable
{
  public QZoneUnreadServletLogic$1(QQAppInterface paramQQAppInterface, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.val$app == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.val$app.getManager(10);
      } while ((localObject == null) || (!(localObject instanceof aneo)));
      localObject = (aneo)localObject;
      if (((aneo)localObject).Aq == null) {
        ((aneo)localObject).Aq = new ArrayList();
      }
      if (((aneo)localObject).Aq.size() == 0) {
        sxc.a(this.val$app.getCurrentAccountUin(), ((aneo)localObject).Aq);
      }
    } while (ands.g(this.val$list, ((aneo)localObject).Aq));
    ((aneo)localObject).Aq.clear();
    ((aneo)localObject).Aq.addAll(this.val$list);
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.t, null, null);
      sxc.q(this.val$app.getCurrentAccountUin(), this.val$list);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 2, "getNavigatorConfigs error:" + localException.getMessage(), localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1
 * JD-Core Version:    0.7.0.1
 */