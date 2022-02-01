package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare
{
  public static final class DPBiz
    extends MessageMicro<DPBiz>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "biz_zone", "category", "rate", "avg_price", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, DPBiz.class);
    public final PBStringField avg_price = PBField.initString("");
    public final PBStringField biz_zone = PBField.initString("");
    public final PBStringField category = PBField.initString("");
    public final PBUInt32Field has_quan = PBField.initUInt32(0);
    public final PBUInt32Field has_tuan = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field rate = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class GetShopsByIdsReq
    extends MessageMicro<GetShopsByIdsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ids" }, new Object[] { "" }, GetShopsByIdsReq.class);
    public final PBRepeatField<String> ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class GetShopsByIdsResp
    extends MessageMicro<GetShopsByIdsResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ec", "shops" }, new Object[] { Integer.valueOf(0), null }, GetShopsByIdsResp.class);
    public final PBUInt32Field ec = PBField.initUInt32(0);
    public final PBRepeatMessageField<LBSShare.DPBiz> shops = PBField.initRepeatMessage(LBSShare.DPBiz.class);
  }
  
  public static final class LocationReq
    extends MessageMicro<LocationReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 74 }, new String[] { "lat", "lng", "coordinate", "keyword", "category", "page", "count", "requireMyLbs", "imei" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, LocationReq.class);
    public final PBStringField category = PBField.initString("");
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField imei = PBField.initString("");
    public final PBStringField keyword = PBField.initString("");
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field page = PBField.initUInt32(0);
    public final PBUInt32Field requireMyLbs = PBField.initUInt32(0);
  }
  
  public static final class LocationResp
    extends MessageMicro<LocationResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 56 }, new String[] { "ec", "poilist", "mylbs", "next", "is_foreign", "search_id", "is_ark" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, LocationResp.class);
    public final PBUInt32Field ec = PBField.initUInt32(0);
    public final PBUInt32Field is_ark = PBField.initUInt32(0);
    public final PBUInt32Field is_foreign = PBField.initUInt32(0);
    public LBSShare.POI mylbs = new LBSShare.POI();
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBRepeatMessageField<LBSShare.POI> poilist = PBField.initRepeatMessage(LBSShare.POI.class);
    public final PBStringField search_id = PBField.initString("");
  }
  
  public static final class NearByShopsReq
    extends MessageMicro<NearByShopsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "lat", "lng", "coordinate", "begin", "limit", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NearByShopsReq.class);
    public final PBUInt32Field begin = PBField.initUInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class NearByShopsResp
    extends MessageMicro<NearByShopsResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ec", "poilist", "next_begin", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, NearByShopsResp.class);
    public final PBUInt32Field ec = PBField.initUInt32(0);
    public final PBUInt32Field next_begin = PBField.initUInt32(0);
    public final PBRepeatMessageField<LBSShare.Shop> poilist = PBField.initRepeatMessage(LBSShare.Shop.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class POI
    extends MessageMicro<POI>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66, 74, 80, 90, 98, 106 }, new String[] { "name", "addr", "shop_url", "lat", "lng", "coordinate", "id", "shop_url_quan", "dpid", "shop_count", "shangquan_url", "shangquan_wording", "POI_preview_url" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", "", "" }, POI.class);
    public final PBStringField POI_preview_url = PBField.initString("");
    public final PBStringField addr = PBField.initString("");
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBStringField dpid = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField shangquan_url = PBField.initString("");
    public final PBStringField shangquan_wording = PBField.initString("");
    public final PBUInt32Field shop_count = PBField.initUInt32(0);
    public final PBStringField shop_url = PBField.initString("");
    public final PBStringField shop_url_quan = PBField.initString("");
  }
  
  public static final class Shop
    extends MessageMicro<Shop>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "detail", "discount", "price", "soldnum", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, Shop.class);
    public final PBStringField detail = PBField.initString("");
    public final PBStringField discount = PBField.initString("");
    public final PBUInt32Field has_quan = PBField.initUInt32(0);
    public final PBUInt32Field has_tuan = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField price = PBField.initString("");
    public final PBStringField soldnum = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare
 * JD-Core Version:    0.7.0.1
 */