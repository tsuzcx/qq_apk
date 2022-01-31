import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.1.1;

public class vgv
  implements tcc<tdt>
{
  vgv(vgu paramvgu) {}
  
  public void a(boolean paramBoolean, tdt paramtdt)
  {
    veg.b("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramtdt != null))
    {
      veg.a("Q.qqstory.publish.edit.EditVideoFilterNeo", "onWeatherUpdate, temperature=%s", Integer.valueOf(paramtdt.a));
      int i = paramtdt.a;
      vgu.a(this.a).post(new EditVideoFilterNeo.1.1(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgv
 * JD-Core Version:    0.7.0.1
 */