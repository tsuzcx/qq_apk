package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicLike
{
  public static final class FeedsItem_Like
    extends MessageMicro<FeedsItem_Like>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ulFeedID", "uiClickTime", "strFeedCookie" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, FeedsItem_Like.class);
    public final PBStringField strFeedCookie = PBField.initString("");
    public final PBUInt32Field uiClickTime = PBField.initUInt32(0);
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd_FeedsItem_ReqInfo_Like
    extends MessageMicro<SubCmd_FeedsItem_ReqInfo_Like>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "LikeList" }, new Object[] { null }, SubCmd_FeedsItem_ReqInfo_Like.class);
    public final PBRepeatMessageField<DynamicLike.FeedsItem_Like> LikeList = PBField.initRepeatMessage(DynamicLike.FeedsItem_Like.class);
  }
  
  public static final class SubCmd_FeedsItem_RespInfo_Like
    extends MessageMicro<SubCmd_FeedsItem_RespInfo_Like>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uiRetCode" }, new Object[] { Integer.valueOf(0) }, SubCmd_FeedsItem_RespInfo_Like.class);
    public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicLike
 * JD-Core Version:    0.7.0.1
 */