package com.tencent.mobileqq.screendetect;

import acfp;
import ahgg.a;
import ahgq;
import ahix;
import ahra;
import amdf;
import amiq;
import amiq.a;
import amis;
import amit;
import amiu;
import amiv;
import amiw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ankt;
import aqcu;
import aqnm;
import avqq;
import ayxa;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import xtm;

public class ScreenShotFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private ImageView Dp;
  private ImageView Dq;
  private ImageView Dr;
  private int OC;
  private TextView Yo;
  private TextView Yp;
  private TextView Yq;
  private TextView Yr;
  private ahgq jdField_a_of_type_Ahgq;
  private DragView jdField_a_of_type_ComTencentWidgetDragView;
  private FragmentActivity activity;
  private String aeD;
  private amiq.a jdField_b_of_type_Amiq$a = new amis(this);
  private amiq jdField_b_of_type_Amiq;
  private Gallery jdField_b_of_type_ComTencentWidgetGallery;
  private boolean cCO;
  private boolean cCP;
  private boolean cCQ;
  private boolean cCR;
  private int dAe;
  private int dAf;
  private int dCf;
  private ElasticHorScrView jdField_e_of_type_ComTencentBizWidgetsElasticHorScrView;
  private GridView jdField_e_of_type_ComTencentWidgetGridView;
  protected AdapterView.c f = new amiv(this);
  private Bitmap gg;
  private Runnable hv = new ScreenShotFragment.5(this);
  private TextView kM;
  private LinearLayout kk;
  private LinearLayout kl;
  private RelativeLayout lR;
  private View lj;
  private QQAppInterface mApp;
  private amiw mHelper;
  private LinearLayoutManager mLinearLayoutManager;
  private RecyclerView mRecyclerView;
  private Handler mUiHandler = new Handler(Looper.getMainLooper());
  private List<RecentBaseData> pr = new ArrayList();
  
  protected static String G(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
  
  private void Ka(String paramString)
  {
    amdf.o(this.activity, paramString, 101);
  }
  
  private void PF(String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    do
    {
      return;
      this.gg = x(paramString);
      if (this.gg == null)
      {
        QLog.e("ScreenShotFragment", 1, "run: screenBitmap == null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "screenBitmap : width = " + this.gg.getWidth() + ", height = " + this.gg.getHeight());
      }
    } while ((this.gg.getHeight() <= 16) || (this.gg.getWidth() <= 16));
    int j = this.gg.getHeight();
    int i = j;
    int k;
    if (this.cCQ)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change start, height is : ", Integer.valueOf(j) });
      k = this.lj.getHeight();
      if ((k == 0) || (j <= k)) {
        break label309;
      }
      i = k;
    }
    Canvas localCanvas;
    for (;;)
    {
      QLog.d("ScreenShotFragment", 1, new Object[] { "long pic blur background change finish, height is : ", Integer.valueOf(i), " rootHeight is : ", Integer.valueOf(k) });
      try
      {
        paramString = Bitmap.createScaledBitmap(this.gg, (int)(this.gg.getWidth() * 0.0625F), (int)(i * 0.0625F), false);
        localCanvas = new Canvas(this.gg);
        localCanvas.drawColor(Color.parseColor("#33000000"));
        localCanvas.setBitmap(null);
        if (this.Dq != null) {
          this.mUiHandler.post(new ScreenShotFragment.6(this));
        }
        if (paramString == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: scaledBitmap == null");
          return;
          label309:
          i = j;
          if (getActivity() == null) {
            continue;
          }
          i = j;
          if (j <= ankt.aC(getActivity())) {
            continue;
          }
          i = ankt.aC(getActivity());
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (0 != 0) {
            throw new NullPointerException();
          }
          QLog.e("ScreenShotFragment", 1, "create scale Bitmap error : out of memory");
          paramString = null;
        }
        Bitmap localBitmap = new StackBlurManager(paramString).process(4);
        if (localBitmap == null)
        {
          QLog.e("ScreenShotFragment", 1, "run: blured bitmap is null");
          return;
        }
        localCanvas = new Canvas(paramString);
        localCanvas.drawColor(0);
        localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
        if (!"1103".equals(ThemeUtil.curThemeId)) {
          break label478;
        }
      }
    }
    localCanvas.drawColor(Color.parseColor("#4DEBEDF5"));
    for (;;)
    {
      localCanvas.setBitmap(null);
      if (this.lj == null) {
        break;
      }
      this.mUiHandler.post(new ScreenShotFragment.7(this, paramString));
      return;
      label478:
      localCanvas.drawColor(Color.parseColor("#7F03081A"));
    }
  }
  
  private void Pl(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.kk.setVisibility(0);
      this.kl.setVisibility(8);
    }
    do
    {
      return;
      this.kk.setVisibility(8);
      this.kl.setVisibility(0);
    } while (!this.cCQ);
    amiw.aS("0X800A9A8", "1", "");
  }
  
  private void Uu(int paramInt)
  {
    Object localObject3 = (RecentBaseData)this.pr.get(paramInt);
    if ((localObject3 instanceof RecentUserBaseData))
    {
      pm(((RecentBaseData)localObject3).ng());
      Object localObject1 = null;
      if (getActivity().getIntent() != null) {
        localObject1 = getActivity().getIntent();
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Intent();
      }
      localObject1 = (RecentUserBaseData)localObject3;
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment handleIconItemClick");
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("uin", ((RecentUserBaseData)localObject1).qx());
      ((Bundle)localObject3).putString("troop_uin", ((RecentUserBaseData)localObject1).qz());
      ((Bundle)localObject3).putString("uinname", ((RecentUserBaseData)localObject1).getTitleName());
      ((Bundle)localObject3).putInt("uintype", ((RecentUserBaseData)localObject1).ng());
      ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
      ((Intent)localObject2).setData(Uri.parse(this.aeD));
      ((Intent)localObject2).putExtra("forward_type", 1);
      ((Intent)localObject2).putExtra("key_share_from_screen_shot", true);
      if (this.jdField_a_of_type_Ahgq == null) {
        this.jdField_a_of_type_Ahgq = ahix.a((Intent)localObject2, getActivity().app, getActivity());
      }
      if (((RecentUserBaseData)localObject1).ng() == 6000)
      {
        this.jdField_a_of_type_Ahgq.H(ahgg.a.W.intValue(), (Bundle)localObject3);
        return;
      }
      this.jdField_a_of_type_Ahgq.H(ahgg.a.R.intValue(), (Bundle)localObject3);
      return;
    }
    QLog.e("ScreenShotFragment", 2, "handleIconItemClick : position = " + paramInt + ", data is null!");
  }
  
  private void bindData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment bindData");
    }
    if (this.aeD != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.hv, 100L);
    }
    this.mLinearLayoutManager = new LinearLayoutManager(getActivity());
    this.mLinearLayoutManager.setOrientation(0);
    this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
    this.jdField_b_of_type_Amiq = new amiq(getActivity(), this.mApp, this.mRecyclerView, 0);
    this.jdField_b_of_type_Amiq.a(this.jdField_b_of_type_Amiq$a);
    this.mRecyclerView.setAdapter(this.jdField_b_of_type_Amiq);
    this.jdField_b_of_type_Amiq.cS(this.pr);
    List localList = a()[0];
    Object localObject1 = new TextPaint();
    ((TextPaint)localObject1).setTextSize(getActivity().getResources().getDimensionPixelSize(2131299551));
    localObject1 = new StaticLayout(G(q(localList), 6), (TextPaint)localObject1, this.OC, Layout.Alignment.ALIGN_CENTER, 1.0F, this.dAf, true);
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_e_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
    }
    Object localObject2 = localList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject2).next()).visibility != 0) {
        break label408;
      }
      i += 1;
    }
    label408:
    for (;;)
    {
      break;
      int j = 20 + (this.OC + 20);
      this.jdField_e_of_type_ComTencentWidgetGridView.setColumnWidth(j);
      this.jdField_e_of_type_ComTencentWidgetGridView.setNumColumns(i);
      localObject2 = this.jdField_e_of_type_ComTencentWidgetGridView.getLayoutParams();
      this.jdField_e_of_type_ComTencentWidgetGridView.setPadding(16, this.jdField_e_of_type_ComTencentWidgetGridView.getPaddingTop(), 16, this.jdField_e_of_type_ComTencentWidgetGridView.getPaddingBottom());
      ((ViewGroup.LayoutParams)localObject2).width = (j * i + 0 + 0);
      i = this.OC;
      j = this.dAe;
      ((ViewGroup.LayoutParams)localObject2).height = (((StaticLayout)localObject1).getHeight() + (i + j));
      this.jdField_e_of_type_ComTencentWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_e_of_type_ComTencentWidgetGridView.setAdapter(new a(getActivity(), localList));
      this.jdField_e_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
      this.jdField_e_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.f);
      return;
    }
  }
  
  private Bitmap d(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    float f2;
    if (paramInt == 90) {
      f2 = paramBitmap.getHeight();
    }
    for (float f1 = 0.0F;; f1 = paramBitmap.getWidth())
    {
      Object localObject = new float[9];
      localMatrix.getValues((float[])localObject);
      localMatrix.postTranslate(f2 - localObject[2], f1 - localObject[5]);
      localObject = Bitmap.createBitmap(paramBitmap.getHeight(), paramBitmap.getWidth(), Bitmap.Config.RGB_565);
      Paint localPaint = new Paint();
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      localCanvas.drawBitmap(paramBitmap, localMatrix, localPaint);
      localCanvas.setBitmap(null);
      return localObject;
      f2 = paramBitmap.getHeight();
    }
  }
  
  private void dNK()
  {
    int n = 1;
    int i;
    int j;
    label27:
    int k;
    label39:
    int m;
    if (this.Yo.getVisibility() == 0)
    {
      i = 1;
      if (this.kM.getVisibility() != 0) {
        break label135;
      }
      j = 1;
      if (this.Yp.getVisibility() != 0) {
        break label140;
      }
      k = 1;
      if (this.Yq.getVisibility() != 0) {
        break label145;
      }
      m = 1;
      label52:
      if (this.Yr.getVisibility() != 0) {
        break label151;
      }
    }
    for (;;)
    {
      if (m + (0 + i + j + k) + n >= 4)
      {
        this.Yo.setTextSize(12.0F);
        this.kM.setTextSize(12.0F);
        this.Yp.setTextSize(12.0F);
        this.Yq.setTextSize(12.0F);
        this.Yr.setTextSize(12.0F);
      }
      return;
      i = 0;
      break;
      label135:
      j = 0;
      break label27;
      label140:
      k = 0;
      break label39;
      label145:
      m = 0;
      break label52;
      label151:
      n = 0;
    }
  }
  
  private void dNL()
  {
    QQToast.a(getActivity(), 2131718933, 0).show();
    File localFile = new File(this.aeD);
    xtm.a(getActivity(), localFile, Utils.Crc64String(localFile.getName()));
  }
  
  private void dNM()
  {
    if (ImmersiveUtils.hasNotchInScreen(getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume current is liuhai style!");
      }
      ayxa.enableNotch(getActivity());
    }
  }
  
  private void dNR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment#screenShotLong");
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("click_long_screen_shot", true);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
  }
  
  private void dwP()
  {
    this.cCP = getArguments().getBoolean("is_aio_page_with_msg", false);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "handlerArg: mHasMsg = " + this.cCP);
    }
  }
  
  private void f(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    this.pr.addAll(this.mHelper.a(paramActivity, paramQQAppInterface));
  }
  
  private void h(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToQzone");
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localBundle.putStringArrayList("images", localArrayList);
    avqq.a(paramBaseActivity, getActivity(), localBundle, null, 2);
  }
  
  private void initUI(View paramView)
  {
    boolean bool = false;
    this.lR = ((RelativeLayout)paramView.findViewById(2131377739));
    this.lR.setOnClickListener(this);
    this.Dq = ((ImageView)paramView.findViewById(2131377742));
    this.Dq.setOnClickListener(this);
    this.kk = ((LinearLayout)paramView.findViewById(2131377735));
    this.Dp = ((ImageView)paramView.findViewById(2131377740));
    this.Dp.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      this.Dp.setContentDescription(acfp.m(2131714067));
    }
    this.mRecyclerView = ((RecyclerView)paramView.findViewById(2131377734));
    this.Yo = ((TextView)paramView.findViewById(2131378168));
    this.Yo.setOnClickListener(this);
    this.kM = ((TextView)paramView.findViewById(2131366187));
    this.kM.setOnClickListener(this);
    this.Yp = ((TextView)paramView.findViewById(2131380794));
    Object localObject = this.Yp;
    int i;
    if ((this.cCP) || (this.cCR))
    {
      i = 0;
      aqnm.setVisible((View)localObject, i);
      this.Yp.setOnClickListener(this);
      this.Yq = ((TextView)paramView.findViewById(2131380807));
      this.Yq.setOnClickListener(this);
      this.Yr = ((TextView)paramView.findViewById(2131380864));
      this.Yr.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131366139));
      this.jdField_b_of_type_ComTencentWidgetGallery = ((Gallery)paramView.findViewById(2131367833));
      this.kl = ((LinearLayout)paramView.findViewById(2131377736));
      this.Dr = ((ImageView)this.lj.findViewById(2131363234));
      if (AppSetting.enableTalkBack) {
        this.Dr.setContentDescription(acfp.m(2131714071));
      }
      this.Dr.setOnClickListener(this);
      this.jdField_e_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)paramView.findViewById(2131378197));
      this.jdField_e_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      this.jdField_e_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131368140));
      if (this.cCQ)
      {
        this.Dq.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetDragView.setVisibility(0);
        this.jdField_b_of_type_ComTencentWidgetGallery.setAdapter(new ahra(Collections.singletonList(this.aeD)));
        this.jdField_b_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297406));
        this.jdField_b_of_type_ComTencentWidgetGallery.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
        this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(false);
        this.lR.setPadding(this.lR.getPaddingLeft(), this.lR.getPaddingTop(), this.lR.getPaddingRight(), 0);
        if (!CheckPermission.isHasStoragePermission(getActivity())) {
          break label715;
        }
        dNL();
      }
    }
    for (;;)
    {
      ((TextView)paramView.findViewById(2131377737)).setText(acfp.m(2131696967));
      if (this.cCR) {
        this.Yp.setText(acfp.m(2131719215));
      }
      this.lR.setPadding(this.lR.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(getActivity()) + 15, this.lR.getPaddingRight(), this.lR.getPaddingBottom());
      this.Dp.setContentDescription(getString(2131720765));
      localObject = getActivity();
      Uri localUri = Uri.fromFile(new File(this.aeD));
      TextView localTextView1 = this.Yr;
      TextView localTextView2 = this.Yq;
      if (this.Yp.getVisibility() != 0) {
        bool = true;
      }
      amiw.a((Context)localObject, localUri, localTextView1, localTextView2, bool);
      paramView.findViewById(2131367886).setVisibility(this.Yp.getVisibility());
      paramView.findViewById(2131367887).setVisibility(this.Yq.getVisibility());
      paramView.findViewById(2131367888).setVisibility(this.Yr.getVisibility());
      dNK();
      return;
      i = 8;
      break;
      label715:
      CheckPermission.requestStoragePermission(this.activity, 1, new amit(this));
    }
  }
  
  private void pm(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.cCQ) && (str != null)) {
        amiw.aS("0X800A9A7", str, "1");
      }
      return;
      str = "1";
      amiw.cN("0X8009FEE", 1);
      continue;
      str = "2";
      amiw.cN("0X8009FEE", 2);
      continue;
      amiw.cN("0X8009FEE", 3);
      continue;
      amiw.cN("0X8009FEE", 4);
      continue;
      str = "3";
      amiw.cN("0X8009FEE", 5);
    }
  }
  
  private void w(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 0, false);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private void x(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment shareToFriendCircle");
    }
    WXShareHelper.a().a(paramString, paramBitmap, 1, false);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  private static void z(Activity paramActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment launchFriendPicker path = " + paramString);
    }
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
    localIntent.putExtra("key_share_from_screen_shot", true);
    localIntent.putExtra("key_share_from_screen_need_finish", true);
    localIntent.setData(Uri.parse(paramString));
    paramActivity.startActivityForResult(localIntent, 3);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = getActivity().getString(2131694185);
    localActionSheetItem.icon = 2130840529;
    localActionSheetItem.action = 50;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void dNN()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      localFragmentActivity.overridePendingTransition(0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity, because app is null!");
      }
    }
  }
  
  public void dNO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment exitScreenShotScreen");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void dNP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startEdit");
    }
    if (this.aeD == null) {
      return;
    }
    Intent localIntent = EditPicActivity.a(getActivity(), this.aeD, true, true, true, true, true, false, false, false, 2, 122, 0, false, null);
    getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void dNQ()
  {
    QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment startCrop");
    if (this.aeD == null)
    {
      QLog.e("ScreenShotFragment", 1, "crop error : mCurrentPath is null");
      return;
    }
    Intent localIntent = EditPicActivity.a(getActivity(), this.aeD, true, true, true, true, true, false, false, false, 2, 133, 0, false, null);
    getActivity().startActivityForResult(localIntent, 5);
  }
  
  public void finishActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment finishActivity");
      }
      localFragmentActivity.overridePendingTransition(0, 0);
    }
    if (this.cCQ) {
      amiw.aS("0X800A9AD", "1", "");
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, new Object[] { "ScreenShotShareFragment onActivityResult requestCode = ", paramInt1 + ", resultCode = " + paramInt2 });
    }
    if (paramInt1 == 1) {
      dNO();
    }
    do
    {
      return;
      if (paramInt1 == 2)
      {
        dNO();
        return;
      }
      if (paramInt1 == 3)
      {
        dNO();
        return;
      }
    } while (paramInt1 != 101);
    dNO();
  }
  
  public boolean onBackEvent()
  {
    return false;
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
      finishActivity();
      continue;
      Pl(false);
      amiw.cN("0X8009FEF", 0);
      continue;
      if (this.cCQ)
      {
        dNQ();
        amiw.aS("0X800A9AA", "1", "");
      }
      else
      {
        dNP();
        amiw.cN("0X8009FF4", 0);
        continue;
        dNR();
        if (this.cCP) {
          amiw.cN("0X800A8BD", 0);
        }
        if (this.cCR)
        {
          amiw.aS("0X800A9A5", "1", "");
          continue;
          Pl(true);
          continue;
          finishActivity();
          continue;
          Intent localIntent = new Intent();
          localIntent.putExtra("preResult", (String)this.Yq.getTag());
          amiw.a(getActivity(), this.aeD, 2, localIntent);
          amiw.cN("0X800AC94", 0);
          this.cCO = true;
          continue;
          localIntent = new Intent();
          localIntent.putExtra("preResult", (String)this.Yr.getTag());
          amiw.a(getActivity(), this.aeD, 1, localIntent);
          amiw.cN("0X800AC93", 0);
          this.activity.finish();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate");
    }
    if (getActivity() == null) {
      QLog.e("ScreenShotFragment", 2, "ScreenShotShareFragment onCreate activity has gone!");
    }
    this.activity = getActivity();
    this.mHelper = new amiw();
    this.mApp = getActivity().app;
    if (this.mApp == null) {
      dNN();
    }
    do
    {
      do
      {
        return;
        f(getActivity(), this.mApp);
        this.OC = getActivity().getResources().getDimensionPixelSize(2131296957);
        this.dAf = getActivity().getResources().getDimensionPixelOffset(2131296960);
        this.dAe = getActivity().getResources().getDimensionPixelOffset(2131296959);
        paramBundle = getActivity().getIntent();
      } while (paramBundle == null);
      this.aeD = paramBundle.getStringExtra("screen_path");
      this.cCQ = paramBundle.getBooleanExtra("is_web_screen_long_shot", false);
      this.cCR = paramBundle.getBooleanExtra("is_screen_shot_from_web", false);
    } while (!this.cCQ);
    amiw.aS("0X800A9A6", "1", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onCreateView");
    }
    dwP();
    this.lj = paramLayoutInflater.inflate(2131561646, paramViewGroup, false);
    this.lj.setBackgroundColor(Color.parseColor("#aa000000"));
    this.dCf = getActivity().getResources().getDimensionPixelSize(2131299353);
    initUI(this.lj);
    bindData();
    paramLayoutInflater = this.lj;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onDestroy");
    }
    if (this.jdField_b_of_type_Amiq != null) {
      this.jdField_b_of_type_Amiq.onDestroy();
    }
    if (this.hv != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hv);
    }
    if (this.gg != null)
    {
      this.gg.recycle();
      this.gg = null;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotShareFragment onResume");
    }
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact = localFragmentActivity.mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setgetStatusBarVisible(false, 0);
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      ViewCompat.setOnApplyWindowInsetsListener(localFragmentActivity.getWindow().getDecorView(), new amiu(this));
      return;
    }
    dNM();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.cCO) {
      this.activity.finish();
    }
  }
  
  protected String q(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    Object localObject = "";
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((ShareActionSheetBuilder.ActionSheetItem)paramList.get(i)).label;
      if (str.length() <= ((String)localObject).length()) {
        break label55;
      }
      localObject = str;
    }
    label55:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public Bitmap x(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          Object localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          aqcu.decodeFile(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject);
          int i = ((BitmapFactory.Options)localObject).outHeight;
          ((BitmapFactory.Options)localObject).inSampleSize = ((i - this.dCf) / i);
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = aqcu.decodeFile(paramString.getAbsolutePath(), (BitmapFactory.Options)localObject).copy(Bitmap.Config.RGB_565, true);
          paramString = (String)localObject;
          if (((Bitmap)localObject).getWidth() > ((Bitmap)localObject).getHeight()) {
            paramString = d((Bitmap)localObject, 90);
          }
        }
      }
      catch (OutOfMemoryError paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
          }
          paramString = null;
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ScreenShotFragment", 2, "makeShareBitmap", paramString);
          }
          paramString = null;
        }
      }
    }
    return paramString;
  }
  
  public static class a
    extends BaseAdapter
    implements AdapterView.c
  {
    private int OE;
    private a a;
    private LayoutInflater inflater;
    private List<ShareActionSheetBuilder.ActionSheetItem> items;
    private Resources mRes;
    
    public a(Context paramContext, List<ShareActionSheetBuilder.ActionSheetItem> paramList)
    {
      this.items = paramList;
      this.inflater = LayoutInflater.from(paramContext);
    }
    
    public ShareActionSheetBuilder.ActionSheetItem c(int paramInt)
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.items == null) || (paramInt < 0))
      {
        localActionSheetItem = null;
        return localActionSheetItem;
      }
      int j = -1;
      int i = 0;
      for (;;)
      {
        if (i >= this.items.size()) {
          break label89;
        }
        localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)this.items.get(i);
        int k = j;
        if (localActionSheetItem != null)
        {
          k = j;
          if (localActionSheetItem.visibility == 0) {
            k = j + 1;
          }
        }
        if (k == paramInt) {
          break;
        }
        i += 1;
        j = k;
      }
      label89:
      return null;
    }
    
    public int getCount()
    {
      if (this.items == null) {
        return 0;
      }
      Iterator localIterator = this.items.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
        if ((localActionSheetItem == null) || (localActionSheetItem.visibility != 0)) {
          break label60;
        }
        i += 1;
      }
      label60:
      for (;;)
      {
        break;
        return i;
      }
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int j = 0;
      if (this.mRes == null) {
        this.mRes = paramViewGroup.getContext().getResources();
      }
      if (this.OE == 0) {
        this.OE = ((int)this.mRes.getDimension(2131296957));
      }
      if (this.a == null) {
        this.a = new a(paramViewGroup.getContext());
      }
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2131559035, paramViewGroup, false);
        localObject1 = new ScreenShotFragment.b();
        ((ScreenShotFragment.b)localObject1).vIcon = ((ImageView)paramView.findViewById(2131378172));
        ((ScreenShotFragment.b)localObject1).vLabel = ((TextView)paramView.findViewById(2131378173));
        paramView.setTag(localObject1);
        paramView.setFocusable(true);
      }
      for (;;)
      {
        ((ScreenShotFragment.b)localObject1).b = c(paramInt);
        if (((ScreenShotFragment.b)localObject1).b != null) {
          break;
        }
        QLog.e("ScreenShotFragment", 2, "ShareActionSheetBuilder.ActionSheetItemAdapter.getView() getItem(" + paramInt + ") == null !!!");
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject1 = (ScreenShotFragment.b)paramView.getTag();
      }
      paramView.setId(((ScreenShotFragment.b)localObject1).b.id);
      Object localObject2 = ((ScreenShotFragment.b)localObject1).vLabel;
      Object localObject3 = ((ScreenShotFragment.b)localObject1).b.label;
      int i;
      if (((ScreenShotFragment.b)localObject1).b.firstLineCount > 0)
      {
        i = ((ScreenShotFragment.b)localObject1).b.firstLineCount;
        label254:
        ((TextView)localObject2).setText(ScreenShotFragment.G((String)localObject3, i));
        i = -8947849;
        localObject2 = ((ScreenShotFragment.b)localObject1).vLabel;
        if (!((ScreenShotFragment.b)localObject1).b.enable) {
          break label505;
        }
        label288:
        ((TextView)localObject2).setTextColor(i);
        if (!((ScreenShotFragment.b)localObject1).b.iconNeedBg) {
          break label575;
        }
        if (((ScreenShotFragment.b)localObject1).b.iconDrawable == null) {
          break label513;
        }
        localObject2 = ((ScreenShotFragment.b)localObject1).b.iconDrawable;
        label327:
        i = ((Drawable)localObject2).getIntrinsicWidth();
        int k = ((Drawable)localObject2).getIntrinsicHeight();
        if (this.OE <= i) {
          break label533;
        }
        i = (int)((this.OE - i) / 2.0F);
        label363:
        if (this.OE > k) {
          j = (int)((this.OE - k) / 2.0F);
        }
        localObject2 = this.a.a((Drawable)localObject2, i, j);
        if (!((ScreenShotFragment.b)localObject1).b.enable) {
          break label539;
        }
        localObject3 = a.a(this.a, (Drawable)localObject2);
        localObject2 = this.a.a((Drawable)localObject2, (Drawable)localObject3);
        ((ScreenShotFragment.b)localObject1).vIcon.setImageDrawable((Drawable)localObject2);
        label445:
        if (Build.VERSION.SDK_INT < 16) {
          break label563;
        }
        ((ScreenShotFragment.b)localObject1).vIcon.setBackground(null);
        label462:
        if (AppSetting.enableTalkBack) {
          if (((ScreenShotFragment.b)localObject1).b.label == null) {
            break label662;
          }
        }
      }
      label513:
      label533:
      label662:
      for (Object localObject1 = ((ScreenShotFragment.b)localObject1).b.label;; localObject1 = "")
      {
        paramView.setContentDescription((CharSequence)localObject1);
        break;
        i = 6;
        break label254;
        label505:
        i = 2138535799;
        break label288;
        localObject2 = this.mRes.getDrawable(((ScreenShotFragment.b)localObject1).b.icon);
        break label327;
        i = 0;
        break label363;
        label539:
        localObject2 = a.b(this.a, (Drawable)localObject2);
        ((ScreenShotFragment.b)localObject1).vIcon.setImageDrawable((Drawable)localObject2);
        break label445;
        label563:
        ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundDrawable(null);
        break label462;
        label575:
        ((ScreenShotFragment.b)localObject1).vIcon.setImageResource(2130837636);
        if (((ScreenShotFragment.b)localObject1).b.iconDrawable != null)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            ((ScreenShotFragment.b)localObject1).vIcon.setBackground(((ScreenShotFragment.b)localObject1).b.iconDrawable);
            break label462;
          }
          ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundDrawable(((ScreenShotFragment.b)localObject1).b.iconDrawable);
          break label462;
        }
        ((ScreenShotFragment.b)localObject1).vIcon.setBackgroundResource(((ScreenShotFragment.b)localObject1).b.icon);
        break label462;
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
    
    static class a
    {
      private final Drawable cy;
      private final Drawable cz;
      
      a(Context paramContext)
      {
        paramContext = paramContext.getResources();
        this.cy = paramContext.getDrawable(2130837635);
        this.cz = paramContext.getDrawable(2130837639);
      }
      
      private Drawable A(Drawable paramDrawable)
      {
        return new LayerDrawable(new Drawable[] { paramDrawable, this.cz });
      }
      
      private Drawable B(Drawable paramDrawable)
      {
        paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
        paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
        return paramDrawable;
      }
      
      Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
      {
        paramDrawable = new LayerDrawable(new Drawable[] { this.cy, paramDrawable });
        paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
        return paramDrawable;
      }
      
      StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
      {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
        localStateListDrawable.addState(new int[0], paramDrawable1);
        return localStateListDrawable;
      }
    }
  }
  
  public static class b
  {
    public ShareActionSheetBuilder.ActionSheetItem b;
    public ImageView vIcon;
    public TextView vLabel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment
 * JD-Core Version:    0.7.0.1
 */