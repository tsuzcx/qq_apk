import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aizo
  implements Manager
{
  public static String TAG = "TimUpgradeHongdianManager";
  private QQAppInterface app;
  public boolean cmW;
  public String mSubTitle;
  public String mTitle;
  public String mUrl;
  
  public aizo(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public boolean aqc()
  {
    long l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + this.app.getCurrentUin(), 0);
        this.cmW = localSharedPreferences.getBoolean("tim_upgrade_hongdian_switch", false);
        this.mTitle = localSharedPreferences.getString("tim_upgrade_hongdian_title", null);
        this.mSubTitle = localSharedPreferences.getString("tim_upgrade_hongdian_sub_title", null);
        this.mUrl = localSharedPreferences.getString("tim_upgrade_hongdian_url", null);
        long l2 = System.currentTimeMillis();
        boolean bool2;
        if ((!TextUtils.isEmpty(this.mTitle)) && (!TextUtils.isEmpty(this.mSubTitle)))
        {
          bool1 = TextUtils.isEmpty(this.mUrl);
          if (!bool1)
          {
            bool1 = true;
            bool2 = bool1;
          }
        }
        boolean bool1 = false;
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, "checkIfShowTimHongdian , switchKey = " + this.cmW + ", mTitle = " + this.mTitle + ", mSubTitle =" + this.mSubTitle + ", url=" + this.mUrl + ", sp time cost = " + (l2 - l1) + ", ifShow= " + bool1);
            bool2 = bool1;
          }
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        bool1 = false;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG, 2, "checkIfShowTimHongdian " + localException1.toString());
          return bool1;
        }
      }
    }
  }
  
  public void dvI()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("tim_upgrade_hongdian_pre_" + this.app.getCurrentUin(), 0).edit();
      localEditor.putBoolean("tim_upgrade_hongdian_switch", false);
      localEditor.putString("tim_upgrade_hongdian_title", null);
      localEditor.putString("tim_upgrade_hongdian_sub_title", null);
      localEditor.putString("tim_upgrade_hongdian_url", null);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "clearHondianSP done");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(TAG, 2, "clearHondianSP " + localException.toString());
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizo
 * JD-Core Version:    0.7.0.1
 */