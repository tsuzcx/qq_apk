package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import mqq.util.WeakReference;
import whk;
import whl;

public class BirthdayActivatePage
  extends ActivateBasePage
{
  private ActivateFriendGrid.a b = new whl(this);
  private View.OnClickListener dG = new whk(this);
  private WeakReference<ActivateFriendActivity> mActivity;
  
  public BirthdayActivatePage(Context paramContext)
  {
    super(paramContext);
    this.mActivity = new WeakReference((ActivateFriendActivity)paramContext);
    this.dM.setText(2131689664);
    this.dM.setOnClickListener(this.dG);
    this.a.setGridCallBack(this.b);
    this.Hr.setVisibility(0);
  }
  
  public void initUI()
  {
    this.mRootView = this.mInflater.inflate(2131561164, this, false);
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.iG = ((TextView)this.mRootView.findViewById(2131362035));
    this.dM = ((Button)this.mRootView.findViewById(2131362029));
    this.Hq = ((TextView)this.mRootView.findViewById(2131362034));
    this.Hr = ((TextView)this.mRootView.findViewById(2131362028));
    this.a = ((ActivateFriendGrid)this.mRootView.findViewById(2131367678));
    eQ((TextView)this.mRootView.findViewById(2131362052));
    addView(this.mRootView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage
 * JD-Core Version:    0.7.0.1
 */