package wf7;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.wifisdk.services.common.api.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class fb
{
  public static File pG = null;
  public static File pH = null;
  private e pI = new hh(fd.dE(), "sk");
  
  static
  {
    try
    {
      pG = new File(Environment.getExternalStorageDirectory(), fd.dE().getPackageName());
      pH = new File(pG, "files");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private LinkedHashMap<String, dn.a> dB()
  {
    int i = 0;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = this.pI.getString("key_hips", "");
    localObject = gi.c(fd.dE(), (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return localLinkedHashMap;
      localObject = ((String)localObject).split("\\|");
    } while ((localObject == null) || (localObject.length == 0));
    int j = localObject.length;
    label71:
    CharSequence localCharSequence;
    if (i < j)
    {
      localCharSequence = localObject[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        break label97;
      }
    }
    for (;;)
    {
      i += 1;
      break label71;
      break;
      label97:
      String[] arrayOfString = localCharSequence.split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        localCharSequence = arrayOfString[0];
        try
        {
          long l = Long.parseLong(arrayOfString[1]);
          arrayOfString = arrayOfString[2].split("#");
          if (arrayOfString != null) {
            localLinkedHashMap.put(localCharSequence, new dn.a(l, dn.a(Arrays.asList(arrayOfString), false), false));
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void A(String paramString)
  {
    paramString = gi.b(fd.dE(), paramString);
    if (paramString == null) {
      return;
    }
    this.pI.b("key_gd", paramString);
  }
  
  public void B(String paramString)
  {
    if (paramString == null) {}
    Context localContext;
    String str;
    do
    {
      return;
      localContext = fd.dE();
      str = gi.b(localContext, paramString);
    } while (str == null);
    if (pH != null) {
      gk.a(new File(pH, "wfsdksk_g.dat"), str.getBytes(), false);
    }
    try
    {
      if (ea.ct()) {}
      for (paramString = "_test";; paramString = "")
      {
        gr.a(localContext, de.encodeToString(ea.a(("wfsdk" + localContext.getPackageName() + "_guid" + paramString).getBytes(), null), 0), str);
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void C(String paramString)
  {
    paramString = gi.b(fd.dE(), paramString);
    if (paramString == null) {
      return;
    }
    this.pI.b("key_vd", paramString);
  }
  
  public void D(String paramString)
  {
    try
    {
      String str = gi.b(fd.dE(), paramString);
      if (str == null) {
        return;
      }
      if (ea.ct()) {}
      for (paramString = "_test";; paramString = "")
      {
        gk.a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.tmfs/sk_v" + paramString + ".dat"), str.getBytes(), false);
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public dn.a E(String paramString)
  {
    return (dn.a)dB().get(paramString);
  }
  
  public void b(String paramString, long paramLong, List<String> paramList)
  {
    if (paramString == null) {}
    label451:
    do
    {
      return;
      if ((paramLong <= 0L) || (paramList == null)) {}
      Object localObject2;
      Object localObject1;
      Object localObject4;
      Object localObject3;
      for (int i = 1;; i = 0)
      {
        localObject2 = dB();
        localObject1 = new LinkedHashMap();
        localObject2 = ((LinkedHashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (dn.a)((Map.Entry)localObject4).getValue();
          if ((localObject3 != null) && (localObject4 != null) && (((dn.a)localObject4).isValid())) {
            ((LinkedHashMap)localObject1).put(localObject3, localObject4);
          }
        }
      }
      if (i != 0)
      {
        ((LinkedHashMap)localObject1).remove(paramString);
        if (((LinkedHashMap)localObject1).size() > 10) {
          ((LinkedHashMap)localObject1).remove((String)new ArrayList(((LinkedHashMap)localObject1).keySet()).get(0));
        }
        paramString = new StringBuilder();
        paramList = ((LinkedHashMap)localObject1).entrySet().iterator();
        i = 0;
      }
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label451;
        }
        localObject2 = (Map.Entry)paramList.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject3 = (dn.a)((Map.Entry)localObject2).getValue();
        if ((localObject1 != null) && (localObject3 != null))
        {
          paramLong = ((dn.a)localObject3).lq;
          if (paramLong > System.currentTimeMillis())
          {
            localObject2 = new StringBuilder();
            int j = 0;
            localObject3 = ((dn.a)localObject3).lr.iterator();
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
                paramList = new dn.a(paramLong, paramList, false);
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
      paramString = gi.b(fd.dE(), paramString.toString());
    } while (paramString == null);
    this.pI.b("key_hips", paramString);
  }
  
  public void b(dx paramdx)
  {
    paramdx = "" + paramdx.lv + "|" + paramdx.lu;
    paramdx = gi.b(fd.dE(), paramdx);
    if (paramdx == null) {
      return;
    }
    this.pI.b("key_rsa", paramdx);
  }
  
  public dx cO()
  {
    Object localObject1 = this.pI.getString("key_rsa", "");
    String str = gi.c(fd.dE(), (String)localObject1);
    Object localObject2 = null;
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
          localObject1 = new dx();
          ((dx)localObject1).lv = str.substring(0, i);
          ((dx)localObject1).lu = str.substring(i + 1);
        }
      }
    }
    return localObject1;
  }
  
  public void d(dl paramdl)
  {
    if (paramdl == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramdl = df.a(paramdl);
        } while (paramdl == null);
        paramdl = gi.k(paramdl);
      } while (paramdl == null);
      paramdl = gi.b(fd.dE(), paramdl);
    } while (paramdl == null);
    this.pI.b("key_g_i", paramdl);
  }
  
  public boolean dA()
  {
    return this.pI.getBoolean("key_its", false);
  }
  
  public String du()
  {
    String str = this.pI.getString("key_gd", "");
    return gi.c(fd.dE(), str);
  }
  
  public String dv()
  {
    Object localObject;
    if (pH != null)
    {
      localObject = gk.a(new File(pH, "wfsdksk_g.dat"));
      if (localObject != null)
      {
        localObject = new String((byte[])localObject);
        localObject = gi.c(fd.dE(), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          return localObject;
        }
      }
    }
    try
    {
      Context localContext = fd.dE();
      if (ea.ct()) {}
      for (localObject = "_test";; localObject = "")
      {
        localObject = gr.d(localContext, de.encodeToString(ea.a(("wfsdk" + localContext.getPackageName() + "_guid" + (String)localObject).getBytes(), null), 0));
        if (localObject == null) {
          break;
        }
        return gi.c(localContext, (String)localObject);
      }
      return null;
    }
    catch (Throwable localThrowable) {}
  }
  
  public String dw()
  {
    String str = this.pI.getString("key_vd", "");
    return gi.c(fd.dE(), str);
  }
  
  public String dx()
  {
    try
    {
      Context localContext = fd.dE();
      if (ea.ct()) {}
      for (Object localObject = "_test";; localObject = "")
      {
        localObject = gk.a(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/.tmfs/sk_v" + (String)localObject + ".dat"));
        if (localObject == null) {
          break;
        }
        return gi.c(localContext, new String((byte[])localObject));
      }
      return null;
    }
    catch (Throwable localThrowable) {}
  }
  
  public long dy()
  {
    String str = this.pI.getString("key_gd_ck_tm", "");
    str = gi.c(fd.dE(), str);
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public dl dz()
  {
    dl localdl = null;
    String str = this.pI.getString("key_g_i", "");
    str = gi.c(fd.dE(), str);
    if (!TextUtils.isEmpty(str)) {
      localdl = (dl)df.a(gi.F(str), new dl(), false);
    }
    return localdl;
  }
  
  public void e(long paramLong)
  {
    String str = Long.toString(paramLong);
    str = gi.b(fd.dE(), str);
    if (str == null) {
      return;
    }
    this.pI.b("key_gd_ck_tm", str);
  }
  
  public void w(boolean paramBoolean)
  {
    this.pI.e("key_its", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fb
 * JD-Core Version:    0.7.0.1
 */