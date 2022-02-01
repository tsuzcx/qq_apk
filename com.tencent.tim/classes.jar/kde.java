import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class kde
  implements aehx<String>
{
  private boolean isSuccess;
  private ArrayList<obt.a> list = new ArrayList(0);
  private String xml = "";
  
  public static kde a(String paramString)
  {
    try
    {
      kde localkde = (kde)aeij.a(paramString, kde.class);
      return localkde;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
    }
    return null;
  }
  
  public static kde a(aeic[] paramArrayOfaeic)
  {
    kde localkde = null;
    int i = 0;
    while (i < paramArrayOfaeic.length)
    {
      localkde = a(paramArrayOfaeic[i].content);
      i += 1;
    }
    return localkde;
  }
  
  public void aBF()
  {
    if (this.isSuccess) {
      obt.bX(this.list);
    }
  }
  
  public void lR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountConfProcessor", 2, "parseConfigXml xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.xml = paramString;
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8"))).getElementsByTagName("public-account-folder");
        int j = paramString.getLength();
        Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject1 instanceof QQAppInterface))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = ((AppRuntime)localObject1).getApplication();
          this.list = new ArrayList(j);
          int i = 0;
          while (i < j)
          {
            Object localObject2 = (Element)paramString.item(i);
            localObject2 = new obt.a(localQQAppInterface, (Context)localObject1, Integer.parseInt(((Element)localObject2).getElementsByTagName("id").item(0).getFirstChild().getNodeValue()), ((Element)localObject2).getElementsByTagName("name").item(0).getFirstChild().getNodeValue(), ((Element)localObject2).getElementsByTagName("icon").item(0).getFirstChild().getNodeValue());
            this.list.add(localObject2);
            i += 1;
          }
          this.isSuccess = true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfProcessor", 2, "parsePublicAccountConfigXml error", paramString);
      }
      paramString.printStackTrace();
    }
  }
  
  public void update()
  {
    if (this.isSuccess)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        aqmj.ct(((QQAppInterface)localAppRuntime).getApplication(), this.xml);
      }
    }
    while (!QLog.isColorLevel())
    {
      AppRuntime localAppRuntime;
      return;
    }
    QLog.e("PublicAccountConfProcessor", 2, "updateEqqConfig fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kde
 * JD-Core Version:    0.7.0.1
 */