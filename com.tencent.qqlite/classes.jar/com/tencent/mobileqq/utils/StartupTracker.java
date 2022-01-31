package com.tencent.mobileqq.utils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static final String A = "AIO_Super_doOnCreate";
  public static final String B = "AIO_Super_doOnNewIntent";
  public static final String C = "AIO_Super_doOnStart";
  public static final String D = "AIO_Super_doOnResume";
  public static final String E = "AIO_Super_doOnPause";
  public static final String F = "AIO_Super_doOnStop";
  public static final String G = "AIO_Super_doOnDestroy";
  public static final String H = "AIO_doOnCreate";
  public static final String I = "AIO_doOnNewIntent";
  public static final String J = "AIO_doOnStart";
  public static final String K = "AIO_doOnResume";
  public static final String L = "AIO_doOnPause";
  public static final String M = "AIO_doOnStop";
  public static final String N = "AIO_doOnDestroy";
  public static final String O = "AIO_doOnCreate_initUI";
  public static final String P = "AIO_doOnCreate_initData";
  public static final String Q = "AIO_doOnCreate_handleRequest";
  public static final String R = "AIO_doOnCreate_uiCost";
  public static final String S = "AIO_doOnCreate_getPieCost";
  public static final String T = "AIO_doOnCreate_otherCost";
  public static final String U = "AIO_doOnResume_updateUI";
  public static final String V = "AIO_doOnNewIntent_updateUI";
  public static final String W = "AIO_doOnNewIntent_updateData";
  public static final String X = "AIO_onDrawView";
  public static final String Y = "AIO_onShow";
  public static final String Z = "AIO_onShow_updateUI";
  public static final String a = "AutoMonitor";
  private static ConcurrentHashMap a = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aA = "Web_qqbrowser_doonresume";
  public static final String aB = "Web_uiplugin_onActivityCreate";
  public static final String aC = "Web_uiplugin_step_";
  public static final String aD = "Recent_clk_enterchat";
  public static final String aE = "Recent_clk_enterchat_troop";
  public static final String aF = "Recent_clk_enterchat_cmr";
  public static final String aG = "Recent_clk_enterchat_pub";
  private static final String aH = "STATE_";
  public static final String aa = "AIO_onShow_videoStatus";
  public static final String ab = "AIO_onShow_setReaded";
  public static final String ac = "AIO_onShow_otherThings";
  public static final String ad = "AIO_onShow_report";
  public static final String ae = "AIO_onShow_emotion";
  public static final String af = "AIO_onShow_business";
  public static final String ag = "AIO_updateSession";
  public static final String ah = "AIO_updateSession_initIntentData";
  public static final String ai = "AIO_updateSession_updateUI";
  public static final String aj = "AIO_updateSession_business";
  public static final String ak = "AIO_updateSession_forwardType";
  public static final String al = "AIO_updateSession_otherThings";
  public static final String am = "AIO_ChatAdapter_getView";
  public static final String an = "AIO_ChatAdapter_itemBuilder";
  public static final String ao = "AIO_onWindowFocusChanged";
  public static final String ap = "AIO_SysMsgCost";
  public static final String aq = "AIO_EmoticonPanel_OpenDuration";
  public static final String ar = "AIO_EmoticonPanel_OnResume";
  public static final String as = "AIO_EmoticonPanel_EnterSecond";
  public static final String at = "AIO_EmoticonPanel_EnterFirst";
  public static final String au = "AIO_EmoticonPanel_PageScroll";
  public static final String av = "AIO_EmoticonPanel_TabClick";
  public static final String aw = "AIO_emosmDetailActivity_onCreate";
  public static final String ax = "AIO_emosmDetailActivity_onResume";
  public static final String ay = "AIO_bubble_craete_bubble_info";
  public static final String az = "Web_qqbrowser_dooncreate";
  public static final String b = "Main_Start";
  public static final String c = "Main_OnCreat";
  public static final String d = "Main_OnStart";
  public static final String e = "Main_OnPostCreat";
  public static final String f = "Main_OnResume";
  public static final String g = "Recent_Start";
  public static final String h = "Recent_CreateView";
  public static final String i = "Recent_OnCreate";
  public static final String j = "Recent_OnLayout";
  public static final String k = "Recent_Draw";
  public static final String l = "QQRt_onCreate";
  public static final String m = "QQRt_superOnCreate";
  public static final String n = "QQRt_PushServlet";
  public static final String o = "QQRt_QQInitHandler";
  public static final String p = "QQRt_netHandler";
  public static final String q = "QQRt_MobileQQService";
  public static final String r = "QQRt_initTheme";
  public static final String s = "QQRt_initFaceIconCache";
  public static final String t = "QQRt_MemoryManager";
  public static final String u = "QQRt_startCoreService";
  public static final String v = "QQRt_videoMsgReceiver";
  public static final String w = "QQRt_initAvatarUploadState";
  public static final String x = "QQRt_ReportController";
  public static final String y = "AIO_Start_cost";
  public static final String z = "AIO_Click_cost";
  
  public static final void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */