package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import oum;
import owf;
import owk;
import oww;
import oxd;
import oxg;
import oxx;
import rxk;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
{
  private QCircleFolderFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart;
  private owk jdField_a_of_type_Owk;
  private oxd b;
  private List<rxk> lu;
  
  private void initParam()
  {
    int i = 1;
    Intent localIntent = getActivity().getIntent();
    boolean bool = localIntent.getBooleanExtra("key_enable_splash", true);
    if (this.jdField_a_of_type_Owk != null) {
      this.jdField_a_of_type_Owk.rg(bool);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {}
    try
    {
      int j = Integer.parseInt(localIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.ve(i);
  }
  
  public void biQ()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onWriteClick?");
    if (this.b != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleFolderActivityFragment", 4, bool);
      if (this.b != null)
      {
        this.b.bin();
        this.b.nA(1);
      }
      return;
    }
  }
  
  public List<rxk> bw()
  {
    if (this.lu == null)
    {
      this.lu = new ArrayList();
      this.lu.add(new owf());
      this.lu.add(new oxg(oum.a()));
      List localList = this.lu;
      Object localObject = new oxd(oum.a());
      this.b = ((oxd)localObject);
      localList.add(localObject);
      this.lu.add(new oww());
      localList = this.lu;
      localObject = new QCircleFolderFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart = ((QCircleFolderFragmentsPart)localObject);
      localList.add(localObject);
      localList = this.lu;
      localObject = new owk();
      this.jdField_a_of_type_Owk = ((owk)localObject);
      localList.add(localObject);
      this.lu.add(new oxx());
    }
    initParam();
    return this.lu;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->doOnCreateView");
    if (paramViewGroup != null) {}
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramViewGroup.setFitsSystemWindows(true);
        paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) - 1, 0, 0);
        new FrameLayout.LayoutParams(-1, -1);
      }
      super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560908;
  }
  
  public String getLogTag()
  {
    return "QCircleFolderActivityFragment";
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int i = 1;
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {}
    try
    {
      int j = Integer.parseInt(paramIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception paramIntent)
    {
      label34:
      break label34;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.j(i, false, false);
  }
  
  public void onResume()
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderActivityFragment
 * JD-Core Version:    0.7.0.1
 */