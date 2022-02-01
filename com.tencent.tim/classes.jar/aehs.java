import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class aehs
{
  private static byte[] W()
  {
    String str = MD5.toMD5(aehp.getUin() + AppSetting.getLC() + "E1D84CC825147ECD").substring(0, 16);
    try
    {
      byte[] arrayOfByte = str.getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return str.getBytes();
  }
  
  private static void a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new Cryptor().decrypt(paramArrayOfByte, W());
    switch (paramInt)
    {
    case 3: 
    default: 
    case 4: 
      do
      {
        return;
        paramString = aehp.a();
      } while (paramString == null);
      a(paramString.a, paramArrayOfByte);
      return;
    case 24: 
      aehp.a.removeAll();
      aehp.a.Hx(false);
      a(aehp.a, paramArrayOfByte, paramString);
      return;
    }
    aehp.b.removeAll();
    aehp.b.Hx(false);
    a(aehp.b, paramArrayOfByte);
  }
  
  private static void a(aehr.a parama, byte[] paramArrayOfByte)
  {
    int i = aqoj.b(paramArrayOfByte, 0);
    parama.bxx = aqoj.a(paramArrayOfByte, 2, i);
    i += 2;
    parama.bj = paramArrayOfByte[i];
    i += 1;
    parama.bk = paramArrayOfByte[i];
    int j = i + 1;
    i = aqoj.b(paramArrayOfByte, j);
    j += 2;
    parama.bxy = aqoj.a(paramArrayOfByte, j, i);
  }
  
  private static void a(aeht paramaeht) {}
  
  private static void a(aeht paramaeht, String paramString)
  {
    int k = 2;
    int m = 0;
    int n = aqoj.b(paramaeht.dD, 0);
    int i = m;
    int j = k;
    if (QLog.isColorLevel())
    {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--itemNum = " + n);
      j = k;
      i = m;
    }
    while (i < n)
    {
      k = aqoj.b(paramaeht.dD, j);
      m = j + 2;
      j = aqoj.b(paramaeht.dD, m);
      m += 2;
      byte[] arrayOfByte = new byte[j];
      aqoj.c(paramaeht.dD, m, arrayOfByte, j);
      j = m + j;
      a(k, arrayOfByte, paramString);
      i += 1;
    }
    paramaeht = aehp.a();
    if (paramaeht != null) {
      paramaeht.cXb();
    }
  }
  
  private static void a(aevv paramaevv, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    paramaevv.WM = aqoj.getLongData(paramArrayOfByte, 0);
    paramaevv.WN = (aqoj.getLongData(paramArrayOfByte, 4) * 1000L);
    paramaevv.WO = (aqoj.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int m;
    int n;
    for (int j = 13; i < k; j = n + m)
    {
      long l = aqoj.getLongData(paramArrayOfByte, j);
      m = j + 4;
      j = paramArrayOfByte[m];
      n = m + 1 + 1;
      m = aqoj.b(paramArrayOfByte, n);
      n += 2;
      String str1 = aqoj.a(paramArrayOfByte, n, m);
      n += m;
      m = aqoj.b(paramArrayOfByte, n);
      n += 2;
      String str2 = aqoj.a(paramArrayOfByte, n, m);
      if (j == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShanPing", 2, "flashlogo desc= " + str1 + " src addr = " + str2);
        }
        str2 = paramaevv.b(str1, (byte)3);
        paramaevv.HA(str2);
        paramaevv.addElement(paramaevv.a(l, str1, str2, null, ""));
      }
      i += 1;
    }
  }
  
  private static void a(aevv paramaevv, byte[] paramArrayOfByte, String paramString)
  {
    paramaevv.WM = aqoj.getLongData(paramArrayOfByte, 0);
    paramaevv.WN = (aqoj.getLongData(paramArrayOfByte, 4) * 1000L);
    paramaevv.WO = (aqoj.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int j = 13;
    if (k > 0)
    {
      paramaevv.cXt();
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + paramString, true).commit();
    }
    int i = 0;
    while (i < k)
    {
      long l1 = aqoj.getLongData(paramArrayOfByte, j);
      int m = j + 4;
      j = paramArrayOfByte[m];
      m = m + 1 + 1;
      long l2 = aqoj.getLongData(paramArrayOfByte, m);
      int n = m + 4;
      m = aqoj.b(paramArrayOfByte, n);
      int i1 = n + 2;
      n = aqoj.b(paramArrayOfByte, i1);
      i1 += 2;
      paramString = aqoj.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = aqoj.b(paramArrayOfByte, i1);
      i1 += 2;
      String str2 = aqoj.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = aqoj.b(paramArrayOfByte, i1);
      i1 += 2;
      String str1 = aqoj.a(paramArrayOfByte, i1, n);
      if (j == 1)
      {
        str2 = paramaevv.b(str2, (byte)3);
        if (!lD(String.valueOf(l1))) {
          paramaevv.HA(str2);
        }
        paramaevv.addElement(paramaevv.a(l1, paramString, str2, str1, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + l1, "" + l2, (short)m));
      }
      i += 1;
      j = n + i1;
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap, NodeList paramNodeList)
  {
    if ((paramNodeList == null) || (paramNodeList.getLength() == 0)) {
      return;
    }
    int i = 0;
    label16:
    Node localNode;
    if (i < paramNodeList.getLength())
    {
      localNode = paramNodeList.item(i);
      if (!(localNode instanceof Element)) {
        break label67;
      }
      if (localNode.hasChildNodes()) {
        a(paramHashMap, localNode.getChildNodes());
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label67:
      if (localNode.getParentNode() != null) {
        paramHashMap.put(localNode.getParentNode().getNodeName(), localNode.getNodeValue());
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, aeht paramaeht)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 11)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 2)
      {
        paramaeht.aa = aqoj.b(paramArrayOfByte, 1);
        paramaeht.Z = aqoj.b(paramArrayOfByte, 3);
        paramaeht.serverTime = (aqoj.getLongData(paramArrayOfByte, 5) * 1000L);
        paramaeht.bl = paramArrayOfByte[9];
        int i = paramArrayOfByte.length - 10 - 1;
        if (paramaeht.bl == 0)
        {
          paramaeht.dD = new byte[i];
          aqoj.c(paramArrayOfByte, 10, paramaeht.dD, i);
        }
        while (paramArrayOfByte.length != i + 10 + 1)
        {
          return;
          paramaeht.errorMsg = aqoj.a(paramArrayOfByte, 10, i);
        }
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte, aeht paramaeht, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      do
      {
        return false;
        a(paramArrayOfByte, paramaeht);
      } while (paramaeht.aa != 768);
      if (paramaeht.bl != 0)
      {
        a(paramaeht);
        return false;
      }
    } while ((paramaeht.dD == null) || (paramaeht.dD.length == 0));
    a(paramaeht, paramString);
    return true;
  }
  
  public static boolean lD(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  public static HashMap<String, String> r(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      a(localHashMap, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + paramString).getBytes())).getDocumentElement().getChildNodes());
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aehs
 * JD-Core Version:    0.7.0.1
 */