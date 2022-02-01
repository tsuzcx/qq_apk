import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qav.controller.multi.MultiOperatorImpl.1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aset
  extends ases
  implements aser, asey.a
{
  private asei.a a;
  private boolean dec;
  private boolean ded;
  private boolean dee;
  private boolean def;
  private int elK;
  private Runnable id;
  private AudioManager mAudioManager;
  private Map<Long, asei.b> oT;
  
  public aset(Context paramContext, long paramLong, asen paramasen)
  {
    super(paramContext, paramLong, paramasen);
    asev.d("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramasen }));
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    this.oT = new HashMap();
    asey.a().a(this);
  }
  
  private void UA(boolean paramBoolean)
  {
    asev.d("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(true);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend(true);
  }
  
  private void UB(boolean paramBoolean)
  {
    asev.d("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
  }
  
  private asei.b a(long paramLong)
  {
    asei.b localb = null;
    if (this.oT != null) {
      localb = (asei.b)this.oT.get(Long.valueOf(paramLong));
    }
    return localb;
  }
  
  private void a(asei.b paramb)
  {
    if (this.oT != null) {
      this.oT.put(Long.valueOf(paramb.mUin), paramb);
    }
  }
  
  private void a(asei.b paramb, boolean paramBoolean)
  {
    asfd.a().a(aseu.class, 5, new Object[] { paramb, Boolean.valueOf(paramBoolean) });
  }
  
  private asei.b b(long paramLong)
  {
    asei.b localb = null;
    if (this.oT != null) {
      localb = (asei.b)this.oT.remove(Long.valueOf(paramLong));
    }
    return localb;
  }
  
  private void b(asei.b paramb)
  {
    asfd.a().a(aseu.class, 3, new Object[] { paramb });
  }
  
  private void c(asei.b paramb)
  {
    asfd.a().a(aseu.class, 4, new Object[] { paramb });
  }
  
  private void emU()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void emV()
  {
    asev.d("MultiOperatorImpl", String.format("checkInterruptCurrentCall mHasEnterRoom=%s", new Object[] { Boolean.valueOf(this.dee) }));
    if (this.dee)
    {
      exitRoom();
      notifyError(4);
    }
  }
  
  private void emW()
  {
    if (this.id == null)
    {
      this.id = new MultiOperatorImpl.1(this);
      asfe.k(this.id, 30000L);
    }
  }
  
  private void emX()
  {
    if (this.id != null)
    {
      asfe.at(this.id);
      this.id = null;
    }
  }
  
  private List<asei.b> gW()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.oT != null)
    {
      Collection localCollection = this.oT.values();
      localObject1 = localObject2;
      if (!localCollection.isEmpty()) {
        localObject1 = new ArrayList(localCollection);
      }
    }
    return localObject1;
  }
  
  private void notifyError(int paramInt)
  {
    asev.e("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    asfd.a().a(aseu.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void Uw(boolean paramBoolean)
  {
    UA(paramBoolean);
    this.dec = paramBoolean;
  }
  
  public void Ux(boolean paramBoolean)
  {
    UB(paramBoolean);
    this.ded = paramBoolean;
  }
  
  public void Uy(boolean paramBoolean)
  {
    if (paramBoolean) {
      emV();
    }
  }
  
  public void Uz(boolean paramBoolean)
  {
    if (paramBoolean) {
      emV();
    }
  }
  
  public int a(asei.a parama)
  {
    for (;;)
    {
      try
      {
        asev.d("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { parama }));
        boolean bool1 = asey.a().bF();
        boolean bool2 = asey.a().sM();
        asev.d("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        int i;
        if ((bool1) || (bool2))
        {
          asev.e("MultiOperatorImpl", "enterRoom device take up.");
          i = -2;
          return i;
        }
        if (this.dee)
        {
          asev.e("MultiOperatorImpl", "enterRoom duplicate call.");
          i = -3;
        }
        else
        {
          aseq.a(this.jdField_a_of_type_Asen);
          aseq.a(this.jdField_a_of_type_Asen, this.mContext, this.mSelfUin);
          if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_Asei$a = parama;
            i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(parama.aqx, parama.aww, parama.elI, parama.elJ, this.mSelfUin, parama.mOpenId, parama.bDB, parama.bc, 0);
            asev.d("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0) {
              emW();
            }
            this.dee = true;
            if (i == 0) {
              i = 0;
            } else {
              i = -1;
            }
          }
          else
          {
            i = -1;
          }
        }
      }
      finally {}
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    asev.e("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    exitRoom();
    emX();
    if (paramInt2 == 15)
    {
      notifyError(3);
      return;
    }
    notifyError(2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    asei.b localb;
    if (!paramBoolean)
    {
      bool1 = true;
      asev.d("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool1) }));
      localb = a(paramLong);
      if (localb != null) {
        if (paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localb.mMicOn = paramBoolean;
      if ((!TextUtils.isEmpty(localb.mOpenId)) || (this.jdField_a_of_type_Asei$a.aqx != 11)) {
        a(localb, bool1);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 42) || (paramInt1 == 43))
    {
      if (paramInt1 == 42) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt2 = paramArrayOfLong.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          asei.b localb = a(paramArrayOfLong[paramInt1]);
          if ((localb != null) && ((!TextUtils.isEmpty(localb.mOpenId)) || (this.jdField_a_of_type_Asei$a.aqx != 11))) {
            asfd.a().a(aseu.class, 6, new Object[] { localb, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void a(ini paramini, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_Asei$a == null) {}
    do
    {
      do
      {
        return;
        if (paramInt1 == 70)
        {
          asev.d("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramini.account), Long.valueOf(paramLong1) }));
          if (paramini.account == this.mSelfUin) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0)
            {
              emX();
              asfd.a().a(aseu.class, 1, new Object[0]);
            }
            paramVarArgs = a(paramini.account);
            if ((paramVarArgs == null) && (paramInt1 == 0)) {
              break;
            }
            paramini = paramVarArgs;
            if (paramInt1 != 0)
            {
              paramini = new asei.b();
              paramini.mUin = this.jdField_a_of_type_Asei$a.mUin;
              paramini.mOpenId = this.jdField_a_of_type_Asei$a.mOpenId;
              paramini.mMicOn = true;
              a(paramini);
            }
            b(paramini);
            return;
          }
          paramVarArgs = new asei.b();
          paramVarArgs.mUin = paramini.account;
          paramVarArgs.mMicOn = true;
          a(paramVarArgs);
          if (this.jdField_a_of_type_Asei$a.aqx == 11)
          {
            emU();
            return;
          }
          b(paramVarArgs);
          return;
        }
      } while (paramInt1 != 71);
      asev.d("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramini.account), Long.valueOf(paramLong1) }));
      paramini = b(paramini.account);
    } while (paramini == null);
    c(paramini);
  }
  
  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    asev.d("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    exitRoom();
    emX();
    notifyError(2);
  }
  
  public void bD(long paramLong) {}
  
  public void destroy()
  {
    try
    {
      asey.a().a(null);
      if (this.oT != null)
      {
        this.oT.clear();
        this.oT = null;
      }
      super.destroy();
      return;
    }
    finally {}
  }
  
  public void e(long paramLong, ArrayList<ini> paramArrayList)
  {
    if (this.jdField_a_of_type_Asei$a == null) {
      return;
    }
    Iterator localIterator;
    if (this.jdField_a_of_type_Asei$a.aqx == 11) {
      localIterator = paramArrayList.iterator();
    }
    label26:
    label204:
    label208:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ini localini = (ini)localIterator.next();
        asei.b localb = a(localini.account);
        paramArrayList = localb;
        if (localb == null)
        {
          paramArrayList = new asei.b();
          paramArrayList.mUin = localini.account;
          paramArrayList.mMicOn = true;
          a(paramArrayList);
        }
        if (!TextUtils.isEmpty(paramArrayList.mOpenId)) {
          break label204;
        }
        paramArrayList.mOpenId = localini.openId;
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        b(paramArrayList);
        if (paramArrayList.mMicOn) {
          break label26;
        }
        a(paramArrayList, false);
        break label26;
        if (!this.def) {
          break;
        }
        paramArrayList = gW();
        asev.d("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
        asfd.a().a(aseu.class, 7, new Object[] { paramArrayList });
        this.def = false;
        return;
      }
    }
  }
  
  public void exitRoom()
  {
    try
    {
      asev.d("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_Asei$a = null;
      if (this.oT != null) {
        this.oT.clear();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quit(0);
        emX();
        this.dee = false;
      }
      return;
    }
    finally {}
  }
  
  public void f(int paramInt1, long paramLong, int paramInt2)
  {
    asev.d("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void setAudioRoute(int paramInt)
  {
    if (paramInt == 0)
    {
      try
      {
        this.mAudioManager.stopBluetoothSco();
        this.mAudioManager.setBluetoothScoOn(false);
        this.mAudioManager.setSpeakerphoneOn(false);
        if (Build.VERSION.SDK_INT >= 21) {
          this.mAudioManager.setMode(3);
        }
        for (;;)
        {
          this.elK = paramInt;
          return;
          this.mAudioManager.setMode(2);
        }
        if (paramInt != 1) {
          break label113;
        }
      }
      catch (Exception localException)
      {
        asev.e("MultiOperatorImpl", "setAudioRoute fail.", localException);
        return;
      }
    }
    else
    {
      this.mAudioManager.stopBluetoothSco();
      this.mAudioManager.setBluetoothScoOn(false);
      this.mAudioManager.setSpeakerphoneOn(true);
      this.mAudioManager.setMode(0);
      this.elK = paramInt;
      return;
    }
    label113:
    if (paramInt == 2)
    {
      this.mAudioManager.startBluetoothSco();
      this.mAudioManager.setBluetoothScoOn(true);
      this.mAudioManager.setSpeakerphoneOn(false);
      this.mAudioManager.setMode(3);
      this.elK = paramInt;
    }
  }
  
  public void updateRoomInfo()
  {
    try
    {
      asev.d("MultiOperatorImpl", "updateRoomInfo");
      emU();
      this.def = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aset
 * JD-Core Version:    0.7.0.1
 */