import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.b;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;

public class wyq
  implements View.OnClickListener
{
  public wyq(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    if ((!this.this$0.mClickable) || (this.this$0.Rk()) || (System.currentTimeMillis() - ApolloItemBuilder.b(this.this$0) < 600L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ApolloItemBuilder.b(this.this$0, System.currentTimeMillis());
      abhh.sI.clear();
      ApolloItemBuilder.b localb = (ApolloItemBuilder.b)wja.a(paramView);
      MessageForApollo localMessageForApollo = (MessageForApollo)localb.mMessage;
      if (localMessageForApollo == null)
      {
        QLog.e("ApolloItemBuilder", 1, "errInfo->mr is null.");
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloItemBuilder", 2, "click game msg, roomId:" + localMessageForApollo.roomId);
        }
        if ((localMessageForApollo.mApolloMessage == null) || (localMessageForApollo.mApolloMessage.id == 99999))
        {
          QQToast.a(paramView.getContext(), acfp.m(2131702550), 0).show();
        }
        else if (abhh.aV(this.this$0.app.getApplication()))
        {
          if (!ApolloGameUtil.ib(localMessageForApollo.msgType))
          {
            int j = localMessageForApollo.mApolloMessage.id;
            if (localMessageForApollo.isDoubleAction()) {
              i = 1;
            }
            if (!ApolloUtil.aF(j, i))
            {
              abhh localabhh = (abhh)this.this$0.app.getManager(153);
              if ((localabhh != null) && (localabhh.cd(this.this$0.app.getCurrentUin()) != 2))
              {
                localb.a.setFailedIconVisable(true, this);
                if (!abhh.aM.contains(Integer.valueOf(localb.mActionId))) {
                  abhh.aM.add(Integer.valueOf(localb.mActionId));
                }
              }
              if (!aqiw.isNetworkAvailable(this.this$0.mContext)) {
                continue;
              }
            }
          }
          ApolloItemBuilder.a(this.this$0, localMessageForApollo);
          this.this$0.a(localb, 2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyq
 * JD-Core Version:    0.7.0.1
 */