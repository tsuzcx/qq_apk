package com.tencent.tim.resourcesgrab;

import ajos;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import aujl;
import aujo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;

public class ResourceGrabFragment
  extends LifeCycleFragment
{
  private aujo a;
  private WeakReference<ResourceGrabView> bm;
  private boolean diX;
  
  private void evm()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "doGrabResourceName");
    }
    View localView = getActivity().getWindow().getDecorView();
    this.a.T(localView, true);
    this.diX = true;
  }
  
  void a(ResourceGrabView paramResourceGrabView)
  {
    this.bm = new WeakReference(paramResourceGrabView);
  }
  
  public boolean aJt()
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.bm.get();
    return (localResourceGrabView != null) && (localResourceGrabView.diZ);
  }
  
  void evl()
  {
    if (!this.diX)
    {
      ThreadManager.getUIHandler().postDelayed(new ResourceGrabFragment.1(this), 200L);
      return;
    }
    evm();
  }
  
  void evn()
  {
    Object localObject = getActivity().getWindow().getDecorView();
    this.a.T((View)localObject, false);
    localObject = (ResourceGrabView)this.bm.get();
    if (localObject != null) {
      ((ResourceGrabView)localObject).evs();
    }
  }
  
  public void evo()
  {
    View localView = getActivity().getWindow().getDecorView();
    this.a.T(localView, false);
  }
  
  public void nW(List<aujl> paramList)
  {
    ResourceGrabView localResourceGrabView = (ResourceGrabView)this.bm.get();
    if (localResourceGrabView != null) {
      localResourceGrabView.afs.setText(this.a.X(paramList));
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((aujo)ajos.a(this).get(aujo.class));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    evn();
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabFragment", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.resourcesgrab.ResourceGrabFragment
 * JD-Core Version:    0.7.0.1
 */