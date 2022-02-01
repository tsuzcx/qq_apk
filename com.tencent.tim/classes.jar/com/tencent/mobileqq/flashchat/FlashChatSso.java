package com.tencent.mobileqq.flashchat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FlashChatSso
{
  public static final class TItem
    extends MessageMicro<TItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "i32_id", "uint32_feetype", "string_name", "string_icon_url", "string_app_name", "string_main_view", "string_ver", "string_bg_color" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", "" }, TItem.class);
    public final PBInt32Field i32_id = PBField.initInt32(0);
    public final PBStringField string_app_name = PBField.initString("");
    public final PBStringField string_bg_color = PBField.initString("");
    public final PBStringField string_icon_url = PBField.initString("");
    public final PBStringField string_main_view = PBField.initString("");
    public final PBStringField string_name = PBField.initString("");
    public final PBStringField string_ver = PBField.initString("");
    public final PBUInt32Field uint32_feetype = PBField.initUInt32(0);
  }
  
  public static final class TSsoCmd0x1Rsp
    extends MessageMicro<TSsoCmd0x1Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "item" }, new Object[] { null }, TSsoCmd0x1Rsp.class);
    public final PBRepeatMessageField<FlashChatSso.TItem> item = PBField.initRepeatMessage(FlashChatSso.TItem.class);
  }
  
  public static final class TSsoReq
    extends MessageMicro<TSsoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_cmd", "i32_implat", "str_qq_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, TSsoReq.class);
    public final PBInt32Field i32_cmd = PBField.initInt32(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public final PBStringField str_qq_ver = PBField.initString("");
  }
  
  public static final class TSsoRsp
    extends MessageMicro<TSsoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "i32_ret", "str_msg", "st_cmd0x1_rsp" }, new Object[] { Integer.valueOf(0), "", null }, TSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public FlashChatSso.TSsoCmd0x1Rsp st_cmd0x1_rsp = new FlashChatSso.TSsoCmd0x1Rsp();
    public final PBStringField str_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatSso
 * JD-Core Version:    0.7.0.1
 */