package com.tencent.ttpic.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.ETC1;
import android.opengl.ETC1Util.ETC1Texture;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.etc.ETC1File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipPkmReader
{
  private ByteBuffer headerBuffer;
  private ZipEntry mZipEntry;
  private ZipInputStream mZipStream;
  private String path;
  
  public ZipPkmReader(String paramString)
  {
    this.path = paramString;
  }
  
  private ETC1Util.ETC1Texture createTexture(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    if (paramInputStream.read(arrayOfByte, 0, 16) != 16) {
      throw new IOException("Unable to read PKM file header.");
    }
    if (this.headerBuffer == null) {
      this.headerBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
    }
    this.headerBuffer.put(arrayOfByte, 0, 16).position(0);
    if (!ETC1.isValid(this.headerBuffer)) {
      throw new IOException("Not a PKM file.");
    }
    int i = ETC1.getWidth(this.headerBuffer);
    int j = ETC1.getHeight(this.headerBuffer);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(ETC1.getEncodedDataSize(i, j)).order(ByteOrder.nativeOrder());
    for (;;)
    {
      int k = paramInputStream.read(arrayOfByte);
      if (k == -1) {
        break;
      }
      localByteBuffer.put(arrayOfByte, 0, k);
    }
    localByteBuffer.position(0);
    return new ETC1Util.ETC1Texture(i, j, localByteBuffer);
  }
  
  private boolean hasElements()
  {
    try
    {
      if (this.mZipStream != null)
      {
        this.mZipEntry = this.mZipStream.getNextEntry();
        ZipEntry localZipEntry = this.mZipEntry;
        if (localZipEntry != null) {
          return true;
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  public void close()
  {
    if (this.mZipStream != null) {}
    try
    {
      this.mZipStream.closeEntry();
      this.mZipStream.close();
      if (this.headerBuffer != null)
      {
        this.headerBuffer.clear();
        this.headerBuffer = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public ETC1File getNextEntry()
  {
    ETC1Util.ETC1Texture localETC1Texture = getNextTexture();
    if ((localETC1Texture != null) && (!this.mZipEntry.getName().contains("../"))) {
      return new ETC1File(this.mZipEntry.getName(), localETC1Texture);
    }
    return null;
  }
  
  public InputStream getNextStream()
  {
    if (hasElements()) {
      return this.mZipStream;
    }
    return null;
  }
  
  public ETC1Util.ETC1Texture getNextTexture()
  {
    if (hasElements()) {
      try
      {
        ETC1Util.ETC1Texture localETC1Texture = createTexture(this.mZipStream);
        return localETC1Texture;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return null;
  }
  
  public boolean open()
  {
    if ((this.path == null) || (this.path.contains("../"))) {
      return false;
    }
    try
    {
      if (this.path.startsWith("assets://"))
      {
        this.mZipStream = new ZipInputStream(AEModule.getContext().getAssets().open(FileUtils.getRealPath(this.path)));
      }
      else
      {
        this.mZipStream = new ZipInputStream(new FileInputStream(this.path));
        this.mZipStream.reset();
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return false;
    }
    return true;
  }
  
  public void reset()
  {
    close();
    open();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.ZipPkmReader
 * JD-Core Version:    0.7.0.1
 */