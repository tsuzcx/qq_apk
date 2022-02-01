package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay
{
  public static final class StCheckGamePayReq
    extends MessageMicro<StCheckGamePayReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "openid", "appid", "prepay_id", "bill_no", "sig" }, new Object[] { null, "", "", "", "", "" }, StCheckGamePayReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField prepay_id = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
  }
  
  public static final class StCheckGamePayRsp
    extends MessageMicro<StCheckGamePayRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "pay_state", "pay_time", "app_remark" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), "" }, StCheckGamePayRsp.class);
    public final PBStringField app_remark = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field pay_state = PBField.initInt32(0);
    public final PBInt64Field pay_time = PBField.initInt64(0L);
  }
  
  public static final class StCheckPayResultReq
    extends MessageMicro<StCheckPayResultReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "id", "scene" }, new Object[] { null, "", Integer.valueOf(0) }, StCheckPayResultReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField id = PBField.initString("");
    public final PBInt32Field scene = PBField.initInt32(0);
  }
  
  public static final class StCheckPayResultRsp
    extends MessageMicro<StCheckPayResultRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "result" }, new Object[] { null, Integer.valueOf(0) }, StCheckPayResultRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class StGamePayReq
    extends MessageMicro<StGamePayReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72 }, new String[] { "extInfo", "appId", "prepayId", "starCurrency", "balanceAmount", "topupAmount", "payChannel", "sandboxEnv", "reason" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StGamePayReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBInt32Field balanceAmount = PBField.initInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field payChannel = PBField.initInt32(0);
    public final PBStringField prepayId = PBField.initString("");
    public final PBInt32Field reason = PBField.initInt32(0);
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
    public final PBInt32Field starCurrency = PBField.initInt32(0);
    public final PBInt32Field topupAmount = PBField.initInt32(0);
  }
  
  public static final class StGamePayRsp
    extends MessageMicro<StGamePayRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGamePayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGamePrePayReq
    extends MessageMicro<StGamePrePayReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 98, 106 }, new String[] { "extInfo", "openid", "appid", "ts", "zone_id", "pf", "user_ip", "amt", "bill_no", "goodid", "good_num", "app_remark", "sig" }, new Object[] { null, "", "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), "", "" }, StGamePrePayReq.class);
    public final PBInt64Field amt = PBField.initInt64(0L);
    public final PBStringField app_remark = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field good_num = PBField.initInt32(0);
    public final PBStringField goodid = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field ts = PBField.initInt64(0L);
    public final PBStringField user_ip = PBField.initString("");
    public final PBStringField zone_id = PBField.initString("");
  }
  
  public static final class StGamePrePayRsp
    extends MessageMicro<StGamePrePayRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "prepayId", "token" }, new Object[] { null, "", "" }, StGamePrePayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField token = PBField.initString("");
  }
  
  public static final class StGameQueryPayReq
    extends MessageMicro<StGameQueryPayReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "prepayId", "sig" }, new Object[] { null, "", "" }, StGameQueryPayReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
  }
  
  public static final class StGameQueryPayRsp
    extends MessageMicro<StGameQueryPayRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "status" }, new Object[] { null, Integer.valueOf(0) }, StGameQueryPayRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field status = PBField.initInt32(0);
  }
  
  public static final class StGetBalanceReq
    extends MessageMicro<StGetBalanceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 50 }, new String[] { "extInfo", "openid", "appid", "sig" }, new Object[] { null, "", "", "" }, StGetBalanceReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField sig = PBField.initString("");
  }
  
  public static final class StGetBalanceRsp
    extends MessageMicro<StGetBalanceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "remainder" }, new Object[] { null, Integer.valueOf(0) }, StGetBalanceRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field remainder = PBField.initInt32(0);
  }
  
  public static final class StGetExtDataByUniqIdReq
    extends MessageMicro<StGetExtDataByUniqIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appId", "id" }, new Object[] { null, "", "" }, StGetExtDataByUniqIdReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class StGetExtDataByUniqIdRsp
    extends MessageMicro<StGetExtDataByUniqIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "extData" }, new Object[] { null, "" }, StGetExtDataByUniqIdRsp.class);
    public final PBStringField extData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetMiniPayUniqIdReq
    extends MessageMicro<StGetMiniPayUniqIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appId", "extData" }, new Object[] { null, "", "" }, StGetMiniPayUniqIdReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField extData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetMiniPayUniqIdRsp
    extends MessageMicro<StGetMiniPayUniqIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "id" }, new Object[] { null, "" }, StGetMiniPayUniqIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class StGetWalletPayLinkReq
    extends MessageMicro<StGetWalletPayLinkReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "prepayId", "appid" }, new Object[] { null, "", "" }, StGetWalletPayLinkReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
  }
  
  public static final class StGetWalletPayLinkRsp
    extends MessageMicro<StGetWalletPayLinkRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "link" }, new Object[] { null, "" }, StGetWalletPayLinkRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
  }
  
  public static final class StMiniCheckOfferIdReq
    extends MessageMicro<StMiniCheckOfferIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appId", "offerId" }, new Object[] { null, "", "" }, StMiniCheckOfferIdReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField offerId = PBField.initString("");
  }
  
  public static final class StMiniCheckOfferIdRsp
    extends MessageMicro<StMiniCheckOfferIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "extInfo", "result", "firstRefer", "firstVia" }, new Object[] { null, Integer.valueOf(0), "", "" }, StMiniCheckOfferIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField firstRefer = PBField.initString("");
    public final PBStringField firstVia = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class StMiniGetBalanceReq
    extends MessageMicro<StMiniGetBalanceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74, 82, 88, 98 }, new String[] { "extInfo", "openid", "appid", "offer_id", "ts", "zone_id", "pf", "pfkey", "sig", "qq_sig", "sandbox_env", "openkey" }, new Object[] { null, "", "", "", Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "" }, StMiniGetBalanceReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField offer_id = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBStringField qq_sig = PBField.initString("");
    public final PBInt64Field sandbox_env = PBField.initInt64(0L);
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field ts = PBField.initInt64(0L);
    public final PBStringField zone_id = PBField.initString("");
  }
  
  public static final class StMiniGetBalanceRsp
    extends MessageMicro<StMiniGetBalanceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "remainder" }, new Object[] { null, Integer.valueOf(0) }, StMiniGetBalanceRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field remainder = PBField.initInt32(0);
  }
  
  public static final class StMiniPayReq
    extends MessageMicro<StMiniPayReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 120, 130 }, new String[] { "extInfo", "openid", "appid", "offer_id", "ts", "zone_id", "pf", "user_ip", "amt", "bill_no", "pay_item", "app_remark", "sig", "qq_sig", "sandbox_env", "openkey" }, new Object[] { null, "", "", "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "" }, StMiniPayReq.class);
    public final PBInt64Field amt = PBField.initInt64(0L);
    public final PBStringField app_remark = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField offer_id = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public final PBStringField pay_item = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField qq_sig = PBField.initString("");
    public final PBInt64Field sandbox_env = PBField.initInt64(0L);
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field ts = PBField.initInt64(0L);
    public final PBStringField user_ip = PBField.initString("");
    public final PBStringField zone_id = PBField.initString("");
  }
  
  public static final class StMiniPayRsp
    extends MessageMicro<StMiniPayRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "bill_no", "balance", "used_gen_amt", "trade_id" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "" }, StMiniPayRsp.class);
    public final PBInt32Field balance = PBField.initInt32(0);
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField trade_id = PBField.initString("");
    public final PBInt32Field used_gen_amt = PBField.initInt32(0);
  }
  
  public static final class StMiniPresentReq
    extends MessageMicro<StMiniPresentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74, 80, 90, 98, 106, 112, 122 }, new String[] { "extInfo", "openid", "qq_appid", "offer_id", "ts", "zone_id", "pf", "pfkey", "user_ip", "present_counts", "bill_no", "sig", "qq_sig", "sandbox_env", "openkey" }, new Object[] { null, "", "", "", Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "" }, StMiniPresentReq.class);
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField offer_id = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBInt64Field present_counts = PBField.initInt64(0L);
    public final PBStringField qq_appid = PBField.initString("");
    public final PBStringField qq_sig = PBField.initString("");
    public final PBInt64Field sandbox_env = PBField.initInt64(0L);
    public final PBStringField sig = PBField.initString("");
    public final PBInt64Field ts = PBField.initInt64(0L);
    public final PBStringField user_ip = PBField.initString("");
    public final PBStringField zone_id = PBField.initString("");
  }
  
  public static final class StMiniPresentRsp
    extends MessageMicro<StMiniPresentRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "bill_no", "balance" }, new Object[] { null, "", Integer.valueOf(0) }, StMiniPresentRsp.class);
    public final PBInt32Field balance = PBField.initInt32(0);
    public final PBStringField bill_no = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StNotifyIdePayResultReq
    extends MessageMicro<StNotifyIdePayResultReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "extInfo", "appId", "id", "amt", "scene", "result" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StNotifyIdePayResultReq.class);
    public final PBInt32Field amt = PBField.initInt32(0);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField id = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBInt32Field scene = PBField.initInt32(0);
  }
  
  public static final class StNotifyIdePayResultRsp
    extends MessageMicro<StNotifyIdePayResultRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StNotifyIdePayResultRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StQueryStarCurrencyReq
    extends MessageMicro<StQueryStarCurrencyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "appId", "prepayId", "starCurrency", "sandboxEnv" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0) }, StQueryStarCurrencyReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField prepayId = PBField.initString("");
    public final PBInt32Field sandboxEnv = PBField.initInt32(0);
    public final PBInt32Field starCurrency = PBField.initInt32(0);
  }
  
  public static final class StQueryStarCurrencyRsp
    extends MessageMicro<StQueryStarCurrencyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "remainder", "rechargeNum", "offerid" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, StQueryStarCurrencyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField offerid = PBField.initString("");
    public final PBInt32Field rechargeNum = PBField.initInt32(0);
    public final PBInt32Field remainder = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay
 * JD-Core Version:    0.7.0.1
 */