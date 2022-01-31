final class wrn
  extends ThreadLocal<StringBuilder>
{
  protected StringBuilder a()
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    localStringBuilder.setLength(0);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrn
 * JD-Core Version:    0.7.0.1
 */