import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class adyn
  implements ausj.a
{
  adyn(adym paramadym, Context paramContext, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      do
      {
        return;
        paramView = this.a.bwn + this.a.hotWord;
      } while ((TextUtils.isEmpty(paramView)) || ((!paramView.startsWith("http://")) && (!paramView.startsWith("https://"))));
      Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.val$context.startActivity(localIntent);
      if ((this.a.n != null) && (this.a.n.get() != null)) {
        anot.a((QQAppInterface)this.a.n.get(), "P_CliOper", "aio_search", "", "aio_hotword", "search_hotword", 0, 0, "", "", this.a.hotWord, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyn
 * JD-Core Version:    0.7.0.1
 */