import com.tencent.gdtad.views.canvas.GdtCanvasData;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

@Deprecated
class yws
  implements yxe
{
  void a(GdtCanvasData paramGdtCanvasData, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, JSONObject paramJSONObject) {}
  
  /* Error */
  public boolean a(ywk paramywk, java.lang.String paramString, java.lang.String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +12 -> 13
    //   4: ldc 21
    //   6: ldc 23
    //   8: invokestatic 29	yxp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: iconst_1
    //   12: ireturn
    //   13: aload_1
    //   14: invokevirtual 34	ywk:a	()Landroid/app/Activity;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnull -17 -> 4
    //   24: new 36	org/json/JSONObject
    //   27: dup
    //   28: aload_3
    //   29: iconst_0
    //   30: aaload
    //   31: invokespecial 39	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   34: astore 5
    //   36: ldc 21
    //   38: aload 5
    //   40: invokevirtual 43	org/json/JSONObject:toString	()Ljava/lang/String;
    //   43: invokestatic 46	yxp:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload 5
    //   48: ldc 48
    //   50: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 6
    //   55: aload 5
    //   57: ldc 54
    //   59: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 7
    //   64: aload 5
    //   66: ldc 56
    //   68: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 5
    //   75: ldc 58
    //   77: invokevirtual 52	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore 9
    //   82: aload 5
    //   84: ldc 60
    //   86: invokevirtual 64	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   89: astore_2
    //   90: aload_2
    //   91: ifnull -87 -> 4
    //   94: aload_2
    //   95: getstatic 68	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   98: if_acmpeq -94 -> 4
    //   101: aload_2
    //   102: ldc 70
    //   104: invokevirtual 74	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   107: ifne +229 -> 336
    //   110: new 36	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 75	org/json/JSONObject:<init>	()V
    //   117: astore_3
    //   118: aload_3
    //   119: ldc 70
    //   121: aload_2
    //   122: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload_3
    //   127: astore_2
    //   128: new 81	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo
    //   131: dup
    //   132: invokespecial 82	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: getfield 86	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:canvas_json	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: aload_2
    //   141: invokevirtual 43	org/json/JSONObject:toString	()Ljava/lang/String;
    //   144: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   147: new 93	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo
    //   150: dup
    //   151: invokespecial 94	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:<init>	()V
    //   154: astore_2
    //   155: aload_2
    //   156: getfield 97	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:traceid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   159: aload 9
    //   161: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   164: new 99	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo
    //   167: dup
    //   168: invokespecial 100	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:<init>	()V
    //   171: astore 9
    //   173: aload 9
    //   175: getfield 103	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:exposure_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   178: aload 6
    //   180: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   183: aload 9
    //   185: getfield 106	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:click_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   188: aload 7
    //   190: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   193: aload 9
    //   195: getfield 109	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:landing_page_report_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   198: aload 8
    //   200: invokevirtual 91	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   203: aload 9
    //   205: getfield 113	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:trace_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo;
    //   208: aload_2
    //   209: invokevirtual 116	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$TraceInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   212: new 118	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo
    //   215: dup
    //   216: invokespecial 119	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:<init>	()V
    //   219: astore 6
    //   221: aload 6
    //   223: getfield 123	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:dest_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo;
    //   226: aload_3
    //   227: invokevirtual 124	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$DestInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   230: aload 6
    //   232: getfield 128	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo:report_info	Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo;
    //   235: aload 9
    //   237: invokevirtual 129	tencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   240: new 131	com/tencent/gdtad/aditem/GdtAd
    //   243: dup
    //   244: aload 6
    //   246: invokespecial 134	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   249: astore_2
    //   250: aload_2
    //   251: invokestatic 139	yzf:a	(Lcom/tencent/gdtad/aditem/GdtAd;)Lcom/tencent/gdtad/views/canvas/GdtCanvasData;
    //   254: astore_3
    //   255: aload_0
    //   256: aload_3
    //   257: aload 6
    //   259: aload 5
    //   261: invokevirtual 141	yws:a	(Lcom/tencent/gdtad/views/canvas/GdtCanvasData;Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;Lorg/json/JSONObject;)V
    //   264: aload 4
    //   266: ldc 143
    //   268: aload_3
    //   269: invokestatic 147	com/tencent/gdtad/jsbridge/GdtCanvasFragmentForJS:start	(Landroid/app/Activity;Ljava/lang/Class;Lcom/tencent/gdtad/views/canvas/GdtCanvasData;)V
    //   272: aload_1
    //   273: ifnull +58 -> 331
    //   276: aload_1
    //   277: invokevirtual 149	ywk:a	()Ljava/lang/String;
    //   280: astore_1
    //   281: aload 4
    //   283: iconst_0
    //   284: ldc 151
    //   286: aload_1
    //   287: aload_2
    //   288: invokestatic 157	com/tencent/ad/tangram/statistics/AdReporterForAnalysis:reportForJSBridgeInvoked	(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;Lcom/tencent/ad/tangram/Ad;)V
    //   291: iconst_1
    //   292: ireturn
    //   293: astore_1
    //   294: ldc 21
    //   296: ldc 23
    //   298: aload_1
    //   299: invokestatic 160	yxp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: goto -298 -> 4
    //   305: astore_2
    //   306: ldc 21
    //   308: ldc 23
    //   310: aload_2
    //   311: invokestatic 160	yxp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -226 -> 90
    //   319: astore_1
    //   320: ldc 21
    //   322: ldc 23
    //   324: aload_1
    //   325: invokestatic 160	yxp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: goto -324 -> 4
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -52 -> 281
    //   336: goto -208 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	yws
    //   0	339	1	paramywk	ywk
    //   0	339	2	paramString	java.lang.String
    //   0	339	3	paramVarArgs	java.lang.String[]
    //   17	265	4	localActivity	android.app.Activity
    //   34	226	5	localJSONObject	JSONObject
    //   53	205	6	localObject1	Object
    //   62	127	7	str1	java.lang.String
    //   71	128	8	str2	java.lang.String
    //   80	156	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	36	293	org/json/JSONException
    //   82	90	305	java/lang/Throwable
    //   118	126	319	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yws
 * JD-Core Version:    0.7.0.1
 */