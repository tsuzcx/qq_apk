package wf7;

import java.util.Comparator;

public class bn$b
  implements Comparator<bn>
{
  public int a(bn parambn1, bn parambn2)
  {
    if ((parambn1.ad().I() != -1) && (parambn2.ad().I() != -1)) {
      if (parambn1.ad().K() <= parambn2.ad().K()) {}
    }
    int i;
    int j;
    do
    {
      return -1;
      if (parambn1.ad().K() < parambn2.ad().K()) {
        return 1;
      }
      i = parambn1.ac().getLevel();
      j = parambn2.ac().getLevel();
    } while (i > j);
    if (i < j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.bn.b
 * JD-Core Version:    0.7.0.1
 */