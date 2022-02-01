package com.tencent.mobileqq.search.activity;

import ampx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.FoldersSearchFragment;
import java.util.ArrayList;
import java.util.List;

public class FoldersSearchActivity
  extends BaseSearchActivity
{
  static List<ampx> Bs;
  List<ampx> Bt;
  String avs;
  
  public static void d(Context paramContext, String paramString, List<ampx> paramList)
  {
    Intent localIntent = new Intent(paramContext, FoldersSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    Bs = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    FoldersSearchFragment localFoldersSearchFragment = new FoldersSearchFragment();
    localFoldersSearchFragment.Q(this.avs, Bs);
    return localFoldersSearchFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.avs = getIntent().getStringExtra("keyword");
    this.Bt = new ArrayList();
    this.Bt.addAll(Bs);
    Bs = null;
    this.cDh = true;
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected String vm()
  {
    return "搜索文件夹";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.FoldersSearchActivity
 * JD-Core Version:    0.7.0.1
 */