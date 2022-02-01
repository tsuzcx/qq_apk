package com.tencent.av.gaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igv;
import iiv;
import inj;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import jjc;
import jll;
import mqq.app.BaseActivity;

public abstract class BaseGaInvite
  extends BaseActivity
{
  public String OE;
  public final String TAG = getClass().getSimpleName() + "_" + AudioHelper.hG();
  public VideoController a;
  BaseGaInvite.GetGaFaceRunnable.a jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$a = new inj(this);
  GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  a jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$a = new a();
  public int aqx = 0;
  public ImageView gn;
  Timer l;
  public long[] l;
  public VideoAppInterface mApp;
  public long mGroupId;
  public int mUinType = 0;
  public long mf;
  public TextView mw;
  public TextView mx;
  
  public BaseGaInvite()
  {
    this.jdField_l_of_type_ArrayOfLong = null;
    this.jdField_l_of_type_JavaUtilTimer = null;
  }
  
  public static Intent a(Intent paramIntent, String paramString)
  {
    return paramIntent.putExtra("_from", paramString);
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString, long[] paramArrayOfLong)
  {
    return a(paramVideoAppInterface, paramTextView, paramVideoAppInterface.getDisplayName(paramInt1, paramString, null), paramInt2, paramString, paramArrayOfLong);
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, String paramString1, int paramInt, String paramString2, long[] paramArrayOfLong)
  {
    String str = paramString1;
    if (paramTextView != null)
    {
      float f = paramVideoAppInterface.getApp().getResources().getDimensionPixelSize(2131297766);
      str = jll.a(paramVideoAppInterface.getApp(), paramString1, paramTextView, f);
    }
    paramTextView = paramVideoAppInterface.getApp().getString(2131697703);
    int i = paramVideoAppInterface.e(paramInt, paramString2);
    paramInt = i;
    if (i == 0) {
      if (paramArrayOfLong == null) {
        break label109;
      }
    }
    label109:
    for (paramInt = paramArrayOfLong.length + 1;; paramInt = 1)
    {
      paramVideoAppInterface = String.format(paramTextView, new Object[] { Integer.valueOf(paramInt) });
      return str + paramVideoAppInterface;
    }
  }
  
  public static String b(Intent paramIntent)
  {
    return paramIntent.getStringExtra("_from");
  }
  
  public String a(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Context localContext = getApplicationContext();
    Object localObject1 = igv.a(paramInt, String.valueOf(paramLong), new int[0]);
    localObject1 = igv.a().c((String)localObject1);
    int i = 0;
    if (localObject1 != null) {
      if (((iiv)localObject1).any != 4) {
        break label161;
      }
    }
    label161:
    for (i = 1; i != 0; i = 0)
    {
      localObject2 = localContext.getString(2131697839);
      localObject1 = paramString;
      paramString = (String)localObject2;
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "getGInviteWording, relationType[" + paramInt + "], groupId[" + paramInt + "], groupName[" + (String)localObject1 + "], isOnlyAudio[" + paramBoolean1 + "], fromMultiCall[" + paramBoolean2 + "], inviteHintStr[" + paramString + "]");
      }
      return paramString;
    }
    if (paramBoolean2)
    {
      f = localContext.getResources().getDimensionPixelSize(2131298231);
      localObject2 = "";
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject1 = this.mApp.getDisplayName(this.mUinType, String.valueOf(this.mGroupId), null);
      }
      paramString = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString = jll.a(localContext, (String)localObject1, this.mw, f);
      }
      localObject2 = localContext.getResources();
      if (paramBoolean1) {}
      for (i = 2131697857;; i = 2131697859)
      {
        paramString = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
        break;
      }
    }
    localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = this.mApp.getDisplayName(this.mUinType, String.valueOf(this.mGroupId), null);
    }
    float f = localContext.getResources().getDimensionPixelSize(2131297418);
    paramString = jll.a(localContext, (String)localObject1, this.mw, f);
    Object localObject2 = localContext.getResources();
    if (paramBoolean1) {}
    for (i = 2131697857;; i = 2131697859)
    {
      paramString = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
      break;
    }
  }
  
  public void aC(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      AudioHelper.I(this.TAG, paramIntent.getExtras());
      this.mUinType = paramIntent.getIntExtra("uinType", 0);
      this.mGroupId = paramIntent.getLongExtra("discussId", 0L);
      this.mf = paramIntent.getLongExtra("friendUin", 0L);
      this.aqx = paramIntent.getIntExtra("relationType", this.aqx);
      this.jdField_l_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      i = jll.cM(this.aqx);
    } while (i == this.mUinType);
    QLog.w(this.TAG, 1, "processIntent, mUinType与mRelationType不匹配，mRelationType[" + this.aqx + "], uinTpye[" + i + "], mUinType[" + this.mUinType + "]");
  }
  
  protected void aot()
  {
    if (this.jdField_l_of_type_JavaUtilTimer != null)
    {
      this.jdField_l_of_type_JavaUtilTimer.cancel();
      this.jdField_l_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$a != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$a.removeMessages(0);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$a = null;
    }
  }
  
  public abstract void aou();
  
  public boolean co(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  public void finish()
  {
    QLog.w(this.TAG, 1, "finish", new Throwable("打印调用栈"));
    aot();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.cancel();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
    super.finish();
  }
  
  public void jn(String paramString)
  {
    QLog.w(this.TAG, 1, "from:" + paramString);
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null)
    {
      if (this.gn == null) {
        break label123;
      }
      this.gn.setImageResource(2130839584);
      if (this.mx == null) {
        break label160;
      }
      String str = Long.toString(this.mf);
      this.mx.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new GetGaFaceRunnable(this.TAG, this.mApp, this.mUinType, this.aqx, this.mGroupId, this.mf, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$a);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.jo(paramString);
      return;
      label123:
      QLog.w(this.TAG, 1, "refreshUI[" + paramString + "], mHeadImage为空");
      break;
      label160:
      QLog.w(this.TAG, 1, "refreshUI[" + paramString + "], mCallersName为空");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApp = ((VideoAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    uu();
  }
  
  public void onDestroy()
  {
    QLog.w(this.TAG, 1, "onDestroy");
    super.onDestroy();
    aot();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.cancel();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
  }
  
  protected void startTimer(int paramInt)
  {
    if (this.jdField_l_of_type_JavaUtilTimer != null) {
      this.jdField_l_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_l_of_type_JavaUtilTimer = new Timer(true);
    ToolBarTask localToolBarTask = new ToolBarTask();
    this.jdField_l_of_type_JavaUtilTimer.schedule(localToolBarTask, paramInt);
  }
  
  boolean uu()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.mApp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().tf()) || (this.jdField_a_of_type_ComTencentAvVideoController.b().tg()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.P(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean uv()
  {
    return (this.mUinType == 1) || (this.mUinType == 3000);
  }
  
  public boolean uw()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {}
    while (isFinishing()) {
      return true;
    }
    return false;
  }
  
  public static class GetGaFaceRunnable
    implements Runnable
  {
    String OF;
    final String TAG;
    boolean Tf = false;
    int aqx;
    WeakReference<a> bu;
    VideoAppInterface mApp;
    long mUin;
    int mUinType;
    
    public GetGaFaceRunnable(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, long paramLong1, long paramLong2, a parama)
    {
      this.TAG = paramString;
      this.mUinType = paramInt1;
      this.mUin = paramLong1;
      this.OF = Long.toString(paramLong2);
      this.mApp = paramVideoAppInterface;
      this.aqx = paramInt2;
      this.bu = new WeakReference(parama);
    }
    
    public void cancel()
    {
      this.mApp.getHandler().removeCallbacks(this);
    }
    
    public void jo(String paramString)
    {
      if (this.Tf)
      {
        QLog.w(this.TAG, 1, "refreshUI[" + paramString + "], WaitDelayPost");
        return;
      }
      jp(paramString);
    }
    
    void jp(String paramString)
    {
      boolean bool2 = false;
      this.Tf = false;
      int i = this.mUinType;
      String str = String.valueOf(this.mUin);
      Bitmap localBitmap = this.mApp.a(i, str, null, true, false);
      int j = jjc.cJ(this.aqx);
      str = this.mApp.getDisplayName(i, str, null);
      Object localObject;
      if ((localBitmap != null) && (!TextUtils.equals(str, this.OF)))
      {
        localObject = (a)this.bu.get();
        if (localObject == null) {}
      }
      for (boolean bool1 = ((a)localObject).b(localBitmap, str);; bool1 = false)
      {
        if (!bool1)
        {
          this.Tf = true;
          this.mApp.getHandler().postDelayed(this, 1500L);
        }
        localObject = this.TAG;
        paramString = new StringBuilder().append("setGaFace[").append(paramString).append("], mRelationType[").append(this.aqx).append("], uinType_Group[").append(i).append("], mGroupId[").append(this.mUin).append("], uinType_Invite[").append(j).append("], mInviterUin[").append(this.OF).append("], memberName[").append(str).append("], faceBitmap[");
        if (localBitmap != null) {
          bool2 = true;
        }
        QLog.w((String)localObject, 1, bool2 + "], mWaitDelayPost[" + this.Tf + "], result[" + bool1 + "]");
        return;
      }
    }
    
    public void run()
    {
      jp("Runnable");
    }
    
    public static abstract interface a
    {
      public abstract boolean b(Bitmap paramBitmap, String paramString);
    }
  }
  
  class ToolBarTask
    extends TimerTask
  {
    ToolBarTask() {}
    
    public void run()
    {
      BaseGaInvite.this.a.sendEmptyMessage(0);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        BaseGaInvite.this.aou();
        return;
      }
      BaseGaInvite.this.jn("Msg");
      super.sendEmptyMessageDelayed(1, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite
 * JD-Core Version:    0.7.0.1
 */