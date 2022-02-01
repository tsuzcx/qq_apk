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
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

public class SettingCardActivity
  extends BaseActivityEx
{
  private static final String TAG = "SettingCardActivity";
  private UITableItemView birthdayRemindItemView;
  private boolean checked;
  private UITableItemView defaultNameItemView;
  private UITableView.ClickListener defaultNameTableClickListener = new SettingCardActivity.5(this);
  private boolean isNickChanged = false;
  private UITableView mDefaultTable;
  private QMBaseView mSettingView;
  private UITableView mShowTable;
  private UITableView mStatusTable;
  private String nick;
  private EditText nickNameEditText;
  private UITableItemView showItemView;
  private UITableView.ClickListener showTableClickListener = new SettingCardActivity.2(this);
  private UITableItemView statusItemView;
  private UITableView.ClickListener statusTableClickListener = new SettingCardActivity.1(this);
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingCardActivity.class);
  }
  
  private void createShowTable()
  {
    this.mShowTable = new UITableView(this);
    this.mSettingView.addContentView(this.mShowTable);
    this.mShowTable.setClickListener(this.showTableClickListener);
    this.showItemView = this.mShowTable.addItem(2131719652);
    if (FolderDataManager.getInnerAppIdList().indexOf(Integer.valueOf(-23)) == -1) {
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
    this.mStatusTable = new UITableView(this);
    this.mSettingView.addContentView(this.mStatusTable);
    this.statusItemView = this.mStatusTable.addItem(2131691269);
    this.checked = QMSettingManager.sharedInstance().getCardDisplay();
    this.statusItemView.setChecked(this.checked);
    this.mStatusTable.setClickListener(this.statusTableClickListener);
    this.mStatusTable.commit();
  }
  
  private void editNickName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.defaultNameItemView.setEnabled(false);
      this.defaultNameItemView.hideDetailView();
      this.defaultNameItemView.limitDetailWidth(true);
      this.nickNameEditText.setVisibility(0);
      this.nickNameEditText.requestFocus();
      this.nickNameEditText.setSelection(this.nickNameEditText.getText().length());
      ((InputMethodManager)this.nickNameEditText.getContext().getSystemService("input_method")).showSoftInput(this.nickNameEditText, 0);
      return;
    }
    this.defaultNameItemView.setEnabled(true);
    this.nickNameEditText.setVisibility(8);
    this.defaultNameItemView.showDetailView();
    this.defaultNameItemView.limitDetailWidth(false);
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
    this.nickNameEditText.setText(this.nick);
    this.nickNameEditText.setTextSize(2, 14.0F);
    this.nickNameEditText.setTextColor(getResources().getColor(2131167535));
    this.nickNameEditText.setGravity(21);
    this.nickNameEditText.setVisibility(8);
    this.nickNameEditText.setImeOptions(6);
    this.nickNameEditText.addTextChangedListener(new SettingCardActivity.3(this));
    this.mSettingView.addOnCompleteInputListener(this.nickNameEditText, new SettingCardActivity.4(this));
    this.defaultNameItemView.addView(this.nickNameEditText);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(getString(2131691269));
    localQMTopBar.setButtonLeftBack();
  }
  
  public void createDefaultNameTable()
  {
    this.mDefaultTable = new UITableView(this);
    this.mSettingView.addContentView(this.mDefaultTable);
    this.mDefaultTable.setClickListener(this.defaultNameTableClickListener);
    this.defaultNameItemView = this.mDefaultTable.addItem(2131691319);
    this.defaultNameItemView.setResponedWithBgState(false);
    this.nick = CardUtil.getDefaultSendName();
    if (this.nick != null) {
      this.defaultNameItemView.setDetail(this.nick);
    }
    this.defaultNameItemView.hideArrow();
    this.birthdayRemindItemView = this.mDefaultTable.addItem(2131691318);
    this.birthdayRemindItemView.setChecked(QMSettingManager.sharedInstance().getCardBirthdayRemind());
    this.mDefaultTable.setClickListener(this.defaultNameTableClickListener);
    this.mDefaultTable.commit();
    initNickNameEditText();
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    initTopBar();
    createStatusTable();
    createShowTable();
    createDefaultNameTable();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackground()
  {
    hideKB(this.defaultNameItemView);
    CardUtil.setDefaultSendName(this.nick);
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
    if ((paramBoolean) && (this.defaultNameItemView.getDetailView() != null))
    {
      int i = getResources().getDimensionPixelSize(2131299377);
      this.defaultNameItemView.getDetailView().setMaxWidth(this.defaultNameItemView.getWidth() - i);
    }
  }
  
  public void refreshData() {}
  
  public void render()
  {
    if (this.checked)
    {
      this.mShowTable.setVisibility(0);
      this.mDefaultTable.setVisibility(0);
      return;
    }
    this.mShowTable.setVisibility(4);
    this.mDefaultTable.setVisibility(4);
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity
 * JD-Core Version:    0.7.0.1
 */