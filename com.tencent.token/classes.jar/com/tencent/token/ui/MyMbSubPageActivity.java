package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.DetailItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import java.util.HashMap;

public class MyMbSubPageActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final int SCENE_MB_MOBILE = 0;
  private static final int SCENE_MB_QQ_TOKEN = 2;
  private static final int SCENE_MB_QUESTION = 1;
  private HashMap detailItemMap = new HashMap();
  private View divider;
  private View divider1;
  private View divider2;
  private boolean fromspalsh;
  private ArrayList mDetails = new ArrayList();
  private View.OnClickListener mErrorAction = new pz(this);
  private ErrorView mErrorView;
  private EvalAccountResult mEvalResult = null;
  private RelativeLayout mFaceLayout;
  private TextView mFaceTip;
  private Handler mHandler = new px(this);
  private RelativeLayout mMobileLayout;
  private TextView mMobileTip;
  private int mPageId;
  private RelativeLayout mQQTokenLayout;
  private TextView mQQTokenTip;
  private RelativeLayout mQuestionLayout;
  private TextView mQuestionTip;
  private RelativeLayout mRealNameLayout;
  private TextView mRealNameTip;
  private RealNameStatusResult result;
  private TextView thirdtitle;
  private int whichMbCase = -1;
  
  private void goToDifferentMbActivity(int paramInt1, MbInfoResult.MbInfoItem paramMbInfoItem, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMbInfoItem.mId != 51);
        h.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
        if (paramMbInfoItem.mDetail.mBtnType == 1)
        {
          Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
          localIntent.putExtra("title", getResources().getString(2131231428) + paramMbInfoItem.mName);
          localIntent.putExtra("op_type", 1);
          localIntent.putExtra("position", paramInt2);
          localIntent.putExtra("page_id", 14);
          startActivityForResult(localIntent, 0);
          return;
        }
        paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
        paramMbInfoItem.putExtra("position", paramInt2);
        paramMbInfoItem.putExtra("page_id", 14);
        startActivityForResult(paramMbInfoItem, 0);
        return;
      } while (paramMbInfoItem.mId != 50);
      h.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
      if (paramMbInfoItem.mDetail.mBtnType == 2) {}
      paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
      paramMbInfoItem.putExtra("position", paramInt2);
      startActivityForResult(paramMbInfoItem, 0);
      return;
    } while (paramMbInfoItem.mId != 53);
    h.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
    paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
    paramMbInfoItem.putExtra("position", paramInt2);
    startActivityForResult(paramMbInfoItem, 0);
  }
  
  private void initItemTipText(EvalAccountResult.DetailItem paramDetailItem, TextView paramTextView)
  {
    if (paramDetailItem == null) {
      return;
    }
    Drawable localDrawable = getResources().getDrawable(2130837619);
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
    paramTextView.setCompoundDrawables(null, null, localDrawable, null);
    paramTextView.setText(paramDetailItem.mDesc);
    if (paramDetailItem.mDegree == 1)
    {
      paramDetailItem = getResources().getDrawable(2130837590);
      paramDetailItem.setBounds(0, 0, paramDetailItem.getMinimumWidth(), paramDetailItem.getMinimumHeight());
      paramTextView.setCompoundDrawables(paramDetailItem, null, localDrawable, null);
      paramTextView.setTextColor(getResources().getColor(2131492921));
      return;
    }
    if (paramDetailItem.mDegree == 2)
    {
      paramDetailItem = getResources().getDrawable(2130837591);
      paramDetailItem.setBounds(0, 0, paramDetailItem.getMinimumWidth(), paramDetailItem.getMinimumHeight());
      paramTextView.setCompoundDrawables(paramDetailItem, null, localDrawable, null);
      paramTextView.setTextColor(getResources().getColor(2131492922));
      return;
    }
    paramTextView.setTextColor(getResources().getColor(2131493051));
  }
  
  private void initView(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    this.detailItemMap.clear();
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.detailItemMap.put(Integer.valueOf(((EvalAccountResult.DetailItem)paramArrayList.get(i)).mRecommendId), paramArrayList.get(i));
      i += 1;
    }
    if (this.detailItemMap.get(Integer.valueOf(401)) != null)
    {
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(401)), this.mFaceTip);
      if (this.detailItemMap.get(Integer.valueOf(404)) == null) {
        break label276;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(404)), this.mMobileTip);
      label143:
      if (this.detailItemMap.get(Integer.valueOf(403)) == null) {
        break label288;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(403)), this.mRealNameTip);
      label183:
      if (this.detailItemMap.get(Integer.valueOf(405)) == null) {
        break label346;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(405)), this.mQuestionTip);
    }
    for (;;)
    {
      if (this.detailItemMap.get(Integer.valueOf(406)) == null) {
        break label367;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(406)), this.mQQTokenTip);
      return;
      this.mFaceLayout.setVisibility(8);
      break;
      label276:
      this.mMobileLayout.setVisibility(8);
      break label143;
      label288:
      this.mRealNameLayout.setVisibility(8);
      this.divider.setVisibility(8);
      if (this.detailItemMap.get(Integer.valueOf(401)) != null) {
        break label183;
      }
      this.thirdtitle.setVisibility(8);
      findViewById(2131559040).setVisibility(8);
      break label183;
      label346:
      this.mQuestionLayout.setVisibility(8);
      this.divider1.setVisibility(8);
    }
    label367:
    this.mQQTokenLayout.setVisibility(8);
    this.divider2.setVisibility(8);
  }
  
  private void selectView(f paramf, Message paramMessage)
  {
    if ((paramf != null) && (paramMessage != null) && (paramMessage.arg1 != 110))
    {
      h.c("----result.mErrCode: " + paramf.a);
      h.c("----result.mErrDebug: " + paramf.b);
      if (this.mErrorView == null)
      {
        this.mErrorView = new ErrorView(this);
        this.mErrorView.setAction(this.mErrorAction);
        addContentView(this.mErrorView);
      }
      this.mErrorView.setErrorType(paramf.a);
      this.mErrorView.setTag(Integer.valueOf(paramMessage.what));
      this.mErrorView.a();
      bringChildToFront(this.mErrorView);
      setRightTitleImageHide();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (((this.mPageId == 17) || (this.mPageId == 14)) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      paramKeyEvent = new Intent(this, IndexActivity.class);
      paramKeyEvent.putExtra("index_from", 16);
      startActivity(paramKeyEvent);
      finish();
      return true;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 0)
    {
      cw.a().d(0L, this.mHandler);
      showUserDialog(12);
    }
  }
  
  public void onBackPressed()
  {
    if ((this.fromspalsh) || (this.mPageId == 17) || (this.mPageId == 14))
    {
      Intent localIntent = new Intent(this, IndexActivity.class);
      localIntent.putExtra("index_from", 16);
      startActivity(localIntent);
      finish();
      return;
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    TMSDKContext.SaveStringData(1150065, "");
    switch (paramView.getId())
    {
    case 2131559042: 
    case 2131559044: 
    case 2131559046: 
    case 2131559048: 
    default: 
      return;
    case 2131559041: 
      if (do.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 20, 1);
        return;
      }
      if (do.a().j())
      {
        startActivityForResult(new Intent(this, FaceRecognitionDefaultActivity.class), 0);
        return;
      }
      startActivityForResult(new Intent(this, FaceRecognitionCreateActivity.class), 0);
      return;
    case 2131559043: 
      if (do.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 21, 1);
        return;
      }
      cw.a().j(0L, this.mHandler);
      showProDialog(this, 2131230843, 2131231601, null);
      return;
    case 2131559045: 
      if (do.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 19, 1);
        return;
      }
      this.whichMbCase = 0;
      cw.a().e(0L, this.mHandler);
      showProDialog(this, 2131230843, 2131231299, null);
      return;
    case 2131559047: 
      if (do.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!do.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 23, 1);
        return;
      }
      this.whichMbCase = 1;
      cw.a().e(0L, this.mHandler);
      showProDialog(this, 2131230843, 2131231299, null);
      return;
    }
    if (do.a().e() == null)
    {
      showNoAccountTipDialog(this, 19, 0);
      return;
    }
    if (!do.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 22, 1);
      return;
    }
    this.whichMbCase = 2;
    cw.a().e(0L, this.mHandler);
    showProDialog(this, 2131230843, 2131231299, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDetails = ((ArrayList)getIntent().getSerializableExtra("detailItems"));
    if ((this.mDetails == null) || (this.mDetails.size() == 0))
    {
      cw.a().d(0L, this.mHandler);
      showUserDialog(12);
    }
    this.fromspalsh = getIntent().getBooleanExtra("fromspalsh", false);
    this.mPageId = getIntent().getIntExtra("page_id", 0);
    setContentView(2130968699);
    this.mFaceLayout = ((RelativeLayout)findViewById(2131559041));
    this.mRealNameLayout = ((RelativeLayout)findViewById(2131559043));
    this.mMobileLayout = ((RelativeLayout)findViewById(2131559045));
    this.mQuestionLayout = ((RelativeLayout)findViewById(2131559047));
    this.mQQTokenLayout = ((RelativeLayout)findViewById(2131559049));
    this.mFaceLayout.setOnClickListener(this);
    this.mRealNameLayout.setOnClickListener(this);
    this.mMobileLayout.setOnClickListener(this);
    this.mQuestionLayout.setOnClickListener(this);
    this.mQQTokenLayout.setOnClickListener(this);
    this.mFaceTip = ((TextView)findViewById(2131559042));
    this.mRealNameTip = ((TextView)findViewById(2131559044));
    this.mMobileTip = ((TextView)findViewById(2131559046));
    this.mQuestionTip = ((TextView)findViewById(2131559048));
    this.mQQTokenTip = ((TextView)findViewById(2131559050));
    this.divider = findViewById(2131558836);
    this.divider1 = findViewById(2131558991);
    this.divider2 = findViewById(2131558841);
    this.thirdtitle = ((TextView)findViewById(2131559039));
    initView(this.mDetails);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new py(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.MyMbSubPageActivity
 * JD-Core Version:    0.7.0.1
 */