import android.util.Pair;
import cooperation.qzone.util.QZLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class avsa
  implements Closeable
{
  public avsa.a a;
  public avsa.b[] a;
  public avsa.c[] a;
  private final FileInputStream b;
  private final Map<String, avsa.c> qd = new HashMap();
  
  public avsa(File paramFile)
    throws IOException
  {
    this.b = new FileInputStream(paramFile);
    Object localObject = this.b.getChannel();
    this.jdField_a_of_type_Avsa$a = new avsa.a((FileChannel)localObject, null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.jdField_a_of_type_Avsa$a.aE);
    if (this.jdField_a_of_type_Avsa$a.hY[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.jdField_a_of_type_Avsa$a.azY);
      this.jdField_a_of_type_ArrayOfAvsa$b = new avsa.b[this.jdField_a_of_type_Avsa$a.aF];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfAvsa$b.length)
      {
        a((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.jdField_a_of_type_ArrayOfAvsa$b[i] = new avsa.b(localByteBuffer, this.jdField_a_of_type_Avsa$a.hY[4], null);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.jdField_a_of_type_Avsa$a.azZ);
    localByteBuffer.limit(this.jdField_a_of_type_Avsa$a.aG);
    this.jdField_a_of_type_ArrayOfAvsa$c = new avsa.c[this.jdField_a_of_type_Avsa$a.aH];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAvsa$c.length)
    {
      a((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.jdField_a_of_type_ArrayOfAvsa$c[i] = new avsa.c(localByteBuffer, this.jdField_a_of_type_Avsa$a.hY[4], null);
      i += 1;
    }
    if (this.jdField_a_of_type_Avsa$a.aI > 0)
    {
      paramFile = a(this.jdField_a_of_type_ArrayOfAvsa$c[this.jdField_a_of_type_Avsa$a.aI]);
      localObject = this.jdField_a_of_type_ArrayOfAvsa$c;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.eyg);
        localByteBuffer.cNk = a(paramFile);
        this.qd.put(localByteBuffer.cNk, localByteBuffer);
        i += 1;
      }
    }
  }
  
  public static Pair<Integer, Throwable> a(File paramFile)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramFile = new avsa(paramFile);
        if (paramFile == null) {}
      }
      catch (IOException paramFile)
      {
        Object localObject = paramFile.getMessage();
        if (localObject == null) {
          continue;
        }
        if (!((String)localObject).startsWith("bad elf magic")) {
          continue;
        }
        i = -1;
        localObject = new Pair(Integer.valueOf(i), paramFile);
        paramFile = (File)localObject;
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramFile)
        {
          QZLog.e("ShareElfFile", "", paramFile);
          return localObject;
        }
        if (!((String)localObject).startsWith("bad elf class")) {
          continue;
        }
        i = -2;
        continue;
        if (!((String)localObject).startsWith("bad elf data encoding")) {
          continue;
        }
        i = -3;
        continue;
        if (!((String)localObject).startsWith("failed to read rest part of ehdr")) {
          continue;
        }
        i = -4;
        continue;
        if (!((String)localObject).startsWith("bad elf version")) {
          continue;
        }
        i = -5;
        continue;
        if (!((String)localObject).startsWith("Unexpected elf class")) {
          continue;
        }
        i = -6;
        continue;
        if (!((String)localObject).startsWith("failed to read phdr")) {
          continue;
        }
        i = -7;
        continue;
        boolean bool = ((String)localObject).startsWith("failed to read shdr");
        if (!bool) {
          continue;
        }
        i = -8;
        continue;
        i = -1000;
        continue;
      }
      finally
      {
        if (0 == 0) {
          break label232;
        }
      }
      try
      {
        paramFile.close();
        paramFile = new Pair(Integer.valueOf(0), null);
        return paramFile;
      }
      catch (IOException paramFile)
      {
        QZLog.e("ShareElfFile", "", paramFile);
      }
    }
    try
    {
      throw new NullPointerException();
      label232:
      throw paramFile;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QZLog.e("ShareElfFile", "", localIOException);
      }
    }
  }
  
  public static String a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
    throws IOException
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  private static void q(int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws IOException
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new IOException(paramString);
    }
  }
  
  public ByteBuffer a(avsa.c paramc)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramc.aAj);
    this.b.getChannel().position(paramc.aAi);
    a(this.b.getChannel(), localByteBuffer, "failed to read section: " + paramc.cNk);
    return localByteBuffer;
  }
  
  public void close()
    throws IOException
  {
    this.b.close();
    this.qd.clear();
    this.jdField_a_of_type_ArrayOfAvsa$b = null;
    this.jdField_a_of_type_ArrayOfAvsa$c = null;
  }
  
  public static class a
  {
    public final short aB;
    public final short aC;
    public final short aD;
    public final short aE;
    public final short aF;
    public final short aG;
    public final short aH;
    public final short aI;
    public final long azX;
    public final long azY;
    public final long azZ;
    public final int eyc;
    public final int eyd;
    public final byte[] hY = new byte[16];
    
    private a(FileChannel paramFileChannel)
      throws IOException
    {
      paramFileChannel.position(0L);
      paramFileChannel.read(ByteBuffer.wrap(this.hY));
      if ((this.hY[0] != 127) || (this.hY[1] != 69) || (this.hY[2] != 76) || (this.hY[3] != 70)) {
        throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.hY[0]), Byte.valueOf(this.hY[1]), Byte.valueOf(this.hY[2]), Byte.valueOf(this.hY[3]) }));
      }
      avsa.r(this.hY[4], 1, 2, "bad elf class: " + this.hY[4]);
      avsa.r(this.hY[5], 1, 2, "bad elf data encoding: " + this.hY[5]);
      int i;
      label222:
      ByteBuffer localByteBuffer;
      if (this.hY[4] == 1)
      {
        i = 36;
        localByteBuffer = ByteBuffer.allocate(i);
        if (this.hY[5] != 1) {
          break label382;
        }
      }
      label382:
      for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
      {
        localByteBuffer.order(localByteOrder);
        avsa.a(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
        this.aB = localByteBuffer.getShort();
        this.aC = localByteBuffer.getShort();
        this.eyc = localByteBuffer.getInt();
        avsa.r(this.eyc, 1, 1, "bad elf version: " + this.eyc);
        switch (this.hY[4])
        {
        default: 
          throw new IOException("Unexpected elf class: " + this.hY[4]);
          i = 48;
          break label222;
        }
      }
      this.azX = localByteBuffer.getInt();
      this.azY = localByteBuffer.getInt();
      for (this.azZ = localByteBuffer.getInt();; this.azZ = localByteBuffer.getLong())
      {
        this.eyd = localByteBuffer.getInt();
        this.aD = localByteBuffer.getShort();
        this.aE = localByteBuffer.getShort();
        this.aF = localByteBuffer.getShort();
        this.aG = localByteBuffer.getShort();
        this.aH = localByteBuffer.getShort();
        this.aI = localByteBuffer.getShort();
        return;
        this.azX = localByteBuffer.getLong();
        this.azY = localByteBuffer.getLong();
      }
    }
  }
  
  public static class b
  {
    public final long aAa;
    public final long aAb;
    public final long aAc;
    public final long aAd;
    public final long aAe;
    public final long aAf;
    public final int eye;
    public final int eyf;
    
    private b(ByteBuffer paramByteBuffer, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.eye = paramByteBuffer.getInt();
        this.aAa = paramByteBuffer.getInt();
        this.aAb = paramByteBuffer.getInt();
        this.aAc = paramByteBuffer.getInt();
        this.aAd = paramByteBuffer.getInt();
        this.aAe = paramByteBuffer.getInt();
        this.eyf = paramByteBuffer.getInt();
        this.aAf = paramByteBuffer.getInt();
        return;
      }
      this.eye = paramByteBuffer.getInt();
      this.eyf = paramByteBuffer.getInt();
      this.aAa = paramByteBuffer.getLong();
      this.aAb = paramByteBuffer.getLong();
      this.aAc = paramByteBuffer.getLong();
      this.aAd = paramByteBuffer.getLong();
      this.aAe = paramByteBuffer.getLong();
      this.aAf = paramByteBuffer.getLong();
    }
  }
  
  public static class c
  {
    public final long aAg;
    public final long aAh;
    public final long aAi;
    public final long aAj;
    public final long aAk;
    public final long aAl;
    public String cNk;
    public final int eyg;
    public final int eyh;
    public final int eyi;
    public final int eyj;
    
    private c(ByteBuffer paramByteBuffer, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.eyg = paramByteBuffer.getInt();
        this.eyh = paramByteBuffer.getInt();
        this.aAg = paramByteBuffer.getInt();
        this.aAh = paramByteBuffer.getInt();
        this.aAi = paramByteBuffer.getInt();
        this.aAj = paramByteBuffer.getInt();
        this.eyi = paramByteBuffer.getInt();
        this.eyj = paramByteBuffer.getInt();
        this.aAk = paramByteBuffer.getInt();
      }
      for (this.aAl = paramByteBuffer.getInt();; this.aAl = paramByteBuffer.getLong())
      {
        this.cNk = null;
        return;
        this.eyg = paramByteBuffer.getInt();
        this.eyh = paramByteBuffer.getInt();
        this.aAg = paramByteBuffer.getLong();
        this.aAh = paramByteBuffer.getLong();
        this.aAi = paramByteBuffer.getLong();
        this.aAj = paramByteBuffer.getLong();
        this.eyi = paramByteBuffer.getInt();
        this.eyj = paramByteBuffer.getInt();
        this.aAk = paramByteBuffer.getLong();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avsa
 * JD-Core Version:    0.7.0.1
 */