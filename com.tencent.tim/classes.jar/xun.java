import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class xun
  implements Manager
{
  public int bXf;
  public int bXg;
  public Set<String> bs = new HashSet();
  boolean mInit = false;
  
  public static xun a(QQAppInterface paramQQAppInterface)
  {
    xun localxun = (xun)paramQQAppInterface.getManager(215);
    localxun.z(paramQQAppInterface);
    return localxun;
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("PhotoListConfig" + paramString, 0).getInt("k_version", 0);
  }
  
  public static void k(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("PhotoListConfig" + paramString, 0).edit().putInt("k_version", paramInt).apply();
  }
  
  @TargetApi(14)
  private void z(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (!this.mInit)
      {
        this.mInit = true;
        paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + paramQQAppInterface.getCurrentAccountUin(), 0);
        this.bXf = paramQQAppInterface.getInt("k_s", 0);
        this.bXg = paramQQAppInterface.getInt("k_w", 0);
        this.bs = paramQQAppInterface.getStringSet("k_b_l", null);
        paramQQAppInterface = new StringBuilder("init ");
        paramQQAppInterface.append("size:").append(this.bXf).append(" width:").append(this.bXg).append(" black:").append(this.bs);
        QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    try
    {
      this.bXf = paramInt1;
      this.bXg = paramInt2;
      this.bs = paramSet;
      paramQQAppInterface.getApp().getSharedPreferences("PhotoListConfig" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("k_s", paramInt1).putInt("k_w", paramInt2).putStringSet("k_b_l", paramSet).apply();
      paramQQAppInterface = new StringBuilder("updateConfig ");
      paramQQAppInterface.append("size:").append(this.bXf).append(" width:").append(this.bXg).append(" black:").append(paramSet);
      QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xun
 * JD-Core Version:    0.7.0.1
 */