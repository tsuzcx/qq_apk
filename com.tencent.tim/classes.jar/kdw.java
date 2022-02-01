import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class kdw
  implements View.OnClickListener
{
  kdw(kdv paramkdv, int paramInt, JSONObject paramJSONObject, Context paramContext, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    switch (this.val$actionType)
    {
    }
    for (;;)
    {
      if ((kdv.a(this.a) != null) && (kdv.a(this.a).isShowing())) {
        kdv.a(this.a).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.S.optString("action_url", "");
      if (!aqmr.isEmpty((String)localObject))
      {
        Intent localIntent = new Intent(this.val$context, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
        ((Activity)this.val$context).startActivity(localIntent);
        continue;
        ((FragmentActivity)this.val$context).getChatFragment().a().a((ChatMessage)this.b);
        if ((this.b instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)this.b;
          if (((MessageForArkApp)localObject).arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            ((MessageForArkApp)localObject).arkContainer.doOnEvent(2);
          }
        }
        ((kds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(8, this.b);
        continue;
        ((FragmentActivity)this.val$context).getChatFragment().a().a((ChatMessage)this.b);
        if ((this.b instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)this.b;
          if (((MessageForArkApp)localObject).arkContainer != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("EcshopAdHelper", 2, "doOnEvent ARKAPP_TYPE_DESTROY");
            }
            ((MessageForArkApp)localObject).arkContainer.doOnEvent(2);
          }
        }
        ((kds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(139)).a(7, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdw
 * JD-Core Version:    0.7.0.1
 */