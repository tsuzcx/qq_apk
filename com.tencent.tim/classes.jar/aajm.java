import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aajm
  implements View.OnClickListener
{
  aajm(aajg paramaajg) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    label109:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = paramView.getId();
      if ((i >= 0) && (i < this.this$0.getCount()))
      {
        Object localObject = this.this$0.getItem(i);
        if ((localObject != null) && ((localObject instanceof RecentBaseData)))
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)localObject;
          if ((paramView instanceof TextView))
          {
            localObject = ((TextView)paramView).getText();
            if (localObject == null) {}
          }
          for (localObject = ((CharSequence)localObject).toString();; localObject = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label109;
            }
            this.this$0.a(localRecentBaseData, (String)localObject, "1");
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajm
 * JD-Core Version:    0.7.0.1
 */