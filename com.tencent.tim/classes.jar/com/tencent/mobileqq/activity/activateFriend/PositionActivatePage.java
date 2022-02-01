package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import mqq.util.WeakReference;
import who;
import whp;
import whq;

public class PositionActivatePage
  extends ActivateBasePage
{
  public String aSg;
  private ActivateFriendGrid.a b = new who(this);
  private View.OnClickListener dG = new whp(this);
  private View.OnClickListener dH = new whq(this);
  private WeakReference<ActivateFriendActivity> mActivity;
  
  public PositionActivatePage(Context paramContext)
  {
    super(paramContext);
    this.mActivity = new WeakReference((ActivateFriendActivity)paramContext);
    this.dM.setText(2131689670);
    this.dM.setOnClickListener(this.dG);
    this.a.setGridCallBack(this.b);
    this.Hq.setVisibility(0);
    this.Hq.setOnClickListener(this.dH);
  }
  
  public void initUI()
  {
    this.mRootView = this.mInflater.inflate(2131561165, this, false);
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.iG = ((TextView)this.mRootView.findViewById(2131362035));
    this.Ho = ((TextView)this.mRootView.findViewById(2131362031));
    this.Hp = ((TextView)this.mRootView.findViewById(2131362032));
    this.dM = ((Button)this.mRootView.findViewById(2131362029));
    this.Hq = ((TextView)this.mRootView.findViewById(2131362034));
    this.Hr = ((TextView)this.mRootView.findViewById(2131362028));
    this.a = ((ActivateFriendGrid)this.mRootView.findViewById(2131367678));
    eQ((TextView)this.mRootView.findViewById(2131362052));
    addView(this.mRootView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.PositionActivatePage
 * JD-Core Version:    0.7.0.1
 */