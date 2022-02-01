package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicPb
{
  public static final class ComicFavorEmotIcons
    extends MessageMicro<ComicFavorEmotIcons>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "md5", "info" }, new Object[] { "", "" }, ComicFavorEmotIcons.class);
    public final PBStringField info = PBField.initString("");
    public final PBStringField md5 = PBField.initString("");
  }
  
  public static final class DelMyComicFavorEmotIconsReqBody
    extends MessageMicro<DelMyComicFavorEmotIconsReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "md5List" }, new Object[] { "" }, DelMyComicFavorEmotIconsReqBody.class);
    public final PBRepeatField<String> md5List = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class DelMyComicFavorEmotIconsRspBody
    extends MessageMicro<DelMyComicFavorEmotIconsRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DelMyComicFavorEmotIconsRspBody.class);
  }
  
  public static final class GetComicGlobalConfigReqBody
    extends MessageMicro<GetComicGlobalConfigReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetComicGlobalConfigReqBody.class);
  }
  
  public static final class GetComicGlobalConfigRspBody
    extends MessageMicro<GetComicGlobalConfigRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "maintab" }, new Object[] { "" }, GetComicGlobalConfigRspBody.class);
    public final PBStringField maintab = PBField.initString("");
  }
  
  public static final class GetMyComicFavorEmotIconsReqBody
    extends MessageMicro<GetMyComicFavorEmotIconsReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetMyComicFavorEmotIconsReqBody.class);
  }
  
  public static final class GetMyComicFavorEmotIconsRspBody
    extends MessageMicro<GetMyComicFavorEmotIconsRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rsps" }, new Object[] { null }, GetMyComicFavorEmotIconsRspBody.class);
    public final PBRepeatMessageField<MqqComicPb.ComicFavorEmotIcons> rsps = PBField.initRepeatMessage(MqqComicPb.ComicFavorEmotIcons.class);
  }
  
  public static final class SetMyComicFavorEmotIconsReqBody
    extends MessageMicro<SetMyComicFavorEmotIconsReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqs" }, new Object[] { null }, SetMyComicFavorEmotIconsReqBody.class);
    public final PBRepeatMessageField<MqqComicPb.ComicFavorEmotIcons> reqs = PBField.initRepeatMessage(MqqComicPb.ComicFavorEmotIcons.class);
  }
  
  public static final class SetMyComicFavorEmotIconsRspBody
    extends MessageMicro<SetMyComicFavorEmotIconsRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SetMyComicFavorEmotIconsRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicPb
 * JD-Core Version:    0.7.0.1
 */