package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GlUtil
{
  public static final int NO_TEXTURE = -1;
  private static final int SIZEOF_FLOAT = 4;
  private static final String TAG = "GlUtil";
  
  public static Bitmap captureFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    Object localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    GLES20.glBindFramebuffer(36160, localObject[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
    localObject[0] = 0;
    localByteBuffer.position(0);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    return localObject;
  }
  
  public static Bitmap captureFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = ByteBuffer.allocate(paramInt2 * paramInt3 * 4);
    Object localObject1 = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject1, 0);
    GLES20.glBindFramebuffer(36160, localObject1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, (Buffer)localObject2);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject1, 0);
    localObject1[0] = 0;
    ((ByteBuffer)localObject2).position(0);
    localObject1 = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject1).copyPixelsFromBuffer((Buffer)localObject2);
    localObject2 = new Matrix();
    ((Matrix)localObject2).postRotate(paramInt4);
    ((Matrix)localObject2).postScale(1.0F, -1.0F);
    localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, paramInt2, paramInt3, (Matrix)localObject2, true);
    ((Bitmap)localObject1).recycle();
    return localObject2;
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.e("GlUtil", paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  public static int createComputeProgram(String paramString)
  {
    int i = loadShader(37305, paramString);
    if (i == 0) {
      return 0;
    }
    int j = GLES20.glCreateProgram();
    checkGlError("createComputeProgram");
    if (j == 0) {
      Log.e("GlUtil", "Could not create ComputeProgram");
    }
    GLES20.glAttachShader(j, i);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(j);
    paramString = new int[1];
    GLES20.glGetProgramiv(j, 35714, paramString, 0);
    if (paramString[0] != 1)
    {
      Log.e("GlUtil", "Could not link ComputeProgram: ");
      Log.e("GlUtil", GLES20.glGetProgramInfoLog(j));
      GLES20.glDeleteProgram(j);
      return 0;
    }
    return j;
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    localByteBuffer.order(paramByteOrder);
    paramByteOrder = localByteBuffer.asFloatBuffer();
    paramByteOrder.put(paramArrayOfFloat);
    paramByteOrder.position(0);
    return paramByteOrder;
  }
  
  public static IntBuffer createIntBuffer(int[] paramArrayOfInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfInt.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asIntBuffer();
    ((IntBuffer)localObject).put(paramArrayOfInt);
    ((IntBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    checkGlError("glCreateProgram");
    if (k == 0) {
      Log.e("GlUtil", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("GlUtil", "Could not link program: ");
      Log.e("GlUtil", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static int createTexture(int paramInt)
  {
    return createTexture(paramInt, null, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt, Bitmap paramBitmap)
  {
    return createTexture(paramInt, paramBitmap, 9729, 9729, 33071, 33071);
  }
  
  public static int createTexture(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    checkGlError("glGenTextures");
    GLES20.glBindTexture(paramInt1, arrayOfInt[0]);
    checkGlError("glBindTexture " + arrayOfInt[0]);
    GLES20.glTexParameterf(paramInt1, 10241, paramInt2);
    GLES20.glTexParameterf(paramInt1, 10240, paramInt3);
    GLES20.glTexParameteri(paramInt1, 10242, paramInt4);
    GLES20.glTexParameteri(paramInt1, 10243, paramInt5);
    if (paramBitmap != null) {
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    }
    checkGlError("glTexParameter");
    return arrayOfInt[0];
  }
  
  @TargetApi(18)
  public static int createTextureAllocate(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = createTexture(3553);
    if (paramBoolean) {
      GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      return i;
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
  }
  
  public static void deleteTexture(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("GlUtil", "Could not compile shader " + paramInt + ":");
      Log.e("GlUtil", " " + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  /* Error */
  public static String readTextFromRawResource(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: new 96	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 297	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   13: iload_1
    //   14: invokevirtual 303	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   17: astore 4
    //   19: new 305	java/io/InputStreamReader
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 308	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: astore_3
    //   29: new 310	java/io/BufferedReader
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 313	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 316	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +73 -> 117
    //   47: aload 5
    //   49: aload_0
    //   50: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: bipush 10
    //   58: invokevirtual 319	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -24 -> 38
    //   65: astore_0
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 322	java/io/BufferedReader:close	()V
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   82: aload 4
    //   84: ifnull +8 -> 92
    //   87: aload 4
    //   89: invokevirtual 326	java/io/InputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   99: goto -25 -> 74
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   107: goto -25 -> 82
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 322	java/io/BufferedReader:close	()V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 326	java/io/InputStream:close	()V
    //   143: aload 5
    //   145: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   154: goto -29 -> 125
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   162: goto -29 -> 133
    //   165: astore_0
    //   166: aload_0
    //   167: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   170: goto -27 -> 143
    //   173: astore_0
    //   174: aconst_null
    //   175: astore_3
    //   176: aconst_null
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 322	java/io/BufferedReader:close	()V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 323	java/io/InputStreamReader:close	()V
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 326	java/io/InputStream:close	()V
    //   207: aload_0
    //   208: athrow
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   214: goto -25 -> 189
    //   217: astore_2
    //   218: aload_2
    //   219: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   222: goto -25 -> 197
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 329	java/io/IOException:printStackTrace	()V
    //   230: goto -23 -> 207
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore_2
    //   238: goto -57 -> 181
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_2
    //   244: goto -63 -> 181
    //   247: astore_0
    //   248: goto -67 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramContext	android.content.Context
    //   0	251	1	paramInt	int
    //   37	149	2	localBufferedReader	java.io.BufferedReader
    //   209	2	2	localIOException1	java.io.IOException
    //   217	2	2	localIOException2	java.io.IOException
    //   225	2	2	localIOException3	java.io.IOException
    //   237	7	2	localObject	Object
    //   28	208	3	localInputStreamReader	java.io.InputStreamReader
    //   17	186	4	localInputStream	java.io.InputStream
    //   7	137	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	65	java/io/IOException
    //   47	62	65	java/io/IOException
    //   70	74	94	java/io/IOException
    //   78	82	102	java/io/IOException
    //   87	92	110	java/io/IOException
    //   121	125	149	java/io/IOException
    //   129	133	157	java/io/IOException
    //   138	143	165	java/io/IOException
    //   9	19	173	finally
    //   185	189	209	java/io/IOException
    //   193	197	217	java/io/IOException
    //   202	207	225	java/io/IOException
    //   19	29	233	finally
    //   29	38	241	finally
    //   38	43	247	finally
    //   47	62	247	finally
  }
  
  public static byte[] saveTextureToRgbaBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[paramInt2 * paramInt3 * 4];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    arrayOfInt[0] = 0;
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil
 * JD-Core Version:    0.7.0.1
 */