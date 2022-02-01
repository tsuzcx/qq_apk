import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class kda
  implements aehx<String>
{
  private String msg = "";
  private int show;
  private int version;
  
  public static kda a(int paramInt, String paramString, boolean paramBoolean)
  {
    kda localkda = new kda();
    localkda.version = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localkda.show = paramInt;
      localkda.msg = paramString;
      return localkda;
    }
  }
  
  public static kda a(String paramString)
  {
    try
    {
      kda localkda = (kda)aeij.a(paramString, kda.class);
      return localkda;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + paramString, localQStorageInstantiateException);
    }
    return null;
  }
  
  public static kda a(aeic[] paramArrayOfaeic)
  {
    kda localkda = null;
    int i = 0;
    while (i < paramArrayOfaeic.length)
    {
      localkda = a(paramArrayOfaeic[i].content);
      i += 1;
    }
    return localkda;
  }
  
  public void lR(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml: " + paramString);
    }
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.trim();
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        NodeList localNodeList = paramString.getElementsByTagName("version");
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (QQAppInterface)localObject;
          this.version = Integer.parseInt(localNodeList.item(0).getFirstChild().getNodeValue());
          paramString = paramString.getElementsByTagName("public-account-folder");
          if (paramString.getLength() > 0)
          {
            paramString = (Element)paramString.item(0);
            this.show = Integer.parseInt(paramString.getElementsByTagName("show").item(0).getFirstChild().getNodeValue());
            this.msg = paramString.getElementsByTagName("msg").item(0).getFirstChild().getNodeValue();
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig xml is empty");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PaSubscribeRedDotProcessor", 2, "updateSubscribeConfig error", paramString);
      }
      paramString.printStackTrace();
    }
  }
  
  public void update()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      int i = oac.d((QQAppInterface)localObject);
      if (this.version != i) {
        break label47;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PaSubscribeRedDotProcessor", 2, "IGNORE THIS ACTION because of SAME VERSION");
      }
    }
    label47:
    do
    {
      return;
      oac.c((QQAppInterface)localObject, this.version);
      oac.a((QQAppInterface)localObject, this.show, this.msg);
      localObject = (WebProcessManager)((QQAppInterface)localObject).getManager(13);
    } while (localObject == null);
    ((WebProcessManager)localObject).egu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kda
 * JD-Core Version:    0.7.0.1
 */