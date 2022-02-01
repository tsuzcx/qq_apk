package com.tencent.mobileqq.teamwork.fragment;

import android.app.Activity;
import android.content.Intent;
import aobu;
import aobw;
import araz;
import arbt;
import arcd.a;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import svi;

public class TeamWorkDocsListFragment
  extends WebViewFragment
{
  public void Qq()
  {
    arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
    if (localarbt != null)
    {
      svi localsvi = a();
      if ((localsvi != null) && (aobw.pN(localsvi.getShareUrl())))
      {
        getHostActivity().getIntent().putExtra("big_brother_source_key", "biz_src_xl_docs");
        localarbt.a = new aobu(getHostActivity());
      }
      localarbt.a(localsvi, this.jdField_a_of_type_Arcd$a.gK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment
 * JD-Core Version:    0.7.0.1
 */