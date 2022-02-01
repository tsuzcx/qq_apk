package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import org.apache.commons.lang3.StringUtils;

public class SettingQmDefaultNickActivity
  extends BaseActivityEx
{
  private static final String ARG_ACCOUNT_ID = "arg_account_id";
  private static final String ARG_NICK = "arg_nick";
  public static final String TAG = "SettingNicknameActivity";
  private Account account;
  private int accountId;
  private final UITableView.ClickListener accountsTableOnClickListener = new SettingQmDefaultNickActivity.3(this);
  private AliasItem[] aliasItems = new AliasItem[0];
  private UITableItemView defaultNickItemView;
  private final UITableView.ClickListener defaultNickTableOnClickListener = new SettingQmDefaultNickActivity.2(this);
  private boolean isNickChanged = false;
  private UITableView mAliasTable;
  private QMBaseView mSettingView;
  private String nick;
  private EditText nickNameEditText;
  private UITableView qmDefaultNickTable;
  
  private void createAliasTable()
  {
    if (this.mAliasTable == null) {
      return;
    }
    this.mAliasTable.clear();
    this.mAliasTable.setDescription(2131719645);
    if ((this.aliasItems != null) && (this.aliasItems.length > 0))
    {
      AliasItem[] arrayOfAliasItem = this.aliasItems;
      int j = arrayOfAliasItem.length;
      int i = 0;
      if (i < j)
      {
        AliasItem localAliasItem = arrayOfAliasItem[i];
        if (StringUtils.isEmpty(localAliasItem.getAlias())) {}
        for (;;)
        {
          i += 1;
          break;
          this.mAliasTable.addItem(localAliasItem.getAlias());
        }
      }
    }
    this.mAliasTable.setClickListener(this.accountsTableOnClickListener);
    this.mAliasTable.commit();
  }
  
  private void createDefaultNickTable()
  {
    this.qmDefaultNickTable = new UITableView(this);
    this.qmDefaultNickTable.setDescription(2131719641);
    this.mSettingView.addContentView(this.qmDefaultNickTable);
    this.defaultNickItemView = this.qmDefaultNickTable.addItem(2131719930);
    this.defaultNickItemView.setResponedWithBgState(false);
    this.nick = QMComposeDataManager.sharedInstance().getQMDefaultNick(this.account.getId());
    if (this.nick != null) {
      this.defaultNickItemView.setDetail(this.nick);
    }
    for (;;)
    {
      this.defaultNickItemView.hideArrow();
      this.qmDefaultNickTable.setClickListener(this.defaultNickTableOnClickListener);
      this.qmDefaultNickTable.commit();
      initNickNameEditText();
      return;
      Threads.runInBackground(new SettingQmDefaultNickActivity.1(this));
    }
  }
  
  public static Intent createIntent(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingQmDefaultNickActivity.class);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_nick", paramString);
    return localIntent;
  }
  
  private void editNickName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.defaultNickItemView.setEnabled(false);
      this.defaultNickItemView.hideDetailView();
      this.defaultNickItemView.limitDetailWidth(true);
      this.nickNameEditText.setVisibility(0);
      this.nickNameEditText.requestFocus();
      this.nickNameEditText.setSelection(this.nickNameEditText.getText().length());
      ((InputMethodManager)this.nickNameEditText.getContext().getSystemService("input_method")).showSoftInput(this.nickNameEditText, 0);
      return;
    }
    this.defaultNickItemView.setEnabled(true);
    this.nickNameEditText.setVisibility(8);
    this.defaultNickItemView.showDetailView();
    this.defaultNickItemView.limitDetailWidth(false);
  }
  
  private void hideKB(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void initNickNameEditText()
  {
    this.nickNameEditText = new EditText(this);
    int i = getResources().getDimensionPixelSize(2131299392);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 1.0F);
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = QMUIKit.dpToPx(30);
    localLayoutParams.rightMargin = (-i);
    localLayoutParams.bottomMargin = 1;
    setEditTextFilter(this.nickNameEditText, 32);
    this.nickNameEditText.setLayoutParams(localLayoutParams);
    this.nickNameEditText.setBackgroundColor(0);
    this.nickNameEditText.setPadding(0, 0, i, 0);
    this.nickNameEditText.setSingleLine(true);
    this.nickNameEditText.setText(QMComposeDataManager.sharedInstance().getQMDefaultNick(this.account.getId()));
    this.nickNameEditText.setTextSize(2, 14.0F);
    this.nickNameEditText.setTextColor(getResources().getColor(2131167535));
    this.nickNameEditText.setGravity(21);
    this.nickNameEditText.setVisibility(8);
    this.nickNameEditText.setImeOptions(6);
    this.nickNameEditText.addTextChangedListener(new SettingQmDefaultNickActivity.4(this));
    this.mSettingView.addOnCompleteInputListener(this.nickNameEditText, new SettingQmDefaultNickActivity.5(this));
    this.defaultNickItemView.addView(this.nickNameEditText);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131689742);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveNickName()
  {
    if (this.isNickChanged)
    {
      DataCollector.logEvent("Event_Compose_Set_Sender_Nick");
      this.isNickChanged = false;
      QMComposeDataManager.sharedInstance().setQMDefaultNick(this.account.getId(), this.nick);
      QMCallback localQMCallback = new QMCallback();
      localQMCallback.setOnSuccess(new SettingQmDefaultNickActivity.6(this));
      localQMCallback.setOnError(new SettingQmDefaultNickActivity.7(this));
      QMAliasManager.shareInstance().syncQMAccountDefaultNick(this.account.getId(), this.nick, localQMCallback);
    }
  }
  
  public void finish()
  {
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      startActivity(SettingAccountActivity.createIntent(this.accountId));
      overridePendingTransition(2130772421, 2130772420);
    }
    super.finish();
  }
  
  public void initDataSource()
  {
    this.nick = getIntent().getStringExtra("arg_nick");
    this.accountId = getIntent().getIntExtra("arg_account_id", 0);
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
  }
  
  public void initDom()
  {
    initTopBar();
    createDefaultNickTable();
    this.mAliasTable = new UITableView(this);
    this.mSettingView.addContentView(this.mAliasTable);
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackground()
  {
    hideKB(this.defaultNickItemView);
    saveNickName();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      int i = getResources().getDimensionPixelSize(2131299377);
      this.defaultNickItemView.getDetailView().setMaxWidth(this.defaultNickItemView.getWidth() - i);
    }
  }
  
  public void refreshData()
  {
    this.aliasItems = QMComposeDataManager.sharedInstance().getQMAliasItems(this.account.getId());
  }
  
  public void render()
  {
    if (this.defaultNickItemView == null) {
      createDefaultNickTable();
    }
    this.defaultNickItemView.setDetail(this.nick);
    createAliasTable();
  }
  
  public void setEditTextFilter(EditText paramEditText, int paramInt)
  {
    paramEditText.setFilters(new InputFilter[] { new CountInputFilter(paramInt) });
  }
  
  public class CountInputFilter
    implements InputFilter
  {
    private int mMaxCount;
    
    public CountInputFilter(int paramInt)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        this.mMaxCount = paramInt;
        return;
        paramInt = 0;
      }
    }
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      Object localObject = paramCharSequence;
      if (paramSpanned.toString().length() + paramCharSequence.toString().length() > this.mMaxCount)
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), "昵称不能超过" + this.mMaxCount + "个字符", 0).show();
        localObject = "";
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity
 * JD-Core Version:    0.7.0.1
 */