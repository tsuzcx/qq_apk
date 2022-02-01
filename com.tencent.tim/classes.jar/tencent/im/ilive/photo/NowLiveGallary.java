package tencent.im.ilive.photo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowLiveGallary
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "req_uin" }, new Object[] { Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field req_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "errCode", "photo_info_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
    public final PBUInt32Field errCode = PBField.initUInt32(0);
    public final PBRepeatMessageField<PhotoInfo> photo_info_list = PBField.initRepeatMessage(PhotoInfo.class);
    
    public static final class PhotoInfo
      extends MessageMicro<PhotoInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt64Field timestamp = PBField.initUInt64(0L);
      public final PBBytesField video = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "video", "cover", "timestamp" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, PhotoInfo.class);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.ilive.photo.NowLiveGallary
 * JD-Core Version:    0.7.0.1
 */