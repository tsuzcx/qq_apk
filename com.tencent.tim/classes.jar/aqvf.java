import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import dualsim.common.OrderCheckResult;
import mqq.os.MqqHandler;

public class aqvf
{
  private static SharedPreferences D()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_sdk", 4);
  }
  
  public static void SV(boolean paramBoolean)
  {
    D().edit().putBoolean("supportActivationView", paramBoolean).apply();
  }
  
  protected static boolean a(@NonNull String paramString, @NonNull OrderCheckResult paramOrderCheckResult)
  {
    Object localObject = D();
    boolean bool;
    int j;
    int i;
    if (((SharedPreferences)localObject).getInt("kingCardProduct", -1) != paramOrderCheckResult.product)
    {
      localObject = ((SharedPreferences)localObject).edit().putInt("kingCardProduct", paramOrderCheckResult.product);
      if (paramOrderCheckResult.kingcard > 0)
      {
        bool = true;
        ((SharedPreferences.Editor)localObject).putBoolean("kingCard", bool).apply();
      }
    }
    else
    {
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + paramString, 4);
      j = paramString.getInt("kingCardSdk", -1);
      if (paramOrderCheckResult.kingcard != 0) {
        break label163;
      }
      i = -1;
    }
    for (;;)
    {
      if (j == i) {
        break label195;
      }
      paramString.edit().putInt("kingCardSdk", i).putInt("toast_version", 0).putInt("popup_version_v2", 0).commit();
      return true;
      bool = false;
      break;
      label163:
      if (paramOrderCheckResult.kingcard == 1)
      {
        if (paramOrderCheckResult.product == 90155946) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
    label195:
    return false;
  }
  
  protected static boolean aFH()
  {
    return D().getBoolean("supportActivationView", false);
  }
  
  protected static Pair<Boolean, Integer> f()
  {
    SharedPreferences localSharedPreferences = D();
    return new Pair(Boolean.valueOf(localSharedPreferences.getBoolean("kingCard", false)), Integer.valueOf(localSharedPreferences.getInt("kingCardProduct", 0)));
  }
  
  void S(ViewGroup paramViewGroup) {}
  
  public final void VK(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(tag(), 2, paramString);
    }
  }
  
  void a(aqvn.a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraper.1(this, parama));
      }
    }
    else {
      return;
    }
    parama.b(false, false, 0);
  }
  
  boolean aFG()
  {
    return false;
  }
  
  void ar(Runnable paramRunnable)
  {
    VK("tryLoad : disable kingcard");
  }
  
  boolean isReady()
  {
    VK("isReady : disable kingcard");
    return false;
  }
  
  String tag()
  {
    return "KC.KCWraper";
  }
  
  boolean x(Activity paramActivity)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvf
 * JD-Core Version:    0.7.0.1
 */