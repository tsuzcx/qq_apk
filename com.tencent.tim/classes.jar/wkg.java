import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.b;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class wkg
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1 = (ChatMessage)paramCompoundButton.getTag();
    if (localObject1 == null) {}
    label507:
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if ((localObject1 instanceof MessageForPtt))
      {
        localObject2 = MediaPlayerManager.a(BaseActivity.sTopActivity.app).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).uniseq == ((ChatMessage)localObject1).uniseq))) {
          MediaPlayerManager.a(BaseActivity.sTopActivity.app).yB(false);
        }
      }
      Object localObject2 = AIOLongShotHelper.a();
      if ((localObject2 != null) && (((AIOLongShotHelper)localObject2).RS()))
      {
        if ((paramBoolean != ((AIOLongShotHelper)localObject2).n((ChatMessage)localObject1)) && (BaseChatItemLayout.a != null)) {
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
        }
      }
      else if (paramBoolean != ajlc.a().O((ChatMessage)localObject1))
      {
        if (!paramBoolean) {
          ajlc.a().a((ChatMessage)localObject1, paramBoolean);
        }
        for (;;)
        {
          if (BaseChatItemLayout.a == null) {
            break label507;
          }
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
          break;
          if ((localObject1 instanceof MessageForFile))
          {
            localObject2 = ahav.a(BaseActivity.sTopActivity.app, (MessageForFile)localObject1);
            if ((((FileManagerEntity)localObject2).getCloudType() == 1) && (((FileManagerEntity)localObject2).status == 2))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131693837);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).show(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          if ((localObject1 instanceof MessageForTroopFile))
          {
            localObject2 = (MessageForTroopFile)localObject1;
            localObject2 = apsv.a(BaseActivity.sTopActivity.app, (MessageForTroopFile)localObject2);
            if ((localObject2 != null) && ((((apcy)localObject2).Status == 0) || (((apcy)localObject2).Status == 1) || (((apcy)localObject2).Status == 2) || (((apcy)localObject2).Status == 3) || (((apcy)localObject2).Status == 4)))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131693837);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).show(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          int i = ajlc.a().Gq();
          if (ajlc.a().c((ChatMessage)localObject1, i))
          {
            if (ajlc.a().djF == 7) {}
            for (localObject1 = paramCompoundButton.getContext().getString(2131700611, new Object[] { Integer.valueOf(i) });; localObject1 = paramCompoundButton.getContext().getString(2131700610, new Object[] { Integer.valueOf(i) }))
            {
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).show(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          ajlc.a().a((ChatMessage)localObject1, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkg
 * JD-Core Version:    0.7.0.1
 */