package com.tencent.qqmail.network.filter;

import java.util.Date;
import java.util.HashMap;

public class RequestFilter
{
  public static final String activeSyncNeedSyncFolder = "active_sync_need_sync_folder";
  public static final String attach_folder_list_ = "attach_folder_list_";
  public static final String folder_mgr_add_folder_ = "folder_mgr_add_folder_";
  public static final String folder_mgr_add_tag_ = "folder_mgr_add_tag_";
  public static final String folder_mgr_remove_folder_ = "folder_mgr_remove_folder_";
  public static final String folder_mgr_remove_tag_ = "folder_mgr_remove_tag_";
  public static final String folder_mgr_rename_folder_ = "folder_mgr_rename_folder_";
  public static final String folder_mgr_rename_tag_ = "folder_mgr_rename_tag_";
  public static final String help_static_receive_init = "help_static_receive_init";
  public static final String help_static_receive_load_more = "help_static_receive_load_more";
  public static final String help_static_receive_retrieve = "help_static_receive_retrieve";
  public static final String load_calendar_event = "load_calendar_event";
  public static final String load_calendar_folder = "load_calendar_folder";
  public static final String load_contact_ = "load_contact";
  public static final String load_list_ = "load_list_";
  public static final String load_list_all_ = "load_list_all_";
  public static final String load_mail_ = "load_mail_";
  public static final String load_name_list_ = "load_name_list";
  public static final String load_vip_ = "load_vip_";
  public static final String modify_send_utc_ = "modify_send_utc_";
  public static final String pop_list_ = "pop_list_";
  public static final String recall_mail = "recall_mail_";
  public static final String recall_mail_query = "recall_mail_query_";
  private static HashMap<String, Long> requestHashMap = new HashMap();
  public static final String sync_ = "sync_";
  public static final String translate_mail_ = "translate_mail_";
  public static final String uma_sync_account_state = "uma_sync_account_state";
  public static final String uma_sync_adbw_list = "uma_sync_adbw_list";
  public static final String uma_update_config = "uma_update_config";
  public static final String update_list_ = "update_list_";
  public static final String update_list_all_ = "update_list_all_";
  
  /* Error */
  public static boolean isRequestOnRunning(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 82	com/tencent/qqmail/network/filter/RequestFilter:requestHashMap	Ljava/util/HashMap;
    //   8: ifnonnull +18 -> 26
    //   11: new 77	java/util/HashMap
    //   14: dup
    //   15: invokespecial 80	java/util/HashMap:<init>	()V
    //   18: putstatic 82	com/tencent/qqmail/network/filter/RequestFilter:requestHashMap	Ljava/util/HashMap;
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: getstatic 82	com/tencent/qqmail/network/filter/RequestFilter:requestHashMap	Ljava/util/HashMap;
    //   29: aload_0
    //   30: invokevirtual 90	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq -12 -> 21
    //   36: getstatic 82	com/tencent/qqmail/network/filter/RequestFilter:requestHashMap	Ljava/util/HashMap;
    //   39: aload_0
    //   40: invokevirtual 94	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 96	java/lang/Long
    //   46: invokevirtual 100	java/lang/Long:longValue	()J
    //   49: lstore_2
    //   50: new 102	java/util/Date
    //   53: dup
    //   54: invokespecial 103	java/util/Date:<init>	()V
    //   57: invokevirtual 106	java/util/Date:getTime	()J
    //   60: lstore 4
    //   62: lload 4
    //   64: lload_2
    //   65: lsub
    //   66: ldc2_w 107
    //   69: lcmp
    //   70: ifge +8 -> 78
    //   73: iconst_1
    //   74: istore_1
    //   75: goto -54 -> 21
    //   78: iconst_0
    //   79: istore_1
    //   80: goto -5 -> 75
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramString	String
    //   1	79	1	bool	boolean
    //   49	16	2	l1	long
    //   60	3	4	l2	long
    // Exception table:
    //   from	to	target	type
    //   5	21	83	finally
    //   26	62	83	finally
  }
  
  public static void resetRequestRunningState(String paramString)
  {
    try
    {
      if (requestHashMap != null) {
        requestHashMap.remove(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void setRequestRunningState(String paramString)
  {
    try
    {
      if (requestHashMap == null) {
        requestHashMap = new HashMap();
      }
      requestHashMap.put(paramString, Long.valueOf(new Date().getTime()));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.network.filter.RequestFilter
 * JD-Core Version:    0.7.0.1
 */