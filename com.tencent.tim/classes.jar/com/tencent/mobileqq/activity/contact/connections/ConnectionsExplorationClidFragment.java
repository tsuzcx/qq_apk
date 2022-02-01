package com.tencent.mobileqq.activity.contact.connections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.a;
import yre;
import yri;

public class ConnectionsExplorationClidFragment
  extends ReportV4Fragment
{
  private yri a;
  SwipListView.a b = new yre(this);
  private boolean bol;
  private boolean bom;
  private int caH;
  private SwipListView e;
  private QQAppInterface mApp;
  private int mPosition;
  
  private void u(View paramView)
  {
    this.mApp = getActivity().app;
    this.e = ((SwipListView)paramView.findViewById(2131376927));
    View localView = paramView.findViewById(2131366420);
    paramView = paramView.findViewById(2131370809);
    this.a = new yri(getActivity(), this.mApp, this.e, localView, paramView, this.bol, this.caH, this.mPosition);
    if (this.bom)
    {
      this.a.ckY();
      this.bom = false;
    }
    this.e.setDragEnable(true);
    this.e.setRightIconMenuListener(this.b);
  }
  
  public void AG(boolean paramBoolean)
  {
    this.bol = paramBoolean;
  }
  
  public void Ev(int paramInt)
  {
    this.caH = paramInt;
  }
  
  public void ckW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, "ConnectionsExplorationClidFragment onPageSelected " + this.mPosition);
    }
    if (this.a != null)
    {
      this.a.ckY();
      return;
    }
    this.bom = true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, "ConnectionsExplorationClidFragment doOnDestroy " + this.mPosition);
    }
    if (this.a != null) {
      this.a.destroy();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561503, paramViewGroup, false);
    u(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    doOnDestroy();
    super.onDestroy();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConnectionsExplorationClidFragment", 2, " onResume");
    }
    super.onResume();
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void setPos(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.ConnectionsExplorationClidFragment
 * JD-Core Version:    0.7.0.1
 */