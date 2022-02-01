package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.TMG.utils.QLog;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.open.ArkView;

public class WrappedArkView
  extends ArkView
{
  private a a;
  private String awx;
  private String brc;
  private String mAppName;
  private String mAppVersion;
  private String mAppView;
  ArkViewImplement.LoadCallback mLoadCallback;
  
  public WrappedArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean load(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, ArkViewImplement.LoadCallback paramLoadCallback)
  {
    this.mAppName = paramString1;
    this.mAppView = paramString2;
    this.mAppVersion = paramString3;
    this.brc = paramString4;
    this.awx = paramString5;
    this.mLoadCallback = paramLoadCallback;
    return super.load(paramString1, paramString2, paramString3, paramString4, paramString5, paramLoadCallback);
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    super.onLoadFailed(paramString, paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadFailed");
    }
    if (this.a != null) {
      this.a.a(paramString, paramInt, paramBoolean, this.mViewImpl.getViewModel());
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoadSuccess");
    }
    if (this.a != null) {
      this.a.onLoadSuccess();
    }
  }
  
  public void onLoading()
  {
    super.onLoading();
    if (QLog.isColorLevel()) {
      QLog.d("WrappedArkView", 0, "onLoading");
    }
    if (this.a != null) {
      this.a.onLoading();
    }
  }
  
  public void setOnLoadListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, boolean paramBoolean, ArkViewModel paramArkViewModel);
    
    public abstract void onLoadSuccess();
    
    public abstract void onLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.WrappedArkView
 * JD-Core Version:    0.7.0.1
 */