package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class vac_adv_get
{
  public static final class DefaultConf
    extends MessageMicro<DefaultConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "left_bottom_text", "right_bottom_button" }, new Object[] { "", "" }, DefaultConf.class);
    public final PBStringField left_bottom_text = PBField.initString("");
    public final PBStringField right_bottom_button = PBField.initString("");
  }
  
  public static final class DropList
    extends MessageMicro<DropList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "iconurl", "optext", "jumpurl", "action_type" }, new Object[] { "", "", "", Integer.valueOf(1) }, DropList.class);
    public final PBEnumField action_type = PBField.initEnum(1);
    public final PBStringField iconurl = PBField.initString("");
    public final PBStringField jumpurl = PBField.initString("");
    public final PBStringField optext = PBField.initString("");
  }
  
  public static final class FeedsContextInfo
    extends MessageMicro<FeedsContextInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "index", "ugckey" }, new Object[] { Integer.valueOf(0), "" }, FeedsContextInfo.class);
    public final PBInt32Field index = PBField.initInt32(0);
    public final PBStringField ugckey = PBField.initString("");
  }
  
  public static final class QzoneBusiMsg
    extends MessageMicro<QzoneBusiMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "page_num", "cur_page_infos", "device_info" }, new Object[] { Integer.valueOf(0), null, "" }, QzoneBusiMsg.class);
    public final PBRepeatMessageField<vac_adv_get.FeedsContextInfo> cur_page_infos = PBField.initRepeatMessage(vac_adv_get.FeedsContextInfo.class);
    public final PBStringField device_info = PBField.initString("");
    public final PBInt32Field page_num = PBField.initInt32(0);
  }
  
  public static final class VacAdvMetaMsg
    extends MessageMicro<VacAdvMetaMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "adv_rsp", "insert_pos", "recomm_cookie" }, new Object[] { null, Integer.valueOf(0), "" }, VacAdvMetaMsg.class);
    public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
    public final PBInt32Field insert_pos = PBField.initInt32(0);
    public final PBStringField recomm_cookie = PBField.initString("");
  }
  
  public static final class VacAdvReq
    extends MessageMicro<VacAdvReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "qq", "device_info", "adv_pos", "qzone_busi_info", "attach_info" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(1), null, "" }, VacAdvReq.class);
    public final PBEnumField adv_pos = PBField.initEnum(1);
    public final PBStringField attach_info = PBField.initString("");
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
    public final PBUInt64Field qq = PBField.initUInt64(0L);
    public vac_adv_get.QzoneBusiMsg qzone_busi_info = new vac_adv_get.QzoneBusiMsg();
  }
  
  public static final class VacAdvRsp
    extends MessageMicro<VacAdvRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "err_code", "err_msg", "vac_adv_msgs", "attach_info" }, new Object[] { Integer.valueOf(0), "", null, "" }, VacAdvRsp.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<vac_adv_get.VacAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(vac_adv_get.VacAdvMetaMsg.class);
  }
  
  public static final class VacFeedsAdvMetaInfo
    extends MessageMicro<VacFeedsAdvMetaInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "adv_rsp", "default_conf", "droplist", "recomm_cookie" }, new Object[] { null, null, null, "" }, VacFeedsAdvMetaInfo.class);
    public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
    public vac_adv_get.DefaultConf default_conf = new vac_adv_get.DefaultConf();
    public final PBRepeatMessageField<vac_adv_get.DropList> droplist = PBField.initRepeatMessage(vac_adv_get.DropList.class);
    public final PBStringField recomm_cookie = PBField.initString("");
  }
  
  public static final class VacFeedsAdvMetaMsg
    extends MessageMicro<VacFeedsAdvMetaMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field insert_pos = PBField.initInt32(0);
    public final PBBytesField rsp_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rsp_buffer", "insert_pos" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, VacFeedsAdvMetaMsg.class);
    }
  }
  
  public static final class VacFeedsAdvMetaReq
    extends MessageMicro<VacFeedsAdvMetaReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "device_info" }, new Object[] { null }, VacFeedsAdvMetaReq.class);
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
  }
  
  public static final class VacFeedsAdvReq
    extends MessageMicro<VacFeedsAdvReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField adv_pos = PBField.initEnum(1);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field page_num = PBField.initInt32(0);
    public final PBInt32Field pre_feed_index = PBField.initInt32(0);
    public final PBUInt64Field qq = PBField.initUInt64(0L);
    public final PBRepeatField<String> recom_adv_pos = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBBytesField req_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58 }, new String[] { "qq", "adv_pos", "req_buffer", "page_num", "pre_feed_index", "recom_adv_pos", "attach_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", "" }, VacFeedsAdvReq.class);
    }
  }
  
  public static final class VacFeedsAdvRsp
    extends MessageMicro<VacFeedsAdvRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "err_code", "err_msg", "vac_adv_msgs", "attach_info", "adv_export_cnt" }, new Object[] { Integer.valueOf(0), "", null, "", Integer.valueOf(0) }, VacFeedsAdvRsp.class);
    public final PBInt32Field adv_export_cnt = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<vac_adv_get.VacFeedsAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(vac_adv_get.VacFeedsAdvMetaMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get
 * JD-Core Version:    0.7.0.1
 */