import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class aida
{
  private static boolean cjU;
  private static boolean cjV;
  public static int[] lE = { 3, 7, 9, 5, 10 };
  private static Map<String, aida> lm = new HashMap();
  private static Context mContext;
  private final String TAG = "GroupVideoManager.IVPluginLoader";
  private aidf a;
  private boolean bTu;
  protected BroadcastReceiver bl = new aidb(this);
  private boolean cjT;
  private WeakReference<aidc> dQ;
  private boolean isDownload;
  private String mPluginName;
  private long mStartTime;
  
  private aida(Context paramContext, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    this.mPluginName = paramString;
  }
  
  private void PM(int paramInt)
  {
    rar.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.mStartTime), new String[] { "", "", "", "3.4.4" });
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 2: 
      aids.report("2856626");
      return;
    case 3: 
      aids.report("2856627");
      return;
    case 5: 
      aids.report("2856629");
      return;
    case 6: 
      aids.report("2856630");
      return;
    case 7: 
      aids.report("2856631");
      return;
    }
    aids.report("2856647");
  }
  
  public static aida a(Context paramContext, String paramString)
  {
    aida localaida2 = (aida)lm.get(paramString);
    aida localaida1 = localaida2;
    if (localaida2 == null)
    {
      localaida1 = new aida(paramContext, paramString);
      lm.put(paramString, localaida1);
    }
    return localaida1;
  }
  
  public static boolean aoS()
  {
    if (cjV) {
      return cjU;
    }
    try
    {
      File localFile = new File(mContext.getExternalFilesDir(null).getPath(), "versionchecker.test");
      if (localFile != null)
      {
        cjU = localFile.exists();
        cjV = true;
      }
      return cjU;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, aidc paramaidc)
  {
    if (!this.bTu)
    {
      localObject = new IntentFilter(aidi.lu(this.mPluginName));
      ((IntentFilter)localObject).addAction(aidi.lv(this.mPluginName));
      mContext.registerReceiver(this.bl, (IntentFilter)localObject);
      this.bTu = true;
    }
    this.cjT = TextUtils.equals(paramString5, "slientDownload");
    this.isDownload = TextUtils.equals(paramString5, "download");
    this.dQ = new WeakReference(paramaidc);
    paramaidc = IVPluginInfo.ao();
    Object localObject = (IVPluginInfo)paramaidc.get(this.mPluginName);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      ((IVPluginInfo)localObject).mRoomId = Long.parseLong(paramString3);
      if (!TextUtils.isEmpty(paramString6)) {
        ((IVPluginInfo)localObject).bMK = paramString6;
      }
      ((IVPluginInfo)localObject).bMM = paramString7;
      ((IVPluginInfo)localObject).dcX = paramInt;
      ((IVPluginInfo)localObject).mOpenType = paramString8;
      ((IVPluginInfo)localObject).extra = paramString9;
      if (this.cjT)
      {
        aids.report("2856624");
        this.a = aidf.a(mContext, this.mPluginName, paramString1);
        ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramaidc));
        return;
      }
    }
    catch (NumberFormatException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
        continue;
        if (this.isDownload)
        {
          aids.report("2856625");
          this.mStartTime = SystemClock.elapsedRealtime();
          rar.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "3.4.4" });
        }
      }
    }
  }
  
  public void cancel()
  {
    if (this.a != null) {
      this.a.dsa();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aida
 * JD-Core Version:    0.7.0.1
 */