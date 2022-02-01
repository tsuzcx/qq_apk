package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xcf4
{
  public static final class CommonBody
    extends MessageMicro<CommonBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_oidb_body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_oidb_cmd = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 40 }, new String[] { "string_oidb_body", "uint32_oidb_cmd" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, CommonBody.class);
    }
  }
  
  public static final class CommonGroupChatInfo
    extends MessageMicro<CommonGroupChatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xcf4.OneGroupInfo msg_one_group_info = new oidb_0xcf4.OneGroupInfo();
    public final PBRepeatMessageField<oidb_0xcf4.OneGroupInfo> rpt_msg_one_group_info = PBField.initRepeatMessage(oidb_0xcf4.OneGroupInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_one_group_info", "msg_one_group_info", "bytes_wording" }, new Object[] { null, null, localByteStringMicro }, CommonGroupChatInfo.class);
    }
  }
  
  public static final class DateTips
    extends MessageMicro<DateTips>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_colour = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField eDateType = PBField.initEnum(1);
    public final PBEnumField eJumpType = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 64 }, new String[] { "eDateType", "bytes_icon_url", "bytes_wording", "bytes_link_url", "bytes_link_wording", "bytes_link_colour", "eJumpType" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(1) }, DateTips.class);
    }
  }
  
  public static final class DnaInfo
    extends MessageMicro<DnaInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_colour = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vice_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField eDnaType = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58 }, new String[] { "eDnaType", "bytes_icon_url", "bytes_wording", "bytes_vice_title", "bytes_link_url", "bytes_link_wording", "bytes_link_colour" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, DnaInfo.class);
    }
  }
  
  public static final class FriendInfo
    extends MessageMicro<FriendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_add_frd_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_add_frd_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_add_frd_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_add_frd_sub_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_add_frd_days", "uint32_add_frd_source", "uint32_add_frd_sub_source", "bytes_add_frd_wording" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, FriendInfo.class);
    }
  }
  
  public static final class MutualMarkInfo
    extends MessageMicro<MutualMarkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "eMutualMarkType", "uint32_level", "uint32_days", "eMutualMarkNewType", "msg_special_word_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), null }, MutualMarkInfo.class);
    public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
    public final PBEnumField eMutualMarkType = PBField.initEnum(0);
    public oidb_0xcf4.SpecialWordInfo msg_special_word_info = new oidb_0xcf4.SpecialWordInfo();
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  }
  
  public static final class MutualScore
    extends MessageMicro<MutualScore>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_current_score" }, new Object[] { Integer.valueOf(0) }, MutualScore.class);
    public final PBUInt32Field uint32_current_score = PBField.initUInt32(0);
  }
  
  public static final class MutualScoreCard
    extends MessageMicro<MutualScoreCard>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_describe = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_level_describe = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_type_describe = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82, 88, 98, 106, 114, 122 }, new String[] { "eMutualMarkNewType", "uint32_level", "uint32_days", "bytes_title", "uint32_score", "bytes_type_describe", "bytes_level_describe", "bytes_button_describe", "bytes_button_url" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, MutualScoreCard.class);
    }
  }
  
  public static final class OneGroupInfo
    extends MessageMicro<OneGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cmduin_last_msg_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_uin", "uint64_group_code", "string_group_name", "uint32_cmduin_last_msg_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, OneGroupInfo.class);
    }
  }
  
  public static final class PrefetchMutualMarkInfo
    extends MessageMicro<PrefetchMutualMarkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "eMutualMarkType", "uint32_level", "uint32_days", "uint32_current_days", "eMutualMarkNewType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) }, PrefetchMutualMarkInfo.class);
    public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
    public final PBEnumField eMutualMarkType = PBField.initEnum(0);
    public final PBUInt32Field uint32_current_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_from_uin", "uint64_to_uin", "eDateType", "bool_qzone_dna", "rpt_msg_common_reqbody" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Boolean.valueOf(false), null }, ReqBody.class);
    public final PBBoolField bool_qzone_dna = PBField.initBool(false);
    public final PBEnumField eDateType = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_reqbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_cur_mutual_mark_info", "msg_friend_info", "msg_common_group_chat_info", "rpt_msg_mutual_mark_info", "rpt_msg_dna_info", "rpt_msg_prefetch_mutual_mark_info", "rpt_msg_data_tips", "rpt_msg_common_rspbody", "rpt_msg_mutual_score", "rpt_msg_mutual_score_card" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public oidb_0xcf4.CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4.CommonGroupChatInfo();
    public oidb_0xcf4.MutualMarkInfo msg_cur_mutual_mark_info = new oidb_0xcf4.MutualMarkInfo();
    public oidb_0xcf4.FriendInfo msg_friend_info = new oidb_0xcf4.FriendInfo();
    public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_rspbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
    public final PBRepeatMessageField<oidb_0xcf4.DateTips> rpt_msg_data_tips = PBField.initRepeatMessage(oidb_0xcf4.DateTips.class);
    public final PBRepeatMessageField<oidb_0xcf4.DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4.DnaInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4.MutualMarkInfo> rpt_msg_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.MutualMarkInfo.class);
    public oidb_0xcf4.MutualScore rpt_msg_mutual_score = new oidb_0xcf4.MutualScore();
    public oidb_0xcf4.MutualScoreCard rpt_msg_mutual_score_card = new oidb_0xcf4.MutualScoreCard();
    public final PBRepeatMessageField<oidb_0xcf4.PrefetchMutualMarkInfo> rpt_msg_prefetch_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4.PrefetchMutualMarkInfo.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class SpecialWordInfo
    extends MessageMicro<SpecialWordInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_static_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording_1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording_2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_all_word_light_up_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mark_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recentchat_msg_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64 }, new String[] { "bytes_card_id", "bytes_static_url", "bytes_wording_1", "bytes_wording_2", "uint32_close_flag", "uint32_recentchat_msg_count", "uint32_all_word_light_up_days", "uint32_mark_days" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SpecialWordInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4
 * JD-Core Version:    0.7.0.1
 */