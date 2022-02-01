package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WordsSecurity
{
  public static final class SecurityReq
    extends MessageMicro<SecurityReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField biz_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field check_mask = PBField.initUInt32(0);
    public final PBBytesField check_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public final PBBytesField from_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField from_user_type = PBField.initEnum(0);
    public final PBBytesField imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field room_id = PBField.initUInt64(0L);
    public final PBUInt32Field svr_type = PBField.initUInt32(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0L);
    public final PBEnumField to_user_type = PBField.initEnum(0);
    public final PBUInt32Field use_white_list = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 98 }, new String[] { "check_word", "check_mask", "svr_type", "from_user_type", "to_user_type", "to_uin", "from_nick_name", "client_ip", "use_white_list", "room_id", "biz_id", "imei" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, SecurityReq.class);
    }
  }
  
  public static final class SecurityRsp
    extends MessageMicro<SecurityRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field credit_beat = PBField.initUInt32(0);
    public final PBUInt32Field dirty_word_beat = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> dirty_word_tips = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field real_auth = PBField.initUInt32(0);
    public final PBUInt32Field required_score = PBField.initUInt32(0);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBBytesField ret_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field sys_beat_level = PBField.initUInt32(0);
    public final PBUInt32Field user_score = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72 }, new String[] { "ret_code", "sys_beat_level", "dirty_word_beat", "ret_text", "dirty_word_tips", "credit_beat", "user_score", "required_score", "real_auth" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SecurityRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.WordsSecurity
 * JD-Core Version:    0.7.0.1
 */