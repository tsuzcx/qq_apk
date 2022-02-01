import java.util.ArrayList;
import java.util.Collections;

public class wve
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public ArrayList<Integer> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  
  public wve()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public wve(wve paramwve)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramwve.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaLangString = paramwve.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramwve.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Long = paramwve.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaLangString = paramwve.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramwve.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramwve.jdField_b_of_type_Int;
    this.jdField_b_of_type_Long = paramwve.jdField_b_of_type_Long;
    this.jdField_c_of_type_JavaLangString = paramwve.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_Long = paramwve.jdField_c_of_type_Long;
    this.d = paramwve.d;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 3) {
      return ((Integer)Collections.max(this.jdField_a_of_type_JavaUtilArrayList)).intValue();
    }
    return -1L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.d = null;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 3) {
      return ((Integer)Collections.min(this.jdField_a_of_type_JavaUtilArrayList)).intValue();
    }
    return -1L;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3) {
      return -1L;
    }
    int k = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), 10);
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue();
      i += 1;
    }
    return j / k;
  }
  
  public String toString()
  {
    return " " + this.jdField_a_of_type_JavaLangString + " " + this.jdField_a_of_type_Long + " " + this.jdField_a_of_type_Int + " " + this.jdField_b_of_type_Int + " " + this.jdField_b_of_type_Long + " " + this.jdField_a_of_type_Boolean + " " + c() + " " + b() + " " + a() + " " + this.jdField_b_of_type_JavaLangString + " " + this.jdField_c_of_type_JavaLangString + " " + this.jdField_c_of_type_Long + " " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wve
 * JD-Core Version:    0.7.0.1
 */