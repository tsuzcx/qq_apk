import android.opengl.GLSurfaceView.Renderer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class aiyo
  implements GLSurfaceView.Renderer
{
  private aixy jdField_a_of_type_Aixy;
  private aiyo.a jdField_a_of_type_Aiyo$a;
  private aiyo.a b;
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLRender", 2, "func copyFrame2Render begins, datas:" + paramArrayOfByte1);
    }
    if (this.b == null) {
      this.b = new aiyo.a();
    }
    if (this.b.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean)) {}
    try
    {
      this.jdField_a_of_type_Aiyo$a = null;
      this.jdField_a_of_type_Aiyo$a = this.b;
      if (QLog.isColorLevel()) {
        QLog.d("GLRender", 2, "func copyFrame2Render ends, mCurData:" + this.jdField_a_of_type_Aiyo$a);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 26
    //   10: iconst_2
    //   11: new 28	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   18: ldc 64
    //   20: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: getfield 66	aiyo:jdField_a_of_type_Aixy	Laixy;
    //   44: ifnonnull +52 -> 96
    //   47: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +43 -> 93
    //   53: ldc 26
    //   55: iconst_2
    //   56: new 28	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   63: ldc 68
    //   65: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   72: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: ldc 70
    //   77: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_0
    //   81: getfield 66	aiyo:jdField_a_of_type_Aixy	Laixy;
    //   84: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 66	aiyo:jdField_a_of_type_Aixy	Laixy;
    //   100: aload_0
    //   101: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   104: getfield 74	aiyo$a:eL	[B
    //   107: aload_0
    //   108: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   111: getfield 77	aiyo$a:eM	[B
    //   114: aload_0
    //   115: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   118: getfield 81	aiyo$a:dgX	I
    //   121: aload_0
    //   122: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   125: getfield 84	aiyo$a:dgY	I
    //   128: aload_0
    //   129: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   132: getfield 87	aiyo$a:dgV	I
    //   135: aload_0
    //   136: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   139: getfield 90	aiyo$a:dgW	I
    //   142: aload_0
    //   143: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   146: getfield 94	aiyo$a:xc	F
    //   149: aload_0
    //   150: getfield 56	aiyo:jdField_a_of_type_Aiyo$a	Laiyo$a;
    //   153: getfield 98	aiyo$a:cmG	Z
    //   156: invokevirtual 102	aixy:a	([B[BIIIIFZ)V
    //   159: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq -69 -> 93
    //   165: ldc 26
    //   167: iconst_2
    //   168: ldc 104
    //   170: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: goto -80 -> 93
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   186: goto -27 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	aiyo
    //   0	189	1	paramGL10	GL10
    // Exception table:
    //   from	to	target	type
    //   2	33	176	finally
    //   33	47	176	finally
    //   47	93	176	finally
    //   96	159	176	finally
    //   159	173	176	finally
    //   182	186	176	finally
    //   96	159	181	java/lang/Throwable
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLRender", 2, "func onSurfaceCreated begins");
    }
    try
    {
      this.jdField_a_of_type_Aixy = new aixy();
      this.jdField_a_of_type_Aiyo$a = null;
      paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("GLRender", 2, "func onSurfaceCreated ends");
      }
      return;
    }
    finally {}
  }
  
  class a
  {
    public boolean cmG;
    public int dgV;
    public int dgW;
    public int dgX;
    public int dgY;
    public byte[] eL;
    public byte[] eM;
    public float xc;
    
    a() {}
    
    public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
    {
      if (paramArrayOfByte1 != null)
      {
        if (this.eL != null) {
          break label28;
        }
        this.eL = new byte[paramArrayOfByte1.length];
        if (this.eL != null) {
          break label49;
        }
      }
      for (;;)
      {
        return false;
        label28:
        if (this.eL.length == paramArrayOfByte1.length) {
          break;
        }
        this.eL = new byte[paramArrayOfByte1.length];
        break;
        label49:
        System.arraycopy(paramArrayOfByte1, 0, this.eL, 0, paramArrayOfByte1.length);
        if (this.eM == null) {
          this.eM = new byte[paramArrayOfByte2.length];
        }
        while (this.eM != null)
        {
          System.arraycopy(paramArrayOfByte2, 0, this.eM, 0, paramArrayOfByte2.length);
          this.dgV = paramInt3;
          this.dgW = paramInt4;
          this.dgX = paramInt1;
          this.dgY = paramInt2;
          this.xc = paramFloat;
          this.cmG = paramBoolean;
          return true;
          if (this.eM.length != paramArrayOfByte2.length) {
            this.eM = new byte[paramArrayOfByte2.length];
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyo
 * JD-Core Version:    0.7.0.1
 */