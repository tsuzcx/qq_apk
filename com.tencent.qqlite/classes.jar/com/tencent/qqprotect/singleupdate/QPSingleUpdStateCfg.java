package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class QPSingleUpdStateCfg
{
  public int a;
  public long a;
  String a;
  public int b;
  public long b;
  public long c = 0L;
  
  public QPSingleUpdStateCfg()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 0;
    Object localObject = BaseApplication.getContext();
    this.jdField_a_of_type_JavaLangString = (((Context)localObject).getFilesDir().getAbsolutePath() + "/TxSingleUpd/UpdState.cfg");
    localObject = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      try
      {
        ((File)localObject).createNewFile();
        c();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    d();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Int -= 1;
    }
    c();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Long == 0L) {}
    while ((new Date().getTime() - this.jdField_a_of_type_Long) / 86400000L != 0L) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 3;
    c();
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_Long == 0L) {}
    while ((new Date().getTime() - this.jdField_a_of_type_Long) / 86400000L != 0L) {
      return false;
    }
    return true;
  }
  
  public void c()
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
      DataOutputStream localDataOutputStream = new DataOutputStream(localFileOutputStream);
      localDataOutputStream.writeLong(this.jdField_a_of_type_Long);
      localDataOutputStream.writeLong(this.jdField_b_of_type_Long);
      localDataOutputStream.writeLong(this.c);
      localDataOutputStream.writeInt(this.jdField_a_of_type_Int);
      localDataOutputStream.writeInt(this.jdField_b_of_type_Int);
      localDataOutputStream.close();
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int != 0;
  }
  
  public void d()
  {
    try
    {
      if (!new File(this.jdField_a_of_type_JavaLangString).exists())
      {
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.c = 0L;
        this.jdField_a_of_type_Int = 3;
        this.jdField_b_of_type_Int = 0;
        c();
      }
      FileInputStream localFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
      DataInputStream localDataInputStream = new DataInputStream(localFileInputStream);
      this.jdField_a_of_type_Long = localDataInputStream.readLong();
      this.jdField_b_of_type_Long = localDataInputStream.readLong();
      this.c = localDataInputStream.readLong();
      this.jdField_a_of_type_Int = localDataInputStream.readInt();
      this.jdField_b_of_type_Int = localDataInputStream.readInt();
      localDataInputStream.close();
      localFileInputStream.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e()
  {
    this.jdField_b_of_type_Long = new Date().getTime();
    this.c = 0L;
  }
  
  public void f()
  {
    this.c = new Date().getTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdStateCfg
 * JD-Core Version:    0.7.0.1
 */