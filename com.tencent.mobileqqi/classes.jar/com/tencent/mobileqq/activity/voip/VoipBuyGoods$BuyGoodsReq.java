package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VoipBuyGoods$BuyGoodsReq
  extends MessageMicro
{
  public static final int GOODSMETA_FIELD_NUMBER = 1;
  public static final int GOODSURL_FIELD_NUMBER = 2;
  public static final int OPENID_FIELD_NUMBER = 3;
  public static final int OPENKEY_FIELD_NUMBER = 4;
  public static final int PAYITEM_FIELD_NUMBER = 6;
  public static final int PAY_TOKEN_FIELD_NUMBER = 5;
  public static final int PFKEY_FIELD_NUMBER = 8;
  public static final int PF_FIELD_NUMBER = 7;
  public static final int SESSION_ID_FIELD_NUMBER = 9;
  public static final int SESSION_TYPE_FIELD_NUMBER = 10;
  public static final int TS_FIELD_NUMBER = 11;
  public static final int ZONEID_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "goodsmeta", "goodsurl", "openid", "openkey", "pay_token", "payitem", "pf", "pfkey", "session_id", "session_type", "ts", "zoneid" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "" }, BuyGoodsReq.class);
  public final PBStringField goodsmeta = PBField.initString("");
  public final PBStringField goodsurl = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public final PBStringField pay_token = PBField.initString("");
  public final PBStringField payitem = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public final PBStringField session_id = PBField.initString("");
  public final PBStringField session_type = PBField.initString("");
  public final PBStringField ts = PBField.initString("");
  public final PBStringField zoneid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipBuyGoods.BuyGoodsReq
 * JD-Core Version:    0.7.0.1
 */