import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class vng
  implements vlc
{
  public vng(DoodleEditView paramDoodleEditView) {}
  
  public void a(vps paramvps)
  {
    if ((paramvps instanceof vlf))
    {
      paramvps = (vld)DoodleEditView.a(this.a).a("TextLayer");
      if (paramvps != null) {
        paramvps.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(vps paramvps, int paramInt1, int paramInt2)
  {
    if ((paramvps instanceof vlf))
    {
      veg.b("DoodleEditView", "click the TextItem:" + paramvps);
      paramvps = (vld)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramvps != null) && (paramvps.a != null))
      {
        paramvps.d();
        paramvps.a.a();
      }
    }
    vkp localvkp;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramvps instanceof vkt));
        veg.b("DoodleEditView", "click the FaceAndTextItem:" + paramvps);
        paramvps.d = false;
        localvkp = (vkp)DoodleEditView.a(this.a).a("FaceLayer");
        vkt localvkt = (vkt)paramvps;
        if (localvkp != null) {
          localvkp.jdField_a_of_type_JavaUtilList.add(localvkt);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramvps instanceof vkq)) {
        break;
      }
    } while ((localvkp == null) || (localvkp.jdField_a_of_type_Vkw == null));
    localvkp.jdField_a_of_type_Vkw.a((vkq)paramvps);
    return;
    DoodleEditView.a(this.a).a(paramvps);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vng
 * JD-Core Version:    0.7.0.1
 */