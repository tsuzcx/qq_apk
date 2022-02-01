import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.HorizontalAlumbListLayout;

public class aytd
  extends RecyclerView.OnScrollListener
{
  private boolean hasReport;
  
  public aytd(HorizontalAlumbListLayout paramHorizontalAlumbListLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 1) && (!this.hasReport))
    {
      if ((this.b.a != null) && (this.b.a.getActivity() != null)) {
        rar.a("video_edit_new", "swap_albumbar", this.b.a.getActivity().getIntent(), new String[0]);
      }
      this.hasReport = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytd
 * JD-Core Version:    0.7.0.1
 */