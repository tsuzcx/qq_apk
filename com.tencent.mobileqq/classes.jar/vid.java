import java.util.Comparator;

final class vid
  implements Comparator<vim>
{
  public int a(vim paramvim1, vim paramvim2)
  {
    if ((paramvim1 == paramvim2) || (paramvim1.b == paramvim2.b)) {
      return 0;
    }
    if (paramvim1.b < paramvim2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vid
 * JD-Core Version:    0.7.0.1
 */