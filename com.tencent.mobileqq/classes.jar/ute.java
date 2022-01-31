import java.util.ArrayList;
import java.util.List;

public class ute
{
  int jdField_a_of_type_Int = 2;
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public ute()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    utb localutb = new utb();
    localutb.a((utb)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localutb);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    utb localutb = (utb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localutb.a.a(localutb.b);
    localutb.c.a(localutb.d);
    localutb.b.a(localutb.d);
    this.jdField_a_of_type_JavaUtilList.add(localutb);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    utb localutb = new utb();
    localutb.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localutb);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    utb localutb1 = new utb();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    utb localutb2 = (utb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localutb1.a.a(localutb2.b);
    localutb1.c.a(localutb2.d);
    localutb1.b.a((localutb1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localutb1.c.b + paramFloat2) / 2.0F, (localutb1.c.c + paramFloat3) / 2.0F, (localutb1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localutb1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localutb1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ute
 * JD-Core Version:    0.7.0.1
 */