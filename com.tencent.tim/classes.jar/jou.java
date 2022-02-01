import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class jou
{
  private static volatile long[] B = { 2852200000L };
  private static volatile long[] C = { 2852999999L };
  private static volatile long[] D = { 1496000000L };
  private static volatile long[] E = { 1497000000L };
  private static volatile long[] F = { 2852000000L, 3003000000L };
  private static volatile long[] G = { 2852199999L, 3003000000L };
  public static final AtomicBoolean al = new AtomicBoolean(false);
  private static long[] w = { 2355000000L, 2880000000L, 2885000000L, 2850121000L, 2852200000L, 3001000000L, 3003000000L, 3003400000L, 3006000000L };
  private static long[] x = { 2355999999L, 2881999999L, 2885999999L, 2851999999L, 2854120999L, 3002999999L, 3003399999L, 3005999999L, 3008999999L };
  private static volatile long[] y;
  private static volatile long[] z;
  
  public static boolean A(Context paramContext, String paramString)
  {
    if (!de(paramString)) {}
    for (;;)
    {
      return false;
      if (!al.get()) {
        bI(paramContext);
      }
      long l = Long.valueOf(paramString).longValue();
      if ((B == null) || (C == null)) {
        ayP();
      }
      if ((B != null) && (C != null) && (B.length == C.length))
      {
        int j = B.length;
        int i = 0;
        while (i < j)
        {
          if ((B[i] <= l) && (l <= C[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null)) {}
    do
    {
      return;
      if (1 == paramInt) {
        try
        {
          y = paramArrayOfLong1;
          z = paramArrayOfLong2;
          return;
        }
        finally {}
      }
      if (2 == paramInt) {
        try
        {
          B = paramArrayOfLong1;
          C = paramArrayOfLong2;
          return;
        }
        finally {}
      }
    } while (3 != paramInt);
    try
    {
      D = paramArrayOfLong1;
      E = paramArrayOfLong2;
      return;
    }
    finally {}
  }
  
  private static void a(Element paramElement, int paramInt)
  {
    Object localObject1 = null;
    NodeList localNodeList;
    if (paramElement != null)
    {
      localNodeList = paramElement.getElementsByTagName("segment");
      int j = localNodeList.getLength();
      if (j > 0)
      {
        localObject1 = new long[j];
        paramElement = new long[j];
        int i = 0;
        while (i < j)
        {
          Object localObject2 = (Element)localNodeList.item(i);
          String str;
          if (localObject2 != null)
          {
            str = ((Element)localObject2).getAttribute("start");
            localObject2 = ((Element)localObject2).getAttribute("end");
          }
          try
          {
            long l1 = Long.valueOf(str.trim()).longValue();
            long l2 = Long.valueOf(((String)localObject2).trim()).longValue();
            localObject1[i] = l1;
            paramElement[i] = l2;
          }
          catch (Exception localException)
          {
            break label122;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label122:
            break label122;
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      a(paramInt, (long[])localObject1, paramElement);
      return;
      localNodeList = null;
      paramElement = (Element)localObject1;
      localObject1 = localNodeList;
    }
  }
  
  private static void ayP()
  {
    if ((y == null) || (z == null))
    {
      y = w;
      z = x;
    }
    if ((B == null) || (C == null))
    {
      B = new long[] { 2852200000L };
      C = new long[] { 2852999999L };
    }
  }
  
  public static void bI(Context paramContext)
  {
    Object localObject = null;
    try
    {
      String str = aqmj.bl(paramContext);
      localObject = str;
    }
    catch (Exception localException)
    {
      label9:
      break label9;
    }
    aqmj.cq(paramContext, "");
    if (!TextUtils.isEmpty(localObject))
    {
      kW(SecurityUtile.decode(localObject));
      n(localObject, true);
    }
    for (;;)
    {
      al.set(true);
      return;
      try
      {
        paramContext = (aced)BaseApplicationImpl.sApplication.getRuntime().getManager(69);
        if (paramContext != null) {
          n(paramContext.ry(), false);
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean de(String paramString)
  {
    boolean bool = false;
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 10000L) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException paramString)
    {
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean df(String paramString)
  {
    if (!de(paramString)) {}
    while (!al.get()) {
      return false;
    }
    return z(null, paramString);
  }
  
  public static void kW(String paramString)
  {
    aced localaced;
    if (n(paramString, false))
    {
      localaced = (aced)BaseApplicationImpl.sApplication.getRuntime().getManager(69);
      if (localaced == null) {
        break label47;
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label41;
      }
      localaced.DD("");
    }
    label41:
    label47:
    while (!QLog.isColorLevel())
    {
      return;
      localaced.DD(paramString);
      return;
    }
    QLog.d("BmqqSegmentUtil", 2, "EqqDetailDataManager is null");
  }
  
  private static boolean n(String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramString != null)
    {
      String str = paramString.trim();
      if ("".equals(str)) {
        return true;
      }
      try
      {
        paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        if (paramString != null)
        {
          Object localObject1 = str;
          if (paramBoolean) {
            localObject1 = SecurityUtile.decode(str);
          }
          localObject1 = new InputSource(new StringReader((String)localObject1));
          try
          {
            paramString = paramString.parse((InputSource)localObject1);
            paramBoolean = true;
          }
          catch (SAXException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              paramBoolean = false;
              paramString = localObject2;
            }
          }
          if (paramString != null)
          {
            a((Element)paramString.getElementsByTagName("hrtx-uin-segment").item(0), 1);
            a((Element)paramString.getElementsByTagName("crm3-ext-uin-segment").item(0), 2);
            a((Element)paramString.getElementsByTagName("crm3-wx-map-uin-segment").item(0), 3);
          }
          return paramBoolean;
        }
      }
      catch (ParserConfigurationException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
    return true;
  }
  
  public static boolean z(Context paramContext, String paramString)
  {
    if (!de(paramString)) {}
    for (;;)
    {
      return false;
      if ((!al.get()) && (paramContext != null)) {
        bI(paramContext);
      }
      long l = Long.valueOf(paramString).longValue();
      if ((y == null) || (z == null)) {
        ayP();
      }
      int j;
      int i;
      if ((y != null) && (z != null) && (y.length == z.length))
      {
        j = y.length;
        i = 0;
        while (i < j)
        {
          if ((y[i] <= l) && (l <= z[i])) {
            return true;
          }
          i += 1;
        }
      }
      if ((y != null) && (y.length != w.length))
      {
        j = w.length;
        i = 0;
        while (i < j)
        {
          if ((w[i] <= l) && (l <= x[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jou
 * JD-Core Version:    0.7.0.1
 */