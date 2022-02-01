package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import kbp;
import kwz;
import kxm;
import mkv;
import mkw;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class RIJUGCAddAccountFragment
  extends ViolaLazyFragment
{
  private static String TAG = "RIJUGCAddAccountFragment";
  static int aTB = 1;
  public static int aTC = 2;
  public static int aTD = 3;
  private static boolean ank;
  private static boolean anl;
  private mkw a;
  
  static ReadInJoyUserInfo a(long paramLong)
  {
    return ReadInJoyUserInfoModule.a(paramLong, null);
  }
  
  private void aPH()
  {
    rU(aTB);
    bZ(getActivity());
    getActivity().finish();
  }
  
  public static void aPI()
  {
    ThreadManager.executeOnFileThread(new RIJUGCAddAccountFragment.2());
  }
  
  public static void bZ(Context paramContext)
  {
    if (a(kxm.getLongAccountUin()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      ank = bool;
      cb(paramContext);
      return;
    }
  }
  
  public static void ca(Context paramContext)
  {
    if (TextUtils.isEmpty(kxm.getAccount()))
    {
      QLog.e(TAG, 2, "editUGCAccount , but uin is empty !");
      anl = false;
    }
    Intent localIntent;
    do
    {
      return;
      anl = true;
      Bundle localBundle = new Bundle();
      localBundle.putString("url", "https://kandian.qq.com/mqq/vue/mainProfile?_wv=3&_bid=3302&source=2");
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putString("from", String.valueOf(53));
      localIntent = new Intent(paramContext, ReadInJoyArticleDetailActivity.class);
      localIntent.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).startActivityForResult(localIntent, 10000);
  }
  
  private static void cb(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ugc_account_create", ank);
    localIntent.putExtra("key_ugc_account_edit", anl);
    if ((paramContext instanceof Activity)) {
      ((Activity)paramContext).setResult(-1, localIntent);
    }
  }
  
  static void exposureReport()
  {
    try
    {
      JSONObject localJSONObject = kxm.v();
      localJSONObject.put("uin", kxm.getLongAccountUin());
      kbp.a(null, "CliOper", "", "", "0X800AD87", "0X800AD87", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(TAG, 2, "RIJUGCAddAccountFragment ugcAddAccountExposureReport exception: " + localJSONException.getMessage());
    }
  }
  
  public static String getNickName()
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = a(kxm.getLongAccountUin());
    String str = ReadInJoyUserInfoModule.getDefaultNickName();
    if (localReadInJoyUserInfo == null)
    {
      QLog.d(TAG, 2, "RIJUGCAddAccountFragment getNickName getReadInJoyUserInfoByUin is null! ");
      return kxm.ew(str);
    }
    return kxm.ew(localReadInJoyUserInfo.nick);
  }
  
  private void p(ViewGroup paramViewGroup)
  {
    ViewGroup localViewGroup1 = (ViewGroup)paramViewGroup.findViewById(2131381184);
    ViewGroup localViewGroup2 = (ViewGroup)paramViewGroup.findViewById(2131381185);
    KandianUrlImageView localKandianUrlImageView = (KandianUrlImageView)paramViewGroup.findViewById(2131369941);
    paramViewGroup = (KandianUrlImageView)paramViewGroup.findViewById(2131369942);
    ViewGroup.LayoutParams localLayoutParams = paramViewGroup.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).topMargin = (ImmersiveUtils.getStatusBarHeight(getActivity()) + (getResources().getDimensionPixelSize(2131299627) - wja.dp2px(19.5F, getResources())) / 2);
      paramViewGroup.setLayoutParams(localLayoutParams);
    }
    try
    {
      kwz.a(localKandianUrlImageView, new URL("https://pub.idqqimg.com/pc/misc/files/20200430/21b88f2ba3bd43919173a767982d649d.png"), getActivity());
      kwz.a(paramViewGroup, new URL("https://pub.idqqimg.com/pc/misc/files/20200430/eb40275894c9455f9ab438dd91081678.png"), getActivity());
      this.a = new mkw(getActivity(), localViewGroup2);
      localViewGroup1.setOnClickListener(new mkv(this));
      return;
    }
    catch (MalformedURLException paramViewGroup)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "[initView] error, e = " + paramViewGroup);
      }
    }
  }
  
  public static void rU(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = kxm.v();
      localJSONObject.put("uin", kxm.getLongAccountUin());
      localJSONObject.put("click_area", paramInt);
      kbp.a(null, "CliOper", "", "", "0X800AD89", "0X800AD89", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(TAG, 2, "RIJUGCAddAccountFragment ugcAddAccountClickReport exception: " + localJSONException.getMessage());
    }
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    hideTitleBar();
    bcg();
    p(paramViewGroup);
    exposureReport();
  }
  
  public void aF(Bundle paramBundle) {}
  
  public void doOnBackPressed()
  {
    if (getActivity() != null) {
      aPH();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      cb(getActivity());
      getActivity().finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.destroy();
  }
  
  public int pw()
  {
    return 2131560492;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment
 * JD-Core Version:    0.7.0.1
 */