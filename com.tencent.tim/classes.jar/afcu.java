import android.os.Bundle;
import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x876.oidb_0x876.ReqBody;
import tencent.im.oidb.cmd0x877.oidb_0x877.FollowInfo;
import tencent.im.oidb.cmd0x877.oidb_0x877.InteractInfo;
import tencent.im.oidb.cmd0x877.oidb_0x877.MsgWord;
import tencent.im.oidb.cmd0x877.oidb_0x877.ReqBody;
import tencent.im.oidb.cmd0x877.oidb_0x877.RspBody;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;
import tencent.nearby.now.nearby_now_anchor.ReqBatchGetAnchorStatus;
import tencent.nearby.now.nearby_now_anchor.RspBatchGetAnchorStatus;

public class afcu
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, afcu.a parama)
  {
    oidb_0x877.ReqBody localReqBody = new oidb_0x877.ReqBody();
    localReqBody.uint32_refer.set(paramInt);
    jnm.a(paramQQAppInterface, parama, localReqBody.toByteArray(), "OidbSvc.0x877_0", 2167, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, afcu.b paramb)
  {
    jnm.a(paramQQAppInterface, paramb, new oidb_0x876.ReqBody().toByteArray(), "OidbSvc.0x876_" + paramInt, 2166, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<Long> paramList, Bundle paramBundle, afcu.c paramc)
  {
    nearby_now_anchor.ReqBatchGetAnchorStatus localReqBatchGetAnchorStatus = new nearby_now_anchor.ReqBatchGetAnchorStatus();
    localReqBatchGetAnchorStatus.uint64_uin.set(paramList);
    paramList = paramBundle;
    if (paramBundle == null) {
      paramList = new Bundle();
    }
    jnm.a(paramQQAppInterface, paramc, localReqBatchGetAnchorStatus.toByteArray(), "NearbyNowTips.batch_get_anchor_stats", paramList);
  }
  
  public static void cM(QQAppInterface paramQQAppInterface)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    localReqBody.uid.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    localReqBody.tinyid.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str = ((TicketManager)localObject).getA2(paramQQAppInterface.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(paramQQAppInterface.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localReqBody.a2.set(str);
      localReqBody.platform.set(1);
      localReqBody.version.set("3.4.4");
      localReqBody.original_id.set(paramQQAppInterface.getCurrentAccountUin());
      localReqBody.original_key.set((String)localObject);
      localReqBody.original_id_type.set(1);
    }
    localReqBody.cmd.set(24727);
    localReqBody.subcmd.set(6);
    jnm.a(paramQQAppInterface, new afcv(), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
  
  public static abstract class a
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box.protocol", 2, "UnReadFeedObserver, errorCode=" + paramInt);
      }
      oidb_0x877.RspBody localRspBody;
      if (paramInt == 0) {
        localRspBody = new oidb_0x877.RspBody();
      }
      label723:
      label981:
      for (;;)
      {
        boolean bool2;
        int i;
        long l2;
        long l1;
        boolean bool1;
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          if (!localRspBody.interact_info.has()) {
            break label792;
          }
          bool2 = true;
          i = 0;
          l2 = 0L;
          paramArrayOfByte = new StringBuilder();
          if (!localRspBody.interact_info.uint32_interact_flag.has()) {
            break label753;
          }
          if (localRspBody.interact_info.uint32_interact_flag.get() != 0) {
            break label740;
          }
          if (!localRspBody.interact_info.interact_word.has()) {
            break label723;
          }
          if (localRspBody.interact_info.interact_word.bytes_from_user.has()) {
            paramArrayOfByte.append(localRspBody.interact_info.interact_word.bytes_from_user.get().toStringUtf8());
          }
          if (localRspBody.interact_info.interact_word.bytes_buluo_word.has())
          {
            paramArrayOfByte.append(afcw.kv(afcw.ku(localRspBody.interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
            paramInt = localRspBody.interact_info.uint32_interact_count.get();
            l1 = localRspBody.interact_info.uint64_interact_info_time.get();
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg_box.protocol", 2, "interact_info|needShow=" + bool1 + ",rawcontext=" + paramArrayOfByte.toString() + ",unReadCount=" + paramInt + ",timeStamp=" + l1);
            }
            if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l1 != 0L)) {
              break label981;
            }
            bool1 = false;
            a(true, paramArrayOfByte.toString(), paramInt, l1, bool1, paramBundle);
            if (!localRspBody.follow_info.has()) {
              break label946;
            }
            bool2 = true;
            i = 0;
            l2 = 0L;
            paramArrayOfByte = new StringBuilder();
            if (!localRspBody.follow_info.uint32_follow_flag.has()) {
              break label907;
            }
            if (localRspBody.follow_info.uint32_follow_flag.get() != 0) {
              break label894;
            }
            if (!localRspBody.follow_info.follow_word.has()) {
              break label877;
            }
            if (localRspBody.follow_info.follow_word.bytes_from_user.has()) {
              paramArrayOfByte.append(localRspBody.follow_info.follow_word.bytes_from_user.get().toStringUtf8());
            }
            if (!localRspBody.follow_info.follow_word.bytes_buluo_word.has()) {
              break label805;
            }
            paramArrayOfByte.append(afcw.kv(afcw.ku(localRspBody.interact_info.interact_word.bytes_buluo_word.get().toStringUtf8())));
            paramInt = localRspBody.follow_info.uint32_follow_count.get();
            l1 = localRspBody.follow_info.uint64_follow_info_time.get();
            bool1 = true;
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg_box.protocol", 2, "follow_info|needShow=" + bool1 + ",rawcontext=" + paramArrayOfByte.toString() + ",unReadCount=" + paramInt + ",timeStamp=" + l1);
            }
            if ((!TextUtils.isEmpty(paramArrayOfByte.toString())) && (l1 != 0L)) {
              break label978;
            }
            bool1 = false;
            b(true, paramArrayOfByte.toString(), paramInt, l1, bool1, paramBundle);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg_box.protocol", 2, paramArrayOfByte.toString(), paramArrayOfByte);
          }
          a(false, null, 0, 0L, false, paramBundle);
          b(false, null, 0, 0L, false, paramBundle);
          return;
        }
        if (localRspBody.interact_info.interact_word.rich_fresh_word.has())
        {
          paramArrayOfByte.append(afcw.a((appoint_define.RichText)localRspBody.interact_info.interact_word.rich_fresh_word.get(), 14));
        }
        else
        {
          paramArrayOfByte.append(localRspBody.interact_info.interact_word.bytes_plain_text.get().toStringUtf8());
          continue;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg_box.protocol", 2, "resp.interact_info.interact_word.has() == false");
            continue;
            label740:
            bool1 = false;
            paramInt = i;
            l1 = l2;
            continue;
            label753:
            bool1 = bool2;
            paramInt = i;
            l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.msg_box.protocol", 2, "uint32_interact_flag.has()= false");
              bool1 = bool2;
              paramInt = i;
              l1 = l2;
              continue;
              a(true, null, 0, 0L, false, paramBundle);
              continue;
              if (localRspBody.follow_info.follow_word.rich_fresh_word.has())
              {
                paramArrayOfByte.append(afcw.a((appoint_define.RichText)localRspBody.follow_info.follow_word.rich_fresh_word.get(), 14));
              }
              else
              {
                paramArrayOfByte.append(localRspBody.follow_info.follow_word.bytes_plain_text.get().toStringUtf8());
                continue;
                label877:
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.msg_box.protocol", 2, "resp.follow_info.follow_word.has() == false");
                  continue;
                  label894:
                  bool1 = false;
                  paramInt = i;
                  l1 = l2;
                  continue;
                  bool1 = bool2;
                  paramInt = i;
                  l1 = l2;
                  if (QLog.isColorLevel())
                  {
                    QLog.i("Q.msg_box.protocol", 2, "uint32_follow_flag.has()= false");
                    bool1 = bool2;
                    paramInt = i;
                    l1 = l2;
                    continue;
                    b(true, null, 0, 0L, false, paramBundle);
                    return;
                    a(false, null, 0, 0L, false, paramBundle);
                    b(false, null, 0, 0L, false, paramBundle);
                    return;
                  }
                }
              }
            }
          }
        }
      }
    }
    
    protected abstract void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
    
    protected abstract void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle);
  }
  
  public static abstract class b
    extends jnm.d
  {}
  
  public static abstract class c
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      boolean bool4 = false;
      boolean bool3 = false;
      Object localObject = null;
      nearby_now_anchor.RspBatchGetAnchorStatus localRspBatchGetAnchorStatus;
      boolean bool1;
      if (paramInt == 0)
      {
        localRspBatchGetAnchorStatus = new nearby_now_anchor.RspBatchGetAnchorStatus();
        bool1 = bool4;
      }
      for (;;)
      {
        try
        {
          localRspBatchGetAnchorStatus.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = localObject;
          bool2 = bool3;
          bool1 = bool4;
          if (localRspBatchGetAnchorStatus.uint32_result.has())
          {
            paramArrayOfByte = localObject;
            bool2 = bool3;
            bool1 = bool4;
            if (localRspBatchGetAnchorStatus.uint32_result.get() == 0)
            {
              bool1 = true;
              bool2 = true;
              paramArrayOfByte = localRspBatchGetAnchorStatus.msg_anchor_stats.get();
            }
          }
        }
        catch (Exception localException)
        {
          paramArrayOfByte = localObject;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg_box.protocol", 2, localException.toString());
          paramArrayOfByte = localObject;
          bool2 = bool1;
          continue;
        }
        b(bool2, paramArrayOfByte, paramBundle);
        return;
        paramArrayOfByte = localObject;
        boolean bool2 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.msg_box.protocol", 2, "getNowState failed, errorCode=" + paramInt);
          paramArrayOfByte = localObject;
          bool2 = bool3;
        }
      }
    }
    
    public abstract void b(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcu
 * JD-Core Version:    0.7.0.1
 */