package com.tencent.tim.filemanager.activity.fileassistant;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import atqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.activity.FMActivity;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class QfileBaseTabView
  extends RelativeLayout
  implements atqs
{
  boolean aQ = true;
  protected boolean ajo;
  public QQAppInterface app;
  public FMActivity b;
  public boolean cdh = true;
  View mRootView;
  protected Runnable runnable;
  
  public QfileBaseTabView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QfileBaseTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = ((FMActivity)paramContext);
    this.app = this.b.app;
  }
  
  public int Ec()
  {
    return 0;
  }
  
  public boolean H()
  {
    return this.aQ;
  }
  
  public BaseFileAssistantActivity a()
  {
    return this.b;
  }
  
  public void a(FileInfo paramFileInfo) {}
  
  public void aM()
  {
    this.aQ = false;
    new Handler().postDelayed(new QfileBaseTabView.1(this), 2000L);
  }
  
  protected boolean akI()
  {
    return a().akI();
  }
  
  protected boolean akK()
  {
    return a().akK();
  }
  
  public boolean akL()
  {
    return (akK()) || (akI());
  }
  
  public boolean akZ()
  {
    return this.runnable == null;
  }
  
  public boolean b(FileInfo paramFileInfo)
  {
    return false;
  }
  
  public boolean b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return false;
  }
  
  public boolean d(FileManagerEntity paramFileManagerEntity)
  {
    return false;
  }
  
  public void deR()
  {
    a().deR();
  }
  
  public void dfP() {}
  
  public void dfQ() {}
  
  public void dge()
  {
    if (this.runnable != null)
    {
      ThreadManager.getFileThreadHandler().removeCallbacks(this.runnable);
      this.runnable = null;
    }
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public void f(FileManagerEntity paramFileManagerEntity) {}
  
  public void fn(ArrayList<FileInfo> paramArrayList) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause()
  {
    this.cdh = false;
    this.ajo = false;
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    this.ajo = true;
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void refreshUI() {}
  
  public void resetData() {}
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    a().runOnUiThread(paramRunnable);
  }
  
  protected void setContentView(int paramInt)
  {
    this.mRootView = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.mRootView);
  }
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.b.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.cdh = paramBoolean;
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */