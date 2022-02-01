import java.util.Comparator;

final class ygp
  implements Comparator<ygk>
{
  public int a(ygk paramygk1, ygk paramygk2)
  {
    if ((paramygk1 == null) || (paramygk2 == null)) {
      return 0;
    }
    return Float.compare(paramygk1.wH(), paramygk2.wH());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygp
 * JD-Core Version:    0.7.0.1
 */