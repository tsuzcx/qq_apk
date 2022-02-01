package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicDislike
{
  public static final class FeedsItem_Dislike
    extends MessageMicro<FeedsItem_Dislike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ulFeedID", "strFeedCookie", "strDislikeFeedback" }, new Object[] { Long.valueOf(0L), "", "" }, FeedsItem_Dislike.class);
    public final PBStringField strDislikeFeedback = PBField.initString("");
    public final PBStringField strFeedCookie = PBField.initString("");
    public final PBUInt64Field ulFeedID = PBField.initUInt64(0L);
  }
  
  public static final class SubCmd_FeedsItem_ReqInfo_Dislike
    extends MessageMicro<SubCmd_FeedsItem_ReqInfo_Dislike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "DislikeList" }, new Object[] { null }, SubCmd_FeedsItem_ReqInfo_Dislike.class);
    public final PBRepeatMessageField<DynamicDislike.FeedsItem_Dislike> DislikeList = PBField.initRepeatMessage(DynamicDislike.FeedsItem_Dislike.class);
  }
  
  public static final class SubCmd_FeedsItem_RespInfo_Dislike
    extends MessageMicro<SubCmd_FeedsItem_RespInfo_Dislike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uiRetCode" }, new Object[] { Integer.valueOf(0) }, SubCmd_FeedsItem_RespInfo_Dislike.class);
    public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicDislike
 * JD-Core Version:    0.7.0.1
 */