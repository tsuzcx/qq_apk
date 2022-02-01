package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aopb;
import aqha;
import aqju;
import aqnm;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import xuc;
import zrk;
import zrl;
import zrm;
import zrn;
import zro;
import zrp;
import zsz;

public class CameraPreviewActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public aqju Y;
  private a a;
  private Gallery b;
  boolean bsF;
  public boolean bsG;
  String customSendBtnText = null;
  private ViewGroup dI;
  private Drawable ei = new ColorDrawable(0);
  private ArrayList<String> paths = new ArrayList();
  private int reqHeight;
  private int reqWidth;
  
  private void Fs(int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = getString(2131719250);
      str2 = getString(2131719249);
    }
    for (;;)
    {
      this.Y = aqha.a(this, 230, str1, str2, new zrn(this), null);
      this.Y.setOnCancelListener(new zro(this));
      this.Y.setOnDismissListener(new zrp(this));
      this.Y.show();
      return;
      if (paramInt == 7)
      {
        str1 = getString(2131719254);
        str2 = getString(2131719253);
      }
      else
      {
        if (this.Y != null)
        {
          this.Y.dismiss();
          return;
        }
        str1 = null;
        str2 = null;
      }
    }
  }
  
  private boolean VJ()
  {
    if (!Environment.getExternalStorageState().equalsIgnoreCase("mounted"))
    {
      Fs(7);
      return true;
    }
    if (xuc.eq() < 10L)
    {
      Fs(6);
      return true;
    }
    return false;
  }
  
  private void initData()
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    this.bsG = localIntent.getBooleanExtra("callFromFastImage", false);
    if (this.bsG) {
      zsz.crE();
    }
    for (;;)
    {
      this.paths = localIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      int i = localIntent.getIntExtra("uintype", 1003);
      if ((i == 0) || (i == 1) || (i == 3000) || (i == 7)) {
        bool = true;
      }
      this.bsF = bool;
      this.customSendBtnText = localIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      return;
      zsz.crC();
    }
  }
  
  private void initGallery()
  {
    this.b = new Gallery(this);
    this.b.setSpacing(getResources().getDimensionPixelSize(2131297406));
    this.dI.addView(this.b, -1, -1);
    this.a = new a();
    this.b.setAdapter(this.a);
  }
  
  private boolean io(String paramString)
  {
    boolean bool = false;
    if (new File(paramString).length() > aopb.hm())
    {
      QQToast.a(this, getResources().getString(2131696907), 0).show(getResources().getDimensionPixelSize(2131299627));
      bool = true;
    }
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.Y != null) && (this.Y.isShowing())) {
      this.Y.hide();
    }
    this.Y = null;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractGifImage.resumeAll();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (getIntent().getIntExtra("uintype", 1003) == 8000)
    {
      PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, getIntent().getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", true));
      finish();
      return;
    }
    PhotoUtils.onSendResult(this, paramInt1, paramInt2, paramIntent, false);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initData();
    this.dI = ((ViewGroup)getLayoutInflater().inflate(2131559757, null));
    initGallery();
    getLayoutInflater().inflate(2131559759, this.dI);
    this.reqWidth = getResources().getDisplayMetrics().widthPixels;
    this.reqHeight = getResources().getDisplayMetrics().heightPixels;
    super.setContentView(this.dI);
    if (this.bsF) {
      setRightButton(2131696935, new zrk(this));
    }
    setTitle(2131721081);
    this.leftView.setVisibility(8);
    this.leftViewNotBack = ((TextView)findViewById(2131369581));
    this.leftViewNotBack.setVisibility(8);
    paramBundle = (TextView)this.dI.findViewById(2131373177);
    QLog.d("IphoneTitleBarActivity", 2, "BUILD MODEL:" + Build.MODEL);
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.customSendBtnText != null)
    {
      paramBundle.setText(this.customSendBtnText);
      if (Build.MODEL.equals("PAFM00"))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, 0, aqnm.dpToPx(12.0F), 0);
        localLayoutParams.addRule(11);
        paramBundle.setLayoutParams(localLayoutParams);
      }
    }
    paramBundle.setOnClickListener(new zrl(this));
    paramBundle = this.dI.findViewById(2131373176);
    if (Build.MODEL.equals("PAFM00"))
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.setMargins(aqnm.dpToPx(12.0F), 0, 0, 0);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    paramBundle.setOnClickListener(new zrm(this));
  }
  
  class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      if (CameraPreviewActivity.a(CameraPreviewActivity.this) != null) {
        return CameraPreviewActivity.a(CameraPreviewActivity.this).size();
      }
      return 0;
    }
    
    public String getItem(int paramInt)
    {
      if ((CameraPreviewActivity.a(CameraPreviewActivity.this) != null) && (paramInt < CameraPreviewActivity.a(CameraPreviewActivity.this).size()) && (paramInt >= 0)) {
        return (String)CameraPreviewActivity.a(CameraPreviewActivity.this).get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      CameraPreviewActivity.b localb;
      Object localObject;
      if (paramView == null)
      {
        paramView = CameraPreviewActivity.this.getLayoutInflater().inflate(2131559758, null);
        localb = new CameraPreviewActivity.b();
        localb.aB = ((URLImageView)paramView.findViewById(2131373577));
        paramView.setTag(localb);
        localObject = getItem(paramInt);
        if (localObject == null) {
          break label155;
        }
        localObject = new File((String)localObject);
        if (!((File)localObject).exists()) {}
      }
      for (;;)
      {
        try
        {
          localb.aB.setImageDrawable(URLDrawable.getDrawable(((File)localObject).toURL(), CameraPreviewActivity.a(CameraPreviewActivity.this), CameraPreviewActivity.b(CameraPreviewActivity.this), CameraPreviewActivity.a(CameraPreviewActivity.this), null, true));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localb = (CameraPreviewActivity.b)paramView.getTag();
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          continue;
        }
        label155:
        localMalformedURLException.aB.setImageDrawable(null);
      }
    }
  }
  
  static class b
  {
    URLImageView aB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity
 * JD-Core Version:    0.7.0.1
 */