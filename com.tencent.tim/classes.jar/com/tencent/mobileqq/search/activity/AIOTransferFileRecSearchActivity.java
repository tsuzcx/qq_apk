package com.tencent.mobileqq.search.activity;

import ampx;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.search.fragment.AIOTransferFileSearchFragment;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import java.util.List;

public class AIOTransferFileRecSearchActivity
  extends AIOTransferFileSearchActivity
{
  protected int mFromType = 32;
  
  public static void a(Context paramContext, String paramString, List<ampx> paramList, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AIOTransferFileRecSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    Bs = paramList;
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    AIOTransferFileSearchFragment localAIOTransferFileSearchFragment = new AIOTransferFileSearchFragment(this.mFromType);
    localAIOTransferFileSearchFragment.Q(this.avs, Bs);
    return localAIOTransferFileSearchFragment;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.cDh = true;
    return super.doOnCreate(paramBundle);
  }
  
  protected String vm()
  {
    return "搜索我收到的文件";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.AIOTransferFileRecSearchActivity
 * JD-Core Version:    0.7.0.1
 */