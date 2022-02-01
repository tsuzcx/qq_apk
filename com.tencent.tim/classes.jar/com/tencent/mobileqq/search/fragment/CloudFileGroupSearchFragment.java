package com.tencent.mobileqq.search.fragment;

import amlt;
import amlw;
import ammt;
import amwd;
import android.os.Bundle;
import aths;
import aths.a;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine;

public class CloudFileGroupSearchFragment
  extends BaseSearchFragment
{
  aths.a a = new ammt(this);
  private int fromType = 27;
  
  public static CloudFileGroupSearchFragment a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt);
    CloudFileGroupSearchFragment localCloudFileGroupSearchFragment = new CloudFileGroupSearchFragment();
    localCloudFileGroupSearchFragment.setArguments(localBundle);
    return localCloudFileGroupSearchFragment;
  }
  
  protected boolean DS()
  {
    return false;
  }
  
  protected amlt a()
  {
    return new amlw(this.c);
  }
  
  protected amwd a()
  {
    return new CloudFileGroupSearchEngine(this.d, this.fromType);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      this.fromType = localBundle.getInt("fromType", -1);
    }
    aths.a().a(this.a);
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aths.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.CloudFileGroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */