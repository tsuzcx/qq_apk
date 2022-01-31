import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.biz.JoinGroupTransitActivity;

public class ju
  implements JoinGroupHandler.IJoinGroupCB
{
  public ju(JoinGroupTransitActivity paramJoinGroupTransitActivity) {}
  
  public void a()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(1);
  }
  
  public void b()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(2);
  }
  
  public void c()
  {
    JoinGroupTransitActivity.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ju
 * JD-Core Version:    0.7.0.1
 */