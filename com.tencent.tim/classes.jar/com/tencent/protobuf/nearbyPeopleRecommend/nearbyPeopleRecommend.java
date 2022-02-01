package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public final class nearbyPeopleRecommend
{
  public static final class LBSInfo
    extends MessageMicro<LBSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "location" }, new Object[] { null }, LBSInfo.class);
    public nearbyPeopleRecommend.Location location = new nearbyPeopleRecommend.Location();
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_latitude", "int32_longitude", "int32_coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
    public final PBInt32Field int32_coordinate = PBField.initInt32(0);
    public final PBInt32Field int32_latitude = PBField.initInt32(0);
    public final PBInt32Field int32_longitude = PBField.initInt32(0);
  }
  
  public static final class QueryRecommendReq
    extends MessageMicro<QueryRecommendReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_qq_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public nearbyPeopleRecommend.LBSInfo lbs_info = new nearbyPeopleRecommend.LBSInfo();
    public final PBRepeatMessageField<nearbyPeopleRecommend.QueryReqItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend.QueryReqItem.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "lbs_info", "source", "query_list", "uint32_client_version", "uint32_client_type", "bytes_qq_version" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, QueryRecommendReq.class);
    }
  }
  
  public static final class QueryRecommendRsp
    extends MessageMicro<QueryRecommendRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret_code", "ret_msg", "query_list" }, new Object[] { Integer.valueOf(0), "", null }, QueryRecommendRsp.class);
    public final PBRepeatMessageField<nearbyPeopleRecommend.QueryRspItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend.QueryRspItem.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
  }
  
  public static final class QueryReqItem
    extends MessageMicro<QueryReqItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_id" }, new Object[] { "" }, QueryReqItem.class);
    public final PBStringField msg_id = PBField.initString("");
  }
  
  public static final class QueryRspItem
    extends MessageMicro<QueryRspItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_id", "rd_people" }, new Object[] { "", null }, QueryRspItem.class);
    public final PBStringField msg_id = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x8dd.NearbyPeople> rd_people = PBField.initRepeatMessage(oidb_0x8dd.NearbyPeople.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend
 * JD-Core Version:    0.7.0.1
 */