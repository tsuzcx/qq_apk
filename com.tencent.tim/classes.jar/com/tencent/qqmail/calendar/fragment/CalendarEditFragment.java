package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.view.CalendarColorItemView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableFormItemView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class CalendarEditFragment
  extends CalendarScrollBaseFragment
{
  private final int EDIT_TYPE_CREATE = 0;
  private final int EDIT_TYPE_MODIFY = 1;
  private Account account;
  private QMCalendarFolder calendarFolder;
  private EditText editText;
  private int editType;
  private int mSelectColor = -1;
  
  protected CalendarEditFragment(Account paramAccount)
  {
    this.editType = 0;
    this.account = paramAccount;
    this.calendarFolder = new QMCalendarFolder();
    this.calendarFolder.setColor(QMCalendarManager.getInstance().getColorForNewCalendar(paramAccount.getId()));
  }
  
  protected CalendarEditFragment(QMCalendarFolder paramQMCalendarFolder)
  {
    this.editType = 1;
    this.calendarFolder = paramQMCalendarFolder;
  }
  
  private void addCalendarFolder()
  {
    QMCalendarFolder localQMCalendarFolder = new QMCalendarFolder();
    localQMCalendarFolder.setCollectionId("");
    localQMCalendarFolder.setParentId("0");
    localQMCalendarFolder.setAccountId(this.account.getId());
    localQMCalendarFolder.setAccountName("");
    localQMCalendarFolder.setAccountType("");
    localQMCalendarFolder.setName(this.editText.getText().toString());
    localQMCalendarFolder.setPath("");
    localQMCalendarFolder.setcTag("");
    localQMCalendarFolder.setSyncToken("");
    localQMCalendarFolder.setSyncKey("0");
    localQMCalendarFolder.setShareOwner("");
    localQMCalendarFolder.setType(13);
    localQMCalendarFolder.setCategory(0);
    localQMCalendarFolder.setColor(this.mSelectColor);
    localQMCalendarFolder.setIsShow(true);
    localQMCalendarFolder.setIsEditable(true);
    localQMCalendarFolder.setOffLineOptType(3);
    localQMCalendarFolder.setShareList(new ArrayList());
    localQMCalendarFolder.setId(QMCalendarFolder.generateTmpId(localQMCalendarFolder));
    localQMCalendarFolder.setCreateTime(System.currentTimeMillis());
    QMCalendarManager.getInstance().addCalendarFolder(localQMCalendarFolder);
  }
  
  private boolean canEditCalendarFolder()
  {
    if (!this.calendarFolder.isEditable()) {}
    do
    {
      do
      {
        return false;
      } while (!this.calendarFolder.isSelfFolder());
      if (this.calendarFolder.isLocalFolder()) {
        return true;
      }
    } while (!QMCalendarManager.getInstance().isActiveSyncAccount(this.calendarFolder.getAccountId()));
    return this.calendarFolder.isActiveSyncCalendarFolder();
  }
  
  private void createColorTableView()
  {
    QMRadioGroup localQMRadioGroup = new QMRadioGroup(getActivity());
    this.mContainer.addView(localQMRadioGroup);
    localQMRadioGroup.setCaption(2131691056);
    int j = QMUIHelper.getCalendarColor(getActivity(), this.calendarFolder);
    int i = 0;
    Object localObject;
    while (i < QMUIHelper.getCalendarColorCount())
    {
      int k = QMUIHelper.getCalendarColorByIndex(getActivity(), i);
      localObject = QMUIHelper.getCalendarColorName(getActivity(), i);
      localObject = new CalendarColorItemView(getActivity(), (String)localObject, k);
      ((CalendarColorItemView)localObject).setTag(Integer.valueOf(i));
      ((CalendarColorItemView)localObject).setTailImage(2130840882).setVisibility(4);
      localQMRadioGroup.addItem((UITableItemView)localObject);
      if (k == j) {
        this.mSelectColor = i;
      }
      i += 1;
    }
    if (this.mSelectColor == -1)
    {
      this.mSelectColor = this.calendarFolder.getColor();
      localObject = new CalendarColorItemView(getActivity(), "自定义", this.mSelectColor);
      ((CalendarColorItemView)localObject).setTag(Integer.valueOf(this.mSelectColor));
      localQMRadioGroup.addItem((UITableItemView)localObject);
      ((CalendarColorItemView)localObject).setTailImage(2130840882).setVisibility(4);
    }
    localQMRadioGroup.setOnCheckedChangeListener(new CalendarEditFragment.5(this));
    localQMRadioGroup.setClickListenerWithoutSelector();
    localQMRadioGroup.commit();
    localQMRadioGroup.setSelectedItem(this.mSelectColor);
  }
  
  private void createNameTableView()
  {
    UITableView localUITableView = new UITableView(getActivity());
    localUITableView.setCaption(2131691091);
    this.mContainer.addView(localUITableView);
    this.editText = localUITableView.addFormItem(new UITableFormItemView(getActivity())).addEditText(2131691075);
    this.editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    this.editText.addTextChangedListener(new CalendarEditFragment.3(this));
    if (this.editType == 0)
    {
      this.editText.setText("");
      this.editText.requestFocus();
      this.editText.postDelayed(new CalendarEditFragment.4(this), 300L);
    }
    for (;;)
    {
      localUITableView.commit();
      return;
      if (this.editType == 1)
      {
        this.editText.setText(this.calendarFolder.getName());
        if (canEditCalendarFolder())
        {
          this.editText.setEnabled(true);
        }
        else
        {
          this.editText.setEnabled(false);
          this.editText.setTextColor(getResources().getColor(2131165860));
        }
      }
    }
  }
  
  private void updateCalendarFolderColor()
  {
    if ((this.calendarFolder.isLocalFolder()) && (QMUIHelper.getCalendarColorByIndex(getActivity(), this.mSelectColor) != this.calendarFolder.getColor())) {
      CalendarProviderManager.sharedInstance().updateCalendarFolderColor(this.calendarFolder, QMUIHelper.getCalendarColorByIndex(getActivity(), this.mSelectColor));
    }
    while (QMUIHelper.getCalendarColor(getActivity(), this.calendarFolder) == this.mSelectColor) {
      return;
    }
    QMCalendarManager.getInstance().updateCalendarFolderColor(this.calendarFolder, this.mSelectColor);
  }
  
  private void updateCalendarFolderName()
  {
    String str = this.editText.getText().toString().trim();
    if (!this.calendarFolder.getName().equals(str))
    {
      this.calendarFolder.setName(str);
      if (this.calendarFolder.isLocalFolder()) {
        CalendarProviderManager.sharedInstance().updateCalendarFolderName(this.calendarFolder, str);
      }
    }
    else
    {
      return;
    }
    QMCalendarManager.getInstance().updateCalendarFolder(this.calendarFolder);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    createNameTableView();
    createColorTableView();
  }
  
  public void initTopbar(View paramView)
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.editType == 0) {}
    for (paramView = getString(2131691064);; paramView = "")
    {
      localQMTopBar.setTitle(paramView);
      localQMTopBar.setButtonLeftNormal(2131691246);
      localQMTopBar.setButtonRightBlue(2131693745);
      localQMTopBar.setButtonLeftOnclickListener(new CalendarEditFragment.1(this));
      localQMTopBar.setButtonRightOnclickListener(new CalendarEditFragment.2(this));
      return;
    }
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onRelease()
  {
    super.onRelease();
    if (this.editText != null) {
      KeyBoardHelper.hideKeyBoard(this.editText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarEditFragment
 * JD-Core Version:    0.7.0.1
 */