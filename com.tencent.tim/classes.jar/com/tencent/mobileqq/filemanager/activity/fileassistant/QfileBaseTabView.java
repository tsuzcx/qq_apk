package com.tencent.mobileqq.filemanager.activity.fileassistant;

import agfj;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;
import yzo.a;

public class QfileBaseTabView
  extends RelativeLayout
  implements agfj, yzo.a
{
  public int BL = -1;
  public BaseFileAssistantActivity a;
  boolean aQ = true;
  public QQAppInterface app;
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
    this.a = ((BaseFileAssistantActivity)paramContext);
    this.app = this.a.app;
  }
  
  public int Ec()
  {
    return 0;
  }
  
  public boolean H()
  {
    return this.aQ;
  }
  
  public int[] S()
  {
    return null;
  }
  
  public BaseFileAssistantActivity a()
  {
    return this.a;
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
  
  public ListView b()
  {
    return null;
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
  
  public View e()
  {
    return null;
  }
  
  public int eA()
  {
    return this.BL;
  }
  
  public void ei(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void ek(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  public void f(FileManagerEntity paramFileManagerEntity) {}
  
  public void m(Set<FileInfo> paramSet) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause()
  {
    this.cdh = false;
  }
  
  public void onRestart() {}
  
  public void onResume() {}
  
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
    this.mRootView = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(paramInt, null);
    this.mRootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(this.mRootView);
  }
  
  public void setEditbarButton(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  public void setExpandGroup(boolean paramBoolean)
  {
    this.cdh = paramBoolean;
  }
  
  public void setFromWeiXin(boolean paramBoolean)
  {
    this.a.setFromWeiXin(paramBoolean);
  }
  
  public void setPos(int paramInt1, int paramInt2) {}
  
  public void setSelect(int paramInt) {}
  
  public void setSortType(int paramInt)
  {
    this.BL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
 * JD-Core Version:    0.7.0.1
 */