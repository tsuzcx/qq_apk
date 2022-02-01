package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import apgo;
import apgo.a;
import apgq;
import apgq.a;
import apgq.c;
import apgs;
import apgu;
import apgv;
import aqhu;
import ausj;
import auss;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import ram;
import rom;

public class CheckArithHWResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener, URLDrawable.URLDrawableListener, ArithResultView.a
{
  private ImageView Eu;
  private ImageView Ev;
  private apgo jdField_a_of_type_Apgo;
  private ArithResultView jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView;
  private String aLx;
  private TextView aaC;
  private TextView aaD;
  private ausj ap;
  private LinearLayout ch;
  private String coT;
  private String coU;
  Stream<apgq.c> e;
  private String mCallBack;
  private TextView mTitle;
  private String mTroopUin;
  private String mUrl;
  private URLDrawable p;
  
  public static void SQ(String paramString)
  {
    if ((paramString != null) && (paramString.equals("null"))) {
      rom.fail("param is n-u-l-l,plz dont do this...", new Object[0]);
    }
    rom.sF(paramString);
  }
  
  public static Intent a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Intent localIntent = new Intent();
    SQ(paramString1);
    SQ(paramString2);
    SQ(paramString3);
    SQ(paramString5);
    SQ(paramString4);
    SQ(paramString6);
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("json", paramString2);
    localIntent.putExtra("cb", paramString3);
    localIntent.putExtra("troopUin", paramString5);
    localIntent.putExtra("hwId", paramString4);
    localIntent.putExtra("targetUin", paramString6);
    ram.b("QQ.Troop.homework.CheckArithHWResultFragment", "getOpenIntent %s", localIntent.toString());
    localIntent.setClass(paramActivity, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", CheckArithHWResultFragment.class.getName());
    return localIntent;
  }
  
