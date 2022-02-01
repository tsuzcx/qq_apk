package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.ce;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.ui.base.FacePwdVerifySelDialog;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.m;
import java.util.ArrayList;
import java.util.List;

public class FacePwdIndexActivity
  extends BaseActivity
{
  private g mAdapter;
  private View mDivider;
  private TextView mFacePwdVerifyTipTextView;
  private boolean mIsChecked = false;
  private ListView mListView;
  private List<QQUser> mRegisterFacePwdUserList = new ArrayList();
  private SwitchButton mSwitchVerifySet;
  
  private void initView()
  {
    this.mFacePwdVerifyTipTextView = ((TextView)findViewById(2131165484));
    this.mDivider = findViewById(2131165445);
    this.mSwitchVerifySet = ((SwitchButton)findViewById(2131165374));
    cs.a().a(this.mRegisterFacePwdUserList);
    if (this.mRegisterFacePwdUserList.size() > 0)
    {
      QQUser localQQUser = m.f();
      if ((localQQUser != null) && (localQQUser.mIsRegisterFacePwd))
      {
        this.mSwitchVerifySet.a(false, false);
        this.mIsChecked = true;
      }
      else
      {
        this.mSwitchVerifySet.a(true, false);
        this.mIsChecked = false;
      }
    }
    else
    {
      this.mSwitchVerifySet.a(true, false);
      this.mIsChecked = false;
    }
    this.mSwitchVerifySet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean != FacePwdIndexActivity.this.mIsChecked) {
          return;
        }
        if (FacePwdIndexActivity.this.mIsChecked)
        {
          FacePwdIndexActivity.this.mSwitchVerifySet.a(true, false);
          FacePwdIndexActivity.access$002(FacePwdIndexActivity.this, false);
          m.b(0L);
          FacePwdIndexActivity.this.mListView.setVisibility(4);
          FacePwdIndexActivity.this.mFacePwdVerifyTipTextView.setVisibility(4);
          FacePwdIndexActivity.this.mDivider.setVisibility(4);
          return;
        }
        FacePwdIndexActivity.this.mListView.setVisibility(0);
        FacePwdIndexActivity.this.mFacePwdVerifyTipTextView.setVisibility(0);
        FacePwdIndexActivity.this.mDivider.setVisibility(0);
        if (FacePwdIndexActivity.this.mRegisterFacePwdUserList.size() > 0)
        {
          if (FacePwdIndexActivity.this.mRegisterFacePwdUserList.size() == 1)
          {
            FacePwdIndexActivity.access$002(FacePwdIndexActivity.this, true);
            FacePwdIndexActivity.this.mSwitchVerifySet.a(false, false);
            m.b(((QQUser)FacePwdIndexActivity.this.mRegisterFacePwdUserList.get(0)).mRealUin);
            FacePwdIndexActivity.this.refreshList();
            return;
          }
          FacePwdIndexActivity.access$002(FacePwdIndexActivity.this, true);
          FacePwdIndexActivity.this.mSwitchVerifySet.a(false, false);
          paramAnonymousCompoundButton = FacePwdIndexActivity.this;
          paramAnonymousCompoundButton = new FacePwdVerifySelDialog(paramAnonymousCompoundButton, 2131558791, paramAnonymousCompoundButton.mRegisterFacePwdUserList);
          paramAnonymousCompoundButton.setCancelable(false);
          paramAnonymousCompoundButton.show();
          return;
        }
        paramAnonymousCompoundButton = new Intent(FacePwdIndexActivity.this, FaceRecognitionCreateActivity.class);
        FacePwdIndexActivity.this.startActivity(paramAnonymousCompoundButton);
        FacePwdIndexActivity.this.finish();
      }
    });
    this.mListView = ((ListView)findViewById(2131165483));
    this.mAdapter = new g(this, this.mRegisterFacePwdUserList);
    this.mListView.setAdapter(this.mAdapter);
    if (this.mIsChecked)
    {
      this.mListView.setVisibility(0);
      this.mFacePwdVerifyTipTextView.setVisibility(0);
      this.mDivider.setVisibility(0);
      return;
    }
    this.mListView.setVisibility(4);
    this.mFacePwdVerifyTipTextView.setVisibility(4);
    this.mDivider.setVisibility(4);
  }
  
  private void showGesturePwdDialog()
  {
    if (!ce.a().c()) {
      showUserDialog(2131493137, getString(2131493134), 2131493136, 2131493135, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent(FacePwdIndexActivity.this, StartPwdUpdateInfoActivity.class);
          FacePwdIndexActivity.this.startActivity(paramAnonymousDialogInterface);
        }
      }, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296329);
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