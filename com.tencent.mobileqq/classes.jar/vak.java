import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class vak
  implements uyg
{
  public vak(DoodleEditView paramDoodleEditView) {}
  
  public void a(vcw paramvcw)
  {
    if ((paramvcw instanceof uyj))
    {
      paramvcw = (uyh)DoodleEditView.a(this.a).a("TextLayer");
      if (paramvcw != null) {
        paramvcw.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(vcw paramvcw, int paramInt1, int paramInt2)
  {
    if ((paramvcw instanceof uyj))
    {
      urk.b("DoodleEditView", "click the TextItem:" + paramvcw);
      paramvcw = (uyh)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramvcw != null) && (paramvcw.a != null))
      {
        paramvcw.d();
        paramvcw.a.a();
      }
    }
    uxt localuxt;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramvcw instanceof uxx));
        urk.b("DoodleEditView", "click the FaceAndTextItem:" + paramvcw);
        paramvcw.d = false;
        localuxt = (uxt)DoodleEditView.a(this.a).a("FaceLayer");
        uxx localuxx = (uxx)paramvcw;
        if (localuxt != null) {
          localuxt.jdField_a_of_type_JavaUtilList.add(localuxx);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramvcw instanceof uxu)) {
        break;
      }
    } while ((localuxt == null) || (localuxt.jdField_a_of_type_Uya == null));
    localuxt.jdField_a_of_type_Uya.a((uxu)paramvcw);
    return;
    DoodleEditView.a(this.a).a(paramvcw);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vak
 * JD-Core Version:    0.7.0.1
 */