package tencent.im.cs.ptt_waveform;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_waveform
{
  public static final class PttWaveform
    extends MessageMicro<PttWaveform>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_amplitudes = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin32_size", "bytes_amplitudes" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, PttWaveform.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.ptt_waveform.ptt_waveform
 * JD-Core Version:    0.7.0.1
 */