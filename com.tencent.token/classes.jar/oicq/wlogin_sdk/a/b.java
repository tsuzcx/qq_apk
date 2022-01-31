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
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt1, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean, byte[] paramArrayOfByte7, long paramLong, byte[] paramArrayOfByte8, int paramInt2, Map paramMap)
  {
    byte[] arrayOfByte1 = paramArrayOfByte6;
    if (paramArrayOfByte6 == null) {
      arrayOfByte1 = new byte[0];
    }
    paramArrayOfByte6 = paramArrayOfByte4;
    if (paramArrayOfByte4 == null) {
      paramArrayOfByte6 = new byte[0];
    }
    byte[] arrayOfByte2 = paramArrayOfByte7;
    if (paramArrayOfByte7 == null) {
      arrayOfByte2 = new byte[0];
    }
    ArrayList localArrayList;
    int n;
    if (paramBoolean)
    {
      paramArrayOfByte7 = new int[11];
      byte[] tmp55_53 = paramArrayOfByte7;
      tmp55_53[0] = 1;
      byte[] tmp59_55 = tmp55_53;
      tmp59_55[1] = 5;
      byte[] tmp63_59 = tmp59_55;
      tmp63_59[2] = 6;
      byte[] tmp68_63 = tmp63_59;
      tmp68_63[3] = 8;
      byte[] tmp73_68 = tmp68_63;
      tmp73_68[4] = 15;
      byte[] tmp78_73 = tmp73_68;
      tmp78_73[5] = 37;
      byte[] tmp83_78 = tmp78_73;
      tmp83_78[6] = 9;
      byte[] tmp89_83 = tmp83_78;
      tmp89_83[7] = 10;
      byte[] tmp95_89 = tmp89_83;
      tmp95_89[8] = 11;
      byte[] tmp101_95 = tmp95_89;
      tmp101_95[9] = 13;
      byte[] tmp107_101 = tmp101_95;
      tmp107_101[10] = 14;
      tmp107_101;
      localArrayList = new ArrayList();
      int i1 = paramArrayOfByte7.length;
      j = 0;
      i = 0;
      n = 0;
      label137:
      if (n >= i1) {
        break label686;
      }
      paramArrayOfByte4 = new byte[0];
      switch (paramArrayOfByte7[n])
      {
      }
    }
    for (;;)
    {
      int k = i;
      int m = j;
      if (paramArrayOfByte4.length >= 2)
      {
        m = j + 1;
        k = i + paramArrayOfByte4.length;
        localArrayList.add(paramArrayOfByte4);
      }
      n += 1;
      j = m;
      i = k;
      break label137;
      paramArrayOfByte7 = new int[9];
      byte[] tmp314_312 = paramArrayOfByte7;
      tmp314_312[0] = 1;
      byte[] tmp318_314 = tmp314_312;
      tmp318_314[1] = 5;
      byte[] tmp322_318 = tmp318_314;
      tmp322_318[2] = 6;
      byte[] tmp327_322 = tmp322_318;
      tmp327_322[3] = 8;
      byte[] tmp332_327 = tmp327_322;
      tmp332_327[4] = 15;
      byte[] tmp337_332 = tmp332_327;
      tmp337_332[5] = 37;
      byte[] tmp342_337 = tmp337_332;
      tmp342_337[6] = 10;
      byte[] tmp348_342 = tmp342_337;
      tmp348_342[7] = 13;
      byte[] tmp354_348 = tmp348_342;
      tmp354_348[8] = 14;
      tmp354_348;
      break;
      paramArrayOfByte4 = new RegTLV(1);
      paramArrayOfByte4.setData(paramArrayOfByte5, paramArrayOfByte5.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(5);
      paramArrayOfByte4.setData(arrayOfByte1, arrayOfByte1.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(6);
      paramArrayOfByte4.setData(paramArrayOfByte6, paramArrayOfByte6.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(8);
      paramArrayOfByte4.setByte((byte)1);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(15);
      paramArrayOfByte4.setInt(paramInt2);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(37);
      paramArrayOfByte4.setShort(t.au);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(9);
      paramArrayOfByte4.setByte((byte)1);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(10);
      paramArrayOfByte4.setData(arrayOfByte2, arrayOfByte2.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(11);
      paramArrayOfByte4.setData(paramArrayOfByte3, paramArrayOfByte3.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(13);
      paramArrayOfByte4.setInt((int)paramLong);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
      continue;
      paramArrayOfByte4 = new RegTLV(14);
      paramArrayOfByte4.setData(paramArrayOfByte8, paramArrayOfByte8.length);
      paramArrayOfByte4 = paramArrayOfByte4.getBuf();
    }
    label686:
    paramArrayOfByte4 = paramMap.keySet().iterator();
    while (paramArrayOfByte4.hasNext())
    {
      paramArrayOfByte5 = ((RegTLV)paramMap.get((Integer)paramArrayOfByte4.next())).getBuf();
      localArrayList.add(paramArrayOfByte5);
      i += paramArrayOfByte5.length;
    }
    int j = localArrayList.size();
    paramArrayOfByte4 = new byte[i + 2];
    util.int16_to_buf(paramArrayOfByte4, 0, (byte)j);
    util.LOGI("tlv cnt " + j, "");
    int i = 2;
    paramInt2 = 0;
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
      if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) {
        util.LOGI("msgchk is null or length is 0", "");
      }
      for (paramArrayOfByte2 = h.a.getBytes();; paramArrayOfByte2 = MD5.toMD5Byte(paramArrayOfByte2))
      {
        paramArrayOfByte2 = cryptor.encrypt(paramArrayOfByte3, 0, paramArrayOfByte3.length, paramArrayOfByte2);
        this.d = (paramArrayOfByte1.length + 1 + 2 + paramArrayOfByte2.length);
        paramArrayOfByte3 = new byte[this.d];
        util.int8_to_buf(paramArrayOfByte3, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte3, 1, paramArrayOfByte1.length);
        paramInt1 = paramArrayOfByte1.length + 1;
        util.int16_to_buf(paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
        paramInt1 += 2;
        System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte3, paramInt1, paramArrayOfByte2.length);
        paramInt1 = paramArrayOfByte2.length;
        util.LOGI("encryptedContent length " + paramArrayOfByte2.length, "");
        return a(paramArrayOfByte3);
        util.LOGI("msgchk is " + util.buf_to_string(paramArrayOfByte2, paramArrayOfByte2.length), "");
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
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */