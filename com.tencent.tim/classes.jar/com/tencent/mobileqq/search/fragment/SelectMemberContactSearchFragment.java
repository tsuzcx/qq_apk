package com.tencent.mobileqq.search.fragment;

import acfp;
import amlt;
import amnh;
import amni;
import amvg;
import amwd;
import amxk;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.widget.ListView;

public class SelectMemberContactSearchFragment
  extends BaseSearchFragment
{
  private int dCH;
  private int fromType;
  private boolean isSearching;
  
  protected boolean DS()
  {
    return amxk.lo(this.fromType);
  }
  
  protected int IT()
  {
    return 20;
  }
  
  protected amlt a()
  {
    return new amni(this, this.a, this.c);
  }
  
  protected amwd a()
  {
    return new amvg(this.d, this.fromType, this.dCH, null);
  }
  
  protected void fO(String paramString, int paramInt)
  {
    super.fO(paramString, paramInt);
    if ((!amxk.lo(this.fromType)) && (this.GV != null))
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.isSearching = false;
        this.GV.setBackgroundResource(2131165586);
      }
    }
    else {
      return;
    }
    this.isSearching = true;
    this.GV.setBackgroundResource(2130838900);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.dCH = localBundle.getInt("contactSearchSource", 197437);
      this.fromType = localBundle.getInt("fromType", -1);
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!amxk.lo(this.fromType))
    {
      this.GV.setBackgroundResource(2131165586);
      this.isSearching = false;
      this.a.setOnTouchListener(new amnh(this));
    }
  }
  
  protected String vn()
  {
    return acfp.m(2131714212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */