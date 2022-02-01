import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController.1;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDefaultSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class adaq
{
  private static adaq jdField_a_of_type_Adaq = new adaq();
  private ArEffectConfig jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  private boolean ajI = true;
  private boolean bKJ = true;
  private boolean bKK = true;
  private boolean bKL = true;
  private boolean bKM;
  private boolean bKN;
  private String bry;
  private int cBs = 1;
  private int cBt;
  private int cBu;
  private boolean isInBlackList;
  private boolean isInited;
  private String model = jJ(Build.MODEL);
  private int trackQuality = 5;
  
  private adaq()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
    this.bry = ((SharedPreferences)localObject1).getString("gpu_renderer", null);
    if (!TextUtils.isEmpty(this.bry)) {
      this.bry = jJ(this.bry);
    }
    this.cBt = ((SharedPreferences)localObject1).getInt("ar_incompatible_reason", 0);
    this.cBu = ((SharedPreferences)localObject1).getInt("ar_load_so_crash_time", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString("ar_load_so_crash_version", "");
    if (!AppSetting.getVersion().equals(localObject2))
    {
      localObject2 = ((SharedPreferences)localObject1).edit();
      ((SharedPreferences.Editor)localObject2).putInt("ar_load_so_crash_time", 0);
      aqmj.b((SharedPreferences.Editor)localObject2);
      this.cBu = 0;
    }
    int i = ((SharedPreferences)localObject1).getInt("ar_native_so_crash_version", 0);
    if (((SharedPreferences)localObject1).getInt("ar_native_so_version", 0) != i)
    {
      ((SharedPreferences)localObject1).edit().putInt("ar_load_so_crash_time", 0).commit();
      this.cBu = 0;
    }
    try
    {
      localObject1 = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getDeviceConfigurationInfo();
      if (localObject1 == null) {
        break label249;
      }
      if (((ConfigurationInfo)localObject1).reqGlEsVersion < 131072) {
        break label290;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      try
      {
        if ((!"000000000000000".equalsIgnoreCase(alla.a((TelephonyManager)BaseApplicationImpl.getApplication().getSystemService("phone")))) || (!Build.FINGERPRINT.startsWith("generic"))) {
          break label303;
        }
        for (boolean bool = true;; bool = false)
        {
          this.bKM = bool;
          return;
          bool = false;
          break;
          localException = localException;
          localException.printStackTrace();
          break label249;
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    this.bKN = bool;
  }
  
  public static adaq a()
  {
    return jdField_a_of_type_Adaq;
  }
  
  private void bd(boolean paramBoolean, int paramInt)
  {
    if ((this.bKL) || (this.cBt != paramInt))
    {
      this.bKL = false;
      ThreadManager.post(new ARDeviceController.1(this, paramInt, paramBoolean), 5, null, true);
    }
    this.cBt = paramInt;
  }
  
  private void cPy()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    int i;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
    {
      this.trackQuality = -1;
      this.cBs = -1;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.ul.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (jJ((String)localIterator.next()).equals(this.model))
          {
            this.trackQuality = 5;
            this.cBs = 1;
            i = 1;
            int j = i;
            if (i == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.un.iterator();
              do
              {
                k = i;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!jJ((String)localIterator.next()).equals(this.model));
              this.isInBlackList = true;
              k = 1;
              j = k;
              if (k == 0)
              {
                this.isInBlackList = false;
                j = k;
              }
            }
            k = j;
            ArDefaultSetting localArDefaultSetting;
            if (j == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.up.iterator();
              do
              {
                k = j;
                if (!localIterator.hasNext()) {
                  break;
                }
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
              } while ((localArDefaultSetting.type != 0) || (!jJ(localArDefaultSetting.key).equals(this.model)));
              this.trackQuality = localArDefaultSetting.cIb;
              this.cBs = localArDefaultSetting.cIa;
              k = 1;
            }
            i = k;
            if (k == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.um.iterator();
              do
              {
                i = k;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!jJ((String)localIterator.next()).equals(this.bry));
              this.trackQuality = 5;
              this.cBs = 1;
              i = 1;
            }
            k = i;
            if (i == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.uo.iterator();
              do
              {
                j = i;
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!jJ((String)localIterator.next()).equals(this.bry));
              this.isInBlackList = true;
              j = 1;
              k = j;
              if (j == 0)
              {
                this.isInBlackList = false;
                k = j;
              }
            }
            if (k == 0)
            {
              localIterator = this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig.up.iterator();
              while (localIterator.hasNext())
              {
                localArDefaultSetting = (ArDefaultSetting)localIterator.next();
                if ((localArDefaultSetting.type == 1) && (jJ(localArDefaultSetting.key).equals(this.bry)))
                {
                  this.trackQuality = localArDefaultSetting.cIb;
                  this.cBs = localArDefaultSetting.cIa;
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.trackQuality >= 1) && (this.trackQuality <= 5) && (this.cBs >= 0) && (this.cBs <= 1))
      {
        this.bKJ = false;
        this.bKK = false;
        this.isInited = true;
        return;
      }
      this.trackQuality = localSharedPreferences.getInt("ar_adjust_track_quality", -1);
      if ((this.trackQuality >= 1) && (this.trackQuality <= 5))
      {
        this.bKJ = false;
        this.cBs = localSharedPreferences.getInt("ar_adjust_render_quality", -1);
        if ((this.cBs < 0) || (this.cBs > 1)) {
          break label610;
        }
      }
      for (this.bKK = false;; this.bKK = true)
      {
        this.isInited = true;
        return;
        this.bKJ = true;
        this.trackQuality = 5;
        break;
        label610:
        this.cBs = 1;
      }
      i = k;
      continue;
      i = 0;
      break;
      i = 0;
    }
  }
  
  private static String jJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (((c >= '0') && (c <= '9')) || ((c >= 'a') && (c <= 'z'))) {
        localStringBuilder.append(c);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void Gn(String paramString)
  {
    if (!TextUtils.isEmpty(this.bry)) {}
    do
    {
      return;
      this.bry = jJ(paramString);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
      localEditor.putString("gpu_renderer", paramString);
      aqmj.b(localEditor);
      Gn(paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null);
    cPy();
  }
  
  public boolean adl()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    for (;;)
    {
      int j;
      try
      {
        if (this.cBu >= 5)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= false,failCode= 870888");
          }
          bd(false, 870888);
          return bool2;
        }
        if (!this.ajI) {
          break label338;
        }
        this.ajI = false;
        this.cBu += 1;
        Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        localEditor.putInt("ar_load_so_crash_time", this.cBu);
        localEditor.putString("ar_load_so_crash_version", AppSetting.getVersion());
        localEditor.putInt("ar_native_so_crash_version", ((SharedPreferences)localObject1).getInt("ar_native_so_version", 0));
        aqmj.b(localEditor);
        j = 1;
        if (this.isInBlackList)
        {
          i = 870882;
          bd(bool1, i);
          if (QLog.isColorLevel()) {
            QLog.d("ARDeviceController", 2, "isAREnable enable= " + bool1 + ",failCode= " + i);
          }
          bool2 = bool1;
          if (j == 0) {
            continue;
          }
          localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
          ((SharedPreferences.Editor)localObject1).putInt("ar_load_so_crash_time", 0);
          aqmj.b((SharedPreferences.Editor)localObject1);
          this.cBu = 0;
          bool2 = bool1;
          continue;
        }
        if (Build.VERSION.SDK_INT >= 14) {
          break label272;
        }
      }
      finally {}
      int i = 870881;
      continue;
      label272:
      if (!this.bKN)
      {
        i = 870883;
      }
      else if (this.bKM)
      {
        i = 870887;
      }
      else if (imm.getCpuArchitecture() < 3)
      {
        i = 870884;
      }
      else
      {
        bool2 = akrf.asG();
        if (!bool2)
        {
          i = 870886;
        }
        else
        {
          bool1 = true;
          i = 0;
          continue;
          label338:
          j = 0;
        }
      }
    }
  }
  
  public boolean adm()
  {
    boolean bool = false;
    int i;
    if (this.cBu >= 5) {
      i = 870888;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARDeviceController", 2, "isSupportAr enable= " + bool + ",errorCode= " + i);
      }
      return bool;
      if (this.isInBlackList)
      {
        i = 870882;
      }
      else if (Build.VERSION.SDK_INT < 14)
      {
        i = 870881;
      }
      else if (!this.bKN)
      {
        i = 870883;
      }
      else if (this.bKM)
      {
        i = 870887;
      }
      else if (imm.getCpuArchitecture() < 3)
      {
        i = 870884;
      }
      else if (!akrf.asG())
      {
        i = 870886;
      }
      else
      {
        i = 0;
        bool = true;
      }
    }
  }
  
  public void b(ArEffectConfig paramArEffectConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramArEffectConfig;
    if (!TextUtils.isEmpty(this.bry)) {
      cPy();
    }
  }
  
  public String sc()
  {
    return this.bry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adaq
 * JD-Core Version:    0.7.0.1
 */