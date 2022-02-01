import com.tencent.tim.todo.data.TodoInfo;
import java.util.Comparator;

final class auok
  implements Comparator<aupm>
{
  public int a(aupm paramaupm1, aupm paramaupm2)
  {
    long l1 = ((TodoInfo)paramaupm1).finishTime;
    long l2 = ((TodoInfo)paramaupm2).finishTime;
    if (l1 < l2) {
      return 1;
    }
    if (l1 == l2) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auok
 * JD-Core Version:    0.7.0.1
 */