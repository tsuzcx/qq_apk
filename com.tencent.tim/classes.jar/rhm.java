import android.graphics.PointF;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.b;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class rhm
  implements rga.a
{
  public rhm(DoodleEditView paramDoodleEditView) {}
  
  public void a(riy.a parama, int paramInt1, int paramInt2)
  {
    if ((parama instanceof rgb.b))
    {
      ram.d("DoodleEditView", "click the TextItem:" + parama);
      parama = (rgb)DoodleEditView.a(this.this$0).a("TextLayer");
      this.this$0.a.btS();
      if ((parama != null) && (parama.a != null))
      {
        parama.btV();
        parama.a.btW();
      }
    }
    rft localrft;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(parama instanceof rft.b));
        ram.d("DoodleEditView", "click the FaceAndTextItem:" + parama);
        parama.aIp = false;
        localrft = (rft)DoodleEditView.a(this.this$0).a("FaceLayer");
        rft.b localb = (rft.b)parama;
        if (localrft != null) {
          localrft.oJ.add(localb);
        }
        this.this$0.a.btS();
        this.this$0.setVisibility(8);
      } while (DoodleEditView.a(this.this$0) == null);
      if (!(parama instanceof rft.a)) {
        break;
      }
    } while ((localrft == null) || (localrft.a == null));
    localrft.a.a((rft.a)parama);
    return;
    DoodleEditView.a(this.this$0).a(parama);
  }
  
  public void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    if (DoodleEditView.a(this.this$0) != null) {
      DoodleEditView.a(this.this$0).b(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
    }
  }
  
  public void c(riy.a parama)
  {
    if ((parama instanceof rgb.b))
    {
      parama = (rgb)DoodleEditView.a(this.this$0).a("TextLayer");
      if (parama != null) {
        parama.clear();
      }
    }
    this.this$0.a.btS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rhm
 * JD-Core Version:    0.7.0.1
 */