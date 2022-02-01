import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.2;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.4;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.5;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.8;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.9;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo.Biu0x210Msg.1;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.BBInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.NotifyBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.RedPointInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.StyleSheet;
import tencent.im.s2c.msgtype0x210.submsgtype0xc5.submsgtype0xc5.TipsBody;

public class mhm
{
  public static int aRO = -1;
  public static int aRP = aRO + 1;
  public static int aRQ = aRP + 1;
  public static int aRR = -1;
  public static int aRS = aRR + 1;
  public static int aRT = aRS + 1;
  public static int aRU = aRT + 1;
  public int aRJ;
  public int aRK;
  public int aRL;
  public int aRM;
  public int aRN;
  public String ahb;
  public String ahc;
  public String ahd;
  public String ahe;
  public int bid;
  private byte[] bp;
  public String cookie;
  public ArrayList<MySelfNormalItemRedPointInfo> kV = new ArrayList();
  public int msgCount = 1;
  public String msgId;
  public long msgSeq;
  public long msgTime;
  public int msgType;
  public String orangeWord;
  public long rX;
  public String summary;
  public int tipType;
  public long vh;
  public long vi;
  
  public static mhm a()
  {
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_ox210_msg", ""), localSharedPreferences.getInt("kandian_push_ox210_c5_msg_count", 1)));
  }
  
