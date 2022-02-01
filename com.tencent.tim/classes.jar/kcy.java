import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;

public class kcy
  implements View.OnClickListener
{
  public static String Ya = "tag_on_nearby_tips_click";
  private View[] j = { this.jp, this.jq };
  private View jp;
  private View jq;
  private Context mContext;
  long rK;
  
  public kcy(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public View a(String paramString, View.OnClickListener paramOnClickListener)
  {
    if ((this.mContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (this.jp == null)
    {
      this.jp = new TextView(this.mContext);
      ((TextView)this.jp).setTextColor(this.mContext.getResources().getColor(2131167654));
      this.jp.setBackgroundResource(2130847970);
      ((TextView)this.jp).setGravity(16);
      this.jp.setTag(Ya);
      ((TextView)this.jp).setTextSize(this.mContext.getResources().getInteger(2131427344));
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = aqcx.dip2px(this.mContext, 18.0F);
    localLayoutParams.addRule(3, 2131374819);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = aqcx.px2dip(this.mContext, 20.0F);
    ((TextView)this.jp).setText(paramString);
    this.jp.setLayoutParams(localLayoutParams);
    this.jp.setOnClickListener(paramOnClickListener);
    return this.jp;
  }
  
  public void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup == null) || (paramView == null)) {}
    do
    {
      return;
      int i = 0;
      while (i < this.j.length)
      {
        if ((this.j[i] != null) && (this.j[i] != paramView) && (paramViewGroup.indexOfChild(this.j[i]) != -1)) {
          paramViewGroup.removeView(this.j[i]);
        }
        i += 1;
      }
    } while (paramViewGroup.indexOfChild(paramView) != -1);
    paramViewGroup.addView(paramView);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    label55:
    do
    {
      return;
      Object localObject1 = null;
      try
      {
        localObject2 = (ViewGroup)((FragmentActivity)this.mContext).getChatFragment().a().mAIORootView.findViewById(2131364469);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        int i;
        break label55;
      }
    } while (localObject1 == null);
    if (this.jq == null)
    {
      this.jq = new URLImageView(this.mContext);
      this.jq.setId(2131362569);
      i = aqcx.dip2px(this.mContext, 62.0F);
      localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = aqcx.dip2px(this.mContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = aqcx.dip2px(this.mContext, 15.0F);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131374819);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      this.jq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    this.jq.setTag(2131362572, paramString2);
    this.jq.setTag(2131362570, String.valueOf(paramInt1));
    this.jq.setTag(2131362571, String.valueOf(paramInt2));
    this.jq.setTag(2131362573, Integer.valueOf(paramInt3));
    this.jq.setOnClickListener(this);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mPlayGifImage = true;
    try
    {
      paramString1 = URLDrawable.getDrawable(new URL(paramString1), paramString2);
      ((URLImageView)this.jq).setImageDrawable(paramString1);
      if (paramString1.getStatus() == 2)
      {
        paramString1.restartDownload();
        this.jq.setVisibility(8);
      }
      ((URLImageView)this.jq).setURLDrawableDownListener(new kcz(this));
    }
    catch (MalformedURLException paramString1)
    {
      label298:
      break label298;
    }
    a(localObject1, this.jq);
    anot.a(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A0", "0X80075A0", 0, 0, "", "", String.valueOf(paramInt1), String.valueOf(paramInt2));
  }
  
  public void aBE()
  {
    if (this.jq != null)
    {
      ViewGroup localViewGroup = (ViewGroup)this.jq.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.jq);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.rK < 1000L) {}
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.rK = System.currentTimeMillis();
    } while ((paramView.getId() != 2131362569) || (this.mContext == null));
    String str1 = (String)paramView.getTag(2131362572);
    String str2 = (String)paramView.getTag(2131362570);
    String str3 = (String)paramView.getTag(2131362571);
    Intent localIntent;
    if (((Integer)paramView.getTag(2131362573)).intValue() == 1)
    {
      localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str1);
      localIntent.putExtra("fromAio", true);
      this.mContext.startActivity(localIntent);
    }
    for (;;)
    {
      anot.a(null, "dc00899", "Pb_account_lifeservice", "1", "0X80075A1", "0X80075A1", 0, 0, "", "", str2, str3);
      break;
      localIntent = new Intent(this.mContext, JumpActivity.class);
      localIntent.setData(Uri.parse(str1));
      this.mContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcy
 * JD-Core Version:    0.7.0.1
 */