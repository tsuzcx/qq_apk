package com.tencent.mobileqq.apollo.sdk;

import abhh;
import abml;
import abru;
import abrv;
import abrw;
import abrx;
import abry;
import abrz;
import absr;
import abyv;
import abyv.a;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import mqq.util.WeakReference;

public class CmShowRenderView
  extends ApolloTextureView
{
  private static boolean bEZ;
  private static int crm;
  private static final HashMap<String, WeakReference<CmShowRenderView>> ix = new HashMap();
  private absr a;
  private String mFriendUin;
  private String mSelfUin;
  
  public CmShowRenderView(Context paramContext)
  {
    super(paramContext, null);
    if (!aZ(paramContext)) {
      throw new RuntimeException("isSdkInit is false!");
    }
    ix.put(toString(), new WeakReference(this));
  }
  
  public CmShowRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!aZ(paramContext)) {
      throw new RuntimeException("isSdkInit is false!");
    }
    ix.put(toString(), new WeakReference(this));
  }
  
  public static void CO(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_open_store", localBundle, new abrx());
  }
  
  public static void a(int paramInt, b paramb)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "changeApolloStatus mode:", Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("mode", paramInt);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_change_mode", localBundle, new abry(paramb));
  }
  
  public static void a(abyv.a parama, int paramInt)
  {
    if (parama == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    GLTextureView.checkGLVersion();
    crm = paramInt;
    abml.registerModule();
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_base_data", localBundle, new abrv(parama));
  }
  
  public static void a(String paramString1, String paramString2, c paramc, int paramInt)
  {
    if (paramc == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    abml.registerModule();
    Bundle localBundle = new Bundle();
    localBundle.putString("selfUin", paramString1);
    localBundle.putString("friendUin", paramString2);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_init_cmshow_data", localBundle, new abrw(paramString1, paramString2, paramc));
  }
  
  public static boolean aZ(Context paramContext)
  {
    return (abhh.aW(paramContext)) && (abyv.Zr()) && (bEZ);
  }
  
  public static void b(ArrayList<String> paramArrayList, int[] paramArrayOfInt)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "preLoadRes uins:", paramArrayList });
    absr.b(paramArrayList, paramArrayOfInt);
  }
  
  public static void ib(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "onDressChanged uin.size:" + paramList.size());
    ThreadManagerV2.getUIHandlerV2().post(new CmShowRenderView.3(paramList));
  }
  
  private void ic(List<String> paramList)
  {
    Object localObject1 = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      break label15;
    }
    label15:
    while (this.a == null) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    paramList = (List<String>)localObject1;
    label35:
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = localObject2;
        if (str.equals(this.mSelfUin)) {
          localObject1 = this.mSelfUin;
        }
      }
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.mFriendUin))) {
        break label140;
      }
      paramList = this.mFriendUin;
    }
    label140:
    for (;;)
    {
      localObject2 = localObject1;
      break label35;
      if ((TextUtils.isEmpty(localObject2)) && (!TextUtils.isEmpty(paramList))) {
        break;
      }
      this.a.ez(localObject2, paramList);
      return;
    }
  }
  
  public void CP(String paramString)
  {
    if (!aZ(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ApolloUtil.iY(paramString) });
    } while (this.a == null);
    this.a.CP(paramString);
  }
  
  public int H(String paramString)
  {
    return abru.ci(paramString);
  }
  
  public void a(PlayActionConfig paramPlayActionConfig)
  {
    if (!aZ(BaseApplicationImpl.getContext()))
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction !isSdkInit");
      return;
    }
    if (paramPlayActionConfig == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction playActionConfig == null");
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "playAction before");
    this.a.a(paramPlayActionConfig);
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "playAction playActionConfig:", paramPlayActionConfig });
  }
  
  public void a(a parama, String paramString1, String paramString2, int paramInt)
  {
    this.a = new absr(this, paramInt);
    this.a.CQ(paramString1);
    this.a.b(parama);
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (!aZ(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "initAvatar !isSdkInit");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
      {
        QLog.e("CmShow_CmShowRenderView", 1, "initAvatar empty uin");
        return;
      }
      this.mSelfUin = paramString1;
      this.mFriendUin = paramString2;
    } while (this.a == null);
    this.a.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
  }
  
  public void ag(List<String> paramList, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "disposeAvatar");
    if (this.a != null) {
      this.a.ah(paramList, paramBoolean);
    }
  }
  
  public void bx(String paramString, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "hideAvatar uin", ApolloUtil.iY(paramString), " show:", Boolean.valueOf(paramBoolean) });
    if (this.a != null) {
      this.a.bx(paramString, paramBoolean);
    }
  }
  
  public void dm(String paramString, int paramInt)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "changeSpriteModel mode:", Integer.valueOf(paramInt) });
    if (this.a != null) {
      this.a.dm(paramString, paramInt);
    }
  }
  
  public void doOnPause()
  {
    if (this.a != null) {
      this.a.onPause();
    }
  }
  
  public void doOnResume()
  {
    if (this.a != null) {
      this.a.onResume();
    }
  }
  
  public void f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "updateAvatarParam");
    if (this.a != null) {
      this.a.f(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void gL(int paramInt1, int paramInt2)
  {
    if (!aZ(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "stopAction actionId:", Integer.valueOf(paramInt1), " actionSeqId:", Integer.valueOf(paramInt2) });
    } while (this.a == null);
    this.a.gL(paramInt1, paramInt2);
  }
  
  public void k(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!aZ(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ApolloUtil.iY(paramString1), " bubbleText:", paramString2 });
    } while (this.a == null);
    this.a.k(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void onDestroy()
  {
    QLog.d("CmShow_CmShowRenderView", 1, "onDestroy");
    if (this.a != null) {
      this.a.onDestroy();
    }
    ix.remove(toString());
  }
  
  public void setTouchEventRect(Rect paramRect1, Rect paramRect2, String paramString1, Rect paramRect3, String paramString2)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "setTouchEventRect leftRect:", paramRect2, " leftUin:", paramString1, " rightRect:", paramRect3, " rightUin:", paramString2 });
    ApolloRender localApolloRender = getRender();
    if (localApolloRender != null)
    {
      ApolloRender.setAABBCallBack(localApolloRender, paramRect2.left, paramRect1.bottom - paramRect2.bottom, paramRect2.right - paramRect2.left, paramRect2.bottom - paramRect2.top, paramString1, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
      ApolloRender.setAABBCallBack(localApolloRender, paramRect3.left, paramRect1.bottom - paramRect3.bottom, paramRect3.right - paramRect3.left, paramRect3.bottom - paramRect3.top, paramString2, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  public static class PlayActionConfig
    implements Parcelable
  {
    public static final Parcelable.Creator<PlayActionConfig> CREATOR = new abrz();
    public Bundle av;
    public boolean bFa;
    public int cri;
    public int crn;
    public int mActionId;
    public boolean mLoop;
    public String mUin;
    
    public PlayActionConfig() {}
    
    public PlayActionConfig(Parcel paramParcel)
    {
      this.mUin = paramParcel.readString();
      this.mActionId = paramParcel.readInt();
      this.crn = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.mLoop = bool1;
        if (paramParcel.readByte() == 0) {
          break label72;
        }
      }
      label72:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.bFa = bool1;
        this.cri = paramParcel.readInt();
        return;
        bool1 = false;
        break;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String getCacheKey()
    {
      return this.mActionId + "_" + this.mUin;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("PlayActionConfig{");
      localStringBuffer.append("mUin='").append(this.mUin).append('\'');
      localStringBuffer.append(", mActionId=").append(this.mActionId);
      localStringBuffer.append(", mActionSeqId=").append(this.crn);
      localStringBuffer.append(", mLoop=").append(this.mLoop);
      localStringBuffer.append(", mNeedRestore=").append(this.bFa);
      localStringBuffer.append(", mPlayFragment=").append(this.cri);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.mUin);
      paramParcel.writeInt(this.mActionId);
      paramParcel.writeInt(this.crn);
      if (this.mLoop)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        if (!this.bFa) {
          break label70;
        }
      }
      label70:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.cri);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void C(int paramInt, String paramString);
    
    public abstract void aH(int paramInt1, int paramInt2);
    
    public abstract void b(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle);
    
    public abstract void f(String paramString, int paramInt1, int paramInt2);
    
    public abstract void fX(String paramString);
    
    public abstract void m(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void Ee(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void fy(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowRenderView
 * JD-Core Version:    0.7.0.1
 */