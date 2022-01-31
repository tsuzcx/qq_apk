import android.util.SparseArray;

public class xfv
{
  public int a;
  public SparseArray<xfw> a;
  public String a;
  public boolean a;
  public int b = 4;
  
  public xfv(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public xfw a(int paramInt)
  {
    xfw localxfw2 = (xfw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    xfw localxfw1 = localxfw2;
    if (localxfw2 == null)
    {
      if (paramInt != 1) {
        break label40;
      }
      localxfw1 = new xfw(85, 5, 0.7F, 0.2F);
    }
    label40:
    do
    {
      return localxfw1;
      if (paramInt == 2) {
        return new xfw(80, 15, 0.9F, 0.4F);
      }
      localxfw1 = localxfw2;
    } while (paramInt != 3);
    return new xfw(75, 30, 1.0F, 0.7F);
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
 * Qualified Name:     xfv
 * JD-Core Version:    0.7.0.1
 */