import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ahmh
  extends RecyclerView.OnScrollListener
{
  ahmh(ahme paramahme) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      ahme.a(this.this$0).pause();
    }
    while (!ahme.a(this.this$0).isPausing()) {
      return;
    }
    ahme.a(this.this$0).resume();
    ahme.a(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */