import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xub
  implements View.OnClickListener
{
  public xub(AIOPhotoListAdapter paramAIOPhotoListAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AIOPhotoListAdapter.a(this.this$0) == null) || (AIOPhotoListAdapter.a(this.this$0).a.ab(this.val$title) == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = AIOPhotoListAdapter.a(this.this$0).a.c(this.val$title, AIOPhotoListAdapter.a(this.this$0).mColumnCount, AIOPhotoListAdapter.a(this.this$0).sm);
    String str2 = AIOPhotoListAdapter.a(this.this$0) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      anot.a(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str2, str1, "", "");
      this.this$0.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xub
 * JD-Core Version:    0.7.0.1
 */