import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class vgs
  implements tbz<tdq>
{
  vgs(vgr paramvgr) {}
  
  public void a(boolean paramBoolean, tdq paramtdq)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramtdq != null))
    {
      ved.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramtdq.a));
      int i = paramtdq.a;
      vgr.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgs
 * JD-Core Version:    0.7.0.1
 */