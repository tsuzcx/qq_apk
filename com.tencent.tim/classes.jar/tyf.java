import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.impls.memory.MemoryDumpHelper.5;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qapmsdk.common.util.InspectUUID;
import com.tencent.qphone.base.util.QLog;

public class tyf
{
  public static boolean aQG;
  private static Handler bH;
  protected arhz g;
  private SharedPreferences mPreferences;
  private aqju u;
  
  private boolean Ox()
  {
    label179:
    for (;;)
    {
      try
      {
        if ((this.u != null) && (this.u.isShowing()))
        {
          this.u.dismiss();
          this.u = null;
        }
        Object localObject1;
        boolean bool;
        if (2 == BaseApplicationImpl.sProcessId)
        {
          localObject1 = awcs.getTopActivity();
          if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MemoryDumpHelper", 2, "ReportDump initDialog ctx == null");
            }
            bool = false;
            return bool;
          }
        }
        else
        {
          if (BaseActivity.sTopActivity != null)
          {
            localObject1 = BaseActivity.sTopActivity;
            continue;
          }
          if (!QLog.isColorLevel()) {
            break label179;
          }
          QLog.d("MemoryDumpHelper", 2, "ReportDump initDialog invalid");
          break label179;
        }
        if (((Activity)localObject1).isFinishing())
        {
          bool = false;
        }
        else
        {
          this.u = new aqju((Context)localObject1, 2131756467);
          this.u.setContentView(2131559151);
          this.u.setTitle(null);
          this.u.setNegativeButton(2131721058, new tyh(this));
          this.u.setCanceledOnTouchOutside(false);
          bool = true;
          continue;
          bool = false;
        }
      }
      finally {}
    }
  }
  
  private void a(boolean paramBoolean1, InspectUUID paramInspectUUID, String paramString, long paramLong, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("ReportDump dump mem.").append("fromLeak=").append(paramBoolean1);
    localStringBuilder.append(". Threshold=").append((100 - MagnifierSDK.a().a().bDb) * Runtime.getRuntime().maxMemory() / 100L / 1024L);
    localStringBuilder.append(" KB HeapMax=");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append(" KB HeapSize=");
    localStringBuilder.append((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L);
    localStringBuilder.append(" KB HeapSizeBeforeTrim=").append(paramLong);
    QLog.d("MemoryDumpHelper", 2, localStringBuilder.toString());
    bH.postDelayed(new MemoryDumpHelper.5(this, paramBoolean1, paramInspectUUID, paramString, paramBoolean2), 100L);
  }
  
  private void atg()
  {
    for (;;)
    {
      try
      {
        if (this.g == null)
        {
          if ((2 != BaseApplicationImpl.sProcessId) || (awcs.getTopActivity() == null)) {
            continue;
          }
          this.g = new arhz(awcs.getTopActivity(), BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
          this.g.setMessage(acfp.m(2131708121));
          this.g.setBackAndSearchFilter(false);
          this.g.setOnDismissListener(new tyi(this));
        }
        this.g.show();
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MemoryDumpHelper", 2, "show juhua exception", localException);
        continue;
      }
      finally {}
      return;
      this.g = new arhz(BaseActivity.sTopActivity, BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
    }
  }
  
  private void ath()
  {
    try
    {
      if ((this.g != null) && (this.g.isShowing()))
      {
        this.g.dismiss();
        this.g = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void bF()
  {
    try
    {
      if ((this.u != null) && (this.u.isShowing()))
      {
        this.u.dismiss();
        this.u = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */