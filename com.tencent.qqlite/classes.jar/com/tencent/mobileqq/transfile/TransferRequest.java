package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.UpCallBack;
import java.io.OutputStream;

public class TransferRequest
{
  public int a;
  public long a;
  public URLDrawableHandler a;
  public MessageRecord a;
  public DownCallBack a;
  public UpCallBack a;
  public TransferResult a;
  public OutputStream a;
  public Object a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f = true;
  public String g;
  public String h;
  public String i;
  private String j = null;
  
  public TransferRequest()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 5;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public String a()
  {
    if (this.j == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("_");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      return localStringBuilder.toString();
    }
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsIp:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mUinType:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(",mFileType:" + this.jdField_b_of_type_Int);
    localStringBuilder.append(",mUniseq:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(",mSelfUin:" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mPeerUin:" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",mSecondId:" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(",mServerPath:" + this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(",mLocalPath:" + this.h);
    localStringBuilder.append(",mBusiType:" + this.jdField_d_of_type_Int);
    localStringBuilder.append(",mMd5:{" + this.jdField_e_of_type_JavaLangString + "}");
    localStringBuilder.append(",mGroupFileID:" + this.jdField_c_of_type_Long);
    localStringBuilder.append(",mExtraObj:{" + this.jdField_a_of_type_JavaLangObject + "}");
    localStringBuilder.append(",mPrioty:" + this.jdField_e_of_type_Int);
    localStringBuilder.append(",mLogicCallBack：" + this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest
 * JD-Core Version:    0.7.0.1
 */