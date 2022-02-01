import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc1.submsgtype0xc1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdb.submsgtype0xdb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe9.SubMsgType0xe9.MsgBody;

public class acjq
  implements Handler.Callback
{
  static ArrayList<acjq.a> tB;
  static ArrayList<String> tC;
  AVNotifyCenter b;
  boolean bJf = false;
  QQAppInterface mApp = null;
  byte[] mBuffer = new byte['ª'];
  Handler mHandler;
  Vector<byte[]> y = new Vector();
  
  static
  {
    try
    {
      tB = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg create successful!");
      }
      try
      {
        label24:
        tC = new ArrayList();
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "sCacheMsgList create successful!");
        }
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label24;
    }
  }
  
  public acjq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.b = this.mApp.a();
  }
  
  public static acjq.c a(byte[] paramArrayOfByte)
  {
    acjq.c localc = new acjq.c();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 40)) {
      return localc;
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = new byte[4];
    byte[] arrayOfByte3 = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
    localc.cxy = ihk.a(ihk.bytesToShort(arrayOfByte1, 2));
    System.arraycopy(paramArrayOfByte, 2, arrayOfByte3, 0, 8);
    localc.QI = ihk.bytesToLong(arrayOfByte3, 8);
    localc.cxz = ihk.b(paramArrayOfByte[10]);
    int j = localc.cxz + 11;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localc.QJ = ihk.q(ihk.bytesToInt(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localc.QK = ihk.q(ihk.bytesToInt(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte3, 0, 8);
    localc.QL = ihk.bytesToLong(arrayOfByte3, 8);
    j += 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localc.cxA = ihk.bytesToInt(arrayOfByte2, 4);
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localc.cxB = ihk.a(ihk.bytesToShort(arrayOfByte1, 2));
    j += 2;
    localc.cxC = ihk.b(paramArrayOfByte[j]);
    j += 1;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localc.QM = ihk.a(arrayOfByte2, 4);
    j += localc.cxC;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localc.cxD = ihk.a(ihk.bytesToShort(arrayOfByte1, 2));
    j = j + 2 + localc.cxD * 8;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 4);
    localc.QN = ihk.q(ihk.bytesToInt(arrayOfByte2, 4));
    j += 4;
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
    localc.cxE = ihk.a(ihk.bytesToShort(arrayOfByte1, 2));
    j += 2;
    if ((localc.cxE >= 16) && (localc.cxE + j <= i))
    {
      System.arraycopy(paramArrayOfByte, j + 9, arrayOfByte1, 0, 2);
      i = ihk.a(ihk.bytesToShort(arrayOfByte1, 2)) + 11;
      if (localc.cxB != 3) {
        break label414;
      }
    }
    for (;;)
    {
      i = localc.cxE;
      return localc;
      label414:
      localc.cxF = ihk.b(paramArrayOfByte[(j + i)]);
      i += 1;
      if (i + 4 <= localc.cxE)
      {
        System.arraycopy(paramArrayOfByte, j + i, arrayOfByte2, 0, 4);
        localc.QO = ihk.q(ihk.bytesToInt(arrayOfByte2, 4));
      }
    }
  }
  
  private void aI(byte[] paramArrayOfByte)
  {
    int i = 0;
    Object localObject = new byte[1];
    System.arraycopy(paramArrayOfByte, 11, localObject, 0, 1);
    if (QLog.isColorLevel()) {
      QLog.w("QQGAudioMsgHandler", 1, "onRecvRoomDestroy, cAuthType[" + localObject[0] + "]");
    }
    if (localObject[0] != 3) {
      return;
    }
    localObject = BaseApplication.getContext();
    long l = this.b.bG();
    int j = this.b.lg();
    if (l > 0L) {
      i = this.b.z(l);
    }
    if ((j == 1) && (i == 2))
    {
      new avfi(this.mApp).a(new acjx(this, paramArrayOfByte));
      return;
    }
    new iuq((Context)localObject).a(new acjy(this, paramArrayOfByte));
  }
  
  public void EJ(String paramString)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GVideoMedalChange");
      localIntent.putExtra("jsonString", paramString);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long[] paramArrayOfLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    QLog.w("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber, relationType[" + paramInt1 + "], relationId[" + paramString + "], memberNum[" + paramInt2 + "], avtype[" + paramInt3 + "], gameId[" + paramInt5 + "], liveExtraMode[" + paramInt6 + "],memberList[" + Arrays.toString(paramArrayOfLong) + "]");
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.e("QQGAudioMsgHandler", 1, "onRecvGroupVideoMemberNumber", localException);
      }
      this.mApp.a().ai(paramString, paramInt3);
      i = paramInt3;
      if (paramInt3 != 14) {
        break label167;
      }
      i = 2;
      paramInt3 = 21;
      if (paramInt2 > 0) {
        break label179;
      }
      paramInt3 = 23;
      AVNotifyCenter.h localh = this.mApp.a().a(l1);
      if ((localh == null) || (localh.memberNum <= 0) || (paramInt2 != 0)) {
        break label228;
      }
      this.b.a(5, 1, l1, null, localh.memberNum);
      this.mApp.a().q(l1, i, paramInt2);
      this.mApp.a().a(4, l1, i, paramInt4, paramInt5, paramInt6, paramInt3, paramInt2);
      if (paramInt2 != 0) {
        break label378;
      }
    }
    if (l1 == 0L) {
      return;
    }
    int i;
    label167:
    label179:
    label228:
    az(l1, i);
    this.b.b(21, 1, l1, 0L);
    label292:
    if (this.mApp.a().as(paramString) != 14)
    {
      paramString = new Intent();
      paramString.setAction("tencent.video.q2v.membersChange");
      paramString.putExtra("relationType", 1);
      paramString.putExtra("avtype", i);
      paramString.putExtra("relationId", l1);
      if (paramInt2 != 0) {
        break label468;
      }
      paramString.putExtra("Exit", true);
    }
    for (;;)
    {
      this.mApp.getApp().sendBroadcast(paramString);
      return;
      label378:
      this.b.a(6, 1, l1, paramArrayOfLong, paramInt2);
      this.b.k(10, l1, i);
      if ((i == 2) && (paramInt1 == 1) && (((apuk)this.mApp.getManager(164)).eV(paramString) == 1)) {
        this.mApp.a().w(l1, true);
      }
      this.b.b(21, 1, l1, 0L);
      break label292;
      break;
      label468:
      paramString.putExtra("Exit", false);
    }
  }
  
  void a(long paramLong, int paramInt, byte paramByte)
  {
    if (this.mApp == null) {
      return;
    }
    igd.aK("QQGAudioMsgHandler", String.format("queryRoomMemberNum| discussId=%d, dataType= %d, wReserve=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Byte.valueOf(paramByte) }));
    byte[] arrayOfByte = new byte[33];
    arrayOfByte[0] = ((byte)0);
    arrayOfByte[1] = ((byte)48);
    long l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[(i + 2)] = ((byte)(int)(l >> (7 - i) * 8 & 0xFF));
      i += 1;
    }
    arrayOfByte[10] = 0;
    arrayOfByte[11] = 0;
    arrayOfByte[12] = 0;
    arrayOfByte[13] = 0;
    arrayOfByte[14] = 0;
    arrayOfByte[15] = ((byte)paramInt);
    arrayOfByte[16] = 4;
    paramInt = 0;
    while (paramInt < 4)
    {
      arrayOfByte[(paramInt + 17)] = ((byte)(int)(paramLong >> (3 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 8)
    {
      arrayOfByte[(paramInt + 21)] = ((byte)(int)(531L >> (7 - paramInt) * 8 & 0xFF));
      paramInt += 1;
    }
    arrayOfByte[29] = 0;
    arrayOfByte[30] = 0;
    arrayOfByte[31] = 0;
    arrayOfByte[32] = paramByte;
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), anfb.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)462);
    localNewIntent.putExtra("selfuin", l);
    localNewIntent.putExtra("toUin", paramLong);
    localNewIntent.putExtra("vMsg", arrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    this.mApp.startServlet(localNewIntent);
  }
  
  public void a(submsgtype0xc1.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.randomMultiOwnerOnlinePush").putExtra("group_id", paramMsgBody.uint64_groupid.get()).putExtra("member_num", paramMsgBody.uint32_member_num.get());
    if (TextUtils.isEmpty(paramMsgBody.string_data.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_data.get())
    {
      paramMsgBody = localIntent.putExtra("string_data", paramMsgBody);
      this.mApp.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(submsgtype0xcf.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.random1V1OnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_rspbody.get())
    {
      paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
      this.mApp.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(submsgtype0xdb.MsgBody paramMsgBody)
  {
    Intent localIntent = new Intent("tencent.video.q2v.avreportOnlinePush").putExtra("rsptype", paramMsgBody.uint32_rsptype.get());
    if (TextUtils.isEmpty(paramMsgBody.string_rspbody.get())) {}
    for (paramMsgBody = "";; paramMsgBody = paramMsgBody.string_rspbody.get())
    {
      paramMsgBody = localIntent.putExtra("rspbody", paramMsgBody);
      this.mApp.getApp().sendBroadcast(paramMsgBody);
      return;
    }
  }
  
  public void a(SubMsgType0xe9.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_business_type.get();
    Intent localIntent = new Intent();
    if (i == 3) {
      localIntent.setAction("tencent.peak.q2v.AudioTransPush");
    }
    for (;;)
    {
      localIntent.putExtra("rsptype", paramMsgBody.uint32_business_type.get());
      localIntent.putExtra("rspbody", paramMsgBody.bytes_business.get().toByteArray());
      this.mApp.getApp().sendBroadcast(localIntent);
      return;
      localIntent.setAction("tencent.video.q2v.AudioTransPush");
    }
  }
  
  public void a(byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    if (!ur()) {}
    Object localObject;
    long l2;
    int j;
    long l3;
    long l4;
    String str;
    do
    {
      return;
      localObject = new byte[2];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
      i = ihk.a(ihk.bytesToShort((byte[])localObject, 2));
      if (i != 141) {
        break label628;
      }
      acjq.c localc = a(paramArrayOfByte);
      i = localc.cxB;
      l1 = localc.QL;
      l2 = localc.QM;
      j = localc.cxA;
      l3 = localc.QN;
      l4 = localc.QO;
      str = Long.toString(l2);
      localObject = Long.toString(l1);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg relationShip[" + i + "], groupUin[" + str + "], inviteUin[" + l1 + "], subCmd0x8DMsg[" + localc + "]");
      }
      if (1 == i)
      {
        VideoMsgTools.a(this.mApp, 1, 13, false, str, (String)localObject, false, null, false, j, new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
        this.b.b(l2, 1, 10, true);
        return;
      }
      if (3 != i) {
        break label470;
      }
      paramArrayOfByte = str;
      if (!this.mApp.getCurrentAccountUin().equals(localObject)) {
        paramArrayOfByte = (byte[])localObject;
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg friendUin is empty!");
    return;
    long l1 = 0L;
    if (paramMsg != null) {
      l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    }
    if ((l1 > 0L) && (l1 - NetConnInfoCenter.getServerTime() - 60000L > 0L)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        VideoMsgTools.a(this.mApp, 0, 6, true, paramArrayOfByte, (String)localObject, false, null, false, new Object[] { paramMsg });
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "GAudioOfflineMsg double meeting friendUin is:" + paramArrayOfByte);
      }
      l2 = l1;
      if (l1 == 0L) {
        l2 = anaz.gQ();
      }
      if ((tB == null) || (this.mHandler == null)) {
        break;
      }
      tB.add(new acjq.a(paramMsg, Long.valueOf(paramArrayOfByte).longValue(), l2));
      a(Long.valueOf(paramArrayOfByte).longValue(), 4, (byte)8);
      this.mHandler.sendEmptyMessageDelayed(1, 10000L);
      return;
      label470:
      paramMsg = (alkm)this.mApp.getManager(38);
      if ((this.mApp.getCurrentAccountUin() != null) && (this.mApp.getCurrentAccountUin().equals(localObject))) {
        paramMsg.k(1, l2, (String)localObject);
      }
      for (;;)
      {
        this.b.b(l2, 2, 0, true);
        VideoMsgTools.a(this.mApp, 3000, 13, false, str, (String)localObject, false, null, false, new Object[] { Long.valueOf(l3), Long.valueOf(l4) });
        if (!this.bJf) {
          break;
        }
        aH(paramArrayOfByte);
        return;
        if (this.b.d(2, l2) <= 0L) {
          paramMsg.U(3000, str, (String)localObject);
        }
      }
      if (this.y == null) {
        break;
      }
      this.y.add(paramArrayOfByte);
      return;
      label628:
      if (i != 7) {
        break;
      }
      i = (paramArrayOfByte[10] & 0xFF) + 19;
      paramMsg = new byte[8];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 8);
      l1 = ihk.bytesToLong(paramMsg, 8);
      i += 8;
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i, paramMsg, 0, 4);
      j = ihk.bytesToInt(paramMsg, 4);
      paramMsg = new byte[4];
      System.arraycopy(paramArrayOfByte, i + 4, paramMsg, 0, 4);
      l2 = ihk.bytesToLong(paramMsg, 4);
      VideoMsgTools.a(this.mApp, 1, 13, true, Long.toString(l2), Long.toString(l1), false, null, false, j, new Object[0]);
      this.b.k(11, l2, j);
      ((apuk)this.mApp.getManager(164)).lT(l2);
      this.b.b(l2, 1, 2, true);
      return;
    }
  }
  
  public void aA(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = (arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, String.format("onRecvMultiVideoS2CData msgType=0x%X", new Object[] { Integer.valueOf(i) }));
    }
    if (!ur()) {
      if ((141 == i) || (7 == i)) {
        l(i, paramArrayOfByte);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (i)
            {
            default: 
              return;
            }
          } while (this.mBuffer == null);
          i = paramArrayOfByte.length;
        } while (i < 40);
        if (this.mBuffer.length < i) {
          this.mBuffer = new byte[i];
        }
        System.arraycopy(paramArrayOfByte, 0, this.mBuffer, 0, i);
        aG(paramArrayOfByte);
        return;
        g(paramArrayOfByte, 27);
        return;
      } while (this.mBuffer == null);
      i = paramArrayOfByte.length;
    } while (i < 40);
    if (this.mBuffer.length < i) {
      this.mBuffer = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.mBuffer, 0, i);
    aF(this.mBuffer);
    return;
    aE(paramArrayOfByte);
    return;
    aI(paramArrayOfByte);
  }
  
  public void aB(byte[] paramArrayOfByte)
  {
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 2);
    int i = localObject[0];
    if (((localObject[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      aD(paramArrayOfByte);
    }
    if (this.mApp != null)
    {
      localObject = new Intent("tencent.video.q2v.MultiVideo");
      this.mApp.getCurrentAccountUin();
      ((Intent)localObject).putExtra("type", 30);
      ((Intent)localObject).putExtra("buffer", paramArrayOfByte);
      this.mApp.getApp().sendBroadcast((Intent)localObject);
    }
  }
  
  public void aC(byte[] paramArrayOfByte)
  {
    igd.aK("QQGAudioMsgHandler", "onRecvAppTipMsgData.");
    if (!ur()) {}
    byte[] arrayOfByte1;
    Object localObject3;
    byte[] arrayOfByte2;
    int i3;
    do
    {
      do
      {
        return;
        arrayOfByte1 = new byte[2];
        localObject3 = new byte[4];
        arrayOfByte2 = new byte[8];
      } while ((arrayOfByte1 == null) || (localObject3 == null) || (arrayOfByte2 == null));
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, 2);
      i3 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
    } while (i3 < 4);
    long l1 = 0L;
    int i = 0;
    int n = 0;
    int k = 0;
    int j = 2;
    Object localObject1 = null;
    label102:
    if (n < i3)
    {
      System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
      j += 2;
      switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
      {
      }
    }
    for (;;)
    {
      n += 1;
      break label102;
      j += 2;
      System.arraycopy(paramArrayOfByte, j, localObject3, 0, 4);
      l1 = ihk.bytesToLong((byte[])localObject3, 4);
      j += 4;
      continue;
      j += 2;
      System.arraycopy(paramArrayOfByte, j, localObject3, 0, 4);
      i = ihk.bytesToInt((byte[])localObject3, 4);
      if (i == 0)
      {
        hI(l1);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", l1);
        paramArrayOfByte.putExtra("Exit", true);
        this.mApp.getApp().sendBroadcast(paramArrayOfByte);
        return;
        j += 6;
        continue;
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        k = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (k <= 0) {
          break;
        }
        int i2 = k / 8;
        Object localObject2 = new long[i2];
        int m = j + 2;
        int i1 = 0;
        for (;;)
        {
          k = i2;
          j = m;
          localObject1 = localObject2;
          if (i1 >= i2) {
            break;
          }
          System.arraycopy(paramArrayOfByte, m, arrayOfByte2, 0, 8);
          localObject2[i1] = ihk.bytesToLong(arrayOfByte2, 8);
          i1 += 1;
          m += 8;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
        i1 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "TLV-NUMBER = " + i1);
        }
        localObject2 = new int[k];
        localObject3 = new int[k];
        m = 0;
        j += 2;
        if (m < i1)
        {
          System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, 2);
          n = j + 2;
          j = arrayOfByte1[0];
          i3 = arrayOfByte1[1];
          System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, 2);
          n += 2;
          i2 = (arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0;
          switch ((j & 0xFF) << 8 | (i3 & 0xFF) << 0)
          {
          default: 
            j = n + i2;
          }
          for (;;)
          {
            m += 1;
            break;
            j = n;
            if (i2 == k)
            {
              System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, i2);
              j = 0;
              while (j < i2)
              {
                localObject2[j] = arrayOfByte1[j];
                j += 1;
              }
              j = n + i2;
              continue;
              j = n;
              if (i2 == k)
              {
                System.arraycopy(paramArrayOfByte, n, arrayOfByte1, 0, i2);
                j = 0;
                while (j < i2)
                {
                  localObject3[j] = arrayOfByte1[j];
                  j += 1;
                }
                j = n + i2;
              }
            }
          }
        }
        QLog.w("QQGAudioMsgHandler", 1, "onRecvAppTipMsgData, roomUserNum[" + i + "], qqUserLen[" + k + "]");
        if (this.b == null) {
          break;
        }
        long l2 = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
        if ((i == 1) && (localObject1 != null) && (localObject1.length >= 1) && (l2 == localObject1[0]) && (this.b.bG() == 0L))
        {
          if (this.b.d(2, l1) != 0L) {
            break;
          }
          a(l1, 1, (byte)1);
          return;
        }
        this.b.a(2, l1, localObject1, (int[])localObject2, i);
        this.b.b(21, 2, l1, 0L);
        paramArrayOfByte = new Intent();
        paramArrayOfByte.setAction("tencent.video.q2v.membersChange");
        paramArrayOfByte.putExtra("relationType", 2);
        paramArrayOfByte.putExtra("relationId", l1);
        paramArrayOfByte.putExtra("Exit", false);
        this.mApp.getApp().sendBroadcast(paramArrayOfByte);
        return;
      }
      j += 4;
    }
  }
  
  public void aD(byte[] paramArrayOfByte)
  {
    igd.aK("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31.");
    if (this.b == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2;
    long l2;
    if (this.mApp != null)
    {
      localObject2 = this.mApp.getCurrentAccountUin();
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l2 = Long.valueOf((String)localObject2).longValue();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[2];
      byte[] arrayOfByte2 = new byte[4];
      byte[] arrayOfByte3 = new byte[8];
      System.arraycopy(paramArrayOfByte, 2, arrayOfByte2, 0, 4);
      int i = ihk.bytesToInt(arrayOfByte2, 4);
      if (i != 0)
      {
        localObject1 = new byte[2];
        System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject1, 0, 2);
        igd.aK("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| retCode wR0=" + localObject1[0] + " wR1=" + localObject1[1]);
        if (localObject1[0] == 3)
        {
          h(paramArrayOfByte, i);
          return;
        }
        igd.aL("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong retCode.");
        return;
      }
      localObject2 = new byte[2];
      System.arraycopy(paramArrayOfByte, paramArrayOfByte.length - 2, localObject2, 0, 2);
      igd.aK("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31| relation type wR0=" + localObject2[0] + " wR1=" + localObject2[1]);
      int j;
      long l1;
      int k;
      if (localObject2[0] == 1)
      {
        j = 1;
        System.arraycopy(paramArrayOfByte, 8, arrayOfByte1, 0, 2);
        int i2 = arrayOfByte1[0];
        int i3 = arrayOfByte1[1];
        l1 = 0L;
        k = 0;
        localObject2 = null;
        i = 10;
        label278:
        if (k < ((i2 & 0xFF) << 8 | (i3 & 0xFF) << 0))
        {
          System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
          i += 2;
        }
      }
      else
      {
        switch ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0)
        {
        default: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
          for (;;)
          {
            k += 1;
            break label278;
            if (localObject2[0] == 2)
            {
              j = 2;
              break;
            }
            if (localObject2[0] == 3)
            {
              h(paramArrayOfByte, i);
              return;
            }
            igd.aL("QQGAudioMsgHandler", "onRecvMultiVideoC2SACK_0x31|wrong relation type.");
            j = 2;
            break;
            i += 2;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, 4);
            i += 4;
            l1 = ihk.bytesToLong(arrayOfByte2, 4);
            continue;
            i += 6;
            continue;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
            i = i + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            i += 10;
            continue;
            i += 6;
            continue;
            i += 6;
            continue;
            i += 6;
            continue;
            System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
            i = i + 2 + ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0);
            continue;
            i += 6;
          }
        }
        System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 2);
        i += 2;
        int i4 = ((arrayOfByte1[0] & 0xFF) << 8 | (arrayOfByte1[1] & 0xFF) << 0) / 8;
        localObject2 = new long[i4];
        int n = 0;
        int m = 0;
        while (m < i4)
        {
          System.arraycopy(paramArrayOfByte, i, arrayOfByte3, 0, 8);
          int i1 = i + 8;
          long l3 = ihk.bytesToLong(arrayOfByte3, 8);
          localObject2[m] = l3;
          i = n;
          if (l3 == l2)
          {
            i = n;
            if (this.b.bG() == 0L)
            {
              i = n;
              if (0L == this.b.d(j, l1)) {
                i = 1;
              }
            }
          }
          m += 1;
          n = i;
          i = i1;
        }
        String str;
        if (n != 0)
        {
          str = Long.toString(l1);
          if (j != 2) {
            break label796;
          }
        }
        label796:
        for (m = 3000;; m = 1)
        {
          VideoMsgTools.a(this.mApp, m, 13, false, str, (String)localObject1, true, null, true, new Object[0]);
          break;
        }
      }
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break;
      }
      this.b.a(j, l1, (long[])localObject2);
      this.b.b(21, j, l1, 0L);
      return;
      l2 = 0L;
    }
  }
  
  public void aE(byte[] paramArrayOfByte)
  {
    igd.aK("QQGAudioMsgHandler", "onRecvMultiVideoS2C_0x95.");
    if (!ur()) {}
    int i;
    label1150:
    do
    {
      return;
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
      localByteBuffer.getShort();
      localByteBuffer.getLong();
      int n = localByteBuffer.getShort();
      long l1 = 0L;
      i = 0;
      int i1;
      int k;
      int m;
      int i2;
      if (n > 0)
      {
        j = 0;
        while (j < n)
        {
          i1 = localByteBuffer.getShort();
          paramArrayOfByte = null;
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l1 = localByteBuffer.getInt();
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          this.b.a(9, 2, l1, paramArrayOfByte, i);
          this.b.b(21, 2, l1, 0L);
          j += 1;
        }
      }
      n = localByteBuffer.getShort();
      l1 = 0L;
      i = 0;
      if (n > 0)
      {
        j = 0;
        while (j < n)
        {
          i1 = localByteBuffer.getShort();
          k = 0;
          if (k < i1)
          {
            m = localByteBuffer.getShort();
            i2 = localByteBuffer.getShort();
            switch (m)
            {
            default: 
              localByteBuffer.get(new byte[i2], 0, i2);
            }
            for (;;)
            {
              k += 1;
              break;
              l1 = ihk.q(localByteBuffer.getInt());
              continue;
              i = localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
              continue;
              paramArrayOfByte = new long[i2 / 8];
              m = 0;
              while (m < i2 / 8)
              {
                paramArrayOfByte[m] = localByteBuffer.getLong();
                m += 1;
              }
              continue;
              localByteBuffer.getInt();
              continue;
              localByteBuffer.getInt();
            }
          }
          jjq.a().a(this.mApp, String.valueOf(l1), new acjr(this, l1, i));
          j += 1;
        }
      }
      int i7 = localByteBuffer.getShort();
      l1 = 0L;
      j = 0;
      if (i7 > 0)
      {
        i = 0;
        if (i < i7)
        {
          int i8 = localByteBuffer.getShort();
          k = 0;
          Object localObject1 = null;
          i1 = -1;
          n = -1;
          m = -1;
          paramArrayOfByte = null;
          Object localObject2;
          Object localObject3;
          if (k < i8)
          {
            i2 = localByteBuffer.getShort();
            int i9 = localByteBuffer.getShort();
            int i5;
            int i4;
            long l2;
            int i3;
            switch (i2)
            {
            default: 
              localByteBuffer.get(new byte[i9], 0, i9);
              i5 = j;
              i4 = m;
              l2 = l1;
              i3 = n;
              i2 = i1;
              localObject2 = localObject1;
            }
            for (;;)
            {
              k += 1;
              localObject1 = localObject2;
              i1 = i2;
              n = i3;
              l1 = l2;
              m = i4;
              j = i5;
              break;
              l2 = ihk.q(localByteBuffer.getInt());
              localObject2 = localObject1;
              i2 = i1;
              i3 = n;
              i4 = m;
              i5 = j;
              continue;
              i5 = localByteBuffer.getInt();
              localObject2 = localObject1;
              i2 = i1;
              i3 = n;
              l2 = l1;
              i4 = m;
              continue;
              i4 = localByteBuffer.getInt();
              localObject2 = localObject1;
              i2 = i1;
              i3 = n;
              l2 = l1;
              i5 = j;
              continue;
              localObject3 = new long[i9 / 8];
              int i6 = 0;
              for (;;)
              {
                localObject2 = localObject1;
                i2 = i1;
                i3 = n;
                l2 = l1;
                i4 = m;
                paramArrayOfByte = (byte[])localObject3;
                i5 = j;
                if (i6 >= i9 / 8) {
                  break;
                }
                localObject3[i6] = localByteBuffer.getLong();
                i6 += 1;
              }
              i3 = localByteBuffer.getInt();
              localObject2 = localObject1;
              i2 = i1;
              l2 = l1;
              i4 = m;
              i5 = j;
              continue;
              i2 = localByteBuffer.getInt();
              localObject2 = localObject1;
              i3 = n;
              l2 = l1;
              i4 = m;
              i5 = j;
              continue;
              localObject2 = new byte[i9];
              localByteBuffer.get((byte[])localObject2, 0, i9);
              i2 = i1;
              i3 = n;
              l2 = l1;
              i4 = m;
              i5 = j;
            }
          }
          if (AudioHelper.aCz())
          {
            localObject2 = new StringBuilder().append("onRecvMultiVideoS2C_0x95, index[").append(i).append("], GroupId[").append(l1).append("], roomUserNum[").append(j).append("], busitype[").append(m).append("], shortnum[").append(n).append("], createtime[").append(i1).append("], ppt[");
            if (localObject1 != null) {
              break label1150;
            }
            localObject1 = "null";
            localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append("], uinList[");
            if (paramArrayOfByte != null) {
              break label1209;
            }
          }
          for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
          {
            QLog.w("QQGAudioMsgHandler", 1, paramArrayOfByte + "]");
            this.b.a(11, 1, l1, null, j);
            this.b.a(6, l1, 10, 0, 0, 21, j);
            this.b.b(21, 1, l1, 0L);
            i += 1;
            break;
            localObject3 = new StringBuilder().append(localObject1.length).append("|");
            if (localObject1.length == 0) {}
            for (localObject1 = "";; localObject1 = Byte.valueOf(localObject1[0]))
            {
              localObject1 = localObject1;
              break;
            }
          }
        }
      }
      this.bJf = true;
    } while (this.y == null);
    label1209:
    int j = this.y.size();
    if (j > 0)
    {
      i = 0;
      while (i < j)
      {
        aH((byte[])this.y.elementAt(i));
        i += 1;
      }
    }
    this.y.clear();
  }
  
  void aF(byte[] paramArrayOfByte)
  {
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    Object localObject = new byte[8];
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 8);
    long l1 = ihk.bytesToLong((byte[])localObject, 8);
    int j = i + 8;
    localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 4);
    i = ihk.bytesToInt((byte[])localObject, 4);
    j += 4;
    localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, j, localObject, 0, 2);
    int k = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if ((k != 3) && (k != 2) && (k == 2) && (i != 10))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "Current version is only surpport discussion and friend. RelationType=" + k);
      }
      return;
    }
    long l2;
    if (k == 2)
    {
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
      l2 = ihk.a((byte[])localObject, 4);
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMuitiInvite discussId is" + l2 + "InviteUin:" + l1);
      }
      ((acdt)this.mApp.getBusinessHandler(6)).hl(l2);
      if (this.b != null) {
        this.b.a(7, 2, l2, new long[] { l1 }, 1L);
      }
      paramArrayOfByte = Long.toString(l2);
      localObject = Long.toString(l1);
      ((alkm)this.mApp.getManager(38)).d(0, l2, (String)localObject, "");
      if (!this.mApp.a().sM()) {
        VideoMsgTools.a(this.mApp, 3000, 13, false, paramArrayOfByte, (String)localObject, false, null, true, new Object[0]);
      }
    }
    while ((k == 1) && (i == 2))
    {
      new avfi(this.mApp).a(new acjs(this));
      return;
      if ((k == 1) && (i == 10))
      {
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, j + 3, localObject, 0, 4);
        l2 = ihk.a((byte[])localObject, 4);
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 1, "onRecvMuitiInvite, groupUin[" + l2 + "], InviteUin[" + l1 + "]");
        }
        if ((this.b != null) && (this.b.d(1, l2) == 0L))
        {
          this.b.a(5, l2, 10, 0, 0, 20, 1);
          this.b.a(8, 1, l2, new long[] { l1 }, 1L);
          this.b.b(21, 1, Long.valueOf(l2).longValue(), 0L);
        }
        VideoMsgTools.a(this.mApp, 1, 13, false, Long.toString(l2), Long.toString(l1), false, null, false, i, new Object[0]);
      }
    }
    new iuq(BaseApplication.getContext()).a(new acjt(this));
  }
  
  void aG(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvGroupVideoInvite");
    }
    int i = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 8);
    long l1 = ihk.bytesToLong(arrayOfByte, 8);
    i += 8;
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, 4);
    int j = ihk.bytesToInt(arrayOfByte, 4);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, i + 4, arrayOfByte, 0, 4);
    long l2 = ihk.bytesToLong(arrayOfByte, 4);
    jjq.a().a(this.mApp, String.valueOf(l2), new acju(this, l2, j, l1));
  }
  
  void aH(byte[] paramArrayOfByte)
  {
    if ((this.b == null) || (this.mApp == null)) {}
    long l;
    do
    {
      return;
      int i = paramArrayOfByte[10];
      localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, (i & 0xFF) + 34, localObject, 0, 4);
      l = ihk.a((byte[])localObject, 4);
      QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg discussId is:" + l);
    } while (this.b.d(2, l) <= 0L);
    ((acdt)this.mApp.getBusinessHandler(6)).hl(l);
    Object localObject = this.mApp.getCurrentAccountUin();
    Intent localIntent = new Intent("tencent.video.q2v.RecvMultiVideoCall");
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.mApp.getApp().sendBroadcast(localIntent);
    QLog.d("QQGAudioMsgHandler", 1, "dealGAudioOfflineMsg sendBroadcast discussId is:" + l);
  }
  
  public void aJ(byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent("tencent.video.q2v.VisitorSendGift");
    localIntent.putExtra("data", paramArrayOfByte);
    this.mApp.getApp().sendBroadcast(localIntent);
  }
  
  public void am(long paramLong, boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.KickOutVisitor");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("isAllVisitor", paramBoolean);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void an(long paramLong, boolean paramBoolean)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.ChangeVisitorSpeakMode");
      localIntent.putExtra("groupId", paramLong);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  void az(long paramLong, int paramInt)
  {
    if ((this.b == null) || (this.mApp == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQGAudioMsgHandler", 2, "onGroupChatRoomDestroy-->can not get mNotifycenter or mapp");
      }
    }
    for (;;)
    {
      return;
      if (this.b.d(1, paramLong) > 0L)
      {
        this.b.a(3, 1, paramLong, null, 0L);
        String str = this.mApp.getCurrentAccountUin();
        VideoMsgTools.a(this.mApp, 1, 14, false, String.valueOf(paramLong), str, false, null, false, paramInt, new Object[0]);
        this.b.b(21, 1, paramLong, 0L);
      }
      while (paramInt == 2)
      {
        this.b.w(paramLong, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("QQGAudioMsgHandler", 2, "MultiRoomMemberNum is 0");
        }
        this.b.b(23, 1, paramLong, 0L);
      }
    }
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoLevelUpgrade");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("enable", paramInt2);
      localIntent.putExtra("level", paramInt3);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void c(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoGift");
      localIntent.putExtra("type", paramInt1);
      localIntent.putExtra("fromUin", paramLong1);
      localIntent.putExtra("toUin", paramLong2);
      localIntent.putExtra("count", paramInt2);
      localIntent.putExtra("seq", paramLong3);
      localIntent.putExtra("groupId", paramLong4);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void cLY()
  {
    this.bJf = false;
    if (this.y != null) {
      this.y.clear();
    }
    if ((tB == null) || (tB.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
      }
    }
    do
    {
      return;
      tB.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear in clearOnLineQueue");
  }
  
  public void g(long paramLong1, long paramLong2, String paramString)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemRejectInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  void g(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, String.format("sendRoomInfoBroadcast, type[%s]", new Object[] { Integer.valueOf(paramInt) }));
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    String str = this.mApp.getCurrentAccountUin();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("buffer", paramArrayOfByte);
    this.mApp.getApp().sendBroadcast(localIntent);
  }
  
  public void h(long paramLong1, long paramLong2, String paramString)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoMemUntInvite");
      localIntent.putExtra("groupId", paramLong1);
      localIntent.putExtra("dealMemUin", paramLong2);
      localIntent.putExtra("invitedId", paramString);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void h(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.mApp != null)
    {
      localObject = this.mApp.getCurrentAccountUin();
      if (localObject != null) {
        Long.valueOf((String)localObject).longValue();
      }
    }
    Object localObject = new byte[2];
    System.arraycopy(paramArrayOfByte, 8, localObject, 0, 2);
    int n = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->tlvNum=" + n);
    }
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    int i = 10;
    int k = 0;
    if (k < n)
    {
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      i += 2;
      switch ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0)
      {
      default: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        for (;;)
        {
          k += 1;
          break;
          i += 2;
          System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, 4);
          i += 4;
          ihk.bytesToLong(arrayOfByte1, 4);
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 10;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          i += 6;
          continue;
          System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
          i = i + 2 + ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0);
          continue;
          i += 6;
        }
      }
      System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
      int i1 = ((localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0) / 8;
      long[] arrayOfLong = new long[i1];
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->userNum=" + i1);
      }
      j = i + 2;
      int m = 0;
      for (;;)
      {
        i = j;
        if (m >= i1) {
          break;
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, 8);
        ihk.bytesToLong(arrayOfByte2, 8);
        m += 1;
        j += 8;
      }
    }
    System.arraycopy(paramArrayOfByte, i, localObject, 0, 2);
    int j = (localObject[0] & 0xFF) << 8 | (localObject[1] & 0xFF) << 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->wReverseLen=" + j);
    }
    localObject = new byte[j];
    System.arraycopy(paramArrayOfByte, i + 2, localObject, 0, j);
    long l1 = ihk.bytesToLong((byte[])localObject, j);
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->uin=" + l1);
    }
    long l2;
    if (paramInt != 0)
    {
      if ((tB != null) && (!tB.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + tB.size());
        }
        paramInt = 0;
        while (paramInt < tB.size())
        {
          paramArrayOfByte = (acjq.a)tB.get(paramInt);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uin == l1) && (paramArrayOfByte.cH.compareAndSet(false, true)))
          {
            localObject = new byte[8];
            arrayOfByte1 = ((im_msg_body.MsgBody)paramArrayOfByte.msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte1, (arrayOfByte1[10] & 0xFF) + 19, localObject, 0, 8);
            l2 = ihk.bytesToLong((byte[])localObject, 8);
            VideoMsgTools.a(this.mApp, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { paramArrayOfByte.msg });
          }
          paramInt += 1;
        }
      }
    }
    else {
      if ((tB != null) && (!tB.isEmpty())) {
        break label856;
      }
    }
    label856:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->msgList size=" + tB.size());
          }
          paramArrayOfByte = new ArrayList();
          paramInt = 0;
          while (paramInt < tB.size())
          {
            localObject = (acjq.a)tB.get(paramInt);
            if ((localObject != null) && (((acjq.a)localObject).uin == l1) && (((acjq.a)localObject).cH.compareAndSet(false, true))) {
              paramArrayOfByte.add(localObject);
            }
            paramInt += 1;
          }
          Collections.sort(paramArrayOfByte, new acjq.b());
          paramInt = 0;
          while (paramInt < paramArrayOfByte.size() - 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoC2SACK_0x31-retCode->list =" + ((acjq.a)paramArrayOfByte.get(paramInt)).time);
            }
            localObject = (acjq.a)paramArrayOfByte.get(paramInt);
            arrayOfByte1 = new byte[8];
            arrayOfByte2 = ((im_msg_body.MsgBody)((acjq.a)localObject).msg.msg_body.get()).msg_content.get().toByteArray();
            System.arraycopy(arrayOfByte2, (arrayOfByte2[10] & 0xFF) + 19, arrayOfByte1, 0, 8);
            l2 = ihk.bytesToLong(arrayOfByte1, 8);
            VideoMsgTools.a(this.mApp, 0, 6, true, Long.toString(l1), Long.toString(l2), false, null, false, new Object[] { ((acjq.a)localObject).msg });
            paramInt += 1;
          }
        } while (paramArrayOfByte.size() <= 0);
        paramArrayOfByte = ((im_msg_body.MsgBody)((acjq.a)paramArrayOfByte.get(paramArrayOfByte.size() - 1)).msg.msg_body.get()).msg_content.get().toByteArray();
      } while (this.mBuffer == null);
      paramInt = paramArrayOfByte.length;
    } while (paramInt < 40);
    if (this.mBuffer.length < paramInt) {
      this.mBuffer = new byte[paramInt];
    }
    System.arraycopy(paramArrayOfByte, 0, this.mBuffer, 0, paramInt);
    aF(this.mBuffer);
  }
  
  public void hH(long paramLong)
  {
    if (this.mApp != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.GvideoRankListUpdate");
      localIntent.putExtra("groupId", paramLong);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  void hI(long paramLong)
  {
    if ((this.b == null) || (this.mApp == null)) {}
    long l;
    do
    {
      return;
      l = this.b.d(2, paramLong);
      QLog.w("QQGAudioMsgHandler", 1, "onMultiRoomDestroy, discussId[" + paramLong + "], roomMemberNum[" + l + "]");
    } while (l <= 0L);
    this.b.a(4, 2, paramLong, null, 0L);
    String str = this.mApp.getCurrentAccountUin();
    this.b.b(21, 2, paramLong, 0L);
    ((acdt)this.mApp.getBusinessHandler(6)).hk(paramLong);
    VideoMsgTools.a(this.mApp, 3000, 14, false, String.valueOf(paramLong), str, false, null, false, new Object[0]);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (tB == null)) {}
    label80:
    do
    {
      do
      {
        for (;;)
        {
          return true;
          try
          {
            switch (paramMessage.what)
            {
            case 1: 
              if (!tB.isEmpty()) {
                break label80;
              }
              if (QLog.isColorLevel())
              {
                QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is empty!");
                return true;
              }
              break;
            }
          }
          catch (Exception paramMessage) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGAudioMsgHandler", 2, "handleMessage sDoubleMeetingMsg error!");
      return true;
      tB.clear();
    } while (!QLog.isColorLevel());
    QLog.d("QQGAudioMsgHandler", 2, "sDoubleMeetingMsg is clear after 10 seconds");
    return true;
    return true;
  }
  
  void l(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "showDevNotSurportMsg-->MsgType" + paramInt);
    }
    if (paramInt == 141)
    {
      paramInt = paramArrayOfByte[10];
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, (paramInt & 0xFF) + 34, arrayOfByte, 0, 4);
      l = ihk.a(arrayOfByte, 4);
      paramArrayOfByte = this.mApp.getCurrentAccountUin();
      VideoMsgTools.a(this.mApp, 3000, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
    }
    while (paramInt != 7) {
      return;
    }
    paramInt = (paramArrayOfByte[10] & 0xFF) + 19;
    byte[] arrayOfByte = new byte[8];
    System.arraycopy(paramArrayOfByte, paramInt, arrayOfByte, 0, 8);
    ihk.bytesToLong(arrayOfByte, 8);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, paramInt + 12, arrayOfByte, 0, 4);
    long l = ihk.a(arrayOfByte, 4);
    paramArrayOfByte = this.mApp.getCurrentAccountUin();
    VideoMsgTools.a(this.mApp, 1, 18, false, String.valueOf(l), paramArrayOfByte, false, null, false, new Object[0]);
  }
  
  boolean ur()
  {
    if (!imm.isSupportSharpAudio())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGAudioMsgHandler", 2, "device not surpport Sharp audio");
      }
      return false;
    }
    return true;
  }
  
  static class a
  {
    public AtomicBoolean cH;
    public msg_comm.Msg msg;
    public long time;
    public long uin;
    
    public a(msg_comm.Msg paramMsg, long paramLong1, long paramLong2)
    {
      this.msg = paramMsg;
      this.uin = paramLong1;
      this.time = paramLong2;
      this.cH = new AtomicBoolean(false);
    }
  }
  
  static class b
    implements Comparator<acjq.a>
  {
    public int a(acjq.a parama1, acjq.a parama2)
    {
      if (parama1.time < parama2.time) {
        return -1;
      }
      if (parama1.time > parama2.time) {
        return 1;
      }
      return 0;
    }
  }
  
  static class c
  {
    long QI;
    long QJ;
    long QK;
    long QL;
    long QM;
    long QN;
    long QO;
    int cxA;
    int cxB;
    int cxC;
    int cxD;
    int cxE;
    int cxF;
    int cxy;
    int cxz;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("{");
      localStringBuilder.append("wSubCmd: ").append(this.cxy);
      localStringBuilder.append(", llAccount: ").append(this.QI);
      localStringBuilder.append(", cKeyLen: ").append(this.cxz);
      localStringBuilder.append(", dwRoomNum: ").append(this.QJ);
      localStringBuilder.append(", dwClientSeq: ").append(this.QK);
      localStringBuilder.append(", llFromAccount: ").append(this.QL);
      localStringBuilder.append(", dwFlag: ").append(this.cxA);
      localStringBuilder.append(", cRelationBufLen: ").append(this.cxC);
      localStringBuilder.append(", dwRelationId: ").append(this.QM);
      localStringBuilder.append(", wCount: ").append(this.cxD);
      localStringBuilder.append(", dwSendTime: ").append(this.QN);
      localStringBuilder.append(", wReverseLen: ").append(this.cxE);
      localStringBuilder.append(", cOriginalType: ").append(this.cxF);
      localStringBuilder.append(", dwMsgSeq: ").append(this.QO);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acjq
 * JD-Core Version:    0.7.0.1
 */