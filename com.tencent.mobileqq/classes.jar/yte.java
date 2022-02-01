import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class yte
  implements yrh
{
  public yte(DoodleEditView paramDoodleEditView) {}
  
  public void a(yvp paramyvp)
  {
    if ((paramyvp instanceof yrk))
    {
      paramyvp = (yri)DoodleEditView.a(this.a).a("TextLayer");
      if (paramyvp != null) {
        paramyvp.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(yvp paramyvp, int paramInt1, int paramInt2)
  {
    if ((paramyvp instanceof yrk))
    {
      ykq.b("DoodleEditView", "click the TextItem:" + paramyvp);
      paramyvp = (yri)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramyvp != null) && (paramyvp.a != null))
      {
        paramyvp.d();
        paramyvp.a.a();
      }
    }
    yqv localyqv;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramyvp instanceof yqz));
        ykq.b("DoodleEditView", "click the FaceAndTextItem:" + paramyvp);
        paramyvp.d = false;
        localyqv = (yqv)DoodleEditView.a(this.a).a("FaceLayer");
        yqz localyqz = (yqz)paramyvp;
        if (localyqv != null) {
          localyqv.jdField_a_of_type_JavaUtilList.add(localyqz);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramyvp instanceof yqw)) {
        break;
      }
    } while ((localyqv == null) || (localyqv.jdField_a_of_type_Yrc == null));
    localyqv.jdField_a_of_type_Yrc.a((yqw)paramyvp);
    return;
    DoodleEditView.a(this.a).a(paramyvp);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yte
 * JD-Core Version:    0.7.0.1
 */