import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class zdk
  implements zbg
{
  public zdk(DoodleEditView paramDoodleEditView) {}
  
  public void a(zfw paramzfw)
  {
    if ((paramzfw instanceof zbj))
    {
      paramzfw = (zbh)DoodleEditView.a(this.a).a("TextLayer");
      if (paramzfw != null) {
        paramzfw.a();
      }
    }
    this.a.a.b();
  }
  
  public void a(zfw paramzfw, int paramInt1, int paramInt2)
  {
    if ((paramzfw instanceof zbj))
    {
      yuk.b("DoodleEditView", "click the TextItem:" + paramzfw);
      paramzfw = (zbh)DoodleEditView.a(this.a).a("TextLayer");
      this.a.a.b();
      if ((paramzfw != null) && (paramzfw.a != null))
      {
        paramzfw.d();
        paramzfw.a.a();
      }
    }
    zat localzat;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramzfw instanceof zax));
        yuk.b("DoodleEditView", "click the FaceAndTextItem:" + paramzfw);
        paramzfw.d = false;
        localzat = (zat)DoodleEditView.a(this.a).a("FaceLayer");
        zax localzax = (zax)paramzfw;
        if (localzat != null) {
          localzat.jdField_a_of_type_JavaUtilList.add(localzax);
        }
        this.a.a.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramzfw instanceof zau)) {
        break;
      }
    } while ((localzat == null) || (localzat.jdField_a_of_type_Zba == null));
    localzat.jdField_a_of_type_Zba.a((zau)paramzfw);
    return;
    DoodleEditView.a(this.a).a(paramzfw);
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.a) != null) {
      DoodleEditView.a(this.a).a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdk
 * JD-Core Version:    0.7.0.1
 */