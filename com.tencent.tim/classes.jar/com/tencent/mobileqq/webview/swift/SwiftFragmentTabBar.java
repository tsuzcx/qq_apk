package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import java.util.List;

public class SwiftFragmentTabBar
  extends TabBarView
{
  public SwiftFragmentTabBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(List<WebViewTabBarData> paramList, TabBarView.a parama)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      super.a(((WebViewTabBarData)paramList.get(i)).tabName);
      i += 1;
    }
    super.setOnTabChangeListener(parama);
    super.setSelectedTab(0, false);
    super.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar
 * JD-Core Version:    0.7.0.1
 */