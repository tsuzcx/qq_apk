package com.tencent.mobileqq.activity;

import altq;
import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import pco;
import utt;

public class ConversationTitleBtnCtrl$1
  implements Runnable
{
  public ConversationTitleBtnCtrl$1(utt paramutt) {}
  
  public void run()
  {
    localObject = (altq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    try
    {
      localAppInfo = ((altq)localObject).getAppInfoByPath("140000");
      if (localAppInfo == null) {
        return;
      }
      localObject = ((altq)localObject).ai(140000);
      if (localObject == null) {
        break label292;
      }
      localObject = ((List)localObject).iterator();
      i = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo;
          if (((Iterator)localObject).hasNext())
          {
            k = i;
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject).next();
            if (localNumRedPath == null) {
              continue;
            }
            k = i;
            if (localNumRedPath.uint32_msg_status.get() != 0) {
              continue;
            }
            i += 1;
            break label289;
          }
          k = j;
          i = localAppInfo.iNewFlag.get();
          if (i == 1)
          {
            bool = true;
            i = j;
            if (utt.a(this.this$0) != bool)
            {
              utt.a(this.this$0, bool);
              utt.b(this.this$0, true);
            }
            utt.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.1.1(this, i, bool));
            if (!utt.b(this.this$0)) {
              continue;
            }
            if (!utt.a(this.this$0)) {
              continue;
            }
            pco.b("", 2, 1L, 1L);
            utt.b(this.this$0, false);
            return;
          }
          bool = false;
          continue;
          localException1 = localException1;
          i = 0;
        }
        catch (Exception localException2)
        {
          int k;
          boolean bool;
          int i = k;
          continue;
          break label289;
          return;
        }
        QLog.e("ConversationTitleBtnCtrl", 2, "updateQQCircleRedFlag  updateRedDot" + localException1.toString());
        bool = false;
        continue;
        pco.b("", 2, 1L, 3L);
        continue;
        continue;
        int j = 0;
      }
    }
    j = i;
    k = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1
 * JD-Core Version:    0.7.0.1
 */