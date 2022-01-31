import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class uhn
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d;
  
  private uhn(ChatHistoryAdapterForC2C paramChatHistoryAdapterForC2C) {}
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
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
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
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
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837919);
              }
            }
            else
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (localObject1 == null) {
                ChatAdapter1.a((MessageForStructing)localObject3, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, false);
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
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837907);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837911);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837909);
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
    if (i == 2131375336)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)) {
        ((ChatHistoryForC2C)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_delete", 1, 0, new String[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      return;
      if (i == 2131375382)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        paramView = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        if (paramView != null) {
          TeamWorkConvertUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        } else {
          QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131439111), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
    Object localObject2 = new QQCustomMenu();
    ((QQCustomMenu)localObject2).a(2131375336, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131433621), 2130838305);
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgtype;
    Object localObject3;
    if ((i == -2014) || (i == -2005))
    {
      if (this.c)
      {
        this.d = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 4).getBoolean("tim_convert_teamwork_show_aio_menu", false);
        this.c = false;
      }
      localObject3 = (MessageForFile)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject3 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject3);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).status != 16) && (this.d) && (TeamWorkUtils.a(((FileManagerEntity)localObject3).strFilePath, ((FileManagerEntity)localObject3).fileName)))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        ((QQCustomMenu)localObject2).a(2131375382, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_AndroidContentContext.getString(2131439108), 2130838318);
      }
    }
    if (((QQCustomMenu)localObject2).a() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      int j = 0;
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
      {
        i = j;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)) {
          i = 1;
        }
      }
      j = (int)this.jdField_a_of_type_AndroidGraphicsPointF.y;
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
          break label510;
        }
        ((AbsStructMsgItem)localObject2).c(this.jdField_a_of_type_AndroidViewView);
      }
      label510:
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
          Object localObject4 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
          if ((localObject1 instanceof StructingMsgItemBuilder))
          {
            if (((StructingMsgItemBuilder)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
            {
              if ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
              }
              this.jdField_a_of_type_Boolean = false;
            }
          }
          else
          {
            if ((this.jdField_b_of_type_AndroidViewView == null) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_Boolean)) {
              break label712;
            }
            localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            if (!this.jdField_a_of_type_Boolean) {
              break label728;
            }
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
              break label714;
            }
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845658);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
            this.jdField_a_of_type_Boolean = true;
            break label585;
            break;
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845494);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
            {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837921);
            }
            else
            {
              localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
              if (((BaseBubbleBuilder)localObject1).a(paramView) == null) {
                ChatAdapter1.a((MessageForStructing)localObject4, (BaseBubbleBuilder.ViewHolder)localObject2, this.jdField_b_of_type_AndroidViewView, true);
              }
            }
          }
        }
      } while (!(localObject2 instanceof StructMsgItemButton));
      label585:
      label714:
      label728:
      this.jdField_b_of_type_AndroidViewView = paramView;
      label712:
      localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)paramView.getTag(2131362187)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837908);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837912);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837910);
        }
      }
    }
    a(paramView);
    return false;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C);
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
 * Qualified Name:     uhn
 * JD-Core Version:    0.7.0.1
 */