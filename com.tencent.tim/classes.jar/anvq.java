import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;

public class anvq
  implements Handler.Callback, Manager, BusinessObserver
{
  private static int dMQ = -1;
  protected Handler M;
  public anvq.a a;
  private int dMR = -1;
  private final int dMS = 2002;
  private final int dMT = 2003;
  private final int dMU = 2004;
  private ConcurrentHashMap<Long, anvq.b> it;
  public QQAppInterface mApp;
  public HashMap<Long, MessageForPtt> nG;
  
  public anvq() {}
  
  public anvq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.M = new Handler(Looper.getMainLooper(), this);
  }
  
  public static void I(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.getCurrentUin(), 0).edit().putInt("k_c_v", paramInt).commit();
  }
  
  public static int P(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.getCurrentUin(), 0).getInt("k_c_v", 0);
  }
  
  private boolean azb()
  {
    if (this.dMR == -1) {
      this.dMR = this.mApp.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_101" + this.mApp.getAccount(), 1);
    }
    return this.dMR == 1;
  }
  
  private void b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.sttAbility = 3;
      paramMessageForPtt.sttText = acfp.m(2131715039);
      paramMessageForPtt.isReadPtt = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_succ_flag", "0");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      localHashMap.put("param_resultCode", paramInt + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", false, 0L, 0L, localHashMap, null);
    }
    try
    {
      paramMessageForPtt.serial();
      this.mApp.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      return;
    }
    catch (Exception paramMessageForPtt)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.stt", 2, "updatedb", paramMessageForPtt);
    }
  }
  
  public static boolean bD(QQAppInterface paramQQAppInterface)
  {
    if (dMQ < 0) {
      dMQ = paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_" + paramQQAppInterface.getAccount(), 0);
    }
    if (dMQ == 1) {
      return true;
    }
    return ((anvq)paramQQAppInterface.getManager(17)).azb();
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (bD(paramQQAppInterface) != paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        dMQ = i;
        paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_" + paramQQAppInterface.getAccount(), dMQ).commit();
        return true;
      }
    }
    return false;
  }
  
  public static boolean lJ(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public void Vw(int paramInt)
  {
    this.dMR = paramInt;
    this.mApp.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_101" + this.mApp.getAccount(), paramInt).apply();
    try
    {
      anpc localanpc = anpc.a(BaseApplication.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("appversion", "3.4.4");
      localanpc.collectPerformance("", "PttSttEntryChange", false, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    return b(paramMessageForPtt, paramInt);
  }
  
  public void a(anvq.a parama)
  {
    this.a = parama;
  }
  
  public Long b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (this.nG == null)
    {
      this.nG = new HashMap();
      this.mApp.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (paramMessageForPtt.istroop == 0)
    {
      if (!aqmr.isEmpty(paramMessageForPtt.urlAtServer)) {
        break label160;
      }
      QLog.e("", 1, new Object[] { "stt err, c2c no fileID ", paramMessageForPtt });
      b(paramMessageForPtt, 2003);
      if (this.a != null) {
        this.a.a(false, paramMessageForPtt);
      }
    }
    for (;;)
    {
      return localLong;
      if (aqmr.isEmpty(paramMessageForPtt.md5))
      {
        QLog.e("", 1, new Object[] { "stt err, troop no md5 ", paramMessageForPtt });
        b(paramMessageForPtt, 2004);
        if (this.a != null)
        {
          this.a.a(false, paramMessageForPtt);
          return localLong;
        }
      }
      else
      {
        label160:
        Object localObject = aerb.c();
        boolean bool = aqvl.e(this.mApp, "have_add_ptt_svip_gray_msg", false);
        if ((((aera)localObject).stage == 2) && (!bool) && (VipUtils.ce(this.mApp)) && (xla.bhz))
        {
          localObject = new ahwa(paramMessageForPtt.frienduin, paramMessageForPtt.selfuin, acfp.m(2131715040), paramMessageForPtt.istroop, -5020, 655392, paramMessageForPtt.time);
          MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
          if (paramMessageForPtt.istroop == 1) {
            localMessageForUniteGrayTip.shmsgseq = paramMessageForPtt.shmsgseq;
          }
          localMessageForUniteGrayTip.initGrayTipMsg(this.mApp, (ahwa)localObject);
          ahwb.a(this.mApp, localMessageForUniteGrayTip);
          aqvl.f(this.mApp, "have_add_ptt_svip_gray_msg", true);
          QLog.e("Q.stt", 1, "stage2 first translate It is need add gray msg and insert success");
        }
        while (!this.nG.containsKey(localLong))
        {
          this.nG.put(localLong, paramMessageForPtt);
          anvs.a(this.mApp, paramMessageForPtt, localLong, paramInt);
          return localLong;
          if (QLog.isColorLevel()) {
            QLog.d("Q.stt", 1, "stage2 first translate It is need add gray msg and insert falied:conf.stage == " + ((aera)localObject).stage + " && " + bool);
          }
        }
      }
    }
  }
  
  public void by(byte[] paramArrayOfByte)
  {
    Object localObject = new SttResultPush.MsgBody();
    for (;;)
    {
      SttResultPush.TransPttResp localTransPttResp;
      Long localLong;
      int i;
      int j;
      int k;
      int m;
      try
      {
        ((SttResultPush.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localTransPttResp = ((SttResultPush.MsgBody)localObject).msg_ptt_resp;
        localLong = Long.valueOf(localTransPttResp.uint64_sessionid.get());
        i = localTransPttResp.uint32_pos.get();
        j = localTransPttResp.uint32_len.get();
        k = localTransPttResp.uint32_total_len.get();
        m = 1 << localTransPttResp.uint32_seq.get();
        int n = localTransPttResp.uint32_error_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onSttResultPush with: " + n + ", " + localLong + ", " + i + ", " + j + ", " + k);
        }
        if ((n != 0) || (i + j > k))
        {
          if (this.it != null) {
            this.it.remove(localLong);
          }
          this.M.obtainMessage(4, localLong).sendToTarget();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
        return;
      }
      if (j >= k) {
        paramArrayOfByte = new String(localTransPttResp.bytes_text.get().toByteArray());
      }
      while (paramArrayOfByte != null)
      {
        this.M.obtainMessage(3, (int)(localLong.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong.longValue() & 0xFFFFFFFF), paramArrayOfByte).sendToTarget();
        return;
        if (this.it == null) {
          this.it = new ConcurrentHashMap();
        }
        localObject = (anvq.b)this.it.get(localLong);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null)
        {
          paramArrayOfByte = new anvq.b(null);
          paramArrayOfByte.x = ByteBuffer.allocate(k);
          this.M.removeMessages(1, localLong);
          localObject = this.M.obtainMessage(2, localLong);
          this.M.sendMessageDelayed((Message)localObject, 30000L);
          this.it.put(localLong, paramArrayOfByte);
        }
        if (0L == (paramArrayOfByte.anY & m))
        {
          paramArrayOfByte.x.position(i);
          paramArrayOfByte.x.put(localTransPttResp.bytes_text.get().toByteArray());
          long l = paramArrayOfByte.length;
          paramArrayOfByte.length = (j + l);
          paramArrayOfByte.anY |= m;
          if (paramArrayOfByte.length >= k)
          {
            this.it.remove(localLong);
            paramArrayOfByte = new String(paramArrayOfByte.x.array());
            continue;
          }
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("unknown msg: " + paramMessage.what);
    case 2: 
      if (this.it != null) {
        this.it.remove(paramMessage.obj);
      }
    case 1: 
    case 4: 
      if (this.nG == null) {}
      break;
    }
    for (MessageForPtt localMessageForPtt = (MessageForPtt)this.nG.remove(paramMessage.obj);; localMessageForPtt = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + paramMessage.obj + ", " + localMessageForPtt);
      }
      if ((localMessageForPtt != null) && (this.a != null))
      {
        b(localMessageForPtt, 2002);
        this.a.a(false, localMessageForPtt);
      }
      return true;
      long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
      if (this.nG != null) {}
      for (localMessageForPtt = (MessageForPtt)this.nG.remove(Long.valueOf(l));; localMessageForPtt = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + l + ", " + localMessageForPtt);
        }
        if (localMessageForPtt == null) {
          break;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_succ_flag", "1");
        localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
        localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("param_resultCode", "0");
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", true, 0L, 0L, localHashMap, null);
        localMessageForPtt.sttAbility = 2;
        localMessageForPtt.sttText = ((String)paramMessage.obj);
        localMessageForPtt.isReadPtt = true;
        localMessageForPtt.serial();
        this.mApp.b().c(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "ptt convert to text success,seq is:" + localMessageForPtt.uniseq + ",sttAbility is:" + localMessageForPtt.sttAbility + ",sttText is:" + aqft.pk(localMessageForPtt.sttText));
        }
        if (this.a == null) {
          break;
        }
        this.a.a(true, localMessageForPtt);
        return true;
      }
    }
  }
  
  public boolean l(MessageForPtt paramMessageForPtt)
  {
    return (this.nG != null) && (this.nG.containsKey(Long.valueOf(paramMessageForPtt.uniseq)));
  }
  
  public boolean m(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.autoToText >= 1) && (!l(paramMessageForPtt)) && (paramMessageForPtt.sttAbility != 2)) {}
    do
    {
      return true;
      aqjh.eA(this.mApp);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "needAuotoChange AutoChangeFlag=" + xla.bhz + " AutoChangeSetTime=" + xla.Jb + " isTranslating=" + l(paramMessageForPtt) + "mPtt.msgTime=" + paramMessageForPtt.msgTime + " mPtt.time=" + paramMessageForPtt.time + " mPtt.sttAbility=" + paramMessageForPtt.sttAbility + " isRedPackPTT=" + aagm.b(paramMessageForPtt));
      }
    } while ((!l(paramMessageForPtt)) && (!aagm.b(paramMessageForPtt)) && (xla.bhz) && ((xla.Jb < paramMessageForPtt.msgTime) || (xla.Jb < paramMessageForPtt.time)) && (paramMessageForPtt.voiceChangeFlag != 1) && ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)));
    return false;
  }
  
  public void onDestroy()
  {
    dMQ = -1;
    if (this.nG != null) {
      this.nG.clear();
    }
    this.a = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
    }
    Long localLong2;
    do
    {
      do
      {
        return;
        localLong2 = Long.valueOf(paramBundle.getLong("k_session", 0L));
        Long localLong1 = Long.valueOf(paramBundle.getLong("k_time_out", 30000L));
        paramInt = paramBundle.getInt("k_result_code", 0);
        String str = paramBundle.getString("k_ptt_trans_txt", null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onReceive, session = " + localLong2 + ", timeout = " + localLong1);
        }
        paramBundle = localObject;
        if (this.nG != null) {
          paramBundle = (MessageForPtt)this.nG.get(localLong2);
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBoolean)
        {
          if (str != null)
          {
            this.M.obtainMessage(3, (int)(localLong2.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong2.longValue() & 0xFFFFFFFF), str).sendToTarget();
            return;
          }
          paramBundle = this.M.obtainMessage(1, localLong2);
          this.M.sendMessageDelayed(paramBundle, localLong1.longValue());
          return;
        }
        if (this.nG != null) {
          this.nG.remove(localLong2);
        }
        b(paramBundle, paramInt);
      } while (this.a == null);
      this.a.a(false, paramBundle);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.stt", 2, "onReceive with no request on: " + localLong2);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, MessageForPtt paramMessageForPtt);
    
    public abstract void a(boolean paramBoolean, MessageForPtt paramMessageForPtt);
  }
  
  static class b
  {
    public long anY;
    public long length;
    public ByteBuffer x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvq
 * JD-Core Version:    0.7.0.1
 */