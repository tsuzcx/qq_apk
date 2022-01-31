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
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintManager;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(19)
class PrintHelper$PrintHelperApi19
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
  
  PrintHelper$PrintHelperApi19(Context paramContext)
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
    //   7: getfield 47	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
    //   10: ifnonnull +13 -> 23
    //   13: new 163	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc 201
    //   19: invokespecial 168	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: new 203	android/graphics/BitmapFactory$Options
    //   26: dup
    //   27: invokespecial 204	android/graphics/BitmapFactory$Options:<init>	()V
    //   30: astore 6
    //   32: aload 6
    //   34: iconst_1
    //   35: putfield 207	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   38: aload_0
    //   39: aload_1
    //   40: aload 6
    //   42: invokespecial 209	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   45: pop
    //   46: aload 6
    //   48: getfield 212	android/graphics/BitmapFactory$Options:outWidth	I
    //   51: istore 4
    //   53: aload 6
    //   55: getfield 215	android/graphics/BitmapFactory$Options:outHeight	I
    //   58: istore 5
    //   60: iload 4
    //   62: ifle +8 -> 70
    //   65: iload 5
    //   67: ifgt +5 -> 72
    //   70: aconst_null
    //   71: areturn
    //   72: iload 4
    //   74: iload 5
    //   76: invokestatic 218	java/lang/Math:max	(II)I
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
    //   106: invokestatic 220	java/lang/Math:min	(II)I
    //   109: iload_2
    //   110: idiv
    //   111: ifle -41 -> 70
    //   114: aload_0
    //   115: getfield 37	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
    //   118: astore 6
    //   120: aload 6
    //   122: monitorenter
    //   123: aload_0
    //   124: new 203	android/graphics/BitmapFactory$Options
    //   127: dup
    //   128: invokespecial 204	android/graphics/BitmapFactory$Options:<init>	()V
    //   131: putfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   134: aload_0
    //   135: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   138: iconst_1
    //   139: putfield 223	android/graphics/BitmapFactory$Options:inMutable	Z
    //   142: aload_0
    //   143: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   146: iload_2
    //   147: putfield 226	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   150: aload_0
    //   151: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
    //   154: astore 7
    //   156: aload 6
    //   158: monitorexit
    //   159: aload_0
    //   160: aload_1
    //   161: aload 7
    //   163: invokespecial 209	android/support/v4/print/PrintHelper$PrintHelperApi19:loadBitmap	(Landroid/net/Uri;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   166: astore 6
    //   168: aload_0
    //   169: getfield 37	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
    //   172: astore_1
    //   173: aload_1
    //   174: monitorenter
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
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
    //   201: getfield 37	android/support/v4/print/PrintHelper$PrintHelperApi19:mLock	Ljava/lang/Object;
    //   204: astore_1
    //   205: aload_1
    //   206: monitorenter
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19:mDecodeOptions	Landroid/graphics/BitmapFactory$Options;
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
  
  private void writeBitmap(PrintAttributes paramPrintAttributes, int paramInt, Bitmap paramBitmap, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    if (this.mIsMinMarginsHandlingCorrect) {}
    for (PrintAttributes localPrintAttributes = paramPrintAttributes;; localPrintAttributes = copyAttributes(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build())
    {
      new PrintHelper.PrintHelperApi19.2(this, paramCancellationSignal, localPrintAttributes, paramBitmap, paramPrintAttributes, paramInt, paramParcelFileDescriptor, paramWriteResultCallback).execute(new Void[0]);
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
  
  public void printBitmap(String paramString, Bitmap paramBitmap, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if (paramBitmap == null) {
      return;
    }
    int i = this.mScaleMode;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    if (isPortrait(paramBitmap)) {}
    for (Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;; localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE)
    {
      localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintHelper.PrintHelperApi19.1(this, paramString, i, paramBitmap, paramOnPrintFinishCallback), (PrintAttributes)localObject);
      return;
    }
  }
  
  public void printBitmap(String paramString, Uri paramUri, PrintHelper.OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    paramUri = new PrintHelper.PrintHelperApi19.3(this, paramString, paramUri, paramOnPrintFinishCallback, this.mScaleMode);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperApi19
 * JD-Core Version:    0.7.0.1
 */