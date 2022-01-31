package tmsdkdual;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tmsdk.dual.sharkcpp.callback.SharkCallbackCommon;

public class e
{
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      if (paramString != null) {}
    }
    for (;;)
    {
      return false;
      for (;;)
      {
        long l;
        String str;
        boolean bool;
        try
        {
          l = a.b().g.getLong("r_kclrt", 0L);
          str = a.b().g.getString("r_kclr", null);
          if (System.currentTimeMillis() - l < a.b().g.getLong("r_kcrintval", 24L) * 3600000L)
          {
            bool = paramString.equals(str);
            if (bool) {
              break;
            }
          }
          return true;
        }
        catch (Exception paramString) {}
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          l = a.b().g.getLong("r_nplrt", 0L);
          str = a.b().g.getString("r_nplr", null);
          if (System.currentTimeMillis() - l < a.b().g.getLong("r_nprinterval", 24L) * 3600000L)
          {
            bool = paramString.equals(str);
            if (bool) {
              break;
            }
          }
          return true;
        }
        catch (Exception paramString)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public void a(dualsim.common.PhoneGetResult paramPhoneGetResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 76	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   13: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   16: ldc 79
    //   18: aconst_null
    //   19: invokeinterface 41 3 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +187 -> 216
    //   32: aload_3
    //   33: ldc 81
    //   35: invokevirtual 85	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   38: astore_3
    //   39: ldc 87
    //   41: aload_3
    //   42: iconst_0
    //   43: aaload
    //   44: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +12 -> 59
    //   50: aload_2
    //   51: aload_1
    //   52: getfield 93	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   55: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: ldc 81
    //   62: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 87
    //   68: aload_3
    //   69: iconst_1
    //   70: aaload
    //   71: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +12 -> 86
    //   77: aload_2
    //   78: aload_1
    //   79: getfield 101	dualsim/common/PhoneGetResult:result	I
    //   82: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: ldc 81
    //   89: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 87
    //   95: aload_3
    //   96: iconst_2
    //   97: aaload
    //   98: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +12 -> 113
    //   104: aload_2
    //   105: aload_1
    //   106: getfield 107	dualsim/common/PhoneGetResult:queryType	I
    //   109: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: ldc 81
    //   116: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 87
    //   122: aload_3
    //   123: iconst_3
    //   124: aaload
    //   125: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +12 -> 140
    //   131: aload_2
    //   132: aload_1
    //   133: getfield 110	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   136: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: ldc 81
    //   143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 87
    //   149: aload_3
    //   150: iconst_4
    //   151: aaload
    //   152: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +12 -> 167
    //   158: aload_2
    //   159: aload_1
    //   160: getfield 113	dualsim/common/PhoneGetResult:respType	I
    //   163: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_2
    //   168: ldc 81
    //   170: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: ldc 87
    //   176: aload_3
    //   177: iconst_5
    //   178: aaload
    //   179: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifeq +12 -> 194
    //   185: aload_2
    //   186: aload_1
    //   187: getfield 116	dualsim/common/PhoneGetResult:respCode	I
    //   190: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_0
    //   195: iconst_1
    //   196: aload_2
    //   197: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 122	tmsdkdual/e:a	(ILjava/lang/String;)Z
    //   203: ifne +110 -> 313
    //   206: ldc 124
    //   208: ldc 126
    //   210: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   213: aload_0
    //   214: monitorexit
    //   215: return
    //   216: aload_2
    //   217: aload_1
    //   218: getfield 93	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   221: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 81
    //   226: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: getfield 101	dualsim/common/PhoneGetResult:result	I
    //   233: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc 81
    //   238: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_1
    //   242: getfield 107	dualsim/common/PhoneGetResult:queryType	I
    //   245: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 81
    //   250: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: getfield 110	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   257: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: goto -67 -> 194
    //   264: astore_3
    //   265: aload_2
    //   266: aload_1
    //   267: getfield 93	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 81
    //   275: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_1
    //   279: getfield 101	dualsim/common/PhoneGetResult:result	I
    //   282: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: ldc 81
    //   287: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_1
    //   291: getfield 107	dualsim/common/PhoneGetResult:queryType	I
    //   294: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc 81
    //   299: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_1
    //   303: getfield 110	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   306: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: goto -116 -> 194
    //   313: new 133	java/util/HashMap
    //   316: dup
    //   317: invokespecial 134	java/util/HashMap:<init>	()V
    //   320: astore_3
    //   321: aload_1
    //   322: getfield 93	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   325: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   328: ifne +19 -> 347
    //   331: aload_3
    //   332: bipush 11
    //   334: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: aload_1
    //   338: getfield 93	dualsim/common/PhoneGetResult:innerPhoneNumber	Ljava/lang/String;
    //   341: invokeinterface 146 3 0
    //   346: pop
    //   347: aload_3
    //   348: bipush 13
    //   350: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aload_1
    //   354: getfield 101	dualsim/common/PhoneGetResult:result	I
    //   357: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   360: invokeinterface 146 3 0
    //   365: pop
    //   366: aload_3
    //   367: bipush 14
    //   369: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   372: aload_1
    //   373: getfield 107	dualsim/common/PhoneGetResult:queryType	I
    //   376: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   379: invokeinterface 146 3 0
    //   384: pop
    //   385: aload_3
    //   386: bipush 15
    //   388: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aload_1
    //   392: getfield 113	dualsim/common/PhoneGetResult:respType	I
    //   395: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   398: invokeinterface 146 3 0
    //   403: pop
    //   404: aload_3
    //   405: bipush 16
    //   407: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aload_1
    //   411: getfield 116	dualsim/common/PhoneGetResult:respCode	I
    //   414: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   417: invokeinterface 146 3 0
    //   422: pop
    //   423: aload_1
    //   424: getfield 110	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   427: ifnull +19 -> 446
    //   430: aload_3
    //   431: bipush 17
    //   433: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aload_1
    //   437: getfield 110	dualsim/common/PhoneGetResult:extraInfo	Ljava/lang/String;
    //   440: invokeinterface 146 3 0
    //   445: pop
    //   446: sipush 187
    //   449: aload_3
    //   450: new 8	tmsdkdual/e$2
    //   453: dup
    //   454: aload_0
    //   455: aload_2
    //   456: invokespecial 152	tmsdkdual/e$2:<init>	(Ltmsdkdual/e;Ljava/lang/StringBuilder;)V
    //   459: invokestatic 158	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportAsyn	(ILjava/util/Map;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   462: goto -249 -> 213
    //   465: astore_1
    //   466: aload_0
    //   467: monitorexit
    //   468: aload_1
    //   469: athrow
    //   470: astore_1
    //   471: goto -258 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	e
    //   0	474	1	paramPhoneGetResult	dualsim.common.PhoneGetResult
    //   9	447	2	localStringBuilder	StringBuilder
    //   24	153	3	localObject	Object
    //   264	1	3	localException	Exception
    //   320	130	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   10	59	264	java/lang/Exception
    //   59	86	264	java/lang/Exception
    //   86	113	264	java/lang/Exception
    //   113	140	264	java/lang/Exception
    //   140	167	264	java/lang/Exception
    //   167	194	264	java/lang/Exception
    //   216	261	264	java/lang/Exception
    //   2	10	465	finally
    //   10	59	465	finally
    //   59	86	465	finally
    //   86	113	465	finally
    //   113	140	465	finally
    //   140	167	465	finally
    //   167	194	465	finally
    //   194	213	465	finally
    //   216	261	465	finally
    //   265	310	465	finally
    //   313	347	465	finally
    //   347	446	465	finally
    //   446	462	465	finally
    //   2	10	470	java/lang/Throwable
    //   10	59	470	java/lang/Throwable
    //   59	86	470	java/lang/Throwable
    //   86	113	470	java/lang/Throwable
    //   113	140	470	java/lang/Throwable
    //   140	167	470	java/lang/Throwable
    //   167	194	470	java/lang/Throwable
    //   194	213	470	java/lang/Throwable
    //   216	261	470	java/lang/Throwable
    //   265	310	470	java/lang/Throwable
    //   313	347	470	java/lang/Throwable
    //   347	446	470	java/lang/Throwable
    //   446	462	470	java/lang/Throwable
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    for (;;)
    {
      try
      {
        boolean bool = a.b().g.getBoolean("r_drsn", true);
        if (bool) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        StringBuilder localStringBuilder;
        Object localObject;
        continue;
      }
      finally {}
      return;
      localStringBuilder = new StringBuilder().append(paramBoolean).append("&").append(paramInt1).append("&");
      localObject = paramString1;
      if (paramString1 == null) {
        localObject = Integer.valueOf(0);
      }
      localObject = localStringBuilder.append(localObject).append("&");
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = Integer.valueOf(0);
      }
      paramString1 = paramString1 + "&" + paramInt2 + "&" + System.currentTimeMillis();
      m.b("UnionReport", "daliy save:" + paramString1);
      a.b().a("r_lkr", paramString1);
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 76	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   9: astore 8
    //   11: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   14: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   17: ldc 186
    //   19: aconst_null
    //   20: invokeinterface 41 3 0
    //   25: astore 9
    //   27: aload 9
    //   29: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +192 -> 224
    //   35: aload 9
    //   37: ldc 81
    //   39: invokevirtual 85	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   42: astore 9
    //   44: ldc 87
    //   46: aload 9
    //   48: iconst_0
    //   49: aaload
    //   50: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +10 -> 63
    //   56: aload 8
    //   58: iload_1
    //   59: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 8
    //   65: ldc 81
    //   67: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 87
    //   73: aload 9
    //   75: iconst_1
    //   76: aaload
    //   77: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifeq +10 -> 90
    //   83: aload 8
    //   85: iload_2
    //   86: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 8
    //   92: ldc 81
    //   94: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 87
    //   100: aload 9
    //   102: iconst_2
    //   103: aaload
    //   104: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +10 -> 117
    //   110: aload 8
    //   112: aload_3
    //   113: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 8
    //   119: ldc 81
    //   121: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 87
    //   127: aload 9
    //   129: iconst_3
    //   130: aaload
    //   131: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   134: ifeq +11 -> 145
    //   137: aload 8
    //   139: iload 5
    //   141: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 8
    //   147: ldc 81
    //   149: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 87
    //   155: aload 9
    //   157: iconst_4
    //   158: aaload
    //   159: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   162: ifeq +11 -> 173
    //   165: aload 8
    //   167: aload 4
    //   169: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 8
    //   175: ldc 81
    //   177: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 87
    //   183: aload 9
    //   185: iconst_5
    //   186: aaload
    //   187: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +11 -> 201
    //   193: aload 8
    //   195: iload 6
    //   197: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_0
    //   202: iconst_0
    //   203: aload 8
    //   205: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 122	tmsdkdual/e:a	(ILjava/lang/String;)Z
    //   211: ifne +256 -> 467
    //   214: ldc 124
    //   216: ldc 188
    //   218: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   221: aload_0
    //   222: monitorexit
    //   223: return
    //   224: aload 8
    //   226: iload_1
    //   227: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   230: ldc 81
    //   232: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload_2
    //   236: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc 81
    //   241: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 81
    //   250: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 5
    //   255: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 81
    //   260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload 4
    //   265: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: goto -68 -> 201
    //   272: astore 9
    //   274: aload 8
    //   276: iload_1
    //   277: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: ldc 81
    //   282: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: iload_2
    //   286: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc 81
    //   291: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_3
    //   295: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc 81
    //   300: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload 5
    //   305: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 81
    //   310: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 4
    //   315: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: goto -118 -> 201
    //   322: new 133	java/util/HashMap
    //   325: dup
    //   326: invokespecial 134	java/util/HashMap:<init>	()V
    //   329: astore 9
    //   331: aload_3
    //   332: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: ifne +17 -> 352
    //   338: aload 9
    //   340: bipush 7
    //   342: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: aload_3
    //   346: invokeinterface 146 3 0
    //   351: pop
    //   352: aload 9
    //   354: bipush 8
    //   356: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: iload_2
    //   360: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   363: invokeinterface 146 3 0
    //   368: pop
    //   369: iload_1
    //   370: ifeq +87 -> 457
    //   373: ldc 87
    //   375: astore_3
    //   376: aload 9
    //   378: bipush 9
    //   380: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aload_3
    //   384: invokeinterface 146 3 0
    //   389: pop
    //   390: aload 9
    //   392: bipush 10
    //   394: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: iload 7
    //   399: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   402: invokeinterface 146 3 0
    //   407: pop
    //   408: aload 4
    //   410: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   413: ifne +18 -> 431
    //   416: aload 9
    //   418: bipush 12
    //   420: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   423: aload 4
    //   425: invokeinterface 146 3 0
    //   430: pop
    //   431: sipush 191
    //   434: aload 9
    //   436: new 6	tmsdkdual/e$1
    //   439: dup
    //   440: aload_0
    //   441: aload 8
    //   443: invokespecial 189	tmsdkdual/e$1:<init>	(Ltmsdkdual/e;Ljava/lang/StringBuilder;)V
    //   446: invokestatic 158	com/tmsdk/dual/sharkcpp/SharkCppProxy:unifiedReportAsyn	(ILjava/util/Map;Lcom/tmsdk/dual/sharkcpp/callback/SharkCallbackCommon;)V
    //   449: goto -228 -> 221
    //   452: astore_3
    //   453: aload_0
    //   454: monitorexit
    //   455: aload_3
    //   456: athrow
    //   457: ldc 191
    //   459: astore_3
    //   460: goto -84 -> 376
    //   463: astore_3
    //   464: goto -243 -> 221
    //   467: iload 5
    //   469: istore 7
    //   471: iload 6
    //   473: ifeq -151 -> 322
    //   476: iload 5
    //   478: bipush 10
    //   480: iadd
    //   481: istore 7
    //   483: goto -161 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	e
    //   0	486	1	paramBoolean1	boolean
    //   0	486	2	paramInt1	int
    //   0	486	3	paramString1	String
    //   0	486	4	paramString2	String
    //   0	486	5	paramInt2	int
    //   0	486	6	paramBoolean2	boolean
    //   397	85	7	i	int
    //   9	433	8	localStringBuilder	StringBuilder
    //   25	159	9	localObject	Object
    //   272	1	9	localException	Exception
    //   329	106	9	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   11	63	272	java/lang/Exception
    //   63	90	272	java/lang/Exception
    //   90	117	272	java/lang/Exception
    //   117	145	272	java/lang/Exception
    //   145	173	272	java/lang/Exception
    //   173	201	272	java/lang/Exception
    //   224	269	272	java/lang/Exception
    //   2	11	452	finally
    //   11	63	452	finally
    //   63	90	452	finally
    //   90	117	452	finally
    //   117	145	452	finally
    //   145	173	452	finally
    //   173	201	452	finally
    //   201	221	452	finally
    //   224	269	452	finally
    //   274	319	452	finally
    //   322	352	452	finally
    //   352	369	452	finally
    //   376	431	452	finally
    //   431	449	452	finally
    //   2	11	463	java/lang/Exception
    //   201	221	463	java/lang/Exception
    //   274	319	463	java/lang/Exception
    //   322	352	463	java/lang/Exception
    //   352	369	463	java/lang/Exception
    //   376	431	463	java/lang/Exception
    //   431	449	463	java/lang/Exception
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   8: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   11: ldc 161
    //   13: iconst_1
    //   14: invokeinterface 165 3 0
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   30: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   33: ldc 180
    //   35: aconst_null
    //   36: invokeinterface 41 3 0
    //   41: astore 6
    //   43: aload 6
    //   45: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne -24 -> 24
    //   51: aload 6
    //   53: ldc 170
    //   55: invokevirtual 85	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   58: astore 8
    //   60: aload 8
    //   62: ifnull -38 -> 24
    //   65: aload 8
    //   67: arraylength
    //   68: ifle -44 -> 24
    //   71: aload 8
    //   73: iconst_0
    //   74: aaload
    //   75: invokestatic 198	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   78: istore_3
    //   79: aload 8
    //   81: iconst_1
    //   82: aaload
    //   83: invokestatic 202	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   86: istore_1
    //   87: ldc 191
    //   89: aload 8
    //   91: iconst_2
    //   92: aaload
    //   93: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +207 -> 303
    //   99: aconst_null
    //   100: astore 6
    //   102: ldc 191
    //   104: aload 8
    //   106: iconst_3
    //   107: aaload
    //   108: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +201 -> 312
    //   114: aload 8
    //   116: iconst_4
    //   117: aaload
    //   118: invokestatic 202	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   121: istore_2
    //   122: aload 8
    //   124: iconst_5
    //   125: aaload
    //   126: invokestatic 208	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   129: lstore 4
    //   131: iload_3
    //   132: ifne +20 -> 152
    //   135: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   138: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   141: ldc 210
    //   143: iconst_1
    //   144: invokeinterface 165 3 0
    //   149: ifne -125 -> 24
    //   152: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   155: lload 4
    //   157: lsub
    //   158: lstore 4
    //   160: lload 4
    //   162: invokestatic 23	tmsdkdual/a:b	()Ltmsdkdual/a;
    //   165: getfield 27	tmsdkdual/a:g	Landroid/content/SharedPreferences;
    //   168: ldc 212
    //   170: ldc2_w 213
    //   173: invokeinterface 35 4 0
    //   178: ldc2_w 52
    //   181: lmul
    //   182: lcmp
    //   183: ifle +31 -> 214
    //   186: ldc 124
    //   188: new 76	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   195: ldc 216
    //   197: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: lload 4
    //   202: invokevirtual 176	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   205: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   211: goto -187 -> 24
    //   214: aload_0
    //   215: iload_3
    //   216: iload_1
    //   217: aload 6
    //   219: aload 7
    //   221: iload_2
    //   222: iconst_1
    //   223: invokevirtual 218	tmsdkdual/e:a	(ZILjava/lang/String;Ljava/lang/String;IZ)V
    //   226: ldc 124
    //   228: new 76	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   235: ldc 220
    //   237: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: iload_3
    //   241: invokevirtual 168	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   244: ldc 222
    //   246: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_1
    //   250: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc 224
    //   255: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 6
    //   260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 226
    //   265: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 7
    //   270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 228
    //   275: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload_2
    //   279: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 131	tmsdkdual/m:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   288: goto -264 -> 24
    //   291: astore 6
    //   293: aload_0
    //   294: monitorexit
    //   295: aload 6
    //   297: athrow
    //   298: astore 6
    //   300: goto -276 -> 24
    //   303: aload 8
    //   305: iconst_2
    //   306: aaload
    //   307: astore 6
    //   309: goto -207 -> 102
    //   312: aload 8
    //   314: iconst_3
    //   315: aaload
    //   316: astore 7
    //   318: goto -204 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	e
    //   86	164	1	i	int
    //   121	158	2	j	int
    //   19	222	3	bool	boolean
    //   129	72	4	l	long
    //   41	218	6	str1	String
    //   291	5	6	localObject1	Object
    //   298	1	6	localThrowable	Throwable
    //   307	1	6	localObject2	Object
    //   1	316	7	str2	String
    //   58	255	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   5	20	291	finally
    //   27	60	291	finally
    //   65	99	291	finally
    //   102	114	291	finally
    //   114	131	291	finally
    //   135	152	291	finally
    //   152	211	291	finally
    //   214	288	291	finally
    //   5	20	298	java/lang/Throwable
    //   27	60	298	java/lang/Throwable
    //   65	99	298	java/lang/Throwable
    //   102	114	298	java/lang/Throwable
    //   114	131	298	java/lang/Throwable
    //   135	152	298	java/lang/Throwable
    //   152	211	298	java/lang/Throwable
    //   214	288	298	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.e
 * JD-Core Version:    0.7.0.1
 */