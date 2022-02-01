import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import mqq.app.AppRuntime;

public class ajci
  extends ajcl
{
  private static void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    ajcm localajcm = new ajcm();
    int i;
    if ("MiniAppLauncher".equals(paramString2))
    {
      i = 1;
      localajcm.type = i;
      localajcm.isSuccess = paramBoolean;
      localajcm.src = paramString2;
      if (!paramBoolean) {
        break label107;
      }
    }
    label107:
    for (localajcm.s = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt), bg(paramString3, "") };; localajcm.s = new Object[] { paramString1, paramObject, Integer.valueOf(paramInt) })
    {
      if (localajcm.type != 1) {
        break label135;
      }
      pmi.a().dispatch("MiniAppManager", localajcm);
      return;
      i = 5;
      break;
    }
    label135:
    pmi.a().dispatch(localajcm);
  }
  
  public static String bg(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return jpe.dO(paramString1) + paramString1;
    }
    return jpe.dO(paramString1) + paramString1 + File.separator + paramString2;
  }
  
  public boolean E(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return false;
      str = paramBundle.getString("bid");
      paramBundle = paramBundle.getString("path");
    } while ((!jpa.di(str)) || (!jqj.D(paramBundle, str)));
    return true;
  }
  
  public void f(String paramString1, String paramString2, Object paramObject)
  {
    String str = paramString1.substring("ak:".length());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      a(false, paramString1, paramString2, -1, str, paramObject);
      return;
    }
    jpa.b(str, localAppRuntime, new ajcj(this, str, paramString1, paramString2, paramObject, System.currentTimeMillis()), true, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */