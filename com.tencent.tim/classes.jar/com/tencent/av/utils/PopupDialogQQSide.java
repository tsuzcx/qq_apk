package com.tencent.av.utils;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqha;
import aqju;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import jkj;
import jkk;
import jkl;

public class PopupDialogQQSide
  extends PublicBaseFragment
{
  public aqju mDialog = null;
  
  void axs()
  {
    Object localObject1 = (Bundle)getArguments().getParcelable("request");
    int k = ((Bundle)localObject1).getInt("type", 230);
    String str1 = ((Bundle)localObject1).getString("titleText");
    String str2 = ((Bundle)localObject1).getString("contentText");
    int i = ((Bundle)localObject1).getInt("leftBtnText", 0);
    int j = ((Bundle)localObject1).getInt("rightBtnText", 0);
    Object localObject2 = (ResultReceiver)((Bundle)localObject1).getParcelable("resultReceiver");
    boolean bool1 = ((Bundle)localObject1).getBoolean("leftBtnVisiable", true);
    boolean bool2 = ((Bundle)localObject1).getBoolean("rightBtnVisiable", true);
    gV();
    localObject1 = new jkj(this, (ResultReceiver)localObject2);
    localObject2 = new jkk(this, (ResultReceiver)localObject2);
    if (i == 0) {
      i = 2131721737;
    }
    for (;;)
    {
      if (j == 0) {
        j = 2131721737;
      }
      for (;;)
      {
        aqju localaqju = aqha.a(getActivity(), k);
        localaqju.setMessage(str2);
        localaqju.setTitle(str1);
        if (bool1) {
          localaqju.setNegativeButton(i, (DialogInterface.OnClickListener)localObject1);
        }
        if (bool2) {
          localaqju.setPositiveButton(j, (DialogInterface.OnClickListener)localObject2);
        }
        localaqju.setOnDismissListener(new jkl(this));
        localaqju.setCancelable(true);
        localaqju.show();
        this.mDialog = localaqju;
        return;
      }
    }
  }
  
  void gV()
  {
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    gV();
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    axs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialogQQSide
 * JD-Core Version:    0.7.0.1
 */