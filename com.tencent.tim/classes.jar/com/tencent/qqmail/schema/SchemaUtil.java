package com.tencent.qqmail.schema;

import android.content.Context;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

public class SchemaUtil
{
  public static final int ANIMATION_TYPE_DEFAULT = 0;
  public static final int ANIMATION_TYPE_SCALE = 1;
  public static final int ANIMATION_TYPE_SLIDE = 2;
  public static final int FROM_JS_API = 1;
  public static final int FROM_OTHER_APP = 0;
  public static final int FROM_POPULARIZE = 2;
  public static final int FROM_PUSH = 3;
  public static final int FROM_READMAIL = 4;
  public static final int FROM_UPDATE_CONFIG = 5;
  private static final String FUNC_ACCOUNT = "account";
  private static final String FUNC_BOTTLE = "bottle";
  private static final String FUNC_CALENDAR = "calendar";
  private static final String FUNC_CALENDAR_SHARE = "calendar_share";
  private static final String FUNC_COMPOSEMAIL = "composemail";
  private static final String FUNC_FOLDERLIST = "folderlist";
  private static final String FUNC_FTN = "ftn";
  private static final String FUNC_GREETINGCARD = "greetingcard";
  private static final String FUNC_HOME = "home";
  private static final String FUNC_MAIL = "mail";
  private static final String FUNC_MAILLIST = "maillist";
  private static final String FUNC_MAIL_HWPUSH = "mail_hwpush";
  private static final String FUNC_NOTE = "note";
  private static final String FUNC_OTHERAPP = "otherapp";
  private static final String FUNC_READ = "read";
  private static final String FUNC_SECAPPGUIDE = "secappguide";
  private static final String FUNC_SETTING = "setting";
  private static final String FUNC_TOOLS = "tools";
  public static final String TAG = "SchemaUtil";
  
  private static void checkUpgrade()
  {
    Threads.runInBackground(new SchemaUtil.1());
  }
  
