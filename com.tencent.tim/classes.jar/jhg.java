import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import java.lang.ref.WeakReference;

public class jhg
  extends jhf
{
  private jhg.a a;
  private Paint jdField_ap_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_ap_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  Rect aq = new Rect(0, 0, 0, 0);
  int azO = 10;
  int azP = 8;
  int azQ = 4;
  private Bitmap bz;
  private final int[] cO;
  private Canvas f = new Canvas();
  private long mStartTime = System.currentTimeMillis();
  
  public jhg(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat, jhg.a parama)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
    this.jdField_ap_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.cO = new int[] { paramInt1 / 6, paramInt1 / 5 };
    this.jdField_a_of_type_Jhg$a = parama;
    awq();
  }
  
  /* Error */
  private Bitmap O()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 111	jhg:jdField_a_of_type_Ijn	Lijn;
    //   7: getfield 117	ijn:l	Ljava/lang/CharSequence;
    //   10: checkcast 119	java/lang/String
    //   13: astore 9
    //   15: aload 9
    //   17: invokevirtual 123	java/lang/String:length	()I
    //   20: istore 6
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 96	jhg:jdField_a_of_type_Jhg$a	Ljhg$a;
    //   27: getfield 126	jhg$a:azS	I
    //   30: iload 6
    //   32: imul
    //   33: iload 6
    //   35: iconst_1
    //   36: isub
    //   37: aload_0
    //   38: getfield 49	jhg:azP	I
    //   41: imul
    //   42: iadd
    //   43: aload_0
    //   44: getfield 96	jhg:jdField_a_of_type_Jhg$a	Ljhg$a;
    //   47: getfield 126	jhg$a:azS	I
    //   50: getstatic 132	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   53: invokestatic 138	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   56: putfield 140	jhg:bz	Landroid/graphics/Bitmap;
    //   59: aload_0
    //   60: getfield 45	jhg:f	Landroid/graphics/Canvas;
    //   63: aload_0
    //   64: getfield 140	jhg:bz	Landroid/graphics/Bitmap;
    //   67: invokevirtual 144	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   70: aload_0
    //   71: getfield 96	jhg:jdField_a_of_type_Jhg$a	Ljhg$a;
    //   74: getfield 126	jhg$a:azS	I
    //   77: iconst_2
    //   78: idiv
    //   79: i2f
    //   80: fstore_2
    //   81: aload_0
    //   82: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   85: invokevirtual 148	android/graphics/Paint:getFontMetrics	()Landroid/graphics/Paint$FontMetrics;
    //   88: astore 10
    //   90: aload 10
    //   92: getfield 154	android/graphics/Paint$FontMetrics:ascent	F
    //   95: fstore_1
    //   96: aload 10
    //   98: getfield 157	android/graphics/Paint$FontMetrics:descent	F
    //   101: fload_1
    //   102: fadd
    //   103: fconst_2
    //   104: fdiv
    //   105: fstore_3
    //   106: aload_0
    //   107: getfield 51	jhg:azQ	I
    //   110: iconst_2
    //   111: idiv
    //   112: i2f
    //   113: fstore 4
    //   115: fload_2
    //   116: fstore_1
    //   117: iload 5
    //   119: iload 6
    //   121: if_icmpge +194 -> 315
    //   124: aload_0
    //   125: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   128: iconst_0
    //   129: invokevirtual 161	android/graphics/Paint:setAntiAlias	(Z)V
    //   132: aload_0
    //   133: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   136: getstatic 167	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   139: invokevirtual 171	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   142: aload_0
    //   143: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   146: iconst_m1
    //   147: invokevirtual 175	android/graphics/Paint:setColor	(I)V
    //   150: aload_0
    //   151: getfield 45	jhg:f	Landroid/graphics/Canvas;
    //   154: fload_1
    //   155: fload_2
    //   156: fload_2
    //   157: aload_0
    //   158: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   161: invokevirtual 179	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   164: aload_0
    //   165: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   168: iconst_1
    //   169: invokevirtual 161	android/graphics/Paint:setAntiAlias	(Z)V
    //   172: aload_0
    //   173: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   176: getstatic 182	android/graphics/Paint$Style:STROKE	Landroid/graphics/Paint$Style;
    //   179: invokevirtual 171	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   182: aload_0
    //   183: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   186: ldc 183
    //   188: invokevirtual 175	android/graphics/Paint:setColor	(I)V
    //   191: aload_0
    //   192: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   195: aload_0
    //   196: getfield 51	jhg:azQ	I
    //   199: i2f
    //   200: invokevirtual 187	android/graphics/Paint:setStrokeWidth	(F)V
    //   203: aload_0
    //   204: getfield 45	jhg:f	Landroid/graphics/Canvas;
    //   207: fload_1
    //   208: fload_2
    //   209: fload_2
    //   210: fload 4
    //   212: fsub
    //   213: aload_0
    //   214: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   217: invokevirtual 179	android/graphics/Canvas:drawCircle	(FFFLandroid/graphics/Paint;)V
    //   220: aload_0
    //   221: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   224: fconst_0
    //   225: invokevirtual 187	android/graphics/Paint:setStrokeWidth	(F)V
    //   228: aload_0
    //   229: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   232: getstatic 167	android/graphics/Paint$Style:FILL	Landroid/graphics/Paint$Style;
    //   235: invokevirtual 171	android/graphics/Paint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   238: aload_0
    //   239: getfield 45	jhg:f	Landroid/graphics/Canvas;
    //   242: aload 9
    //   244: iload 5
    //   246: iload 5
    //   248: iconst_1
    //   249: iadd
    //   250: fload_1
    //   251: fload_2
    //   252: fload_3
    //   253: fsub
    //   254: aload_0
    //   255: getfield 82	jhg:mPaint	Landroid/graphics/Paint;
    //   258: invokevirtual 191	android/graphics/Canvas:drawText	(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V
    //   261: aload_0
    //   262: getfield 96	jhg:jdField_a_of_type_Jhg$a	Ljhg$a;
    //   265: getfield 126	jhg$a:azS	I
    //   268: istore 7
    //   270: aload_0
    //   271: getfield 49	jhg:azP	I
    //   274: istore 8
    //   276: fload_1
    //   277: iload 7
    //   279: iload 8
    //   281: iadd
    //   282: i2f
    //   283: fadd
    //   284: fstore_1
    //   285: iload 5
    //   287: iconst_1
    //   288: iadd
    //   289: istore 5
    //   291: goto -174 -> 117
    //   294: astore 9
    //   296: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +16 -> 315
    //   302: aload_0
    //   303: getfield 201	jhg:TAG	Ljava/lang/String;
    //   306: iconst_2
    //   307: aload 9
    //   309: invokevirtual 205	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   312: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_0
    //   316: getfield 140	jhg:bz	Landroid/graphics/Bitmap;
    //   319: areturn
    //   320: astore 9
    //   322: invokestatic 197	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq -10 -> 315
    //   328: aload_0
    //   329: getfield 201	jhg:TAG	Ljava/lang/String;
    //   332: iconst_2
    //   333: aload 9
    //   335: invokevirtual 210	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   338: invokestatic 209	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -26 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	jhg
    //   95	190	1	f1	float
    //   80	172	2	f2	float
    //   105	148	3	f3	float
    //   113	98	4	f4	float
    //   1	289	5	i	int
    //   20	102	6	j	int
    //   268	14	7	k	int
    //   274	8	8	m	int
    //   13	230	9	str	String
    //   294	14	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   320	14	9	localException	java.lang.Exception
    //   88	9	10	localFontMetrics	android.graphics.Paint.FontMetrics
    // Exception table:
    //   from	to	target	type
    //   3	115	294	java/lang/OutOfMemoryError
    //   124	276	294	java/lang/OutOfMemoryError
    //   3	115	320	java/lang/Exception
    //   124	276	320	java/lang/Exception
  }
  
  private boolean xp()
  {
    return this.mCurrentX < this.azH / 2;
  }
  
  public Bitmap I()
  {
    if ((this.bd == null) || (this.bd.isRecycled()))
    {
      O();
      this.bd = H();
    }
    for (;;)
    {
      return this.bd;
      d(this.mCanvas, getWidth(), getHeight());
    }
  }
  
  public void a(jhg.a parama)
  {
    this.jdField_a_of_type_Jhg$a = parama;
  }
  
  void awq()
  {
    float f1 = 0.48F * this.hY;
    this.azO = ((int)(this.azO * f1));
    this.azP = ((int)(this.azP * f1));
    this.azQ = ((int)(f1 * this.azQ));
  }
  
  protected int b(Paint paramPaint, String paramString)
  {
    if (this.jdField_a_of_type_Ijn != null) {}
    for (int i = this.jdField_a_of_type_Ijn.l.length();; i = 0)
    {
      int j = this.jdField_a_of_type_Jhg$a.azR;
      int k = this.azO;
      int m = this.jdField_a_of_type_Jhg$a.azS;
      return (i - 1) * this.azP + (j + k + m * i);
    }
  }
  
  protected int c(Paint paramPaint)
  {
    this.mHeight = this.jdField_a_of_type_Jhg$a.azR;
    this.aq.right = this.mHeight;
    this.aq.bottom = this.mHeight;
    return this.mHeight;
  }
  
  protected int cF(int paramInt)
  {
    if (paramInt < 8) {
      return this.cO[0];
    }
    return this.cO[1];
  }
  
  protected void d(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    paramCanvas.drawPaint(this.jdField_ap_of_type_AndroidGraphicsPaint);
    paramCanvas.save();
    paramCanvas.clipRect(this.jdField_a_of_type_Jhg$a.azR / 2, 0, paramInt1, paramInt2);
    float f2 = this.jdField_a_of_type_Jhg$a.azR + this.azO;
    float f1 = f2;
    if (xp())
    {
      f1 = f2 - 100.0F * this.hY;
      f1 = (f2 - f1) * (this.mCurrentX * 2) / this.azH + f1;
    }
    paramCanvas.drawBitmap(this.bz, f1, (this.jdField_a_of_type_Jhg$a.azR - this.jdField_a_of_type_Jhg$a.azS) / 2, this.mPaint);
    paramCanvas.restore();
    Bitmap localBitmap = this.jdField_a_of_type_Jhg$a.f[((int)((l - this.mStartTime) / 200L % this.jdField_a_of_type_Jhg$a.f.length))];
    this.jdField_ap_of_type_AndroidGraphicsRect.right = localBitmap.getWidth();
    this.jdField_ap_of_type_AndroidGraphicsRect.bottom = localBitmap.getHeight();
    paramCanvas.drawBitmap(localBitmap, this.jdField_ap_of_type_AndroidGraphicsRect, this.aq, this.mPaint);
  }
  
  public int my()
  {
    return this.jdField_a_of_type_Jhg$a.azT;
  }
  
  void releaseBitmap()
  {
    super.releaseBitmap();
    if (this.bz != null)
    {
      if (!this.bz.isRecycled()) {
        this.bz.recycle();
      }
      this.bz = null;
    }
  }
  
  public static class a
  {
    int azR;
    int azS;
    int azT;
    Bitmap[] f;
    
    public a(Bitmap[] paramArrayOfBitmap, int paramInt1, int paramInt2, int paramInt3)
    {
      this.f = paramArrayOfBitmap;
      this.azR = paramInt1;
      this.azS = paramInt2;
      this.azT = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhg
 * JD-Core Version:    0.7.0.1
 */