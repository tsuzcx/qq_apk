package com.tencent.mobileqq.activity;

import acfd;
import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import aqdj;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import jqs;
import vsy;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private a a;
  private acfd h = new vsy(this);
  private XListView mListView;
  private ArrayList<SearchResultItem> py;
  
  void Q(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.py.size())) {}
    do
    {
      return;
      localObject2 = (SearchResultItem)this.py.get(paramInt);
    } while (localObject2 == null);
    Object localObject1 = ((SearchResultItem)localObject2).strNick;
    String str1 = String.valueOf(((SearchResultItem)localObject2).lUIN);
    String str2 = ((SearchResultItem)localObject2).strMobile;
    int i = ((SearchResultItem)localObject2).source;
    Object localObject2 = (b)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ((b)localObject2).FB.setText((CharSequence)localObject1);
      if (i != 1) {
        break label194;
      }
      ((b)localObject2).pV.setImageDrawable(aqdj.a(this.app, str1, (byte)1));
      ((b)localObject2).FC.setText("QQ号码: " + str1);
    }
    for (;;)
    {
      ((b)localObject2).pos = paramInt;
      paramView.setContentDescription(((b)localObject2).FB.getText());
      return;
      TextView localTextView = ((b)localObject2).FB;
      if (i == 1) {}
      for (localObject1 = str1;; localObject1 = str2)
      {
        localTextView.setText((CharSequence)localObject1);
        break;
      }
      label194:
      ((b)localObject2).pV.setImageDrawable(aqdj.b(this.app, str2, (byte)1));
      ((b)localObject2).FC.setText(acfp.m(2131714111) + str2);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563014);
    setContentBackgroundResource(2130838900);
    setTitle(acfp.m(2131714110));
    this.mListView = ((XListView)findViewById(2131377821));
    this.mListView.setContentBackground(2130838900);
    addObserver(this.h);
    this.py = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.py == null) {
      this.py = new ArrayList();
    }
    this.a = new a(null);
    this.mListView.setAdapter(this.a);
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.h);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView.getTag() instanceof b))
    {
      i = ((b)paramView.getTag()).pos;
      if ((i < 0) || (i >= this.py.size())) {
        break label101;
      }
    }
    label101:
    for (SearchResultItem localSearchResultItem = (SearchResultItem)this.py.get(i);; localSearchResultItem = null)
    {
      if (localSearchResultItem == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (localSearchResultItem.bIsEnterpriseQQ == 0) {
          AddFriendActivity.a(this, localSearchResultItem, this.app, false, 1);
        } else {
          jqs.a(this, null, String.valueOf(localSearchResultItem.lUIN), false, -1, true, -1);
        }
      }
    }
  }
  
  public class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      return SearchFriendListActivity.a(SearchFriendListActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= SearchFriendListActivity.a(SearchFriendListActivity.this).size())) {
        return null;
      }
      return SearchFriendListActivity.a(SearchFriendListActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = SearchFriendListActivity.this.getLayoutInflater().inflate(2131563013, paramViewGroup, false);
        SearchFriendListActivity.b localb = new SearchFriendListActivity.b();
        localb.pV = ((ImageView)paramView.findViewById(2131368406));
        localb.FB = ((TextView)paramView.findViewById(2131372383));
        localb.FC = ((TextView)paramView.findViewById(2131365662));
        paramView.setTag(localb);
        paramView.setOnClickListener(SearchFriendListActivity.this);
      }
      for (;;)
      {
        SearchFriendListActivity.this.Q(paramView, paramInt);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  static class b
  {
    TextView FB;
    TextView FC;
    ImageView pV;
    int pos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */