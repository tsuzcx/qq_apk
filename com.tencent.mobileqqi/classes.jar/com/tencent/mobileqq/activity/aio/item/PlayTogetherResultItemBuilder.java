package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo;
import com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import java.util.ArrayList;
import java.util.List;

public class PlayTogetherResultItemBuilder
  extends AbstractChatItemBuilder
  implements View.OnClickListener
{
  public static final String b = "PlayTogetherResult";
  
  public PlayTogetherResultItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(ChatMessage paramChatMessage, String paramString, ImageView paramImageView)
  {
    if ((paramImageView == null) || (paramString == null)) {
      return;
    }
    int j = paramChatMessage.istroop;
    int i = 1;
    if (j == 1006) {
      i = 11;
    }
    paramImageView.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramString));
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage.mNeedTimeStamp = true;
    return super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForPlayTogetherResult)paramMessageRecord;
    paramOnLongClickAndTouchListener = paramLinearLayout.getMsgInfo();
    if (paramOnLongClickAndTouchListener == null) {}
    Object localObject;
    int j;
    int i;
    int k;
    do
    {
      do
      {
        do
        {
          return paramView;
          localObject = (PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)paramViewHolder;
          paramMessageRecord = paramView;
          if (paramView == null)
          {
            paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903112, null);
            ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).jdField_b_of_type_AndroidViewView = paramViewHolder.findViewById(2131231252);
            ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131231253));
            ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).c = ((TextView)paramViewHolder.findViewById(2131231254));
            paramMessageRecord = paramViewHolder;
            if (((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).a == null)
            {
              ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).a = new ArrayList();
              paramMessageRecord = ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).a;
              paramMessageRecord.add(paramViewHolder.findViewById(2131231255));
              paramMessageRecord.add(paramViewHolder.findViewById(2131231256));
              paramMessageRecord.add(paramViewHolder.findViewById(2131231257));
              paramMessageRecord.add(paramViewHolder.findViewById(2131231258));
              paramMessageRecord.add(paramViewHolder.findViewById(2131231259));
              paramMessageRecord = paramViewHolder;
            }
          }
          paramViewHolder = ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).jdField_b_of_type_AndroidViewView;
          paramViewHolder.setOnClickListener(this);
          j = paramViewHolder.getId();
          i = j;
          if (j == -1)
          {
            i = 2131231252;
            paramViewHolder.setId(2131231252);
          }
          paramViewHolder.setTag(i, paramOnLongClickAndTouchListener);
          ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(paramOnLongClickAndTouchListener.mGameName);
          if ((paramOnLongClickAndTouchListener.mSubHeading != null) && (paramOnLongClickAndTouchListener.mCallerNick != null)) {
            ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).c.setText(paramOnLongClickAndTouchListener.mSubHeading.replaceAll("\\{nick\\}", paramOnLongClickAndTouchListener.mCallerNick));
          }
          paramView = paramMessageRecord;
        } while (paramOnLongClickAndTouchListener.mUinInfos == null);
        paramView = paramMessageRecord;
      } while (((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).a == null);
      paramViewHolder = paramOnLongClickAndTouchListener.mUinInfos;
      paramOnLongClickAndTouchListener = ((PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder)localObject).a;
      j = paramOnLongClickAndTouchListener.size();
      k = paramViewHolder.size();
      i = 0;
      paramView = paramMessageRecord;
    } while (i >= j);
    paramView = (View)paramOnLongClickAndTouchListener.get(i);
    if (i < k)
    {
      localObject = (MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)paramViewHolder.get(i);
      ((TextView)paramView.findViewById(2131231260)).setText(String.valueOf(((MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)localObject).mGrade));
      ImageView localImageView = (ImageView)paramView.findViewById(2131231261);
      a(paramLinearLayout, String.valueOf(((MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)localObject).mUin), localImageView);
      ((TextView)paramView.findViewById(2131231262)).setText(((MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)localObject).mNickName);
      ((TextView)paramView.findViewById(2131231263)).setText(((MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo)localObject).mScore);
      paramView.setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break;
      paramView.setVisibility(8);
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new PlayTogetherResultItemBuilder.PlayTogetherResultViewHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == -1) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag(i);
      } while (!MessageForPlayTogetherResult.PlayTogetherResultInfo.class.isInstance(paramView));
      paramView = ((MessageForPlayTogetherResult.PlayTogetherResultInfo)paramView).mMoreInfo;
    } while (paramView == null);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    localIntent.putExtra("url", paramView.trim());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PlayTogetherResultItemBuilder
 * JD-Core Version:    0.7.0.1
 */