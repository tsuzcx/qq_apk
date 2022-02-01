package com.tencent.mobileqq.facetoface;

import acff;
import acfp;
import agay;
import agba;
import agbb;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqhu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import wja;

public class Face2FaceTroopDetailView
  extends Face2FaceDetailBaseView
  implements View.OnClickListener
{
  protected TextView Sb;
  public agba d;
  protected Button gh;
  protected ImageView zD;
  protected TextView zt;
  protected TextView zu;
  
  public Face2FaceTroopDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void d(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onJoinTroopSucc, ret=").append(paramInt).append(",errInfo=").append(paramString1).append(",troopUin=").append(paramString2).append(",mUserData.nearbyUin=");
      if (this.d != null)
      {
        str = this.d.bGh;
        QLog.d("Face2FaceTroopDetailView", 2, str);
      }
    }
    else if ((this.isShowing) && ((this.d instanceof agay)) && (paramString2 != null) && (paramString2.equals(this.d.bGh)))
    {
      if (paramInt != 0) {
        break label166;
      }
      setBtnEnabled(false);
      this.gh.setText(2131693389);
      if (!paramBoolean) {
        QQToast.a(super.getContext(), 2, acfp.m(2131706014), 1).show();
      }
      super.deG();
    }
    label166:
    do
    {
      return;
      str = null;
      break;
      if (paramInt == -5)
      {
        this.b.c((agay)this.d);
        super.deG();
      }
    } while (paramBoolean);
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = acfp.m(2131706031);
    }
    QQToast.a(super.getContext(), 1, paramString2, 1).show();
  }
  
  protected void initView()
  {
    this.mHeadView = super.findViewById(2131380263);
    this.CG = super.findViewById(2131378908);
    this.zt = ((TextView)super.findViewById(2131380362));
    this.zu = ((TextView)super.findViewById(2131380409));
    this.Sb = ((TextView)super.findViewById(2131380369));
    this.gh = ((Button)super.findViewById(2131362244));
    this.zD = ((ImageView)this.mHeadView);
    this.CJ = super.findViewById(2131377233);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.CJ.setPadding(wja.dp2px(10.0F, this.CJ.getResources()), wja.dp2px(15.0F, this.CJ.getResources()) + ImmersiveUtils.getStatusBarHeight(this.CJ.getContext()), wja.dp2px(10.0F, this.CJ.getResources()), wja.dp2px(15.0F, this.CJ.getResources()));
    }
    this.CJ.setOnClickListener(this);
    super.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.CJ) {
      super.deG();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.gh) && (this.b != null) && ((this.d instanceof agay)))
      {
        agay localagay = (agay)this.d;
        this.b.a(localagay, 1);
        anot.a(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "Clk_join", 0, 0, localagay.bGh, this.b.getApp().getCurrentAccountUin(), "", "");
      }
    }
  }
  
  public void setBindData(agba paramagba, View.OnClickListener paramOnClickListener)
  {
    this.d = paramagba;
    QQAppInterface localQQAppInterface = this.b.getApp();
    if ((paramagba instanceof agay))
    {
      localObject2 = (agay)paramagba;
      localObject1 = this.b.getApp().a(paramagba.bGh, (byte)3, false, false);
      paramagba = (agba)localObject1;
      if (localObject1 == null) {
        paramagba = aqhu.aL();
      }
      this.zD.setBackgroundDrawable(new BitmapDrawable(paramagba));
      this.zt.setText(((agay)localObject2).troopName);
      this.zu.setText("(" + ((agay)localObject2).bGh + ")");
      localObject1 = ((agay)localObject2).troopOwnerNick;
      paramagba = (agba)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramagba = ((agay)localObject2).bGg;
      }
      paramagba = localQQAppInterface.getApplication().getString(2131693397, new Object[] { paramagba });
      this.Sb.setText(paramagba);
      this.Sb.setVisibility(0);
      this.zu.setVisibility(0);
      if (this.b.mi(((agay)localObject2).bGh))
      {
        setBtnEnabled(false);
        this.gh.setText(2131693389);
      }
    }
    while (!(paramagba instanceof agbb)) {
      for (;;)
      {
        this.zD.setOnClickListener(paramOnClickListener);
        return;
        setBtnEnabled(true);
        this.gh.setText(2131693388);
      }
    }
    Object localObject2 = localQQAppInterface.a(paramagba.bGh, (byte)3, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = aqhu.G();
    }
    this.zD.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject1));
    localObject1 = (agbb)paramagba;
    this.zt.setText(((agbb)localObject1).userNick);
    paramagba = ((acff)localQQAppInterface.getManager(51)).e(paramagba.bGh);
    if ((paramagba != null) && (!TextUtils.isEmpty(paramagba.remark)))
    {
      this.zu.setText("(" + paramagba.remark + ")");
      this.zu.setVisibility(0);
    }
    for (;;)
    {
      this.Sb.setVisibility(8);
      setBtnEnabled(false);
      this.gh.setText(2131693390);
      break;
      this.zu.setVisibility(8);
    }
  }
  
  public void setBtnEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gh.setBackgroundResource(2130839524);
      this.gh.setOnClickListener(this);
      return;
    }
    this.gh.setBackgroundResource(2130839540);
    this.gh.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceTroopDetailView
 * JD-Core Version:    0.7.0.1
 */