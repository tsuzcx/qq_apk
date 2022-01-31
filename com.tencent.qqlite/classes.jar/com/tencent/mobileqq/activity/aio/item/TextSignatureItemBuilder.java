package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bxk;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;

public class TextSignatureItemBuilder
  extends AbstractChatItemBuilder
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  TextSignatureItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private CharSequence a(String paramString1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray)
  {
    paramString3 = this.jdField_a_of_type_JavaLangStringBuilder;
    paramString3.setLength(0);
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      paramString3.append(paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      paramString3.append(paramString2);
    }
    int j = Integer.parseInt(paramString4);
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      i = 0;
      while (i < j)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      i = j;
      while (i < k)
      {
        paramString4 = paramJSONArray.optString(i);
        if ((paramString4 != null) && (paramString4.length() > 0)) {
          paramString3.append(paramString4);
        }
        i += 1;
      }
    }
    paramString4 = new SpannableString(paramString3.toString());
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        i = paramString1.length() + paramString2.length();
        paramString4.setSpan(new ForegroundColorSpan(-16754769), 0, i, 33);
      }
    }
    for (;;)
    {
      paramString3.setLength(0);
      return paramString4;
      i = paramString2.length();
      break;
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        paramString4.setSpan(new ForegroundColorSpan(-8947849), 0, paramString1.length(), 33);
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "icon" + paramInt;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "cover" + paramString2;
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject2 = (MessageForRichState)paramMessageRecord;
    paramLinearLayout = (bxk)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903096, null);
      paramLinearLayout.b = ((TextView)paramMessageRecord.findViewById(2131296734));
      paramLinearLayout.c = ((TextView)paramMessageRecord.findViewById(2131296741));
      paramLinearLayout.d = ((TextView)paramMessageRecord.findViewById(2131296740));
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramMessageRecord.findViewById(2131296739));
      paramLinearLayout.e = ((TextView)paramMessageRecord.findViewById(2131296738));
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    }
    paramMessageRecord.setContentDescription(null);
    paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.length(), "");
    paramLinearLayout.b.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    paramLinearLayout.jdField_a_of_type_Long = ((MessageForRichState)localObject2).uniseq;
    paramLinearLayout.jdField_a_of_type_JavaLangString = ((MessageForRichState)localObject2).frienduin;
    paramLinearLayout.jdField_a_of_type_Int = ((MessageForRichState)localObject2).istroop;
    paramViewHolder = ((MessageForRichState)localObject2).ver;
    long l;
    Object localObject1;
    label331:
    String str2;
    if ((paramViewHolder != null) && (paramViewHolder.equals("1.0")))
    {
      l = ((MessageForRichState)localObject2).time;
      paramView = ((MessageForRichState)localObject2).actionText;
      paramOnLongClickAndTouchListener = ((MessageForRichState)localObject2).dataText;
      localObject1 = ((MessageForRichState)localObject2).plainText;
      String str1 = ((MessageForRichState)localObject2).locText;
      localObject2 = ((MessageForRichState)localObject2).locPos;
      if (l <= 0L) {
        break label506;
      }
      paramViewHolder = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, 1000L * l);
      paramLinearLayout.c.setVisibility(0);
      paramLinearLayout.c.setText(paramViewHolder);
      if ((str1 == null) || (str1.trim().length() <= 0)) {
        break label531;
      }
      paramLinearLayout.d.setVisibility(0);
      paramLinearLayout.d.setText(str1);
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      str2 = Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 10);
      paramLinearLayout.b.setText(str2 + "更新了签名");
      localObject1 = a(paramView, paramOnLongClickAndTouchListener, str1, (String)localObject2, (JSONArray)localObject1);
      paramLinearLayout.e.setText((CharSequence)localObject1);
      if ((paramOnLongClickAndTouchListener == null) || (paramOnLongClickAndTouchListener.length() <= 0)) {
        break label564;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AIOSign", 2, "bindViewForTextSignature(),dataText is illegal,dataText is:" + paramOnLongClickAndTouchListener);
      }
    }
    for (;;)
    {
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append(str2);
      if (l > 0L) {
        paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append("于").append(paramViewHolder);
      }
      paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.append("更新了签名，内容是：").append((CharSequence)localObject1);
      paramMessageRecord.setContentDescription(paramLinearLayout.jdField_a_of_type_JavaLangStringBuilder.toString());
      return paramMessageRecord;
      label506:
      paramLinearLayout.c.setVisibility(8);
      paramLinearLayout.c.setText("");
      paramViewHolder = null;
      break;
      label531:
      paramLinearLayout.d.setVisibility(8);
      paramLinearLayout.d.setText("");
      paramLinearLayout.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label331;
      label564:
      if ((paramView != null) && (paramView.length() > 0) && (QLog.isColorLevel())) {
        QLog.e("AIOSign", 2, "bindViewForTextSignature(),actionText is illegal,actionText is:" + paramView);
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bxk(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextSignatureItemBuilder
 * JD-Core Version:    0.7.0.1
 */