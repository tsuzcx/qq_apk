import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class ynd
  implements wis<wkj>
{
  ynd(ync paramync) {}
  
  public void a(boolean paramBoolean, wkj paramwkj)
  {
    ykq.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwkj != null))
    {
      ykq.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramwkj.a));
      int i = paramwkj.a;
      ync.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynd
 * JD-Core Version:    0.7.0.1
 */