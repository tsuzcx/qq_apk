package com.tencent.av.opengl.texture;

import android.content.Context;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import iof;
import ipm;
import ipp;
import iqi;
import iqk;
import irc;
import java.lang.ref.WeakReference;
import jkn;

public abstract class YUVTexture
  extends iqk
{
  public static float[] ab = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  static boolean soloaded;
  private final String TAG;
  boolean TY = false;
  boolean TZ = true;
  volatile boolean Ua = true;
  private boolean Ub = true;
  private a jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a;
  private b jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$b;
  private iof jdField_a_of_type_Iof;
  protected float[] ac = { 1.0F, 1.0F, 1.0F, 0.0F, 0.00093F, -0.3437F, 1.77216F, 0.0F, 1.401687F, -0.71417F, 0.00099F, 0.0F, -0.7011F, 0.525F, -0.8828F, 1.0F };
  protected int arZ = -1;
  protected int arq;
  public int asa = -1;
  private long mA;
  private long mB;
  public float mBrightness = 1.2F;
  private long mC;
  protected Context mContext;
  public float mContrast = 1.93F;
  private long mD;
  private long mE;
  private long mNativeContext;
  
  public YUVTexture(Context paramContext, String paramString, long paramLong)
  {
    super(null, 0);
    this.mContext = paramContext;
    this.TZ = jkn.xK();
    QLog.d("YUVTexture", 1, "ray debug,YUVTexture, initial from config,upLoadWhenGetNewData = " + this.TZ);
    if (AudioHelper.jY(22) == 1) {
      this.TZ = true;
    }
    for (;;)
    {
      QLog.d("YUVTexture", 1, "ray debug,YUVTexture, initial upLoadWhenGetNewData = " + this.TZ);
      this.arV = 1;
      if (!soloaded) {}
      try
      {
        SoLoadUtil.loadNativeLibrary(paramContext, "xplatform", 0, false);
        soloaded = true;
        Looper localLooper1 = Looper.myLooper();
        if (localLooper1 != null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a = new a(localLooper1);
        }
        try
        {
          if (soloaded) {
            Init(irc.getGLVersion(paramContext), new WeakReference(this), paramLong);
          }
          return;
        }
        catch (Exception paramContext)
        {
          Looper localLooper2;
          paramContext.printStackTrace();
          return;
        }
        catch (Error paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        finally
        {
          this.TAG = (getClass().getSimpleName() + "_" + paramString + "_0x" + Long.toHexString(this.mNativeContext));
        }
        if (AudioHelper.jY(22) != 0) {
          continue;
        }
        this.TZ = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          continue;
          localLooper2 = Looper.getMainLooper();
          if (localLooper2 != null) {
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a = new a(localLooper2);
          } else {
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a = null;
          }
        }
      }
    }
  }
  
  static void onNativeNotify(Object paramObject1, int paramInt, Object paramObject2)
  {
    paramObject1 = (YUVTexture)((WeakReference)paramObject1).get();
    if (paramObject1 != null)
    {
      if (paramInt != 0) {
        break label40;
      }
      if (AudioHelper.cTR) {
        paramObject1.mC = System.currentTimeMillis();
      }
      paramObject1.a(0, 0, paramObject2);
    }
    label40:
    do
    {
      return;
      if (paramInt == 2)
      {
        if (AudioHelper.cTR) {
          paramObject1.mD = System.currentTimeMillis();
        }
        paramObject1.a(2, 0, paramObject2);
        return;
      }
      if (paramInt == 1)
      {
        if (AudioHelper.cTR) {
          paramObject1.mE = System.currentTimeMillis();
        }
        paramObject1.a(1, 0, paramObject2);
        return;
      }
    } while (paramInt != 3);
    if (AudioHelper.cTR) {
      paramObject1.mB = System.currentTimeMillis();
    }
    paramObject1.a(3, 0, paramObject2);
  }
  
  private native int uploadContent(int[] paramArrayOfInt);
  
  public byte[] A()
  {
    return getFaceFeature();
  }
  
  /* Error */
  public int I(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 3553
    //   3: iload_2
    //   4: invokestatic 249	android/opengl/GLES20:glBindTexture	(II)V
    //   7: sipush 3553
    //   10: sipush 10241
    //   13: ldc 250
    //   15: invokestatic 254	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   18: sipush 3553
    //   21: sipush 10240
    //   24: ldc 255
    //   26: invokestatic 254	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   29: sipush 3553
    //   32: sipush 10242
    //   35: ldc_w 256
    //   38: invokestatic 254	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   41: sipush 3553
    //   44: sipush 10243
    //   47: ldc_w 256
    //   50: invokestatic 254	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   53: aload_0
    //   54: getfield 87	com/tencent/av/opengl/texture/YUVTexture:mContext	Landroid/content/Context;
    //   57: invokevirtual 262	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   60: iload_1
    //   61: invokevirtual 268	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   64: astore_3
    //   65: aload_3
    //   66: invokestatic 274	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   69: astore 4
    //   71: aload_3
    //   72: invokevirtual 279	java/io/InputStream:close	()V
    //   75: aload 4
    //   77: ifnull +61 -> 138
    //   80: sipush 3553
    //   83: iconst_0
    //   84: aload 4
    //   86: iconst_0
    //   87: invokestatic 285	android/opengl/GLUtils:texImage2D	(IILandroid/graphics/Bitmap;I)V
    //   90: aload 4
    //   92: invokevirtual 290	android/graphics/Bitmap:recycle	()V
    //   95: iload_2
    //   96: ireturn
    //   97: astore_3
    //   98: aload_3
    //   99: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   102: goto -27 -> 75
    //   105: astore 4
    //   107: aload_3
    //   108: invokevirtual 279	java/io/InputStream:close	()V
    //   111: iconst_m1
    //   112: ireturn
    //   113: astore_3
    //   114: aload_3
    //   115: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore 4
    //   123: aload_3
    //   124: invokevirtual 279	java/io/InputStream:close	()V
    //   127: aload 4
    //   129: athrow
    //   130: astore_3
    //   131: aload_3
    //   132: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   135: goto -8 -> 127
    //   138: iconst_m1
    //   139: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	YUVTexture
    //   0	140	1	paramInt1	int
    //   0	140	2	paramInt2	int
    //   64	8	3	localInputStream	java.io.InputStream
    //   97	11	3	localIOException1	java.io.IOException
    //   113	11	3	localIOException2	java.io.IOException
    //   130	2	3	localIOException3	java.io.IOException
    //   69	22	4	localBitmap	android.graphics.Bitmap
    //   105	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   121	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   71	75	97	java/io/IOException
    //   65	71	105	java/lang/OutOfMemoryError
    //   107	111	113	java/io/IOException
    //   65	71	121	finally
    //   123	127	130	java/io/IOException
  }
  
  native void Init(int paramInt, Object paramObject, long paramLong);
  
  native void Uninit();
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a != null)
    {
      paramObject = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a.obtainMessage(paramInt1, 0, 0, paramObject);
      if (paramInt2 == 0) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a.sendMessage(paramObject);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$a.sendMessageDelayed(paramObject, paramInt2);
      return;
    }
    QLog.e(this.TAG, 2, "notifyUpdateUI|mEventHandler == null");
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$b = paramb;
  }
  
  public boolean a(ipm paramipm)
  {
    if (AudioHelper.cTR) {
      this.mA = System.currentTimeMillis();
    }
    int i;
    if (!isLoaded())
    {
      if (this.mId == null) {
        this.mId = new int[3];
      }
      i = 0;
      while (i < this.mId.length)
      {
        this.mId[i] = paramipm.a().generateTexture();
        i += 1;
      }
    }
    for (int j = 1;; j = 0)
    {
      TextureProgram localTextureProgram = a();
      if (this.Ub) {
        if (this.TZ)
        {
          if (!this.Ua) {
            break label293;
          }
          this.Ua = false;
          i = 1;
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0)) {
          apw();
        }
        for (i = uploadContent(this.mId);; i = -1)
        {
          if (i != -1) {
            this.arZ = i;
          }
          for (;;)
          {
            if (this.arZ != -1) {
              GLES20.glUniform1i(localTextureProgram.a()[10].handle, this.arZ);
            }
            this.mState = 1;
            if ((this.TY) && (this.asa == -1))
            {
              this.asa = paramipm.a().generateTexture();
              this.asa = I(2130840641, this.asa);
            }
            if (this.arZ == -1) {
              break label286;
            }
            return true;
            i = 1;
            break;
            if (QLog.isColorLevel()) {
              QLog.w(this.TAG, 2, "onBind, uploadContent fail, mYuvFormat[" + this.arZ + "], isBind[" + this.Ub + "]");
            }
          }
          label286:
          return false;
        }
        label293:
        i = 0;
      }
    }
  }
  
  public iqi[] a(ipm paramipm)
  {
    TextureProgram localTextureProgram = a();
    paramipm = super.a(paramipm);
    try
    {
      GLES20.glUniform1f(localTextureProgram.a()[7].handle, getImgWidth());
      GLES20.glUniform1f(localTextureProgram.a()[8].handle, getImgHeight());
      GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].handle, 1, false, this.ac, 0);
      if ((this.TY) && (this.asa != -1))
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glActiveTexture(33987);
        irc.lx();
        GLES20.glBindTexture(getTarget(), this.asa);
        irc.lx();
        GLES20.glUniform1i(localTextureProgram.a()[11].handle, 3);
        irc.lx();
        GLES20.glUniform1i(localTextureProgram.a()[12].handle, 1);
        irc.lx();
      }
      return paramipm;
    }
    catch (Exception localException) {}
    return paramipm;
  }
  
  public void apw()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$b != null)
    {
      byte[] arrayOfByte = getFaceFeature();
      if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture$b.E(arrayOfByte);
      }
    }
  }
  
  public native boolean canRender();
  
  public native void flush(boolean paramBoolean);
  
  native byte[] getCaptureFrameTexture();
  
  native byte[] getFaceFeature();
  
  native byte[] getFrameTexture();
  
  public native int getImgAngle();
  
  public native int getImgHeight();
  
  public native int getImgWidth();
  
  public int getTarget()
  {
    return 3553;
  }
  
  native int getcaptureFrameHeight();
  
  native int getcaptureFrameWidth();
  
  public String hb()
  {
    long l6 = System.currentTimeMillis();
    long l1 = -1L;
    if (this.mA != 0L) {
      l1 = l6 - this.mA;
    }
    long l2 = -1L;
    if (this.mB != 0L) {
      l2 = l6 - this.mB;
    }
    long l3 = -1L;
    if (this.mC != 0L) {
      l3 = l6 - this.mC;
    }
    long l4 = -1L;
    if (this.mD != 0L) {
      l4 = l6 - this.mD;
    }
    long l5 = -1L;
    if (this.mE != 0L) {
      l5 = l6 - this.mE;
    }
    return "TAG[" + this.TAG + "], onBindTime[" + l1 + "], MSG_SHOW[" + l2 + "], MSG_RENDER[" + l4 + "], MSG_RESET[" + l3 + "], MSG_FLUSH[" + l5 + "], isBind[" + vf() + "], Source[" + getSourceWidth() + ", " + getSourceHeight() + "], ImgAngle[" + lv() + "]";
  }
  
  public void iG(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "setIsBind, old[%s], new[%s]", Boolean.valueOf(this.Ub), Boolean.valueOf(paramBoolean) });
    }
    this.Ub = paramBoolean;
  }
  
  public boolean isOpaque()
  {
    return true;
  }
  
  public int ls()
  {
    return getcaptureFrameWidth();
  }
  
  public int lt()
  {
    return getcaptureFrameHeight();
  }
  
  public int lv()
  {
    if (this.Ub) {}
    try
    {
      this.arq = getImgAngle();
      return this.arq;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public int lw()
  {
    return this.arZ;
  }
  
  public native void onPause();
  
  public native void onResume();
  
  public native boolean updateCurFrame();
  
  public boolean vf()
  {
    return this.Ub;
  }
  
  public byte[] y()
  {
    return getFrameTexture();
  }
  
  public byte[] z()
  {
    return getCaptureFrameTexture();
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      YUVTexture.this.Ua = true;
      switch (i)
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (YUVTexture.a(YUVTexture.this) == null);
            YUVTexture.a(YUVTexture.this).onRenderFrame();
            return;
          } while (YUVTexture.a(YUVTexture.this) == null);
          YUVTexture.a(YUVTexture.this).onRenderReset();
          return;
        } while (YUVTexture.a(YUVTexture.this) == null);
        YUVTexture.a(YUVTexture.this).onRenderFlush();
        return;
      } while (YUVTexture.a(YUVTexture.this) == null);
      if (YUVTexture.a(YUVTexture.this) == null) {
        YUVTexture.a(YUVTexture.this, new iof('=', ';'));
      }
      paramMessage = (String)paramMessage.obj;
      YUVTexture.a(YUVTexture.this).unflatten(paramMessage);
      i = YUVTexture.a(YUVTexture.this).getInt("width");
      int j = YUVTexture.a(YUVTexture.this).getInt("height");
      int k = YUVTexture.a(YUVTexture.this).getInt("angle");
      int m = YUVTexture.a(YUVTexture.this).getInt("rotation", -1);
      YUVTexture.a(YUVTexture.this).j(i, j, k, m);
    }
  }
  
  public static abstract interface b
  {
    public abstract void E(byte[] paramArrayOfByte);
    
    public abstract void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onRenderFlush();
    
    public abstract void onRenderFrame();
    
    public abstract void onRenderReset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YUVTexture
 * JD-Core Version:    0.7.0.1
 */