package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloaderAssinfo
{
  public static String b;
  protected int a;
  protected Object a;
  protected int b;
  public long b;
  protected Object b;
  protected int c;
  public final long c;
  protected Object c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  static
  {
    jdField_b_of_type_JavaLangString = "UniformDownloaderAssinfo<FileAssistant>";
  }
  
  public UniformDownloaderAssinfo(long paramLong)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    if (a()) {
      return 0;
    }
    if ((paramString == null) || (paramBundle == null)) {
      try
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. init param error");
        return -1;
      }
      finally {}
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    this.e = paramBundle.getString("_PARAM_FILEPATH");
    this.f = paramBundle.getString("_PARAM_TMP_FILEPATH");
    this.d = paramBundle.getString("_PARAM_FILENAME");
    this.jdField_b_of_type_Long = paramBundle.getLong("_PARAM_FILESIZE");
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] init. ST:" + e() + " PGR:" + h());
    c(1);
    return 0;
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  protected boolean a()
  {
    return e() >= 1;
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public void c(int paramInt)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] setStatus. " + this.jdField_c_of_type_Int + "->" + paramInt);
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public int e()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
  }
  
  public int g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public int h()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloaderAssinfo
 * JD-Core Version:    0.7.0.1
 */