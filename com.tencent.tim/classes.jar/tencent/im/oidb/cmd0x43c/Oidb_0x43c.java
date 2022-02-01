package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c
{
  public static final class CardInfo
    extends MessageMicro<CardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bind_mbl = PBField.initString("");
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField card_src = PBField.initEnum(1);
    public final PBStringField company = PBField.initString("");
    public final PBRepeatField<String> descs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field last_update_time = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x43c.MobileInfo> mobile_info = PBField.initRepeatMessage(Oidb_0x43c.MobileInfo.class);
    public final PBRepeatField<String> mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField name = PBField.initString("");
    public Oidb_0x43c.OCRInfo ocr_info = new Oidb_0x43c.OCRInfo();
    public final PBStringField pic_url = PBField.initString("");
    public final PBRepeatMessageField<Oidb_0x43c.UinInfo> uin_info = PBField.initRepeatMessage(Oidb_0x43c.UinInfo.class);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106, 114 }, new String[] { "card_id", "pic_url", "name", "company", "uins", "mobiles", "descs", "bind_uin", "card_src", "last_update_time", "ocr_info", "mobile_info", "uin_info", "bind_mbl" }, new Object[] { localByteStringMicro, "", "", "", Long.valueOf(0L), "", "", Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, null, null, "" }, CardInfo.class);
    }
  }
  
  public static final class MobileInfo
    extends MessageMicro<MobileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "mobile", "isFriend", "bind_uin", "nick_name", "format_mobile" }, new Object[] { "", Boolean.valueOf(false), Long.valueOf(0L), "", "" }, MobileInfo.class);
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public final PBStringField format_mobile = PBField.initString("");
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBStringField mobile = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
  }
  
  public static final class OCRInfo
    extends MessageMicro<OCRInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 37, 45, 53 }, new String[] { "name", "uins", "mobiles", "name_dependLevel", "uins_dependLevel", "mobiles_dependLevel" }, new Object[] { "", Long.valueOf(0L), "", Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F) }, OCRInfo.class);
    public final PBRepeatField<String> mobiles = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBFloatField mobiles_dependLevel = PBField.initFloat(0.0F);
    public final PBStringField name = PBField.initString("");
    public final PBFloatField name_dependLevel = PBField.initFloat(0.0F);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBFloatField uins_dependLevel = PBField.initFloat(0.0F);
  }
  
  public static final class RequestAdd
    extends MessageMicro<RequestAdd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "card_info", "isMine" }, new Object[] { null, Boolean.valueOf(false) }, RequestAdd.class);
    public Oidb_0x43c.CardInfo card_info = new Oidb_0x43c.CardInfo();
    public final PBBoolField isMine = PBField.initBool(false);
  }
  
  public static final class RequestCardDetail
    extends MessageMicro<RequestCardDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_id" }, new Object[] { localByteStringMicro }, RequestCardDetail.class);
    }
  }
  
  public static final class RequestCardList
    extends MessageMicro<RequestCardList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "seq", "next_flag", "req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(10) }, RequestCardList.class);
    public final PBUInt32Field next_flag = PBField.initUInt32(0);
    public final PBUInt32Field req_num = PBField.initUInt32(10);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class RequestDel
    extends MessageMicro<RequestDel>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_id" }, new Object[] { localByteStringMicro }, RequestDel.class);
    }
  }
  
  public static final class RequestModify
    extends MessageMicro<RequestModify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_info" }, new Object[] { null }, RequestModify.class);
    public Oidb_0x43c.CardInfo card_info = new Oidb_0x43c.CardInfo();
  }
  
  public static final class ResponseAdd
    extends MessageMicro<ResponseAdd>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_id" }, new Object[] { localByteStringMicro }, ResponseAdd.class);
    }
  }
  
  public static final class ResponseCardDetail
    extends MessageMicro<ResponseCardDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Oidb_0x43c.CardInfo card_info = new Oidb_0x43c.CardInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_id", "card_info" }, new Object[] { localByteStringMicro, null }, ResponseCardDetail.class);
    }
  }
  
  public static final class ResponseCardList
    extends MessageMicro<ResponseCardList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "seq", "next_flag", "others", "mine" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, ResponseCardList.class);
    public Oidb_0x43c.CardInfo mine = new Oidb_0x43c.CardInfo();
    public final PBUInt32Field next_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x43c.CardInfo> others = PBField.initRepeatMessage(Oidb_0x43c.CardInfo.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class ResponseDel
    extends MessageMicro<ResponseDel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ResponseDel.class);
  }
  
  public static final class ResponseModify
    extends MessageMicro<ResponseModify>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ResponseModify.class);
  }
  
  public static final class UinInfo
    extends MessageMicro<UinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "isFriend", "isSearchable" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false) }, UinInfo.class);
    public final PBBoolField isFriend = PBField.initBool(false);
    public final PBBoolField isSearchable = PBField.initBool(false);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c
 * JD-Core Version:    0.7.0.1
 */