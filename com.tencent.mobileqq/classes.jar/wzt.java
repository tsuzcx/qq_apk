import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class wzt
  implements uva<uwr>
{
  wzt(wzs paramwzs) {}
  
  public void a(boolean paramBoolean, uwr paramuwr)
  {
    wxe.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramuwr != null))
    {
      wxe.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramuwr.a));
      int i = paramuwr.a;
      wzs.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzt
 * JD-Core Version:    0.7.0.1
 */