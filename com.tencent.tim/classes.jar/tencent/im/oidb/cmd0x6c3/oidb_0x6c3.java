package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6c3
{
  public static final class ExclusiveGiftItem
    extends MessageMicro<ExclusiveGiftItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "gift_id" }, new Object[] { Long.valueOf(0L) }, ExclusiveGiftItem.class);
    public final PBInt64Field gift_id = PBField.initInt64(0L);
  }
  
  public static final class ExtParam
    extends MessageMicro<ExtParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 106 }, new String[] { "msg_login_sig", "msg_user_login_session" }, new Object[] { null, null }, ExtParam.class);
    public oidb_0x6c3.LoginSig msg_login_sig = new oidb_0x6c3.LoginSig();
    public oidb_0x6c3.UserLoginSession msg_user_login_session = new oidb_0x6c3.UserLoginSession();
  }
  
  public static final class GetExtraDataReq
    extends MessageMicro<GetExtraDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_config_id", "int32_version_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetExtraDataReq.class);
    public final PBInt32Field int32_config_id = PBField.initInt32(0);
    public final PBInt32Field int32_version_seq = PBField.initInt32(0);
  }
  
  public static final class GetExtraDataRsp
    extends MessageMicro<GetExtraDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_shop_config = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_version_seq = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_shop_config", "int32_version_seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, GetExtraDataRsp.class);
    }
  }
  
  public static final class GetStockReq
    extends MessageMicro<GetStockReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_not_need_gift_stock", "uint32_imgshow_config", "uint32_not_give_stock", "uint32_not_midas_stock" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetStockReq.class);
    public final PBBoolField bool_not_need_gift_stock = PBField.initBool(false);
    public final PBUInt32Field uint32_imgshow_config = PBField.initUInt32(0);
    public final PBUInt32Field uint32_not_give_stock = PBField.initUInt32(0);
    public final PBUInt32Field uint32_not_midas_stock = PBField.initUInt32(0);
  }
  
  public static final class GetStockRsp
    extends MessageMicro<GetStockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_give_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_midas_error = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recharge_activity = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_count = PBField.initInt32(0);
    public final PBInt32Field int32_give_count = PBField.initInt32(0);
    public final PBInt64Field int64_balance = PBField.initInt64(0L);
    public final PBInt64Field int64_midas_gen_balance = PBField.initInt64(0L);
    public oidb_0x6c3.ImgShowConfig msg_imgshow_config = new oidb_0x6c3.ImgShowConfig();
    public oidb_0x6c3.StockInfo msg_stock = new oidb_0x6c3.StockInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74 }, new String[] { "int32_count", "int32_give_count", "bytes_give_info", "msg_stock", "bytes_recharge_activity", "msg_imgshow_config", "int64_balance", "int64_midas_gen_balance", "bytes_midas_error" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro3 }, GetStockRsp.class);
    }
  }
  
  public static final class ImgShowConfig
    extends MessageMicro<ImgShowConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_imgshow_item" }, new Object[] { null }, ImgShowConfig.class);
    public final PBRepeatMessageField<oidb_0x6c3.ImgShowItem> msg_imgshow_item = PBField.initRepeatMessage(oidb_0x6c3.ImgShowItem.class);
  }
  
  public static final class ImgShowItem
    extends MessageMicro<ImgShowItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cut_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_price = PBField.initUInt32(0);
    public final PBUInt32Field uint32_productid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_productid", "uint32_price", "bytes_wording", "bytes_cut_wording" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ImgShowItem.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6c3.ExtParam msg_ext_param = new oidb_0x6c3.ExtParam();
    public oidb_0x6c3.GetExtraDataReq msg_extra_data = new oidb_0x6c3.GetExtraDataReq();
    public oidb_0x6c3.GetStockReq msg_get_stock = new oidb_0x6c3.GetStockReq();
    public final PBUInt32Field uint32_activity_detail = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_stock_cache = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 74, 80, 88, 96, 104 }, new String[] { "uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_get_stock", "msg_extra_data", "uint32_business_id", "uint32_req_from", "uint32_activity_detail", "uint32_use_stock_cache" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x6c3.ExclusiveGiftItem> exclusive_gift_list = PBField.initRepeatMessage(oidb_0x6c3.ExclusiveGiftItem.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public oidb_0x6c3.GetExtraDataRsp msg_extra_data = new oidb_0x6c3.GetExtraDataRsp();
    public oidb_0x6c3.GetStockRsp msg_get_stock = new oidb_0x6c3.GetStockRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "int32_ret", "bytes_msg", "msg_get_stock", "msg_extra_data", "exclusive_gift_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null }, RspBody.class);
    }
  }
  
  public static final class StockInfo
    extends MessageMicro<StockInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_stock" }, new Object[] { null }, StockInfo.class);
    public final PBRepeatMessageField<oidb_0x6c3.StockItem> msg_stock = PBField.initRepeatMessage(oidb_0x6c3.StockItem.class);
  }
  
  public static final class StockItem
    extends MessageMicro<StockItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_productid", "int32_amount", "int32_free_limit_chance" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StockItem.class);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_free_limit_chance = PBField.initInt32(0);
    public final PBInt32Field int32_productid = PBField.initInt32(0);
  }
  
  public static final class UserLoginSession
    extends MessageMicro<UserLoginSession>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_accesstoken = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_appid", "bytes_openid", "bytes_accesstoken" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, UserLoginSession.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6c3.oidb_0x6c3
 * JD-Core Version:    0.7.0.1
 */