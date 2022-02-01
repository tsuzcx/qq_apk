package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qvideo_recom
{
  public static final class QueryRecomQunVideoReq
    extends MessageMicro<QueryRecomQunVideoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_index", "end_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QueryRecomQunVideoReq.class);
    public final PBUInt32Field end_index = PBField.initUInt32(0);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
  }
  
  public static final class QueryRecomQunVideoRsp
    extends MessageMicro<QueryRecomQunVideoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret", "err", "total", "qun_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, QueryRecomQunVideoRsp.class);
    public final PBStringField err = PBField.initString("");
    public final PBRepeatMessageField<qvideo_recom.QunInfo> qun_infos = PBField.initRepeatMessage(qvideo_recom.QunInfo.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class QunInfo
    extends MessageMicro<QunInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "qun_index", "qun_code", "qun_name", "onlive_num", "qvideo_url", "logo_url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", "" }, QunInfo.class);
    public final PBStringField logo_url = PBField.initString("");
    public final PBUInt32Field onlive_num = PBField.initUInt32(0);
    public final PBUInt64Field qun_code = PBField.initUInt64(0L);
    public final PBUInt32Field qun_index = PBField.initUInt32(0);
    public final PBStringField qun_name = PBField.initString("");
    public final PBStringField qvideo_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.qapp.qvideoproj.qvideo_recom.qvideo_recom
 * JD-Core Version:    0.7.0.1
 */