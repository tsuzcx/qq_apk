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

public class tps
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
    bhpc localbhpc = new bhpc(paramContext, 2131755824);
    localbhpc.setContentView(2131558984);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localbhpc.getMessageTextView().getLayoutParams();
    localLayoutParams.leftMargin = agej.a(30.0F, paramContext.getResources());
    localLayoutParams.rightMargin = agej.a(30.0F, paramContext.getResources());
    localLayoutParams.width = -1;
    localbhpc.getMessageTextView().setLayoutParams(localLayoutParams);
    localbhpc.setMessage(paramSpannableStringBuilder);
    localbhpc.setTitle(paramString1);
    localbhpc.setPositiveButton(paramString2, new tpt(paramOnClickListener));
    localbhpc.setNegativeButton(paramString3, new tpu(paramOnClickListener));
    localbhpc.show();
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
      str1 = anzj.a(2131711825);
      if (!a(paramAdvertisementInfo.gameAdComData.m).equals("0")) {
        str1 = String.format(anzj.a(2131711694), new Object[] { a(paramAdvertisementInfo.gameAdComData.m) });
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.y)) {
        str1 = paramAdvertisementInfo.gameAdComData.y;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      if (!paramBoolean2)
      {
        String str4 = anzj.a(2131711952);
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
      str1 = anzj.a(2131711949);
      if (paramBoolean2) {
        str1 = anzj.a(2131711920);
      }
      if (TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.w)) {
        break label363;
      }
      str1 = paramAdvertisementInfo.gameAdComData.w;
    }
    label363:
    for (;;)
    {
      str2 = anzj.a(2131711611);
      if (bhny.a(BaseApplicationImpl.getContext(), paramAdvertisementInfo.gameAdComData.d)) {
        str2 = anzj.a(2131711756);
      }
      if (paramBoolean2) {}
      for (paramAdvertisementInfo = anzj.a(2131711880);; paramAdvertisementInfo = anzj.a(2131711585))
      {
        a(paramContext, paramOnClickListener, localSpannableStringBuilder, str1, str2, paramAdvertisementInfo);
        return;
        str1 = anzj.a(2131711803);
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
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anzj.a(2131711695));
    String str2 = anzj.a(2131711853);
    String str1 = anzj.a(2131711610);
    if (bhny.a(BaseApplicationImpl.getContext(), paramString)) {
      str1 = anzj.a(2131711889);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str2, str1, anzj.a(2131712003));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(String.format(anzj.a(2131711867), new Object[] { a(paramString1) }));
    String str = anzj.a(2131711772);
    paramString1 = anzj.a(2131712016);
    if (bhny.a(BaseApplicationImpl.getContext(), paramString2)) {
      paramString1 = anzj.a(2131711984);
    }
    a(paramContext, paramOnClickListener, localSpannableStringBuilder, str, paramString1, anzj.a(2131711742));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tps
 * JD-Core Version:    0.7.0.1
 */