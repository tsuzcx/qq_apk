package com.tencent.qqmail.search.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.SearchHistoryItem;
import moai.oss.KvHelper;

class SearchListFragment$19
  implements AdapterView.OnItemClickListener
{
  SearchListFragment$19(SearchListFragment paramSearchListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    SearchListFragment.access$2102(this.this$0, true);
    Object localObject = SearchListFragment.access$3500(this.this$0).getItem(paramInt);
    SearchListFragment.access$3600(this.this$0);
    localObject = ((SearchHistoryItem)localObject).getSearchContent();
    SearchListFragment.access$1400(this.this$0).setText((CharSequence)localObject);
    SearchListFragment.access$1400(this.this$0).setSelection(((String)localObject).length());
    SearchListFragment.access$1800(this.this$0);
    KvHelper.eventSearchHistoryClick(new double[0]);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.search.fragment.SearchListFragment.19
 * JD-Core Version:    0.7.0.1
 */