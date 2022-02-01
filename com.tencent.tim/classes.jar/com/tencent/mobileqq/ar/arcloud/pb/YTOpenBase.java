package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase
{
  public static final class FaceItem
    extends MessageMicro<FaceItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 37, 45, 48, 56, 64, 72, 80, 88, 96, 104, 165, 173, 181, 189, 242, 320, 328, 336 }, new String[] { "face_id", "x", "y", "height", "width", "pitch", "roll", "yaw", "age", "gender", "glass", "expression", "beauty", "rel_leftx", "rel_width", "rel_lefty", "rel_height", "face_shape", "glasses", "mask", "hat" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FaceItem.class);
    public final PBInt32Field age = PBField.initInt32(0);
    public final PBInt32Field beauty = PBField.initInt32(0);
    public final PBInt32Field expression = PBField.initInt32(0);
    public final PBStringField face_id = PBField.initString("");
    public YTOpenBase.FaceShapeItem face_shape = new YTOpenBase.FaceShapeItem();
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBBoolField glass = PBField.initBool(false);
    public final PBInt32Field glasses = PBField.initInt32(0);
    public final PBInt32Field hat = PBField.initInt32(0);
    public final PBFloatField height = PBField.initFloat(0.0F);
    public final PBInt32Field mask = PBField.initInt32(0);
    public final PBInt32Field pitch = PBField.initInt32(0);
    public final PBFloatField rel_height = PBField.initFloat(0.0F);
    public final PBFloatField rel_leftx = PBField.initFloat(0.0F);
    public final PBFloatField rel_lefty = PBField.initFloat(0.0F);
    public final PBFloatField rel_width = PBField.initFloat(0.0F);
    public final PBInt32Field roll = PBField.initInt32(0);
    public final PBFloatField width = PBField.initFloat(0.0F);
    public final PBInt32Field x = PBField.initInt32(0);
    public final PBInt32Field y = PBField.initInt32(0);
    public final PBInt32Field yaw = PBField.initInt32(0);
  }
  
  public static final class FaceShapeItem
    extends MessageMicro<FaceShapeItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 42, 50, 58, 66, 74 }, new String[] { "face_profile", "left_eye", "right_eye", "left_eyebrow", "right_eyebrow", "mouth", "nose" }, new Object[] { null, null, null, null, null, null, null }, FaceShapeItem.class);
    public final PBRepeatMessageField<YTOpenBase.point> face_profile = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> left_eye = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> left_eyebrow = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> mouth = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> nose = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> right_eye = PBField.initRepeatMessage(YTOpenBase.point.class);
    public final PBRepeatMessageField<YTOpenBase.point> right_eyebrow = PBField.initRepeatMessage(YTOpenBase.point.class);
  }
  
  public static final class FeatureItem
    extends MessageMicro<FeatureItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField face_id = PBField.initString("");
    public final PBInt32Field version = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "face_id", "data", "version" }, new Object[] { "", localByteStringMicro, Integer.valueOf(0) }, FeatureItem.class);
    }
  }
  
  public static final class StoreFace
    extends MessageMicro<StoreFace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "face_id", "face_item", "tag" }, new Object[] { "", null, "" }, StoreFace.class);
    public final PBStringField face_id = PBField.initString("");
    public YTOpenBase.FaceItem face_item = new YTOpenBase.FaceItem();
    public final PBStringField tag = PBField.initString("");
  }
  
  public static final class StoreFeature
    extends MessageMicro<StoreFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 50 }, new String[] { "person_id", "feature", "group_ids", "version" }, new Object[] { "", null, "", "" }, StoreFeature.class);
    public final PBRepeatMessageField<YTOpenBase.FeatureItem> feature = PBField.initRepeatMessage(YTOpenBase.FeatureItem.class);
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField person_id = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class StoreGroup
    extends MessageMicro<StoreGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "group_id", "person_ids", "tag" }, new Object[] { "", "", "" }, StoreGroup.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBRepeatField<String> person_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField tag = PBField.initString("");
  }
  
  public static final class StoreGroupCluster
    extends MessageMicro<StoreGroupCluster>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "size", "cur_group" }, new Object[] { "", "" }, StoreGroupCluster.class);
    public final PBStringField cur_group = PBField.initString("");
    public final PBStringField size = PBField.initString("");
  }
  
  public static final class StoreGroupList
    extends MessageMicro<StoreGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_id", "group_ids" }, new Object[] { "", "" }, StoreGroupList.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StorePerson
    extends MessageMicro<StorePerson>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "person_id", "person_name", "face_ids", "group_ids", "tag" }, new Object[] { "", "", "", "", "" }, StorePerson.class);
    public final PBRepeatField<String> face_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField person_id = PBField.initString("");
    public final PBStringField person_name = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
  }
  
  public static final class point
    extends MessageMicro<point>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "x", "y" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, point.class);
    public final PBInt32Field x = PBField.initInt32(0);
    public final PBInt32Field y = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase
 * JD-Core Version:    0.7.0.1
 */