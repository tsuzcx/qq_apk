import android.util.SparseArray;

public class zdl
{
  public int a;
  public SparseArray<zdm> a;
  public String a;
  public boolean a;
  public int b = 4;
  
  public zdl(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public zdm a(int paramInt)
  {
    zdm localzdm2 = (zdm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    zdm localzdm1 = localzdm2;
    if (localzdm2 == null)
    {
      if (paramInt != 1) {
        break label40;
      }
      localzdm1 = new zdm(85, 5, 0.7F, 0.2F);
    }
    label40:
    do
    {
      return localzdm1;
      if (paramInt == 2) {
        return new zdm(80, 15, 0.9F, 0.4F);
      }
      localzdm1 = localzdm2;
    } while (paramInt != 3);
    return new zdm(75, 30, 1.0F, 0.7F);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ClearMemoryConfig{");
    localStringBuilder.append("DpcConfigId='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", isClearEnable=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", delay=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", clearStep=").append(this.b);
    localStringBuilder.append(", clearLevels=").append(this.jdField_a_of_type_AndroidUtilSparseArray);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdl
 * JD-Core Version:    0.7.0.1
 */