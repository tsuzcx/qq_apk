package com.tencent.mobileqq.mini.entry.search.ui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchResultAdapter$SearchResultViewHolder$1
  implements View.OnClickListener
{
  SearchResultAdapter$SearchResultViewHolder$1(SearchResultAdapter.SearchResultViewHolder paramSearchResultViewHolder, Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      MiniAppController.launchMiniAppByAppInfo(this.val$activity, this.val$miniAppInfo, this.val$refer);
      ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).updateHistorySearchList(this.val$keyword);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SearchResultAdapter", 1, "SearchResultAdapter, start miniApp exception: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchResultAdapter.SearchResultViewHolder.1
 * JD-Core Version:    0.7.0.1
 */