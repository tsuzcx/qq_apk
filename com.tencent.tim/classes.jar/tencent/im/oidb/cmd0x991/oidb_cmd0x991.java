package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.VideoFile;

public final class oidb_cmd0x991
{
  public static final class Goods
    extends MessageMicro<Goods>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_animation_param = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_goods_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_goods_price = PBField.initInt32(0);
    public final PBInt32Field int32_product_id = PBField.initInt32(0);
    public im_msg_body.CustomFace msg_img = new im_msg_body.CustomFace();
    public im_msg_body.VideoFile msg_video = new im_msg_body.VideoFile();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "int32_product_id", "bytes_goods_name", "int32_goods_price", "bytes_animation_param", "msg_video", "msg_img" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, null }, Goods.class);
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_user", "msg_goods" }, new Object[] { null, null }, ReqBody.class);
    public oidb_cmd0x991.Goods msg_goods = new oidb_cmd0x991.Goods();
    public oidb_cmd0x991.User msg_user = new oidb_cmd0x991.User();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_stock_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0x991.StockRsp msg_stock_rsp = new oidb_cmd0x991.StockRsp();
  }
  
  public static final class StockRsp
    extends MessageMicro<StockRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_midas_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt64Field int64_give_stock = PBField.initInt64(0L);
    public final PBInt64Field int64_midas_balance = PBField.initInt64(0L);
    public final PBInt64Field int64_user_stock = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int64_user_stock", "int64_give_stock", "int64_midas_balance", "bytes_midas_json" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, StockRsp.class);
    }
  }
  
  public static final class User
    extends MessageMicro<User>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x991.LoginSig msg_login_sig = new oidb_cmd0x991.LoginSig();
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48 }, new String[] { "uint64_group", "uint32_client", "bytes_version", "uint32_portal", "msg_login_sig", "uint32_instance_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0) }, User.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x991.oidb_cmd0x991
 * JD-Core Version:    0.7.0.1
 */