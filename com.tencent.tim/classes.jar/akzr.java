import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class akzr
  extends akzb
{
  akzb jdField_a_of_type_Akzb;
  akzw jdField_a_of_type_Akzw;
  public alad a;
  RectF ax;
  akzb b;
  public int cJX;
  public int dqA;
  int dqB;
  int dqC;
  private int dqz;
  public int endY;
  public boolean mAnimating;
  public Context mContext;
  public long mDuration;
  private Interpolator mInterpolator;
  public View mParentView;
  public long mStartTime;
  public int mState;
  public int offsetY;
  public int startY;
  
  public void Lw(int paramInt)
  {
    float f1 = 1.0F * paramInt / this.dqC;
    float f2 = this.dqB - this.dqC;
    this.y = paramInt;
    if (this.jdField_a_of_type_Akzb != null) {
      this.jdField_a_of_type_Akzb.height = ((int)(f1 * f2) + paramInt);
    }
    if (this.jdField_a_of_type_Akzw != null) {
      this.jdField_a_of_type_Akzw.y = paramInt;
    }
    if (this.b != null) {
      this.b.y = (this.height + paramInt + this.dqz);
    }
    if (this.jdField_a_of_type_Alad != null) {
      this.jdField_a_of_type_Alad.setPoint(this.x + this.width / 2, this.y);
    }
  }
  
  public RectF a(int paramInt)
  {
    float f = this.width / 4;
    this.ax.set(this.x - f, this.y - f + this.offsetY - paramInt, this.x + this.width + f, f + (this.y + this.height) + this.offsetY - paramInt);
    return this.ax;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.cJX = paramInt2;
    this.jdField_a_of_type_Akzb = new akzb();
    paramInt2 = (int)this.mContext.getResources().getDimension(2131298686);
    this.dqB = ((int)this.mContext.getResources().getDimension(2131298685));
    paramInt3 = this.width / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_Akzb.drawable = this.mContext.getResources().getDrawable(2130846199);
    this.jdField_a_of_type_Akzb.a(paramInt3 + paramInt1 - paramInt4, 0, paramInt2, this.dqB, paramView);
  }
  
  /* Error */
  public void a(boolean paramBoolean, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 128
    //   8: iconst_2
    //   9: new 130	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   16: ldc 133
    //   18: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 150	akzr:mParentView	Landroid/view/View;
    //   35: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   38: ldc 154
    //   40: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   43: fstore_3
    //   44: fload_3
    //   45: f2i
    //   46: istore 8
    //   48: aload_0
    //   49: getfield 150	akzr:mParentView	Landroid/view/View;
    //   52: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   55: ldc 155
    //   57: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   60: f2i
    //   61: istore 13
    //   63: aload_0
    //   64: getfield 150	akzr:mParentView	Landroid/view/View;
    //   67: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   70: ldc 156
    //   72: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   75: f2i
    //   76: istore 10
    //   78: aload_0
    //   79: getfield 150	akzr:mParentView	Landroid/view/View;
    //   82: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   85: ldc 157
    //   87: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   90: f2i
    //   91: istore 9
    //   93: aload_0
    //   94: getfield 150	akzr:mParentView	Landroid/view/View;
    //   97: invokevirtual 161	android/view/View:getWidth	()I
    //   100: iload 13
    //   102: isub
    //   103: iload 10
    //   105: isub
    //   106: istore 10
    //   108: aload_0
    //   109: iload 9
    //   111: putfield 36	akzr:dqC	I
    //   114: aload_2
    //   115: astore 16
    //   117: aload_2
    //   118: ifnonnull +31 -> 149
    //   121: aload_0
    //   122: getfield 163	akzr:dqA	I
    //   125: iconst_1
    //   126: if_icmpne +352 -> 478
    //   129: aload_0
    //   130: getfield 94	akzr:mContext	Landroid/content/Context;
    //   133: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   136: ldc 164
    //   138: invokestatic 170	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   141: astore 16
    //   143: aload 16
    //   145: astore_2
    //   146: aload_2
    //   147: astore 16
    //   149: aload_0
    //   150: getfield 163	akzr:dqA	I
    //   153: iconst_1
    //   154: if_icmpne +357 -> 511
    //   157: aload_0
    //   158: getfield 150	akzr:mParentView	Landroid/view/View;
    //   161: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   164: ldc 171
    //   166: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   169: fstore 6
    //   171: aload 16
    //   173: invokevirtual 176	android/graphics/Bitmap:getHeight	()I
    //   176: i2f
    //   177: fload 6
    //   179: fmul
    //   180: aload 16
    //   182: invokevirtual 177	android/graphics/Bitmap:getWidth	()I
    //   185: i2f
    //   186: fdiv
    //   187: fstore 5
    //   189: iload 8
    //   191: i2f
    //   192: fstore 4
    //   194: aload_0
    //   195: getfield 150	akzr:mParentView	Landroid/view/View;
    //   198: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   201: ldc 178
    //   203: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   206: fstore 7
    //   208: aload_0
    //   209: getfield 150	akzr:mParentView	Landroid/view/View;
    //   212: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   215: ldc 179
    //   217: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   220: fstore_3
    //   221: fload 4
    //   223: fload 5
    //   225: fsub
    //   226: fload 7
    //   228: fsub
    //   229: fstore 4
    //   231: aload_0
    //   232: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   235: ifnonnull +96 -> 331
    //   238: aload_0
    //   239: new 50	akzw
    //   242: dup
    //   243: aload_0
    //   244: getfield 94	akzr:mContext	Landroid/content/Context;
    //   247: iload 13
    //   249: iload 8
    //   251: iload 10
    //   253: iload 9
    //   255: fload_3
    //   256: f2i
    //   257: fload 4
    //   259: f2i
    //   260: fload 6
    //   262: f2i
    //   263: fload 5
    //   265: f2i
    //   266: invokespecial 182	akzw:<init>	(Landroid/content/Context;IIIIIIII)V
    //   269: putfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   272: aload_0
    //   273: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   276: aload_0
    //   277: getfield 150	akzr:mParentView	Landroid/view/View;
    //   280: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   283: ldc 183
    //   285: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   288: f2i
    //   289: putfield 186	akzw:dqG	I
    //   292: aload_0
    //   293: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   296: aload_0
    //   297: getfield 150	akzr:mParentView	Landroid/view/View;
    //   300: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   303: ldc 187
    //   305: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   308: f2i
    //   309: putfield 190	akzw:dqH	I
    //   312: aload_0
    //   313: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   316: aload_0
    //   317: getfield 94	akzr:mContext	Landroid/content/Context;
    //   320: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   323: ldc 191
    //   325: invokestatic 170	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   328: invokevirtual 195	akzw:ab	(Landroid/graphics/Bitmap;)V
    //   331: aload_0
    //   332: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   335: fload_3
    //   336: f2i
    //   337: putfield 198	akzw:agh	I
    //   340: aload_0
    //   341: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   344: fload 4
    //   346: f2i
    //   347: putfield 201	akzw:agi	I
    //   350: aload_0
    //   351: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   354: fload 6
    //   356: f2i
    //   357: putfield 204	akzw:imageWidth	I
    //   360: aload_0
    //   361: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   364: fload 5
    //   366: f2i
    //   367: putfield 207	akzw:imageHeight	I
    //   370: aload_0
    //   371: getfield 163	akzr:dqA	I
    //   374: iconst_1
    //   375: if_icmpne +203 -> 578
    //   378: aload_0
    //   379: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   382: aload_0
    //   383: getfield 150	akzr:mParentView	Landroid/view/View;
    //   386: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   389: ldc 208
    //   391: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   394: f2i
    //   395: putfield 211	akzw:dqI	I
    //   398: aload_0
    //   399: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   402: aload_0
    //   403: getfield 150	akzr:mParentView	Landroid/view/View;
    //   406: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   409: ldc 212
    //   411: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   414: f2i
    //   415: putfield 215	akzw:dqJ	I
    //   418: aload_0
    //   419: getfield 163	akzr:dqA	I
    //   422: iconst_3
    //   423: if_icmpne +186 -> 609
    //   426: aload_0
    //   427: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   430: aload 16
    //   432: invokevirtual 218	akzw:aa	(Landroid/graphics/Bitmap;)V
    //   435: aload_0
    //   436: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   439: invokevirtual 221	akzw:startAnim	()V
    //   442: aload_0
    //   443: iload 10
    //   445: iload 9
    //   447: iload 13
    //   449: iload 8
    //   451: aload_0
    //   452: getfield 150	akzr:mParentView	Landroid/view/View;
    //   455: invokevirtual 222	akzr:a	(IIIILandroid/view/View;)V
    //   458: iload_1
    //   459: ifeq +162 -> 621
    //   462: aload_0
    //   463: aconst_null
    //   464: putfield 53	akzr:b	Lakzb;
    //   467: aload_0
    //   468: invokevirtual 225	akzr:update	()V
    //   471: return
    //   472: astore_2
    //   473: aload_2
    //   474: invokevirtual 228	java/lang/OutOfMemoryError:printStackTrace	()V
    //   477: return
    //   478: aload_0
    //   479: getfield 94	akzr:mContext	Landroid/content/Context;
    //   482: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   485: ldc 229
    //   487: invokestatic 170	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   490: astore 16
    //   492: aload 16
    //   494: astore_2
    //   495: goto -349 -> 146
    //   498: astore 16
    //   500: aload 16
    //   502: invokevirtual 228	java/lang/OutOfMemoryError:printStackTrace	()V
    //   505: aload_2
    //   506: astore 16
    //   508: goto -359 -> 149
    //   511: aload_0
    //   512: getfield 150	akzr:mParentView	Landroid/view/View;
    //   515: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   518: ldc 230
    //   520: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   523: fstore 6
    //   525: iload 8
    //   527: i2f
    //   528: fstore 4
    //   530: aload_0
    //   531: getfield 150	akzr:mParentView	Landroid/view/View;
    //   534: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   537: ldc 231
    //   539: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   542: fstore 5
    //   544: iload 13
    //   546: i2f
    //   547: fload 6
    //   549: fsub
    //   550: fconst_2
    //   551: fdiv
    //   552: fstore_3
    //   553: fload 4
    //   555: fload 6
    //   557: fsub
    //   558: fload 5
    //   560: fsub
    //   561: fstore 4
    //   563: fload 6
    //   565: fstore 5
    //   567: goto -336 -> 231
    //   570: astore_2
    //   571: aload_2
    //   572: invokevirtual 228	java/lang/OutOfMemoryError:printStackTrace	()V
    //   575: goto -244 -> 331
    //   578: aload_0
    //   579: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   582: iconst_0
    //   583: putfield 211	akzw:dqI	I
    //   586: aload_0
    //   587: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   590: aload_0
    //   591: getfield 150	akzr:mParentView	Landroid/view/View;
    //   594: invokevirtual 153	android/view/View:getResources	()Landroid/content/res/Resources;
    //   597: ldc 232
    //   599: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   602: f2i
    //   603: putfield 215	akzw:dqJ	I
    //   606: goto -188 -> 418
    //   609: aload_0
    //   610: getfield 48	akzr:jdField_a_of_type_Akzw	Lakzw;
    //   613: aload 16
    //   615: invokevirtual 235	akzw:setLogo	(Landroid/graphics/Bitmap;)V
    //   618: goto -176 -> 442
    //   621: aload_0
    //   622: new 4	akzb
    //   625: dup
    //   626: invokespecial 92	akzb:<init>	()V
    //   629: putfield 53	akzr:b	Lakzb;
    //   632: aload_0
    //   633: aload_0
    //   634: getfield 94	akzr:mContext	Landroid/content/Context;
    //   637: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   640: ldc 236
    //   642: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   645: f2i
    //   646: putfield 56	akzr:dqz	I
    //   649: aload_0
    //   650: getfield 94	akzr:mContext	Landroid/content/Context;
    //   653: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   656: ldc 237
    //   658: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   661: f2i
    //   662: istore 11
    //   664: aload_0
    //   665: getfield 94	akzr:mContext	Landroid/content/Context;
    //   668: invokevirtual 100	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   671: ldc 238
    //   673: invokevirtual 107	android/content/res/Resources:getDimension	(I)F
    //   676: f2i
    //   677: istore 12
    //   679: iload 13
    //   681: iconst_2
    //   682: idiv
    //   683: istore 13
    //   685: iload 11
    //   687: iconst_2
    //   688: idiv
    //   689: istore 14
    //   691: aload_0
    //   692: getfield 56	akzr:dqz	I
    //   695: istore 15
    //   697: aload_0
    //   698: getfield 53	akzr:b	Lakzb;
    //   701: iload 13
    //   703: iload 10
    //   705: iadd
    //   706: iload 14
    //   708: isub
    //   709: iload 15
    //   711: iload 9
    //   713: iload 8
    //   715: iadd
    //   716: iadd
    //   717: iload 11
    //   719: iload 12
    //   721: aload_0
    //   722: getfield 150	akzr:mParentView	Landroid/view/View;
    //   725: invokevirtual 86	akzb:a	(IIIILandroid/view/View;)V
    //   728: goto -261 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	731	0	this	akzr
    //   0	731	1	paramBoolean	boolean
    //   0	731	2	paramBitmap	android.graphics.Bitmap
    //   43	510	3	f1	float
    //   192	370	4	f2	float
    //   187	379	5	f3	float
    //   169	395	6	f4	float
    //   206	21	7	f5	float
    //   46	670	8	i	int
    //   91	625	9	j	int
    //   76	630	10	k	int
    //   662	56	11	m	int
    //   677	43	12	n	int
    //   61	645	13	i1	int
    //   689	20	14	i2	int
    //   695	22	15	i3	int
    //   115	378	16	localBitmap1	android.graphics.Bitmap
    //   498	3	16	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   506	108	16	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   31	44	472	java/lang/OutOfMemoryError
    //   121	143	498	java/lang/OutOfMemoryError
    //   478	492	498	java/lang/OutOfMemoryError
    //   312	331	570	java/lang/OutOfMemoryError
  }
  
  public void ad(int paramInt, long paramLong)
  {
    this.startY = this.cJX;
    this.endY = (this.cJX + paramInt);
    this.mInterpolator = new DecelerateInterpolator();
    this.mState = 1;
    startAnimation(paramLong);
  }
  
  public void animateUp()
  {
    this.startY = this.y;
    this.endY = this.cJX;
    this.mState = 3;
    this.mInterpolator = new akzc();
    startAnimation(1500L);
  }
  
  public void cUp()
  {
    this.mAnimating = false;
    this.mStartTime = -1L;
    this.mDuration = 1L;
    this.mState = 2;
    Lw(this.cJX);
  }
  
  public void dEx()
  {
    aqnc localaqnc = new aqnc(Float.valueOf(1.0F), Float.valueOf(1.1F), new akzs(this));
    localaqnc.setDuration(500L);
    localaqnc.setRepeatCount(-1);
    localaqnc.setRepeatMode(2);
    startAnimation(localaqnc);
    this.jdField_a_of_type_Alad.startAnimation();
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    boolean bool2 = false;
    boolean bool3 = super.ata();
    update();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.offsetY);
    if ((this.jdField_a_of_type_Akzb != null) && (this.alpha != 0))
    {
      this.jdField_a_of_type_Akzb.alpha = this.alpha;
      this.jdField_a_of_type_Akzb.draw(paramCanvas);
    }
    super.ba(paramCanvas);
    if (this.jdField_a_of_type_Akzw != null) {}
    for (boolean bool1 = this.jdField_a_of_type_Akzw.draw(paramCanvas);; bool1 = false)
    {
      if ((this.b != null) && (this.alpha != 0))
      {
        this.b.alpha = this.alpha;
        this.b.draw(paramCanvas);
      }
      this.jdField_a_of_type_Alad.onDraw(paramCanvas);
      paramCanvas.restore();
      if ((this.mAnimating) || (bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public void startAnimation(long paramLong)
  {
    this.mDuration = paramLong;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    this.mAnimating = true;
  }
  
  public void stopAnimation()
  {
    super.stopAnimation();
    cUp();
    this.scaleY = 1.0F;
    this.scaleX = 1.0F;
    if (this.jdField_a_of_type_Akzw != null)
    {
      this.jdField_a_of_type_Akzw.scaleY = 1.0F;
      this.jdField_a_of_type_Akzw.scaleX = 1.0F;
    }
  }
  
  public void update()
  {
    float f1 = 1.0F;
    if (!this.mAnimating) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) * 1.0F / (float)this.mDuration;
    float f3;
    if (this.mInterpolator != null)
    {
      f3 = this.mInterpolator.getInterpolation(f2);
      if (f3 <= 1.0F) {}
    }
    for (;;)
    {
      f3 = this.startY;
      Lw((int)(f1 * (this.endY - this.startY) + f3));
      if (f2 <= 0.99D) {
        break;
      }
      switch (this.mState)
      {
      case 2: 
      default: 
        cUp();
        return;
      case 1: 
        this.mState = 3;
        animateUp();
        return;
      }
      this.mState = 2;
      return;
      f1 = f3;
      continue;
      f1 = f2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */