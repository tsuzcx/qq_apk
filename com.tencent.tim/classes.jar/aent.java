import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class aent
  extends aehv<aent.a>
{
  @NonNull
  public aent.a a(int paramInt)
  {
    return new aent.a();
  }
  
  @Nullable
  public aent.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      if (QLog.isColorLevel()) {
        QLog.d("RichmediaIpv6ConifgProcessor", 2, "onParsed, content:" + paramArrayOfaeic);
      }
      return aent.a.a(paramArrayOfaeic);
    }
    return new aent.a();
  }
  
  public void a(aent.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onUpdate");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      localQQAppInterface.a().a = parama;
      localQQAppInterface.getHwEngine().ipv6Switch = parama.bVd;
    }
  }
  
  public Class clazz()
  {
    return aent.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichmediaIpv6ConifgProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 538;
  }
  
  public static class a
  {
    public boolean bVd;
    public boolean bVe;
    public boolean bVf;
    public boolean bVg;
    
    public a() {}
    
    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.bVd = paramBoolean1;
      this.bVe = paramBoolean2;
      this.bVf = paramBoolean3;
      this.bVg = paramBoolean4;
    }
    
    public static a a(String paramString)
    {
      boolean bool5 = false;
      if (paramString == null) {
        return null;
      }
      boolean bool1;
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
        localNodeList = paramString.getElementsByTagName("bdh_ipv6_switch");
        if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
          break label405;
        }
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
          break label380;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        NodeList localNodeList;
        label152:
        QLog.e("RichmediaIpv6ConifgProcessor", 1, "onParsed failed" + paramString);
        return null;
      }
      localNodeList = paramString.getElementsByTagName("bdh_dual_ipv6_switch");
      if ((localNodeList != null) && (localNodeList.getLength() > 0)) {
        if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() > 0)
        {
          bool1 = true;
          break label415;
          localNodeList = paramString.getElementsByTagName("richmedia_down_ipv6_switch");
          if ((localNodeList == null) || (localNodeList.getLength() <= 0)) {
            break label395;
          }
          if (Integer.valueOf(((Element)localNodeList.item(0)).getFirstChild().getNodeValue()).intValue() <= 0) {
            break label390;
          }
          bool1 = true;
          break label420;
        }
      }
      label390:
      label395:
      label405:
      label410:
      label415:
      label420:
      for (;;)
      {
        paramString = paramString.getElementsByTagName("richmedia_down_dual_ipv6_switch");
        boolean bool4 = bool5;
        if (paramString != null)
        {
          bool4 = bool5;
          if (paramString.getLength() > 0)
          {
            bool4 = bool5;
            if (Integer.valueOf(((Element)paramString.item(0)).getFirstChild().getNodeValue()).intValue() > 0) {
              bool4 = true;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("RichmediaIpv6ConifgProcessor", 2, "parse, bdh_ipv6_switch = " + bool2 + ", bdh_dual_ipv6_switch = " + bool3 + ", richmedia_down_ipv6_switch = " + bool1 + ", richmedia_down_dual_ipv6_switch = " + bool4);
        }
        paramString = new a(bool2, bool3, bool1, bool4);
        return paramString;
        label380:
        bool1 = false;
        break label410;
        bool1 = false;
        break label415;
        bool1 = false;
        break label420;
        bool1 = false;
        continue;
        boolean bool3 = false;
        break label152;
        boolean bool2 = false;
        break;
        bool2 = bool1;
        break;
        bool3 = bool1;
        break label152;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aent
 * JD-Core Version:    0.7.0.1
 */