package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_SUBCMD0X1_REQ_NEARBYINFO_FIELD_NUMBER = 2;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_req_nearbyinfo" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
    public nearby_troop_post.ReqNearbyPostInfo msg_subcmd0x1_req_nearbyinfo = new nearby_troop_post.ReqNearbyPostInfo();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class ReqNearbyPostInfo
    extends MessageMicro<ReqNearbyPostInfo>
  {
    public static final int UINT64_LATITUDE_FIELD_NUMBER = 2;
    public static final int UINT64_LONGTITUDE_FIELD_NUMBER = 1;
    public static final int UINT64_RANGE_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_longtitude", "uint64_latitude", "uint64_range", "uint64_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqNearbyPostInfo.class);
    public final PBUInt32Field uint64_latitude = PBField.initUInt32(0);
    public final PBUInt32Field uint64_longtitude = PBField.initUInt32(0);
    public final PBUInt32Field uint64_range = PBField.initUInt32(0);
    public final PBUInt32Field uint64_uin = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int INT32_RESULT_FIELD_NUMBER = 2;
    public static final int MSG_SUBCMD0X1_RSP_NEARBYPOSTINFO_FIELD_NUMBER = 4;
    public static final int STR_ERRO_FIELD_NUMBER = 3;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_sub_cmd", "int32_result", "str_erro", "msg_subcmd0x1_rsp_nearbypostinfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, RspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public nearby_troop_post.RspNearbyPostInfo msg_subcmd0x1_rsp_nearbypostinfo = new nearby_troop_post.RspNearbyPostInfo();
    public final PBStringField str_erro = PBField.initString("");
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class RspNearbyPostInfo
    extends MessageMicro<RspNearbyPostInfo>
  {
    public static final int STR_DESC_FIELD_NUMBER = 2;
    public static final int STR_POST_ADDRESS_FIELD_NUMBER = 7;
    public static final int STR_POST_PICTURE_URL_FIELD_NUMBER = 6;
    public static final int STR_POST_TITLE_FIELD_NUMBER = 5;
    public static final int STR_POST_URL_FIELD_NUMBER = 8;
    public static final int STR_TITLE_FIELD_NUMBER = 1;
    public static final int STR_TITLE_URL_FIELD_NUMBER = 3;
    public static final int UINT32_DISTANCE_FIELD_NUMBER = 4;
    public static final int UINT32_POST_REPLYS_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 72 }, new String[] { "str_title", "str_desc", "str_title_url", "uint32_distance", "str_post_title", "str_post_picture_url", "str_post_address", "str_post_url", "uint32_post_replys" }, new Object[] { "", "", "", Integer.valueOf(0), "", "", "", "", Integer.valueOf(0) }, RspNearbyPostInfo.class);
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_post_address = PBField.initString("");
    public final PBStringField str_post_picture_url = PBField.initString("");
    public final PBStringField str_post_title = PBField.initString("");
    public final PBStringField str_post_url = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_title_url = PBField.initString("");
    public final PBUInt32Field uint32_distance = PBField.initUInt32(0);
    public final PBUInt32Field uint32_post_replys = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_post.nearby_troop_post
 * JD-Core Version:    0.7.0.1
 */