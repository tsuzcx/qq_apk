package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import java.util.ArrayList;
import java.util.List;
import ous;
import ovd;
import oxh;
import oxx;
import pbc;
import pcr;
import rxk;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  public boolean HJ()
  {
    return false;
  }
  
  public List<rxk> bw()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new pbc());
    localArrayList.add(new oxh());
    localArrayList.add(new oxx());
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    ovd.f(getActivity(), false);
  }
  
  public int getContentLayoutId()
  {
    return 2131560884;
  }
  
  public String getLogTag()
  {
    return "QCircleContentDetailFragment";
  }
  
  public int getStatusBarColor()
  {
    return getResources().getColor(2131167595);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (pcr.a().ey(57)) {
      pcr.a().aX(getActivity().getIntent());
    }
  }
  
  public void onBackPressed() {}
  
  public void onDestroy()
  {
    ovd.bc(getActivity());
    ous.clearMemoryCache();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    pcr.a().vq(57);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */