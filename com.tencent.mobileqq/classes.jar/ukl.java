import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ukl
{
  private static String a(String paramString)
  {
    String str = "0";
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = String.format("%.3f", new Object[] { Float.valueOf((float)Long.parseLong(paramString) * 1.0F / 1048576.0F) });
      }
      return str;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener, SpannableStringBuilder paramSpannableStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755829);
    localQQCustomDialog.setContentView(2131559019);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.dp2px(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    localQQCustomDialog.setMessage(paramSpannableStringBuilder);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setPositiveButton(paramString2, new ukm(paramOnClickListener));
    localQQCustomDialog.setNegativeButton(paramString3, new ukn(paramOnClickListener));
    localQQCustomDialog.show();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.gameAdComData == null)) {
      return;
    }
    String str1;
    SpannableStringBuilder localSpannableStringBuilder;
    String str2;
    if (!paramBoolean1)
    {
      str1 = anvx.a(2131712404);
      if (!a(paramAdvertisementInfo.gameAdComData.m).equals("0")) {
        str1 = String.format(anvx.a(2131712273), new Object[] { a(paramAdvertisementInfo.gameAdComData.m) });
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
        str1 = paramAdvertisementInfo.gameAdComData.y;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = anvx.a(2131712531);
        String str5 = "#E06F00";
        String str3 = str5;
        str2 = str4;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.z))
        {
          str3 = str5;
          str2 = str4;
          if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.A))
          {
            str2 = paramAdvertisementInfo.gameAdComData.z;
            str3 = paramAdvertisementInfo.gameAdComData.A;
          }
        }
        if (str1.contains(str2))
        {
          int i = str1.indexOf(str2);
          int j = str2.length();
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), i, j + i, 33);
        }
      }
      str1 = anvx.a(2131712528);
      if (paramBoolean2) {
        str1 = anvx.a(2131712499);
      }
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.w)) {
        break label363;
      }
      str1 = paramAdvertisementInfo.gameAdComData.w;
    }
    label363:
    for (;;)
    {
      str2 = anvx.a(2131712190);
      if (bhfn.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.d)) {
        str2 = anvx.a(2131712335);
      }
      if (paramBoolean2) {}
      for (paramAdvertisementInfo = anvx.a(2131712459);; paramAdvertisementInfo = anvx.a(2131712164))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdvertisementInfo);
        return;
        str1 = anvx.a(2131712382);
        if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.x)) {
          break;
        }
        str1 = paramAdvertisementInfo.gameAdComData.x;
        break;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anvx.a(2131712274));
    String str2 = anvx.a(2131712432);
    String str1 = anvx.a(2131712189);
    if (bhfn.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = anvx.a(2131712468);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, anvx.a(2131712582));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(anvx.a(2131712446), new Object[] { a(paramString1) }));
    String str = anvx.a(2131712351);
    paramString1 = anvx.a(2131712595);
    if (bhfn.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = anvx.a(2131712563);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, anvx.a(2131712321));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukl
 * JD-Core Version:    0.7.0.1
 */