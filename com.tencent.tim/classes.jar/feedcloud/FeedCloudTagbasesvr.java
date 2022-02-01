package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagbasesvr
{
  public static final class StAddTagBaseInfoReq
    extends MessageMicro<StAddTagBaseInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tagParentName", "tagName" }, new Object[] { "", "" }, StAddTagBaseInfoReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagParentName = PBField.initString("");
  }
  
  public static final class StAddTagBaseInfoRsp
    extends MessageMicro<StAddTagBaseInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StAddTagBaseInfoRsp.class);
  }
  
  public static final class StAddTagBaseRelateReq
    extends MessageMicro<StAddTagBaseRelateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "tagName", "tagRelateName", "relateType" }, new Object[] { "", "", Integer.valueOf(0) }, StAddTagBaseRelateReq.class);
    public final PBEnumField relateType = PBField.initEnum(0);
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagRelateName = PBField.initString("");
  }
  
  public static final class StAddTagBaseRelateRsp
    extends MessageMicro<StAddTagBaseRelateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StAddTagBaseRelateRsp.class);
  }
  
  public static final class StChangeTagOrderReq
    extends MessageMicro<StChangeTagOrderReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "tagParentName", "tagName", "orderChange" }, new Object[] { "", "", Integer.valueOf(0) }, StChangeTagOrderReq.class);
    public final PBInt32Field orderChange = PBField.initInt32(0);
    public final PBStringField tagName = PBField.initString("");
    public final PBStringField tagParentName = PBField.initString("");
  }
  
  public static final class StChangeTagOrderRsp
    extends MessageMicro<StChangeTagOrderRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "parentInfo" }, new Object[] { null }, StChangeTagOrderRsp.class);
    public FeedCloudTagbasesvr.StTagBaseInfo parentInfo = new FeedCloudTagbasesvr.StTagBaseInfo();
  }
  
  public static final class StDelTagBaseInfoReq
    extends MessageMicro<StDelTagBaseInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagNames" }, new Object[] { "" }, StDelTagBaseInfoReq.class);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StDelTagBaseInfoRsp
    extends MessageMicro<StDelTagBaseInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], StDelTagBaseInfoRsp.class);
  }
  
  public static final class StFilterTagBaseInfoReq
    extends MessageMicro<StFilterTagBaseInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagNames" }, new Object[] { "" }, StFilterTagBaseInfoReq.class);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StFilterTagBaseInfoRsp
    extends MessageMicro<StFilterTagBaseInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "filteredTags" }, new Object[] { null }, StFilterTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> filteredTags = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  }
  
  public static final class StGetTagBaseAllCategoryReq
    extends MessageMicro<StGetTagBaseAllCategoryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "tagName", "useCache" }, new Object[] { "", Boolean.valueOf(false) }, StGetTagBaseAllCategoryReq.class);
    public final PBStringField tagName = PBField.initString("");
    public final PBBoolField useCache = PBField.initBool(false);
  }
  
  public static final class StGetTagBaseAllCategoryRsp
    extends MessageMicro<StGetTagBaseAllCategoryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "categorys" }, new Object[] { null }, StGetTagBaseAllCategoryRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> categorys = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  }
  
  public static final class StGetTagBaseInfoReq
    extends MessageMicro<StGetTagBaseInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagNames" }, new Object[] { "" }, StGetTagBaseInfoReq.class);
    public final PBRepeatField<String> tagNames = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetTagBaseInfoRsp
    extends MessageMicro<StGetTagBaseInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagBaseInfos" }, new Object[] { null }, StGetTagBaseInfoRsp.class);
    public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> tagBaseInfos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  }
  
  public static final class StTagBaseInfo
    extends MessageMicro<StTagBaseInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72 }, new String[] { "tagName", "categoryChilds", "tagChilds", "relates", "parents", "status", "type", "tagNameId", "createTime" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, StTagBaseInfo.class);
    public final PBRepeatField<String> categoryChilds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field createTime = PBField.initInt64(0L);
    public final PBRepeatField<String> parents = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> relates = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField status = PBField.initEnum(0);
    public final PBRepeatField<String> tagChilds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField tagName = PBField.initString("");
    public final PBInt64Field tagNameId = PBField.initInt64(0L);
    public final PBEnumField type = PBField.initEnum(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr
 * JD-Core Version:    0.7.0.1
 */