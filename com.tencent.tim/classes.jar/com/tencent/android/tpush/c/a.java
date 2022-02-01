package com.tencent.android.tpush.c;

import com.tencent.android.tpush.logging.TLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private String a = null;
  private String b = null;
  private String c = null;
  private String d = "0";
  private long e = 0L;
  private int f = 0;
  private long g = 0L;
  
  public static a a(String paramString)
  {
    a locala = new a();
    if (e.a(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("imei")) {
        locala.c(paramString.getString("imei"));
      }
      if (!paramString.isNull("imsi")) {
        locala.d(paramString.getString("imsi"));
      }
      if (!paramString.isNull("mac")) {
        locala.e(paramString.getString("mac"));
      }
      if (!paramString.isNull("mid")) {
        locala.b(paramString.getString("mid"));
      }
      if (!paramString.isNull("ts")) {
        locala.a(paramString.getLong("ts"));
      }
      if (!paramString.isNull("ver")) {
        locala.f = paramString.optInt("ver", 0);
      }
      if (!paramString.isNull("guid")) {
        locala.g = paramString.optLong("guid", 0L);
      }
      return locala;
    }
    catch (JSONException paramString)
    {
      TLogger.w("MidEntity", "MidEntity parse error: " + paramString.toString());
    }
    return locala;
  }
  
  /* Error */
  JSONObject a()
  {
    // Byte code:
    //   0: new 46	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 119	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 51
    //   11: aload_0
    //   12: getfield 20	com/tencent/android/tpush/c/a:a	Ljava/lang/String;
    //   15: invokestatic 122	com/tencent/android/tpush/c/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_1
    //   19: ldc 62
    //   21: aload_0
    //   22: getfield 22	com/tencent/android/tpush/c/a:b	Ljava/lang/String;
    //   25: invokestatic 122	com/tencent/android/tpush/c/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: ldc 66
    //   31: aload_0
    //   32: getfield 24	com/tencent/android/tpush/c/a:c	Ljava/lang/String;
    //   35: invokestatic 122	com/tencent/android/tpush/c/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_1
    //   39: ldc 70
    //   41: aload_0
    //   42: getfield 28	com/tencent/android/tpush/c/a:d	Ljava/lang/String;
    //   45: invokestatic 122	com/tencent/android/tpush/c/e:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: ldc 89
    //   51: aload_0
    //   52: getfield 34	com/tencent/android/tpush/c/a:g	J
    //   55: invokevirtual 126	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload_1
    //   60: ldc 74
    //   62: aload_0
    //   63: getfield 30	com/tencent/android/tpush/c/a:e	J
    //   66: invokevirtual 126	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload_1
    //   71: areturn
    //   72: astore_2
    //   73: ldc 95
    //   75: new 97	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   82: ldc 128
    //   84: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 108	org/json/JSONException:toString	()Ljava/lang/String;
    //   91: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 115	com/tencent/android/tpush/logging/TLogger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: areturn
    //   102: astore_2
    //   103: goto -44 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	a
    //   7	94	1	localJSONObject	JSONObject
    //   72	16	2	localJSONException	JSONException
    //   102	1	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   8	48	72	org/json/JSONException
    //   48	59	72	org/json/JSONException
    //   59	70	72	org/json/JSONException
    //   48	59	102	java/lang/Throwable
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(String paramString)
  {
    this.a = paramString;
  }
  
  public void d(String paramString)
  {
    this.b = paramString;
  }
  
  public void e(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.c.a
 * JD-Core Version:    0.7.0.1
 */