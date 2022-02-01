package com.tencent.qqmail.activity.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.alias.QMAliasManager;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import org.apache.commons.lang3.StringUtils;

public class SettingIndependentNickActivity
  extends BaseActivityEx
{
  public static final String TAG = "SettingIndependentNickActivity";
  private int accountId = -1;
  private String alias = null;
  private boolean checked = false;
  private UITableItemView composeNickItemView;
  private boolean detailViewFirstLoadIndicator = true;
  private String detailViewIntroWord = "";
  private UITableView.ClickListener independentNickTableClickListener = new SettingIndependentNickActivity.3(this);
  private boolean isNickChanged = false;
  private UITableView mIndependentNickTable;
  private QMBaseView mSettingView;
  private EditText nickEditText;
  private LinearLayout.LayoutParams nickEditTextEmptyLp;
  private LinearLayout.LayoutParams nickEditTextLp;
  private UITableItemView useIndependentNickItemView;
  
  private void editNickName(boolean paramBoolean)
  {
    if (this.nickEditText.getText().length() == 0) {
      paramBoolean = true;
    }
    if (paramBoolean)
    {
      this.composeNickItemView.setEnabled(false);
      if (this.nickEditText.getText().length() != 0) {
        this.composeNickItemView.hideDetailView();
      }
      for (;;)
      {
        this.composeNickItemView.limitDetailWidth(true);
        this.nickEditText.setVisibility(0);
        this.nickEditText.setSelection(this.nickEditText.getText().length());
        this.nickEditText.requestFocus();
        ((InputMethodManager)this.nickEditText.getContext().getSystemService("input_method")).showSoftInput(this.nickEditText, 0);
        return;
        this.composeNickItemView.setEnabled(true);
        togglerEmptyState(true);
      }
    }
    this.composeNickItemView.setEnabled(true);
    this.nickEditText.setVisibility(8);
    this.composeNickItemView.showDetailView();
    this.composeNickItemView.limitDetailWidth(false);
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(this.alias);
    localQMTopBar.setButtonLeftBack();
  }
  
  private void prepareEditText()
  {
    this.nickEditText = new EditText(this);
    int i = getResources().getDimensionPixelSize(2131299392);
    this.nickEditTextLp = new LinearLayout.LayoutParams(-2, -1, 1.0F);
    this.nickEditTextLp.gravity = 16;
    this.nickEditTextLp.leftMargin = QMUIKit.dpToPx(30);
    this.nickEditTextLp.rightMargin = (-i);
    this.nickEditTextLp.bottomMargin = 1;
    this.nickEditTextEmptyLp = new LinearLayout.LayoutParams(QMUIKit.dpToPx(16), -1);
    this.nickEditTextEmptyLp.gravity = 16;
    this.nickEditTextEmptyLp.rightMargin = (-i);
    this.nickEditTextEmptyLp.bottomMargin = 1;
    setEditTextFilter(this.nickEditText, 32);
    this.nickEditText.setLayoutParams(this.nickEditTextLp);
    this.nickEditText.setBackgroundColor(0);
    this.nickEditText.setPadding(0, 0, i, 0);
    this.nickEditText.setSingleLine(true);
    this.nickEditText.setTextSize(2, 14.0F);
    this.nickEditText.setTextColor(getResources().getColor(2131167535));
    this.nickEditText.setGravity(21);
    this.nickEditText.setVisibility(8);
    this.nickEditText.setImeOptions(6);
    this.composeNickItemView.addView(this.nickEditText);
  }
  
  private void prepareIndependentNickTable()
  {
    this.mIndependentNickTable = new UITableView(this);
    this.mIndependentNickTable.setDescription(2131719646);
    this.mSettingView.addContentView(this.mIndependentNickTable);
    this.useIndependentNickItemView = this.mIndependentNickTable.addItem(2131719642);
    this.useIndependentNickItemView.setChecked(false);
    this.composeNickItemView = this.mIndependentNickTable.addItem(2131689742);
    this.composeNickItemView.setResponedWithBgState(false);
    if (!StringUtils.isEmpty(QMComposeDataManager.sharedInstance().getQMAliasNick(this.alias, this.accountId))) {
      this.composeNickItemView.setDetail(QMComposeDataManager.sharedInstance().getQMAliasNick(this.alias, this.accountId));
    }
    for (;;)
    {
      this.composeNickItemView.hideArrow();
      this.mIndependentNickTable.setClickListener(this.independentNickTableClickListener);
      this.mIndependentNickTable.commit();
      return;
      this.composeNickItemView.setDetail("");
    }
  }
  
  private void togglerEmptyState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.composeNickItemView.showDetailView();
      this.composeNickItemView.setDetail(this.detailViewIntroWord);
      this.composeNickItemView.getDetailView().setTextColor(getResources().getColor(2131167531));
      this.nickEditText.setLayoutParams(this.nickEditTextEmptyLp);
      if (this.detailViewIntroWord == "") {
        this.detailViewIntroWord = getResources().getString(2131720009);
      }
      return;
    }
    this.composeNickItemView.hideDetailView();
    this.composeNickItemView.getDetailView().setTextColor(getResources().getColor(2131167535));
    this.nickEditText.setLayoutParams(this.nickEditTextLp);
  }
  
  private void updateNickEditText()
  {
    String str = QMComposeDataManager.sharedInstance().getQMAliasNick(this.alias, this.accountId);
    if (!StringUtils.isEmpty(str))
    {
      this.nickEditText.setText(str);
      this.composeNickItemView.setDetail(str);
    }
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.accountId = localIntent.getIntExtra("accountId", -1);
      this.alias = localIntent.getStringExtra("alias");
      if (!StringUtils.isEmpty(this.alias)) {
        this.alias = this.alias.replace("​", "");
      }
    }
    initTopBar();
    prepareIndependentNickTable();
    prepareEditText();
  }
  
  public void initUI()
  {
    this.mSettingView = initScrollView(this);
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    this.nickEditText.addTextChangedListener(new SettingIndependentNickActivity.1(this));
    this.mSettingView.addOnCompleteInputListener(this.nickEditText, new SettingIndependentNickActivity.2(this));
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.isNickChanged)
    {
      DataCollector.logEvent("Event_Compose_Set_Account_Nick");
      QMComposeDataManager.sharedInstance().setQMAliasNick(this.accountId, this.alias, this.nickEditText.getText().toString());
      QMCallback localQMCallback = new QMCallback();
      localQMCallback.setOnSuccess(new SettingIndependentNickActivity.5(this));
      localQMCallback.setOnError(new SettingIndependentNickActivity.6(this));
      QMAliasManager.shareInstance().syncQMAliasNick(this.alias, this.accountId, this.nickEditText.getText().toString(), localQMCallback);
    }
  }
  
  public void onRelease() {}
  
  public void refreshData()
  {
    this.checked = QMComposeDataManager.sharedInstance().getQMAliasIndep(this.alias, this.accountId);
  }
  
  public void render()
  {
    this.useIndependentNickItemView.setChecked(this.checked);
    if (this.detailViewFirstLoadIndicator)
    {
      this.detailViewFirstLoadIndicator = false;
      if (this.checked) {
        this.detailViewIntroWord = getResources().getString(2131720009);
      }
    }
    if (this.checked)
    {
      this.composeNickItemView.setVisibility(0);
      this.mSettingView.post(new SettingIndependentNickActivity.4(this));
      return;
    }
    this.composeNickItemView.setVisibility(8);
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
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity
 * JD-Core Version:    0.7.0.1
 */