package com.tencent.mobileqq.activity.voip;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.PrintStream;

public class VoipSSOHandler
  extends BusinessHandler
{
  public static final String a = "QQiSvc.fs_account";
  public static final String b = "QQiSvc.gti_balance_info";
  public static final String c = "QQiSvc.sendUinInfo";
  public static final String d = "QQiSvc.tencentpay_buy_goods";
  private Handler a;
  
  public VoipSSOHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new VoipGetUid.ResponseBody();
    try
    {
      paramToServiceMsg = (VoipGetUid.ResponseBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      return paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        paramToServiceMsg = null;
      }
    }
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new VoipQueryBalance.query_balance_resp();
    try
    {
      paramToServiceMsg = (VoipQueryBalance.query_balance_resp)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      System.out.println(paramToServiceMsg.cmd.get());
      return paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        paramToServiceMsg = null;
      }
    }
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    return null;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new VoipBuyGoods.BuyGoodsRsp();
    try
    {
      paramToServiceMsg = (VoipBuyGoods.BuyGoodsRsp)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      return paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
        paramToServiceMsg = null;
      }
    }
  }
  
  protected Class a()
  {
    return VoipSSOObserver.class;
  }
  
  public void a()
  {
    VoipReportIP.SendUinInfoReq localSendUinInfoReq = new VoipReportIP.SendUinInfoReq();
    localSendUinInfoReq.mIp.set("0.0.0.0");
    localSendUinInfoReq.mUin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    localSendUinInfoReq.mIsBindContact.set(0);
    localSendUinInfoReq.mLang.set("zh_CN");
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "QQiSvc.sendUinInfo");
    localToServiceMsg.putWupBuffer(localSendUinInfoReq.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle)
  {
    VoipBuyGoods.BuyGoodsReq localBuyGoodsReq = new VoipBuyGoods.BuyGoodsReq();
    localBuyGoodsReq.goodsmeta.set(paramBundle.getString("goodsmeta"));
    localBuyGoodsReq.goodsurl.set(paramBundle.getString("goodsurl"));
    localBuyGoodsReq.openid.set(paramBundle.getString("openid"));
    localBuyGoodsReq.openkey.set(paramBundle.getString("openkey"));
    localBuyGoodsReq.pay_token.set(paramBundle.getString("pay_token"));
    localBuyGoodsReq.payitem.set(paramBundle.getString("payitem"));
    localBuyGoodsReq.pf.set(paramBundle.getString("pf"));
    localBuyGoodsReq.pfkey.set(paramBundle.getString("pfkey"));
    localBuyGoodsReq.session_id.set(paramBundle.getString("session_id"));
    localBuyGoodsReq.session_type.set(paramBundle.getString("session_type"));
    localBuyGoodsReq.ts.set(paramBundle.getString("ts"));
    localBuyGoodsReq.zoneid.set(paramBundle.getString("zoneid"));
    try
    {
      paramBundle = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "QQiSvc.tencentpay_buy_goods");
      paramBundle.putWupBuffer(localBuyGoodsReq.toByteArray());
      paramBundle.extraData.putBoolean("req_pb_protocol_flag", true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_BUYGOODS_ERROR.ordinal());
    }
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = paramFromServiceMsg.getServiceCmd();
    if (TextUtils.isEmpty(paramObject)) {}
    do
    {
      return;
      if (paramObject.compareTo("QQiSvc.fs_account") == 0)
      {
        paramToServiceMsg = (VoipGetUid.ResponseBody)a(paramToServiceMsg, paramFromServiceMsg);
        if (paramToServiceMsg == null)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_GETUID_FAIL.ordinal());
          return;
        }
        if ((paramToServiceMsg.user.get().length() == 0) || (paramToServiceMsg.password.get().length() == 0))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_GETUID_FAIL.ordinal());
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(VoipErrorCodeEnum.VOIP_GETUID_SUCCESS.ordinal(), paramToServiceMsg));
        return;
      }
      if (paramObject.compareTo("QQiSvc.gti_balance_info") == 0)
      {
        paramToServiceMsg = (VoipQueryBalance.query_balance_resp)b(paramToServiceMsg, paramFromServiceMsg);
        if (paramToServiceMsg == null)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_CHECK_BALANCE_FAIL.ordinal());
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(VoipErrorCodeEnum.VOIP_CHECK_BALANCE_SUCCESS.ordinal(), paramToServiceMsg));
        return;
      }
      if (paramObject.compareTo("QQiSvc.sendUinInfo") == 0)
      {
        c(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (paramObject.compareTo("QQiSvc.tencentpay_buy_goods") != 0);
    paramToServiceMsg = (VoipBuyGoods.BuyGoodsRsp)d(paramToServiceMsg, paramFromServiceMsg);
    if (paramToServiceMsg == null)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(VoipErrorCodeEnum.VOIP_BUYGOODS_ERROR.ordinal());
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(VoipErrorCodeEnum.VOIP_BUYGOODS_SUCCESS.ordinal(), paramToServiceMsg));
  }
  
  public void a(String paramString)
  {
    Object localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
    localObject = new VoipGetUid.RequestBody();
    ((VoipGetUid.RequestBody)localObject).uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((VoipGetUid.RequestBody)localObject).platform.set(10);
    ((VoipGetUid.RequestBody)localObject).mobile.set(str);
    ((VoipGetUid.RequestBody)localObject).language.set("zh_CN");
    ((VoipGetUid.RequestBody)localObject).country.set("zh_CN");
    ((VoipGetUid.RequestBody)localObject).called_mobile.set(paramString);
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "QQiSvc.fs_account");
    paramString.putWupBuffer(((VoipGetUid.RequestBody)localObject).toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString);
  }
  
  public void b()
  {
    Object localObject = new VoipQueryBalance.query_balance_req_body();
    ((VoipQueryBalance.query_balance_req_body)localObject).caller_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    ((VoipQueryBalance.query_balance_req_body)localObject).caller_phone_type.set(10);
    VoipQueryBalance.query_balance_req localquery_balance_req = new VoipQueryBalance.query_balance_req();
    localquery_balance_req.cmd.set("query_balance");
    localquery_balance_req.echo.set(2);
    localquery_balance_req.body.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "QQiSvc.gti_balance_info");
    ((ToServiceMsg)localObject).putWupBuffer(localquery_balance_req.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipSSOHandler
 * JD-Core Version:    0.7.0.1
 */