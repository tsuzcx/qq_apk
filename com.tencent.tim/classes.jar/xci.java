import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.23;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import org.json.JSONObject;

public class xci
  extends wjd
{
  String aUJ = BaseApplication.getContext().getString(2131719350);
  protected boolean bgW;
  private long lastClickTime;
  
  public xci(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void A(TextView paramTextView)
  {
    Object localObject = this.mContext.getString(2131692844);
    int i = ((String)localObject).indexOf(paramTextView.getResources().getString(2131721238));
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new xdb(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void D(TextView paramTextView)
  {
    Object localObject = BaseApplicationImpl.getContext().getString(2131721550);
    String str = this.mContext.getString(2131721551);
    int j = ((String)localObject).length() + str.indexOf(acfp.m(2131707002));
    int i = j;
    if (j < 0) {
      i = 20;
    }
    localObject = new SpannableString(new SpannableString((String)localObject + str));
    ((SpannableString)localObject).setSpan(new xdl(this), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void E(TextView paramTextView) {}
  
  private void F(TextView paramTextView)
  {
    Object localObject = acfp.m(2131707003);
    int j = ((String)localObject).indexOf("Q");
    int i = j;
    if (j < 0) {
      i = 11;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new xdm(this), i, j + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  private CharSequence a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramBoolean)
    {
      str = acfp.m(2131707010) + paramString + acfp.m(2131707011);
      if (!paramBoolean) {
        break label130;
      }
    }
    label130:
    for (int i = acfp.m(2131707015).length();; i = acfp.m(2131707014).length())
    {
      int j = paramString.length();
      paramString = new SpannableString(str);
      paramString.setSpan(new xcs(this), i, i + j, 33);
      return paramString;
      str = acfp.m(2131707021) + paramString + acfp.m(2131707018);
      break;
    }
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
    paramString1.setSpan(new xde(this, paramString3, paramString4), paramInt, paramString2.length() + paramInt, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString1);
  }
  
  private void a(ChatMessage paramChatMessage, wjd.a parama, View paramView)
  {
    ahvw.a(paramChatMessage, parama, paramView);
  }
  
  private CharSequence b(CharSequence paramCharSequence)
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
  
  private void b(String paramString, TextView paramTextView)
  {
    int i = 0;
    int j = 0;
    Object localObject1 = null;
    String str1 = null;
    String str2 = null;
    int m = 0;
    String str3 = null;
    String str4 = null;
    int k = 0;
    String str6 = null;
    long l = 0L;
    do
    {
      Object localObject2;
      try
      {
        localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).has("sens_msg_id")) {
          continue;
        }
        i = ((JSONObject)localObject2).getInt("sens_msg_id");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if (((JSONObject)localObject2).has("sens_msg_attr")) {
        j = ((JSONObject)localObject2).getInt("sens_msg_attr");
      }
      paramString = (String)localObject1;
      if (((JSONObject)localObject2).has("sens_msg_status")) {
        paramString = ((JSONObject)localObject2).getString("sens_msg_status");
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (String str5 = "0";; str5 = paramString)
      {
        if (((JSONObject)localObject2).has("sens_msg_phoe")) {
          str1 = ((JSONObject)localObject2).getString("sens_msg_phoe");
        }
        if (((JSONObject)localObject2).has("sens_msg_senderuin")) {
          str2 = ((JSONObject)localObject2).getString("sens_msg_senderuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_peeruin")) {
          str3 = ((JSONObject)localObject2).getString("sens_msg_peeruin");
        }
        if (((JSONObject)localObject2).has("sens_msg_nickname")) {
          str4 = ((JSONObject)localObject2).getString("sens_msg_nickname");
        }
        if (((JSONObject)localObject2).has("sens_msg_istroop")) {
          k = ((JSONObject)localObject2).getInt("sens_msg_istroop");
        }
        if (((JSONObject)localObject2).has("sens_msg_troopuin")) {
          str6 = ((JSONObject)localObject2).getString("sens_msg_troopuin");
        }
        if (((JSONObject)localObject2).has("sens_msg_uniseq")) {
          l = ((JSONObject)localObject2).getLong("sens_msg_uniseq");
        }
        if (((JSONObject)localObject2).has("sens_msg_sessiontype")) {
          m = ((JSONObject)localObject2).getInt("sens_msg_sessiontype");
        }
        if (((JSONObject)localObject2).has("sens_msg_default_wording")) {}
        for (localObject2 = ((JSONObject)localObject2).getString("sens_msg_default_wording");; localObject2 = null)
        {
          localObject1 = null;
          paramString = null;
          Object localObject3 = (Bundle)aqfz.a().a("SensMsgTipsCfg", "TailWording", i, j);
          if (localObject3 != null)
          {
            localObject1 = ((Bundle)localObject3).getString("0");
            paramString = ((Bundle)localObject3).getString("1");
          }
          Bundle localBundle = (Bundle)aqfz.a().a("SensMsgTipsCfg", "Action", i, j);
          Object localObject4 = paramString;
          localObject3 = localObject1;
          if (localBundle != null)
          {
            Iterator localIterator = localBundle.keySet().iterator();
            for (;;)
            {
              localObject4 = paramString;
              localObject3 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (String)localIterator.next();
              localObject4 = localBundle.getBundle((String)localObject3).getString("Name");
              String str7 = "$" + (String)localObject3;
              localObject3 = localObject1;
              if (localObject1 != null)
              {
                localObject3 = localObject1;
                if (((String)localObject1).contains(str7)) {
                  localObject3 = ((String)localObject1).replace(str7, (CharSequence)localObject4);
                }
              }
              localObject1 = localObject3;
              if (paramString != null)
              {
                localObject1 = localObject3;
                if (paramString.contains(str7))
                {
                  paramString = paramString.replace(str7, (CharSequence)localObject4);
                  localObject1 = localObject3;
                }
              }
            }
          }
          paramString = (String)localObject4;
          if (str5.equalsIgnoreCase("0")) {
            paramString = (String)localObject3;
          }
          localObject1 = paramString;
          if (i == 2)
          {
            localObject1 = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              localObject1 = paramString;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            ThreadManager.post(new GrayTipsItemBuilder.23(this, str6, k, l, (String)localObject1), 5, null, false);
          }
          paramString = new SpannableString((CharSequence)localObject1);
          if (localBundle != null)
          {
            localObject2 = localBundle.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = localBundle.getBundle((String)((Iterator)localObject2).next());
              str5 = ((Bundle)localObject4).getString("Type");
              localObject3 = ((Bundle)localObject4).getString("Name");
              if ((((String)localObject1).indexOf((String)localObject3) >= 0) && ((!str5.equalsIgnoreCase("makePhoneCall")) || (!TextUtils.isEmpty(str1))))
              {
                localObject4 = new xdk(this, str5, str2, i, j, str1, (Bundle)localObject4, str3, k, l, str4, m, str6);
                int i1 = ((String)localObject1).indexOf((String)localObject3);
                int n = i1;
                if (i1 < 0) {
                  n = 0;
                }
                paramString.setSpan(localObject4, n, ((String)localObject3).length() + n, 33);
              }
            }
          }
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
    } while (i > 0);
  }
  
  private void d(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.msg)) || (paramTextView == null)) {}
    int i;
    do
    {
      return;
      int j = paramMessageRecord.msg.indexOf(acfp.m(2131707017));
      i = j;
      if (j < 0) {
        i = paramMessageRecord.msg.indexOf(acfp.m(2131707001));
      }
    } while (i < 0);
    SpannableString localSpannableString = new SpannableString(new SpannableString(paramMessageRecord.msg));
    localSpannableString.setSpan(new xci.f(this.app, this.mContext, paramMessageRecord), i, i + 4, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  private void f(TextView paramTextView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = acfp.m(2131707012);; paramString = paramString + acfp.m(2131707009))
    {
      String str = acfp.m(2131707000);
      Object localObject = acfp.m(2131706999);
      localObject = new SpannableString(paramString + str + (String)localObject);
      ((SpannableString)localObject).setSpan(new xdj(this), paramString.length(), (paramString + str).length(), 33);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public static String hu(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private void i(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
  }
  
  public void B(TextView paramTextView)
  {
    Object localObject = acfp.m(2131707016);
    int j = ((String)localObject).indexOf(acfp.m(2131707007));
    int i = j;
    if (j < 0) {
      i = 10;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new xci.d(this.app, this.mContext), i, j + 5, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  public void C(TextView paramTextView)
  {
    Object localObject = acfp.m(2131707006);
    String str = "为TA设置特别消息提示音," + (String)localObject;
    int i = "为TA设置特别消息提示音,".length();
    int j = ((String)localObject).length() + i;
    localObject = new SpannableString(str);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-15036176), i, j, 33);
    ((SpannableString)localObject).setSpan(new xci.e(this.app, this.mContext), 0, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    xci.a locala = (xci.a)parama;
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558954, null);
      locala.mTextView = ((TextView)paramView.findViewById(2131368123));
      localObject = locala.mTextView.getLayoutParams();
      localView = paramView;
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        localView = paramView;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != BaseChatItemLayout.bOg)
        {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = BaseChatItemLayout.bOg;
          localView = paramView;
        }
      }
    }
    locala.mTextView.setMovementMethod(null);
    locala.mTextView.setTextColor(localView.getResources().getColorStateList(2131167621));
    Object localObject = paramMessageRecord.msg;
    int i;
    switch (paramMessageRecord.msgtype)
    {
    default: 
      locala.mTextView.setText((CharSequence)localObject);
    case -1002: 
    case -1001: 
      for (;;)
      {
        if ((paramMessageRecord instanceof MessageForGrayTips))
        {
          i = ((MessageForGrayTips)paramMessageRecord).getTextGravity();
          locala.mTextView.setGravity(i);
          label652:
          a((ChatMessage)paramMessageRecord, parama, localView);
          locala.mTextView.setOnTouchListener(paramwlz);
          locala.mTextView.setOnLongClickListener(paramwlz);
          locala.mTextView.setMovementMethod(areu.getInstance());
          return localView;
          paramView = null;
          if ((paramMessageRecord instanceof MessageForSafeGrayTips))
          {
            if (QLog.isColorLevel()) {
              QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
            }
            paramView = (MessageForSafeGrayTips)paramMessageRecord;
          }
          a(paramView, locala.mTextView);
          continue;
          if ((localObject != null) && (((String)localObject).length() > 0) && (((String)localObject).charAt(0) == '\026'))
          {
            paramView = ((String)localObject).split("\\|");
            label772:
            if ((paramView == null) || (paramView.length <= 0)) {
              break label4081;
            }
          }
        }
      }
    }
    label1072:
    label1114:
    label3181:
    label4081:
    for (paramView = paramView[0].trim();; paramView = (View)localObject)
    {
      locala.mTextView.setText(paramView);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      if ((paramView != null) && (paramView.equals(this.mContext.getString(2131698058))))
      {
        paramLinearLayout = aqmj.i(this.app.getCurrentUin());
        if (!paramLinearLayout.getBoolean(VideoConstants.Ml, false))
        {
          localObject = new SpannableStringBuilder(locala.mTextView.getText().toString());
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(-14782465), 0, 8, 33);
          locala.mTextView.setText((CharSequence)localObject);
          localObject = new xcj(this, paramMessageRecord.uniseq);
          locala.mTextView.setClickable(true);
          locala.mTextView.setOnClickListener((View.OnClickListener)localObject);
          paramLinearLayout.edit().putLong("qav_score_msg_uniseq", paramMessageRecord.uniseq).commit();
        }
      }
      if (paramView == null) {
        break;
      }
      boolean bool1 = paramView.equals(this.mContext.getString(2131697896));
      boolean bool2 = paramView.equals(this.mContext.getString(2131721729));
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "MessageRecord.MSG_TYPE_TEXT_VIDEO isEqualNotAccept:=" + bool1 + ",isEqualNetWorkBroken:=" + bool2);
      }
      if ((!bool1) && (!bool2)) {
        break;
      }
      if (bool1)
      {
        i = 1;
        paramView = new SpannableStringBuilder(locala.mTextView.getText().toString());
        paramLinearLayout = new ForegroundColorSpan(-14782465);
        if (!bool1) {
          break label1188;
        }
        j = 8;
        if (!bool1) {
          break label1195;
        }
      }
      for (int k = 14;; k = 15)
      {
        paramView.setSpan(paramLinearLayout, j, k, 33);
        locala.mTextView.setText(paramView);
        paramView = new xda(this, paramMessageRecord, i);
        locala.mTextView.setClickable(true);
        locala.mTextView.setOnClickListener(paramView);
        break;
        paramView = null;
        break label772;
        i = 2;
        break label1072;
        j = 9;
        break label1114;
      }
      paramView = new aofk((CharSequence)localObject, 1);
      locala.mTextView.setText(paramView);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      if (paramMessageRecord.istroop == 0)
      {
        i(locala.mTextView, (String)localObject);
        break;
      }
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        locala.mTextView.setText(paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView));
        locala.mTextView.setClickable(true);
        locala.mTextView.setFocusable(true);
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      locala.mTextView.setText((CharSequence)localObject);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      locala.mTextView.setText(a((String)localObject, true));
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      locala.mTextView.setText(a((String)localObject, false));
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForSafeGrayTips");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        locala.mTextView.setText(paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView));
        locala.mTextView.setClickable(true);
        locala.mTextView.setFocusable(true);
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      locala.mTextView.setText((CharSequence)localObject);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      paramView = String.format((String)localObject, new Object[] { this.sessionInfo.aTn });
      locala.mTextView.setText(paramView);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      locala.mTextView.setText(b((CharSequence)localObject));
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      paramView = BaseApplicationImpl.getContext().getString(2131693546) + "\"" + (String)localObject + "\"";
      locala.mTextView.setText(paramView);
      break;
      locala.mTextView.setText((CharSequence)localObject);
      break;
      paramView = this.mContext.getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      paramLinearLayout = paramView.getString("renewal_tail_click_text", null);
      i = paramView.getInt("renewal_tail_action", -1);
      int j = paramView.getInt("renewal_tail_tip_exit", -1);
      String str1 = paramView.getString("renewal_tail_activity_url", null);
      k = paramView.getInt("renewal_tail_item_id", -1);
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "MSG_TYPE_RENEWAL_TAIL_TIP, action=" + i + ", msg=" + (String)localObject + ", clickText=" + paramLinearLayout + ", expireFlag=" + j + ", activityUrl=" + str1);
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramLinearLayout)))
      {
        paramView = ahav.a((String)localObject, paramLinearLayout, new xdn(this, i, k, str1, j));
        locala.mTextView.setText(paramView);
      }
      for (;;)
      {
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        locala.mTextView.setHighlightColor(17170445);
        break;
        QLog.e("GrayTipsItemBuilder", 1, "MSG_TYPE_RENEWAL_TAIL_TIP msg or clickText empty");
      }
      x(locala.mTextView);
      break;
      y(locala.mTextView);
      break;
      D(locala.mTextView);
      break;
      locala.mTextView.setText(this.mContext.getString(2131721548));
      break;
      z(locala.mTextView);
      break;
      e(locala.mTextView, (String)localObject);
      break;
      paramView = ahav.a(BaseApplicationImpl.getContext().getString(2131700475), BaseApplicationImpl.getContext().getString(2131700474), new xdo(this));
      locala.mTextView.setText(paramView);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setHighlightColor(17170445);
      break;
      paramLinearLayout = this.mContext.getString(2131700521);
      paramView = paramLinearLayout;
      if (!((String)localObject).contains(paramLinearLayout)) {
        paramView = this.mContext.getString(2131700484);
      }
      paramView = ahav.a((String)localObject, paramView, new xdp(this));
      locala.mTextView.setText(paramView);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setHighlightColor(17170445);
      break;
      paramView = ahav.a((String)localObject, this.mContext.getString(2131691407), new xdq(this, paramMessageRecord.getExtInfoFromExtStr("bat_process_tips_last_file_type")));
      locala.mTextView.setText(paramView);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setHighlightColor(17170445);
      break;
      paramView = ahav.a((String)localObject, this.mContext.getString(2131693859), new xdr(this));
      locala.mTextView.setText(paramView);
      paramView = ((String)localObject).replace("TIM", "t i m");
      locala.mTextView.setContentDescription(paramView);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setHighlightColor(17170445);
      break;
      f(locala.mTextView, paramMessageRecord.extStr);
      break;
      paramView = ((MessageForGrayTips)paramMessageRecord).getExtInfoFromExtStr("approval_subtype");
      paramLinearLayout = this.mContext.getString(2131690446);
      localObject = new SpannableString(paramLinearLayout);
      ((SpannableString)localObject).setSpan(new xds(this, paramView), 0, paramLinearLayout.length(), 33);
      locala.mTextView.setHighlightColor(17170445);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText((CharSequence)localObject);
      break;
      i = paramMessageRecord.extraflag;
      j = ((String)localObject).indexOf(paramMessageRecord.extStr);
      paramView = new SpannableString((CharSequence)localObject);
      paramView.setSpan(new xdt(this, i), j, paramMessageRecord.extStr.length() + j, 33);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText(paramView);
      break;
      c(locala.mTextView, paramMessageRecord);
      break;
      A(locala.mTextView);
      break;
      paramView = ((String)localObject).split("\\|");
      if (paramView.length != 5) {
        break;
      }
      a(locala.mTextView, paramView[0], paramView[1], Integer.parseInt(paramView[2]), paramView[3], paramView[4]);
      break;
      B(locala.mTextView);
      break;
      F(locala.mTextView);
      break;
      paramView = paramMessageRecord.msg;
      if (paramView == null) {
        break;
      }
      g(locala.mTextView, paramView);
      break;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView msgtype:-5000 istroop:" + paramMessageRecord.istroop + " msg:" + aqft.pk((String)localObject));
      }
      if (!(paramMessageRecord instanceof MessageForNewGrayTips)) {
        break;
      }
      paramView = (MessageForNewGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramView.buildTextView(this.app, locala.mTextView);
      break;
      E(locala.mTextView);
      break;
      if (!(paramMessageRecord instanceof MessageForIncompatibleGrayTips)) {
        break;
      }
      paramView = (MessageForIncompatibleGrayTips)paramMessageRecord;
      localObject = paramView.url;
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "getItemView MessageForIncompatibleGrayTips");
      }
      paramLinearLayout = new SpannableString(paramView.msg);
      localObject = new xck(this, (String)localObject);
      paramLinearLayout.setSpan(new ForegroundColorSpan(2131167522), paramView.linkStart, paramView.linkEnd, 33);
      paramLinearLayout.setSpan(localObject, paramView.linkStart, paramView.linkEnd, 33);
      locala.mTextView.setText(paramLinearLayout);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setHighlightColor(17170445);
      break;
      paramView = null;
      if ((paramMessageRecord instanceof MessageForGrayTips))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "getItemView MSG_TYPE_CONFIGURABLE_GRAY_TIPS");
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
      }
      if (paramView != null)
      {
        locala.mTextView.setText(paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView));
        locala.mTextView.setClickable(true);
        locala.mTextView.setFocusable(true);
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        break;
      }
      locala.mTextView.setText((CharSequence)localObject);
      break;
      C(locala.mTextView);
      break;
      h(locala.mTextView, (String)localObject);
      break;
      b(locala.mTextView, paramMessageRecord);
      break;
      if ((paramMessageRecord instanceof MessageForNearbyMarketGrayTips))
      {
        paramView = ((MessageForNearbyMarketGrayTips)paramMessageRecord).getHightlightMsgText(this.app, paramLinearLayout.getContext());
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        locala.mTextView.setText(paramView);
        if (!ajpc.a(paramMessageRecord, "isFaceScoreGrayTips")) {
          break;
        }
        if (ajpc.a(paramMessageRecord, "isFaceScoreSecondMember"))
        {
          paramView = "2";
          if (!ajpc.a(paramMessageRecord, "isFaceScoreSpecialLike")) {
            break label3181;
          }
        }
        for (paramLinearLayout = "2";; paramLinearLayout = "1")
        {
          ajpc.b("exp_grey", paramMessageRecord.frienduin, new String[] { paramView, "", "", paramLinearLayout });
          break;
          paramView = "1";
          break label3123;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("GrayTipsItemBuilder", 2, "nearby market gray tips msg is not validate");
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = acfp.m(2131706997);
      paramView = ahav.a(paramView.msg + paramLinearLayout, paramLinearLayout, new xcl(this));
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = acfp.m(2131707005);
      paramView = ahav.a(paramView.msg + paramLinearLayout, paramLinearLayout, new xco(this));
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      if ((paramView == null) || (paramView.msg.length() <= 0)) {
        break;
      }
      paramLinearLayout = acfp.m(2131707008);
      paramView = ahav.a(paramView.msg + paramLinearLayout + acfp.m(2131706998), paramLinearLayout, new xcp(this));
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForQQWalletTips)) {
        break;
      }
      ((MessageForQQWalletTips)paramMessageRecord).buildQQWalletTips(this.app, this.mContext, locala.mTextView);
      break;
      locala.mTextView.setText((CharSequence)localObject);
      locala.mTextView.setOnTouchListener(paramwlz);
      locala.mTextView.setOnLongClickListener(paramwlz);
      break;
      if (!(paramMessageRecord instanceof MessageForGrayTips)) {
        break;
      }
      paramView = (MessageForGrayTips)paramMessageRecord;
      locala.mTextView.setText(paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView));
      locala.mTextView.setClickable(true);
      locala.mTextView.setFocusable(true);
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if (!(paramMessageRecord instanceof ShareHotChatGrayTips)) {
        break;
      }
      paramView = ((ShareHotChatGrayTips)paramMessageRecord).getHighlightMsgText(this.app, paramLinearLayout.getContext());
      locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      locala.mTextView.setText(paramView);
      break;
      if (!(paramMessageRecord instanceof MessageForDeliverGiftTips)) {
        break;
      }
      ((MessageForDeliverGiftTips)paramMessageRecord).buildDeliverGiftTips(this.app, this.mContext, locala.mTextView);
      break;
      a(paramMessageRecord, locala.mTextView);
      break;
      paramLinearLayout = aquv.a();
      str1 = paramLinearLayout.c(paramMessageRecord.isSend(), this.sessionInfo.cZ);
      String str2 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_open_url");
      String str3 = paramMessageRecord.getExtInfoFromExtStr("aio_vip_keyword");
      paramView = paramMessageRecord.getExtInfoFromExtStr("aio_vip_tips_highlight");
      i = ((String)localObject).indexOf(paramView);
      paramView.length();
      if (i == -1) {
        paramView = "";
      }
      for (;;)
      {
        paramView = ahav.a((String)localObject, paramView, new xcq(this, str2, str1, paramMessageRecord, str3, paramLinearLayout));
        locala.mTextView.setText(paramView);
        if (aTl) {
          locala.mTextView.setContentDescription(paramView);
        }
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        locala.mTextView.setHighlightColor(17170445);
        break;
        paramView = aquu.a().M(this.app);
        i = ((String)localObject).indexOf(paramView);
        paramView.length();
        if (i == -1) {}
        paramView = ahav.a((String)localObject, paramView, new xcr(this));
        locala.mTextView.setText(paramView);
        if (aTl) {
          locala.mTextView.setContentDescription(paramView);
        }
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        locala.mTextView.setHighlightColor(17170445);
        VasWebviewUtil.reportVipKeywords("", "2", "", "", "", "", "", "", "", "");
        break;
        if (!(paramMessageRecord instanceof MessageForGrayTips)) {
          break;
        }
        paramView = (MessageForGrayTips)paramMessageRecord;
        locala.mTextView.setText(paramView.getHightlightMsgText(this.app, paramLinearLayout.getContext(), false, locala.mTextView));
        locala.mTextView.setClickable(true);
        locala.mTextView.setFocusable(true);
        locala.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
        break;
        d(locala.mTextView, paramMessageRecord);
        break;
        locala.mTextView.setGravity(19);
        break label652;
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xci.a();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 890)
    {
      if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForQQWalletTips))) {}
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof xci.a)));
        paramView = (xci.a)paramView;
        paramChatMessage = (MessageForQQWalletTips)paramChatMessage;
      } while ((this.app == null) || (this.mContext == null) || (paramView.mTextView == null));
      paramChatMessage.buildQQWalletTips(this.app, this.mContext, paramView.mTextView);
      return;
    }
    super.a(paramView, paramChatMessage, paramInt);
  }
  
  void a(MessageForSafeGrayTips paramMessageForSafeGrayTips, TextView paramTextView)
  {
    aqfz.a().bf(this.app, "SensMsgTipsCfg");
    if ((paramMessageForSafeGrayTips == null) || (paramMessageForSafeGrayTips.safeInfo == null)) {
      return;
    }
    int j = 0;
    if (paramMessageForSafeGrayTips.safeInfo.strFromMobile.has()) {}
    for (String str1 = paramMessageForSafeGrayTips.safeInfo.strFromMobile.get();; str1 = null)
    {
      if (paramMessageForSafeGrayTips.safeInfo.strFromName.has()) {}
      for (String str2 = paramMessageForSafeGrayTips.safeInfo.strFromName.get();; str2 = null)
      {
        int i = j;
        if (paramMessageForSafeGrayTips.safeInfo.strMsgTxt.has()) {}
        try
        {
          i = Integer.parseInt(paramMessageForSafeGrayTips.safeInfo.strMsgTxt.get());
          aqfz.a().f(null, "SensMsgTipsCfg", null, null);
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("sens_msg_id", 2);
            localJSONObject.put("sens_msg_attr", i);
            localJSONObject.put("sens_msg_status", "0");
            localJSONObject.put("sens_msg_phoe", str1);
            localJSONObject.put("sens_msg_fromname", str2);
            localJSONObject.put("sens_msg_senderuin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_sessiontype", this.sessionInfo.cZ);
            localJSONObject.put("sens_msg_peeruin", paramMessageForSafeGrayTips.senderuin);
            localJSONObject.put("sens_msg_nickname", this.sessionInfo.aTn);
            localJSONObject.put("sens_msg_troopuin", this.sessionInfo.aTl);
            localJSONObject.put("sens_msg_istroop", paramMessageForSafeGrayTips.istroop);
            localJSONObject.put("sens_msg_uniseq", paramMessageForSafeGrayTips.uniseq);
            localJSONObject.put("sens_msg_default_wording", this.aUJ);
            b(localJSONObject.toString(), paramTextView);
            return;
          }
          catch (Exception paramMessageForSafeGrayTips)
          {
            paramMessageForSafeGrayTips.printStackTrace();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = j;
          }
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, TextView paramTextView)
  {
    try
    {
      paramMessageRecord = (MessageForGrayTips)paramMessageRecord;
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText(paramMessageRecord.getHightlightMsgText(this.app, this.mContext, false, paramTextView));
      paramTextView.setGravity(3);
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  public aqob[] a(View paramView)
  {
    return new aqoa().a();
  }
  
  public void b(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype != -1046) {}
    do
    {
      do
      {
        return;
        long l1 = -1L;
        try
        {
          long l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("sens_msg_uniseq"));
          l1 = l2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            int n;
            int j;
            boolean bool2;
            try
            {
              localObject3 = new bankcode_info.BankcodeCtrlInfo();
              j = k;
              ((bankcode_info.BankcodeCtrlInfo)localObject3).mergeFrom(aqhs.hexStr2Bytes((String)localObject5));
              i = k;
              j = k;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.has())
              {
                j = k;
                i = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_id.get();
              }
              j = i;
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.has())
              {
                j = i;
                paramMessageRecord = ((bankcode_info.BankcodeCtrlInfo)localObject3).fromuin_phonenum.get();
              }
            }
            catch (Exception localException4)
            {
              MessageRecord localMessageRecord2;
              int i1;
              int i3;
              int i2;
              Object localObject1;
              Object localObject5;
              Object localObject3;
              int m;
              boolean bool1;
              boolean bool3;
              k = 0;
              localMessageRecord1 = null;
              paramMessageRecord = null;
              localObject2 = null;
              int i = j;
              j = k;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.has()) {
                localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_url.get();
              }
            }
            catch (Exception localException5)
            {
              j = 0;
              localMessageRecord1 = null;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = localObject6;
              continue;
            }
            try
            {
              if (((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.has()) {
                localObject2 = ((bankcode_info.BankcodeCtrlInfo)localObject3).msgtail_conf_file_md5.get();
              }
              m = i1;
            }
            catch (Exception localException6)
            {
              j = 0;
              localObject6 = null;
              localObject2 = paramMessageRecord;
              paramMessageRecord = localObject6;
              continue;
              bool2 = false;
              continue;
              String str = "0";
              continue;
              k = j;
              continue;
              k = 0;
              continue;
            }
            try
            {
              localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_attr");
              m = i1;
              bool1 = TextUtils.isEmpty((CharSequence)localObject5);
              if (bool1) {
                continue;
              }
              try
              {
                k = Integer.parseInt((String)localObject5);
                localObject3 = localObject2;
                j = k;
                localObject2 = localObject1;
                localObject1 = localObject3;
                if (j != 20) {
                  break label1042;
                }
                bool1 = true;
                localObject3 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_need_mask");
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  bool1 = Boolean.parseBoolean((String)localObject3);
                }
                if ((n == 0) && (bool1)) {
                  break label1042;
                }
                localObject3 = "1";
                bool3 = false;
                bool1 = false;
                bool2 = bool3;
                try
                {
                  localObject5 = paramTextView.getTag(2131378037);
                  if (localObject5 != null)
                  {
                    bool2 = bool3;
                    bool1 = ((Boolean)localObject5).booleanValue();
                  }
                  bool2 = bool1;
                  localObject5 = paramTextView.getTag(2131378036);
                  if (localObject5 == null) {
                    break label1036;
                  }
                  bool2 = bool1;
                  bool3 = ((Boolean)localObject5).booleanValue();
                  bool2 = bool3;
                }
                catch (Exception localException7)
                {
                  Object localObject4;
                  localException7.printStackTrace();
                  bool3 = false;
                  bool1 = bool2;
                  bool2 = bool3;
                  continue;
                }
                if ((!bool1) && (((String)localObject3).equalsIgnoreCase("0")))
                {
                  anot.a(this.app, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Mask", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131378037, Boolean.valueOf(true));
                }
                if ((!bool2) && (((String)localObject3).equalsIgnoreCase("1")))
                {
                  anot.a(this.app, "P_CliOper", "Safe_SensMsg", localMessageRecord2.senderuin, "Tips_Show", "Show", i, j, Long.toString(localMessageRecord2.msgUid), Long.toString(localMessageRecord2.uniseq), "", "");
                  paramTextView.setTag(2131378036, Boolean.valueOf(true));
                }
                aqfz.a().f(null, "SensMsgTipsCfg", (String)localObject2, (String)localObject1);
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("sens_msg_id", i);
                  ((JSONObject)localObject1).put("sens_msg_attr", j);
                  ((JSONObject)localObject1).put("sens_msg_status", localObject3);
                  ((JSONObject)localObject1).put("sens_msg_phoe", paramMessageRecord);
                  ((JSONObject)localObject1).put("sens_msg_senderuin", localMessageRecord2.senderuin);
                  ((JSONObject)localObject1).put("sens_msg_sessiontype", this.sessionInfo.cZ);
                  ((JSONObject)localObject1).put("sens_msg_peeruin", this.sessionInfo.aTl);
                  ((JSONObject)localObject1).put("sens_msg_nickname", this.sessionInfo.aTn);
                  ((JSONObject)localObject1).put("sens_msg_troopuin", this.sessionInfo.troopUin);
                  ((JSONObject)localObject1).put("sens_msg_istroop", localMessageRecord2.istroop);
                  ((JSONObject)localObject1).put("sens_msg_uniseq", localMessageRecord2.uniseq);
                  b(((JSONObject)localObject1).toString(), paramTextView);
                  return;
                }
                catch (Exception paramTextView)
                {
                  paramTextView.printStackTrace();
                  return;
                }
                localException1 = localException1;
                localException1.printStackTrace();
              }
              catch (Exception localException2)
              {
                m = i1;
                localException2.printStackTrace();
                k = i2;
                continue;
              }
              localException3.printStackTrace();
            }
            catch (Exception localException3)
            {
              j = m;
              localObject5 = localObject2;
              localObject2 = paramMessageRecord;
              paramMessageRecord = (MessageRecord)localObject5;
            }
            localObject4 = localException1;
            localObject5 = localObject2;
            MessageRecord localMessageRecord1 = paramMessageRecord;
            Object localObject2 = localObject4;
            paramMessageRecord = (MessageRecord)localObject5;
            continue;
            int k = i2;
            m = i1;
            if (((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.has())
            {
              m = i1;
              localObject4 = ((bankcode_info.BankcodeCtrlInfo)localObject4).bankcode_elems.get().iterator();
              j = i3;
              k = j;
              m = j;
              if (((Iterator)localObject4).hasNext())
              {
                m = j;
                localObject5 = (bankcode_info.BankcodeElem)((Iterator)localObject4).next();
                m = j;
                if (((bankcode_info.BankcodeElem)localObject5).bankcode_attr.has())
                {
                  m = j;
                  k = ((bankcode_info.BankcodeElem)localObject5).bankcode_attr.get();
                  if (k > j)
                  {
                    j = k;
                    continue;
                  }
                }
                Object localObject6;
                n = 0;
              }
            }
          }
        }
        localMessageRecord2 = this.app.b().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, l1);
      } while (localMessageRecord2 == null);
      paramMessageRecord = localMessageRecord2.getExtInfoFromExtStr("sens_msg_confirmed");
      if ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equalsIgnoreCase("1"))) {
        break label1063;
      }
      n = 1;
      k = -1;
      i1 = 0;
      i3 = 0;
      i2 = 0;
      paramMessageRecord = null;
      localObject1 = null;
      localObject2 = null;
      localObject5 = localMessageRecord2.getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty((CharSequence)localObject5));
    j = k;
  }
  
  public void c(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (TextUtils.isEmpty(paramMessageRecord.extStr)) {}
    do
    {
      return;
      paramMessageRecord = paramMessageRecord.extStr.split(":");
    } while (paramMessageRecord.length < 2);
    paramMessageRecord = String.format("你当前所在WiFi：%s，%s人正在热聊，", new Object[] { paramMessageRecord[0], paramMessageRecord[1] });
    String str = acfp.m(2131707020);
    SpannableString localSpannableString = new SpannableString(paramMessageRecord + str);
    localSpannableString.setSpan(new xci.b(this.app, this.mContext), paramMessageRecord.length(), (paramMessageRecord + str).length(), 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  void e(TextView paramTextView, String paramString)
  {
    String str1 = null;
    Object localObject;
    String str2;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject = paramString.split("\\$");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTipMsg", 2, "splitResult is:" + Arrays.toString((Object[])localObject));
      }
      str2 = "";
      if (localObject.length >= 1)
      {
        if (!localObject[0].startsWith("ver=")) {
          break label207;
        }
        str2 = localObject[0].split("\\=")[1];
      }
      if (!str2.equals("1")) {
        break label215;
      }
      paramString = localObject[0];
      str1 = paramTextView.getResources().getString(2131721238);
    }
    for (;;)
    {
      label125:
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        localObject = str1;
        if (str1 == null) {
          localObject = "";
        }
        int i = paramString.indexOf((String)localObject);
        if ((str2.equals("1")) && (i < 0)) {
          i = paramString.indexOf(paramTextView.getResources().getString(2131721238));
        }
        for (;;)
        {
          if ((localObject == null) || (((String)localObject).trim().length() == 0) || (i < 0))
          {
            paramTextView.setText(paramString);
            return;
            label207:
            str2 = "1";
            break;
            label215:
            if (!str2.equals("2")) {
              break label305;
            }
            if (localObject.length >= 3)
            {
              paramString = localObject[1];
              str1 = localObject[2];
              break label125;
            }
            paramString = localObject[1];
            break label125;
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new xcx(this), i, ((String)localObject).length() + i, 33);
          paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
          paramTextView.setText(paramString);
          return;
        }
      }
      label305:
      paramString = null;
    }
  }
  
  public void g(TextView paramTextView, String paramString)
  {
    int j = paramString.indexOf(acfp.m(2131707004)) - 1;
    int k = paramString.indexOf(acfp.m(2131707019)) + 1;
    int i = j;
    if (j < 0) {
      i = 10;
    }
    paramString = new SpannableString(paramString);
    paramString.setSpan(new xci.c(this.app, this.mContext, this.sessionInfo.aTl), i, k, 33);
    paramString.setSpan(new ForegroundColorSpan(-14782465), i, k, 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(paramString);
  }
  
  public void h(TextView paramTextView, String paramString)
  {
    paramTextView.setClickable(true);
    paramTextView.setText("" + "" + paramString);
  }
  
  void x(TextView paramTextView)
  {
    paramTextView.setText(BaseApplicationImpl.getContext().getString(2131720356));
    paramTextView.setContentDescription(BaseApplicationImpl.getContext().getString(2131720356));
  }
  
  void y(TextView paramTextView)
  {
    SpannableString localSpannableString = ahav.a(BaseApplicationImpl.getContext().getString(2131720354), BaseApplicationImpl.getContext().getString(2131720355), new xct(this));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setContentDescription(localSpannableString);
    if (QLog.isColorLevel()) {
      QLog.d("GrayTipsItemBuilder", 2, "handleSingleWayFriendAddAllowTipsItem hasReportAddAllowShow：" + this.bgW + "  this:" + this);
    }
    if (!this.bgW)
    {
      anot.a(this.app, "dc00898", "", this.sessionInfo.aTl, "0X800994B", "0X800994B", 0, 0, "", "", "", "");
      this.bgW = true;
    }
  }
  
  void z(TextView paramTextView)
  {
    Object localObject = this.mContext.getString(2131700694);
    String str = paramTextView.getResources().getString(2131721238);
    int i = ((String)localObject).indexOf(str);
    if (i < 0)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new xcu(this), i, str.length() + i, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject);
  }
  
  class a
    extends wjd.a
  {
    TextView mTextView;
    
    a() {}
  }
  
  static class b
    extends ClickableSpan
  {
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    
    b(QQAppInterface paramQQAppInterface, Context paramContext)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      if (((this.eh.get() instanceof Activity)) && (paramView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsItemBuilder", 2, "handleHotChatToSeeTip span click ");
        }
        HotChatManager.w(null, false);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(-14782465);
    }
  }
  
  class c
    extends ClickableSpan
  {
    public final String aUU = "mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3";
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    private String uin;
    
    c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
      this.uin = paramString;
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      Object localObject = (Context)this.eh.get();
      if ((paramView == null) || (localObject == null)) {}
      long l;
      do
      {
        do
        {
          return;
        } while (!(localObject instanceof Activity));
        if (!aqiw.isNetSupport((Context)localObject))
        {
          QQToast.a((Context)localObject, 2131693404, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299627));
          return;
        }
        l = System.currentTimeMillis();
        if ((xci.a(xci.this) == 0L) || (l <= xci.a(xci.this)) || (l - xci.a(xci.this) > 800L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
      return;
      xci.a(xci.this, l);
      localObject = aqik.c(paramView, (Context)localObject, String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3", new Object[] { this.uin }));
      if (localObject != null) {
        ((aqhv)localObject).ace();
      }
      anot.a(paramView, "CliOper", "", "", "0X80055FD", "0X80055FD", 0, 0, akkw.a(paramView)[0], this.uin, "", "");
    }
  }
  
  class d
    extends ClickableSpan
  {
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    
    d(QQAppInterface paramQQAppInterface, Context paramContext)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      Object localObject = (Context)this.eh.get();
      if ((paramView == null) || (localObject == null)) {}
      long l;
      do
      {
        do
        {
          return;
        } while (!(localObject instanceof Activity));
        if (!aqiw.isNetSupport((Context)localObject))
        {
          QQToast.a((Context)localObject, 2131693404, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299627));
          return;
        }
        l = System.currentTimeMillis();
        if ((xci.a(xci.this) == 0L) || (l <= xci.a(xci.this)) || (l - xci.a(xci.this) > 800L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
      return;
      xci.a(xci.this, l);
      if (aqiw.isWifiConnected((Context)localObject))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString(aryv.PARAM_SNG_APPID, "100868074");
        localBundle.putString(aryv.PARAM_URL, "https://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
        localBundle.putString(aryv.PARAM_TASK_PACKNAME, "com.sohu.inputmethod.sogou");
        localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
        localBundle.putString(aryv.PARAM_VIA, "ANDROIDQQ.MSG.SOUGOU");
        localBundle.putString(aryv.PARAM_APPNAME, acfp.m(2131707013));
        localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
        aryr.d((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
      }
      for (;;)
      {
        anot.a(paramView, "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
        return;
        localObject = aqik.c(paramView, (Context)localObject, "qapp://detail?param=" + xci.hu("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU"));
        if (localObject != null) {
          ((aqhv)localObject).ace();
        }
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(-14782465);
    }
  }
  
  class e
    extends ClickableSpan
  {
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    
    e(QQAppInterface paramQQAppInterface, Context paramContext)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      Context localContext = (Context)this.eh.get();
      if ((paramView == null) || (localContext == null)) {}
      while (!(localContext instanceof Activity)) {
        return;
      }
      if (!aqiw.isNetSupport(localContext))
      {
        QQToast.a(localContext, 2131693404, 0).show(localContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      Intent localIntent = new Intent(localContext, QQSpecialCareSettingActivity.class);
      localIntent.putExtra("key_friend_uin", xci.this.sessionInfo.aTl);
      localContext.startActivity(localIntent);
      VipUtils.a(paramView, "Vip_SpecialRemind", "0X8005057", "0X8005057", 0, 1, new String[0]);
    }
    
    public void updateDrawState(TextPaint paramTextPaint) {}
  }
  
  static class f
    extends ClickableSpan
  {
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    private MessageRecord messageRecord;
    
    f(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
      this.messageRecord = paramMessageRecord;
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      Object localObject = (Context)this.eh.get();
      if ((paramView == null) || (localObject == null)) {}
      boolean bool;
      do
      {
        do
        {
          do
          {
            return;
            anot.a(paramView, "dc00898", "", "", "0X800906D", "0X800906D", 0, 0, "", "", "", "");
          } while (!(localObject instanceof Activity));
          if (!aqiw.isNetSupport((Context)localObject))
          {
            QQToast.a((Context)localObject, 2131693404, 0).show(((Context)localObject).getResources().getDimensionPixelSize(2131299627));
            return;
          }
        } while ((this.messageRecord == null) || (this.eh.get() == null));
        localObject = this.messageRecord.getExtInfoFromExtStr("key_team_work_ext_info_new_url");
        bool = Boolean.parseBoolean(this.messageRecord.getExtInfoFromExtStr("team_work_is_message_convert"));
      } while (TextUtils.isEmpty((CharSequence)localObject));
      Bundle localBundle = new Bundle();
      localBundle.putString("url", (String)localObject);
      localBundle.putString("tdsourcetag", "s_qq_aio_grey");
      TeamWorkDocEditBrowserActivity.a((Context)this.eh.get(), localBundle, false);
      if (!bool)
      {
        anot.a(paramView, "CliOper", "", "", "0X8008A35", "0X8008A35", 0, 0, "", "", "", "");
        return;
      }
      anot.a(paramView, "CliOper", "", "", "0X8009075", "0X8009075", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xci
 * JD-Core Version:    0.7.0.1
 */