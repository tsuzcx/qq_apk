package com.tencent.qqmail.bottle.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.bottle.controller.BottleBeachController;
import com.tencent.qqmail.bottle.controller.BottleBeachController.BottleLoadWatcher;
import com.tencent.qqmail.bottle.controller.BottleBeachController.BottlePickupWatcher;
import com.tencent.qqmail.bottle.controller.BottleBeachController.BottleSpamWatcher;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.bottle.fragment.adapter.BottleBeachAdapter;
import com.tencent.qqmail.bottle.fragment.adapter.BottleBeachWithAdvertiseAdapter;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.businessfilter.TypePageFilter;
import com.tencent.qqmail.popularize.view.PopularizeBanner;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BottleBeachFragment
  extends BottleBaseFragment
{
  private static final String TAG = "BottleBeachFragment";
  private static final long TRANSACTION_DURATION = 300L;
  private final int BOTTLE_CONVERSATION_REQUEST_CODE = 1;
  private final int BOTTLE_THROW_REQUEST_CODE = 2;
  private int SPAM_FORBIDDEN = 1;
  private int SPAM_NORMAL = 0;
  private int SPAM_WARNING = 2;
  private String bottleUin = "";
  private boolean hasCheckedSpam = false;
  private boolean isDeleteAnimation = false;
  private boolean isFlyAnimation = false;
  private boolean isInsertAnimation = false;
  private BottleBeachWithAdvertiseAdapter mAdapter;
  private BottleBeach[] mAllBottles = null;
  private AnimationEndTask mAnimationEndRenderTask = new AnimationEndTask(null);
  private ImageView mAvatarImage = null;
  private BottleManager mBottleManager;
  private final BottleBeachController.BottleSpamWatcher mBottleSpamWatcher = new BottleBeachFragment.25(this);
  private BottleBeachController mController = null;
  private ImageView mImageAnimation = null;
  private PtrListView mListView = null;
  private final BottleBeachController.BottleLoadWatcher mLoadBottleWatcher = new BottleBeachFragment.23(this);
  private LinearLayout mLoading = null;
  private String mPickKey = null;
  private final BottleBeachController.BottlePickupWatcher mPickUpBottleWatcher = new BottleBeachFragment.24(this);
  private final long[] mPickupBottleLog = new long[2];
  private final BottleListController.UpdateUnreadStatusWatcher mUnreadWatcher = new BottleBeachFragment.22(this);
  private PopularizeBanner popularizeBanner;
  private int spamBlock = 0;
  private RelativeLayout spamTipsBar;
  private TextView spamTipsContent;
  private TextView spamTipsTitle;
  
  public BottleBeachFragment()
  {
    super(false);
  }
  
  public BottleBeachFragment(String paramString)
  {
    super(false);
    this.mPickKey = paramString;
  }
  
  private void animRemoveItem(String paramString)
  {
    int i = getBottlePosition(paramString);
    if (i >= 0)
    {
      paramString = new ArrayList();
      paramString.add(Integer.valueOf(i));
      this.mAnimationEndRenderTask.addTask(new BottleBeachFragment.16(this));
      ListViewRemoveItemAnimator.animateRemoval(this.mListView, paramString, this.mAnimationEndRenderTask);
      return;
    }
    this.mController.loadBeachBottle();
  }
  
  private void confirmDelete(String paramString)
  {
    this.mBottleManager.logEvent("Event_Bottle_Beach_Delete");
    this.mController.remove(paramString, new BottleBeachFragment.19(this));
  }
  
  private void confirmSpam(String paramString)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131691009))).setMessage(getString(2131691010)).addAction(2131691246, new BottleBeachFragment.18(this))).addAction(0, 2131691009, 2, new BottleBeachFragment.17(this, paramString))).create().show();
  }
  
  private void flashBottleIcon()
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    Object localObject = new BottleBeachFragment.26(this);
    localAlphaAnimation2.setInterpolator((Interpolator)localObject);
    localAlphaAnimation1.setInterpolator((Interpolator)localObject);
    localAlphaAnimation2.setAnimationListener(new BottleBeachFragment.27(this));
    localAlphaAnimation2.setRepeatCount(1);
    localAlphaAnimation2.setDuration(1600L);
    localAlphaAnimation1.setRepeatCount(1);
    localAlphaAnimation1.setDuration(1600L);
    localObject = getTopBar().getButtonReplyMask();
    View localView = getTopBar().getButtonReply();
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      ((View)localObject).startAnimation(localAlphaAnimation1);
      localView.startAnimation(localAlphaAnimation2);
    }
  }
  
  private int getBottlePosition(String paramString)
  {
    int k = this.mListView.getFirstVisiblePosition();
    int m = this.mListView.getLastVisiblePosition();
    int j = this.mListView.getHeaderViewsCount();
    int i = k;
    if (k < j) {
      i = j;
    }
    QMLog.log(2, "BottleBeachFragment", "getBottlePosition: ( " + i + ", " + m + " )");
    while (i <= m)
    {
      k = i - j;
      BottleBeach localBottleBeach = this.mAdapter.getItem(k);
      if ((localBottleBeach != null) && (localBottleBeach.getBottleid().equals(paramString))) {
        return k;
      }
      i += 1;
    }
    return -1;
  }
  
  private void initListView()
  {
    this.mListView = ((PtrListView)findViewById(2131363594));
    initPopularizeBannerView();
    this.popularizeBanner.render(this.mListView, false);
    this.mListView.setOnItemClickListener(new BottleBeachFragment.10(this));
    this.mListView.setOnItemLongClickListener(new BottleBeachFragment.11(this));
    this.mListView.setEnablePullToRefresh(true);
    this.mListView.setOnRefreshListener(new BottleBeachFragment.12(this));
    this.mListView.setOnRefreshCompleteListener(new BottleBeachFragment.13(this));
    BottleBeachAdapter localBottleBeachAdapter = new BottleBeachAdapter(getActivity(), this.mBottleManager);
    this.mAdapter = new BottleBeachWithAdvertiseAdapter(localBottleBeachAdapter);
    ArrayList localArrayList = PopularizeManager.sharedInstance().getPopularize(new TypePageFilter(10, 6));
    this.mAdapter.setPopularizedData(localArrayList);
    this.mListView.setAdapter(this.mAdapter);
    localBottleBeachAdapter.setOnDetailClickListener(new BottleBeachFragment.14(this));
    localBottleBeachAdapter.setOnRowAdditionAnimationListener(new BottleBeachFragment.15(this));
    this.mListView.setDropdownViewBackgroundColor(getResources().getColor(2131167681));
  }
  
  private void initPopularizeBannerView()
  {
    this.popularizeBanner = new PopularizeBanner(6);
  }
  
  private void initSpamTipBar(String paramString1, String paramString2)
  {
    if (this.spamTipsBar == null)
    {
      this.spamTipsBar = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131558774, null));
      this.spamTipsBar.setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131297366), 80);
      this.spamTipsBar.setLayoutParams(localLayoutParams);
      this.spamTipsBar.findViewById(2131378603).setOnClickListener(new BottleBeachFragment.9(this));
      this.spamTipsTitle = ((TextView)this.spamTipsBar.findViewById(2131378606));
      this.spamTipsContent = ((TextView)this.spamTipsBar.findViewById(2131378604));
      ((FrameLayout)this.mListView.getParent()).addView(this.spamTipsBar);
    }
    this.spamTipsTitle.setText(paramString1);
    this.spamTipsContent.setText(paramString2);
    this.spamTipsBar.setVisibility(0);
  }
  
  private void initTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131690982);
    Object localObject = AccountManager.shareInstance().getAccountList();
    Account localAccount = ((AccountList)localObject).getAccountById(QMSettingManager.sharedInstance().getDefaultBottleAccountID());
    if (((AccountList)localObject).getPureQQMailAccountNumber() > 1)
    {
      if (localAccount != null)
      {
        localObject = localAccount.getEmail();
        localQMTopBar.setSubTitle((String)localObject);
      }
    }
    else {
      if (localAccount == null) {
        break label160;
      }
    }
    label160:
    for (localObject = localAccount.getUin();; localObject = "")
    {
      this.bottleUin = ((String)localObject);
      localQMTopBar.setButtonLeftBack();
      localQMTopBar.setButtonLeftOnclickListener(new BottleBeachFragment.5(this));
      localQMTopBar.setButtonRightMore(true);
      localQMTopBar.setButtonReplyOnClickListener(new BottleBeachFragment.6(this));
      localQMTopBar.setButtonMoreOnClickListener(new BottleBeachFragment.7(this));
      localQMTopBar.getButtonReply().setContentDescription(getString(2131720839));
      localQMTopBar.getButtonMore().setContentDescription(getString(2131720858));
      localQMTopBar.setCenterOnclickListener(new BottleBeachFragment.8(this));
      return;
      localObject = "";
      break;
    }
  }
  
  private void renderListView(BottleBeach[] paramArrayOfBottleBeach)
  {
    this.mListView.setVisibility(0);
    if ((paramArrayOfBottleBeach == null) || (paramArrayOfBottleBeach.length == 0))
    {
      this.mLoading.setVisibility(0);
      ((TextView)this.mLoading.findViewById(2131363610)).setText(getString(2131690986));
      this.mAdapter.getWrappedAdapter().update(paramArrayOfBottleBeach);
    }
    for (;;)
    {
      this.popularizeBanner.render(this.mListView, false);
      return;
      if (this.mListView.isEnabled())
      {
        this.mLoading.setVisibility(8);
        if (this.isInsertAnimation)
        {
          this.isInsertAnimation = false;
          this.mAllBottles = null;
          this.mAdapter.getWrappedAdapter().updateWithAnimation(paramArrayOfBottleBeach);
        }
        else
        {
          this.mAdapter.getWrappedAdapter().update(paramArrayOfBottleBeach);
        }
      }
    }
  }
  
  private void renderLoading()
  {
    this.mListView.setVisibility(8);
    this.mLoading.setVisibility(0);
  }
  
  private void renderPicking()
  {
    if (this.mAdapter.getCount() == 0) {
      ((TextView)this.mLoading.findViewById(2131363610)).setText(getString(2131690987));
    }
  }
  
  private void renderUnread()
  {
    int i = this.mBottleManager.getBottleListController().getBottleUnreadCount();
    QMLog.log(4, "BottleBeachFragment", "renderUnread: " + i);
    getTopBar().setBottleUnread(i);
  }
  
  private void showADBottleActionDialog(BottleBeach paramBottleBeach)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131690980);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new BottleBeachFragment.21(this, paramBottleBeach));
    localBottomListSheetBuilder.addItem(getString(2131690961));
    paramBottleBeach = localBottomListSheetBuilder.build();
    paramBottleBeach.setCanceledOnTouchOutside(true);
    paramBottleBeach.show();
  }
  
  private void showActionDialog(BottleBeach paramBottleBeach)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(2131690980);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new BottleBeachFragment.20(this, paramBottleBeach));
    localBottomListSheetBuilder.addItem(getString(2131691008));
    localBottomListSheetBuilder.addItem(getString(2131690961));
    localBottomListSheetBuilder.addItem(getString(2131691009));
    paramBottleBeach = localBottomListSheetBuilder.build();
    paramBottleBeach.setCanceledOnTouchOutside(true);
    paramBottleBeach.show();
  }
  
  public QMTopBar getTopBar()
  {
    return (QMTopBar)findViewById(2131363595);
  }
  
  public void initDataSource()
  {
    this.mBottleManager = BottleManager.getInstance();
    this.mController = this.mBottleManager.getBottleBeachController();
    this.mBottleManager.getBottlerController().refreshMyInformation();
    this.mBottleManager.logEvent("Event_Bottle_Enter_Beach");
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopbar();
    initListView();
    this.mImageAnimation = ((ImageView)findViewById(2131368835));
    this.mLoading = ((LinearLayout)findViewById(2131363603));
    ((TextView)findViewById(2131363610)).setText(getString(2131690975));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131558772, null, false);
  }
  
  public void onBackground()
  {
    super.onBackground();
    this.mListView.onRefreshCompleteWithoutAnimation();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    this.mController.bindBottleLoadWatcher(this.mLoadBottleWatcher, paramBoolean);
    this.mController.bindBottlePickUpWatcher(this.mPickUpBottleWatcher, paramBoolean);
    this.mController.bindBottleSpamWatcher(this.mBottleSpamWatcher, paramBoolean);
    this.mBottleManager.getBottleListController().bindUpdateUnreadStatusWatcher(this.mUnreadWatcher, paramBoolean);
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 2) {
        break label26;
      }
      runOnMainThread(new BottleBeachFragment.1(this), 300L);
    }
    label26:
    while (paramInt1 != 1) {
      return;
    }
    this.isDeleteAnimation = true;
    this.isFlyAnimation = true;
    ArrayList localArrayList = new ArrayList();
    paramInt1 = ((Integer)paramHashMap.get("Action")).intValue();
    paramInt2 = getBottlePosition((String)paramHashMap.get("BottleId"));
    localArrayList.clear();
    localArrayList.add(Integer.valueOf(paramInt2));
    switch (paramInt1)
    {
    default: 
      throw new RuntimeException();
    case 3: 
      this.mAnimationEndRenderTask.addTask(new BottleBeachFragment.2(this));
    }
    this.mAnimationEndRenderTask.addTask(new BottleBeachFragment.3(this));
    runOnMainThread(new BottleBeachFragment.4(this, localArrayList), 300L);
  }
  
  public Object onLastFragmentFinish()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    if (localAccountList.size() > 1) {
      return MailFragmentActivity.createIntentToAccountList();
    }
    if (localAccountList.size() == 1) {
      return MailFragmentActivity.createIntentToFolderList(localAccountList.get(0).getId());
    }
    return null;
  }
  
  public void onRelease() {}
  
  public int refreshData()
  {
    if (this.mAnimationEndRenderTask.isNoTask()) {
      this.mController.loadBeachBottle();
    }
    if (this.mPickKey != null)
    {
      this.mController.requestBeachBottle(this.mPickKey);
      this.mPickKey = null;
    }
    if (!this.hasCheckedSpam)
    {
      this.mController.checkBottlePanel();
      this.hasCheckedSpam = true;
    }
    return 0;
  }
  
  public void render(int paramInt)
  {
    renderUnread();
    if ((this.mAdapter.getWrappedAdapter().getBeachBottles() == null) || (this.mAdapter.getWrappedAdapter().getBeachBottles().length == 0)) {
      renderLoading();
    }
    if (getTopBar().getButtonReplyMask() != null) {
      getTopBar().getButtonReplyMask().setVisibility(8);
    }
  }
  
  class AnimationEndTask
    implements Runnable
  {
    private ArrayList<Runnable> mList = new ArrayList();
    
    private AnimationEndTask() {}
    
    public void addTask(Runnable paramRunnable)
    {
      this.mList.add(paramRunnable);
    }
    
    public boolean isNoTask()
    {
      return this.mList.isEmpty();
    }
    
    public void run()
    {
      Iterator localIterator = this.mList.iterator();
      while (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
      this.mList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment
 * JD-Core Version:    0.7.0.1
 */