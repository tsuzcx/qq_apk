package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackServer
{
  public static final class GetNewPackReq
    extends MessageMicro<GetNewPackReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBUInt32Field group_id = PBField.initUInt32(0);
    public final PBUInt32Field group_type = PBField.initUInt32(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 160 }, new String[] { "promotion_id", "seq", "signature", "group_id", "group_type", "business" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetNewPackReq.class);
    }
  }
  
  public static final class GetNewPackResp
    extends MessageMicro<GetNewPackResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 80 }, new String[] { "promotion_id", "seq", "data", "empty_url", "follow", "is_bingo_limit" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", Boolean.valueOf(false), Integer.valueOf(0) }, GetNewPackResp.class);
    public PackData.Pack data = new PackData.Pack();
    public final PBStringField empty_url = PBField.initString("");
    public final PBBoolField follow = PBField.initBool(false);
    public final PBUInt32Field is_bingo_limit = PBField.initUInt32(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class GivePackReq
    extends MessageMicro<GivePackReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "pack_id", "peer_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, GivePackReq.class);
    }
  }
  
  public static final class GivePackResp
    extends MessageMicro<GivePackResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "data", "peer_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, GivePackResp.class);
    }
  }
  
  public static final class PkgReq
    extends MessageMicro<PkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField a8 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt32Field ctime = PBField.initUInt32(0);
    public final PBUInt32Field from_id = PBField.initUInt32(0);
    public PackServer.GetNewPackReq get_new_pack = new PackServer.GetNewPackReq();
    public PackServer.GivePackReq give_pack = new PackServer.GivePackReq();
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public PackServer.QueryBusinessReq query_business = new PackServer.QueryBusinessReq();
    public PackServer.QueryLuckyUsersReq query_lucky_users = new PackServer.QueryLuckyUsersReq();
    public PackServer.QueryPackReq query_pack = new PackServer.QueryPackReq();
    public PackServer.QueryPackListReq query_pack_list = new PackServer.QueryPackListReq();
    public PackServer.QueryPromotionReq query_promotion = new PackServer.QueryPromotionReq();
    public PackServer.QueryReloadCounterReq query_reload_counter = new PackServer.QueryReloadCounterReq();
    public PackServer.QueryRemainPackReq query_remain_pack = new PackServer.QueryRemainPackReq();
    public PackServer.QueryUserHistoryReq query_user_history = new PackServer.QueryUserHistoryReq();
    public PackServer.SetPackUsedReq set_pack_used = new PackServer.SetPackUsedReq();
    public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 162, 170, 176, 184, 192, 200 }, new String[] { "cmdtype", "uin", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "query_reload_counter", "skey", "a8", "appid", "from_id", "net_type", "ctime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkgReq.class);
    }
  }
  
  public static final class PkgResp
    extends MessageMicro<PkgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 160, 168, 176 }, new String[] { "cmdtype", "uin", "errcode", "errmsg", "resp_name", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "grab_interval", "report_active_interval", "report_normal_interval" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkgResp.class);
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public PackServer.GetNewPackResp get_new_pack = new PackServer.GetNewPackResp();
    public PackServer.GivePackResp give_pack = new PackServer.GivePackResp();
    public final PBUInt32Field grab_interval = PBField.initUInt32(0);
    public PackServer.QueryBusinessResp query_business = new PackServer.QueryBusinessResp();
    public PackServer.QueryLuckyUsersResp query_lucky_users = new PackServer.QueryLuckyUsersResp();
    public PackServer.QueryPackResp query_pack = new PackServer.QueryPackResp();
    public PackServer.QueryPackListResp query_pack_list = new PackServer.QueryPackListResp();
    public PackServer.QueryPromotionResp query_promotion = new PackServer.QueryPromotionResp();
    public PackServer.QueryRemainPackResp query_remain_pack = new PackServer.QueryRemainPackResp();
    public PackServer.QueryUserHistoryResp query_user_history = new PackServer.QueryUserHistoryResp();
    public final PBUInt32Field report_active_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_normal_interval = PBField.initUInt32(0);
    public final PBStringField resp_name = PBField.initString("");
    public PackServer.SetPackUsedResp set_pack_used = new PackServer.SetPackUsedResp();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class QueryBusinessReq
    extends MessageMicro<QueryBusinessReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "business" }, new Object[] { Integer.valueOf(0) }, QueryBusinessReq.class);
    public final PBUInt32Field business = PBField.initUInt32(0);
  }
  
  public static final class QueryBusinessResp
    extends MessageMicro<QueryBusinessResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "business", "pack" }, new Object[] { Integer.valueOf(0), null }, QueryBusinessResp.class);
    public final PBUInt32Field business = PBField.initUInt32(0);
    public PackData.Pack pack = new PackData.Pack();
  }
  
  public static final class QueryLuckyUsersReq
    extends MessageMicro<QueryLuckyUsersReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "count" }, new Object[] { Integer.valueOf(0) }, QueryLuckyUsersReq.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
  }
  
  public static final class QueryLuckyUsersResp
    extends MessageMicro<QueryLuckyUsersResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField list = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "list" }, new Object[] { localByteStringMicro }, QueryLuckyUsersResp.class);
    }
  }
  
  public static final class QueryPackListReq
    extends MessageMicro<QueryPackListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "from_index", "count", "type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryPackListReq.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBUInt32Field from_index = PBField.initUInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class QueryPackListResp
    extends MessageMicro<QueryPackListResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "from_index", "total_count", "count", "data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, QueryPackListResp.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBRepeatMessageField<PackData.Pack> data = PBField.initRepeatMessage(PackData.Pack.class);
    public final PBUInt32Field from_index = PBField.initUInt32(0);
    public final PBUInt32Field total_count = PBField.initUInt32(0);
  }
  
  public static final class QueryPackReq
    extends MessageMicro<QueryPackReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pack_id" }, new Object[] { localByteStringMicro }, QueryPackReq.class);
    }
  }
  
  public static final class QueryPackResp
    extends MessageMicro<QueryPackResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "data" }, new Object[] { null }, QueryPackResp.class);
    public PackData.Pack data = new PackData.Pack();
  }
  
  public static final class QueryPromotionReq
    extends MessageMicro<QueryPromotionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "promotion_id" }, new Object[] { Integer.valueOf(0) }, QueryPromotionReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class QueryPromotionResp
    extends MessageMicro<QueryPromotionResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "promotion_id" }, new Object[] { Integer.valueOf(0) }, QueryPromotionResp.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class QueryReloadCounterReq
    extends MessageMicro<QueryReloadCounterReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "now" }, new Object[] { Integer.valueOf(0) }, QueryReloadCounterReq.class);
    public final PBUInt32Field now = PBField.initUInt32(0);
  }
  
  public static final class QueryRemainPackReq
    extends MessageMicro<QueryRemainPackReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "promotion_id" }, new Object[] { Integer.valueOf(0) }, QueryRemainPackReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class QueryRemainPackResp
    extends MessageMicro<QueryRemainPackResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "promotion_id", "pack_count", "interval_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryRemainPackResp.class);
    public final PBUInt32Field interval_time = PBField.initUInt32(0);
    public final PBUInt32Field pack_count = PBField.initUInt32(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class QueryUserHistoryReq
    extends MessageMicro<QueryUserHistoryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "promotion_id" }, new Object[] { Integer.valueOf(0) }, QueryUserHistoryReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class QueryUserHistoryResp
    extends MessageMicro<QueryUserHistoryResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "promotion_id" }, new Object[] { Integer.valueOf(0) }, QueryUserHistoryResp.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  }
  
  public static final class SetPackUsedReq
    extends MessageMicro<SetPackUsedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField external = PBField.initBool(false);
    public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "pack_id", "external" }, new Object[] { localByteStringMicro, Boolean.valueOf(false) }, SetPackUsedReq.class);
    }
  }
  
  public static final class SetPackUsedResp
    extends MessageMicro<SetPackUsedResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business = PBField.initUInt32(0);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "data", "business" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, SetPackUsedResp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer
 * JD-Core Version:    0.7.0.1
 */