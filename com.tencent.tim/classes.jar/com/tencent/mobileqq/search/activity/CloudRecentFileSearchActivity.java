package com.tencent.mobileqq.search.activity;

import ampx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.CloudRecentFileSearchFragment;
import java.util.ArrayList;
import java.util.List;

public class CloudRecentFileSearchActivity
  extends BaseSearchActivity
{
  List<ampx> Bt;
  String avs;
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, int paramInt)
  {
    paramList = new Intent(paramContext, CloudRecentFileSearchActivity.class);
    paramList.putExtra("keyword", paramString);
    paramContext.startActivity(paramList);
  }
  
  protected BaseSearchFragment a()
  {
    CloudRecentFileSearchFragment localCloudRecentFileSearchFragment = new CloudRecentFileSearchFragment();
    localCloudRecentFileSearchFragment.Q(this.avs, null);
    return localCloudRecentFileSearchFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent();
    this.avs = getIntent().getStringExtra("keyword");
    this.Bt = new ArrayList();
    super.doOnCreate(paramBundle);
    this.Dt.setVisibility(8);
    return true;
  }
  
  protected String vm()
  {
    return "搜索最近浏览";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.CloudRecentFileSearchActivity
 * JD-Core Version:    0.7.0.1
 */