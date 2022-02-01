package com.tencent.tgpa.vendorpd.a;

import com.tencent.tgpa.vendorpd.GameCallback;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class j$1
  implements Callback
{
  j$1(j paramj) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    m.b("onFailure: request version failed.");
    if (j.a(this.a) != null)
    {
      paramCall = new StringBuilder();
      paramCall.append("{\"ret\": 1,\"data\":{},\"msg\": \"network is not available.\"}");
      j.a(this.a).getPreDownloadVersionInfo(paramCall.toString());
    }
  }
  
  /* Error */
  public void onResponse(Call paramCall, okhttp3.Response paramResponse)
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: ldc 56
    //   9: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_2
    //   13: invokevirtual 62	okhttp3/Response:code	()I
    //   16: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 26	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   29: invokevirtual 74	okhttp3/ResponseBody:string	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 78	okhttp3/Response:isSuccessful	()Z
    //   37: ifne +65 -> 102
    //   40: aload_0
    //   41: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   44: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   47: ifnull +47 -> 94
    //   50: new 33	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 80
    //   61: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 62	okhttp3/Response:code	()I
    //   68: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc 82
    //   73: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   81: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   84: aload_1
    //   85: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokeinterface 50 2 0
    //   93: pop
    //   94: aload_2
    //   95: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   98: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   101: return
    //   102: new 33	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   109: ldc 87
    //   111: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 26	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   127: new 95	org/json/JSONObject
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 97	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   135: astore_3
    //   136: aload_3
    //   137: ldc 99
    //   139: invokevirtual 103	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   142: ifeq +393 -> 535
    //   145: aload_3
    //   146: ldc 99
    //   148: invokevirtual 106	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   151: ifne +384 -> 535
    //   154: aload_3
    //   155: ldc 108
    //   157: invokevirtual 103	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   160: ifeq +375 -> 535
    //   163: aload_3
    //   164: ldc 108
    //   166: invokevirtual 112	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   169: astore 4
    //   171: aload 4
    //   173: invokevirtual 116	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   176: astore 5
    //   178: new 118	java/util/ArrayList
    //   181: dup
    //   182: invokespecial 119	java/util/ArrayList:<init>	()V
    //   185: astore 6
    //   187: aload 5
    //   189: invokeinterface 124 1 0
    //   194: ifeq +227 -> 421
    //   197: aload 5
    //   199: invokeinterface 128 1 0
    //   204: checkcast 89	java/lang/String
    //   207: astore 7
    //   209: aload 4
    //   211: aload 7
    //   213: invokevirtual 112	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   216: astore 8
    //   218: aload 8
    //   220: ldc 130
    //   222: invokevirtual 134	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 9
    //   227: aload 8
    //   229: ldc 130
    //   231: new 33	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   238: invokestatic 140	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   241: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   244: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   247: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 9
    //   252: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: getstatic 149	java/io/File:separator	Ljava/lang/String;
    //   258: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokevirtual 153	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload 8
    //   270: ldc 155
    //   272: invokevirtual 159	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   275: astore 8
    //   277: aload 7
    //   279: aload_0
    //   280: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   283: invokestatic 162	com/tencent/tgpa/vendorpd/a/j:b	(Lcom/tencent/tgpa/vendorpd/a/j;)Ljava/lang/String;
    //   286: aload 8
    //   288: invokestatic 167	com/tencent/tgpa/vendorpd/a/k:a	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;)Z
    //   291: ifeq -104 -> 187
    //   294: aload 6
    //   296: aload 7
    //   298: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   301: pop
    //   302: goto -115 -> 187
    //   305: astore 8
    //   307: aload 8
    //   309: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   312: new 33	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   319: ldc 176
    //   321: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 7
    //   326: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 179	com/tencent/tgpa/vendorpd/a/m:c	(Ljava/lang/String;)V
    //   335: aload 6
    //   337: aload 7
    //   339: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   342: pop
    //   343: goto -156 -> 187
    //   346: astore_3
    //   347: aload_3
    //   348: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   351: new 33	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   358: ldc 181
    //   360: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_1
    //   364: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   367: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 179	com/tencent/tgpa/vendorpd/a/m:c	(Ljava/lang/String;)V
    //   376: new 33	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   383: astore_1
    //   384: aload_1
    //   385: ldc 183
    //   387: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc 82
    //   392: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_0
    //   397: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   400: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   403: aload_1
    //   404: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokeinterface 50 2 0
    //   412: pop
    //   413: aload_2
    //   414: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   417: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   420: return
    //   421: aload 6
    //   423: invokevirtual 186	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   426: astore 5
    //   428: aload 5
    //   430: invokeinterface 124 1 0
    //   435: ifeq +32 -> 467
    //   438: aload 4
    //   440: aload 5
    //   442: invokeinterface 128 1 0
    //   447: checkcast 89	java/lang/String
    //   450: invokevirtual 190	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   453: pop
    //   454: goto -26 -> 428
    //   457: astore_1
    //   458: aload_2
    //   459: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   462: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   465: aload_1
    //   466: athrow
    //   467: aload 4
    //   469: invokevirtual 193	org/json/JSONObject:length	()I
    //   472: ifne +43 -> 515
    //   475: new 33	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   482: astore_3
    //   483: aload_3
    //   484: ldc 195
    //   486: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_0
    //   491: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   494: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   497: aload_3
    //   498: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokeinterface 50 2 0
    //   506: pop
    //   507: aload_2
    //   508: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   511: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   514: return
    //   515: aload_0
    //   516: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   519: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   522: aload_3
    //   523: invokevirtual 196	org/json/JSONObject:toString	()Ljava/lang/String;
    //   526: invokeinterface 50 2 0
    //   531: pop
    //   532: goto -25 -> 507
    //   535: ldc 198
    //   537: invokestatic 26	com/tencent/tgpa/vendorpd/a/m:b	(Ljava/lang/String;)V
    //   540: aload_0
    //   541: getfield 12	com/tencent/tgpa/vendorpd/a/j$1:a	Lcom/tencent/tgpa/vendorpd/a/j;
    //   544: invokestatic 31	com/tencent/tgpa/vendorpd/a/j:a	(Lcom/tencent/tgpa/vendorpd/a/j;)Lcom/tencent/tgpa/vendorpd/GameCallback;
    //   547: aload_1
    //   548: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   551: invokeinterface 50 2 0
    //   556: pop
    //   557: aload_2
    //   558: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   561: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   564: return
    //   565: astore_1
    //   566: aload_1
    //   567: invokevirtual 174	java/lang/Exception:printStackTrace	()V
    //   570: ldc 200
    //   572: invokestatic 179	com/tencent/tgpa/vendorpd/a/m:c	(Ljava/lang/String;)V
    //   575: aload_2
    //   576: invokevirtual 69	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   579: invokevirtual 85	okhttp3/ResponseBody:close	()V
    //   582: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	1
    //   0	583	1	paramCall	Call
    //   0	583	2	paramResponse	okhttp3.Response
    //   135	29	3	localJSONObject1	org.json.JSONObject
    //   346	2	3	localException1	java.lang.Exception
    //   482	41	3	localStringBuilder	StringBuilder
    //   169	299	4	localJSONObject2	org.json.JSONObject
    //   176	265	5	localIterator	java.util.Iterator
    //   185	237	6	localArrayList	java.util.ArrayList
    //   207	131	7	str1	java.lang.String
    //   216	71	8	localObject	Object
    //   305	3	8	localException2	java.lang.Exception
    //   225	26	9	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   209	302	305	java/lang/Exception
    //   102	187	346	java/lang/Exception
    //   187	209	346	java/lang/Exception
    //   307	343	346	java/lang/Exception
    //   421	428	346	java/lang/Exception
    //   428	454	346	java/lang/Exception
    //   467	507	346	java/lang/Exception
    //   515	532	346	java/lang/Exception
    //   535	557	346	java/lang/Exception
    //   33	94	457	finally
    //   102	187	457	finally
    //   187	209	457	finally
    //   209	302	457	finally
    //   307	343	457	finally
    //   347	413	457	finally
    //   421	428	457	finally
    //   428	454	457	finally
    //   467	507	457	finally
    //   515	532	457	finally
    //   535	557	457	finally
    //   566	575	457	finally
    //   33	94	565	java/lang/Exception
    //   347	413	565	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.j.1
 * JD-Core Version:    0.7.0.1
 */