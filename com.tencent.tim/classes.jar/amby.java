import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SHeartBeatReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CNotifyExitReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CPushDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.NetAddr;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class amby
  extends accg
{
  private static final Object eC = Integer.valueOf(2000);
  private alyi a = new alyi(paramAppInterface, this.b);
  public long aiw;
  private ambx b = new ambx();
  private Random mRandom = new Random();
  
  public amby(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private AudioTransClientTransInfo.IntHead a(int paramInt, String paramString)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    localIntHead.str_session_id.set(paramString);
    localIntHead.str_uin.set(this.mApp.getCurrentAccountUin());
    localIntHead.uint32_seq.set(this.mRandom.nextInt());
    localIntHead.enum_body_type.set(paramInt);
    return localIntHead;
  }
  
  private AudioTransClientTransInfo.IntReqBody a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AudioTransClientTransInfo.IntReqBody localIntReqBody = new AudioTransClientTransInfo.IntReqBody();
    if (paramInt1 == 1)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
      paramArrayOfByte.uint32_client_ver.set(1);
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_net_type.set(paramInt4);
      paramArrayOfByte.enum_business_direction.set(1);
      paramArrayOfByte.enum_data_source.set(2);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_join_session_req.set(paramArrayOfByte);
    }
    do
    {
      return localIntReqBody;
      if (paramInt1 == 3)
      {
        paramArrayOfByte = new AudioTransClientTransInfo.IntC2SExitSessionReq();
        localIntReqBody.msg_exit_session_req.set(paramArrayOfByte);
        return localIntReqBody;
      }
      if (paramInt1 == 7)
      {
        AudioTransClientTransInfo.IntC2SRawDataReq localIntC2SRawDataReq = new AudioTransClientTransInfo.IntC2SRawDataReq();
        if (paramArrayOfByte != null) {
          localIntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(paramArrayOfByte, paramInt2, paramInt3));
        }
        localIntC2SRawDataReq.str_key.set("audio_trans");
        localIntReqBody.msg_raw_data_req.set(localIntC2SRawDataReq);
        return localIntReqBody;
      }
      if (paramInt1 == 5)
      {
        paramArrayOfByte = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
        paramArrayOfByte.bool_translate.set(paramBoolean);
        localIntReqBody.msg_change_session_req.set(paramArrayOfByte);
        return localIntReqBody;
      }
    } while (paramInt1 != 9);
    paramArrayOfByte = new AudioTransClientTransInfo.IntC2SHeartBeatReq();
    localIntReqBody.msg_heart_beat_req.set(paramArrayOfByte);
    return localIntReqBody;
  }
  
  private void e(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = new AudioTransClientTransInfo.InfoHead();
    int i;
    try
    {
      paramArrayOfByte1 = (AudioTransClientTransInfo.InfoHead)((AudioTransClientTransInfo.InfoHead)localObject1).mergeFrom(paramArrayOfByte1);
      if (!paramArrayOfByte1.uint32_error_no.has()) {
        break label546;
      }
      paramArrayOfByte2 = (AudioTransClientTransInfo.InfoRspBody)new AudioTransClientTransInfo.InfoRspBody().mergeFrom(paramArrayOfByte2);
      if (paramArrayOfByte1.uint32_error_no.get() != 0) {
        break label486;
      }
      paramArrayOfByte2 = (AudioTransClientTransInfo.InfoC2SCreateSessionRsp)paramArrayOfByte2.msg_create_session_rsp.get();
      i = paramArrayOfByte2.enum_channel_type.get();
      paramArrayOfByte1 = paramArrayOfByte1.str_session_id.get();
      if (i != 1) {
        break label471;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PeakAudioTransHandler", 2, "channelType is CT_SSO");
      }
      i = paramArrayOfByte2.uint32_combine_num.get();
      if (QLog.isColorLevel()) {
        QLog.d("PeakAudioTransHandler", 2, "combineNum = " + i);
      }
      localObject1 = paramArrayOfByte2.rpt_msg_interface_list.get();
      paramArrayOfByte2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AudioTransCommon.NetAddr)((Iterator)localObject1).next();
        String str = ijf.aH(((AudioTransCommon.NetAddr)localObject2).fixed32_IP.get());
        int j = ((AudioTransCommon.NetAddr)localObject2).uint32_port.get();
        if (QLog.isColorLevel()) {
          QLog.d("PeakAudioTransHandler", 2, "fixed32_IP = " + str + "uint32_port = " + j);
        }
        localObject2 = new alyj(str, j);
        ((alyj)localObject2).dAj = i;
        paramArrayOfByte2.add(localObject2);
        continue;
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      QLog.e("PeakAudioTransHandler", 2, "exception = " + paramArrayOfByte1.getMessage());
    }
    if (!TextUtils.isEmpty(paramArrayOfByte1)) {}
    for (long l = Long.valueOf(paramArrayOfByte1).longValue();; l = 0L)
    {
      if (!paramArrayOfByte2.isEmpty())
      {
        if (this.b.avr())
        {
          this.b.Ul(2);
          paramArrayOfByte1 = (alyj)paramArrayOfByte2.get(0);
          this.a.eM(paramArrayOfByte2);
          this.a.a(paramArrayOfByte1, l);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("PeakAudioTransHandler", 1, "create delay = " + (System.currentTimeMillis() - this.aiw));
          return;
        }
        QLog.e("PeakAudioTransHandler", 1, "session not in opening state");
        notifyUI(3, true, new Object[] { Long.valueOf(l), Integer.valueOf(0) });
        return;
      }
      QLog.e("PeakAudioTransHandler", 1, "sessionIpList is null");
      return;
      label471:
      if (i != 2) {
        break;
      }
      QLog.d("PeakAudioTransHandler", 2, "channelType is CT_RELAY");
      return;
      label486:
      paramArrayOfByte1 = (AudioTransClientTransInfo.InfoC2SFailedRsp)paramArrayOfByte2.msg_failed_rsp.get();
      QLog.d("PeakAudioTransHandler", 2, "create session rsp failed, errcode:" + paramArrayOfByte1.uint32_errcode.get() + "  msg:" + paramArrayOfByte1.str_errmsg.get());
      return;
      label546:
      QLog.e("PeakAudioTransHandler", 2, "response not return uint32_error_no");
      return;
    }
  }
  
  private void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    for (;;)
    {
      long l;
      try
      {
        paramArrayOfByte1 = (AudioTransClientTransInfo.IntHead)localIntHead.mergeFrom(paramArrayOfByte1);
        if (!paramArrayOfByte1.uint32_error_no.has()) {
          break label560;
        }
        i = paramArrayOfByte1.uint32_error_no.get();
        if (!paramArrayOfByte1.enum_body_type.has()) {
          break label554;
        }
        j = paramArrayOfByte1.enum_body_type.get();
        l = 0L;
        if (paramArrayOfByte1.str_session_id.has()) {
          l = Long.valueOf(paramArrayOfByte1.str_session_id.get()).longValue();
        }
        QLog.d("PeakAudioTransHandler", 2, "onReceive result:" + i + " sessionid:" + l + " bodyType:" + j);
        paramArrayOfByte2 = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramArrayOfByte2);
        if (i != 0) {
          break label472;
        }
        if (j == 2)
        {
          paramArrayOfByte1 = (AudioTransClientTransInfo.IntC2SJoinSessionRsp)paramArrayOfByte2.msg_join_session_rsp.get();
          i = paramArrayOfByte1.uint32_combine_num.get();
          j = paramArrayOfByte1.uint32_heartbeat_duration.get();
          if (QLog.isColorLevel()) {
            QLog.d("PeakAudioTransHandler", 2, "combineNum = " + i + "\nheartBeatDuration = " + j);
          }
          notifyUI(1, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
        if (j == 4)
        {
          this.b.Ul(0);
          notifyUI(2, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          ax(l, false);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte1)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PeakAudioTransHandler", 2, "exception = " + paramArrayOfByte1.getMessage(), paramArrayOfByte1);
        return;
      }
      if (j == 8) {
        break;
      }
      if (j == 6)
      {
        paramArrayOfByte1 = (AudioTransClientTransInfo.IntC2SChangeSessionRsp)paramArrayOfByte2.msg_change_session_rsp.get();
        i = paramArrayOfByte1.uint32_combine_num.get();
        j = paramArrayOfByte1.enum_channel_type.get();
        QLog.d("PeakAudioTransHandler", 2, "enum_channel_type = " + j + "  uint32_combine_num = " + i);
        notifyUI(4, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
        return;
      }
      if ((j != 10) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("PeakAudioTransHandler", 2, "onReceiveOther INT_C2S_HEART_BEAT_RSP heartbeat !");
      return;
      label472:
      paramArrayOfByte2 = (AudioTransClientTransInfo.IntC2SFailedRsp)paramArrayOfByte2.msg_failed_rsp.get();
      QLog.d("PeakAudioTransHandler", 2, "create session rsp fail msg: " + paramArrayOfByte1.uint32_error_no.get() + " uint32_errcode = " + paramArrayOfByte2.uint32_errcode.get() + " str_errmsg = " + paramArrayOfByte2.str_errmsg.get());
      lc(l);
      return;
      label554:
      int j = 0;
      continue;
      label560:
      int i = 0;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakAudioTransHandler", 2, "sendRawDataToServer, cmd = " + paramString2 + ", sendReq ip = " + paramString3 + ", port = " + paramInt1 + " strSessionID =" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    paramInt1 = -1;
    if ("TransInfo.RawData".equals(paramString2)) {
      paramInt1 = 7;
    }
    for (;;)
    {
      try
      {
        paramString1 = a(paramInt1, paramString1);
        paramString2 = a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramBoolean, paramInt4);
        paramString1 = ijf.g(paramString1.toByteArray(), paramString2.toByteArray());
        if (this.a == null) {
          break;
        }
        if (this.a.hasNet()) {
          break label200;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PeakAudioTransHandler", 2, "sendCmdToServerByTcp network is not available");
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if ("TransInfo.HeartBeat".equals(paramString2)) {
        paramInt1 = 9;
      } else {
        QLog.e("PeakAudioTransHandler", 2, "unknown cmd");
      }
    }
    label200:
    this.a.br(paramString1);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramArrayOfByte, paramInt1, paramInt2, paramBoolean, 2);
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakAudioTransHandler", 2, "sendCmdToService cmd = " + paramString2 + " len:" + paramInt2 + " sessionid:" + paramString1 + " withEnglish:" + paramBoolean);
    }
    long l = -1L;
    if (paramString1 != null) {
      l = Long.valueOf(paramString1).longValue();
    }
    if (!this.b.avx())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "sendCmdToService state legal cmd = " + paramString2);
      }
      lc(l);
    }
    int i;
    label648:
    label652:
    do
    {
      do
      {
        ToServiceMsg localToServiceMsg;
        for (;;)
        {
          return;
          localToServiceMsg = createToServiceMsg(paramString2);
          if ("TransInfoCreate.CreateSession".equals(paramString2))
          {
            paramString1 = new AudioTransClientTransInfo.InfoHead();
            paramString1.str_session_id.set(String.valueOf(0));
            paramString1.str_uin.set(this.mApp.getCurrentAccountUin());
            paramString1.uint32_seq.set(this.mRandom.nextInt());
            paramString1.enum_body_type.set(1);
            paramString2 = new AudioTransClientTransInfo.InfoReqBody();
            paramArrayOfByte = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
            paramArrayOfByte.enum_business_type.set(3);
            paramArrayOfByte.enum_term.set(4);
            paramArrayOfByte.enum_business_direction.set(1);
            paramArrayOfByte.uint32_client_ver.set(1);
            paramArrayOfByte.enum_net_type.set(paramInt3);
            paramArrayOfByte.bool_translate.set(paramBoolean);
            paramArrayOfByte.rpt_member_list.set(Arrays.asList(new String[] { paramString1.str_uin.get() }));
            paramString2.msg_create_session_req.set(paramArrayOfByte);
            paramString1 = ijf.g(paramString1.toByteArray(), paramString2.toByteArray());
            this.aiw = System.currentTimeMillis();
            localToServiceMsg.putWupBuffer(paramString1);
            if (!this.b.avs())
            {
              if (QLog.isColorLevel()) {
                QLog.e("PeakAudioTransHandler", 2, "sendCmdToService create last session not close state = " + this.b.Iw());
              }
              if (paramBoolean) {}
              for (paramInt1 = 0;; paramInt1 = 1)
              {
                this.b.Un(paramInt1);
                return;
              }
            }
            if (this.a.hasNet())
            {
              sendPbReq(localToServiceMsg);
              this.b.Ul(1);
              return;
            }
            QLog.e("PeakAudioTransHandler", 2, "sendCmdToService create network is not available");
            return;
          }
          i = -1;
          if ("TransInfo.JoinSession".equals(paramString2))
          {
            i = 1;
            paramString1 = a(i, paramString1);
            paramString2 = a(i, paramArrayOfByte, paramInt1, paramInt2, paramBoolean, paramInt3);
            localToServiceMsg.putWupBuffer(ijf.g(paramString1.toByteArray(), paramString2.toByteArray()));
            if (this.b.avq()) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.e("PeakAudioTransHandler", 2, "sendCmdToService other  session not open ! state =" + this.b.Iw());
            }
            paramInt1 = -1;
            if (i == 5) {
              if (!paramBoolean) {
                break label648;
              }
            }
          }
          for (paramInt1 = 2;; paramInt1 = 3)
          {
            if (paramInt1 == -1) {
              break label652;
            }
            this.b.Un(paramInt1);
            return;
            if ("TransInfo.ExitSession".equals(paramString2))
            {
              i = 3;
              break;
            }
            if ("TransInfo.ChangeSession".equals(paramString2))
            {
              i = 5;
              break;
            }
            if ("TransInfo.RawData".equals(paramString2))
            {
              i = 7;
              break;
            }
            if ("TransInfo.HeartBeat".equals(paramString2))
            {
              i = 9;
              break;
            }
            QLog.e("PeakAudioTransHandler", 2, "unknown cmd");
            break;
          }
        }
        if (!this.a.hasNet()) {
          break;
        }
        sendPbReq(localToServiceMsg);
      } while (i != 3);
      this.b.Ul(3);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "sendCmdToService others network is not available");
      }
    } while (i != 3);
    this.b.reset();
  }
  
  public void ax(long paramLong, boolean paramBoolean)
  {
    if (!this.b.avx())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "processNextEvent state legal lSessionID = " + paramLong);
      }
      lc(paramLong);
    }
    int i;
    do
    {
      return;
      i = this.b.Iy();
      QLog.d("PeakAudioTransHandler", 2, "nextEvent = " + i);
      switch (i)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent list is null");
    return;
    if (!paramBoolean)
    {
      a(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
      return;
    }
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + i);
    return;
    if (!paramBoolean)
    {
      a(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
      return;
    }
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + i);
    return;
    if (paramBoolean)
    {
      QLog.d("PeakAudioTransHandler", 2, "processNextEvent close tcp");
      this.a.kT(paramLong);
      return;
    }
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already closed");
    return;
    if (!paramBoolean)
    {
      a(null, "TransInfoCreate.CreateSession", null, 0, 0, true);
      return;
    }
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + i);
    lc(paramLong);
    return;
    if (!paramBoolean)
    {
      a(null, "TransInfoCreate.CreateSession", null, 0, 0, false);
      return;
    }
    QLog.d("PeakAudioTransHandler", 2, "processNextEvent already open nextEvent = " + i);
    lc(paramLong);
  }
  
  public void d(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = ijf.a(paramArrayOfByte);
    paramArrayOfByte = ((ijf.a)localObject).head;
    localObject = ((ijf.a)localObject).body;
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (AudioTransClientTransInfo.IntHead)localIntHead.mergeFrom(paramArrayOfByte);
        if (!paramArrayOfByte.enum_body_type.has()) {
          break label544;
        }
        i = paramArrayOfByte.enum_body_type.get();
        if (!paramArrayOfByte.str_session_id.has()) {
          break label538;
        }
        l = Long.valueOf(paramArrayOfByte.str_session_id.get()).longValue();
        if (!paramArrayOfByte.uint32_error_no.has()) {
          break label533;
        }
        paramInt = paramArrayOfByte.uint32_error_no.get();
        if (paramInt != 0) {
          break label476;
        }
        paramArrayOfByte = (AudioTransClientTransInfo.IntReqBody)new AudioTransClientTransInfo.IntReqBody().mergeFrom((byte[])localObject);
        switch (i)
        {
        case 11: 
          paramArrayOfByte = ((AudioTransClientTransInfo.IntS2CPushDataReq)paramArrayOfByte.msg_push_data_req.get()).translate_result.get().toByteArray();
          localObject = (AudioTransCommon.TranslateResult)new AudioTransCommon.TranslateResult().mergeFrom(paramArrayOfByte);
          paramInt = ((AudioTransCommon.TranslateResult)localObject).int32_end_seq.get();
          i = ((AudioTransCommon.TranslateResult)localObject).int32_start_seq.get();
          paramArrayOfByte = ((AudioTransCommon.TranslateResult)localObject).bytes_tar_text.get().toStringUtf8();
          int j = ((AudioTransCommon.TranslateResult)localObject).int32_status.get();
          localObject = ((AudioTransCommon.TranslateResult)localObject).bytes_src_text.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.d("PeakAudioTransHandler", 2, "onReceivePush strChinese:" + (String)localObject + " strEnglish:" + paramArrayOfByte);
          }
          notifyUI(0, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j), localObject, paramArrayOfByte });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("PeakAudioTransHandler", 2, "onReceivePush exception = " + paramArrayOfByte.getMessage(), paramArrayOfByte);
        return;
      }
      paramArrayOfByte = (AudioTransClientTransInfo.IntS2CNotifyExitReq)paramArrayOfByte.msg_notify_exit_req.get();
      if (paramArrayOfByte.uint32_reason.has()) {}
      for (int i = paramArrayOfByte.uint32_reason.get();; i = -1)
      {
        QLog.d("PeakAudioTransHandler", 2, "onReceivePush exit:" + i);
        notifyUI(2, true, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
        return;
        QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat req:");
        return;
        QLog.d("PeakAudioTransHandler", 2, "onReceivePush heartbeat rsp:");
        return;
        label476:
        notifyUI(3, true, new Object[] { Long.valueOf(l), Integer.valueOf(paramInt) });
        QLog.e("PeakAudioTransHandler", 2, "onReceivePush error:" + paramInt);
        return;
      }
      label533:
      paramInt = 0;
      continue;
      label538:
      long l = 0L;
      continue;
      label544:
      i = 0;
    }
  }
  
  public void lb(long paramLong)
  {
    if (!this.b.avx())
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakAudioTransHandler", 2, "closeWholeConnection state legal lSessionID = " + paramLong);
      }
      lc(paramLong);
    }
    do
    {
      do
      {
        return;
        if (!this.b.avq()) {
          break;
        }
        if (this.b.avt())
        {
          QLog.d("PeakAudioTransHandler", 2, "closeWholeConnection close tcp");
          this.a.kT(paramLong);
          return;
        }
        if (this.b.avv())
        {
          a(String.valueOf(paramLong), "TransInfo.ExitSession", null, 0, 0, false);
          return;
        }
        if (this.b.avu())
        {
          this.b.Un(4);
          return;
        }
      } while (!this.b.avw());
      this.b.Un(4);
      return;
    } while (this.b.avs());
    this.b.Un(4);
  }
  
  public void lc(long paramLong)
  {
    this.b.reset();
    notifyUI(3, true, new Object[] { Long.valueOf(paramLong), Integer.valueOf(0) });
  }
  
  protected Class<? extends acci> observerClass()
  {
    return amca.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = ijf.a(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramObject.head;
      paramObject = paramObject.body;
      if ("TransInfoCreate.CreateSession".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramObject);
        return;
      }
      f(paramToServiceMsg, paramObject);
      return;
    }
    QLog.e("PeakAudioTransHandler", 2, "onReceive fail, error msg is " + paramFromServiceMsg.getBusinessFailMsg());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amby
 * JD-Core Version:    0.7.0.1
 */