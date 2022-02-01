import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class rcm
  implements psc.a<pth.a>
{
  rcm(rcl paramrcl) {}
  
  public void a(boolean paramBoolean, pth.a parama)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (parama != null))
    {
      ram.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(parama.temperature));
      int i = parama.temperature;
      rcl.a(this.this$0).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rcm
 * JD-Core Version:    0.7.0.1
 */