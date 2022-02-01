package com.tencent.mobileqq.filemanager.data.search;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import java.util.ArrayList;
import java.util.List;

public class SearchTypeDetailActivity
  extends IphoneTitleBarActivity
{
  private SparseArray<String> cB = new SparseArray();
  private int mFileType;
  private List<Integer> mTypes;
  private String mUin;
  
  public static void a(Context paramContext, int paramInt, String paramString, List<Integer> paramList)
  {
    Intent localIntent = new Intent(paramContext, SearchTypeDetailActivity.class);
    localIntent.putExtra("qfile_search_param_type", paramInt);
    localIntent.putExtra("qfile_search_param_uin", paramString);
    paramString = new Bundle();
    paramString.putIntegerArrayList("qfile_search_param_others", (ArrayList)paramList);
    localIntent.putExtra("qfile_search_param_others", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mFileType = super.getIntent().getIntExtra("qfile_search_param_type", -1);
    this.mUin = super.getIntent().getStringExtra("qfile_search_param_uin");
    this.mTypes = super.getIntent().getBundleExtra("qfile_search_param_others").getIntegerArrayList("qfile_search_param_others");
    this.cB.put(3, acfp.m(2131714149));
    this.cB.put(2, acfp.m(2131714153));
    this.cB.put(0, acfp.m(2131714152));
    this.cB.put(1, acfp.m(2131714151));
    this.cB.put(11, acfp.m(2131714150));
    super.setContentView(2131559029);
    super.setTitle((CharSequence)this.cB.get(this.mFileType));
    paramBundle = getSupportFragmentManager().beginTransaction();
    ChatFileSearchFragment localChatFileSearchFragment = new ChatFileSearchFragment();
    localChatFileSearchFragment.mFromType = 2;
    localChatFileSearchFragment.cYj = 2;
    localChatFileSearchFragment.mFileType = this.mFileType;
    localChatFileSearchFragment.mTypes = this.mTypes;
    localChatFileSearchFragment.mUin = this.mUin;
    paramBundle.replace(2131365379, localChatFileSearchFragment);
    paramBundle.commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity
 * JD-Core Version:    0.7.0.1
 */