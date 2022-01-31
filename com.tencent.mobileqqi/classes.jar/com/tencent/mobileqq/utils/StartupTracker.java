package com.tencent.mobileqq.utils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StartupTracker
{
  public static final String A = "AIO_Super_doOnStart";
  public static final String B = "AIO_Super_doOnResume";
  public static final String C = "AIO_Super_doOnResume_step1";
  public static final String D = "AIO_Super_doOnResume_step2";
  public static final String E = "AIO_Super_doOnResume_step3";
  public static final String F = "AIO_Super_doOnResume_step4";
  public static final String G = "AIO_Super_doOnResume_step5";
  public static final String H = "AIO_Super_doOnResume_step6";
  public static final String I = "AIO_Super_doOnResume_step7";
  public static final String J = "AIO_Super_doOnResume_step8";
  public static final String K = "AIO_Super_doOnNewIntent";
  public static final String L = "AIO_doOnCreate";
  public static final String M = "AIO_doOnCreate_initUI";
  public static final String N = "AIO_doOnCreate_initData";
  public static final String O = "AIO_doOnCreate_handleRequest";
  public static final String P = "AIO_doOnStart";
  public static final String Q = "AIO_doOnResume";
  public static final String R = "AIO_doOnResume_updateUI";
  public static final String S = "AIO_doOnResume_troopType";
  public static final String T = "AIO_doOnResume_discussType";
  public static final String U = "AIO_doOnNewIntent";
  public static final String V = "AIO_doOnNewIntent_updateUI";
  public static final String W = "AIO_doOnNewIntent_updateData";
  public static final String X = "AIO_onShow";
  public static final String Y = "AIO_onShow_troopType";
  public static final String Z = "AIO_onShow_AIORoad";
  public static final String a = "AutoMonitor";
  private static ConcurrentHashMap a = new ConcurrentHashMap(new HashMap(8));
  public static final boolean a = false;
  public static final String aa = "AIO_onShow_insertSomeTips";
  public static final String ab = "AIO_onShow_updateUI";
  public static final String ac = "AIO_onShow_videoStatus";
  public static final String ad = "AIO_onShow_setReaded";
  public static final String ae = "AIO_onShow_YYVoIP";
  public static final String af = "AIO_updateSession";
  public static final String ag = "AIO_updateSession_initIntentData";
  public static final String ah = "AIO_updateSession_businessCmrTmp";
  public static final String ai = "AIO_updateSession_troopType";
  public static final String aj = "AIO_updateSession_strangerType";
  public static final String ak = "AIO_updateSession_lbsType";
  public static final String al = "AIO_updateSession_sameStateType";
  public static final String am = "AIO_updateSession_updateUI";
  public static final String an = "AIO_updateSession_forwardType";
  public static final String ao = "AIO_updateSession_otherThings";
  public static final String ap = "AIO_ChatAdapter_getView";
  public static final String aq = "AIO_ChatAdapter_itemBuilder";
  public static final String ar = "Recent_clk_enterchat";
  public static final String as = "Recent_clk_enterchat_troop";
  public static final String at = "Recent_clk_enterchat_cmr";
  public static final String au = "Recent_clk_enterchat_pub";
  private static final String av = "STATE_";
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
  public static final String z = "AIO_Super_doOnCreate";
  
  public static final void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.StartupTracker
 * JD-Core Version:    0.7.0.1
 */