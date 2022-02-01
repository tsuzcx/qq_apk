package tencent.im.oidb.cmd0x66b;

import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x66b
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reqbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_req_configinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_giftinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_likeinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_pansocialinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_visitor = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 480802, 481600, 482400, 483200, 484000, 484800 }, new String[] { "bytes_reqbody_5eb", "uint32_req_likeinfo", "uint32_req_pansocialinfo", "uint32_req_giftinfo", "uint32_req_configinfo", "uint32_req_visitor" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rspbody_5eb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rspbody_gift = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<appoint_define.PublisherInfo> rpt_msg_vistor_info = PBField.initRepeatMessage(appoint_define.PublisherInfo.class);
    public final PBRepeatMessageField<Oidb_0x66b.RspConfigItem> stConfigList = PBField.initRepeatMessage(Oidb_0x66b.RspConfigItem.class);
    public Oidb_0x66b.RspLikeInfo stLikeInfo = new Oidb_0x66b.RspLikeInfo();
    public Oidb_0x66b.RspPansocialInfo stPansocialInfo = new Oidb_0x66b.RspPansocialInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 480802, 481602, 482402, 483202, 484002, 484802 }, new String[] { "bytes_rspbody_5eb", "stLikeInfo", "stPansocialInfo", "bytes_rspbody_gift", "stConfigList", "rpt_msg_vistor_info" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2, null, null }, RspBody.class);
    }
  }
  
  public static final class RspConfigItem
    extends MessageMicro<RspConfigItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 484008, 484018, 484026, 484034, 484040, 484050 }, new String[] { "uint32_id", "str_name", "str_url", "str_picurl", "uint32_redtouch_appid", "str_tips" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, RspConfigItem.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_picurl = PBField.initString("");
    public final PBStringField str_tips = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_redtouch_appid = PBField.initUInt32(0);
  }
  
  public static final class RspLikeInfo
    extends MessageMicro<RspLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 481608, 481616 }, new String[] { "uint32_total", "uint32_new" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspLikeInfo.class);
    public final PBUInt32Field uint32_new = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  }
  
  public static final class RspPansocialInfo
    extends MessageMicro<RspPansocialInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 482408, 482416, 482424, 482432 }, new String[] { "uint32_charm", "uint32_charmlevel", "uint32_charmlevelvalue", "uint32_nextcharmlevelvalue" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspPansocialInfo.class);
    public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charmlevel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_charmlevelvalue = PBField.initUInt32(0);
    public final PBUInt32Field uint32_nextcharmlevelvalue = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x66b.Oidb_0x66b
 * JD-Core Version:    0.7.0.1
 */