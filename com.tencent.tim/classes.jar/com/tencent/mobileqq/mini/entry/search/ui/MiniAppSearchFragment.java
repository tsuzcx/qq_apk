package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import jqi;
import mqq.util.WeakReference;

public class MiniAppSearchFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SearchResultAdapter.DataChangedListener
{
  public static final String KEY_RECOMMEND_WORD = "recommend_word";
  public static final String KEY_REFER = "key_refer";
  public static final String SEARCH_KEYWORD = "search_keyword";
  public static final String TAG = "MiniAppSearchFragment";
  private boolean hasSendHotSearchRequest;
  private TextView mCancelButton;
  private ImageView mClearHistoryButton;
  private ImageButton mClearInputTextButton;
  private EditText mEditTextView;
  private ImageView mEmptyBackground;
  private ViewGroup mHistoryAndRecommendContainer;
  private ViewGroup mHistoryListViewGroup;
  private ViewGroup mHistorySearchContainer;
  private HotSearchAdapter mHotSearchAdapter;
  private TextView mHotSearchTitle;
  private ViewGroup mNoSearchResultViewGroup;
  private GridView mRecommendGridView;
  private int mRefer;
  private SearchResultAdapter mResultAdapter;
  private ListView mResultListView;
  private ViewGroup mSearchResultContainer;
  private TextView mSearchResultExceptionText;
  private String mTianShuKeyword;
  
  private void initData()
  {
    Object localObject = getActivity().getIntent();
    this.mTianShuKeyword = ((Intent)localObject).getStringExtra("recommend_word");
    localObject = ((Intent)localObject).getStringExtra("search_keyword");
    if (!TextUtils.isEmpty(this.mTianShuKeyword)) {
      this.mEditTextView.setHint(this.mTianShuKeyword);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.mEditTextView.setText((CharSequence)localObject);
      this.mEditTextView.setSelection(((String)localObject).length());
    }
    localObject = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    String str = ((MiniAppSearchDataManager)localObject).getHotSearchTitle();
    if (!TextUtils.isEmpty(str)) {
      this.mHotSearchTitle.setText(str);
    }
    if (((MiniAppSearchDataManager)localObject).getHotSearchData().size() > 0) {
      this.mHotSearchAdapter.setData(((MiniAppSearchDataManager)localObject).getHotSearchData());
    }
  }
  
  private void initHistorySearch()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mEditTextView.setOnEditorActionListener(new MiniAppSearchFragment.3(this, localMiniAppSearchDataManager));
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getCachedHistorySearchList());
  }
  
  private void sendHotSearchRequest()
  {
    ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).sendHotSearchAppRequest();
  }
  
  private void updateHistorySearchRecordLayout()
  {
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mHistoryListViewGroup.removeAllViews();
    updateSearchRecord(localMiniAppSearchDataManager, localMiniAppSearchDataManager.getHistorySearchList());
  }
  
  private void updateSearchRecord(MiniAppSearchDataManager paramMiniAppSearchDataManager, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      TextView localTextView = new TextView(getActivity());
      localTextView.setText(str);
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130841819);
      localTextView.setOnClickListener(new MiniAppSearchFragment.4(this, localTextView, paramMiniAppSearchDataManager));
      this.mHistoryListViewGroup.addView(localTextView);
    }
    if (paramList.size() > 0)
    {
      this.mHistorySearchContainer.setVisibility(0);
      this.mHistorySearchContainer.requestLayout();
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_expo", null);
      return;
    }
    this.mHistorySearchContainer.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (getActivity() != null)
      {
        getActivity().finish();
        continue;
        this.mEditTextView.setText("");
        this.mSearchResultContainer.setVisibility(8);
        this.mHistoryAndRecommendContainer.setVisibility(0);
        this.mClearInputTextButton.setVisibility(8);
        continue;
        this.mHistorySearchContainer.setVisibility(8);
        ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).clearHistorySearch();
        MiniProgramLpReportDC04239.reportAsync("desktop", "search", "history_delete", null);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559605, null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramLayoutInflater.setFitsSystemWindows(true);
    }
    for (;;)
    {
      this.mRefer = getActivity().getIntent().getIntExtra("key_refer", 2077);
      QLog.d("MiniAppSearchFragment", 1, "onCreateView, refer: " + this.mRefer);
      if (this.mRefer != 1005)
      {
        this.hasSendHotSearchRequest = true;
        sendHotSearchRequest();
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("MiniAppSearchFragment", 1, "onDestroy");
    MiniAppSearchDataManager localMiniAppSearchDataManager = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    localMiniAppSearchDataManager.clearSearchResult();
    localMiniAppSearchDataManager.setDataChangedListener(null);
    localMiniAppSearchDataManager.setHotSearchDataChangedListener(null);
    this.hasSendHotSearchRequest = false;
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onResultDataChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(this.mEditTextView.getText().toString())) {
        return;
      }
      if (this.mHistoryAndRecommendContainer.getVisibility() == 0)
      {
        this.mHistoryAndRecommendContainer.setVisibility(8);
        this.mSearchResultContainer.setVisibility(0);
        this.mClearInputTextButton.setVisibility(0);
        QLog.d("MiniAppSearchFragment", 1, "onResultDataChanged, history and recommend is gone");
      }
      if (((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).getSearchResultData().size() == 0)
      {
        this.mEmptyBackground.setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20200317103714_042EdeeOON.png", null));
        this.mNoSearchResultViewGroup.setVisibility(0);
        if (!jqi.isNetworkAvailable(BaseApplicationImpl.getContext()))
        {
          this.mSearchResultExceptionText.setText(2131700256);
          return;
        }
        this.mSearchResultExceptionText.setText(2131695929);
        return;
      }
      this.mNoSearchResultViewGroup.setVisibility(8);
      return;
    }
    if (!this.hasSendHotSearchRequest)
    {
      sendHotSearchRequest();
      this.hasSendHotSearchRequest = true;
    }
    this.mHistoryAndRecommendContainer.setVisibility(0);
    this.mSearchResultContainer.setVisibility(8);
    this.mClearInputTextButton.setVisibility(8);
    updateHistorySearchRecordLayout();
    this.mResultListView.smoothScrollToPositionFromTop(0, 0, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    QLog.d("MiniAppSearchFragment", 1, "onStop");
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface != null) {
      ((MiniAppExposureManager)localAppInterface.getManager(322)).submitSearchReportData();
    }
  }
  
  public void onTextChanged(String paramString)
  {
    if (this.mResultAdapter != null) {
      this.mResultAdapter.setKeyword(paramString);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mHistoryAndRecommendContainer = ((ViewGroup)paramView.findViewById(2131371607));
    this.mSearchResultContainer = ((ViewGroup)paramView.findViewById(2131371705));
    this.mHistorySearchContainer = ((ViewGroup)paramView.findViewById(2131371688));
    this.mHistoryListViewGroup = ((ViewGroup)paramView.findViewById(2131371687));
    this.mNoSearchResultViewGroup = ((ViewGroup)paramView.findViewById(2131371692));
    this.mEmptyBackground = ((ImageView)paramView.findViewById(2131371707));
    this.mSearchResultExceptionText = ((TextView)paramView.findViewById(2131371708));
    this.mHotSearchTitle = ((TextView)paramView.findViewById(2131371698));
    this.mRecommendGridView = ((GridView)paramView.findViewById(2131371695));
    paramBundle = (MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360);
    this.mHotSearchAdapter = new HotSearchAdapter(getActivity(), this.mHotSearchTitle, this.mRefer);
    paramBundle.setHotSearchDataChangedListener(this.mHotSearchAdapter);
    this.mRecommendGridView.setAdapter(this.mHotSearchAdapter);
    this.mResultListView = ((ListView)paramView.findViewById(2131371710));
    this.mResultAdapter = new SearchResultAdapter(getActivity(), this.mRefer);
    this.mResultAdapter.setDataChangedListener(this);
    paramBundle.setDataChangedListener(this.mResultAdapter);
    this.mResultListView.setAdapter(this.mResultAdapter);
    this.mCancelButton = ((TextView)paramView.findViewById(2131371568));
    this.mCancelButton.setOnClickListener(this);
    this.mClearInputTextButton = ((ImageButton)paramView.findViewById(2131371685));
    this.mClearInputTextButton.setOnClickListener(this);
    this.mClearHistoryButton = ((ImageView)paramView.findViewById(2131371684));
    this.mClearHistoryButton.setOnClickListener(this);
    this.mEditTextView = ((EditText)paramView.findViewById(2131371683));
    this.mEditTextView.addTextChangedListener(new SearchEditTextWatcher(this));
    this.mEditTextView.postDelayed(new MiniAppSearchFragment.1(this), 300L);
    this.mResultListView.setOnScrollListener(new MiniAppSearchFragment.2(this));
    initData();
    initHistorySearch();
  }
  
  static class SearchEditTextWatcher
    implements TextWatcher
  {
    private WeakReference<SearchResultAdapter.DataChangedListener> weakReferenceListener;
    
    public SearchEditTextWatcher(SearchResultAdapter.DataChangedListener paramDataChangedListener)
    {
      this.weakReferenceListener = new WeakReference(paramDataChangedListener);
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SearchResultAdapter.DataChangedListener localDataChangedListener = (SearchResultAdapter.DataChangedListener)this.weakReferenceListener.get();
      if (localDataChangedListener != null) {
        localDataChangedListener.onTextChanged(paramCharSequence.toString());
      }
      if (!TextUtils.isEmpty(paramCharSequence)) {
        ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).sendSearchAppRequest(paramCharSequence.toString());
      }
      while (localDataChangedListener == null) {
        return;
      }
      localDataChangedListener.onResultDataChanged(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment
 * JD-Core Version:    0.7.0.1
 */