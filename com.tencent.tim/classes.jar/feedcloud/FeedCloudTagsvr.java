package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagsvr
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
  
  public static final class FeedsKeyItem
    extends MessageMicro<FeedsKeyItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "feedsKey", "feedsTime" }, new Object[] { "", "" }, FeedsKeyItem.class);
    public final PBStringField feedsKey = PBField.initString("");
    public final PBStringField feedsTime = PBField.initString("");
  }
  
  public static final class GetFeedsKeysByTagIDReq
    extends MessageMicro<GetFeedsKeysByTagIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "id", "feedsTime", "num", "attachInfo" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L), "" }, GetFeedsKeysByTagIDReq.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt64Field feedsTime = PBField.initInt64(0L);
    public final PBStringField id = PBField.initString("");
    public final PBInt64Field num = PBField.initInt64(0L);
  }
  
  public static final class GetFeedsKeysByTagNameReq
    extends MessageMicro<GetFeedsKeysByTagNameReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "name", "feedsTime", "num", "attachInfo" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L), "" }, GetFeedsKeysByTagNameReq.class);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt64Field feedsTime = PBField.initInt64(0L);
    public final PBStringField name = PBField.initString("");
    public final PBInt64Field num = PBField.initInt64(0L);
  }
  
  public static final class GetFeedsKeysRsp
    extends MessageMicro<GetFeedsKeysRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58 }, new String[] { "extInfo", "hasMore", "FeedTotal", "uinTotal", "feedsKeyList", "tag", "attachInfo" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", null, "" }, GetFeedsKeysRsp.class);
    public final PBInt64Field FeedTotal = PBField.initInt64(0L);
    public final PBStringField attachInfo = PBField.initString("");
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field hasMore = PBField.initInt32(0);
    public FeedCloudTagsvr.TagInfo tag = new FeedCloudTagsvr.TagInfo();
    public final PBInt64Field uinTotal = PBField.initInt64(0L);
  }
  
  public static final class GetRecommendTagsReq
    extends MessageMicro<GetRecommendTagsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "secne", "num", "gps" }, new Object[] { null, Integer.valueOf(1), Integer.valueOf(0), null }, GetRecommendTagsReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public FeedCloudMeta.StGPSV2 gps = new FeedCloudMeta.StGPSV2();
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBEnumField secne = PBField.initEnum(1);
  }
  
  public static final class GetRecommendTagsRsp
    extends MessageMicro<GetRecommendTagsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "tagList" }, new Object[] { null, null }, GetRecommendTagsRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatMessageField<FeedCloudTagsvr.RecomTag> tagList = PBField.initRepeatMessage(FeedCloudTagsvr.RecomTag.class);
  }
  
  public static final class GetTopTagsReq
    extends MessageMicro<GetTopTagsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "sortType", "num", "minScore" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetTopTagsReq.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBInt32Field minScore = PBField.initInt32(0);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBInt32Field sortType = PBField.initInt32(0);
  }
  
  public static final class GetTopTagsRsp
    extends MessageMicro<GetTopTagsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "tagList" }, new Object[] { null, "" }, GetTopTagsRsp.class);
    public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
    public final PBRepeatField<String> tagList = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class PageAttach
    extends MessageMicro<PageAttach>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feedsKeyItemList" }, new Object[] { null }, PageAttach.class);
    public final PBRepeatMessageField<FeedCloudTagsvr.FeedsKeyItem> feedsKeyItemList = PBField.initRepeatMessage(FeedCloudTagsvr.FeedsKeyItem.class);
  }
  
  public static final class RecomTag
    extends MessageMicro<RecomTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tag" }, new Object[] { "" }, RecomTag.class);
    public final PBStringField tag = PBField.initString("");
  }
  
  public static final class TagInfo
    extends MessageMicro<TagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagID", "tagName" }, new Object[] { "", "" }, TagInfo.class);
    public final PBStringField tagID = PBField.initString("");
    public final PBStringField tagName = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr
 * JD-Core Version:    0.7.0.1
 */