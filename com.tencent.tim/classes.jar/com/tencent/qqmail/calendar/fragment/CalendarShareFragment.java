package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeAddrView;
import com.tencent.qqmail.activity.compose.ComposeAddrView.ComposeAddrViewCallback;
import com.tencent.qqmail.activity.compose.ComposeContactsActivity;
import com.tencent.qqmail.activity.compose.MailAddrsViewControl;
import com.tencent.qqmail.activity.compose.MailAddrsViewControl.MailAddressAdapter;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.watcher.CalendarShareWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.mail.watcher.LoadContactListWatcher;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.model.verify.QMVerifyImageDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateEmail;
import com.tencent.qqmail.utilities.validate.ValidateEmail.EmailException;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;
import org.apache.commons.lang3.StringUtils;

public class CalendarShareFragment
  extends CalendarBaseFragment
  implements ComposeAddrView.ComposeAddrViewCallback
{
  private QMCalendarFolder calendarFolder;
  private QMGetVerifyImageWatcher getVerifyImageWatcher = new CalendarShareFragment.2(this);
  private LoadContactListWatcher loadContactListWatcher = new CalendarShareFragment.1(this);
  private ComposeAddrView mMailAddressAddView;
  private int retryVerifyCount = 0;
  private CalendarShareWatcher shareWatcher = new CalendarShareFragment.3(this);
  private QMVerifyImageDialog verifyDialog;
  
  protected CalendarShareFragment(QMCalendarFolder paramQMCalendarFolder)
  {
    super(false);
    this.calendarFolder = paramQMCalendarFolder;
  }
  
  private void bindTouchListener()
  {
    this.mMailAddressAddView.getAddrsViewControl().setMOnTouchListener(new CalendarShareFragment.4(this));
  }
  
  private int[] getAccountIds()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int[] arrayOfInt = new int[localAccountList.size()];
    int i = 0;
    while (i < localAccountList.size())
    {
      arrayOfInt[i] = localAccountList.get(i).getId();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private ArrayList<String> getEmailList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.mMailAddressAddView.getContactList();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof MailContact)) {
          localArrayList.add(((MailContact)localObject2).getAddress());
        }
      }
    }
    return localArrayList;
  }
  
  private void handleNewSelectedAddress(boolean paramBoolean)
  {
    MailAddrsViewControl localMailAddrsViewControl = this.mMailAddressAddView.getAddrsViewControl();
    if (!paramBoolean)
    {
      localMailAddrsViewControl.requestInputAreaFocusDelayed(100L);
      return;
    }
    localMailAddrsViewControl.insertMailAddrs(ComposeContactsActivity.getAllCheckedContacts());
    localMailAddrsViewControl.requestInputAreaFocusDelayed(100L);
  }
  
  private void handleShareCalendar()
  {
    this.retryVerifyCount = 0;
    this.mMailAddressAddView.setFocused(false);
    ArrayList localArrayList1 = getEmailList();
    ArrayList localArrayList2 = validateAddress(localArrayList1);
    if (!localArrayList2.isEmpty()) {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131721116)).setMessage(getString(2131691171) + "\n" + StringUtils.join(localArrayList2, ",")).addAction(2131696547, new CalendarShareFragment.11(this))).create().show();
    }
    while (localArrayList1.isEmpty()) {
      return;
    }
    QMCalendarManager.getInstance().shareCalendarFolder(this.calendarFolder, (String[])localArrayList1.toArray(new String[localArrayList1.size()]), null);
  }
  
  private void loadContacts()
  {
    QMContactManager.sharedInstance().loadAccountContacts(getAccountIds());
    showContacts();
  }
  
  private void showContacts()
  {
    Threads.runInBackground(new CalendarShareFragment.10(this));
  }
  
  private void updateContactArray(List<MailContact> paramList)
  {
    MailAddrsViewControl.MailAddressAdapter localMailAddressAdapter = this.mMailAddressAddView.getAddrsViewControl().getAdapter();
    if (localMailAddressAdapter != null)
    {
      localMailAddressAdapter.updateLocalContacts(paramList);
      localMailAddressAdapter.updateRemoteContacts(new ArrayList());
      localMailAddressAdapter.refreshData();
    }
    for (;;)
    {
      QMUIHelper.triggerFilteringForAutoCompleteTextView(this.mMailAddressAddView.getAddrsViewControl().getInputATV());
      return;
      paramList = new MailAddrsViewControl.MailAddressAdapter(getActivity(), paramList, new ArrayList());
      this.mMailAddressAddView.getAddrsViewControl().setAddrsAdapter(paramList);
    }
  }
  
  private ArrayList<String> validateAddress(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      try
      {
        ValidateEmail.composeMailValidateAddr(str);
      }
      catch (ValidateEmail.EmailException localEmailException)
      {
        localArrayList.add(str);
      }
    }
    return localArrayList;
  }
  
  public void addrViewScrollChanged(ComposeAddrView paramComposeAddrView) {}
  
  public void addrViewTextChanged(ComposeAddrView paramComposeAddrView, String paramString)
  {
    ArrayList localArrayList = paramComposeAddrView.getAddrsViewControl().getMailAddrs();
    if (("".equals(paramString)) && ((localArrayList == null) || (localArrayList.size() == 0))) {
      getTopBar().getButtonRight().setEnabled(false);
    }
    for (;;)
    {
      paramComposeAddrView = paramComposeAddrView.getAddrsViewControl().getInputATV();
      if ((localArrayList == null) || (localArrayList.size() <= 0)) {
        break;
      }
      paramComposeAddrView.setHint("");
      return;
      getTopBar().getButtonRight().setEnabled(true);
    }
    paramComposeAddrView.setHint(2131691165);
  }
  
  public void clickAddContactButton(ComposeAddrView paramComposeAddrView)
  {
    startActivityForResult(new Intent(getActivity(), ComposeContactsActivity.class), 0);
  }
  
  public void clickedAddGroupContactButton(ComposeAddrView paramComposeAddrView) {}
  
  public void enterForClearFocus(ComposeAddrView paramComposeAddrView, boolean paramBoolean) {}
  
  public void initDataSource() {}
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    this.mMailAddressAddView.postDelayed(new CalendarShareFragment.7(this), 300L);
  }
  
  public void initTopbar(View paramView)
  {
    paramView = getTopBar();
    paramView.setTitle(2131691164);
    paramView.setButtonLeftNormal(2131691246);
    paramView.setButtonRightBlue(2131719473);
    paramView.setButtonLeftOnclickListener(new CalendarShareFragment.5(this));
    paramView.setButtonRightOnclickListener(new CalendarShareFragment.6(this));
    paramView.getButtonRight().setEnabled(false);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (FrameLayout)super.initUI(paramViewHolder);
    paramViewHolder.setBackgroundColor(getResources().getColor(2131166570));
    LayoutInflater.from(getActivity()).inflate(2131558812, paramViewHolder, true);
    this.mMailAddressAddView = ((ComposeAddrView)paramViewHolder.findViewById(2131365130));
    this.mMailAddressAddView.setTotalWidth(QMUIKit.getScreenWidth());
    this.mMailAddressAddView.init(false);
    this.mMailAddressAddView.getAddrsViewControl().setExpanded(true);
    this.mMailAddressAddView.setiType(1);
    this.mMailAddressAddView.setHasAddImage(true);
    this.mMailAddressAddView.setCallback(this);
    this.mMailAddressAddView.setVisibility(0);
    bindTouchListener();
    return paramViewHolder;
  }
  
  public void inputClickChanged(ComposeAddrView paramComposeAddrView) {}
  
  public void inputFocusChanged(ComposeAddrView paramComposeAddrView, boolean paramBoolean)
  {
    paramComposeAddrView = paramComposeAddrView.getmContactImage();
    if (!paramBoolean) {
      if (paramComposeAddrView != null) {
        paramComposeAddrView.setVisibility(4);
      }
    }
    while (paramComposeAddrView == null) {
      return;
    }
    paramComposeAddrView.setVisibility(0);
    QMUIKit.expendTouchArea(paramComposeAddrView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramInt2 == -1) {}
    for (boolean bool = true;; bool = false)
    {
      handleNewSelectedAddress(bool);
      return;
    }
  }
  
  public void onBackPressed()
  {
    hideKeyBoard();
    this.mMailAddressAddView.setFocused(false);
    ArrayList localArrayList = this.mMailAddressAddView.getContactList();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131691169).addAction(2131691246, new CalendarShareFragment.9(this))).addAction(2131696547, new CalendarShareFragment.8(this))).create().show();
      return;
    }
    popBackStack();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadContactListWatcher, paramBoolean);
    Watchers.bind(this.getVerifyImageWatcher, paramBoolean);
    Watchers.bind(this.shareWatcher, paramBoolean);
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    return SCALE_TRANSITION_CONFIG;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    loadContacts();
    return 0;
  }
  
  public void render(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarShareFragment
 * JD-Core Version:    0.7.0.1
 */