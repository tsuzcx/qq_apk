package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46
{
  public static final class KsBannerInfo
    extends MessageMicro<KsBannerInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_title", "uint32_jump_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, KsBannerInfo.class);
    }
  }
  
  public static final class KsClearUnreadReq
    extends MessageMicro<KsClearUnreadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint32_ks_topic_id_list" }, new Object[] { Integer.valueOf(0) }, KsClearUnreadReq.class);
    public final PBRepeatField<Integer> rpt_uint32_ks_topic_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class KsClearUnreadRsp
    extends MessageMicro<KsClearUnreadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], KsClearUnreadRsp.class);
  }
  
  public static final class KsGetSubscribedListReq
    extends MessageMicro<KsGetSubscribedListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_result_type" }, new Object[] { Integer.valueOf(0) }, KsGetSubscribedListReq.class);
    public final PBUInt32Field uint32_result_type = PBField.initUInt32(0);
  }
  
  public static final class KsGetSubscribedListRsp
    extends MessageMicro<KsGetSubscribedListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ks_subscribed_list = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_ks_subscribed_list" }, new Object[] { localByteStringMicro }, KsGetSubscribedListRsp.class);
    }
  }
  
  public static final class KsSubscribedList
    extends MessageMicro<KsSubscribedList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_subscribed_count", "msg_ks_banner_info", "rpt_msg_ks_topic_list" }, new Object[] { Integer.valueOf(0), null, null }, KsSubscribedList.class);
    public oidb_cmd0xd46.KsBannerInfo msg_ks_banner_info = new oidb_cmd0xd46.KsBannerInfo();
    public final PBRepeatMessageField<oidb_cmd0xd46.KsTopicInfo> rpt_msg_ks_topic_list = PBField.initRepeatMessage(oidb_cmd0xd46.KsTopicInfo.class);
    public final PBUInt32Field uint32_subscribed_count = PBField.initUInt32(0);
  }
  
  public static final class KsTopicInfo
    extends MessageMicro<KsTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_ts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_cnt = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_ts = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 88, 96, 104 }, new String[] { "uint32_id", "bytes_title", "bytes_icon_url", "bytes_web_url", "uint32_subscribe_ts", "uint32_update_ts", "uint32_update_cnt" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, KsTopicInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_oper_type", "msg_ks_clear_unread_req", "msg_ks_get_subscribed_list_req" }, new Object[] { Integer.valueOf(0), null, null }, ReqBody.class);
    public oidb_cmd0xd46.KsClearUnreadReq msg_ks_clear_unread_req = new oidb_cmd0xd46.KsClearUnreadReq();
    public oidb_cmd0xd46.KsGetSubscribedListReq msg_ks_get_subscribed_list_req = new oidb_cmd0xd46.KsGetSubscribedListReq();
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "msg_ks_clear_unread_rsp", "msg_ks_get_subscribed_list_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_cmd0xd46.KsClearUnreadRsp msg_ks_clear_unread_rsp = new oidb_cmd0xd46.KsClearUnreadRsp();
    public oidb_cmd0xd46.KsGetSubscribedListRsp msg_ks_get_subscribed_list_rsp = new oidb_cmd0xd46.KsGetSubscribedListRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46
 * JD-Core Version:    0.7.0.1
 */