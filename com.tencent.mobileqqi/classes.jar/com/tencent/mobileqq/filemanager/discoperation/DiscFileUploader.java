package com.tencent.mobileqq.filemanager.discoperation;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DiscFileUploader
  implements IFileHttpUploderSink
{
  long jdField_a_of_type_Long;
  DiscFileOperator jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileOperator = null;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public long a(NetResp paramNetResp, FileReportData paramFileReportData)
  {
    paramNetResp = new ByteArrayInputStream(paramNetResp.a);
    DataInputStream localDataInputStream = new DataInputStream(paramNetResp);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0)
      {
        paramFileReportData.jdField_a_of_type_Long = 9001L;
        paramFileReportData.c = "httpServer retCode!=0";
        a(paramFileReportData);
      }
    }
    catch (IOException paramFileReportData)
    {
      int i;
      int j;
      long l;
      paramFileReportData.printStackTrace();
    }
    finally
    {
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return -1L;
        paramFileReportData = finally;
        try
        {
          paramNetResp.close();
          localDataInputStream.close();
          throw paramFileReportData;
        }
        catch (Exception paramNetResp)
        {
          break label234;
        }
      }
      catch (Exception paramNetResp)
      {
        break label220;
      }
    }
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      j = localDataInputStream.readInt();
      l = i;
      l = j << 32 | l & 0xFFFFFFF;
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return l;
      }
      catch (Exception paramNetResp)
      {
        return l;
      }
    }
    if (i == 1)
    {
      paramFileReportData.jdField_a_of_type_Long = 0L;
      paramFileReportData.g = (paramFileReportData.f + 1L);
      b(paramFileReportData);
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return 0L;
      }
      catch (Exception paramNetResp)
      {
        return 0L;
      }
    }
    paramFileReportData.jdField_a_of_type_Long = 9001L;
    paramFileReportData.c = "httpServer flag!=0 flag!=1";
    a(paramFileReportData);
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp)
    {
      return 0L;
    }
    label220:
    label234:
    return 0L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileOperator.a(paramLong1, paramLong2);
  }
  
  public void a(FileReportData paramFileReportData)
  {
    paramFileReportData.c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileOperator.a(null);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, DiscFileOperator paramDiscFileOperator)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileOperator = paramDiscFileOperator;
  }
  
  public void a(boolean paramBoolean, FileReportData paramFileReportData) {}
  
  public byte[] a(byte[] paramArrayOfByte, long paramLong, FileReportData paramFileReportData)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.b == null) || (this.jdField_a_of_type_JavaLangString.length() == 0) || (this.b.length() == 0))
    {
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException();
      }
      paramFileReportData.jdField_a_of_type_Long = 9005L;
      a(paramFileReportData);
      return null;
    }
    byte[] arrayOfByte1 = HexUtil.hexStr2Bytes(this.b);
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(this.jdField_a_of_type_JavaLangString);
    int i = arrayOfByte2.length + 2 + 2 + arrayOfByte1.length + 20 + paramArrayOfByte.length;
    localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(arrayOfByte2.length);
      localDataOutputStream.write(arrayOfByte2);
      localDataOutputStream.writeShort(arrayOfByte1.length);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt((int)(this.jdField_a_of_type_Long & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.jdField_a_of_type_Long >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Exception paramFileReportData)
      {
        return paramArrayOfByte;
      }
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception paramFileReportData)
      {
        break label319;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramFileReportData.jdField_a_of_type_Long = 9003L;
      paramFileReportData.c = FileManagerUtil.a();
      a(paramFileReportData);
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally {}
  }
  
  public void b(FileReportData paramFileReportData)
  {
    paramFileReportData.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileOperator.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.DiscFileUploader
 * JD-Core Version:    0.7.0.1
 */