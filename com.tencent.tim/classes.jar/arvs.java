import android.text.TextUtils;

public class arvs
{
  /* Error */
  public static void Xm(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 12	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic 18	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -10 -> 12
    //   25: aload_0
    //   26: invokevirtual 22	android/net/Uri:getHost	()Ljava/lang/String;
    //   29: ifnull -17 -> 12
    //   32: aload_0
    //   33: invokevirtual 22	android/net/Uri:getHost	()Ljava/lang/String;
    //   36: invokevirtual 27	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   39: invokestatic 31	arvs:sq	(Ljava/lang/String;)Z
    //   42: ifeq -30 -> 12
    //   45: new 33	arvr
    //   48: dup
    //   49: invokestatic 39	aroi:a	()Laroi;
    //   52: invokevirtual 43	aroi:getContext	()Landroid/content/Context;
    //   55: invokespecial 47	arvr:<init>	(Landroid/content/Context;)V
    //   58: astore_0
    //   59: new 49	arvq
    //   62: dup
    //   63: invokespecial 52	arvq:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_1
    //   71: invokevirtual 56	arvq:setAcceptCookie	(Z)V
    //   74: invokestatic 39	aroi:a	()Laroi;
    //   77: invokevirtual 60	aroi:getUin	()J
    //   80: lstore_2
    //   81: invokestatic 65	arxr:getImei	()Ljava/lang/String;
    //   84: astore 5
    //   86: invokestatic 39	aroi:a	()Laroi;
    //   89: invokevirtual 68	aroi:getSkey	()Ljava/lang/String;
    //   92: astore 6
    //   94: aload 4
    //   96: ldc 70
    //   98: new 72	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   105: ldc 75
    //   107: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload_2
    //   111: invokevirtual 82	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: ldc 84
    //   116: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 86
    //   121: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 88
    //   126: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 95	arvq:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: ldc 70
    //   139: new 72	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   146: ldc 97
    //   148: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 84
    //   158: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 86
    //   163: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 88
    //   168: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 95	arvq:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 4
    //   179: ldc 70
    //   181: new 72	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   188: ldc 99
    //   190: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 5
    //   195: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 84
    //   200: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 86
    //   205: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 88
    //   210: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 95	arvq:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 102	arvr:sync	()V
    //   223: goto -211 -> 12
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   7	2	1	bool	boolean
    //   80	31	2	l	long
    //   66	112	4	localarvq	arvq
    //   84	110	5	str1	String
    //   92	60	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	8	226	finally
    //   16	21	226	finally
    //   25	223	226	finally
  }
  
  public static boolean sq(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".qq.com")) || (paramString.endsWith(".myapp.com")) || (paramString.endsWith(".3gqq.com")) || (paramString.endsWith(".qzone.com"))))
    {
      arwt.d("CookieUtils", "host:" + paramString + " isAuthedDomain:true");
      return true;
    }
    arwt.d("CookieUtils", "host:" + paramString + " isAuthedDomain:false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvs
 * JD-Core Version:    0.7.0.1
 */