package btmsdkobf;

import android.os.Bundle;

public class bl
{
  public static final String KEY_COMPLETED = "key_completed";
  public static final String KEY_DOWNSIZE = "key_downSize";
  public static final String KEY_DOWNTYPE = "key_downType";
  public static final String KEY_ERRCODE = "key_errcode";
  public static final String KEY_ERRORMSG = "key_errorMsg";
  public static final String KEY_PROGRESS = "key_progress";
  public static final String KEY_SDCARDSTATUS = "key_sdcardstatus";
  public static final String KEY_SUCCESS = "key_success";
  public static final String KEY_TOTAL = "key_total";
  protected a gf = null;
  
  /* Error */
  public static String getRelocationUrl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 50	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 53	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 57	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 59	java/net/HttpURLConnection
    //   18: astore_0
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 63	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   26: aload_0
    //   27: sipush 30000
    //   30: invokevirtual 66	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   33: aload_0
    //   34: iconst_1
    //   35: invokevirtual 70	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   38: aload_0
    //   39: invokevirtual 74	java/net/HttpURLConnection:getResponseCode	()I
    //   42: pop
    //   43: aload_0
    //   44: invokevirtual 78	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   47: invokevirtual 82	java/net/URL:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: aload_0
    //   54: ifnull +41 -> 95
    //   57: aload_0
    //   58: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: aload_0
    //   65: astore_2
    //   66: goto +8 -> 74
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   82: aload_1
    //   83: athrow
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +8 -> 95
    //   90: aload_3
    //   91: astore_1
    //   92: goto -35 -> 57
    //   95: aload_2
    //   96: areturn
    //   97: astore_0
    //   98: goto -14 -> 84
    //   101: astore_1
    //   102: goto -16 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString	String
    //   50	12	1	str	String
    //   63	1	1	localObject1	Object
    //   73	19	1	localObject2	Object
    //   101	1	1	localException	java.lang.Exception
    //   1	95	2	localObject3	Object
    //   3	88	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	51	63	finally
    //   4	19	69	finally
    //   4	19	97	java/lang/Exception
    //   19	51	101	java/lang/Exception
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    a locala = this.gf;
    if (locala != null)
    {
      if (paramInt == 1)
      {
        locala.a(paramBundle);
        return;
      }
      if (paramInt == 2) {
        locala.b(paramBundle);
      }
    }
  }
  
  public void setNetworkListener(a parama)
  {
    this.gf = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(Bundle paramBundle);
    
    public abstract void b(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bl
 * JD-Core Version:    0.7.0.1
 */