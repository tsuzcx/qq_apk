import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class ywz
  implements wsh<wty>
{
  ywz(ywy paramywy) {}
  
  public void a(boolean paramBoolean, wty paramwty)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwty != null))
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramwty.a));
      int i = paramwty.a;
      ywy.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */