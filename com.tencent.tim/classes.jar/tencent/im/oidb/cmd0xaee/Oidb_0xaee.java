package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xaee
{
  public static final class AdminReq
    extends MessageMicro<AdminReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AdminReq.class);
  }
  
  public static final class AdminRsp
    extends MessageMicro<AdminRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AdminRsp.class);
  }
  
  public static final class ListReq
    extends MessageMicro<ListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ListReq.class);
  }
  
  public static final class ListRsp
    extends MessageMicro<ListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_template" }, new Object[] { null }, ListRsp.class);
    public final PBRepeatMessageField<Oidb_0xaee.Template> rpt_template = PBField.initRepeatMessage(Oidb_0xaee.Template.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "group_code", "list_req", "admin_req" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
    public Oidb_0xaee.AdminReq admin_req = new Oidb_0xaee.AdminReq();
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public Oidb_0xaee.ListReq list_req = new Oidb_0xaee.ListReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "list_rsp", "admin_rsp" }, new Object[] { null, null }, RspBody.class);
    public Oidb_0xaee.AdminRsp admin_rsp = new Oidb_0xaee.AdminRsp();
    public Oidb_0xaee.ListRsp list_rsp = new Oidb_0xaee.ListRsp();
  }
  
  public static final class Template
    extends MessageMicro<Template>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66, 72, 160 }, new String[] { "template_id", "template_name", "group_type", "mob_thumb_url", "mob_prev_url", "web_thumb_url", "web_prev_url", "template_url", "doc_type", "group_code" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L) }, Template.class);
    public final PBUInt32Field doc_type = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBStringField mob_prev_url = PBField.initString("");
    public final PBStringField mob_thumb_url = PBField.initString("");
    public final PBUInt32Field template_id = PBField.initUInt32(0);
    public final PBStringField template_name = PBField.initString("");
    public final PBStringField template_url = PBField.initString("");
    public final PBStringField web_prev_url = PBField.initString("");
    public final PBStringField web_thumb_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaee.Oidb_0xaee
 * JD-Core Version:    0.7.0.1
 */