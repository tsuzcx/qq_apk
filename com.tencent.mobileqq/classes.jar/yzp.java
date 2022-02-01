import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class yzp
  implements yxl
{
  public yzp(DoodleEditView paramDoodleEditView) {}
  
  public void a(zcb paramzcb)
  {
    if ((paramzcb instanceof yxo))
    {
      paramzcb = (yxm)DoodleEditView.a(this.a).a("TextLayer");
      if (paramzcb != null) {
        paramzcb.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(zcb paramzcb, int paramInt1, int paramInt2)
  {
    if ((paramzcb instanceof yxo))
    {
      yqp.b("DoodleEditView", "click the TextItem:" + paramzcb);
      paramzcb = (yxm)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramzcb != null) && (paramzcb.a != null))
      {
        paramzcb.d();
        paramzcb.a.a();
      }
    }
    ywy localywy;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramzcb instanceof yxc));
        yqp.b("DoodleEditView", "click the FaceAndTextItem:" + paramzcb);
        paramzcb.d = false;
        localywy = (ywy)DoodleEditView.a(this.a).a("FaceLayer");
        yxc localyxc = (yxc)paramzcb;
        if (localywy != null) {
          localywy.jdField_a_of_type_JavaUtilList.add(localyxc);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramzcb instanceof ywz)) {
        break;
      }
    } while ((localywy == null) || (localywy.jdField_a_of_type_Yxf == null));
    localywy.jdField_a_of_type_Yxf.a((ywz)paramzcb);
    return;
    DoodleEditView.a(this.a).a(paramzcb);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yzp
 * JD-Core Version:    0.7.0.1
 */