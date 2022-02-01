package com.tencent.token;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class agk
{
  public static final String a = afz.a(afz.aP);
  public static final String b = afz.a(afz.aQ);
  public static final String c = afz.a(afz.aR);
  public static final String d = afz.a(afz.aS);
  public static final String e = afz.a(afz.aT);
  public long f = -1L;
  public int g = -1;
  public String h = "";
  public ArrayList<String> i = null;
  
  public agk(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      Object localObject = e;
      if (paramString.has((String)localObject))
      {
        localObject = paramString.optJSONArray((String)localObject);
        ((JSONArray)localObject).length();
        this.i = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(j);
          this.i.add(str);
          j += 1;
        }
        a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(((String)this.i.get(0)).getBytes())));
        paramString.put(c, this.h);
        paramString.put(d, this.g);
        paramString.put(b, this.f);
        return;
      }
      this.f = paramString.optLong(b);
      this.g = paramString.optInt(d);
      this.h = paramString.optString(c);
      paramString.optString(a);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public agk(java.security.cert.Certificate[] paramArrayOfCertificate)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc2_w 59
    //   8: putfield 62	com/tencent/token/agk:f	J
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 64	com/tencent/token/agk:g	I
    //   16: aload_0
    //   17: ldc 66
    //   19: putfield 68	com/tencent/token/agk:h	Ljava/lang/String;
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 70	com/tencent/token/agk:i	Ljava/util/ArrayList;
    //   27: aload_1
    //   28: ifnull +148 -> 176
    //   31: new 90	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 91	java/util/ArrayList:<init>	()V
    //   38: astore 4
    //   40: new 84	org/json/JSONArray
    //   43: dup
    //   44: invokespecial 155	org/json/JSONArray:<init>	()V
    //   47: astore_3
    //   48: iconst_0
    //   49: istore_2
    //   50: iload_2
    //   51: aload_1
    //   52: arraylength
    //   53: if_icmpge +64 -> 117
    //   56: aload_1
    //   57: iload_2
    //   58: aaload
    //   59: astore 6
    //   61: aload 6
    //   63: invokevirtual 160	java/security/cert/Certificate:getEncoded	()[B
    //   66: iconst_2
    //   67: invokestatic 166	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   70: pop
    //   71: aload 6
    //   73: invokestatic 171	com/tencent/token/age:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   76: astore 5
    //   78: iload_2
    //   79: ifne +16 -> 95
    //   82: aload 6
    //   84: checkcast 128	java/security/cert/X509Certificate
    //   87: astore 6
    //   89: aload 6
    //   91: aload_0
    //   92: invokestatic 174	com/tencent/token/age:a	(Ljava/security/cert/X509Certificate;Lcom/tencent/token/agk;)V
    //   95: aload_3
    //   96: aload 5
    //   98: invokevirtual 177	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   101: pop
    //   102: aload 4
    //   104: aload 5
    //   106: invokevirtual 99	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: iload_2
    //   111: iconst_1
    //   112: iadd
    //   113: istore_2
    //   114: goto -64 -> 50
    //   117: aload_0
    //   118: aload 4
    //   120: putfield 70	com/tencent/token/agk:i	Ljava/util/ArrayList;
    //   123: new 72	org/json/JSONObject
    //   126: dup
    //   127: invokespecial 178	org/json/JSONObject:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: getstatic 51	com/tencent/token/agk:e	Ljava/lang/String;
    //   135: aload_3
    //   136: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_1
    //   141: getstatic 41	com/tencent/token/agk:c	Ljava/lang/String;
    //   144: aload_0
    //   145: getfield 68	com/tencent/token/agk:h	Ljava/lang/String;
    //   148: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_1
    //   153: getstatic 46	com/tencent/token/agk:d	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 64	com/tencent/token/agk:g	I
    //   160: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: getstatic 36	com/tencent/token/agk:b	Ljava/lang/String;
    //   168: aload_0
    //   169: getfield 62	com/tencent/token/agk:f	J
    //   172: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   175: pop
    //   176: return
    //   177: astore_1
    //   178: return
    //   179: astore 6
    //   181: goto -86 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	agk
    //   0	184	1	paramArrayOfCertificate	java.security.cert.Certificate[]
    //   49	65	2	j	int
    //   47	89	3	localJSONArray	JSONArray
    //   38	81	4	localArrayList	ArrayList
    //   76	29	5	str	String
    //   59	31	6	localObject	Object
    //   179	1	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	48	177	java/lang/Exception
    //   50	56	177	java/lang/Exception
    //   61	78	177	java/lang/Exception
    //   82	89	177	java/lang/Exception
    //   95	110	177	java/lang/Exception
    //   117	176	177	java/lang/Exception
    //   89	95	179	java/lang/Exception
  }
  
  private void a(X509Certificate paramX509Certificate)
  {
    try
    {
      age.a(paramX509Certificate, this);
      return;
    }
    catch (Exception paramX509Certificate) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agk
 * JD-Core Version:    0.7.0.1
 */