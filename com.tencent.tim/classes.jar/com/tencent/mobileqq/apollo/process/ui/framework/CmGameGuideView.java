package com.tencent.mobileqq.apollo.process.ui.framework;

import abmt;
import aboi;
import abos;
import aboz;
import abtn;
import abxi;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import auru;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class CmGameGuideView
  extends FrameworkView
  implements View.OnClickListener
{
  URLImageView aH;
  URLImageView aI;
  RelativeLayout jl;
  RelativeLayout jm;
  private int mCurrentCount;
  
  public CmGameGuideView(Context paramContext)
  {
    super(paramContext);
    u(paramContext, true);
  }
  
  public CmGameGuideView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    if (paramStartCheckParam.viewMode == 0) {}
    for (boolean bool = true;; bool = false)
    {
      u(paramContext, bool);
      return;
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if ((paramURLImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramURLImageView.setImageDrawable(abtn.a(true, abxi.biw + paramString.substring(paramString.lastIndexOf("/") + 1), null, paramString, true));
  }
  
  private void cDv()
  {
    if (this.a != null) {
      this.a.cDH();
    }
    this.e.sendEmptyMessageDelayed(102, 500L);
  }
  
  private void u(Context paramContext, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131559006, null);
    aboz localaboz = abmt.a();
    int i;
    Object localObject;
    if ((localaboz != null) && (localaboz.YS()))
    {
      i = 1;
      if (!paramBoolean) {
        break label286;
      }
      this.jl = ((RelativeLayout)localRelativeLayout.findViewById(2131364841));
      this.jm = ((RelativeLayout)localRelativeLayout.findViewById(2131364845));
      this.aH = ((URLImageView)localRelativeLayout.findViewById(2131364850));
      this.aI = ((URLImageView)localRelativeLayout.findViewById(2131364848));
      localRelativeLayout.findViewById(2131364839).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364840).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364837).setOnClickListener(this);
      localObject = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play.png";
      paramContext = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus.png";
      label135:
      a(this.aH, (String)localObject);
      a(this.aI, paramContext);
      if (i == 0) {
        break label385;
      }
      this.jl.setVisibility(0);
    }
    for (;;)
    {
      addView(localRelativeLayout);
      paramContext = (RelativeLayout)((Activity)this.mActivityRef.get()).findViewById(2131377555);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramContext.addView(this, (ViewGroup.LayoutParams)localObject);
      invalidate();
      if (localaboz != null)
      {
        localaboz.cDU();
        this.mCurrentCount = localaboz.cqA;
      }
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_kxw", 0, 0, new String[] { String.valueOf(this.b.gameId), String.valueOf(this.mCurrentCount) });
      return;
      i = 0;
      break;
      label286:
      this.jl = ((RelativeLayout)localRelativeLayout.findViewById(2131364844));
      this.jm = ((RelativeLayout)localRelativeLayout.findViewById(2131364846));
      this.aH = ((URLImageView)localRelativeLayout.findViewById(2131364849));
      this.aI = ((URLImageView)localRelativeLayout.findViewById(2131364847));
      localRelativeLayout.findViewById(2131364842).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364843).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364838).setOnClickListener(this);
      localObject = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play_landscape.png";
      paramContext = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus_landscape.png";
      break label135;
      label385:
      this.jm.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("xyId", 3112);
        localJSONObject.put("src", 888001);
        aboi.a("cs.create_xy.local", localJSONObject.toString(), false, null, this.b.gameId);
        cDv();
        VipUtils.a(null, "cmshow", "Apollo", "BeGuiClick", 0, 0, new String[] { String.valueOf(this.b.gameId), String.valueOf(this.mCurrentCount) });
      }
      catch (Exception localException)
      {
        QLog.e("cmframe_CmGameGuideView", 1, "cmgame_framework_guide_play_btn e:", localException);
      }
      continue;
      this.jl.setVisibility(8);
      this.jm.setVisibility(0);
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_xxlb", 0, 0, new String[] { String.valueOf(this.b.gameId), String.valueOf(this.mCurrentCount) });
      continue;
      cDv();
    }
  }
  
  public void resetView() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView
 * JD-Core Version:    0.7.0.1
 */