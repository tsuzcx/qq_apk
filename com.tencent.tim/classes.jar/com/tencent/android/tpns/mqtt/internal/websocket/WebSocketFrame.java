package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class WebSocketFrame
{
  public static final int frameLengthOverhead = 6;
  private boolean closeFlag = false;
  private boolean fin;
  private byte opcode;
  private byte[] payload;
  
  public WebSocketFrame(byte paramByte, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.opcode = paramByte;
    this.fin = paramBoolean;
    this.payload = paramArrayOfByte;
  }
  
  public WebSocketFrame(InputStream paramInputStream)
    throws IOException
  {
    setFinAndOpCode((byte)paramInputStream.read());
    int i;
    int k;
    if (this.opcode == 2)
    {
      i = (byte)paramInputStream.read();
      if ((i & 0x80) != 0)
      {
        k = 1;
        i = (byte)(i & 0x7F);
        if (i != 127) {
          break label111;
        }
      }
    }
    for (;;)
    {
      int m = j;
      if (j > 0)
      {
        i = 0;
        m = j;
      }
      for (;;)
      {
        m -= 1;
        if (m < 0) {
          break;
        }
        i |= ((byte)paramInputStream.read() & 0xFF) << m * 8;
      }
      k = 0;
      break;
      label111:
      if (i == 126)
      {
        j = 2;
        continue;
        byte[] arrayOfByte = null;
        if (k != 0)
        {
          arrayOfByte = new byte[4];
          paramInputStream.read(arrayOfByte, 0, 4);
        }
        this.payload = new byte[i];
        j = i;
        m = 0;
        while (m != i)
        {
          int i1 = paramInputStream.read(this.payload, m, j);
          m += i1;
          j -= i1;
        }
        if (k != 0)
        {
          i = n;
          while (i < this.payload.length)
          {
            paramInputStream = this.payload;
            paramInputStream[i] = ((byte)(paramInputStream[i] ^ arrayOfByte[(i % 4)]));
            i += 1;
            continue;
            if (this.opcode != 8) {
              break label248;
            }
            this.closeFlag = true;
          }
        }
        return;
        label248:
        throw new IOException("Invalid Frame: Opcode: " + this.opcode);
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public WebSocketFrame(byte[] paramArrayOfByte)
  {
    Object localObject = ByteBuffer.wrap(paramArrayOfByte);
    setFinAndOpCode(((ByteBuffer)localObject).get());
    int i = ((ByteBuffer)localObject).get();
    int j;
    int k;
    if ((i & 0x80) != 0)
    {
      j = 1;
      k = (byte)(i & 0x7F);
      if (k != 127) {
        break label95;
      }
      i = 8;
    }
    for (;;)
    {
      i -= 1;
      if (i > 0)
      {
        k |= (((ByteBuffer)localObject).get() & 0xFF) << i * 8;
        continue;
        j = 0;
        break;
        label95:
        if (k != 126) {
          break label192;
        }
        i = 2;
        continue;
      }
      paramArrayOfByte = null;
      if (j != 0)
      {
        paramArrayOfByte = new byte[4];
        ((ByteBuffer)localObject).get(paramArrayOfByte, 0, 4);
      }
      this.payload = new byte[k];
      ((ByteBuffer)localObject).get(this.payload, 0, k);
      if (j != 0)
      {
        i = m;
        while (i < this.payload.length)
        {
          localObject = this.payload;
          localObject[i] = ((byte)(localObject[i] ^ paramArrayOfByte[(i % 4)]));
          i += 1;
        }
      }
      return;
      label192:
      i = 0;
    }
  }
  
  public static void appendFinAndOpCode(ByteBuffer paramByteBuffer, byte paramByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      i = (byte)'';
    }
    paramByteBuffer.put((byte)(i | paramByte & 0xF));
  }
  
  private static void appendLength(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Length cannot be negative");
    }
    if (paramBoolean) {}
    for (int i = -128; paramInt > 65535; i = 0)
    {
      paramByteBuffer.put((byte)(i | 0x7F));
      paramByteBuffer.put((byte)0);
      paramByteBuffer.put((byte)0);
      paramByteBuffer.put((byte)0);
      paramByteBuffer.put((byte)0);
      paramByteBuffer.put((byte)(paramInt >> 24 & 0xFF));
      paramByteBuffer.put((byte)(paramInt >> 16 & 0xFF));
      paramByteBuffer.put((byte)(paramInt >> 8 & 0xFF));
      paramByteBuffer.put((byte)(paramInt & 0xFF));
      return;
    }
    if (paramInt >= 126)
    {
      paramByteBuffer.put((byte)(i | 0x7E));
      paramByteBuffer.put((byte)(paramInt >> 8));
      paramByteBuffer.put((byte)(paramInt & 0xFF));
      return;
    }
    paramByteBuffer.put((byte)(i | paramInt));
  }
  
  public static void appendLengthAndMask(ByteBuffer paramByteBuffer, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      appendLength(paramByteBuffer, paramInt, true);
      paramByteBuffer.put(paramArrayOfByte);
      return;
    }
    appendLength(paramByteBuffer, paramInt, false);
  }
  
  public static byte[] generateMaskingKey()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    int i = localSecureRandom.nextInt(255);
    int j = localSecureRandom.nextInt(255);
    int k = localSecureRandom.nextInt(255);
    int m = localSecureRandom.nextInt(255);
    return new byte[] { (byte)i, (byte)j, (byte)k, (byte)m };
  }
  
  private void setFinAndOpCode(byte paramByte)
  {
    if ((paramByte & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.fin = bool;
      this.opcode = ((byte)(paramByte & 0xF));
      return;
    }
  }
  
  public byte[] encodeFrame()
  {
    int j = this.payload.length + 6;
    int i;
    if (this.payload.length > 65535) {
      i = j + 8;
    }
    ByteBuffer localByteBuffer;
    for (;;)
    {
      localByteBuffer = ByteBuffer.allocate(i);
      appendFinAndOpCode(localByteBuffer, this.opcode, this.fin);
      byte[] arrayOfByte1 = generateMaskingKey();
      appendLengthAndMask(localByteBuffer, this.payload.length, arrayOfByte1);
      i = 0;
      while (i < this.payload.length)
      {
        byte[] arrayOfByte2 = this.payload;
        byte b = (byte)(arrayOfByte2[i] ^ arrayOfByte1[(i % 4)]);
        arrayOfByte2[i] = b;
        localByteBuffer.put(b);
        i += 1;
      }
      i = j;
      if (this.payload.length >= 126) {
        i = j + 2;
      }
    }
    localByteBuffer.flip();
    return localByteBuffer.array();
  }
  
  public byte getOpcode()
  {
    return this.opcode;
  }
  
  public byte[] getPayload()
  {
    return this.payload;
  }
  
  public boolean isCloseFlag()
  {
    return this.closeFlag;
  }
  
  public boolean isFin()
  {
    return this.fin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.WebSocketFrame
 * JD-Core Version:    0.7.0.1
 */