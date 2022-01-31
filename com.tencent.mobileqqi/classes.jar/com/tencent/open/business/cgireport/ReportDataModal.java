package com.tencent.open.business.cgireport;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.Iterator;

public class ReportDataModal
{
  protected static final String a;
  protected SQLiteDatabase a;
  protected ReportDataModal.DataBaseHelper a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReportDataModal.class.getName();
  }
  
  public ReportDataModal()
  {
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper = new ReportDataModal.DataBaseHelper(this, CommonDataAdapter.a().a(), "agent_cgi_report.db", null, 4);
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + a("newdata_report", paramString);
      LogUtility.b(jdField_a_of_type_JavaLangString, "new_table>>count=" + i);
      i += a("olddata_report", paramString);
      LogUtility.b(jdField_a_of_type_JavaLangString, "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +64 -> 73
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_2
    //   16: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore 4
    //   21: iload 4
    //   23: ifeq +57 -> 80
    //   26: aload 6
    //   28: astore_2
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 39	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   34: invokevirtual 82	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: putfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   40: aload_0
    //   41: getfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   44: aload_1
    //   45: aconst_null
    //   46: aload 5
    //   48: aload_2
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual 90	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 96 1 0
    //   62: istore_3
    //   63: aload_1
    //   64: invokeinterface 99 1 0
    //   69: aload_0
    //   70: monitorexit
    //   71: iload_3
    //   72: ireturn
    //   73: ldc 101
    //   75: astore 5
    //   77: goto -62 -> 15
    //   80: iconst_1
    //   81: anewarray 103	java/lang/String
    //   84: astore 6
    //   86: aload 6
    //   88: iconst_0
    //   89: aload_2
    //   90: aastore
    //   91: aload 6
    //   93: astore_2
    //   94: goto -65 -> 29
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: getstatic 18	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: ldc 105
    //   108: aload_1
    //   109: invokestatic 108	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: iconst_0
    //   113: istore_3
    //   114: goto -45 -> 69
    //   117: astore_1
    //   118: getstatic 18	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 111	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   125: aload_1
    //   126: invokestatic 114	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: iconst_0
    //   130: istore_3
    //   131: goto -62 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ReportDataModal
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   62	69	3	i	int
    //   19	3	4	bool	boolean
    //   13	63	5	str	String
    //   1	91	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	12	97	finally
    //   15	21	97	finally
    //   29	40	97	finally
    //   40	69	97	finally
    //   80	86	97	finally
    //   103	112	97	finally
    //   118	129	97	finally
    //   29	40	102	java/lang/Exception
    //   40	69	117	java/lang/Exception
  }
  
  public int a(ArrayList paramArrayList)
  {
    int i;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal backupOldItems count = " + paramArrayList.size());
      paramArrayList = new ArrayList(paramArrayList).iterator();
      i = 0;
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          reportItem localreportItem = (reportItem)paramArrayList.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("apn", localreportItem.jdField_a_of_type_JavaLangString);
          localContentValues.put("frequency", localreportItem.b);
          localContentValues.put("commandid", localreportItem.c);
          localContentValues.put("resultcode", localreportItem.d);
          localContentValues.put("tmcost", localreportItem.e);
          localContentValues.put("reqsize", localreportItem.f);
          localContentValues.put("rspsize", localreportItem.g);
          localContentValues.put("touin", localreportItem.h);
          localContentValues.put("deviceinfo", localreportItem.i);
          localContentValues.put("detail", localreportItem.j);
          localContentValues.put("appid", localreportItem.k);
          try
          {
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insertOrThrow("olddata_report", null, localContentValues);
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              LogUtility.c(jdField_a_of_type_JavaLangString, "update>>>", localException);
            }
          }
        }
      }
      LogUtility.b("cgi_report_debug", "ReportDataModal backupOldItems succ_count = " + i);
    }
    finally {}
    return i;
  }
  
  public ArrayList a(String paramString)
  {
    try
    {
      paramString = a("newdata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public ArrayList a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: ldc 218
    //   6: invokestatic 66	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 121	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 219	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 39	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   22: invokevirtual 82	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: putfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   28: new 47	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   35: ldc 221
    //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 223
    //   46: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 197
    //   51: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 225
    //   56: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 4
    //   64: aload_0
    //   65: getfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   68: aload 4
    //   70: iconst_1
    //   71: anewarray 103	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload_2
    //   77: aastore
    //   78: invokevirtual 229	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore 4
    //   83: aload 4
    //   85: invokeinterface 232 1 0
    //   90: pop
    //   91: aload 4
    //   93: invokeinterface 235 1 0
    //   98: ifne +319 -> 417
    //   101: aload 4
    //   103: aload 4
    //   105: ldc 148
    //   107: invokeinterface 238 2 0
    //   112: invokeinterface 242 2 0
    //   117: astore 5
    //   119: aload 4
    //   121: aload 4
    //   123: ldc 154
    //   125: invokeinterface 238 2 0
    //   130: invokeinterface 242 2 0
    //   135: astore 6
    //   137: aload 4
    //   139: aload 4
    //   141: ldc 158
    //   143: invokeinterface 238 2 0
    //   148: invokeinterface 242 2 0
    //   153: astore 7
    //   155: aload 4
    //   157: aload 4
    //   159: ldc 162
    //   161: invokeinterface 238 2 0
    //   166: invokeinterface 242 2 0
    //   171: astore 8
    //   173: aload 4
    //   175: aload 4
    //   177: ldc 167
    //   179: invokeinterface 238 2 0
    //   184: invokeinterface 242 2 0
    //   189: astore 9
    //   191: aload 4
    //   193: aload 4
    //   195: ldc 172
    //   197: invokeinterface 238 2 0
    //   202: invokeinterface 242 2 0
    //   207: astore 10
    //   209: aload 4
    //   211: aload 4
    //   213: ldc 177
    //   215: invokeinterface 238 2 0
    //   220: invokeinterface 242 2 0
    //   225: astore 11
    //   227: aload 4
    //   229: aload 4
    //   231: ldc 192
    //   233: invokeinterface 238 2 0
    //   238: invokeinterface 242 2 0
    //   243: astore 12
    //   245: aload_3
    //   246: new 143	com/tencent/open/business/cgireport/reportItem
    //   249: dup
    //   250: aload 5
    //   252: aload 6
    //   254: aload 7
    //   256: aload 8
    //   258: aload 9
    //   260: aload 10
    //   262: aload 11
    //   264: aload 4
    //   266: aload 4
    //   268: ldc 182
    //   270: invokeinterface 238 2 0
    //   275: invokeinterface 242 2 0
    //   280: aload 4
    //   282: aload 4
    //   284: ldc 187
    //   286: invokeinterface 238 2 0
    //   291: invokeinterface 242 2 0
    //   296: aload 12
    //   298: aload_2
    //   299: invokespecial 245	com/tencent/open/business/cgireport/reportItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   302: invokevirtual 249	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   305: pop
    //   306: aload 4
    //   308: invokeinterface 252 1 0
    //   313: pop
    //   314: goto -223 -> 91
    //   317: astore_2
    //   318: getstatic 18	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: new 47	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   328: ldc 254
    //   330: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_1
    //   334: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 256
    //   340: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: aload_2
    //   347: invokestatic 108	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   350: aload_0
    //   351: getfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   354: invokevirtual 208	android/database/sqlite/SQLiteDatabase:close	()V
    //   357: ldc 117
    //   359: new 47	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   366: ldc 254
    //   368: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_1
    //   372: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc_w 256
    //   378: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc_w 258
    //   384: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_3
    //   388: invokevirtual 124	java/util/ArrayList:size	()I
    //   391: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 66	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: monitorexit
    //   402: aload_3
    //   403: areturn
    //   404: astore_1
    //   405: getstatic 18	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   408: ldc 105
    //   410: aload_1
    //   411: invokestatic 108	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   414: goto -14 -> 400
    //   417: aload 4
    //   419: invokeinterface 99 1 0
    //   424: goto -74 -> 350
    //   427: astore_1
    //   428: aload_0
    //   429: monitorexit
    //   430: aload_1
    //   431: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	ReportDataModal
    //   0	432	1	paramString1	String
    //   0	432	2	paramString2	String
    //   16	387	3	localArrayList	ArrayList
    //   62	356	4	localObject	Object
    //   117	134	5	str1	String
    //   135	118	6	str2	String
    //   153	102	7	str3	String
    //   171	86	8	str4	String
    //   189	70	9	str5	String
    //   207	54	10	str6	String
    //   225	38	11	str7	String
    //   243	54	12	str8	String
    // Exception table:
    //   from	to	target	type
    //   28	91	317	java/lang/Exception
    //   91	314	317	java/lang/Exception
    //   417	424	317	java/lang/Exception
    //   17	28	404	java/lang/Exception
    //   2	17	427	finally
    //   17	28	427	finally
    //   28	91	427	finally
    //   91	314	427	finally
    //   318	350	427	finally
    //   350	400	427	finally
    //   405	414	427	finally
    //   417	424	427	finally
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteOldItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        paramString = "delete from olddata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          LogUtility.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteOldItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 13
    //   5: aload_3
    //   6: ldc_w 276
    //   9: invokevirtual 279	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +14 -> 26
    //   15: aload_3
    //   16: ldc_w 281
    //   19: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   22: iconst_0
    //   23: aaload
    //   24: astore 13
    //   26: ldc 117
    //   28: new 47	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 287
    //   38: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 289
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 291
    //   58: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 13
    //   63: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 293
    //   69: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 295
    //   80: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 5
    //   85: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 297
    //   91: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 6
    //   96: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 299
    //   102: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 7
    //   107: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 66	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: new 145	android/content/ContentValues
    //   119: dup
    //   120: invokespecial 146	android/content/ContentValues:<init>	()V
    //   123: astore_3
    //   124: aload_3
    //   125: ldc 148
    //   127: new 47	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   134: aload_1
    //   135: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 301
    //   141: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ldc 154
    //   153: new 47	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   160: aload_2
    //   161: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 301
    //   167: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_3
    //   177: ldc 158
    //   179: new 47	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   186: aload 13
    //   188: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 301
    //   194: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc 162
    //   206: new 47	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   213: aload 4
    //   215: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 301
    //   221: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_3
    //   231: ldc 167
    //   233: new 47	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   240: aload 5
    //   242: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 301
    //   248: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_3
    //   258: ldc 172
    //   260: new 47	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   267: aload 6
    //   269: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 301
    //   275: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_3
    //   285: ldc 177
    //   287: new 47	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   294: aload 7
    //   296: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 301
    //   302: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_3
    //   312: ldc 182
    //   314: new 47	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   321: aload 8
    //   323: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 301
    //   329: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_3
    //   339: ldc 197
    //   341: new 47	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   348: aload 10
    //   350: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 301
    //   356: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: new 47	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   372: astore_2
    //   373: aload_2
    //   374: ldc_w 303
    //   377: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: bipush 38
    //   386: invokevirtual 306	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_2
    //   391: ldc_w 308
    //   394: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: astore_1
    //   398: invokestatic 313	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   401: ldc_w 315
    //   404: invokevirtual 318	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +172 -> 579
    //   410: iconst_1
    //   411: istore 11
    //   413: aload_1
    //   414: iload 11
    //   416: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: bipush 38
    //   421: invokevirtual 306	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_2
    //   426: ldc_w 320
    //   429: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokestatic 29	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   435: invokevirtual 32	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   438: invokestatic 325	com/tencent/open/base/APNUtil:e	(Landroid/content/Context;)Ljava/lang/String;
    //   441: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_3
    //   446: ldc 187
    //   448: aload_2
    //   449: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: new 47	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 327
    //   465: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokestatic 29	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   471: invokevirtual 330	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   474: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: ldc_w 301
    //   480: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: astore_2
    //   487: aload_2
    //   488: astore_1
    //   489: aload 9
    //   491: ifnull +35 -> 526
    //   494: new 47	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   501: aload_2
    //   502: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 335
    //   508: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 9
    //   513: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 301
    //   519: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore_1
    //   526: aload_3
    //   527: ldc 192
    //   529: aload_1
    //   530: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: aload_0
    //   535: getfield 39	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   538: invokevirtual 203	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   541: putfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   544: aload_0
    //   545: getfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   548: ldc 42
    //   550: aconst_null
    //   551: aload_3
    //   552: invokevirtual 207	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   555: pop2
    //   556: aload_0
    //   557: getfield 84	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   560: invokevirtual 208	android/database/sqlite/SQLiteDatabase:close	()V
    //   563: ldc 117
    //   565: ldc_w 337
    //   568: invokestatic 66	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iconst_1
    //   572: istore 12
    //   574: aload_0
    //   575: monitorexit
    //   576: iload 12
    //   578: ireturn
    //   579: iconst_0
    //   580: istore 11
    //   582: goto -169 -> 413
    //   585: astore_1
    //   586: ldc 117
    //   588: ldc_w 339
    //   591: invokestatic 341	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iconst_0
    //   595: istore 12
    //   597: goto -23 -> 574
    //   600: astore_1
    //   601: aload_0
    //   602: monitorexit
    //   603: aload_1
    //   604: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	ReportDataModal
    //   0	605	1	paramString1	String
    //   0	605	2	paramString2	String
    //   0	605	3	paramString3	String
    //   0	605	4	paramString4	String
    //   0	605	5	paramString5	String
    //   0	605	6	paramString6	String
    //   0	605	7	paramString7	String
    //   0	605	8	paramString8	String
    //   0	605	9	paramString9	String
    //   0	605	10	paramString10	String
    //   411	170	11	i	int
    //   572	24	12	bool	boolean
    //   3	184	13	str	String
    // Exception table:
    //   from	to	target	type
    //   533	571	585	java/lang/Exception
    //   5	26	600	finally
    //   26	410	600	finally
    //   413	487	600	finally
    //   494	526	600	finally
    //   526	533	600	finally
    //   533	571	600	finally
    //   586	594	600	finally
  }
  
  public ArrayList b(String paramString)
  {
    try
    {
      paramString = a("olddata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteNewItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        paramString = "delete from newdata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          LogUtility.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteNewItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportDataModal
 * JD-Core Version:    0.7.0.1
 */