package tencent.im.oidb.PhotoWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_PhotoWall
{
  public static final class CommRsp
    extends MessageMicro<CommRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, CommRsp.class);
    public final PBStringField errmsg = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class GetPhotoIndexListReq
    extends MessageMicro<GetPhotoIndexListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 80072 }, new String[] { "uin", "offset", "num", "photo_source", "uptime", "opuin", "last_filekey", "last_ctime", "base_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, GetPhotoIndexListReq.class);
    public final PBUInt64Field base_time = PBField.initUInt64(0L);
    public final PBUInt32Field last_ctime = PBField.initUInt32(0);
    public final PBStringField last_filekey = PBField.initString("");
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBUInt64Field opuin = PBField.initUInt64(0L);
    public final PBUInt32Field photo_source = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field uptime = PBField.initUInt32(0);
  }
  
  public static final class GetPhotoIndexListRsp
    extends MessageMicro<GetPhotoIndexListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 80080 }, new String[] { "comm_rsp", "photo_list", "uptime", "next_offset", "total", "base_time_photo_count" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetPhotoIndexListRsp.class);
    public final PBUInt64Field base_time_photo_count = PBField.initUInt64(0L);
    public oidb_PhotoWall.CommRsp comm_rsp = new oidb_PhotoWall.CommRsp();
    public final PBInt32Field next_offset = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_PhotoWall.PhotoIndexInfoEx> photo_list = PBField.initRepeatMessage(oidb_PhotoWall.PhotoIndexInfoEx.class);
    public final PBInt32Field total = PBField.initInt32(0);
    public final PBUInt32Field uptime = PBField.initUInt32(0);
  }
  
  public static final class PhotoIndexInfoEx
    extends MessageMicro<PhotoIndexInfoEx>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "filekey", "ctime", "ourl", "murl", "surl", "burl" }, new Object[] { "", Integer.valueOf(0), "", "", "", "" }, PhotoIndexInfoEx.class);
    public final PBStringField burl = PBField.initString("");
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBStringField filekey = PBField.initString("");
    public final PBStringField murl = PBField.initString("");
    public final PBStringField ourl = PBField.initString("");
    public final PBStringField surl = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.PhotoWall.oidb_PhotoWall
 * JD-Core Version:    0.7.0.1
 */