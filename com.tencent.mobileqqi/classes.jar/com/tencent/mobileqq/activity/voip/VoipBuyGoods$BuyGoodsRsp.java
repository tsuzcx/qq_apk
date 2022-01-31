package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class VoipBuyGoods$BuyGoodsRsp
  extends MessageMicro
{
  public static final int ERROR_CODE_FIELD_NUMBER = 1;
  public static final int ERROR_DESP_FIELD_NUMBER = 2;
  public static final int URL_PARAMS_FIELD_NUMBER = 3;
  public static final int URL_TOKEN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "error_code", "error_desp", "url_params", "url_token" }, new Object[] { Integer.valueOf(0), "", "", "" }, BuyGoodsRsp.class);
  public final PBUInt32Field error_code = PBField.initUInt32(0);
  public final PBStringField error_desp = PBField.initString("");
  public final PBStringField url_params = PBField.initString("");
  public final PBStringField url_token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipBuyGoods.BuyGoodsRsp
 * JD-Core Version:    0.7.0.1
 */