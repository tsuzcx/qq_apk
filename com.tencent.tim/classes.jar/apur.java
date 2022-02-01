import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.troop.widget.AddedRobotView;
import com.tencent.mobileqq.troop.widget.AddedRobotView.a;
import com.tencent.qphone.base.util.QLog;

public class apur
  extends RecyclerView.OnScrollListener
{
  public apur(AddedRobotView paramAddedRobotView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    QLog.i("AddedRobotView", 1, "onScrollStateChanged state: " + paramInt);
    if (paramInt != 0) {
      AddedRobotView.a(this.b).pause();
    }
    while (!AddedRobotView.a(this.b).isPausing()) {
      return;
    }
    AddedRobotView.a(this.b).resume();
    AddedRobotView.a(this.b).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apur
 * JD-Core Version:    0.7.0.1
 */