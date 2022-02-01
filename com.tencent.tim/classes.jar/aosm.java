import android.view.View;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;

public class aosm
  implements AdapterView.d
{
  public aosm(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.a != null)
    {
      paramAdapterView = this.this$0.a.a(paramInt);
      if ((paramAdapterView == null) || (paramAdapterView.type != 1)) {
        return false;
      }
    }
    MediaPreviewActivity.a(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosm
 * JD-Core Version:    0.7.0.1
 */