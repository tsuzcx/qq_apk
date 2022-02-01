import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class aenp
  extends aehv<aenp.a>
{
  @NonNull
  public aenp.a a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = aqmj.af(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin());
    return new aenp.a(aqmj.ag(localQQAppInterface.getApp(), localQQAppInterface.getCurrentAccountUin()), str);
  }
  
  @Nullable
  public aenp.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onParsed, content:" + paramArrayOfaeic);
    }
    try
    {
      paramArrayOfaeic = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramArrayOfaeic.getBytes("utf-8")));
      NodeList localNodeList = paramArrayOfaeic.getElementsByTagName("video_redbag_config");
      if ((localNodeList != null) && (localNodeList.getLength() > 0))
      {
        paramArrayOfaeic = new aenp.a(paramArrayOfaeic.getElementsByTagName("resUrl").item(0).getFirstChild().getNodeValue(), paramArrayOfaeic.getElementsByTagName("resMd5").item(0).getFirstChild().getNodeValue());
        return paramArrayOfaeic;
      }
    }
    catch (Exception paramArrayOfaeic)
    {
      QLog.e("RedBagVideoResProcessor", 1, "handleVideoRedbagConfig failed" + paramArrayOfaeic);
    }
    return null;
  }
  
  public void a(aenp.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onUpdate");
    }
  }
  
  public Class<aenp.a> clazz()
  {
    return aenp.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return aqmj.aW(localQQAppInterface.getApp(), localQQAppInterface.getCurrentUin());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RedBagVideoResProcessor", 2, "handleVideoRedbagConfig onReqFailed");
    }
  }
  
  public int type()
  {
    return 252;
  }
  
  public static class a
  {
    public String resUrl = "";
    public String tT = "";
    
    public a() {}
    
    public a(String paramString1, String paramString2)
    {
      this.resUrl = paramString1;
      this.tT = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenp
 * JD-Core Version:    0.7.0.1
 */