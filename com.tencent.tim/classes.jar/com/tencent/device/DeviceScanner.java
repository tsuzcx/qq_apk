package com.tencent.device;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import aqha;
import aqju;
import awjb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import rwe;
import tar;

public class DeviceScanner
{
  public static final String ADD_TAG_SMS = "SMS";
  public static final String HPCLOUD_QCODE = "http://qqapp.eprintsw.com";
  public static final String PARAM_PID = "pid";
  public static final int PARAM_PID_MIN_VALUE = 1000000000;
  public static final String PARAM_SCAN_FROM = "ScanSmartDevice";
  public static final String PARAM_SN = "sn";
  public static final int PARAM_SN_LEN = 16;
  public static final String PARAM_TAG = "addtag";
  public static final String PARAM_TOKEN = "token";
  public static final String QCODE = "http://iot.qq.com/add";
  public static final String QCODE_EX = "https://iot.qq.com/add";
  static final String TAG = "smartdevice::DeviceScanner";
  
  static void goToErrorPage(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://qzs.qq.com/open/mobile/iot_qrcode_error/index.html");
    awjb.a().a(paramActivity, paramQQAppInterface, paramQQAppInterface.getAccount(), localIntent, "com.tencent.device.activities.DeviceSquareActivity", 0, null, SmartDevicePluginProxyActivity.class);
  }
  
