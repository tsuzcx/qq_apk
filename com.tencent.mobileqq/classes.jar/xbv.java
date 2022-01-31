import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class xbv
  implements wzr
{
  public xbv(DoodleEditView paramDoodleEditView) {}
  
  public void a(xeh paramxeh)
  {
    if ((paramxeh instanceof wzu))
    {
      paramxeh = (wzs)DoodleEditView.a(this.a).a("TextLayer");
      if (paramxeh != null) {
        paramxeh.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(xeh paramxeh, int paramInt1, int paramInt2)
  {
    if ((paramxeh instanceof wzu))
    {
      wsv.b("DoodleEditView", "click the TextItem:" + paramxeh);
      paramxeh = (wzs)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramxeh != null) && (paramxeh.a != null))
      {
        paramxeh.d();
        paramxeh.a.a();
      }
    }
    wze localwze;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramxeh instanceof wzi));
        wsv.b("DoodleEditView", "click the FaceAndTextItem:" + paramxeh);
        paramxeh.d = false;
        localwze = (wze)DoodleEditView.a(this.a).a("FaceLayer");
        wzi localwzi = (wzi)paramxeh;
        if (localwze != null) {
          localwze.jdField_a_of_type_JavaUtilList.add(localwzi);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramxeh instanceof wzf)) {
        break;
      }
    } while ((localwze == null) || (localwze.jdField_a_of_type_Wzl == null));
    localwze.jdField_a_of_type_Wzl.a((wzf)paramxeh);
    return;
    DoodleEditView.a(this.a).a(paramxeh);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xbv
 * JD-Core Version:    0.7.0.1
 */