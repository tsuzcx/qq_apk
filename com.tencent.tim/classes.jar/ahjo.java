import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ahjo
  extends RecyclerView.OnScrollListener
{
  ahjo(ahjl paramahjl) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("Forward.Preview.Dialog", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      ahjl.a(this.this$0).pause();
    }
    while (!ahjl.a(this.this$0).isPausing()) {
      return;
    }
    ahjl.a(this.this$0).resume();
    ahjl.a(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjo
 * JD-Core Version:    0.7.0.1
 */