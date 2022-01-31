package com.tencent.mobileqq.troop.data;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;

public final class TroopFileInfo
{
  public static final long e = 3000L;
  public static final long f = 300000L;
  public int a;
  public long a;
  public final String a;
  public UUID a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public transient String g;
  public int h;
  public transient String h;
  public int i;
  public String i;
  
  public TroopFileInfo()
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_g_of_type_Int = 7;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 7;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public TroopFileInfo(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    this.jdField_a_of_type_JavaLangString = "TroopFileInfo";
    this.jdField_g_of_type_Int = 7;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 7;
    a(paramFileInfo);
  }
  
  public static String a(int paramInt)
  {
    long l1 = 0x7FFFFFFF & paramInt;
    long l2 = paramInt >> 31 & 0x1;
    return (l1 | l2 << 31) + "";
  }
  
  private String a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int n = 1;
    int m = 0;
    if ((paramBoolean) || (this.i == null)) {}
    label75:
    int k;
    for (int j = 1;; j = 1)
    {
      if (j != 0)
      {
        this.i = ContactUtils.a(paramQQAppInterface, c(), paramLong + "", 1, 0);
        if (this.i.length() > 10) {
          break label264;
        }
        j = n;
        if (j == 0) {
          break label279;
        }
        k = 0;
        label83:
        if (k >= this.i.length()) {
          break label279;
        }
        if (Character.isDigit(this.i.charAt(k))) {
          break label270;
        }
        j = m;
        label114:
        if ((TextUtils.isEmpty(this.i)) || (j != 0)) {
          this.i = this.jdField_d_of_type_JavaLangString;
        }
        this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
      }
      return this.i;
      if (SystemClock.uptimeMillis() - this.jdField_d_of_type_Long <= 300000L) {
        break;
      }
    }
    if (this.i.length() <= 10)
    {
      j = 1;
      label185:
      if (j == 0) {
        break label288;
      }
      k = 0;
      label193:
      if (k >= this.i.length()) {
        break label288;
      }
      if (Character.isDigit(this.i.charAt(k))) {
        break label255;
      }
      j = 0;
    }
    label264:
    label270:
    label279:
    label288:
    for (;;)
    {
      if ((j != 0) && (SystemClock.uptimeMillis() - this.jdField_d_of_type_Long > 3000L))
      {
        j = 1;
        break;
        j = 0;
        break label185;
        label255:
        k += 1;
        break label193;
        j = 0;
        break label75;
        k += 1;
        break label83;
        break label114;
      }
      j = 0;
      break;
    }
  }
  
  public String a()
  {
    return TroopFileUtils.a(this.jdField_a_of_type_Long);
  }
  
  public String a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface, paramLong, false);
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_g_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    this.jdField_h_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    this.jdField_g_of_type_Int = paramTroopFileStatusInfo.jdField_b_of_type_Int;
    this.jdField_f_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_Long = paramTroopFileStatusInfo.jdField_c_of_type_Long;
    this.jdField_h_of_type_Int = paramTroopFileStatusInfo.jdField_c_of_type_Int;
    this.jdField_c_of_type_Boolean = paramTroopFileStatusInfo.jdField_a_of_type_Boolean;
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = paramTroopFileStatusInfo.jdField_d_of_type_Int;
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = paramTroopFileStatusInfo.jdField_b_of_type_Long;
    }
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
    }
    if ((this.jdField_a_of_type_Int == 0) || (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.jdField_b_of_type_Int))) {
      this.jdField_a_of_type_Int = paramTroopFileStatusInfo.jdField_e_of_type_Int;
    }
    if ((this.jdField_b_of_type_Int == 0) && (TroopFileInfo.FileStatus.a(paramTroopFileStatusInfo.jdField_b_of_type_Int))) {}
    try
    {
      this.jdField_b_of_type_Int = ((int)Long.parseLong(paramQQAppInterface.a()));
      return;
    }
    catch (NumberFormatException paramTroopFileStatusInfo)
    {
      QLog.e("TroopFileInfo", 4, "updateItemStatus NumberFormatException");
    }
  }
  
  public void a(cmd0x383.ApplyGetFileListRspBody.FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramFileInfo.str_file_path.get();
    this.jdField_c_of_type_JavaLangString = paramFileInfo.str_file_name.get();
    this.jdField_a_of_type_Long = paramFileInfo.uint64_file_size.get();
    this.jdField_a_of_type_Int = paramFileInfo.uint32_bus_id.get();
    this.jdField_b_of_type_Int = paramFileInfo.uint32_upload_uin.get();
    this.jdField_b_of_type_Long = paramFileInfo.uint64_uploaded_size.get();
    this.jdField_c_of_type_Int = paramFileInfo.uint32_upload_time.get();
    this.jdField_d_of_type_Int = paramFileInfo.uint32_dead_time.get();
    this.jdField_e_of_type_Int = paramFileInfo.uint32_modify_time.get();
    this.jdField_f_of_type_Int = paramFileInfo.uint32_download_times.get();
    this.jdField_d_of_type_JavaLangString = paramFileInfo.str_uploader_name.get();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((paramQQAppInterface.a().equals(c())) || (TroopFileUtils.a(paramQQAppInterface, paramLong))) {}
    for (boolean bool = true;; bool = false) {
      switch (this.jdField_g_of_type_Int)
      {
      case 4: 
      case 5: 
      case 8: 
      case 12: 
      default: 
        bool = false;
      case 7: 
        return bool;
      }
    }
    return true;
  }
  
  public String b()
  {
    return TroopFileUtils.a(this.jdField_c_of_type_Long) + "/" + TroopFileUtils.a(this.jdField_a_of_type_Long);
  }
  
  public String b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return a(paramQQAppInterface, paramLong, true);
  }
  
  public String c()
  {
    return a(this.jdField_b_of_type_Int);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (!(paramObject instanceof TroopFileInfo))) {
      return false;
    }
    paramObject = (TroopFileInfo)paramObject;
    return this.jdField_a_of_type_JavaUtilUUID.equals(paramObject.jdField_a_of_type_JavaUtilUUID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileInfo
 * JD-Core Version:    0.7.0.1
 */