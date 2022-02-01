package oicq.wlogin_sdk.report;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.util;

public class Reporter
  extends report_t
{
  private static final long serialVersionUID = 1L;
  public String _app_n = new String("");
  public String _app_sig = new String("");
  public String _app_v = new String("");
  public String _btime = util.get_release_time();
  public String _bver = "6.0.0.2202";
  public String _device = new String("");
  public String _disp_name = new String("");
  public String _ksid = new String("");
  public TreeMap<Integer, report_t2> _lst = new TreeMap();
  public int _os = 2;
  public String _os_v = new String("");
  public String _sdk_v = new Integer(5).toString();
  
  public void add_t2(report_t2 paramreport_t2)
  {
    try
    {
      if (this._lst.size() >= 10) {
        this._lst.remove(Integer.valueOf(this._lst.size() - 1));
      }
      this._lst.put(Integer.valueOf(this._lst.size()), paramreport_t2);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void add_t3(report_t3 paramreport_t3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   6: invokevirtual 85	java/util/TreeMap:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifgt +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   21: aload_0
    //   22: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   25: invokevirtual 85	java/util/TreeMap:size	()I
    //   28: iconst_1
    //   29: isub
    //   30: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   39: aload_1
    //   40: invokevirtual 106	oicq/wlogin_sdk/report/report_t2:add_t3	(Loicq/wlogin_sdk/report/report_t3;)V
    //   43: goto -29 -> 14
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	Reporter
    //   0	51	1	paramreport_t3	report_t3
    //   9	2	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	46	finally
    //   17	43	46	finally
  }
  
  public void attr_api(int paramInt)
  {
    try
    {
      add_t2(new report_t2(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clear_t2()
  {
    try
    {
      Iterator localIterator = this._lst.keySet().iterator();
      while (localIterator.hasNext()) {
        ((report_t2)this._lst.get(localIterator.next())).clear_t3();
      }
      this._lst.clear();
    }
    finally {}
  }
  
  public void commit(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    try
    {
      this._os_v = paramString1;
      this._app_v = paramString2;
      this._ksid = paramString4;
      this._app_n = paramString5;
      this._disp_name = paramString6;
      this._device = paramString7;
      this._app_sig = paramString8;
      this._btime = paramString9;
      this._bver = paramString10;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public void commit_t2(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   6: invokevirtual 85	java/util/TreeMap:size	()I
    //   9: istore 6
    //   11: iload 6
    //   13: ifgt +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   23: aload_0
    //   24: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   27: invokevirtual 85	java/util/TreeMap:size	()I
    //   30: iconst_1
    //   31: isub
    //   32: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   41: lload_1
    //   42: aload_3
    //   43: iload 4
    //   45: iload 5
    //   47: invokevirtual 143	oicq/wlogin_sdk/report/report_t2:commit	(JLjava/lang/String;II)V
    //   50: getstatic 147	oicq/wlogin_sdk/tools/util:LCB	Loicq/wlogin_sdk/tools/LogCallBack;
    //   53: ifnull -37 -> 16
    //   56: getstatic 147	oicq/wlogin_sdk/tools/util:LCB	Loicq/wlogin_sdk/tools/LogCallBack;
    //   59: aload_0
    //   60: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   63: aload_0
    //   64: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   67: invokevirtual 85	java/util/TreeMap:size	()I
    //   70: iconst_1
    //   71: isub
    //   72: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   81: invokevirtual 151	oicq/wlogin_sdk/report/report_t2:toJasonObj	()Lorg/json/JSONObject;
    //   84: invokevirtual 157	oicq/wlogin_sdk/tools/LogCallBack:OnLog	(Lorg/json/JSONObject;)V
    //   87: goto -71 -> 16
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	Reporter
    //   0	95	1	paramLong	long
    //   0	95	3	paramString	String
    //   0	95	4	paramInt1	int
    //   0	95	5	paramInt2	int
    //   9	3	6	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	90	finally
    //   19	87	90	finally
  }
  
  /* Error */
  public org.json.JSONObject toJasonObj()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aconst_null
    //   5: astore_3
    //   6: new 161	org/json/JSONObject
    //   9: dup
    //   10: invokespecial 162	org/json/JSONObject:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 164
    //   17: ldc 166
    //   19: iconst_1
    //   20: anewarray 168	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: getfield 30	oicq/wlogin_sdk/report/Reporter:_os	I
    //   29: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 172	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_2
    //   41: ldc 177
    //   43: aload_0
    //   44: getfield 39	oicq/wlogin_sdk/report/Reporter:_os_v	Ljava/lang/String;
    //   47: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   50: pop
    //   51: aload_2
    //   52: ldc 179
    //   54: aload_0
    //   55: getfield 41	oicq/wlogin_sdk/report/Reporter:_app_v	Ljava/lang/String;
    //   58: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_2
    //   63: ldc 181
    //   65: aload_0
    //   66: getfield 52	oicq/wlogin_sdk/report/Reporter:_sdk_v	Ljava/lang/String;
    //   69: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_2
    //   74: ldc 183
    //   76: aload_0
    //   77: getfield 54	oicq/wlogin_sdk/report/Reporter:_ksid	Ljava/lang/String;
    //   80: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_2
    //   85: ldc 185
    //   87: aload_0
    //   88: getfield 56	oicq/wlogin_sdk/report/Reporter:_app_n	Ljava/lang/String;
    //   91: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_2
    //   96: ldc 187
    //   98: aload_0
    //   99: getfield 58	oicq/wlogin_sdk/report/Reporter:_disp_name	Ljava/lang/String;
    //   102: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   105: pop
    //   106: aload_2
    //   107: ldc 189
    //   109: aload_0
    //   110: getfield 60	oicq/wlogin_sdk/report/Reporter:_device	Ljava/lang/String;
    //   113: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   116: pop
    //   117: aload_2
    //   118: ldc 191
    //   120: aload_0
    //   121: getfield 62	oicq/wlogin_sdk/report/Reporter:_app_sig	Ljava/lang/String;
    //   124: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_2
    //   129: ldc 193
    //   131: aload_0
    //   132: getfield 69	oicq/wlogin_sdk/report/Reporter:_btime	Ljava/lang/String;
    //   135: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_2
    //   140: ldc 195
    //   142: aload_0
    //   143: getfield 73	oicq/wlogin_sdk/report/Reporter:_bver	Ljava/lang/String;
    //   146: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   149: pop
    //   150: new 197	org/json/JSONArray
    //   153: dup
    //   154: invokespecial 198	org/json/JSONArray:<init>	()V
    //   157: astore_3
    //   158: aload_0
    //   159: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   162: invokevirtual 115	java/util/TreeMap:keySet	()Ljava/util/Set;
    //   165: invokeinterface 121 1 0
    //   170: astore 4
    //   172: aload 4
    //   174: invokeinterface 127 1 0
    //   179: ifeq +36 -> 215
    //   182: aload_3
    //   183: iload_1
    //   184: aload_0
    //   185: getfield 78	oicq/wlogin_sdk/report/Reporter:_lst	Ljava/util/TreeMap;
    //   188: aload 4
    //   190: invokeinterface 131 1 0
    //   195: invokevirtual 102	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: checkcast 104	oicq/wlogin_sdk/report/report_t2
    //   201: invokevirtual 151	oicq/wlogin_sdk/report/report_t2:toJasonObj	()Lorg/json/JSONObject;
    //   204: invokevirtual 201	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   207: pop
    //   208: iload_1
    //   209: iconst_1
    //   210: iadd
    //   211: istore_1
    //   212: goto -40 -> 172
    //   215: aload_2
    //   216: ldc 203
    //   218: aload_3
    //   219: invokevirtual 175	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: monitorexit
    //   225: aload_2
    //   226: areturn
    //   227: astore_2
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_2
    //   231: athrow
    //   232: astore_2
    //   233: aload_3
    //   234: astore_2
    //   235: goto -12 -> 223
    //   238: astore_3
    //   239: goto -16 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	Reporter
    //   1	211	1	i	int
    //   13	213	2	localJSONObject	org.json.JSONObject
    //   227	4	2	localObject	Object
    //   232	1	2	localException1	java.lang.Exception
    //   234	1	2	localJSONArray1	org.json.JSONArray
    //   5	229	3	localJSONArray2	org.json.JSONArray
    //   238	1	3	localException2	java.lang.Exception
    //   170	19	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   6	14	227	finally
    //   14	172	227	finally
    //   172	208	227	finally
    //   215	223	227	finally
    //   6	14	232	java/lang/Exception
    //   14	172	238	java/lang/Exception
    //   172	208	238	java/lang/Exception
    //   215	223	238	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.Reporter
 * JD-Core Version:    0.7.0.1
 */