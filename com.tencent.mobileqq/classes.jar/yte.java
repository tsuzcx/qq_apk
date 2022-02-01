import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class yte
  implements wom<wqd>
{
  yte(ytd paramytd) {}
  
  public void a(boolean paramBoolean, wqd paramwqd)
  {
    yqp.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwqd != null))
    {
      yqp.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramwqd.a));
      int i = paramwqd.a;
      ytd.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yte
 * JD-Core Version:    0.7.0.1
 */