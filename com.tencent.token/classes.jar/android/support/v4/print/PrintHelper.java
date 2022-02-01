package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
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
import java.io.IOException;
import java.io.InputStream;
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
      float f = paramRectF.width() / paramInt1;
      if (paramInt3 == 2) {}
      for (f = Math.max(f, paramRectF.height() / paramInt2);; f = Math.min(f, paramRectF.height() / paramInt2))
      {
        localMatrix.postScale(f, f);
        localMatrix.postTranslate((paramRectF.width() - paramInt1 * f) / 2.0F, (paramRectF.height() - f * paramInt2) / 2.0F);
        return localMatrix;
      }
    }
    
    private static boolean isPortrait(Bitmap paramBitmap)
    {
      return paramBitmap.getWidth() <= paramBitmap.getHeight();
    }
    
    private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    {
      localUri = null;
      if ((paramUri == null) || (this.mContext == null)) {
        throw new IllegalArgumentException("bad argument to loadBitmap");
      }
      try
      {
        paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
        localUri = paramUri;
        paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
        if (paramUri != null) {}
        try
        {
          paramUri.close();
          return paramOptions;
        }
        catch (IOException paramUri)
        {
          Log.w("PrintHelperApi19", "close fail ", paramUri);
          return paramOptions;
        }
        try
        {
          localUri.close();
          throw paramUri;
        }
        catch (IOException paramOptions)
        {
          for (;;)
          {
            Log.w("PrintHelperApi19", "close fail ", paramOptions);
          }
        }
      }
      finally
      {
        if (localUri == null) {}
      }
    }
    
    /* Error */
    private Bitmap loadConstrainedBitmap(Uri paramUri)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_1
      //   3: ifnull +10 -> 13
      //   6: aload_0
      //   7: getfield 59	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
      //   10: ifnonnull +13 -> 23
      //   13: new 175	java/lang/IllegalArgumentException
      //   16: dup
      //   17: ldc 213
      //   19: invokespecial 180	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
      //   22: athrow
      //   23: new 215	android/graphics/BitmapFactory$Options
      //   26: dup
      //   27: invokespecial 216	android/graphics/BitmapFactory$Options:<init>	()V
      //   30: astore 6
      //   32: aload 6
      //   34: iconst_1
      //   35: putfield 219	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   38: aload_0
      //   39: aload_1
      //   40: aload 6
      //   42: invokespecial 221	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   45: pop
      //   46: aload 6
      //   48: getfield 224	android/graphics/BitmapFactory$Options:outWidth	I
      //   51: istore 4
      //   53: aload 6
      //   55: getfield 227	android/graphics/BitmapFactory$Options:outHeight	I
      //   58: istore 5
      //   60: iload 4
      //   62: ifle +8 -> 70
      //   65: iload 5
      //   67: ifgt +5 -> 72
      //   70: aconst_null
      //   71: areturn
      //   72: iload 4
      //   74: iload 5
      //   76: invokestatic 230	java/lang/Math:max	(II)I
      //   79: istore_3
      //   80: iload_3
      //   81: sipush 3500
      //   84: if_icmple +14 -> 98
      //   87: iload_3
      //   88: iconst_1
      //   89: iushr
      //   90: istore_3
      //   91: iload_2
      //   92: iconst_1
      //   93: ishl
      //   94: istore_2
      //   95: goto -15 -> 80
      //   98: iload_2
      //   99: ifle -29 -> 70
      //   102: iload 4
      //   104: iload 5
      //   106: invokestatic 232	java/lang/Math:min	(II)I
      //   109: iload_2
      //   110: idiv
      //   111: ifle -41 -> 70
      //   114: aload_0
      //   115: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   118: astore 6
      //   120: aload 6
      //   122: monitorenter
      //   123: aload_0
      //   124: new 215	android/graphics/BitmapFactory$Options
      //   127: dup
      //   128: invokespecial 216	android/graphics/BitmapFactory$Options:<init>	()V
      //   131: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   134: aload_0
      //   135: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   138: iconst_1
      //   139: putfield 235	android/graphics/BitmapFactory$Options:inMutable	Z
      //   142: aload_0
      //   143: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   146: iload_2
      //   147: putfield 238	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   150: aload_0
      //   151: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   154: astore 7
      //   156: aload 6
      //   158: monitorexit
      //   159: aload_0
      //   160: aload_1
      //   161: aload 7
      //   163: invokespecial 221	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   166: astore 6
      //   168: aload_0
      //   169: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   172: astore_1
      //   173: aload_1
      //   174: monitorenter
      //   175: aload_0
      //   176: aconst_null
      //   177: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   180: aload_1
      //   181: monitorexit
      //   182: aload 6
      //   184: areturn
      //   185: astore 6
      //   187: aload_1
      //   188: monitorexit
      //   189: aload 6
      //   191: athrow
      //   192: astore_1
      //   193: aload 6
      //   195: monitorexit
      //   196: aload_1
      //   197: athrow
      //   198: astore 6
      //   200: aload_0
      //   201: getfield 49	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
      //   204: astore_1
      //   205: aload_1
      //   206: monitorenter
      //   207: aload_0
      //   208: aconst_null
      //   209: putfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
      //   212: aload_1
      //   213: monitorexit
      //   214: aload 6
      //   216: athrow
      //   217: astore 6
      //   219: aload_1
      //   220: monitorexit
      //   221: aload 6
      //   223: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	224	0	this	PrintHelperApi19
      //   0	224	1	paramUri	Uri
      //   1	146	2	i	int
      //   79	12	3	j	int
      //   51	52	4	k	int
      //   58	47	5	m	int
      //   30	153	6	localObject1	Object
      //   185	9	6	localObject2	Object
      //   198	17	6	localObject3	Object
      //   217	5	6	localObject4	Object
      //   154	8	7	localOptions	BitmapFactory.Options
      // Exception table:
      //   from	to	target	type
      //   175	182	185	finally
      //   187	189	185	finally
      //   123	159	192	finally
      //   193	196	192	finally
      //   159	168	198	finally
      //   207	214	217	finally
      //   219	221	217	finally
    }
    
    private void writeBitmap(final PrintAttributes paramPrintAttributes, final int paramInt, final Bitmap paramBitmap, final ParcelFileDescriptor paramParcelFileDescriptor, final CancellationSignal paramCancellationSignal, final PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
    {
      if (this.mIsMinMarginsHandlingCorrect) {}
      for (final PrintAttributes localPrintAttributes = paramPrintAttributes;; localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build())
      {
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
            //   60: ifne +329 -> 389
            //   63: aload 4
            //   65: iconst_1
            //   66: invokevirtual 90	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
            //   69: astore 5
            //   71: aload_0
            //   72: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
            //   75: getfield 94	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
            //   78: ifeq +120 -> 198
            //   81: new 96	android/graphics/RectF
            //   84: dup
            //   85: aload 5
            //   87: invokevirtual 102	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
            //   90: invokevirtual 108	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
            //   93: invokespecial 111	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
            //   96: astore_1
            //   97: aload_0
            //   98: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
            //   101: aload_3
            //   102: invokevirtual 116	android/graphics/Bitmap:getWidth	()I
            //   105: aload_3
            //   106: invokevirtual 119	android/graphics/Bitmap:getHeight	()I
            //   109: aload_1
            //   110: aload_0
            //   111: getfield 42	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fittingMode	I
            //   114: invokestatic 123	android/support/v4/print/PrintHelper$PrintHelperApi19:access$200	(Landroid/support/v4/print/PrintHelper$PrintHelperApi19;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
            //   117: astore 6
            //   119: aload_0
            //   120: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
            //   123: getfield 94	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
            //   126: ifeq +169 -> 295
            //   129: aload 5
            //   131: invokevirtual 127	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
            //   134: aload_3
            //   135: aload 6
            //   137: aconst_null
            //   138: invokevirtual 133	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
            //   141: aload 4
            //   143: aload 5
            //   145: invokevirtual 137	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
            //   148: aload_0
            //   149: getfield 34	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
            //   152: invokevirtual 67	android/os/CancellationSignal:isCanceled	()Z
            //   155: istore_2
            //   156: iload_2
            //   157: ifeq +165 -> 322
            //   160: aload 4
            //   162: invokevirtual 140	android/print/pdf/PrintedPdfDocument:close	()V
            //   165: aload_0
            //   166: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   169: astore_1
            //   170: aload_1
            //   171: ifnull +10 -> 181
            //   174: aload_0
            //   175: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   178: invokevirtual 143	android/os/ParcelFileDescriptor:close	()V
            //   181: aload_3
            //   182: aload_0
            //   183: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
            //   186: if_acmpeq +203 -> 389
            //   189: aload_3
            //   190: invokevirtual 146	android/graphics/Bitmap:recycle	()V
            //   193: aconst_null
            //   194: areturn
            //   195: astore_1
            //   196: aload_1
            //   197: areturn
            //   198: new 69	android/print/pdf/PrintedPdfDocument
            //   201: dup
            //   202: aload_0
            //   203: getfield 32	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
            //   206: getfield 73	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
            //   209: aload_0
            //   210: getfield 40	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$attributes	Landroid/print/PrintAttributes;
            //   213: invokespecial 76	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
            //   216: astore 6
            //   218: aload 6
            //   220: iconst_1
            //   221: invokevirtual 90	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
            //   224: astore 7
            //   226: new 96	android/graphics/RectF
            //   229: dup
            //   230: aload 7
            //   232: invokevirtual 102	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
            //   235: invokevirtual 108	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
            //   238: invokespecial 111	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
            //   241: astore_1
            //   242: aload 6
            //   244: aload 7
            //   246: invokevirtual 137	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
            //   249: aload 6
            //   251: invokevirtual 140	android/print/pdf/PrintedPdfDocument:close	()V
            //   254: goto -157 -> 97
            //   257: astore_1
            //   258: aload 4
            //   260: invokevirtual 140	android/print/pdf/PrintedPdfDocument:close	()V
            //   263: aload_0
            //   264: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   267: astore 4
            //   269: aload 4
            //   271: ifnull +10 -> 281
            //   274: aload_0
            //   275: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   278: invokevirtual 143	android/os/ParcelFileDescriptor:close	()V
            //   281: aload_3
            //   282: aload_0
            //   283: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
            //   286: if_acmpeq +7 -> 293
            //   289: aload_3
            //   290: invokevirtual 146	android/graphics/Bitmap:recycle	()V
            //   293: aload_1
            //   294: athrow
            //   295: aload 6
            //   297: aload_1
            //   298: getfield 150	android/graphics/RectF:left	F
            //   301: aload_1
            //   302: getfield 153	android/graphics/RectF:top	F
            //   305: invokevirtual 159	android/graphics/Matrix:postTranslate	(FF)Z
            //   308: pop
            //   309: aload 5
            //   311: invokevirtual 127	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
            //   314: aload_1
            //   315: invokevirtual 163	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
            //   318: pop
            //   319: goto -190 -> 129
            //   322: aload 4
            //   324: new 165	java/io/FileOutputStream
            //   327: dup
            //   328: aload_0
            //   329: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   332: invokevirtual 169	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
            //   335: invokespecial 172	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
            //   338: invokevirtual 176	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
            //   341: aload 4
            //   343: invokevirtual 140	android/print/pdf/PrintedPdfDocument:close	()V
            //   346: aload_0
            //   347: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   350: astore_1
            //   351: aload_1
            //   352: ifnull +10 -> 362
            //   355: aload_0
            //   356: getfield 44	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
            //   359: invokevirtual 143	android/os/ParcelFileDescriptor:close	()V
            //   362: aload_3
            //   363: aload_0
            //   364: getfield 38	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
            //   367: if_acmpeq +22 -> 389
            //   370: aload_3
            //   371: invokevirtual 146	android/graphics/Bitmap:recycle	()V
            //   374: aconst_null
            //   375: areturn
            //   376: astore 4
            //   378: goto -97 -> 281
            //   381: astore_1
            //   382: goto -20 -> 362
            //   385: astore_1
            //   386: goto -205 -> 181
            //   389: aconst_null
            //   390: areturn
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	391	0	this	2
            //   0	391	1	paramAnonymousVarArgs	Void[]
            //   58	99	2	bool	boolean
            //   50	321	3	localBitmap	Bitmap
            //   30	312	4	localObject1	Object
            //   376	1	4	localIOException	IOException
            //   69	241	5	localPage1	android.graphics.pdf.PdfDocument.Page
            //   117	179	6	localObject2	Object
            //   224	21	7	localPage2	android.graphics.pdf.PdfDocument.Page
            // Exception table:
            //   from	to	target	type
            //   0	10	195	java/lang/Throwable
            //   12	59	195	java/lang/Throwable
            //   160	170	195	java/lang/Throwable
            //   174	181	195	java/lang/Throwable
            //   181	193	195	java/lang/Throwable
            //   258	269	195	java/lang/Throwable
            //   274	281	195	java/lang/Throwable
            //   281	293	195	java/lang/Throwable
            //   293	295	195	java/lang/Throwable
            //   341	351	195	java/lang/Throwable
            //   355	362	195	java/lang/Throwable
            //   362	374	195	java/lang/Throwable
            //   63	97	257	finally
            //   97	129	257	finally
            //   129	156	257	finally
            //   198	254	257	finally
            //   295	319	257	finally
            //   322	341	257	finally
            //   274	281	376	java/io/IOException
            //   355	362	381	java/io/IOException
            //   174	181	385	java/io/IOException
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
        return;
      }
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
      if (this.mOrientation == 0) {
        return 1;
      }
      return this.mOrientation;
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
      if (isPortrait(paramBitmap)) {}
      for (Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;; localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE)
      {
        localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
        localPrintManager.print(paramString, new PrintDocumentAdapter()
        {
          private PrintAttributes mAttributes;
          
          public void onFinish()
          {
            if (paramOnPrintFinishCallback != null) {
              paramOnPrintFinishCallback.onFinish();
            }
          }
          
          public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
          {
            boolean bool = true;
            this.mAttributes = paramAnonymousPrintAttributes2;
            paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
            if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
            for (;;)
            {
              paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
              return;
              bool = false;
            }
          }
          
          public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
          {
            PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, i, paramBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
          }
        }, (PrintAttributes)localObject);
        return;
      }
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
          if (this.mLoadBitmap != null) {
            this.mLoadBitmap.cancel(true);
          }
          if (paramOnPrintFinishCallback != null) {
            paramOnPrintFinishCallback.onFinish();
          }
          if (this.mBitmap != null)
          {
            this.mBitmap.recycle();
            this.mBitmap = null;
          }
        }
        
        public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          boolean bool = true;
          try
          {
            this.mAttributes = paramAnonymousPrintAttributes2;
            if (paramAnonymousCancellationSignal.isCanceled())
            {
              paramAnonymousLayoutResultCallback.onLayoutCancelled();
              return;
            }
          }
          finally {}
          if (this.mBitmap != null)
          {
            paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
            if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
            for (;;)
            {
              paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
              return;
              bool = false;
            }
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
              catch (FileNotFoundException paramAnonymous2VarArgs) {}
              return null;
            }
            
            protected void onCancelled(Bitmap paramAnonymous2Bitmap)
            {
              paramAnonymousLayoutResultCallback.onLayoutCancelled();
              PrintHelper.PrintHelperApi19.3.this.mLoadBitmap = null;
            }
            
            protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
            {
              boolean bool = true;
              super.onPostExecute(paramAnonymous2Bitmap);
              Object localObject = paramAnonymous2Bitmap;
              if (paramAnonymous2Bitmap != null) {
                if (PrintHelper.PrintHelperApi19.this.mPrintActivityRespectsOrientation)
                {
                  localObject = paramAnonymous2Bitmap;
                  if (PrintHelper.PrintHelperApi19.this.mOrientation != 0) {
                    break label110;
                  }
                }
              }
              for (;;)
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
                  label110:
                  PrintHelper.PrintHelperApi19.3.this.mBitmap = ((Bitmap)localObject);
                  if (localObject == null) {
                    break label190;
                  }
                  paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(PrintHelper.PrintHelperApi19.3.this.val$jobName).setContentType(1).setPageCount(1).build();
                  if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1))
                  {
                    paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, bool);
                    PrintHelper.PrintHelperApi19.3.this.mLoadBitmap = null;
                    return;
                  }
                }
                finally {}
                bool = false;
                continue;
                label190:
                paramAnonymousLayoutResultCallback.onLayoutFailed(null);
              }
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
        }
        
        public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          PrintHelper.PrintHelperApi19.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousCancellationSignal, paramAnonymousWriteResultCallback);
        }
      };
      paramOnPrintFinishCallback = (PrintManager)this.mContext.getSystemService("print");
      PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
      localBuilder.setColorMode(this.mColorMode);
      if ((this.mOrientation == 1) || (this.mOrientation == 0)) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
      }
      for (;;)
      {
        paramOnPrintFinishCallback.print(paramString, paramUri, localBuilder.build());
        return;
        if (this.mOrientation == 2) {
          localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
      }
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