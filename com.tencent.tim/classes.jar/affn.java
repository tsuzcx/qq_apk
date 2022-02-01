import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaBizLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affn
  extends afeu
{
  public static final String[] eX = { "libviola.so" };
  
  public affn(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_biz_810", paramQQAppInterface);
  }
  
  public static boolean ajd()
  {
    String str = lcl.jg();
    int i = 0;
    while (i < eX.length)
    {
      File localFile = new File(str, eX[i]);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void cYK()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (afem)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (affn)((afem)localObject).a("android.qq.readinjoy.viola_biz_810");
        if (localObject != null)
        {
          ((affn)localObject).HL(true);
          QLog.i("viola.ViolaBizLibHandler", 1, "restartDownloadLib");
        }
      }
    }
  }
  
  public void HO(String paramString)
  {
    QLog.i("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = b();
    if (localXmlData != null) {
      QLog.i("viola.ViolaBizLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (lcl.dJ(paramString)) {
        break label124;
      }
      if (localXmlData != null)
      {
        localXmlData.loadState = 0;
        localXmlData.Version = 0;
        afel.a(localXmlData, new String[] { "loadState", "Version" });
      }
      QLog.e("viola.ViolaBizLibHandler", 1, "[doOnDownloadSuccess],unzip android.qq.readinjoy.viola_biz_810 lib failed!");
    }
    label124:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_biz_810").commit();
      }
    } while (!affo.ajd());
    lci.loadLibrary("biz doOnDownloadSuccess");
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return ViolaBizLibData.class;
  }
  
  public int getBusinessId()
  {
    return 10079;
  }
  
  public String un()
  {
    return "viola.ViolaBizLibHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affn
 * JD-Core Version:    0.7.0.1
 */