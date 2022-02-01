package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CouponProto
{
  public static final class AddBusinessFavourReq
    extends MessageMicro<AddBusinessFavourReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bid", "source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AddBusinessFavourReq.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
  }
  
  public static final class AddBusinessFavourResp
    extends MessageMicro<AddBusinessFavourResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "business", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, AddBusinessFavourResp.class);
    public CouponProto.Business business = new CouponProto.Business();
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class AddCouponFavourReq
    extends MessageMicro<AddCouponFavourReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "bid", "cid", "source_id", "city" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, AddCouponFavourReq.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field cid = PBField.initUInt32(0);
    public final PBStringField city = PBField.initString("");
    public final PBUInt32Field source_id = PBField.initUInt32(0);
  }
  
  public static final class AddCouponFavourResp
    extends MessageMicro<AddCouponFavourResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "retcode", "coupon", "ts", "jump_url" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), "" }, AddCouponFavourResp.class);
    public CouponProto.Coupon coupon = new CouponProto.Coupon();
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class BatchCheckBusinessUpdateReq
    extends MessageMicro<BatchCheckBusinessUpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, BatchCheckBusinessUpdateReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class BatchCheckBusinessUpdateResp
    extends MessageMicro<BatchCheckBusinessUpdateResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "retcode", "bids", "source_ids", "ts_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, BatchCheckBusinessUpdateResp.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> ts_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class Business
    extends MessageMicro<Business>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 96, 106, 112, 120, 128, 136 }, new String[] { "bid", "name", "detail", "type", "city", "tag", "contact", "tel", "logo", "mt", "cname", "update_count", "qlife_url", "source_id", "add2favour_time", "shids", "last_add_time" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, Business.class);
    public final PBUInt64Field add2favour_time = PBField.initUInt64(0L);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField city = PBField.initString("");
    public final PBStringField cname = PBField.initString("");
    public final PBStringField contact = PBField.initString("");
    public final PBStringField detail = PBField.initString("");
    public final PBUInt64Field last_add_time = PBField.initUInt64(0L);
    public final PBStringField logo = PBField.initString("");
    public final PBUInt64Field mt = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBStringField qlife_url = PBField.initString("");
    public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBStringField tel = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field update_count = PBField.initUInt32(0);
  }
  
  public static final class CheckMyBusinessFavourUpdateReq
    extends MessageMicro<CheckMyBusinessFavourUpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CheckMyBusinessFavourUpdateReq.class);
  }
  
  public static final class CheckMyBusinessFavourUpdateResp
    extends MessageMicro<CheckMyBusinessFavourUpdateResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "retcode", "bids", "source_ids", "ts_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, CheckMyBusinessFavourUpdateResp.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Long> ts_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class Coupon
    extends MessageMicro<Coupon>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74, 80, 88, 98, 106, 114, 122, 128, 136, 146, 152, 160, 168 }, new String[] { "cid", "bid", "name", "detail", "stime", "etime", "veri_type", "pic", "tag", "shids", "is_valid", "usage", "rebate", "qrcode", "qlife_url", "source_id", "rcv_time", "tips", "rcv_limit", "rcv_count", "is_readdable" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Coupon.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field cid = PBField.initUInt32(0);
    public final PBStringField detail = PBField.initString("");
    public final PBUInt64Field etime = PBField.initUInt64(0L);
    public final PBUInt32Field is_readdable = PBField.initUInt32(0);
    public final PBUInt32Field is_valid = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBStringField qlife_url = PBField.initString("");
    public final PBStringField qrcode = PBField.initString("");
    public final PBUInt32Field rcv_count = PBField.initUInt32(0);
    public final PBUInt32Field rcv_limit = PBField.initUInt32(0);
    public final PBUInt64Field rcv_time = PBField.initUInt64(0L);
    public final PBStringField rebate = PBField.initString("");
    public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
    public final PBUInt64Field stime = PBField.initUInt64(0L);
    public final PBStringField tag = PBField.initString("");
    public final PBStringField tips = PBField.initString("");
    public final PBStringField usage = PBField.initString("");
    public final PBUInt32Field veri_type = PBField.initUInt32(0);
  }
  
  public static final class GetBusinessesDetailReq
    extends MessageMicro<GetBusinessesDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetBusinessesDetailReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class GetBusinessesDetailResp
    extends MessageMicro<GetBusinessesDetailResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "businesses" }, new Object[] { Integer.valueOf(0), null }, GetBusinessesDetailResp.class);
    public final PBRepeatMessageField<CouponProto.Business> businesses = PBField.initRepeatMessage(CouponProto.Business.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class GetCouponsDetailReq
    extends MessageMicro<GetCouponsDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "cids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetCouponsDetailReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> cids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class GetCouponsDetailResp
    extends MessageMicro<GetCouponsDetailResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "coupons" }, new Object[] { Integer.valueOf(0), null }, GetCouponsDetailResp.class);
    public final PBRepeatMessageField<CouponProto.Coupon> coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class GetShopsByBidsReq
    extends MessageMicro<GetShopsByBidsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetShopsByBidsReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class GetShopsByBidsResp
    extends MessageMicro<GetShopsByBidsResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByBidsResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto.Shop> shops = PBField.initRepeatMessage(CouponProto.Shop.class);
  }
  
  public static final class GetShopsDetailReq
    extends MessageMicro<GetShopsDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "shids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetShopsDetailReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class GetShopsDetailResp
    extends MessageMicro<GetShopsDetailResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsDetailResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBRepeatMessageField<CouponProto.Shop> shops = PBField.initRepeatMessage(CouponProto.Shop.class);
  }
  
  public static final class IsValidCouponsReq
    extends MessageMicro<IsValidCouponsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bids", "cids", "source_ids" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, IsValidCouponsReq.class);
    public final PBRepeatField<Integer> bids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> cids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> source_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class IsValidCouponsResp
    extends MessageMicro<IsValidCouponsResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "coupons" }, new Object[] { Integer.valueOf(0), null }, IsValidCouponsResp.class);
    public final PBRepeatMessageField<CouponProto.Coupon> coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class MarkBusinessFavourUpdateReq
    extends MessageMicro<MarkBusinessFavourUpdateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], MarkBusinessFavourUpdateReq.class);
  }
  
  public static final class MarkBusinessFavourUpdateResp
    extends MessageMicro<MarkBusinessFavourUpdateResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "retcode" }, new Object[] { Integer.valueOf(0) }, MarkBusinessFavourUpdateResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class MyBusinessFavourListReq
    extends MessageMicro<MyBusinessFavourListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ts", "stype" }, new Object[] { Long.valueOf(0L), "" }, MyBusinessFavourListReq.class);
    public final PBStringField stype = PBField.initString("");
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class MyBusinessFavourListResp
    extends MessageMicro<MyBusinessFavourListResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "businesses", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, MyBusinessFavourListResp.class);
    public final PBRepeatMessageField<CouponProto.Business> businesses = PBField.initRepeatMessage(CouponProto.Business.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class MyCouponFavourListReq
    extends MessageMicro<MyCouponFavourListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ts", "stype" }, new Object[] { Long.valueOf(0L), "" }, MyCouponFavourListReq.class);
    public final PBStringField stype = PBField.initString("");
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class MyCouponFavourListResp
    extends MessageMicro<MyCouponFavourListResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "retcode", "coupons", "ts" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, MyCouponFavourListResp.class);
    public final PBRepeatMessageField<CouponProto.Coupon> coupons = PBField.initRepeatMessage(CouponProto.Coupon.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class RemoveBusinessFavourReq
    extends MessageMicro<RemoveBusinessFavourReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bid", "source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RemoveBusinessFavourReq.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
  }
  
  public static final class RemoveBusinessFavourResp
    extends MessageMicro<RemoveBusinessFavourResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "retcode", "ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RemoveBusinessFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class RemoveCouponFavourReq
    extends MessageMicro<RemoveCouponFavourReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bid", "cid", "source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RemoveCouponFavourReq.class);
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBUInt32Field cid = PBField.initUInt32(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
  }
  
  public static final class RemoveCouponFavourResp
    extends MessageMicro<RemoveCouponFavourResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "retcode", "ts" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, RemoveCouponFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class ReportReq
    extends MessageMicro<ReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "data" }, new Object[] { Integer.valueOf(0), "" }, ReportReq.class);
    public final PBStringField data = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReportResp
    extends MessageMicro<ReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "retcode" }, new Object[] { Integer.valueOf(0) }, ReportResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
  }
  
  public static final class Shop
    extends MessageMicro<Shop>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 130, 138, 144 }, new String[] { "shid", "bid", "name", "addr", "detail", "city", "region", "area", "tag", "contact", "tel", "maplng", "maplat", "mt", "couponids", "cname", "qlife_url", "source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0) }, Shop.class);
    public final PBStringField addr = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBUInt32Field bid = PBField.initUInt32(0);
    public final PBStringField city = PBField.initString("");
    public final PBStringField cname = PBField.initString("");
    public final PBStringField contact = PBField.initString("");
    public final PBRepeatField<Integer> couponids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField detail = PBField.initString("");
    public final PBUInt32Field maplat = PBField.initUInt32(0);
    public final PBUInt32Field maplng = PBField.initUInt32(0);
    public final PBUInt64Field mt = PBField.initUInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBStringField qlife_url = PBField.initString("");
    public final PBStringField region = PBField.initString("");
    public final PBUInt32Field shid = PBField.initUInt32(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
    public final PBStringField tag = PBField.initString("");
    public final PBStringField tel = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.coupon.CouponProto
 * JD-Core Version:    0.7.0.1
 */