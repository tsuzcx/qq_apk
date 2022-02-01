package oicq.wlogin_sdk.a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.request.t;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class b
  extends a
{
  public b()
  {
    this.b = 6;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, int paramInt2, Map<Integer, RegTLV> paramMap)
  {
    byte[] arrayOfByte1;
    if (paramArrayOfByte6 == null) {
      arrayOfByte1 = new byte[0];
    } else {
      arrayOfByte1 = paramArrayOfByte6;
    }
    byte[] arrayOfByte2;
    if (paramArrayOfByte4 == null) {
      arrayOfByte2 = new byte[0];
    } else {
      arrayOfByte2 = paramArrayOfByte4;
    }
    if (paramArrayOfByte7 == null) {
      paramArrayOfByte4 = new byte[0];
    } else {
      paramArrayOfByte4 = paramArrayOfByte7;
    }
    if (paramBoolean)
    {
      paramArrayOfByte6 = new int[11];
      byte[] tmp64_62 = paramArrayOfByte6;
      tmp64_62[0] = 1;
      byte[] tmp68_64 = tmp64_62;
      tmp68_64[1] = 5;
      byte[] tmp72_68 = tmp68_64;
      tmp72_68[2] = 6;
      byte[] tmp77_72 = tmp72_68;
      tmp77_72[3] = 8;
      byte[] tmp82_77 = tmp77_72;
      tmp82_77[4] = 15;
      byte[] tmp87_82 = tmp82_77;
      tmp87_82[5] = 37;
      byte[] tmp92_87 = tmp87_82;
      tmp92_87[6] = 9;
      byte[] tmp98_92 = tmp92_87;
      tmp98_92[7] = 10;
      byte[] tmp104_98 = tmp98_92;
      tmp104_98[8] = 11;
      byte[] tmp110_104 = tmp104_98;
      tmp110_104[9] = 13;
      byte[] tmp116_110 = tmp110_104;
      tmp116_110[10] = 14;
      tmp116_110;
    }
    else
    {
      paramArrayOfByte6 = new int[9];
      byte[] tmp134_132 = paramArrayOfByte6;
      tmp134_132[0] = 1;
      byte[] tmp138_134 = tmp134_132;
      tmp138_134[1] = 5;
      byte[] tmp142_138 = tmp138_134;
      tmp142_138[2] = 6;
      byte[] tmp147_142 = tmp142_138;
      tmp147_142[3] = 8;
      byte[] tmp152_147 = tmp147_142;
      tmp152_147[4] = 15;
      byte[] tmp157_152 = tmp152_147;
      tmp157_152[5] = 37;
      byte[] tmp162_157 = tmp157_152;
      tmp162_157[6] = 10;
      byte[] tmp168_162 = tmp162_157;
      tmp168_162[7] = 13;
      byte[] tmp174_168 = tmp168_162;
      tmp174_168[8] = 14;
      tmp174_168;
    }
    ArrayList localArrayList = new ArrayList();
    int m = paramArrayOfByte6.length;
    int j = 0;
    int i = 0;
    paramArrayOfByte7 = paramArrayOfByte6;
    paramArrayOfByte6 = paramArrayOfByte4;
    for (;;)
    {
      paramArrayOfByte4 = paramArrayOfByte8;
      if (j >= m) {
        break;
      }
      int k = paramArrayOfByte7[j];
      if (k != 1)
      {
        if (k != 37)
        {
          switch (k)
          {
          default: 
            switch (k)
            {
            default: 
              switch (k)
              {
              default: 
                paramArrayOfByte4 = new byte[0];
                break;
              case 15: 
                paramArrayOfByte4 = new RegTLV(15);
                paramArrayOfByte4.setInt(paramInt2);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
                break;
              case 14: 
                RegTLV localRegTLV = new RegTLV(14);
                localRegTLV.setData(paramArrayOfByte4, paramArrayOfByte4.length);
                paramArrayOfByte4 = localRegTLV.getBuf();
                break;
              case 13: 
                paramArrayOfByte4 = new RegTLV(13);
                paramArrayOfByte4.setInt((int)paramLong);
                paramArrayOfByte4 = paramArrayOfByte4.getBuf();
              }
              break;
            case 11: 
              paramArrayOfByte4 = new RegTLV(11);
              paramArrayOfByte4.setData(paramArrayOfByte3, paramArrayOfByte3.length);
              paramArrayOfByte4 = paramArrayOfByte4.getBuf();
              break;
            case 10: 
              paramArrayOfByte4 = new RegTLV(10);
              paramArrayOfByte4.setData(paramArrayOfByte6, paramArrayOfByte6.length);
              paramArrayOfByte4 = paramArrayOfByte4.getBuf();
              break;
            case 9: 
              paramArrayOfByte4 = new RegTLV(9);
              paramArrayOfByte4.setByte((byte)1);
              paramArrayOfByte4 = paramArrayOfByte4.getBuf();
              break;
            case 8: 
              paramArrayOfByte4 = new RegTLV(8);
              paramArrayOfByte4.setByte((byte)1);
              paramArrayOfByte4 = paramArrayOfByte4.getBuf();
            }
            break;
          case 6: 
            paramArrayOfByte4 = new RegTLV(6);
            paramArrayOfByte4.setData(arrayOfByte2, arrayOfByte2.length);
            paramArrayOfByte4 = paramArrayOfByte4.getBuf();
            break;
          case 5: 
            paramArrayOfByte4 = new RegTLV(5);
            paramArrayOfByte4.setData(arrayOfByte1, arrayOfByte1.length);
            paramArrayOfByte4 = paramArrayOfByte4.getBuf();
            break;
          }
        }
        else
        {
          paramArrayOfByte4 = new RegTLV(37);
          paramArrayOfByte4.setShort(t.au);
          paramArrayOfByte4 = paramArrayOfByte4.getBuf();
        }
      }
      else
      {
        paramArrayOfByte4 = new RegTLV(1);
        paramArrayOfByte4.setData(paramArrayOfByte5, paramArrayOfByte5.length);
        paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      }
      k = i;
      if (paramArrayOfByte4.length >= 2)
      {
        k = i + paramArrayOfByte4.length;
        localArrayList.add(paramArrayOfByte4);
      }
      j += 1;
      i = k;
    }
    paramArrayOfByte4 = paramMap.keySet().iterator();
    while (paramArrayOfByte4.hasNext())
    {
      paramArrayOfByte5 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte4.next())).getBuf();
      localArrayList.add(paramArrayOfByte5);
      i += paramArrayOfByte5.length;
    }
    j = localArrayList.size();
    paramArrayOfByte4 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte4, 0, (byte)j);
    paramArrayOfByte5 = new StringBuilder();
    paramArrayOfByte5.append("tlv cnt ");
    paramArrayOfByte5.append(j);
    util.LOGI(paramArrayOfByte5.toString(), "");
    paramInt2 = 0;
    i = 2;
    while (paramInt2 < j)
    {
      paramArrayOfByte5 = (byte[])localArrayList.get(paramInt2);
      System.arraycopy(paramArrayOfByte5, 0, paramArrayOfByte4, i, paramArrayOfByte5.length);
      i += paramArrayOfByte5.length;
      paramInt2 += 1;
    }
    paramArrayOfByte5 = new ByteArrayOutputStream();
    paramArrayOfByte6 = new DataOutputStream(paramArrayOfByte5);
    try
    {
      paramArrayOfByte6.writeByte(paramArrayOfByte1.length);
      paramArrayOfByte6.write(paramArrayOfByte1);
      paramArrayOfByte6.writeByte(paramArrayOfByte3.length);
      paramArrayOfByte6.write(paramArrayOfByte3);
      paramArrayOfByte6.writeByte(paramInt1);
      paramArrayOfByte6.write(paramArrayOfByte4);
      paramArrayOfByte3 = paramArrayOfByte5.toByteArray();
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
      {
        paramArrayOfByte4 = new StringBuilder();
        paramArrayOfByte4.append("msgchk is ");
        paramArrayOfByte4.append(util.buf_to_string(paramArrayOfByte2, paramArrayOfByte2.length));
        util.LOGI(paramArrayOfByte4.toString(), "");
        paramArrayOfByte2 = MD5.toMD5Byte(paramArrayOfByte2);
      }
      else
      {
        util.LOGI("msgchk is null or length is 0", "");
        paramArrayOfByte2 = h.a.getBytes();
      }
      paramArrayOfByte2 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
      this.d = (paramArrayOfByte1.length + 1 + 2 + paramArrayOfByte2.length);
      paramArrayOfByte3 = new byte[this.d];
      util.int8_to_buf(paramArrayOfByte3, 0, paramArrayOfByte1.length);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 1, paramArrayOfByte1.length);
      paramInt1 = 1 + paramArrayOfByte1.length;
      util.int16_to_buf(paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1 + 2, paramArrayOfByte2.length);
      paramInt1 = paramArrayOfByte2.length;
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("encryptedContent length ");
      paramArrayOfByte1.append(paramArrayOfByte2.length);
      util.LOGI(paramArrayOfByte1.toString(), "");
      return a(paramArrayOfByte3);
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("get account failed ");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      util.LOGI(paramArrayOfByte2.toString(), "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */