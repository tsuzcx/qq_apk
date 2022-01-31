package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.pubaccount.util.Encrypt;
import com.tencent.common.app.AppInterface;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;
import java.util.concurrent.atomic.AtomicInteger;
import og;

public class PublicAccountJavascriptInterface$LocListener
  extends SOSOMapLBSApiListener
{
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Runnable jdField_a_of_type_JavaLangRunnable = new og(this);
  public String a;
  boolean jdField_a_of_type_Boolean;
  
  public PublicAccountJavascriptInterface$LocListener(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    a(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void onLocationDataUpdate(byte[] paramArrayOfByte, int paramInt)
  {
    label43:
    Object localObject2;
    if (paramArrayOfByte != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.jdField_a_of_type_JavaLangBoolean.booleanValue() == true) {}
      for (;;)
      {
        try
        {
          Object localObject1 = ThreeDes.a(PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, paramArrayOfByte), "nbyvie");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label518;
          }
          paramInt = 1;
          if (paramInt == 0) {
            break label366;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:1, decrypt_padding:" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.m + ",data:\"" + ((String)localObject1).toString() + "\"}" });
          localObject1 = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), (String)localObject1, "", "");
          if (PublicAccountJavascriptInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
            SOSOMapLBSApi.getInstance().removeLocationUpdate();
          }
          if (paramArrayOfByte != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
            if (localObject1 != null)
            {
              localObject1 = ((WebView)localObject1).getUrl();
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("_bid=108"))) {
                BnrReport.a(null, 81, "", 0, 0, Base64Util.a(paramArrayOfByte, 2), "", "", "");
              }
            }
          }
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = "";
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.m == 1) {}
          for (boolean bool = true;; bool = false)
          {
            localObject2 = Base64Util.a(Encrypt.a(bool, Encrypt.a(paramArrayOfByte), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
            break;
          }
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
        }
        catch (Exception localException2)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime == null) {}
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null) {
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, ((AppInterface)localObject2).getAccount(), localException2.getMessage(), "", "");
      }
      localObject2 = "";
      break;
      label366:
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        paramArrayOfByte = new LocListener(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, 1, 1, 0, 1, true, this.jdField_a_of_type_JavaLangString);
        if (SOSOMapLBSApi.getInstance().verifyRegCode("QQ2013", "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ")) {
          SOSOMapLBSApi.getInstance().requestLocationUpdate(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), paramArrayOfByte);
        }
        paramArrayOfByte = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramArrayOfByte, "", "");
        return;
      }
      paramArrayOfByte = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramArrayOfByte, "", "");
      return;
      label518:
      paramInt = 0;
      break label43;
      localObject2 = null;
    }
  }
  
  public void onLocationUpdate(SOSOMapLBSApiResult paramSOSOMapLBSApiResult)
  {
    double d1;
    double d2;
    if (paramSOSOMapLBSApiResult.ErrorCode == 0)
    {
      d1 = paramSOSOMapLBSApiResult.Latitude;
      d2 = paramSOSOMapLBSApiResult.Longitude;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:2, lat:" + d1 + ", lon:" + d2 + "}" });
        paramSOSOMapLBSApiResult = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSOSOMapLBSApiResult, "", "");
      }
    }
    for (;;)
    {
      if (PublicAccountJavascriptInterface.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() == 0) {
        SOSOMapLBSApi.getInstance().removeLocationUpdate();
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
      break;
      paramSOSOMapLBSApiResult = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSOSOMapLBSApiResult, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.LocListener
 * JD-Core Version:    0.7.0.1
 */