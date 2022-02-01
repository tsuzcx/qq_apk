import android.content.SharedPreferences;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.net.URL;

public class asbg
{
  protected static final String TAG = asbg.class.getName();
  protected static asbg a;
  protected volatile WeakReference<SharedPreferences> iP;
  
  public static asbg a()
  {
    try
    {
      if (a == null) {
        a = new asbg();
      }
      asbg localasbg = a;
      return localasbg;
    }
    finally {}
  }
  
  public String d(String paramString, Bundle paramBundle)
  {
    if ((this.iP == null) || (this.iP.get() == null)) {
      this.iP = new WeakReference(asbf.getGlobalPreference(aroi.a().getContext(), "OpenSettings"));
    }
    String str1 = paramString;
    String str2;
    SharedPreferences localSharedPreferences;
    String str3;
    try
    {
      str2 = new URL(paramString).getHost();
      if (str2 == null)
      {
        str1 = paramString;
        arwt.e(TAG, "Get host error. url=" + paramString);
        return paramString;
      }
      str1 = paramString;
      localSharedPreferences = (SharedPreferences)this.iP.get();
      str1 = paramString;
      if (localSharedPreferences == null) {
        return str1;
      }
      str1 = paramString;
      str3 = localSharedPreferences.getString(str2, null);
      if (str3 != null)
      {
        str1 = paramString;
        if (!str2.equals(str3)) {}
      }
      else
      {
        str1 = paramString;
        arwt.d(TAG, "host=" + str2 + ", envHost=" + str3);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      arwt.e(TAG, "getEnvUrl error. url=" + str1);
      return str1;
    }
    if (paramBundle != null)
    {
      str1 = paramString;
      paramBundle.putString("env", localSharedPreferences.getString("OpenEnvironment", "formal"));
    }
    str1 = paramString;
    paramString = paramString.replace(str2, str3);
    str1 = paramString;
    arwt.d(TAG, "return environment url : " + paramString);
    str1 = paramString;
    return str1;
  }
  
  public String qP(String paramString)
  {
    return d(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbg
 * JD-Core Version:    0.7.0.1
 */