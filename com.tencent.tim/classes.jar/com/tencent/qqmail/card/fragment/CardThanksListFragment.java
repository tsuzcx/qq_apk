package com.tencent.qqmail.card.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.cursor.QMCardThanksFriendListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.watcher.LoadThankListWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import moai.core.watcher.Watchers;

public class CardThanksListFragment
  extends CardBaseFragment
{
  private static final String TAG = "CardThanksListFragment";
  private boolean isLoading;
  private final LoadThankListWatcher loadThankListWatcher = new CardThanksListFragment.2(this);
  private CardThanksListAdapter mAdapter;
  private final String mCardId;
  private QMCardThanksFriendListCursor mCursor;
  private ListView mListView;
  private QMContentLoadingView mLoadingView;
  private View mRootView;
  private QMTopBar mTopBar;
  private final QMRefreshCallback refreshCallback = new CardThanksListFragment.1(this);
  
  public CardThanksListFragment(QMCardData paramQMCardData)
  {
    this.mCardId = paramQMCardData.getCardId();
    this.mCursor = QMCardManager.shareInstance().getCardThanksFriendListByCardId(this.mCardId);
  }
  
  private void initListView()
  {
    this.mListView = ((ListView)this.mRootView.findViewById(2131370584));
    this.mLoadingView = ((QMContentLoadingView)this.mRootView.findViewById(2131370787));
  }
  
  private void initTopBar()
  {
    this.mTopBar = ((QMTopBar)this.mRootView.findViewById(2131380043));
    this.mTopBar.setButtonLeftNormal(2131691246);
    this.mTopBar.setTitle(2131691331);
    this.mTopBar.getButtonLeft().setOnClickListener(new CardThanksListFragment.5(this));
  }
  
  private void refreshCursor(boolean paramBoolean)
  {
    this.isLoading = true;
    runInBackground(new CardThanksListFragment.3(this, paramBoolean));
  }
  
  private void showListView()
  {
    if (this.mAdapter == null)
    {
      this.mAdapter = new CardThanksListAdapter(getActivity(), this.mCursor);
      this.mListView.setAdapter(this.mAdapter);
      return;
    }
    this.mAdapter.notifyDataSetChanged();
  }
  
  private void syncThankList()
  {
    this.isLoading = true;
    runInBackground(new CardThanksListFragment.4(this));
  }
  
  public void initDataSource()
  {
    syncThankList();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558828, null);
    this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    initTopBar();
    initListView();
    return this.mRootView;
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.loadThankListWatcher, paramBoolean);
  }
  
  public void onRelease()
  {
    this.mCursor.close();
    super.onRelease();
  }
  
  public void render(int paramInt)
  {
    if (!this.isLoading)
    {
      if ((this.mCursor != null) && (this.mCursor.getCount() > 0))
      {
        this.mLoadingView.hide();
        showListView();
      }
    }
    else {
      return;
    }
    this.mLoadingView.showTips(2131695454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardThanksListFragment
 * JD-Core Version:    0.7.0.1
 */