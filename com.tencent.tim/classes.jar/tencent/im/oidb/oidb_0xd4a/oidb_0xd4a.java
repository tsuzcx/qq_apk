package tencent.im.oidb.oidb_0xd4a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonBody;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScore;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.PrefetchMutualMarkInfo;

public final class oidb_0xd4a
{
  public static final class FriendData
    extends MessageMicro<FriendData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0xcf4.CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4.CommonGroupChatInfo();
    public oidb_0xcf4.MutualMarkInfo msg_cur_mutual_mark_info = new oidb_0xcf4.MutualMarkInfo();
    public oidb_0xcf4.FriendInfo msg_friend_info = new oidb_0xcf4.FriendInfo();
    public final PBRepeatMessageField<oidb_0xcf4.DateTips> rpt_msg_data_tips = PBField.initRepeatMessage(oidb_0xcf4.DateTips.class);
    public final PBRepeatMessageField<oidb_0xcf4.DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4.DnaInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4.MutualMarkInfo> rpt_msg_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.MutualMarkInfo.class);
    public oidb_0xcf4.MutualScore rpt_msg_mutual_score = new oidb_0xcf4.MutualScore();
    public final PBRepeatMessageField<oidb_0xcf4.PrefetchMutualMarkInfo> rpt_msg_prefetch_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.PrefetchMutualMarkInfo.class);
    public final PBBytesField string_reddot_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 98, 106, 114, 122, 130, 138, 146 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_cur_mutual_mark_info", "msg_friend_info", "msg_common_group_chat_info", "rpt_msg_mutual_mark_info", "rpt_msg_dna_info", "rpt_msg_prefetch_mutual_mark_info", "rpt_msg_data_tips", "rpt_msg_mutual_score", "string_reddot_data" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null, null, null, localByteStringMicro }, FriendData.class);
    }
  }
  
  public static final class NotFriendData
    extends MessageMicro<NotFriendData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 98, 114 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_common_group_chat_info", "rpt_msg_dna_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null }, NotFriendData.class);
    public oidb_0xcf4.CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4.CommonGroupChatInfo();
    public final PBRepeatMessageField<oidb_0xcf4.DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4.DnaInfo.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_from_uin", "rpt_uint64_uin_list", "uint64_group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "rpt_msg_friend_data", "rpt_msg_not_friend_data", "uint64_group_code", "rpt_msg_common_rspbody" }, new Object[] { null, null, Long.valueOf(0L), null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_rspbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
    public final PBRepeatMessageField<oidb_0xd4a.FriendData> rpt_msg_friend_data = PBField.initRepeatMessage(oidb_0xd4a.FriendData.class);
    public final PBRepeatMessageField<oidb_0xd4a.NotFriendData> rpt_msg_not_friend_data = PBField.initRepeatMessage(oidb_0xd4a.NotFriendData.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd4a.oidb_0xd4a
 * JD-Core Version:    0.7.0.1
 */