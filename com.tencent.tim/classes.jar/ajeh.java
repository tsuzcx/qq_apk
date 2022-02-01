import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class ajeh
  implements ajea
{
  ajeh(ajee paramajee) {}
  
  public void LT(boolean paramBoolean) {}
  
  public void LU(boolean paramBoolean)
  {
    ajgv.c("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ajgu.reset();
    ajgu.track(null, "total_transport_cost");
  }
  
  public void exit(boolean paramBoolean) {}
  
  public void iC(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      ajgu.track("total_transport_cost", null);
      ajgu.dxv();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    ajee.a(this.this$0, paramInt2);
    ajee.b(this.this$0, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str2;
      String str1;
      if (ajee.a(this.this$0) == 1)
      {
        str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690759);
        str1 = i + "/" + ajee.dio;
      }
      for (;;)
      {
        str1 = String.format(str2, new Object[] { str1, ajgv.bw(ajee.a(this.this$0)) + "B/s" });
        i = ajdt.a().Gi();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        ajee.dwH();
        this.this$0.c(BaseActivity.sTopActivity, i);
        return;
        if (ajee.a(this.this$0) == 3)
        {
          str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
          str1 = i + "/" + ajee.dio;
        }
        else
        {
          str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
          str1 = i + "/" + ajee.dio;
        }
      }
      this.this$0.dt(i, str1);
      return;
    }
  }
  
  public void iD(int paramInt1, int paramInt2) {}
  
  public void kg(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "speedState!!! increment = " + paramLong);
    }
    ajee.a(this.this$0, paramLong);
    int j = ajee.b(this.this$0);
    int i = j;
    if (j != ajee.dio) {
      i = j + 1;
    }
    String str2;
    String str1;
    if (ajee.a(this.this$0) == 1)
    {
      str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690759);
      str1 = i + "/" + ajee.dio;
    }
    for (;;)
    {
      str1 = String.format(str2, new Object[] { str1, ajgv.bw(ajee.a(this.this$0)) + "B/S" });
      this.this$0.dt(ajdt.a().Gi(), str1);
      return;
      if (ajee.a(this.this$0) == 3)
      {
        str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
        str1 = i + "/" + ajee.dio;
      }
      else
      {
        str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
        str1 = i + "/" + ajee.dio;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajeh
 * JD-Core Version:    0.7.0.1
 */