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
  public static File pG;
  public static File pH;
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
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = this.pI.getString("key_hips", "");
    localObject = gi.c(fd.dE(), (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localLinkedHashMap;
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return localLinkedHashMap;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject[i];
        String[] arrayOfString;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          arrayOfString = localCharSequence.split(",");
          if ((arrayOfString != null) && (arrayOfString.length > 0)) {
            localCharSequence = arrayOfString[0];
          }
        }
        try
        {
          long l = Long.parseLong(arrayOfString[1]);
          arrayOfString = arrayOfString[2].split("#");
          if (arrayOfString != null) {
            localLinkedHashMap.put(localCharSequence, new dn.a(l, dn.a(Arrays.asList(arrayOfString), false), false));
          }
        }
        catch (Exception localException)
        {
          label175:
          break label175;
        }
        i += 1;
      }
    }
    else
    {
      return localLinkedHashMap;
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
    if (paramString == null) {
      return;
    }
    Context localContext = fd.dE();
    String str = gi.b(localContext, paramString);
    if (str != null)
    {
      paramString = pH;
      if (paramString != null) {
        gk.a(new File(paramString, "wfsdksk_g.dat"), str.getBytes(), false);
      }
    }
    for (;;)
    {
      try
      {
        if (ea.ct())
        {
          paramString = "_test";
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wfsdk");
          localStringBuilder.append(localContext.getPackageName());
          localStringBuilder.append("_guid");
          localStringBuilder.append(paramString);
          gr.a(localContext, de.encodeToString(ea.a(localStringBuilder.toString().getBytes(), null), 0), str);
          return;
        }
      }
      catch (Throwable paramString)
      {
        return;
      }
      paramString = "";
    }
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
    for (;;)
    {
      try
      {
        String str = gi.b(fd.dE(), paramString);
        if (str == null) {
          return;
        }
        if (ea.ct())
        {
          paramString = "_test";
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
          localStringBuilder.append("/DCIM/.tmfs/sk_v");
          localStringBuilder.append(paramString);
          localStringBuilder.append(".dat");
          gk.a(new File(localStringBuilder.toString()), str.getBytes(), false);
          return;
        }
      }
      catch (Throwable paramString)
      {
        return;
      }
      paramString = "";
    }
  }
  
  public dn.a E(String paramString)
  {
    return (dn.a)dB().get(paramString);
  }
  
  public void b(String paramString, long paramLong, List<String> paramList)
  {
    if (paramString == null) {
      return;
    }
    if ((paramLong > 0L) && (paramList != null)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = dB();
    Object localObject1 = new LinkedHashMap();
    localObject2 = ((LinkedHashMap)localObject2).entrySet().iterator();
    Object localObject4;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = (String)((Map.Entry)localObject4).getKey();
      localObject4 = (dn.a)((Map.Entry)localObject4).getValue();
      if ((localObject3 != null) && (localObject4 != null) && (((dn.a)localObject4).isValid())) {
        ((LinkedHashMap)localObject1).put(localObject3, localObject4);
      }
    }
    if (i != 0)
    {
      ((LinkedHashMap)localObject1).remove(paramString);
    }
    else
    {
      paramList = new dn.a(paramLong, paramList, false);
      if (paramList.isValid()) {
        ((LinkedHashMap)localObject1).put(paramString, paramList);
      }
    }
    if (((LinkedHashMap)localObject1).size() > 10) {
      ((LinkedHashMap)localObject1).remove((String)new ArrayList(((LinkedHashMap)localObject1).keySet()).get(0));
    }
    paramString = new StringBuilder();
    paramList = ((LinkedHashMap)localObject1).entrySet().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject2 = (Map.Entry)paramList.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject3 = (dn.a)((Map.Entry)localObject2).getValue();
      if ((localObject1 != null) && (localObject3 != null))
      {
        paramLong = ((dn.a)localObject3).lq;
        if (paramLong > System.currentTimeMillis())
        {
          localObject2 = new StringBuilder();
          localObject3 = ((dn.a)localObject3).lr.iterator();
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
    paramString = gi.b(fd.dE(), paramString.toString());
    if (paramString == null) {
      return;
    }
    this.pI.b("key_hips", paramString);
  }
  
  public void b(dx paramdx)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramdx.lv);
    localStringBuilder.append("|");
    localStringBuilder.append(paramdx.lu);
    paramdx = localStringBuilder.toString();
    paramdx = gi.b(fd.dE(), paramdx);
    if (paramdx == null) {
      return;
    }
    this.pI.b("key_rsa", paramdx);
  }
  
  public dx cO()
  {
    String str = this.pI.getString("key_rsa", "");
    str = gi.c(fd.dE(), str);
    if (!TextUtils.isEmpty(str))
    {
      int i = str.indexOf("|");
      if ((i > 0) && (i < str.length() - 1))
      {
        dx localdx = new dx();
        localdx.lv = str.substring(0, i);
        localdx.lu = str.substring(i + 1);
        return localdx;
      }
    }
    return null;
  }
  
  public void d(dl paramdl)
  {
    if (paramdl == null) {
      return;
    }
    paramdl = df.a(paramdl);
    if (paramdl != null)
    {
      paramdl = gi.k(paramdl);
      if (paramdl != null)
      {
        paramdl = gi.b(fd.dE(), paramdl);
        if (paramdl != null) {
          this.pI.b("key_g_i", paramdl);
        }
      }
    }
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
    Object localObject1 = pH;
    if (localObject1 != null)
    {
      localObject1 = gk.a(new File((File)localObject1, "wfsdksk_g.dat"));
      if (localObject1 != null)
      {
        localObject1 = new String((byte[])localObject1);
        localObject1 = gi.c(fd.dE(), (String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          return localObject1;
        }
      }
    }
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        Context localContext = fd.dE();
        if (ea.ct())
        {
          localObject1 = "_test";
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("wfsdk");
          ((StringBuilder)localObject3).append(localContext.getPackageName());
          ((StringBuilder)localObject3).append("_guid");
          ((StringBuilder)localObject3).append((String)localObject1);
          localObject3 = gr.d(localContext, de.encodeToString(ea.a(((StringBuilder)localObject3).toString().getBytes(), null), 0));
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = gi.c(localContext, (String)localObject3);
          }
          return localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      String str = "";
    }
  }
  
  public String dw()
  {
    String str = this.pI.getString("key_vd", "");
    return gi.c(fd.dE(), str);
  }
  
  public String dx()
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        Context localContext = fd.dE();
        if (ea.ct())
        {
          Object localObject1 = "_test";
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(Environment.getExternalStorageDirectory().getAbsolutePath());
          ((StringBuilder)localObject3).append("/DCIM/.tmfs/sk_v");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(".dat");
          localObject3 = gk.a(new File(((StringBuilder)localObject3).toString()));
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = gi.c(localContext, new String((byte[])localObject3));
          }
          return localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        return null;
      }
      String str = "";
    }
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
    catch (Exception localException)
    {
      label30:
      break label30;
    }
    return 0L;
  }
  
  public dl dz()
  {
    String str = this.pI.getString("key_g_i", "");
    str = gi.c(fd.dE(), str);
    if (!TextUtils.isEmpty(str)) {
      return (dl)df.a(gi.F(str), new dl(), false);
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fb
 * JD-Core Version:    0.7.0.1
 */