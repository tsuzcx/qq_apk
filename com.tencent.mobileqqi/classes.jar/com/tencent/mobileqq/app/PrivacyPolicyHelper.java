package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fet;
import feu;
import fev;
import java.util.Locale;

public class PrivacyPolicyHelper
{
  public static final int a = 0;
  private static PrivacyPolicyHelper.MyLinkMovementMethod a;
  public static final String a = "PrivacyPolicyHelper";
  public static final int b = 1;
  public static final String b = "0";
  private static final int c = -12541697;
  public static final String c = "1";
  private static final int d = 2134941951;
  public static final String d = "0";
  public static final String e = "1";
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new PrivacyPolicyHelper.MyLinkMovementMethod();
    }
    return a;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131563388));
    Object localObject = Locale.getDefault().getLanguage();
    if ((((String)localObject).endsWith("cn")) || (((String)localObject).endsWith("zh")))
    {
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/mobile/terms/terms.html?language=ch_simple&lan=cn&lan=cn&lan=cn"), 114, 120, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/mobile/privacy/privacy.html?language=ch_simple&lan=cn&lan=cn&lan=cn"), 121, 127, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/mobile/privacy/privacy.html?language=ch_simple&lan=cn&lan=cn&lan=cn"), 128, 136, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 128, 136, 17);
    }
    for (;;)
    {
      paramString = new fet();
      localObject = new feu();
      paramContext = DialogUtil.d(paramContext, 0, paramContext.getString(2131563387), localSpannableString.toString(), 2131563386, 2131563385, (DialogInterface.OnClickListener)localObject, paramString);
      paramContext.setCanceledOnTouchOutside(false);
      paramContext.setCancelable(true);
      paramString = (TextView)paramContext.findViewById(2131231029);
      paramString.setText(localSpannableString);
      paramString.setTextSize(1, 13.0F);
      paramString.setHighlightColor(0);
      paramString.setMovementMethod(a());
      ((TextView)paramContext.findViewById(2131231473)).setTextColor(Color.parseColor("#40A0FF"));
      paramContext.show();
      return paramContext;
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/mobile/terms/terms.html?language=en_simple&lan=en&lan=en&lan=en"), 416, 433, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 416, 433, 17);
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/privacy/privacy_En.html"), 434, 449, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 434, 449, 17);
      localSpannableString.setSpan(new fev(paramContext, paramString, "https://www.imqq.com/privacy/privacy_En.html"), 453, 475, 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 453, 475, 17);
    }
  }
  
  public static String a()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void a()
  {
    a();
  }
  
  public static void a(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_state", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setPrivacyPolicyStatus, state=" + paramString);
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (b().equals("1")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "hasShowRedDotState, hasShow=" + bool);
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool3 = false;
    if (a().equals("0")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (paramInt == 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          if (!a()) {
            break label100;
          }
          bool1 = bool3;
        }
      }
      label100:
      for (;;)
      {
        bool2 = bool1;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PrivacyPolicyHelper", 2, "needShowPrivacyPolicy, needShow=" + bool2 + ", from=" + paramInt);
          }
          return bool2;
          bool2 = bool1;
          if (paramInt == 1)
          {
            bool2 = bool1;
            if (bool1)
            {
              b("1");
              bool2 = bool1;
            }
          }
        }
      }
    }
  }
  
  public static String b()
  {
    String str2 = SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static void b(String paramString)
  {
    SharePreferenceUtils.a(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setHasShowRedDotState, state=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrivacyPolicyHelper
 * JD-Core Version:    0.7.0.1
 */