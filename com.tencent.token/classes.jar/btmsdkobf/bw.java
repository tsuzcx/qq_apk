package btmsdkobf;

import android.os.Environment;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tmsdk.base.utils.ConvertUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bw
{
  public static String gP = null;
  private static int gQ;
  private static volatile bw gR;
  private ec O = new ec("sk");
  
  static
  {
    for (;;)
    {
      try
      {
        if (!bc.p()) {
          continue;
        }
        str = "_test";
        gP = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.tmfs/" + "sk_v" + str + ".dat";
      }
      catch (Throwable localThrowable)
      {
        String str;
        continue;
      }
      gQ = 1;
      gR = null;
      return;
      str = "";
    }
  }
  
  private bw()
  {
    this.O.putInt("key_shark_dao_ver", gQ);
  }
  
  public static bw ah()
  {
    if (gR == null) {}
    try
    {
      if (gR == null) {
        gR = new bw();
      }
      return gR;
    }
    finally {}
  }
  
  private LinkedHashMap ap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = dx.F(this.O.getString("key_hips", ""));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      eh.f("SharkDao", "[ip_list]getAllHIPListInfos(), none is saved");
      return localLinkedHashMap;
    }
    localObject = ((String)localObject).split("\\|");
    if ((localObject == null) || (localObject.length == 0))
    {
      eh.g("SharkDao", "[ip_list]getAllHIPListInfos(), item number is 0!");
      return localLinkedHashMap;
    }
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      CharSequence localCharSequence = localObject[i];
      if (TextUtils.isEmpty(localCharSequence)) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localCharSequence.split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localCharSequence = arrayOfString[0];
          try
          {
            long l = Long.parseLong(arrayOfString[1]);
            arrayOfString = arrayOfString[2].split("#");
            if (arrayOfString != null) {
              localLinkedHashMap.put(localCharSequence, new cg.a(l, cg.a(Arrays.asList(arrayOfString), false), false));
            }
          }
          catch (Exception localException)
          {
            eh.h("SharkDao", "[ip_list]getAllHIPListInfos() exception: " + localException);
          }
        }
      }
    }
    eh.f("SharkDao", "[ip_list]getAllHIPListInfos(), size: " + localLinkedHashMap.size());
    return localLinkedHashMap;
  }
  
  public void a(an paraman)
  {
    try
    {
      paraman = ConvertUtil.bytesToHexString(paraman.toByteArray("UTF-8"));
      this.O.putString("key_gd_info", paraman);
      return;
    }
    catch (Throwable paraman)
    {
      eh.h("SharkDao", paraman.getMessage());
    }
  }
  
  public void a(cs.b paramb)
  {
    paramb = dx.E("" + paramb.is + "|" + paramb.ir);
    if (paramb == null) {
      return;
    }
    this.O.putString("key_rsa", paramb);
  }
  
  public void a(v paramv)
  {
    if (paramv == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramv = cp.b(paramv);
        } while (paramv == null);
        paramv = ConvertUtil.bytesToHexString(paramv);
      } while (paramv == null);
      paramv = dx.E(paramv);
    } while (paramv == null);
    this.O.putString("key_s_c", paramv);
    eh.f("SharkDao", "[shark_conf]setSharkConf() succ");
  }
  
  public void a(String paramString, long paramLong, List paramList)
  {
    if (paramString == null)
    {
      eh.h("SharkDao", "[ip_list]setHIPListInfo(), bad arg, key == null");
      return;
    }
    int i;
    Object localObject2;
    Object localObject1;
    if ((paramLong <= 0L) || (paramList == null))
    {
      i = 1;
      localObject2 = new StringBuilder().append("[ip_list]setHIPListInfo(), op=");
      if (i == 0) {
        break label199;
      }
      localObject1 = "[delete] ";
      label49:
      eh.e("SharkDao", (String)localObject1 + "|key=" + paramString);
      localObject2 = ap();
      localObject1 = new LinkedHashMap();
      localObject2 = ((LinkedHashMap)localObject2).entrySet().iterator();
    }
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label220;
      }
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (cg.a)((Map.Entry)localObject4).getValue();
      if ((localObject3 != null) && (localObject4 != null))
      {
        if (!((cg.a)localObject4).isValid())
        {
          eh.h("SharkDao", "[ip_list]setHIPListInfo(), remove expired:　" + (String)localObject3);
          continue;
          i = 0;
          break;
          label199:
          localObject1 = "[set] ";
          break label49;
        }
        ((LinkedHashMap)localObject1).put(localObject3, localObject4);
      }
    }
    label220:
    if (i != 0)
    {
      ((LinkedHashMap)localObject1).remove(paramString);
      if (((LinkedHashMap)localObject1).size() > 10)
      {
        paramString = new ArrayList(((LinkedHashMap)localObject1).keySet());
        eh.f("SharkDao", "[ip_list]setHIPListInfo(), too manay, keyList: " + paramString);
        paramString = (String)paramString.get(0);
        ((LinkedHashMap)localObject1).remove(paramString);
        eh.f("SharkDao", "[ip_list]setHIPListInfo(), too manay, remove firstKey: " + paramString);
      }
      paramString = new StringBuilder();
      paramList = ((LinkedHashMap)localObject1).entrySet().iterator();
      i = 0;
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label595;
      }
      localObject2 = (Map.Entry)paramList.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (cg.a)((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject3 != null))
      {
        paramLong = ((cg.a)localObject3).hZ;
        if (paramLong > System.currentTimeMillis())
        {
          localObject2 = new StringBuilder();
          int j = 0;
          localObject3 = ((cg.a)localObject3).ia.iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              if (j > 0) {
                ((StringBuilder)localObject2).append("#");
              }
              ((StringBuilder)localObject2).append((String)localObject4);
              j += 1;
              continue;
              paramList = new cg.a(paramLong, paramList, false);
              if (!paramList.isValid()) {
                break;
              }
              ((LinkedHashMap)localObject1).put(paramString, paramList);
              break;
            }
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1).append(",").append(paramLong).append(",").append(((StringBuilder)localObject2).toString());
          if (i > 0) {
            paramString.append("|");
          }
          paramString.append(((StringBuilder)localObject3).toString());
          i += 1;
        }
      }
    }
    label595:
    eh.f("SharkDao", "[ip_list]setHIPListInfo(), new size: " + i + ", before encode: " + paramString.toString());
    paramString = dx.E(paramString.toString());
    if (paramString == null)
    {
      eh.h("SharkDao", "[ip_list]getEncodeString for HIPLists failed");
      return;
    }
    this.O.putString("key_hips", paramString);
  }
  
  public cs.b ai()
  {
    Object localObject2 = null;
    String str = this.O.getString("key_rsa", "");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      str = dx.F(str);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("|");
        localObject1 = localObject2;
        if (i > 0)
        {
          localObject1 = localObject2;
          if (i < str.length() - 1)
          {
            localObject1 = new cs.b();
            ((cs.b)localObject1).is = str.substring(0, i);
            ((cs.b)localObject1).ir = str.substring(i + 1);
          }
        }
      }
    }
    return localObject1;
  }
  
  public String aj()
  {
    return dx.F(this.O.getString("key_gd", ""));
  }
  
  public String ak()
  {
    return dx.F(this.O.getString("key_vd", ""));
  }
  
  public String al()
  {
    String str = null;
    byte[] arrayOfByte = dz.G(gP);
    if (arrayOfByte != null) {
      str = dx.F(new String(arrayOfByte));
    }
    return str;
  }
  
  public long am()
  {
    String str = dx.F(this.O.getString("key_gd_ck_tm", ""));
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public an an()
  {
    an localan = new an();
    try
    {
      Object localObject = this.O.getString("key_gd_info", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ConvertUtil.hexStringToByte((String)localObject);
        if (localObject != null)
        {
          localObject = new JceInputStream((byte[])localObject);
          ((JceInputStream)localObject).setServerEncoding("UTF-8");
          localan.readFrom((JceInputStream)localObject);
        }
      }
      return localan;
    }
    catch (Throwable localThrowable)
    {
      eh.h("SharkDao", localThrowable.getMessage());
    }
    return localan;
  }
  
  public boolean ao()
  {
    return this.O.getBoolean("key_test_state", false);
  }
  
  public v aq()
  {
    v localv = null;
    String str = dx.F(this.O.getString("key_s_c", ""));
    if (!TextUtils.isEmpty(str)) {
      localv = (v)cp.a(ConvertUtil.hexStringToByte(str), new v(), false);
    }
    return localv;
  }
  
  public void b(long paramLong)
  {
    String str = dx.E(Long.toString(paramLong));
    if (str == null) {
      return;
    }
    this.O.putString("key_gd_ck_tm", str);
  }
  
  public void c(boolean paramBoolean)
  {
    this.O.putBoolean("key_test_state", paramBoolean);
  }
  
  public void n(String paramString)
  {
    paramString = dx.E(paramString);
    if (paramString == null) {
      return;
    }
    this.O.putString("key_gd", paramString);
  }
  
  public void o(String paramString)
  {
    paramString = dx.E(paramString);
    if (paramString == null) {
      return;
    }
    this.O.putString("key_vd", paramString);
  }
  
  public void p(String paramString)
  {
    paramString = dx.E(paramString);
    if (paramString == null) {}
    while (gP == null) {
      return;
    }
    dz.a(paramString.getBytes(), gP);
  }
  
  public cg.a q(String paramString)
  {
    return (cg.a)ap().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bw
 * JD-Core Version:    0.7.0.1
 */