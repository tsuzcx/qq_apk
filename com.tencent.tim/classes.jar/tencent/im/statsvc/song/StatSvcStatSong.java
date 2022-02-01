package tencent.im.statsvc.song;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatSvcStatSong
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_need_convert = PBField.initBool(false);
    public final PBBoolField bool_pause_flag = PBField.initBool(false);
    public final PBBytesField bytes_singer_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_remaining_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_song_play_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "bool_need_convert", "bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint32_remaining_time", "uint32_source_type", "bool_pause_flag", "uint32_song_play_time" }, new Object[] { Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "error_code", "error_msg", "bytes_song_id" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class SongInfo
    extends MessageMicro<SongInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_singer_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pause_remaining_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_song_play_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint64_end_time", "uint32_source_type", "uint32_pause_remaining_time", "uint32_song_play_time" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SongInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.statsvc.song.StatSvcStatSong
 * JD-Core Version:    0.7.0.1
 */