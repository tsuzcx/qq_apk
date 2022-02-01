package tencent.im.oidb.cmd0x51c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51c
{
  public static final class AppNoticeVar
    extends MessageMicro<AppNoticeVar>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "opt_uint64_appdid", "opt_msg_app_noticevar", "rpt_msg_subitem_noticevar" }, new Object[] { Long.valueOf(0L), null, null }, AppNoticeVar.class);
    public oidb_0x51c.NoticeVar opt_msg_app_noticevar = new oidb_0x51c.NoticeVar();
    public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0x51c.SubItemNoticeVar> rpt_msg_subitem_noticevar = PBField.initRepeatMessage(oidb_0x51c.SubItemNoticeVar.class);
  }
  
  public static final class NoticeVar
    extends MessageMicro<NoticeVar>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint32_operate_type", "opt_uint32_notice_var", "opt_uint32_notice_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NoticeVar.class);
    public final PBUInt32Field opt_uint32_notice_var = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_operate_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "opt_uint64_handled_uin", "opt_msg_office_noticevar", "rpt_msg_app_noticevar" }, new Object[] { Long.valueOf(0L), null, null }, ReqBody.class);
    public oidb_0x51c.NoticeVar opt_msg_office_noticevar = new oidb_0x51c.NoticeVar();
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0x51c.AppNoticeVar> rpt_msg_app_noticevar = PBField.initRepeatMessage(oidb_0x51c.AppNoticeVar.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "opt_uint32_result", "opt_bytes_errinfo", "opt_uint64_handled_uin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, RspBody.class);
    }
  }
  
  public static final class SubItemNoticeVar
    extends MessageMicro<SubItemNoticeVar>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_subitem_id", "opt_msg_subitem_noticevar" }, new Object[] { Integer.valueOf(0), null }, SubItemNoticeVar.class);
    public oidb_0x51c.NoticeVar opt_msg_subitem_noticevar = new oidb_0x51c.NoticeVar();
    public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51c.oidb_0x51c
 * JD-Core Version:    0.7.0.1
 */