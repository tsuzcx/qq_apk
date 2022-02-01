import android.graphics.Bitmap;
import android.graphics.Matrix;

public class akyi
{
  boolean aGB;
  boolean cvq = false;
  boolean cvr = false;
  int mDegree;
  int mMaxSize;
  int mMinSize;
  float mRatio;
  
  public akyi(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMaxSize = paramInt1;
    this.mMinSize = paramInt2;
    this.mRatio = (this.mMaxSize / this.mMinSize);
    this.mDegree = paramInt3;
    if ((paramInt3 != 0) && (paramInt3 % 90 == 0)) {
      this.aGB = true;
    }
  }
  
  private Bitmap M(Bitmap paramBitmap)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap = paramBitmap;
    int i;
    if (this.aGB)
    {
      localMatrix.postRotate(this.mDegree, j >> 1, k >> 1);
      i = j;
    }
    try
    {
      if (j > paramBitmap.getWidth()) {
        i = paramBitmap.getWidth();
      }
      j = k;
      if (k > paramBitmap.getHeight()) {
        j = paramBitmap.getHeight();
      }
      localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramBitmap.recycle();
      localOutOfMemoryError.printStackTrace();
      log("keepSide", "createBitmap OutOfMemoryError");
    }
    return null;
  }
  
  private boolean d(Bitmap paramBitmap)
  {
    if (e(paramBitmap))
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      if ((i > this.mMaxSize) || (j > this.mMaxSize)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean e(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    return (i > j * this.mRatio) || (j > i * this.mRatio);
  }
  
  /* Error */
  private Bitmap n(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 44	android/graphics/Bitmap:getWidth	()I
    //   4: istore 5
    //   6: aload_1
    //   7: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   10: istore 6
    //   12: new 49	android/graphics/Matrix
    //   15: dup
    //   16: invokespecial 50	android/graphics/Matrix:<init>	()V
    //   19: astore 8
    //   21: aload_1
    //   22: astore 7
    //   24: aload_0
    //   25: getfield 33	akyi:aGB	Z
    //   28: ifeq +67 -> 95
    //   31: aload 8
    //   33: aload_0
    //   34: getfield 31	akyi:mDegree	I
    //   37: i2f
    //   38: iload 5
    //   40: iconst_1
    //   41: ishr
    //   42: i2f
    //   43: iload 6
    //   45: iconst_1
    //   46: ishr
    //   47: i2f
    //   48: invokevirtual 54	android/graphics/Matrix:postRotate	(FFF)Z
    //   51: pop
    //   52: iload 5
    //   54: aload_1
    //   55: invokevirtual 44	android/graphics/Bitmap:getWidth	()I
    //   58: if_icmple +198 -> 256
    //   61: aload_1
    //   62: invokevirtual 44	android/graphics/Bitmap:getWidth	()I
    //   65: istore_2
    //   66: iload 6
    //   68: aload_1
    //   69: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   72: if_icmple +177 -> 249
    //   75: aload_1
    //   76: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   79: istore 4
    //   81: aload_1
    //   82: iconst_0
    //   83: iconst_0
    //   84: iload_2
    //   85: iload 4
    //   87: aload 8
    //   89: iconst_1
    //   90: invokestatic 58	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   93: astore 7
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 21	akyi:cvq	Z
    //   100: iload_3
    //   101: i2f
    //   102: aload_0
    //   103: getfield 29	akyi:mRatio	F
    //   106: fmul
    //   107: f2i
    //   108: istore 4
    //   110: iload 5
    //   112: iload 6
    //   114: if_icmple +88 -> 202
    //   117: iload 4
    //   119: istore_2
    //   120: aload_0
    //   121: getfield 31	akyi:mDegree	I
    //   124: bipush 90
    //   126: idiv
    //   127: iconst_2
    //   128: irem
    //   129: ifeq +109 -> 238
    //   132: iload_3
    //   133: istore 4
    //   135: iload_3
    //   136: aload 7
    //   138: invokevirtual 44	android/graphics/Bitmap:getWidth	()I
    //   141: if_icmple +10 -> 151
    //   144: aload 7
    //   146: invokevirtual 44	android/graphics/Bitmap:getWidth	()I
    //   149: istore 4
    //   151: iload_2
    //   152: istore_3
    //   153: iload_2
    //   154: aload 7
    //   156: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   159: if_icmple +9 -> 168
    //   162: aload 7
    //   164: invokevirtual 47	android/graphics/Bitmap:getHeight	()I
    //   167: istore_3
    //   168: aload 7
    //   170: iconst_0
    //   171: iconst_0
    //   172: iload 4
    //   174: iload_3
    //   175: invokestatic 82	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   178: astore_1
    //   179: aload_1
    //   180: areturn
    //   181: astore 7
    //   183: aload_1
    //   184: invokevirtual 61	android/graphics/Bitmap:recycle	()V
    //   187: aload 7
    //   189: invokevirtual 64	java/lang/OutOfMemoryError:printStackTrace	()V
    //   192: aload_0
    //   193: ldc 84
    //   195: ldc 86
    //   197: invokevirtual 72	akyi:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aconst_null
    //   201: areturn
    //   202: iload_3
    //   203: istore_2
    //   204: iload 4
    //   206: istore_3
    //   207: goto -87 -> 120
    //   210: astore_1
    //   211: aload 7
    //   213: invokevirtual 90	android/graphics/Bitmap:isRecycled	()Z
    //   216: ifne +8 -> 224
    //   219: aload 7
    //   221: invokevirtual 61	android/graphics/Bitmap:recycle	()V
    //   224: aload_1
    //   225: invokevirtual 64	java/lang/OutOfMemoryError:printStackTrace	()V
    //   228: aload_0
    //   229: ldc 92
    //   231: ldc 86
    //   233: invokevirtual 72	akyi:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aconst_null
    //   237: areturn
    //   238: iload_2
    //   239: istore 4
    //   241: iload_3
    //   242: istore_2
    //   243: iload 4
    //   245: istore_3
    //   246: goto -114 -> 132
    //   249: iload 6
    //   251: istore 4
    //   253: goto -172 -> 81
    //   256: iload 5
    //   258: istore_2
    //   259: goto -193 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	akyi
    //   0	262	1	paramBitmap	Bitmap
    //   0	262	2	paramInt1	int
    //   0	262	3	paramInt2	int
    //   79	173	4	i	int
    //   4	253	5	j	int
    //   10	240	6	k	int
    //   22	147	7	localBitmap	Bitmap
    //   181	39	7	localOutOfMemoryError	OutOfMemoryError
    //   19	69	8	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   52	66	181	java/lang/OutOfMemoryError
    //   66	81	181	java/lang/OutOfMemoryError
    //   81	95	181	java/lang/OutOfMemoryError
    //   120	132	210	java/lang/OutOfMemoryError
    //   135	151	210	java/lang/OutOfMemoryError
    //   153	168	210	java/lang/OutOfMemoryError
    //   168	179	210	java/lang/OutOfMemoryError
  }
  
  public Bitmap K(Bitmap paramBitmap)
  {
    if (d(paramBitmap)) {
      paramBitmap = L(paramBitmap);
    }
    for (;;)
    {
      if (paramBitmap == null) {
        return paramBitmap;
      }
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k;
      if (j > i)
      {
        k = j;
        j = i;
      }
      while (e(paramBitmap))
      {
        return n(paramBitmap, k, j);
        k = i;
      }
      if (k > this.mMaxSize) {
        return m(paramBitmap, k, j);
      }
      return M(paramBitmap);
    }
  }
  
  Bitmap L(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int i;
    int j;
    if (k > m)
    {
      i = m;
      j = (int)(i * this.mRatio);
      if (k <= m) {
        break label90;
      }
    }
    for (;;)
    {
      k = j;
      try
      {
        if (j > paramBitmap.getWidth()) {
          k = paramBitmap.getWidth();
        }
        j = i;
        if (i > paramBitmap.getHeight()) {
          j = paramBitmap.getHeight();
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, k, j);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramBitmap.recycle();
        localOutOfMemoryError.printStackTrace();
        log("clipBigImg", "createBitmap OutOfMemoryError");
      }
      i = k;
      break;
      label90:
      k = i;
      i = j;
      j = k;
    }
    return null;
  }
  
  void log(String paramString1, String paramString2)
  {
    akxe.b("ClipStrategy", paramString1, paramString2);
  }
  
  Bitmap m(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt2 = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    Object localObject = new Matrix();
    this.cvr = true;
    float f = this.mMaxSize / (paramInt1 * 1.0F);
    if (this.aGB) {
      ((Matrix)localObject).postRotate(this.mDegree, paramInt2 >> 1, i >> 1);
    }
    ((Matrix)localObject).postScale(f, f);
    paramInt1 = paramInt2;
    try
    {
      if (paramInt2 > paramBitmap.getWidth()) {
        paramInt1 = paramBitmap.getWidth();
      }
      paramInt2 = i;
      if (i > paramBitmap.getHeight()) {
        paramInt2 = paramBitmap.getHeight();
      }
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, (Matrix)localObject, true);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramBitmap.recycle();
      localOutOfMemoryError.printStackTrace();
      log("clipLongSide", "createBitmap OutOfMemoryError");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyi
 * JD-Core Version:    0.7.0.1
 */