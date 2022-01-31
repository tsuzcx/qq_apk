package com.tencent.av;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class SharpReport_OffLine
{
  private static final int jdField_a_of_type_Int = 0;
  private static SharpReport_OffLine jdField_a_of_type_ComTencentAvSharpReport_OffLine = null;
  private static final String jdField_a_of_type_JavaLangString = "617";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "UNKNOWN", "WIFI", "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET" };
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "Data";
  private static final int c = 2;
  private UniPacket jdField_a_of_type_ComQqJceWupUniPacket = null;
  private SharpReport_OffLine.ReportHeader jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader = null;
  private strupbuff jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff = null;
  private Map jdField_a_of_type_JavaUtilMap = null;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int d = 0;
  
  private int a()
  {
    Object localObject = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    if (localObject == null) {
      return 0;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return 0;
    }
    if (((NetworkInfo)localObject).getType() == 1) {
      return 1;
    }
    localObject = ((NetworkInfo)localObject).getExtraInfo();
    if (localObject == null) {
      return 0;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_c_of_type_JavaLangString)) {
      return 3;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.d)) {
      return 2;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_a_of_type_JavaLangString)) {
      return 7;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.jdField_b_of_type_JavaLangString)) {
      return 6;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.e)) {
      return 5;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.f)) {
      return 4;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.g)) {
      return 9;
    }
    if (((String)localObject).equalsIgnoreCase(PkgTools.h)) {
      return 8;
    }
    return 0;
  }
  
  private int a(int paramInt)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return i;
                b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_JavaLangString.length());
                j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_JavaLangString);
                i = j;
              } while (j < 0);
              b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_JavaLangString.length());
              j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_JavaLangString);
              i = j;
            } while (j < 0);
            b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_JavaLangString.length());
            j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_JavaLangString);
            i = j;
          } while (j < 0);
          b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f.length());
          j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f);
          i = j;
        } while (j < 0);
        b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.d.length());
        j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.d);
        i = j;
      } while (j < 0);
      b(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.e.length());
      j = a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.e);
      i = j;
    } while (j < 0);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Long);
    a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Int);
    a(paramInt);
    return 0;
  }
  
  private int a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_ComQqJceWupUniPacket == null) || (this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff == null)) {
      return 0;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.put("617", new ArrayList());
    ((ArrayList)this.jdField_a_of_type_JavaUtilMap.get("617")).add(paramArrayOfByte);
    this.jdField_a_of_type_ComQqJceWupUniPacket.put("Data", this.jdField_a_of_type_ComTencentAvVideoJceQQServiceStrupbuff);
    paramArrayOfByte = this.jdField_a_of_type_ComQqJceWupUniPacket.encode();
    ToServiceMsg localToServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setNeedRemindSlowNetwork(false);
    try
    {
      int i = MsfServiceSdk.get().sendMsg(localToServiceMsg);
      if (i >= 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return 0;
  }
  
  private int a(String paramString)
  {
    int k = 0;
    try
    {
      paramString = paramString.getBytes("utf-8");
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramString.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte[this.d] = paramString[i];
        this.d += 1;
        i += 1;
      }
      return j;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      j = -1;
    }
  }
  
  public static SharpReport_OffLine a()
  {
    if (jdField_a_of_type_ComTencentAvSharpReport_OffLine == null) {
      jdField_a_of_type_ComTencentAvSharpReport_OffLine = new SharpReport_OffLine();
    }
    return jdField_a_of_type_ComTencentAvSharpReport_OffLine;
  }
  
  private String a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  
  private void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.d] = i;
    this.d += 1;
  }
  
  private void a(long paramLong)
  {
    int i = (byte)(int)(paramLong >> 56 & 0xFF);
    int j = (byte)(int)(paramLong >> 48 & 0xFF);
    int k = (byte)(int)(paramLong >> 40 & 0xFF);
    int m = (byte)(int)(paramLong >> 32 & 0xFF);
    int n = (byte)(int)(paramLong >> 24 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 16 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 8 & 0xFF);
    int i3 = (byte)(int)(paramLong & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.d] = i;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 1)] = j;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 2)] = k;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 3)] = m;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 4)] = n;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 5)] = i1;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 6)] = i2;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 7)] = i3;
    this.d += 8;
  }
  
  private void b(int paramInt)
  {
    int i = (byte)(paramInt >> 8 & 0xFF);
    int j = (byte)(paramInt & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.d] = i;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 1)] = j;
    this.d += 2;
  }
  
  private void c(int paramInt)
  {
    int i = (byte)(paramInt >> 24 & 0xFF);
    int j = (byte)(paramInt >> 16 & 0xFF);
    int k = (byte)(paramInt >> 8 & 0xFF);
    int m = (byte)(paramInt & 0xFF);
    this.jdField_a_of_type_ArrayOfByte[this.d] = i;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 1)] = j;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 2)] = k;
    this.jdField_a_of_type_ArrayOfByte[(this.d + 3)] = m;
    this.d += 4;
  }
  
  public int a(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader == null) {
      paramInt2 = -1;
    }
    do
    {
      return paramInt2;
      int j = a();
      this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.e = jdField_a_of_type_ArrayOfJavaLangString[j];
      this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.d = a();
      this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Int = paramInt2;
      if (paramLong != 0L) {
        this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Long = paramLong;
      }
      this.d = 0;
      if (a(paramInt1) < 0) {
        return -1;
      }
      if (this.d <= 0) {
        break;
      }
      byte[] arrayOfByte = new byte[this.d];
      paramInt2 = 0;
      while (paramInt2 < this.d)
      {
        arrayOfByte[paramInt2] = this.jdField_a_of_type_ArrayOfByte[paramInt2];
        paramInt2 += 1;
      }
      a(this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Long, arrayOfByte);
      this.d = 0;
      paramInt2 = i;
    } while (!QLog.isColorLevel());
    QLog.d("SharpReport_Node", 2, "report_node is" + paramInt1);
    return 0;
    return -1;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_b_of_type_Long = paramLong3;
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.jdField_c_of_type_JavaLangString = String.valueOf(AppSetting.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentAvSharpReport_OffLine$ReportHeader.f = AppSetting.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.SharpReport_OffLine
 * JD-Core Version:    0.7.0.1
 */