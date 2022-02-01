import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aurl
{
  private static int aNm;
  private static String cIT = "";
  public static final Object lock = new Object();
  
  public static boolean aw(String paramString, int paramInt)
  {
    synchronized (lock)
    {
      jg();
      String str;
      if (!TextUtils.isEmpty(cIT)) {
        str = gF(paramInt);
      }
      try
      {
        aNm = 1;
        aqhq.W(paramString, str, false);
        aNm = 0;
        QLog.i("ApolloSoLoader_preLoader", 1, "succeed to unzip so.");
        if (aNm == 0) {
          return true;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          aNm = 2;
          QLog.e("ApolloSoLoader_preLoader", 1, paramString, new Object[0]);
        }
      }
    }
    return false;
  }
  
  public static String gF(int paramInt)
  {
    jg();
    String str = cIT;
    if (paramInt == 0) {
      str = cIT + "jsc_temp_dir" + "/";
    }
    while (1 != paramInt) {
      return str;
    }
    return cIT + "sava_temp_dir" + "/";
  }
  
  public static String jg()
  {
    if (TextUtils.isEmpty(cIT))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label65;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (TextUtils.isEmpty(cIT)) {
        cIT = ((File)localObject).getParent() + "/txlib/" + "cmshow/";
      }
    }
    for (;;)
    {
      return cIT;
      label65:
      QLog.w("ApolloSoLoader_preLoader", 2, "getSoLibPath but context is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurl
 * JD-Core Version:    0.7.0.1
 */