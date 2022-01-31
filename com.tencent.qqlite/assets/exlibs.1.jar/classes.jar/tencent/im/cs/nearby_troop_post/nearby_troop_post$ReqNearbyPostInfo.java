package tencent.im.cs.nearby_troop_post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_post$ReqNearbyPostInfo
  extends MessageMicro
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_post.nearby_troop_post.ReqNearbyPostInfo
 * JD-Core Version:    0.7.0.1
 */