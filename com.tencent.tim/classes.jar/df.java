import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class df
  implements ahav.d
{
  df(db paramdb, DataLineMsgRecord paramDataLineMsgRecord) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.app == null) || (this.this$0.mContext == null)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          paramView = new WeakReference(this.this$0.mContext);
        } while (!(this.this$0.mContext instanceof Activity));
        if (!aqiw.isNetSupport(this.this$0.mContext))
        {
          QQToast.a(this.this$0.mContext, 2131693404, 0).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
          return;
        }
      } while ((this.a == null) || (paramView.get() == null));
      str = this.a.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
      Boolean.parseBoolean(this.a.getExtInfoFromExtStr("team_work_is_message_convert"));
    } while (TextUtils.isEmpty(str));
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    localBundle.putString("tdsourcetag", "s_qq_aio_grey");
    TeamWorkDocEditBrowserActivity.a((Context)paramView.get(), localBundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     df
 * JD-Core Version:    0.7.0.1
 */