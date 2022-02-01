package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import apuh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kjf;
import kjh;
import kxm;
import mqq.manager.TicketManager;
import mqv.a;
import mqw;

public class ReadInJoyUploadAvatarFragment
  extends IphoneTitleBarFragment
{
  public static String TAG = "ReadInJoyUploadAvatarFragment";
  mqv.a a = new kjh(this);
  protected ProgressDialog d;
  protected Handler mHandler = new Handler();
  
  private void b(String paramString, Handler paramHandler, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = getActivity();
    if ((localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = ((FragmentActivity)localObject1).app;
    TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject2).getManager(2);
    localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    localObject2 = localTicketManager.getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
    localBundle.putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + (String)localObject2);
    localBundle.putString("bkn", "" + apuh.eU((String)localObject2));
    localBundle.putString("dataType", "base64");
    localBundle.putString("type", "" + paramInt);
    ThreadManager.executeOnSubThread(new ReadInJoyUploadAvatarFragment.3(this, paramString, localBundle, paramHandler));
  }
  
  private void mg(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    new mqw(BaseApplicationImpl.getContext(), localQQAppInterface, this.a).a(paramString, true, 2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setLeftViewName(2131696873);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {
      QLog.e(TAG, 1, "doOnCreateView activity = null");
    }
    int i;
    int j;
    do
    {
      return;
      this.mHandler.post(new ReadInJoyUploadAvatarFragment.1(this, paramLayoutInflater));
      paramViewGroup = paramLayoutInflater.getIntent();
      paramBundle = paramViewGroup.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      i = paramViewGroup.getIntExtra("from", 0);
      if ((paramBundle == null) || (paramBundle.isEmpty()))
      {
        Intent localIntent = paramLayoutInflater.getIntent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("retCode", 2);
        localIntent.putExtra("Bundle", localBundle);
        paramLayoutInflater.setResult(-1, localIntent);
        paramLayoutInflater.finish();
      }
      j = paramViewGroup.getIntExtra("type", 1);
    } while ((paramBundle == null) || (paramBundle.size() <= 0));
    g(i, (String)paramBundle.get(0), j);
  }
  
  protected void g(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      b(paramString, new kjf(this, Looper.getMainLooper()), paramInt2);
    }
    for (;;)
    {
      QLog.d(TAG, 1, "uploadFile: from:" + paramInt1 + " paths:" + paramString);
      return;
      mg(paramString);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560502;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.d != null) {
      this.d.dismiss();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment
 * JD-Core Version:    0.7.0.1
 */