  public static JSONObject b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("imgUrl");
    paramIntent = paramIntent.getStringExtra("ytData");
    ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack:" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("imgUrl", str);
      localJSONObject.put("ytData", paramIntent);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack--json put data failed imgUrl=:" + str + ",ytDate=" + paramIntent);
    }
    return localJSONObject;
  }
  
  private void hU(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("imgUrl", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("ytData", paramString2);
    }
    getActivity().setResult(0, localIntent);
    getActivity().finish();
  }
  
  private void y(String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Apgo.cQp)
    {
      hU(null, null);
      return;
    }
    if (this.e != null) {
      this.e.cancel();
    }
    apgq.a locala = new apgq.a();
    locala.groupId = Long.parseLong(this.mTroopUin);
    locala.coS = paramString;
    locala.coR = this.mUrl;
    try
    {
      locala.arz = Long.parseLong(this.coT);
      locala.uin = Long.parseLong(this.aLx);
      this.ch.setVisibility(0);
      this.e = Stream.of(paramBitmap).map(new ThreadOffFunction("QQ.Troop.homework.CheckArithHWResultFragment", 2)).map(new apgs(this.mTroopUin, this.jdField_a_of_type_Apgo, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.Dk)).map(new apgq(locala)).map(new UIThreadOffFunction(null));
      this.e.subscribe(new apgv(this));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        rom.fail("requestSendHomeworkResult hwid=" + this.coT + "uin=" + this.aLx + " is illegal", new Object[0]);
      }
    }
  }
  
  public void b(apgo.a parama)
  {
    this.aaC.setText(parama.subject.replace("*", "x").replace("/", "÷").replace("frac", "").replace(",", "/"));
    int i = (int)(parama.x - parama.width * 0.05F);
    int j = (int)(parama.y - parama.height * 0.05F);
    int k = (int)(parama.x + parama.width * 1.05F);
    int m = (int)(parama.y + parama.height * 1.05F);
    if (i > 0)
    {
      if (j <= 0) {
        break label231;
      }
      label125:
      if (k <= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap().getWidth()) {
        break label236;
      }
      k = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap().getWidth() - i;
      label154:
      if (m <= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap().getHeight()) {
        break label245;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap().getHeight() - j;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap(), i, j, k, m);
      this.Ev.setImageBitmap(localBitmap);
      this.ap.mUserData = parama;
      this.ap.show();
      return;
      i = 0;
      break;
      label231:
      j = 0;
      break label125;
      label236:
      k -= i;
      break label154;
      label245:
      m -= j;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      y(this.jdField_a_of_type_Apgo.toJSON(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.getBitmap());
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        rom.fail("QQ.Troop.homework.CheckArithHWResultFragment//onBackEvent toJSON error:" + localJSONException, new Object[0]);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.Eu) {
      this.ap.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.aaD)
      {
        apgo.a locala = (apgo.a)this.ap.mUserData;
        this.jdField_a_of_type_Apgo.cQp = true;
        Object localObject = this.jdField_a_of_type_Apgo;
        ((apgo)localObject).dUe -= 1;
        locala.cQq = true;
        localObject = acfp.m(2131703787);
        if (this.jdField_a_of_type_Apgo.dUe > 0) {
          localObject = this.jdField_a_of_type_Apgo.dUe + acfp.m(2131703784);
        }
        this.mTitle.setText((CharSequence)localObject);
        this.ap.dismiss();
        ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "teacher correct the item:" + locala.toString());
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    int i = paramBundle.getIntExtra("magic_code", 0);
    boolean bool;
    if (i == 15453) {
      bool = true;
    }
    for (;;)
    {
      rom.assertTrue(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
      this.mUrl = paramBundle.getStringExtra("url");
      this.coU = paramBundle.getStringExtra("json");
      this.mCallBack = paramBundle.getStringExtra("cb");
      this.mTroopUin = paramBundle.getStringExtra("troopUin");
      this.coT = paramBundle.getStringExtra("hwId");
      this.aLx = paramBundle.getStringExtra("targetUin");
      try
      {
        this.jdField_a_of_type_Apgo = apgo.a(this.coU);
        ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "onCreate");
        return;
        bool = false;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "json is illegal!! " + this.coU);
          QQToast.a(getActivity(), 1, acfp.m(2131703786), 0).show();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(2131561737, paramViewGroup, false);
    this.ap = ((ausj)auss.a(getActivity(), null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131561738, paramViewGroup, false);
    this.ap.addView(paramLayoutInflater);
    this.Eu = ((ImageView)paramLayoutInflater.findViewById(2131375000));
    this.aaC = ((TextView)paramLayoutInflater.findViewById(2131375003));
    this.Ev = ((ImageView)paramLayoutInflater.findViewById(2131375002));
    this.aaD = ((TextView)paramLayoutInflater.findViewById(2131375001));
    this.Eu.setOnClickListener(this);
    this.aaD.setOnClickListener(this);
    paramLayoutInflater = getActivity();
    paramLayoutInflater.getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
    if (paramLayoutInflater.mSystemBarComp == null) {
      paramLayoutInflater.setImmersiveStatus(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView = ((ArithResultView)paramBundle.findViewById(2131375007));
      this.ch = ((LinearLayout)paramBundle.findViewById(2131375005));
      this.mTitle = ((TextView)paramBundle.findViewById(2131375009));
      paramLayoutInflater = acfp.m(2131703788);
      if (this.jdField_a_of_type_Apgo.dUe > 0)
      {
        paramLayoutInflater = this.jdField_a_of_type_Apgo.dUe + acfp.m(2131703783);
        label239:
        this.mTitle.setText(paramLayoutInflater);
        ((TextView)paramBundle.findViewById(2131375008)).setOnClickListener(new apgu(this));
        paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
        paramLayoutInflater.mRequestWidth = 0;
        paramLayoutInflater.mRequestHeight = 0;
      }
      try
      {
        this.p = URLDrawable.getDrawable(new URL(this.mUrl), paramLayoutInflater);
        this.p.setAutoDownload(true);
        this.p.setURLDrawableListener(this);
        if (this.p.getStatus() == 1) {
          onLoadSuccessed(this.p);
        }
        for (;;)
        {
          V4FragmentCollector.onV4FragmentViewCreated(this, paramBundle);
          return paramBundle;
          paramLayoutInflater.mSystemBarComp.setStatusBarDrawable(null);
          paramLayoutInflater.mSystemBarComp.setStatusBarColor(0);
          paramLayoutInflater.mSystemBarComp.setStatusColor(0);
          break;
          if (this.jdField_a_of_type_Apgo.Lq() != 0) {
            break label239;
          }
          paramLayoutInflater = acfp.m(2131703785);
          break label239;
          if ((this.p.getStatus() != 2) && (this.p.getStatus() != 3)) {
            break label477;
          }
          this.p.restartDownload();
        }
      }
      catch (MalformedURLException paramLayoutInflater)
      {
        for (;;)
        {
          paramLayoutInflater.printStackTrace();
          ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "url is illegal!! " + this.mUrl);
          QQToast.a(getActivity(), 1, acfp.m(2131703782), 0).show();
          continue;
          label477:
          this.p.startDownload();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.e.cancel();
    }
    ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "onDestroy");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.e != null) {
      this.e.cancel();
    }
    ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "onDetach");
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadCanceled url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadFialed url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "urlDrawable onLoad Success url:" + paramURLDrawable.getURL().toString());
    Object localObject1 = paramURLDrawable.getCurrDrawable();
    if ((localObject1 instanceof RegionDrawable))
    {
      localObject1 = ((RegionDrawable)localObject1).getBitmap();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "region bitmap is null!!");
        localObject2 = aqhu.f(paramURLDrawable, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setData(this.jdField_a_of_type_Apgo);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setImageBitmap((Bitmap)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setOnItemClickListener(this);
          return;
        }
        ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed bitmap is null!!");
        return;
      }
      ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed mArithResultView is null!!");
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment
 * JD-Core Version:    0.7.0.1
 */