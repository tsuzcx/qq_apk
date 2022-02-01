package com.tencent.qqmail.calendar.fragment;

import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMCalendarShare;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager;
import com.tencent.qqmail.calendar.model.QMCalendarProtocolManager.LoginType;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.view.CalendarTableItemView;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.calendar.watcher.CalendarFolderCreateWatcher;
import com.tencent.qqmail.calendar.watcher.CalendarFolderDeleteWatcher;
import com.tencent.qqmail.calendar.watcher.CalendarFolderUpdateWatcher;
import com.tencent.qqmail.calendar.watcher.CalendarShareWatcher;
import com.tencent.qqmail.calendar.watcher.CalendarStopShareWatcher;
import com.tencent.qqmail.calendar.watcher.LoadCalendarListWatcher;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMToggleView;
import com.tencent.qqmail.utilities.ui.QMToggleView.QMToggleViewCallback;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.UITableItemFactory;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class CalendarListFragment
  extends CalendarScrollBaseFragment
{
  protected static final int FROM_LIST = 0;
  protected static final int FROM_SETTING = 1;
  protected static final int FROM_SHARE = 2;
  private int aboveViewCntOfShareItem = 0;
  private HashMap<Integer, ArrayList<QMCalendarFolder>> accountFolderHashMap = new HashMap();
  private CalendarListType calendarListType = CalendarListType.CALENDAR_LIST;
  private QMToggleView calendarToggleView;
  private CalendarFolderCreateWatcher createWatcher = new CalendarListFragment.2(this);
  private int defaultFolderId = QMCalendarManager.getInstance().getDefaultFolderId();
  private CalendarFolderDeleteWatcher deleteWatcher = new CalendarListFragment.3(this);
  private HashMap<Integer, Boolean> folderCheckMap = new HashMap();
  private HashMap<Integer, Integer> folderIDANDAccountIDMap = new HashMap();
  private int from;
  private ArrayList<CalendarTableItemView> itemViews = new ArrayList();
  private LoadCalendarListWatcher loadListWatcher = new CalendarListFragment.1(this);
  private TextView mShowAll;
  private View mainView;
  private ArrayList<QMRadioGroup> radioGroups = new ArrayList();
  private int selectFolderId = this.defaultFolderId;
  private String shareCode;
  private CalendarTableItemView shareItemView;
  private CalendarShareWatcher shareWatcher = new CalendarListFragment.5(this);
  private int sharedAccountId;
  private CalendarStopShareWatcher stopShareWatcher = new CalendarListFragment.6(this);
  private QMToggleView.QMToggleViewCallback toggleViewCallback = new CalendarListFragment.9(this);
  private CalendarFolderUpdateWatcher updateWatcher = new CalendarListFragment.4(this);
  
  protected CalendarListFragment(int paramInt)
  {
    this.from = paramInt;
  }
  
  protected CalendarListFragment(String paramString, int paramInt)
  {
    this.from = 2;
    this.sharedAccountId = paramInt;
    this.shareCode = paramString;
  }
  
  private void animateAddPopup(int paramInt, View paramView)
  {
    CalendarListFragment.17 local17 = new CalendarListFragment.17(this, paramInt, paramView);
    local17.setAnimationListener(new CalendarListFragment.18(this));
    local17.setDuration(400);
    paramView.startAnimation(local17);
  }
  
  private void createCalendarTableView(Account paramAccount)
  {
    Object localObject = QMCalendarManager.getInstance().getSortedCalendarFoldersByAccountId(paramAccount.getId());
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      UITableView localUITableView = new UITableView(getActivity());
      if ((paramAccount.isQQMail()) && (AccountManager.shareInstance().getAccountList().getQQMailAccountNumber() == 1)) {
        localUITableView.setCaption(QMCalendarProtocolManager.getLoginTypeWithAccountTypeNone(paramAccount).getName());
      }
      for (;;)
      {
        this.mContainer.addView(localUITableView);
        this.accountFolderHashMap.put(Integer.valueOf(paramAccount.getId()), new ArrayList());
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((Iterator)localObject).next();
          CalendarTableItemView localCalendarTableItemView = new CalendarTableItemView(getActivity(), localQMCalendarFolder.getName().trim(), false, QMUIHelper.getCalendarColor(getActivity(), localQMCalendarFolder));
          localCalendarTableItemView.setIsLeftChecked(localQMCalendarFolder.isShow());
          if (QMCalendarManager.getInstance().isActiveSyncAccount(paramAccount.getId()))
          {
            localCalendarTableItemView.setTailImage(2130840890);
            ImageView localImageView = localCalendarTableItemView.getTailImage();
            LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
            localLayoutParams.height = -1;
            localLayoutParams.leftMargin = 0;
            localLayoutParams.rightMargin = (-QMUIKit.dpToPx(8));
            localImageView.setPadding(QMUIKit.dpToPx(8), 0, QMUIKit.dpToPx(8), 0);
            localImageView.setScaleType(ImageView.ScaleType.CENTER);
            localImageView.setOnClickListener(new CalendarListFragment.14(this, localQMCalendarFolder));
          }
          if ((localQMCalendarFolder.isShareReceiverFolder()) && (!localQMCalendarFolder.isShareSystemFolder()) && (!StringExtention.isNullOrEmpty(localQMCalendarFolder.getShareOwner())))
          {
            localCalendarTableItemView.setContent(String.format(getString(2131691078), new Object[] { localQMCalendarFolder.getShareOwner() }));
            if (isFollowCalendar(localQMCalendarFolder)) {
              this.shareItemView = localCalendarTableItemView;
            }
          }
          if ((localQMCalendarFolder.isShareOwnerFolder()) && (localQMCalendarFolder.getShareList() != null) && (localQMCalendarFolder.getShareList().size() > 0)) {
            localCalendarTableItemView.setContent(String.format(getString(2131691079), new Object[] { getShareListContent(localQMCalendarFolder.getShareList()) }));
          }
          localUITableView.addItem(localCalendarTableItemView);
          this.itemViews.add(localCalendarTableItemView);
          this.folderCheckMap.put(Integer.valueOf(localQMCalendarFolder.getId()), Boolean.valueOf(localQMCalendarFolder.isShow()));
          ((ArrayList)this.accountFolderHashMap.get(Integer.valueOf(paramAccount.getId()))).add(localQMCalendarFolder);
          if (this.shareItemView == null) {
            this.aboveViewCntOfShareItem += 1;
          }
        }
        localUITableView.setCaption(QMCalendarProtocolManager.getLoginTypeWithAccountTypeNone(paramAccount).getName() + "(" + paramAccount.getEmail() + ")");
      }
      localObject = new CalendarTableItemView(getActivity(), getString(2131691049), true, 0);
      if (QMCalendarManager.getInstance().isActiveSyncAccount(paramAccount.getId())) {
        localUITableView.addItem((UITableItemView)localObject);
      }
      localUITableView.setClickListener(new CalendarListFragment.15(this, (CalendarTableItemView)localObject, paramAccount));
      localUITableView.commit();
      if (this.shareItemView == null) {
        break label618;
      }
      paramAccount = new LinearLayout.LayoutParams(-1, 1);
      this.shareItemView.setLayoutParams(paramAccount);
      Threads.runOnMainThread(new CalendarListFragment.16(this), 300L);
    }
    label618:
    while (this.from != 2) {
      return;
    }
    getTips().showSuccess(2131691189, 1000L);
  }
  
  private void createDefaultCalendarView()
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(AccountManager.shareInstance().getAccountList().toArrayList());
    ((List)localObject1).add(QMCalendarManager.getInstance().getLocalAccount());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Account)((Iterator)localObject1).next();
      Object localObject3 = QMCalendarManager.getInstance().getSortedCalendarFoldersByAccountId(((Account)localObject2).getId());
      if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty()))
      {
        int i = 0;
        QMRadioGroup localQMRadioGroup = new QMRadioGroup(getActivity());
        Object localObject4;
        if (((Account)localObject2).getId() != 0)
        {
          localObject4 = QMCalendarProtocolManager.getLoginTypeWithAccountTypeNone((Account)localObject2);
          localQMRadioGroup.setCaption(((QMCalendarProtocolManager.LoginType)localObject4).getName() + "(" + ((Account)localObject2).getEmail() + ")");
        }
        for (;;)
        {
          localObject2 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (QMCalendarFolder)((Iterator)localObject2).next();
            int j = i;
            if (((QMCalendarFolder)localObject4).isEditable())
            {
              j = i;
              if (((QMCalendarFolder)localObject4).isSelfFolder())
              {
                j = 1;
                i = ((QMCalendarFolder)localObject4).getAccountId();
                int k = ((QMCalendarFolder)localObject4).getId();
                localObject3 = DrawBitmapUtil.drawCircle(getActivity(), QMUIHelper.getCalendarColor(getActivity(), (QMCalendarFolder)localObject4), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
                localObject4 = localQMRadioGroup.addItem(k, ((QMCalendarFolder)localObject4).getName()).getTitleView();
                ((TextView)localObject4).setCompoundDrawables((Drawable)localObject3, null, null, null);
                ((TextView)localObject4).setCompoundDrawablePadding(10);
                this.folderIDANDAccountIDMap.put(Integer.valueOf(k), Integer.valueOf(i));
              }
            }
            i = j;
          }
          localQMRadioGroup.setCaption(((Account)localObject2).getName());
        }
        localQMRadioGroup.setOnCheckedChangeListener(new CalendarListFragment.21(this));
        if (i != 0)
        {
          this.mContainer.addView(localQMRadioGroup);
          this.radioGroups.add(localQMRadioGroup);
        }
        localQMRadioGroup.commit();
        localQMRadioGroup.setSelectedItem(this.selectFolderId);
      }
    }
  }
  
  private void createLocalCalendarTableView()
  {
    Object localObject = QMCalendarManager.getInstance().getSortedCalendarFoldersByAccountId(0);
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      UITableView localUITableView = new UITableView(getActivity());
      localUITableView.setCaption(2131691080);
      this.mContainer.addView(localUITableView);
      this.accountFolderHashMap.put(Integer.valueOf(0), new ArrayList());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((Iterator)localObject).next();
        CalendarTableItemView localCalendarTableItemView = new CalendarTableItemView(getActivity(), localQMCalendarFolder.getName(), false, QMUIHelper.getCalendarColor(getActivity(), localQMCalendarFolder));
        localCalendarTableItemView.setIsLeftChecked(localQMCalendarFolder.isShow());
        localCalendarTableItemView.setTailImage(2130840890);
        localCalendarTableItemView.getTailImage().setOnClickListener(new CalendarListFragment.19(this, localQMCalendarFolder));
        localUITableView.addItem(localCalendarTableItemView);
        this.itemViews.add(localCalendarTableItemView);
        this.folderCheckMap.put(Integer.valueOf(localQMCalendarFolder.getId()), Boolean.valueOf(localQMCalendarFolder.isShow()));
        ((ArrayList)this.accountFolderHashMap.get(Integer.valueOf(0))).add(localQMCalendarFolder);
      }
      localUITableView.setClickListener(new CalendarListFragment.20(this));
      localUITableView.commit();
    }
  }
  
  private void createShowOrHideStateBtn()
  {
    this.mShowAll = UITableItemFactory.addCenterTextView(getActivity());
    this.mShowAll.setText(2131719702);
    this.mShowAll.setOnClickListener(new CalendarListFragment.13(this));
    this.mContainer.addView(this.mShowAll);
  }
  
  private void followCalendar()
  {
    if ((this.from == 2) && (this.sharedAccountId != 0) && (!StringExtention.isNullOrEmpty(this.shareCode)))
    {
      if (QMCalendarManager.getInstance().isExistAccountForCalendar(this.sharedAccountId)) {
        break label43;
      }
      showCalendarSettingDialog();
    }
    label43:
    Account localAccount;
    do
    {
      return;
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.sharedAccountId);
    } while (localAccount == null);
    String str2 = QMComposeDataManager.sharedInstance().getQMDefaultAlias(localAccount.getId());
    String str1 = str2;
    if (StringExtention.isNullOrEmpty(str2)) {
      str1 = localAccount.getEmail();
    }
    QMCalendarManager.getInstance().followShareCalendarFolder(localAccount.getId(), true, this.shareCode, str1);
  }
  
  private void initToggleView()
  {
    this.calendarToggleView = ((QMToggleView)LayoutInflater.from(getActivity()).inflate(2131561145, null));
    this.calendarToggleView.init();
    Object localObject = new FrameLayout.LayoutParams(-1, -1, 48);
    ((FrameLayout.LayoutParams)localObject).setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.calendarToggleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.calendarToggleView.setVisibility(4);
    this.calendarToggleView.setVerticalFadingEdgeEnabled(false);
    this.calendarToggleView.setToggleViewCallback(this.toggleViewCallback);
    localObject = getString(2131691206);
    String str = getString(2131719687);
    this.calendarToggleView.setData(new String[] { localObject, str });
    this.calendarToggleView.setSelectedRow(getString(2131691206));
    ((FrameLayout)this.mainView).addView(this.calendarToggleView);
  }
  
  private boolean isFollowCalendar(QMCalendarFolder paramQMCalendarFolder)
  {
    if ((this.from == 2) && (paramQMCalendarFolder.getId() == QMCalendarManager.getInstance().getNewestFollowFolderId()) && (this.shareItemView == null))
    {
      QMCalendarManager.getInstance().resetNewestFollowFolderId();
      return true;
    }
    return false;
  }
  
  private boolean isShowAll()
  {
    Iterator localIterator = this.folderCheckMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      if (!((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  private void onBack()
  {
    if (this.selectFolderId != this.defaultFolderId) {
      QMCalendarManager.getInstance().modifyDefaultAccountAndFolder(((Integer)this.folderIDANDAccountIDMap.get(Integer.valueOf(this.selectFolderId))).intValue(), this.selectFolderId);
    }
    popBackStack();
  }
  
  private void operationDone()
  {
    Threads.runOnMainThread(new CalendarListFragment.10(this));
  }
  
  private void render(CalendarListType paramCalendarListType)
  {
    if (paramCalendarListType == CalendarListType.CALENDAR_LIST)
    {
      renderCalendarList();
      return;
    }
    renderDefaultCalendarList();
  }
  
  private void renderCalendarList()
  {
    this.mContainer.removeAllViews();
    createShowOrHideStateBtn();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext()) {
      createCalendarTableView((Account)localIterator.next());
    }
    createLocalCalendarTableView();
    toggleShowOrHideStateBtn();
  }
  
  private void renderDefaultCalendarList()
  {
    this.mContainer.removeAllViews();
    createDefaultCalendarView();
  }
  
  private void showCalendarSettingDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131696424)).setMessage(2131691168).addAction(2131691246, new CalendarListFragment.12(this))).addAction(2131719634, new CalendarListFragment.11(this))).create().show();
  }
  
  private void toggleCalendarFragment()
  {
    if (this.calendarToggleView != null)
    {
      if (this.calendarToggleView.isHidden()) {
        this.calendarToggleView.show();
      }
    }
    else {
      return;
    }
    this.calendarToggleView.hide();
  }
  
  private void toggleShowAll(boolean paramBoolean)
  {
    this.folderCheckMap.clear();
    Iterator localIterator1 = this.accountFolderHashMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
      while (localIterator2.hasNext())
      {
        QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)localIterator2.next();
        this.folderCheckMap.put(Integer.valueOf(localQMCalendarFolder.getId()), Boolean.valueOf(paramBoolean));
      }
    }
    localIterator1 = this.itemViews.iterator();
    while (localIterator1.hasNext()) {
      ((CalendarTableItemView)localIterator1.next()).setIsLeftChecked(paramBoolean);
    }
  }
  
  private void toggleShowOrHideStateBtn()
  {
    TextView localTextView = this.mShowAll;
    if (isShowAll()) {}
    for (int i = 2131719689;; i = 2131719702)
    {
      localTextView.setText(i);
      return;
    }
  }
  
  private void updateData()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    Iterator localIterator = this.accountFolderHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((Iterator)localObject).next();
        Boolean localBoolean = (Boolean)this.folderCheckMap.get(Integer.valueOf(localQMCalendarFolder.getId()));
        if (localQMCalendarFolder.isLocalFolder())
        {
          if ((localBoolean != null) && (localBoolean.booleanValue() != localQMCalendarFolder.isShow()))
          {
            localArrayList4.add(Integer.valueOf(localQMCalendarFolder.getId()));
            localArrayList5.add(Integer.valueOf(i));
            localArrayList6.add(localBoolean);
          }
        }
        else if ((localBoolean != null) && (localBoolean.booleanValue() != localQMCalendarFolder.isShow()))
        {
          localArrayList1.add(Integer.valueOf(localQMCalendarFolder.getId()));
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(localBoolean);
        }
      }
    }
    QMCalendarManager.getInstance().updateCalendarFolderIsShow(localArrayList1, localArrayList2, localArrayList3);
    CalendarProviderManager.sharedInstance().updateCalendarFolderIsShow(localArrayList4, localArrayList5, localArrayList6);
  }
  
  public String getShareListContent(ArrayList<QMCalendarShare> paramArrayList)
  {
    String str = ((QMCalendarShare)paramArrayList.get(0)).getDisplayName();
    int i = 1;
    while (i < paramArrayList.size())
    {
      QMCalendarShare localQMCalendarShare = (QMCalendarShare)paramArrayList.get(i);
      str = str + ", " + localQMCalendarShare.getDisplayName();
      i += 1;
    }
    return str;
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    QMCalendarManager.getInstance().syncCalendar();
    followCalendar();
  }
  
  public void initTopbar(View paramView)
  {
    paramView = getTopBar();
    paramView.setCenterOnclickListener(new CalendarListFragment.7(this));
    if (this.from == 1) {
      paramView.setButtonLeftBack();
    }
    for (;;)
    {
      paramView.setButtonLeftOnclickListener(new CalendarListFragment.8(this));
      paramView.setTitle(2131691206);
      getTopBar().showArrow(true);
      return;
      paramView.setButtonLeftBack(2130841088);
    }
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mainView = super.initUI(paramViewHolder);
    if (this.from != 2) {
      initToggleView();
    }
    return this.mainView;
  }
  
  public void onBackPressed()
  {
    if ((this.calendarToggleView != null) && (!this.calendarToggleView.isHidden()))
    {
      this.calendarToggleView.hide();
      return;
    }
    if (this.selectFolderId != this.defaultFolderId) {
      QMCalendarManager.getInstance().modifyDefaultAccountAndFolder(((Integer)this.folderIDANDAccountIDMap.get(Integer.valueOf(this.selectFolderId))).intValue(), this.selectFolderId);
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    updateData();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    super.onBindEvent(paramBoolean);
    Watchers.bind(this.loadListWatcher, paramBoolean);
    Watchers.bind(this.createWatcher, paramBoolean);
    Watchers.bind(this.deleteWatcher, paramBoolean);
    Watchers.bind(this.updateWatcher, paramBoolean);
    Watchers.bind(this.shareWatcher, paramBoolean);
    Watchers.bind(this.stopShareWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (this.from == 1) || (this.from == 2);
  }
  
  public BaseFragment.TransitionConfig onFetchTransitionConfig()
  {
    if ((this.from == 1) || (this.from == 2)) {
      return SLIDE_TRANSITION_CONFIG;
    }
    return SCALE_TRANSITION_CONFIG;
  }
  
  public Object onLastFragmentFinish()
  {
    if (this.from == 1) {
      return SettingActivity.createIntent("from_none");
    }
    if (QMActivityManager.shareInstance().getActivitySize() <= 1)
    {
      if (AccountManager.shareInstance().getAccountList().size() == 1) {
        return MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      }
      return MailFragmentActivity.createIntentToAccountList();
    }
    return super.onLastFragmentFinish();
  }
  
  public int refreshData()
  {
    this.itemViews.clear();
    this.folderCheckMap.clear();
    this.accountFolderHashMap.clear();
    return super.refreshData();
  }
  
  public void render(int paramInt)
  {
    super.render(paramInt);
    render(this.calendarListType);
  }
  
  static enum CalendarListType
  {
    CALENDAR_LIST,  DEFAULT_CALENDAR_LIST;
    
    private CalendarListType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarListFragment
 * JD-Core Version:    0.7.0.1
 */