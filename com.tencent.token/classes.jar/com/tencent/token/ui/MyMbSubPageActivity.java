package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.ax;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.DetailItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItem;
import com.tencent.token.core.bean.MbInfoResult.MbInfoItemDetail;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ErrorView;
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
  private View.OnClickListener mErrorAction = new qm(this);
  private ErrorView mErrorView;
  private EvalAccountResult mEvalResult = null;
  private RelativeLayout mFaceLayout;
  private TextView mFaceTip;
  private Handler mHandler = new qk(this);
  private RelativeLayout mMobileLayout;
  private TextView mMobileTip;
  private RelativeLayout mQQTokenLayout;
  private TextView mQQTokenTip;
  private RelativeLayout mQuestionLayout;
  private TextView mQuestionTip;
  private RelativeLayout mRealNameLayout;
  private TextView mRealNameTip;
  private RealNameStatusResult result;
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
        e.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
        if (paramMbInfoItem.mDetail.mBtnType == 1)
        {
          Intent localIntent = new Intent(this, UtilsModSetMobileStep1Activity.class);
          localIntent.putExtra("title", getResources().getString(2131361814) + paramMbInfoItem.mName);
          localIntent.putExtra("op_type", 1);
          localIntent.putExtra("position", paramInt2);
          startActivityForResult(localIntent, 0);
          return;
        }
        paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
        paramMbInfoItem.putExtra("position", paramInt2);
        startActivityForResult(paramMbInfoItem, 0);
        return;
      } while (paramMbInfoItem.mId != 50);
      e.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
      this.detailItemMap.get(Integer.valueOf(405));
      paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
      paramMbInfoItem.putExtra("position", paramInt2);
      startActivityForResult(paramMbInfoItem, 0);
      return;
    } while (paramMbInfoItem.mId != 53);
    e.a("setting item: name=" + paramMbInfoItem.mName + ", desc=" + paramMbInfoItem.mDesc + ", value =" + paramMbInfoItem.mValue + ", content=" + paramMbInfoItem.mContent);
    paramMbInfoItem = new Intent(this, UtilsMbInfoItemActivity.class);
    paramMbInfoItem.putExtra("position", paramInt2);
    startActivityForResult(paramMbInfoItem, 0);
  }
  
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
    if (paramDetailItem.mDegree == 2)
    {
      paramDetailItem = getResources().getDrawable(2130837510);
      paramDetailItem.setBounds(0, 0, paramDetailItem.getMinimumWidth(), paramDetailItem.getMinimumHeight());
      paramTextView.setCompoundDrawables(paramDetailItem, null, localDrawable, null);
      paramTextView.setTextColor(getResources().getColor(2131165345));
      return;
    }
    paramTextView.setTextColor(getResources().getColor(2131165335));
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
    initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(401)), this.mFaceTip);
    initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(404)), this.mMobileTip);
    if (this.detailItemMap.get(Integer.valueOf(403)) != null)
    {
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(403)), this.mRealNameTip);
      if (this.detailItemMap.get(Integer.valueOf(405)) == null) {
        break label253;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(405)), this.mQuestionTip);
    }
    for (;;)
    {
      if (this.detailItemMap.get(Integer.valueOf(406)) == null) {
        break label274;
      }
      initItemTipText((EvalAccountResult.DetailItem)this.detailItemMap.get(Integer.valueOf(406)), this.mQQTokenTip);
      return;
      this.mRealNameLayout.setVisibility(8);
      this.divider.setVisibility(8);
      break;
      label253:
      this.mQuestionLayout.setVisibility(8);
      this.divider1.setVisibility(8);
    }
    label274:
    this.mQQTokenLayout.setVisibility(8);
    this.divider2.setVisibility(8);
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
  
  public void onBackPressed()
  {
    if (this.fromspalsh)
    {
      Intent localIntent = new Intent(this, IndexActivity.class);
      localIntent.putExtra("index_from", 16);
      startActivity(localIntent);
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296838: 
    case 2131296840: 
    case 2131296842: 
    case 2131296844: 
    default: 
      return;
    case 2131296837: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 20, 1);
        return;
      }
      if (ax.a().j())
      {
        startActivityForResult(new Intent(this, FaceRecognitionDefaultActivity.class), 0);
        return;
      }
      startActivityForResult(new Intent(this, FaceRecognitionCreateActivity.class), 0);
      return;
    case 2131296839: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 21, 1);
        return;
      }
      af.a().l(0L, this.mHandler);
      showProDialog(this, 2131361808, 2131362203, null);
      return;
    case 2131296841: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 19, 1);
        return;
      }
      this.whichMbCase = 0;
      af.a().e(0L, this.mHandler);
      showProDialog(this, 2131361808, 2131361816, null);
      return;
    case 2131296843: 
      if (ax.a().e() == null)
      {
        showNoAccountTipDialog(this, 19, 0);
        return;
      }
      if (!ax.a().e().mIsBinded)
      {
        showNoAccountTipDialog(this, 23, 1);
        return;
      }
      this.whichMbCase = 1;
      af.a().e(0L, this.mHandler);
      showProDialog(this, 2131361808, 2131361816, null);
      return;
    }
    if (ax.a().e() == null)
    {
      showNoAccountTipDialog(this, 19, 0);
      return;
    }
    if (!ax.a().e().mIsBinded)
    {
      showNoAccountTipDialog(this, 22, 1);
      return;
    }
    this.whichMbCase = 2;
    af.a().e(0L, this.mHandler);
    showProDialog(this, 2131361808, 2131361816, null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDetails = ((ArrayList)getIntent().getSerializableExtra("detailItems"));
    if ((this.mDetails == null) || (this.mDetails.size() == 0))
    {
      af.a().d(0L, this.mHandler);
      showUserDialog(12);
    }
    this.fromspalsh = getIntent().getBooleanExtra("fromspalsh", false);
    setContentView(2130903143);
    this.mFaceLayout = ((RelativeLayout)findViewById(2131296837));
    this.mRealNameLayout = ((RelativeLayout)findViewById(2131296839));
    this.mMobileLayout = ((RelativeLayout)findViewById(2131296841));
    this.mQuestionLayout = ((RelativeLayout)findViewById(2131296843));
    this.mQQTokenLayout = ((RelativeLayout)findViewById(2131296845));
    this.mFaceLayout.setOnClickListener(this);
    this.mRealNameLayout.setOnClickListener(this);
    this.mMobileLayout.setOnClickListener(this);
    this.mQuestionLayout.setOnClickListener(this);
    this.mQQTokenLayout.setOnClickListener(this);
    this.mFaceTip = ((TextView)findViewById(2131296838));
    this.mRealNameTip = ((TextView)findViewById(2131296840));
    this.mMobileTip = ((TextView)findViewById(2131296842));
    this.mQuestionTip = ((TextView)findViewById(2131296844));
    this.mQQTokenTip = ((TextView)findViewById(2131296846));
    this.divider = findViewById(2131296550);
    this.divider1 = findViewById(2131296788);
    this.divider2 = findViewById(2131296555);
    initView(this.mDetails);
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ql(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.MyMbSubPageActivity
 * JD-Core Version:    0.7.0.1
 */