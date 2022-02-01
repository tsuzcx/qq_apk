package com.tencent.biz.pubaccount.readinjoy.fragment;

import acbn;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;
import apzg;
import aqhu;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import kvx;
import lrj;
import lse;
import lsr;
import luh;
import npu;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDailyShareFragment
  extends PublicBaseFragment
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private lrj jdField_a_of_type_Lrj;
  private String aeC;
  private String aeD;
  private JSONObject ap;
  ProteusItemView b;
  private Bitmap ca;
  
  private void aKU()
  {
    if (this.ap == null) {}
    label92:
    for (;;)
    {
      return;
      Object localObject = this.ap.optString("qr_code_url");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = apzg.a((String)localObject, getActivity().getResources(), 540, 0, false);; localObject = null)
      {
        if (localObject == null) {
          break label92;
        }
        ViewBase localViewBase = (ViewBase)this.b.a().getViewIdMapping().get("id_kandian_share_qr_code");
        if (!(localViewBase instanceof lsr)) {
          break;
        }
        ((ImageView)localViewBase.getNativeView()).setImageBitmap((Bitmap)localObject);
        return;
      }
    }
  }
  
  private void aKV()
  {
    ViewBase localViewBase = (ViewBase)this.b.a().getViewIdMapping().get("id_share_choice");
    if ((localViewBase instanceof lse)) {
      ((lse)localViewBase).setInitRunnable(new ReadInJoyDailyShareFragment.1(this, localViewBase));
    }
  }
  
  private void aKW()
  {
    if (TextUtils.isEmpty(this.aeD))
    {
      View localView = ((ViewBase)this.b.a().getViewIdMapping().get("id_check_container")).getNativeView();
      if (localView != null)
      {
        this.aeC = acbn.oM;
        this.aeD = (this.aeC + "kandiandaily-" + b(Calendar.getInstance().getTime()) + ".png");
        npu.h(new File(this.aeC));
        this.ca = c(localView);
        c(this.ca, this.aeD);
      }
    }
  }
  
  private static String b(Date paramDate)
  {
    return new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(paramDate);
  }
  
  private Bitmap c(View paramView)
  {
    if ((paramView.getWidth() == 0) || (paramView.getHeight() == 0))
    {
      QLog.e("ReadInJoyDailyShareFragment", 1, "can not createBitmap");
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    paramView.draw(localCanvas);
    return localBitmap;
  }
  
  private boolean c(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return false;
    }
    try
    {
      aqhu.saveBitmapToFile(paramBitmap, new File(paramString));
      return true;
    }
    catch (IOException paramBitmap)
    {
      QLog.e("ReadInJoyDailyShareFragment", 1, paramBitmap, new Object[0]);
    }
    return false;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getActivity() != null) {
      paramBundle = getActivity().getIntent();
    }
    for (;;)
    {
      if (paramBundle != null) {
        paramBundle = paramBundle.getStringExtra("share_info_intent");
      }
      try
      {
        this.ap = new JSONObject(paramBundle);
        QLog.d("ReadInJoyDailyShareFragment", 1, "shareinfo is " + this.ap.toString());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new luh();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(getActivity());
        kvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(getActivity());
        this.jdField_a_of_type_Lrj = new lrj();
        this.jdField_a_of_type_Lrj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
        return;
        paramBundle = null;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          QLog.e("ReadInJoyDailyShareFragment", 1, paramBundle, new Object[0]);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560344, paramViewGroup, false);
    paramViewGroup = (ScrollView)paramLayoutInflater.findViewById(2131378197);
    if ((paramViewGroup != null) && (this.jdField_a_of_type_Lrj != null) && (this.ap != null))
    {
      this.b = this.jdField_a_of_type_Lrj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.ap);
      if (this.b != null) {
        paramViewGroup.addView(this.b, -1, -1);
      }
    }
    else
    {
      aKU();
      aKV();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyShareFragment
 * JD-Core Version:    0.7.0.1
 */