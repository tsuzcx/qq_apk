package com.tencent.av.business.manager.magicface;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import ijz;
import ikl;
import iog;
import ioh;
import iow;
import iwu;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class MagicFaceDataEntity
  extends ijz
{
  protected boolean RQ;
  protected boolean RR;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  StopSelfDecorationRunnable jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable;
  protected a a;
  b jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$b;
  ikl jdField_a_of_type_Ikl;
  protected Handler aO;
  protected BitSet c;
  int[] cv;
  protected VideoAppInterface mApp;
  int mStatus;
  
  public MagicFaceDataEntity(VideoAppInterface paramVideoAppInterface, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramString3, paramString1, paramString2);
    igd.aJ("MagicFaceDataEntity", "MagicFaceDataEntity constructor:" + paramString1 + "|" + paramBoolean + "|" + paramInt);
    this.mApp = paramVideoAppInterface;
    this.RR = paramBoolean;
    this.aO = new c(Looper.getMainLooper());
    this.cv = r();
    this.c = new BitSet();
    if ((paramInt & 0x1) != 0) {
      this.c.set(0);
    }
    if ((paramInt & 0x2) != 0) {
      this.c.set(1);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    this.jdField_a_of_type_Ikl = ((ikl)this.mApp.a(2));
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$b = new b();
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$a = new a(this);
    this.mApp.addObserver(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$a);
    this.mStatus = 0;
  }
  
  @Nullable
  private PendantItem a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_Ikl.y(null).iterator();
    PendantItem localPendantItem;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localPendantItem = (PendantItem)localIterator.next();
    } while (!paramString.equals(localPendantItem.getName()));
    for (;;)
    {
      igd.aJ("MagicFaceDataEntity", "getPtvTemplateInfo 1:" + paramString + "|" + localPendantItem);
      return localPendantItem;
      localPendantItem = null;
    }
  }
  
  private void a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    paramMagicfaceDataPendantJason = a(paramMagicfaceDataPendantJason);
    if (paramMagicfaceDataPendantJason != null) {
      iT(paramMagicfaceDataPendantJason);
    }
  }
  
  private void b(long paramLong, PendantItem paramPendantItem)
  {
    QLog.w("MagicFaceDataEntity", 1, "startSelfDecoration, info[" + paramPendantItem.getName() + "], seq[" + paramLong + "]");
    this.jdField_a_of_type_Ikl.a(paramLong, paramPendantItem);
    if (!TextUtils.isEmpty(paramPendantItem.getName()))
    {
      String str = dl(paramPendantItem.getName());
      MagicfaceDataPendantJason localMagicfaceDataPendantJason = (MagicfaceDataPendantJason)this.cR.get(str);
      igd.aJ("MagicFaceDataEntity", "startSelfDecoration 2:" + str + "|" + localMagicfaceDataPendantJason);
      if ((localMagicfaceDataPendantJason != null) && (localMagicfaceDataPendantJason.duration > 0))
      {
        igd.aJ("MagicFaceDataEntity", "startSelfDecoration 3:" + localMagicfaceDataPendantJason.duration);
        int i = localMagicfaceDataPendantJason.duration;
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable = new StopSelfDecorationRunnable(this, paramPendantItem);
        this.aO.postDelayed(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable, i);
      }
    }
  }
  
  private boolean ci(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.cv != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.cv.length)
      {
        if (this.cv[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void d(String paramString, byte[] paramArrayOfByte)
  {
    short s3 = 0;
    igd.aJ("MagicFaceDataEntity", "onReceiveFunChatExpData:" + paramString + "|" + paramArrayOfByte.length);
    SparseArray localSparseArray = ioh.a(paramArrayOfByte);
    paramArrayOfByte = null;
    Object localObject = (iog)localSparseArray.get(1);
    iog localiog = (iog)localSparseArray.get(4);
    boolean bool;
    if (localiog != null)
    {
      paramArrayOfByte = localiog.getValue();
      bool = true;
    }
    for (;;)
    {
      short s2;
      short s1;
      int i;
      if (paramArrayOfByte != null)
      {
        localObject = (iog)localSparseArray.get(3);
        s2 = 320;
        s1 = 240;
        if (localObject == null) {
          break label260;
        }
        localObject = ((iog)localObject).getValue();
        s2 = (short)(localObject[0] << 8 | localObject[1] & 0xFF);
        s1 = (short)(localObject[2] << 8 | localObject[3] & 0xFF);
        s3 = (short)(localObject[4] << 8 | localObject[5] & 0xFF);
        i = localObject[6];
      }
      label260:
      for (short s4 = (short)(localObject[7] & 0xFF | i << 8);; s4 = 0)
      {
        a(paramString, paramArrayOfByte, s1, s2, s3, s4, bool);
        paramArrayOfByte = (iog)localSparseArray.get(2);
        if (paramArrayOfByte != null) {
          ae(paramString, ByteBuffer.wrap(paramArrayOfByte.getValue()).getShort());
        }
        return;
        if (localObject == null) {
          break label266;
        }
        paramArrayOfByte = ((iog)localObject).getValue();
        bool = false;
        break;
      }
      label266:
      bool = false;
    }
  }
  
  @Nullable
  private String dk(String paramString)
  {
    if (this.cR == null) {
      return null;
    }
    Iterator localIterator = this.cR.entrySet().iterator();
    int i;
    String str;
    label35:
    int j;
    Object localObject;
    if (localIterator != null)
    {
      i = 0;
      str = null;
      j = i;
      localObject = str;
      if (!localIterator.hasNext()) {
        break label193;
      }
      localObject = (MagicfaceDataPendantJason)((Map.Entry)localIterator.next()).getValue();
      if (TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject).belongto)) {
        break label245;
      }
      if ((((MagicfaceDataPendantJason)localObject).belongto.equals("sender")) && (this.c.get(0)))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
      }
    }
    label193:
    label245:
    for (;;)
    {
      break label35;
      if ((((MagicfaceDataPendantJason)localObject).belongto.equals("reciever")) && (this.c.get(1)))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
      }
      else if (((MagicfaceDataPendantJason)localObject).belongto.equals("both"))
      {
        str = ((MagicfaceDataPendantJason)localObject).name;
        i += 1;
        continue;
        j = 0;
        localObject = null;
        igd.aJ("MagicFaceDataEntity", "getDecorateNameById: " + j + "|" + paramString + "|" + (String)localObject);
        if (j != 1) {
          break;
        }
        return localObject;
      }
    }
  }
  
  private void iS(String paramString)
  {
    igd.aJ("MagicFaceDataEntity", "reloadDecrateList 1:" + paramString);
    PtvTemplateManager.a(this.mApp).ai(new MagicFaceDataEntity.1(this, paramString));
  }
  
  private void iT(String paramString)
  {
    igd.aJ("MagicFaceDataEntity", "startSelfPendant 1:" + paramString);
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      ArrayList localArrayList = PtvTemplateManager.a(this.mApp).dG();
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break label103;
      }
      localStringBuilder = new StringBuilder().append("startSelfPendant, infos[");
      if (localArrayList == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("MagicFaceDataEntity", 1, bool + "]");
      iS(paramString);
      return;
    }
    label103:
    iU(paramString);
  }
  
  private void iU(String paramString)
  {
    paramString = a(paramString);
    long l;
    if (paramString != null)
    {
      l = AudioHelper.hG();
      if (AudioHelper.aCz()) {
        QLog.w("MagicFaceDataEntity", 1, "doStartSelfDecoration, seq[" + l + "], target[" + paramString + "]");
      }
      if (!paramString.isUsable()) {
        this.jdField_a_of_type_Ikl.a(l, paramString);
      }
    }
    else
    {
      return;
    }
    b(l, paramString);
  }
  
  private void q(Object[] paramArrayOfObject)
  {
    switch (((Integer)paramArrayOfObject[0]).intValue())
    {
    default: 
      return;
    case 130: 
      d((String)paramArrayOfObject[1], (byte[])paramArrayOfObject[2]);
      return;
    case 131: 
      ac(1, (String)paramArrayOfObject[1]);
      return;
    }
    ac(3, (String)paramArrayOfObject[1]);
  }
  
  private int[] r()
  {
    if (this.cR != null)
    {
      int i = this.cR.size();
      igd.aJ("MagicFaceDataEntity", "getPendantStartFrames 11:" + i);
      if (i > 0)
      {
        int[] arrayOfInt = new int[i];
        Iterator localIterator = this.cR.entrySet().iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          arrayOfInt[i] = ((MagicfaceDataPendantJason)localEntry.getValue()).startframe;
          igd.aJ("MagicFaceDataEntity", "getPendantStartFrames 22:" + str + "|" + arrayOfInt[i]);
          i += 1;
        }
        return arrayOfInt;
      }
    }
    return null;
  }
  
  protected boolean E(String paramString)
  {
    return this.mApp.getCurrentAccountUin().equals(paramString);
  }
  
  public PendantItem a()
  {
    String str = dk(this.mTaskId);
    if (str != null) {
      return a(str);
    }
    return null;
  }
  
  protected String a(MagicfaceDataPendantJason paramMagicfaceDataPendantJason)
  {
    return paramMagicfaceDataPendantJason.name;
  }
  
  protected void a(PendantItem paramPendantItem)
  {
    long l = AudioHelper.hG();
    this.jdField_a_of_type_Ikl.a(l, null);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, short paramShort1, short paramShort2, short paramShort3, short paramShort4, boolean paramBoolean)
  {
    igd.aJ("MagicFaceDataEntity", "onReceivePeerFaceFeature:" + paramString + "|" + paramArrayOfByte.length);
  }
  
  public String aI(int paramInt)
  {
    return "video";
  }
  
  protected void ac(int paramInt, String paramString)
  {
    igd.aJ("MagicFaceDataEntity", "onReceiveFunChatExpCMD:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      igd.aJ("MagicFaceDataEntity", "onReceiveFunChatExpCMD 22:" + paramInt + "|" + paramString + "|" + "START");
      if (!paramString.equals("START")) {
        break label133;
      }
      igd.aJ("MagicFaceDataEntity", "onReceiveFunChatExpCMD 33:" + paramInt + "|" + paramString);
      kM(paramInt);
    }
    label133:
    while (!paramString.equals("STOP")) {
      return;
    }
    kL(paramInt);
  }
  
  public void ae(String paramString, int paramInt)
  {
    igd.aJ("MagicFaceDataEntity", "onReceiveVolume:" + paramString + "|" + paramInt);
  }
  
  protected void ani()
  {
    igd.aJ("MagicFaceDataEntity", "processStart:" + this.mTaskId + "|" + this);
    this.jdField_a_of_type_Ikl.a(-1041L, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$b);
  }
  
  protected void anj()
  {
    igd.aJ("MagicFaceDataEntity", "processStop:" + this.mTaskId);
    if (a() != null) {
      a(null);
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable != null)
    {
      this.aO.removeCallbacks(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable);
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable.run();
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$StopSelfDecorationRunnable = null;
    }
    this.jdField_a_of_type_Ikl.b(-1042L, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$b);
    this.mApp.deleteObserver(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity$a);
  }
  
  public void bw(int paramInt1, int paramInt2)
  {
    igd.aJ("MagicFaceDataEntity", "MagicFaceDataEntity run:" + paramInt1 + "|" + paramInt2 + "|");
    this.anW = paramInt1;
    if (ci(paramInt1))
    {
      igd.aJ("MagicFaceDataEntity", " inPendantStartFrames:" + paramInt1);
      this.aO.obtainMessage(4, Integer.valueOf(paramInt1)).sendToTarget();
    }
  }
  
  String dl(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.endsWith("_mirror")) {
        str = paramString.substring(0, paramString.length() - "_mirror".length());
      }
    }
    return str;
  }
  
  protected void ig(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "START";; str = "STOP")
    {
      igd.aJ("MagicFaceDataEntity", "requestFaceFeatureExp:" + paramBoolean + "|" + str);
      this.jdField_a_of_type_ComTencentAvVideoController.d(6, str);
      return;
    }
  }
  
  public boolean isSender()
  {
    return this.c.get(0);
  }
  
  protected void kK(int paramInt)
  {
    igd.aJ("MagicFaceDataEntity", "processStartDecoration:" + this.mTaskId + "|" + paramInt + "|" + this.c.get(0) + "|" + this.c.get(1));
    Iterator localIterator = this.cR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (MagicfaceDataPendantJason)((Map.Entry)localObject).getValue();
      if ((paramInt == ((MagicfaceDataPendantJason)localObject).startframe) && (!TextUtils.isEmpty(((MagicfaceDataPendantJason)localObject).belongto))) {
        if ((((MagicfaceDataPendantJason)localObject).belongto.equals("sender")) && (this.c.get(0))) {
          a((MagicfaceDataPendantJason)localObject);
        } else if ((((MagicfaceDataPendantJason)localObject).belongto.equals("reciever")) && (this.c.get(1))) {
          a((MagicfaceDataPendantJason)localObject);
        } else if (((MagicfaceDataPendantJason)localObject).belongto.equals("both")) {
          a((MagicfaceDataPendantJason)localObject);
        }
      }
    }
  }
  
  protected void kL(int paramInt)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    Object localObject = BaseApplicationImpl.getContext();
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a((Context)localObject);
    if (localObject != null) {
      ((iow)localObject).lo(paramInt);
    }
    localiiv.b.clear(0);
  }
  
  protected void kM(int paramInt)
  {
    iiv localiiv = this.jdField_a_of_type_ComTencentAvVideoController.b();
    Object localObject = BaseApplicationImpl.getContext();
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a((Context)localObject);
    if (localObject != null) {
      ((iow)localObject).lm(paramInt);
    }
    localiiv.b.set(0);
  }
  
  public int kR()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count;
  }
  
  protected void showTips(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      iwu.a(this.mApp, 1016);
      return;
    }
    iwu.a(this.mApp, 1016, paramString);
  }
  
  public void start()
  {
    igd.aJ("MagicFaceDataEntity", "start:" + this.mTaskId + "|" + this);
    this.aO.obtainMessage(2).sendToTarget();
  }
  
  public void stop()
  {
    igd.aJ("MagicFaceDataEntity", "stop:" + this.mTaskId);
    this.aO.obtainMessage(3).sendToTarget();
  }
  
  static class StopSelfDecorationRunnable
    implements Runnable
  {
    final PendantItem a;
    WeakReference<MagicFaceDataEntity> mRef;
    
    StopSelfDecorationRunnable(MagicFaceDataEntity paramMagicFaceDataEntity, PendantItem paramPendantItem)
    {
      this.a = paramPendantItem;
      this.mRef = new WeakReference(paramMagicFaceDataEntity);
    }
    
    public void run()
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.mRef.get();
      if (localMagicFaceDataEntity != null)
      {
        PendantItem localPendantItem = (PendantItem)localMagicFaceDataEntity.a.a();
        if ((localPendantItem != null) && (this.a.getName().equals(localPendantItem.getName()))) {
          localMagicFaceDataEntity.a(this.a);
        }
      }
    }
  }
  
  static class a
    implements Observer
  {
    private WeakReference<MagicFaceDataEntity> bk;
    
    a(MagicFaceDataEntity paramMagicFaceDataEntity)
    {
      this.bk = new WeakReference(paramMagicFaceDataEntity);
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      int j;
      if (this.bk.get() != null)
      {
        paramObservable = ((MagicFaceDataEntity)this.bk.get()).aO;
        if (paramObject != null)
        {
          Object[] arrayOfObject = (Object[])paramObject;
          if ((arrayOfObject != null) && (arrayOfObject.length > 0))
          {
            j = ((Integer)arrayOfObject[0]).intValue();
            if ((j == 130) || (j == 131) || (j == 132)) {
              if ((j != 131) && (j != 132)) {
                break label152;
              }
            }
          }
        }
      }
      label152:
      for (int i = 500;; i = 0)
      {
        igd.aJ("MagicFaceDataEntity", "MagicFaceDataEntity update :" + j + "|" + i);
        paramObservable.sendMessageDelayed(paramObservable.obtainMessage(1, paramObject), i);
        return;
      }
    }
  }
  
  class b
    implements EffectConfigBase.a<PendantItem>
  {
    b() {}
    
    public void onDownloadFinish(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
    {
      igd.aJ("MagicFaceDataEntity", "onDownloadFinish: " + paramPendantItem.toString() + "|" + paramBoolean);
      if (paramBoolean) {
        MagicFaceDataEntity.a(MagicFaceDataEntity.this, paramLong, paramPendantItem);
      }
    }
    
    public void onItemSelectedChanged(long paramLong, PendantItem paramPendantItem) {}
    
    public void onProgressUpdate(PendantItem paramPendantItem, int paramInt) {}
  }
  
  class c
    extends Handler
  {
    c(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      igd.aJ("MagicFaceDataEntity", "MagicFaceDataEntity handleMessage A: " + MagicFaceDataEntity.this.mStatus + "|" + paramMessage.what);
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
              return;
            } while (MagicFaceDataEntity.this.mStatus != 1);
            MagicFaceDataEntity.a(MagicFaceDataEntity.this, (Object[])paramMessage.obj);
            return;
          } while (MagicFaceDataEntity.this.mStatus != 0);
          MagicFaceDataEntity.this.mStatus = 1;
          MagicFaceDataEntity.this.ani();
          return;
        } while (MagicFaceDataEntity.this.mStatus != 1);
        MagicFaceDataEntity.this.mStatus = 0;
        MagicFaceDataEntity.this.anj();
        return;
      } while (MagicFaceDataEntity.this.mStatus != 1);
      paramMessage = (Integer)paramMessage.obj;
      MagicFaceDataEntity.this.kK(paramMessage.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity
 * JD-Core Version:    0.7.0.1
 */