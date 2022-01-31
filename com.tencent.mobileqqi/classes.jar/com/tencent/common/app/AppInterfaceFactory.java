package com.tencent.common.app;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qlink.QlinkHelper;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.weiyun.WeiyunHelper;
import mqq.app.AppRuntime;

public class AppInterfaceFactory
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    QQAppInterface localQQAppInterface = null;
    String str = paramBaseApplicationImpl.getPackageName();
    if (str.equals(paramString)) {
      localQQAppInterface = new QQAppInterface(paramBaseApplicationImpl, paramString);
    }
    while (paramString.equals(str + ":notifypush")) {
      return localQQAppInterface;
    }
    if (paramString.equals(str + ":video")) {
      return new VideoAppInterface(paramBaseApplicationImpl, "video");
    }
    if (paramString.equals(str + ":qzone")) {
      return QZoneHelper.a(paramBaseApplicationImpl, "qzone");
    }
    if (paramString.equals(str + ":web")) {
      return new BrowserAppInterface(paramBaseApplicationImpl, "web");
    }
    if (paramString.equals(str + ":openSdk")) {
      return new OpenSDKAppInterface(paramBaseApplicationImpl, "openSdk");
    }
    if (paramString.equals(str + ":photoedit"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":zebra")) {
      return new PluginRuntime();
    }
    if (paramString.equals(str + ":demoji"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":map")) {
      return new QQMapActivity.MapRuntime();
    }
    if (paramString.equals(str + ":weiyun"))
    {
      paramBaseApplicationImpl = WeiyunHelper.a(paramBaseApplicationImpl);
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qwallet"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qqfav")) {
      return QfavHelper.a(paramBaseApplicationImpl);
    }
    if (paramString.equals(str + ":qqreader"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":qlink")) {
      return QlinkHelper.a(paramBaseApplicationImpl, "qlink");
    }
    if (paramString.equals(str + ":cardpay"))
    {
      paramBaseApplicationImpl = new PluginRuntime();
      ReportController.a(paramBaseApplicationImpl);
      return paramBaseApplicationImpl;
    }
    if (paramString.equals(str + ":peak")) {
      return new PeakAppInterface(paramBaseApplicationImpl, "peak");
    }
    paramBaseApplicationImpl = new PluginRuntime();
    ReportController.a(paramBaseApplicationImpl);
    return paramBaseApplicationImpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterfaceFactory
 * JD-Core Version:    0.7.0.1
 */