package com.tencent.mobileqq.antiphing;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import com.tencent.qphone.base.util.QLog;
import eyw;
import eyx;
import eyy;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class AntiphishingUrlConfig
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private Handler jdField_a_of_type_AndroidOsHandler = new eyw(this);
  private String jdField_a_of_type_JavaLangString = "antiphishingConfig";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  private int c = 1;
  private int d = 2;
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  private String a()
  {
    new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Tencent/com/tencent/mobileqq/antiphishingconfig.xml").toString();
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int a()
  {
    if ((this.jdField_b_of_type_Int == 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) && (!this.jdField_a_of_type_Boolean)) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, Context paramContext)
  {
    if (paramInt <= this.jdField_a_of_type_Int)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "nNewVersion:" + paramInt + "nLocalConfigVer:" + this.jdField_a_of_type_Int + "Do not Need Update!");
      return;
    }
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Int == paramInt) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 7200000L))
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "Config Updata, Frequence limited!");
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = paramInt;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "filehash:" + paramString2 + "downloadurl:" + paramString1);
    new eyx(this, paramContext, paramString1, paramString2).start();
  }
  
  public void a(String paramString, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public boolean a()
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Parase Config!");
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    localObject = new File((String)localObject);
    eyy localeyy = new eyy();
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream((File)localObject), "UTF-8")), localeyy);
      this.jdField_a_of_type_Int = localeyy.a();
      this.jdField_a_of_type_JavaUtilArrayList = localeyy.a();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig
 * JD-Core Version:    0.7.0.1
 */