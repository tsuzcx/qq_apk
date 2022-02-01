final class wjb
  extends ThreadLocal<char[]>
{
  protected char[] initialValue()
  {
    return new char[1024];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjb
 * JD-Core Version:    0.7.0.1
 */