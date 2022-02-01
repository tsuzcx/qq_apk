import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloJscLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afep
  extends afeu
{
  public afep(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.jsc820", paramQQAppInterface);
  }
  
  public static void cYK()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (afem)((QQAppInterface)localObject).getManager(77);
      if (localObject != null)
      {
        localObject = (afep)((afem)localObject).a("android.qq.apollo.jsc820");
        if (localObject != null)
        {
          ((afep)localObject).HL(true);
          QLog.i("ApolloSoLoader_JscHandler", 1, "restartDownload jscLib");
        }
      }
    }
  }
  
  public void HO(String paramString)
  {
    QLog.i("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess] jsc:" + paramString);
    XmlData localXmlData = b();
    if (localXmlData != null) {
      QLog.i("ApolloSoLoader_JscHandler", 1, "version:" + localXmlData.Version);
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
        if (aurl.aw(paramString, 0)) {
          break label189;
        }
        if (localXmlData != null)
        {
          localXmlData.loadState = 0;
          localXmlData.Version = 0;
          afel.a(localXmlData, new String[] { "loadState", "Version" });
        }
        QLog.e("ApolloSoLoader_JscHandler", 1, "[doOnDownloadSuccess],unzip apollo jsclib failed!");
        if (i != 0)
        {
          abwh.a(10, 201, 1001, new Object[] { "unzip jsc lib failed" });
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
      if (i != 0) {
        abwh.a(10, 201, 0, new Object[] { "libjsc so download success" });
      }
      abyv.loadSo("after_JSC_downloaded");
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public Class<? extends XmlData> g()
  {
    return ApolloJscLibData.class;
  }
  
  public int getBusinessId()
  {
    return 10072;
  }
  
  public String un()
  {
    return "ApolloSoLoader_JscHandler";
  }
  
  public String uo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afep
 * JD-Core Version:    0.7.0.1
 */