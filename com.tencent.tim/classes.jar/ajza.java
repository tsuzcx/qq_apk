import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajza
  implements View.OnClickListener
{
  public ajza(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    String str3 = ShortVideoCommentsView.a(this.this$0).getText().toString();
    if (str3.equals("")) {
      this.this$0.showToast(this.this$0.getContext().getResources().getString(2131698609));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (str3.length() > 140)
      {
        this.this$0.showToast(this.this$0.getContext().getResources().getString(2131698610));
      }
      else
      {
        Comments.Comment localComment = new Comments.Comment();
        localComment.uid = Long.parseLong(this.this$0.app.getCurrentAccountUin());
        localComment.headUrl = "";
        String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + this.this$0.app.getCurrentAccountUin(), 4).getString("nick", "");
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = this.this$0.app.getCurrentNickname();
        }
        localComment.name = str1;
        localComment.content = str3;
        localComment.timestamp = (System.currentTimeMillis() / 1000L);
        localComment.a = ShortVideoCommentsView.a(this.this$0);
        if ((ShortVideoCommentsView.a(this.this$0) != null) && ((ShortVideoCommentsView.a(this.this$0).uid > 0L) || (ShortVideoCommentsView.a(this.this$0).nowId > 0L)))
        {
          localComment.bSy = ShortVideoCommentsView.a(this.this$0).headUrl;
          localComment.bSx = ShortVideoCommentsView.a(this.this$0).name;
          localComment.ado = ShortVideoCommentsView.a(this.this$0).uid;
          localComment.adp = ShortVideoCommentsView.a(this.this$0).nowId;
          localComment.dll = ShortVideoCommentsView.a(this.this$0).nowUserType;
        }
        ShortVideoCommentsView.a(this.this$0).l(localComment);
        ShortVideoCommentsView.a(this.this$0, localComment);
        anot.a(this.this$0.app, "dc00899", "grp_lbs", "", "new_thing", "clk_reply", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajza
 * JD-Core Version:    0.7.0.1
 */