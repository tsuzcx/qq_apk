import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class yel
  implements yco
{
  public yel(DoodleEditView paramDoodleEditView) {}
  
  public void a(ygw paramygw)
  {
    if ((paramygw instanceof ycr))
    {
      paramygw = (ycp)DoodleEditView.a(this.a).a("TextLayer");
      if (paramygw != null) {
        paramygw.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(ygw paramygw, int paramInt1, int paramInt2)
  {
    if ((paramygw instanceof ycr))
    {
      xvv.b("DoodleEditView", "click the TextItem:" + paramygw);
      paramygw = (ycp)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramygw != null) && (paramygw.a != null))
      {
        paramygw.d();
        paramygw.a.a();
      }
    }
    ycc localycc;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramygw instanceof ycg));
        xvv.b("DoodleEditView", "click the FaceAndTextItem:" + paramygw);
        paramygw.d = false;
        localycc = (ycc)DoodleEditView.a(this.a).a("FaceLayer");
        ycg localycg = (ycg)paramygw;
        if (localycc != null) {
          localycc.jdField_a_of_type_JavaUtilList.add(localycg);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramygw instanceof ycd)) {
        break;
      }
    } while ((localycc == null) || (localycc.jdField_a_of_type_Ycj == null));
    localycc.jdField_a_of_type_Ycj.a((ycd)paramygw);
    return;
    DoodleEditView.a(this.a).a(paramygw);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yel
 * JD-Core Version:    0.7.0.1
 */