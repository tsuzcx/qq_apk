package com.tencent.qqmail.view.gifimageview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GifDecoder
  extends Thread
{
  private static final int MaxStackSize = 4096;
  public static final int STATUS_FINISH = -1;
  public static final int STATUS_FORMAT_ERROR = 1;
  public static final int STATUS_OPEN_ERROR = 2;
  public static final int STATUS_PARSING = 0;
  private int[] act;
  private GifAction action = null;
  private int bgColor;
  private int bgIndex;
  private byte[] block = new byte[256];
  private int blockSize = 0;
  private GifFrame currentFrame = null;
  private int delay = 0;
  private int dispose = 0;
  private int frameCount;
  private int[] gct;
  private boolean gctFlag;
  private int gctSize;
  private byte[] gifData = null;
  private GifFrame gifFrame;
  public int height;
  private int ih;
  private Bitmap image;
  private InputStream in;
  private boolean interlace;
  private boolean isShow = false;
  private int iw;
  private int ix;
  private int iy;
  private int lastBgColor;
  private int lastDispose = 0;
  private Bitmap lastImage;
  private int[] lct;
  private boolean lctFlag;
  private int lctSize;
  private int loopCount = 1;
  private int lrh;
  private int lrw;
  private int lrx;
  private int lry;
  private int pixelAspect;
  private byte[] pixelStack;
  private byte[] pixels;
  private short[] prefix;
  private int status;
  private byte[] suffix;
  private int transIndex;
  private boolean transparency = false;
  public int width;
  
  public GifDecoder(InputStream paramInputStream, GifAction paramGifAction)
  {
    this.in = paramInputStream;
    this.action = paramGifAction;
  }
  
  public GifDecoder(byte[] paramArrayOfByte, GifAction paramGifAction)
  {
    this.gifData = paramArrayOfByte;
    this.action = paramGifAction;
  }
  
  private void decodeImageData()
  {
    int i11 = this.iw * this.ih;
    if ((this.pixels == null) || (this.pixels.length < i11)) {
      this.pixels = new byte[i11];
    }
    if (this.prefix == null) {
      this.prefix = new short[4096];
    }
    if (this.suffix == null) {
      this.suffix = new byte[4096];
    }
    if (this.pixelStack == null) {
      this.pixelStack = new byte[4097];
    }
    int i12 = read();
    int i13 = 1 << i12;
    int i2 = i13 + 2;
    int j = i12 + 1;
    int k = (1 << j) - 1;
    int i = 0;
    while (i < i13)
    {
      this.prefix[i] = 0;
      this.suffix[i] = ((byte)i);
      i += 1;
    }
    int i1 = 0;
    int i8 = 0;
    int n = 0;
    int i3 = 0;
    int m = 0;
    int i5 = 0;
    int i7 = 0;
    i = -1;
    int i6 = 0;
    int i4;
    if (i8 < i11)
    {
      if (m != 0) {
        break label662;
      }
      if (n >= j) {
        break label275;
      }
      i4 = i6;
      if (i6 != 0) {
        break label234;
      }
      i4 = readBlock();
      if (i4 > 0) {
        break label231;
      }
    }
    label231:
    label234:
    int i9;
    for (;;)
    {
      if (i5 < i11)
      {
        this.pixels[i5] = 0;
        i5 += 1;
        continue;
        i7 = 0;
        i1 += ((this.block[i7] & 0xFF) << n);
        n += 8;
        i7 += 1;
        i6 = i4 - 1;
        break;
        label275:
        i4 = i1 & k;
        i1 >>= j;
        i9 = n - j;
        if ((i4 <= i2) && (i4 != i13 + 1))
        {
          if (i4 == i13)
          {
            j = i12 + 1;
            k = (1 << j) - 1;
            i2 = i13 + 2;
            i = -1;
            n = i9;
            break;
          }
          if (i == -1)
          {
            this.pixelStack[m] = this.suffix[i4];
            m += 1;
            i = i4;
            i3 = i4;
            n = i9;
            break;
          }
          if (i4 != i2) {
            break label655;
          }
          byte[] arrayOfByte = this.pixelStack;
          int i10 = m + 1;
          arrayOfByte[m] = ((byte)i3);
          n = i;
          m = i10;
          label415:
          while (n > i13)
          {
            this.pixelStack[m] = this.suffix[n];
            n = this.prefix[n];
            m += 1;
          }
          i10 = this.suffix[n] & 0xFF;
          if (i2 < 4096)
          {
            this.pixelStack[m] = ((byte)i10);
            this.prefix[i2] = ((short)i);
            this.suffix[i2] = ((byte)i10);
            i3 = i2 + 1;
            n = k;
            i = j;
            if ((i3 & k) == 0)
            {
              n = k;
              i = j;
              if (i3 < 4096)
              {
                i = j + 1;
                n = k + i3;
              }
            }
            k = i10;
            j = n;
            i2 = i1;
            i1 = i9;
            i9 = m + 1;
            m = i3;
            n = i;
            i3 = i9;
            i = k;
            k = i2;
          }
        }
      }
    }
    for (;;)
    {
      i2 = i3 - 1;
      this.pixels[i5] = this.pixelStack[i2];
      i8 += 1;
      i9 = i5 + 1;
      i3 = i1;
      i5 = i2;
      i2 = m;
      i1 = k;
      k = j;
      j = n;
      n = i3;
      i3 = i;
      m = i5;
      i = i4;
      i5 = i9;
      break;
      return;
      label655:
      n = i4;
      break label415;
      label662:
      i4 = i;
      i9 = k;
      k = i1;
      i = i3;
      i1 = n;
      n = j;
      i3 = m;
      j = i9;
      m = i2;
    }
  }
  
  private boolean err()
  {
    return this.status != 0;
  }
  
  private void init()
  {
    this.status = 0;
    this.frameCount = 0;
    this.gifFrame = null;
    this.gct = null;
    this.lct = null;
  }
  
  private int read()
  {
    try
    {
      int i = this.in.read();
      return i;
    }
    catch (Exception localException)
    {
      this.status = 1;
    }
    return 0;
  }
  
  private int readBlock()
  {
    this.blockSize = read();
    int j = 0;
    int i = 0;
    if (this.blockSize > 0) {}
    for (;;)
    {
      try
      {
        if (i < this.blockSize)
        {
          j = this.in.read(this.block, i, this.blockSize - i);
          if (j != -1) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      j = i;
      if (i < this.blockSize)
      {
        this.status = 1;
        j = i;
      }
      return j;
      i += j;
    }
  }
  
  private int readByte()
  {
    this.in = new ByteArrayInputStream(this.gifData);
    this.gifData = null;
    return readStream();
  }
  
  private int[] readColorTable(int paramInt)
  {
    int j = 0;
    int k = paramInt * 3;
    Object localObject = null;
    byte[] arrayOfByte = new byte[k];
    int i;
    int[] arrayOfInt;
    try
    {
      i = this.in.read(arrayOfByte);
      if (i < k)
      {
        this.status = 1;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        i = 0;
      }
      arrayOfInt = new int[256];
      k = 0;
      i = j;
      j = k;
    }
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= paramInt) {
        break;
      }
      int n = j + 1;
      k = arrayOfByte[j];
      int m = n + 1;
      n = arrayOfByte[n];
      j = m + 1;
      arrayOfInt[i] = ((k & 0xFF) << 16 | 0xFF000000 | (n & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
      i += 1;
    }
  }
  
  private void readContents()
  {
    int i = 0;
    while ((i == 0) && (!err())) {
      switch (read())
      {
      case 0: 
      default: 
        this.status = 1;
        break;
      case 44: 
        readImage();
        break;
      case 33: 
        switch (read())
        {
        default: 
          skip();
          break;
        case 249: 
          readGraphicControlExt();
          break;
        case 255: 
          readBlock();
          String str = "";
          int j = 0;
          while (j < 11)
          {
            str = str + (char)this.block[j];
            j += 1;
          }
          if (str.equals("NETSCAPE2.0")) {
            readNetscapeExt();
          } else {
            skip();
          }
          break;
        }
        break;
      case 59: 
        i = 1;
      }
    }
  }
  
  private void readGraphicControlExt()
  {
    boolean bool = true;
    read();
    int i = read();
    this.dispose = ((i & 0x1C) >> 2);
    if (this.dispose == 0) {
      this.dispose = 1;
    }
    if ((i & 0x1) != 0) {}
    for (;;)
    {
      this.transparency = bool;
      this.delay = (readShort() * 10);
      this.transIndex = read();
      read();
      return;
      bool = false;
    }
  }
  
  private void readHeader()
  {
    String str = "";
    int i = 0;
    while (i < 6)
    {
      str = str + (char)read();
      i += 1;
    }
    if (!str.startsWith("GIF")) {
      this.status = 1;
    }
    do
    {
      return;
      readLSD();
    } while ((!this.gctFlag) || (err()));
    this.gct = readColorTable(this.gctSize);
    this.bgColor = this.gct[this.bgIndex];
  }
  
  private void readImage()
  {
    int i = 0;
    this.ix = readShort();
    this.iy = readShort();
    this.iw = readShort();
    this.ih = readShort();
    int j = read();
    boolean bool;
    if ((j & 0x80) != 0)
    {
      bool = true;
      this.lctFlag = bool;
      if ((j & 0x40) == 0) {
        break label157;
      }
      bool = true;
      label63:
      this.interlace = bool;
      this.lctSize = (2 << (j & 0x7));
      if (!this.lctFlag) {
        break label162;
      }
      this.lct = readColorTable(this.lctSize);
      this.act = this.lct;
      label105:
      if (this.transparency)
      {
        i = this.act[this.transIndex];
        this.act[this.transIndex] = 0;
      }
      if (this.act == null) {
        this.status = 1;
      }
      if (!err()) {
        break label189;
      }
    }
    label157:
    label162:
    label189:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label63;
      this.act = this.gct;
      if (this.bgIndex != this.transIndex) {
        break label105;
      }
      this.bgColor = 0;
      break label105;
      decodeImageData();
      skip();
    } while (err());
    this.frameCount += 1;
    this.image = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_4444);
    setPixels();
    if (this.gifFrame == null)
    {
      this.gifFrame = new GifFrame(this.image, this.delay);
      this.currentFrame = this.gifFrame;
    }
    for (;;)
    {
      if (this.transparency) {
        this.act[this.transIndex] = i;
      }
      resetFrame();
      this.action.parseOk(true, this.frameCount);
      return;
      for (GifFrame localGifFrame = this.gifFrame; localGifFrame.nextFrame != null; localGifFrame = localGifFrame.nextFrame) {}
      localGifFrame.nextFrame = new GifFrame(this.image, this.delay);
    }
  }
  
  private void readLSD()
  {
    this.width = readShort();
    this.height = readShort();
    int i = read();
    if ((i & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.gctFlag = bool;
      this.gctSize = (2 << (i & 0x7));
      this.bgIndex = read();
      this.pixelAspect = read();
      return;
    }
  }
  
  private void readNetscapeExt()
  {
    do
    {
      readBlock();
      if (this.block[0] == 1) {
        this.loopCount = (this.block[1] & 0xFF | (this.block[2] & 0xFF) << 8);
      }
    } while ((this.blockSize > 0) && (!err()));
  }
  
  private int readShort()
  {
    return read() | read() << 8;
  }
  
  private int readStream()
  {
    init();
    if (this.in != null)
    {
      readHeader();
      if (!err())
      {
        readContents();
        if (this.frameCount >= 0) {
          break label61;
        }
        this.status = 1;
        this.action.parseOk(false, -1);
      }
    }
    for (;;)
    {
      try
      {
        this.in.close();
        return this.status;
        label61:
        this.status = -1;
        this.action.parseOk(true, -1);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.status = 2;
      this.action.parseOk(false, -1);
    }
  }
  
  private void resetFrame()
  {
    this.lastDispose = this.dispose;
    this.lrx = this.ix;
    this.lry = this.iy;
    this.lrw = this.iw;
    this.lrh = this.ih;
    this.lastImage = this.image;
    this.lastBgColor = this.bgColor;
    this.dispose = 0;
    this.transparency = false;
    this.delay = 0;
    this.lct = null;
  }
  
  private void setPixels()
  {
    int i1 = 0;
    int[] arrayOfInt = new int[this.width * this.height];
    int i;
    if (this.lastDispose > 0) {
      if (this.lastDispose == 3)
      {
        i = this.frameCount - 2;
        if (i > 0) {
          this.lastImage = getFrameImage(i - 1);
        }
      }
      else
      {
        if (this.lastImage == null) {
          break label177;
        }
        this.lastImage.getPixels(arrayOfInt, 0, this.width, 0, 0, this.width, this.height);
        if (this.lastDispose != 2) {
          break label177;
        }
        if (this.transparency) {
          break label463;
        }
      }
    }
    label177:
    label455:
    label463:
    for (int j = this.lastBgColor;; j = 0)
    {
      int k = 0;
      for (;;)
      {
        if (k >= this.lrh) {
          break label177;
        }
        m = (this.lry + k) * this.width + this.lrx;
        n = this.lrw;
        i = m;
        for (;;)
        {
          if (i < n + m)
          {
            arrayOfInt[i] = j;
            i += 1;
            continue;
            this.lastImage = null;
            break;
          }
        }
        k += 1;
      }
      int m = 8;
      int n = 1;
      i = 0;
      k = i1;
      i1 = i;
      int i2;
      if (k < this.ih)
      {
        if (!this.interlace) {
          break label455;
        }
        i = i1;
        j = m;
        i2 = n;
        if (i1 >= this.ih) {
          i2 = n + 1;
        }
        switch (i2)
        {
        default: 
          j = m;
          i = i1;
          i1 = i + j;
          n = i2;
        }
      }
      for (;;)
      {
        i += this.iy;
        if (i < this.height)
        {
          int i3 = this.width * i;
          i2 = i3 + this.ix;
          m = this.iw + i2;
          i = m;
          if (this.width + i3 < m) {
            i = this.width + i3;
          }
          m = this.iw * k;
          for (;;)
          {
            if (i2 < i)
            {
              i3 = this.pixels[m];
              i3 = this.act[(i3 & 0xFF)];
              if (i3 != 0) {
                arrayOfInt[i2] = i3;
              }
              i2 += 1;
              m += 1;
              continue;
              i = 4;
              j = m;
              break;
              i = 2;
              j = 4;
              break;
              i = 1;
              j = 2;
              break;
            }
          }
        }
        k += 1;
        m = j;
        break;
        this.image = Bitmap.createBitmap(arrayOfInt, this.width, this.height, Bitmap.Config.ARGB_4444);
        return;
        i = k;
        j = m;
      }
    }
  }
  
  private void skip()
  {
    do
    {
      readBlock();
    } while ((this.blockSize > 0) && (!err()));
  }
  
  public void free()
  {
    for (GifFrame localGifFrame = this.gifFrame; localGifFrame != null; localGifFrame = this.gifFrame)
    {
      localGifFrame.image = null;
      this.gifFrame = this.gifFrame.nextFrame;
    }
    if (this.in != null) {}
    try
    {
      this.in.close();
      label47:
      this.in = null;
      this.gifData = null;
      return;
    }
    catch (Exception localException)
    {
      break label47;
    }
  }
  
  public GifFrame getCurrentFrame()
  {
    return this.currentFrame;
  }
  
  public int getDelay(int paramInt)
  {
    this.delay = -1;
    if ((paramInt >= 0) && (paramInt < this.frameCount))
    {
      GifFrame localGifFrame = getFrame(paramInt);
      if (localGifFrame != null) {
        this.delay = localGifFrame.delay;
      }
    }
    return this.delay;
  }
  
  public int[] getDelays()
  {
    GifFrame localGifFrame = this.gifFrame;
    int[] arrayOfInt = new int[this.frameCount];
    int i = 0;
    while ((localGifFrame != null) && (i < this.frameCount))
    {
      arrayOfInt[i] = localGifFrame.delay;
      localGifFrame = localGifFrame.nextFrame;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public GifFrame getFrame(int paramInt)
  {
    GifFrame localGifFrame = this.gifFrame;
    int i = 0;
    while (localGifFrame != null)
    {
      if (i == paramInt) {
        return localGifFrame;
      }
      localGifFrame = localGifFrame.nextFrame;
      i += 1;
    }
    return null;
  }
  
  public int getFrameCount()
  {
    return this.frameCount;
  }
  
  public Bitmap getFrameImage(int paramInt)
  {
    GifFrame localGifFrame = getFrame(paramInt);
    if (localGifFrame == null) {
      return null;
    }
    return localGifFrame.image;
  }
  
  public Bitmap getImage()
  {
    return getFrameImage(0);
  }
  
  public int getLoopCount()
  {
    return this.loopCount;
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public GifFrame next()
  {
    if (!this.isShow)
    {
      this.isShow = true;
      return this.gifFrame;
    }
    if (this.status == 0) {
      if (this.currentFrame.nextFrame != null) {
        this.currentFrame = this.currentFrame.nextFrame;
      }
    }
    for (;;)
    {
      return this.currentFrame;
      this.currentFrame = this.currentFrame.nextFrame;
      if (this.currentFrame == null) {
        this.currentFrame = this.gifFrame;
      }
    }
  }
  
  public boolean parseOk()
  {
    return this.status == -1;
  }
  
  public void reset()
  {
    this.currentFrame = this.gifFrame;
  }
  
  public void run()
  {
    if (this.in != null) {
      readStream();
    }
    while (this.gifData == null) {
      return;
    }
    readByte();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.gifimageview.GifDecoder
 * JD-Core Version:    0.7.0.1
 */