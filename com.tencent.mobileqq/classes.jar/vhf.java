import java.util.ArrayList;

public class vhf
{
  public int a;
  public ArrayList<vgr> a;
  public ArrayList<Integer> b;
  
  public vhf(ArrayList<vgr> paramArrayList, ArrayList<Integer> paramArrayList1, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramArrayList.clone());
    this.b = ((ArrayList)paramArrayList1.clone());
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public vhf a()
  {
    return new vhf(this.jdField_a_of_type_JavaUtilArrayList, this.b, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhf
 * JD-Core Version:    0.7.0.1
 */