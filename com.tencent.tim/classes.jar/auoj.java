import com.tencent.tim.todo.data.TodoInfo;
import java.util.Comparator;

final class auoj
  implements Comparator<aupm>
{
  public int a(aupm paramaupm1, aupm paramaupm2)
  {
    long l1 = ((TodoInfo)paramaupm1).createTime;
    long l2 = ((TodoInfo)paramaupm2).createTime;
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
 * Qualified Name:     auoj
 * JD-Core Version:    0.7.0.1
 */