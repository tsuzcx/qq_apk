import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController.1;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;

public class anqs
{
  private static anqs jdField_a_of_type_Anqs;
  private aeiq.a jdField_a_of_type_Aeiq$a;
  public boolean cJC;
  private boolean cJD;
  @Deprecated
  public boolean cJE;
  
  private anqs()
  {
    ThreadManager.executeOnSubThread(new AIOVideoPlayController.1(this));
  }
  
  public static anqs a()
  {
    if (jdField_a_of_type_Anqs == null) {}
    try
    {
      if (jdField_a_of_type_Anqs == null) {
        jdField_a_of_type_Anqs = new anqs();
      }
      return jdField_a_of_type_Anqs;
    }
    finally {}
  }
  
  private boolean ayQ()
  {
    if (this.jdField_a_of_type_Aeiq$a != null) {
      return this.jdField_a_of_type_Aeiq$a.bUd;
    }
    return false;
  }
  
  private boolean ayR()
  {
    if (this.jdField_a_of_type_Aeiq$a != null) {
      return this.jdField_a_of_type_Aeiq$a.bUe;
    }
    return false;
  }
  
  private boolean ayS()
  {
    if (this.jdField_a_of_type_Aeiq$a != null) {
      return this.jdField_a_of_type_Aeiq$a.bUf;
    }
    return false;
  }
  
  private boolean ayT()
  {
    if (this.jdField_a_of_type_Aeiq$a != null) {
      return this.jdField_a_of_type_Aeiq$a.bUg;
    }
    return false;
  }
  
  public boolean ayP()
  {
    Object localObject;
    if (!this.cJC)
    {
      localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_gifplay.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): parseConfig, aio_gifplay =" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 8) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(localObject[7]) != 0) {
          continue;
        }
        this.cJD = false;
        if (Integer.parseInt(localObject[9]) != 0) {
          continue;
        }
        this.cJE = false;
      }
      catch (Exception localException)
      {
        this.cJC = false;
        continue;
        this.cJE = true;
        continue;
      }
      this.cJC = true;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "isAllowDPC(): mDPCAllow =" + this.cJD + ", mEnbleAutoPlayInNotPAAIO = " + this.cJE);
      }
      return this.cJD;
      this.cJD = true;
    }
  }
  
  public void b(aeiq.a parama)
  {
    this.jdField_a_of_type_Aeiq$a = parama;
  }
  
  public void b(View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare) {}
  
  public boolean d(Context paramContext, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (ayP())
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null) {
        return false;
      }
      if (paramInt1 == 3)
      {
        if ((!NetworkUtils.isWifiConnected(paramContext)) || (!awit.cE(localQQAppInterface))) {
          break label169;
        }
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoPlayController", 2, "allowAutoPlay(): playType=" + paramInt1 + ", uinType = " + paramInt2 + ", result = " + bool + ", mDPCAllow = " + this.cJD);
      }
      return bool;
      if (paramInt1 == 1)
      {
        if (paramInt2 == 1) {
          bool = ayQ();
        } else {
          bool = ayR();
        }
      }
      else if (paramInt1 == 2)
      {
        if (paramInt2 == 1) {
          bool = ayS();
        } else {
          bool = ayT();
        }
      }
      else {
        label169:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqs
 * JD-Core Version:    0.7.0.1
 */