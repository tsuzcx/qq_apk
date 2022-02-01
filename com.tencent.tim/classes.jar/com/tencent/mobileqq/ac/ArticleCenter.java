package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleCenter
{
  public static final class GetUrlByVidRequest
    extends MessageMicro<GetUrlByVidRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField latitude = PBField.initFloat(0.0F);
    public final PBFloatField longitude = PBField.initFloat(0.0F);
    public final PBBytesField mobile_detail_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField mv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBUInt32Field prefer_h265 = PBField.initUInt32(0);
    public final PBBytesField user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 53, 61, 64, 74 }, new String[] { "vid", "mv", "net_type", "user_ip", "video_type", "longitude", "latitude", "prefer_h265", "mobile_detail_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro4 }, GetUrlByVidRequest.class);
    }
  }
  
  public static final class GetUrlByVidResponse
    extends MessageMicro<GetUrlByVidResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField definition = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field encode_type = PBField.initUInt32(0);
    public final PBUInt32Field file_size = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBBytesField json_video_detail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field prefer_h265 = PBField.initUInt32(0);
    public final PBBytesField rate = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field rate_type = PBField.initUInt32(0);
    public ArticleCenter.RetInfo ret_info = new ArticleCenter.RetInfo();
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ArticleCenter.VideoInfo> video_info = PBField.initRepeatMessage(ArticleCenter.VideoInfo.class);
    public final PBUInt32Field video_type = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 56, 64, 72, 80, 90, 96, 106, 114 }, new String[] { "ret_info", "vid", "url", "video_type", "rate", "rate_type", "prefer_h265", "encode_type", "width", "height", "definition", "file_size", "video_info", "json_video_detail" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), null, localByteStringMicro5 }, GetUrlByVidResponse.class);
    }
  }
  
  public static final class GetVidByUrlRequest
    extends MessageMicro<GetVidByUrlRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField mv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "url", "mv" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, GetVidByUrlRequest.class);
    }
  }
  
  public static final class GetVidByUrlResponse
    extends MessageMicro<GetVidByUrlResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public ArticleCenter.RetInfo ret_info = new ArticleCenter.RetInfo();
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ret_info", "url", "vid" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, GetVidByUrlResponse.class);
    }
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "err_info" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBStringField err_info = PBField.initString("");
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField definition = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field encode_type = PBField.initUInt32(0);
    public final PBUInt32Field file_size = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBBytesField json_video_detail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rate = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field rate_type = PBField.initUInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_type = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 74, 80, 90 }, new String[] { "vid", "url", "video_type", "rate", "rate_type", "encode_type", "width", "height", "definition", "file_size", "json_video_detail" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5 }, VideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleCenter
 * JD-Core Version:    0.7.0.1
 */