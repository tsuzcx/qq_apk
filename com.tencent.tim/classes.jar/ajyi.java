import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;

public class ajyi
  implements AdapterView.OnItemLongClickListener
{
  public ajyi(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Comments.Comment)paramAdapterView.getAdapter().getItem(paramInt);
    if (paramAdapterView == null) {
      return true;
    }
    paramLong = Long.parseLong(this.this$0.app.getCurrentAccountUin());
    if (paramAdapterView.uid == paramLong)
    {
      this.this$0.d(paramAdapterView);
      return true;
    }
    if (ShortVideoCommentsView.a(this.this$0).adu == paramLong) {
      this.this$0.f(paramAdapterView);
    }
    for (;;)
    {
      return false;
      this.this$0.e(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyi
 * JD-Core Version:    0.7.0.1
 */