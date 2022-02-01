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

public class twk
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
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755826);
    localQQCustomDialog.setContentView(2131558992);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.dp2px(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localQQCustomDialog.getMessageTextView().setLayoutParams(localLayoutParams);
    localQQCustomDialog.setMessage(paramSpannableStringBuilder);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setPositiveButton(paramString2, new twl(paramOnClickListener));
    localQQCustomDialog.setNegativeButton(paramString3, new twm(paramOnClickListener));
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
      str1 = amtj.a(2131712057);
      if (!a(paramAdvertisementInfo.gameAdComData.m).equals("0")) {
        str1 = String.format(amtj.a(2131711926), new Object[] { a(paramAdvertisementInfo.gameAdComData.m) });
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
        str1 = paramAdvertisementInfo.gameAdComData.y;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = amtj.a(2131712184);
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
      str1 = amtj.a(2131712181);
      if (paramBoolean2) {
        str1 = amtj.a(2131712152);
      }
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.w)) {
        break label363;
      }
      str1 = paramAdvertisementInfo.gameAdComData.w;
    }
    label363:
    for (;;)
    {
      str2 = amtj.a(2131711843);
      if (bfwv.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.d)) {
        str2 = amtj.a(2131711988);
      }
      if (paramBoolean2) {}
      for (paramAdvertisementInfo = amtj.a(2131712112);; paramAdvertisementInfo = amtj.a(2131711817))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdvertisementInfo);
        return;
        str1 = amtj.a(2131712035);
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(amtj.a(2131711927));
    String str2 = amtj.a(2131712085);
    String str1 = amtj.a(2131711842);
    if (bfwv.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = amtj.a(2131712121);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, amtj.a(2131712235));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(amtj.a(2131712099), new Object[] { a(paramString1) }));
    String str = amtj.a(2131712004);
    paramString1 = amtj.a(2131712248);
    if (bfwv.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = amtj.a(2131712216);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, amtj.a(2131711974));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twk
 * JD-Core Version:    0.7.0.1
 */