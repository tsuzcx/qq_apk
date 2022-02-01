package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class richtext
{
  public static final class Attach
    extends MessageMicro<Attach>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "name", "url", "size", "busid" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, Attach.class);
    public final PBUInt32Field busid = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class MultiMedia
    extends MessageMicro<MultiMedia>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic", "voice", "video", "attach" }, new Object[] { null, null, null, null }, MultiMedia.class);
    public final PBRepeatMessageField<richtext.Attach> attach = PBField.initRepeatMessage(richtext.Attach.class);
    public final PBRepeatMessageField<richtext.Picture> pic = PBField.initRepeatMessage(richtext.Picture.class);
    public final PBRepeatMessageField<richtext.Video> video = PBField.initRepeatMessage(richtext.Video.class);
    public final PBRepeatMessageField<richtext.Voice> voice = PBField.initRepeatMessage(richtext.Voice.class);
  }
  
  public static final class Picture
    extends MessageMicro<Picture>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "url", "size" }, new Object[] { "", Integer.valueOf(0) }, Picture.class);
    public final PBRepeatField<Integer> size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Video
    extends MessageMicro<Video>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50 }, new String[] { "url", "title", "summary", "pic", "type", "realurl" }, new Object[] { "", "", "", "", Integer.valueOf(0), "" }, Video.class);
    public final PBStringField pic = PBField.initString("");
    public final PBStringField realurl = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Voice
    extends MessageMicro<Voice>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "url", "time", "size", "url_mp3" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "" }, Voice.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBStringField url_mp3 = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.richtext
 * JD-Core Version:    0.7.0.1
 */