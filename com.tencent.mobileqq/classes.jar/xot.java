public class xot
{
  public float a;
  public int a;
  public float b;
  public int b;
  
  public xot(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MemoryLevelInfo{");
    localStringBuilder.append("MemoryPercent=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", delayTime=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", maxCacheSize=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", trimPercent=").append(this.jdField_b_of_type_Float);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xot
 * JD-Core Version:    0.7.0.1
 */