import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.1;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.2;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.3;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.4;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.5;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo.6;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import mqq.os.MqqHandler;

public class alyr
  extends alyt
{
  public alyr(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, alyr.e parame, boolean paramBoolean, int paramInt, String paramString)
  {
    parame.isForward = paramBoolean;
    if (paramBoolean)
    {
      if (paramInt == 0) {
        parame.dAy = 0;
      }
    }
    else {
      return;
    }
    if (paramInt == 3000)
    {
      parame.dAy = 3000;
      return;
    }
    if (paramInt == 1)
    {
      switch (paramQQAppInterface.cs(paramString))
      {
      default: 
        parame.dAy = 1;
      }
      for (;;)
      {
        parame.dAz = 0;
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.c(paramString);
        if (paramQQAppInterface == null) {
          break;
        }
        parame.dAz = paramQQAppInterface.wMemberNum;
        return;
        parame.dAy = 1;
        continue;
        parame.dAy = 3;
        continue;
        parame.dAy = 4;
        continue;
        parame.dAy = 2;
      }
    }
    parame.dAy = 9999;
  }
  
  private boolean a(alyr.e parame, String paramString)
  {
    Object localObject2 = new File(paramString);
    Object localObject1 = ahbj.getFileDirectoryOf(paramString);
    paramString = (String)localObject1;
    if (localObject1 != null) {
      paramString = ((String)localObject1).toLowerCase(Locale.US);
    }
    localObject1 = null;
    try
    {
      localObject2 = ((File)localObject2).getParentFile().getName().toLowerCase(Locale.US);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label50:
      break label50;
    }
    if ((paramString == null) || (localObject1 == null)) {
      return false;
    }
    if (paramString.contains("/tencent/")) {
      if (paramString.contains("/mobileqq/shortvideo/")) {
        parame.dAA = 1002;
      }
    }
    for (;;)
    {
      return true;
      if (paramString.contains("/qq_collection/"))
      {
        parame.dAA = 1001;
      }
      else if (paramString.contains("/qqfile_recv/"))
      {
        parame.dAA = 1003;
      }
      else if ((paramString.contains("/weixin/")) || (paramString.contains("/wechat/")) || (paramString.contains("/micromsg/")))
      {
        parame.dAA = 1004;
      }
      else if (zsz.it(paramString))
      {
        parame.dAA = 1005;
      }
      else
      {
        parame.dAA = 1006;
        continue;
        if (paramString.equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator)) {
          parame.dAA = 1002;
        } else if ((((String)localObject1).contains("camera")) || (((String)localObject1).equals("dcim")) || (((String)localObject1).equals("100MEDIA")) || (((String)localObject1).equals("100ANDRO")) || (((String)localObject1).contains(acfp.m(2131704704))) || (((String)localObject1).contains(acfp.m(2131704703))) || (((String)localObject1).contains(acfp.m(2131704705)))) {
          parame.dAA = 1007;
        } else if (zsz.it(paramString)) {
          parame.dAA = 1005;
        } else {
          parame.dAA = 1006;
        }
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.3(this, paramAppInterface, paramInt1, paramInt3, paramString, paramInt2, paramLong));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.4(this, paramAppInterface, paramInt1, paramInt2, paramString));
    }
  }
  
  public void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, alyr.c paramc)
  {
    paramc.dAw = paramInt1;
    if (paramInt2 == 0) {
      paramc.uinType = 0;
    }
    for (;;)
    {
      paramAppInterface = (ajpj)paramAppInterface.getManager(106);
      if (paramAppInterface != null)
      {
        paramc.age = paramAppInterface.Gz();
        paramc.gender = paramAppInterface.GA();
      }
      paramc.dAx = Calendar.getInstance().get(11);
      paramc.netType = aqiw.getSystemNetwork(BaseApplication.getContext());
      return;
      if (paramInt2 == 3000)
      {
        paramc.uinType = 3000;
      }
      else
      {
        if (paramInt2 == 1)
        {
          if ((paramAppInterface instanceof QQAppInterface)) {
            switch (((QQAppInterface)paramAppInterface).cs(paramString))
            {
            default: 
              paramc.uinType = 1;
            }
          }
          for (;;)
          {
            paramc.dAv = 0;
            TroopManager localTroopManager = (TroopManager)paramAppInterface.getManager(52);
            if (localTroopManager == null) {
              break;
            }
            paramString = localTroopManager.c(paramString);
            if (paramString == null) {
              break;
            }
            paramc.dAv = paramString.wMemberNum;
            break;
            paramc.uinType = 1;
            continue;
            paramc.uinType = 3;
            continue;
            paramc.uinType = 4;
            continue;
            paramc.uinType = 2;
            continue;
            paramc.uinType = 1;
          }
        }
        paramc.uinType = 9999;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramQQAppInterface != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.2(this, paramQQAppInterface, paramInt1, paramInt2, paramString, paramInt3));
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString3, long paramLong, String paramString4)
  {
    if ((paramQQAppInterface != null) && (paramString1 != null) && ((paramInt1 == 2001) || (paramInt1 == 2002) || (paramInt1 == 2003))) {
      ThreadManager.getSubThreadHandler().post(new DCShortVideo.1(this, paramString1, paramQQAppInterface, paramInt1, paramInt2, paramString2, paramLong, paramString4, paramBoolean1, paramInt3, paramString3, paramBoolean2));
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.6(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt7, paramInt8, paramLong));
  }
  
  public void bQ(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new DCShortVideo.5(this, paramInt, paramBoolean));
  }
  
  public static class a
    extends alyr.c
  {
    public long aif = -1L;
    public long duration = 0L;
    
    public HashMap<String, String> v(String paramString)
    {
      if ("ShortVideo.FullscreenPreview".equals(paramString))
      {
        paramString = new HashMap();
        paramString.put("param_uinType", this.uinType + "");
        paramString.put("param_GroupMemberCount", this.dAv + "");
        paramString.put("param_age", this.age + "");
        paramString.put("param_gender", this.gender + "");
        paramString.put("param_shortVideoType", this.dAw + "");
        paramString.put("param_duration", this.duration + "");
        paramString.put("param_reportHour", this.dAx + "");
        paramString.put("param_netType", this.netType + "");
        paramString.put("param_playTimeCost", this.aif + "");
        return paramString;
      }
      return null;
    }
  }
  
  public static class b
    extends alyr.c
  {
    public int dAu = -1;
    
    public HashMap<String, String> v(String paramString)
    {
      if ("ShortVideo.Preview".equals(paramString))
      {
        paramString = new HashMap();
        paramString.put("param_uinType", this.uinType + "");
        paramString.put("param_GroupMemberCount", this.dAv + "");
        paramString.put("param_age", this.age + "");
        paramString.put("param_gender", this.gender + "");
        paramString.put("param_shortVideoType", this.dAw + "");
        paramString.put("param_reportHour", this.dAx + "");
        paramString.put("param_netType", this.netType + "");
        paramString.put("param_playAction", this.dAu + "");
        return paramString;
      }
      return null;
    }
  }
  
  public static abstract class c
    extends alys
  {
    public int age = -1;
    public int dAv;
    public int dAw = -1;
    public int dAx = -1;
    public int gender = -1;
    public int netType = -1;
    public int uinType = -1;
  }
  
  public static class d
    extends alyr.c
  {
    public HashMap<String, String> v(String paramString)
    {
      if ("ShortVideo.Save".equals(paramString))
      {
        paramString = new HashMap();
        paramString.put("param_uinType", this.uinType + "");
        paramString.put("param_GroupMemberCount", this.dAv + "");
        paramString.put("param_age", this.age + "");
        paramString.put("param_gender", this.gender + "");
        paramString.put("param_shortVideoType", this.dAw + "");
        paramString.put("param_reportHour", this.dAx + "");
        paramString.put("param_netType", this.netType + "");
        return paramString;
      }
      return null;
    }
  }
  
  public static class e
    extends alyr.c
  {
    public String bZD = "";
    public int dAA = -1;
    public int dAB = -1;
    public int dAy = -1;
    public int dAz;
    public long duration = 0L;
    public long fileSize = 0L;
    public boolean isExist = false;
    public boolean isForward = false;
    public String md5 = "";
    public int status = -1;
    public int userType = 1001;
    
    public HashMap<String, String> v(String paramString)
    {
      if ("ShortVideo.Send".equals(paramString))
      {
        paramString = new HashMap();
        paramString.put("param_DetailUrl", this.bZD);
        paramString.put("param_uinType", this.uinType + "");
        paramString.put("param_GroupMemberCount", this.dAv + "");
        paramString.put("param_isForward", this.isForward + "");
        paramString.put("param_isExist", this.isExist + "");
        paramString.put("param_forwardSourceUinType", this.dAy + "");
        paramString.put("param_forwardSourceGroupMemberCount", this.dAz + "");
        paramString.put("param_age", this.age + "");
        paramString.put("param_gender", this.gender + "");
        paramString.put("param_userType", this.userType + "");
        paramString.put("param_shortVideoType", this.dAw + "");
        paramString.put("param_shortVideoSourceType", this.dAA + "");
        paramString.put("param_reportHour", this.dAx + "");
        paramString.put("param_fileInterval", this.dAB + "");
        paramString.put("param_netType", this.netType + "");
        paramString.put("param_md5", this.md5);
        paramString.put("param_fileSize", this.fileSize + "");
        paramString.put("param_duration", this.duration + "");
        paramString.put("param_status", this.status + "");
        return paramString;
      }
      return null;
    }
  }
  
  public static class f
    extends alys
  {
    public long aif;
    public int dAC;
    public int dAD;
    public int dAE;
    public int dAF;
    public int dAG;
    public int durationTime;
    public int fileSize;
    public boolean supportProgressive;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("supportProgressive ").append(this.supportProgressive);
      localStringBuilder.append("playReadyTime ").append(this.dAC);
      localStringBuilder.append("exitPlayProgress ").append(this.dAD);
      localStringBuilder.append("exitCacheProgress ").append(this.dAE);
      localStringBuilder.append("durationTime ").append(this.durationTime);
      localStringBuilder.append("fileSize ").append(this.fileSize);
      localStringBuilder.append("seekTimes ").append(this.dAF);
      localStringBuilder.append("playResult ").append(this.dAG);
      localStringBuilder.append("playTimeCost").append(this.aif);
      return localStringBuilder.toString();
    }
    
    public HashMap<String, String> v(String paramString)
    {
      if ("actStreamingVideoPlay".equalsIgnoreCase(paramString))
      {
        paramString = new HashMap();
        paramString.put("StreamingVideoSupport", String.valueOf(this.supportProgressive));
        paramString.put("FirstBufferTime", String.valueOf(this.dAC));
        paramString.put("PlayProgress", String.valueOf(this.dAD));
        paramString.put("LoadProgress", String.valueOf(this.dAE));
        paramString.put("FileDuration", String.valueOf(this.durationTime));
        paramString.put("FileLen", String.valueOf(this.fileSize));
        paramString.put("param_seekTimes", String.valueOf(this.dAF));
        paramString.put("PlayResult", String.valueOf(this.dAG));
        paramString.put("param_playTimeCost", String.valueOf(this.aif));
        return paramString;
      }
      return null;
    }
  }
  
  public static class g
    extends alys
  {
    public boolean cBu = false;
    public int dAH = 0;
    
    public HashMap<String, String> v(String paramString)
    {
      if ("RealShortVideo.Record".equals(paramString))
      {
        paramString = new HashMap();
        paramString.put("param_cameraID", String.valueOf(this.dAH));
        paramString.put("param_hasMultiSegments", String.valueOf(this.cBu));
        return paramString;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyr
 * JD-Core Version:    0.7.0.1
 */