import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView.ScrollStateListener.1;

public class wvv
  implements wvq
{
  private wvv(AEBottomListScrollView paramAEBottomListScrollView) {}
  
  public void a()
  {
    if (AEBottomListScrollView.a(this.a) == null) {}
    int i;
    RecyclerView.ViewHolder localViewHolder;
    do
    {
      return;
      i = AEBottomListScrollView.a(this.a).b();
      localViewHolder = this.a.a(i);
    } while (localViewHolder == null);
    AEBottomListScrollView.a(this.a, localViewHolder, i);
  }
  
  public void a(float paramFloat)
  {
    if (AEBottomListScrollView.a(this.a) == null) {}
    int i;
    int j;
    do
    {
      return;
      i = this.a.a();
      j = AEBottomListScrollView.a(this.a).a();
    } while (i == j);
    AEBottomListScrollView.a(this.a, paramFloat, i, j, this.a.a(i), this.a.a(j));
  }
  
  public void b()
  {
    if ((AEBottomListScrollView.a(this.a) == null) && (AEBottomListScrollView.a(this.a) == null)) {}
    int i;
    RecyclerView.ViewHolder localViewHolder;
    do
    {
      return;
      i = AEBottomListScrollView.a(this.a).b();
      localViewHolder = this.a.a(i);
    } while (localViewHolder == null);
    AEBottomListScrollView.b(this.a, localViewHolder, i);
    AEBottomListScrollView.c(this.a, localViewHolder, i);
  }
  
  public void c()
  {
    this.a.post(new AEBottomListScrollView.ScrollStateListener.1(this));
  }
  
  public void d()
  {
    AEBottomListScrollView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvv
 * JD-Core Version:    0.7.0.1
 */