package com.tencent.qqmail.bottle.fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import com.tencent.qqmail.bottle.controller.BottleBeachController;
import com.tencent.qqmail.bottle.controller.BottleConversationController;
import com.tencent.qqmail.bottle.controller.BottleConversationController.ConversationSyncWatcher;
import com.tencent.qqmail.bottle.controller.BottleConversationController.UpdateConversationWatcher;
import com.tencent.qqmail.bottle.controller.BottleConversationCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.bottle.controller.BottleThrowController.OnBottleThrowWatcher;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.bottle.controller.OnActionCallback;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;
import com.tencent.qqmail.bottle.fragment.adapter.OnDetailClickBridge.OnDetailClickListener;
import com.tencent.qqmail.bottle.model.BottleBeach;
import com.tencent.qqmail.bottle.model.BottleConversation;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.bottle.view.BottleConversationMoreItemView;
import com.tencent.qqmail.bottle.view.BottleViewHolderCache;
import com.tencent.qqmail.bottle.view.ReplyListView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PopupAdapter;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMPopupWindow;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import moai.fragment.base.BaseFragment.TransitionConfig;
import moai.fragment.base.SaveArgumentField;

public class BottleConversationFragment
  extends BottleBaseFragment
{
  public static final int ACTION_DELETE = 1;
  public static final int ACTION_REPLY = 3;
  public static final int ACTION_SPAM = 2;
  private static final int ANIMATION_STATUS_COMPLETE = 2;
  private static final int ANIMATION_STATUS_DOING = 1;
  private static final int ANIMATION_STATUS_INIT = 0;
  public static final String BOTTLE_ACTION = "Action";
  public static final String BOTTLE_ID = "BottleId";
  private static final int DELAY_MILLS = 10;
  private static final String TAG = "BottleConversationFragment";
  private static ConversationHolder sViewHolder = null;
  private int animationStatus = 0;
  private View baseView = null;
  private boolean isFoldComplete = false;
  @SaveArgumentField
  private boolean isFromBeach = false;
  private boolean isInsertAnimation = false;
  private boolean isMyBottle = false;
  private boolean isReplying = false;
  private boolean isUseHolder = false;
  private int listViewFullHeight = -1;
  private BottleConversationAdapter mAdapter = null;
  @SaveArgumentField
  private String mBottleId;
  private BottleManager mBottleManager = null;
  private BottleThrowController.OnBottleThrowWatcher mBottleThrowWatcher = new BottleConversationFragment.30(this);
  @SaveArgumentField
  private String mBottlerName;
  private final View.OnClickListener mClickToBackPressed = new BottleConversationFragment.2(this);
  private QMContentLoadingView mContentLoadingView;
  private BottleConversationController mController = null;
  private final BottleConversationController.ConversationSyncWatcher mConversationSyncWatcher = new BottleConversationFragment.36(this);
  private BottleConversationCursor mCursor = null;
  private BottleConversationCursor mCursorToDelayRender = null;
  private final OnDetailClickBridge.OnDetailClickListener mDetailListener = new BottleConversationFragment.29(this);
  private int mLastVisibleIndex;
  private ReplyListView mListView = null;
  private BottleConversationMoreItemView mLoadMore = null;
  private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = null;
  private QMPopupWindow mPopupWindow;
  private final OnActionCallback mRemoveBottleCallback = new BottleConversationFragment.31(this);
  private final OnActionCallback mRemoveMsgCallback = new BottleConversationFragment.32(this);
  private final OnActionCallback mSpamBottleCallback = new BottleConversationFragment.33(this);
  private final BottleConversationController.UpdateConversationWatcher mUpdateConversationWatcher = new BottleConversationFragment.35(this);
  private BottleViewHolderCache mViewCache = null;
  private View.OnClickListener onReloadListener = new BottleConversationFragment.34(this);
  
  public BottleConversationFragment()
  {
    super(false);
  }
  
  public BottleConversationFragment(BottleBeach paramBottleBeach)
  {
    super(true);
    this.mBottleId = paramBottleBeach.getBottleid();
    this.mBottlerName = BottleManager.formatNickName(paramBottleBeach.getName());
    this.isFromBeach = true;
    this.isMyBottle = false;
  }
  
  public BottleConversationFragment(BottleList paramBottleList)
  {
    super(true);
    this.mBottleId = paramBottleList.getBottleId();
    this.mBottlerName = BottleManager.formatNickName(paramBottleList.getName());
    this.isFromBeach = false;
    this.isMyBottle = this.mBottleManager.getBottlerController().isMine(paramBottleList.getUin());
  }
  
  public BottleConversationFragment(String paramString)
  {
    super(true);
    this.mBottleId = paramString;
    Object localObject = this.mController.getBottleUin(paramString);
    localObject = this.mBottleManager.getBottlerController().getBottler((String)localObject);
    if (localObject == null) {}
    for (;;)
    {
      this.mBottlerName = BottleManager.formatNickName(str);
      this.isFromBeach = this.mBottleManager.getBottleBeachController().isBeachBottle(paramString);
      return;
      str = ((Bottler)localObject).getName();
    }
  }
  
  private void backWithBottleId(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Action", Integer.valueOf(paramInt));
    localHashMap.put("BottleId", this.mBottleId);
    setFragmentResult(-1, localHashMap);
    this.mListView.hideSoftInput();
    popBackStack();
  }
  
  private void confirmDeleteBottle(View paramView)
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131690965))).setMessage(2131690964).addAction(2131691246, new BottleConversationFragment.16(this))).addAction(0, 2131690961, 2, new BottleConversationFragment.15(this))).create();
    localQMUIDialog.setOnDismissListener(new BottleConversationFragment.17(this, paramView));
    localQMUIDialog.show();
  }
  
  private void confirmDeleteBottle(BottleConversation paramBottleConversation, View paramView)
  {
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(BottleManager.formatNickName(paramBottleConversation.getBottler().getName()));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new BottleConversationFragment.18(this, paramBottleConversation, arrayOfBoolean, paramView));
    localBottomListSheetBuilder.addItem(getString(2131690960));
    localBottomListSheetBuilder.addItem(getString(2131690962));
    localBottomListSheetBuilder.setOnBottomDialogDismissListener(new BottleConversationFragment.19(this, paramView, arrayOfBoolean));
    localBottomListSheetBuilder.build().show();
  }
  
  private void confirmDeleteMsg(BottleConversation paramBottleConversation, int paramInt, View paramView)
  {
    String str = BottleManager.formatNickName(paramBottleConversation.getBottler().getName());
    int i = this.mListView.getHeaderViewsCount();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt - i));
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(getActivity());
    localBottomListSheetBuilder.setTitle(str);
    localBottomListSheetBuilder.setOnSheetItemClickListener(new BottleConversationFragment.13(this, paramBottleConversation, localArrayList));
    localBottomListSheetBuilder.addItem(getString(2131690960));
    localBottomListSheetBuilder.addItem(getString(2131690963));
    localBottomListSheetBuilder.setOnBottomDialogDismissListener(new BottleConversationFragment.14(this, paramView));
    localBottomListSheetBuilder.build().show();
  }
  
  private void confirmResend(BottleConversation paramBottleConversation)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131690999))).setMessage(getString(2131690993)).addAction(2131691246, new BottleConversationFragment.21(this))).addAction(2131690992, new BottleConversationFragment.20(this, paramBottleConversation))).create().show();
  }
  
  private void confirmSpam()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131691009))).setMessage(getString(2131691010)).addAction(2131691246, new BottleConversationFragment.12(this))).addAction(0, 2131691009, 2, new BottleConversationFragment.11(this))).create().show();
  }
  
  @SuppressLint({"NewApi"})
  private void copyMessage(BottleConversation paramBottleConversation)
  {
    CommUtils.copyText(paramBottleConversation.getOriginalContent());
  }
  
  private void initPopupWindow()
  {
    this.mPopupWindow = new BottleConversationFragment.22(this, getActivity(), true);
  }
  
  private void initTopbar()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.isFromBeach)
    {
      localQMTopBar.setTitle(this.mBottlerName);
      localQMTopBar.setButtonLeftIcon(2130841088);
      localQMTopBar.setOnlyButtonLeftIconOnClickListener(new BottleConversationFragment.3(this));
      localQMTopBar.setButtonRightMore(false);
      localQMTopBar.getButtonReply().setVisibility(8);
      localQMTopBar.setButtonMoreOnClickListener(new BottleConversationFragment.4(this));
      localQMTopBar.getButtonMore().setContentDescription(getString(2131720837));
      localQMTopBar.setButtonRightBlue(2131719473);
      localQMTopBar.setOnlyButtonRightOnClickListener(new BottleConversationFragment.5(this));
      setTopbarActionButton(false);
      refreshTopBarButton();
    }
    for (;;)
    {
      localQMTopBar.setCenterOnclickListener(new BottleConversationFragment.10(this));
      return;
      if (this.isMyBottle)
      {
        localQMTopBar.setTitle(this.mBottlerName);
        localQMTopBar.setButtonLeftBack();
        localQMTopBar.setOnlyButtonLeftIconOnClickListener(this.mClickToBackPressed);
        localQMTopBar.setButtonRightIcon(2130840803);
        localQMTopBar.setOnlyButtonRightIconOnClickListener(new BottleConversationFragment.6(this));
        localQMTopBar.getButtonRightIcon().setContentDescription(getString(2131720814));
        setTopbarActionButton(false);
      }
      else
      {
        localQMTopBar.setTitle(this.mBottlerName);
        localQMTopBar.setButtonLeftBack();
        localQMTopBar.setOnlyButtonLeftIconOnClickListener(new BottleConversationFragment.7(this));
        localQMTopBar.setButtonRightMore(false);
        localQMTopBar.getButtonReply().setVisibility(8);
        localQMTopBar.setButtonMoreOnClickListener(new BottleConversationFragment.8(this));
        localQMTopBar.setButtonLeftNormal(2131691253);
        localQMTopBar.setOnlyButtonLeftOnClickListener(this.mClickToBackPressed);
        localQMTopBar.setButtonRightBlue(2131719473);
        localQMTopBar.setButtonRightOnclickListener(new BottleConversationFragment.9(this));
        setTopbarActionButton(false);
        refreshTopBarButton();
      }
    }
  }
  
  private boolean isTopbarButtonEnabled()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.isFromBeach) {
      return localQMTopBar.getOnlyButtonRight().isEnabled();
    }
    if (this.isMyBottle) {
      return localQMTopBar.getOnlyButtonRightIcon().isEnabled();
    }
    if (this.isReplying) {
      return localQMTopBar.getOnlyButtonRight().isEnabled();
    }
    return localQMTopBar.getButtonMore().isEnabled();
  }
  
  private void onShowKeyboard(boolean paramBoolean)
  {
    BottleManager.log("onShowKeyboard: " + paramBoolean);
    if (paramBoolean) {
      this.mBottleManager.logEvent("Event_Bottle_Button_Reply");
    }
    refreshTopBarButton();
    if (paramBoolean)
    {
      this.mListView.requestEditFocus();
      this.mAdapter.setEnabled(false);
      return;
    }
    this.mListView.clearEditFocus();
    this.mAdapter.setEnabled(true);
    setTopbarActionButton(true);
  }
  
  private void refreashFooterLoadingView()
  {
    int i;
    if (this.mAdapter != null)
    {
      i = this.mListView.getFooterViewsCount();
      if ((i <= 0) && (this.mAdapter.cursorCanLoadMore())) {
        break label42;
      }
      this.mListView.removeFooterView(this.mLoadMore);
    }
    label42:
    while ((i != 0) || (!this.mAdapter.cursorCanLoadMore())) {
      return;
    }
    this.mListView.addFooterView(this.mLoadMore);
  }
  
  private void refreshTopBarButton()
  {
    QMTopBar localQMTopBar = getTopBar();
    if (this.isFromBeach) {
      if (this.isReplying)
      {
        localQMTopBar.getButtonMore().setVisibility(8);
        localQMTopBar.getOnlyButtonRight().setVisibility(0);
      }
    }
    while (this.isMyBottle)
    {
      return;
      localQMTopBar.getButtonMore().setVisibility(0);
      localQMTopBar.getOnlyButtonRight().setVisibility(8);
      return;
    }
    if (this.isReplying)
    {
      localQMTopBar.getButtonMore().setVisibility(8);
      localQMTopBar.getOnlyButtonLeftIcon().setVisibility(0);
      if ((this.mListView.getEditTextContent().length() > 0) && (this.mListView.getEditTextContent().length() <= 140)) {}
      for (boolean bool = true;; bool = false)
      {
        setTopbarSendButton(bool);
        localQMTopBar.getOnlyButtonRight().setVisibility(0);
        localQMTopBar.getOnlyButtonLeft().setVisibility(8);
        return;
      }
    }
    localQMTopBar.getOnlyButtonRight().setVisibility(8);
    localQMTopBar.getOnlyButtonLeft().setVisibility(8);
    localQMTopBar.getOnlyButtonLeftIcon().setVisibility(0);
    localQMTopBar.getButtonMore().setVisibility(0);
  }
  
  private void renderListView(BottleConversationCursor paramBottleConversationCursor, boolean paramBoolean)
  {
    this.mContentLoadingView.showLoading(false);
    this.mContentLoadingView.setVisibility(8);
    this.mListView.setVisibility(0);
    if (((paramBottleConversationCursor == null) || (paramBottleConversationCursor.getCount() != 0)) || (paramBoolean)) {
      this.mAdapter.updateWithAnimation(paramBottleConversationCursor);
    }
    for (;;)
    {
      this.mCursor = null;
      this.isFoldComplete = false;
      refreashFooterLoadingView();
      return;
      this.mAdapter.update(paramBottleConversationCursor);
    }
  }
  
  private void renderLoading()
  {
    this.mListView.setVisibility(8);
    this.mContentLoadingView.showLoading(true);
  }
  
  private void setTopbarActionButton(boolean paramBoolean)
  {
    QMTopBar localQMTopBar = getTopBar();
    if ((localQMTopBar != null) && (localQMTopBar.getOnlyButtonRightIcon() != null)) {
      localQMTopBar.getOnlyButtonRightIcon().setEnabled(paramBoolean);
    }
    if ((localQMTopBar != null) && (localQMTopBar.getButtonMore() != null)) {
      localQMTopBar.getButtonMore().setEnabled(paramBoolean);
    }
  }
  
  private void setTopbarSendButton(boolean paramBoolean)
  {
    QMTopBar localQMTopBar = getTopBar();
    if ((localQMTopBar != null) && (localQMTopBar.getOnlyButtonRight() != null)) {
      localQMTopBar.getOnlyButtonRight().setEnabled(paramBoolean);
    }
  }
  
  private void showBottlerDetail(Bottler paramBottler)
  {
    CommonUI.showBottlerDetail(getActivity(), this.mBottleManager, paramBottler.getName(), paramBottler.isMale(), paramBottler.getAvatar(), paramBottler.getBigAvatar(), paramBottler.getUin());
  }
  
  private void toggleNormalState(boolean paramBoolean)
  {
    if (this.isReplying)
    {
      this.mListView.hideSoftInput();
      this.mListView.clearEditFocus();
      this.mAdapter.setEnabled(true);
      if (paramBoolean) {
        this.mController.setDraft(this.mBottleId, this.mListView.getEditTextContent());
      }
    }
  }
  
  private void toggleReplyingState()
  {
    if (!this.isReplying) {
      this.mAdapter.setEnabled(false);
    }
  }
  
  private void updateBottler(String paramString)
  {
    int j = 1;
    boolean bool = this.mBottleManager.getBottlerController().isMine(paramString);
    Bottler localBottler = this.mBottleManager.getBottlerController().getBottler(paramString);
    int i = 0;
    if (this.isMyBottle != bool)
    {
      this.isMyBottle = bool;
      i = 1;
    }
    if (localBottler != null)
    {
      this.mBottlerName = BottleManager.formatNickName(localBottler.getName());
      i = j;
    }
    for (;;)
    {
      if (i != 0)
      {
        getTopBar().reset();
        initTopbar();
        updateListViewMode();
      }
      return;
      QMLog.log(6, "BottleConversationFragment", "updateBottler getBottler null: " + paramString);
    }
  }
  
  private void updateListViewMode()
  {
    if (this.isMyBottle)
    {
      this.mListView.enableToPull(false);
      return;
    }
    this.mListView.expandWithoutAnimation();
    this.mListView.enableToPull(true);
  }
  
  public String getBottleId()
  {
    return this.mBottleId;
  }
  
  public QMTopBar getTopBar()
  {
    return (QMTopBar)findViewById(2131363600);
  }
  
  public void initDataSource()
  {
    BottleManager.log("conversation initDataSource: " + this.isMyBottle + ", " + this.mBottleManager.getBottlerController().getMyUin());
    this.mBottleManager.logEvent("Event_Bottle_Enter_Message");
    this.mBottleManager.clearResponseNotify(this.mBottleId);
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopbar();
    initPopupWindow();
    this.mContentLoadingView = ((QMContentLoadingView)findViewById(2131370545));
    this.mListView = ((ReplyListView)findViewById(2131363599));
    this.mListView.setEnabled(true);
    this.mListView.setEditTextHint(getResources().getString(2131690958, new Object[] { this.mBottlerName }));
    paramView.setBackgroundColor(getResources().getColor(2131167654));
    this.mListView.setOnItemClickListener(new BottleConversationFragment.23(this));
    this.mListView.setOnItemLongClickListener(new BottleConversationFragment.24(this));
    this.mListView.setOnScrollListener(new BottleConversationFragment.25(this));
    this.mListView.setOnTextChangeWatcher(new BottleConversationFragment.26(this));
    this.mListView.setOnTouchListener(new BottleConversationFragment.27(this));
    this.mListView.setOnResizeListener(new BottleConversationFragment.28(this));
    updateListViewMode();
    this.mAdapter = new BottleConversationAdapter(getActivity(), this.mBottleManager, this.mViewCache, this.isFromBeach);
    this.mAdapter.setListView(this.mListView);
    this.mLoadMore = new BottleConversationMoreItemView(getActivity());
    refreashFooterLoadingView();
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setDivider(new ColorDrawable(getResources().getColor(2131165952)));
    this.mListView.setDividerHeight(getResources().getDimensionPixelSize(2131297594));
    this.mListView.setHeaderDividersEnabled(false);
    paramView = this.mController.getDraft(this.mBottleId);
    this.mListView.setEditTextContent(paramView);
    this.mAdapter.setOnDetailClickListener(this.mDetailListener);
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ConversationHolder)paramViewHolder;
    if (paramViewHolder != null)
    {
      this.isUseHolder = true;
      this.baseView = paramViewHolder.baseView;
    }
    for (this.mViewCache = paramViewHolder.cacheView;; this.mViewCache = new BottleViewHolderCache())
    {
      return this.baseView;
      this.isUseHolder = false;
      this.baseView = LayoutInflater.from(getActivity()).inflate(2131558775, null, false);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    this.animationStatus = 2;
    if (this.mCursorToDelayRender != null)
    {
      setTopbarActionButton(true);
      renderListView(this.mCursorToDelayRender, false);
      if (!this.isFromBeach) {
        break label44;
      }
    }
    for (;;)
    {
      this.mCursorToDelayRender = null;
      return;
      label44:
      if (this.isMyBottle) {}
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    super.onAnimationStart(paramAnimation);
    this.animationStatus = 1;
  }
  
  public void onBackPressed()
  {
    if (this.isReplying)
    {
      toggleNormalState(true);
      return;
    }
    if (this.isFromBeach)
    {
      String str = this.mListView.getEditTextContent();
      this.mController.setDraft(this.mBottleId, str);
      this.mListView.hideSoftInput();
      super.onBackPressed();
      return;
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    this.mController.bindUpdateConversationWatcher(this.mUpdateConversationWatcher, paramBoolean);
    this.mController.bindConversationSyncWatcher(this.mConversationSyncWatcher, paramBoolean);
    this.mBottleManager.getBottleThrowController().bindOnBottleThrowWatcher(this.mBottleThrowWatcher, paramBoolean);
  }
  
  public QMBaseFragment.ViewHolder onCacheView()
  {
    if (sViewHolder != null) {
      sViewHolder.activeFragment = this;
    }
    return sViewHolder;
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return !this.isReplying;
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    if (this.isFromBeach) {
      return SCALE_TRANSITION_CONFIG;
    }
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (!this.isFromBeach) && (!this.isMyBottle) && (!this.isReplying) && (isTopbarButtonEnabled()))
    {
      if ((this.mPopupWindow != null) && (this.mPopupWindow.isShowing()))
      {
        this.mPopupWindow.dismiss();
        return false;
      }
      showPopWindow(getTopBar().getButtonMore());
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public Object onLastFragmentFinish()
  {
    return new BottleListFragment();
  }
  
  public void onRelease()
  {
    this.mAdapter.update(null);
    getTopBar().reset();
    refreashFooterLoadingView();
    this.mListView.setAdapter(null);
    this.mListView.setOnItemClickListener(null);
    this.mListView.setOnItemLongClickListener(null);
    this.mListView.setOnScrollListener(null);
    this.mListView.setOnTextChangeWatcher(null);
    this.mListView.setOnResizeListener(null);
    this.mListView.reset();
  }
  
  public void onSaveViewHolder() {}
  
  public int refreshData()
  {
    if (this.mAdapter != null) {
      this.mController.loadConversation(this.mBottleId, this.mAdapter.getCursor());
    }
    return 0;
  }
  
  public void render(int paramInt)
  {
    if (this.mAdapter.getCursor() == null) {
      renderLoading();
    }
  }
  
  public void showPopWindow(View paramView)
  {
    if (this.mPopupWindow.isShowing()) {
      this.mPopupWindow.dismiss();
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131691008));
    ((List)localObject).add(getString(2131691009));
    ((List)localObject).add(getString(2131690961));
    localObject = new PopupAdapter(getActivity(), 2131559771, 2131373495, (List)localObject);
    this.mPopupWindow.setAdapter((ListAdapter)localObject);
    this.mPopupWindow.setAnchor(paramView);
    this.mPopupWindow.showDown();
  }
  
  static class ConversationHolder
    extends QMBaseFragment.ViewHolder
  {
    BottleConversationFragment activeFragment;
    View baseView;
    BottleViewHolderCache cacheView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment
 * JD-Core Version:    0.7.0.1
 */