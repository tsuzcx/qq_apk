package com.tencent.biz.qqstory.takevideo.doodle.ui.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import auru;
import com.tencent.qphone.base.util.QLog;
import ram;
import ras;

public class CropView
  extends View
  implements Handler.Callback, View.OnTouchListener
{
  auru jdField_a_of_type_Auru;
  a jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a;
  Rect aF;
  Rect aG = new Rect();
  Rect aH = new Rect();
  boolean aHF;
  private boolean aHG = true;
  boolean aHH = false;
  boolean aHI = false;
  boolean aHJ = true;
  Rect aI;
  int arq;
  private Paint bb = new Paint();
  private Paint bc = new Paint();
  int bro;
  private int brp = 40;
  int brq;
  int brr = 8;
  Bitmap cF;
  private float lF;
  private float lG;
  Bitmap mBitmap;
  Context mContext;
  Rect mImageRect;
  Matrix mMatrix;
  float nc;
  float nd;
  float ne;
  float nf;
  float ng;
  float nh;
  float ni;
  float nj;
  float nk;
  float nl;
  
  public CropView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public CropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void F(float paramFloat1, float paramFloat2)
  {
    this.aHH = true;
    this.jdField_a_of_type_Auru.removeMessages(1001);
    int i = (int)(this.aF.left + paramFloat1);
    int j = (int)(this.aF.right + paramFloat1);
    int k = (int)(this.aF.top + paramFloat2);
    int m = (int)(this.aF.bottom + paramFloat2);
    if (i <= this.mImageRect.left)
    {
      paramFloat1 = this.mImageRect.left - this.aF.left;
      if (k > this.mImageRect.top) {
        break label204;
      }
      paramFloat2 = this.mImageRect.top - this.aF.top;
    }
    for (;;)
    {
      this.aF.offset((int)paramFloat1, (int)paramFloat2);
      this.aHI = true;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a.tw(this.aHI);
      }
      return;
      if (this.mImageRect.right > j) {
        break;
      }
      paramFloat1 = this.mImageRect.right - this.aF.right;
      break;
      label204:
      if (this.mImageRect.bottom <= m) {
        paramFloat2 = this.mImageRect.bottom - this.aF.bottom;
      }
    }
  }
  
  private void M(Canvas paramCanvas)
  {
    this.bb.setColor(-16777216);
    this.bb.setStyle(Paint.Style.FILL);
    this.bb.setAlpha(160);
    this.bc.setColor(-1);
    this.bc.setStyle(Paint.Style.STROKE);
    this.bc.setStrokeWidth(5.0F);
    this.bc.setAlpha(255);
    paramCanvas.save();
    if (this.aF == null) {
      return;
    }
    paramCanvas.clipRect(this.aF, Region.Op.XOR);
    paramCanvas.drawRect(this.mImageRect, this.bb);
    Path localPath = new Path();
    localPath.moveTo(this.aF.left, this.aF.top);
    localPath.lineTo(this.aF.right, this.aF.top);
    localPath.lineTo(this.aF.right, this.aF.bottom);
    localPath.lineTo(this.aF.left, this.aF.bottom);
    localPath.close();
    paramCanvas.drawPath(localPath, this.bc);
    paramCanvas.restore();
    this.bc.setStyle(Paint.Style.FILL);
    int i = (int)(0.07F * this.mImageRect.width() + 0.5F);
    this.aG.set(this.aF.left - this.brr, this.aF.top - this.brr, this.aF.left + i, this.aF.top);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.right - i, this.aF.top - this.brr, this.aF.right + this.brr, this.aF.top);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.left - this.brr, this.aF.top, this.aF.left, this.aF.top + i);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.right, this.aF.top, this.aF.right + this.brr, this.aF.top + i);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.left - this.brr, this.aF.bottom, this.aF.left + i, this.aF.bottom + this.brr);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.right - i, this.aF.bottom, this.aF.right + this.brr, this.aF.bottom + this.brr);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.left - this.brr, this.aF.bottom - i, this.aF.left, this.aF.bottom);
    paramCanvas.drawRect(this.aG, this.bc);
    this.aG.set(this.aF.right, this.aF.bottom - i, this.aF.right + this.brr, this.aF.bottom);
    paramCanvas.drawRect(this.aG, this.bc);
    this.bc.setStyle(Paint.Style.STROKE);
    paramCanvas.save();
    this.bc.setStrokeWidth(2.0F);
    this.bc.setAlpha(150);
    float f1 = this.aF.left;
    float f2 = this.aF.top + this.aF.height() / 3;
    paramCanvas.drawLine(f1, f2, this.aF.right, f2, this.bc);
    f1 = this.aF.left;
    f2 = this.aF.top + this.aF.height() / 3 * 2;
    paramCanvas.drawLine(f1, f2, this.aF.right, f2, this.bc);
    f1 = this.aF.left + this.aF.width() / 3;
    paramCanvas.drawLine(f1, this.aF.top, f1, this.aF.bottom, this.bc);
    f1 = this.aF.left + this.aF.width() / 3 * 2;
    paramCanvas.drawLine(f1, this.aF.top, f1, this.aF.bottom, this.bc);
    paramCanvas.restore();
  }
  
  private boolean N(MotionEvent paramMotionEvent)
  {
    return this.aF.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private Bitmap a(int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: getstatic 240	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 10
    //   5: if_icmplt +887 -> 892
    //   8: aload_0
    //   9: getfield 242	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:cF	Landroid/graphics/Bitmap;
    //   12: astore 9
    //   14: new 244	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial 245	java/io/ByteArrayOutputStream:<init>	()V
    //   21: astore 10
    //   23: aload 9
    //   25: getstatic 251	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   28: bipush 100
    //   30: aload 10
    //   32: invokevirtual 257	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   35: pop
    //   36: aload 10
    //   38: invokevirtual 261	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: astore 9
    //   43: aload 9
    //   45: iconst_0
    //   46: aload 9
    //   48: arraylength
    //   49: iconst_0
    //   50: invokestatic 267	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   53: astore 9
    //   55: aload 9
    //   57: ifnull +835 -> 892
    //   60: aload_0
    //   61: invokevirtual 271	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:f	()[F
    //   64: astore 10
    //   66: ldc_w 273
    //   69: ldc_w 275
    //   72: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   79: ifnonnull +65 -> 144
    //   82: aload_0
    //   83: new 75	android/graphics/Rect
    //   86: dup
    //   87: invokespecial 76	android/graphics/Rect:<init>	()V
    //   90: putfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   93: aload_0
    //   94: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   97: iconst_0
    //   98: putfield 113	android/graphics/Rect:top	I
    //   101: aload_0
    //   102: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   105: iconst_0
    //   106: putfield 107	android/graphics/Rect:left	I
    //   109: aload_0
    //   110: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   113: aload 9
    //   115: invokevirtual 286	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   118: putfield 110	android/graphics/Rect:right	I
    //   121: aload_0
    //   122: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   125: aload 9
    //   127: invokevirtual 289	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   130: putfield 116	android/graphics/Rect:bottom	I
    //   133: aload_0
    //   134: getfield 82	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aH	Landroid/graphics/Rect;
    //   137: aload_0
    //   138: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   141: invokevirtual 292	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   144: aload_0
    //   145: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   148: invokevirtual 198	android/graphics/Rect:width	()I
    //   151: istore 5
    //   153: aload_0
    //   154: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   157: invokevirtual 206	android/graphics/Rect:height	()I
    //   160: istore 6
    //   162: aload_0
    //   163: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   166: aload_0
    //   167: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   170: getfield 113	android/graphics/Rect:top	I
    //   173: i2f
    //   174: iload 6
    //   176: i2f
    //   177: aload 10
    //   179: iconst_1
    //   180: faload
    //   181: fmul
    //   182: fadd
    //   183: f2i
    //   184: putfield 113	android/graphics/Rect:top	I
    //   187: aload_0
    //   188: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   191: aload_0
    //   192: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   195: getfield 116	android/graphics/Rect:bottom	I
    //   198: i2f
    //   199: iload 6
    //   201: i2f
    //   202: aload 10
    //   204: iconst_3
    //   205: faload
    //   206: fmul
    //   207: fsub
    //   208: f2i
    //   209: putfield 116	android/graphics/Rect:bottom	I
    //   212: aload_0
    //   213: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   216: aload_0
    //   217: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   220: getfield 107	android/graphics/Rect:left	I
    //   223: i2f
    //   224: iload 5
    //   226: i2f
    //   227: aload 10
    //   229: iconst_0
    //   230: faload
    //   231: fmul
    //   232: fadd
    //   233: f2i
    //   234: putfield 107	android/graphics/Rect:left	I
    //   237: aload_0
    //   238: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   241: aload_0
    //   242: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   245: getfield 110	android/graphics/Rect:right	I
    //   248: i2f
    //   249: iload 5
    //   251: i2f
    //   252: aload 10
    //   254: iconst_2
    //   255: faload
    //   256: fmul
    //   257: fsub
    //   258: f2i
    //   259: putfield 110	android/graphics/Rect:right	I
    //   262: ldc_w 273
    //   265: new 294	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 297
    //   275: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 10
    //   280: iconst_0
    //   281: faload
    //   282: invokevirtual 304	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   285: ldc_w 306
    //   288: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 10
    //   293: iconst_1
    //   294: faload
    //   295: invokevirtual 304	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   298: ldc_w 306
    //   301: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: iconst_2
    //   307: faload
    //   308: invokevirtual 304	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   311: ldc_w 306
    //   314: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 10
    //   319: iconst_3
    //   320: faload
    //   321: invokevirtual 304	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   324: ldc_w 308
    //   327: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   334: getfield 107	android/graphics/Rect:left	I
    //   337: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 313
    //   343: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   350: getfield 110	android/graphics/Rect:right	I
    //   353: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 315
    //   359: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   366: getfield 113	android/graphics/Rect:top	I
    //   369: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: ldc_w 317
    //   375: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_0
    //   379: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   382: getfield 116	android/graphics/Rect:bottom	I
    //   385: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 324	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: ldc_w 273
    //   397: new 294	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 326
    //   407: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   414: invokevirtual 329	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: new 331	android/graphics/BitmapFactory$Options
    //   426: dup
    //   427: invokespecial 332	android/graphics/BitmapFactory$Options:<init>	()V
    //   430: astore 10
    //   432: aload 10
    //   434: iconst_1
    //   435: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   438: aload 9
    //   440: aload_0
    //   441: getfield 283	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:aI	Landroid/graphics/Rect;
    //   444: aload 10
    //   446: invokevirtual 339	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   449: astore 10
    //   451: aload_0
    //   452: getfield 341	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:arq	I
    //   455: istore 7
    //   457: iload 7
    //   459: ifne +39 -> 498
    //   462: aload 9
    //   464: invokevirtual 344	android/graphics/BitmapRegionDecoder:recycle	()V
    //   467: aload 10
    //   469: areturn
    //   470: astore 9
    //   472: ldc_w 273
    //   475: ldc_w 346
    //   478: aload 9
    //   480: invokestatic 349	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   483: aload_1
    //   484: ifnull +8 -> 492
    //   487: aload_1
    //   488: iconst_0
    //   489: bipush 253
    //   491: iastore
    //   492: aconst_null
    //   493: astore 9
    //   495: goto -440 -> 55
    //   498: ldc_w 273
    //   501: new 294	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 351
    //   511: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: iload 7
    //   516: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   519: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 10
    //   527: invokevirtual 352	android/graphics/Bitmap:getWidth	()I
    //   530: istore 6
    //   532: aload 10
    //   534: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   537: istore 5
    //   539: iload 7
    //   541: bipush 90
    //   543: if_icmpeq +11 -> 554
    //   546: iload 7
    //   548: sipush 270
    //   551: if_icmpne +380 -> 931
    //   554: aload 10
    //   556: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   559: istore 6
    //   561: aload 10
    //   563: invokevirtual 352	android/graphics/Bitmap:getWidth	()I
    //   566: istore 5
    //   568: ldc_w 273
    //   571: new 294	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 355
    //   581: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 6
    //   586: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: ldc_w 357
    //   592: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iload 5
    //   597: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   606: aload_0
    //   607: invokevirtual 361	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:getContext	()Landroid/content/Context;
    //   610: invokevirtual 367	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   613: invokevirtual 373	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   616: getfield 378	android/util/DisplayMetrics:widthPixels	I
    //   619: i2f
    //   620: fstore_2
    //   621: aload_0
    //   622: invokevirtual 361	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:getContext	()Landroid/content/Context;
    //   625: invokevirtual 367	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   628: invokevirtual 373	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   631: getfield 381	android/util/DisplayMetrics:heightPixels	I
    //   634: i2f
    //   635: fstore_3
    //   636: iload 5
    //   638: i2f
    //   639: iload 6
    //   641: i2f
    //   642: fdiv
    //   643: fstore 4
    //   645: fload_3
    //   646: fload_2
    //   647: fdiv
    //   648: fstore_2
    //   649: ldc_w 273
    //   652: new 294	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 383
    //   662: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: fconst_1
    //   666: invokevirtual 304	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   669: ldc_w 385
    //   672: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: iload 6
    //   677: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 387
    //   683: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: iload 5
    //   688: invokevirtual 311	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: iload 6
    //   699: iload 5
    //   701: getstatic 393	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   704: invokestatic 397	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   707: astore 11
    //   709: new 157	android/graphics/Canvas
    //   712: dup
    //   713: aload 11
    //   715: invokespecial 400	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   718: astore 12
    //   720: new 402	android/graphics/Matrix
    //   723: dup
    //   724: invokespecial 403	android/graphics/Matrix:<init>	()V
    //   727: astore 13
    //   729: iload 7
    //   731: ifeq +28 -> 759
    //   734: aload 13
    //   736: iload 7
    //   738: i2f
    //   739: aload 10
    //   741: invokevirtual 352	android/graphics/Bitmap:getWidth	()I
    //   744: iconst_2
    //   745: idiv
    //   746: i2f
    //   747: aload 10
    //   749: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   752: iconst_2
    //   753: idiv
    //   754: i2f
    //   755: invokevirtual 407	android/graphics/Matrix:postRotate	(FFF)Z
    //   758: pop
    //   759: aload 10
    //   761: invokevirtual 352	android/graphics/Bitmap:getWidth	()I
    //   764: iconst_2
    //   765: idiv
    //   766: istore 7
    //   768: iload 6
    //   770: iconst_2
    //   771: idiv
    //   772: istore 6
    //   774: aload 10
    //   776: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   779: iconst_2
    //   780: idiv
    //   781: istore 8
    //   783: iload 5
    //   785: iconst_2
    //   786: idiv
    //   787: istore 5
    //   789: aload 13
    //   791: iload 7
    //   793: iload 6
    //   795: isub
    //   796: ineg
    //   797: i2f
    //   798: iload 8
    //   800: iload 5
    //   802: isub
    //   803: ineg
    //   804: i2f
    //   805: invokevirtual 411	android/graphics/Matrix:postTranslate	(FF)Z
    //   808: pop
    //   809: aload 12
    //   811: aload 10
    //   813: aload 13
    //   815: aconst_null
    //   816: invokevirtual 415	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   819: ldc_w 273
    //   822: new 294	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 295	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 417
    //   832: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 11
    //   837: invokevirtual 421	android/graphics/Bitmap:isMutable	()Z
    //   840: invokevirtual 424	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   843: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 281	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload_1
    //   850: ifnull +7 -> 857
    //   853: aload_1
    //   854: iconst_0
    //   855: iconst_0
    //   856: iastore
    //   857: aload 9
    //   859: invokevirtual 344	android/graphics/BitmapRegionDecoder:recycle	()V
    //   862: aload 11
    //   864: areturn
    //   865: astore 10
    //   867: ldc_w 273
    //   870: ldc_w 346
    //   873: aload 10
    //   875: invokestatic 349	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   878: aload_1
    //   879: ifnull +8 -> 887
    //   882: aload_1
    //   883: iconst_0
    //   884: bipush 254
    //   886: iastore
    //   887: aload 9
    //   889: invokevirtual 344	android/graphics/BitmapRegionDecoder:recycle	()V
    //   892: aconst_null
    //   893: areturn
    //   894: astore 10
    //   896: ldc_w 273
    //   899: ldc_w 346
    //   902: aload 10
    //   904: invokestatic 349	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   907: aload_1
    //   908: ifnull +7 -> 915
    //   911: aload_1
    //   912: iconst_0
    //   913: iconst_m1
    //   914: iastore
    //   915: aload 9
    //   917: invokevirtual 344	android/graphics/BitmapRegionDecoder:recycle	()V
    //   920: goto -28 -> 892
    //   923: astore_1
    //   924: aload 9
    //   926: invokevirtual 344	android/graphics/BitmapRegionDecoder:recycle	()V
    //   929: aload_1
    //   930: athrow
    //   931: goto -363 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	CropView
    //   0	934	1	paramArrayOfInt	int[]
    //   620	29	2	f1	float
    //   635	11	3	f2	float
    //   643	1	4	f3	float
    //   151	652	5	i	int
    //   160	636	6	j	int
    //   455	341	7	k	int
    //   781	22	8	m	int
    //   12	451	9	localObject1	Object
    //   470	9	9	localIOException	java.io.IOException
    //   493	432	9	localObject2	Object
    //   21	791	10	localObject3	Object
    //   865	9	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   894	9	10	localException	java.lang.Exception
    //   707	156	11	localBitmap	Bitmap
    //   718	92	12	localCanvas	Canvas
    //   727	87	13	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   8	55	470	java/io/IOException
    //   438	457	865	java/lang/OutOfMemoryError
    //   498	539	865	java/lang/OutOfMemoryError
    //   554	568	865	java/lang/OutOfMemoryError
    //   568	729	865	java/lang/OutOfMemoryError
    //   734	759	865	java/lang/OutOfMemoryError
    //   759	849	865	java/lang/OutOfMemoryError
    //   438	457	894	java/lang/Exception
    //   498	539	894	java/lang/Exception
    //   554	568	894	java/lang/Exception
    //   568	729	894	java/lang/Exception
    //   734	759	894	java/lang/Exception
    //   759	849	894	java/lang/Exception
    //   438	457	923	finally
    //   498	539	923	finally
    //   554	568	923	finally
    //   568	729	923	finally
    //   734	759	923	finally
    //   759	849	923	finally
    //   867	878	923	finally
    //   896	907	923	finally
  }
  
  private void bud()
  {
    if (this.mBitmap == null) {
      return;
    }
    this.brq = 0;
    this.aHH = false;
    this.aHJ = true;
    this.mMatrix = new Matrix();
    this.mMatrix.setScale(1.0F, 1.0F);
    float f1 = this.mBitmap.getWidth();
    float f2 = this.mBitmap.getHeight();
    this.nj = Math.min(this.nh / f1, this.ni / f2);
    ram.d("EditPicActivityCropView", "setBitmap scale : " + this.nj);
    this.lF = (f1 * this.nj);
    this.lG = (this.nj * f2);
    ram.d("EditPicActivityCropView", "setBitmap image width " + this.lF + " image height " + this.lG);
    this.aF = o();
    this.mImageRect = o();
    this.mMatrix.postScale(this.nj, this.nj);
    this.nk = (this.nf / 2.0F);
    this.nl = (this.ng / 2.0F);
    f1 = this.nk;
    f2 = this.lF / 2.0F;
    float f3 = this.nl;
    float f4 = this.lG / 2.0F;
    this.mMatrix.postTranslate(f1 - f2, f3 - f4);
  }
  
  private int c(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2) {
      return 0;
    }
    int i = this.brp;
    Rect localRect1 = new Rect(this.aF.left - i * 10, this.aF.top - i * 10, this.aF.left + i * 2, this.aF.top + i * 2);
    Rect localRect2 = new Rect(this.aF.right - i * 2, this.aF.top - i * 10, this.aF.right + i * 10, this.aF.top + i * 2);
    Rect localRect3 = new Rect(this.aF.left - i * 10, this.aF.bottom - i * 2, this.aF.left + i * 2, this.aF.bottom + i * 10);
    Rect localRect4 = new Rect(this.aF.right - i * 2, this.aF.bottom - i * 2, this.aF.right + i * 10, this.aF.bottom + i * 10);
    Rect localRect5 = new Rect(this.aF.left - i * 10, this.aF.top + i * 2, this.aF.left + i * 2, this.aF.bottom - i * 2);
    Rect localRect6 = new Rect(this.aF.right - i * 2, this.aF.top + i * 2, this.aF.right + i * 10, this.aF.bottom - i * 2);
    Rect localRect7 = new Rect(this.aF.left + i * 2, this.aF.top - i * 10, this.aF.right - i * 2, this.aF.top + i * 2);
    Rect localRect8 = new Rect(this.aF.left + i * 2, this.aF.bottom - i * 2, this.aF.right - i * 2, i * 10 + this.aF.bottom);
    if (localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 1;
    }
    if (localRect2.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 2;
    }
    if (localRect3.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 3;
    }
    if (localRect4.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 4;
    }
    if (localRect5.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 5;
    }
    if (localRect6.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 7;
    }
    if (localRect7.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 6;
    }
    if (localRect8.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 8;
    }
    return 0;
  }
  
  private void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.aHH = true;
    this.jdField_a_of_type_Auru.removeMessages(1001);
    int i;
    Rect localRect;
    if (paramInt == 1)
    {
      paramInt = (int)(this.aF.left + paramFloat1);
      i = (int)(this.aF.top + paramFloat2);
      if ((paramInt + 64 < this.aF.right) && (paramInt >= this.mImageRect.left))
      {
        localRect = this.aF;
        localRect.left = ((int)(localRect.left + paramFloat1));
      }
      if ((i + 64 < this.aF.bottom) && (i >= this.mImageRect.top))
      {
        localRect = this.aF;
        localRect.top = ((int)(localRect.top + paramFloat2));
      }
    }
    for (;;)
    {
      this.aHI = true;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a.tw(this.aHI);
      }
      return;
      if (paramInt == 2)
      {
        paramInt = (int)(this.aF.right + paramFloat1);
        i = (int)(this.aF.top + paramFloat2);
        if ((paramInt - 64 > this.aF.left) && (paramInt <= this.mImageRect.right))
        {
          localRect = this.aF;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((i + 64 < this.aF.bottom) && (i >= this.mImageRect.top))
        {
          localRect = this.aF;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 3)
      {
        paramInt = (int)(this.aF.left + paramFloat1);
        i = (int)(this.aF.bottom + paramFloat2);
        if ((paramInt + 64 < this.aF.right) && (paramInt >= this.mImageRect.left))
        {
          localRect = this.aF;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
        if ((i - 64 > this.aF.top) && (i <= this.mImageRect.bottom))
        {
          localRect = this.aF;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 4)
      {
        paramInt = (int)(this.aF.right + paramFloat1);
        i = (int)(this.aF.bottom + paramFloat2);
        if ((paramInt - 64 > this.aF.left) && (paramInt <= this.mImageRect.right))
        {
          localRect = this.aF;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((i - 64 > this.aF.top) && (i <= this.mImageRect.bottom))
        {
          localRect = this.aF;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 5)
      {
        paramInt = (int)(this.aF.left + paramFloat1);
        if ((paramInt + 64 < this.aF.right) && (paramInt >= this.mImageRect.left))
        {
          localRect = this.aF;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
      }
      else if (paramInt == 7)
      {
        paramInt = (int)(this.aF.right + paramFloat1);
        if ((paramInt - 64 > this.aF.left) && (paramInt <= this.mImageRect.right))
        {
          localRect = this.aF;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
      }
      else if (paramInt == 6)
      {
        paramInt = (int)(this.aF.top + paramFloat2);
        if ((paramInt + 64 < this.aF.bottom) && (paramInt >= this.mImageRect.top))
        {
          localRect = this.aF;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 8)
      {
        paramInt = (int)(this.aF.bottom + paramFloat2);
        if ((paramInt - 64 > this.aF.top) && (paramInt <= this.mImageRect.bottom))
        {
          localRect = this.aF;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
    }
  }
  
  private Rect o()
  {
    float f2;
    if (this.aHJ) {
      f2 = this.lF;
    }
    for (float f1 = this.lG;; f1 = this.lF)
    {
      float f3 = this.nf / 2.0F;
      float f4 = f2 / 2.0F;
      float f5 = this.ng / 2.0F;
      float f6 = f1 / 2.0F;
      float f7 = this.nf / 2.0F;
      f2 /= 2.0F;
      float f8 = this.ng / 2.0F;
      f1 /= 2.0F;
      return new Rect((int)(f3 - f4 + 0.5F), (int)(f5 - f6 + 0.5F), (int)(f2 + f7 + 0.5F), (int)(f1 + f8 + 0.5F));
      f2 = this.lG;
    }
  }
  
  public boolean Ls()
  {
    this.jdField_a_of_type_Auru.removeMessages(1001);
    Object localObject = new int[2];
    Bitmap localBitmap = this.mBitmap;
    if (this.aI != null) {
      this.aH.set(this.aI);
    }
    if (this.cF == null) {}
    do
    {
      return false;
      localObject = a((int[])localObject);
      if ((localObject != null) && (((Bitmap)localObject).getWidth() >= 64) && (((Bitmap)localObject).getHeight() >= 64)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivityCropView", 2, "too small " + localObject);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a.wS(7);
      }
    } while (this.aI == null);
    this.aI.set(this.aH);
    return false;
    if (localObject != null) {
      setBitmap((Bitmap)localObject);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a.t(localBitmap);
    }
    return true;
  }
  
  public Bitmap Y()
  {
    return this.cF;
  }
  
  public void clear()
  {
    this.mBitmap = null;
    this.cF = null;
    this.aI = null;
    this.jdField_a_of_type_Auru.removeMessages(1001);
    this.arq = 0;
    this.aHI = false;
  }
  
  public float[] f()
  {
    float[] arrayOfFloat = new float[4];
    if (this.arq == 90)
    {
      arrayOfFloat[3] = ((this.aF.left - this.mImageRect.left) / this.mImageRect.width());
      arrayOfFloat[0] = ((this.aF.top - this.mImageRect.top) / this.mImageRect.height());
      arrayOfFloat[1] = ((this.mImageRect.right - this.aF.right) / this.mImageRect.width());
      arrayOfFloat[2] = ((this.mImageRect.bottom - this.aF.bottom) / this.mImageRect.height());
      return arrayOfFloat;
    }
    if (this.arq == 270)
    {
      arrayOfFloat[1] = ((this.aF.left - this.mImageRect.left) / this.mImageRect.width());
      arrayOfFloat[2] = ((this.aF.top - this.mImageRect.top) / this.mImageRect.height());
      arrayOfFloat[3] = ((this.mImageRect.right - this.aF.right) / this.mImageRect.width());
      arrayOfFloat[0] = ((this.mImageRect.bottom - this.aF.bottom) / this.mImageRect.height());
      return arrayOfFloat;
    }
    if (this.arq == 180)
    {
      arrayOfFloat[2] = ((this.aF.left - this.mImageRect.left) / this.mImageRect.width());
      arrayOfFloat[3] = ((this.aF.top - this.mImageRect.top) / this.mImageRect.height());
      arrayOfFloat[0] = ((this.mImageRect.right - this.aF.right) / this.mImageRect.width());
      arrayOfFloat[1] = ((this.mImageRect.bottom - this.aF.bottom) / this.mImageRect.height());
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((this.aF.left - this.mImageRect.left) / this.mImageRect.width());
    arrayOfFloat[1] = ((this.aF.top - this.mImageRect.top) / this.mImageRect.height());
    arrayOfFloat[2] = ((this.mImageRect.right - this.aF.right) / this.mImageRect.width());
    arrayOfFloat[3] = ((this.mImageRect.bottom - this.aF.bottom) / this.mImageRect.height());
    return arrayOfFloat;
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      ras.sp("0X80075D1");
      Ls();
    }
    return false;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    setOnTouchListener(this);
    this.brr = paramContext.getResources().getDimensionPixelSize(2131299779);
    this.brp = paramContext.getResources().getDimensionPixelSize(2131299780);
    this.mMatrix = new Matrix();
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
  }
  
  public void initSize(int paramInt1, int paramInt2)
  {
    this.nf = paramInt1;
    this.ng = paramInt2;
    this.nh = (paramInt1 - this.brr * 2);
    this.ni = (paramInt2 - this.brr * 2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mBitmap != null)
    {
      paramCanvas.drawBitmap(this.mBitmap, this.mMatrix, null);
      M(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    initSize(paramInt1, paramInt2);
    bud();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.aF == null);
      this.nd = paramMotionEvent.getX();
      this.ne = paramMotionEvent.getY();
      this.bro = c(paramMotionEvent);
      ram.d("EditPicActivityCropView", "hitResizeCorner " + this.bro);
      this.aHF = N(paramMotionEvent);
      this.nc = 0.0F;
      this.aHG = false;
      return true;
    case 5: 
    case 261: 
      this.bro = 0;
      this.nd = 0.0F;
      this.ne = 0.0F;
      return true;
    case 6: 
    case 262: 
      this.aHF = false;
      return true;
    case 1: 
      this.aHG = true;
      this.bro = 0;
      this.aHF = false;
      if (this.aHH) {
        this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(1001, 1000L);
      }
      return true;
    }
    if ((paramMotionEvent.getPointerCount() == 2) && (this.bro == 0))
    {
      f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      f2 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f3 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      if (this.nc == 0.0F) {
        this.nc = f1;
      }
    }
    while (paramMotionEvent.getPointerCount() != 1) {
      for (;;)
      {
        return true;
        if (this.nd == 0.0F)
        {
          this.nd = f2;
          this.ne = f3;
        }
        else if ((f1 - this.nc >= 10.0F) || (f1 - this.nc <= -10.0F))
        {
          f2 = f1 / this.nc;
          this.nc = f1;
          f1 = this.aF.width() - this.aF.width() * f2;
          f2 = this.aF.height() - f2 * this.aF.height();
          d(1, f1 / 2.0F, f2 / 2.0F);
          d(4, -f1 / 2.0F, -f2 / 2.0F);
          invalidate();
        }
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f1 - this.nd;
    float f4 = f2 - this.ne;
    if (this.bro != 0) {
      d(this.bro, f3, f4);
    }
    for (;;)
    {
      this.nd = f1;
      this.ne = f2;
      invalidate();
      break;
      if (this.aHF) {
        F(f3, f4);
      }
    }
  }
  
  public void rotate(int paramInt)
  {
    this.mMatrix = new Matrix();
    this.mMatrix.setScale(1.0F, 1.0F);
    if (this.mBitmap == null) {
      ram.e("EditPicActivityCropView", "cropview rotate bitmap is null..");
    }
    float f1;
    float f2;
    float f3;
    label194:
    label201:
    label228:
    do
    {
      return;
      f1 = this.mBitmap.getWidth();
      f2 = this.mBitmap.getHeight();
      f3 = this.nk;
      float f4 = f1 / 2.0F;
      float f5 = this.nl;
      float f6 = f2 / 2.0F;
      this.mMatrix.postTranslate(f3 - f4, f5 - f6);
      this.brq += paramInt;
      this.brq %= 360;
      this.arq += paramInt;
      this.arq %= 360;
      switch (this.brq)
      {
      default: 
        if (!this.aHJ) {
          break label469;
        }
        f3 = f1;
        if (!this.aHJ) {
          break label475;
        }
        if (f2 / f3 <= this.ni / this.nh) {
          break label480;
        }
        this.nj = (this.ni / f2);
        f1 = this.nj;
        ram.d("EditPicActivityCropView", "calculate picscale : " + this.nj + " final : " + f1);
        this.lF = (this.mBitmap.getWidth() * this.nj);
        this.lG = (this.mBitmap.getHeight() * this.nj);
        this.aF = o();
        this.mImageRect = o();
        this.mMatrix.postScale(f1, f1, this.nk, this.nl);
        invalidate();
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a == null);
    if ((this.aHI) || (this.brq != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a.tw(bool);
      return;
      this.aHJ = true;
      break;
      this.mMatrix.postRotate(90.0F, this.nk, this.nl);
      this.aHJ = false;
      break;
      this.mMatrix.postRotate(180.0F, this.nk, this.nl);
      this.aHJ = true;
      break;
      this.mMatrix.postRotate(270.0F, this.nk, this.nl);
      this.aHJ = false;
      break;
      label469:
      f3 = f2;
      break label194;
      label475:
      f2 = f1;
      break label201;
      label480:
      this.nj = (this.nh / f3);
      break label228;
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (this.mBitmap == null) {
      this.cF = paramBitmap;
    }
    this.mBitmap = paramBitmap;
    if (this.nf == 0.0F) {
      return;
    }
    bud();
    invalidate();
    this.jdField_a_of_type_Auru.removeMessages(1001);
  }
  
  public void setCropListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiCropCropView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void t(Bitmap paramBitmap);
    
    public abstract void tw(boolean paramBoolean);
    
    public abstract void wS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView
 * JD-Core Version:    0.7.0.1
 */