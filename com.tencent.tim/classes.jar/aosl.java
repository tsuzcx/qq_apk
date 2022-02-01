import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;

public class aosl
  implements AdapterView.e
{
  public aosl(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (this.this$0.a != null) {
      this.this$0.a.bH(false, paramInt);
    }
    this.this$0.mSelectedIndex = paramInt;
    paramAdapterView = this.this$0.mSelectedIndex + 1 + "/" + this.this$0.dRE;
    this.this$0.mTextView.setText(paramAdapterView);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosl
 * JD-Core Version:    0.7.0.1
 */