package com.tencent.mobileqq.studyroom.ui;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anwv;
import anxf;
import anxf.a;
import arhz;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class StudyRoomLoadingFragment
  extends PublicBaseFragment
{
  private arhz jdField_m_of_type_Arhz;
  private Future<?> jdField_m_of_type_JavaUtilConcurrentFuture;
  
  private void Sa()
  {
    if (this.jdField_m_of_type_Arhz == null)
    {
      this.jdField_m_of_type_Arhz = new arhz(getActivity(), 40);
      this.jdField_m_of_type_Arhz.setMessage(acfp.m(2131709353));
      this.jdField_m_of_type_Arhz.setOnCancelListener(new anwv(this));
    }
    this.jdField_m_of_type_Arhz.show();
  }
  
  public static void ao(Map<String, String> paramMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (paramMap == null) {}
    for (paramMap = new HashMap();; paramMap = new HashMap(paramMap))
    {
      localIntent.putExtra("param", paramMap);
      PublicFragmentActivity.b.a(localIntent, PublicTransFragmentActivity.class, StudyRoomLoadingFragment.class);
      return;
    }
  }
  
  private void bpm()
  {
    if (this.jdField_m_of_type_Arhz != null) {
      this.jdField_m_of_type_Arhz.dismiss();
    }
  }
  
  public void finish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    finish();
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new FrameLayout(paramViewGroup.getContext());
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_m_of_type_JavaUtilConcurrentFuture != null) && (!this.jdField_m_of_type_JavaUtilConcurrentFuture.isDone()))
    {
      this.jdField_m_of_type_JavaUtilConcurrentFuture.cancel(true);
      QLog.i("studyroom.StudyRoomLoadingFragment", 4, "cancel load plugin");
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Sa();
    paramView = new Bundle();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getSerializable("param");
      if ((paramBundle instanceof HashMap))
      {
        Iterator localIterator = ((HashMap)paramBundle).keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = localIterator.next();
          if ((localObject1 instanceof String))
          {
            Object localObject2 = ((HashMap)paramBundle).get(localObject1);
            if ((localObject2 instanceof String)) {
              paramView.putString((String)localObject1, (String)localObject2);
            }
          }
        }
      }
    }
    this.jdField_m_of_type_JavaUtilConcurrentFuture = anxf.a(getActivity().getApplicationContext(), paramView, false, new a(this));
  }
  
  static class a
    implements anxf.a
  {
    private WeakReference<StudyRoomLoadingFragment> aX;
    
    public a(StudyRoomLoadingFragment paramStudyRoomLoadingFragment)
    {
      this.aX = new WeakReference(paramStudyRoomLoadingFragment);
    }
    
    public void onCloseLoadingView()
    {
      QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onCloseLoadingView");
      StudyRoomLoadingFragment localStudyRoomLoadingFragment = (StudyRoomLoadingFragment)this.aX.get();
      if (localStudyRoomLoadingFragment != null)
      {
        StudyRoomLoadingFragment.a(localStudyRoomLoadingFragment);
        localStudyRoomLoadingFragment.finish();
      }
    }
    
    public void onEnterComplete() {}
    
    public void onError(Throwable paramThrowable)
    {
      ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.1(this));
    }
    
    public void onShowLoadingView(View paramView)
    {
      QLog.d("studyroom.StudyRoomLoadingFragment", 4, "onShowLoadingView");
      ThreadManager.getUIHandler().post(new StudyRoomLoadingFragment.WeakCallback.2(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment
 * JD-Core Version:    0.7.0.1
 */