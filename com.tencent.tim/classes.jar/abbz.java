import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class abbz
  extends ackl
  implements afip
{
  private HandlerThread A;
  private Bundle ar;
  private Bundle as;
  private volatile int cnC;
  private final int cnD = 1;
  private final int cnE = 90000;
  private Handler cq;
  
  public abbz()
  {
    ThreadManager.post(new VipSpecialCareHandler.1(this), 8, null, true);
  }
  
  private final void GT(int paramInt)
  {
    int i = this.cnC - 1;
    this.cnC = i;
    if (i != 0)
    {
      log("-->warning:special care set,uncorrect state,seq=" + this.cnC);
      this.cnC = 0;
    }
    try
    {
      Bundle localBundle = this.as;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      localBundle.putInt("error", i);
      this.ar.putBundle("response", this.as);
      bS(this.ar);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareHandler", 2, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.cnC != 0)
    {
      log("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      bS(paramBundle1);
      return;
    }
    this.cnC += 1;
    log("-->do request,seq=" + this.cnC);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        b(paramBundle1, paramBundle2);
        if ((!"sepcial_care_delete_ring".equals(paramString)) && (!"special_care_set_ring".equals(paramString))) {
          break;
        }
        paramBundle1 = paramBundle1.getBundle("request");
        int i = paramBundle1.getInt("id", 1);
        paramBundle2 = paramBundle1.getString("uin");
        paramBundle1 = paramBundle2;
        if (paramBundle2 == null) {
          paramBundle1 = "";
        }
        paramBundle2 = new ArrayList();
        paramBundle2.add(paramBundle1);
        localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(i));
        if (this.cq != null) {
          this.cq.sendEmptyMessageDelayed(1, 90000L);
        }
        if (!"special_care_set_ring".equals(paramString)) {
          break label288;
        }
        if (i == 1)
        {
          abbf.a(paramBundle2, 2, localArrayList, paramQQAppInterface);
          paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          paramString = "specialcare_already_set" + paramBundle1;
          paramQQAppInterface.edit().putBoolean(paramString, true).commit();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        this.cnC = 0;
        return;
      }
      abbf.a(paramBundle2, 3, localArrayList, paramQQAppInterface);
    }
    label288:
    abbf.a(paramBundle2, 4, localArrayList, paramQQAppInterface);
  }
  
  public void aO(Object paramObject)
  {
    int i = -1;
    if (paramObject != null)
    {
      i = ((Integer)paramObject).intValue();
      if (i != 10010) {
        break label48;
      }
      log("-->error:set quota limit");
    }
    for (;;)
    {
      if (this.cq != null) {
        this.cq.removeMessages(1);
      }
      GT(i);
      return;
      label48:
      log("-->error:" + i);
    }
  }
  
  public void ax(Object paramObject)
  {
    if (paramObject != null) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    for (;;)
    {
      if (this.cq != null) {
        this.cq.removeMessages(1);
      }
      GT(0);
      return;
      log("-->method_type_open_switch");
      continue;
      log("-->method_type_set_sound");
      continue;
      log("-->method_type_delete_sound");
    }
  }
  
  public final void b(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.ar = paramBundle1;
    this.as = paramBundle2;
  }
  
  public void bS(Bundle paramBundle) {}
  
  public void destroy()
  {
    if (this.cq != null) {
      this.cq.removeMessages(1);
    }
    if (this.A != null) {
      this.A.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbz
 * JD-Core Version:    0.7.0.1
 */