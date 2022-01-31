import java.util.ArrayList;
import java.util.List;

public class uye
{
  int jdField_a_of_type_Int = 2;
  public List a;
  boolean jdField_a_of_type_Boolean = false;
  
  public uye()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_JavaUtilList.clear();
    uyb localuyb = new uyb();
    localuyb.a((uyb)localArrayList.get(localArrayList.size() - 1));
    this.jdField_a_of_type_JavaUtilList.add(localuyb);
    this.jdField_a_of_type_Boolean = true;
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    uyb localuyb = (uyb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localuyb.a.a(localuyb.b);
    localuyb.c.a(localuyb.d);
    localuyb.b.a(localuyb.d);
    this.jdField_a_of_type_JavaUtilList.add(localuyb);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    uyb localuyb = new uyb();
    localuyb.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localuyb);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    uyb localuyb1 = new uyb();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      a(paramFloat1, paramFloat2, paramFloat3, paramLong);
      return false;
    }
    uyb localuyb2 = (uyb)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
    localuyb1.a.a(localuyb2.b);
    localuyb1.c.a(localuyb2.d);
    localuyb1.b.a((localuyb1.c.jdField_a_of_type_Float + paramFloat1) / 2.0F, (localuyb1.c.b + paramFloat2) / 2.0F, (localuyb1.c.c + paramFloat3) / 2.0F, (localuyb1.c.jdField_a_of_type_Long + paramLong) / 2L);
    localuyb1.d.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    this.jdField_a_of_type_JavaUtilList.add(localuyb1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return this.jdField_a_of_type_JavaUtilList.size() > this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uye
 * JD-Core Version:    0.7.0.1
 */