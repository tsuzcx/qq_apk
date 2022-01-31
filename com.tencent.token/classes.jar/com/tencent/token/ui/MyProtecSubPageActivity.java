package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.DetailItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.p;
import com.tencent.token.ui.base.ErrorView;
import java.util.ArrayList;
import java.util.HashMap;

public class MyProtecSubPageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button btn_return;
  private HashMap detailItemMap = new HashMap();
  private View divider1;
  private View divider2;
  private View divider3;
  private View divider4;
  private LinearLayout loginLayout;
  private RelativeLayout mAccountLockLayout;
  private TextView mAccountLockTip;
  private ArrayList mDetails = new ArrayList();
  private View.OnClickListener mErrorAction = new qp(this);
  private ErrorView mErrorView;
  private EvalAccountResult mEvalResult = null;
  private RelativeLayout mGameLockLayout;
  private TextView mGameLockTip;
  private RelativeLayout mGameProtecLayout;
  private TextView mGameProtecTip;
  private Handler mHandler = new qn(this);
  private int mLockCount = 0;
  private LinearLayout mLockLayout;
  private RelativeLayout mMailProtecLayout;
  private TextView mMailProtecTip;
  private int mProtectCount = 0;
  private RelativeLayout mQBProtecLayout;
  private TextView mQBProtecTip;
  private RelativeLayout mQQProtecLayout;
  private TextView mQQProtecTip;
  private LinearLayout noLoginLayout;
  private TextView noLoginTipTextView;
  
  private void initItemTipText(EvalAccountResult.DetailItem paramDetailItem, TextView paramTextView)
  {
    if (paramDetailItem == null) {
      return;
    }
    Drawable localDrawable = getResources().getDrawable(2130837540);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramTextView.setCompoundDrawables(null, null, localDrawable, null);
    paramTextView.setText(paramDetailItem.mDesc);
    if (paramDetailItem.mDegree == 1)
    {
      paramDetailItem = getResources().getDrawable(2130837509);
      paramDetailItem.setBounds(0, 0, paramDetailItem.getMinimumWidth(), paramDetailItem.getMinimumHeight());
      paramTextView.setCompoundDrawables(paramDetailItem, null, localDrawable, null);
      paramTextView.setTextColor(getResources().getColor(2131165344));
      return;
    }
    paramTextView.setTextColor(getResources().getColor(2131165335));
  }
  
  private void initView(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.loginLayout.setVisibility(8);
      this.noLoginLayout.setVisibility(0);
      this.noLoginTipTextView = ((TextView)findViewById(2131296735));
      this.noLoginTipTextView.setText(getResources().getString(2131362315));
      this.btn_return = ((Button)findViewById(2131296848));
      this.btn_return.setOnClickListener(new qo(this));
    }
    label312:
    label352:
    label613:
    label634:
    do
    {
      return;
      this.noLoginLayout.setVisibility(8);
      this.loginLayout.setVisibility(0);
      this.detailItemMap.clear();
      this.mProtectCount = 0;
      this.mLockCount = 0;
      int i = 0;
      while (i < paramArrayList.size())
      {
        this.detailItemMap.put(Integer.valueOf(((EvalAccountResult.DetailItem)paramArrayList.get(i)).mRecommendId), paramArrayList.get(i));
        i += 1;
      }
      if (this.detailItemMap.get(Integer.valueOf(305)) != null) {
        this.mLockCount += 1;
      }
      if (this.detailItemMap.get(Integer.valueOf(306)) != null) {
        this.mLockCount += 1;
      }
      this.mProtectCount = (this.detailItemMap.size() - this.mLockCount);
      if (this.detailItemMap.get(Integer.valueOf(302)) != null)
      {
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(302)), this.mGameProtecTip);
        if (this.detailItemMap.get(Integer.valueOf(303)) == null) {
          break label550;
        }
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(303)), this.mMailProtecTip);
        if (this.detailItemMap.get(Integer.valueOf(301)) == null) {
          break label571;
        }
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(301)), this.mQQProtecTip);
        if (this.detailItemMap.get(Integer.valueOf(304)) == null) {
          break label592;
        }
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(304)), this.mQBProtecTip);
        if (this.detailItemMap.get(Integer.valueOf(305)) == null) {
          break label613;
        }
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(305)), this.mAccountLockTip);
        if (this.detailItemMap.get(Integer.valueOf(306)) == null) {
          break label634;
        }
        initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(306)), this.mGameLockTip);
      }
      for (;;)
      {
        if ((this.mAccountLockLayout.getVisibility() != 0) && (this.mGameLockLayout.getVisibility() != 0)) {
          this.mLockLayout.setVisibility(8);
        }
        if ((this.mProtectCount != 1) || (this.mQQProtecLayout.getVisibility() != 0)) {
          break label655;
        }
        this.divider1.setVisibility(8);
        return;
        this.mGameProtecLayout.setVisibility(8);
        this.divider2.setVisibility(8);
        break;
        this.mMailProtecLayout.setVisibility(8);
        this.divider3.setVisibility(8);
        break label312;
        this.mQQProtecLayout.setVisibility(8);
        this.divider1.setVisibility(8);
        break label352;
        this.mQBProtecLayout.setVisibility(8);
        this.divider3.setVisibility(8);
        break label392;
        this.mAccountLockLayout.setVisibility(8);
        this.divider4.setVisibility(8);
        break label432;
        this.mGameLockLayout.setVisibility(8);
        this.divider4.setVisibility(8);
      }
    } while ((this.mProtectCount != 2) || (this.mQQProtecLayout.getVisibility() != 0) || (this.mGameProtecLayout.getVisibility() != 0));
    label392:
    label432:
    label571:
    label592:
    this.divider2.setVisibility(8);
    label550:
  }
  
  private void selectView(d paramd, Message paramMessage)
  {
    if ((paramd != null) && (paramMessage != null) && (paramMessage.arg1 != 110))
    {
      e.c("----result.mErrCode: " + paramd.a);
      e.c("----result.mErrDebug: " + paramd.b);
      if (this.mErrorView == null)
      {
        this.mErrorView = new ErrorView(this);
        this.mErrorView.a(this.mErrorAction);
        addContentView(this.mErrorView);
      }
      this.mErrorView.a(paramd.a);
      this.mErrorView.setTag(Integer.valueOf(paramMessage.what));
      this.mErrorView.setVisibility(0);
      bringChildToFront(this.mErrorView);
      setRightTitleImageHide();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      af.a().d(0L, this.mHandler);
      showUserDialog(12);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296851: 
    case 2131296853: 
    case 2131296855: 
    case 2131296857: 
    case 2131296858: 
    case 2131296860: 
    case 2131296861: 
    default: 
      return;
    case 2131296850: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 12, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 12, 1);
        return;
      }
      startActivityForResult(new Intent(this, UtilsLoginProtectActivity.class), 0);
      return;
    case 2131296852: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 15, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 15, 1);
        return;
      }
      p.a().a(System.currentTimeMillis(), 75);
      startActivityForResult(new Intent(this, UtilsGameProtectActivity.class), 0);
      return;
    case 2131296854: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 8, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 8, 1);
        return;
      }
      startActivityForResult(new Intent(this, UtilsMailProtectActivity.class), 0);
      return;
    case 2131296856: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 9, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 9, 1);
        return;
      }
      startActivityForResult(new Intent(this, UtilsQbQdProtectActivity.class), 0);
      return;
    case 2131296859: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 11, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 11, 1);
        return;
      }
      startActivityForResult(new Intent(this, UtilsAccountLockActivity.class), 0);
      return;
    }
    if (ax.a().e() == null)
    {
      showNoAccountTipDialog(this, 15, 0);
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 15, 1);
      return;
    }
    startActivityForResult(new Intent(this, UtilsGameLockActivity.class), 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDetails = ((ArrayList)getIntent().getSerializableExtra("detailItems"));
    setContentView(2130903144);
    this.noLoginLayout = ((LinearLayout)findViewById(2131296847));
    this.loginLayout = ((LinearLayout)findViewById(2131296849));
    this.mQQProtecLayout = ((RelativeLayout)findViewById(2131296850));
    this.mGameProtecLayout = ((RelativeLayout)findViewById(2131296852));
    this.mMailProtecLayout = ((RelativeLayout)findViewById(2131296854));
    this.mQBProtecLayout = ((RelativeLayout)findViewById(2131296856));
    this.mAccountLockLayout = ((RelativeLayout)findViewById(2131296859));
    this.mGameLockLayout = ((RelativeLayout)findViewById(2131296862));
    this.mQQProtecTip = ((TextView)findViewById(2131296851));
    this.mGameProtecTip = ((TextView)findViewById(2131296853));
    this.mMailProtecTip = ((TextView)findViewById(2131296855));
    this.mQBProtecTip = ((TextView)findViewById(2131296857));
    this.mAccountLockTip = ((TextView)findViewById(2131296860));
    this.mGameLockTip = ((TextView)findViewById(2131296863));
    this.mQQProtecLayout.setOnClickListener(this);
    this.mGameProtecLayout.setOnClickListener(this);
    this.mMailProtecLayout.setOnClickListener(this);
    this.mQBProtecLayout.setOnClickListener(this);
    this.mAccountLockLayout.setOnClickListener(this);
    this.mGameLockLayout.setOnClickListener(this);
    this.mLockLayout = ((LinearLayout)findViewById(2131296858));
    this.divider1 = findViewById(2131296788);
    this.divider2 = findViewById(2131296555);
    this.divider3 = findViewById(2131296795);
    this.divider4 = findViewById(2131296861);
    initView(this.mDetails);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.MyProtecSubPageActivity
 * JD-Core Version:    0.7.0.1
 */