package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import aoll;
import aoll.b;
import aqoj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.HashMap;

public class PicCryptor
  implements aoll.b
{
  private int aqR;
  public long asW;
  public aoll d;
  private int dZt;
  private int dZu;
  private int dZv;
  private int dZw;
  private boolean first = true;
  private byte[] gC;
  private byte[] gD;
  private byte[] gE;
  private byte[] gF;
  private byte[] gG;
  private int state;
  
  static
  {
    SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "piccryptor");
  }
  
  public PicCryptor(byte[] paramArrayOfByte)
  {
    this.gE = paramArrayOfByte;
    this.state = 0;
  }
  
  public static String B(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = aqoj.C(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("byte2Hex error, byte not null");
    }
    return paramArrayOfByte.toLowerCase();
  }
  
  private byte[] H(byte[] paramArrayOfByte)
    throws Exception
  {
    if (paramArrayOfByte == null)
    {
      arrayOfByte1 = null;
      return arrayOfByte1;
    }
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte1 = new byte[j];
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      if (this.dZw >= this.gF.length) {
        throw new Exception("decryptKey len overflow! bodyLen:" + this.dZu + ",encryptLen:" + this.gF.length);
      }
      k = paramArrayOfByte[i];
      byte[] arrayOfByte2 = this.gF;
      int m = this.dZw;
      this.dZw = (m + 1);
      arrayOfByte1[i] = ((byte)(k ^ arrayOfByte2[m]));
      if (this.dZw == this.dZu)
      {
        this.state = 2;
        k = j - (i + 1);
        if ((k == 1) && (paramArrayOfByte[(i + 1)] == 41))
        {
          paramArrayOfByte = new byte[j - 1];
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, j - 1);
        }
      }
    }
    for (;;)
    {
      arrayOfByte1 = paramArrayOfByte;
      if (!this.first) {
        break;
      }
      this.first = false;
      arrayOfByte1 = new byte[Math.min(20, j)];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
      return paramArrayOfByte;
      if (k != 0) {
        throw new IllegalArgumentException("Invalid encrypt data end format");
      }
      i += 1;
      break label20;
      paramArrayOfByte = arrayOfByte1;
    }
  }
  
  private int LX()
  {
    String str = (String)this.d.u.get("Range");
    if (!TextUtils.isEmpty(str))
    {
      str = str.replace("bytes=", "");
      int i = str.indexOf("-");
      if (i != -1) {
        return Integer.valueOf(str.substring(0, i)).intValue();
      }
    }
    return 0;
  }
  
  public static void aS(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static byte[] af(String paramString)
    throws IllegalArgumentException
  {
    paramString = aqoj.ag(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("hex2byte error, hexStr length must even");
    }
    return paramString;
  }
  
  public static byte[] teaDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length < 0)) {
      throw new Exception("Tea Decrypt Error ! ");
    }
    return paramArrayOfByte1;
  }
  
  public byte[] G(byte[] paramArrayOfByte)
    throws Exception
  {
    boolean bool2 = true;
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer1.put(paramArrayOfByte);
    localByteBuffer1.rewind();
    if (localByteBuffer1.get() == 40)
    {
      bool1 = true;
      aS(bool1, "Invalid encrypt data start format");
      this.dZt = localByteBuffer1.getInt();
      this.dZu = localByteBuffer1.getInt();
      if ((this.dZt <= 0) || (this.dZu <= 0)) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = true;; bool1 = false)
    {
      aS(bool1, "head or body length is not negative");
      if (this.dZt + 1 + 8 <= paramArrayOfByte.length) {
        break label107;
      }
      return null;
      bool1 = false;
      break;
    }
    label107:
    this.aqR = localByteBuffer1.getShort();
    ByteBuffer localByteBuffer2;
    if (this.aqR == 1)
    {
      bool1 = true;
      aS(bool1, "magic num not equal 1!");
      this.gC = new byte[this.dZt - 2];
      localByteBuffer1.get(this.gC);
      paramArrayOfByte = teaDecrypt(this.gC, this.gE);
      localByteBuffer2 = ByteBuffer.allocate(paramArrayOfByte.length);
      localByteBuffer2.put(paramArrayOfByte);
      localByteBuffer2.rewind();
      this.dZv = localByteBuffer2.getShort();
      if (this.dZv <= 0) {
        break label450;
      }
    }
    label450:
    for (bool1 = bool2;; bool1 = false)
    {
      aS(bool1, "seed len is no allow negative");
      try
      {
        this.gD = new byte[this.dZv];
        localByteBuffer2.get(this.gD);
        paramArrayOfByte = getISSACSequence(B(this.gD), this.dZu + LX()).substring(LX() * 2);
        if (paramArrayOfByte == null) {
          return null;
        }
        long l = Runtime.getRuntime().totalMemory();
        l = Runtime.getRuntime().maxMemory() - (l - Runtime.getRuntime().freeMemory());
        if (l < paramArrayOfByte.length() * 3)
        {
          QLog.e("PicCryptor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + l + ", flowKeyHexStr.length() = " + paramArrayOfByte.length());
          throw new Exception("applying memory too large!");
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      this.gF = af(paramArrayOfByte);
      this.state = 1;
      this.dZw = 0;
      try
      {
        paramArrayOfByte = MessageDigest.getInstance("MD5");
        paramArrayOfByte.update(this.gF);
        B(paramArrayOfByte.digest());
        int i = localByteBuffer1.capacity() - localByteBuffer1.position();
        if (i > 0)
        {
          paramArrayOfByte = new byte[i];
          localByteBuffer1.get(paramArrayOfByte);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
      return null;
      bool1 = false;
      break;
    }
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
    throws Exception
  {
    Object localObject2 = null;
    long l1 = SystemClock.uptimeMillis();
    Object localObject1;
    if (this.state == 0) {
      if (this.gG != null)
      {
        localObject1 = new byte[this.gG.length + paramArrayOfByte.length];
        System.arraycopy(this.gG, 0, localObject1, 0, this.gG.length);
        System.arraycopy(paramArrayOfByte, 0, localObject1, 0, paramArrayOfByte.length);
        this.gG = ((byte[])localObject1);
        paramArrayOfByte = G(this.gG);
        localObject1 = localObject2;
        if (this.state == 1)
        {
          localObject1 = localObject2;
          if (paramArrayOfByte != null) {
            localObject1 = H(paramArrayOfByte);
          }
        }
      }
    }
    label148:
    do
    {
      for (;;)
      {
        long l2 = this.asW;
        this.asW = (SystemClock.uptimeMillis() - l1 + l2);
        return localObject1;
        this.gG = paramArrayOfByte;
        break;
        if (this.state != 1) {
          break label148;
        }
        localObject1 = H(paramArrayOfByte);
      }
      if (paramArrayOfByte.length != 1) {
        break label166;
      }
      localObject1 = localObject2;
    } while (paramArrayOfByte[0] == 41);
    label166:
    throw new Exception("pic data len is error!");
  }
  
  public native String getISSACSequence(String paramString, int paramInt);
  
  public boolean isFinish()
  {
    return this.state == 2;
  }
  
  public void reset()
  {
    this.state = 0;
    this.first = true;
    this.gG = null;
    this.dZw = 0;
    this.asW = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PicCryptor
 * JD-Core Version:    0.7.0.1
 */