  public static boolean handleSchemaAction(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    bool5 = false;
    bool4 = false;
    boolean bool3 = false;
    bool2 = bool4;
    for (;;)
    {
      try
      {
        QMLog.log(4, "SchemaUtil", "handleSchemaAction url :" + paramString);
        bool1 = bool5;
        if (paramString != null)
        {
          bool1 = bool5;
          bool2 = bool4;
          if (paramString.startsWith("qqmail://"))
          {
            bool2 = bool4;
            arrayOfString = paramString.replace("qqmail://", "").split("\\?");
            bool1 = bool5;
            bool2 = bool4;
            if (arrayOfString.length > 0)
            {
              str2 = arrayOfString[0];
              if (str2 == null) {
                continue;
              }
              bool2 = bool4;
              if (!str2.equals("home")) {
                continue;
              }
              bool2 = bool4;
              if (arrayOfString.length != 1) {
                continue;
              }
              bool2 = bool4;
              bool1 = new SchemaHome(paramContext, paramString).doAction(paramInt1);
              str1 = str2;
              bool2 = bool1;
              logSchema(str1, paramString, paramInt2, bool1);
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        String[] arrayOfString;
        String str2;
        String str1;
        paramContext.printStackTrace();
        QMLog.log(6, "SchemaUtil", paramContext.getMessage());
        boolean bool1 = bool2;
        continue;
        bool2 = bool4;
        new SchemaHome(paramContext, paramString).doAction(paramInt1);
        bool2 = bool4;
        QMLog.log(6, "SchemaUtil", "unknow but home, func :" + str2);
        bool2 = bool4;
        logSchema("home", paramString, paramInt2, false);
        bool1 = bool5;
        continue;
      }
      if ((!bool1) && (paramInt2 != 5))
      {
        QMLog.log(4, "SchemaUtil", "can not handle schema, check upgrade");
        checkUpgrade();
      }
      return bool1;
      bool2 = bool4;
      if (str2.equals("note"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaNote(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("ftn"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaFtn(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("calendar"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaCalendar(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("calendar_share"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaCalendarShare(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("bottle"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaBottle(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("folderlist"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaFolderList(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("maillist"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaMailList(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("mail"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaMail(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("composemail"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaCompose(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("otherapp"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaApp(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("account"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaAccount(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("read"))
      {
        bool2 = bool4;
        if (arrayOfString.length == 2)
        {
          bool2 = bool4;
          paramContext = new SchemaRead(paramContext, paramString);
          bool2 = bool4;
          paramContext.parseParams();
          bool2 = bool4;
          bool1 = paramContext.doAction(paramInt1);
          str1 = str2;
          continue;
        }
      }
      bool2 = bool4;
      if (str2.equals("tools"))
      {
        bool1 = bool3;
        str1 = str2;
        bool2 = bool4;
        if (arrayOfString.length == 2) {}
      }
      else
      {
        bool2 = bool4;
        if (str2.equals("setting"))
        {
          bool2 = bool4;
          if (arrayOfString.length == 2)
          {
            bool2 = bool4;
            paramContext = new SchemaSetting(paramContext, paramString);
            bool2 = bool4;
            paramContext.parseParams();
            bool2 = bool4;
            bool1 = paramContext.doAction(paramInt1);
            str1 = str2;
            continue;
          }
        }
        bool2 = bool4;
        if (str2.equals("greetingcard"))
        {
          bool2 = bool4;
          if (arrayOfString.length == 2)
          {
            bool2 = bool4;
            paramContext = new SchemaCard(paramContext, paramString);
            bool2 = bool4;
            paramContext.parseParams();
            bool2 = bool4;
            bool1 = paramContext.doAction(paramInt1);
            str1 = str2;
            continue;
          }
        }
        bool2 = bool4;
        if (str2.equals("secappguide"))
        {
          bool2 = bool4;
          if (arrayOfString.length == 2)
          {
            bool2 = bool4;
            paramContext = new SchemaSecAppGuide(paramContext, paramString);
            bool2 = bool4;
            paramContext.parseParams();
            bool2 = bool4;
            bool1 = paramContext.doAction(paramInt1);
            str1 = str2;
            continue;
          }
        }
        bool2 = bool4;
        if (str2.equals("mail_hwpush"))
        {
          bool2 = bool4;
          if (arrayOfString.length == 2)
          {
            bool2 = bool4;
            paramContext = new SchemaMailHwpush(paramContext, paramString);
            bool2 = bool4;
            paramContext.parseParams();
            bool2 = bool4;
            bool1 = paramContext.doAction(paramInt1);
            str1 = str2;
            continue;
          }
        }
        str1 = "home";
        bool2 = bool4;
        new SchemaHome(paramContext, paramString).doAction(paramInt1);
        bool2 = bool4;
        QMLog.log(6, "SchemaUtil", "unknow but home, func :" + "home");
        bool1 = bool3;
      }
    }
  }
  
  public static void logSchema(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    QMLog.log(4, "SchemaUtil", "logSchema:" + paramString1 + "," + paramInt + "," + paramBoolean + "," + paramString2);
    if (paramInt == 0)
    {
      if (!paramString1.equals("home")) {
        break label89;
      }
      if (!paramBoolean) {
        break label79;
      }
      DataCollector.logDetailEvent("DetailEvent_Scheme_Home", 0L, 0L, paramString2);
    }
    label79:
    label89:
    do
    {
      return;
      DataCollector.logDetailEvent("DetailEvent_Scheme_Home", 0L, 1L, paramString2);
      return;
      if (paramString1.equals("note"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Note", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Note", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("ftn"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Ftn", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Ftn", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("calendar"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Calendar", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Calendar", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("bottle"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Plp", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Plp", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("folderlist"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Folderlist", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Folderlist", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("maillist"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Maillist", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Maillist", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("mail"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_Scheme_Readmail", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_Scheme_Readmail", 0L, 1L, paramString2);
        return;
      }
      if (paramString1.equals("composemail"))
      {
        if (paramBoolean)
        {
          DataCollector.logDetailEvent("DetailEvent_SFcheme_Compose", 0L, 0L, paramString2);
          return;
        }
        DataCollector.logDetailEvent("DetailEvent_SFcheme_Compose", 0L, 1L, paramString2);
        return;
      }
    } while (!paramString1.equals("account"));
    if (paramBoolean)
    {
      DataCollector.logDetailEvent("DetailEvent_Scheme_Login", 0L, 0L, paramString2);
      return;
    }
    DataCollector.logDetailEvent("DetailEvent_Scheme_Login", 0L, 1L, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaUtil
 * JD-Core Version:    0.7.0.1
 */