package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_act
{
  public static final class SQQSHPActInfo
    extends MessageMicro<SQQSHPActInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "act_id", "beg_ts", "end_ts", "status", "fail_pic" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, SQQSHPActInfo.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBUInt32Field beg_ts = PBField.initUInt32(0);
    public final PBUInt32Field end_ts = PBField.initUInt32(0);
    public final PBStringField fail_pic = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPActReadReq
    extends MessageMicro<SQQSHPActReadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "act_id" }, new Object[] { Integer.valueOf(0) }, SQQSHPActReadReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPActReadRsp
    extends MessageMicro<SQQSHPActReadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "code", "act_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SQQSHPActReadRsp.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBUInt32Field code = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPActReq
    extends MessageMicro<SQQSHPActReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_id", "usr_info" }, new Object[] { Integer.valueOf(0), null }, SQQSHPActReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public qqshop_act.SQQSHPUsrInfo usr_info = new qqshop_act.SQQSHPUsrInfo();
  }
  
  public static final class SQQSHPActRsp
    extends MessageMicro<SQQSHPActRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "code", "act_info", "act_show_info" }, new Object[] { Integer.valueOf(0), null, null }, SQQSHPActRsp.class);
    public qqshop_act.SQQSHPActInfo act_info = new qqshop_act.SQQSHPActInfo();
    public qqshop_act.SQQSHPActShowInfo act_show_info = new qqshop_act.SQQSHPActShowInfo();
    public final PBUInt32Field code = PBField.initUInt32(0);
  }
  
  public static final class SQQSHPActShowInfo
    extends MessageMicro<SQQSHPActShowInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "title", "logo", "subtext", "btn_text", "btn_url", "detail_url", "gift_text", "act_text" }, new Object[] { "", "", "", "", "", "", "", "" }, SQQSHPActShowInfo.class);
    public final PBStringField act_text = PBField.initString("");
    public final PBStringField btn_text = PBField.initString("");
    public final PBStringField btn_url = PBField.initString("");
    public final PBStringField detail_url = PBField.initString("");
    public final PBStringField gift_text = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField subtext = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class SQQSHPUsrInfo
    extends MessageMicro<SQQSHPUsrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "carriertype", "src", "src_idx", "net_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SQQSHPUsrInfo.class);
    public final PBUInt32Field carriertype = PBField.initUInt32(0);
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBUInt32Field src = PBField.initUInt32(0);
    public final PBUInt32Field src_idx = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act
 * JD-Core Version:    0.7.0.1
 */