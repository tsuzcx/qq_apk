import java.util.LinkedList;
import java.util.Random;

public class xsv
{
  private int jdField_a_of_type_Int;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  
  public xsv(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    if (paramInt2 > 0)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[paramInt2];
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt1] = -1;
        paramInt1 += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfInt = null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)
    {
      i = 0;
      if (i < this.b)
      {
        if (a(i)) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_JavaUtilLinkedList.add(Integer.valueOf(i));
        }
      }
    }
    int i = this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_JavaUtilLinkedList.size()) % this.b;
    int j = ((Integer)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).intValue();
    this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
    a(j);
    return j;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = paramInt;
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_Int %= this.jdField_a_of_type_ArrayOfInt.length;
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length == 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == paramInt) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsv
 * JD-Core Version:    0.7.0.1
 */