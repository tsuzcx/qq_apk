package com.tencent.mobileqq.apollo.store;

import abii;
import abiy;
import abja;
import abtn;
import abvg;
import acfp;
import afej;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqep;
import aqgz;
import arhz;
import auru;
import ausj;
import ausj.a;
import ausr;
import avqq;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import jqg;
import wja;

public class ApolloImageShareLayout
  extends RelativeLayout
  implements abiy, abja, DialogInterface.OnDismissListener, Handler.Callback, View.OnClickListener, AdapterView.OnItemClickListener, ausj.a
{
  private long BH;
  private long Op;
  private long Oq;
  arhz jdField_a_of_type_Arhz;
  private ausr jdField_a_of_type_Ausr;
  private ausj ad;
  private boolean bFn;
  boolean bFo;
  private String bhB = "apollo_fakeurl";
  private int crE;
  private int crF;
  private int crG;
  private int crH;
  auru e = new auru(Looper.getMainLooper(), this);
  ApolloTextureView f;
  private RelativeLayout jp;
  private Activity mActivity;
  private WeakReference<AppInterface> mAppRef;
  private int[] mDressIds;
  private String mNickName;
  private int mRoleId;
  int mSurfaceHeight;
  private boolean mSurfaceReady;
  int mSurfaceWidth;
  private float sF;
  private TextView us;
  private ImageView xB;
  private ImageView xC;
  private ImageView xD;
  private ImageView xE;
  private ImageView xF;
  
  public ApolloImageShareLayout(Activity paramActivity)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
  }
  
  private void Eg(boolean paramBoolean)
  {
    if ((this.f != null) && (this.mSurfaceReady) && (this.f.getRenderImpl() != null))
    {
      if (!paramBoolean)
      {
        this.f.getRenderImpl().onExecDispose();
        this.f.getRenderImpl().a(1, null, this.mRoleId, this.sF, this.mSurfaceWidth / aqgz.getDesity() / 2.0F * 1.05F, 0.0F);
        if ((this.mDressIds != null) && (this.mDressIds.length > 0)) {
          this.f.getRenderImpl().a(1, null, this.mDressIds, null);
        }
      }
      String[] arrayOfString = abvg.a(5, -1, this.mRoleId, true);
      this.f.getRenderImpl().a(1, null, 5, 1000000, arrayOfString[0], arrayOfString[1]);
    }
  }
  
  @TargetApi(14)
  private Bitmap at()
  {
    Bitmap localBitmap = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 14) {
        localBitmap = this.f.getBitmap();
      }
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
    }
    return null;
  }
  
  public void B(int paramInt1, int paramInt2, String paramString)
  {
    if (this.f != null) {
      this.f.stopLoopDelayed(0L);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.ad != null) {
      this.ad.dismiss();
    }
  }
  
  protected void Qq()
  {
    if (this.mActivity == null) {}
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ausr.a(1));
      localArrayList.add(ausr.a(0));
      if (this.jdField_a_of_type_Ausr == null) {
        this.jdField_a_of_type_Ausr = new ausr(this.mActivity);
      }
      this.jdField_a_of_type_Ausr.setData(localArrayList);
      if (this.ad == null) {
        this.ad = ausr.a(this.mActivity, this.jdField_a_of_type_Ausr, this, this, this, false);
      }
    } while ((this.ad == null) || (this.ad.isShowing()));
    this.ad.show();
  }
  
  public void a(int paramInt1, int paramInt2, AppInterface paramAppInterface, int paramInt3, int[] paramArrayOfInt, float paramFloat)
  {
    this.mAppRef = new WeakReference(paramAppInterface);
    this.mRoleId = paramInt3;
    this.mDressIds = paramArrayOfInt;
    this.sF = paramFloat;
    super.setBackgroundColor(-1778384896);
    if (!this.bFn)
    {
      this.bFn = true;
      super.setClickable(true);
      this.jp = new RelativeLayout(getContext());
      this.crF = ((int)(wja.dp2px(296.0F, getResources()) * 0.96F));
      this.crG = (this.crF * 880 / 592);
      paramAppInterface = new RelativeLayout.LayoutParams(this.crF, this.crG);
      paramAppInterface.addRule(14);
      paramAppInterface.addRule(10);
      paramInt3 = paramInt2;
      if (paramInt2 == 0) {
        paramInt3 = (int)aqgz.hL();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 0) {
        paramInt2 = (int)aqgz.hK();
      }
      paramInt1 = (paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.crG) / 2;
      paramAppInterface.topMargin = paramInt1;
      this.jp.setDrawingCacheEnabled(true);
      super.addView(this.jp, paramAppInterface);
      int i = this.crG * 272 / 880;
      this.mSurfaceWidth = ((int)(368.0F * paramFloat));
      this.mSurfaceHeight = ((int)(368.0F * paramFloat * 1.3F));
      this.f = new ApolloTextureView(getContext(), null);
      this.f.init(this);
      paramAppInterface = new RelativeLayout.LayoutParams(this.mSurfaceWidth, this.mSurfaceHeight);
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.crE = (this.crG - this.mSurfaceHeight - i);
      paramAppInterface.topMargin = (this.crE + paramInt1);
      super.addView(this.f, paramAppInterface);
      this.f.getRender().setRenderCallback(this);
      this.crH = (this.crE + paramInt1 + this.mSurfaceHeight / 2);
      i = (int)(wja.dp2px(40.0F, getResources()) * 0.96F);
      this.xF = new ImageView(getContext());
      this.xF.setBackgroundResource(2130838543);
      paramAppInterface = new RelativeLayout.LayoutParams(i, i);
      paramAppInterface.addRule(14, -1);
      paramAppInterface.addRule(12, -1);
      paramAppInterface.bottomMargin = ((paramInt3 - ImmersiveUtils.getStatusBarHeight(super.getContext()) - this.crG - paramInt1 - i) / 2);
      this.xF.setOnClickListener(this);
      super.addView(this.xF, paramAppInterface);
      this.us = new TextView(getContext());
      this.us.setTextColor(-1);
      this.us.setTextSize(18.0F);
      this.us.setSingleLine(true);
      this.us.setMaxWidth((int)(this.crF * 0.8F));
      this.us.setEllipsize(TextUtils.TruncateAt.END);
      paramAppInterface = new RelativeLayout.LayoutParams(-2, -2);
      paramAppInterface.topMargin = ((int)(wja.dp2px(40.0F, getResources()) * 0.96F));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(14);
      this.jp.addView(this.us, paramAppInterface);
      paramAppInterface = new View(super.getContext());
      paramArrayOfInt = new RelativeLayout.LayoutParams(this.crF, (int)(wja.dp2px(55.0F, super.getResources()) * 0.96F));
      paramArrayOfInt.addRule(10);
      paramArrayOfInt.addRule(14);
      paramArrayOfInt.topMargin = ((int)(this.crG + paramInt1 - wja.dp2px(55.0F, super.getResources()) * 0.96F));
      paramAppInterface.setBackgroundResource(2130838554);
      super.addView(paramAppInterface, paramArrayOfInt);
      paramInt3 = (int)(wja.dp2px(25.0F, getResources()) * 0.96F);
      paramFloat = wja.dp2px(41.0F, super.getResources()) * 0.96F;
      float f1 = (this.crF - 2.0F * paramFloat) / 3.0F;
      this.xC = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.crG + paramInt1 - wja.dp2px(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.leftMargin = ((int)((paramInt2 - this.crF) / 2 + paramFloat - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.xC, paramAppInterface);
      this.xC.setOnClickListener(this);
      this.xC.setBackgroundResource(2130838695);
      this.xE = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.crG + paramInt1 - wja.dp2px(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.leftMargin = ((int)((paramInt2 - this.crF) / 2 + paramFloat + f1 - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(9);
      super.addView(this.xE, paramAppInterface);
      this.xE.setOnClickListener(this);
      this.xE.setBackgroundResource(2130838693);
      this.xB = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(this.crG + paramInt1 - wja.dp2px(42.0F, super.getResources()) * 0.96F));
      paramAppInterface.rightMargin = ((int)(f1 + ((paramInt2 - this.crF) / 2 + paramFloat) - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.xB, paramAppInterface);
      this.xB.setOnClickListener(this);
      this.xB.setBackgroundResource(2130838694);
      this.xD = new ImageView(getContext());
      paramAppInterface = new RelativeLayout.LayoutParams(paramInt3, paramInt3);
      paramAppInterface.topMargin = ((int)(paramInt1 + this.crG - 0.96F * wja.dp2px(42.0F, super.getResources())));
      paramAppInterface.rightMargin = ((int)((paramInt2 - this.crF) / 2 + paramFloat - paramInt3 / 2));
      paramAppInterface.addRule(10);
      paramAppInterface.addRule(11);
      super.addView(this.xD, paramAppInterface);
      this.xD.setOnClickListener(this);
      this.xD.setBackgroundResource(2130838696);
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, float paramFloat, String paramString1, String paramString2)
  {
    super.setVisibility(0);
    this.mNickName = paramString2;
    if ((paramInt != this.mRoleId) || (paramArrayOfInt != this.mDressIds) || (paramFloat != this.sF))
    {
      this.mRoleId = paramInt;
      this.mDressIds = paramArrayOfInt;
      this.sF = paramFloat;
      Eg(false);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.us.setText(paramString2);
      }
      if ((paramString1 != null) && (!paramString1.equals(this.bhB)))
      {
        this.bhB = paramString1;
        if (TextUtils.isEmpty(this.bhB)) {
          this.bhB = "https://cmshow.qq.com/qqshow/admindata/comdata/vipApollo_mall_share_background/sha1.61aa8c34c1eefb6207b65e500da2f5eb.png";
        }
        paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
        paramArrayOfInt.mRequestHeight = this.crG;
        paramArrayOfInt.mRequestWidth = this.crF;
        paramString1 = new afej(-8305182, 20.0F, this.crF, this.crG);
        paramArrayOfInt.mLoadingDrawable = paramString1;
        paramArrayOfInt.mFailedDrawable = paramString1;
        paramArrayOfInt = abtn.a(Utils.Crc64String(this.bhB), paramArrayOfInt, this.bhB);
        this.jp.setBackgroundDrawable(paramArrayOfInt);
      }
      VipUtils.a(null, "cmshow", "Apollo", "PageView", 2, 0, new String[0]);
      return;
      Eg(true);
    }
  }
  
  void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void bH(int paramInt, String paramString) {}
  
  public void close(boolean paramBoolean)
  {
    super.setVisibility(8);
    if (paramBoolean)
    {
      super.removeAllViews();
      if ((this.f != null) && (this.f.getRenderImpl() != null)) {
        this.f.getRenderImpl().onDestroy();
      }
    }
    this.e.removeCallbacksAndMessages(null);
    if (this.ad != null) {
      this.ad.dismiss();
    }
    aqz();
  }
  
  void dN(String paramString)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this.mActivity, this.crH);
    }
    this.jdField_a_of_type_Arhz.setMessage(paramString);
    this.jdField_a_of_type_Arhz.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    aqz();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return false;
                          } while (super.getVisibility() != 0);
                          paramMessage = (String)paramMessage.obj;
                        } while (TextUtils.isEmpty(paramMessage));
                        QQToast.a(getContext(), acfp.m(2131702541) + paramMessage, 1).show();
                        return false;
                        if (this.ad != null) {
                          this.ad.dismiss();
                        }
                      } while ((super.getVisibility() != 0) || (this.mAppRef == null));
                      localObject = (AppInterface)this.mAppRef.get();
                    } while (localObject == null);
                    paramMessage = (String)paramMessage.obj;
                    if (!TextUtils.isEmpty(paramMessage)) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.e("ApolloImageShareLayout", 1, "onItemClick share QZone apolloImage no file");
                  return false;
                  Bundle localBundle = new Bundle();
                  ArrayList localArrayList = new ArrayList();
                  try
                  {
                    localArrayList.add(URLDecoder.decode(paramMessage));
                    localBundle.putStringArrayList("images", localArrayList);
                    localBundle.putString("summary", acfp.m(2131702543));
                    localBundle.putInt("req_type", 7);
                    localBundle.putBoolean("key_need_save_draft", false);
                    avqq.a((AppInterface)localObject, this.mActivity, localBundle, this, 15);
                    return false;
                  }
                  catch (Exception paramMessage)
                  {
                    QLog.d("ApolloImageShareLayout", 2, "publishToQzone:" + paramMessage.getMessage());
                    return false;
                  }
                  if (this.ad != null) {
                    this.ad.dismiss();
                  }
                } while (super.getVisibility() != 0);
                paramMessage = (String)paramMessage.obj;
                if (!TextUtils.isEmpty(paramMessage)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
              return false;
              if (new File(paramMessage).exists()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("ApolloImageShareLayout", 1, "onItemClick share QQ apolloImage no file");
            return false;
          } while (this.mActivity == null);
          ApolloUtil.d(this.mActivity, paramMessage, null, 1);
          return false;
        } while (super.getVisibility() != 0);
        paramMessage = (String)paramMessage.obj;
        if (!TextUtils.isEmpty(paramMessage)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
      return false;
      if (new File(paramMessage).exists()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ApolloImageShareLayout", 1, "update avatar share QQ apolloImage no file");
    return false;
    int i = aqep.w(this.mActivity);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("keyFromUpdateAvatar", true);
    ((Intent)localObject).putExtra("Business_Origin", 100);
    PhotoUtils.a((Intent)localObject, this.mActivity, this.mActivity.getClass().getName(), i, i, 1080, 1080, paramMessage, aqep.BR());
    return false;
  }
  
  @TargetApi(14)
  public void onClick(View paramView)
  {
    long l;
    if (paramView == this.xB)
    {
      l = System.currentTimeMillis();
      if (l - this.Op >= 800L) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.Op = l;
      if (this.bFo)
      {
        QQToast.a(getContext(), acfp.m(2131702540), 0).show();
      }
      else
      {
        this.bFo = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloImageShareLayout", 2, "download Request:" + l);
        }
        if (Build.VERSION.SDK_INT >= 14)
        {
          dN(acfp.m(2131702539));
          ThreadManager.executeOnSubThread(new SaveImageTask(this, at(), this.f.getWidth(), this.f.getHeight(), 15, l));
        }
        VipUtils.a(null, "cmshow", "Apollo", "SaveClick", 0, 0, new String[0]);
        continue;
        if (paramView == this.xC)
        {
          if ((this.mSurfaceReady) && (this.f != null) && (this.f.getRenderImpl() != null))
          {
            String[] arrayOfString = abvg.a(5, -1, this.mRoleId, true);
            this.f.getRenderImpl().a(1, null, 5, 1000000, arrayOfString[0], arrayOfString[1]);
          }
          VipUtils.a(null, "cmshow", "Apollo", "PoseClick", 0, 0, new String[0]);
        }
        else if (paramView == this.xD)
        {
          Qq();
          VipUtils.a(null, "cmshow", "Apollo", "ShareClick", 0, 0, new String[0]);
        }
        else if (paramView == this.xF)
        {
          VipUtils.a(null, "cmshow", "Apollo", "CloseClick", 0, 0, new String[0]);
          close(false);
        }
        else if (paramView == this.xE)
        {
          l = System.currentTimeMillis();
          if (l - this.Oq >= 800L)
          {
            this.Oq = l;
            if (this.bFo)
            {
              QQToast.a(getContext(), acfp.m(2131702537), 0).show();
            }
            else
            {
              this.bFo = true;
              VipUtils.a(null, "cmshow", "Apollo", "headClick", 0, 0, new String[0]);
              dN(acfp.m(2131702538));
              ThreadManager.executeOnSubThread(new SaveImageTask(this, at(), this.f.getWidth(), this.f.getHeight(), 18, System.currentTimeMillis()));
            }
          }
        }
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  @TargetApi(14)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - this.BH < 2000L) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      this.BH = l;
      if (paramLong == 1L)
      {
        if (Build.VERSION.SDK_INT >= 14)
        {
          dN(acfp.m(2131702536));
          ThreadManager.executeOnSubThread(new SaveImageTask(this, at(), this.f.getWidth(), this.f.getHeight(), 16, l));
        }
        VipUtils.a(null, "cmshow", "Apollo", "Share2Qzone", 0, 0, new String[0]);
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 14)
        {
          dN(acfp.m(2131702542));
          ThreadManager.executeOnSubThread(new SaveImageTask(this, at(), this.f.getWidth(), this.f.getHeight(), 17, l));
        }
        VipUtils.a(null, "cmshow", "Apollo", "Share2QQ", 0, 0, new String[0]);
      }
    }
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.mSurfaceReady = true;
    if (this.mRoleId > 0) {
      Eg(false);
    }
  }
  
  static class SaveImageTask
    implements Runnable
  {
    private final WeakReference<Bitmap> dR;
    WeakReference<ApolloImageShareLayout> fO;
    private final int mCallBackCode;
    private final int mHeight;
    private final long mSeq;
    private final int mWidth;
    
    SaveImageTask(ApolloImageShareLayout paramApolloImageShareLayout, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      this.fO = new WeakReference(paramApolloImageShareLayout);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mCallBackCode = paramInt3;
      this.mSeq = paramLong;
      this.dR = new WeakReference(paramBitmap);
    }
    
    public void run()
    {
      if ((this.fO == null) || (this.dR == null)) {}
      do
      {
        return;
        localApolloImageShareLayout = (ApolloImageShareLayout)this.fO.get();
      } while ((localApolloImageShareLayout == null) || (ApolloImageShareLayout.a(localApolloImageShareLayout) == null) || (localApolloImageShareLayout.e == null));
      for (;;)
      {
        try
        {
          Object localObject1 = (Bitmap)this.dR.get();
          if (localObject1 == null) {
            continue;
          }
          ApolloImageShareLayout.a(localApolloImageShareLayout).buildDrawingCache(true);
          Object localObject3 = Bitmap.createBitmap(ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth(), ApolloImageShareLayout.a(localApolloImageShareLayout).getHeight(), Bitmap.Config.ARGB_8888);
          if (localObject3 == null) {
            continue;
          }
          Canvas localCanvas = new Canvas((Bitmap)localObject3);
          Bitmap localBitmap = ApolloImageShareLayout.a(localApolloImageShareLayout).getDrawingCache();
          if (localBitmap != null) {
            localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
          }
          localCanvas.drawBitmap((Bitmap)localObject1, (ApolloImageShareLayout.a(localApolloImageShareLayout).getWidth() - ((Bitmap)localObject1).getWidth()) / 2, ApolloImageShareLayout.a(localApolloImageShareLayout), null);
          localObject1 = jqg.c((Bitmap)localObject3);
          localObject3 = localApolloImageShareLayout.e.obtainMessage(this.mCallBackCode);
          ((Message)localObject3).obj = localObject1;
          ((Message)localObject3).sendToTarget();
          ApolloImageShareLayout.a(localApolloImageShareLayout).destroyDrawingCache();
        }
        catch (Exception localException)
        {
          QLog.e("ApolloImageShareLayout", 2, localException.getMessage());
          return;
          QLog.e("ApolloImageShareLayout", 2, "error! bitmap null");
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("ApolloImageShareLayout", 2, localOutOfMemoryError.getMessage());
          return;
        }
        finally
        {
          localApolloImageShareLayout.bFo = false;
        }
        localApolloImageShareLayout.bFo = false;
        return;
        QLog.e("ApolloImageShareLayout", 2, "error! layout.mBackLayout.getDrawingCache() null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloImageShareLayout
 * JD-Core Version:    0.7.0.1
 */