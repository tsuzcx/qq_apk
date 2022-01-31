import java.util.ArrayList;
import java.util.List;

public class uqc
{
  int jdField_a_of_type_Int = 2;
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public uqc()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    upz localupz = new upz();
    localupz.a((upz)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localupz);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    upz localupz = (upz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localupz.a.a(localupz.b);
    localupz.c.a(localupz.d);
    localupz.b.a(localupz.d);
    this.jdField_a_of_type_JavaUtilList.add(localupz);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    upz localupz = new upz();
    localupz.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localupz);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    upz localupz1 = new upz();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    upz localupz2 = (upz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localupz1.a.a(localupz2.b);
    localupz1.c.a(localupz2.d);
    localupz1.b.a((localupz1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localupz1.c.b + paramFloat2) / 2.0F, (localupz1.c.c + paramFloat3) / 2.0F, (localupz1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localupz1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localupz1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqc
 * JD-Core Version:    0.7.0.1
 */