  public static boolean openDeviceQCodeUrl(Activity paramActivity, rwe paramrwe, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::DeviceScanner", 2, "device qrcode url:" + paramString);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    DeviceQRCodeParser localDeviceQRCodeParser = new DeviceQRCodeParser();
    try
    {
      localDeviceQRCodeParser.parseQRCodeUrl(paramString);
      int i;
      do
      {
        try
        {
          i = Integer.parseInt(localDeviceQRCodeParser.strDevPid);
          if ((TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) || (TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) || ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) && (localDeviceQRCodeParser.strDevToken.length() != 32)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("smartdevice::DeviceScanner", 2, "device qrcode error pid:" + localDeviceQRCodeParser.strDevPid + " sn:" + localDeviceQRCodeParser.strDevSN + ",token:" + localDeviceQRCodeParser.strDevToken);
            }
            tar.a().bAQ = i;
            tar.a().a(localQQAppInterface, "Usr_Analyze_URL", 3);
            tar.a(localQQAppInterface, "Usr_QRCode_Result", 0, 0, i);
            if (paramActivity != null)
            {
              if (paramString.startsWith("http://iot.qq.com")) {
                showNoticeDlg(paramActivity, paramrwe, 2131692572, 2131692571);
              }
            }
            else {
              return false;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            i = 0;
          }
          if ((!TextUtils.isEmpty(localDeviceQRCodeParser.strDevToken)) && (localDeviceQRCodeParser.strDevToken.length() != 32))
          {
            showNoticeDlg(paramActivity, paramrwe, 2131692572, 2131692573);
            return false;
          }
          if (!awjb.a().cF(localQQAppInterface))
          {
            showNoticeDlg(paramActivity, paramrwe, 2131692572, 2131692571);
            return false;
          }
          goToErrorPage(paramActivity, localQQAppInterface);
          return false;
        }
        if (((TextUtils.isEmpty(localDeviceQRCodeParser.strDevPid)) || ((localDeviceQRCodeParser.strDevPid.length() == 10) && (TextUtils.isDigitsOnly(localDeviceQRCodeParser.strDevPid)))) && ((TextUtils.isEmpty(localDeviceQRCodeParser.strDevSN)) || (localDeviceQRCodeParser.strDevSN.length() == 16))) {
          break;
        }
      } while (paramActivity == null);
      showNoticeDlg(paramActivity, paramrwe, 2131692572, 2131692571);
      return false;
      tar.a().bAQ = i;
      tar.a().aIF = localDeviceQRCodeParser.strDevSN;
      if ("SMS".equals(localDeviceQRCodeParser.strTag)) {
        tar.a().a(localQQAppInterface, "Usr_Analyze_URL", 4);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("smartdevice::DeviceScanner", 2, "device qrcode pid:" + localDeviceQRCodeParser.strDevPid + " sn:" + localDeviceQRCodeParser.strDevSN);
        }
        if (awjb.a().cF(localQQAppInterface)) {
          break;
        }
        if (paramActivity != null)
        {
          paramrwe = new Intent(paramActivity, DevicePluginDownloadActivity.class);
          paramrwe.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
          paramrwe.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
          paramrwe.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
          paramActivity.startActivity(paramrwe);
        }
        return true;
        if ((localDeviceQRCodeParser.strDevToken != null) && (localDeviceQRCodeParser.strDevToken.length() > 0)) {
          tar.a().a(localQQAppInterface, "Usr_Analyze_URL", 2);
        } else {
          tar.a().a(localQQAppInterface, "Usr_Analyze_URL", 1);
        }
      }
      paramrwe = new Intent();
      paramrwe.putExtra("DevicePID", localDeviceQRCodeParser.strDevPid);
      paramrwe.putExtra("DeviceSN", localDeviceQRCodeParser.strDevSN);
      paramrwe.putExtra("DeviceToken", localDeviceQRCodeParser.strDevToken);
      paramrwe.putExtra("DataReportSeq", tar.a().DU);
    }
    catch (Exception localException2)
    {
      try
      {
        paramrwe.putExtra("nickname", localQQAppInterface.getCurrentNickname());
        paramrwe.putExtra("bitmap", localQQAppInterface.a(localQQAppInterface.getCurrentAccountUin(), (byte)2, false));
        label666:
        awjb.a().a(paramActivity, localQQAppInterface, localQQAppInterface.getAccount(), paramrwe, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
        return true;
        localException2 = localException2;
      }
      catch (Exception paramString)
      {
        break label666;
      }
    }
  }
  
  private static void showNoticeDlg(Activity paramActivity, rwe paramrwe, int paramInt1, int paramInt2)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity = aqha.a(paramActivity, 230);
    paramActivity.setNegativeButton(2131721079, new DeviceScanner.1(paramrwe));
    paramActivity.setTitle(paramInt1);
    paramActivity.setMessage(paramInt2);
    paramActivity.show();
  }
  
  static class DeviceQRCodeParser
  {
    public String strDevPid = "";
    public String strDevSN = "";
    public String strDevToken = "";
    public String strTag = "";
    
    public boolean parseQRCodeUrl(String paramString)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      if (paramString == null) {}
      Object localObject2;
      label148:
      do
      {
        do
        {
          do
          {
            return false;
          } while ((!paramString.startsWith("http://iot.qq.com/add")) && (!paramString.startsWith("https://iot.qq.com/add")));
          paramString = paramString.substring(paramString.indexOf("?") + 1);
        } while (TextUtils.isEmpty(paramString));
        String[] arrayOfString1 = paramString.split("&");
        if (arrayOfString1 != null)
        {
          int i = 0;
          paramString = null;
          localObject3 = localObject1;
          localObject2 = paramString;
          if (i < arrayOfString1.length)
          {
            String[] arrayOfString2 = arrayOfString1[i].split("=");
            localObject2 = localObject1;
            localObject3 = paramString;
            if (arrayOfString2 != null)
            {
              localObject2 = localObject1;
              localObject3 = paramString;
              if (arrayOfString2.length == 2)
              {
                if (!arrayOfString2[0].equals("pid")) {
                  break label148;
                }
                localObject3 = arrayOfString2[1];
                localObject2 = localObject1;
              }
            }
            for (;;)
            {
              i += 1;
              localObject1 = localObject2;
              paramString = (String)localObject3;
              break;
              if (arrayOfString2[0].equals("sn"))
              {
                localObject2 = arrayOfString2[1];
                localObject3 = paramString;
              }
              else if (arrayOfString2[0].equals("token"))
              {
                this.strDevToken = arrayOfString2[1];
                localObject2 = localObject1;
                localObject3 = paramString;
              }
              else
              {
                localObject2 = localObject1;
                localObject3 = paramString;
                if (arrayOfString2[0].equals("addtag"))
                {
                  this.strTag = arrayOfString2[1];
                  localObject2 = localObject1;
                  localObject3 = paramString;
                }
              }
            }
          }
        }
        else
        {
          localObject2 = null;
        }
      } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)));
      if ((((String)localObject3).length() != 16) && (QLog.isColorLevel())) {
        QLog.e("smartdevice::DeviceScanner", 2, "device qrcode sn: " + (String)localObject3 + " is invalid, length:" + ((String)localObject3).length());
      }
      this.strDevSN = ((String)localObject3);
      this.strDevPid = ((String)localObject2);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.DeviceScanner
 * JD-Core Version:    0.7.0.1
 */