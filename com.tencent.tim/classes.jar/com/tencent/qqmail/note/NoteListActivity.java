package com.tencent.qqmail.note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.NoteStorage;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteStatus;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.register.view.LinkTouchMovementMethod;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMToggleView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMListItemView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.sectionlist.SectionListAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class NoteListActivity
  extends BaseActivityEx
{
  public static final String NOTE_DATACHANGE = "NOTE_DATACHANGE";
  public static final String NOTE_LIST_DELETE_DONE = "NOTE_LIST_DELETE_DONE";
  private static final String NOTE_LIST_ERROR = "NOTE_LIST_ERROR";
  public static final String N_NOTE_TO_NORMALVIEW = "NOTE_TONORMALVIEW";
  public static final CharSequence QMAIL_SITE = "mail.qq.com";
  public static final String TAG = "NoteListActivity";
  public String ALGER_LIST_TAG = "ALGER_LIST_TAG";
  private int animationType;
  private Handler delAniHandler = new Handler();
  private Runnable delAniRunnable = new NoteListActivity.32(this);
  private ArrayList<String> deleteNotesIdList;
  private String filterIndex;
  private QMUnlockFolderPwdWatcher folderLockWacher = new NoteListActivity.4(this);
  private boolean isFolderLockBlocking = false;
  private boolean isFromNoteShortcutAndNoteInAppFolderList = false;
  private int lastIndex = -1;
  private int lastTop = -1;
  private TextView listEmptyLockTextView;
  protected QMContentLoadingView listEmptyView;
  private FolderLockDialog lockDialog;
  private boolean lockTextViewOnCancelTouch = false;
  protected StandardArrayAdapter mArrayAdapter = null;
  private QMBaseView mBaseView;
  private String mCatalogId = null;
  private String mCatalogName = null;
  @SuppressLint({"UseSparseArrays"})
  public HashMap<Integer, String> mCheckedNoteIds = new HashMap();
  private QMBottomBar mFooterbar;
  private final Handler mHandler = new Handler();
  protected LayoutInflater mInflater = null;
  public boolean mIsEditing = false;
  protected boolean mIsLoading;
  private boolean mIsSelectAll = false;
  protected View mLongClickItem = null;
  protected PtrListView mNoteListListView = null;
  private NoteUI mNoteUI = null;
  private PopularizeBanner mPopularizeBanner;
  private final Runnable mRenderErrorRunnable = new NoteListActivity.2(this);
  private final Runnable mRenderRunnable = new NoteListActivity.1(this);
  protected final Runnable mSearchBefore = new NoteListActivity.29(this);
  protected final Runnable mSearchSuc = new NoteListActivity.30(this);
  protected SectionListAdapter mSectionAdapter = null;
  public boolean mShouldSkipRefreshError = false;
  public String mTimeCaption = "0";
  private int mToggleHeight = 0;
  private QMTopBar mTopBar;
  private Activity mainActivity = null;
  private Observer noteListDeleteIObserver = new IObserver(new NoteListActivity.3(this));
  private IObserver noteListErrorIObserver = new IObserver(new NoteListActivity.15(this));
  private IObserver noteListToNormalIObserver = new IObserver(new NoteListActivity.16(this));
  private IObserver noteListUpdateIObserver = new IObserver(new NoteListActivity.18(this));
  private NoteManager noteManager;
  private QMToggleView noteTypeToggleView;
  private View.OnClickListener onReloadListener = new NoteListActivity.28(this);
  private QMSearchBar searchbar;
  private Runnable showNetWorkErrorThread = new NoteListActivity.22(this);
  protected int toggleheight;
  private final IObserver webpushIObserver = new IObserver(new NoteListActivity.14(this));
  
  private void _loadNoteList()
  {
    renderLoading();
    this.noteManager.loadNoteList();
  }
  
  private void addBottomBarButton()
  {
    this.mFooterbar.addButton(1, getString(2131692498), new NoteListActivity.23(this));
    this.mFooterbar.addButton(0, getString(2131695667), new NoteListActivity.24(this));
    this.mFooterbar.addButton(0, getString(2131696005), new NoteListActivity.25(this));
  }
  
  private void addObserver()
  {
    QMNotification.registNotification("NOTE_LIST_UPDATE", this.noteListUpdateIObserver);
    QMNotification.registNotification("NOTE_LIST_DELETE_DONE", this.noteListDeleteIObserver);
    QMNotification.registNotification("NOTE_LIST_ERROR", this.noteListErrorIObserver);
    QMNotification.registNotification("NOTE_DATACHANGE", this.noteListUpdateIObserver);
    QMNotification.registNotification("NOTE_TONORMALVIEW", this.noteListToNormalIObserver);
    QMNotification.registNotification("receivePushNote", this.webpushIObserver);
  }
  
  private void changeNoteList(int paramInt)
  {
    Object localObject = this.noteManager.readAllCategory();
    String[] arrayOfString = new String[((ArrayList)localObject).size() + 2];
    arrayOfString[0] = getString(2131690287);
    arrayOfString[1] = getString(2131720427);
    int j = ((ArrayList)localObject).size();
    int i = 0;
    while (i < j)
    {
      arrayOfString[(i + 2)] = ((QMNNoteCategory)((ArrayList)localObject).get(i)).getCatalogName();
      i += 1;
    }
    if (paramInt == 0)
    {
      this.mCatalogId = NoteListDefine.CATALOG_ALL_ID;
      this.mCatalogName = getString(2131690287);
    }
    for (;;)
    {
      getNoteListByCatalogId();
      if (this.mNoteUI != null) {
        break;
      }
      renderError();
      return;
      if (paramInt == 1)
      {
        this.mCatalogId = "star";
        this.mCatalogName = getString(2131720427);
      }
      else
      {
        localObject = (QMNNoteCategory)((ArrayList)localObject).get(paramInt - 2);
        this.mCatalogId = ((QMNNoteCategory)localObject).getCatalogId();
        this.mCatalogName = ((QMNNoteCategory)localObject).getCatalogName();
      }
    }
    if (this.mNoteUI.size() == 0)
    {
      renderEmpty();
      return;
    }
    renderNormal();
    renderList();
    this.mHandler.post(this.mRenderRunnable);
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), NoteListActivity.class);
  }
  
  private void deleteWithCallback()
  {
    ArrayList localArrayList = getNoteIdsFromCheckedMap();
    doDelAni(false, this.mArrayAdapter.getCount(), localArrayList);
  }
  
  private void didDeleteNotes()
  {
    if (this.mCheckedNoteIds.size() == 0)
    {
      getTips().showInfo("请选择记事");
      return;
    }
    this.deleteNotesIdList = Lists.newArrayList(this.mCheckedNoteIds.values());
    deleteWithCallback();
  }
  
  /* Error */
  private void doDelAni(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 129	com/tencent/qqmail/note/NoteListActivity:mArrayAdapter	Lcom/tencent/qqmail/note/NoteListActivity$StandardArrayAdapter;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 239	com/tencent/qqmail/note/NoteListActivity:mCheckedNoteIds	Ljava/util/HashMap;
    //   18: invokevirtual 489	java/util/HashMap:size	()I
    //   21: ifle +7 -> 28
    //   24: aload_0
    //   25: invokespecial 516	com/tencent/qqmail/note/NoteListActivity:notifyDelAni	()V
    //   28: aload_0
    //   29: getfield 129	com/tencent/qqmail/note/NoteListActivity:mArrayAdapter	Lcom/tencent/qqmail/note/NoteListActivity$StandardArrayAdapter;
    //   32: invokevirtual 484	com/tencent/qqmail/note/NoteListActivity$StandardArrayAdapter:getCount	()I
    //   35: ifne -24 -> 11
    //   38: goto -27 -> 11
    //   41: astore 4
    //   43: aload_3
    //   44: monitorexit
    //   45: aload 4
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	NoteListActivity
    //   0	48	1	paramBoolean	boolean
    //   0	48	2	paramInt	int
    //   0	48	3	paramArrayList	ArrayList<String>
    //   41	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	41	finally
    //   14	28	41	finally
    //   28	38	41	finally
    //   43	45	41	finally
  }
  
  private ArrayList<String> getNoteIdsFromCheckedMap()
  {
    if (this.mCheckedNoteIds == null) {
      return null;
    }
    return Lists.newArrayList(this.mCheckedNoteIds.values());
  }
  
  private void getNoteListByCatalogId()
  {
    this.mNoteUI = this.noteManager.readNoteUIByCategoryId(this.mCatalogId);
    if (this.mArrayAdapter == null) {
      this.mArrayAdapter = new StandardArrayAdapter(this.mainActivity.getApplicationContext(), 0, this.mNoteUI);
    }
    for (;;)
    {
      this.mArrayAdapter.notifyDataSetChanged();
      return;
      this.mArrayAdapter.setDataSource(this.mNoteUI);
    }
  }
  
  private void initListViewClickEvent()
  {
    this.mNoteListListView.setOnItemClickListener(new NoteListActivity.8(this));
    this.mNoteListListView.setOnItemLongClickListener(new NoteListActivity.9(this));
  }
  
  private void initNoteTypeToggleView()
  {
    this.noteTypeToggleView = ((QMToggleView)this.mInflater.inflate(2131561145, null));
    this.mBaseView.addView(this.noteTypeToggleView);
    this.noteTypeToggleView.init();
    ((FrameLayout.LayoutParams)this.noteTypeToggleView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(2131299664);
    this.noteTypeToggleView.setToggleViewCallback(new NoteListActivity.27(this));
    renderToggleTypes();
  }
  
  private void initPopularizeBannerView()
  {
    this.mPopularizeBanner = new PopularizeBanner(4);
  }
  
  private ViewGroup initSearchBarView()
  {
    this.searchbar = new QMSearchBar(this);
    this.searchbar.setStateNormal();
    this.searchbar.setSearchHint(2131696400);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.searchbar.setLayoutParams(localLayoutParams);
    this.searchbar.searchInitWrap.setOnTouchListener(new NoteListActivity.26(this));
    return this.searchbar;
  }
  
  private void initTopBar()
  {
    refreshTopBar();
    this.mTopBar.setCenterOnclickListener(new NoteListActivity.19(this));
  }
  
  private void noteItemOnClick(View paramView, int paramInt)
  {
    paramView = ((NoteListItemViewHolder)paramView.getTag()).noteId;
    Intent localIntent = new Intent(this.mainActivity, ReadNoteActivity.class);
    localIntent.putExtra("position", paramInt - this.mNoteListListView.getHeaderViewsCount());
    if (paramView != null) {
      localIntent.putExtra("noteId", paramView);
    }
    if (this.mNoteUI != null) {
      localIntent.putExtra("noteList", this.mNoteUI.toNoteIds());
    }
    if (this.mCatalogName != null) {
      localIntent.putExtra("catalogName", this.mCatalogName);
    }
    startActivity(localIntent);
  }
  
  private void notifyDelAni()
  {
    this.delAniHandler.post(this.delAniRunnable);
  }
  
  private void openStarPopup()
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    ArrayList localArrayList = getNoteIdsFromCheckedMap();
    Iterator localIterator = this.mCheckedNoteIds.keySet().iterator();
    int j = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (String)this.mCheckedNoteIds.get(localObject);
      localObject = this.noteManager.readNoteData((String)localObject);
      if ((localObject != null) && (((QMNNote)localObject).status != null)) {
        if (((QMNNote)localObject).status.starred)
        {
          i = j;
          j = 1;
          label112:
          if ((j == 0) || (i == 0)) {
            break label205;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        localBottomListSheetBuilder.addItem(2130840824, getString(2131695669), getString(2131695669));
      }
      if (j != 0) {
        localBottomListSheetBuilder.addItem(2130840826, getString(2131695672), getString(2131695672));
      }
      localBottomListSheetBuilder.setOnSheetItemClickListener(new NoteListActivity.13(this, localArrayList));
      localBottomListSheetBuilder.build().show();
      return;
      int k = 1;
      j = i;
      i = k;
      break label112;
      label205:
      k = j;
      j = i;
      i = k;
      break;
      k = i;
      i = j;
      j = k;
      break label112;
      k = i;
      i = j;
      j = k;
    }
  }
  
  private void openStarPopup(View paramView)
  {
    int j = 0;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof View))) {
      paramView = (View)paramView.getTag();
    }
    for (;;)
    {
      ArrayList localArrayList1 = getNoteIdsFromCheckedMap();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.mCheckedNoteIds.keySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        localObject = (String)this.mCheckedNoteIds.get(localObject);
        localObject = this.noteManager.readNoteData((String)localObject);
        if ((localObject != null) && (((QMNNote)localObject).status != null)) {
          if (((QMNNote)localObject).status.starred)
          {
            i = j;
            j = 1;
            label133:
            if ((j == 0) || (i == 0)) {
              break label222;
            }
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          localArrayList2.add(getString(2131695669));
        }
        if (j != 0) {
          localArrayList2.add(getString(2131695672));
        }
        new NoteListActivity.12(this, this, paramView, new PopupAdapter(this, 2131559771, 2131373495, localArrayList2), localArrayList1).show();
        return;
        int k = 1;
        j = i;
        i = k;
        break label133;
        label222:
        k = j;
        j = i;
        i = k;
        break;
        k = i;
        i = j;
        j = k;
        break label133;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  private void readTimeCaption()
  {
    this.mTimeCaption = NoteStorage.readSortType();
  }
  
  private void recheckItem()
  {
    int i = 0;
    int j = this.mArrayAdapter.getCount();
    int k = this.mNoteListListView.getHeaderViewsCount();
    while (i < j)
    {
      if (this.mCheckedNoteIds.containsValue(this.mArrayAdapter.getItem(i).getNoteId())) {
        this.mNoteListListView.setItemChecked(i + k, true);
      }
      i += 1;
    }
  }
  
  private void refreshBottomBarState()
  {
    int i = 0;
    if (this.mCheckedNoteIds.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      int j = this.mFooterbar.getChildCount();
      while (i < j)
      {
        this.mFooterbar.getChildAt(i).setEnabled(bool);
        i += 1;
      }
    }
  }
  
  private void refreshTopBar()
  {
    if (!this.mIsEditing)
    {
      this.mTopBar.setTitle(this.mCatalogName);
      if (AccountManager.shareInstance().getAccountList().getQQMailAccountNumber() > 1)
      {
        Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(QMSettingManager.sharedInstance().getDefaultNoteAccountID());
        if (localAccount != null) {
          this.mTopBar.setSubTitle(localAccount.getEmail());
        }
      }
      this.mTopBar.showArrow(true);
      this.mTopBar.setButtonLeftBack();
      this.mTopBar.setButtonRightIcon(2130841079);
      this.mTopBar.getButtonRight().setContentDescription(getString(2131720843));
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftOnclickListener(new NoteListActivity.20(this));
      this.mTopBar.setButtonRightOnclickListener(new NoteListActivity.21(this));
      return;
      this.mTopBar.showArrow(false);
      this.mTopBar.setButtonLeftNormal(2131719469);
      this.mTopBar.setButtonRightBlue(2131691246);
    }
  }
  
  private void renderEmpty()
  {
    Log.d("NoteListActivity", "renderEmpty");
    this.mNoteListListView.setVisibility(8);
    this.listEmptyView.showTips(2131696413);
    this.mNoteListListView.setVisibility(8);
  }
  
  private void renderError()
  {
    if (this.mNoteListListView.getVisibility() != 0)
    {
      DataCollector.logException(7, 6, "Event_Error", getString(2131696414), true);
      Log.d("NoteListActivity", "renderError");
      this.mNoteListListView.setVisibility(8);
      this.listEmptyView.showTipsReload(2131696414, this.onReloadListener);
      this.mNoteListListView.setVisibility(8);
    }
    for (;;)
    {
      this.mShouldSkipRefreshError = false;
      return;
      if (!this.mShouldSkipRefreshError) {
        getTips().showError(2131695613);
      }
    }
  }
  
  private void renderLoading()
  {
    this.listEmptyView.showLoading(true);
    this.mNoteListListView.setVisibility(8);
  }
  
  private void renderLock()
  {
    this.mNoteListListView.setVisibility(8);
    String str1 = getString(2131693914);
    String str2 = getString(2131693915);
    String str3 = getString(2131693916);
    SpannableString localSpannableString = new SpannableString(str1 + str2 + str3);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131167531)), 0, str1.length(), 33);
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(getResources().getColor(2131167531));
    int i = str1.length();
    int j = str2.length();
    int k = str1.length();
    int m = str2.length();
    localSpannableString.setSpan(localForegroundColorSpan, i + j, str3.length() + (k + m), 33);
    localSpannableString.setSpan(new NoteListActivity.31(this, getResources().getColor(2131167535), getResources().getColor(2131167537), getResources().getColor(2131167595), getResources().getColor(2131167595)), str1.length(), str1.length() + str2.length(), 33);
    this.listEmptyLockTextView = new TextView(getActivity());
    this.listEmptyLockTextView.setText(localSpannableString);
    this.listEmptyLockTextView.setMovementMethod(LinkTouchMovementMethod.getInstance());
    this.listEmptyView.setTextView(this.listEmptyLockTextView);
    this.mTopBar.getButtonRight().setEnabled(false);
    this.mTopBar.getTitleView().setEnabled(false);
    this.mTopBar.getTitleView().setTextColor(getResources().getColor(2131165857));
    if (this.mTopBar.getArrowView() != null) {
      this.mTopBar.getArrowView().setAlpha(0.5F);
    }
  }
  
  private void renderNormal()
  {
    this.listEmptyView.hide();
    this.mNoteListListView.setVisibility(0);
    this.mTopBar.getButtonRight().setEnabled(true);
    this.mTopBar.getTitleView().setEnabled(true);
    this.mTopBar.getTitleView().setTextColor(getResources().getColor(2131165381));
    if (this.mTopBar.getArrowView() != null) {
      this.mTopBar.getArrowView().setAlpha(1.0F);
    }
  }
  
  private void renderTitleForEditMode(int paramInt)
  {
    if (paramInt < 1) {
      this.mTopBar.setTitle(getString(2131696422));
    }
    for (;;)
    {
      refreshBottomBarState();
      return;
      this.mTopBar.setTitle(String.format(getString(2131696412), new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  private void sendCGI(ArrayList<String> paramArrayList)
  {
    this.noteManager.deleteNotesWithNotification(paramArrayList, null);
  }
  
  private void setSeletAllState(boolean paramBoolean)
  {
    int j = 0;
    int k = this.mNoteListListView.getHeaderViewsCount();
    int m = this.mNoteListListView.getAdapter().getCount();
    int i = 0;
    while (i < m)
    {
      this.mNoteListListView.setItemChecked(i + k, paramBoolean);
      i += 1;
    }
    if (paramBoolean)
    {
      ArrayList localArrayList = this.mNoteUI.toNoteIds();
      i = j;
      while (i < localArrayList.size())
      {
        this.mCheckedNoteIds.put(Integer.valueOf(i), localArrayList.get(i));
        i += 1;
      }
    }
    this.mNoteListListView.clearChoices();
    this.mCheckedNoteIds.clear();
    updateSeleteAllButton(paramBoolean);
    renderTitleForEditMode(this.mCheckedNoteIds.size());
    savePostion();
    restorePostion();
  }
  
  private void shortcutDialog()
  {
    QMLog.log(4, "NoteListActivity", "show Note shortcutDialog");
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131690415))).setMessage(getString(2131690414)).addAction(2131691246, new NoteListActivity.7(this))).addAction(2131696547, new NoteListActivity.6(this))).create().show();
  }
  
  private void showAddShortcutDialog()
  {
    int i = SharedPreferenceUtil.getNoteEnterCount();
    if ((i == 1) && (!ShortcutUtility.isShortcutExist(getString(2131689807))))
    {
      shortcutDialog();
      SharedPreferenceUtil.setNoteEnterCount(2);
    }
    while (i > 1) {
      return;
    }
    SharedPreferenceUtil.setNoteEnterCount(1);
  }
  
  private void toggleEditView()
  {
    if (this.mIsEditing)
    {
      toNormalView();
      return;
    }
    toEditView();
  }
  
  private void toggleNoteType()
  {
    if (this.mIsEditing) {
      return;
    }
    if (this.noteTypeToggleView == null) {
      initNoteTypeToggleView();
    }
    if (this.noteTypeToggleView.isHidden())
    {
      this.noteTypeToggleView.show();
      return;
    }
    this.noteTypeToggleView.hide();
  }
  
  private void unRegisterObserver()
  {
    QMNotification.unregistNotification("NOTE_LIST_UPDATE", this.noteListUpdateIObserver);
    QMNotification.unregistNotification("NOTE_LIST_DELETE_DONE", this.noteListDeleteIObserver);
    QMNotification.unregistNotification("NOTE_DATACHANGE", this.noteListUpdateIObserver);
    QMNotification.unregistNotification("NOTE_LIST_ERROR", this.noteListErrorIObserver);
    QMNotification.unregistNotification("NOTE_TONORMALVIEW", this.noteListToNormalIObserver);
    QMNotification.unregistNotification("receivePushNote", this.webpushIObserver);
  }
  
  private void updateNoteList()
  {
    Threads.runOnMainThread(new NoteListActivity.17(this));
  }
  
  private void updateSeleteAllButton(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsSelectAll = true;
      this.mTopBar.setButtonLeftNormal(2131719470);
      return;
    }
    this.mIsSelectAll = false;
    this.mTopBar.setButtonLeftNormal(2131719469);
  }
  
  public void initDataSource()
  {
    readTimeCaption();
  }
  
  public void initDom()
  {
    initPopularizeBannerView();
    this.mPopularizeBanner.render(this.mNoteListListView, false);
    this.mCatalogId = NoteListDefine.CATALOG_ALL_ID;
    this.mCatalogName = getString(2131690287);
    addObserver();
    initSearchBarView();
    this.noteManager = NoteManager.sharedInstance();
    this.mainActivity = this;
    initTopBar();
    this.mNoteListListView.addHeaderView(this.searchbar);
    this.mNoteListListView.setOnRefreshListener(new NoteListActivity.5(this));
    this.mInflater = LayoutInflater.from(this);
    initNoteTypeToggleView();
    initListViewClickEvent();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.mainActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.mToggleHeight = (localDisplayMetrics.heightPixels - getResources().getDimensionPixelSize(2131299665) - getResources().getDimensionPixelSize(2131299664));
    addBottomBarButton();
    showAddShortcutDialog();
  }
  
  public void initUI()
  {
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1) {
      overridePendingTransition(2130772401, 2130772430);
    }
    for (;;)
    {
      this.mBaseView = initBaseView(this);
      this.mTopBar = getTopBar();
      this.listEmptyView = this.mBaseView.addListEmptyView();
      this.mNoteListListView = this.mBaseView.addPtrListView(true);
      this.mFooterbar = new QMBottomBar(this);
      this.mFooterbar.setVisibility(8);
      this.mBaseView.addView(this.mFooterbar);
      return;
      if (this.animationType == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.mIsEditing)
    {
      toNormalView();
      return;
    }
    this.isFromNoteShortcutAndNoteInAppFolderList = getActivity().getIntent().getBooleanExtra("fromNoteShortcutAppFolderAndNoteInAppFolder", false);
    if (this.isFromNoteShortcutAndNoteInAppFolderList)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      Intent localIntent = MailFragmentActivity.createIntentFromShortcut();
      localIntent.putExtra("fromNoteShortcutAppFolderAndNoteInAppFolder", true);
      startActivity(localIntent);
      overridePendingTransition(2130772421, 2130772420);
      return;
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return !this.mIsEditing;
  }
  
  public Intent onLastFinish()
  {
    if (AccountManager.shareInstance().getAccountList().size() == 1) {
      return MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
    }
    return MailFragmentActivity.createIntentToAccountList();
  }
  
  public void onOverridePendingTransitionInFinish(Intent paramIntent)
  {
    if (paramIntent != null) {
      overridePendingTransition(2130772421, 2130772420);
    }
  }
  
  public void onRelease()
  {
    savePostion();
    unRegisterObserver();
    if (this.mNoteUI != null) {
      this.mNoteUI.close();
    }
  }
  
  public void refreshData()
  {
    if (FolderLockDialog.isFolderLock(-4))
    {
      if ((getActivity() != null) && (!this.isFolderLockBlocking))
      {
        this.lockDialog = new FolderLockDialog(getActivity(), -4, this.noteManager.mCurAccountId, this.folderLockWacher);
        this.lockDialog.createDialog(1);
        this.lockDialog.showDialogTouchOutsideFalse();
        this.isFolderLockBlocking = true;
        renderLock();
      }
      return;
    }
    if (NoteManager.getNeedUpdate())
    {
      this.mShouldSkipRefreshError = true;
      _loadNoteList();
    }
    for (;;)
    {
      readTimeCaption();
      return;
      updateNoteList();
    }
  }
  
  public void render()
  {
    QMNotificationConstructor.getInstance().clearAllNote();
  }
  
  protected void renderList()
  {
    Log.d("NoteListActivity", "render");
    if (this.mNoteListListView.getAdapter() == null) {
      this.mNoteListListView.setAdapter(this.mArrayAdapter);
    }
    this.mNoteListListView.setVerticalScrollBarEnabled(true);
    this.mNoteListListView.setVisibility(0);
    if (this.mIsEditing) {
      recheckItem();
    }
    this.mPopularizeBanner.render(this.mNoteListListView, false);
  }
  
  public void renderToggleTypes()
  {
    int k = 0;
    ArrayList localArrayList = this.noteManager.readAllCategory();
    String[] arrayOfString = new String[localArrayList.size() + 2];
    arrayOfString[0] = getString(2131690287);
    arrayOfString[1] = getString(2131720427);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      arrayOfString[(i + 2)] = ((QMNNoteCategory)localArrayList.get(i)).getCatalogName();
      i += 1;
    }
    if (StringUtils.equals(this.mCatalogId, NoteListDefine.CATALOG_ALL_ID)) {}
    for (i = k;; i = 1)
    {
      this.noteTypeToggleView.setData(arrayOfString);
      this.noteTypeToggleView.setSelectedRow(i);
      return;
      if (!StringUtils.equals(this.mCatalogId, "star")) {
        break;
      }
    }
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= localArrayList.size()) {
        break;
      }
      if (StringUtils.equals(((QMNNoteCategory)localArrayList.get(j)).getCatalogId(), this.mCatalogId))
      {
        i = j + 2;
        break;
      }
      j += 1;
    }
  }
  
  public void restorePostion()
  {
    if (this.lastIndex > -1) {
      this.mNoteListListView.setSelectionFromTop(this.lastIndex, this.lastTop);
    }
  }
  
  public void restorePostionToTop()
  {
    this.lastIndex = -1;
  }
  
  public void savePostion()
  {
    int i = 0;
    View localView;
    if (this.mNoteListListView != null)
    {
      this.lastIndex = this.mNoteListListView.getFirstVisiblePosition();
      localView = this.mNoteListListView.getChildAt(0);
      if (localView != null) {
        break label39;
      }
    }
    for (;;)
    {
      this.lastTop = i;
      return;
      label39:
      i = localView.getTop();
    }
  }
  
  protected void showDeleteConfirmDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131691978)).setMessage(2131691977).addAction(2131691246, new NoteListActivity.11(this))).addAction(0, 2131691840, 2, new NoteListActivity.10(this))).create().show();
  }
  
  public void showFooterbar(boolean paramBoolean)
  {
    if (this.mFooterbar == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mFooterbar.setVisibility(0);
      return;
    }
    this.mFooterbar.setVisibility(8);
  }
  
  protected void toEditView()
  {
    this.mIsEditing = true;
    this.mNoteListListView.setEnablePullToRefresh(false);
    this.mCheckedNoteIds.clear();
    savePostion();
    restorePostion();
    this.mNoteListListView.setChoiceMode(2);
    refreshTopBar();
    renderTitleForEditMode(0);
    this.searchbar.setEnabled(false);
    showFooterbar(true);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mNoteListListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    this.mNoteListListView.setLayoutParams(localLayoutParams);
  }
  
  protected void toNormalView()
  {
    this.mIsEditing = false;
    setSeletAllState(false);
    this.mNoteListListView.clearChoices();
    this.mCheckedNoteIds.clear();
    this.mNoteListListView.setEnablePullToRefresh(true);
    restorePostion();
    this.mNoteListListView.setChoiceMode(0);
    showFooterbar(false);
    refreshTopBar();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mNoteListListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.mNoteListListView.setLayoutParams(localLayoutParams);
    this.mTopBar.setTitle(this.mCatalogName);
    this.searchbar.setEnabled(true);
  }
  
  public static abstract interface NoteDeleteCallback
  {
    public abstract void onError();
    
    public abstract void onSuccess();
  }
  
  public class NoteListItemViewHolder
  {
    public ImageView audioimage;
    public String categoryId;
    public CheckBox checkbox;
    public TextView content;
    public String imageUrl;
    public String noteId;
    public ImageView star;
    public TextView subject;
    public ImageView thumb;
    public TextView time;
    
    public NoteListItemViewHolder() {}
  }
  
  public class StandardArrayAdapter
    extends ArrayAdapter<NoteUI>
  {
    private NoteUI mNoteUI;
    
    public StandardArrayAdapter(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public StandardArrayAdapter(Context paramContext, int paramInt, NoteUI paramNoteUI)
    {
      super(paramInt);
      this.mNoteUI = paramNoteUI;
    }
    
    public int getCount()
    {
      if (this.mNoteUI != null) {
        return this.mNoteUI.size();
      }
      return 0;
    }
    
    public NoteUI getItem(int paramInt)
    {
      if (this.mNoteUI == null) {
        return null;
      }
      this.mNoteUI.moveToPosition(paramInt);
      return this.mNoteUI;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject1 = new StringBuilder().append("position:").append(paramInt).append(" convertView:");
      boolean bool;
      Object localObject3;
      label196:
      Object localObject2;
      label227:
      label244:
      label380:
      ImageView localImageView;
      label337:
      int i;
      if (paramView == null)
      {
        bool = true;
        Log.i("algeranimation", bool);
        localObject3 = getItem(paramInt);
        if ((paramView != null) && (paramView.getTag() != null)) {
          break label782;
        }
        paramView = NoteListActivity.this.mInflater.inflate(2131559709, paramViewGroup, false);
        localObject1 = new NoteListActivity.NoteListItemViewHolder(NoteListActivity.this);
        ((NoteListActivity.NoteListItemViewHolder)localObject1).subject = ((TextView)paramView.findViewById(2131372511));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).content = ((TextView)paramView.findViewById(2131372508));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).time = ((TextView)paramView.findViewById(2131372509));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb = ((ImageView)paramView.findViewById(2131379637));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage = ((ImageView)paramView.findViewById(2131379636));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).star = ((ImageView)paramView.findViewById(2131372510));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).checkbox = ((CheckBox)paramView.findViewById(2131372507));
        paramView.setTag(localObject1);
        localObject2 = (QMListItemView)paramView;
        ((QMListItemView)localObject2).bindItemCheckBox(((NoteListActivity.NoteListItemViewHolder)localObject1).checkbox);
        if (!NoteListActivity.this.mIsEditing) {
          break label794;
        }
        ((QMListItemView)localObject2).setItemToEditMode();
        if (!((NoteUI)localObject3).getStarred()) {
          break label802;
        }
        ((NoteListActivity.NoteListItemViewHolder)localObject1).star.setVisibility(0);
        ((NoteListActivity.NoteListItemViewHolder)localObject1).noteId = ((NoteUI)localObject3).getNoteId();
        ((NoteListActivity.NoteListItemViewHolder)localObject1).categoryId = ((NoteUI)localObject3).getCatalogId();
        localObject2 = "";
        if (!TextUtils.isEmpty(((NoteUI)localObject3).getAbstract())) {
          localObject2 = ((NoteUI)localObject3).getAbstract().replaceAll("<br\\s*/?>", "\n").replaceAll("&nb(sp;|sp|s)?$", " ");
        }
        if (((String)localObject2).length() <= 0) {
          break label815;
        }
        ((NoteListActivity.NoteListItemViewHolder)localObject1).content.setText((String)localObject2 + QMUIKit.ELLIPSIZE_FIXED);
        if (((NoteUI)localObject3).getSubject().length() <= 0) {
          break label836;
        }
        ((NoteListActivity.NoteListItemViewHolder)localObject1).subject.setText(((NoteUI)localObject3).getSubject() + QMUIKit.ELLIPSIZE_FIXED);
        double d = ((NoteUI)localObject3).getUpdatetime();
        if (StringUtils.equals(NoteListActivity.this.mTimeCaption, "1")) {
          d = ((NoteUI)localObject3).getCreateTime();
        }
        localObject2 = DateExtension.shortDateName(new Date(d * 1000L));
        ((NoteListActivity.NoteListItemViewHolder)localObject1).time.setText((CharSequence)localObject2);
        if ((((NoteUI)localObject3).getThumbUrl() == null) || ("".equals(((NoteUI)localObject3).getThumbUrl()))) {
          break label927;
        }
        localObject3 = ((NoteUI)localObject3).getThumbUrl().replaceAll("^\\s*file://localhost", "file://").replaceAll("&amp;", "&");
        QMLog.log(2, "algerthumbnail", (String)localObject3);
        ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage.setVisibility(8);
        localImageView = ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb;
        localObject2 = null;
        if (localImageView.getTag() != null) {
          localObject2 = localImageView.getTag().toString();
        }
        if ((localObject2 == null) || (((String)localObject2).length() < 3) || (!((String)localObject2).equals(localObject3)))
        {
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setVisibility(0);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage.setVisibility(8);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setImageResource(2130841019);
          localImageView.setTag(localObject3);
          if (ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject3) == 0) {
            break label857;
          }
          i = 1;
          label604:
          if (i == 0) {
            break label869;
          }
          if ((localImageView.getTag() != null) && (localImageView.getTag().equals(localObject3)))
          {
            localObject1 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject3);
            if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled()))
            {
              localObject2 = new StringBuilder().append("bitmapRecycled1 ");
              if (localObject1 != null) {
                break label863;
              }
              bool = true;
              label676:
              QMLog.log(6, "NoteListActivity", bool + " exit status " + ImageDownloadManager.shareInstance().isThumbBitmapExistLocal((String)localObject3));
            }
            if (localObject1 != null) {
              localImageView.setImageBitmap((Bitmap)localObject1);
            }
          }
        }
      }
      for (;;)
      {
        long l = getItemId(paramInt);
        paramView.setOnClickListener(new NoteListActivity.StandardArrayAdapter.2(this, paramInt, l));
        paramView.setOnLongClickListener(new NoteListActivity.StandardArrayAdapter.3(this, paramInt, l));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        bool = false;
        break;
        label782:
        localObject1 = (NoteListActivity.NoteListItemViewHolder)paramView.getTag();
        break label196;
        label794:
        ((QMListItemView)localObject2).setItemToNormalMode();
        break label227;
        label802:
        ((NoteListActivity.NoteListItemViewHolder)localObject1).star.setVisibility(8);
        break label244;
        label815:
        ((NoteListActivity.NoteListItemViewHolder)localObject1).content.setText(NoteListActivity.this.getString(2131696411));
        break label337;
        label836:
        ((NoteListActivity.NoteListItemViewHolder)localObject1).subject.setText(NoteListActivity.this.getString(2131696420));
        break label380;
        label857:
        i = 0;
        break label604;
        label863:
        bool = false;
        break label676;
        label869:
        localObject1 = new DownloadInfo();
        ((DownloadInfo)localObject1).setAccountId(NoteListActivity.this.noteManager.mCurAccountId);
        ((DownloadInfo)localObject1).setUrl((String)localObject3);
        ((DownloadInfo)localObject1).setImageDownloadListener(new NoteListActivity.StandardArrayAdapter.1(this, localImageView));
        ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject1);
        continue;
        label927:
        if (!((NoteUI)localObject3).getAudio().equals("0"))
        {
          ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage.setVisibility(0);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setVisibility(8);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setTag(null);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage.setImageResource(2130841020);
        }
        else
        {
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setVisibility(8);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).thumb.setTag(null);
          ((NoteListActivity.NoteListItemViewHolder)localObject1).audioimage.setVisibility(8);
        }
      }
    }
    
    public void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
    }
    
    public void setDataSource(NoteUI paramNoteUI)
    {
      this.mNoteUI = paramNoteUI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity
 * JD-Core Version:    0.7.0.1
 */