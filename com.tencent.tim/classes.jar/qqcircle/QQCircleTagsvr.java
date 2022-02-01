package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleTagsvr
{
  public static final class AddTagReq
    extends MessageMicro<AddTagReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "name" }, new Object[] { null, "" }, AddTagReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class AddTagRsp
    extends MessageMicro<AddTagRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "id" }, new Object[] { null, "" }, AddTagRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class GetFeedsKeysByTagIDReq
    extends MessageMicro<GetFeedsKeysByTagIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "id", "feedsTime", "num" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L) }, GetFeedsKeysByTagIDReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt64Field feedsTime = PBField.initInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBInt64Field num = PBField.initInt64(0L);
  }
  
  public static final class GetFeedsKeysByTagNameReq
    extends MessageMicro<GetFeedsKeysByTagNameReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "name", "feedsTime", "num" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L) }, GetFeedsKeysByTagNameReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt64Field feedsTime = PBField.initInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBInt64Field num = PBField.initInt64(0L);
  }
  
  public static final class GetFeedsKeysRsp
    extends MessageMicro<GetFeedsKeysRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50 }, new String[] { "extInfo", "hasMore", "FeedTotal", "uinTotal", "feedsKeyList", "tag" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", null }, GetFeedsKeysRsp.class);
    public final PBInt64Field FeedTotal = PBField.initInt64(0L);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field hasMore = PBField.initInt32(0);
    public QQCircleTagsvr.TagInfo tag = new QQCircleTagsvr.TagInfo();
    public final PBInt64Field uinTotal = PBField.initInt64(0L);
  }
  
  public static final class StGetTagRecomReq
    extends MessageMicro<StGetTagRecomReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "scene" }, new Object[] { null, Integer.valueOf(0) }, StGetTagRecomReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field scene = PBField.initInt32(0);
  }
  
  public static final class StGetTagRecomRsp
    extends MessageMicro<StGetTagRecomRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "tagList" }, new Object[] { null, null }, StGetTagRecomRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagID", "tagName" }, new Object[] { "", "" }, TagInfo.class);
    public final PBStringField tagID = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleTagsvr
 * JD-Core Version:    0.7.0.1
 */