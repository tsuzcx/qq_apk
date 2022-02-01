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
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap)
  {
    String str = Build.VERSION.RELEASE;
    int j = 0;
    byte[] arrayOfByte1;
    if (paramArrayOfByte7 == null) {
      arrayOfByte1 = new byte[0];
    } else {
      arrayOfByte1 = paramArrayOfByte7;
    }
    if (paramArrayOfByte10 == null) {
      paramArrayOfByte10 = new byte[0];
    }
    int[] arrayOfInt = new int[8];
    int[] tmp46_44 = arrayOfInt;
    tmp46_44[0] = 1;
    int[] tmp50_46 = tmp46_44;
    tmp50_46[1] = 2;
    int[] tmp54_50 = tmp50_46;
    tmp54_50[2] = 3;
    int[] tmp58_54 = tmp54_50;
    tmp58_54[3] = 4;
    int[] tmp62_58 = tmp58_54;
    tmp62_58[4] = 13;
    int[] tmp67_62 = tmp62_58;
    tmp67_62[5] = 6;
    int[] tmp72_67 = tmp67_62;
    tmp72_67[6] = 7;
    int[] tmp78_72 = tmp72_67;
    tmp78_72[7] = 37;
    tmp78_72;
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; j < 8; i = k)
    {
      k = arrayOfInt[j];
      if (k != 13)
      {
        if (k != 37)
        {
          switch (k)
          {
          default: 
            switch (k)
            {
            default: 
              paramArrayOfByte7 = new byte[0];
              break;
            case 7: 
              paramArrayOfByte7 = new RegTLV(7);
              k = t.ah | 0x0;
              if (true == t.ag) {
                k |= 0x2;
              }
              paramArrayOfByte7.setInt(k | 0x8);
              paramArrayOfByte7 = paramArrayOfByte7.getBuf();
              break;
            case 6: 
              paramArrayOfByte7 = new RegTLV(6);
              byte[] arrayOfByte2 = new byte[paramArrayOfByte10.length + 3];
              if (paramArrayOfByte10.length == 0) {
                k = 1;
              } else {
                k = 2;
              }
              util.int8_to_buf(arrayOfByte2, 0, k);
              util.int16_to_buf(arrayOfByte2, 1, paramArrayOfByte10.length);
              System.arraycopy(paramArrayOfByte10, 0, arrayOfByte2, 3, paramArrayOfByte10.length);
              paramArrayOfByte7.setData(arrayOfByte2, arrayOfByte2.length);
              paramArrayOfByte7 = paramArrayOfByte7.getBuf();
            }
            break;
          case 4: 
            paramArrayOfByte7 = new RegTLV(4);
            paramArrayOfByte7.setData(paramArrayOfByte9, paramArrayOfByte9.length);
            paramArrayOfByte7 = paramArrayOfByte7.getBuf();
            break;
          case 3: 
            paramArrayOfByte7 = new RegTLV(3);
            paramArrayOfByte7.setData(paramArrayOfByte8, paramArrayOfByte8.length);
            paramArrayOfByte7 = paramArrayOfByte7.getBuf();
            break;
          case 2: 
            paramArrayOfByte7 = new RegTLV(2);
            paramArrayOfByte7.setLong(paramLong3);
            paramArrayOfByte7 = paramArrayOfByte7.getBuf();
            break;
          case 1: 
            paramArrayOfByte7 = new RegTLV(1);
            paramArrayOfByte7.setData(arrayOfByte1, arrayOfByte1.length);
            paramArrayOfByte7 = paramArrayOfByte7.getBuf();
            break;
          }
        }
        else
        {
          paramArrayOfByte7 = new RegTLV(37);
          paramArrayOfByte7.setShort(t.au);
          paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        }
      }
      else
      {
        paramArrayOfByte7 = new RegTLV(13);
        paramArrayOfByte7.setInt((int)paramLong2);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
      }
      k = i;
      if (paramArrayOfByte7.length > 4)
      {
        k = i + paramArrayOfByte7.length;
        localArrayList.add(paramArrayOfByte7);
      }
      j += 1;
    }
    paramArrayOfByte7 = paramMap.keySet().iterator();
    while (paramArrayOfByte7.hasNext())
    {
      paramArrayOfByte8 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte7.next())).getBuf();
      localArrayList.add(paramArrayOfByte8);
      i += paramArrayOfByte8.length;
    }
    int k = localArrayList.size();
    paramArrayOfByte7 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte7, 0, (byte)k);
    i = 0;
    j = 2;
    while (i < k)
    {
      paramArrayOfByte8 = (byte[])localArrayList.get(i);
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
      paramArrayOfByte9.writeByte(tmp46_44.length());
      paramArrayOfByte9.write(tmp46_44.getBytes());
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
      } else {
        paramArrayOfByte9.writeInt(0);
      }
      paramArrayOfByte9.writeByte(paramArrayOfByte5.length);
      paramArrayOfByte9.write(paramArrayOfByte5);
      paramArrayOfByte9.writeByte(paramArrayOfByte6.length);
      paramArrayOfByte9.write(paramArrayOfByte6);
      paramArrayOfByte9.write(paramArrayOfByte7);
      paramArrayOfByte1 = a(paramArrayOfByte8.toByteArray());
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte2 = new StringBuilder("get account failed ");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      util.LOGI(paramArrayOfByte2.toString(), "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */