package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x8fc
{
  public static final class CardNameElem
    extends MessageMicro<CardNameElem>
  {
    public static final int CARD_TYPE_TEXT = 1;
    public static final int CARD_TYPE_XC = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_card_type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_card_type", "bytes_value" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, CardNameElem.class);
    }
  }
  
  public static final class ClientInfo
    extends MessageMicro<ClientInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_implat", "string_clientver" }, new Object[] { Integer.valueOf(0), "" }, ClientInfo.class);
    public final PBStringField string_clientver = PBField.initString("");
    public final PBUInt32Field uint32_implat = PBField.initUInt32(0);
  }
  
  public static final class CommCardNameBuf
    extends MessageMicro<CommCardNameBuf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_rich_card_name" }, new Object[] { null }, CommCardNameBuf.class);
    public final PBRepeatMessageField<Oidb_0x8fc.RichCardNameElem> rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc.RichCardNameElem.class);
  }
  
  public static final class LevelName
    extends MessageMicro<LevelName>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_level", "str_name" }, new Object[] { Integer.valueOf(0), "" }, LevelName.class);
    public final PBStringField str_name = PBField.initString("");
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  }
  
  public static final class MemberInfo
    extends MessageMicro<MemberInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comm_rich_card_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_email = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_job = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField member_card_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Oidb_0x8fc.CardNameElem> rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc.CardNameElem.class);
    public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tribe_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tribe_point = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138 }, new String[] { "uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "bytes_special_title", "uint32_special_title_expire_time", "bytes_uin_name", "member_card_name", "bytes_phone", "bytes_email", "bytes_remark", "uint32_gender", "bytes_job", "uint32_tribe_level", "uint32_tribe_point", "rpt_rich_card_name", "bytes_comm_rich_card_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro8 }, MemberInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public Oidb_0x8fc.ClientInfo msg_client_info = new Oidb_0x8fc.ClientInfo();
    public final PBRepeatMessageField<Oidb_0x8fc.LevelName> rpt_level_name = PBField.initRepeatMessage(Oidb_0x8fc.LevelName.class);
    public final PBRepeatMessageField<Oidb_0x8fc.MemberInfo> rpt_mem_level_info = PBField.initRepeatMessage(Oidb_0x8fc.MemberInfo.class);
    public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_office_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66, 74 }, new String[] { "uint64_group_code", "uint32_show_flag", "rpt_mem_level_info", "rpt_level_name", "uint32_update_time", "uint32_office_mode", "uint32_group_open_appid", "msg_client_info", "bytes_auth_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RichCardNameElem
    extends MessageMicro<RichCardNameElem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_ctrl", "bytes_text" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, RichCardNameElem.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "strErrInfo" }, new Object[] { Long.valueOf(0L), "" }, RspBody.class);
    public final PBStringField strErrInfo = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fc.Oidb_0x8fc
 * JD-Core Version:    0.7.0.1
 */