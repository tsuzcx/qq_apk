package oicq.wlogin_sdk.a;

import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tools.util;

public class f
  extends a
{
  public f()
  {
    this.b = 10;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, Map paramMap)
  {
    String str = Build.VERSION.RELEASE;
    byte[] arrayOfByte1 = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      arrayOfByte1 = new byte[0];
    }
    byte[] arrayOfByte2 = paramArrayOfByte10;
    if (paramArrayOfByte10 == null) {
      arrayOfByte2 = new byte[0];
    }
    int[] arrayOfInt = new int[8];
    int[] tmp41_39 = arrayOfInt;
    tmp41_39[0] = 1;
    int[] tmp45_41 = tmp41_39;
    tmp45_41[1] = 2;
    int[] tmp49_45 = tmp45_41;
    tmp49_45[2] = 3;
    int[] tmp53_49 = tmp49_45;
    tmp53_49[3] = 4;
    int[] tmp57_53 = tmp53_49;
    tmp57_53[4] = 13;
    int[] tmp62_57 = tmp57_53;
    tmp62_57[5] = 6;
    int[] tmp67_62 = tmp62_57;
    tmp67_62[6] = 7;
    int[] tmp73_67 = tmp67_62;
    tmp73_67[7] = 37;
    tmp73_67;
    paramArrayOfByte10 = new ArrayList();
    int i1 = tmp45_41.length;
    int j = 0;
    int i = 0;
    int n = 0;
    if (n < i1)
    {
      paramArrayOfByte7 = new byte[0];
      switch (tmp45_41[n])
      {
      }
      for (;;)
      {
        k = i;
        int m = j;
        if (paramArrayOfByte7.length > 4)
        {
          m = j + 1;
          k = i + paramArrayOfByte7.length;
          paramArrayOfByte10.add(paramArrayOfByte7);
        }
        n += 1;
        j = m;
        i = k;
        break;
        paramArrayOfByte7 = new RegTLV(1);
        paramArrayOfByte7.setData(arrayOfByte1, arrayOfByte1.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(2);
        paramArrayOfByte7.setLong(paramLong3);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(3);
        paramArrayOfByte7.setData(paramArrayOfByte8, paramArrayOfByte8.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(4);
        paramArrayOfByte7.setData(paramArrayOfByte9, paramArrayOfByte9.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(13);
        paramArrayOfByte7.setInt((int)paramLong2);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(6);
        byte[] arrayOfByte3 = new byte[arrayOfByte2.length + 3];
        if (arrayOfByte2.length == 0) {}
        for (k = 1;; k = 2)
        {
          util.int8_to_buf(arrayOfByte3, 0, k);
          util.int16_to_buf(arrayOfByte3, 1, arrayOfByte2.length);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 3, arrayOfByte2.length);
          k = arrayOfByte2.length;
          paramArrayOfByte7.setData(arrayOfByte3, arrayOfByte3.length);
          paramArrayOfByte7 = paramArrayOfByte7.getBuf();
          break;
        }
        paramArrayOfByte7 = new RegTLV(7);
        m = 0x0 | t.ah;
        k = m;
        if (true == t.ag) {
          k = m | 0x2;
        }
        paramArrayOfByte7.setInt(k | 0x8);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        continue;
        paramArrayOfByte7 = new RegTLV(37);
        paramArrayOfByte7.setShort(t.au);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      }
    }
    paramArrayOfByte7 = paramMap.keySet().iterator();
    while (paramArrayOfByte7.hasNext())
    {
      paramArrayOfByte8 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte7.next())).getBuf();
      paramArrayOfByte10.add(paramArrayOfByte8);
      i += paramArrayOfByte8.length;
    }
    int k = paramArrayOfByte10.size();
    paramArrayOfByte7 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte7, 0, (byte)k);
    j = 2;
    i = 0;
    while (i < k)
    {
      paramArrayOfByte8 = (byte[])paramArrayOfByte10.get(i);
      System.arraycopy(paramArrayOfByte8, 0, paramArrayOfByte7, j, paramArrayOfByte8.length);
      j += paramArrayOfByte8.length;
      i += 1;
    }
    paramArrayOfByte8 = new ByteArrayOutputStream();
    paramArrayOfByte9 = new DataOutputStream(paramArrayOfByte8);
    try
    {
      paramArrayOfByte9.writeByte(paramArrayOfByte1.length);
      paramArrayOfByte9.write(paramArrayOfByte1);
      paramArrayOfByte9.writeByte(this.c);
      paramArrayOfByte9.writeByte(tmp41_39.length());
      paramArrayOfByte9.write(tmp41_39.getBytes());
      paramArrayOfByte9.writeByte(paramArrayOfByte2.length);
      paramArrayOfByte9.write(paramArrayOfByte2);
      paramArrayOfByte9.writeByte(paramArrayOfByte3.length);
      paramArrayOfByte9.write(paramArrayOfByte3);
      paramArrayOfByte9.writeByte(paramInt1);
      paramArrayOfByte9.writeByte(paramInt2);
      paramArrayOfByte9.writeByte(paramInt3);
      paramArrayOfByte9.writeInt((int)paramLong1);
      if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length == 4)) {
        paramArrayOfByte9.write(paramArrayOfByte4);
      }
      for (;;)
      {
        paramArrayOfByte9.writeByte(paramArrayOfByte5.length);
        paramArrayOfByte9.write(paramArrayOfByte5);
        paramArrayOfByte9.writeByte(paramArrayOfByte6.length);
        paramArrayOfByte9.write(paramArrayOfByte6);
        paramArrayOfByte9.write(paramArrayOfByte7);
        return a(paramArrayOfByte8.toByteArray());
        paramArrayOfByte9.writeInt(0);
      }
      return null;
    }
    catch (Exception paramArrayOfByte1)
    {
      util.LOGI("get account failed " + paramArrayOfByte1.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */