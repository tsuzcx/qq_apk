import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class vba
  implements AdapterView.e
{
  public vba(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.this$0.sG = paramView;
    this.this$0.a.setCurrentIndex(paramInt);
    this.this$0.a(paramAdapterView, paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vba
 * JD-Core Version:    0.7.0.1
 */