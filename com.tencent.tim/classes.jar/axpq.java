import android.graphics.Bitmap;
import com.tencent.component.network.utils.thread.AsyncTask;
import java.util.List;

final class axpq
  extends AsyncTask<Void, Void, Bitmap>
{
  axpq(boolean paramBoolean1, boolean paramBoolean2, List paramList, boolean paramBoolean3) {}
  
  /* Error */
  protected Bitmap b(Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 37	ayva:a	()Layva;
    //   3: astore_1
    //   4: aload_1
    //   5: invokevirtual 41	ayva:bc	()Landroid/graphics/Bitmap;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +190 -> 202
    //   15: aload_1
    //   16: astore_2
    //   17: aload_1
    //   18: invokevirtual 47	android/graphics/Bitmap:isRecycled	()Z
    //   21: ifne +181 -> 202
    //   24: aload_0
    //   25: getfield 15	axpq:dvS	Z
    //   28: ifne +119 -> 147
    //   31: aload_0
    //   32: getfield 17	axpq:dvT	Z
    //   35: ifeq +51 -> 86
    //   38: getstatic 52	aygz:a	Layym;
    //   41: ifnull +155 -> 196
    //   44: new 54	ayym
    //   47: dup
    //   48: invokespecial 55	ayym:<init>	()V
    //   51: astore_2
    //   52: aload_2
    //   53: getstatic 52	aygz:a	Layym;
    //   56: getfield 59	ayym:sharedContext	Landroid/opengl/EGLContext;
    //   59: aload_1
    //   60: invokevirtual 63	android/graphics/Bitmap:getWidth	()I
    //   63: aload_1
    //   64: invokevirtual 66	android/graphics/Bitmap:getHeight	()I
    //   67: invokevirtual 69	ayym:b	(Landroid/opengl/EGLContext;II)V
    //   70: aload_2
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 19	axpq:gY	Ljava/util/List;
    //   76: getstatic 52	aygz:a	Layym;
    //   79: invokevirtual 72	ayym:a	(Landroid/graphics/Bitmap;Ljava/util/List;Layym;)Landroid/graphics/Bitmap;
    //   82: astore_2
    //   83: goto +115 -> 198
    //   86: new 54	ayym
    //   89: dup
    //   90: invokespecial 55	ayym:<init>	()V
    //   93: astore_3
    //   94: aload_3
    //   95: aload_1
    //   96: invokevirtual 63	android/graphics/Bitmap:getWidth	()I
    //   99: aload_1
    //   100: invokevirtual 66	android/graphics/Bitmap:getHeight	()I
    //   103: invokevirtual 76	ayym:lD	(II)V
    //   106: aload_3
    //   107: aload_1
    //   108: aload_0
    //   109: getfield 19	axpq:gY	Ljava/util/List;
    //   112: aload_0
    //   113: getfield 21	axpq:dvU	Z
    //   116: invokevirtual 79	ayym:a	(Landroid/graphics/Bitmap;Ljava/util/List;Z)Landroid/graphics/Bitmap;
    //   119: astore_2
    //   120: aload_3
    //   121: invokevirtual 82	ayym:destory	()V
    //   124: goto +74 -> 198
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +69 -> 202
    //   136: ldc 89
    //   138: iconst_1
    //   139: ldc 91
    //   141: aload_3
    //   142: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_1
    //   146: areturn
    //   147: aload_1
    //   148: aload_1
    //   149: invokevirtual 99	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   152: iconst_1
    //   153: invokevirtual 103	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   156: astore_2
    //   157: aload_2
    //   158: areturn
    //   159: astore_3
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: astore_2
    //   164: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +35 -> 202
    //   170: ldc 89
    //   172: iconst_1
    //   173: ldc 105
    //   175: aload_3
    //   176: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload_1
    //   180: areturn
    //   181: astore_3
    //   182: goto -20 -> 162
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_1
    //   188: goto -60 -> 128
    //   191: aload_1
    //   192: astore_2
    //   193: goto +9 -> 202
    //   196: aconst_null
    //   197: astore_2
    //   198: aload_2
    //   199: ifnull -8 -> 191
    //   202: aload_2
    //   203: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	axpq
    //   0	204	1	paramVarArgs	Void[]
    //   10	193	2	localObject	java.lang.Object
    //   93	28	3	localayym	ayym
    //   127	15	3	localException1	java.lang.Exception
    //   159	17	3	localError1	java.lang.Error
    //   181	1	3	localError2	java.lang.Error
    //   185	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	83	127	java/lang/Exception
    //   86	124	127	java/lang/Exception
    //   147	157	127	java/lang/Exception
    //   4	9	159	java/lang/Error
    //   17	83	181	java/lang/Error
    //   86	124	181	java/lang/Error
    //   147	157	181	java/lang/Error
    //   4	9	185	java/lang/Exception
  }
  
  protected void o(Bitmap paramBitmap)
  {
    aygz localaygz = ayva.a().b();
    if ((localaygz != null) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      localaygz.e(paramBitmap, true);
      localaygz.eRL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axpq
 * JD-Core Version:    0.7.0.1
 */