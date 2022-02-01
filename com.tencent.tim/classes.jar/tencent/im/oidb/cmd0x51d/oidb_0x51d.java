package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x51d
{
  public static final class AppNoticeInfo
    extends MessageMicro<AppNoticeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint64_appdid", "opt_msg_app_notice" }, new Object[] { Long.valueOf(0L), null }, AppNoticeInfo.class);
    public oidb_0x51d.NoticeInfo opt_msg_app_notice = new oidb_0x51d.NoticeInfo();
    public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
  }
  
  public static final class GetAppNoticeRsp
    extends MessageMicro<GetAppNoticeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_app_notice" }, new Object[] { null }, GetAppNoticeRsp.class);
    public final PBRepeatMessageField<oidb_0x51d.AppNoticeInfo> rpt_msg_app_notice = PBField.initRepeatMessage(oidb_0x51d.AppNoticeInfo.class);
  }
  
  public static final class GetOfficeNoticeRsp
    extends MessageMicro<GetOfficeNoticeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "opt_msg_office_notice" }, new Object[] { null }, GetOfficeNoticeRsp.class);
    public oidb_0x51d.NoticeInfo opt_msg_office_notice = new oidb_0x51d.NoticeInfo();
  }
  
  public static final class GetSubItemNoticeRsp
    extends MessageMicro<GetSubItemNoticeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint64_appdid", "rpt_msg_subitem_notice" }, new Object[] { Long.valueOf(0L), null }, GetSubItemNoticeRsp.class);
    public final PBUInt64Field opt_uint64_appdid = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_0x51d.SubItemNoticeInfo> rpt_msg_subitem_notice = PBField.initRepeatMessage(oidb_0x51d.SubItemNoticeInfo.class);
  }
  
  public static final class NoticeInfo
    extends MessageMicro<NoticeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_notice_count", "opt_uint32_notice_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, NoticeInfo.class);
    public final PBUInt32Field opt_uint32_notice_count = PBField.initUInt32(0);
    public final PBUInt32Field opt_uint32_notice_version = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint64_handled_uin", "opt_uint64_office_appid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0L);
    public final PBUInt64Field opt_uint64_office_appid = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x51d.GetAppNoticeRsp opt_msg_app_notice_rsp = new oidb_0x51d.GetAppNoticeRsp();
    public oidb_0x51d.GetOfficeNoticeRsp opt_msg_office_notice_rsp = new oidb_0x51d.GetOfficeNoticeRsp();
    public oidb_0x51d.GetSubItemNoticeRsp opt_msg_subitem_notice_rsp = new oidb_0x51d.GetSubItemNoticeRsp();
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "opt_uint32_result", "opt_bytes_errinfo", "opt_msg_office_notice_rsp", "opt_msg_app_notice_rsp", "opt_msg_subitem_notice_rsp" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
    }
  }
  
  public static final class SubItemNoticeInfo
    extends MessageMicro<SubItemNoticeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_subitem_id", "opt_msg_subitem_notice" }, new Object[] { Integer.valueOf(0), null }, SubItemNoticeInfo.class);
    public oidb_0x51d.NoticeInfo opt_msg_subitem_notice = new oidb_0x51d.NoticeInfo();
    public final PBUInt32Field opt_uint32_subitem_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x51d.oidb_0x51d
 * JD-Core Version:    0.7.0.1
 */