package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import buv;
import buw;
import bux;
import buy;
import buz;
import bvc;
import bvd;
import bve;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

public class GrayTipsItemBuilder
  extends AbstractChatItemBuilder
{
  private static final String b = "GrayTipsItemBuilder";
  private long a;
  
  public GrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Long = 0L;
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
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramBoolean)
    {
      str = "通过" + paramString + "加的新朋友，一起聊聊吧！";
      if (!paramBoolean) {
        break label115;
      }
    }
    label115:
    for (int i = "通过".length();; i = "对方通过".length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new bux(this), i, i + j, 33);
      return paramString;
      str = "对方通过" + paramString + "加你为好友，一起聊聊吧！";
      break;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
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
    paramString1.setSpan(new bvc(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void c(TextView paramTextView)
  {
    paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131362800));
  }
  
  private void d(TextView paramTextView) {}
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    String str2 = null;
    bve localbve = (bve)paramViewHolder;
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903110, null);
      localbve.b = ((TextView)localView.findViewById(2131296827));
    }
    localbve.b.setMovementMethod(null);
    localbve.b.setTextColor(localView.getResources().getColorStateList(2131427339));
    localbve.b.setGravity(17);
    String str1 = paramMessageRecord.msg;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      localbve.b.setText(str1);
      return localView;
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
      paramLinearLayout = "";
      str2 = "";
      paramView = str2;
      paramViewHolder = paramLinearLayout;
      if (paramMessageRecord != null)
      {
        paramView = str2;
        paramViewHolder = paramLinearLayout;
        if (paramMessageRecord.safeInfo != null)
        {
          paramViewHolder = paramMessageRecord.safeInfo.strFromMobile.get();
          paramView = paramMessageRecord.safeInfo.strFromName.get();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "strFromMobile" + paramViewHolder);
      }
      a(str1, paramViewHolder, paramView, localbve.b);
      localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      return localView;
      paramMessageRecord = str2;
      if (str1 != null)
      {
        paramMessageRecord = str2;
        if (str1.length() > 0)
        {
          paramMessageRecord = str2;
          if (str1.charAt(0) == '\026') {
            paramMessageRecord = str1.split("\\|");
          }
        }
      }
      if ((paramMessageRecord != null) && (paramMessageRecord.length > 0)) {}
      for (paramMessageRecord = paramMessageRecord[0].trim();; paramMessageRecord = str1)
      {
        localbve.b.setText(paramMessageRecord);
        localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return localView;
        localbve.b.setText(str1);
        localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
        localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
        return localView;
        if (paramMessageRecord.istroop == 0)
        {
          c(localbve.b);
          return localView;
        }
        if ((paramMessageRecord instanceof MessageForGrayTips)) {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
          }
        }
        for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
        {
          if (paramMessageRecord != null)
          {
            localbve.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
            localbve.b.setClickable(true);
            localbve.b.setFocusable(true);
            localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
            return localView;
          }
          localbve.b.setText(str1);
          localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          localbve.b.setText(a(str1, true));
          localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          localbve.b.setText(a(str1, false));
          localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
          localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
          return localView;
          if ((paramMessageRecord instanceof MessageForGrayTips)) {
            if (QLog.isColorLevel()) {
              QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
            }
          }
          for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
          {
            if (paramMessageRecord != null)
            {
              localbve.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
              localbve.b.setClickable(true);
              localbve.b.setFocusable(true);
              localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
              return localView;
            }
            localbve.b.setText(str1);
            localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            paramMessageRecord = String.format(str1, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
            localbve.b.setText(paramMessageRecord);
            localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            localbve.b.setText(a(str1));
            localbve.b.setGravity(3);
            localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
            localbve.b.setOnTouchListener(paramOnLongClickAndTouchListener);
            localbve.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
            return localView;
            paramMessageRecord = BaseApplicationImpl.getContext().getString(2131362034) + "\"" + str1 + "\"";
            localbve.b.setText(paramMessageRecord);
            return localView;
            localbve.b.setText(str1);
            return localView;
            paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131364328);
            paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getString(2131364329);
            paramLinearLayout = this.jdField_a_of_type_AndroidContentContext.getString(2131364330);
            paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getString(2131364331);
            paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131364327);
            if (str1.contains(paramLinearLayout))
            {
              paramView = "CJCLUBT";
              paramViewHolder = paramMessageRecord;
              paramMessageRecord = paramLinearLayout;
            }
            for (;;)
            {
              paramMessageRecord = FileManagerUtil.a(str1, paramMessageRecord, new buv(this, paramViewHolder, paramView));
              localbve.b.setText(paramMessageRecord);
              localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
              localbve.b.setHighlightColor(17170445);
              return localView;
              if (str1.contains(paramViewHolder))
              {
                paramLinearLayout = "CJCLUBT";
                paramView = paramMessageRecord;
                paramMessageRecord = paramViewHolder;
                paramViewHolder = paramView;
                paramView = paramLinearLayout;
              }
              else
              {
                paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getString(2131364280);
                if (str1.contains(paramView))
                {
                  paramLinearLayout = "LTMCLUB";
                  paramViewHolder = paramMessageRecord;
                  paramMessageRecord = paramView;
                  paramView = paramLinearLayout;
                }
                else
                {
                  if (str1.contains(paramOnLongClickAndTouchListener))
                  {
                    paramView = "LTMCLUB";
                    paramViewHolder = paramMessageRecord;
                    paramMessageRecord = paramOnLongClickAndTouchListener;
                    continue;
                    a(localbve.b);
                    return localView;
                    paramMessageRecord = str1.split("\\|");
                    if (paramMessageRecord.length != 5) {
                      break;
                    }
                    a(localbve.b, paramMessageRecord[0], paramMessageRecord[1], Integer.parseInt(paramMessageRecord[2]), paramMessageRecord[3], paramMessageRecord[4]);
                    return localView;
                    b(localbve.b);
                    return localView;
                    if (QLog.isColorLevel()) {
                      QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + Utils.a(str1));
                    }
                    if ((paramMessageRecord instanceof MessageForNewGrayTips)) {}
                    for (paramMessageRecord = (MessageForNewGrayTips)paramMessageRecord; (paramMessageRecord != null) && (paramMessageRecord.msg.length() > 0); paramMessageRecord = null)
                    {
                      paramViewHolder = new SpannableString(paramMessageRecord.msg);
                      if ((paramMessageRecord.spans != null) && (paramMessageRecord.spans.size() != 0))
                      {
                        paramMessageRecord = paramMessageRecord.spans.iterator();
                        while (paramMessageRecord.hasNext())
                        {
                          paramView = (GrayTipsSpan)paramMessageRecord.next();
                          try
                          {
                            paramViewHolder.setSpan(new URLSpan(paramView.url), paramView.begin, paramView.end, 33);
                          }
                          catch (Exception paramView)
                          {
                            paramView.printStackTrace();
                          }
                        }
                      }
                      localbve.b.setText(paramViewHolder);
                      localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
                      return localView;
                      d(localbve.b);
                      return localView;
                      if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
                        break;
                      }
                      paramMessageRecord = (MessageForIncompatibleGrayTips)paramMessageRecord;
                      paramView = paramMessageRecord.url;
                      if (QLog.isColorLevel()) {
                        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
                      }
                      paramViewHolder = new SpannableString(paramMessageRecord.msg);
                      paramView = new buw(this, paramView);
                      paramViewHolder.setSpan(new ForegroundColorSpan(2131427331), paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
                      paramViewHolder.setSpan(paramView, paramMessageRecord.linkStart, paramMessageRecord.linkEnd, 33);
                      localbve.b.setText(paramViewHolder);
                      localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
                      localbve.b.setHighlightColor(17170445);
                      return localView;
                      if ((paramMessageRecord instanceof MessageForGrayTips)) {
                        if (QLog.isColorLevel()) {
                          QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
                        }
                      }
                      for (paramMessageRecord = (MessageForGrayTips)paramMessageRecord;; paramMessageRecord = null)
                      {
                        if (paramMessageRecord != null)
                        {
                          localbve.b.setText(paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext()));
                          localbve.b.setClickable(true);
                          localbve.b.setFocusable(true);
                          localbve.b.setMovementMethod(LinkMovementMethod.getInstance());
                          return localView;
                        }
                        localbve.b.setText(str1);
                        return localView;
                      }
                    }
                  }
                  paramView = "LTMCLUB";
                  paramViewHolder = paramMessageRecord;
                  paramMessageRecord = "";
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new bve(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131298983) {
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
  }
  
  void a(TextView paramTextView)
  {
    String str = BaseApplicationImpl.getContext().getString(2131364313) + "\n";
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(str);
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131364313));
  }
  
  void a(String paramString1, String paramString2, String paramString3, TextView paramTextView)
  {
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131363589) + "";
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131363590) + "";
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
        localSpannableString.setSpan(new buy(this), i, j + i, 33);
      }
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str1)))
    {
      i = paramString1.indexOf(str1);
      if (i >= 0)
      {
        j = str1.length();
        localSpannableString.setSpan(new buz(this, paramString3, paramString2), i, j + i, 33);
      }
    }
    paramTextView.setText(localSpannableString);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
  
  public void b(TextView paramTextView)
  {
    int j = "想要打字更快，试试搜狗输入法吧。".indexOf("搜");
    int i = j;
    if (j < 0) {
      i = 10;
    }
    SpannableString localSpannableString = new SpannableString("想要打字更快，试试搜狗输入法吧。");
    localSpannableString.setSpan(new bvd(this), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */