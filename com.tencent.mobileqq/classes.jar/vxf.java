import java.util.Comparator;

public class vxf
  implements Comparator<vxd>
{
  public int a(vxd paramvxd1, vxd paramvxd2)
  {
    if (paramvxd1.c < paramvxd2.c) {
      return 1;
    }
    if (paramvxd1.c > paramvxd2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */