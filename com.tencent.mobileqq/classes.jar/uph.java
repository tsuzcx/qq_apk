import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class uph
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public BubblePopupWindow a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  
  private uph(ChatAdapter1 paramChatAdapter1) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "popup onDismiss is called");
    }
    EmojiStickerManager.a().b();
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
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
      this.jdField_b_of_type_Boolean = false;
      BubbleContextMenu.jdField_a_of_type_Boolean = false;
      Object localObject2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setPressed(false);
        localObject2 = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject2 == null) || (!(localObject2 instanceof AbsStructMsgItem))) {
          break label168;
        }
        ((AbsStructMsgItem)localObject2).b(this.jdField_a_of_type_AndroidViewView);
      }
      label168:
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
              ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_AndroidViewView, false);
            }
          }
          for (;;)
          {
            localObject1 = this.jdField_b_of_type_AndroidViewView.findViewById(2131361925);
            if ((localObject1 == null) || (!(localObject1 instanceof PAHighLightImageView))) {
              break label391;
            }
            ((PAHighLightImageView)localObject1).a();
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008))
            {
              if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject3).jdField_a_of_type_Boolean) {
                this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837921);
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
      label391:
      localObject1 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
      int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
      int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
      int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
      int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131362187)).intValue();
      if (n == 0) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837909);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
        break;
        if (n == 2) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837913);
        } else {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837911);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localContext = paramView.getContext();
      localChatItemBuilder.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    while (!QLog.isColorLevel())
    {
      ChatItemBuilder localChatItemBuilder;
      Context localContext;
      return;
    }
    QLog.d("ChatItemBuilder", 2, "bubble onClick() is called while the chatMessage is null.");
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView instanceof AnimationTextView)) {
      ((AnimationTextView)paramView).setTag(2131362292, Boolean.valueOf(true));
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return true;
    }
    if ((paramView instanceof ETTextView))
    {
      localObject1 = (ETTextView)paramView;
      if (((ETTextView)localObject1).c)
      {
        ((ETTextView)localObject1).c = false;
        a(paramView);
        return true;
      }
    }
    this.jdField_b_of_type_Boolean = true;
    AIOUtils.m = true;
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onLongClick() is called");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      a(paramView);
      return false;
    }
    Object localObject2 = new QQCustomMenu();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    Object localObject3 = ((ChatItemBuilder)localObject1).a(paramView);
    int j;
    Object localObject4;
    if ((localObject3 != null) && (localObject3.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      j = localObject3.length;
      i = 0;
      if (i < j)
      {
        localObject4 = localObject3[i];
        if ((GoldMsgChatHelper.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!GoldMsgChatHelper.b(((QQCustomMenuItem)localObject4).a()))) {}
        for (;;)
        {
          i += 1;
          break;
          ((QQCustomMenu)localObject2).a((QQCustomMenuItem)localObject4);
        }
      }
      if (((QQCustomMenu)localObject2).a() < 1) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label935;
      }
    }
    label902:
    label935:
    for (int i = 1;; i = 0)
    {
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
        if ((localObject2 instanceof AbsStructMsgItem)) {
          ((AbsStructMsgItem)localObject2).c(this.jdField_a_of_type_AndroidViewView);
        }
      }
      else
      {
        if ((localObject1 instanceof BaseBubbleBuilder))
        {
          EmojiStickerManager.a().a(paramView);
          localObject2 = ((BaseBubbleBuilder)localObject1).a(paramView);
          if (localObject2 != null)
          {
            this.jdField_a_of_type_AndroidViewView = paramView;
            ((BaseBubbleBuilder.TouchDelegate)localObject2).a(paramView, false);
          }
        }
        if (!(localObject1 instanceof TextItemBuilder)) {
          break label902;
        }
        paramView = Integer.toString(0);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramView, "", "", "");
        BubbleContextMenu.jdField_a_of_type_Boolean = true;
        return true;
        if ((localObject2 instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
        {
          localObject4 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject2;
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
            label552:
            if ((this.jdField_b_of_type_AndroidViewView == null) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_Boolean)) {
              break label679;
            }
            localObject3 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            if (!this.jdField_a_of_type_Boolean) {
              break label695;
            }
            if (!((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
              break label681;
            }
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845867);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            this.jdField_b_of_type_AndroidViewView = ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidWidgetRelativeLayout;
            this.jdField_a_of_type_Boolean = true;
            break label552;
            label679:
            break;
            label681:
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject4).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845703);
            continue;
            label695:
            if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)
            {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837923);
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
        if (!(localObject2 instanceof StructMsgItemButton)) {
          break;
        }
        this.jdField_b_of_type_AndroidViewView = paramView;
        localObject2 = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        int n = ((Integer)paramView.getTag(2131362187)).intValue();
        if (n == 0) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837910);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          break;
          if (n == 2) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837914);
          } else {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837912);
          }
        }
        if ((localObject1 instanceof PicItemBuilder)) {
          paramView = Integer.toString(1);
        } else {
          paramView = Integer.toString(999);
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
    Object localObject = paramView.findViewById(2131361925);
    if ((localObject != null) && ((localObject instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localObject).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((!this.jdField_b_of_type_Boolean) && ((localObject instanceof BaseBubbleBuilder)))
      {
        localObject = ((BaseBubbleBuilder)localObject).a(paramView);
        if (localObject != null) {
          ((BaseBubbleBuilder.TouchDelegate)localObject).a(paramView, paramMotionEvent);
        }
      }
      return false;
      localObject = paramView.findViewById(2131362097);
      if ((localObject != null) && ((localObject instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localObject).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */