import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SecSharedInfo.FileInfo;
import com.tencent.ims.SecSharedInfo.SendInfo;
import com.tencent.ims.SecSharedInfo.SharedInfoPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqp.app.sec.SecShareInfoUtil.1;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

public class arnv
{
  private static arnv a;
  private ConcurrentLinkedQueue<arnv.a> P = new ConcurrentLinkedQueue();
  private String cBd;
  
  private long a(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {}
    do
    {
      do
      {
        return 0L;
        if (!TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SecShare.AV", 2, "Path is empty.");
      return 0L;
      try
      {
        long l = new File(paramPackageInfo.applicationInfo.sourceDir).length();
        return l;
      }
      catch (Exception paramPackageInfo) {}
    } while (!QLog.isColorLevel());
    QLog.d("SecShare.AV", 2, "Read file failed.");
    return 0L;
  }
  
  private PackageInfo a(String paramString)
  {
    try
    {
      paramString = BaseApplication.getContext().getPackageManager().getPackageInfo(paramString, 192);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static arnv a()
  {
    try
    {
      if (a == null) {
        a = new arnv();
      }
      arnv localarnv = a;
      return localarnv;
    }
    finally {}
  }
  
  public static String b(PackageInfo paramPackageInfo)
  {
    try
    {
      PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
      paramPackageInfo = paramPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
      return paramPackageInfo;
    }
    catch (Exception paramPackageInfo)
    {
      paramPackageInfo.printStackTrace();
    }
    return "";
  }
  
  private String c(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return "f0";
    }
    if (paramPackageInfo.signatures == null) {
      return "f1";
    }
    if (paramPackageInfo.signatures[0] == null) {
      return "f2";
    }
    paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
    if (paramPackageInfo == null) {
      return "f3";
    }
    if (paramPackageInfo.length == 0) {
      return "f4";
    }
    return aszr.getMD5String(paramPackageInfo);
  }
  
  private void doReport()
  {
    QQAppInterface localQQAppInterface;
    SecSharedInfo.SharedInfoPacket localSharedInfoPacket;
    SecSharedInfo.SendInfo localSendInfo;
    int i;
    Object localObject3;
    String str3;
    try
    {
      localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localQQAppInterface == null) {
        return;
      }
      localSharedInfoPacket = new SecSharedInfo.SharedInfoPacket();
      localSharedInfoPacket.version.set(1);
      localSharedInfoPacket.type.set(1);
      localSharedInfoPacket.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      localSharedInfoPacket.uint32_appid.set(AppSetting.getAppId());
      localSharedInfoPacket.str_sysversion.set(Build.VERSION.RELEASE);
      localSharedInfoPacket.str_brand.set(Build.BRAND);
      localSharedInfoPacket.str_model.set(Build.MODEL);
      localSharedInfoPacket.qq_version.set(fu("3.4.4"));
      if (QLog.isColorLevel()) {
        QLog.d("SecShare.AV", 2, String.format("Version = %s intVersion= 0x%x", new Object[] { "3.4.4", Integer.valueOf(fu("3.4.4")) }));
      }
      if (this.P.isEmpty()) {
        break label557;
      }
      localSendInfo = new SecSharedInfo.SendInfo();
      localObject1 = (arnv.a)this.P.poll();
      i = ((arnv.a)localObject1).getType();
      localObject3 = ((arnv.a)localObject1).getUri();
      str3 = ((arnv.a)localObject1).Da();
      j = ((arnv.a)localObject1).Nb();
      localSendInfo.type.set(i);
      if (!QLog.isColorLevel()) {
        break label767;
      }
      QLog.d("SecShare.AV", 2, String.format("Type = %d", new Object[] { Integer.valueOf(i) }));
    }
    catch (Exception localException)
    {
      Object localObject1;
      int j;
      label248:
      if (!QLog.isColorLevel()) {
        break label449;
      }
      label281:
      label343:
      QLog.d("SecShare.AV", 2, "Do sso exception.");
      label449:
      ekD();
      return;
    }
    localSendInfo.url.set((String)localObject3);
    localObject1 = getFileMd5((String)localObject3);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localSendInfo.md5.set((String)localObject1);
    }
    String str1 = localQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(str1)) {
      localSendInfo.src_uin.set(str1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label780;
      }
      localObject1 = "null";
    }
    for (;;)
    {
      String str2;
      if (localSendInfo.md5.get() == null)
      {
        str2 = "null";
        QLog.d("SecShare.AV", 2, String.format("type = %d uri = %s uin = %s dest_uin = %s uin_type = 0x%x file_hash = %s", new Object[] { Integer.valueOf(i), localObject1, localObject3, str1, Integer.valueOf(j), str2 }));
        if (!TextUtils.isEmpty(str3))
        {
          localSendInfo.des_uin.set(str3);
          localSendInfo.des_type.set(j);
        }
        localSharedInfoPacket.send_info.add(localSendInfo);
        break;
      }
      label557:
      label748:
      label767:
      do
      {
        Object localObject2;
        if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject2 = atad.toMD5((String)localObject3);
          localSendInfo.md5.set((String)localObject2);
          break label281;
        }
        if ((i == 2) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject2 = atad.toMD5((String)localObject3);
          localSendInfo.md5.set((String)localObject2);
          localSendInfo.url.set((String)localObject3);
          break label281;
        }
        if (i != 5) {
          break label281;
        }
        localSendInfo.url.set((String)localObject3);
        break label281;
        str2 = localSendInfo.md5.get();
        break label343;
        if (QLog.isColorLevel())
        {
          if (TextUtils.isEmpty(this.cBd)) {
            break label748;
          }
          QLog.d("SecShare.AV", 2, String.format("Act ref = %s", new Object[] { this.cBd }));
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.cBd))
          {
            localObject2 = a(this.cBd);
            if (localObject2 != null)
            {
              localSharedInfoPacket.file_info.setHasFlag(true);
              localSharedInfoPacket.file_info.package_name.set(this.cBd);
              localSharedInfoPacket.file_info.soft_name.set(b((PackageInfo)localObject2));
              localSharedInfoPacket.file_info.cert_md5.set(c((PackageInfo)localObject2));
              localSharedInfoPacket.file_info.apk_filesize.set((int)a((PackageInfo)localObject2));
            }
          }
          localObject2 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), "ShareRiskSvc.SecReport");
          if (localObject2 == null) {
            break;
          }
          ((ToServiceMsg)localObject2).putWupBuffer(localSharedInfoPacket.toByteArray());
          ((ToServiceMsg)localObject2).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject2).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject2);
          break;
          QLog.d("SecShare.AV", 2, String.format("Act ref = NullorEmpty", new Object[0]));
        }
        if (i == 3) {
          break;
        }
      } while (i != 4);
      break label248;
      label780:
      localObject3 = str1;
      if (str1 == null) {
        localObject3 = "null";
      }
      if (str3 == null) {
        str1 = "null";
      } else {
        str1 = str3;
      }
    }
  }
  
  private void ekD()
  {
    if (this.cBd != null) {
      this.cBd = null;
    }
  }
  
  private int fu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split("[.]");
    } while ((paramString == null) || ((paramString.length != 3) && (paramString.length != 4)));
    j = 0;
    int i = 0;
    try
    {
      while (j < paramString.length)
      {
        k = Integer.parseInt(paramString[j]);
        j += 1;
        i = k & 0xFF | i << 8;
      }
      int k = paramString.length;
      j = i;
      if (3 == k) {
        j = i << 8;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        j = 0;
      }
    }
    return j;
  }
  
  private String getFileMd5(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        if (!localFile.canRead()) {
          return "";
        }
        if (localFile.length() >= 125829120L) {
          return "toolarge";
        }
        paramString = auqr.getFileMd5(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public boolean aGW()
  {
    return !TextUtils.isEmpty(this.cBd);
  }
  
  public void j(Object paramObject, String paramString)
  {
    if ((paramObject != null) && ((paramObject instanceof Activity)) && (Build.VERSION.SDK_INT >= 22)) {}
    do
    {
      for (;;)
      {
        try
        {
          Field localField = Activity.class.getDeclaredField("mReferrer");
          localField.setAccessible(true);
          paramObject = (String)localField.get(paramObject);
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          this.cBd = paramString;
          return;
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("SecShare.AV", 2, "Get ACT Ref failed.");
            QLog.d("SecShare.AV", 2, Log.getStackTraceString(paramObject));
          }
        }
        paramObject = "";
      }
    } while (TextUtils.isEmpty(paramObject));
    this.cBd = paramObject;
  }
  
  public void n(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.P.offer(new arnv.a(paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void report()
  {
    ThreadManager.post(new SecShareInfoUtil.1(this), 5, null, true);
  }
  
  public static class a
  {
    private String cBe;
    private int ekA;
    private int type;
    private String uri;
    
    public a() {}
    
    public a(int paramInt1, String paramString1, int paramInt2, String paramString2)
    {
      this.uri = paramString1;
      this.type = paramInt1;
      this.ekA = paramInt2;
      this.cBe = paramString2;
    }
    
    public String Da()
    {
      return this.cBe;
    }
    
    public int Nb()
    {
      return this.ekA;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public String getUri()
    {
      return this.uri;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnv
 * JD-Core Version:    0.7.0.1
 */