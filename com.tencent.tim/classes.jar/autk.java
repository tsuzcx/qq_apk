import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.DynamicGridView;

public class autk
  implements AbsListView.OnScrollListener
{
  private int ajD = -1;
  private int ajE = -1;
  private int ajF;
  private int ajG;
  private int mCurrentScrollState;
  
  public autk(DynamicGridView paramDynamicGridView) {}
  
  private void akx()
  {
    if ((this.ajG > 0) && (this.mCurrentScrollState == 0))
    {
      if ((!DynamicGridView.a(this.a)) || (!DynamicGridView.b(this.a))) {
        break label42;
      }
      DynamicGridView.b(this.a);
    }
    label42:
    while (!DynamicGridView.c(this.a)) {
      return;
    }
    DynamicGridView.c(this.a);
  }
  
  public void aky()
  {
    if ((this.ajF != this.ajD) && (DynamicGridView.a(this.a)) && (DynamicGridView.a(this.a) != -1L))
    {
      DynamicGridView.a(this.a, DynamicGridView.a(this.a));
      DynamicGridView.d(this.a);
    }
  }
  
  public void akz()
  {
    if ((this.ajF + this.ajG != this.ajD + this.ajE) && (DynamicGridView.a(this.a)) && (DynamicGridView.a(this.a) != -1L))
    {
      DynamicGridView.a(this.a, DynamicGridView.a(this.a));
      DynamicGridView.d(this.a);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.ajF = paramInt1;
    this.ajG = paramInt2;
    if (this.ajD == -1)
    {
      i = this.ajF;
      this.ajD = i;
      if (this.ajE != -1) {
        break label111;
      }
    }
    label111:
    for (int i = this.ajG;; i = this.ajE)
    {
      this.ajE = i;
      aky();
      akz();
      this.ajD = this.ajF;
      this.ajE = this.ajG;
      if (DynamicGridView.a(this.a) != null) {
        DynamicGridView.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      i = this.ajD;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    this.mCurrentScrollState = paramInt;
    DynamicGridView.c(this.a, paramInt);
    akx();
    if (DynamicGridView.a(this.a) != null) {
      DynamicGridView.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     autk
 * JD-Core Version:    0.7.0.1
 */