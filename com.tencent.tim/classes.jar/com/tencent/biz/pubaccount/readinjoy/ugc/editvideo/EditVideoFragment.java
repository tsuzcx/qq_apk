package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import auss;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.RoundBackgroundTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kxm;
import kxm.b;
import lcc;
import mir.a;
import mix;
import mmh.c;
import mmi;
import mmj;
import mmk;
import mml;
import mmm;
import mmn;
import mmo;
import mmp;
import mng;
import mnw;
import ntp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import riw;
import rpq;

public class EditVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, mmh.c
{
  private EditText S;
  @Nullable
  private ColumnInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo;
  private UgcVideo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = new UgcVideo();
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoEditVideoFragment$a;
  private mmp jdField_a_of_type_Mmp = new mmp(new mmo(kxm.a()));
  private mng jdField_a_of_type_Mng = new mmi(this);
  private int aTH = 2;
  private String ajr;
  private boolean anq;
  private boolean anr;
  private QQAppInterface app;
  private Context context = BaseApplicationImpl.getContext();
  private int from;
  private ImageView jD;
  private float jF;
  private ArrayList<ColumnInfo> jQ = new ArrayList();
  private ListView k;
  private View lj;
  private View lk;
  private View ll;
  private Dialog q;
  private TextView qR;
  private TextView qS;
  private TextView qT;
  private TextView qU;
  private Dialog r;
  
