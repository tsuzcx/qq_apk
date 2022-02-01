import android.content.Context;

public class asej
{
  private static volatile asej jdField_a_of_type_Asej;
  private asen jdField_a_of_type_Asen;
  private aseq jdField_a_of_type_Aseq;
  private Context mContext;
  private boolean mInited;
  private long mSelfUin;
  
  public static asej a()
  {
    if (jdField_a_of_type_Asej == null) {}
    try
    {
      if (jdField_a_of_type_Asej == null) {
        jdField_a_of_type_Asej = new asej();
      }
      return jdField_a_of_type_Asej;
    }
    finally {}
  }
  
  public aser a()
  {
    aser localaser = null;
    if (this.jdField_a_of_type_Aseq != null) {
      localaser = this.jdField_a_of_type_Aseq.a();
    }
    return localaser;
  }
  
  /* Error */
  public void a(Context paramContext, long paramLong, asen paramasen)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: ldc 37
    //   6: iconst_3
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: lload_2
    //   17: invokestatic 43	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: aload 4
    //   25: aastore
    //   26: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokestatic 55	asev:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 57	asej:mInited	Z
    //   36: ifeq +13 -> 49
    //   39: ldc 35
    //   41: ldc 59
    //   43: invokestatic 62	asev:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 68	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   54: putfield 70	asej:mContext	Landroid/content/Context;
    //   57: aload_0
    //   58: lload_2
    //   59: putfield 72	asej:mSelfUin	J
    //   62: aload_0
    //   63: aload 4
    //   65: putfield 74	asej:jdField_a_of_type_Asen	Lasen;
    //   68: aload_0
    //   69: getfield 26	asej:jdField_a_of_type_Aseq	Laseq;
    //   72: ifnonnull +26 -> 98
    //   75: aload_0
    //   76: new 28	aseq
    //   79: dup
    //   80: aload_0
    //   81: getfield 70	asej:mContext	Landroid/content/Context;
    //   84: aload_0
    //   85: getfield 72	asej:mSelfUin	J
    //   88: aload_0
    //   89: getfield 74	asej:jdField_a_of_type_Asen	Lasen;
    //   92: invokespecial 76	aseq:<init>	(Landroid/content/Context;JLasen;)V
    //   95: putfield 26	asej:jdField_a_of_type_Aseq	Laseq;
    //   98: aload_0
    //   99: iconst_1
    //   100: putfield 57	asej:mInited	Z
    //   103: goto -57 -> 46
    //   106: astore_1
    //   107: ldc 35
    //   109: ldc 78
    //   111: aload_1
    //   112: invokestatic 82	asev:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield 26	asej:jdField_a_of_type_Aseq	Laseq;
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield 57	asej:mInited	Z
    //   125: goto -79 -> 46
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	asej
    //   0	133	1	paramContext	Context
    //   0	133	2	paramLong	long
    //   0	133	4	paramasen	asen
    // Exception table:
    //   from	to	target	type
    //   49	98	106	java/lang/Throwable
    //   98	103	106	java/lang/Throwable
    //   2	46	128	finally
    //   49	98	128	finally
    //   98	103	128	finally
    //   107	125	128	finally
  }
  
  public void a(asfc paramasfc)
  {
    asfd.a().a(paramasfc, true);
  }
  
  public void b(asfc paramasfc)
  {
    asfd.a().b(paramasfc);
  }
  
  public void emQ()
  {
    try
    {
      asfd.a().destroy();
      if (this.jdField_a_of_type_Aseq != null)
      {
        this.jdField_a_of_type_Aseq.destroy();
        this.jdField_a_of_type_Aseq = null;
      }
      this.mContext = null;
      this.mSelfUin = 0L;
      this.jdField_a_of_type_Asen = null;
      this.mInited = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asej
 * JD-Core Version:    0.7.0.1
 */