package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import eds;
import edt;
import edu;
import edv;
import edw;
import edx;
import eea;
import eeb;
import eec;
import eed;
import eee;
import eef;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class GrayTipsItemBuilder
  extends AbstractChatItemBuilder
{
  private static final String b = "GrayTipsItemBuilder";
  
  public GrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    Pattern localPattern = Pattern.compile("<a.*?/a>");
    paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
    int i = 0;
    while (paramCharSequence.find(i))
    {
      Object localObject3 = Pattern.compile(">.*?</a>").matcher(paramCharSequence.group());
      Object localObject1 = null;
      while (((Matcher)localObject3).find())
      {
        localObject2 = ((Matcher)localObject3).group().replaceAll(">|</a>", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "标题：" + (String)localObject2);
          localObject1 = localObject2;
        }
      }
      Matcher localMatcher = Pattern.compile("href=.*?>").matcher(paramCharSequence.group());
      Object localObject2 = null;
      while (localMatcher.find())
      {
        localObject3 = localMatcher.group().replaceAll("href=|>", "");
        localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("GrayTipsItemBuilder", 2, "网址：" + (String)localObject3);
          localObject2 = localObject3;
        }
      }
      if ((localObject1 != null) && (localObject2 != null))
      {
        localSpannableStringBuilder.replace(paramCharSequence.start(), paramCharSequence.end(), localObject1);
        localSpannableStringBuilder.setSpan(new URLSpan((String)localObject2), paramCharSequence.start(), paramCharSequence.start() + localObject1.length(), 33);
        i = paramCharSequence.start() + localObject1.length();
        paramCharSequence = localPattern.matcher(localSpannableStringBuilder);
        paramCharSequence.reset();
      }
    }
    return localSpannableStringBuilder;
  }
  
  private void a(TextView paramTextView, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramString1.length() < paramInt)
    {
      paramTextView.setText(new SpannableString(paramString1));
      return;
    }
    paramString1 = new StringBuilder(paramString1);
    paramString1.insert(paramInt, paramString2);
    paramString1 = new SpannableString(paramString1.toString());
    paramString1.setSpan(new eee(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void b(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558890);; paramString = paramString + this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558891))
    {
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558892);
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558893);
      localObject = new SpannableString(paramString + str + (String)localObject);
      ((SpannableString)localObject).setSpan(new edt(this), paramString.length(), (paramString + str).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  private void c(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131563103);
    int i = ((String)localObject).indexOf(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558889));
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558889).length();
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new eed(this), i, j + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void d(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131563246);
    int j = ((String)localObject).indexOf(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558888));
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558888).length();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new edu(this), i, k + j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = null;
    eef localeef = (eef)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903131, null);
      localeef.b = ((TextView)paramViewHolder.findViewById(2131231357));
    }
    localeef.b.setMovementMethod(null);
    localeef.b.setTextColor(paramViewHolder.getResources().getColorStateList(2131361809));
    localeef.b.setGravity(17);
    paramView = paramMessageRecord.msg;
    String str1 = LocaleString.k(this.jdField_a_of_type_AndroidContentContext, paramView);
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localeef.b.setText(str1);
      return paramViewHolder;
    case -1002: 
      if ((paramMessageRecord instanceof MessageForSafeGrayTips)) {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
      }
      break;
    }
    for (paramMessageRecord = (MessageForSafeGrayTips)paramMessageRecord;; paramMessageRecord = null)
    {
      String str2 = "";
      String str3 = "";
      paramLinearLayout = str3;
      paramView = str2;
      if (paramMessageRecord != null)
      {
        paramLinearLayout = str3;
        paramView = str2;
        if (paramMessageRecord.safeInfo != null)
        {
          paramView = paramMessageRecord.safeInfo.strFromMobile.get();
          paramLinearLayout = paramMessageRecord.safeInfo.strFromName.get();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "strFromMobile" + paramView);
      }
      a(str1, paramView, paramLinearLayout, localeef.b);
      localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      return paramViewHolder;
      paramMessageRecord = paramLinearLayout;
      if (str1 != null)
      {
        paramMessageRecord = paramLinearLayout;
        if (str1.length() > 0)
        {
          paramMessageRecord = paramLinearLayout;
          if (str1.charAt(0) == '\026') {
            paramMessageRecord = str1.split("\\|");
          }
        }
      }
      if ((paramMessageRecord != null) && (paramMessageRecord.length > 0)) {}
      for (paramMessageRecord = paramMessageRecord[0].trim();; paramMessageRecord = str1)
      {
        localeef.b.setText(paramMessageRecord);
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        localeef.b.setText(str1);
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        if (paramMessageRecord.istroop == 0)
        {
          d(localeef.b);
          return paramViewHolder;
        }
        localeef.b.setText(str1);
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        localeef.b.setText(str1);
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        paramMessageRecord = String.format(str1, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
        localeef.b.setText(paramMessageRecord);
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        localeef.b.setText(a(str1));
        localeef.b.setGravity(3);
        localeef.b.setMovementMethod(LinkMovementMethod.getInstance());
        localeef.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localeef.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return paramViewHolder;
        paramMessageRecord = BaseApplicationImpl.getContext().getString(2131558773) + "\"" + str1 + "\"";
        localeef.b.setText(paramMessageRecord);
        return paramViewHolder;
        localeef.b.setText(str1);
        return paramViewHolder;
        a(localeef.b);
        return paramViewHolder;
        b(localeef.b);
        return paramViewHolder;
        a(localeef.b, str1);
        return paramViewHolder;
        paramMessageRecord = FileManagerUtil.a(BaseApplicationImpl.getContext().getString(2131560926), BaseApplicationImpl.getContext().getString(2131560927), new eds(this));
        localeef.b.setText(paramMessageRecord);
        localeef.b.setMovementMethod(LinkMovementMethod.getInstance());
        localeef.b.setHighlightColor(17170445);
        return paramViewHolder;
        paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131560934);
        paramMessageRecord = paramView;
        if (!str1.contains(paramView)) {
          paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131560935);
        }
        paramMessageRecord = FileManagerUtil.a(str1, paramMessageRecord, new edv(this));
        localeef.b.setText(paramMessageRecord);
        localeef.b.setMovementMethod(LinkMovementMethod.getInstance());
        localeef.b.setHighlightColor(17170445);
        return paramViewHolder;
        b(localeef.b, paramMessageRecord.extStr);
        return paramViewHolder;
        c(localeef.b);
        return paramViewHolder;
        paramMessageRecord = str1.split("\\|");
        if (paramMessageRecord.length != 5) {
          break;
        }
        a(localeef.b, paramMessageRecord[0], paramMessageRecord[1], Integer.parseInt(paramMessageRecord[2]), paramMessageRecord[3], paramMessageRecord[4]);
        return paramViewHolder;
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new eef(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131234872) {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  void a(TextView paramTextView)
  {
    String str = BaseApplicationImpl.getContext().getString(2131563239) + "\n";
    SpannableString localSpannableString = new SpannableString(str + BaseApplicationImpl.getContext().getString(2131562347));
    localSpannableString.setSpan(new eea(this), str.length(), localSpannableString.length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131563239) + "点击两次" + BaseApplicationImpl.getContext().getString(2131562347));
  }
  
  void a(TextView paramTextView, String paramString)
  {
    String str = null;
    Object localObject;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = paramString.split("\\$");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "splitResult is:" + Arrays.toString((Object[])localObject));
      }
      paramString = "";
      if (localObject.length >= 1)
      {
        if (!localObject[0].startsWith("ver=")) {
          break label184;
        }
        paramString = localObject[0].split("\\=")[1];
      }
      if (!paramString.equals("1")) {
        break label191;
      }
      str = localObject[0];
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558888);
    }
    for (;;)
    {
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = paramString;
      if (paramString == null) {
        str = "";
      }
      int i = ((String)localObject).indexOf(str);
      if ((str == null) || (str.trim().length() == 0) || (i < 0))
      {
        paramTextView.setText((CharSequence)localObject);
        return;
        label184:
        paramString = "1";
        break;
        label191:
        if (!paramString.equals("2")) {
          break label278;
        }
        if (localObject.length >= 3)
        {
          str = localObject[1];
          paramString = localObject[2];
          continue;
        }
        str = localObject[1];
        paramString = null;
        continue;
      }
      paramString = new SpannableString((CharSequence)localObject);
      paramString.setSpan(new eec(this), i, str.length() + i, 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramString);
      return;
      label278:
      paramString = null;
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, TextView paramTextView)
  {
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131562603) + "";
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131562768) + "";
    paramString1 = paramString1 + "";
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i;
    int j;
    if (!TextUtils.isEmpty(str2))
    {
      i = paramString1.indexOf(str2);
      if (i >= 0)
      {
        j = str2.length();
        localSpannableString.setSpan(new edw(this), i, j + i, 33);
      }
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str1)))
    {
      i = paramString1.indexOf(str1);
      if (i >= 0)
      {
        j = str1.length();
        localSpannableString.setSpan(new edx(this, paramString3, paramString2), i, j + i, 33);
      }
    }
    paramTextView.setText(localSpannableString);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
  
  void b(TextView paramTextView)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131562213);
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558888);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new eeb(this), i, str.length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */