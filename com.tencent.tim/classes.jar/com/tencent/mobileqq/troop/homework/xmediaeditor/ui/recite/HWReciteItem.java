package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import apkp;
import aplc.a;
import aplp;
import aplt;
import aplu;
import aplv;
import aplx;
import aqnt;
import aqnt.a;
import auru;
import awjs;
import awjs.b;
import awjs.c;
import awkc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import qem;

public class HWReciteItem
  extends aplp<b, apkp>
  implements Handler.Callback, aqnt.a
{
  private final auru a;
  public b a;
  private apkp jdField_b_of_type_Apkp;
  private aqnt jdField_b_of_type_Aqnt;
  BroadcastReceiver bC = new aplu(this);
  private final Context mContext;
  private boolean mIsPlaying;
  private String mTroopUin;
  
  public HWReciteItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.mContext = paramContext;
    this.jdField_a_of_type_Auru = new auru(this);
    this.mTroopUin = paramXMediaEditor.oG("troopuin");
  }
  
  private void Ta(String paramString)
  {
    awkc.n(this.mContext).edit().remove(paramString).commit();
  }
  
  private void d(apkp paramapkp)
  {
    if ((!TextUtils.isEmpty(paramapkp.bIS)) || (paramapkp.mUploadStatus != 0)) {
      return;
    }
    f(paramapkp);
    ThreadManager.post(new HWReciteItem.1(this, paramapkp), 8, null, true);
  }
  
  private void e(apkp paramapkp)
  {
    if ((!TextUtils.isEmpty(paramapkp.bIS)) || (paramapkp.mUploadStatus != 2)) {
      return;
    }
    f(paramapkp);
    ThreadManager.post(new HWReciteItem.2(this, paramapkp), 8, null, true);
  }
  
  private void f(apkp paramapkp)
  {
    if (paramapkp.a == null)
    {
      paramapkp.a = new awjs.c(qem.getQQAppInterface(), paramapkp.mFilePath, paramapkp.mTroopUin);
      paramapkp.a.a(new a(paramapkp));
    }
    paramapkp.mUploadStatus = 1;
  }
  
  private void hV(String paramString1, String paramString2)
  {
    awkc.n(this.mContext).edit().putString(paramString1, paramString2).commit();
  }
  
  private void i(apkp paramapkp)
  {
    if ((paramapkp != null) && (paramapkp.mIsPlaying)) {
      stopAudio();
    }
  }
  
  private String oI(String paramString)
  {
    return awkc.n(this.mContext).getString(paramString, null);
  }
  
  public b a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131560828, paramViewGroup, false);
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tnecnet.mobileqq.homework.recite.stopAudio");
      this.mContext.registerReceiver(this.bC, localIntentFilter);
      label42:
      return new b(paramViewGroup);
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  public void a(View paramView, b paramb)
  {
    if (paramb != null) {
      paramb.a(paramView, this);
    }
  }
  
  public void a(apkp paramapkp)
  {
    if (paramapkp.bGG == 1) {
      d(paramapkp);
    }
  }
  
  public void a(b paramb, apkp paramapkp, int paramInt)
  {
    if (TextUtils.isEmpty(paramapkp.mTroopUin)) {
      paramapkp.mTroopUin = this.mTroopUin;
    }
    paramb.a(this, paramapkp, paramInt);
    if ((this.e.Ls() != 0) && ((paramb.jdField_a_of_type_Aplx.mItemView.getVisibility() == 0) || (paramb.jdField_a_of_type_Aplt.mItemView.getVisibility() == 0))) {
      paramb.itemView.setPadding(this.e.Ls(), 0, this.e.Ls(), 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteHWReciteItem$b = paramb;
      return;
      paramb.itemView.setPadding(0, 0, 0, 0);
    }
  }
  
  public void b(apkp paramapkp)
  {
    e(paramapkp);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = this.jdField_b_of_type_Apkp.mPosition;
    stopAudio();
    this.e.getAdapter().notifyItemChanged(paramInt1);
  }
  
  public void c(apkp paramapkp)
  {
    super.f(paramapkp);
    i(paramapkp);
  }
  
  public void c(String paramString, int paramInt1, int paramInt2) {}
  
  public void d(String paramString, int paramInt1, int paramInt2) {}
  
  public void g(apkp paramapkp)
  {
    paramapkp.mDownloadStatus = 1;
    if (!TextUtils.isEmpty(paramapkp.bIS))
    {
      String str2 = oI(paramapkp.bIS);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!new File(str2).exists())
        {
          Ta(paramapkp.bIS);
          str1 = null;
        }
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramapkp.mFilePath = str1;
        paramapkp.mDownloadStatus = 2;
        return;
      }
      ThreadManager.postImmediately(new DownloadAudioTask(this, paramapkp), null, false);
      return;
    }
    paramapkp.mDownloadStatus = 3;
  }
  
  public void h(apkp paramapkp)
  {
    if (this.mIsPlaying) {
      stopAudio();
    }
    this.mIsPlaying = true;
    this.jdField_b_of_type_Apkp = paramapkp;
    paramapkp.mIsPlaying = true;
    this.jdField_b_of_type_Aqnt = new aqnt(paramapkp.mFilePath, new Handler(), 1);
    this.jdField_b_of_type_Aqnt.cf(this.mContext);
    this.jdField_b_of_type_Aqnt.a(this);
    this.jdField_b_of_type_Aqnt.start();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof apkp)));
    paramMessage = (apkp)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage.mFilePath))
    {
      paramMessage.mDownloadStatus = 2;
      hV(paramMessage.bIS, paramMessage.mFilePath);
    }
    for (;;)
    {
      this.e.getAdapter().notifyItemChanged(paramMessage.mPosition);
      break;
      paramMessage.mDownloadStatus = 3;
    }
  }
  
  public void release()
  {
    super.release();
    stopAudio();
    try
    {
      this.mContext.unregisterReceiver(this.bC);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopAudio()
  {
    if (this.jdField_b_of_type_Aqnt != null)
    {
      this.jdField_b_of_type_Aqnt.release();
      this.jdField_b_of_type_Aqnt = null;
    }
    this.mIsPlaying = false;
    if (this.jdField_b_of_type_Apkp != null)
    {
      this.jdField_b_of_type_Apkp.mIsPlaying = false;
      this.jdField_b_of_type_Apkp = null;
    }
  }
  
  static class DownloadAudioTask
    implements Runnable
  {
    private final WeakReference<HWReciteItem> jdField_if;
    private final WeakReference<apkp> ig;
    
    DownloadAudioTask(HWReciteItem paramHWReciteItem, apkp paramapkp)
    {
      this.jdField_if = new WeakReference(paramHWReciteItem);
      this.ig = new WeakReference(paramapkp);
    }
    
    public void run()
    {
      apkp localapkp = (apkp)this.ig.get();
      if (localapkp != null)
      {
        localapkp.mFilePath = awjs.so(localapkp.bIS);
        Object localObject = (HWReciteItem)this.jdField_if.get();
        if ((localObject != null) && (HWReciteItem.a((HWReciteItem)localObject) != null))
        {
          localObject = HWReciteItem.a((HWReciteItem)localObject).obtainMessage();
          ((Message)localObject).what = 233;
          ((Message)localObject).obj = localapkp;
          ((Message)localObject).sendToTarget();
        }
      }
    }
  }
  
  final class a
    implements awjs.b
  {
    apkp d;
    
    public a(apkp paramapkp)
    {
      this.d = paramapkp;
    }
    
    public void onComplete(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HWReciteItem", 2, "upload onComplete " + this.d.cpO);
      }
      this.d.setUrl(paramString);
      this.d.mUploadStatus = 3;
    }
    
    public void onError(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HWReciteItem", 2, "onError errorCode = " + paramInt);
      }
      this.d.mUploadStatus = 2;
      HWReciteItem.a(HWReciteItem.this).post(new HWReciteItem.AudioUploadCallback.2(this));
    }
    
    public void onProgress(int paramInt)
    {
      HWReciteItem.a(HWReciteItem.this).post(new HWReciteItem.AudioUploadCallback.1(this));
    }
  }
  
  public static class b
    extends aplc.a
  {
    int CP;
    View ID;
    aplt jdField_a_of_type_Aplt;
    public aplv a;
    aplx jdField_a_of_type_Aplx;
    
    public b(View paramView)
    {
      super();
      View localView1 = paramView.findViewById(2131370265);
      View localView2 = paramView.findViewById(2131370209);
      View localView3 = paramView.findViewById(2131370264);
      this.jdField_a_of_type_Aplx = new aplx(localView1);
      this.jdField_a_of_type_Aplt = new aplt(localView2);
      this.jdField_a_of_type_Aplv = new aplv(localView3);
      this.ID = paramView;
    }
    
    void a(View paramView, HWReciteItem paramHWReciteItem)
    {
      switch (((apkp)this.jdField_a_of_type_Apkn).bGG)
      {
      default: 
        return;
      case 2: 
        if (this.CP == 2)
        {
          this.jdField_a_of_type_Aplt.a(paramView, paramHWReciteItem, this);
          return;
        }
        this.jdField_a_of_type_Aplx.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_Aplv.a(paramView, paramHWReciteItem, this);
    }
    
    void a(HWReciteItem paramHWReciteItem, apkp paramapkp, int paramInt)
    {
      this.CP = paramInt;
      switch (paramapkp.bGG)
      {
      default: 
        this.jdField_a_of_type_Aplx.mItemView.setVisibility(8);
        this.jdField_a_of_type_Aplt.mItemView.setVisibility(8);
        this.jdField_a_of_type_Aplv.mItemView.setVisibility(8);
        return;
      case 2: 
        if (paramInt == 2)
        {
          paramapkp.mUploadStatus = 0;
          this.jdField_a_of_type_Aplx.mItemView.setVisibility(8);
          this.jdField_a_of_type_Aplt.a(paramHWReciteItem, this, paramapkp, paramInt);
          this.jdField_a_of_type_Aplv.mItemView.setVisibility(8);
          return;
        }
        paramapkp.mUploadStatus = 3;
        this.jdField_a_of_type_Aplx.a(paramHWReciteItem, this, paramapkp, paramInt);
        this.jdField_a_of_type_Aplt.mItemView.setVisibility(8);
        this.jdField_a_of_type_Aplv.mItemView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_Aplx.mItemView.setVisibility(8);
      this.jdField_a_of_type_Aplt.mItemView.setVisibility(8);
      this.jdField_a_of_type_Aplv.a(paramHWReciteItem, this, paramapkp, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem
 * JD-Core Version:    0.7.0.1
 */