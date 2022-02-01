import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class mul
  implements View.OnClickListener
{
  mul(String paramString, Context paramContext, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "handleKingCardHintTextView span is clicked, guideUrl=" + this.akq);
    }
    if (!TextUtils.isEmpty(this.akq))
    {
      Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
      localIntent.putExtra("url", this.akq);
      localIntent.putExtra("big_brother_source_key", kxm.bg(0));
      this.val$context.startActivity(localIntent);
    }
    if (this.cq != null) {
      this.cq.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mul
 * JD-Core Version:    0.7.0.1
 */