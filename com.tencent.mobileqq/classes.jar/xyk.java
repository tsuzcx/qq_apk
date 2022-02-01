import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class xyk
  implements vtx<vvo>
{
  xyk(xyj paramxyj) {}
  
  public void a(boolean paramBoolean, vvo paramvvo)
  {
    xvv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramvvo != null))
    {
      xvv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramvvo.a));
      int i = paramvvo.a;
      xyj.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyk
 * JD-Core Version:    0.7.0.1
 */