package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cy;
import com.tencent.token.do;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.x;
import java.util.ArrayList;
import java.util.List;

public class FacePwdIndexActivity
  extends BaseActivity
{
  private fg mAdapter;
  private View mDivider;
  private TextView mFacePwdVerifyTipTextView;
  private boolean mIsChecked = false;
  private ListView mListView;
  private List mRegisterFacePwdUserList = new ArrayList();
  private SwitchButton mSwitchVerifySet;
  
  private void initView()
  {
    this.mFacePwdVerifyTipTextView = ((TextView)findViewById(2131558835));
    this.mDivider = findViewById(2131558836);
    this.mSwitchVerifySet = ((SwitchButton)findViewById(2131558834));
    do.a().a(this.mRegisterFacePwdUserList);
    if (this.mRegisterFacePwdUserList.size() > 0)
    {
      QQUser localQQUser = x.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mSwitchVerifySet.a(false, false);
        this.mIsChecked = true;
      }
    }
    for (;;)
    {
      this.mSwitchVerifySet.setOnCheckedChangeListener(new fe(this));
      this.mListView = ((ListView)findViewById(2131558849));
      this.mAdapter = new fg(this, this.mRegisterFacePwdUserList);
      this.mListView.setAdapter(this.mAdapter);
      if (!this.mIsChecked) {
        break;
      }
      this.mListView.setVisibility(0);
      this.mFacePwdVerifyTipTextView.setVisibility(0);
      this.mDivider.setVisibility(0);
      return;
      this.mSwitchVerifySet.a(true, false);
      this.mIsChecked = false;
      continue;
      this.mSwitchVerifySet.a(true, false);
      this.mIsChecked = false;
    }
    this.mListView.setVisibility(4);
    this.mFacePwdVerifyTipTextView.setVisibility(4);
    this.mDivider.setVisibility(4);
  }
  
  private void showGesturePwdDialog()
  {
    if (!cy.a().c()) {
      showUserDialog(2131230994, getString(2131230991), 2131230993, 2131230992, new ff(this), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968649);
    initView();
  }
  
  public void refreshList()
  {
    this.mAdapter.notifyDataSetChanged();
    showGesturePwdDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FacePwdIndexActivity
 * JD-Core Version:    0.7.0.1
 */