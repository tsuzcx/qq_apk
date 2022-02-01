package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.ranklist_comm.ranklist_comm.RankItem;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ReportItem;

public final class Oidb_0xb85
{
  public static final class GetRankListReqBody
    extends MessageMicro<GetRankListReqBody>
  {
    public static final int RANK_CUR_VAL = 0;
    public static final int RANK_MAX_VAL = 1;
    public static final int RANK_MIN_VAL = 2;
    public static final int RANK_ORDER_ASC = 1;
    public static final int RANK_ORDER_DESC = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "ranklist_id", "top_count", "rank_key", "rank_value_type", "rank_order_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(10), "", Integer.valueOf(0), Integer.valueOf(0) }, GetRankListReqBody.class);
    public final PBStringField rank_key = PBField.initString("");
    public final PBInt32Field rank_order_type = PBField.initInt32(0);
    public final PBInt32Field rank_value_type = PBField.initInt32(0);
    public final PBInt32Field ranklist_id = PBField.initInt32(0);
    public final PBInt32Field top_count = PBField.initInt32(10);
  }
  
  public static final class GetRankListRspBody
    extends MessageMicro<GetRankListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_rank_item", "self_rank_item" }, new Object[] { null, null }, GetRankListRspBody.class);
    public final PBRepeatMessageField<ranklist_comm.RankItem> rpt_rank_item = PBField.initRepeatMessage(ranklist_comm.RankItem.class);
    public ranklist_comm.RankItem self_rank_item = new ranklist_comm.RankItem();
  }
  
  public static final class QueryUserScoreReqBody
    extends MessageMicro<QueryUserScoreReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QueryUserScoreReqBody.class);
  }
  
  public static final class QueryUserScoreRspBody
    extends MessageMicro<QueryUserScoreRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QueryUserScoreRspBody.class);
  }
  
  public static final class ReportScoreReqBody
    extends MessageMicro<ReportScoreReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_report_item", "ranklist_id" }, new Object[] { null, Integer.valueOf(0) }, ReportScoreReqBody.class);
    public final PBInt32Field ranklist_id = PBField.initInt32(0);
    public final PBRepeatMessageField<ranklist_comm.ReportItem> rpt_report_item = PBField.initRepeatMessage(ranklist_comm.ReportItem.class);
  }
  
  public static final class ReportScoreRspBody
    extends MessageMicro<ReportScoreRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReportScoreRspBody.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 90, 98 }, new String[] { "openid", "openkey", "appid", "service_id", "report_score_req", "get_ranklist_req" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), null, null }, ReqBody.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public Oidb_0xb85.GetRankListReqBody get_ranklist_req = new Oidb_0xb85.GetRankListReqBody();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public Oidb_0xb85.ReportScoreReqBody report_score_req = new Oidb_0xb85.ReportScoreReqBody();
    public final PBInt32Field service_id = PBField.initInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "report_score_rsp", "get_ranklist_rsp" }, new Object[] { null, null }, RspBody.class);
    public Oidb_0xb85.GetRankListRspBody get_ranklist_rsp = new Oidb_0xb85.GetRankListRspBody();
    public Oidb_0xb85.ReportScoreRspBody report_score_rsp = new Oidb_0xb85.ReportScoreRspBody();
  }
  
  public static final class UpdateUserScoreReqBody
    extends MessageMicro<UpdateUserScoreReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UpdateUserScoreReqBody.class);
  }
  
  public static final class UpdateUserScoreRspBody
    extends MessageMicro<UpdateUserScoreRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UpdateUserScoreRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb85.Oidb_0xb85
 * JD-Core Version:    0.7.0.1
 */