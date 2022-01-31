package com.tencent.util;

public class GTUtil
{
  public static final String A = "step_init_other";
  public static final String B = "activity_onCreate_TO_onWindowFocusChanged";
  public static final String C = "qzone_launch";
  public static final int a = 0;
  public static final String a = "group_global_all_consume_time";
  private static boolean a = true;
  public static final int b = 1;
  public static final String b = "click_2_app_oncreate";
  private static boolean b = false;
  public static final int c = 2;
  public static final String c = "app_oncreate_2_activity_oncreate";
  public static final int d = 3;
  public static final String d = "activity_oncreate_2_load_data";
  public static final String e = "group_application_oncreate";
  public static final String f = "step_try_load_dex";
  public static final String g = "step_old_oncreate";
  public static final String h = "step_init_skin";
  public static final String i = "step_new_runtime";
  public static final String j = "step_start_service";
  public static final String k = "step_QzoneAppinterface_oncreate";
  public static final String l = "step_QzoneAppinterface_oncreate_first_init";
  public static final String m = "step_QzoneAppinterface_oncreate_businessservice_init";
  public static final String n = "Group_FriendFeedActivity";
  public static final String o = "Step_onCreate_set_fake_ui";
  public static final String p = "Step_onCreate";
  public static final String q = "Step_onResume";
  public static final String r = "step_onLaterCreate";
  public static final String s = "step_onCreate_load_realdata";
  public static final String t = "step_onCreate_end_2_load_realdata";
  public static final String u = "step_initUI";
  public static final String v = "step_initUI_loadxml";
  public static final String w = "step_loadHeader";
  public static final String x = "step_loadHeader_loadxml";
  public static final String y = "step_init_Header_cover";
  public static final String z = "step_init_Data";
  
  private static long a(String paramString1, String paramString2, int... paramVarArgs)
  {
    return 0L;
  }
  
  public static void a()
  {
    if (!a) {
      return;
    }
    TimeCostTrace.a("qzone_launch").a();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, int... paramVarArgs)
  {
    if (!a) {}
    do
    {
      return;
      TimeCostTrace.a("qzone_launch").a(paramString2);
    } while (!b);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramString1, "RealTime-" + paramString2, paramVarArgs);
      return;
    case 1: 
      d(paramString1, "ThreadTime-" + paramString2, paramVarArgs);
      return;
    case 2: 
      b(paramString1, "GlobalTime-" + paramString2, paramVarArgs);
      return;
    }
    a(paramString1, "RealTime-" + paramString2, paramVarArgs);
    d(paramString1, "ThreadTime-" + paramString2, paramVarArgs);
  }
  
  private static void a(String paramString1, String paramString2, int... paramVarArgs) {}
  
  private static long b(String paramString1, String paramString2, int... paramVarArgs)
  {
    return 0L;
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, int... paramVarArgs)
  {
    if (!a) {}
    do
    {
      return;
      TimeCostTrace.a("qzone_launch").b(paramString2);
    } while (!b);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramString1, "RealTime-" + paramString2, paramVarArgs);
      return;
    case 1: 
      b(paramString1, "ThreadTime-" + paramString2, paramVarArgs);
      return;
    case 2: 
      c(paramString1, "GlobalTime-" + paramString2, paramVarArgs);
      return;
    }
    a(paramString1, "RealTime-" + paramString2, paramVarArgs);
    b(paramString1, "ThreadTime-" + paramString2, paramVarArgs);
  }
  
  private static void b(String paramString1, String paramString2, int... paramVarArgs) {}
  
  private static void c(String paramString1, String paramString2, int... paramVarArgs) {}
  
  private static void d(String paramString1, String paramString2, int... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.GTUtil
 * JD-Core Version:    0.7.0.1
 */