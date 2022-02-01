import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aciu
{
  private static aciu.b a;
  private static boolean bII;
  
  public static void Ew(String paramString)
  {
    aqfe.J(BaseApplication.getContext(), "privacypolicy_state", paramString);
    QLog.d("PrivacyPolicyHelper", 1, "setPrivacyPolicyStatus, state=" + paramString);
  }
  
  public static void Ex(String paramString)
  {
    aqfe.J(BaseApplication.getContext(), "privacypolicy_show_reddot", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "setHasShowRedDotState, state=" + paramString);
    }
  }
  
  public static MovementMethod a()
  {
    if (a == null) {
      a = new aciu.b();
    }
    return a;
  }
  
  public static aqju a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null, null);
  }
  
  public static aqju a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131701505));
    localSpannableString.setSpan(new aciu.a(paramContext, paramString, "https://ti.qq.com/tim/serverinfo.html"), 114, 120, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 114, 120, 17);
    localSpannableString.setSpan(new aciu.a(paramContext, paramString, "https://tim.qq.com/timapp/agreement/tim_privacy_guid_ios.html"), 121, 127, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 121, 127, 17);
    localSpannableString.setSpan(new aciu.a(paramContext, paramString, "https://tim.qq.com/timapp/agreement/tim_privacy_desc.html"), 128, 136, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(-12541697), 128, 136, 17);
    paramString = new aciv(paramOnClickListener1);
    paramOnClickListener1 = new aciw(paramOnClickListener2);
    paramContext = aqha.a(paramContext, 0, paramContext.getString(2131701507), localSpannableString.toString(), 2131701506, 2131701504, paramOnClickListener1, paramString);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramString = (TextView)paramContext.findViewById(2131365863);
    paramString.setText(localSpannableString);
    paramString.setTextSize(1, 13.0F);
    paramString.setHighlightColor(0);
    paramString.setMovementMethod(a());
    ((TextView)paramContext.findViewById(2131365858)).setTextColor(Color.parseColor("#40A0FF"));
    paramContext.show();
    return paramContext;
  }
  
  public static boolean abf()
  {
    if ((!bII) && (rF().equals("1"))) {
      bII = true;
    }
    return bII;
  }
  
  public static boolean abg()
  {
    boolean bool = false;
    if (rG().equals("1")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrivacyPolicyHelper", 2, "hasShowRedDotState, hasShow=" + bool);
    }
    return bool;
  }
  
  public static void b(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    paramRedTouch.c(localRedTypeInfo);
  }
  
  public static void cKZ()
  {
    rF();
  }
  
  public static boolean ix(int paramInt)
  {
    boolean bool3 = false;
    if (rF().equals("0")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      if (paramInt == 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          if (!abg()) {
            break label102;
          }
          bool1 = bool3;
        }
      }
      label102:
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
              Ex("1");
              bool2 = bool1;
            }
          }
        }
      }
    }
  }
  
  public static String rF()
  {
    String str2 = aqfe.get(BaseApplication.getContext(), "privacypolicy_state");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  public static String rG()
  {
    String str2 = aqfe.get(BaseApplication.getContext(), "privacypolicy_show_reddot");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "0";
    }
    return str1;
  }
  
  static class a
    extends ClickableSpan
  {
    Context context;
    String uin;
    String url;
    
    public a(Context paramContext, String paramString1, String paramString2)
    {
      this.url = paramString2;
      this.context = paramContext;
      this.uin = paramString1;
    }
    
    public void onClick(View paramView)
    {
      try
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(this.url));
        this.context.startActivity(paramView);
        return;
      }
      catch (Exception paramView)
      {
        QLog.d("PrivacyPolicyHelper", 1, "no system browser exp=", paramView);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
    }
  }
  
  public static class b
    extends LinkMovementMethod
  {
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      if ((i == 1) || (i == 0))
      {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramTextView.getTotalPaddingLeft();
        int n = paramTextView.getTotalPaddingTop();
        int i1 = paramTextView.getScrollX();
        int i2 = paramTextView.getScrollY();
        Object localObject = paramTextView.getLayout();
        j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
        localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
        if (localObject.length != 0)
        {
          if (i == 1)
          {
            localObject[0].onClick(paramTextView);
            paramSpannable.setSpan(new ForegroundColorSpan(-12541697), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
          }
          for (;;)
          {
            return true;
            if (i == 0)
            {
              paramSpannable.setSpan(new ForegroundColorSpan(2134941951), paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]), 33);
              Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject[0]), paramSpannable.getSpanEnd(localObject[0]));
            }
          }
        }
        Selection.removeSelection(paramSpannable);
      }
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aciu
 * JD-Core Version:    0.7.0.1
 */