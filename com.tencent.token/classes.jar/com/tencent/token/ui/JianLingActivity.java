package com.tencent.token.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.ba;
import com.tencent.token.core.bean.JLProtectionInfo;
import com.tencent.token.core.bean.JLProtectionInfo.ProtectionInfoItem;
import com.tencent.token.core.bean.NewConfigureCacheItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.fp;
import com.tencent.token.ui.base.ErrorView;
import com.tencent.token.ui.base.HorizontialListView;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.ui.base.bh;
import java.util.ArrayList;

public class JianLingActivity
  extends BaseActivity
{
  public JLProtectionInfo.ProtectionInfoItem m2VerifyItem;
  public boolean m2VerifyQuerying = false;
  private View.OnClickListener mBindListener = new nn(this);
  private ErrorView mErrorView;
  public Handler mHandler = new np(this);
  public JLProtectionInfo mInfo;
  private nw mLiBaoAdapter;
  private HorizontialListView mLiBaoGallery;
  public Bitmap[] mLiBaoImgs;
  private TextView mLiBaoText;
  private LinearLayout mListView;
  private bh mNeedVerifyView;
  private View mProgressView;
  private TextView mRecommendDesc;
  private TextView mRecommendName;
  private View.OnClickListener mRetryListener = new no(this);
  private String mTipBindQQBtnDesc;
  private String mTipBindQQDesc;
  
  public void hideTip()
  {
    this.mProgressView.setVisibility(8);
    this.mListView.setVisibility(0);
  }
  
  public void initListItem(View paramView, int paramInt)
  {
    if ((isFinishing()) || (this.mInfo == null) || (this.mInfo.protectionInfoItem == null)) {
      return;
    }
    Object localObject = this.mInfo;
    TextView localTextView1 = (TextView)paramView.findViewById(2131296718);
    TextView localTextView2 = (TextView)paramView.findViewById(2131296719);
    SwitchButton localSwitchButton = (SwitchButton)paramView.findViewById(2131296720);
    ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131296721);
    ImageView localImageView = (ImageView)paramView.findViewById(2131296722);
    if (paramInt < ((JLProtectionInfo)localObject).protectionInfoItem.size())
    {
      localObject = (JLProtectionInfo.ProtectionInfoItem)((JLProtectionInfo)localObject).protectionInfoItem.get(paramInt);
      localTextView1.setText(((JLProtectionInfo.ProtectionInfoItem)localObject).name);
      localTextView2.setText(((JLProtectionInfo.ProtectionInfoItem)localObject).desc);
      localSwitchButton.setVisibility(0);
      if (((JLProtectionInfo.ProtectionInfoItem)localObject).busy)
      {
        localSwitchButton.setEnabled(false);
        localProgressBar.setVisibility(0);
        localImageView.setVisibility(4);
        localSwitchButton.setOnCheckedChangeListener(new ns(this, paramInt, (JLProtectionInfo.ProtectionInfoItem)localObject, paramView));
        return;
      }
      localSwitchButton.setEnabled(true);
      if (((JLProtectionInfo.ProtectionInfoItem)localObject).value == 1) {}
      for (boolean bool = false;; bool = true)
      {
        localSwitchButton.a(bool, false);
        localProgressBar.setVisibility(4);
        break;
      }
    }
    localTextView1.setText(((JLProtectionInfo)localObject).appealName);
    localTextView2.setText(((JLProtectionInfo)localObject).appealDesc);
    localSwitchButton.setVisibility(4);
    localProgressBar.setVisibility(4);
    localImageView.setVisibility(0);
    paramView.setOnClickListener(new nq(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903108);
    this.mTipBindQQDesc = getResources().getString(2131362193);
    this.mTipBindQQBtnDesc = getResources().getString(2131362297);
    this.mRecommendName = ((TextView)findViewById(2131296709));
    this.mRecommendDesc = ((TextView)findViewById(2131296710));
    this.mProgressView = findViewById(2131296714);
    this.mLiBaoText = ((TextView)findViewById(2131296712));
    this.mListView = ((LinearLayout)findViewById(2131296711));
    this.mLiBaoGallery = ((HorizontialListView)findViewById(2131296713));
    this.mLiBaoAdapter = new nw(this);
    this.mLiBaoGallery.a(this.mLiBaoAdapter);
    this.mLiBaoGallery.setOnItemClickListener(new nr(this));
    af.a().a(0L, this.mHandler, this);
    showTip(-1, null, null, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mLiBaoImgs != null)
    {
      int i = 0;
      while (i < this.mLiBaoImgs.length)
      {
        Bitmap localBitmap = this.mLiBaoImgs[i];
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ba.a().h.a("jl_zone").a();
  }
  
  public void onResume()
  {
    super.onResume();
    ba.a().h.a("jl_zone").a();
  }
  
  public void showTip(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramInt == -1) && (paramString1 == null) && (paramString2 == null))
    {
      this.mProgressView.setVisibility(0);
      this.mListView.setVisibility(8);
      this.mLiBaoText.setVisibility(8);
      this.mLiBaoGallery.setVisibility(8);
      return;
    }
    paramString1 = ax.a().e();
    if ((paramString1 != null) && (!paramString1.mIsBinded))
    {
      if (this.mNeedVerifyView == null) {
        this.mNeedVerifyView = new bh(this);
      }
      setContentView(this.mNeedVerifyView);
      return;
    }
    if (this.mErrorView == null)
    {
      this.mErrorView = new ErrorView(this);
      addContentView(this.mErrorView);
    }
    this.mErrorView.a(paramInt);
    if (paramBoolean) {
      this.mErrorView.a(this.mBindListener);
    }
    for (;;)
    {
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      return;
      this.mErrorView.a(this.mRetryListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JianLingActivity
 * JD-Core Version:    0.7.0.1
 */