import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aail
  implements View.OnClickListener
{
  aail(aahb paramaahb, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    Object localObject1 = aqqj.o(aahb.a(this.this$0), "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
    Object localObject2 = new StringBuilder().append((String)localObject1);
    if (((String)localObject1).contains("?"))
    {
      localObject1 = "&";
      localObject1 = (String)localObject1;
      localObject2 = (String)localObject1 + "dialog_source=other&authresult=" + this.cgK;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.val$themeId)) {
        if (!((String)localObject2).contains("id=[id]")) {
          break label276;
        }
      }
    }
    label276:
    for (localObject1 = ((String)localObject2).replace("[id]", this.val$themeId);; localObject1 = (String)localObject2 + "&id=" + this.val$themeId)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "theme market url: " + (String)localObject1);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(aahb.a(this.this$0), (String)localObject1, 32L, localIntent, true, -1);
      anot.a(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(this.cgL), "", "", "");
      aahb.a(this.this$0).obtainMessage(16).sendToTarget();
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 15, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = "?";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aail
 * JD-Core Version:    0.7.0.1
 */