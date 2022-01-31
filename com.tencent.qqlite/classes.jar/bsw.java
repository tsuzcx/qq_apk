import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MenuPopupDialog;

public class bsw
  implements View.OnClickListener, OnLongClickAndTouchListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public MenuPopupDialog a;
  
  private bsw(ChatAdapter1 paramChatAdapter1) {}
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.dismiss();
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
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onLongClick() is called");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) && (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.isShowing()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    Object localObject = localChatItemBuilder.a(paramView);
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localQQCustomMenu.a(localObject[i]);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForText)) {
        if (((MessageForText)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).location != null)
        {
          localObject = "地理位置";
          this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, (String)localObject, localQQCustomMenu, this, new bsx(this));
          a(paramView);
          if (!(localChatItemBuilder instanceof TextItemBuilder)) {
            break label322;
          }
          paramView = Integer.toString(0);
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramView, "", "", "");
        MenuPopupDialog.a = true;
        return true;
        localObject = "消息";
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForFile))
        {
          localObject = "文件";
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))
        {
          localObject = "语音";
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPic))
        {
          localObject = "图片";
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForMarketFace))
        {
          localObject = "表情";
          break;
        }
        localObject = "消息";
        break;
        label322:
        if ((localChatItemBuilder instanceof PicItemBuilder)) {
          paramView = Integer.toString(1);
        } else {
          paramView = Integer.toString(999);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bsw
 * JD-Core Version:    0.7.0.1
 */