  public static void a(Activity paramActivity, UgcVideo paramUgcVideo, @Nullable ColumnInfo paramColumnInfo, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_info", paramUgcVideo);
    localIntent.putExtra("key_column_info", paramColumnInfo);
    localIntent.putExtra("key_from", paramInt1);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, EditVideoFragment.class, paramInt2);
  }
  
  public static void a(Activity paramActivity, mir.a parama, @Nullable ColumnInfo paramColumnInfo, int paramInt1, int paramInt2)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.filePath = parama.path;
    localUgcVideo.duration = ((int)(parama.videoDuration / 1000L));
    localUgcVideo.fileSize = parama.fileSize;
    localUgcVideo.coverPath = parama.coverPath;
    localUgcVideo.width = parama.getWidth();
    localUgcVideo.height = parama.getHeight();
    a(paramActivity, localUgcVideo, paramColumnInfo, paramInt1, paramInt2);
  }
  
  private void aQf()
  {
    LimitWordCountEditText localLimitWordCountEditText = (LimitWordCountEditText)this.lj.findViewById(2131379823);
    localLimitWordCountEditText.setCountLimit(mix.pn());
    localLimitWordCountEditText.setDisableManualEnter(true);
    this.S = localLimitWordCountEditText.b();
    this.S.addTextChangedListener(new mmk(this));
  }
  
  private void aQg()
  {
    View localView = this.lj.findViewById(2131370618);
    int i = mix.po();
    localView.setVisibility(i);
    this.qS = ((TextView)this.lj.findViewById(2131380512));
    if (i == 0)
    {
      boolean bool = mix.DO();
      this.qS.setText(g(bool));
      localView.setOnClickListener(this);
    }
  }
  
  private void aQh()
  {
    View localView = this.lj.findViewById(2131370623);
    int i = mix.pp();
    localView.setVisibility(i);
    this.qT = ((TextView)this.lj.findViewById(2131380527));
    if (i == 0)
    {
      i = mix.pq();
      this.qT.setText(bs(i));
      localView.setOnClickListener(this);
    }
  }
  
  private void aQi()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
    if (!mix.DO()) {}
    for (boolean bool = true;; bool = false)
    {
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = mix.pq();
      return;
    }
  }
  
  private void aQj()
  {
    mnw.a(this.app).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void aQk()
  {
    if ((!TextUtils.isEmpty(this.S.getText().toString())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.qR.setAlpha(1.0F);
      return;
    }
    this.qR.setAlpha(0.5F);
  }
  
  private void aQl()
  {
    TextView localTextView = this.qS;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setText(g(bool));
      this.qT.setText(bs(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType));
      return;
    }
  }
  
  private void aQm()
  {
    if (aqiw.isMobileNetWork(getActivity()))
    {
      mix.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize, new mml(this), null);
      return;
    }
    mnw.a(this.app).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
  }
  
  private void aQn()
  {
    kbp.bp("0X800AC5E", o().build());
    getActivity().finish();
    aQj();
  }
  
  private void aQo()
  {
    kbp.bp("0X800AC60", o().a("source", Integer.valueOf(2)).build());
    mix.Q(getActivity(), 3);
  }
  
  private void aQp()
  {
    kbp.bp("0X800AC5F", o().build());
    if (TextUtils.isEmpty(this.S.getText().toString()))
    {
      QQToast.a(getActivity(), 2131718404, 0).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId == 0L)
    {
      QQToast.a(getActivity(), 2131718365, 0).show();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.title = this.S.getText().toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startUserWaitingTime = System.currentTimeMillis();
    }
    for (;;)
    {
      this.jdField_a_of_type_Mmp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime = 0L;
    }
  }
  
  private void aQq()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560359, null);
    ((RelativeLayout)localView.findViewById(2131362681)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131367493)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364239)).setOnClickListener(new mmm(this));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362683);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131367495);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.q = auss.a(getActivity(), localView);
      this.q.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  private void aQr()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560358, null);
    cO(localView);
    cP(localView);
    cQ(localView);
    this.r = auss.a(getActivity(), localView);
    this.r.show();
  }
  
  private String bs(int paramInt)
  {
    String str = getResources().getString(2131718462);
    if (paramInt == UgcVideo.TYPE_PUBLIC) {
      str = mix.ae(this.context);
    }
    do
    {
      return str;
      if (paramInt == UgcVideo.TYPE_NO_PUBLIC) {
        return mix.ag(this.context);
      }
    } while (paramInt != UgcVideo.TYPE_PUBLIC_AND_REMIND);
    return mix.ac(this.context);
  }
  
  private void cO(@NotNull View paramView)
  {
    String str = mix.ac(this.context);
    ((TextView)paramView.findViewById(2131373789)).setText(str);
    str = mix.ad(this.context);
    ((TextView)paramView.findViewById(2131373786)).setText(str);
    str = mix.ae(this.context);
    ((TextView)paramView.findViewById(2131373795)).setText(str);
    str = mix.af(this.context);
    ((TextView)paramView.findViewById(2131373790)).setText(str);
    str = mix.ag(this.context);
    ((TextView)paramView.findViewById(2131372435)).setText(str);
    str = mix.ah(this.context);
    ((TextView)paramView.findViewById(2131372432)).setText(str);
  }
  
  private void cP(@NotNull View paramView)
  {
    ((RelativeLayout)paramView.findViewById(2131373787)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131373791)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131372433)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131364239)).setOnClickListener(new mmn(this));
  }
  
  private void cQ(@NotNull View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131373788);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131373793);
    paramView = (ImageView)paramView.findViewById(2131372434);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType == UgcVideo.TYPE_PUBLIC_AND_REMIND)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
      paramView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType == UgcVideo.TYPE_NO_PUBLIC)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      paramView.setVisibility(0);
      return;
    }
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    paramView.setVisibility(8);
  }
  
  private int dt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private String g(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getResources().getString(2131718330);
    }
    return getResources().getString(2131718425);
  }
  
  private boolean h(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof EditText))
    {
      int[] arrayOfInt = new int[2];
      int[] tmp14_12 = arrayOfInt;
      tmp14_12[0] = 0;
      int[] tmp18_14 = tmp14_12;
      tmp18_14[1] = 0;
      tmp18_14;
      paramView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int m = paramView.getHeight();
      int n = paramView.getWidth();
      if ((paramMotionEvent.getX() <= i - 80) || (paramMotionEvent.getX() >= n + i + 80) || (paramMotionEvent.getY() <= j - 25) || (paramMotionEvent.getY() >= m + j + 35)) {
        break label120;
      }
    }
    label120:
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramView.setFocusable(false);
    paramView.setFocusableInTouchMode(true);
    return true;
  }
  
  private void initData()
  {
    boolean bool2 = true;
    Object localObject3 = getArguments();
    this.jdField_a_of_type_Mmp.a(this);
    this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (localObject3 == null) {
      QLog.e("RIJUGC.EditVideoFragment", 1, "getArgument() is null.");
    }
    Object localObject1;
    do
    {
      return;
      this.from = ((Bundle)localObject3).getInt("key_from", 0);
      localObject1 = (UgcVideo)((Bundle)localObject3).getParcelable("key_video_info");
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RIJUGC.EditVideoFragment", 2, "video param is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = ((UgcVideo)localObject1);
    aQi();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport = dt(this.from);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.seqId = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.filePath.hashCode() + "_" + System.currentTimeMillis() + "_" + this.app.getCurrentUin());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.insertTime = (System.currentTimeMillis() / 1000L);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localColorDrawable;
    }
    try
    {
      localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath).toURI().toURL(), (URLDrawable.URLDrawableOptions)localObject1);
      this.jD.setImageDrawable((Drawable)localObject1);
      localObject3 = (ColumnInfo)((Bundle)localObject3).getParcelable("key_column_info");
      if (localObject3 != null)
      {
        i = ((ColumnInfo)localObject3).columnID;
        if (localObject3 == null) {
          break label414;
        }
        localObject1 = ((ColumnInfo)localObject3).title;
        bool1 = bool2;
        if (i != 0)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label422;
          }
          bool1 = bool2;
        }
        this.anq = bool1;
        if (!this.anq) {
          break label427;
        }
        this.lk.setVisibility(8);
        this.ll.setVisibility(0);
        this.k.setVisibility(0);
        this.jdField_a_of_type_Mmp.aMF();
        aQm();
        aQl();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.EditVideoFragment", 1, "initData -> setVideoCoverFailed e:" + localMalformedURLException.toString());
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        label414:
        localObject2 = "";
        continue;
        label422:
        boolean bool1 = false;
        continue;
        label427:
        this.lk.setVisibility(0);
        this.ll.setVisibility(8);
        this.k.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = i;
        localObject2 = getResources().getDrawable(2130843862);
        ((Drawable)localObject2).setBounds(0, 0, rpq.dip2px(this.context, 15.0F), rpq.dip2px(this.context, 15.0F));
        this.qU.setText(((ColumnInfo)localObject3).title);
        this.qU.setCompoundDrawablePadding(rpq.dip2px(this.context, 5.0F));
        this.qU.setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
    }
  }
  
  private void initUI()
  {
    ((LinearLayout.LayoutParams)((ViewGroup)this.lj.findViewById(2131379798)).getLayoutParams()).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((PressEffectImageView)this.lj.findViewById(2131364690)).setOnClickListener(this);
    this.qR = ((TextView)this.lj.findViewById(2131373829));
    this.qR.setOnClickListener(this);
    this.jD = ((ImageView)this.lj.findViewById(2131365488));
    ViewGroup.LayoutParams localLayoutParams = this.jD.getLayoutParams();
    localLayoutParams.height = (riw.getWindowScreenWidth(getActivity()) * 9 / 16);
    this.jD.setLayoutParams(localLayoutParams);
    this.jD.setOnClickListener(this);
    ((RoundBackgroundTextView)this.lj.findViewById(2131377936)).setOnClickListener(this);
    aQf();
    aQg();
    aQh();
    this.lk = this.lj.findViewById(2131380077);
    this.qU = ((TextView)this.lj.findViewById(2131380084));
    this.ll = this.lj.findViewById(2131362242);
    this.lj.findViewById(2131362243).setOnClickListener(this);
    this.k = ((ListView)this.lj.findViewById(2131380082));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoEditVideoFragment$a = new a();
    this.k.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoEditVideoFragment$a);
    this.k.setOnItemClickListener(new mmj(this));
  }
  
  private void nT(boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.q != null) && (this.q.isShowing()))
    {
      this.qS.setText(g(paramBoolean));
      if (!paramBoolean) {
        QQToast.a(getActivity(), 2131718427, 0).show();
      }
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
      if (!paramBoolean) {
        bool = true;
      }
      localUgcVideo.reprintDisable = bool;
      this.q.dismiss();
    }
  }
  
  @NotNull
  private kxm.b o()
  {
    int i1 = 2;
    int i2 = 1;
    int i;
    int j;
    label56:
    int m;
    label75:
    int i3;
    switch (this.aTH)
    {
    default: 
      i = -1;
      if (TextUtils.isEmpty(this.S.getText().toString()))
      {
        j = 0;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID != 0)) {
          break label258;
        }
        m = 0;
        i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {
          break label275;
        }
      }
      break;
    }
    label258:
    label275:
    for (int n = 1;; n = 0)
    {
      int i4 = dt(this.from);
      if (i4 == 4) {}
      for (;;)
      {
        kxm.b localb1 = new kxm.b();
        kxm.b localb2 = localb1.a("from", Integer.valueOf(i4)).a("user_type", Integer.valueOf(i1)).a("video_flag", Integer.valueOf(1));
        if (this.anr) {}
        for (i1 = i2;; i1 = 0)
        {
          localb2.a("cover_flag", Integer.valueOf(i1)).a("cover_type", Integer.valueOf(i)).a("video_name_flag", Integer.valueOf(j)).a("column_flag", Integer.valueOf(m)).a("secret_flag", Integer.valueOf(i3)).a("reprint_flag", Integer.valueOf(n));
          return localb1;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          j = 1;
          break label56;
          m = 1;
          break label75;
        }
        i1 = 1;
      }
    }
  }
  
  private void sa(int paramInt)
  {
    if ((this.r != null) && (this.r.isShowing()))
    {
      if (paramInt != UgcVideo.TYPE_NO_PUBLIC) {
        break label67;
      }
      QQToast.a(getActivity(), 2131718452, 0).show();
    }
    for (;;)
    {
      this.qT.setText(bs(paramInt));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = paramInt;
      this.r.dismiss();
      return;
      label67:
      QQToast.a(getActivity(), 2131718467, 0).show();
    }
  }
  
  private void selectCover()
  {
    CoverSelectTabFragment.a(getActivity(), 10001, this.aTH, this.jF, this.ajr, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  public void aQe()
  {
    lcc.a().aJE();
    getActivity().finish();
    if ((this.from == 1) && (mix.ps() == 2))
    {
      String str = mix.ka() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
      ntp.a(getActivity(), "", str, null, false);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      View localView = getActivity().getCurrentFocus();
      if (h(localView, paramMotionEvent)) {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("ARG_SELECTED_COVER");
      this.aTH = paramIntent.getIntExtra("ARG_SELECTED_ITEM", 0);
      this.jF = paramIntent.getFloatExtra("ARG_INITIAL_PROGRESS", 0.0F);
      this.ajr = paramIntent.getStringExtra("ARG_PLACEHOLDER_URL");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath = ((String)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverUrl = "";
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if ((this.jD != null) && (this.jD.getHeight() != 0) && (this.jD.getWidth() != 0))
        {
          localURLDrawableOptions.mRequestHeight = this.jD.getHeight();
          localURLDrawableOptions.mRequestWidth = this.jD.getWidth();
        }
        paramIntent = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = paramIntent;
        localURLDrawableOptions.mLoadingDrawable = paramIntent;
        paramIntent = null;
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(new File((String)localObject).toURI().toURL(), localURLDrawableOptions);
      paramIntent = (Intent)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.EditVideoFragment", 1, "onActivityResult -> setVideoCoverFailed e:" + localMalformedURLException.toString());
      }
    }
    this.jD.setImageDrawable(paramIntent);
    this.anr = true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    lcc.a().b(this.jdField_a_of_type_Mng);
  }
  
  public boolean onBackEvent()
  {
    aQj();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aQp();
      continue;
      aQn();
      continue;
      selectCover();
      continue;
      aQq();
      continue;
      aQr();
      continue;
      nT(true);
      continue;
      nT(false);
      continue;
      sa(UgcVideo.TYPE_PUBLIC_AND_REMIND);
      continue;
      sa(UgcVideo.TYPE_PUBLIC);
      continue;
      sa(UgcVideo.TYPE_NO_PUBLIC);
      continue;
      aQo();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.lj = paramLayoutInflater.inflate(2131560357, paramViewGroup, false);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.lj)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      initUI();
      initData();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    lcc.a().c(this.jdField_a_of_type_Mng);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Mmp.detachView();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Mmp != null) && (this.anq)) {
      this.jdField_a_of_type_Mmp.aMF();
    }
    kxm.a(getActivity());
  }
  
  public void setCenterEmpty() {}
  
  public void setCenterError(int paramInt, String paramString) {}
  
  public void setCenterHide() {}
  
  public void setCenterLoading() {}
  
  public void setFooterError(int paramInt, String paramString) {}
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Mmp.aMG();
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading() {}
  
  public void setFooterNoMore() {}
  
  public void setHeaderError(int paramInt, String paramString)
  {
    QQToast.a(getActivity(), getString(2131718495), 0).show();
  }
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(List<ColumnInfo> paramList, boolean paramBoolean)
  {
    if ((!paramList.isEmpty()) && (!paramBoolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)paramList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = ((ColumnInfo)paramList.get(0)).columnID;
    }
    this.jQ.clear();
    this.jQ.addAll(paramList);
    if (this.jQ.size() > 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)this.jQ.get(0));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcEditvideoEditVideoFragment$a.notifyDataSetChanged();
    aQk();
  }
  
  public void setTotal(int paramInt) {}
  
  public class a
    extends BaseAdapter
  {
    a() {}
    
    public ColumnInfo a(int paramInt)
    {
      return (ColumnInfo)EditVideoFragment.a(EditVideoFragment.this).get(paramInt);
    }
    
    public int getCount()
    {
      return EditVideoFragment.a(EditVideoFragment.this).size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      EditVideoFragment.b localb;
      if (paramView == null)
      {
        localView = LayoutInflater.from(EditVideoFragment.this.getActivity()).inflate(2131560361, paramViewGroup, false);
        localb = new EditVideoFragment.b(EditVideoFragment.this.getActivity(), (ViewGroup)localView);
        localView.setTag(localb);
      }
      for (;;)
      {
        if (EditVideoFragment.a(EditVideoFragment.this) != null) {
          localb.a(a(paramInt), EditVideoFragment.a(EditVideoFragment.this).columnID);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        localb = (EditVideoFragment.b)paramView.getTag();
        localView = paramView;
      }
    }
  }
  
  static class b
  {
    private RoundImageView a;
    private Context context;
    private TextView countText;
    private ImageView jE;
    private TextView titleText;
    
    b(Context paramContext, ViewGroup paramViewGroup)
    {
      this.context = paramContext;
      this.a = ((RoundImageView)paramViewGroup.findViewById(2131365488));
      this.titleText = ((TextView)paramViewGroup.findViewById(2131379862));
      this.countText = ((TextView)paramViewGroup.findViewById(2131381644));
      this.jE = ((ImageView)paramViewGroup.findViewById(2131380091));
    }
    
    void a(ColumnInfo paramColumnInfo, int paramInt)
    {
      Object localObject = this.context.getResources().getDrawable(2130843862);
      ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.context, 15.0F), rpq.dip2px(this.context, 15.0F));
      this.titleText.setText(paramColumnInfo.title);
      this.titleText.setCompoundDrawablePadding(rpq.dip2px(this.context, 5.0F));
      this.titleText.setCompoundDrawables((Drawable)localObject, null, null, null);
      localObject = this.context.getString(2131718539);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.countText.setText(String.format((String)localObject, new Object[] { Integer.valueOf(paramColumnInfo.videoCount) }));
      }
      if (!TextUtils.isEmpty(paramColumnInfo.coverUrl))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        localObject = URLDrawable.getDrawable(paramColumnInfo.coverUrl, (URLDrawable.URLDrawableOptions)localObject);
        this.a.setImageDrawable((Drawable)localObject);
      }
      if (paramInt == paramColumnInfo.columnID)
      {
        this.jE.setVisibility(0);
        return;
      }
      this.jE.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */