import java.util.Comparator;

class vjf
  implements Comparator<vim>
{
  vjf(vje paramvje) {}
  
  public int a(vim paramvim1, vim paramvim2)
  {
    if (paramvim1.b == paramvim2.b) {
      return 0;
    }
    if (paramvim1.b > paramvim2.b) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjf
 * JD-Core Version:    0.7.0.1
 */