package com.tencent.mobileqq.vip;

import android.os.Bundle;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadTask
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 5;
  public static final int e = 0;
  public static final int f = 2;
  public static final int g = -1;
  public static final int h = -2;
  public static final int i = -3;
  public static final int j = -4;
  public float a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  public File a;
  public String a;
  public AtomicBoolean a;
  public AtomicInteger a;
  public long b;
  public AtomicBoolean b;
  public int k;
  public int l = 3;
  
  public DownloadTask(int paramInt, String paramString, File paramFile)
  {
    this.k = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(2);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public Bundle a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public DownloadListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (this.jdField_a_of_type_Long <= 0L)
    {
      this.jdField_a_of_type_Float = 30.0F;
      return;
    }
    this.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_Long * 100.0F / (float)this.jdField_a_of_type_Long);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  public String toString()
  {
    return "id=" + this.k + "|url=" + this.jdField_a_of_type_JavaLangString + "|dstPath=" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + "|status=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + "|percent=" + this.jdField_a_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadTask
 * JD-Core Version:    0.7.0.1
 */