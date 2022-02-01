import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nrw
  implements AbsListView.OnScrollListener
{
  private int ajD = -1;
  private int ajE = -1;
  private int ajF;
  private int ajG;
  private int mCurrentScrollState;
  
  public nrw(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  private void akx()
  {
    if ((this.ajG > 0) && (this.mCurrentScrollState == 0))
    {
      if ((!ReadInJoyNinePicDeliverDynamicGridView.a(this.b)) || (!ReadInJoyNinePicDeliverDynamicGridView.b(this.b))) {
        break label42;
      }
      ReadInJoyNinePicDeliverDynamicGridView.b(this.b);
    }
    label42:
    while (!ReadInJoyNinePicDeliverDynamicGridView.c(this.b)) {
      return;
    }
    ReadInJoyNinePicDeliverDynamicGridView.c(this.b);
  }
  
  public void aky()
  {
    if ((this.ajF != this.ajD) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.b)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.b) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.b, ReadInJoyNinePicDeliverDynamicGridView.a(this.b));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.b);
    }
  }
  
  public void akz()
  {
    if ((this.ajF + this.ajG != this.ajD + this.ajE) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.b)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.b) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.b, ReadInJoyNinePicDeliverDynamicGridView.a(this.b));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.b);
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
      if (ReadInJoyNinePicDeliverDynamicGridView.a(this.b) != null) {
        ReadInJoyNinePicDeliverDynamicGridView.a(this.b).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
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
    ReadInJoyNinePicDeliverDynamicGridView.c(this.b, paramInt);
    akx();
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.b) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.b).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nrw
 * JD-Core Version:    0.7.0.1
 */