package com.tencent.token.core.bean;

import java.util.List;

public final class g
{
  public int a;
  public String b;
  public boolean c;
  public int d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public Object h = null;
  protected List i = null;
  
  /* Error */
  public final boolean a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 38
    //   4: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 46	com/tencent/token/core/bean/g:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 48
    //   14: invokevirtual 52	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 56
    //   23: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +118 -> 144
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 58	com/tencent/token/core/bean/g:c	Z
    //   36: aload_0
    //   37: aload_1
    //   38: ldc 60
    //   40: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: putfield 62	com/tencent/token/core/bean/g:d	I
    //   46: aload_1
    //   47: ldc 64
    //   49: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   52: ifne +97 -> 149
    //   55: iconst_0
    //   56: istore_3
    //   57: aload_0
    //   58: iload_3
    //   59: putfield 28	com/tencent/token/core/bean/g:g	Z
    //   62: aload_1
    //   63: ldc 66
    //   65: invokevirtual 70	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +200 -> 270
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: aload_1
    //   77: invokevirtual 76	org/json/JSONArray:length	()I
    //   80: if_icmpge +190 -> 270
    //   83: aload_1
    //   84: iload_2
    //   85: invokevirtual 80	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +100 -> 192
    //   95: iconst_1
    //   96: istore_3
    //   97: iload_3
    //   98: invokestatic 85	com/tencent/token/global/e:a	(Z)V
    //   101: new 2	com/tencent/token/core/bean/g
    //   104: dup
    //   105: invokespecial 86	com/tencent/token/core/bean/g:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload 4
    //   114: invokevirtual 88	com/tencent/token/core/bean/g:a	(Lorg/json/JSONObject;)Z
    //   117: ifne +80 -> 197
    //   120: new 90	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   127: ldc 93
    //   129: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_2
    //   133: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: iconst_0
    //   145: istore_3
    //   146: goto -115 -> 31
    //   149: iconst_1
    //   150: istore_3
    //   151: goto -94 -> 57
    //   154: astore 4
    //   156: aload 4
    //   158: invokevirtual 110	org/json/JSONException:printStackTrace	()V
    //   161: goto -99 -> 62
    //   164: astore_1
    //   165: new 90	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   172: ldc 112
    //   174: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 115	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   190: iconst_0
    //   191: ireturn
    //   192: iconst_0
    //   193: istore_3
    //   194: goto -97 -> 97
    //   197: aload_0
    //   198: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   201: ifnonnull +14 -> 215
    //   204: aload_0
    //   205: new 117	java/util/ArrayList
    //   208: dup
    //   209: invokespecial 118	java/util/ArrayList:<init>	()V
    //   212: putfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   215: aload_0
    //   216: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   219: aload 5
    //   221: invokeinterface 124 2 0
    //   226: pop
    //   227: new 90	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   234: ldc 126
    //   236: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload_2
    //   240: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc 128
    //   245: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 5
    //   250: getfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   253: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 130	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   262: iload_2
    //   263: iconst_1
    //   264: iadd
    //   265: istore_2
    //   266: goto -191 -> 75
    //   269: astore_1
    //   270: iconst_1
    //   271: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	g
    //   0	272	1	paramJSONObject	org.json.JSONObject
    //   74	192	2	j	int
    //   30	164	3	bool	boolean
    //   88	25	4	localJSONObject	org.json.JSONObject
    //   154	3	4	localJSONException	org.json.JSONException
    //   108	141	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   46	55	154	org/json/JSONException
    //   57	62	154	org/json/JSONException
    //   0	29	164	org/json/JSONException
    //   31	46	164	org/json/JSONException
    //   156	161	164	org/json/JSONException
    //   62	69	269	org/json/JSONException
    //   75	90	269	org/json/JSONException
    //   97	142	269	org/json/JSONException
    //   197	215	269	org/json/JSONException
    //   215	262	269	org/json/JSONException
  }
  
  /* Error */
  public final boolean b(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 38
    //   4: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 46	com/tencent/token/core/bean/g:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 48
    //   14: invokevirtual 52	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 56
    //   23: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +92 -> 118
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 58	com/tencent/token/core/bean/g:c	Z
    //   36: aload_1
    //   37: ldc 66
    //   39: invokevirtual 70	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +185 -> 229
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: aload_1
    //   51: invokevirtual 76	org/json/JSONArray:length	()I
    //   54: if_icmpge +175 -> 229
    //   57: aload_1
    //   58: iload_2
    //   59: invokevirtual 80	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +85 -> 151
    //   69: iconst_1
    //   70: istore_3
    //   71: iload_3
    //   72: invokestatic 85	com/tencent/token/global/e:a	(Z)V
    //   75: new 2	com/tencent/token/core/bean/g
    //   78: dup
    //   79: invokespecial 86	com/tencent/token/core/bean/g:<init>	()V
    //   82: astore 5
    //   84: aload 5
    //   86: aload 4
    //   88: invokevirtual 132	com/tencent/token/core/bean/g:b	(Lorg/json/JSONObject;)Z
    //   91: ifne +65 -> 156
    //   94: new 90	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   101: ldc 93
    //   103: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   116: iconst_0
    //   117: ireturn
    //   118: iconst_0
    //   119: istore_3
    //   120: goto -89 -> 31
    //   123: astore_1
    //   124: new 90	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   131: ldc 112
    //   133: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 115	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: iconst_0
    //   152: istore_3
    //   153: goto -82 -> 71
    //   156: aload_0
    //   157: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   160: ifnonnull +14 -> 174
    //   163: aload_0
    //   164: new 117	java/util/ArrayList
    //   167: dup
    //   168: invokespecial 118	java/util/ArrayList:<init>	()V
    //   171: putfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   174: aload_0
    //   175: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   178: aload 5
    //   180: invokeinterface 124 2 0
    //   185: pop
    //   186: new 90	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   193: ldc 126
    //   195: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 128
    //   204: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 5
    //   209: getfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   212: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 130	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -176 -> 49
    //   228: astore_1
    //   229: iconst_1
    //   230: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	g
    //   0	231	1	paramJSONObject	org.json.JSONObject
    //   48	177	2	j	int
    //   30	123	3	bool	boolean
    //   62	25	4	localJSONObject	org.json.JSONObject
    //   82	126	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   0	29	123	org/json/JSONException
    //   31	36	123	org/json/JSONException
    //   36	43	228	org/json/JSONException
    //   49	64	228	org/json/JSONException
    //   71	116	228	org/json/JSONException
    //   156	174	228	org/json/JSONException
    //   174	221	228	org/json/JSONException
  }
  
  /* Error */
  public final boolean c(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 38
    //   4: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 46	com/tencent/token/core/bean/g:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 48
    //   14: invokevirtual 52	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 56
    //   23: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +108 -> 134
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 58	com/tencent/token/core/bean/g:c	Z
    //   36: aload_1
    //   37: ldc 64
    //   39: invokevirtual 44	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: ifne +97 -> 139
    //   45: iconst_0
    //   46: istore_3
    //   47: aload_0
    //   48: iload_3
    //   49: putfield 28	com/tencent/token/core/bean/g:g	Z
    //   52: aload_1
    //   53: ldc 66
    //   55: invokevirtual 70	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +190 -> 250
    //   63: iconst_0
    //   64: istore_2
    //   65: iload_2
    //   66: aload_1
    //   67: invokevirtual 76	org/json/JSONArray:length	()I
    //   70: if_icmpge +180 -> 250
    //   73: aload_1
    //   74: iload_2
    //   75: invokevirtual 80	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +90 -> 172
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: invokestatic 85	com/tencent/token/global/e:a	(Z)V
    //   91: new 2	com/tencent/token/core/bean/g
    //   94: dup
    //   95: invokespecial 86	com/tencent/token/core/bean/g:<init>	()V
    //   98: astore 5
    //   100: aload 5
    //   102: aload 4
    //   104: invokevirtual 134	com/tencent/token/core/bean/g:c	(Lorg/json/JSONObject;)Z
    //   107: ifne +70 -> 177
    //   110: new 90	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   117: ldc 93
    //   119: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload_2
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_0
    //   135: istore_3
    //   136: goto -105 -> 31
    //   139: iconst_1
    //   140: istore_3
    //   141: goto -94 -> 47
    //   144: astore_1
    //   145: new 90	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   152: ldc 112
    //   154: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 115	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 107	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   170: iconst_0
    //   171: ireturn
    //   172: iconst_0
    //   173: istore_3
    //   174: goto -87 -> 87
    //   177: aload_0
    //   178: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   181: ifnonnull +14 -> 195
    //   184: aload_0
    //   185: new 117	java/util/ArrayList
    //   188: dup
    //   189: invokespecial 118	java/util/ArrayList:<init>	()V
    //   192: putfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   195: aload_0
    //   196: getfield 32	com/tencent/token/core/bean/g:i	Ljava/util/List;
    //   199: aload 5
    //   201: invokeinterface 124 2 0
    //   206: pop
    //   207: new 90	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   214: ldc 126
    //   216: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: iload_2
    //   220: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc 128
    //   225: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 5
    //   230: getfield 54	com/tencent/token/core/bean/g:b	Ljava/lang/String;
    //   233: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 130	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   242: iload_2
    //   243: iconst_1
    //   244: iadd
    //   245: istore_2
    //   246: goto -181 -> 65
    //   249: astore_1
    //   250: iconst_1
    //   251: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	g
    //   0	252	1	paramJSONObject	org.json.JSONObject
    //   64	182	2	j	int
    //   30	144	3	bool	boolean
    //   78	25	4	localJSONObject	org.json.JSONObject
    //   98	131	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   0	29	144	org/json/JSONException
    //   31	45	144	org/json/JSONException
    //   47	52	144	org/json/JSONException
    //   52	59	249	org/json/JSONException
    //   65	80	249	org/json/JSONException
    //   87	132	249	org/json/JSONException
    //   177	195	249	org/json/JSONException
    //   195	242	249	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.g
 * JD-Core Version:    0.7.0.1
 */