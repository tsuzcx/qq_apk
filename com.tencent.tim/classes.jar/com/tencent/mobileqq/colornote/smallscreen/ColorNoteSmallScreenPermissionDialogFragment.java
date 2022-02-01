package com.tencent.mobileqq.colornote.smallscreen;

import aebd;
import aedq;
import aedr;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anot;
import aqha;
import aqju;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class ColorNoteSmallScreenPermissionDialogFragment
  extends PublicBaseFragment
{
  public static boolean bSY;
  
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
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.i("ColorNoteSmallScreenPermissionDialogFragment", 2, "showPermissionDialog in");
    }
    Object localObject = getActivity().getIntent();
    if (localObject != null) {}
    for (int i = ((Intent)localObject).getIntExtra("key_permission_from", 1);; i = 1)
    {
      int m = 2131691725;
      int j;
      if (i == 2)
      {
        j = 2131691726;
        localObject = aqha.a(getActivity(), 230).setMessage(j).setPositiveButton(2131691727, new aedq(this));
        ((aqju)localObject).setTitle(2131691728);
        ((aqju)localObject).setCancelable(true);
        ((aqju)localObject).setOnCancelListener(new aedr(this));
        ((aqju)localObject).setCanceledOnTouchOutside(false);
        ((aqju)localObject).show();
        bSY = true;
        if (i != 2) {
          break label197;
        }
      }
      label197:
      for (i = k;; i = 2)
      {
        anot.a(null, "dc00898", "", "", "0X800AB3A", "0X800AB3A", i, 0, "", "", "", "");
        paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        j = m;
        if (i != 3) {
          break;
        }
        aebd.He(true);
        j = m;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bSY = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenPermissionDialogFragment
 * JD-Core Version:    0.7.0.1
 */