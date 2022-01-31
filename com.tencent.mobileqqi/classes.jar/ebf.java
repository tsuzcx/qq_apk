import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class ebf
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  
  private ebf(ChatAdapter1 paramChatAdapter1) {}
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((localChatItemBuilder instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)localChatItemBuilder).c();
      }
    }
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if ((ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1) != null) && (ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).isShowing())) {
      ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localContext = paramView.getContext();
      localChatItemBuilder.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    }
    while (!QLog.isColorLevel())
    {
      ChatItemBuilder localChatItemBuilder;
      Context localContext;
      return;
    }
    QLog.d(ChatItemBuilder.a, 2, "bubble onClick() is called while the chatMessage is null.");
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onLongClick() is called");
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).a(paramView);
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      while (i < j)
      {
        localQQCustomMenu.a(localObject1[i]);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      Object localObject2;
      if (ItemBuilderFactory.a == null)
      {
        localObject2 = ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).getResources().getString(2131559157);
        localObject1 = localObject2;
        if (localObject2.equals(ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).getResources().getString(2131559163)))
        {
          localObject2 = LocaleUtil.a(ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          localObject1 = null;
          TransDiskCache localTransDiskCache = TranslateCache.a(ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).getApplicationContext());
          if (localTransDiskCache != null) {
            localObject1 = localTransDiskCache.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, (String)localObject2);
          }
          if ((localObject1 == null) || (!((Trans_entity)localObject1).a().booleanValue()) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
            break label305;
          }
          localObject2 = ((Trans_entity)localObject1).a();
          label250:
          if (!EmoticonUtils.a((String)localObject2)) {
            break label317;
          }
          localObject1 = new QQText((CharSequence)localObject2, 13, 32);
        }
      }
      for (;;)
      {
        ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, BubbleContextMenu.a(paramView, localQQCustomMenu, this, (CharSequence)localObject1));
        a(paramView);
        return true;
        localObject2 = ItemBuilderFactory.a;
        break;
        label305:
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg;
        break label250;
        label317:
        localObject1 = localObject2;
        if (EmoticonUtils.c((String)localObject2)) {
          localObject1 = ChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).getResources().getString(2131559157);
        }
      }
    }
    a(paramView);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onTouch() is called,action is:" + paramMotionEvent.getAction());
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ebf
 * JD-Core Version:    0.7.0.1
 */