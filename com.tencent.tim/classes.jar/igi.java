import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class igi
  extends igm<igi.a>
{
  public igi()
  {
    super(431);
  }
  
  public static igi.c a(int paramInt)
  {
    igi.a locala = (igi.a)aeif.a().o(431);
    if (locala.cu == null) {
      return null;
    }
    return (igi.c)locala.cu.get(Integer.valueOf(paramInt));
  }
  
  static igi.c a(igj.a parama)
  {
    int j = parama.akU;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = parama.akY;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = parama.akZ;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = parama.minVersion;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = parama.ala;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((parama.eZ == null) || (parama.eZ.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    igi.b localb;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = parama.LQ;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = parama.eZ.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (igj.a.a)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((igj.a.a)localObject3).md5)) && (!TextUtils.isEmpty(((igj.a.a)localObject3).url)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((igj.a.a)localObject3).LO)) {
            break label591;
          }
          QLog.w("QAVConfig_431", 1, "exp 为空, codec[" + j + "]");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + parama.LQ + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((igj.a.a)localObject3).w == 0) || (((igj.a.a)localObject3).h == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          localb = new igi.b();
          localb.url = ((igj.a.a)localObject3).url;
          localb.LO = ((igj.a.a)localObject3).LO;
          localb.md5 = ((igj.a.a)localObject3).md5;
          localb.w = ((igj.a.a)localObject3).w;
          localb.h = ((igj.a.a)localObject3).h;
          localb.Ot = parama.Ot;
          localHashMap.put(((igj.a.a)localObject3).md5, localb);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      localb = null;
      localObject2 = null;
      localObject3 = localb;
      if (parama.eY == null) {
        break label831;
      }
    }
    Object localObject3 = localb;
    int i1;
    if (parama.eY.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= parama.eY.size()) {
          break label831;
        }
        i1 = ((Integer)parama.eY.get(i)).intValue();
        if (i1 > 0) {
          break;
        }
        i += 1;
      }
      if (localObject2 != null) {
        break label906;
      }
      localObject2 = new ArrayList();
    }
    label906:
    for (;;)
    {
      ((ArrayList)localObject2).add(Integer.valueOf(i1));
      break;
      label831:
      localObject2 = new igi.c();
      ((igi.c)localObject2).cv = localHashMap;
      ((igi.c)localObject2).hX = ((ArrayList)localObject3);
      ((igi.c)localObject2).akV = k;
      ((igi.c)localObject2).akW = m;
      ((igi.c)localObject2).akU = j;
      ((igi.c)localObject2).LP = str;
      ((igi.c)localObject2).akX = n;
      ((igi.c)localObject2).Ot = parama.Ot;
      ((igi.c)localObject2).kz = l;
      return localObject2;
    }
  }
  
  @NonNull
  public igi.a a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
    }
    return new igi.a();
  }
  
  @Nullable
  protected igi.a a(aeic[] paramArrayOfaeic)
    throws Exception
  {
    igi.a locala = new igi.a();
    int j = paramArrayOfaeic.length;
    int i = 0;
    while (i < j)
    {
      aeic localaeic = paramArrayOfaeic[i];
      Object localObject = igj.a(localaeic.content);
      boolean bool;
      if ((localObject != null) && (((igj)localObject).eX != null))
      {
        bool = true;
        if (AudioHelper.aCz()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localaeic.taskId + "], suc[" + bool + "], oldVersion[" + ku() + "]");
        }
        if (bool) {
          localObject = ((igj)localObject).eX.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label365;
          }
          igj.a locala1 = (igj.a)((Iterator)localObject).next();
          igi.c localc1 = a(locala1);
          if (localc1 == null)
          {
            if (!AudioHelper.aCz()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (locala.cu.containsKey(Integer.valueOf(locala1.akU)))
          {
            igi.c localc2 = (igi.c)locala.cu.get(Integer.valueOf(locala1.akU));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + locala1.akU + "], _taskId[" + localc2.taskId + "], _test_ver[" + localc2.akX + "], taskId[" + localaeic.taskId + "], test_ver[" + localc1.akX + "]");
            if (localc1.akX <= localc2.akX) {}
          }
          else
          {
            localc1.taskId = localaeic.taskId;
            locala.cu.put(Integer.valueOf(locala1.akU), localc1);
          }
        }
      }
      label365:
      i += 1;
    }
    return locala;
  }
  
  public void a(igi.a parama)
  {
    super.onUpdate(parama);
    int i = aeif.a().q(431, "");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = (QQAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((QQAppInterface)localObject2).getCurrentAccountUin());
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = new int[4];
      Object tmp115_113 = localObject2;
      tmp115_113[0] = 1;
      Object tmp119_115 = tmp115_113;
      tmp119_115[1] = 2;
      Object tmp123_119 = tmp119_115;
      tmp123_119[2] = 4;
      Object tmp127_123 = tmp123_119;
      tmp127_123[3] = 8;
      tmp127_123;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        igi.c localc = (igi.c)parama.cu.get(Integer.valueOf(k));
        if (localc != null)
        {
          int m = ioe.a(localc);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", localc.akX + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<igi.a> clazz()
  {
    return igi.a.class;
  }
  
  static class a
  {
    HashMap<Integer, igi.c> cu = new HashMap();
    
    public String toString()
    {
      return "size[" + this.cu.size() + "]";
    }
  }
  
  public static class b
  {
    public String LO;
    public boolean Ot;
    public int bitrate;
    public int fps;
    public int h;
    public String md5;
    public String url;
    public int w;
  }
  
  public static class c
  {
    public String LP;
    public boolean Ot;
    public int akU;
    public int akV;
    public int akW;
    public int akX;
    public HashMap<String, igi.b> cv;
    public ArrayList<Integer> hX;
    public long kz;
    public int taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igi
 * JD-Core Version:    0.7.0.1
 */