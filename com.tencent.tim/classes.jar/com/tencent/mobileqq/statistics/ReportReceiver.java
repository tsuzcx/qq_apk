package com.tencent.mobileqq.statistics;

import aczb;
import amub;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import anns;
import anot;
import awot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.report.ReportModel;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReportReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReportRunner(paramIntent));
  }
  
  static class ReportRunner
    implements Runnable
  {
    private Intent Q;
    
    public ReportRunner(Intent paramIntent)
    {
      this.Q = paramIntent;
    }
    
    public void run()
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {}
      for (;;)
      {
        return;
        localObject = (QQAppInterface)localObject;
        try
        {
          localIntent = this.Q;
          i = localIntent.getIntExtra("is_runtime", -1);
          if (i == 1001)
          {
            ((aczb)((QQAppInterface)localObject).getManager(126)).dm(localIntent);
            return;
          }
          str1 = localIntent.getStringExtra("reporting_tag");
          str2 = localIntent.getStringExtra("reporting_detail");
          j = localIntent.getIntExtra("reporting_count", 1);
        }
        catch (Exception localException)
        {
          try
          {
            Intent localIntent;
            int i;
            String str1;
            String str2;
            int j;
            if ("dc02528".equals(str1))
            {
              if ((i == 0) || (i != 1)) {
                continue;
              }
              amub.a(str1, (QQAppInterface)localObject, (ReportModel)localIntent.getSerializableExtra("reporting_detail"));
              return;
            }
            if ("dc02181".equals(str1))
            {
              if (i == 0)
              {
                anns.b(str1, (QQAppInterface)localObject, str2);
                return;
              }
              if (i != 1) {
                continue;
              }
              anns.a(str1, (QQAppInterface)localObject, str2);
              return;
            }
            if ("dc05076".equals(str1))
            {
              awot.a().e((AppRuntime)localObject, str1, str2);
              return;
            }
            if (i == 0)
            {
              anot.m((QQAppInterface)localObject, str1, str2, j);
              return;
            }
            if (i != 1) {
              continue;
            }
            anot.n((QQAppInterface)localObject, str1, str2, j);
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError) {}
          localException = localException;
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ReportReceiver
 * JD-Core Version:    0.7.0.1
 */