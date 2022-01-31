package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.EvalAccountResult;
import com.tencent.token.core.bean.EvalAccountResult.DetailItem;
import com.tencent.token.cw;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ErrorView;
import java.util.ArrayList;

public class MyPswSubPageActivity
  extends BaseActivity
{
  public static int[] mIconStatus = { 2130837836, 2130837838, 2130837837 };
  private boolean isNeedRefresh = false;
  private EvalAccountResult.DetailItem mAbnormalPswDetail;
  private ArrayList mDetails = new ArrayList();
  private View.OnClickListener mErrorAction = new qd(this);
  private ErrorView mErrorView;
  private EvalAccountResult mEvalResult = null;
  private Handler mHandler = new qa(this);
  private Button mPswBtn;
  private EvalAccountResult.DetailItem mPswDetail;
  private ImageView mPswIv;
  private TextView mPswTip;
  private TextView mPswTipDetail;
  private TextView mPswTitle;
  
  private void initView(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (((EvalAccountResult.DetailItem)paramArrayList.get(i)).mRecommendId == 201) {
        this.mPswDetail = ((EvalAccountResult.DetailItem)paramArrayList.get(i));
      }
      if (((EvalAccountResult.DetailItem)paramArrayList.get(i)).mRecommendId == 202) {
        this.mAbnormalPswDetail = ((EvalAccountResult.DetailItem)paramArrayList.get(i));
      }
      i += 1;
    }
    if (this.mPswDetail == null)
    {
      finish();
      return;
    }
    if (this.mPswDetail != null)
    {
      this.mPswTitle.setText(this.mPswDetail.mTitle);
      this.mPswTip.setText(this.mPswDetail.mDesc);
      this.mPswIv.setImageDrawable(getResources().getDrawable(mIconStatus[this.mPswDetail.mDegree]));
      if (this.mAbnormalPswDetail != null)
      {
        this.mPswTip.setText(this.mAbnormalPswDetail.mDesc + ", ");
        this.mPswTipDetail.setVisibility(0);
        this.mPswTipDetail.setOnClickListener(new qb(this));
      }
    }
    this.mPswBtn.setOnClickListener(new qc(this));
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968701);
    this.mDetails = ((ArrayList)getIntent().getSerializableExtra("detailItems"));
    this.mPswIv = ((ImageView)findViewById(2131559068));
    this.mPswTitle = ((TextView)findViewById(2131559069));
    this.mPswTip = ((TextView)findViewById(2131559071));
    this.mPswBtn = ((Button)findViewById(2131559073));
    this.mPswTipDetail = ((TextView)findViewById(2131559072));
    initView(this.mDetails);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.isNeedRefresh = true;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.isNeedRefresh)
    {
      cw.a().d(0L, this.mHandler);
      showUserDialog(12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.MyPswSubPageActivity
 * JD-Core Version:    0.7.0.1
 */