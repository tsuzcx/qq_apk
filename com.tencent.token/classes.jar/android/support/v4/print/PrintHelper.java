package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  private final PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mImpl = new PrintHelperApi24(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mImpl = new PrintHelperApi23(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.mImpl = new PrintHelperApi20(paramContext);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.mImpl = new PrintHelperApi19(paramContext);
      return;
    }
    this.mImpl = new PrintHelperStub(null);
  }
  
  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public int getColorMode()
  {
    return this.mImpl.getColorMode();
  }
  
  public int getOrientation()
  {
    return this.mImpl.getOrientation();
  }
  
  public int getScaleMode()
  {
    return this.mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mImpl.printBitmap(paramString, paramBitmap, paramOnPrintFinishCallback);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
  {
    this.mImpl.printBitmap(paramString, paramUri, null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    this.mImpl.printBitmap(paramString, paramUri, paramOnPrintFinishCallback);
  }
  
  public void setColorMode(int paramInt)
  {
    this.mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    this.mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mImpl.setScaleMode(paramInt);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface ColorMode {}
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface Orientation {}
  
  @RequiresApi(19)
  private static class PrintHelperApi19
    implements PrintHelper.PrintHelperVersionImpl
  {
    private static final String LOG_TAG = "PrintHelperApi19";
    private static final int MAX_PRINT_SIZE = 3500;
    int mColorMode = 2;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    protected boolean mIsMinMarginsHandlingCorrect = true;
    private final Object mLock = new Object();
    int mOrientation;
    protected boolean mPrintActivityRespectsOrientation = true;
    int mScaleMode = 2;
    
    PrintHelperApi19(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private Bitmap convertBitmapForColorMode(Bitmap paramBitmap, int paramInt)
    {
      if (paramInt != 1) {
        return paramBitmap;
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.setSaturation(0.0F);
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localCanvas.setBitmap(null);
      return localBitmap;
    }
    
    private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
    {
      Matrix localMatrix = new Matrix();
      float f1 = paramRectF.width();
      float f2 = paramInt1;
      f1 /= f2;
      if (paramInt3 == 2) {
        f1 = Math.max(f1, paramRectF.height() / paramInt2);
      } else {
        f1 = Math.min(f1, paramRectF.height() / paramInt2);
      }
      localMatrix.postScale(f1, f1);
      localMatrix.postTranslate((paramRectF.width() - f2 * f1) / 2.0F, (paramRectF.height() - paramInt2 * f1) / 2.0F);
      return localMatrix;
    }
    
    private static boolean isPortrait(Bitmap paramBitmap)
    {
      return paramBitmap.getWidth() <= paramBitmap.getHeight();
    }
    
    /* Error */
    private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +89 -> 90
      //   4: aload_0
      //   5: getfield 59	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
      //   8: astore 4
      //   10: aload 4
      //   12: ifnull +78 -> 90
      //   15: aconst_null
      //   16: astore_3
      //   17: aload 4
      //   19: invokevirtual 179	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   22: aload_1
      //   23: invokevirtual 185	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
      //   26: astore_1
      //   27: aload_1
      //   28: aconst_null
      //   29: aload_2
      //   30: invokestatic 191	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   33: astore_2
      //   34: aload_1
      //   35: ifnull +19 -> 54
      //   38: aload_1
      //   39: invokevirtual 196	java/io/InputStream:close	()V
      //   42: aload_2
      //   43: areturn
      //   44: astore_1
      //   45: ldc 25
      //   47: ldc 198
      //   49: aload_1
      //   50: invokestatic 204	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   53: pop
      //   54: aload_2
      //   55: areturn
      //   56: astore_3
      //   57: aload_1
      //   58: astore_2
      //   59: aload_3
      //   60: astore_1
      //   61: goto +6 -> 67
      //   64: astore_1
      //   65: aload_3
      //   66: astore_2
      //   67: aload_2
      //   68: ifnull +20 -> 88
      //   71: aload_2
      //   72: invokevirtual 196	java/io/InputStream:close	()V
      //   75: goto +13 -> 88
      //   78: astore_2
      //   79: ldc 25
      //   81: ldc 198
      //   83: aload_2
      //   84: invokestatic 204	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   87: pop
      //   88: aload_1
      //   89: athrow
      //   90: new 206	java/lang/IllegalArgumentException
      //   93: dup
      //   94: ldc 208
      //   96: invokespecial 211	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	PrintHelperApi19
      //   0	100	1	paramUri	Uri
      //   0	100	2	paramOptions	BitmapFactory.Options
      //   16	1	3	localObject1	Object
      //   56	10	3	localObject2	Object
      //   8	10	4	localContext	Context
      // Exception table:
      //   from	to	target	type
      //   38	42	44	java/io/IOException
      //   27	34	56	finally
      //   17	27	64	finally
      //   71	75	78	java/io/IOException
    }
    
    /* Error */
    private Bitmap loadConstrainedBitmap(Uri paramUri)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +219 -> 220
      //   4: aload_0
      //   5: getfield 59	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
      //   8: ifnull +212 -> 220
      //   11: new 213	android/graphics/BitmapFactory$Options
      //   14: dup
      //   15: invokespecial 214	android/graphics/BitmapFactory$Options:<init>	()V
      //   18: astore 6
      //   20: aload 6
      //   22: iconst_1
      //   23: putfield 217	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   26: aload_0
      //   27: aload_1
      //   28: aload 6
      //   30: invokespecial 219	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   33: pop
      //   34: aload 6
      //   36: getfield 222	android/graphics/BitmapFactory$Options:outWidth	I
      //   39: istore 4
      //   41: aload 6
      //   43: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
      //   46: istore 5
      //   48: iload 4
      //   50: ifle +168 -> 218
      //   53: iload 5
      //   55: ifgt +5 -> 60
      //   58: aconst_null
      //   59: areturn
      //   60: iload 4
      //   62: iload 5
      //   64: invokestatic 228	java/lang/Math:max	(II)I
      //   67: istore_3
      //   68: iconst_1
      //   69: istore_2
      //   70: iload_3
      //   71: sipush 3500
      //   74: if_icmple +14 -> 88
      //   77: iload_3
      //   78: iconst_1
      //   79: iushr
      //   80: istore_3
      //   81: iload_2
      //   82: iconst_1
      //   83: ishl
      //   84: istore_2
      //   85: goto -15 -> 70
      //   88: iload_2
      //   89: ifle +127 -> 216
      //   92: iload 4
      //   94: iload 5
      //   96: invokestatic 230	java/lang/Math:min	(II)I
      //   99: iload_2
      //   100: idiv
      //   101: ifgt +5 -> 106
      //   104: aconst_null
      //   105: areturn
      //   106: aload_0
      //   107: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   110: astore 6
      //   112: aload 6
      //   114: monitorenter
      //   115: aload_0
      //   116: new 213	android/graphics/BitmapFactory$Options
      //   119: dup
      //   120: invokespecial 214	android/graphics/BitmapFactory$Options:<init>	()V
      //   123: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   126: aload_0
      //   127: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   130: iconst_1
      //   131: putfield 233	android/graphics/BitmapFactory$Options:inMutable	Z
      //   134: aload_0
      //   135: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   138: iload_2
      //   139: putfield 236	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   142: aload_0
      //   143: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   146: astore 7
      //   148: aload 6
      //   150: monitorexit
      //   151: aload_0
      //   152: aload_1
      //   153: aload 7
      //   155: invokespecial 219	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   158: astore 6
      //   160: aload_0
      //   161: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   164: astore_1
      //   165: aload_1
      //   166: monitorenter
      //   167: aload_0
      //   168: aconst_null
      //   169: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   172: aload_1
      //   173: monitorexit
      //   174: aload 6
      //   176: areturn
      //   177: astore 6
      //   179: aload_1
      //   180: monitorexit
      //   181: aload 6
      //   183: athrow
      //   184: astore 6
      //   186: aload_0
      //   187: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   190: astore_1
      //   191: aload_1
      //   192: monitorenter
      //   193: aload_0
      //   194: aconst_null
      //   195: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   198: aload_1
      //   199: monitorexit
      //   200: aload 6
      //   202: athrow
      //   203: astore 6
      //   205: aload_1
      //   206: monitorexit
      //   207: aload 6
      //   209: athrow
      //   210: astore_1
      //   211: aload 6
      //   213: monitorexit
      //   214: aload_1
      //   215: athrow
      //   216: aconst_null
      //   217: areturn
      //   218: aconst_null
      //   219: areturn
      //   220: new 206	java/lang/IllegalArgumentException
      //   223: dup
      //   224: ldc 238
      //   226: invokespecial 211	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   229: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	230	0	this	PrintHelperApi19
      //   0	230	1	paramUri	Uri
      //   69	70	2	i	int
      //   67	14	3	j	int
      //   39	54	4	k	int
      //   46	49	5	m	int
      //   18	157	6	localObject1	Object
      //   177	5	6	localObject2	Object
      //   184	17	6	localObject3	Object
      //   203	9	6	localObject4	Object
      //   146	8	7	localOptions	BitmapFactory.Options
      // Exception table:
      //   from	to	target	type
      //   167	174	177	finally
      //   179	181	177	finally
      //   151	160	184	finally
      //   193	200	203	finally
      //   205	207	203	finally
      //   115	151	210	finally
      //   211	214	210	finally
    }
    
    private void writeBitmap(final PrintAttributes paramPrintAttributes, final int paramInt, final Bitmap paramBitmap, final ParcelFileDescriptor paramParcelFileDescriptor, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      final PrintAttributes localPrintAttributes;
      if (this.mIsMinMarginsHandlingCorrect) {
        localPrintAttributes = paramPrintAttributes;
      } else {
        localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
      }
      new AsyncTask()
      {
        /* Error */
        protected Throwable doInBackground(Void... paramAnonymousVarArgs)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 34	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   4: invokevirtual 67	android/os/CancellationSignal:isCanceled	()Z
          //   7: ifeq +5 -> 12
          //   10: aconst_null
          //   11: areturn
          //   12: new 69	android/print/pdf/PrintedPdfDocument
          //   15: dup
          //   16: aload_0
          //   17: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   20: getfield 73	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
          //   23: aload_0
          //   24: getfield 36	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$pdfAttributes	Landroid/print/PrintAttributes;
          //   27: invokespecial 76	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   30: astore 4
          //   32: aload_0
          //   33: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   36: aload_0
          //   37: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
          //   40: aload_0
          //   41: getfield 36	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$pdfAttributes	Landroid/print/PrintAttributes;
          //   44: invokevirtual 82	android/print/PrintAttributes:getColorMode	()I
          //   47: invokestatic 86	android/support/v4/print/PrintHelper$PrintHelperApi19:access$100	(Landroid/support/v4/print/PrintHelper$PrintHelperApi19;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
          //   50: astore_3
          //   51: aload_0
          //   52: getfield 34	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   55: invokevirtual 67	android/os/CancellationSignal:isCanceled	()Z
          //   58: istore_2
          //   59: iload_2
          //   60: ifeq +5 -> 65
          //   63: aconst_null
          //   64: areturn
          //   65: aload 4
          //   67: iconst_1
          //   68: invokevirtual 90	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   71: astore 5
          //   73: aload_0
          //   74: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   77: getfield 94	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
          //   80: ifeq +22 -> 102
          //   83: new 96	android/graphics/RectF
          //   86: dup
          //   87: aload 5
          //   89: invokevirtual 102	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   92: invokevirtual 108	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   95: invokespecial 111	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   98: astore_1
          //   99: goto +59 -> 158
          //   102: new 69	android/print/pdf/PrintedPdfDocument
          //   105: dup
          //   106: aload_0
          //   107: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   110: getfield 73	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
          //   113: aload_0
          //   114: getfield 40	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$attributes	Landroid/print/PrintAttributes;
          //   117: invokespecial 76	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
          //   120: astore 6
          //   122: aload 6
          //   124: iconst_1
          //   125: invokevirtual 90	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
          //   128: astore 7
          //   130: new 96	android/graphics/RectF
          //   133: dup
          //   134: aload 7
          //   136: invokevirtual 102	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
          //   139: invokevirtual 108	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
          //   142: invokespecial 111	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
          //   145: astore_1
          //   146: aload 6
          //   148: aload 7
          //   150: invokevirtual 115	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   153: aload 6
          //   155: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
          //   158: aload_0
          //   159: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   162: aload_3
          //   163: invokevirtual 123	android/graphics/Bitmap:getWidth	()I
          //   166: aload_3
          //   167: invokevirtual 126	android/graphics/Bitmap:getHeight	()I
          //   170: aload_1
          //   171: aload_0
          //   172: getfield 42	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fittingMode	I
          //   175: invokestatic 130	android/support/v4/print/PrintHelper$PrintHelperApi19:access$200	(Landroid/support/v4/print/PrintHelper$PrintHelperApi19;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
          //   178: astore 6
          //   180: aload_0
          //   181: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
          //   184: getfield 94	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
          //   187: ifeq +6 -> 193
          //   190: goto +27 -> 217
          //   193: aload 6
          //   195: aload_1
          //   196: getfield 134	android/graphics/RectF:left	F
          //   199: aload_1
          //   200: getfield 137	android/graphics/RectF:top	F
          //   203: invokevirtual 143	android/graphics/Matrix:postTranslate	(FF)Z
          //   206: pop
          //   207: aload 5
          //   209: invokevirtual 147	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   212: aload_1
          //   213: invokevirtual 153	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
          //   216: pop
          //   217: aload 5
          //   219: invokevirtual 147	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
          //   222: aload_3
          //   223: aload 6
          //   225: aconst_null
          //   226: invokevirtual 157	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
          //   229: aload 4
          //   231: aload 5
          //   233: invokevirtual 115	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
          //   236: aload_0
          //   237: getfield 34	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
          //   240: invokevirtual 67	android/os/CancellationSignal:isCanceled	()Z
          //   243: istore_2
          //   244: iload_2
          //   245: ifeq +38 -> 283
          //   248: aload 4
          //   250: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
          //   253: aload_0
          //   254: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   257: astore_1
          //   258: aload_1
          //   259: ifnull +10 -> 269
          //   262: aload_0
          //   263: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   266: invokevirtual 160	android/os/ParcelFileDescriptor:close	()V
          //   269: aload_3
          //   270: aload_0
          //   271: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
          //   274: if_acmpeq +7 -> 281
          //   277: aload_3
          //   278: invokevirtual 163	android/graphics/Bitmap:recycle	()V
          //   281: aconst_null
          //   282: areturn
          //   283: aload 4
          //   285: new 165	java/io/FileOutputStream
          //   288: dup
          //   289: aload_0
          //   290: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   293: invokevirtual 169	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
          //   296: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
          //   299: invokevirtual 176	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
          //   302: aload 4
          //   304: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
          //   307: aload_0
          //   308: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   311: astore_1
          //   312: aload_1
          //   313: ifnull +10 -> 323
          //   316: aload_0
          //   317: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   320: invokevirtual 160	android/os/ParcelFileDescriptor:close	()V
          //   323: aload_3
          //   324: aload_0
          //   325: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
          //   328: if_acmpeq +63 -> 391
          //   331: aload_3
          //   332: invokevirtual 163	android/graphics/Bitmap:recycle	()V
          //   335: aconst_null
          //   336: areturn
          //   337: astore_1
          //   338: aload 4
          //   340: invokevirtual 118	android/print/pdf/PrintedPdfDocument:close	()V
          //   343: aload_0
          //   344: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   347: astore 4
          //   349: aload 4
          //   351: ifnull +10 -> 361
          //   354: aload_0
          //   355: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
          //   358: invokevirtual 160	android/os/ParcelFileDescriptor:close	()V
          //   361: aload_3
          //   362: aload_0
          //   363: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
          //   366: if_acmpeq +7 -> 373
          //   369: aload_3
          //   370: invokevirtual 163	android/graphics/Bitmap:recycle	()V
          //   373: aload_1
          //   374: athrow
          //   375: astore_1
          //   376: aload_1
          //   377: areturn
          //   378: astore_1
          //   379: goto -110 -> 269
          //   382: astore_1
          //   383: goto -60 -> 323
          //   386: astore 4
          //   388: goto -27 -> 361
          //   391: aconst_null
          //   392: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	393	0	this	2
          //   0	393	1	paramAnonymousVarArgs	Void[]
          //   58	187	2	bool	boolean
          //   50	320	3	localBitmap	Bitmap
          //   30	320	4	localObject1	Object
          //   386	1	4	localIOException	java.io.IOException
          //   71	161	5	localPage1	android.graphics.pdf.PdfDocument.Page
          //   120	104	6	localObject2	Object
          //   128	21	7	localPage2	android.graphics.pdf.PdfDocument.Page
          // Exception table:
          //   from	to	target	type
          //   65	99	337	finally
          //   102	158	337	finally
          //   158	190	337	finally
          //   193	217	337	finally
          //   217	244	337	finally
          //   283	302	337	finally
          //   0	10	375	java/lang/Throwable
          //   12	59	375	java/lang/Throwable
          //   248	258	375	java/lang/Throwable
          //   262	269	375	java/lang/Throwable
          //   269	281	375	java/lang/Throwable
          //   302	312	375	java/lang/Throwable
          //   316	323	375	java/lang/Throwable
          //   323	335	375	java/lang/Throwable
          //   338	349	375	java/lang/Throwable
          //   354	361	375	java/lang/Throwable
          //   361	373	375	java/lang/Throwable
          //   373	375	375	java/lang/Throwable
          //   262	269	378	java/io/IOException
          //   316	323	382	java/io/IOException
          //   354	361	386	java/io/IOException
        }
        
        protected void onPostExecute(Throwable paramAnonymousThrowable)
        {
          if (paramCancellationSignal.isCanceled())
          {
            paramWriteResultCallback.onWriteCancelled();
            return;
          }
          if (paramAnonymousThrowable == null)
          {
            paramWriteResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
            return;
          }
          Log.e("PrintHelperApi19", "Error writing printed content", paramAnonymousThrowable);
          paramWriteResultCallback.onWriteFailed(null);
        }
      }.execute(new Void[0]);
    }
    
    protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
    {
      PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
      if (paramPrintAttributes.getColorMode() != 0) {
        localBuilder.setColorMode(paramPrintAttributes.getColorMode());
      }
      return localBuilder;
    }
    
    public int getColorMode()
    {
      return this.mColorMode;
    }
    
    public int getOrientation()
    {
      int i = this.mOrientation;
      if (i == 0) {
        return 1;
      }
      return i;
    }
    
    public int getScaleMode()
    {
      return this.mScaleMode;
    }
    
    public void printBitmap(final String paramString, final Bitmap paramBitmap, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    {
      if (paramBitmap == null) {
        return;
      }
      final int i = this.mScaleMode;
      PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
      if (isPortrait(paramBitmap)) {
        localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      } else {
        localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      }
      Object localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        
        public void onFinish()
        {
          PrintHelper.OnPrintFinishCallback localOnPrintFinishCallback = paramOnPrintFinishCallback;
          if (localOnPrintFinishCallback != null) {
            localOnPrintFinishCallback.onFinish();
          }
        }
        
        public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          this.mAttributes = paramAnonymousPrintAttributes2;
          paramAnonymousLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build(), paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1) ^ true);
        }
        
        public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, i, paramBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
        }
      }, (PrintAttributes)localObject);
    }
    
    public void printBitmap(final String paramString, final Uri paramUri, final PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
    {
      paramUri = new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        Bitmap mBitmap = null;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        
        private void cancelLoad()
        {
          synchronized (PrintHelper.PrintHelperApi19.this.mLock)
          {
            if (PrintHelper.PrintHelperApi19.this.mDecodeOptions != null)
            {
              PrintHelper.PrintHelperApi19.this.mDecodeOptions.requestCancelDecode();
              PrintHelper.PrintHelperApi19.this.mDecodeOptions = null;
            }
            return;
          }
        }
        
        public void onFinish()
        {
          super.onFinish();
          cancelLoad();
          Object localObject = this.mLoadBitmap;
          if (localObject != null) {
            ((AsyncTask)localObject).cancel(true);
          }
          localObject = paramOnPrintFinishCallback;
          if (localObject != null) {
            ((PrintHelper.OnPrintFinishCallback)localObject).onFinish();
          }
          localObject = this.mBitmap;
          if (localObject != null)
          {
            ((Bitmap)localObject).recycle();
            this.mBitmap = null;
          }
        }
        
        public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          try
          {
            this.mAttributes = paramAnonymousPrintAttributes2;
            if (paramAnonymousCancellationSignal.isCanceled())
            {
              paramAnonymousLayoutResultCallback.onLayoutCancelled();
              return;
            }
            if (this.mBitmap != null)
            {
              paramAnonymousLayoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build(), paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1) ^ true);
              return;
            }
            this.mLoadBitmap = new AsyncTask()
            {
              protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
              {
                try
                {
                  paramAnonymous2VarArgs = PrintHelper.PrintHelperApi19.this.loadConstrainedBitmap(PrintHelper.PrintHelperApi19.3.this.val$imageFile);
                  return paramAnonymous2VarArgs;
                }
                catch (FileNotFoundException paramAnonymous2VarArgs)
                {
                  label20:
                  break label20;
                }
                return null;
              }
              
              protected void onCancelled(Bitmap paramAnonymous2Bitmap)
              {
                paramAnonymousLayoutResultCallback.onLayoutCancelled();
                PrintHelper.PrintHelperApi19.3.this.mLoadBitmap = null;
              }
              
              protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
              {
                super.onPostExecute(paramAnonymous2Bitmap);
                Object localObject = paramAnonymous2Bitmap;
                if (paramAnonymous2Bitmap != null) {
                  if (PrintHelper.PrintHelperApi19.this.mPrintActivityRespectsOrientation)
                  {
                    localObject = paramAnonymous2Bitmap;
                    if (PrintHelper.PrintHelperApi19.this.mOrientation != 0) {}
                  }
                  else
                  {
                    try
                    {
                      PrintAttributes.MediaSize localMediaSize = PrintHelper.PrintHelperApi19.3.this.mAttributes.getMediaSize();
                      localObject = paramAnonymous2Bitmap;
                      if (localMediaSize != null)
                      {
                        localObject = paramAnonymous2Bitmap;
                        if (localMediaSize.isPortrait() != PrintHelper.PrintHelperApi19.isPortrait(paramAnonymous2Bitmap))
                        {
                          localObject = new Matrix();
                          ((Matrix)localObject).postRotate(90.0F);
                          localObject = Bitmap.createBitmap(paramAnonymous2Bitmap, 0, 0, paramAnonymous2Bitmap.getWidth(), paramAnonymous2Bitmap.getHeight(), (Matrix)localObject, true);
                        }
                      }
                    }
                    finally {}
                  }
                }
                paramAnonymous2Bitmap = PrintHelper.PrintHelperApi19.3.this;
                paramAnonymous2Bitmap.mBitmap = ((Bitmap)localObject);
                if (localObject != null)
                {
                  paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(paramAnonymous2Bitmap.val$jobName).setContentType(1).setPageCount(1).build();
                  boolean bool = paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1);
                  paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, true ^ bool);
                }
                else
                {
                  paramAnonymousLayoutResultCallback.onLayoutFailed(null);
                }
                PrintHelper.PrintHelperApi19.3.this.mLoadBitmap = null;
              }
              
              protected void onPreExecute()
              {
                paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
                {
                  public void onCancel()
                  {
                    PrintHelper.PrintHelperApi19.3.this.cancelLoad();
                    PrintHelper.PrintHelperApi19.3.1.this.cancel(false);
                  }
                });
              }
            }.execute(new Uri[0]);
            return;
          }
          finally {}
        }
        
        public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
        }
      };
      paramOnPrintFinishCallback = (PrintManager)this.mContext.getSystemService("print");
      PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
      localBuilder.setColorMode(this.mColorMode);
      int i = this.mOrientation;
      if ((i != 1) && (i != 0))
      {
        if (i == 2) {
          localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
      }
      else {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
      }
      paramOnPrintFinishCallback.print(paramString, paramUri, localBuilder.build());
    }
    
    public void setColorMode(int paramInt)
    {
      this.mColorMode = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      this.mOrientation = paramInt;
    }
    
    public void setScaleMode(int paramInt)
    {
      this.mScaleMode = paramInt;
    }
  }
  
  @RequiresApi(20)
  private static class PrintHelperApi20
    extends PrintHelper.PrintHelperApi19
  {
    PrintHelperApi20(Context paramContext)
    {
      super();
      this.mPrintActivityRespectsOrientation = false;
    }
  }
  
  @RequiresApi(23)
  private static class PrintHelperApi23
    extends PrintHelper.PrintHelperApi20
  {
    PrintHelperApi23(Context paramContext)
    {
      super();
      this.mIsMinMarginsHandlingCorrect = false;
    }
    
    protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
    {
      PrintAttributes.Builder localBuilder = super.copyAttributes(paramPrintAttributes);
      if (paramPrintAttributes.getDuplexMode() != 0) {
        localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
      }
      return localBuilder;
    }
  }
  
  @RequiresApi(24)
  private static class PrintHelperApi24
    extends PrintHelper.PrintHelperApi23
  {
    PrintHelperApi24(Context paramContext)
    {
      super();
      this.mIsMinMarginsHandlingCorrect = true;
      this.mPrintActivityRespectsOrientation = true;
    }
  }
  
  private static final class PrintHelperStub
    implements PrintHelper.PrintHelperVersionImpl
  {
    int mColorMode = 2;
    int mOrientation = 1;
    int mScaleMode = 2;
    
    public int getColorMode()
    {
      return this.mColorMode;
    }
    
    public int getOrientation()
    {
      return this.mOrientation;
    }
    
    public int getScaleMode()
    {
      return this.mScaleMode;
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback) {}
    
    public void setColorMode(int paramInt)
    {
      this.mColorMode = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      this.mOrientation = paramInt;
    }
    
    public void setScaleMode(int paramInt)
    {
      this.mScaleMode = paramInt;
    }
  }
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getOrientation();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
    
    public abstract void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback);
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  private static @interface ScaleMode {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper
 * JD-Core Version:    0.7.0.1
 */