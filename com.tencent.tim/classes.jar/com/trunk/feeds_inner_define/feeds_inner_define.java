package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_inner_define
{
  public static final class ConcernUinRecord
    extends MessageMicro<ConcernUinRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_concern_uin", "uint32_confirm_time", "uint32_read_time", "uint32_concern_type", "uint32_ignore_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ConcernUinRecord.class);
    public final PBUInt32Field uint32_concern_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ignore_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_concern_uin = PBField.initUInt64(0L);
  }
  
  public static final class ConcernUinRecordSet
    extends MessageMicro<ConcernUinRecordSet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_concern_uin_record" }, new Object[] { null }, ConcernUinRecordSet.class);
    public final PBRepeatMessageField<feeds_inner_define.ConcernUinRecord> rpt_concern_uin_record = PBField.initRepeatMessage(feeds_inner_define.ConcernUinRecord.class);
  }
  
  public static final class FaceRecordSet
    extends MessageMicro<FaceRecordSet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_face_records" }, new Object[] { null }, FaceRecordSet.class);
    public final PBRepeatMessageField<FaceRecord> rpt_face_records = PBField.initRepeatMessage(FaceRecord.class);
    
    public static final class FaceRecord
      extends MessageMicro<FaceRecord>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_author_uin", "int32_face_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, FaceRecord.class);
      public final PBInt32Field int32_face_type = PBField.initInt32(0);
      public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class GroupFeedsExtendData
    extends MessageMicro<GroupFeedsExtendData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reverse = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_inner_define.ConcernUinRecordSet msg_concern_uin_record_set = new feeds_inner_define.ConcernUinRecordSet();
    public final PBUInt32Field uint32_author_ignore_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_reverse", "msg_concern_uin_record_set", "uint32_author_ignore_time" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0) }, GroupFeedsExtendData.class);
    }
  }
  
  public static final class MergedThemeMsg
    extends MessageMicro<MergedThemeMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 58 }, new String[] { "rpt_theme_msg" }, new Object[] { null }, MergedThemeMsg.class);
    public final PBRepeatMessageField<feeds_inner_define.ThemeMsgInfo> rpt_theme_msg = PBField.initRepeatMessage(feeds_inner_define.ThemeMsgInfo.class);
  }
  
  public static final class ThemeExtInfo
    extends MessageMicro<ThemeExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "rpt_talker_uins", "uint64_open_uin", "uint32_msg_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, ThemeExtInfo.class);
    public final PBRepeatField<Long> rpt_talker_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_msg_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0L);
  }
  
  public static final class ThemeMsgInfo
    extends MessageMicro<ThemeMsgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField opt_bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_cmmntid = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_modtime = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "opt_uint64_fromuin", "opt_uint64_time", "opt_uint64_modtime", "opt_uint32_cmmntid", "opt_bytes_feedsid", "opt_bytes_reserve", "opt_bytes_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ThemeMsgInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define
 * JD-Core Version:    0.7.0.1
 */