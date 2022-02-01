import java.io.File;

class whv
  implements Comparable<whv>
{
  public long a;
  public final File a;
  
  public whv(whu paramwhu, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramwhu = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramwhu);
      return;
    }
    catch (Exception paramFile)
    {
      yqp.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramwhu, paramFile.getMessage() });
    }
  }
  
  public int a(whv paramwhv)
  {
    if (this.jdField_a_of_type_Long < paramwhv.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwhv.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whv
 * JD-Core Version:    0.7.0.1
 */