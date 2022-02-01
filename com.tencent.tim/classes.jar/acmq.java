import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class acmq
{
  private static acmq a;
  private boolean bJu;
  private boolean bJv;
  private boolean bJw;
  private int configId = -2;
  private Context mContext = BaseApplicationImpl.getContext();
  
  private void N(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 7)
    {
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("mobileQQ", 4);
      boolean bool1 = localSharedPreferences.getBoolean("enableUpdateIconStep", false);
      boolean bool2 = "1".equals(paramArrayOfString[7]);
      if (bool1 != bool2) {
        localSharedPreferences.edit().putBoolean("enableUpdateIconStep", bool2).commit();
      }
    }
  }
  
  private void O(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length > 6)
    {
      if ("1".equals(paramArrayOfString[6])) {
        com.tencent.common.config.AppSetting.aNS = true;
      }
    }
    else {
      return;
    }
    com.tencent.common.config.AppSetting.aNS = false;
  }
  
  private void P(String[] paramArrayOfString)
    throws IOException
  {
    File localFile;
    if (paramArrayOfString.length > 5)
    {
      localFile = new File(this.mContext.getFilesDir(), "disableSmallLock");
      if (!"1".equals(paramArrayOfString[5])) {
        break label47;
      }
      if (localFile.exists()) {
        localFile.delete();
      }
    }
    return;
    label47:
    localFile.createNewFile();
  }
  
  public static acmq a()
  {
    try
    {
      if (a == null) {
        a = new acmq();
      }
      acmq localacmq = a;
      return localacmq;
    }
    finally {}
  }
  
  private void a(DeviceProfileManager paramDeviceProfileManager, String[] paramArrayOfString)
  {
    float f = Float.parseFloat(paramArrayOfString[1]);
    if (paramDeviceProfileManager.cuV * 1.0F / 10000.0F < f)
    {
      this.configId = Integer.valueOf(paramArrayOfString[0]).intValue();
      this.bJu = "1".equals(paramArrayOfString[2]);
      this.bJv = "1".equals(paramArrayOfString[3]);
      this.bJw = "1".equals(paramArrayOfString[4]);
      return;
    }
    this.configId = 0;
  }
  
  private void cMD()
  {
    if ((this.bJv) || (this.bJw)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = Thread.currentThread().getThreadGroup();
        Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject).activeCount()];
        ((ThreadGroup)localObject).enumerate(arrayOfThread);
        int j = arrayOfThread.length;
        i = 0;
        if (i < j)
        {
          Thread localThread = arrayOfThread[i];
          if (localThread == null) {
            break label216;
          }
          if (localThread.getName() == null) {
            break label223;
          }
          localObject = localThread.getName();
          if ((this.bJv) && ("MSF-Receiver".equals(localObject))) {
            localThread.setPriority(1);
          } else if ((this.bJw) && (("logWriteThread".equals(localObject)) || (((String)localObject).startsWith("GlobalPool")) || (((String)localObject).startsWith("Face")) || (((String)localObject).startsWith("um-stack")) || (((String)localObject).startsWith("QQ_FTS")) || (((String)localObject).startsWith("httpcomm")))) {
            localThread.setPriority(1);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThreadManager.Optimizer", 2, "", localException);
        }
        if (this.bJw)
        {
          ThreadManager.getSubThread().setPriority(1);
          ThreadManager.getFileThread().setPriority(1);
          ThreadManager.getRecentThreadLooper().getThread().setPriority(1);
        }
      }
      return;
      label216:
      i += 1;
      continue;
      label223:
      String str = "";
    }
  }
  
  public int AZ()
  {
    return this.configId;
  }
  
  public void a(DeviceProfileManager paramDeviceProfileManager)
  {
    Object localObject = paramDeviceProfileManager.jf(DeviceProfileManager.DpcNames.qq_thread_config.name());
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager.Optimizer", 2, "config = " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      return;
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {
          continue;
        }
        a(paramDeviceProfileManager, (String[])localObject);
        P((String[])localObject);
        O((String[])localObject);
        N((String[])localObject);
        cMD();
        return;
      }
      catch (Exception paramDeviceProfileManager)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThreadManager.Optimizer", 2, "", paramDeviceProfileManager);
          }
        }
      }
    }
  }
  
  public boolean abG()
  {
    return this.bJu;
  }
  
  public boolean abH()
  {
    return this.bJv;
  }
  
  public boolean abI()
  {
    return this.bJw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acmq
 * JD-Core Version:    0.7.0.1
 */