package oicq.wlogin_sdk.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oicq.wlogin_sdk.pb.sec_trans.SecTransInfo;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tlv_type.RegTLV;
import oicq.wlogin_sdk.tlv_type.tlv_t544;
import oicq.wlogin_sdk.tools.util;

public class f
  extends a
{
  public f()
  {
    this.b = 10;
  }
  
  public a a(Map<String, Object> paramMap)
  {
    a locala = new a(null);
    StringBuilder localStringBuilder = new StringBuilder("reg_request_submit_mobile analysisExtraMap");
    if (paramMap == null)
    {
      localStringBuilder.append(" extraMap == null");
      return locala;
    }
    locala.a = ((byte[])paramMap.get("country_english_name"));
    localStringBuilder.append("，stCountryCodeTwo = ");
    if (locala.a == null) {
      localStringBuilder.append("null");
    } else {
      localStringBuilder.append(new String(locala.a));
    }
    locala.b = ((byte[])paramMap.get("captcha_verify_info"));
    localStringBuilder.append("，stCaptchaVerifyInfo = ");
    if (locala.b == null) {
      localStringBuilder.append("null");
    } else {
      localStringBuilder.append(locala.b.length);
    }
    util.LOGI(localStringBuilder.toString(), "");
    return locala;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, long paramLong3, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, byte[] paramArrayOfByte10, Map<Integer, RegTLV> paramMap, Map<String, Object> paramMap1)
  {
    Object localObject1 = Build.VERSION.RELEASE;
    byte[] arrayOfByte1;
    if (paramArrayOfByte7 == null) {
      arrayOfByte1 = new byte[0];
    } else {
      arrayOfByte1 = paramArrayOfByte7;
    }
    byte[] arrayOfByte2;
    if (paramArrayOfByte10 == null) {
      arrayOfByte2 = new byte[0];
    } else {
      arrayOfByte2 = paramArrayOfByte10;
    }
    a locala = a(paramMap1);
    StringBuilder localStringBuilder = new StringBuilder("reg_request_submit_mobile");
    paramMap1 = new int[14];
    Map<String, Object> tmp66_64 = paramMap1;
    tmp66_64[0] = 1;
    Map<String, Object> tmp70_66 = tmp66_64;
    tmp70_66[1] = 2;
    Map<String, Object> tmp74_70 = tmp70_66;
    tmp74_70[2] = 3;
    Map<String, Object> tmp78_74 = tmp74_70;
    tmp78_74[3] = 4;
    Map<String, Object> tmp82_78 = tmp78_74;
    tmp82_78[4] = 13;
    Map<String, Object> tmp87_82 = tmp82_78;
    tmp87_82[5] = 6;
    Map<String, Object> tmp92_87 = tmp87_82;
    tmp92_87[6] = 7;
    Map<String, Object> tmp98_92 = tmp92_87;
    tmp98_92[7] = 18;
    Map<String, Object> tmp104_98 = tmp98_92;
    tmp104_98[8] = 37;
    Map<String, Object> tmp110_104 = tmp104_98;
    tmp110_104[9] = 50;
    Map<String, Object> tmp116_110 = tmp110_104;
    tmp116_110[10] = 52;
    Map<String, Object> tmp122_116 = tmp116_110;
    tmp122_116[11] = 53;
    Map<String, Object> tmp128_122 = tmp122_116;
    tmp128_122[12] = 544;
    Map<String, Object> tmp135_128 = tmp128_122;
    tmp135_128[13] = 29;
    tmp135_128;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    paramArrayOfByte10 = (byte[])localObject1;
    while (j < 14)
    {
      switch (paramMap1[j])
      {
      default: 
        break;
      case 544: 
        paramArrayOfByte7 = new byte[paramArrayOfByte1.length + paramArrayOfByte3.length + arrayOfByte2.length + 6];
        util.int16_to_buf(paramArrayOfByte7, 0, paramArrayOfByte1.length);
        System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte7, 0, paramArrayOfByte1.length);
        k = paramArrayOfByte1.length + 2;
        util.int16_to_buf(paramArrayOfByte7, k, paramArrayOfByte3.length);
        k += 2;
        System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte7, k, paramArrayOfByte3.length);
        k += paramArrayOfByte3.length;
        util.int16_to_buf(paramArrayOfByte7, k, arrayOfByte2.length);
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte7, k + 2, arrayOfByte2.length);
        paramArrayOfByte7 = new tlv_t544().get_tlv_544("", "812_a", paramArrayOfByte7);
        break;
      case 53: 
        if (tmp66_64.b != null)
        {
          paramArrayOfByte7 = new RegTLV(53);
          paramArrayOfByte7.setData(tmp66_64.b, tmp66_64.b.length);
          paramArrayOfByte7 = paramArrayOfByte7.getBuf();
          localObject1 = new StringBuilder("tlv53 len:");
          ((StringBuilder)localObject1).append(tmp66_64.b.length);
          ((StringBuilder)localObject1).append("，");
          ((StringBuilder)localObject1).append(paramArrayOfByte7.length);
          util.LOGI(((StringBuilder)localObject1).toString(), "");
          break label1362;
        }
        util.LOGI("tlv53 byteCaptchaVerifyInfo is null", "");
        break;
      case 52: 
        paramArrayOfByte7 = new RegTLV(52);
        localObject1 = new byte[4];
        util.int32_to_buf((byte[])localObject1, 0, 18);
        paramArrayOfByte7.setData((byte[])localObject1, 4);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        util.LOGI("tlv52 len:4", "");
        break;
      case 50: 
        localObject1 = new StringBuilder(23);
        Object localObject2 = new sec_trans.SecTransInfo();
        ((sec_trans.SecTransInfo)localObject2).str_phone_brand.set(Build.BRAND);
        ((StringBuilder)localObject1).append("brand:");
        ((StringBuilder)localObject1).append(Build.BRAND);
        paramArrayOfByte7 = util.get_device_model();
        ((sec_trans.SecTransInfo)localObject2).str_model_type.set(paramArrayOfByte7);
        ((StringBuilder)localObject1).append(" model:");
        ((StringBuilder)localObject1).append(paramArrayOfByte7);
        PBStringField localPBStringField = ((sec_trans.SecTransInfo)localObject2).str_wifi_mac;
        if (u.aB == null) {
          paramArrayOfByte7 = "";
        } else {
          paramArrayOfByte7 = u.aB;
        }
        localPBStringField.set(paramArrayOfByte7);
        ((StringBuilder)localObject1).append(" regMacAddress:");
        ((StringBuilder)localObject1).append(u.aB);
        localPBStringField = ((sec_trans.SecTransInfo)localObject2).str_gps_location;
        if (u.aE == null) {
          paramArrayOfByte7 = "";
        } else {
          paramArrayOfByte7 = u.aE;
        }
        localPBStringField.set(paramArrayOfByte7);
        ((StringBuilder)localObject1).append(" regLocation:");
        ((StringBuilder)localObject1).append(u.aE);
        localPBStringField = ((sec_trans.SecTransInfo)localObject2).str_os_language;
        if (u.aC == null) {
          paramArrayOfByte7 = "";
        } else {
          paramArrayOfByte7 = u.aC;
        }
        localPBStringField.set(paramArrayOfByte7);
        ((StringBuilder)localObject1).append(" regOSLanguage:");
        ((StringBuilder)localObject1).append(u.aC);
        ((sec_trans.SecTransInfo)localObject2).uint32_qq_language.set(u.aD);
        ((StringBuilder)localObject1).append(" regQQLanguage:");
        ((StringBuilder)localObject1).append(u.aD);
        util.LOGI(((StringBuilder)localObject1).toString(), "");
        paramArrayOfByte7 = ((sec_trans.SecTransInfo)localObject2).toByteArray();
        localObject1 = new RegTLV(50);
        ((RegTLV)localObject1).setData(paramArrayOfByte7, paramArrayOfByte7.length);
        localObject2 = new StringBuilder("tlv50 len:");
        ((StringBuilder)localObject2).append(paramArrayOfByte7.length);
        util.LOGI(((StringBuilder)localObject2).toString(), "");
        paramArrayOfByte7 = ((RegTLV)localObject1).getBuf();
        break;
      case 37: 
        paramArrayOfByte7 = new RegTLV(37);
        paramArrayOfByte7.setShort(u.aA);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break;
      case 29: 
        if (tmp66_64.a != null)
        {
          paramArrayOfByte7 = new RegTLV(29);
          paramArrayOfByte7.setData(tmp66_64.a, tmp66_64.a.length);
          paramArrayOfByte7 = paramArrayOfByte7.getBuf();
          localObject1 = new StringBuilder("tlv29 len:");
          ((StringBuilder)localObject1).append(tmp66_64.a.length);
          util.LOGI(((StringBuilder)localObject1).toString(), "");
          break label1362;
        }
        util.LOGI("tlv29 byteCountryCode is null", "");
        break;
      case 18: 
        paramArrayOfByte7 = new RegTLV(18);
        paramArrayOfByte7.setData(paramArrayOfByte3, paramArrayOfByte3.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break;
      case 13: 
        paramArrayOfByte7 = new RegTLV(13);
        paramArrayOfByte7.setInt((int)paramLong2);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break;
      case 7: 
        paramArrayOfByte7 = new RegTLV(7);
        int m = u.ak | 0x0;
        k = m;
        if (true == u.aj) {
          k = m | 0x2;
        }
        k = k | 0x8 | 0x10;
        paramArrayOfByte7.setInt(k);
        util.LOGI("reg_request_submit_mobile tlv7 ".concat(String.valueOf(k)), "");
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
        break;
      case 6: 
        paramArrayOfByte7 = new RegTLV(6);
        localObject1 = new byte[arrayOfByte2.length + 3];
        if (arrayOfByte2.length == 0) {
          k = 1;
        } else {
          k = 2;
        }
        util.int8_to_buf((byte[])localObject1, 0, k);
        util.int16_to_buf((byte[])localObject1, 1, arrayOfByte2.length);
        System.arraycopy(arrayOfByte2, 0, localObject1, 3, arrayOfByte2.length);
        paramArrayOfByte7.setData((byte[])localObject1, localObject1.length);
        paramArrayOfByte7 = paramArrayOfByte7.getBuf();
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
      paramArrayOfByte7 = new byte[0];
      label1362:
      k = i;
      if (paramArrayOfByte7.length > 4)
      {
        k = i + paramArrayOfByte7.length;
        localArrayList.add(paramArrayOfByte7);
      }
      j += 1;
      i = k;
    }
    paramArrayOfByte7 = paramMap.keySet().iterator();
    while (paramArrayOfByte7.hasNext())
    {
      paramArrayOfByte8 = (Integer)paramArrayOfByte7.next();
      paramArrayOfByte9 = ((RegTLV)paramMap.get(paramArrayOfByte8)).getBuf();
      localArrayList.add(paramArrayOfByte9);
      i += paramArrayOfByte9.length;
      localStringBuilder.append(",key=");
      localStringBuilder.append(paramArrayOfByte8);
      localStringBuilder.append(",value=");
      localStringBuilder.append(paramArrayOfByte9.length);
    }
    util.LOGI(localStringBuilder.toString(), "");
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
      paramArrayOfByte9.writeByte(paramArrayOfByte10.length());
      paramArrayOfByte9.write(paramArrayOfByte10.getBytes());
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
  
  static class a
  {
    byte[] a;
    byte[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */