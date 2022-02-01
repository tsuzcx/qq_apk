package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ranklist_comm
{
  public static final class ExtraParam
    extends MessageMicro<ExtraParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "param_key", "param_value", "param_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, ExtraParam.class);
    public final PBStringField param_key = PBField.initString("");
    public final PBInt32Field param_type = PBField.initInt32(0);
    public final PBInt32Field param_value = PBField.initInt32(0);
  }
  
  public static final class RankItem
    extends MessageMicro<RankItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "nick", "figure", "value", "rank" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, RankItem.class);
    public final PBStringField figure = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBInt32Field rank = PBField.initInt32(0);
    public final PBInt32Field value = PBField.initInt32(0);
  }
  
  public static final class ReportItem
    extends MessageMicro<ReportItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "openid", "score", "rpt_extra_param" }, new Object[] { "", Integer.valueOf(0), null }, ReportItem.class);
    public final PBStringField openid = PBField.initString("");
    public final PBRepeatMessageField<ranklist_comm.ExtraParam> rpt_extra_param = PBField.initRepeatMessage(ranklist_comm.ExtraParam.class);
    public final PBInt32Field score = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.ranklist_comm.ranklist_comm
 * JD-Core Version:    0.7.0.1
 */