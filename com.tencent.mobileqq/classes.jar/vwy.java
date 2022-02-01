import java.util.Comparator;

final class vwy
  implements Comparator<vxh>
{
  public int a(vxh paramvxh1, vxh paramvxh2)
  {
    if ((paramvxh1 == paramvxh2) || (paramvxh1.b == paramvxh2.b)) {
      return 0;
    }
    if (paramvxh1.b < paramvxh2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwy
 * JD-Core Version:    0.7.0.1
 */