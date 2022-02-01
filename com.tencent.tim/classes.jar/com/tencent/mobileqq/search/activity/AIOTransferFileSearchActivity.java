package com.tencent.mobileqq.search.activity;

import ampx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.search.fragment.AIOTransferFileSearchFragment;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AIOTransferFileSearchActivity
  extends BaseSearchActivity
  implements View.OnClickListener
{
  static List<ampx> Bs;
  List<ampx> Bt;
  protected View GQ;
  private TextView Yy;
  private TextView Yz;
  String avs;
  protected int mFromType = 31;
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AIOTransferFileSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    Bs = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    AIOTransferFileSearchFragment localAIOTransferFileSearchFragment = new AIOTransferFileSearchFragment(this.mFromType);
    localAIOTransferFileSearchFragment.Q(this.avs, Bs);
    return localAIOTransferFileSearchFragment;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = this.b.getText().toString().trim();
    if (this.GQ != null)
    {
      if ((TextUtils.isEmpty(paramEditable)) && (this.mFromType == 31)) {
        this.GQ.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.GQ.setVisibility(8);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mFromType = getIntent().getIntExtra("fromType", 31);
    this.avs = getIntent().getStringExtra("keyword");
    this.Bt = new ArrayList();
    if (Bs != null) {
      this.Bt.addAll(Bs);
    }
    Bs = null;
    if ((this.mFromType == 45) || (this.mFromType == 46) || (this.mFromType == 47) || (this.mFromType == 48)) {
      this.cDh = true;
    }
    super.doOnCreate(paramBundle);
    initView();
    return true;
  }
  
  protected int getLayoutId()
  {
    return 2131558705;
  }
  
  void initView()
  {
    this.GQ = findViewById(2131368280);
    if ((this.mFromType == 31) && ((this.Bt == null) || (this.Bt.isEmpty()))) {
      this.GQ.setVisibility(0);
    }
    for (;;)
    {
      this.Yy = ((TextView)findViewById(2131368265));
      this.Yz = ((TextView)findViewById(2131368270));
      this.Yy.setOnClickListener(this);
      this.Yz.setOnClickListener(this);
      this.Dt.setVisibility(8);
      return;
      this.GQ.setVisibility(8);
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
      QLog.i("AIOTransferFileSearchActivity", 2, "guide_rec");
      AIOTransferFileRecSearchActivity.a(this, null, null, 32);
      continue;
      AIOTransferFileSendSearchActivity.a(this, null, null, 33);
      QLog.i("AIOTransferFileSearchActivity", 2, "guide_send");
    }
  }
  
  protected String vm()
  {
    return "搜索聊天文件";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.AIOTransferFileSearchActivity
 * JD-Core Version:    0.7.0.1
 */