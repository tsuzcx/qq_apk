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
  public static String gP;
  private static int gQ = 1;
  private static volatile bw gR = null;
  private ec O = new ec("sk");
  
  static
  {
    try
    {
      if (!bc.p()) {
        break label78;
      }
      str1 = "_test";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        StringBuilder localStringBuilder;
        continue;
        label78:
        String str2 = "";
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/DCIM/.tmfs/");
    localStringBuilder.append("sk_v");
    localStringBuilder.append(str1);
    localStringBuilder.append(".dat");
    gP = localStringBuilder.toString();
  }
  
  private bw()
  {
    this.O.putInt("key_shark_dao_ver", gQ);
  }
  
  public static bw ah()
  {
    if (gR == null) {
      try
      {
        if (gR == null) {
          gR = new bw();
        }
      }
      finally {}
    }
    return gR;
  }
  
  private LinkedHashMap<String, cg.a> ap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = dx.F(this.O.getString("key_hips", ""));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      eh.f("SharkDao", "[ip_list]getAllHIPListInfos(), none is saved");
      return localLinkedHashMap;
    }
    localObject1 = ((String)localObject1).split("\\|");
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (!TextUtils.isEmpty(localCharSequence))
        {
          Object localObject2 = localCharSequence.split(",");
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            localCharSequence = localObject2[0];
            try
            {
              long l = Long.parseLong(localObject2[1]);
              localObject2 = localObject2[2].split("#");
              if (localObject2 != null) {
                localLinkedHashMap.put(localCharSequence, new cg.a(l, cg.a(Arrays.asList((Object[])localObject2), false), false));
              }
            }
            catch (Exception localException)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[ip_list]getAllHIPListInfos() exception: ");
              ((StringBuilder)localObject2).append(localException);
              eh.h("SharkDao", ((StringBuilder)localObject2).toString());
            }
          }
        }
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[ip_list]getAllHIPListInfos(), size: ");
      ((StringBuilder)localObject1).append(localLinkedHashMap.size());
      eh.f("SharkDao", ((StringBuilder)localObject1).toString());
      return localLinkedHashMap;
    }
    eh.g("SharkDao", "[ip_list]getAllHIPListInfos(), item number is 0!");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramb.is);
    localStringBuilder.append("|");
    localStringBuilder.append(paramb.ir);
    paramb = dx.E(localStringBuilder.toString());
    if (paramb == null) {
      return;
    }
    this.O.putString("key_rsa", paramb);
  }
  
  public void a(v paramv)
  {
    if (paramv == null) {
      return;
    }
    paramv = cp.b(paramv);
    if (paramv != null)
    {
      paramv = ConvertUtil.bytesToHexString(paramv);
      if (paramv != null)
      {
        paramv = dx.E(paramv);
        if (paramv != null)
        {
          this.O.putString("key_s_c", paramv);
          eh.f("SharkDao", "[shark_conf]setSharkConf() succ");
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong, List<String> paramList)
  {
    if (paramString == null)
    {
      eh.h("SharkDao", "[ip_list]setHIPListInfo(), bad arg, key == null");
      return;
    }
    if ((paramLong > 0L) && (paramList != null)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[ip_list]setHIPListInfo(), op=");
    if (i != 0) {
      localObject1 = "[delete] ";
    } else {
      localObject1 = "[set] ";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("|key=");
    ((StringBuilder)localObject2).append(paramString);
    eh.e("SharkDao", ((StringBuilder)localObject2).toString());
    localObject2 = ap();
    Object localObject1 = new LinkedHashMap();
    localObject2 = ((LinkedHashMap)localObject2).entrySet().iterator();
    Object localObject4;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (cg.a)((Map.Entry)localObject4).getValue();
      if ((localObject3 != null) && (localObject4 != null)) {
        if (!((cg.a)localObject4).isValid())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("[ip_list]setHIPListInfo(), remove expired:　");
          ((StringBuilder)localObject4).append((String)localObject3);
          eh.h("SharkDao", ((StringBuilder)localObject4).toString());
        }
        else
        {
          ((LinkedHashMap)localObject1).put(localObject3, localObject4);
        }
      }
    }
    if (i != 0)
    {
      ((LinkedHashMap)localObject1).remove(paramString);
    }
    else
    {
      paramList = new cg.a(paramLong, paramList, false);
      if (paramList.isValid()) {
        ((LinkedHashMap)localObject1).put(paramString, paramList);
      }
    }
    if (((LinkedHashMap)localObject1).size() > 10)
    {
      paramString = new ArrayList(((LinkedHashMap)localObject1).keySet());
      paramList = new StringBuilder();
      paramList.append("[ip_list]setHIPListInfo(), too manay, keyList: ");
      paramList.append(paramString);
      eh.f("SharkDao", paramList.toString());
      paramString = (String)paramString.get(0);
      ((LinkedHashMap)localObject1).remove(paramString);
      paramList = new StringBuilder();
      paramList.append("[ip_list]setHIPListInfo(), too manay, remove firstKey: ");
      paramList.append(paramString);
      eh.f("SharkDao", paramList.toString());
    }
    paramString = new StringBuilder();
    paramList = ((LinkedHashMap)localObject1).entrySet().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject2 = (Map.Entry)paramList.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (cg.a)((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject3 != null))
      {
        paramLong = ((cg.a)localObject3).hZ;
        if (paramLong > System.currentTimeMillis())
        {
          localObject2 = new StringBuilder();
          localObject3 = ((cg.a)localObject3).ia.iterator();
          int j = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            if (j > 0) {
              ((StringBuilder)localObject2).append("#");
            }
            ((StringBuilder)localObject2).append((String)localObject4);
            j += 1;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append(",");
          ((StringBuilder)localObject3).append(((StringBuilder)localObject2).toString());
          if (i > 0) {
            paramString.append("|");
          }
          paramString.append(((StringBuilder)localObject3).toString());
          i += 1;
        }
      }
    }
    paramList = new StringBuilder();
    paramList.append("[ip_list]setHIPListInfo(), new size: ");
    paramList.append(i);
    paramList.append(", before encode: ");
    paramList.append(paramString.toString());
    eh.f("SharkDao", paramList.toString());
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
    String str = this.O.getString("key_rsa", "");
    if (!TextUtils.isEmpty(str))
    {
      str = dx.F(str);
      if (!TextUtils.isEmpty(str))
      {
        int i = str.indexOf("|");
        if ((i > 0) && (i < str.length() - 1))
        {
          cs.b localb = new cs.b();
          localb.is = str.substring(0, i);
          localb.ir = str.substring(i + 1);
          return localb;
        }
      }
    }
    return null;
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
    byte[] arrayOfByte = dz.G(gP);
    if (arrayOfByte != null) {
      return dx.F(new String(arrayOfByte));
    }
    return null;
  }
  
  public long am()
  {
    String str = dx.F(this.O.getString("key_gd_ck_tm", ""));
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Throwable localThrowable)
    {
      label23:
      break label23;
    }
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
          return localan;
        }
      }
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
    String str = dx.F(this.O.getString("key_s_c", ""));
    if (!TextUtils.isEmpty(str)) {
      return (v)cp.a(ConvertUtil.hexStringToByte(str), new v(), false);
    }
    return null;
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
    if (paramString == null) {
      return;
    }
    if (gP != null) {
      dz.a(paramString.getBytes(), gP);
    }
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