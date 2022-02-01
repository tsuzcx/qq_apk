package com.tencent.token.core.bean;

import java.util.ArrayList;
import java.util.List;

public class f
{
  public int a;
  public String b;
  public boolean c;
  public int d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public Object h = null;
  protected List<f> i = null;
  
  public void a(f paramf)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramf);
  }
  
  /* Error */
  public boolean a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 49
    //   4: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 57	com/tencent/token/core/bean/f:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 59
    //   14: invokevirtual 63	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 67
    //   23: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +118 -> 144
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 69	com/tencent/token/core/bean/f:c	Z
    //   36: aload_0
    //   37: aload_1
    //   38: ldc 71
    //   40: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: putfield 73	com/tencent/token/core/bean/f:d	I
    //   46: aload_1
    //   47: ldc 75
    //   49: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   52: ifne +97 -> 149
    //   55: iconst_0
    //   56: istore_3
    //   57: aload_0
    //   58: iload_3
    //   59: putfield 29	com/tencent/token/core/bean/f:g	Z
    //   62: aload_1
    //   63: ldc 77
    //   65: invokevirtual 81	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +176 -> 246
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: aload_1
    //   77: invokevirtual 87	org/json/JSONArray:length	()I
    //   80: if_icmpge +166 -> 246
    //   83: aload_1
    //   84: iload_2
    //   85: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   88: astore 4
    //   90: aload 4
    //   92: ifnull +100 -> 192
    //   95: iconst_1
    //   96: istore_3
    //   97: iload_3
    //   98: invokestatic 96	com/tencent/token/global/g:a	(Z)V
    //   101: new 2	com/tencent/token/core/bean/f
    //   104: dup
    //   105: invokespecial 97	com/tencent/token/core/bean/f:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload 4
    //   114: invokevirtual 99	com/tencent/token/core/bean/f:a	(Lorg/json/JSONObject;)Z
    //   117: ifne +80 -> 197
    //   120: new 101	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   127: ldc 104
    //   129: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_2
    //   133: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
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
    //   158: invokevirtual 121	org/json/JSONException:printStackTrace	()V
    //   161: goto -99 -> 62
    //   164: astore_1
    //   165: new 101	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   172: ldc 123
    //   174: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 126	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   190: iconst_0
    //   191: ireturn
    //   192: iconst_0
    //   193: istore_3
    //   194: goto -97 -> 97
    //   197: aload_0
    //   198: aload 5
    //   200: invokevirtual 128	com/tencent/token/core/bean/f:a	(Lcom/tencent/token/core/bean/f;)V
    //   203: new 101	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   210: ldc 130
    //   212: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: iload_2
    //   216: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc 132
    //   221: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 5
    //   226: getfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   229: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 134	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   238: iload_2
    //   239: iconst_1
    //   240: iadd
    //   241: istore_2
    //   242: goto -167 -> 75
    //   245: astore_1
    //   246: iconst_1
    //   247: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	f
    //   0	248	1	paramJSONObject	org.json.JSONObject
    //   74	168	2	j	int
    //   30	164	3	bool	boolean
    //   88	25	4	localJSONObject	org.json.JSONObject
    //   154	3	4	localJSONException	org.json.JSONException
    //   108	117	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   46	55	154	org/json/JSONException
    //   57	62	154	org/json/JSONException
    //   0	29	164	org/json/JSONException
    //   31	46	164	org/json/JSONException
    //   156	161	164	org/json/JSONException
    //   62	69	245	org/json/JSONException
    //   75	90	245	org/json/JSONException
    //   97	142	245	org/json/JSONException
    //   197	238	245	org/json/JSONException
  }
  
  /* Error */
  public boolean b(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 49
    //   4: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 57	com/tencent/token/core/bean/f:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 59
    //   14: invokevirtual 63	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 67
    //   23: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +92 -> 118
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 69	com/tencent/token/core/bean/f:c	Z
    //   36: aload_1
    //   37: ldc 77
    //   39: invokevirtual 81	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +161 -> 205
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: aload_1
    //   51: invokevirtual 87	org/json/JSONArray:length	()I
    //   54: if_icmpge +151 -> 205
    //   57: aload_1
    //   58: iload_2
    //   59: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +85 -> 151
    //   69: iconst_1
    //   70: istore_3
    //   71: iload_3
    //   72: invokestatic 96	com/tencent/token/global/g:a	(Z)V
    //   75: new 2	com/tencent/token/core/bean/f
    //   78: dup
    //   79: invokespecial 97	com/tencent/token/core/bean/f:<init>	()V
    //   82: astore 5
    //   84: aload 5
    //   86: aload 4
    //   88: invokevirtual 136	com/tencent/token/core/bean/f:b	(Lorg/json/JSONObject;)Z
    //   91: ifne +65 -> 156
    //   94: new 101	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   101: ldc 104
    //   103: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   116: iconst_0
    //   117: ireturn
    //   118: iconst_0
    //   119: istore_3
    //   120: goto -89 -> 31
    //   123: astore_1
    //   124: new 101	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   131: ldc 123
    //   133: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: invokevirtual 126	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   149: iconst_0
    //   150: ireturn
    //   151: iconst_0
    //   152: istore_3
    //   153: goto -82 -> 71
    //   156: aload_0
    //   157: aload 5
    //   159: invokevirtual 128	com/tencent/token/core/bean/f:a	(Lcom/tencent/token/core/bean/f;)V
    //   162: new 101	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   169: ldc 130
    //   171: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_2
    //   175: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc 132
    //   180: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: getfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   188: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 134	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: goto -152 -> 49
    //   204: astore_1
    //   205: iconst_1
    //   206: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	f
    //   0	207	1	paramJSONObject	org.json.JSONObject
    //   48	153	2	j	int
    //   30	123	3	bool	boolean
    //   62	25	4	localJSONObject	org.json.JSONObject
    //   82	102	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   0	29	123	org/json/JSONException
    //   31	36	123	org/json/JSONException
    //   36	43	204	org/json/JSONException
    //   49	64	204	org/json/JSONException
    //   71	116	204	org/json/JSONException
    //   156	197	204	org/json/JSONException
  }
  
  /* Error */
  public boolean c(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 49
    //   4: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 57	com/tencent/token/core/bean/f:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 59
    //   14: invokevirtual 63	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 67
    //   23: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +108 -> 134
    //   29: iconst_1
    //   30: istore_3
    //   31: aload_0
    //   32: iload_3
    //   33: putfield 69	com/tencent/token/core/bean/f:c	Z
    //   36: aload_1
    //   37: ldc 75
    //   39: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   42: ifne +97 -> 139
    //   45: iconst_0
    //   46: istore_3
    //   47: aload_0
    //   48: iload_3
    //   49: putfield 29	com/tencent/token/core/bean/f:g	Z
    //   52: aload_1
    //   53: ldc 77
    //   55: invokevirtual 81	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +166 -> 226
    //   63: iconst_0
    //   64: istore_2
    //   65: iload_2
    //   66: aload_1
    //   67: invokevirtual 87	org/json/JSONArray:length	()I
    //   70: if_icmpge +156 -> 226
    //   73: aload_1
    //   74: iload_2
    //   75: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +90 -> 172
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: invokestatic 96	com/tencent/token/global/g:a	(Z)V
    //   91: new 2	com/tencent/token/core/bean/f
    //   94: dup
    //   95: invokespecial 97	com/tencent/token/core/bean/f:<init>	()V
    //   98: astore 5
    //   100: aload 5
    //   102: aload 4
    //   104: invokevirtual 138	com/tencent/token/core/bean/f:c	(Lorg/json/JSONObject;)Z
    //   107: ifne +70 -> 177
    //   110: new 101	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   117: ldc 104
    //   119: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload_2
    //   123: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_0
    //   135: istore_3
    //   136: goto -105 -> 31
    //   139: iconst_1
    //   140: istore_3
    //   141: goto -94 -> 47
    //   144: astore_1
    //   145: new 101	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   152: ldc 123
    //   154: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_1
    //   158: invokevirtual 126	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   161: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 118	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   170: iconst_0
    //   171: ireturn
    //   172: iconst_0
    //   173: istore_3
    //   174: goto -87 -> 87
    //   177: aload_0
    //   178: aload 5
    //   180: invokevirtual 128	com/tencent/token/core/bean/f:a	(Lcom/tencent/token/core/bean/f;)V
    //   183: new 101	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   190: ldc 130
    //   192: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload_2
    //   196: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc 132
    //   201: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 5
    //   206: getfield 65	com/tencent/token/core/bean/f:b	Ljava/lang/String;
    //   209: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 134	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   218: iload_2
    //   219: iconst_1
    //   220: iadd
    //   221: istore_2
    //   222: goto -157 -> 65
    //   225: astore_1
    //   226: iconst_1
    //   227: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	f
    //   0	228	1	paramJSONObject	org.json.JSONObject
    //   64	158	2	j	int
    //   30	144	3	bool	boolean
    //   78	25	4	localJSONObject	org.json.JSONObject
    //   98	107	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   0	29	144	org/json/JSONException
    //   31	45	144	org/json/JSONException
    //   47	52	144	org/json/JSONException
    //   52	59	225	org/json/JSONException
    //   65	80	225	org/json/JSONException
    //   87	132	225	org/json/JSONException
    //   177	218	225	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.f
 * JD-Core Version:    0.7.0.1
 */