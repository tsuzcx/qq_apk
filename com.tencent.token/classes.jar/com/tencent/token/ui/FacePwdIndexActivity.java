package com.tencent.token.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.ah;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.t;
import java.util.ArrayList;
import java.util.List;

public class FacePwdIndexActivity
  extends BaseActivity
{
  private ep mAdapter;
  private View mDivider;
  private TextView mFacePwdVerifyTipTextView;
  private boolean mIsChecked = false;
  private ListView mListView;
  private List mRegisterFacePwdUserList = new ArrayList();
  private SwitchButton mSwitchVerifySet;
  
  private void initView()
  {
    this.mFacePwdVerifyTipTextView = ((TextView)findViewById(2131296549));
    this.mDivider = findViewById(2131296550);
    this.mSwitchVerifySet = ((SwitchButton)findViewById(2131296548));
    ax.a().a(this.mRegisterFacePwdUserList);
    if (this.mRegisterFacePwdUserList.size() > 0)
    {
      QQUser localQQUser = t.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mSwitchVerifySet.a(false, false);
        this.mIsChecked = true;
      }
    }
    for (;;)
    {
      this.mSwitchVerifySet.setOnCheckedChangeListener(new en(this));
      this.mListView = ((ListView)findViewById(2131296562));
      this.mAdapter = new ep(this, this.mRegisterFacePwdUserList);
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
    if (!ah.a().c()) {
      showUserDialog(2131362130, getString(2131362131), 2131362132, 2131362133, new eo(this), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
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