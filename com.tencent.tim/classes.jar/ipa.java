import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class ipa
{
  private static final String PE = acbn.SDCARD_ROOT + "/avdebug/";
  private static boolean TQ;
  private static final String[] aO = { "10.AV_SRC", "20.AV_PRE_RENDER", "30.AV_FILTER_NEW", "40.AV_FILTER", "50.AV_POST_RENDER", "60.AV_RETURN", "appleVideoDenoise", "appleLowlightEnhance", "applyBeauty30", "yuvCenterTextureFbo", "rgbRotateCenterTextureFbo", "applyBeauty20", "mirrorTextureIn", "mirrorTextureOut" };
  private static final StringBuilder q = new StringBuilder(500);
  private String PG;
  private boolean TR;
  private ipa.a[] a;
  private byte[] aW;
  private int arz;
  public boolean mDebugMode;
  
  private ipa.a a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.a.length) {
        localObject1 = this.a[paramInt];
      }
    }
    return localObject1;
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, paramInt2, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt3, paramInt4, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
  
  private static void a(FileOutputStream paramFileOutputStream, byte[] paramArrayOfByte)
  {
    if ((paramFileOutputStream == null) || (paramArrayOfByte == null)) {
      return;
    }
    try
    {
      paramFileOutputStream.write(paramArrayOfByte);
      paramFileOutputStream.flush();
      return;
    }
    catch (Throwable paramFileOutputStream)
    {
      paramFileOutputStream.printStackTrace();
    }
  }
  
  static String aL(int paramInt)
  {
    if (paramInt < aO.length) {
      return aO[paramInt];
    }
    return "unknown";
  }
  
  /* Error */
  private static void b(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 148	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 122	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 151	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: invokestatic 139	ipa:a	(Ljava/io/FileOutputStream;[B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   40: aload_2
    //   41: ifnull -30 -> 11
    //   44: aload_2
    //   45: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   48: return
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   54: return
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   64: aload_0
    //   65: ifnull -54 -> 11
    //   68: aload_0
    //   69: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   78: return
    //   79: astore_0
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 154	java/io/FileOutputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   97: goto -7 -> 90
    //   100: astore_0
    //   101: goto -19 -> 82
    //   104: astore_3
    //   105: aload_2
    //   106: astore_0
    //   107: goto -49 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramArrayOfByte	byte[]
    //   0	110	1	paramString	String
    //   20	86	2	localFileOutputStream	FileOutputStream
    //   55	6	3	localException1	java.lang.Exception
    //   104	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   44	48	49	java/lang/Exception
    //   12	21	55	java/lang/Exception
    //   68	72	73	java/lang/Exception
    //   12	21	79	finally
    //   86	90	92	java/lang/Exception
    //   23	28	100	finally
    //   30	34	100	finally
    //   36	40	100	finally
    //   60	64	100	finally
    //   23	28	104	java/lang/Exception
    //   30	34	104	java/lang/Exception
    //   36	40	104	java/lang/Exception
  }
  
  private void bF(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 * paramInt1 * 4;
    if ((this.aW == null) || (this.aW.length != paramInt1))
    {
      this.aW = new byte[paramInt1];
      return;
    }
    Arrays.fill(this.aW, (byte)0);
  }
  
  public static String d(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "UnKnown";
    switch (paramInt3)
    {
    }
    for (;;)
    {
      return "[w" + paramInt1 + "h" + paramInt2 + "f" + str + "]";
      str = "RGB32";
      continue;
      str = "NV21";
      continue;
      str = "YUV420";
      continue;
      str = "NV16";
    }
  }
  
  @TargetApi(23)
  void a(ioz paramioz, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    ipa.a locala;
    Object localObject2;
    int i1;
    int m;
    int n;
    int j;
    int k;
    if (this.mDebugMode)
    {
      locala = a(paramInt1);
      if (locala != null)
      {
        localObject2 = null;
        i1 = 0;
        m = paramioz.mWidth;
        n = paramioz.mHeight;
        if ((paramInt1 != 0) && (paramInt1 != 5)) {
          break label91;
        }
        i = 17;
        j = paramioz.mHeight;
        k = paramioz.mWidth;
        localObject1 = paramArrayOfByte;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        locala.a((byte[])localObject1, i, j, k);
      }
      if (this.TR) {
        break;
      }
      return;
      label91:
      if (paramInt1 == 3)
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt3 != -1)
        {
          bF(m, n);
          a(paramInt3, 36064, m, n, this.aW);
          localObject1 = this.aW;
          i = 42;
          k = n;
          j = m;
        }
      }
      else if (paramInt1 == 2)
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt3 != -1)
        {
          bF(m, n);
          a(paramInt3, 36064, m, n, this.aW);
          localObject1 = this.aW;
          i = 42;
          k = n;
          j = m;
        }
      }
      else if (paramInt1 == 4)
      {
        m = paramioz.mHeight;
        n = paramioz.mWidth;
        if (paramioz.aT != null)
        {
          localObject1 = paramioz.aT;
          i = 42;
          k = n;
          j = m;
        }
        else
        {
          k = n;
          j = m;
          i = i1;
          localObject1 = localObject2;
          if (paramioz.aU != null)
          {
            localObject1 = paramioz.aU;
            i = 35;
            k = n;
            j = m;
          }
        }
      }
      else
      {
        k = n;
        j = m;
        i = i1;
        localObject1 = localObject2;
        if (paramInt1 == 1) {
          if (paramInt3 != -1)
          {
            bF(m, n);
            a(paramInt3, 36064, m, n, this.aW);
            localObject1 = this.aW;
            i = 42;
            k = n;
            j = m;
          }
          else
          {
            k = n;
            j = m;
            i = i1;
            localObject1 = localObject2;
            if (paramInt2 != -1)
            {
              bF(m, n);
              ioz.saveTextureToRgbaBuffer(paramInt2, m, n, this.aW);
              localObject1 = this.aW;
              i = 42;
              k = n;
              j = m;
            }
          }
        }
      }
    }
    Object localObject1 = this.PG + this.arz + "_" + aL(paramInt1);
    int i = paramioz.mHeight * paramioz.mWidth * 4;
    if (paramArrayOfByte != null) {
      b(paramArrayOfByte, (String)localObject1 + "_yuvData_" + d(paramioz.mHeight, paramioz.mWidth, 17) + ".yuv");
    }
    if (paramInt3 != -1)
    {
      paramArrayOfByte = (String)localObject1 + "_textureId_1_" + d(paramioz.mWidth, paramioz.mHeight, 0) + ".jpg";
      ioz.d(paramInt3, paramioz.mWidth, paramioz.mHeight, paramArrayOfByte);
    }
    if (paramInt2 != -1)
    {
      if ((this.aW == null) || (this.aW.length != i)) {
        this.aW = new byte[i];
      }
      paramArrayOfByte = (String)localObject1 + "_fbo_1_" + d(paramioz.mWidth, paramioz.mHeight, 42) + ".yuv";
      ioz.saveTextureToRgbaBuffer(paramInt2, paramioz.mWidth, paramioz.mHeight, this.aW);
      b(this.aW, paramArrayOfByte);
    }
    if (paramInt1 == 1)
    {
      if (paramioz.arr != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_Y_1" + d(paramioz.mWidth, paramioz.mHeight, 0) + ".jpg";
        ioz.d(paramioz.arr, paramioz.mWidth, paramioz.mHeight, paramArrayOfByte);
        if ((this.aW == null) || (this.aW.length != i)) {
          this.aW = new byte[i];
        }
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_Y_1" + d(paramioz.mWidth, paramioz.mHeight, 42) + ".yuv";
        a(paramioz.arr, 6409, paramioz.mWidth, paramioz.mHeight, this.aW);
        b(this.aW, paramArrayOfByte);
      }
      if (paramioz.ars != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_UV_1" + d(paramioz.mWidth / 2, paramioz.mHeight / 2, 0) + ".jpg";
        ioz.d(paramioz.ars, paramioz.mWidth / 2, paramioz.mHeight / 2, paramArrayOfByte);
        if ((this.aW == null) || (this.aW.length != i)) {
          this.aW = new byte[i];
        }
        paramArrayOfByte = (String)localObject1 + "_mYuvTextureId_for_UV_1" + d(paramioz.mWidth, paramioz.mHeight, 42) + ".yuv";
        a(paramioz.ars, 6410, paramioz.mWidth, paramioz.mHeight, this.aW);
        b(this.aW, paramArrayOfByte);
      }
    }
    for (;;)
    {
      if (paramioz.aqX != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_yuvCenterTextureFbo_1" + d(paramioz.mWidth, paramioz.mHeight, 0) + ".jpg";
        ioz.d(paramioz.aqX, paramioz.mWidth, paramioz.mHeight, paramArrayOfByte);
      }
      if (paramioz.aqY != -1)
      {
        paramArrayOfByte = (String)localObject1 + "_yuvCenterTextureId_1" + d(paramioz.mWidth, paramioz.mHeight, 0) + ".jpg";
        ioz.d(paramioz.aqY, paramioz.mWidth, paramioz.mHeight, paramArrayOfByte);
      }
      this.arz += 1;
      return;
      if (paramInt1 == 4)
      {
        if (paramioz.aru != -1)
        {
          if ((this.aW == null) || (this.aW.length != i)) {
            this.aW = new byte[i];
          }
          paramArrayOfByte = (String)localObject1 + "_rgbRotateCenterTextureFbo_" + paramioz.aru + "_" + d(paramioz.mHeight, paramioz.mWidth, 42) + ".yuv";
          ioz.saveTextureToRgbaBuffer(paramioz.aru, paramioz.mHeight, paramioz.mWidth, this.aW);
          b(this.aW, paramArrayOfByte);
        }
        if (paramioz.art != -1)
        {
          paramArrayOfByte = (String)localObject1 + "_rgbRotateCenterTextureId_" + d(paramioz.mHeight, paramioz.mWidth, 0) + ".jpg";
          ioz.d(paramioz.art, paramioz.mHeight, paramioz.mWidth, paramArrayOfByte);
        }
        if (paramioz.aU != null)
        {
          paramArrayOfByte = (String)localObject1 + "_i420Data_" + d(paramioz.mHeight, paramioz.mWidth, 17) + ".yuv";
          b(paramioz.aU, paramArrayOfByte);
        }
        else if (paramioz.aT != null)
        {
          paramArrayOfByte = (String)localObject1 + "_rgbaData_" + d(paramioz.mHeight, paramioz.mWidth, 42) + ".yuv";
          b(paramioz.aT, paramArrayOfByte);
        }
      }
    }
  }
  
  public void ape()
  {
    int j = 0;
    if (AudioHelper.jY(24) == 1) {
      if (this.mDebugMode) {
        return;
      }
    }
    for (this.mDebugMode = true;; this.mDebugMode = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "startOneChat debug[" + this.mDebugMode + "]");
      }
      Object localObject1 = null;
      Object localObject2;
      if (this.mDebugMode)
      {
        localObject1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
        localObject2 = new Date(System.currentTimeMillis());
        localObject2 = PE + ((SimpleDateFormat)localObject1).format((Date)localObject2);
        File localFile = new File((String)localObject2);
        if (localFile.exists())
        {
          localObject1 = localObject2;
          if (localFile.isDirectory()) {}
        }
        else
        {
          localObject1 = localObject2;
          if (!localFile.mkdirs())
          {
            this.mDebugMode = false;
            localObject1 = localObject2;
            if (QLog.isDevelopLevel())
            {
              QLog.i("FilterProcessTest", 4, "startOneChat mkdir fail path: " + (String)localObject2);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (!this.mDebugMode) {
        break;
      }
      int i = j;
      if (this.a == null)
      {
        this.a = new ipa.a[6];
        i = j;
      }
      while (i < this.a.length)
      {
        localObject2 = (String)localObject1 + aO[i];
        if (this.a[i] != null) {
          this.a[i].end();
        }
        this.a[i] = new ipa.a((String)localObject2);
        i += 1;
      }
      break;
      if (!this.mDebugMode) {
        break;
      }
      apf();
    }
  }
  
  public void apf()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FilterProcessTest", 2, "endOfOneChat");
    }
    if (!this.mDebugMode) {}
    for (;;)
    {
      return;
      if ((this.a != null) && (this.a.length > 0))
      {
        int i = 0;
        while (i < this.a.length)
        {
          if (this.a[i] != null)
          {
            this.a[i].end();
            this.a[i] = null;
          }
          i += 1;
        }
      }
    }
  }
  
  public void apg()
  {
    this.TR = TQ;
    if (this.TR)
    {
      this.arz = 0;
      Object localObject = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss/", Locale.getDefault());
      Date localDate = new Date(System.currentTimeMillis());
      this.PG = (PE + ((SimpleDateFormat)localObject).format(localDate));
      localObject = new File(this.PG);
      if (((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) && (!((File)localObject).mkdirs()))
      {
        this.TR = false;
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 2, "beginTestSaveData mkdir fail path: " + this.PG);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FilterProcessTest", 2, "beginTestSaveData path: " + this.PG);
      }
    }
  }
  
  public void aph()
  {
    if (this.TR) {
      AudioHelper.UB("图片已经保存在日志目录下\n" + this.PG);
    }
  }
  
  public void w(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.TR) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    int[] arrayOfInt = new int[1];
    GLES20.glBindFramebuffer(36160, paramInt2);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36048, arrayOfInt, 0);
    GLES20.glGetFramebufferAttachmentParameteriv(36160, 36064, 36049, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, 0);
    QLog.w("FilterProcessRender", 1, "logFrameBuffer, action[" + aL(paramInt1) + "], fbo[" + paramInt2 + "], textureid[" + paramInt3 + "], check[" + arrayOfInt[0] + "]");
  }
  
  static class a
  {
    private int arA;
    private FileOutputStream d;
    private int frameCount;
    private int mLastHeight;
    private int mLastWidth;
    private String path;
    private String prefix;
    
    public a(String paramString)
    {
      this.prefix = paramString;
      this.path = null;
      this.mLastWidth = 0;
      this.mLastHeight = 0;
      this.frameCount = 0;
      this.arA = 0;
    }
    
    private void close()
    {
      if (this.d != null) {}
      try
      {
        this.d.flush();
        try
        {
          this.d.close();
          this.d = null;
          return;
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.path, localThrowable1);
            }
          }
        }
        try
        {
          this.d.close();
          this.d = null;
          throw localObject;
        }
        catch (Throwable localThrowable4)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.path, localThrowable4);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2 = localThrowable2;
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 4, "DebugFile-save flush fail path: " + this.path, localThrowable2);
        }
        try
        {
          this.d.close();
          this.d = null;
          return;
        }
        catch (Throwable localThrowable3)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("FilterProcessTest", 4, "DebugFile-save close fail path: " + this.path, localThrowable3);
            }
          }
        }
      }
      finally {}
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt3 == 0)) {
        return;
      }
      if ((this.d == null) || (this.mLastWidth != paramInt2) || (this.mLastHeight != paramInt3) || (this.arA != paramInt1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 4, String.format("DebugFile-save pre_size[%s,%s], cur_size[%s,%s], pre_fmt[%s], cur_fmt[%s], count[%s]", new Object[] { Integer.valueOf(this.mLastWidth), Integer.valueOf(this.mLastHeight), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.arA), Integer.valueOf(paramInt1), Integer.valueOf(this.frameCount) }));
        }
        close();
        this.path = (this.prefix + "_" + ipa.d(paramInt2, paramInt3, paramInt1) + ".yuv");
        File localFile = new File(this.path);
        if ((localFile.exists()) && (localFile.isFile()) && (!localFile.delete()) && (QLog.isDevelopLevel())) {
          QLog.i("FilterProcessTest", 4, "DebugFile-save del fail path: " + this.path);
        }
      }
      try
      {
        this.d = new FileOutputStream(this.path);
        this.mLastWidth = paramInt2;
        this.mLastHeight = paramInt3;
        this.frameCount = 0;
        this.arA = paramInt1;
        this.frameCount += 1;
        ipa.b(this.d, paramArrayOfByte);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("FilterProcessTest", 4, "DebugFile-save create FileOutputStream fail path: " + this.path);
          }
        }
      }
    }
    
    public void end()
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FilterProcessTest", 4, String.format("DebugFile-end size[%s, %s], fmt[%s], frame[%s], path[%s]", new Object[] { Integer.valueOf(this.mLastWidth), Integer.valueOf(this.mLastHeight), Integer.valueOf(this.arA), Integer.valueOf(this.frameCount), this.path }));
      }
      close();
      this.mLastWidth = 0;
      this.mLastHeight = 0;
      this.frameCount = 0;
      this.arA = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipa
 * JD-Core Version:    0.7.0.1
 */