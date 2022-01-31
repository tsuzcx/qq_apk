import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class vnd
  implements vkz
{
  public vnd(DoodleEditView paramDoodleEditView) {}
  
  public void a(vpp paramvpp)
  {
    if ((paramvpp instanceof vlc))
    {
      paramvpp = (vla)DoodleEditView.a(this.a).a("TextLayer");
      if (paramvpp != null) {
        paramvpp.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(vpp paramvpp, int paramInt1, int paramInt2)
  {
    if ((paramvpp instanceof vlc))
    {
      ved.b("DoodleEditView", "click the TextItem:" + paramvpp);
      paramvpp = (vla)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramvpp != null) && (paramvpp.a != null))
      {
        paramvpp.d();
        paramvpp.a.a();
      }
    }
    vkm localvkm;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramvpp instanceof vkq));
        ved.b("DoodleEditView", "click the FaceAndTextItem:" + paramvpp);
        paramvpp.d = false;
        localvkm = (vkm)DoodleEditView.a(this.a).a("FaceLayer");
        vkq localvkq = (vkq)paramvpp;
        if (localvkm != null) {
          localvkm.jdField_a_of_type_JavaUtilList.add(localvkq);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramvpp instanceof vkn)) {
        break;
      }
    } while ((localvkm == null) || (localvkm.jdField_a_of_type_Vkt == null));
    localvkm.jdField_a_of_type_Vkt.a((vkn)paramvpp);
    return;
    DoodleEditView.a(this.a).a(paramvpp);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnd
 * JD-Core Version:    0.7.0.1
 */