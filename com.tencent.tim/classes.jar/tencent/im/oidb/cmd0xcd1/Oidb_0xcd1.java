package tencent.im.oidb.cmd0xcd1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0xcd1
{
  public static final class EmptyPackagePage
    extends MessageMicro<EmptyPackagePage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enable", "wording", "jump_wording", "jump_url" }, new Object[] { Integer.valueOf(0), "", "", "" }, EmptyPackagePage.class);
    public final PBInt32Field enable = PBField.initInt32(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField jump_wording = PBField.initString("");
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class GetPackageShopReq
    extends MessageMicro<GetPackageShopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "portal_number", "client_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetPackageShopReq.class);
    public final PBInt32Field client_source = PBField.initInt32(0);
    public final PBInt32Field portal_number = PBField.initInt32(0);
  }
  
  public static final class GetPackageShopRsp
    extends MessageMicro<GetPackageShopRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_stock", "empty_package_page" }, new Object[] { null, null }, GetPackageShopRsp.class);
    public Oidb_0xcd1.EmptyPackagePage empty_package_page = new Oidb_0xcd1.EmptyPackagePage();
    public final PBRepeatMessageField<Oidb_0xcd1.StockItem> msg_stock = PBField.initRepeatMessage(Oidb_0xcd1.StockItem.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "get_pack_req" }, new Object[] { null }, ReqBody.class);
    public Oidb_0xcd1.GetPackageShopReq get_pack_req = new Oidb_0xcd1.GetPackageShopReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "get_pack_rsp" }, new Object[] { null }, RspBody.class);
    public Oidb_0xcd1.GetPackageShopRsp get_pack_rsp = new Oidb_0xcd1.GetPackageShopRsp();
  }
  
  public static final class StockItem
    extends MessageMicro<StockItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_productid", "int32_amount" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StockItem.class);
    public final PBInt32Field int32_amount = PBField.initInt32(0);
    public final PBInt32Field int32_productid = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd1.Oidb_0xcd1
 * JD-Core Version:    0.7.0.1
 */