import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zft
  implements View.OnClickListener
{
  zft(zfr paramzfr, String paramString, zfr.c paramc, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (!this.jdField_a_of_type_Zfr.a.aTT) {
      if (!TextUtils.isEmpty(this.val$url))
      {
        localObject1 = null;
        int i = this.val$url.lastIndexOf("#");
        if (i > 0) {
          localObject1 = this.val$url.substring(i);
        }
        localObject2 = URLUtil.guessUrl(this.val$url);
        if (localObject1 == null) {
          break label188;
        }
      }
    }
    label188:
    for (Object localObject1 = (String)localObject2 + (String)localObject1;; localObject1 = localObject2)
    {
      localObject2 = new Intent(this.jdField_a_of_type_Zfr.mContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.jdField_a_of_type_Zfr.mContext.startActivity((Intent)localObject2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      boolean bool = zfr.c.a(this.jdField_a_of_type_Zfr$c).isChecked();
      zfr.a(this.jdField_a_of_type_Zfr).aL(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject1 = zfr.c.a(this.jdField_a_of_type_Zfr$c);
      if (!bool) {}
      for (bool = true;; bool = false)
      {
        ((CheckBox)localObject1).setChecked(bool);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zft
 * JD-Core Version:    0.7.0.1
 */