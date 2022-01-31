package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post$RspNearbyPostInfo
  extends MessageMicro
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_post.nearby_troop_post.RspNearbyPostInfo
 * JD-Core Version:    0.7.0.1
 */