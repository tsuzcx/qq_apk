package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import bke;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.pubaccount.util.Encrypt;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;

public class PublicAccountJavascriptInterface$LocListener
  extends SOSOMapLBSApiListener
{
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private Runnable jdField_a_of_type_JavaLangRunnable = new bke(this);
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
    String str3 = "";
    Object localObject = str3;
    if ((paramArrayOfByte == null) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.jdField_a_of_type_JavaLangBoolean.booleanValue() == true)) {}
    for (;;)
    {
      String str1;
      try
      {
        localObject = ThreeDes.a(PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, paramArrayOfByte), "nbyvie");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label412;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label260;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "0", "{type:1, data:\"" + ((String)localObject).toString() + "\"}" });
        localObject = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), (String)localObject, "", "");
        SOSOMapLBSApi.getInstance().removeLocationUpdate();
        if (paramArrayOfByte != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.mRuntime.a();
          if (localObject != null)
          {
            localObject = ((WebView)localObject).getUrl();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("_bid=108"))) {
              BnrReport.a(null, 81, "", 0, 0, Base64Util.a(paramArrayOfByte, 2), "", "", "");
            }
          }
        }
        return;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str1 = str3;
        continue;
      }
      try
      {
        str1 = Base64Util.a(Encrypt.a(Encrypt.a(paramArrayOfByte), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        String str2 = str3;
      }
      continue;
      label260:
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
      label412:
      paramInt = 0;
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
      SOSOMapLBSApi.getInstance().removeLocationUpdate();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
      break;
      paramSOSOMapLBSApiResult = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.a(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.getNetworkType(), paramSOSOMapLBSApiResult, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.LocListener
 * JD-Core Version:    0.7.0.1
 */