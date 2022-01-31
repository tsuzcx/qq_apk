public class uwb
{
  public int a;
  public long a;
  public boolean a;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (uwb)paramObject;
      if (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) {
        return false;
      }
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int * 31 + (int)(this.jdField_a_of_type_Long ^ this.jdField_a_of_type_Long >>> 32);
  }
  
  public String toString()
  {
    return "EditBehavior{hasMusic=" + this.jdField_a_of_type_Boolean + ", musicType=" + this.jdField_a_of_type_Int + ", musicId=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwb
 * JD-Core Version:    0.7.0.1
 */