  private static mhm a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(aqoj.ag(paramString), paramInt);
  }
  
  private static mhm a(mhm parammhm)
  {
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
    if ((localSharedPreferences == null) || (parammhm == null)) {
      return parammhm;
    }
    parammhm.msgTime = localSharedPreferences.getLong("kandian_push_0x210_c5_msg_time", 0L);
    return parammhm;
  }
  
  public static mhm a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 1);
  }
  
  public static mhm a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    mhm localmhm = new mhm();
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        localmhm.msgCount = paramInt;
        localmhm.bp = paramArrayOfByte;
        localmhm.bid = localMsgBody.uint32_source.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, bid = " + localmhm.bid);
        }
        localmhm.aRJ = localMsgBody.uint32_bid.get();
        if (QLog.isColorLevel()) {
          QLog.d("KandianOx210MsgInfo", 2, "receive push 0xc5, realbid = " + localmhm.aRJ);
        }
        localmhm.rX = localMsgBody.uint64_article_id.get();
        localmhm.msgSeq = localMsgBody.uint64_seq.get();
        if (localMsgBody.bytes_diandian_cookie.has()) {
          localmhm.cookie = localMsgBody.bytes_diandian_cookie.get().toStringUtf8();
        }
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null))
        {
          Object localObject2;
          if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get() != null))
          {
            localmhm.kV.clear();
            paramArrayOfByte = ((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).red_point_info.get();
            paramInt = 0;
            if (paramInt < paramArrayOfByte.size())
            {
              localObject1 = (submsgtype0xc5.RedPointInfo)paramArrayOfByte.get(paramInt);
              localObject2 = new MySelfNormalItemRedPointInfo();
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint32_item_id.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).itemId = ((submsgtype0xc5.RedPointInfo)localObject1).uint32_item_id.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).red_point_item_type.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).redPointType = ((submsgtype0xc5.RedPointInfo)localObject1).red_point_item_type.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).bytes_url.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).imgUrl = ((submsgtype0xc5.RedPointInfo)localObject1).bytes_url.get().toStringUtf8();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint64_effect_time.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).effectTime = ((submsgtype0xc5.RedPointInfo)localObject1).uint64_effect_time.get();
              }
              if (((submsgtype0xc5.RedPointInfo)localObject1).uint64_failure_time.has()) {
                ((MySelfNormalItemRedPointInfo)localObject2).failureTime = ((submsgtype0xc5.RedPointInfo)localObject1).uint64_failure_time.get();
              }
              localmhm.kV.add(localObject2);
              paramInt += 1;
              continue;
            }
          }
          Object localObject1 = (submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get();
          if (((submsgtype0xc5.StyleSheet)localObject1).uint32_show_folder.has())
          {
            paramInt = ((submsgtype0xc5.StyleSheet)localObject1).uint32_show_folder.get();
            localmhm.aRL = paramInt;
            if (!((submsgtype0xc5.StyleSheet)localObject1).folder_red_type.has()) {
              break label1234;
            }
            paramInt = ((submsgtype0xc5.StyleSheet)localObject1).folder_red_type.get();
            localmhm.aRN = paramInt;
            if (!((submsgtype0xc5.StyleSheet)localObject1).bytes_orange_word.has()) {
              break label1239;
            }
            paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).bytes_orange_word.get().toStringUtf8();
            localmhm.orangeWord = paramArrayOfByte;
            if (!((submsgtype0xc5.StyleSheet)localObject1).bytes_summary.has()) {
              break label1244;
            }
            paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).bytes_summary.get().toStringUtf8();
            localmhm.summary = paramArrayOfByte;
            if (((!((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get() == null)) && (localmhm.kV.size() == 0)) {
              return null;
            }
            if (((!((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.has()) || (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get() == null)) && (localmhm.kV.size() > 0)) {
              return localmhm;
            }
            localObject2 = (submsgtype0xc5.TipsBody)((submsgtype0xc5.StyleSheet)((submsgtype0xc5.StyleSheet)localObject1).get()).msg_tip_body.get();
            if (((submsgtype0xc5.StyleSheet)localObject1).uint32_show_lock_screen.has())
            {
              paramInt = ((submsgtype0xc5.StyleSheet)localObject1).uint32_show_lock_screen.get();
              localmhm.aRM = paramInt;
              paramInt = i;
              if (((submsgtype0xc5.TipsBody)localObject2).tips_ui_type.has()) {
                paramInt = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.tips_ui_type.get();
              }
              localmhm.tipType = paramInt;
              if (((submsgtype0xc5.TipsBody)localObject2).uint64_uin.has())
              {
                l = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.uint64_uin.get();
                localmhm.vi = l;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_icon_url.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_icon_url.get().toStringUtf8();
                localmhm.ahc = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_content.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_content.get().toStringUtf8();
                localmhm.ahb = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_schema.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_schema.get().toStringUtf8();
                localmhm.ahd = paramArrayOfByte;
                if (!((submsgtype0xc5.TipsBody)localObject2).bytes_business_info.has()) {
                  continue;
                }
                paramArrayOfByte = ((submsgtype0xc5.StyleSheet)localObject1).msg_tip_body.bytes_business_info.get().toStringUtf8();
                localmhm.ahe = paramArrayOfByte;
                if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has())) {
                  localmhm.msgType = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
                }
                if ((((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get() != null))
                {
                  paramArrayOfByte = (submsgtype0xc5.BBInfo)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_bb_info.get();
                  localmhm.vh = paramArrayOfByte.uint64_bb_uin.get();
                  localmhm.aRK = paramArrayOfByte.uint32_src.get();
                }
                localmhm.msgId = localMsgBody.str_msgid.get();
                return localmhm;
              }
            }
            else
            {
              paramInt = 0;
              continue;
            }
            long l = -1L;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
            paramArrayOfByte = null;
            continue;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("KandianOx210MsgInfo", 2, "receive push 0xc5, parse msgBody err,", paramArrayOfByte);
        }
        return null;
      }
      paramInt = 0;
      continue;
      label1234:
      paramInt = 0;
      continue;
      label1239:
      paramArrayOfByte = null;
      continue;
      label1244:
      paramArrayOfByte = null;
    }
  }
  
  public static mhm b()
  {
    return a(a(awit.a(kxm.getAppRuntime(), true, false).getString("kandian_push_0x210_msg_for_follow", ""), 1));
  }
  
  public static mhm c()
  {
    return a(a(awit.a(kxm.getAppRuntime(), true, false).getString("kandian_push_0x210_msg_for_follow_show_in_folder", ""), 1));
  }
  
  public static mhm d()
  {
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
    return a(a(localSharedPreferences.getString("kandian_push_0x210_msg_sys", ""), localSharedPreferences.getInt("kandian_push_0x210_msg_sys_count", 1)));
  }
  
  public static mhm e()
  {
    SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
    return a(a(localSharedPreferences.getString("kandian_0x210_c5_normal_item_body", ""), localSharedPreferences.getInt("kandian_0x210_c5_normal_item_msg_count", 1)));
  }
  
  public static int o(byte[] paramArrayOfByte)
  {
    int i = aRO;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          j = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (j)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int j;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i);
      }
      return i;
      j = aRP;
      i = j;
      continue;
      j = aRQ;
      i = j;
      continue;
      j = aRP;
      i = j;
      continue;
      j = aRP;
      i = j;
      continue;
      j = aRP;
      i = j;
    }
  }
  
  public static int p(byte[] paramArrayOfByte)
  {
    int i = aRR;
    for (;;)
    {
      try
      {
        submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if ((localMsgBody.msg_notify_infos.has()) && (localMsgBody.msg_notify_infos.get() != null) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.has()) && (((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get() != null) && (((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.has()))
        {
          j = ((submsgtype0xc5.StyleSheet)((submsgtype0xc5.NotifyBody)localMsgBody.msg_notify_infos.get()).msg_style_sheet.get()).msg_type.get();
          switch (j)
          {
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        int j;
        paramArrayOfByte.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgType = " + i);
      }
      return i;
      j = aRS;
      i = j;
      continue;
      j = aRS;
      i = j;
      continue;
      j = aRT;
      i = j;
      continue;
      j = aRU;
      i = j;
    }
  }
  
  public static int q(byte[] paramArrayOfByte)
  {
    try
    {
      submsgtype0xc5.MsgBody localMsgBody = new submsgtype0xc5.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      if (!localMsgBody.uint32_bid.has()) {
        break label85;
      }
      int j = localMsgBody.uint32_bid.get();
      if (j <= 2)
      {
        i = j;
        if (j >= 1) {}
      }
      else
      {
        i = 0;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        label85:
        int i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("KandianOx210MsgInfo", 2, "get0x210MsgBID = " + i);
    }
    return i;
  }
  
  public void U(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.2(this, paramQQAppInterface));
  }
  
  public void V(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.4(this, paramQQAppInterface));
  }
  
  public void W(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.5(this, paramQQAppInterface));
  }
  
  public void X(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.9(this, paramQQAppInterface));
  }
  
  public void e(AppRuntime paramAppRuntime)
  {
    ThreadManager.getSubThreadHandler().post(new KandianOx210MsgInfo.8(this, paramAppRuntime));
  }
  
  public String jO()
  {
    return aqoj.C(this.bp);
  }
  
  public static class a
  {
    public long msgSeq = -1L;
    public int status = -1;
    public long vj = -1L;
    
    public static a a()
    {
      a locala = new a();
      SharedPreferences localSharedPreferences = awit.a(kxm.getAppRuntime(), true, false);
      locala.msgSeq = localSharedPreferences.getLong("kandian_biu_0x210_seq", -1L);
      locala.vj = localSharedPreferences.getLong("kandian_biu_0x210_uin", -1L);
      locala.status = localSharedPreferences.getInt("kandian_biu_0x210_status", -1);
      return locala;
    }
    
    public void Y(QQAppInterface paramQQAppInterface)
    {
      ThreadManager.post(new KandianOx210MsgInfo.Biu0x210Msg.1(this, paramQQAppInterface), 8, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mhm
 * JD-Core Version:    0.7.0.1
 */