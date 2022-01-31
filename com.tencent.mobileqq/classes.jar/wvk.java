import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class wvk
  implements uqr<usi>
{
  wvk(wvj paramwvj) {}
  
  public void a(boolean paramBoolean, usi paramusi)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramusi != null))
    {
      wsv.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramusi.a));
      int i = paramusi.a;
      wvj.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvk
 * JD-Core Version:    0.7.0.1
 */