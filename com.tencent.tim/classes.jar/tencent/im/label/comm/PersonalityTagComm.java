package tencent.im.label.comm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm
{
  public static final class LabelDuplicate
    extends MessageMicro<LabelDuplicate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_ori_label", "uint64_ori_label_id", "rpt_uint64_all_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, LabelDuplicate.class);
    public final PBRepeatField<Long> rpt_uint64_all_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_is_ori_label = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ori_label_id = PBField.initUInt64(0L);
  }
  
  public static final class LabelInfo
    extends MessageMicro<LabelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_photo_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<PersonalityTagComm.PraiseUserInfo> rpt_last_praise_uins_info = PBField.initRepeatMessage(PersonalityTagComm.PraiseUserInfo.class);
    public final PBRepeatMessageField<PersonalityTagComm.LabelPhoto> rpt_msg_photo = PBField.initRepeatMessage(PersonalityTagComm.LabelPhoto.class);
    public final PBStringField str_bg_color = PBField.initString("");
    public final PBStringField str_cover_photo_url = PBField.initString("");
    public final PBStringField str_fg_color = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_add_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_category = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mod_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_photo_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_praise = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 90, 96, 104, 112, 122 }, new String[] { "uint32_add_time", "uint64_id", "uint32_category", "str_text", "str_fg_color", "str_bg_color", "str_cover_photo_url", "uint32_praise_count", "uint32_photo_count", "rpt_msg_photo", "bytes_photo_cookie", "uint32_unread_praise", "uint32_mod_time", "uint32_praise_flag", "rpt_last_praise_uins_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, LabelInfo.class);
    }
  }
  
  public static final class LabelPhoto
    extends MessageMicro<LabelPhoto>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_praise_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<PersonalityTagComm.PraiseRec> rpt_msg_praise_rec = PBField.initRepeatMessage(PersonalityTagComm.PraiseRec.class);
    public final PBUInt32Field uint32_file_slot = PBField.initUInt32(0);
    public final PBUInt32Field uint32_praise_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBStringField uint32_url = PBField.initString("");
    public final PBUInt64Field uint64_file_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_praise_count = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 64 }, new String[] { "uint64_file_id", "uint32_url", "uint32_upload_time", "uint64_praise_count", "rpt_msg_praise_rec", "bytes_praise_cookie", "uint32_file_slot", "uint32_praise_flag" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, LabelPhoto.class);
    }
  }
  
  public static final class LabelProf
    extends MessageMicro<LabelProf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 114, 120 }, new String[] { "uint64_id", "str_text", "rpt_uint32_category", "uint64_ref_count", "str_fg_color", "str_bg_color", "uint32_source", "uint32_create_time", "uint32_hot_flag", "uint32_hit_flag", "uint32_audit_flag", "uint32_audit_time", "str_creater", "str_auditor", "uint32_op_flag" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, LabelProf.class);
    public final PBRepeatField<Integer> rpt_uint32_category = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField str_auditor = PBField.initString("");
    public final PBStringField str_bg_color = PBField.initString("");
    public final PBStringField str_creater = PBField.initString("");
    public final PBStringField str_fg_color = PBField.initString("");
    public final PBStringField str_text = PBField.initString("");
    public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_audit_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hit_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ref_count = PBField.initUInt64(0L);
  }
  
  public static final class LastPraiseUinList
    extends MessageMicro<LastPraiseUinList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_uin2time" }, new Object[] { null }, LastPraiseUinList.class);
    public final PBRepeatMessageField<PersonalityTagComm.Uin2Time> rpt_uin2time = PBField.initRepeatMessage(PersonalityTagComm.Uin2Time.class);
  }
  
  public static final class PraiseRec
    extends MessageMicro<PraiseRec>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "uint32_praise_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, PraiseRec.class);
    public final PBUInt32Field uint32_praise_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class PraiseUserInfo
    extends MessageMicro<PraiseUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_praise_uin", "str_nick" }, new Object[] { Long.valueOf(0L), "" }, PraiseUserInfo.class);
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt64Field uint64_praise_uin = PBField.initUInt64(0L);
  }
  
  public static final class Uin2Time
    extends MessageMicro<Uin2Time>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_time", "uint64_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, Uin2Time.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UserLabel
    extends MessageMicro<UserLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "rpt_msg_label", "uint32_remain_quota", "uint32_max_photo_quota", "uint32_total_photo", "uint32_total_praise", "uint32_unread_praise", "uint64_last_prise_uin" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, UserLabel.class);
    public final PBRepeatMessageField<PersonalityTagComm.LabelInfo> rpt_msg_label = PBField.initRepeatMessage(PersonalityTagComm.LabelInfo.class);
    public final PBUInt32Field uint32_max_photo_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remain_quota = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_photo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_praise = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unread_praise = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_prise_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm
 * JD-Core Version:    0.7.0.1
 */