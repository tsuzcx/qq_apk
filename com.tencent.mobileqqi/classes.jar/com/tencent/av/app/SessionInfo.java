package com.tencent.av.app;

public class SessionInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public long[] a;
  public String[] a;
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
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  public int m;
  public boolean m;
  public int n;
  public boolean n;
  public boolean o = false;
  public boolean p = false;
  public boolean q = false;
  public boolean r = false;
  public boolean s = false;
  public boolean t = false;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  
  public SessionInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_g_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_h_of_type_JavaLangString = "from_internal";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_a_of_type_ArrayOfJavaLangString = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_n_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1 == true) {
      if (paramBoolean2 == true)
      {
        this.jdField_f_of_type_Boolean = true;
        if (this.jdField_a_of_type_Int != 1) {
          break label50;
        }
        this.jdField_a_of_type_Int = 2;
        label28:
        if ((this.jdField_a_of_type_Int != 4) || (paramBoolean2 != true)) {}
      }
    }
    label50:
    do
    {
      return;
      this.jdField_e_of_type_Boolean = true;
      break;
      if (this.jdField_a_of_type_Int != 3) {
        break label28;
      }
      this.jdField_a_of_type_Int = 4;
      break label28;
      if (paramBoolean2 == true) {
        this.jdField_f_of_type_Boolean = false;
      }
      while (((this.jdField_a_of_type_Int != 4) || (paramBoolean2 != true)) || ((this.jdField_a_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)))
      {
        this.jdField_a_of_type_Int = 1;
        return;
        this.jdField_e_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_Int != 4) || (this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean));
    this.jdField_a_of_type_Int = 3;
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Int == 0;
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return (this.jdField_e_of_type_Int == 2) || (this.jdField_e_of_type_Int == 7);
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Int == 3;
  }
  
  public boolean e()
  {
    return this.jdField_e_of_type_Int == 4;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Int == 5;
  }
  
  public boolean g()
  {
    return this.jdField_e_of_type_Int == 6;
  }
  
  public boolean h()
  {
    return "DEVICE_EARPHONE".equals(this.jdField_i_of_type_JavaLangString);
  }
  
  public boolean i()
  {
    return "DEVICE_SPEAKERPHONE".equals(this.jdField_i_of_type_JavaLangString);
  }
  
  public boolean j()
  {
    return "DEVICE_WIREDHEADSET".equals(this.jdField_i_of_type_JavaLangString);
  }
  
  public boolean k()
  {
    return "DEVICE_BLUETOOTHHEADSET".equals(this.jdField_i_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.app.SessionInfo
 * JD-Core Version:    0.7.0.1
 */