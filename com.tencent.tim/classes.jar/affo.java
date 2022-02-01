import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affo
  extends afeu
{
  public static final String[] eX = (String[])new String[] { "libgnustl_shared.so", "libjsc.so" };
  
  public affo(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola_795", paramQQAppInterface);
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
    if (ajd()) {}
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (afem)((QQAppInterface)localObject).getManager(77);
        if (localObject != null)
        {
          localObject = (affo)((afem)localObject).a("android.qq.readinjoy.viola_795");
          if (localObject != null)
          {
            ((affo)localObject).HL(true);
            QLog.i("viola.ViolaLibHandler", 1, "restartDownloadLib");
          }
        }
      }
    } while (affn.ajd());
    affn.cYK();
  }
  
  public void HO(String paramString)
  {
    QLog.i("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = b();
    if (localXmlData != null) {
      QLog.i("viola.ViolaLibHandler", 1, "version:" + localXmlData.Version);
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
      QLog.e("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess],unzip readinjoy_viola lib failed!");
    }
    label124:
    do
    {
      return;
      paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
      if (paramString != null) {
        paramString.edit().putString("res_name", "android.qq.readinjoy.viola_795").commit();
      }
    } while (!affn.ajd());
    lci.loadLibrary("jsc doOnDownloadSuccess");
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return ViolaLibData.class;
  }
  
  public int getBusinessId()
  {
    return 10071;
  }
  
  public String un()
  {
    return "viola.ViolaLibHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affo
 * JD-Core Version:    0.7.0.1
 */