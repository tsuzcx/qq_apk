package dov.com.qq.im.ae.camera.ui.panel;

import aaqh;
import alwy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import aqnc;
import awwk;
import awze;
import awzf;
import awzg;
import axis;
import axpa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AEBeautyProviderView
  extends FrameLayout
{
  private float DV = 1.0F;
  private View Mj;
  private View Mk;
  private awwk a;
  public TextView agW;
  public TextView agX;
  private AEProviderContainerView b;
  private Animation bd;
  private SeekBar.OnSeekBarChangeListener d = new awze(this);
  private SeekBar.OnSeekBarChangeListener e = new awzf(this);
  private int eEm = 500;
  private final int eEn = 300;
  protected View mContentView;
  public boolean mInited;
  private View rootView;
  private SeekBar t;
  private SeekBar u;
  
  public AEBeautyProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEBeautyProviderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int QS()
  {
    int i = QU();
    this.t.setProgress(i);
    this.agW.setText("+" + i / 10.0F);
    return i;
  }
  
  private int QT()
  {
    int i = QV();
    this.u.setProgress(i);
    this.agX.setText("+" + String.format("%.1f", new Object[] { Float.valueOf(i / 10.0F) }));
    return i;
  }
  
  public static int QU()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "ae_beauty_level_" + str + "_CAMERA_ID_" + aaqh.cix;
    int i = 55;
    if (aaqh.cix == 2) {
      i = 0;
    }
    i = axis.a().l(str, i, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEBeautyProviderView", 2, "getBeautyFeature BeautyLevel=" + i + ", key:" + str);
    }
    return i;
  }
  
  public static int QV()
  {
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = axpa.cVC;
    int i;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      if (i == 0) {
        break label148;
      }
      str1 = "ae_sharp_face_level_" + str1 + "_CAMERA_ID_" + aaqh.cix;
      if (aaqh.cix != 2) {
        break label142;
      }
      i = 0;
    }
    for (;;)
    {
      i = axis.a().l(str1, i, 0);
      if (QLog.isColorLevel()) {
        QLog.d("AEBeautyProviderView", 2, "getSharpFaceFeature SharpFaceLevel = " + i + ", filterId = " + str2 + ", key:" + str1);
      }
      return i;
      i = 0;
      break;
      label142:
      i = 40;
      continue;
      label148:
      str1 = "ae_sharp_face_level_" + str1 + "filterId" + str2;
      i = 50;
    }
  }
  
  private Animation a(AEProviderContainerView paramAEProviderContainerView, View paramView, float paramFloat1, float paramFloat2)
  {
    return new aqnc(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new awzg(this, paramAEProviderContainerView, paramView));
  }
  
  private void adD(int paramInt)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = "ae_beauty_level_" + str + "_CAMERA_ID_" + aaqh.cix;
    axis.a().aY(str, paramInt, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEBeautyProviderView", 2, "saveBeautyFeature BeautyLevel=" + paramInt + ", key: " + str);
    }
  }
  
  private void adE(int paramInt)
  {
    String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = axpa.cVC;
    int i;
    String str1;
    if ((TextUtils.isEmpty(str2)) || ("0".equals(str2)))
    {
      i = 1;
      str1 = "ae_sharp_face_level_" + str3 + "filterId" + str2;
      if (i == 0) {
        break label172;
      }
      str1 = "ae_sharp_face_level_" + str3 + "_CAMERA_ID_" + aaqh.cix;
    }
    label172:
    for (;;)
    {
      axis.a().aY(str1, paramInt, 0);
      com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceLevel = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("AEBeautyProviderView", 2, "saveSharpFaceFeature SharpFaceLevel = " + paramInt + ", filterId = " + str2 + ", key:" + str1);
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void q(View paramView1, View paramView2)
  {
    if ((this.rootView != null) && ((this.rootView instanceof ViewGroup))) {
      ((ViewGroup)this.rootView).setMotionEventSplittingEnabled(false);
    }
    int j = 300;
    int i = j;
    if (this.bd != null)
    {
      i = j;
      if (!this.bd.hasEnded())
      {
        this.bd.cancel();
        i = 0;
      }
    }
    paramView1.setAlpha(1.0F);
    if (this.b.aOn()) {
      return;
    }
    this.bd = a(this.b, paramView2, this.DV, 0.0F);
    this.bd.setDuration((this.DV * this.eEm));
    this.bd.setStartOffset(i);
    startAnimation(this.bd);
  }
  
  private void r(View paramView1, View paramView2)
  {
    if ((this.bd != null) && (!this.bd.hasEnded())) {
      this.bd.cancel();
    }
    paramView1.setAlpha(1.0F);
    if (this.b.aOn()) {
      return;
    }
    this.bd = a(this.b, paramView2, this.DV, 1.0F);
    this.bd.setDuration(((1.0F - this.DV) * this.eEm));
    startAnimation(this.bd);
  }
  
  public void dKI()
  {
    eHZ();
  }
  
  public void eHZ()
  {
    if (this.mContentView != null)
    {
      int i = QT();
      if (this.a != null) {
        this.a.setSharpFaceLevel(i);
      }
      i = QS();
      if (this.a != null) {
        this.a.setBeautyLevel(i);
      }
    }
  }
  
  @TargetApi(11)
  public void onCreate(Bundle paramBundle)
  {
    if (this.mContentView == null)
    {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131563116, this, true);
      this.mInited = true;
    }
    this.rootView = ((Activity)getContext()).findViewById(2131367347);
    this.b = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131363367));
    this.Mj = this.mContentView.findViewById(2131363372);
    if (!alwy.auM()) {
      this.Mj.setVisibility(8);
    }
    this.t = ((SeekBar)this.mContentView.findViewById(2131363380));
    this.t.setOnSeekBarChangeListener(this.d);
    if (Build.VERSION.SDK_INT >= 21) {
      this.t.setSplitTrack(false);
    }
    this.agW = ((TextView)this.mContentView.findViewById(2131363373));
    QS();
    this.Mk = this.mContentView.findViewById(2131378232);
    this.u = ((SeekBar)this.mContentView.findViewById(2131378234));
    this.u.setOnSeekBarChangeListener(this.e);
    if (Build.VERSION.SDK_INT >= 21) {
      this.u.setSplitTrack(false);
    }
    this.agX = ((TextView)this.mContentView.findViewById(2131378233));
    QT();
  }
  
  public void onResume()
  {
    if (this.mContentView == null) {}
    int i;
    do
    {
      return;
      i = QS();
    } while (this.a == null);
    this.a.setBeautyLevel(i);
  }
  
  public void setController(awwk paramawwk)
  {
    this.a = paramawwk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView
 * JD-Core Version:    0.7.0.1
 */