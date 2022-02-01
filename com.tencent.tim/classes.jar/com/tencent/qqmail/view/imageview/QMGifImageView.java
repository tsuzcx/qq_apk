package com.tencent.qqmail.view.imageview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class QMGifImageView
  extends View
{
  private int h;
  private Bitmap mBitmap;
  private Movie mMovie;
  private long mMovieStart;
  private int w;
  
  /* Error */
  public QMGifImageView(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 22	android/view/View:<init>	(Landroid/content/Context;)V
    //   5: aload_0
    //   6: iconst_1
    //   7: invokevirtual 26	com/tencent/qqmail/view/imageview/QMGifImageView:setFocusable	(Z)V
    //   10: aload_2
    //   11: invokestatic 32	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   14: astore_1
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 38	android/graphics/Bitmap:getWidth	()I
    //   20: putfield 40	com/tencent/qqmail/view/imageview/QMGifImageView:w	I
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 43	android/graphics/Bitmap:getHeight	()I
    //   28: putfield 45	com/tencent/qqmail/view/imageview/QMGifImageView:h	I
    //   31: aload_1
    //   32: invokevirtual 49	android/graphics/Bitmap:recycle	()V
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 40	com/tencent/qqmail/view/imageview/QMGifImageView:w	I
    //   40: aload_0
    //   41: getfield 45	com/tencent/qqmail/view/imageview/QMGifImageView:h	I
    //   44: imul
    //   45: newarray int
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 40	com/tencent/qqmail/view/imageview/QMGifImageView:w	I
    //   52: aload_0
    //   53: getfield 40	com/tencent/qqmail/view/imageview/QMGifImageView:w	I
    //   56: aload_0
    //   57: getfield 45	com/tencent/qqmail/view/imageview/QMGifImageView:h	I
    //   60: getstatic 55	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   63: invokestatic 59	android/graphics/Bitmap:createBitmap	([IIIIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   66: putfield 61	com/tencent/qqmail/view/imageview/QMGifImageView:mBitmap	Landroid/graphics/Bitmap;
    //   69: new 63	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_2
    //   78: new 68	java/io/FileInputStream
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 71	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: aload_2
    //   88: ifnull +56 -> 144
    //   91: aload_0
    //   92: aload_1
    //   93: invokespecial 75	com/tencent/qqmail/view/imageview/QMGifImageView:streamToBytes	(Ljava/io/InputStream;)[B
    //   96: astore_2
    //   97: aload_0
    //   98: aload_2
    //   99: iconst_0
    //   100: aload_2
    //   101: arraylength
    //   102: invokestatic 81	android/graphics/Movie:decodeByteArray	([BII)Landroid/graphics/Movie;
    //   105: putfield 83	com/tencent/qqmail/view/imageview/QMGifImageView:mMovie	Landroid/graphics/Movie;
    //   108: aload_1
    //   109: invokevirtual 88	java/io/InputStream:close	()V
    //   112: return
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 91	java/io/FileNotFoundException:printStackTrace	()V
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -33 -> 87
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore_2
    //   130: aload_1
    //   131: invokevirtual 88	java/io/InputStream:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   141: goto -7 -> 134
    //   144: new 19	java/io/IOException
    //   147: dup
    //   148: ldc 94
    //   150: invokespecial 95	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   153: athrow
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   159: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	QMGifImageView
    //   0	160	1	paramContext	android.content.Context
    //   0	160	2	paramString	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   78	87	113	java/io/FileNotFoundException
    //   108	112	123	java/io/IOException
    //   91	108	129	finally
    //   130	134	136	java/io/IOException
    //   144	154	154	java/io/IOException
  }
  
  private byte[] streamToBytes(InputStream paramInputStream)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    byte[] arrayOfByte = new byte[1024];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramInputStream) {}
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(819);
    paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, null);
    long l = SystemClock.uptimeMillis();
    if (this.mMovieStart == 0L) {
      this.mMovieStart = l;
    }
    if (this.mMovie != null)
    {
      int j = this.mMovie.duration();
      int i = j;
      if (j == 0) {
        i = 1000;
      }
      i = (int)((l - this.mMovieStart) % i);
      this.mMovie.setTime(i);
      this.mMovie.draw(paramCanvas, (getWidth() - this.mMovie.width()) / 2, (getHeight() - this.mMovie.height()) / 2);
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.QMGifImageView
 * JD-Core Version:    0.7.0.1
 */