package com.tencent.mobileqq.transfile;

import KQQFS.VerifyCode;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileMsg
{
  public static final int A = 131078;
  public static final int D = 999;
  public static final int E = 1000;
  public static final int F = 1001;
  public static final int G = 1002;
  public static final int H = 1003;
  public static final int I = 1004;
  public static final int J = 1005;
  public static final int K = 1006;
  public static final int L = 2000;
  public static final int M = 2001;
  public static final int N = 2002;
  public static final int O = 2003;
  public static final int P = 2004;
  public static final int Q = 2005;
  public static final int R = 2006;
  public static final int S = 2007;
  public static final int T = 2008;
  public static final int U = 3000;
  public static final int V = 3001;
  public static final int W = 3002;
  public static final int X = 4001;
  public static final int Y = 5000;
  public static final int Z = 5001;
  public static final String a = "gif";
  static String[] a;
  public static final int aA = 9082;
  public static final int aB = 9009;
  public static final int aC = 4606;
  public static final int aD = 8;
  public static final int aE = 9061;
  public static final int aF = 9060;
  public static final int aG = 9024;
  public static final int aH = 9035;
  public static final int aI = 9053;
  public static final int aJ = 9052;
  public static final int aK = 9054;
  public static final int aL = 9057;
  public static final int aM = 9032;
  public static final int aN = 9001;
  public static final int aO = 90451;
  public static final int aP = 90460;
  public static final int aQ = 0;
  public static final int aR = 1;
  public static final int aS = 2;
  public static final int aU = 0;
  public static final int aV = 1;
  public static final int aW = 2;
  public static final int aa = 7000;
  public static final int ad = 0;
  public static final int ae = 1;
  public static final int af = 2;
  public static final int ag = 3;
  public static final int ah = 4;
  public static final int ai = 5;
  public static final int aj = 9001;
  public static final int ak = 9006;
  public static final int al = 9005;
  public static final int am = 9048;
  public static final int an = 9015;
  public static final int ao = 9011;
  public static final int ap = 9003;
  public static final int aq = 9004;
  public static final int ar = 9008;
  public static final int as = 9023;
  public static final int at = 9040;
  public static final int au = 9041;
  public static final int av = 9042;
  public static final int aw = 9043;
  public static final int ax = 9045;
  public static final int ay = 9080;
  public static final int az = 9081;
  public static final int b = 0;
  static String[] b;
  public static final int c = 1;
  private static String[] c;
  public static final int d = 2;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static final long h = 612345L;
  public static final int i = 3;
  public static final int j = 5;
  public static final int k = 6;
  public static final int l = 7;
  public static final int m = 8;
  public static final int n = 9;
  public static final int o = 16;
  public static final int p = 17;
  public static final int q = 18;
  public static final int r = 65536;
  public static final int s = 65537;
  public static String s = "defaultTag";
  public static final int t = 65538;
  public static final int u = 131072;
  public static String u = "richfile";
  public static final int v = 131073;
  public static final String v = "photo/";
  public static final int w = 131074;
  public static final String w = "ptt/";
  public static final int x = 131075;
  public static final int y = 131076;
  public static final int z = 131077;
  public int B = -1;
  public int C = -1;
  public int a;
  public long a;
  public VerifyCode a;
  public BaseTransProcessor a;
  public FileMsg.StepBaseInfo a;
  public FileMsg.StepTransInfo a;
  public HttpMsg a;
  public File a;
  public InputStream a;
  public OutputStream a;
  public boolean a;
  public byte[] a;
  public int aT = -1;
  private int aX = 0;
  public int ab;
  public int ac;
  public long b;
  public FileMsg.StepBaseInfo b;
  public FileMsg.StepTransInfo b;
  public String b;
  public boolean b;
  public byte[] b;
  public long c;
  public FileMsg.StepBaseInfo c;
  public String c;
  public byte[] c;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g = "";
  public String h;
  public long i;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p = "";
  public String q = "";
  public String r = "";
  public String t = s;
  public String x = "";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "up", "down", "down" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
  }
  
  public FileMsg()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_f_of_type_Long = System.currentTimeMillis();
  }
  
  public FileMsg(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo = new FileMsg.StepBaseInfo();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo = new FileMsg.StepTransInfo();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_i_of_type_Long = 0L;
    try
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      this.m = paramString1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_e_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_e_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.d = paramString2.substring(paramInt).toLowerCase();
          }
        }
        g(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.jdField_i_of_type_JavaLangString = paramString2;
  }
  
  public static String a()
  {
    try
    {
      Thread.sleep(10L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
  }
  
  public InputStream a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_e_of_type_JavaLangString);
      return this.jdField_a_of_type_JavaIoInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
      }
    }
  }
  
  public OutputStream a()
  {
    if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      if (this.jdField_e_of_type_Int == 0) {}
      for (this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_e_of_type_JavaLangString, true);; this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_e_of_type_JavaLangString)) {
        label30:
        return this.jdField_a_of_type_JavaIoOutputStream;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label30;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject = AppConstants.as + paramString1 + "/";
    paramString1 = "";
    String str2;
    String str3;
    String str1;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return "";
    case 2: 
      str2 = (String)localObject + "ptt/";
      str3 = ".amr";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = "手机qq语音_" + a();
        str1 = str2;
        localObject = str3;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("photo", 2, "getTransferFilePath dir: " + str1);
      }
      paramString2 = new File(str1);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      return new File(str1 + paramString1 + (String)localObject).getAbsoluteFile().toString();
      str2 = (String)localObject + "photo/";
      str3 = ".jpg";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = a();
        localObject = str3;
        str1 = str2;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoOutputStream != null) {
        this.jdField_a_of_type_JavaIoOutputStream.close();
      }
      this.jdField_a_of_type_JavaIoOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("8pic", 2, "exception io FileMsg, " + localIOException.toString());
        }
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    FileMsg.StepTransInfo localStepTransInfo;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.b += 1;
      return;
    case 4: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.e += paramInt2;
      return;
    case 3: 
      localStepTransInfo = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo;
      localStepTransInfo.d += paramInt2;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.c = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.k = paramString;
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    InputStream localInputStream = this.jdField_a_of_type_JavaIoInputStream;
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt2];
    if (paramInt1 == 0) {}
    for (;;)
    {
      try
      {
        localInputStream = a();
        if (paramInt1 <= this.aX) {
          continue;
        }
        localInputStream.skip(paramInt1 - this.aX);
        this.aX = paramInt1;
        localInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, paramInt2);
        this.aX += paramInt2;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ArrayOfByte = null;
        continue;
      }
      return this.jdField_a_of_type_ArrayOfByte;
      if (paramInt1 < this.aX)
      {
        localInputStream = a();
        localInputStream.skip(paramInt1);
      }
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    Object localObject = AppConstants.as + paramString1 + "/";
    paramString1 = "";
    String str2;
    String str3;
    String str1;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      return "";
    case 2: 
      str2 = (String)localObject + "ptt/";
      str3 = ".amr";
      localObject = str3;
      str1 = str2;
      if (paramString2 == null)
      {
        paramString1 = "手机qq语音_" + a();
        str1 = str2;
        localObject = str3;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("photo", 2, "getTransferFilePath dir: " + str1);
      }
      paramString2 = new File(str1);
      if (!paramString2.exists()) {
        paramString2.mkdirs();
      }
      paramString1 = new File(str1 + paramString1 + (String)localObject);
      if (!paramString1.exists()) {}
      try
      {
        paramString1.createNewFile();
        paramString1 = paramString1.getAbsoluteFile().toString();
        if (QLog.isColorLevel()) {
          QLog.d("photo", 2, "getTransferFilePath : " + paramString1);
        }
        c(paramString1);
        return paramString1;
        str2 = (String)localObject + "photo/";
        str3 = ".jpg";
        localObject = str3;
        str1 = str2;
        if (paramString2 != null) {
          continue;
        }
        paramString1 = a();
        localObject = str3;
        str1 = str2;
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoInputStream != null) {
        this.jdField_a_of_type_JavaIoInputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(int paramInt)
  {
    this.ac = paramInt;
  }
  
  public void c(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      try
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_JavaIoFile = new File(paramString);
        File localFile = this.jdField_a_of_type_JavaIoFile.getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_JavaIoInputStream == null))
        {
          if (this.jdField_a_of_type_JavaIoFile.exists())
          {
            this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
            if (paramString != null) {
              this.d = paramString.substring(paramString.lastIndexOf(".")).toLowerCase();
            }
          }
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
          return;
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_e_of_type_JavaLangString = null;
        return;
      }
    } while (this.jdField_a_of_type_JavaIoOutputStream != null);
    if (this.jdField_e_of_type_Int == 0)
    {
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString, true);
      return;
    }
    this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString);
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          if (this.jdField_e_of_type_Int == 0)
          {
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString, true);
            return;
          }
        }
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_e_of_type_JavaLangString = null;
        return;
      }
    }
    this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(paramString);
  }
  
  public void e(String paramString)
  {
    this.jdField_i_of_type_JavaLangString = paramString;
  }
  
  public void f(String paramString)
  {
    try
    {
      d(FileUtils.a(paramString).getAbsoluteFile().toString());
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg
 * JD-Core Version:    0.7.0.1
 */