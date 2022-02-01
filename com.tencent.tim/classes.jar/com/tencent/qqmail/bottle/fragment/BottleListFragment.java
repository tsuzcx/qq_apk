package com.tencent.qqmail.bottle.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateListWatcher;
import com.tencent.qqmail.bottle.controller.BottleListController.UpdateUnreadStatusWatcher;
import com.tencent.qqmail.bottle.controller.BottleListCursor;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import com.tencent.qqmail.view.QMBottomBar;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class BottleListFragment
  extends BottleBaseFragment
{
  private static final String TAG = "BottleListFragment";
  private static final long TRANSACTION_DURATION = 300L;
  private final int BOTTLE_CONVERSATION_REQUEST_CODE = 1;
  private View.OnClickListener bottomButtonDeleteEvent = new BottleListFragment.12(this);
  private TextView bottomDeleteButton;
  private HashMap<Integer, String> checkMap = new HashMap();
  private QMBottomBar footerBar;
  private boolean isEditMode;
  private ActionTask mActionTask = null;
  private BottleListAdapter mAdapter;
  private BottleManager mBottleManager;
  private QMContentLoadingView mContentLoadingView;
  private BottleListController mController;
  private ItemScrollListView mListView;
  private final BottleListController.UpdateUnreadStatusWatcher mUnreadWatcher = new BottleListFragment.17(this);
  private final BottleListController.UpdateListWatcher mUpdateListWatcher = new BottleListFragment.16(this);
  private View.OnClickListener onReloadListener = new BottleListFragment.15(this);
  
  public BottleListFragment()
  {
    super(false);
  }
  
  private void animRemoveItem(String paramString)
  {
    int i = getBottlePosition(paramString);
    if (i >= 0)
    {
      paramString = new ArrayList();
      paramString.add(Integer.valueOf(i));
      ListViewRemoveItemAnimator.animateRemoval(this.mListView, paramString, new BottleListFragment.13(this));
      return;
    }
    BottleListController localBottleListController = this.mController;
    if (this.mAdapter != null) {}
    for (paramString = this.mAdapter.getCursor();; paramString = null)
    {
      localBottleListController.loadList(paramString);
      return;
    }
  }
  
  private void animRemoveItemList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(getBottlePosition((String)paramList.next())));
    }
    ListViewRemoveItemAnimator.animateRemoval(this.mListView, localArrayList, new BottleListFragment.14(this));
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
    Log.v("BottleListFragment", "getBottlePosition: ( " + i + ", " + m + " )");
    while (i <= m)
    {
      k = i - j;
      BottleList localBottleList = this.mAdapter.getItem(k);
      if ((localBottleList != null) && (localBottleList.getBottleId().equals(paramString))) {
        return k;
      }
      i += 1;
    }
    return -1;
  }
  
  private boolean isSelectAll()
  {
    int k = this.mListView.getHeaderViewsCount();
    int i;
    int j;
    if ((this.mAdapter != null) && (this.mAdapter.getCursor() != null)) {
      if (this.mAdapter.getCursor().hasMoreItem())
      {
        i = this.mAdapter.getCount() - 1;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < i)
      {
        if (!this.mListView.isItemChecked(j + k))
        {
          return false;
          i = this.mAdapter.getCount();
          break;
        }
        j += 1;
        continue;
        return false;
      }
    }
    return true;
  }
  
  private void refreshSelectedButton(boolean paramBoolean)
  {
    if (this.isEditMode)
    {
      if (paramBoolean) {
        getTopBar().setButtonLeftNormal(2131719470);
      }
    }
    else {
      return;
    }
    getTopBar().setButtonLeftNormal(2131719469);
  }
  
  private void renderListView(BottleListCursor paramBottleListCursor)
  {
    this.mContentLoadingView.showLoading(false);
    if (this.mAdapter.update(paramBottleListCursor))
    {
      if (this.mAdapter.getCount() == 0)
      {
        this.mListView.setVisibility(8);
        this.mContentLoadingView.setVisibility(0);
        this.mContentLoadingView.showTips(2131690969);
      }
    }
    else {
      return;
    }
    this.mContentLoadingView.setVisibility(8);
    this.mListView.setVisibility(0);
  }
  
  private void renderLoading()
  {
    this.mListView.setVisibility(8);
    this.mContentLoadingView.setVisibility(0);
    this.mContentLoadingView.showLoading(true);
  }
  
  private void renderTopBarUnreadCount()
  {
    int i = this.mController.getBottleUnreadCount();
    QMTopBar localQMTopBar = getTopBar();
    if (i > 0) {}
    for (String str = "(" + i + ")";; str = null)
    {
      localQMTopBar.setTitleSec(str);
      return;
    }
  }
  
  private void setAllSelectState(boolean paramBoolean)
  {
    int j = 0;
    int k = this.mListView.getHeaderViewsCount();
    int i;
    if (paramBoolean)
    {
      if ((this.mAdapter != null) && (this.mAdapter.getCursor() != null))
      {
        if (this.mAdapter.getCursor().hasMoreItem()) {
          i = this.mAdapter.getCount() - 1;
        }
        while (j < i)
        {
          if (!this.mListView.isItemChecked(j + k)) {
            this.mListView.setItemChecked(j + k, true);
          }
          BottleList localBottleList = this.mAdapter.getItem(j);
          this.checkMap.put(Integer.valueOf(j), localBottleList.getBottleId());
          j += 1;
          continue;
          i = this.mAdapter.getCount();
        }
      }
    }
    else
    {
      if ((this.mAdapter != null) && (this.mAdapter.getCursor() != null))
      {
        if (this.mAdapter.getCursor().hasMoreItem()) {}
        for (i = this.mAdapter.getCount() - 1;; i = this.mAdapter.getCount())
        {
          j = 0;
          while (j < i)
          {
            if (this.mListView.isItemChecked(j + k)) {
              this.mListView.setItemChecked(j + k, false);
            }
            j += 1;
          }
        }
      }
      this.mListView.clearChoices();
      this.checkMap.clear();
    }
  }
  
  private void toggleEditMode()
  {
    this.isEditMode = true;
    this.mListView.setChoiceMode(2);
    getTopBar().setButtonLeftNormal(2131719469);
    getTopBar().setButtonLeftOnclickListener(new BottleListFragment.8(this));
    getTopBar().setButtonRightBlue(2131691246);
    getTopBar().setButtonRightOnclickListener(new BottleListFragment.9(this));
    this.footerBar.setVisibility(0);
    if (this.mAdapter != null)
    {
      this.mAdapter.setIsEditing(this.isEditMode);
      this.mAdapter.notifyDataSetChanged();
    }
    this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getPaddingRight(), getResources().getDimensionPixelSize(2131297365));
    this.mListView.setEnablePullToRefresh(false);
  }
  
  private void toggleNormalMode()
  {
    this.isEditMode = false;
    setAllSelectState(false);
    this.mListView.setChoiceMode(0);
    getTopBar().getButtonRight().setVisibility(8);
    getTopBar().setButtonLeftBack();
    getTopBar().setButtonLeftOnclickListener(new BottleListFragment.10(this));
    this.checkMap.clear();
    this.footerBar.setVisibility(8);
    if (this.mAdapter != null)
    {
      this.mAdapter.setIsEditing(this.isEditMode);
      this.mAdapter.notifyDataSetChanged();
    }
    this.mListView.setPadding(this.mListView.getPaddingLeft(), this.mListView.getPaddingTop(), this.mListView.getPaddingRight(), 0);
    this.mListView.setEnablePullToRefresh(true);
    this.mListView.setOnRefreshListener(new BottleListFragment.11(this));
  }
  
  private void updateBottomDeleteButton()
  {
    if (this.checkMap.size() == 0)
    {
      this.bottomDeleteButton.setEnabled(false);
      this.bottomDeleteButton.setText(getString(2131690973).substring(0, 4));
      return;
    }
    this.bottomDeleteButton.setText(String.format(getString(2131690973), new Object[] { Integer.valueOf(this.checkMap.size()) }));
    this.bottomDeleteButton.setEnabled(true);
  }
  
  public QMTopBar getTopBar()
  {
    return (QMTopBar)findViewById(2131380043);
  }
  
  public void initDataSource()
  {
    this.mBottleManager = BottleManager.getInstance();
    this.mController = this.mBottleManager.getBottleListController();
    this.mBottleManager.logEvent("Event_Bottle_Enter_List");
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    paramView = getTopBar();
    paramView.setTitle(2131690981);
    paramView.setButtonLeftBack();
    paramView.setButtonLeftOnclickListener(new BottleListFragment.2(this));
    paramView.setCenterOnclickListener(new BottleListFragment.3(this));
    this.mContentLoadingView = ((QMContentLoadingView)findViewById(2131370545));
    this.mListView = ((ItemScrollListView)findViewById(2131363601));
    this.mListView.setOnItemClickListener(new BottleListFragment.4(this));
    paramView = new boolean[1];
    paramView[0] = 0;
    this.mListView.setOnItemLongClickListener(new BottleListFragment.5(this, paramView));
    this.mListView.setOnTouchListener(new BottleListFragment.6(this, paramView));
    this.mListView.setEnablePullToRefresh(true);
    this.mListView.setOnRefreshListener(new BottleListFragment.7(this));
    this.mAdapter = new BottleListAdapter(getActivity(), this.mBottleManager);
    this.mListView.setAdapter(this.mAdapter);
    this.mListView.setHeaderDividersEnabled(false);
    this.footerBar = ((QMBottomBar)findViewById(2131363602));
    this.bottomDeleteButton = this.footerBar.addButton(1, String.format(getString(2131690973), new Object[] { Integer.valueOf(this.checkMap.size()) }), this.bottomButtonDeleteEvent);
    this.mListView.setOnRightViewClickListener(new OnRightViewClickListener());
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    return LayoutInflater.from(getActivity()).inflate(2131558778, null, false);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.mActionTask != null) {
      this.mActionTask.execute(2);
    }
  }
  
  public void onBackPressed()
  {
    if (this.isEditMode)
    {
      toggleNormalMode();
      return;
    }
    super.onBackPressed();
  }
  
  public void onBackground()
  {
    super.onBackground();
    this.mListView.onRefreshCompleteWithoutAnimation();
    this.mController.unmarkNewUnread();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    this.mController.bindUpdateListWatcher(this.mUpdateListWatcher, paramBoolean);
    this.mBottleManager.getBottleListController().bindUpdateUnreadStatusWatcher(this.mUnreadWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return (!this.isEditMode) && (this.mListView.isFold());
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.mActionTask = new BottleListFragment.1(this, 2, paramHashMap);
    }
  }
  
  public Object onLastFragmentFinish()
  {
    return new BottleBeachFragment();
  }
  
  public void onRelease()
  {
    this.mAdapter.update(null);
    this.mListView.setAdapter(null);
  }
  
  public int refreshData()
  {
    BottleListController localBottleListController;
    if ((this.mActionTask == null) || (!this.mActionTask.execute(1)))
    {
      localBottleListController = this.mController;
      if (this.mAdapter == null) {
        break label45;
      }
    }
    label45:
    for (BottleListCursor localBottleListCursor = this.mAdapter.getCursor();; localBottleListCursor = null)
    {
      localBottleListController.loadList(localBottleListCursor);
      return 0;
    }
  }
  
  public void render(int paramInt)
  {
    renderTopBarUnreadCount();
    if (this.mAdapter.getCursor() == null) {
      renderLoading();
    }
  }
  
  static abstract class ActionTask
    implements Runnable
  {
    private static final int STATUS_IGNORE = 2;
    public static final int STATUS_INIT = 0;
    public static final int STATUS_ONANIMATIONEND = 2;
    public static final int STATUS_REFRESHDATA = 1;
    private int expectedStatusToRun;
    private boolean mCompleted = false;
    private int status;
    
    public ActionTask(int paramInt)
    {
      this.expectedStatusToRun = paramInt;
    }
    
    public boolean execute(int paramInt)
    {
      if (isCompleteOrIgnore()) {
        return false;
      }
      if (this.status >= paramInt)
      {
        this.status = 2;
        return false;
      }
      if ((paramInt == this.expectedStatusToRun) && (!this.mCompleted))
      {
        this.mCompleted = true;
        run();
        return true;
      }
      this.status = paramInt;
      return false;
    }
    
    public boolean isCompleteOrIgnore()
    {
      return (this.mCompleted) || (this.status == 2);
    }
    
    public String toString()
    {
      return String.format(Locale.getDefault(), "@%d, expectedStatusToRun[%d], status[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.expectedStatusToRun), Integer.valueOf(this.status) });
    }
  }
  
  class OnRightViewClickListener
    implements ItemScrollListView.OnRightViewClickListener
  {
    OnRightViewClickListener() {}
    
    public void onRightViewClick(View paramView, int paramInt)
    {
      if (paramView.getId() == 2131377335)
      {
        paramView = BottleListFragment.this.mAdapter.getItem(paramInt);
        if (paramView == null) {
          QMLog.log(6, "BottleListFragment", "delete bottle, but bottle is null!");
        }
      }
      else
      {
        return;
      }
      BottleListFragment.this.mBottleManager.logEvent("Event_Bottle_Delete");
      BottleListFragment.this.mController.remove(paramView.getBottleId(), new BottleListFragment.OnRightViewClickListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment
 * JD-Core Version:    0.7.0.1
 */