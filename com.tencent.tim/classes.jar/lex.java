import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lex
  implements View.OnClickListener
{
  public lex(ReadInJoySelfFragment paramReadInJoySelfFragment, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.val$jumpUrl))
    {
      Intent localIntent = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.val$jumpUrl);
      this.this$0.getActivity().startActivity(localIntent);
      kbp.a(null, "CliOper", "", "", "0X80092FF", "0X80092FF", 0, 0, ReadInJoySelfFragment.a(this.this$0, this.aOu) + "", this.aOu + "", "", kxm.et(this.val$title), false);
      ReadInJoySelfFragment.a(this.this$0, this.aOu);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lex
 * JD-Core Version:    0.7.0.1
 */