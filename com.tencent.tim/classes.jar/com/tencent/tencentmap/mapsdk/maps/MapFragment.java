package com.tencent.tencentmap.mapsdk.maps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;

@TargetApi(12)
public class MapFragment
  extends ReportFragment
{
  private TencentMap a;
  private MapView b = null;
  private boolean c = true;
  
  public static MapFragment newInstance(Context paramContext)
  {
    MapFragment localMapFragment = new MapFragment();
    if (localMapFragment.b == null) {
      localMapFragment.b = new MapView(paramContext.getApplicationContext());
    }
    return localMapFragment;
  }
  
  public final TencentMap getMap()
  {
    if (this.a == null) {
      this.a = this.b.getMap();
    }
    return this.a;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = new MapView(getActivity().getBaseContext());
    }
    this.b.setOnTop(this.c);
    paramLayoutInflater = this.b;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.b.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.b.onDestroy();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.b.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    this.b.onResume();
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    this.b.onStart();
    super.onStart();
  }
  
  public void onStop()
  {
    this.b.onStop();
    super.onStop();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapFragment
 * JD-Core Version:    0.7.0.1
 */