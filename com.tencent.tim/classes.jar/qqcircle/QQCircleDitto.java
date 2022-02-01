package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StImage;

public final class QQCircleDitto
{
  public static final class StButton
    extends MessageMicro<StButton>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "name", "needShow", "jumpUrl", "buttonValue" }, new Object[] { "", Boolean.valueOf(false), "", Integer.valueOf(0) }, StButton.class);
    public final PBUInt32Field buttonValue = PBField.initUInt32(0);
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBBoolField needShow = PBField.initBool(false);
  }
  
  public static final class StCircleDittoDataNew
    extends MessageMicro<StCircleDittoDataNew>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "itemContainter", "singlePicBanner", "dividingLine", "multiItemContainter" }, new Object[] { null, null, null, null }, StCircleDittoDataNew.class);
    public QQCircleDitto.StDividingLine dividingLine = new QQCircleDitto.StDividingLine();
    public QQCircleDitto.StItemContainer itemContainter = new QQCircleDitto.StItemContainer();
    public final PBRepeatMessageField<QQCircleDitto.StItemContainer> multiItemContainter = PBField.initRepeatMessage(QQCircleDitto.StItemContainer.class);
    public QQCircleDitto.StSinglePicBanner singlePicBanner = new QQCircleDitto.StSinglePicBanner();
  }
  
  public static final class StDividingLine
    extends MessageMicro<StDividingLine>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "summary" }, new Object[] { "" }, StDividingLine.class);
    public final PBStringField summary = PBField.initString("");
  }
  
  public static final class StItemContainer
    extends MessageMicro<StItemContainer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "title", "items", "urlInfo", "subTitle", "containerType" }, new Object[] { "", null, null, "", Integer.valueOf(0) }, StItemContainer.class);
    public final PBUInt32Field containerType = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleDitto.StItemInfo> items = PBField.initRepeatMessage(QQCircleDitto.StItemInfo.class);
    public final PBStringField subTitle = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StItemInfo
    extends MessageMicro<StItemInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "id", "name", "des", "images", "buttonInfo", "urlInfo", "busiInfo" }, new Object[] { "", "", "", null, null, null, null }, StItemInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public QQCircleDitto.StButton buttonInfo = new QQCircleDitto.StButton();
    public final PBRepeatField<String> des = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField id = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudMeta.StImage> images = PBField.initRepeatMessage(FeedCloudMeta.StImage.class);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StNegativeFbButton
    extends MessageMicro<StNegativeFbButton>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32 }, new String[] { "buttonType", "needShow", "buttonValue" }, new Object[] { Integer.valueOf(1), Boolean.valueOf(false), Integer.valueOf(0) }, StNegativeFbButton.class);
    public final PBEnumField buttonType = PBField.initEnum(1);
    public final PBUInt32Field buttonValue = PBField.initUInt32(0);
    public final PBBoolField needShow = PBField.initBool(false);
  }
  
  public static final class StSinglePicBanner
    extends MessageMicro<StSinglePicBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "image", "actionType", "actionUrl", "buttons" }, new Object[] { null, Integer.valueOf(1), "", null }, StSinglePicBanner.class);
    public final PBEnumField actionType = PBField.initEnum(1);
    public final PBStringField actionUrl = PBField.initString("");
    public final PBRepeatMessageField<QQCircleDitto.StNegativeFbButton> buttons = PBField.initRepeatMessage(QQCircleDitto.StNegativeFbButton.class);
    public FeedCloudMeta.StImage image = new FeedCloudMeta.StImage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleDitto
 * JD-Core Version:    0.7.0.1
 */