import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryMonitor.1;
import com.tencent.av.VideoRecoveryMonitor.2;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class ihm
{
  private boolean PA;
  private boolean PB;
  private boolean PC;
  private boolean PD;
  private boolean Pz;
  private long lb;
  private long lc;
  private long ld;
  private VideoAppInterface mApp;
  
  public ihm(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    if (jgu.a().azo == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Pz = bool;
      this.lb = jgu.a().azp;
      QLog.d("VideoRecoveryMonitor", 1, String.format("VideoProcessExitMonitor mRecoveryEnable=%s mRecoveryInterval=%s", new Object[] { Boolean.valueOf(this.Pz), Long.valueOf(this.lb) }));
      return;
    }
  }
  
  private void amm()
  {
    for (;;)
    {
      int j;
      try
      {
        boolean bool1;
        if (this.Pz)
        {
          bool1 = this.PA;
          if (bool1) {}
        }
        else
        {
          return;
        }
        try
        {
          VideoController localVideoController = this.mApp.b();
          iiv localiiv = localVideoController.b();
          str1 = localiiv.peerUin;
          str2 = localiiv.MO;
          i = localiiv.relationType;
          j = localiiv.amI;
          bool1 = localiiv.isFriend;
          bool2 = localiiv.QB;
          bool3 = localiiv.PV;
          l = localVideoController.getChatRoomId(str1);
          if (!QLog.isColorLevel()) {
            break label304;
          }
          QLog.d("VideoRecoveryMonitor", 2, String.format("updateLastCallInfo peerUin=%s displayName=%s businessType=%s relationType=%s sessionType=%s isFriend=%s speakerOn=%s localMute=%s roomId=%s", new Object[] { str1, str2, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Long.valueOf(l) }));
        }
        catch (Throwable localThrowable)
        {
          String str1;
          String str2;
          int i;
          boolean bool2;
          boolean bool3;
          long l;
          QLog.e("VideoRecoveryMonitor", 1, "updateLastCallInfo fail.", localThrowable);
        }
        if (i != 3) {
          continue;
        }
        this.mApp.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putString("last_call_uin", str1).putString("last_call_display_name", str2).putInt("last_call_business_type", 0).putInt("last_call_relation_type", i).putBoolean("last_call_is_friend", bool1).putBoolean("last_call_speaker_on", bool2).putBoolean("last_call_local_mute", bool3).putLong("last_call_room_id", l).apply();
        continue;
        continue;
        if (j == 1) {
          continue;
        }
      }
      finally {}
      label304:
      if (j != 2) {}
    }
  }
  
  private void amn()
  {
    try
    {
      this.mApp.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putLong("last_recovery_time", System.currentTimeMillis()).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "updateLastRecoveryTime fail.", localThrowable);
    }
  }
  
  private void amo()
  {
    try
    {
      QLog.d("VideoRecoveryMonitor", 1, "removeLastCallInfo");
      this.mApp.getApp().getSharedPreferences("last_call_info_sp", 0).edit().remove("last_call_uin").remove("last_call_display_name").remove("last_call_business_type").remove("last_call_relation_type").remove("last_call_is_friend").remove("last_call_speaker_on").remove("last_call_local_mute").remove("last_call_room_id").apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("VideoRecoveryMonitor", 1, "removeLastCallInfo fail.", localThrowable);
    }
  }
  
  private void hU(boolean paramBoolean)
  {
    QLog.d("VideoRecoveryMonitor", 1, String.format("sendKeepProcessAlive keepAlive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 19);
    localNewIntent.putExtra("keepAlive", paramBoolean);
    this.mApp.startServlet(localNewIntent);
    this.mApp.hW(paramBoolean);
    this.PA = paramBoolean;
  }
  
  public void amj()
  {
    if (!this.Pz) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("channelReady mIsRecovering=%s", new Object[] { Boolean.valueOf(this.PB) }));
    if (this.PB)
    {
      ihn.n(true, System.currentTimeMillis() - this.lc);
      this.PB = false;
      this.PC = true;
      this.ld = System.currentTimeMillis();
      Object localObject;
      if (this.PD)
      {
        localObject = this.mApp.b().a;
        if (localObject != null) {
          ((TraeHelper)localObject).axK();
        }
      }
      if (this.mApp != null)
      {
        localObject = this.mApp.b().b();
        this.mApp.h(((iiv)localObject).uinType, ((iiv)localObject).peerUin, ((iiv)localObject).MP);
      }
    }
    hU(true);
    amm();
  }
  
  public void amk()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.1(this));
  }
  
  public void aml()
  {
    ThreadManagerV2.executeOnSubThread(new VideoRecoveryMonitor.2(this));
  }
  
  public void kA(int paramInt)
  {
    if (!this.Pz) {
      return;
    }
    QLog.d("VideoRecoveryMonitor", 1, String.format("videoClose reason=%s", new Object[] { Integer.valueOf(paramInt) }));
    this.PB = false;
    if (this.PC)
    {
      this.PC = false;
      ihn.q(paramInt, System.currentTimeMillis() - this.ld);
    }
    hU(false);
    amo();
  }
  
  public void p(int paramInt, long paramLong)
  {
    if (!this.Pz) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = this.mApp.getApp().getSharedPreferences("last_call_info_sp", 0);
        long l1 = System.currentTimeMillis() - ((SharedPreferences)localObject3).getLong("last_recovery_time", 0L);
        paramLong = System.currentTimeMillis() - paramLong;
        Object localObject1 = ((SharedPreferences)localObject3).getString("last_call_uin", null);
        Object localObject2 = ((SharedPreferences)localObject3).getString("last_call_display_name", null);
        int i = ((SharedPreferences)localObject3).getInt("last_call_business_type", -1);
        int j = ((SharedPreferences)localObject3).getInt("last_call_relation_type", -1);
        boolean bool1 = ((SharedPreferences)localObject3).getBoolean("last_call_is_friend", false);
        boolean bool2 = ((SharedPreferences)localObject3).getBoolean("last_call_speaker_on", false);
        boolean bool3 = ((SharedPreferences)localObject3).getBoolean("last_call_local_mute", false);
        long l2 = ((SharedPreferences)localObject3).getLong("last_call_room_id", -1L);
        long l3 = AudioHelper.hG();
        QLog.w("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed, source[" + paramInt + "], lastRecoveryInterval[" + l1 + "], interruptInterval[" + paramLong + "], peerUin[" + (String)localObject1 + "], displayName[" + (String)localObject2 + "], businessType[" + i + "], relationType[" + j + "], isFriend[" + bool1 + "], speakerOn[" + bool2 + "], localMute[" + bool3 + "], roomId[" + l2 + "], seq[" + l3 + "]");
        if ((l1 <= 10000L) || (paramLong > this.lb) || (TextUtils.isEmpty((CharSequence)localObject1)) || (i == -1) || (j == -1) || (l2 == -1L)) {
          break label589;
        }
        localObject3 = igv.a(j, (String)localObject1, new int[0]);
        localObject3 = igv.a().a((String)localObject3, false);
        ((iiv)localObject3).uinType = 0;
        ((iiv)localObject3).peerUin = ((String)localObject1);
        ((iiv)localObject3).MO = ((String)localObject2);
        ((iiv)localObject3).relationType = j;
        ((iiv)localObject3).QU = true;
        ((iiv)localObject3).ln = l2;
        ((iiv)localObject3).e(l3, "recoverLastCallIfNeed", 1);
        ((iiv)localObject3).QE = true;
        ((iiv)localObject3).isFriend = bool1;
        ((iiv)localObject3).PV = bool3;
        localObject2 = this.mApp.b();
        ((VideoController)localObject2).a(l3, (String)localObject1, i, j, null, null, null, 0, null, null, null, null, null, 0, 0, null, null);
        amo();
        amn();
        if (ivv.tY())
        {
          ivv.a(l3, 1, this.mApp.getApp(), false, this.mApp.getCurrentAccountUin(), false);
          localObject1 = ((VideoController)localObject2).a;
          if (localObject1 != null) {
            ((TraeHelper)localObject1).startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
          }
          this.PB = true;
          this.lc = System.currentTimeMillis();
          this.PD = bool2;
          ihn.d(paramInt, paramLong, this.PB);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed fail.", localThrowable);
        return;
      }
      ivv.a(0L, this.mApp, 2);
      continue;
      label589:
      QLog.d("VideoRecoveryMonitor", 1, "recoverLastCallIfNeed no need to recovery last call.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihm
 * JD-Core Version:    0.7.0.1
 */