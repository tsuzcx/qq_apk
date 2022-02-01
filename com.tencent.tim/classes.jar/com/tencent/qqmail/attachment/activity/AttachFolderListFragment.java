package com.tencent.qqmail.attachment.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity;
import com.tencent.qqmail.activity.media.ImageAttachData;
import com.tencent.qqmail.activity.media.QMMediaBottom;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.cursor.AttachFolderListCursor;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.LockInfo;
import com.tencent.qqmail.attachment.util.AttachFolderHelper;
import com.tencent.qqmail.attachment.util.AttachOperateMore;
import com.tencent.qqmail.attachment.util.AttachToolbox;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.maillist.ListViewHelper.OnHandleListScroll;
import com.tencent.qqmail.model.mail.watcher.LoadAttachFolderListWatcher;
import com.tencent.qqmail.model.mail.watcher.OperationAttachFolderWatcher;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.model.media.QMAlbumManager.QMMediaIntentType;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.SaveArgumentField;

public class AttachFolderListFragment
  extends QMBaseFragment
  implements ListViewHelper.OnHandleListScroll
{
  private static final int REQUEST_ATTACH_FOLDER_PREVIEW = 104;
  private static final int REQUEST_UNLOCK_ATTACH_FOLDER = 1;
  public static final int RESULT_UPDATE = 105;
  public static final String TAG = "AttachFolderListFragment";
  @SaveArgumentField
  private int mAccountId;
  private QMMediaBottom mAddBottom;
  private QMBaseView mBaseView;
  private QMBottomBar mBottomBar;
  private View mBtnCancelFav;
  private View mBtnSend;
  private List<Attach> mCheckAttachList = Collections.synchronizedList(new ArrayList());
  private Set<Long> mCheckSet = new HashSet();
  private OperationAttachFolderWatcher mFavoriteWatcher = new AttachFolderListFragment.3(this);
  @SaveArgumentField
  private int mFolderId;
  private QMUnlockFolderPwdWatcher mFolderLockWatcher = new AttachFolderListFragment.2(this);
  private boolean mIsEditing = false;
  private boolean mIsEmpty = false;
  private boolean mIsFastScroll = false;
  private boolean mIsFromComposeMail = false;
  private boolean mIsRefreshed = false;
  private AttachFolderListAdapter mListAdapter;
  private Future<AttachFolderListCursor> mListCursor = null;
  private QMContentLoadingView mListLoadingView;
  private PtrListView mListView;
  private LoadAttachFolderListWatcher mLoadAttachFolderListWatcher = new AttachFolderListFragment.1(this);
  private FolderLockDialog mLockDialog;
  private View.OnClickListener mOnReloadListener = new AttachFolderListFragment.5(this);
  private QMSearchBar mSearchBar;
  private QMTips mTips;
  private QMTopBar mTopBar;
  private final IObserver observerWebPush = new AttachFolderListFragment.4(this, null);
  private TextView selectedFileSize;
  
  public AttachFolderListFragment(int paramInt1, int paramInt2)
  {
    super(false);
    this.mAccountId = paramInt1;
    this.mFolderId = paramInt2;
    setDataSource();
  }
  
  public AttachFolderListFragment(boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    super(false);
    this.mIsFromComposeMail = paramBoolean;
    this.mCheckSet.addAll(paramArrayList);
    runInBackground(new AttachFolderListFragment.6(this));
    setDataSource();
  }
  
  private void clickAttachFolderItemView(Attach paramAttach)
  {
    if ((AttachToolbox.isAttachTypeImage(paramAttach)) && (!FileUtil.isFileTypeTiff(paramAttach.getName())))
    {
      startImageAttachPreview(paramAttach);
      return;
    }
    startActivityForResult(AttachFolderPreviewActivity.createIntentToPreview(getActivity(), paramAttach), 104);
  }
  
  private void clickLockTipsView()
  {
    Object localObject = this.mListAdapter.getAttachFolderLockInfoList();
    if (((ArrayList)localObject).size() == 1)
    {
      localObject = (LockInfo)((ArrayList)localObject).get(0);
      if (localObject != null)
      {
        this.mLockDialog = new FolderLockDialog(getActivity(), ((LockInfo)localObject).getFolderId(), ((LockInfo)localObject).getAccountId(), this.mFolderLockWatcher);
        this.mLockDialog.createDialog(1);
        this.mLockDialog.showDialog();
      }
      return;
    }
    startActivityForResult(AttachFolderUnlockFolderActivity.createIntent(this.mListAdapter.getAttachFolderLockInfoList()), 1);
    getActivity().overridePendingTransition(2130772401, 2130772430);
  }
  
  private void doRender(boolean paramBoolean)
  {
    int j = getDataSource().getState();
    int k = getDataSource().getCount();
    int i;
    if (this.mListAdapter != null) {
      if (this.mListAdapter.hasLockTip())
      {
        i = 1;
        i += k;
        QMLog.log(4, "AttachFolderListFragment", "doRender: state: " + j + ", count: " + i + ", renderList: " + paramBoolean);
        if (i > 0) {
          break label156;
        }
        switch (j)
        {
        default: 
          refreshTopBarLoading(false);
        }
      }
    }
    label156:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        i = 0;
        break;
        refreshTopBarLoading(false);
        renderLoading();
        return;
        refreshTopBarLoading(false);
        renderEmpty();
        return;
        switch (j)
        {
        default: 
          refreshTopBarLoading(false);
          return;
        case 1: 
        case 2: 
          refreshTopBarLoading(true);
        }
      } while (!paramBoolean);
      renderList();
      return;
      refreshTopBarLoading(false);
    } while (!paramBoolean);
    renderList();
  }
  
  private AttachFolderListCursor getDataSource()
  {
    try
    {
      if (this.mListCursor != null)
      {
        AttachFolderListCursor localAttachFolderListCursor = (AttachFolderListCursor)this.mListCursor.get();
        return localAttachFolderListCursor;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "AttachFolderListFragment", Log.getStackTraceString(localException));
    }
    return null;
  }
  
  private long[] getSelectAttachIds()
  {
    long[] arrayOfLong = new long[this.mCheckSet.size()];
    Iterator localIterator = this.mCheckSet.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  private void handleCancelFav()
  {
    if ((this.mIsEmpty) || (!this.mIsEditing)) {
      return;
    }
    if ((this.mCheckSet != null) && (this.mCheckSet.size() == 0))
    {
      getTips().showInfo(2131690613);
      return;
    }
    QMAttachManager.sharedInstance().favoriteAttach(getSelectAttachIds(), false);
    DataCollector.logEvent("Event_Attach_CancelFavorite");
  }
  
  private void handleSendTo()
  {
    if ((!this.mIsEditing) || (this.mIsEmpty)) {}
    do
    {
      return;
      if ((this.mCheckSet != null) && (this.mCheckSet.size() == 0))
      {
        getTips().showInfo(2131690613);
        return;
      }
      if (AttachFolderHelper.validateAttachSize(this.mCheckAttachList, 52428800L))
      {
        if (this.mIsFromComposeMail)
        {
          AttachOperateMore.setResultWithAttaches(getActivity(), getSelectAttachIds());
          overridePendingTransition(2130772423, 2130772402);
          getActivity().finish();
          return;
        }
        AttachOperateMore.doWriteMailWithFavAttaches(getActivity(), getSelectAttachIds());
        toggleNormalState();
        return;
      }
    } while (getActivity() == null);
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131690592))).setMessage("附件大小的总和超过50M，请减少附件数量").addAction(2131696547, new AttachFolderListFragment.19(this))).create().show();
  }
  
  private void initBottomBar()
  {
    if (this.mIsFromComposeMail)
    {
      this.mAddBottom = ((QMMediaBottom)LayoutInflater.from(getActivity()).inflate(2131558498, null));
      this.mAddBottom.init(getActivity());
      this.mAddBottom.addButton.setOnClickListener(new AttachFolderListFragment.10(this));
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.gravity = 5;
      this.mBottomBar.addView(this.mAddBottom, localLayoutParams);
      this.selectedFileSize = ((TextView)this.mAddBottom.findViewById(2131377972));
      return;
    }
    this.mBtnCancelFav = this.mBottomBar.addButton(1, getString(2131690608), new AttachFolderListFragment.11(this));
    this.mBtnSend = this.mBottomBar.addButton(0, getString(2131690612), new AttachFolderListFragment.12(this));
  }
  
  private void initListView()
  {
    this.mListView.setOnItemClickListener(new AttachFolderListFragment.15(this));
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    this.mListView.setOnItemLongClickListener(new AttachFolderListFragment.16(this, arrayOfBoolean));
    this.mListView.setOnTouchListener(new AttachFolderListFragment.17(this, arrayOfBoolean));
    this.mListView.setOnRefreshListener(new AttachFolderListFragment.18(this));
    this.mListAdapter = new AttachFolderListAdapter(getActivity(), getDataSource(), this.mListView, this.mCheckSet);
    this.mListView.setAdapter(this.mListAdapter);
    if (!this.mIsFromComposeMail) {
      this.mListView.addHeaderView(this.mSearchBar);
    }
  }
  
  private void initSearchBar()
  {
    this.mSearchBar = new QMSearchBar(getActivity());
    this.mSearchBar.setStateNormal();
    this.mSearchBar.setBtnRight();
    this.mSearchBar.getBtnRight().setVisibility(8);
    this.mSearchBar.getBtnRight().setOnClickListener(new AttachFolderListFragment.13(this));
    this.mSearchBar.searchInitWrap.setOnClickListener(new AttachFolderListFragment.14(this));
    this.mSearchBar.setStateNormal();
  }
  
  private void initTips()
  {
    this.mTips = new QMTips(getActivity());
    this.mTips.setCanceledOnTouchOutside(true);
  }
  
  private void initTopBar()
  {
    refreshTopBarTitle();
    refreshTopBar();
  }
  
  private void refreshBottomBar()
  {
    if (this.mCheckAttachList.size() == 0) {
      if (this.selectedFileSize != null) {
        this.selectedFileSize.setText("");
      }
    }
    while (this.mIsFromComposeMail)
    {
      this.mAddBottom.updateAddButton(QMAlbumManager.QMMediaIntentType.QMMediaIntentType_NORMAIL, this.mCheckSet.size());
      return;
      Iterator localIterator = this.mCheckAttachList.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((Attach)localIterator.next()).getBytes() + l) {}
      if (this.selectedFileSize != null) {
        this.selectedFileSize.setText("已选择" + this.mCheckAttachList.size() + "项，共" + Formatter.formatFileSize(getActivity(), l));
      }
    }
    if (this.mCheckSet.size() > 0)
    {
      this.mBtnCancelFav.setEnabled(true);
      this.mBtnSend.setEnabled(true);
      return;
    }
    this.mBtnCancelFav.setEnabled(false);
    this.mBtnSend.setEnabled(false);
  }
  
  private void refreshTopBar()
  {
    View localView = this.mTopBar.getButtonRight();
    if (this.mIsFromComposeMail)
    {
      if (localView != null) {
        localView.setVisibility(8);
      }
      this.mTopBar.setButtonLeftNormal(2131691246);
    }
    for (;;)
    {
      this.mTopBar.setButtonLeftOnclickListener(new AttachFolderListFragment.8(this));
      this.mTopBar.setButtonRightOnclickListener(new AttachFolderListFragment.9(this));
      return;
      if (this.mIsEditing)
      {
        this.mTopBar.setButtonLeftNormal(2131719469);
        this.mTopBar.setButtonRightBlue(2131691246);
      }
      else
      {
        if (localView != null) {
          localView.setVisibility(8);
        }
        this.mTopBar.setButtonLeftBack();
      }
    }
  }
  
  private void refreshTopBarButton(boolean paramBoolean)
  {
    if (this.mIsEditing)
    {
      if (paramBoolean) {
        this.mTopBar.setButtonLeftNormal(2131719470);
      }
    }
    else {
      return;
    }
    this.mTopBar.setButtonLeftNormal(2131719469);
  }
  
  private void refreshTopBarLoading(boolean paramBoolean)
  {
    if (this.mTopBar != null) {
      this.mTopBar.showLoading(paramBoolean);
    }
  }
  
  private void refreshTopBarTitle()
  {
    if ((this.mIsEditing) && (!this.mIsFromComposeMail))
    {
      if (this.mCheckSet.size() < 1)
      {
        this.mTopBar.setTitle(2131694081);
        return;
      }
      this.mTopBar.setTitle(String.format(getString(2131694051), new Object[] { Integer.valueOf(this.mCheckSet.size()) }));
      return;
    }
    this.mTopBar.setTitle(2131690605);
  }
  
  private void renderEmpty()
  {
    this.mIsEmpty = true;
    this.mListLoadingView.showTips(2131694064);
    this.mListView.setVisibility(8);
    if (this.mIsFromComposeMail) {
      DataCollector.logEvent("Event_No_Attachment");
    }
  }
  
  private void renderError()
  {
    this.mIsEmpty = true;
    this.mListLoadingView.showTipsReload(2131690602, this.mOnReloadListener);
    this.mListView.setVisibility(8);
  }
  
  private void renderList()
  {
    this.mIsEmpty = false;
    if (this.mListLoadingView != null) {
      this.mListLoadingView.hide();
    }
    if (this.mListView != null)
    {
      this.mListView.setVisibility(0);
      this.mListView.onRefreshComplete();
    }
    if (this.mListAdapter != null)
    {
      this.mListAdapter.updateLockCount();
      this.mListAdapter.notifyDataSetChanged();
    }
  }
  
  private void renderLoading()
  {
    this.mIsEmpty = false;
    if (this.mListLoadingView != null)
    {
      this.mListLoadingView.showLoading(true);
      this.mListView.setVisibility(8);
    }
  }
  
  private void setDataSource()
  {
    this.mListCursor = Threads.submitTask(new AttachFolderListFragment.7(this));
  }
  
  private void setSelectAllState(boolean paramBoolean)
  {
    int j = 0;
    int k = this.mListView.getHeaderViewsCount();
    if (this.mListAdapter.hasLockTip()) {}
    int m;
    for (int i = 1; paramBoolean; i = 0)
    {
      if ((getDataSource() == null) || (this.mListAdapter == null)) {
        break label250;
      }
      m = this.mListAdapter.getCount();
      while (j < m - i)
      {
        if (!this.mListView.isItemChecked(j + k + i)) {
          this.mListView.setItemChecked(j + k + i, true);
        }
        Attach localAttach = getDataSource().getItem(j);
        this.mCheckSet.add(Long.valueOf(localAttach.getHashId()));
        if (this.mCheckAttachList.indexOf(localAttach) == -1) {
          this.mCheckAttachList.add(localAttach);
        }
        j += 1;
      }
    }
    if ((getDataSource() != null) && (this.mListAdapter != null))
    {
      m = this.mListAdapter.getCount();
      j = 0;
      while (j < m - i)
      {
        if (this.mListView.isItemChecked(j + k + i)) {
          this.mListView.setItemChecked(j + k + i, false);
        }
        j += 1;
      }
    }
    this.mListView.clearChoices();
    this.mCheckSet.clear();
    this.mCheckAttachList.clear();
    label250:
    refreshTopBarButton(paramBoolean);
    refreshTopBarTitle();
    refreshBottomBar();
  }
  
  private void startImageAttachPreview(Attach paramAttach)
  {
    if (this.mListAdapter != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int k;
      for (int i = 0; j < this.mListAdapter.getCount(); i = k)
      {
        Object localObject = this.mListAdapter.getItem(j);
        k = i;
        if ((localObject instanceof Attach))
        {
          localObject = (Attach)localObject;
          k = i;
          if (AttachToolbox.isAttachTypeImage((Attach)localObject))
          {
            k = i;
            if (AttachFolderHelper.isAttachPreviewLegal((Attach)localObject))
            {
              k = i;
              if (!FileUtil.isFileTypeTiff(((Attach)localObject).getName()))
              {
                if (((Attach)localObject).getHashId() == paramAttach.getHashId()) {
                  i = localArrayList.size();
                }
                localArrayList.add(localObject);
                k = i;
              }
            }
          }
        }
        j += 1;
      }
      if (localArrayList.size() > 0)
      {
        ImageAttachData.loadData(localArrayList);
        startActivityForResult(ImageAttachBucketSelectActivity.createAttachFolderIntent(paramAttach.getAccountId(), i, -19, false, false), 104);
      }
    }
  }
  
  private void toggleEditingState()
  {
    if ((this.mIsEditing) || (this.mIsEmpty)) {
      return;
    }
    this.mIsEditing = true;
    refreshTopBar();
    refreshBottomBar();
    refreshTopBarTitle();
    this.mBottomBar.setVisibility(0);
    this.mSearchBar.setSearchbarEnable(false);
    this.mListView.setChoiceMode(2);
    this.mListView.setEnablePullToRefresh(false);
    if (this.mListAdapter != null)
    {
      this.mListAdapter.setIsEditing(this.mIsEditing);
      this.mListAdapter.notifyDataSetChanged();
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, getResources().getDimensionPixelSize(2131297365));
    this.mListView.setLayoutParams(localLayoutParams);
  }
  
  private void toggleNormalState()
  {
    this.mIsEditing = false;
    this.mCheckSet.clear();
    this.mCheckAttachList.clear();
    setSelectAllState(false);
    refreshTopBar();
    this.mBottomBar.setVisibility(8);
    this.mSearchBar.setSearchbarEnable(true);
    this.mListView.setChoiceMode(0);
    this.mListView.setEnablePullToRefresh(true);
    if (this.mListAdapter != null)
    {
      this.mListAdapter.setIsEditing(this.mIsEditing);
      this.mListAdapter.notifyDataSetChanged();
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mListView.getLayoutParams();
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    this.mListView.setLayoutParams(localLayoutParams);
  }
  
  public QMTopBar getTopBar()
  {
    return this.mBaseView.getTopBar();
  }
  
  public void initDataSource()
  {
    DataCollector.logEvent("Event_Attach_View_FavList");
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTips();
    initTopBar();
    initSearchBar();
    initListView();
    initBottomBar();
    if (this.mIsFromComposeMail) {
      toggleEditingState();
    }
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = new QMBaseView(getActivity());
    this.mListView = this.mBaseView.addPtrListView(true);
    this.mListLoadingView = this.mBaseView.addListEmptyView();
    this.mTopBar = getTopBar();
    this.mBottomBar = new QMBottomBar(getActivity());
    this.mBottomBar.setVisibility(8);
    this.mBaseView.addView(this.mBottomBar);
    ListViewHelper.addListScrollHandler(this.mListView, this);
    this.mBaseView.setBackgroundColor(ActivityCompat.getColor(getActivity(), 2131167681));
    return this.mBaseView;
  }
  
  public boolean isSelectAll()
  {
    return getDataSource().getCount() == this.mCheckSet.size();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (getDataSource() == null);
      getDataSource().checkUpdate();
      return;
    } while ((paramInt2 != 105) || (getDataSource() == null));
    getDataSource().checkUpdate();
  }
  
  public void onBackPressed()
  {
    if (this.mIsFromComposeMail)
    {
      super.onBackPressed();
      return;
    }
    if (this.mIsEditing)
    {
      toggleNormalState();
      return;
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.mLoadAttachFolderListWatcher, paramBoolean);
    Watchers.bind(this.mFavoriteWatcher, paramBoolean);
    if (paramBoolean)
    {
      QMNotification.registNotification("receivePushAttachFolder", this.observerWebPush);
      return;
    }
    QMNotification.unregistNotification("receivePushAttachFolder", this.observerWebPush);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return !this.mIsEditing;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    if (this.mIsFromComposeMail) {
      return SCALE_TRANSITION_CONFIG;
    }
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public void onRelease()
  {
    this.mListView.setAdapter(null);
    this.mListAdapter = null;
    if (getDataSource() != null) {
      getDataSource().close();
    }
  }
  
  public void onScrollFlingSpeed(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramFloat == 0.0F) {}
    for (this.mIsFastScroll = false;; this.mIsFastScroll = true)
    {
      if (this.mListAdapter != null) {
        this.mListAdapter.setIsFastScroll(this.mIsFastScroll);
      }
      return;
    }
  }
  
  public void onScrollIdle(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      if ((this.mListView != null) && (this.mListAdapter != null))
      {
        View localView = this.mListView.getChildAt(i);
        if (localView != null) {
          this.mListAdapter.setThumbnail(paramInt1 + i - this.mListView.getHeaderViewsCount(), localView);
        }
      }
      i += 1;
    }
  }
  
  public void onScrollToEnd(ListView paramListView) {}
  
  public void onTouchScrollSpeed(float paramFloat, int paramInt1, int paramInt2)
  {
    if (paramFloat == 0.0F) {}
    for (this.mIsFastScroll = false;; this.mIsFastScroll = true)
    {
      this.mListAdapter.setIsFastScroll(this.mIsFastScroll);
      return;
    }
  }
  
  public int refreshData()
  {
    if (this.mIsRefreshed) {
      getDataSource().refresh(false, null);
    }
    this.mIsRefreshed = true;
    return 0;
  }
  
  public void render(int paramInt)
  {
    doRender(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderListFragment
 * JD-Core Version:    0.7.0.1
 */