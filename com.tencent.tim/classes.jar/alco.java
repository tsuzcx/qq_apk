import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.ProfileCardManager.1;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x703.cmd0x703.PhotoInfo;
import tencent.im.oidb.cmd0x703.cmd0x703.UinPhotoListInfo;

public class alco
{
  public static String bVn = "https://gxh.vip.qq.com/xydata";
  public static Map<Long, Boolean> ms = new ConcurrentHashMap();
  public static Map<Long, Boolean> mt = new ConcurrentHashMap();
  public Vector<Integer> M = new Vector();
  Map<String, Boolean> Q = new ConcurrentHashMap();
  public Handler dj;
  protected AppInterface mApp;
  protected Context mContext;
  private Map<Integer, alco.a> mu = new ConcurrentHashMap();
  Map<Long, Integer> y = new ConcurrentHashMap();
  
  public alco(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.mContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public static byte[] E(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    cmd0x703.UinPhotoListInfo localUinPhotoListInfo = new cmd0x703.UinPhotoListInfo();
    cmd0x703.PhotoInfo localPhotoInfo = new cmd0x703.PhotoInfo();
    localPhotoInfo.str_url.set(paramString);
    localPhotoInfo.uint32_id.set(-1);
    localPhotoInfo.uint32_timestamp.set(0);
    localUinPhotoListInfo.rpt_msg_photo_info.add(localPhotoInfo);
    return localUinPhotoListInfo.toByteArray();
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == alcs.agm) {
      return e(paramContext, paramLong2) + "wzBgImage.png";
    }
    if (paramLong1 == alcs.agl) {
      return e(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return e(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public static String b(Context paramContext, long paramLong1, long paramLong2)
  {
    if (paramLong1 == alcs.agm) {
      return e(paramContext, paramLong2) + "wzDynamicDrawerImage.png";
    }
    if (paramLong1 == alcs.agl) {
      return e(paramContext, paramLong2) + "wzJoinImage.png";
    }
    return e(paramContext, paramLong2) + "cardPreview.jpg";
  }
  
  public static boolean b(Context paramContext, long paramLong, String paramString)
  {
    paramContext = new File(e(paramContext, paramLong), paramString);
    return (paramContext.exists()) && ((!paramContext.isDirectory()) || (paramContext.list().length > 1));
  }
  
  public static String e(Context paramContext, long paramLong)
  {
    return aqep.aY(paramContext) + paramLong + File.separator;
  }
  
  public static String f(Context paramContext, long paramLong)
  {
    return aqep.aY(paramContext) + paramLong + ".zip";
  }
  
  public static boolean h(Context paramContext, long paramLong)
  {
    paramContext = e(paramContext, paramLong);
    if (TextUtils.isEmpty(paramContext)) {}
    for (paramContext = null; (paramContext != null) && (paramContext.exists()) && (paramContext.isDirectory()) && (paramContext.list().length > 1); paramContext = new File(paramContext)) {
      return true;
    }
    return false;
  }
  
  public static String mK(String paramString)
  {
    return acbn.bnh + "defaultCard" + File.separator + paramString + ".json";
  }
  
  public int V(long paramLong)
  {
    int i = 0;
    if (this.y.containsKey(Long.valueOf(paramLong))) {
      i = ((Integer)this.y.get(Long.valueOf(paramLong))).intValue();
    }
    return i;
  }
  
  public alco.a a(int paramInt, boolean paramBoolean)
  {
    try
    {
      alco.a locala = (alco.a)this.mu.get(Integer.valueOf(paramInt));
      if (locala == null)
      {
        locala = new alco.a(paramInt);
        this.mu.put(Integer.valueOf(paramInt), locala);
      }
      for (;;)
      {
        Object localObject2;
        if (!locala.isInited)
        {
          localObject2 = new File(mK(Integer.toString(paramInt)));
          if (!((File)localObject2).exists()) {
            break label101;
          }
          ThreadManager.excute(new ProfileCardManager.1(this, (File)localObject2, paramInt), 64, null, true);
        }
        for (;;)
        {
          return locala;
          label101:
          if ((paramBoolean) && (this.mApp != null) && (!this.M.contains(Integer.valueOf(paramInt))))
          {
            localObject2 = (VasQuickUpdateManager)this.mApp.getManager(184);
            this.M.add(Integer.valueOf(paramInt));
            ((VasQuickUpdateManager)localObject2).downloadItem(33L, "profileitem." + paramInt, "ProfileCardRes");
          }
        }
      }
    }
    finally {}
  }
  
  public void aO(long paramLong, int paramInt)
  {
    this.y.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void av(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardManager", 2, "downloadProfileCardRes scid=" + paramString);
    }
    if ((this.Q.containsKey(paramString)) && (((Boolean)this.Q.get(paramString)).booleanValue())) {
      return;
    }
    this.Q.put(paramString, Boolean.valueOf(true));
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).downloadItem(15L, paramString, "ProfileCardRes");
  }
  
  public void cancelDownload(long paramLong)
  {
    ((VasQuickUpdateManager)this.mApp.getManager(184)).cancelDwonloadItem(15L, "card." + paramLong);
  }
  
  public boolean i(Context paramContext, long paramLong)
  {
    return VasQuickUpdateEngine.safeDeleteFile(new File(e(paramContext, paramLong)));
  }
  
  public void l(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    this.Q.put(paramString1, Boolean.valueOf(false));
    if (paramInt == 0)
    {
      l = Long.parseLong(paramString1.substring("card.".length(), paramString1.length()));
      ms.put(Long.valueOf(l), Boolean.valueOf(true));
      mt.put(Long.valueOf(l), Boolean.valueOf(true));
      paramString1 = e(paramQQAppInterface.getApp(), l);
      paramQQAppInterface = new File(f(paramQQAppInterface.getApp(), l));
      if (!paramQQAppInterface.exists()) {
        QLog.e("ProfileCardManager", 1, "unzip file is missing " + paramQQAppInterface.getAbsolutePath());
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        return;
        try
        {
          aqhq.W(paramQQAppInterface.getAbsolutePath(), paramString1, false);
          VasQuickUpdateEngine.safeDeleteFile(paramQQAppInterface);
          paramString2 = new File(paramString1, "dynamic.zip");
          if (paramString2.exists())
          {
            String str = paramString1 + ".dynamic";
            aqhq.W(paramString2.getAbsolutePath(), str, false);
            VasQuickUpdateEngine.safeDeleteFile(paramString2);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("ProfileCardManager", 2, "onDownloadComplete, resDir= " + paramString1);
            return;
          }
        }
        catch (OutOfMemoryError paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
        catch (Throwable paramString2)
        {
          for (;;)
          {
            QLog.e("ProfileCardManager", 1, "failed to unzip " + paramQQAppInterface.getAbsolutePath(), paramString2);
          }
        }
      }
    }
    QLog.d("ProfileCardManager", 2, "onDownloadComplete failed, errorCode = " + paramInt);
  }
  
  public class a
  {
    public String bVo;
    public String coverUrl;
    public int id;
    public boolean isInited;
    public String name;
    public String previewUrl;
    
    public a(int paramInt)
    {
      this.id = paramInt;
      this.name = "";
      this.isInited = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alco
 * JD-Core Version:    0.7.0.1
 */