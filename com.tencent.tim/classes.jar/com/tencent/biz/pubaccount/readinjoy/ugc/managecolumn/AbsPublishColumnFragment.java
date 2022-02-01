package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import acbn;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aqfo;
import aqfy;
import arhz;
import auvy;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kbp;
import kxm;
import kxm.b;
import mix;
import mmu;
import mmv;
import mmw;
import mmx;
import mnf.b;
import mnf.c;
import mnh;
import mnj;
import mql;
import mqo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbsPublishColumnFragment
  extends PublicBaseFragment
  implements View.OnClickListener, mnf.c
{
  public LimitWordCountEditText a;
  public final mnf.b a;
  protected mql a;
  protected String ajs;
  protected LimitWordCountEditText b;
  protected ImmersiveTitleBar2 b;
  protected String callback;
  protected Map<String, String> ew = new HashMap();
  protected ImageView jF;
  protected ImageView jG;
  protected arhz k;
  protected arhz l;
  protected TextView qV;
  protected TextView qW;
  protected TextView qX;
  protected TextView qY;
  
  public AbsPublishColumnFragment()
  {
    this.jdField_a_of_type_Mnf$b = new mnj(new mnh(kxm.a()));
  }
  
  private void aQD()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent(localFragmentActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localFragmentActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = acbn.SDCARD_PATH + localFragmentActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localFragmentActivity.startActivity(localIntent);
    aqfy.anim(localFragmentActivity, false, true);
  }
  
  private void aQF()
  {
    this.qY.setVisibility(8);
    this.jG.setVisibility(0);
    this.qX.setVisibility(0);
  }
  
  private void aQG()
  {
    this.jG.setVisibility(8);
    this.qX.setVisibility(8);
    this.qY.setVisibility(0);
  }
  
  private void aQs()
  {
    if ((VersionUtils.isM()) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void aQt()
  {
    getActivity().getWindow().getDecorView().setBackgroundColor(-1);
  }
  
  @NotNull
  private kxm.b o()
  {
    int i1 = 1;
    kxm.b localb1 = new kxm.b();
    boolean bool1 = mix.DN();
    boolean bool2 = mix.DJ();
    int m;
    int j;
    label55:
    label76:
    int n;
    label84:
    kxm.b localb2;
    if (!TextUtils.isEmpty(this.ajs))
    {
      m = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b().getText().toString())) {
        break label190;
      }
      j = 1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.b().getText().toString())) {
        break label195;
      }
      i = 1;
      if (!bool1) {
        break label200;
      }
      n = 1;
      localb2 = localb1.a("ugc_video_flag", Integer.valueOf(n));
      if (!bool2) {
        break label206;
      }
      n = 1;
      label107:
      localb2 = localb2.a("ugc_column_flag", Integer.valueOf(n));
      if (m == 0) {
        break label212;
      }
      m = 1;
      label128:
      localb2 = localb2.a("cover_flag", Integer.valueOf(m));
      if (j == 0) {
        break label217;
      }
      j = 1;
      label148:
      localb2 = localb2.a("column_name_flag", Integer.valueOf(j));
      if (i == 0) {
        break label222;
      }
    }
    label190:
    label195:
    label200:
    label206:
    label212:
    label217:
    label222:
    for (int i = i1;; i = 0)
    {
      localb2.a("introduction_flag", Integer.valueOf(i));
      return localb1;
      m = 0;
      break;
      j = 0;
      break label55;
      i = 0;
      break label76;
      n = 0;
      break label84;
      n = 0;
      break label107;
      m = 0;
      break label128;
      j = 0;
      break label148;
    }
  }
  
  protected abstract boolean DQ();
  
  public mmx a()
  {
    return new mmx(this.ajs, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.getContent(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.getContent());
  }
  
  public void a(ColumnInfo paramColumnInfo)
  {
    b(paramColumnInfo);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  public void aQA()
  {
    if (DQ())
    {
      this.qW.setClickable(true);
      this.qW.setAlpha(1.0F);
      return;
    }
    this.qW.setClickable(false);
    this.qW.setAlpha(0.5F);
  }
  
  public void aQB()
  {
    kbp.bp("0X800AC5A", o().build());
    if (bU())
    {
      aQy();
      return;
    }
    finishActivity();
  }
  
  public void aQC()
  {
    kbp.bp("0X800AC5C", o().build());
    if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0)
    {
      aQD();
      return;
    }
    getActivity().requestPermissions(new mmv(this), 1, new String[] { "android.permission.CAMERA" });
  }
  
  public void aQE()
  {
    if (!TextUtils.isEmpty(this.ajs))
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jF.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jF.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(-657415);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(-657415);
      String str = (String)this.ew.get(this.ajs);
      if (!TextUtils.isEmpty(str)) {}
      for (;;)
      {
        try
        {
          localObject1 = URLDrawable.getDrawable(new File(str).toURI().toURL(), (URLDrawable.URLDrawableOptions)localObject1);
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              break label190;
            }
            aQG();
            this.jF.setImageDrawable((Drawable)localObject1);
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("RIJUGC.PublishTopicFragment", 1, "updateCoverLayout exception, e=" + localException.getMessage() + ",localPath=" + str);
          localObject2 = null;
          continue;
        }
        Object localObject2 = URLDrawable.getDrawable(this.ajs, (URLDrawable.URLDrawableOptions)localObject2);
        continue;
        label190:
        ((URLDrawable)localObject2).setURLDrawableListener(new mmw(this));
      }
    }
    aQF();
    this.jF.setImageDrawable(null);
  }
  
  public void aQu()
  {
    if (this.k == null)
    {
      this.k = new arhz(getActivity());
      this.k.setMessage(2131718376);
    }
    if (this.k.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showUploadLoadingProgress, but dialog is showing");
      return;
    }
    this.k.show();
  }
  
  public void aQv()
  {
    if ((this.k != null) && (this.k.isShowing())) {
      this.k.dismiss();
    }
  }
  
  public void aQw()
  {
    if (this.l == null) {
      this.l = new arhz(getActivity());
    }
    if (this.l.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showPublishLoadingProgress, but dialog is showing");
      return;
    }
    this.l.show();
  }
  
  public void aQx()
  {
    if ((this.l != null) && (this.l.isShowing())) {
      this.l.dismiss();
    }
  }
  
  public void aQy()
  {
    kbp.bp("0X800AD2D", o().build());
  }
  
  public void aQz()
  {
    kbp.bp("0X800AC5B", o().build());
  }
  
  public void b(@Nullable ColumnInfo paramColumnInfo)
  {
    if (paramColumnInfo != null)
    {
      this.ajs = paramColumnInfo.coverUrl;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.title);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setSelectionEnd();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.intro);
    }
    aQE();
    aQA();
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  public void bG(String paramString1, String paramString2)
  {
    this.ew.put(paramString1, paramString2);
    this.ajs = paramString1;
    aQE();
    aQA();
  }
  
  protected abstract boolean bU();
  
  public void finishActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void nU(boolean paramBoolean)
  {
    kxm.b localb = o();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localb.a("click_area", Integer.valueOf(i));
      kbp.bp("0X800AD2E", localb.build());
      return;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (bU())
    {
      aQy();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      QLog.e("RIJUGC.PublishTopicFragment", 1, "onClick, no handler, view = " + paramView.getClass().getSimpleName());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aQB();
      continue;
      aQz();
      continue;
      aQC();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.callback = getActivity().getIntent().getStringExtra("arg_callback");
    getActivity().getWindow().setSoftInputMode(16);
    auvy.bN(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Mnf$b.O(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560334, null);
    this.jdField_b_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131379866));
    this.qV = ((TextView)paramLayoutInflater.findViewById(2131380976));
    this.qW = ((TextView)paramLayoutInflater.findViewById(2131380981));
    this.jF = ((ImageView)paramLayoutInflater.findViewById(2131369717));
    this.jG = ((ImageView)paramLayoutInflater.findViewById(2131369689));
    this.qX = ((TextView)paramLayoutInflater.findViewById(2131380548));
    this.qY = ((TextView)paramLayoutInflater.findViewById(2131380595));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366526));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366525));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Mnf$b.pA());
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Mnf$b.pB());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
    paramLayoutInflater.findViewById(2131369931).setOnClickListener(this);
    this.qW.setOnClickListener(this);
    this.jF.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new mmu(this));
    aQs();
    aQA();
    aQt();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Mnf$b.detachView();
    if (this.jdField_a_of_type_Mql != null) {
      this.jdField_a_of_type_Mql.cancel();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (!paramIntent.isEmpty()))
    {
      paramIntent = (String)paramIntent.get(0);
      QLog.i("RIJUGC.PublishTopicFragment", 1, "onSelectPhoto, path=" + paramIntent);
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.jdField_a_of_type_Mql != null) {
          this.jdField_a_of_type_Mql.cancel();
        }
        this.jdField_a_of_type_Mql = new mqo(getActivity(), getActivity().app, paramIntent);
        this.jdField_a_of_type_Mnf$b.a(this.jdField_a_of_type_Mql, paramIntent);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void showTips(int paramInt)
  {
    showTips(getResources().getString(paramInt));
  }
  
  public void showTips(@NotNull String paramString)
  {
    QQToast.a(getActivity(), 0, paramString, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.AbsPublishColumnFragment
 * JD-Core Version:    0.7.0.1
 */