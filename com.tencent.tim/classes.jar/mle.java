import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment;
import java.util.List;

public class mle
  implements miw.a<mir.a>
{
  public mle(GalleryFragment paramGalleryFragment) {}
  
  public List<mir.a> a(int paramInt1, int paramInt2)
  {
    return mir.e(paramInt1, paramInt2);
  }
  
  public void p(List<mir.a> paramList, boolean paramBoolean)
  {
    GalleryFragment.a(this.this$0).addAll(paramList);
    GalleryFragment.a(this.this$0).notifyDataSetChanged();
    if (GalleryFragment.a(this.this$0).isEmpty())
    {
      GalleryFragment.a(this.this$0).setVisibility(0);
      return;
    }
    GalleryFragment.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mle
 * JD-Core Version:    0.7.0.1
 */