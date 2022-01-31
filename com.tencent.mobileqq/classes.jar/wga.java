import android.content.ClipboardManager;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListAdapter.HistoryDeleteOperator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class wga
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private wga(ChatHistoryBubbleListAdapter paramChatHistoryBubbleListAdapter) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
      if ((localObject1 instanceof BaseBubbleBuilder))
      {
        ((BaseBubbleBuilder)localObject1).d();
        localObject1 = ((BaseBubbleBuilder)localObject1).a(this.jdField_a_of_type_AndroidViewView);
        if (localObject1 != null) {
          ((BaseBubbleBuilder.TouchDelegate)localObject1).a(this.jdField_a_of_type_AndroidViewView, true);
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof AbsStructMsgItem))) {
          break label144;
        }
        ((AbsStructMsgItem)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label144:
      label367:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewView = null;
          this.jdField_b_of_type_AndroidViewView = null;
          return;
          if ((!(localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) || (this.jdField_b_of_type_AndroidViewView == null)) {
            break;
          }
          Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
          this.jdField_b_of_type_AndroidViewView.getPaddingTop();
          this.jdField_b_of_type_AndroidViewView.getPaddingRight();
          this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
          if (this.jdField_a_of_type_Boolean) {
            if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131361925);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label367;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837922);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                ChatHistoryBubbleListAdapter.c((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, false);
              }
            }
          }
          localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131362097);
          if ((localObject1 != null) && ((localObject1 instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject1).a();
          }
        }
      } while (!(localObject2 instanceof StructMsgItemButton));
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131362187)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837910);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837914);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837912);
        }
      }
      localObject1 = null;
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
    int i = paramView.getId();
    if (i == 2131375567)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter$HistoryDeleteOperator.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_del", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      return;
      if (i == 2131375573)
      {
        ((ClipboardManager)BaseApplicationImpl.getApplication().getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msg);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_chatRecord", "", "chatRecor_aio", "aio_copy", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      a(paramView);
      return false;
    }
    Object localObject1 = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    Object localObject2 = new QQCustomMenu();
    if (((ChatItemBuilder.BaseHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype == -1000) {
      ((QQCustomMenu)localObject2).a(2131375573, "复制", 2130838305);
    }
    ((QQCustomMenu)localObject2).a(2131375567, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433638), 2130838309);
    if (((QQCustomMenu)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
      if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
        break label740;
      }
    }
    label308:
    label740:
    for (int i = 1;; i = 0)
    {
      int j = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
      int k = AIOUtils.a(10.0F, paramView.getResources());
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, j - k, (QQCustomMenu)localObject2, this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
      a(paramView);
      if (i != 0)
      {
        paramView.setPressed(true);
        this.jdField_a_of_type_AndroidViewView = paramView;
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if (!(localObject2 instanceof AbsStructMsgItem)) {
          break label308;
        }
        ((AbsStructMsgItem)localObject2).c(this.jdField_a_of_type_AndroidViewView);
      }
      label383:
      do
      {
        if ((localObject1 instanceof BaseBubbleBuilder))
        {
          localObject1 = ((BaseBubbleBuilder)localObject1).a(paramView);
          if (localObject1 != null)
          {
            this.jdField_a_of_type_AndroidViewView = paramView;
            ((BaseBubbleBuilder.TouchDelegate)localObject1).a(paramView, false);
          }
        }
        return true;
        if ((localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
        {
          Object localObject3 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          ViewGroup.LayoutParams localLayoutParams;
          if ((localObject1 instanceof StructingMsgItemBuilder))
          {
            if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
            {
              if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
              }
              this.jdField_a_of_type_Boolean = false;
            }
          }
          else
          {
            if ((this.jdField_b_of_type_AndroidViewView == null) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean)) {
              break label510;
            }
            localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            if (!this.jdField_a_of_type_Boolean) {
              break label526;
            }
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
              break label512;
            }
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845786);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidWidgetRelativeLayout;
            this.jdField_a_of_type_Boolean = true;
            break label383;
            break;
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845622);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
            {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837924);
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                ChatHistoryBubbleListAdapter.b((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, true);
              }
            }
          }
        }
      } while (!(localObject2 instanceof StructMsgItemButton));
      label510:
      this.jdField_b_of_type_AndroidViewView = paramView;
      localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)paramView.getTag(2131362187)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837911);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837915);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837913);
        }
      }
      a(paramView);
      return false;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryChatHistoryBubbleListAdapter);
    if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
    {
      localObject = ((BaseBubbleBuilder)localObject).a(paramView);
      if (localObject != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */