package c.t.m.g;

final class an$1
  implements Runnable
{
  /* Error */
  @android.annotation.SuppressLint({"MissingPermission"})
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 23	c/t/m/g/am:a	()Landroid/content/SharedPreferences;
    //   3: astore 4
    //   5: invokestatic 28	c/t/m/g/ad:a	()Landroid/content/Context;
    //   8: astore_3
    //   9: invokestatic 34	java/lang/System:currentTimeMillis	()J
    //   12: lstore_1
    //   13: aload 4
    //   15: ldc 36
    //   17: lload_1
    //   18: invokestatic 42	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   21: invokestatic 45	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V
    //   24: lload_1
    //   25: invokestatic 50	c/t/m/g/an:a	(J)J
    //   28: pop2
    //   29: aload_3
    //   30: invokevirtual 56	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   33: ldc 58
    //   35: invokestatic 64	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_3
    //   39: aload 4
    //   41: ldc 66
    //   43: aload_3
    //   44: invokestatic 69	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_3
    //   48: invokestatic 73	c/t/m/g/an:b	(Ljava/lang/String;)Ljava/lang/String;
    //   51: pop
    //   52: getstatic 79	android/os/Build:MODEL	Ljava/lang/String;
    //   55: astore_3
    //   56: aload 4
    //   58: ldc 81
    //   60: aload_3
    //   61: invokestatic 69	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_3
    //   65: invokestatic 84	c/t/m/g/an:c	(Ljava/lang/String;)Ljava/lang/String;
    //   68: pop
    //   69: ldc 86
    //   71: astore_3
    //   72: invokestatic 90	c/t/m/g/an:k	()Z
    //   75: ifne +15 -> 90
    //   78: getstatic 96	android/os/Build$VERSION:SDK_INT	I
    //   81: bipush 26
    //   83: if_icmplt +28 -> 111
    //   86: invokestatic 100	android/os/Build:getSerial	()Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: invokestatic 105	c/t/m/g/ai:c	(Ljava/lang/String;)Z
    //   94: ifne +34 -> 128
    //   97: aload 4
    //   99: ldc 107
    //   101: aload_3
    //   102: invokestatic 69	c/t/m/g/am:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokestatic 110	c/t/m/g/an:d	(Ljava/lang/String;)Ljava/lang/String;
    //   109: pop
    //   110: return
    //   111: getstatic 113	android/os/Build:SERIAL	Ljava/lang/String;
    //   114: astore_3
    //   115: goto -25 -> 90
    //   118: astore_3
    //   119: return
    //   120: astore_3
    //   121: goto -52 -> 69
    //   124: astore_3
    //   125: goto -73 -> 52
    //   128: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	1
    //   12	13	1	l	long
    //   8	107	3	localObject	Object
    //   118	1	3	localThrowable1	java.lang.Throwable
    //   120	1	3	localThrowable2	java.lang.Throwable
    //   124	1	3	localThrowable3	java.lang.Throwable
    //   3	95	4	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   72	90	118	java/lang/Throwable
    //   90	110	118	java/lang/Throwable
    //   111	115	118	java/lang/Throwable
    //   52	69	120	java/lang/Throwable
    //   29	52	124	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.an.1
 * JD-Core Version:    0.7.0.1
 */