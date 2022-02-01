package wf7;

import java.util.Comparator;

public class bn$c
  implements Comparator<bn>
{
  public int a(bn parambn1, bn parambn2)
  {
    int i = parambn1.ac().getLevel();
    int j = parambn2.ac().getLevel();
    if (i > j) {
      return -1;
    }
    if (i == j) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.bn.c
 * JD-Core Version:    0.7.0.1
 */