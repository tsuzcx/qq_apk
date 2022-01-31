package android.support.v4.print;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.util.Log;

class PrintHelper$PrintHelperApi19$2
  extends AsyncTask
{
  PrintHelper$PrintHelperApi19$2(PrintHelper.PrintHelperApi19 paramPrintHelperApi19, CancellationSignal paramCancellationSignal, PrintAttributes paramPrintAttributes1, Bitmap paramBitmap, PrintAttributes paramPrintAttributes2, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {}
  
  /* Error */
  protected Throwable doInBackground(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   4: invokevirtual 58	android/os/CancellationSignal:isCanceled	()Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 60	android/print/pdf/PrintedPdfDocument
    //   15: dup
    //   16: aload_0
    //   17: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   20: getfield 66	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
    //   23: aload_0
    //   24: getfield 27	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$pdfAttributes	Landroid/print/PrintAttributes;
    //   27: invokespecial 69	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   36: aload_0
    //   37: getfield 29	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
    //   40: aload_0
    //   41: getfield 27	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$pdfAttributes	Landroid/print/PrintAttributes;
    //   44: invokevirtual 75	android/print/PrintAttributes:getColorMode	()I
    //   47: invokestatic 79	android/support/v4/print/PrintHelper$PrintHelperApi19:access$100	(Landroid/support/v4/print/PrintHelper$PrintHelperApi19;Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   50: astore_3
    //   51: aload_0
    //   52: getfield 25	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   55: invokevirtual 58	android/os/CancellationSignal:isCanceled	()Z
    //   58: istore_2
    //   59: iload_2
    //   60: ifne +329 -> 389
    //   63: aload 4
    //   65: iconst_1
    //   66: invokevirtual 83	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   69: astore 5
    //   71: aload_0
    //   72: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   75: getfield 87	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
    //   78: ifeq +120 -> 198
    //   81: new 89	android/graphics/RectF
    //   84: dup
    //   85: aload 5
    //   87: invokevirtual 95	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   90: invokevirtual 101	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   93: invokespecial 104	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   101: aload_3
    //   102: invokevirtual 109	android/graphics/Bitmap:getWidth	()I
    //   105: aload_3
    //   106: invokevirtual 112	android/graphics/Bitmap:getHeight	()I
    //   109: aload_1
    //   110: aload_0
    //   111: getfield 33	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fittingMode	I
    //   114: invokestatic 116	android/support/v4/print/PrintHelper$PrintHelperApi19:access$200	(Landroid/support/v4/print/PrintHelper$PrintHelperApi19;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   117: astore 6
    //   119: aload_0
    //   120: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   123: getfield 87	android/support/v4/print/PrintHelper$PrintHelperApi19:mIsMinMarginsHandlingCorrect	Z
    //   126: ifeq +169 -> 295
    //   129: aload 5
    //   131: invokevirtual 120	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   134: aload_3
    //   135: aload 6
    //   137: aconst_null
    //   138: invokevirtual 126	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   141: aload 4
    //   143: aload 5
    //   145: invokevirtual 130	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   148: aload_0
    //   149: getfield 25	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$cancellationSignal	Landroid/os/CancellationSignal;
    //   152: invokevirtual 58	android/os/CancellationSignal:isCanceled	()Z
    //   155: istore_2
    //   156: iload_2
    //   157: ifeq +165 -> 322
    //   160: aload 4
    //   162: invokevirtual 133	android/print/pdf/PrintedPdfDocument:close	()V
    //   165: aload_0
    //   166: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +10 -> 181
    //   174: aload_0
    //   175: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   178: invokevirtual 136	android/os/ParcelFileDescriptor:close	()V
    //   181: aload_3
    //   182: aload_0
    //   183: getfield 29	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
    //   186: if_acmpeq +203 -> 389
    //   189: aload_3
    //   190: invokevirtual 139	android/graphics/Bitmap:recycle	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_1
    //   196: aload_1
    //   197: areturn
    //   198: new 60	android/print/pdf/PrintedPdfDocument
    //   201: dup
    //   202: aload_0
    //   203: getfield 23	android/support/v4/print/PrintHelper$PrintHelperApi19$2:this$0	Landroid/support/v4/print/PrintHelper$PrintHelperApi19;
    //   206: getfield 66	android/support/v4/print/PrintHelper$PrintHelperApi19:mContext	Landroid/content/Context;
    //   209: aload_0
    //   210: getfield 31	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$attributes	Landroid/print/PrintAttributes;
    //   213: invokespecial 69	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   216: astore 6
    //   218: aload 6
    //   220: iconst_1
    //   221: invokevirtual 83	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   224: astore 7
    //   226: new 89	android/graphics/RectF
    //   229: dup
    //   230: aload 7
    //   232: invokevirtual 95	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   235: invokevirtual 101	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   238: invokespecial 104	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   241: astore_1
    //   242: aload 6
    //   244: aload 7
    //   246: invokevirtual 130	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   249: aload 6
    //   251: invokevirtual 133	android/print/pdf/PrintedPdfDocument:close	()V
    //   254: goto -157 -> 97
    //   257: astore_1
    //   258: aload 4
    //   260: invokevirtual 133	android/print/pdf/PrintedPdfDocument:close	()V
    //   263: aload_0
    //   264: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   267: astore 4
    //   269: aload 4
    //   271: ifnull +10 -> 281
    //   274: aload_0
    //   275: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   278: invokevirtual 136	android/os/ParcelFileDescriptor:close	()V
    //   281: aload_3
    //   282: aload_0
    //   283: getfield 29	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
    //   286: if_acmpeq +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 139	android/graphics/Bitmap:recycle	()V
    //   293: aload_1
    //   294: athrow
    //   295: aload 6
    //   297: aload_1
    //   298: getfield 143	android/graphics/RectF:left	F
    //   301: aload_1
    //   302: getfield 146	android/graphics/RectF:top	F
    //   305: invokevirtual 152	android/graphics/Matrix:postTranslate	(FF)Z
    //   308: pop
    //   309: aload 5
    //   311: invokevirtual 120	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   314: aload_1
    //   315: invokevirtual 156	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
    //   318: pop
    //   319: goto -190 -> 129
    //   322: aload 4
    //   324: new 158	java/io/FileOutputStream
    //   327: dup
    //   328: aload_0
    //   329: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   332: invokevirtual 162	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   335: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   338: invokevirtual 169	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   341: aload 4
    //   343: invokevirtual 133	android/print/pdf/PrintedPdfDocument:close	()V
    //   346: aload_0
    //   347: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   350: astore_1
    //   351: aload_1
    //   352: ifnull +10 -> 362
    //   355: aload_0
    //   356: getfield 35	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$fileDescriptor	Landroid/os/ParcelFileDescriptor;
    //   359: invokevirtual 136	android/os/ParcelFileDescriptor:close	()V
    //   362: aload_3
    //   363: aload_0
    //   364: getfield 29	android/support/v4/print/PrintHelper$PrintHelperApi19$2:val$bitmap	Landroid/graphics/Bitmap;
    //   367: if_acmpeq +22 -> 389
    //   370: aload_3
    //   371: invokevirtual 139	android/graphics/Bitmap:recycle	()V
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
    //   0	391	1	paramVarArgs	java.lang.Void[]
    //   58	99	2	bool	boolean
    //   50	321	3	localBitmap	Bitmap
    //   30	312	4	localObject1	java.lang.Object
    //   376	1	4	localIOException	java.io.IOException
    //   69	241	5	localPage1	android.graphics.pdf.PdfDocument.Page
    //   117	179	6	localObject2	java.lang.Object
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
  
  protected void onPostExecute(Throwable paramThrowable)
  {
    if (this.val$cancellationSignal.isCanceled())
    {
      this.val$writeResultCallback.onWriteCancelled();
      return;
    }
    if (paramThrowable == null)
    {
      this.val$writeResultCallback.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
      return;
    }
    Log.e("PrintHelperApi19", "Error writing printed content", paramThrowable);
    this.val$writeResultCallback.onWriteFailed(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.print.PrintHelper.PrintHelperApi19.2
 * JD-Core Version:    0.7.0.1
 */