import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class byn
  extends FriendListObserver
{
  public byn(ChatActivity paramChatActivity) {}
  
  protected void a()
  {
    ChatActivity.a(this.a, null, false);
  }
  
  protected void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null) {
      i = paramBundle.getInt("safety_flag");
    }
    if ((!paramBoolean) || (paramInt != 146)) {
      return;
    }
    long l = paramBundle.getLong("uin");
    if (i == 0)
    {
      UinFraudInfo.a().a(l);
      return;
    }
    UinFraudInfo.a().a(l, i);
    this.a.runOnUiThread(new byo(this, l));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    while (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    paramString = ((FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.a.k();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      this.a.finish();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramString == null)) {
      return;
    }
    int i = 0;
    label17:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        localObject = AIOUtils.a((View)localObject);
        if ((localViewHolder != null) && (((ChatMessage)localObject).senderuin != null) && (paramString.equals(((ChatMessage)localObject).senderuin))) {
          if ((((ChatMessage)localObject).istroop != 1000) && (((ChatMessage)localObject).istroop != 1020) && (((ChatMessage)localObject).istroop != 1004)) {
            break label167;
          }
        }
      }
    }
    label167:
    for (Object localObject = ((ChatMessage)localObject).frienduin;; localObject = ((ChatMessage)localObject).senderuin)
    {
      localViewHolder.a.setHeaderIcon(FaceDrawable.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject));
      i += 1;
      break label17;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      paramString1 = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString1.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.b(false);
      return;
    }
    this.a.b(false);
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if (!paramHashMap.containsKey(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
      {
        Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
        if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
        {
          paramHashMap = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
          localObject = AIOUtils.a((View)localObject);
          if ((paramHashMap != null) && (localObject != null) && (!((ChatMessage)localObject).isSendFromLocal()) && (((ChatMessage)localObject).istroop != 1) && (((ChatMessage)localObject).istroop != 3000))
          {
            FriendManager localFriendManager = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            paramHashMap.a.setHeaderIcon(FaceDrawable.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((ChatMessage)localObject).senderuin));
          }
        }
        i += 1;
      }
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((!paramBoolean) && (this.a.isResume())) {
      QQToast.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2130837949, this.a.getString(2131562192), 0).b(this.a.d());
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.k();
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    Set localSet = (Set)paramObject;
    int k = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label46:
    Object localObject1;
    label101:
    int j;
    if (i < k)
    {
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramObject);
        paramObject = AIOUtils.a(paramObject);
        if (!paramObject.isSend()) {
          break label232;
        }
        paramObject = paramObject.selfuin;
        Object localObject2 = (FriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if ((localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          paramObject = ((FriendManager)localObject2).a(paramObject);
          if (paramObject != null)
          {
            paramObject = Long.valueOf(paramObject.pendantId);
            if (paramObject != null)
            {
              if (paramObject.longValue() == 0L) {
                break label284;
              }
              localObject1 = ((BaseBubbleBuilder.ViewHolder)localObject1).a;
              localObject2 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              long l = paramObject.longValue();
              if (i == k) {
                break label278;
              }
              j = 1;
              label211:
              ((BaseChatItemLayout)localObject1).setPendantImage(AvatarPendantUtil.a((QQAppInterface)localObject2, l, j));
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label232:
      if ((paramObject.istroop == 1000) || (paramObject.istroop == 1020) || (paramObject.istroop == 1004))
      {
        paramObject = paramObject.frienduin;
        break label101;
      }
      paramObject = paramObject.senderuin;
      break label101;
      label278:
      j = 2;
      break label211;
      label284:
      if (((BaseBubbleBuilder.ViewHolder)localObject1).a.a != null)
      {
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.a.setImageDrawable(null);
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.a.setVisibility(8);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
      {
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramArrayOfString[i])))
          {
            ChatActivityFacade.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byn
 * JD-Core Version:    0.7.0.1
 */