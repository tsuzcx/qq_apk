package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class bankcode_info
{
  public static final class BankcodeCtrlInfo
    extends MessageMicro<BankcodeCtrlInfo>
  {
    public static final int BANKCODE_ELEMS_FIELD_NUMBER = 1;
    public static final int FROMUIN_PHONENUM_FIELD_NUMBER = 6;
    public static final int MSGTAIL_CONF_FILE_MD5_FIELD_NUMBER = 5;
    public static final int MSGTAIL_CONF_FILE_URL_FIELD_NUMBER = 4;
    public static final int MSGTAIL_ID_FIELD_NUMBER = 2;
    public static final int MSGTAIL_VER_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "bankcode_elems", "msgtail_id", "msgtail_ver", "msgtail_conf_file_url", "msgtail_conf_file_md5", "fromuin_phonenum" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, BankcodeCtrlInfo.class);
    public final PBRepeatMessageField<bankcode_info.BankcodeElem> bankcode_elems = PBField.initRepeatMessage(bankcode_info.BankcodeElem.class);
    public final PBStringField fromuin_phonenum = PBField.initString("");
    public final PBStringField msgtail_conf_file_md5 = PBField.initString("");
    public final PBStringField msgtail_conf_file_url = PBField.initString("");
    public final PBUInt32Field msgtail_id = PBField.initUInt32(0);
    public final PBUInt32Field msgtail_ver = PBField.initUInt32(0);
  }
  
  public static final class BankcodeElem
    extends MessageMicro<BankcodeElem>
  {
    public static final int BANKCODE_ATTR_FIELD_NUMBER = 3;
    public static final int BANKCODE_HIDDEN_POS_FIELD_NUMBER = 5;
    public static final int BANKCODE_POS_FIELD_NUMBER = 4;
    public static final int CLEAN_BANKCODE_FIELD_NUMBER = 2;
    public static final int RAW_BANKCODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "raw_bankcode", "clean_bankcode", "bankcode_attr", "bankcode_pos", "bankcode_hidden_pos" }, new Object[] { "", "", Integer.valueOf(0), null, null }, BankcodeElem.class);
    public final PBEnumField bankcode_attr = PBField.initEnum(0);
    public bankcode_info.ElemPos bankcode_hidden_pos = new bankcode_info.ElemPos();
    public bankcode_info.ElemPos bankcode_pos = new bankcode_info.ElemPos();
    public final PBStringField clean_bankcode = PBField.initString("");
    public final PBStringField raw_bankcode = PBField.initString("");
  }
  
  public static final class ElemPos
    extends MessageMicro<ElemPos>
  {
    public static final int END_OFFSET_FIELD_NUMBER = 2;
    public static final int START_OFFSET_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_offset", "end_offset" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ElemPos.class);
    public final PBUInt32Field end_offset = PBField.initUInt32(0);
    public final PBUInt32Field start_offset = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.bankcode_info
 * JD-Core Version:    0.7.0.1
 */