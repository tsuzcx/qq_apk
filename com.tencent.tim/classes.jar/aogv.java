import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import eipc.EIPCResult;

public class aogv
  extends QIPCModule
{
  private static aogv a;
  private static String ckG = "setup";
  
  private aogv(String paramString)
  {
    super(paramString);
  }
  
  public static aogv a()
  {
    try
    {
      if (a == null) {
        a = new aogv("ThemeIPCModule");
      }
      aogv localaogv = a;
      return localaogv;
    }
    finally {}
  }
  
  public static void a(String paramString, aogi paramaogi)
  {
    Bundle localBundle = new Bundle();
    if (paramaogi != null) {
      localBundle.putParcelable("binder", new BinderWarpper(paramaogi.asBinder()));
    }
    localBundle.putString("themeId", paramString);
    QIPCClientHelper.getInstance().callServer("ThemeIPCModule", ckG, localBundle, null);
  }
  
  public static void c(String paramString, ajdq<aogy> paramajdq)
  {
    if ((TextUtils.isEmpty(paramString)) || ("1000".equals(paramString)))
    {
      paramajdq.postQuery(null);
      return;
    }
    if ("999".equals(paramString))
    {
      paramajdq.postQuery(new aogy().a());
      return;
    }
    QuickUpdateIPCModule.a(3, ThemeUtil.getThemeConfigID(paramString), true, new aogx(paramString, paramajdq));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeIPCModule", 2, "onCall action = " + paramString);
    }
    paramBundle.setClassLoader(BinderWarpper.class.getClassLoader());
    String str = paramBundle.getString("themeId");
    if (paramBundle.containsKey("binder")) {}
    for (paramBundle = ((BinderWarpper)paramBundle.getParcelable("binder")).binder;; paramBundle = null)
    {
      if (ckG.equals(paramString)) {
        if (paramBundle == null) {
          break label135;
        }
      }
      label135:
      for (paramString = new aogw(this, aogi.a.asInterface(paramBundle));; paramString = null)
      {
        ThemeSwitcher.a(str, "200", paramString);
        return null;
        QLog.e("ThemeIPCModule", 1, "onCall missing action = " + paramString);
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogv
 * JD-Core Version:    0.7.0.1
 */