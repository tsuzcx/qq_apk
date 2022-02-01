import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afeq
  extends afeu
{
  public static final String[] eX = { "libjsc.so" };
  
  public afeq(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.js.836g1", paramQQAppInterface);
  }
  
  public static void cYK()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (afem)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (afeq)((afem)localObject).a("android.qq.apollo.js.836g1");
        if (localObject != null)
        {
          ((afeq)localObject).HL(true);
          QLog.i("ApolloSoLoader_libHandler", 1, "restartDownload savaLib");
        }
      }
    }
  }
  
  public void HO(String paramString)
  {
    QLog.i("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess] sava:" + paramString);
    Object localObject = b();
    if (localObject != null) {
      QLog.i("ApolloSoLoader_libHandler", 1, "version:" + ((XmlData)localObject).Version);
    }
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      i = 1;
      if (i != 0) {
        abwh.b(10, null, new int[] { 1 });
      }
      if (new File(paramString).exists())
      {
        if (aurl.aw(paramString, 1)) {
          break label189;
        }
        if (localObject != null)
        {
          ((XmlData)localObject).loadState = 0;
          ((XmlData)localObject).Version = 0;
          afel.a((XmlData)localObject, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess],unzip apollo lib failed!");
        if (i != 0)
        {
          abwh.a(10, 200, 1001, new Object[] { "unzip sava lib failed" });
          abyv.bGq = true;
        }
      }
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      i = 0;
      break;
      label189:
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("res_name", "android.qq.apollo.js.836g1").commit();
      }
      if (i != 0) {
        abwh.a(10, 200, 0, new Object[] { "libsava so download success" });
      }
      abyv.loadSo("after_ApolloSo_downloaded");
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return ApolloLibData.class;
  }
  
  public int getBusinessId()
  {
    return 10038;
  }
  
  public String un()
  {
    return "ApolloSoLoader_libHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afeq
 * JD-Core Version:    0.7.0.1
 */