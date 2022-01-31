import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class xge
  implements xea
{
  public xge(DoodleEditView paramDoodleEditView) {}
  
  public void a(xiq paramxiq)
  {
    if ((paramxiq instanceof xed))
    {
      paramxiq = (xeb)DoodleEditView.a(this.a).a("TextLayer");
      if (paramxiq != null) {
        paramxiq.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(xiq paramxiq, int paramInt1, int paramInt2)
  {
    if ((paramxiq instanceof xed))
    {
      wxe.b("DoodleEditView", "click the TextItem:" + paramxiq);
      paramxiq = (xeb)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramxiq != null) && (paramxiq.a != null))
      {
        paramxiq.d();
        paramxiq.a.a();
      }
    }
    xdn localxdn;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramxiq instanceof xdr));
        wxe.b("DoodleEditView", "click the FaceAndTextItem:" + paramxiq);
        paramxiq.d = false;
        localxdn = (xdn)DoodleEditView.a(this.a).a("FaceLayer");
        xdr localxdr = (xdr)paramxiq;
        if (localxdn != null) {
          localxdn.jdField_a_of_type_JavaUtilList.add(localxdr);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramxiq instanceof xdo)) {
        break;
      }
    } while ((localxdn == null) || (localxdn.jdField_a_of_type_Xdu == null));
    localxdn.jdField_a_of_type_Xdu.a((xdo)paramxiq);
    return;
    DoodleEditView.a(this.a).a(paramxiq);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xge
 * JD-Core Version:    0.7.0.1
 */