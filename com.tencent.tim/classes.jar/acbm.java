import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class acbm
  implements Handler.Callback
{
  private long Pc;
  protected acbm.b a;
  protected acbm.c a;
  String alm;
  private String bkk;
  String[] dP;
  Bitmap eJ;
  private auru l = new auru(Looper.getMainLooper(), this);
  private boolean mAutoPlay;
  private int mFrameDelay;
  private int mIndex;
  private boolean mLoop;
  private boolean mStart;
  protected int mState = 0;
  
  public acbm(acbm.b paramb, acbm.c paramc)
  {
    this.jdField_a_of_type_Acbm$b = paramb;
    this.jdField_a_of_type_Acbm$c = paramc;
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    int i = 0;
    if (paramBoolean) {}
    try
    {
      b(paramFile, paramString);
      this.dP = new File(paramString).list();
      this.mState = 3;
      if ((this.dP != null) && (this.dP.length > 0)) {
        while (i < this.dP.length)
        {
          this.dP[i] = (paramString + this.dP[i]);
          i += 1;
        }
      }
      if (this.mAutoPlay)
      {
        stop();
        if ((!this.mStart) && (this.dP != null) && (this.dP.length > 0))
        {
          this.mIndex = 0;
          this.mStart = true;
          new acbm.a(this, 0).execute(new Integer[] { Integer.valueOf(this.mIndex) });
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.mState = 2;
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.mState = 2;
    }
  }
  
  protected void b(File paramFile, String paramString)
    throws IOException
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      jqp.b(paramFile, paramString);
    }
  }
  
  public void c(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.mFrameDelay = paramInt;
      this.mAutoPlay = paramBoolean;
      if (!paramString2.equals(this.bkk))
      {
        this.bkk = paramString2;
        this.mState = 0;
        stop();
        this.dP = null;
      }
    } while ((this.mState != 2) && (this.mState != 0));
    paramString2 = jc(this.bkk);
    this.alm = paramString2;
    Object localObject = new File(paramString2);
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).list();
    File localFile = new File(this.bkk);
    if ((localObject != null) && (localObject.length > 0))
    {
      a(false, localFile, paramString2);
      return;
    }
    if (localFile.exists())
    {
      a(true, localFile, paramString2);
      return;
    }
    if (this.jdField_a_of_type_Acbm$b != null)
    {
      this.jdField_a_of_type_Acbm$b.a(this, paramString1, this.bkk, paramString2);
      return;
    }
    this.mState = 2;
  }
  
  public void cGV()
  {
    if (this.mState == 3) {
      stop();
    }
    try
    {
      if ((!this.mStart) && (this.dP != null) && (this.dP.length > 0))
      {
        this.mIndex = 0;
        this.mStart = true;
        new acbm.a(this, 0).execute(new Integer[] { Integer.valueOf(this.mIndex) });
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SimpleFrameZipDecoder", 2, localException, new Object[0]);
    }
  }
  
  public void f(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.bkk != null) && (!this.bkk.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.bkk);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.mState = 2;
      return;
    }
    this.mState = 2;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public void h(Bitmap paramBitmap, int paramInt)
  {
    long l2;
    if ((this.mStart) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l1 = System.currentTimeMillis();
      l2 = l1 - this.Pc;
      this.eJ = paramBitmap;
      if (l2 <= this.mFrameDelay) {
        break label77;
      }
      this.Pc = l1;
      this.l.obtainMessage(255, this.mIndex, 0).sendToTarget();
    }
    for (;;)
    {
      this.mIndex = (paramInt + 1);
      return;
      label77:
      paramBitmap = this.l.obtainMessage(255, this.mIndex, 0);
      this.l.sendMessageDelayed(paramBitmap, this.mFrameDelay - l2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (!this.mStart);
    if (this.jdField_a_of_type_Acbm$c == null) {
      return false;
    }
    this.jdField_a_of_type_Acbm$c.c(paramMessage.arg1, this.eJ);
    if ((this.mLoop) && (this.dP != null) && (this.mIndex >= this.dP.length) && (this.dP.length != 1)) {
      this.mIndex = 0;
    }
    if ((this.dP != null) && (this.dP.length > this.mIndex)) {
      new acbm.a(this, this.mIndex).execute(new Integer[] { Integer.valueOf(this.mIndex) });
    }
    for (;;)
    {
      this.Pc = System.currentTimeMillis();
      break;
      this.mStart = false;
      this.jdField_a_of_type_Acbm$c.cGU();
    }
  }
  
  protected String jc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      return str + File.separator;
    }
    return "";
  }
  
  public void setPlayLoop(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void stop()
  {
    this.mStart = false;
    this.l.removeCallbacksAndMessages(null);
  }
  
  static class a
    extends AsyncTask<Integer, Void, Bitmap>
  {
    private WeakReference<acbm> gf;
    private int mIndex;
    
    public a(acbm paramacbm, int paramInt)
    {
      this.gf = new WeakReference(paramacbm);
      this.mIndex = paramInt;
    }
    
    /* Error */
    protected Bitmap a(Integer... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aload_0
      //   3: getfield 25	acbm$a:gf	Ljava/lang/ref/WeakReference;
      //   6: invokevirtual 37	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   9: checkcast 7	acbm
      //   12: astore_3
      //   13: aload_3
      //   14: ifnull +317 -> 331
      //   17: aload_1
      //   18: ifnull +313 -> 331
      //   21: aload_1
      //   22: arraylength
      //   23: ifle +308 -> 331
      //   26: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   29: ifeq +30 -> 59
      //   32: ldc 45
      //   34: iconst_2
      //   35: new 47	java/lang/StringBuilder
      //   38: dup
      //   39: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   42: ldc 50
      //   44: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: aload_1
      //   48: iconst_0
      //   49: aaload
      //   50: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   53: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   56: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   59: new 47	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   66: aload_3
      //   67: getfield 69	acbm:alm	Ljava/lang/String;
      //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: aload_1
      //   74: iconst_0
      //   75: aaload
      //   76: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   79: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   82: astore_1
      //   83: iconst_0
      //   84: ifne +240 -> 324
      //   87: new 71	java/io/BufferedInputStream
      //   90: dup
      //   91: new 73	java/io/FileInputStream
      //   94: dup
      //   95: aload_1
      //   96: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   99: invokespecial 79	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   102: astore_1
      //   103: aload_1
      //   104: astore_2
      //   105: aload_1
      //   106: invokestatic 85	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
      //   109: astore_3
      //   110: aload_3
      //   111: astore_2
      //   112: aload_1
      //   113: astore_3
      //   114: aload_2
      //   115: astore_1
      //   116: aload_3
      //   117: ifnull +7 -> 124
      //   120: aload_3
      //   121: invokevirtual 88	java/io/BufferedInputStream:close	()V
      //   124: aload_1
      //   125: areturn
      //   126: astore_2
      //   127: ldc 45
      //   129: iconst_1
      //   130: new 47	java/lang/StringBuilder
      //   133: dup
      //   134: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   137: ldc 90
      //   139: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   142: aload_2
      //   143: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   146: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   152: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   155: aload_1
      //   156: areturn
      //   157: astore_3
      //   158: aconst_null
      //   159: astore_1
      //   160: aload_1
      //   161: astore_2
      //   162: ldc 45
      //   164: iconst_1
      //   165: aload_3
      //   166: invokevirtual 97	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   169: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   172: aload_1
      //   173: ifnull +7 -> 180
      //   176: aload_1
      //   177: invokevirtual 88	java/io/BufferedInputStream:close	()V
      //   180: aconst_null
      //   181: areturn
      //   182: astore_1
      //   183: ldc 45
      //   185: iconst_1
      //   186: new 47	java/lang/StringBuilder
      //   189: dup
      //   190: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   193: ldc 90
      //   195: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: aload_1
      //   199: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   202: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   205: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   208: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   211: aconst_null
      //   212: areturn
      //   213: astore_3
      //   214: aconst_null
      //   215: astore_1
      //   216: aload_1
      //   217: astore_2
      //   218: ldc 45
      //   220: iconst_1
      //   221: aload_3
      //   222: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   225: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   228: aload_1
      //   229: ifnull +7 -> 236
      //   232: aload_1
      //   233: invokevirtual 88	java/io/BufferedInputStream:close	()V
      //   236: aconst_null
      //   237: areturn
      //   238: astore_1
      //   239: ldc 45
      //   241: iconst_1
      //   242: new 47	java/lang/StringBuilder
      //   245: dup
      //   246: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   249: ldc 90
      //   251: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   254: aload_1
      //   255: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   258: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   261: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   264: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   267: aconst_null
      //   268: areturn
      //   269: astore_1
      //   270: aload_2
      //   271: ifnull +7 -> 278
      //   274: aload_2
      //   275: invokevirtual 88	java/io/BufferedInputStream:close	()V
      //   278: aload_1
      //   279: athrow
      //   280: astore_2
      //   281: ldc 45
      //   283: iconst_1
      //   284: new 47	java/lang/StringBuilder
      //   287: dup
      //   288: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   291: ldc 90
      //   293: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   296: aload_2
      //   297: invokevirtual 93	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   300: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   306: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   309: goto -31 -> 278
      //   312: astore_1
      //   313: goto -43 -> 270
      //   316: astore_3
      //   317: goto -101 -> 216
      //   320: astore_3
      //   321: goto -161 -> 160
      //   324: aconst_null
      //   325: astore_3
      //   326: aconst_null
      //   327: astore_1
      //   328: goto -212 -> 116
      //   331: aconst_null
      //   332: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	333	0	this	a
      //   0	333	1	paramVarArgs	Integer[]
      //   1	114	2	localObject1	Object
      //   126	17	2	localThrowable1	java.lang.Throwable
      //   161	114	2	arrayOfInteger	Integer[]
      //   280	17	2	localThrowable2	java.lang.Throwable
      //   12	109	3	localObject2	Object
      //   157	9	3	localOutOfMemoryError1	OutOfMemoryError
      //   213	9	3	localThrowable3	java.lang.Throwable
      //   316	1	3	localThrowable4	java.lang.Throwable
      //   320	1	3	localOutOfMemoryError2	OutOfMemoryError
      //   325	1	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   120	124	126	java/lang/Throwable
      //   26	59	157	java/lang/OutOfMemoryError
      //   59	83	157	java/lang/OutOfMemoryError
      //   87	103	157	java/lang/OutOfMemoryError
      //   176	180	182	java/lang/Throwable
      //   26	59	213	java/lang/Throwable
      //   59	83	213	java/lang/Throwable
      //   87	103	213	java/lang/Throwable
      //   232	236	238	java/lang/Throwable
      //   26	59	269	finally
      //   59	83	269	finally
      //   87	103	269	finally
      //   274	278	280	java/lang/Throwable
      //   105	110	312	finally
      //   162	172	312	finally
      //   218	228	312	finally
      //   105	110	316	java/lang/Throwable
      //   105	110	320	java/lang/OutOfMemoryError
    }
    
    protected void o(Bitmap paramBitmap)
    {
      super.onPostExecute(paramBitmap);
      acbm localacbm = (acbm)this.gf.get();
      if ((localacbm != null) && (paramBitmap != null) && (!paramBitmap.isRecycled())) {
        localacbm.h(paramBitmap, this.mIndex);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(acbm paramacbm, String paramString1, String paramString2, String paramString3);
  }
  
  public static abstract interface c
  {
    public abstract void c(int paramInt, Bitmap paramBitmap);
    
    public abstract void cGU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbm
 * JD-Core Version:    0.7.0.1
 */