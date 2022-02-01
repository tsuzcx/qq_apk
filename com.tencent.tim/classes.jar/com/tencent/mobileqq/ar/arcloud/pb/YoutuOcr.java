package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoutuOcr
{
  public static final class ItemCoord
    extends MessageMicro<ItemCoord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "x", "y", "width", "height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ItemCoord.class);
    public final PBInt32Field height = PBField.initInt32(0);
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field x = PBField.initInt32(0);
    public final PBInt32Field y = PBField.initInt32(0);
  }
  
  public static final class Language
    extends MessageMicro<Language>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "language", "language_desc" }, new Object[] { "", "" }, Language.class);
    public final PBStringField language = PBField.initString("");
    public final PBStringField language_desc = PBField.initString("");
  }
  
  public static final class OcrItem
    extends MessageMicro<OcrItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "itemstring", "itemcoord" }, new Object[] { "", null }, OcrItem.class);
    public YoutuOcr.ItemCoord itemcoord = new YoutuOcr.ItemCoord();
    public final PBStringField itemstring = PBField.initString("");
  }
  
  public static final class YoutuOcrDetail
    extends MessageMicro<YoutuOcrDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "errorcode", "errormsg", "session_id", "ocr_item", "language", "ocr_language_list", "dst_translate_language_list", "language_list" }, new Object[] { Integer.valueOf(0), "", "", null, "", "", "", null }, YoutuOcrDetail.class);
    public final PBRepeatField<String> dst_translate_language_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField language = PBField.initString("");
    public final PBRepeatMessageField<YoutuOcr.Language> language_list = PBField.initRepeatMessage(YoutuOcr.Language.class);
    public final PBRepeatMessageField<YoutuOcr.OcrItem> ocr_item = PBField.initRepeatMessage(YoutuOcr.OcrItem.class);
    public final PBRepeatField<String> ocr_language_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField session_id = PBField.initString("");
  }
  
  public static final class YoutuOcrReq
    extends MessageMicro<YoutuOcrReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin32_timeout_ms", "language" }, new Object[] { Integer.valueOf(0), "" }, YoutuOcrReq.class);
    public final PBStringField language = PBField.initString("");
    public final PBUInt32Field uin32_timeout_ms = PBField.initUInt32(0);
  }
  
  public static final class YoutuOcrRsp
    extends MessageMicro<YoutuOcrRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "youtu_ocr_errorcode", "youtu_ocr_errormsg", "youtu_orc_detail" }, new Object[] { Integer.valueOf(0), "", null }, YoutuOcrRsp.class);
    public final PBInt32Field youtu_ocr_errorcode = PBField.initInt32(0);
    public final PBStringField youtu_ocr_errormsg = PBField.initString("");
    public YoutuOcr.YoutuOcrDetail youtu_orc_detail = new YoutuOcr.YoutuOcrDetail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr
 * JD-Core Version:    0.7.0.1
 */