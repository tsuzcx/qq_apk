import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager.ISpLogCallback;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class anox
  implements SharedPreferencesProxyManager.ISpLogCallback
{
  public static final boolean cIW = false;
  private static String cfF;
  private List<String> GF = new CopyOnWriteArrayList();
  private Map<String, String[]> nj = new ConcurrentHashMap();
  private Map<String, String[]> nk = new ConcurrentHashMap();
  
  private static anox.b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("\\|");
    } while (paramString.length != 3);
    return new anox.b(paramString[0], paramString[1], paramString[2]);
  }
  
  public static anox a()
  {
    return anox.a.a;
  }
  
  private static int l(String paramString1, String paramString2, String paramString3)
  {
    return (paramString1 + paramString2 + paramString3).hashCode();
  }
  
  private boolean pv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.contains("com.oppo.embryo")) || (!paramString.contains("."))) {
      return true;
    }
    return false;
  }
  
  public void onIllegalModify(String paramString1, String paramString2, Object paramObject)
  {
    String str = null;
    int i = 1;
    if ((!cIW) || (BaseApplicationImpl.sProcessId != 1)) {}
    label388:
    label392:
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(cfF)) {
        cfF = BaseApplicationImpl.getApplication().getPackageName();
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && ((paramObject instanceof String)) && (!TextUtils.isEmpty((String)paramObject)))
      {
        boolean bool = cfF.equals(paramString2);
        paramObject = (String)paramObject;
        if (bool)
        {
          this.nj.put(paramString1, new String[] { paramString2, null });
          label111:
          if (!bool) {
            break label353;
          }
          paramString2 = (String[])this.nk.get(paramString1);
          if (paramString2 == null) {
            break label345;
          }
          paramObject = paramString2[0];
          paramString2 = paramString2[1];
          label142:
          if (TextUtils.isEmpty(paramObject)) {
            break label388;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label392;
          }
          Object localObject = a(paramString2);
          if (localObject == null) {
            break;
          }
          paramString2 = ((anox.b)localObject).stack;
          str = ((anox.b)localObject).clazz;
          localObject = ((anox.b)localObject).method;
          if ((pv(str)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (this.GF.contains(paramString2))) {
            break;
          }
          this.GF.add(paramString2);
          SharedPreferences.Editor localEditor = SharedPreferencesProxyManager.getInstance().getProxy("sp_dm_report", 0).edit();
          localEditor.putString(String.valueOf(l(str, (String)localObject, paramObject)), paramString1 + '|' + str + '|' + paramObject + '|' + paramString2);
          localEditor.commit();
          return;
          this.nk.put(paramString1, new String[] { paramString2, paramObject });
          break label111;
          label345:
          paramString2 = null;
          paramObject = str;
          break label142;
          label353:
          if ((String[])this.nj.get(paramString1) != null)
          {
            str = paramString2;
            paramString2 = paramObject;
            paramObject = str;
            break label142;
          }
          paramString2 = null;
          paramObject = str;
          break label142;
          i = 0;
        }
      }
    }
  }
  
  public void printLog(boolean paramBoolean, String paramString1, String paramString2, Exception paramException) {}
  
  static final class a
  {
    static final anox a = new anox(null);
  }
  
  static final class b
  {
    final String clazz;
    final String method;
    final String stack;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.clazz = paramString1;
      this.method = paramString2;
      this.stack = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anox
 * JD-Core Version:    0.7.0.1
 */