import android.util.SparseArray;

public class xos
{
  public int a;
  public SparseArray<xot> a;
  public String a;
  public boolean a;
  public int b = 4;
  
  public xos(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public xot a(int paramInt)
  {
    xot localxot2 = (xot)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    xot localxot1 = localxot2;
    if (localxot2 == null)
    {
      if (paramInt != 1) {
        break label40;
      }
      localxot1 = new xot(85, 5, 0.7F, 0.2F);
    }
    label40:
    do
    {
      return localxot1;
      if (paramInt == 2) {
        return new xot(80, 15, 0.9F, 0.4F);
      }
      localxot1 = localxot2;
    } while (paramInt != 3);
    return new xot(75, 30, 1.0F, 0.7F);
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
 * Qualified Name:     xos
 * JD-Core Version:    0.7.0.1
 */