package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TtsResBody
{
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 64, 72, 80 }, new String[] { "ret_code", "session_id", "out_seq", "voice_data", "islast", "pcm_sample_rate", "opus_sample_rate", "opus_channels", "opus_bit_rate", "opus_frame_size" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public final PBBoolField islast = PBField.initBool(false);
    public final PBUInt32Field opus_bit_rate = PBField.initUInt32(0);
    public final PBUInt32Field opus_channels = PBField.initUInt32(0);
    public final PBUInt32Field opus_frame_size = PBField.initUInt32(0);
    public final PBUInt32Field opus_sample_rate = PBField.initUInt32(0);
    public final PBUInt32Field out_seq = PBField.initUInt32(0);
    public final PBUInt32Field pcm_sample_rate = PBField.initUInt32(0);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<TtsResBody.voice_item> voice_data = PBField.initRepeatMessage(TtsResBody.voice_item.class);
  }
  
  public static final class voice_item
    extends MessageMicro<voice_item>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBBytesField voice = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "voice", "seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, voice_item.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.TtsResBody
 * JD-Core Version:    0.7.0.1
 */