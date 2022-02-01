import java.text.SimpleDateFormat;

final class anoa
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat initialValue()
  {
    return new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anoa
 * JD-Core Version:    0.7.0.1
 */