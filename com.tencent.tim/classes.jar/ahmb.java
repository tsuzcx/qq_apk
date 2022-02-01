import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahmb
  extends ahgq
{
  public ahmb(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
    this.cZS = 3;
  }
  
  protected int EW()
  {
    if (aviz.a(null, this.bKu).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null)) {}
    for (int i = 0;; i = -1)
    {
      if (i == 0) {
        avjg.a(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localsyw.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(1)) && (e(aa))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 6002) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    super.anj();
    if (this.bKu == null)
    {
      SpannableString localSpannableString = (SpannableString)this.bf.get("forward_text");
      if (localSpannableString != null) {
        this.bKu = localSpannableString.toString();
      }
    }
    return true;
  }
  
  protected boolean anl()
  {
    Intent localIntent;
    boolean bool;
    if (anq())
    {
      localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      if (this.mIntent.getBooleanExtra("isFromShare", false))
      {
        this.bf.putString("leftBackText", acfp.m(2131706557));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.bf.putString("forward_text", this.bKu);
        localIntent.putExtras(this.bf);
        bool = aa(localIntent);
        if (this.cgS)
        {
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
          if (QSecFramework.a().c(1003).booleanValue())
          {
            localObject = fg().iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              arnv.a().n(1, this.bKu, localResultRecord.lk(), localResultRecord.uin);
              arnv.a().report();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
        }
      }
      this.bf.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.bf);
      this.mActivity.setResult(-1, localIntent);
      return false;
    }
    int i = this.bf.getInt("uintype");
    Object localObject = this.bf.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.mActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", kaw.a((String)localObject, this.app));
      if (this.mIntent.getBooleanExtra("isFromShare", false))
      {
        this.bf.putString("leftBackText", acfp.m(2131706552));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        this.bf.putString("forward_text", this.bKu);
        localIntent.putExtras(this.bf);
        bool = aa(localIntent);
        if (!this.cgS) {
          break label491;
        }
        this.mActivity.startActivity(localIntent);
        if (QSecFramework.a().c(1003).booleanValue())
        {
          arnv.a().n(1, this.bKu, i, (String)localObject);
          arnv.a().report();
        }
      }
    }
    for (;;)
    {
      this.bf.putBoolean("isBack2Root", false);
      localIntent.putExtras(this.bf);
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return false;
      localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      break;
      label491:
      if (!bool) {
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
      }
    }
  }
  
  public boolean ann()
  {
    return true;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
    localLinearLayout.setOrientation(0);
    AnimationTextView localAnimationTextView = new AnimationTextView(this.mActivity);
    Object localObject2 = wn();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localAnimationTextView.setText(new aofk((CharSequence)localObject1, 5, 16));
    localAnimationTextView.setMaxLines(2);
    localAnimationTextView.setEllipsize(TextUtils.TruncateAt.END);
    localAnimationTextView.setTextColor(this.mActivity.getResources().getColorStateList(2131165828));
    localAnimationTextView.setTextSize(14.0F);
    localObject1 = new ImageView(this.mActivity);
    ((ImageView)localObject1).setImageResource(2130840498);
    localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    localLinearLayout.addView(localAnimationTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(aqnm.dip2px(3.0F), 0, 0, 0);
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject1 = new View(this.mActivity);
    ((View)localObject1).setId(2131367542);
    ((View)localObject1).setBackgroundResource(2130840508);
    ((View)localObject1).setOnClickListener(new ahmc(this));
    localObject2 = new FrameLayout(this.mActivity);
    int i = aqnm.dip2px(20.0F);
    ((FrameLayout)localObject2).setPadding(0, i, 0, i);
    ((FrameLayout)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject2).addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -2));
    return localObject2;
  }
  
  protected void dnU()
  {
    anl();
  }
  
  protected void dnr()
  {
    super.dnr();
    if (this.mIntent.getBooleanExtra("k_dataline", true))
    {
      this.cs.add(W);
      this.cs.add(ab);
    }
    if ((this.mIntent.getBooleanExtra("k_smartdevice", true)) && (anz())) {
      this.cs.add(aa);
    }
  }
  
  protected void dns()
  {
    super.dns();
    this.e.adjustMessageBottomMargin(17.0F);
    this.e.setMessageTextColor(2131165857);
    this.e.setMessageTextSize(14.0F);
  }
  
  protected void du(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 102);
    paramIntent.putExtra("dataline_forward_text", this.bKu);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmb
 * JD-Core Version:    0.7.0.1
 */