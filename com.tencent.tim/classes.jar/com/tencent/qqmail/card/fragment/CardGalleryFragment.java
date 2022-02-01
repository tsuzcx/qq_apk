package com.tencent.qqmail.card.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.cursor.QMCardListCursor;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.model.QMCardType;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.card.view.CardGallery;
import com.tencent.qqmail.card.view.CardGalleryLoadMoreArrow;
import com.tencent.qqmail.card.view.CardHandler;
import com.tencent.qqmail.card.view.CardTransitionView;
import com.tencent.qqmail.card.view.CardTransitionView.TransitionListener;
import com.tencent.qqmail.card.view.DragLoadMoreHelper;
import com.tencent.qqmail.card.view.DragLoadMoreHelper.LoadMoreImpl;
import com.tencent.qqmail.card.view.DragLoadMoreHelper.LoadMoreState;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAdapterView;
import com.tencent.qqmail.card.watcher.DeleteCardWatcher;
import com.tencent.qqmail.card.watcher.LoadCardListWatcher;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMContentLoadingView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.base.BaseFragment.TransitionConfig;

public class CardGalleryFragment
  extends CardBaseFragment
  implements DragLoadMoreHelper.LoadMoreImpl
{
  public static String BIRTHDAY_CAKE_SHOW_EXTRA = "birthday_cake_show_extra";
  public static int BIRTHDAY_FRIEND_REQUEST_CODE = 1;
  private static final String TAG = "CardGalleryFragment";
  private final DeleteCardWatcher deleteCardWatcher = new CardGalleryFragment.12(this);
  private boolean fromSchema = false;
  private boolean isLeftEdgeDrag = false;
  private final LoadCardListWatcher listWatcher = new CardGalleryFragment.11(this);
  private View mBaseView;
  private FrameLayout mBirthdayFab;
  private View mBirthdayRedPoint;
  private CardGallery mCardGallery;
  private CardHandler mCardHandler = new CardGalleryFragment.1(this);
  private QMCardListCursor mCardListCursor;
  private final QMCardManager mCardManager = QMCardManager.shareInstance();
  private boolean mIsLoadMoreAvailable = true;
  private CardGalleryLoadMoreArrow mLoadMoreArrow;
  private DragLoadMoreHelper mLoadMoreHelper;
  private TextView mLoadMoreView;
  private QMContentLoadingView mLoadingView;
  private final HashMap<Integer, Integer> mPositionMap = new HashMap();
  private ArrayList<Integer> mRedDotCardTypes;
  private QMTopBar mTopBar;
  private FrameLayout mTransitionLayout;
  private CardTransitionView.TransitionListener mTransitionListener = new CardGalleryFragment.5(this);
  private int mTypeId = -1;
  private ArrayList<QMCardType> mTypeList;
  private final QMRefreshCallback refreshCallback = new CardGalleryFragment.2(this);
  private final SparseBooleanArray requestCardList = new SparseBooleanArray();
  
  public CardGalleryFragment(int paramInt, boolean paramBoolean)
  {
    this.mCardListCursor = this.mCardManager.getCardListByTypeId(paramInt);
    this.fromSchema = paramBoolean;
    updateTypeId(paramInt);
  }
  
  private String getTitle()
  {
    Iterator localIterator = this.mTypeList.iterator();
    while (localIterator.hasNext())
    {
      QMCardType localQMCardType = (QMCardType)localIterator.next();
      if (localQMCardType.getTypeId() == this.mTypeId) {
        return localQMCardType.getTypeName();
      }
    }
    return "";
  }
  
  private void hideTransitionLayout()
  {
    if (this.mTransitionLayout.getChildCount() > 0)
    {
      View localView = this.mTransitionLayout.getChildAt(0);
      if ((localView instanceof CardTransitionView)) {
        ((CardTransitionView)localView).recycle();
      }
    }
    this.mTransitionLayout.setVisibility(8);
    this.mTransitionLayout.removeAllViews();
  }
  
  private void initTopBar()
  {
    this.mTopBar = ((QMTopBar)this.mBaseView.findViewById(2131380043));
    this.mTopBar.setButtonLeftBack();
    this.mTopBar.getButtonLeft().setOnClickListener(new CardGalleryFragment.9(this));
    this.mTopBar.setButtonRightNormal(2131691278);
    this.mTopBar.getOnlyButtonRight().setEnabled(false);
    this.mTopBar.getButtonRight().setOnClickListener(new CardGalleryFragment.10(this));
    this.mTopBar.setBackgroundResource(2131165532);
  }
  
  private void onItemRemoved(long paramLong)
  {
    Log.d("CardGalleryFragment", "onItemRemoved: itemId: " + paramLong + ", typeId:" + this.mTypeId);
    QMCardData localQMCardData = this.mCardListCursor.getItem((int)paramLong);
    this.mCardManager.deleteMyCard(localQMCardData.getCardId());
  }
  
  private void refreshCursor(boolean paramBoolean)
  {
    Log.d("CardGalleryFragment", "refreshCursor: " + paramBoolean + ", typeid:" + this.mTypeId);
    runInBackground(new CardGalleryFragment.3(this, paramBoolean));
  }
  
  private void setTopbarTitleEditMode(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      this.mTopBar.setTitle(2131691287);
      return;
    }
    this.mTopBar.setTitle(getTitle());
  }
  
  private void showEmptyView()
  {
    String str = getString(2131691290);
    Object localObject = str;
    if (this.mTypeList != null)
    {
      localObject = str;
      if (this.mTypeList.size() > 0)
      {
        localObject = this.mTypeList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          QMCardType localQMCardType = (QMCardType)((Iterator)localObject).next();
          if ((localQMCardType.getTypeId() != this.mTypeId) || (StringExtention.isNullOrEmpty(localQMCardType.getEmptyTip()))) {
            break label106;
          }
          str = localQMCardType.getEmptyTip();
        }
      }
    }
    label106:
    for (;;)
    {
      break;
      localObject = str;
      this.mLoadingView.showTips((String)localObject);
      this.mCardGallery.setVisibility(8);
      return;
    }
  }
  
  private void showErrView()
  {
    Log.v("CardGalleryFragment", "showErrView");
    this.mLoadingView.showTips(2131691291);
    this.mCardGallery.setVisibility(8);
  }
  
  private void showGallery()
  {
    this.mLoadingView.hide();
    this.mCardGallery.setVisibility(0);
  }
  
  private void showLoading()
  {
    this.mCardGallery.setVisibility(8);
    this.mLoadingView.showLoading(true);
  }
  
  private void syncCardList()
  {
    if (this.requestCardList.get(this.mTypeId)) {
      return;
    }
    Log.d("CardGalleryFragment", "syncCardList: typeid:" + this.mTypeId);
    this.requestCardList.append(this.mTypeId, true);
    runInBackground(new CardGalleryFragment.4(this));
  }
  
  private void triggerDeleteMode(EcoGalleryAdapterView<?> paramEcoGalleryAdapterView, View paramView, int paramInt, long paramLong, boolean paramBoolean)
  {
    CardTransitionView localCardTransitionView = new CardTransitionView(getActivity());
    localCardTransitionView.setTopOffset(getResources().getDimensionPixelSize(2131296805));
    localCardTransitionView.initTransition(paramEcoGalleryAdapterView, paramView, paramLong, paramBoolean);
    localCardTransitionView.setTransitionListener(this.mTransitionListener);
    paramEcoGalleryAdapterView = new FrameLayout.LayoutParams(-1, -1);
    this.mTransitionLayout.removeAllViews();
    this.mTransitionLayout.addView(localCardTransitionView, paramEcoGalleryAdapterView);
    this.mTransitionLayout.setVisibility(0);
    this.mCardGallery.setVisibility(4);
    setTopbarTitleEditMode(true, paramBoolean);
    this.mCardGallery.setOnTouchListener(localCardTransitionView.getTouchListener());
  }
  
  private void updateTypeId(int paramInt)
  {
    if (paramInt != this.mTypeId)
    {
      QMLog.log(4, "CardGalleryFragment", "updateTypeId: " + paramInt + ", old: " + this.mTypeId);
      this.mTypeId = paramInt;
      this.mCardListCursor.setTypeId(this.mTypeId);
    }
  }
  
  public void fireLoadMore()
  {
    this.mLoadMoreView.setVisibility(8);
    this.mLoadMoreArrow.setVisibility(8);
    this.mLoadMoreArrow.reDrawArrow(0);
    this.mCardHandler.onLoadMoreInvoke();
  }
  
  public void initDataSource()
  {
    super.initDataSource();
    refreshCursor(true);
    syncCardList();
    this.mRedDotCardTypes = this.mCardManager.getRedDotCarTypeList();
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mBaseView = LayoutInflater.from(getActivity()).inflate(2131558822, null);
    this.mBaseView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    initTopBar();
    this.mCardGallery = ((CardGallery)this.mBaseView.findViewById(2131367833));
    this.mCardGallery.setOverScrollMode(2);
    this.mLoadingView = ((QMContentLoadingView)this.mBaseView.findViewById(2131370825));
    this.mLoadMoreView = ((TextView)this.mBaseView.findViewById(2131370779));
    this.mLoadMoreArrow = ((CardGalleryLoadMoreArrow)this.mBaseView.findViewById(2131370780));
    this.mLoadMoreHelper = new DragLoadMoreHelper(this, QMUIKit.getScreenWidth());
    this.mTransitionLayout = ((FrameLayout)this.mBaseView.findViewById(2131380146));
    this.mCardGallery.setCardHandler(this.mCardHandler);
    this.mCardGallery.setOnScrollListener(new CardGalleryFragment.6(this));
    this.mCardGallery.setOnItemLongClickListener(new CardGalleryFragment.7(this));
    this.mBirthdayFab = ((FrameLayout)this.mBaseView.findViewById(2131363517));
    this.mBirthdayRedPoint = this.mBaseView.findViewById(2131363519);
    this.mBirthdayFab.setOnClickListener(new CardGalleryFragment.8(this));
    if (CardUtil.getBirthdayCakeRedDot()) {
      this.mBirthdayRedPoint.setVisibility(0);
    }
    for (;;)
    {
      showLoading();
      return this.mBaseView;
      this.mBirthdayRedPoint.setVisibility(8);
    }
  }
  
  public String makeVerticalString(String paramString)
  {
    String[] arrayOfString = paramString.split("");
    paramString = "";
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (i < arrayOfString.length - 1) {}
      for (paramString = paramString + arrayOfString[i] + "\n";; paramString = paramString + arrayOfString[i])
      {
        i += 1;
        break;
      }
    }
    return paramString;
  }
  
  public void onBackPressed()
  {
    Object localObject;
    if (this.fromSchema)
    {
      localObject = AccountManager.shareInstance().getAccountList();
      if (((AccountList)localObject).size() != 0) {
        break label36;
      }
      localObject = AccountTypeListActivity.createIntent(true);
    }
    for (;;)
    {
      startActivity((Intent)localObject);
      super.onBackPressed();
      return;
      label36:
      if (((AccountList)localObject).size() == 1) {
        localObject = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId());
      } else {
        localObject = MailFragmentActivity.createIntentToAccountList();
      }
    }
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.listWatcher, paramBoolean);
    Watchers.bind(this.deleteCardWatcher, paramBoolean);
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      if (paramMotionEvent.getX() >= QMUIKit.getScreenWidth() / 20) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      this.isLeftEdgeDrag = bool;
      return this.isLeftEdgeDrag;
    }
  }
  
  public BaseFragment.TransitionConfig onFetchTransaction()
  {
    return SLIDE_TRANSITION_CONFIG;
  }
  
  public void onFragmentResult(int paramInt1, int paramInt2, HashMap<String, Object> paramHashMap)
  {
    if ((paramInt1 == BIRTHDAY_FRIEND_REQUEST_CODE) && (paramInt2 == -1) && (paramHashMap != null))
    {
      int i = ((Integer)paramHashMap.get(BIRTHDAY_CAKE_SHOW_EXTRA)).intValue();
      if ((this.mTypeId != 2) || (i != 1)) {
        break label61;
      }
      this.mBirthdayFab.setVisibility(0);
    }
    for (;;)
    {
      super.onFragmentResult(paramInt1, paramInt2, paramHashMap);
      return;
      label61:
      this.mBirthdayFab.setVisibility(8);
    }
  }
  
  public void onRelease()
  {
    this.mCardListCursor.close();
    super.onRelease();
  }
  
  public void render(int paramInt)
  {
    if ((this.mRedDotCardTypes != null) && (this.mRedDotCardTypes.size() > 0))
    {
      this.mTopBar.showRedDot(true, true);
      return;
    }
    this.mTopBar.showRedDot(false);
  }
  
  public void showLoadMore(DragLoadMoreHelper.LoadMoreState paramLoadMoreState, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardGalleryFragment
 * JD-Core Version:    0.7.0.1
 */