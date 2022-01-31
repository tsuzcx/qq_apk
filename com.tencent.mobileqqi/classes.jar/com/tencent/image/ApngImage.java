package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class ApngImage
  implements Runnable
{
  private static final byte COLOR_GREYALPHA = 4;
  private static final byte COLOR_GREYSCALE = 0;
  private static final byte COLOR_INDEXED = 3;
  private static final byte COLOR_TRUEALPHA = 6;
  private static final byte COLOR_TRUECOLOR = 2;
  public static final int DENSITY_NONE = 0;
  private static final int IDAT = 1229209940;
  private static final int IEND = 1229278788;
  private static final int IHDR = 1229472850;
  protected static final int MaxStackSize = 4096;
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final int PLTE = 1347179589;
  private static final byte[] SIGNATURE;
  private static final String TAG = "ApngImage";
  private static final int acTL = 1633899596;
  private static final int fcTL = 1717785676;
  private static final int fdAT = 1717846356;
  private static ArgumentsRunnable<WeakReference<ApngImage>> sAccumulativeRunnable;
  private static Handler sHandler;
  protected static boolean sPaused = false;
  protected static final ArrayList<WeakReference<ApngImage>> sPendingActions;
  private static final int tRNS = 1951551059;
  private int bitdepth = 0;
  private byte[] buffer;
  private int bytesPerPixel = 0;
  private boolean cacheFirstFrame;
  private Vector<WeakReference<AnimationCallback>> callbacks = new Vector();
  private int chunkLength;
  private int chunkRemaining;
  private int chunkType;
  private int colorType = 0;
  protected long contentIndex;
  private CRC32 crc;
  private Bitmap curFrame;
  private int cur_blend_op = 0;
  private int cur_ch_height = 0;
  private int cur_ch_width = 0;
  private int cur_delay_den = 0;
  private int cur_delay_num = 0;
  private int cur_dispose_op = 0;
  private int cur_x_offset = 0;
  private int cur_y_offset = 0;
  protected int currentFrameDelay;
  private int delay = 0;
  protected RandomAccessFile file;
  public Bitmap firstFrame;
  private int height = 0;
  private boolean mDecodeNextFrameEnd = true;
  protected boolean mIsInPendingAction = false;
  private int mTaskType;
  private Bitmap nextFrame;
  private int next_blend_op = 0;
  private int next_ch_height = 0;
  private int next_ch_width = 0;
  private int next_delay_den = 0;
  private int next_delay_num = 0;
  private int next_dispose_op = 0;
  private int next_x_offset = 0;
  private int next_y_offset = 0;
  private int numFrames = 0;
  private int numPlays = 0;
  private boolean onlyOneFrame = false;
  private Paint paint = new Paint();
  private Paint paintTransparentBlack = new Paint();
  private byte[] palette;
  private byte[] paletteA;
  private int[] prev_data;
  private byte[] transPixel;
  private int width = 0;
  
  static
  {
    if (!ApngImage.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SIGNATURE = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
      sPaused = false;
      sPendingActions = new ArrayList(105)
      {
        private void ensureCapacity()
        {
          int i = size();
          if (i > 100) {
            removeRange(0, i - 100 - 1);
          }
        }
        
        public boolean add(WeakReference<ApngImage> paramAnonymousWeakReference)
        {
          boolean bool = super.add(paramAnonymousWeakReference);
          ensureCapacity();
          return bool;
        }
      };
      return;
    }
  }
  
  public ApngImage(File paramFile, boolean paramBoolean)
    throws IOException
  {
    try
    {
      this.file = new RandomAccessFile(paramFile, "r");
      init(paramBoolean);
      return;
    }
    catch (IOException paramFile)
    {
      if (this.file == null) {}
    }
    try
    {
      this.file.close();
      label207:
      throw paramFile;
    }
    catch (Exception localException)
    {
      break label207;
    }
  }
  
  public ApngImage(RandomAccessFile paramRandomAccessFile, boolean paramBoolean)
    throws IOException
  {
    try
    {
      this.file = paramRandomAccessFile;
      init(paramBoolean);
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      if (this.file == null) {}
    }
    try
    {
      this.file.close();
      label198:
      throw paramRandomAccessFile;
    }
    catch (Exception localException)
    {
      break label198;
    }
  }
  
  private int ARGBtoColor(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return paramByte1 << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  private void checkChunkLength(int paramInt)
    throws IOException
  {
    if (this.chunkLength != paramInt) {
      throw new IOException("Chunk has wrong size");
    }
  }
  
  private static boolean checkSignature(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < SIGNATURE.length)
    {
      if (paramArrayOfByte[i] != SIGNATURE[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void closeChunk()
    throws IOException
  {
    if (this.chunkRemaining > 0) {
      this.file.seek(this.file.getFilePointer() + this.chunkRemaining + 4L);
    }
    int i;
    do
    {
      this.chunkRemaining = 0;
      this.chunkLength = 0;
      this.chunkType = 0;
      return;
      readFully(this.buffer, 0, 4);
      i = readInt(this.buffer, 0);
    } while ((int)this.crc.getValue() == i);
    throw new IOException("Invalid CRC");
  }
  
  private void expand1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    while (i < j)
    {
      int k = paramArrayOfByte1[((i >> 3) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 7)] = ((byte)(k & 0x1));
      case 7: 
        paramArrayOfByte2[(i + 6)] = ((byte)(k >> 1 & 0x1));
      case 6: 
        paramArrayOfByte2[(i + 5)] = ((byte)(k >> 2 & 0x1));
      case 5: 
        paramArrayOfByte2[(i + 4)] = ((byte)(k >> 3 & 0x1));
      case 4: 
        paramArrayOfByte2[(i + 3)] = ((byte)(k >> 4 & 0x1));
      case 3: 
        paramArrayOfByte2[(i + 2)] = ((byte)(k >> 5 & 0x1));
      case 2: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k >> 6 & 0x1));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 7));
      i += 8;
    }
  }
  
  private void expand2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    while (i < j)
    {
      int k = paramArrayOfByte1[((i >> 2) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 3)] = ((byte)(k & 0x3));
      case 3: 
        paramArrayOfByte2[(i + 2)] = ((byte)(k >> 2 & 0x3));
      case 2: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k >> 4 & 0x3));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 6));
      i += 4;
    }
  }
  
  private void expand4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte2.length;
    while (i < j)
    {
      int k = paramArrayOfByte1[((i >> 1) + 1)] & 0xFF;
      switch (j - i)
      {
      default: 
        paramArrayOfByte2[(i + 1)] = ((byte)(k & 0xF));
      }
      paramArrayOfByte2[i] = ((byte)(k >> 4));
      i += 2;
    }
  }
  
  private void init(boolean paramBoolean)
    throws IOException
  {
    this.crc = new CRC32();
    this.buffer = new byte[4096];
    this.paint.setAntiAlias(true);
    this.paintTransparentBlack.setAntiAlias(true);
    this.paintTransparentBlack.setColor(0);
    readFully(this.buffer, 0, SIGNATURE.length);
    if (!checkSignature(this.buffer)) {
      throw new IOException("Not a valid PNG file");
    }
    this.cacheFirstFrame = paramBoolean;
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {
      this.firstFrame = this.curFrame;
    }
    if (this.onlyOneFrame)
    {
      this.firstFrame = this.curFrame;
      this.nextFrame = null;
    }
  }
  
  private void invalidateSelf()
  {
    int i = 0;
    if (i < this.callbacks.size())
    {
      WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        this.callbacks.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        ((AnimationCallback)localWeakReference.get()).invalidateSelf();
      }
    }
  }
  
  /* Error */
  public static boolean needDecodeAnimation(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 222	java/io/RandomAccessFile
    //   7: dup
    //   8: aload_0
    //   9: ldc 224
    //   11: invokespecial 227	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_0
    //   15: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   18: arraylength
    //   19: newarray byte
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 344	java/io/RandomAccessFile:read	([B)I
    //   27: pop
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_1
    //   31: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   34: arraylength
    //   35: if_icmpge +35 -> 70
    //   38: aload_2
    //   39: iload_1
    //   40: baload
    //   41: getstatic 138	com/tencent/image/ApngImage:SIGNATURE	[B
    //   44: iload_1
    //   45: baload
    //   46: if_icmpeq +17 -> 63
    //   49: aload_0
    //   50: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   53: aload_0
    //   54: ifnull +7 -> 61
    //   57: aload_0
    //   58: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   61: iconst_0
    //   62: ireturn
    //   63: iload_1
    //   64: iconst_1
    //   65: iadd
    //   66: istore_1
    //   67: goto -37 -> 30
    //   70: aload_0
    //   71: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_0
    //   85: aload_3
    //   86: astore_0
    //   87: aload_0
    //   88: ifnull -27 -> 61
    //   91: aload_0
    //   92: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: iconst_0
    //   99: ireturn
    //   100: astore_0
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 236	java/io/RandomAccessFile:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: goto -51 -> 61
    //   115: astore_0
    //   116: goto -34 -> 82
    //   119: astore_2
    //   120: goto -11 -> 109
    //   123: astore_3
    //   124: aload_0
    //   125: astore_2
    //   126: aload_3
    //   127: astore_0
    //   128: goto -27 -> 101
    //   131: astore_2
    //   132: goto -45 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   29	38	1	i	int
    //   1	105	2	arrayOfByte	byte[]
    //   119	1	2	localIOException	IOException
    //   125	1	2	localFile	File
    //   131	1	2	localException	Exception
    //   3	83	3	localObject1	Object
    //   123	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	15	84	java/lang/Exception
    //   91	95	97	java/io/IOException
    //   4	15	100	finally
    //   57	61	111	java/io/IOException
    //   78	82	115	java/io/IOException
    //   105	109	119	java/io/IOException
    //   15	28	123	finally
    //   30	53	123	finally
    //   70	74	123	finally
    //   15	28	131	java/lang/Exception
    //   30	53	131	java/lang/Exception
    //   70	74	131	java/lang/Exception
  }
  
  private void openChunk()
    throws IOException
  {
    readFully(this.buffer, 0, 8);
    this.chunkLength = readInt(this.buffer, 0);
    this.chunkType = readInt(this.buffer, 4);
    this.chunkRemaining = this.chunkLength;
    this.crc.reset();
    this.crc.update(this.buffer, 4, 4);
  }
  
  private void openChunk(int paramInt)
    throws IOException
  {
    openChunk();
    if (this.chunkType != paramInt) {
      throw new IOException("Expected chunk: " + Integer.toHexString(paramInt));
    }
  }
  
  public static final void pauseAll()
  {
    sPaused = true;
  }
  
  private void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  private int readChunk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt2;
    if (paramInt2 > this.chunkRemaining) {
      i = this.chunkRemaining;
    }
    readFully(paramArrayOfByte, paramInt1, i);
    this.crc.update(paramArrayOfByte, paramInt1, i);
    this.chunkRemaining -= i;
    return i;
  }
  
  private void readChunkUnzip(Inflater paramInflater, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int j = paramInt1;
    int i = paramInt2;
    if (!$assertionsDisabled)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramArrayOfByte == this.buffer) {
        throw new AssertionError();
      }
    }
    label142:
    do
    {
      try
      {
        paramInt1 = paramInflater.inflate(paramArrayOfByte, j, i);
        if (paramInt1 > 0) {
          break label142;
        }
        if (paramInflater.finished()) {
          throw new EOFException();
        }
      }
      catch (DataFormatException paramInflater)
      {
        throw ((IOException)new IOException("inflate error").initCause(paramInflater));
      }
      if (paramInflater.needsInput())
      {
        refillInflater(paramInflater, paramInt3);
        paramInt1 = i;
      }
      else
      {
        throw new IOException("Can't inflate " + i + " bytes");
        j += paramInt1;
        paramInt1 = i - paramInt1;
      }
      i = paramInt1;
    } while (paramInt1 > 0);
  }
  
  private void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    do
    {
      i = this.file.read(paramArrayOfByte, paramInt1, paramInt2);
      if ((i < 0) && (i != -1)) {
        throw new EOFException();
      }
      paramInt1 += i;
      i = paramInt2 - i;
      paramInt2 = i;
    } while (i > 0);
  }
  
  private void readIDAT()
    throws IOException
  {
    this.nextFrame = Bitmap.createBitmap(Bitmap.createBitmap(decodeChunk(1229209940, this.width, this.height), this.width, this.height, Bitmap.Config.ARGB_8888));
    if (this.cacheFirstFrame) {
      this.firstFrame = this.nextFrame;
    }
  }
  
  private void readIEND()
    throws IOException
  {}
  
  private void readIHDR()
    throws IOException
  {
    checkChunkLength(13);
    readChunk(this.buffer, 0, 13);
    this.width = readInt(this.buffer, 0);
    this.height = readInt(this.buffer, 4);
    this.bitdepth = (this.buffer[8] & 0xFF);
    this.colorType = (this.buffer[9] & 0xFF);
    this.prev_data = new int[this.width * this.height];
    switch (this.colorType)
    {
    case 1: 
    case 5: 
    default: 
      throw new IOException("unsupported color format: " + this.colorType);
    case 0: 
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 1;
    }
    while (this.buffer[10] != 0)
    {
      throw new IOException("unsupported compression method");
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 2;
      continue;
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 3;
      continue;
      if (this.bitdepth != 8) {
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 4;
      continue;
      switch (this.bitdepth)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new IOException("Unsupported bit depth: " + this.bitdepth);
      }
      this.bytesPerPixel = 1;
    }
    if (this.buffer[11] != 0) {
      throw new IOException("unsupported filtering method");
    }
    if (this.buffer[12] != 0) {
      throw new IOException("unsupported interlace method");
    }
  }
  
  private int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private void readPLTE()
    throws IOException
  {
    int i = this.chunkLength / 3;
    if ((i < 1) || (i > 256) || (this.chunkLength % 3 != 0)) {
      throw new IOException("PLTE chunk has wrong length");
    }
    this.palette = new byte[i * 3];
    readChunk(this.palette, 0, this.palette.length);
  }
  
  private int readShort(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 8 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  private void readacTL()
    throws IOException
  {
    this.contentIndex = this.file.getFilePointer();
    checkChunkLength(8);
    readChunk(this.buffer, 0, 8);
    this.numFrames = readInt(this.buffer, 0);
    if (this.numFrames == 1) {
      this.onlyOneFrame = true;
    }
    this.numPlays = readInt(this.buffer, 4);
  }
  
  private void readfcTL()
    throws IOException
  {
    checkChunkLength(26);
    readChunk(this.buffer, 0, 26);
    this.next_ch_width = readInt(this.buffer, 4);
    this.next_ch_height = readInt(this.buffer, 8);
    this.next_x_offset = readInt(this.buffer, 12);
    this.next_y_offset = readInt(this.buffer, 16);
    this.next_delay_num = readShort(this.buffer, 20);
    this.next_delay_den = readShort(this.buffer, 22);
    this.next_dispose_op = this.buffer[24];
    this.next_blend_op = this.buffer[25];
    if (this.next_delay_den == 0)
    {
      this.delay = 100;
      return;
    }
    this.delay = (this.next_delay_num * 1000 / this.next_delay_den);
  }
  
  private void readfdAT()
    throws IOException
  {
    readChunk(this.buffer, 0, 4);
    int[] arrayOfInt1 = decodeChunk(1717846356, this.next_ch_width, this.next_ch_height);
    Bitmap localBitmap1 = Bitmap.createBitmap(arrayOfInt1, this.next_ch_width, this.next_ch_height, Bitmap.Config.ARGB_8888);
    Bitmap localBitmap2 = this.curFrame.copy(Bitmap.Config.ARGB_8888, true);
    if ((this.next_dispose_op != 0) && (this.next_dispose_op != 1) && (this.next_dispose_op != 2)) {
      throw new IOException("Incorrect frame dispose: " + Integer.toHexString(this.next_dispose_op));
    }
    localBitmap2.getPixels(this.prev_data, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
    int[] arrayOfInt2;
    if (this.next_blend_op == 0) {
      if (this.next_dispose_op == 0) {
        if (this.cur_dispose_op == 1)
        {
          arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
          Arrays.fill(arrayOfInt2, 0);
          localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
          localBitmap2.setPixels(arrayOfInt1, 0, this.next_ch_width, this.next_x_offset, this.next_y_offset, this.next_ch_width, this.next_ch_height);
        }
      }
    }
    for (;;)
    {
      new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
      this.nextFrame = Bitmap.createBitmap(localBitmap2);
      return;
      if (this.cur_dispose_op != 2) {
        break;
      }
      localBitmap2.setPixels(this.prev_data, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
      break;
      if (this.next_dispose_op == 1)
      {
        arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
        Arrays.fill(arrayOfInt2, 0);
        localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
        break;
      }
      if ((this.next_dispose_op != 2) || (this.cur_dispose_op != 1)) {
        break;
      }
      arrayOfInt2 = new int[this.cur_ch_width * this.cur_ch_height];
      Arrays.fill(arrayOfInt2, 0);
      localBitmap2.setPixels(arrayOfInt2, 0, this.cur_ch_width, this.cur_x_offset, this.cur_y_offset, this.cur_ch_width, this.cur_ch_height);
      break;
      if (this.next_blend_op == 1) {
        if (this.next_dispose_op == 0)
        {
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
        else if (this.next_dispose_op == 1)
        {
          Arrays.fill(arrayOfInt1, 0);
          localBitmap2.setPixels(arrayOfInt1, 0, this.next_ch_width, this.next_x_offset, this.next_y_offset, this.next_ch_width, this.next_ch_height);
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
        else if (this.next_dispose_op == 2)
        {
          new Canvas(localBitmap2).drawBitmap(localBitmap1, this.next_x_offset, this.next_y_offset, this.paint);
        }
      }
    }
  }
  
  private void readtRNS()
    throws IOException
  {
    switch (this.colorType)
    {
    case 1: 
    default: 
      return;
    case 0: 
      checkChunkLength(2);
      this.transPixel = new byte[2];
      readChunk(this.transPixel, 0, 2);
      return;
    case 2: 
      checkChunkLength(6);
      this.transPixel = new byte[6];
      readChunk(this.transPixel, 0, 6);
      return;
    }
    if (this.palette == null) {
      throw new IOException("tRNS chunk without PLTE chunk");
    }
    this.paletteA = new byte[this.palette.length / 3];
    Arrays.fill(this.paletteA, (byte)-1);
    readChunk(this.paletteA, 0, this.paletteA.length);
  }
  
  private void refillInflater(Inflater paramInflater, int paramInt)
    throws IOException
  {
    int i = 0;
    while (this.chunkRemaining == 0)
    {
      closeChunk();
      openChunk(paramInt);
      if (paramInt == 1717846356) {
        i = 4;
      }
    }
    paramInt = readChunk(this.buffer, 0, this.buffer.length);
    paramInflater.setInput(this.buffer, i, paramInt - i);
  }
  
  public static final void resumeAll()
  {
    sPaused = false;
    int i = sPendingActions.size() - 1;
    while (i >= 0)
    {
      ApngImage localApngImage = (ApngImage)((WeakReference)sPendingActions.get(i)).get();
      if (localApngImage != null) {
        localApngImage.reDraw();
      }
      i -= 1;
    }
    sPendingActions.clear();
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  private void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    int i = 0;
    if (i < this.callbacks.size())
    {
      WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        this.callbacks.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
        ((AnimationCallback)localWeakReference.get()).scheduleSelf(paramRunnable, paramLong);
      }
    }
  }
  
  private void unfilter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws IOException
  {
    switch (paramArrayOfByte1[0])
    {
    default: 
      throw new IOException("invalide filter type in scanline: " + paramArrayOfByte1[0]);
    case 1: 
      unfilterSub(paramArrayOfByte1);
    case 0: 
      return;
    case 2: 
      unfilterUp(paramArrayOfByte1, paramArrayOfByte2);
      return;
    case 3: 
      unfilterAverage(paramArrayOfByte1, paramArrayOfByte2);
      return;
    }
    unfilterPaeth(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private void unfilterAverage(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = this.bytesPerPixel;
    int i = 1;
    while (i <= j)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + (byte)((paramArrayOfByte2[i] & 0xFF) >>> 1)));
      i += 1;
    }
    int k = paramArrayOfByte1.length;
    while (i < k)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + (byte)((paramArrayOfByte2[i] & 0xFF) + (paramArrayOfByte1[(i - j)] & 0xFF) >>> 1)));
      i += 1;
    }
  }
  
  private void unfilterPaeth(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i4 = this.bytesPerPixel;
    int i = 1;
    while (i <= i4)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + paramArrayOfByte2[i]));
      i += 1;
    }
    int i5 = paramArrayOfByte1.length;
    int j = i;
    if (j < i5)
    {
      int i1 = paramArrayOfByte1[(j - i4)] & 0xFF;
      int n = paramArrayOfByte2[j] & 0xFF;
      int i2 = paramArrayOfByte2[(j - i4)] & 0xFF;
      int i3 = i1 + n - i2;
      int k = i3 - i1;
      i = k;
      if (k < 0) {
        i = -k;
      }
      int m = i3 - n;
      k = m;
      if (m < 0) {
        k = -m;
      }
      i3 -= i2;
      m = i3;
      if (i3 < 0) {
        m = -i3;
      }
      if ((i <= k) && (i <= m)) {
        i = i1;
      }
      for (;;)
      {
        paramArrayOfByte1[j] = ((byte)(paramArrayOfByte1[j] + (byte)i));
        j += 1;
        break;
        i = i2;
        if (k <= m) {
          i = n;
        }
      }
    }
  }
  
  private void unfilterSub(byte[] paramArrayOfByte)
  {
    int j = this.bytesPerPixel;
    int i = j + 1;
    int k = paramArrayOfByte.length;
    while (i < k)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + paramArrayOfByte[(i - j)]));
      i += 1;
    }
  }
  
  private void unfilterUp(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j = paramArrayOfByte1.length;
    while (i < j)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] + paramArrayOfByte2[i]));
      i += 1;
    }
  }
  
  public void addCallBack(AnimationCallback paramAnimationCallback)
  {
    if (paramAnimationCallback != null) {
      this.callbacks.add(new WeakReference(paramAnimationCallback));
    }
  }
  
  public void applyNextFrame()
  {
    try
    {
      this.curFrame = this.nextFrame;
      this.cur_ch_width = this.next_ch_width;
      this.cur_ch_height = this.next_ch_height;
      this.cur_x_offset = this.next_x_offset;
      this.cur_y_offset = this.next_y_offset;
      this.cur_delay_num = this.next_delay_num;
      this.cur_delay_den = this.next_delay_den;
      this.cur_dispose_op = this.next_dispose_op;
      this.cur_blend_op = this.next_blend_op;
      System.out.println("delay:" + this.delay);
      this.currentFrameDelay = this.delay;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int[] decodeChunk(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   4: iload_2
    //   5: imul
    //   6: bipush 7
    //   8: iadd
    //   9: bipush 8
    //   11: idiv
    //   12: aload_0
    //   13: getfield 202	com/tencent/image/ApngImage:bytesPerPixel	I
    //   16: imul
    //   17: istore 9
    //   19: iconst_0
    //   20: istore 10
    //   22: iload 9
    //   24: iconst_1
    //   25: iadd
    //   26: newarray byte
    //   28: astore 16
    //   30: iload 9
    //   32: iconst_1
    //   33: iadd
    //   34: newarray byte
    //   36: astore 15
    //   38: aload_0
    //   39: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   42: bipush 8
    //   44: if_icmpge +125 -> 169
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: newarray byte
    //   52: astore 17
    //   54: iload_2
    //   55: iload_3
    //   56: imul
    //   57: newarray int
    //   59: astore 20
    //   61: new 386	java/util/zip/Inflater
    //   64: dup
    //   65: invokespecial 570	java/util/zip/Inflater:<init>	()V
    //   68: astore 19
    //   70: iconst_0
    //   71: istore 9
    //   73: iload 10
    //   75: istore_2
    //   76: iload 9
    //   78: iload_3
    //   79: if_icmpge +696 -> 775
    //   82: aload_0
    //   83: aload 19
    //   85: aload 16
    //   87: iconst_0
    //   88: aload 16
    //   90: arraylength
    //   91: iload_1
    //   92: invokespecial 572	com/tencent/image/ApngImage:readChunkUnzip	(Ljava/util/zip/Inflater;[BIII)V
    //   95: aload_0
    //   96: aload 16
    //   98: aload 15
    //   100: invokespecial 574	com/tencent/image/ApngImage:unfilter	([B[B)V
    //   103: aload_0
    //   104: getfield 200	com/tencent/image/ApngImage:colorType	I
    //   107: tableswitch	default:+681 -> 788, 0:+325->432, 1:+41->148, 2:+68->175, 3:+347->454, 4:+336->443, 5:+41->148, 6:+263->370
    //   149: iconst_m1
    //   150: lstore_1
    //   151: dup
    //   152: ldc_w 578
    //   155: invokespecial 579	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   158: athrow
    //   159: astore 15
    //   161: aload 19
    //   163: invokevirtual 582	java/util/zip/Inflater:end	()V
    //   166: aload 15
    //   168: athrow
    //   169: aconst_null
    //   170: astore 17
    //   172: goto -118 -> 54
    //   175: aload_0
    //   176: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   179: ifnull +135 -> 314
    //   182: aload_0
    //   183: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   186: iconst_1
    //   187: baload
    //   188: istore 11
    //   190: aload_0
    //   191: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   194: iconst_3
    //   195: baload
    //   196: istore 12
    //   198: aload_0
    //   199: getfield 499	com/tencent/image/ApngImage:transPixel	[B
    //   202: iconst_5
    //   203: baload
    //   204: istore 13
    //   206: iconst_1
    //   207: istore 10
    //   209: aload 16
    //   211: arraylength
    //   212: istore 14
    //   214: iload 10
    //   216: iload 14
    //   218: if_icmpge +573 -> 791
    //   221: aload 16
    //   223: iload 10
    //   225: baload
    //   226: istore 6
    //   228: aload 16
    //   230: iload 10
    //   232: iconst_1
    //   233: iadd
    //   234: baload
    //   235: istore 7
    //   237: aload 16
    //   239: iload 10
    //   241: iconst_2
    //   242: iadd
    //   243: baload
    //   244: istore 8
    //   246: iconst_m1
    //   247: istore 5
    //   249: iload 5
    //   251: istore 4
    //   253: iload 6
    //   255: iload 11
    //   257: if_icmpne +28 -> 285
    //   260: iload 5
    //   262: istore 4
    //   264: iload 7
    //   266: iload 12
    //   268: if_icmpne +17 -> 285
    //   271: iload 5
    //   273: istore 4
    //   275: iload 8
    //   277: iload 13
    //   279: if_icmpne +6 -> 285
    //   282: iconst_0
    //   283: istore 4
    //   285: aload 20
    //   287: iload_2
    //   288: aload_0
    //   289: iload 4
    //   291: iload 6
    //   293: iload 7
    //   295: iload 8
    //   297: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   300: iastore
    //   301: iload 10
    //   303: iconst_3
    //   304: iadd
    //   305: istore 10
    //   307: iload_2
    //   308: iconst_1
    //   309: iadd
    //   310: istore_2
    //   311: goto -97 -> 214
    //   314: iconst_1
    //   315: istore 10
    //   317: aload 16
    //   319: arraylength
    //   320: istore 11
    //   322: iload 10
    //   324: iload 11
    //   326: if_icmpge +486 -> 812
    //   329: aload 20
    //   331: iload_2
    //   332: aload_0
    //   333: iconst_m1
    //   334: aload 16
    //   336: iload 10
    //   338: baload
    //   339: aload 16
    //   341: iload 10
    //   343: iconst_1
    //   344: iadd
    //   345: baload
    //   346: aload 16
    //   348: iload 10
    //   350: iconst_2
    //   351: iadd
    //   352: baload
    //   353: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   356: iastore
    //   357: iload 10
    //   359: iconst_3
    //   360: iadd
    //   361: istore 10
    //   363: iload_2
    //   364: iconst_1
    //   365: iadd
    //   366: istore_2
    //   367: goto -45 -> 322
    //   370: iconst_1
    //   371: istore 10
    //   373: aload 16
    //   375: arraylength
    //   376: istore 11
    //   378: iload 10
    //   380: iload 11
    //   382: if_icmpge +433 -> 815
    //   385: aload 20
    //   387: iload_2
    //   388: aload_0
    //   389: aload 16
    //   391: iload 10
    //   393: iconst_3
    //   394: iadd
    //   395: baload
    //   396: aload 16
    //   398: iload 10
    //   400: baload
    //   401: aload 16
    //   403: iload 10
    //   405: iconst_1
    //   406: iadd
    //   407: baload
    //   408: aload 16
    //   410: iload 10
    //   412: iconst_2
    //   413: iadd
    //   414: baload
    //   415: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   418: iastore
    //   419: iload 10
    //   421: iconst_4
    //   422: iadd
    //   423: istore 10
    //   425: iload_2
    //   426: iconst_1
    //   427: iadd
    //   428: istore_2
    //   429: goto -51 -> 378
    //   432: iconst_1
    //   433: istore 10
    //   435: aload 16
    //   437: arraylength
    //   438: istore 11
    //   440: goto +378 -> 818
    //   443: iconst_1
    //   444: istore 10
    //   446: aload 16
    //   448: arraylength
    //   449: istore 11
    //   451: goto +403 -> 854
    //   454: aload_0
    //   455: getfield 198	com/tencent/image/ApngImage:bitdepth	I
    //   458: tableswitch	default:+443 -> 901, 1:+201->659, 2:+190->648, 3:+46->504, 4:+179->637, 5:+46->504, 6:+46->504, 7:+46->504, 8:+446->904
    //   505: iconst_m1
    //   506: lstore_1
    //   507: dup
    //   508: ldc_w 586
    //   511: invokespecial 579	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   514: athrow
    //   515: aload_0
    //   516: getfield 503	com/tencent/image/ApngImage:paletteA	[B
    //   519: ifnull +151 -> 670
    //   522: iconst_1
    //   523: istore 11
    //   525: aload 16
    //   527: arraylength
    //   528: istore 12
    //   530: iload 11
    //   532: iload 12
    //   534: if_icmpge +377 -> 911
    //   537: aload 16
    //   539: iload 11
    //   541: baload
    //   542: sipush 255
    //   545: iand
    //   546: istore 13
    //   548: iload_2
    //   549: istore 10
    //   551: aload_0
    //   552: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   555: iload 13
    //   557: iconst_3
    //   558: imul
    //   559: iconst_0
    //   560: iadd
    //   561: baload
    //   562: istore 4
    //   564: iload_2
    //   565: istore 10
    //   567: aload_0
    //   568: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   571: iload 13
    //   573: iconst_3
    //   574: imul
    //   575: iconst_1
    //   576: iadd
    //   577: baload
    //   578: istore 5
    //   580: iload_2
    //   581: istore 10
    //   583: aload_0
    //   584: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   587: iload 13
    //   589: iconst_3
    //   590: imul
    //   591: iconst_2
    //   592: iadd
    //   593: baload
    //   594: istore 6
    //   596: iload_2
    //   597: istore 10
    //   599: aload_0
    //   600: getfield 503	com/tencent/image/ApngImage:paletteA	[B
    //   603: iload 13
    //   605: baload
    //   606: istore 7
    //   608: aload 20
    //   610: iload_2
    //   611: aload_0
    //   612: iload 7
    //   614: iload 4
    //   616: iload 5
    //   618: iload 6
    //   620: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   623: iastore
    //   624: iload 11
    //   626: iconst_1
    //   627: iadd
    //   628: istore 11
    //   630: iload_2
    //   631: iconst_1
    //   632: iadd
    //   633: istore_2
    //   634: goto -104 -> 530
    //   637: aload_0
    //   638: aload 16
    //   640: aload 17
    //   642: invokespecial 588	com/tencent/image/ApngImage:expand4	([B[B)V
    //   645: goto -130 -> 515
    //   648: aload_0
    //   649: aload 16
    //   651: aload 17
    //   653: invokespecial 590	com/tencent/image/ApngImage:expand2	([B[B)V
    //   656: goto -141 -> 515
    //   659: aload_0
    //   660: aload 16
    //   662: aload 17
    //   664: invokespecial 592	com/tencent/image/ApngImage:expand1	([B[B)V
    //   667: goto -152 -> 515
    //   670: iconst_1
    //   671: istore 11
    //   673: aload 16
    //   675: arraylength
    //   676: istore 12
    //   678: iload 11
    //   680: iload 12
    //   682: if_icmpge +90 -> 772
    //   685: aload 16
    //   687: iload 11
    //   689: baload
    //   690: sipush 255
    //   693: iand
    //   694: istore 13
    //   696: iload_2
    //   697: istore 10
    //   699: aload_0
    //   700: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   703: iload 13
    //   705: iconst_3
    //   706: imul
    //   707: iconst_0
    //   708: iadd
    //   709: baload
    //   710: istore 4
    //   712: iload_2
    //   713: istore 10
    //   715: aload_0
    //   716: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   719: iload 13
    //   721: iconst_3
    //   722: imul
    //   723: iconst_1
    //   724: iadd
    //   725: baload
    //   726: istore 5
    //   728: iload_2
    //   729: istore 10
    //   731: aload_0
    //   732: getfield 460	com/tencent/image/ApngImage:palette	[B
    //   735: iload 13
    //   737: iconst_3
    //   738: imul
    //   739: iconst_2
    //   740: iadd
    //   741: baload
    //   742: istore 6
    //   744: aload 20
    //   746: iload_2
    //   747: aload_0
    //   748: iconst_m1
    //   749: iload 4
    //   751: iload 5
    //   753: iload 6
    //   755: invokespecial 584	com/tencent/image/ApngImage:ARGBtoColor	(BBBB)I
    //   758: iastore
    //   759: iload 11
    //   761: iconst_1
    //   762: iadd
    //   763: istore 11
    //   765: iload_2
    //   766: iconst_1
    //   767: iadd
    //   768: istore_2
    //   769: goto -91 -> 678
    //   772: goto +19 -> 791
    //   775: aload 19
    //   777: invokevirtual 582	java/util/zip/Inflater:end	()V
    //   780: aload 20
    //   782: areturn
    //   783: astore 15
    //   785: goto -624 -> 161
    //   788: goto -640 -> 148
    //   791: aload 15
    //   793: astore 18
    //   795: aload 16
    //   797: astore 15
    //   799: iload 9
    //   801: iconst_1
    //   802: iadd
    //   803: istore 9
    //   805: aload 18
    //   807: astore 16
    //   809: goto -733 -> 76
    //   812: goto -21 -> 791
    //   815: goto -24 -> 791
    //   818: iload 10
    //   820: iload 11
    //   822: if_icmpge +29 -> 851
    //   825: aload 20
    //   827: iload_2
    //   828: aload 16
    //   830: iload 10
    //   832: baload
    //   833: ldc_w 593
    //   836: imul
    //   837: iastore
    //   838: iload 10
    //   840: iconst_1
    //   841: iadd
    //   842: istore 10
    //   844: iload_2
    //   845: iconst_1
    //   846: iadd
    //   847: istore_2
    //   848: goto -30 -> 818
    //   851: goto -60 -> 791
    //   854: iload 10
    //   856: iload 11
    //   858: if_icmpge +40 -> 898
    //   861: aload 20
    //   863: iload_2
    //   864: aload 16
    //   866: iload 10
    //   868: baload
    //   869: ldc_w 593
    //   872: imul
    //   873: aload 16
    //   875: iload 10
    //   877: iconst_1
    //   878: iadd
    //   879: baload
    //   880: bipush 6
    //   882: ishl
    //   883: iadd
    //   884: iastore
    //   885: iload 10
    //   887: iconst_2
    //   888: iadd
    //   889: istore 10
    //   891: iload_2
    //   892: iconst_1
    //   893: iadd
    //   894: istore_2
    //   895: goto -41 -> 854
    //   898: goto -107 -> 791
    //   901: goto -397 -> 504
    //   904: aload 16
    //   906: astore 17
    //   908: goto -393 -> 515
    //   911: goto -120 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	this	ApngImage
    //   0	914	1	paramInt1	int
    //   0	914	2	paramInt2	int
    //   0	914	3	paramInt3	int
    //   251	499	4	b1	byte
    //   247	505	5	b2	byte
    //   226	66	6	i	int
    //   594	160	6	b3	byte
    //   235	59	7	j	int
    //   606	7	7	b4	byte
    //   244	52	8	b5	byte
    //   17	787	9	k	int
    //   20	870	10	m	int
    //   188	671	11	n	int
    //   196	487	12	i1	int
    //   204	535	13	i2	int
    //   212	7	14	i3	int
    //   36	63	15	arrayOfByte	byte[]
    //   159	8	15	localObject1	Object
    //   783	9	15	localObject2	Object
    //   797	1	15	localObject3	Object
    //   28	877	16	localObject4	Object
    //   52	855	17	localObject5	Object
    //   793	13	18	localObject6	Object
    //   68	708	19	localInflater	Inflater
    //   59	803	20	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   82	148	159	finally
    //   148	159	159	finally
    //   175	206	159	finally
    //   209	214	159	finally
    //   285	301	159	finally
    //   317	322	159	finally
    //   329	357	159	finally
    //   373	378	159	finally
    //   385	419	159	finally
    //   435	440	159	finally
    //   446	451	159	finally
    //   454	504	159	finally
    //   504	515	159	finally
    //   515	522	159	finally
    //   525	530	159	finally
    //   608	624	159	finally
    //   637	645	159	finally
    //   648	656	159	finally
    //   659	667	159	finally
    //   673	678	159	finally
    //   744	759	159	finally
    //   551	564	783	finally
    //   567	580	783	finally
    //   583	596	783	finally
    //   599	608	783	finally
    //   699	712	783	finally
    //   715	728	783	finally
    //   731	744	783	finally
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    this.mDecodeNextFrameEnd = true;
    if (!sPaused) {
      invalidateSelf();
    }
    while (this.mIsInPendingAction) {
      return;
    }
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    if (sHandler == null)
    {
      sHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable(null);
    }
    if ((this.onlyOneFrame) || ((!paramBoolean) && (this.firstFrame != null))) {
      paramCanvas.drawBitmap(this.firstFrame, null, paramRect, paramPaint);
    }
    do
    {
      return;
      if (this.curFrame != null) {
        paramCanvas.drawBitmap(this.curFrame, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  public void drawFrame(Canvas paramCanvas) {}
  
  protected void executeNewTask()
  {
    long l1;
    long l2;
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      l1 = SystemClock.uptimeMillis();
      l2 = getDelay();
    }
    try
    {
      Utils.executeAsyncTaskOnSerialExcuter(new DecodeNextFrameAsyncTask(l1 + l2), new Void[] { (Void)null });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
    }
  }
  
  public int getByteSize()
  {
    if (this.onlyOneFrame) {
      return Utils.getBitmapSize(this.firstFrame);
    }
    int j = this.width;
    int k = this.height;
    if (this.firstFrame != null) {}
    for (int i = Utils.getBitmapSize(this.firstFrame);; i = 0) {
      return i + (j * k * 4 * 2 + 4096);
    }
  }
  
  public Bitmap getCurrentFrame()
  {
    return this.curFrame;
  }
  
  public int getDelay()
  {
    System.out.println("currentFrameDelay:" + this.currentFrameDelay);
    return this.currentFrameDelay;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLoopCount()
  {
    return this.numPlays;
  }
  
  protected boolean getNextFrame()
    throws IOException
  {
    boolean bool = true;
    int i = 0;
    for (;;)
    {
      if (i < 10000) {}
      for (;;)
      {
        try
        {
          openChunk();
          switch (this.chunkType)
          {
          case 1229472850: 
            if (this.chunkType == 1229278788) {
              break label242;
            }
            closeChunk();
          }
        }
        finally {}
        readIHDR();
        continue;
        readIDAT();
        closeChunk();
        for (;;)
        {
          return bool;
          readPLTE();
          break;
          readtRNS();
          break;
          readacTL();
          this.contentIndex = this.file.getFilePointer();
          break;
          readfcTL();
          break;
          readfdAT();
          closeChunk();
          continue;
          readIEND();
          this.file.seek(this.contentIndex + 4L);
          break;
          if ((this.colorType == 3) && (this.palette == null)) {
            throw new IOException("Missing PLTE chunk");
          }
          bool = false;
        }
      }
      label242:
      i += 1;
    }
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(this.height, 160, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(this.width, 160, paramInt);
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean hasAlpha()
  {
    return (hasAlphaChannel()) || (this.paletteA != null) || (this.transPixel != null);
  }
  
  public boolean hasAlphaChannel()
  {
    return (this.colorType == 6) || (this.colorType == 4);
  }
  
  protected void initHandlerAndRunnable()
  {
    if (sHandler == null)
    {
      sHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable(null);
    }
  }
  
  public boolean isRGB()
  {
    return (this.colorType == 6) || (this.colorType == 2) || (this.colorType == 3);
  }
  
  void onDecodeNextFrameCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode canceled. " + this.file);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameFailed(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("URLDrawable_", 2, "apng decode error. " + this.file, paramThrowable);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameSuccessed(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      long l = SystemClock.uptimeMillis();
      if (l < paramLong) {
        sHandler.postDelayed(this, paramLong - l);
      }
    }
    else
    {
      return;
    }
    sHandler.post(this);
  }
  
  public void overwriteTRNS(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (hasAlphaChannel()) {
      throw new UnsupportedOperationException("image has an alpha channel");
    }
    byte[] arrayOfByte = this.palette;
    if (arrayOfByte == null) {
      this.transPixel = new byte[] { 0, paramByte1, 0, paramByte2, 0, paramByte3 };
    }
    for (;;)
    {
      return;
      this.paletteA = new byte[arrayOfByte.length / 3];
      int j = 0;
      int i = 0;
      while (j < arrayOfByte.length)
      {
        if ((arrayOfByte[j] != paramByte1) || (arrayOfByte[(j + 1)] != paramByte2) || (arrayOfByte[(j + 2)] != paramByte3)) {
          this.paletteA[i] = -1;
        }
        j += 3;
        i += 1;
      }
    }
  }
  
  public void removeCallBack(AnimationCallback paramAnimationCallback)
  {
    int i = 0;
    if (i < this.callbacks.size())
    {
      WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
      int j;
      if ((localWeakReference == null) || (localWeakReference.get() == null))
      {
        this.callbacks.remove(i);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (localWeakReference.get() != paramAnimationCallback);
      this.callbacks.remove(i);
    }
  }
  
  public void run()
  {
    sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(this) });
  }
  
  class DecodeNextFrameAsyncTask
    extends AsyncTask<Void, Void, Object>
  {
    long nextFrameDrawingTime;
    
    public DecodeNextFrameAsyncTask(long paramLong)
    {
      this.nextFrameDrawingTime = paramLong;
    }
    
    protected Object doInBackground(Void... paramVarArgs)
    {
      try
      {
        boolean bool = ApngImage.this.getNextFrame();
        ApngImage.this.onDecodeNextFrameSuccessed(bool, this.nextFrameDrawingTime);
        return null;
      }
      catch (Throwable paramVarArgs) {}
      return paramVarArgs;
    }
    
    protected void onCancelled()
    {
      ApngImage.this.onDecodeNextFrameCanceled();
    }
    
    protected void onPostExecute(Object paramObject)
    {
      if ((paramObject instanceof Throwable)) {
        ApngImage.this.onDecodeNextFrameFailed((Throwable)paramObject);
      }
    }
  }
  
  private class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<ApngImage>>
  {
    private long lastRefreshTime = 0L;
    
    private DoAccumulativeRunnable() {}
    
    protected void run(List<WeakReference<ApngImage>> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (ApngImage)((WeakReference)localObject).get();
          if (localObject != null) {
            ((ApngImage)localObject).doApplyNextFrame();
          }
        }
      }
      this.lastRefreshTime = SystemClock.uptimeMillis();
    }
    
    protected void submit()
    {
      long l = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l - this.lastRefreshTime > 100L))
      {
        run();
        this.lastRefreshTime = l;
        return;
      }
      ApngImage.sHandler.postDelayed(this, 100L - (l - this.lastRefreshTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.image.ApngImage
 * JD-Core Version:    0.7.0.1
 */