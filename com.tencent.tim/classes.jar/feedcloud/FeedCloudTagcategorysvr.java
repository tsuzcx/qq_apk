package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagcategorysvr
{
  public static final class PicRecomEntry
    extends MessageMicro<PicRecomEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "picId", "recomTags" }, new Object[] { "", "" }, PicRecomEntry.class);
    public final PBStringField picId = PBField.initString("");
    public final PBRepeatField<String> recomTags = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StTagCategoryAllReq
    extends MessageMicro<StTagCategoryAllReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gpsInfo" }, new Object[] { null }, StTagCategoryAllReq.class);
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  }
  
  public static final class StTagCategoryAllRsp
    extends MessageMicro<StTagCategoryAllRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "categoryList" }, new Object[] { null }, StTagCategoryAllRsp.class);
    public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagCategoryInfo> categoryList = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagCategoryInfo.class);
  }
  
  public static final class StTagCategoryInfo
    extends MessageMicro<StTagCategoryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "categoryName", "tagList", "nextPage" }, new Object[] { "", null, Integer.valueOf(0) }, StTagCategoryInfo.class);
    public final PBStringField categoryName = PBField.initString("");
    public final PBInt32Field nextPage = PBField.initInt32(0);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  }
  
  public static final class StTagCategoryInfoReq
    extends MessageMicro<StTagCategoryInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "TagNames", "ReqType" }, new Object[] { "", Integer.valueOf(0) }, StTagCategoryInfoReq.class);
    public final PBEnumField ReqType = PBField.initEnum(0);
    public final PBRepeatField<String> TagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StTagCategoryInfoRsp
    extends MessageMicro<StTagCategoryInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagInfos" }, new Object[] { null }, StTagCategoryInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  }
  
  public static final class StTagCategoryRecomReq
    extends MessageMicro<StTagCategoryRecomReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "gpsInfo", "picRecomMap", "reqType" }, new Object[] { null, null, Integer.valueOf(0) }, StTagCategoryRecomReq.class);
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    public final PBRepeatMessageField<FeedCloudTagcategorysvr.PicRecomEntry> picRecomMap = PBField.initRepeatMessage(FeedCloudTagcategorysvr.PicRecomEntry.class);
    public final PBInt32Field reqType = PBField.initInt32(0);
  }
  
  public static final class StTagCategoryRecomRsp
    extends MessageMicro<StTagCategoryRecomRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagList" }, new Object[] { null }, StTagCategoryRecomRsp.class);
    public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  }
  
  public static final class StTagOneCategoryReq
    extends MessageMicro<StTagOneCategoryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "categoryName", "reqPage" }, new Object[] { "", Integer.valueOf(0) }, StTagOneCategoryReq.class);
    public final PBStringField categoryName = PBField.initString("");
    public final PBInt32Field reqPage = PBField.initInt32(0);
  }
  
  public static final class StTagOneCategoryRsp
    extends MessageMicro<StTagOneCategoryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "categoryInfo", "nextPage" }, new Object[] { null, Integer.valueOf(0) }, StTagOneCategoryRsp.class);
    public FeedCloudTagcategorysvr.StTagCategoryInfo categoryInfo = new FeedCloudTagcategorysvr.StTagCategoryInfo();
    public final PBInt32Field nextPage = PBField.initInt32(0);
  }
  
  public static final class StTagUserRelateName
    extends MessageMicro<StTagUserRelateName>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "tagNames" }, new Object[] { Integer.valueOf(1), "" }, StTagUserRelateName.class);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class StTagUserRelateNum
    extends MessageMicro<StTagUserRelateNum>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "num" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0) }, StTagUserRelateNum.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
  }
  
  public static final class StTagUserRelateReq
    extends MessageMicro<StTagUserRelateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uid", "nums", "gpsInfo" }, new Object[] { "", null, null }, StTagUserRelateReq.class);
    public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
    public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagUserRelateNum> nums = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagUserRelateNum.class);
    public final PBStringField uid = PBField.initString("");
  }
  
  public static final class StTagUserRelateRsp
    extends MessageMicro<StTagUserRelateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "names" }, new Object[] { null }, StTagUserRelateRsp.class);
    public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagUserRelateName> names = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagUserRelateName.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr
 * JD-Core Version:    0.7.0.1
 */