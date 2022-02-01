package com.tencent.qqmail.search.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.model.uidomain.NoteUI;
import com.tencent.qqmail.note.NoteListDefine;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.search.view.SearchToggleView;
import com.tencent.qqmail.search.view.SearchToggleView.SearchToggleViewCallback;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMSearchBar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMTips.QMTipsCallback;
import com.tencent.qqmail.view.QMContentLoadingView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class SearchNoteListActivity
  extends BaseActivity
  implements SearchToggleView.SearchToggleViewCallback
{
  public static final String FILTER_INDEX = "filterIndex";
  public static final String FROM_CATID = "categoryId";
  public static final String FROM_FOLDER = "fromfolder";
  public static final String KEY_WORD = "keyword";
  public static final String N_SEARCHNOTE_BEFORESEND = "searchnote_beforesend";
  public static final String N_SEARCHNOTE_ERR = "searchnote_err";
  public static final String N_SEARCHNOTE_SUCC = "searchnote_succ";
  public static final String N_SEARCHNOTE_UPDATE = "searchnote_update";
  public static final String SEARCH_NOTE_KEY = "sSearchNoteContent";
  public static final String TAG = "NoteListActivity";
  public static final String TOGGLE_HEIGHT = "toggleheight";
  private boolean activeSearch = false;
  private boolean canScroll = true;
  private boolean isLoading = false;
  private int lastIndex = -1;
  private int lastTop = -1;
  private QMContentLoadingView listEmptyView;
  private String mCategoryId;
  private ListView mNoteListListView = null;
  private SearchNoteListAdapter mNoteStdArrayAdapter = null;
  private NoteUI mNoteUI = null;
  private QMTips.QMTipsCallback mQMTipsCallback = new SearchNoteListActivity.4(this);
  public IObserver mSearchNoteBeforeSend = new IObserver(new SearchNoteListActivity.3(this));
  public IObserver mSearchNoteError = new IObserver(new SearchNoteListActivity.2(this));
  public IObserver mSearchNoteSuccess = new IObserver(new SearchNoteListActivity.1(this));
  private SearchToggleView mSearchToggleView = null;
  private IObserver noteListUpdateIObserver = new IObserver(new SearchNoteListActivity.7(this));
  private QMSearchBar searchBar;
  private TextView searchBarCancel;
  private ImageButton searchBarCleaner;
  private EditText searchBarInput;
  private QMNetworkRequest searchHttpRequest = null;
  
  private boolean ImeActionDone(int paramInt)
  {
    return paramInt == 6;
  }
  
  private boolean ImeActionGo(int paramInt)
  {
    return paramInt == 2;
  }
  
  private boolean ImeActionUnspecified(int paramInt)
  {
    return paramInt == 0;
  }
  
  private void didCancelButtonClick()
  {
    this.mNoteListListView.setPadding(0, 0, 0, 0);
    Threads.runOnMainThread(new SearchNoteListActivity.14(this), 10L);
  }
  
  private void getIntentData()
  {
    this.mCategoryId = getIntent().getExtras().getString("categoryId");
  }
  
  private void goBack()
  {
    hideKeyBoard();
    this.mNoteListListView.setSelected(false);
    restorePositionToTop();
    finish();
  }
  
  private void handleSearchNoteList(String paramString)
  {
    paramString = Pattern.compile("\\!|\\@|\\#|\\/|\\\\|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\_|\\+|\\~|\\{|\\}|\\:||\\[|\\]|\\;|\\'|\\,|\\.").matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.find()) {
      paramString.appendReplacement(localStringBuffer, "");
    }
    paramString.appendTail(localStringBuffer);
    paramString = localStringBuffer.toString();
    if (paramString.length() == 0) {
      return;
    }
    getNoteManager().searchNoteWithNotifications(paramString);
  }
  
  private void initSearchBar()
  {
    this.searchBar = new QMSearchBar(this);
    this.searchBar.setStateSearch();
    this.searchBar.setSearchHint(2131696400);
    this.searchBar.setBtnRight();
    ((RelativeLayout)findViewById(2131377843)).addView(this.searchBar, 0);
    this.searchBarCancel = this.searchBar.getBtnRight();
    this.searchBarCancel.setVisibility(0);
    this.searchBarCancel.setText(2131691246);
    this.searchBarCancel.setOnClickListener(new SearchNoteListActivity.8(this));
    this.searchBarCleaner = this.searchBar.searchInputCleaner;
    this.searchBarCleaner.setVisibility(8);
    this.searchBarCleaner.setOnClickListener(new SearchNoteListActivity.9(this));
    this.searchBarInput = this.searchBar.searchInput;
    this.searchBarInput.setText("");
    this.searchBarInput.setFocusable(true);
    this.searchBarInput.setFocusableInTouchMode(true);
    this.searchBarInput.setEnabled(true);
    this.searchBarInput.postDelayed(new SearchNoteListActivity.10(this), 300L);
    this.searchBarInput.setOnTouchListener(new SearchNoteListActivity.11(this));
    this.searchBarInput.setOnEditorActionListener(new SearchNoteListActivity.12(this));
    this.searchBarInput.addTextChangedListener(new SearchNoteListActivity.13(this));
    KeyBoardHelper.showKeyBoard(this.searchBarInput, 2);
  }
  
  private void initSearchBarView()
  {
    initSearchToggleView();
    initSearchBar();
  }
  
  private void initSearchToggleView()
  {
    this.mSearchToggleView = ((SearchToggleView)findViewById(2131377864));
    this.mSearchToggleView.init();
    this.mSearchToggleView.setToggleViewCallback(this);
  }
  
  private void noteItemOnClick(View paramView, int paramInt)
  {
    String str = "";
    ArrayList localArrayList = new ArrayList();
    if (this.mNoteUI != null)
    {
      int i = 0;
      while (i < this.mNoteUI.size())
      {
        this.mNoteUI.moveToPosition(i);
        localArrayList.add(this.mNoteUI.getNoteId());
        i += 1;
      }
      this.mNoteUI.moveToPosition(paramInt);
      str = this.mNoteUI.getNoteId();
    }
    Intent localIntent = new Intent(this, ReadNoteActivity.class);
    localIntent.putExtra("noteId", str);
    localIntent.putExtra("position", paramInt);
    localIntent.putExtra("noteList", localArrayList);
    localIntent.putExtra("from", "searchnotelist");
    localIntent.putExtra("catalogName", NoteListDefine.UI_TOPBAR_LEFTBACK_SEARCH);
    paramView.setSelected(true);
    hideKeyBoard();
    startActivity(localIntent);
  }
  
  private void noteListCreate()
  {
    this.mSearchToggleView = ((SearchToggleView)findViewById(2131377864));
    this.mSearchToggleView.addClickChain(new SearchNoteListActivity.5(this));
    this.mNoteListListView = ((ListView)findViewById(2131377911));
    if (this.mNoteListListView != null)
    {
      if (this.mNoteStdArrayAdapter == null) {
        this.mNoteStdArrayAdapter = new SearchNoteListAdapter(getApplicationContext(), 2131377911, this.mNoteUI);
      }
      this.mNoteListListView.setOnScrollListener(new SearchNoteListActivity.6(this));
      this.mNoteListListView.setAdapter(this.mNoteStdArrayAdapter);
      this.mNoteStdArrayAdapter.notifyDataSetChanged();
    }
    initSearchBarView();
    setNoteListItemOnClick();
    registerObserver();
    readDataSourceByCid(this.mCategoryId);
  }
  
  private void registerObserver()
  {
    QMNotification.registNotification("searchnote_succ", this.mSearchNoteSuccess);
    QMNotification.registNotification("searchnote_err", this.mSearchNoteError);
    QMNotification.registNotification("searchnote_beforesend", this.mSearchNoteBeforeSend);
    QMNotification.registNotification("searchnote_update", this.noteListUpdateIObserver);
  }
  
  private void render()
  {
    if ((this.mNoteListListView != null) && (this.mNoteStdArrayAdapter != null))
    {
      this.mNoteStdArrayAdapter.notifyDataSetChanged();
      this.mNoteListListView.setVerticalScrollBarEnabled(false);
      this.mNoteListListView.setSelection(0);
      this.mNoteListListView.setVisibility(0);
    }
  }
  
  private void renderEmpty()
  {
    this.listEmptyView.showTips(2131696416);
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
    this.mNoteListListView.setVisibility(8);
  }
  
  private void renderNormal()
  {
    this.listEmptyView.hide();
    this.mSearchToggleView.hide();
    this.mNoteListListView.setVisibility(0);
  }
  
  private void setNoteListItemOnClick()
  {
    this.mNoteListListView.setOnItemClickListener(new SearchNoteListActivity.15(this));
  }
  
  private void triggerServerSearch()
  {
    String str = this.searchBarInput.getText().toString();
    if (!StringUtils.isBlank(str)) {
      handleSearchNoteList(str);
    }
  }
  
  private void unRegisterObserver()
  {
    QMNotification.unregistNotification("searchnote_succ", this.mSearchNoteSuccess);
    QMNotification.unregistNotification("searchnote_err", this.mSearchNoteError);
    QMNotification.unregistNotification("searchnote_beforesend", this.mSearchNoteBeforeSend);
    QMNotification.unregistNotification("searchnote_update", this.noteListUpdateIObserver);
  }
  
  public void didDismiss(SearchToggleView paramSearchToggleView)
  {
    didCancelButtonClick();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (!isCanScroll())) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public NoteManager getNoteManager()
  {
    return NoteManager.sharedInstance();
  }
  
  public void handleTipsHide(QMTips paramQMTips)
  {
    if (this.searchHttpRequest != null) {
      this.searchHttpRequest.abort();
    }
  }
  
  public void initTips(QMTips paramQMTips)
  {
    paramQMTips.setCanceledOnTouchOutside(true);
    paramQMTips.setCallback(this.mQMTipsCallback);
  }
  
  public boolean isCanScroll()
  {
    return this.canScroll;
  }
  
  public boolean isLoading()
  {
    return this.isLoading;
  }
  
  public void load()
  {
    renderNormal();
    if (this.mNoteStdArrayAdapter.getCount() == 0) {
      renderEmpty();
    }
    for (;;)
    {
      this.mSearchToggleView.show();
      return;
      render();
    }
  }
  
  public void mergeRender()
  {
    renderNormal();
    String str = this.searchBarInput.getText().toString();
    this.mNoteUI = getNoteManager().searchNoteWithServerResult(str);
    this.mNoteUI.setSeverSearch(false);
    this.mNoteStdArrayAdapter.setItems(this.mNoteUI);
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
    if (this.mNoteStdArrayAdapter.getCount() == 0)
    {
      renderEmpty();
      return;
    }
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131563020);
    this.listEmptyView = ((QMContentLoadingView)findViewById(2131370545));
    getIntentData();
    noteListCreate();
    load();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unRegisterObserver();
  }
  
  public void onResume()
  {
    super.onResume();
    String str = this.searchBarInput.getText().toString();
    if (!StringUtils.isEmpty(str))
    {
      if (!this.mNoteUI.getServerSearch()) {
        mergeRender();
      }
    }
    else {
      return;
    }
    renderLocalSearch(str);
  }
  
  public void onStop()
  {
    super.onStop();
    savePosition();
  }
  
  public void readDataSource()
  {
    this.mNoteUI = getNoteManager().getLastSearchNoteUI();
    this.mNoteStdArrayAdapter.setItems(this.mNoteUI);
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
  }
  
  public void readDataSourceByCid(String paramString)
  {
    this.mNoteUI = getNoteManager().getSearchCategoryNoteList(paramString);
    this.mNoteStdArrayAdapter.setItems(this.mNoteUI);
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
  }
  
  public void renderLocalSearch(String paramString)
  {
    this.mNoteUI = getNoteManager().searchNote(paramString);
    this.mNoteUI.setSeverSearch(true);
    this.mNoteStdArrayAdapter.setItems(this.mNoteUI);
    renderNormal();
    this.mNoteStdArrayAdapter.notifyDataSetChanged();
    this.mSearchToggleView.hide();
  }
  
  public void restorePosition()
  {
    if (this.lastIndex > -1) {
      this.mNoteListListView.setSelectionFromTop(this.lastIndex, this.lastTop);
    }
  }
  
  public void restorePositionToTop()
  {
    this.lastIndex = -1;
  }
  
  public void savePosition()
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
  
  public void setCanScroll(boolean paramBoolean)
  {
    this.canScroll = paramBoolean;
  }
  
  public void setLoading(boolean paramBoolean)
  {
    this.isLoading = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchNoteListActivity
 * JD-Core Version:    0.7.0.1
 */