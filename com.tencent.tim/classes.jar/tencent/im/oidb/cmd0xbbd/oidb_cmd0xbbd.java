package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0xbbd
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_uin", "uint32_network_type", "msg_req_para" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0xbbd.ReqPara msg_req_para = new oidb_cmd0xbbd.ReqPara();
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqFeedsInfo
    extends MessageMicro<ReqFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqFeedsInfo.class);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqPara
    extends MessageMicro<ReqPara>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_req_feeds_info" }, new Object[] { null }, ReqPara.class);
    public final PBRepeatMessageField<oidb_cmd0xbbd.ReqFeedsInfo> rpt_req_feeds_info = PBField.initRepeatMessage(oidb_cmd0xbbd.ReqFeedsInfo.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_uin", "msg_rsp_feeds_data" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
    public oidb_cmd0xbbd.RspFeedsData msg_rsp_feeds_data = new oidb_cmd0xbbd.RspFeedsData();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspFeedsData
    extends MessageMicro<RspFeedsData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "rpt_feeds_info_list" }, new Object[] { null }, RspFeedsData.class);
    public final PBRepeatMessageField<oidb_cmd0xbbd.RspFeedsInfo> rpt_feeds_info_list = PBField.initRepeatMessage(oidb_cmd0xbbd.RspFeedsInfo.class);
  }
  
  public static final class RspFeedsInfo
    extends MessageMicro<RspFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_feeds_id", "uint32_feeds_type", "msg_article_summary" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspFeedsInfo.class);
    public articlesummary.ArticleSummary msg_article_summary = new articlesummary.ArticleSummary();
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd
 * JD-Core Version:    0.7.0.1
 */