package com.tencent.tim.cloudfile;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import atdt;
import atdt.a;
import ativ;
import atja;
import atjb;
import atjc;
import atjd;
import atje;
import augx;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WeiYunFileListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, augx
{
  private View HI;
  private TextView MZ;
  private ativ jdField_a_of_type_Ativ;
  private CloudSendBottomBar jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar;
  private atdt jdField_b_of_type_Atdt;
  private PullRefreshHeader jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader;
  private FPSSwipListView c;
  private TextView centerView;
  private RelativeLayout fD;
  private RelativeLayout gu;
  private TextView leftView;
  private View mLoadingView;
  private ImageView rightViewImg;
  
  private void etp()
  {
    Object localObject = new atjb(this);
    atjc localatjc = new atjc(this);
    this.jdField_b_of_type_Atdt.setOnClickListener((View.OnClickListener)localObject);
    this.MZ.setOnClickListener(localatjc);
    localObject = new atjd(this);
    this.jdField_b_of_type_Atdt.a((atdt.a)localObject);
    this.leftView.setOnClickListener(new atje(this));
  }
  
  private void initUI(View paramView)
  {
    this.mLoadingView = paramView.findViewById(2131370943);
    this.mLoadingView.setVisibility(0);
    this.HI = paramView.findViewById(2131370942);
    this.HI.setOnClickListener(this);
    this.c = ((FPSSwipListView)paramView.findViewById(2131367058));
    this.c.setDivider(null);
    this.c.setDividerHeight(0);
    this.c.setOverscrollHeader(getResources().getDrawable(2130839646));
    this.gu = ((RelativeLayout)paramView.findViewById(2131377546));
    this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559847, this.c, false));
    this.c.setOverScrollHeader(this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader);
    this.jdField_a_of_type_Ativ = new ativ(getActivity(), "", this.c, this.jdField_b_of_type_ComTencentTimWidgetPullRefreshHeader, new atja(this));
    this.c.setOnScrollListener(this.jdField_a_of_type_Ativ);
    this.c.setOverScrollListener(this.jdField_a_of_type_Ativ);
    View localView = paramView.findViewById(2131379791);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
      localView.setLayoutParams(localLayoutParams);
    }
    this.fD = ((RelativeLayout)paramView.findViewById(2131379791));
    this.rightViewImg = ((ImageView)paramView.findViewById(2131369594));
    this.MZ = ((TextView)paramView.findViewById(2131369612));
    this.leftView = ((TextView)paramView.findViewById(2131369579));
    this.centerView = ((TextView)paramView.findViewById(2131369627));
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar = ((CloudSendBottomBar)paramView.findViewById(2131377980));
    this.jdField_b_of_type_Atdt = new atdt(getActivity().app, getActivity(), this);
    this.c.setDragEnable(true);
    this.rightViewImg.setVisibility(8);
    this.MZ.setVisibility(0);
    this.MZ.setText(2131721058);
    this.centerView.setText("微云文件");
    this.c.setDragEnable(false);
    this.jdField_b_of_type_Atdt.Vq(true);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setLeftAction(2);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setRightAction(4);
    this.jdField_a_of_type_ComTencentTimFilemanagerWidgetCloudSendBottomBar.setVisibility(0);
    this.jdField_b_of_type_Atdt.setMode(2);
    this.c.setAdapter(this.jdField_b_of_type_Atdt);
  }
  
  public boolean Pp()
  {
    return false;
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558487, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initUI(paramView);
    etp();
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.WeiYunFileListFragment
 * JD-Core Version:    0.7.0.1
 */