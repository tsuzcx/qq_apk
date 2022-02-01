package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.bottle.controller.BottlerController.MyInformationUpdatedWatcher;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class SettingBottleActivity
  extends BaseActivityEx
{
  private static final String TAG = "SettingBottleActivity";
  private int accountId = -1;
  private QMAvatar avatar;
  private Bitmap avatarBitmap;
  private UITableItemView avatarItemView;
  private final UITableView.ClickListener bottleTableOnClickListener = new SettingBottleActivity.5(this);
  private boolean checked;
  private UITableItemView defaultAccountItemView;
  private UITableItemView genderItemView;
  private boolean isAvatarChanged = false;
  private AvatarSelector mAvatarSelector;
  private UITableView mBottleTable;
  private final BottlerController.MyInformationUpdatedWatcher mInformationUpdateWatch = new SettingBottleActivity.3(this);
  private QMBaseView mSettingView;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private UITableItemView nickItemView;
  private EditText nickNameEditText;
  private UITableItemView showItemView;
  private UITableView.ClickListener showTableClickListener = new SettingBottleActivity.4(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingBottleActivity.6(this);
  
  private void createBottleTable()
  {
    this.mBottleTable = new UITableView(this);
    this.mSettingView.addContentView(this.mBottleTable);
    this.defaultAccountItemView = this.mBottleTable.addItem(2131691002);
    this.defaultAccountItemView.setDetail("");
    this.accountId = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    Account localAccount;
    if (this.accountId != -1)
    {
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      if (getQQAccountNum() >= 2) {
        break label251;
      }
      this.defaultAccountItemView.setDetail(localAccount.getEmail(), UITableItemView.STYLE_GRAY);
      this.defaultAccountItemView.setEnabled(false);
    }
    for (;;)
    {
      if (getQQAccountNum() < 2) {
        this.defaultAccountItemView.setEnabled(false);
      }
      this.avatarItemView = this.mBottleTable.addItem(2131691001);
      this.avatar = new QMAvatar(0);
      this.avatarItemView.setDetail(this.avatar.getBitmap());
      this.avatarItemView.hideArrow();
      this.nickItemView = this.mBottleTable.addItem(2131691007);
      this.nickItemView.setDetail("");
      this.nickItemView.limitDetailWidth(true);
      this.nickItemView.hideArrow();
      this.genderItemView = this.mBottleTable.addItem(2131691004);
      this.genderItemView.setDetail("");
      this.mBottleTable.setClickListener(this.bottleTableOnClickListener);
      this.mBottleTable.commit();
      initNickNameEditText();
      return;
      label251:
      this.defaultAccountItemView.setDetail(localAccount.getEmail());
    }
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingBottleActivity.class);
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.mShowTable.setClickListener(this.showTableClickListener);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-16)) == -1) {
      this.showItemView.setChecked(true);
    }
    for (;;)
    {
      this.mShowTable.commit();
      return;
      this.showItemView.setChecked(false);
    }
  }
  
  private void createStatusTable()
  {
    this.checked = true;
    this.mStatusTable = new UITableView(this);
    this.mSettingView.addContentView(this.mStatusTable);
    this.statusItemView = this.mStatusTable.addItem(2131690982);
    this.checked = QMSettingManager.sharedInstance().isBottleEnabled();
    this.statusItemView.setChecked(this.checked);
    this.mStatusTable.setClickListener(this.statusTableClickListener);
    this.mStatusTable.commit();
  }
  
  private void editNickName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.nickItemView.setEnabled(false);
      this.nickItemView.getChildAt(1).setVisibility(8);
      this.nickNameEditText.setVisibility(0);
      this.nickNameEditText.requestFocus();
      this.nickNameEditText.setSelection(this.nickNameEditText.getText().length());
      ((InputMethodManager)this.nickNameEditText.getContext().getSystemService("input_method")).showSoftInput(this.nickNameEditText, 0);
      return;
    }
    this.nickItemView.setEnabled(true);
    this.nickNameEditText.setVisibility(8);
    this.nickItemView.getChildAt(1).setVisibility(0);
  }
  
  private int getQQAccountNum()
  {
    return AccountManager.shareInstance().getAccountList().getPureQQMailAccountNumber();
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
    this.nickNameEditText.setLayoutParams(localLayoutParams);
    this.nickNameEditText.setPadding(0, 0, i, 0);
    this.nickNameEditText.setBackgroundColor(0);
    this.nickNameEditText.setSingleLine(true);
    this.nickNameEditText.setTextSize(2, 16.0F);
    this.nickNameEditText.setTextColor(getResources().getColor(2131167535));
    this.nickNameEditText.setGravity(21);
    this.nickNameEditText.setVisibility(8);
    this.nickNameEditText.setImeOptions(6);
    this.nickNameEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(10) });
    this.nickItemView.addView(this.nickNameEditText);
    this.mSettingView.addOnCompleteInputListener(this.nickNameEditText, new SettingBottleActivity.8(this));
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131690982);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void saveGender(boolean paramBoolean)
  {
    if (BottleManager.available()) {
      BottleManager.getInstance().getBottlerController().submitMyGender(paramBoolean);
    }
  }
  
  private void saveNickName()
  {
    String str = this.nickNameEditText.getText().toString();
    if (BottleManager.available()) {
      BottleManager.getInstance().getBottlerController().submitMyInformcation(str, null);
    }
  }
  
  private void selectGenderPopup()
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.addItem(2130840821, getString(2131691006), getString(2131691006));
    localBottomListSheetBuilder.addItem(2130840818, getString(2131691005), getString(2131691005));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new SettingBottleActivity.7(this));
    localBottomListSheetBuilder.build().show();
  }
  
  private void setInformation(Bottler paramBottler)
  {
    this.nickItemView.setDetail(paramBottler.getName());
    this.nickNameEditText.setText(paramBottler.getName());
    UITableItemView localUITableItemView = this.genderItemView;
    if (paramBottler.isMale()) {}
    for (String str = getString(2131691006);; str = getString(2131691005))
    {
      localUITableItemView.setDetail(str);
      try
      {
        BottleManager.getInstance().loadAvatar(paramBottler.getAvatar(), paramBottler.getUin(), 0, new SettingBottleActivity.2(this));
        return;
      }
      catch (Exception paramBottler)
      {
        QMLog.log(6, "SettingBottleActivity", paramBottler.getMessage());
      }
    }
  }
  
  public void initDataSource()
  {
    if (BottleManager.available()) {
      BottleManager.getInstance().getBottlerController().refreshMyInformation();
    }
  }
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
    createBottleTable();
    this.mAvatarSelector = new AvatarSelector(getBaseActivityImpl(), new SettingBottleActivity.1(this));
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.mAvatarSelector != null) && (this.mAvatarSelector.onActivityResult(paramInt1, paramInt2, paramIntent))) {}
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    if (BottleManager.available()) {
      BottleManager.getInstance().getBottlerController().bindMyInformationUpdatedWatcher(this.mInformationUpdateWatch, paramBoolean);
    }
  }
  
  public void onButtonBackClick()
  {
    if ((this.statusItemView != null) && (this.statusItemView.isChecked())) {
      saveNickName();
    }
    finish();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onRelease()
  {
    this.mAvatarSelector.recyle();
  }
  
  public void refreshData()
  {
    this.accountId = QMSettingManager.sharedInstance().getDefaultBottleAccountID();
    if ((SettingActivity.ADDACCOUNT == SettingActivity.ADDING) && (getQQAccountNum() > 0))
    {
      QMSettingManager.sharedInstance().setBottleDisplay(true);
      this.statusItemView.setChecked(true);
      SettingActivity.ADDACCOUNT = SettingActivity.ADDSUCCESS;
      this.checked = QMSettingManager.sharedInstance().isBottleEnabled();
      if (!this.checked) {
        break label180;
      }
      this.mBottleTable.setVisibility(0);
      this.mShowTable.setVisibility(0);
    }
    for (;;)
    {
      Object localObject;
      if (this.accountId != -1)
      {
        localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
        this.defaultAccountItemView.setDetail(((Account)localObject).getEmail());
      }
      if (BottleManager.available())
      {
        localObject = BottleManager.getInstance().getBottlerController().getMyInformation();
        setInformation((Bottler)localObject);
        if (BottlerController.isAlias(((Bottler)localObject).getUin())) {
          BottleManager.getInstance().getBottlerController().refreshMyInformation();
        }
      }
      return;
      if ((SettingActivity.ADDACCOUNT != SettingActivity.ADDING) || (getQQAccountNum() != 0)) {
        break;
      }
      SettingActivity.ADDACCOUNT = SettingActivity.NOADD;
      break;
      label180:
      this.mBottleTable.setVisibility(4);
      this.mShowTable.setVisibility(4);
    }
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity
 * JD-Core Version:    0.7.0.1
 */