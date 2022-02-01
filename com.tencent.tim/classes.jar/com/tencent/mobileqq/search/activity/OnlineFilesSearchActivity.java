package com.tencent.mobileqq.search.activity;

import ampx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.OnlineFileSearchFragment;
import java.util.ArrayList;
import java.util.List;

public class OnlineFilesSearchActivity
  extends BaseSearchActivity
{
  static List<ampx> Bs;
  List<ampx> Bt;
  String avs;
  protected int mFromType = 35;
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, OnlineFilesSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    Bs = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    OnlineFileSearchFragment localOnlineFileSearchFragment = new OnlineFileSearchFragment();
    localOnlineFileSearchFragment.e(this.mFromType, this.avs, Bs);
    return localOnlineFileSearchFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mFromType = getIntent().getIntExtra("fromType", 35);
    if (this.mFromType == 27) {}
    for (boolean bool = true;; bool = false)
    {
      this.cDh = bool;
      this.avs = getIntent().getStringExtra("keyword");
      this.Bt = new ArrayList();
      if (Bs != null) {
        this.Bt.addAll(Bs);
      }
      Bs = null;
      super.doOnCreate(paramBundle);
      this.Dt.setVisibility(8);
      return true;
    }
  }
  
  protected String vm()
  {
    return "搜索腾讯文档";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.OnlineFilesSearchActivity
 * JD-Core Version:    0.7.0.1
 */