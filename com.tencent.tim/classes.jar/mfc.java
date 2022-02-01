import android.os.RemoteException;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.e;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlClientRedPacketModule;", "", "()V", "TAG", "", "rowkey", "currentContentTaskRowkey", "getCurrentContentTaskRowkey", "()Ljava/lang/String;", "setCurrentContentTaskRowkey", "(Ljava/lang/String;)V", "taskTimeInMs", "", "currentContentTaskTimeInMs", "getCurrentContentTaskTimeInMs", "()I", "setCurrentContentTaskTimeInMs", "(I)V", "type", "currentContentType", "getCurrentContentType", "setCurrentContentType", "curTaskTime", "globalCurrentTaskTimeInMs", "getGlobalCurrentTaskTimeInMs", "setGlobalCurrentTaskTimeInMs", "globalTotalTaskTimeInMs", "getGlobalTotalTaskTimeInMs", "isHighestRedPacketAuthorityOn", "", "()Z", "isNowInKanDianTab", "lastTaskContentRowkey", "getLastTaskContentRowkey", "lastTaskTimeForContentInMs", "getLastTaskTimeForContentInMs", "maxTaskTimePerContentInMs", "getMaxTaskTimePerContentInMs", "rijAidlInterfaceForRedPacket", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "getRijAidlInterfaceForRedPacket", "()Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket;", "taskTimePerRoundInMs", "getTaskTimePerRoundInMs", "totalRound", "getTotalRound", "canDoTaskThisTime", "getInstance", "getTaskTimeFromCache", "rowKey", "hasRead", "hasRedPacketPermission", "reportTaskProgress", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IReportTaskProgressCallback;", "requestShouldDoTaskTiming", "Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager$IShouldDoTaskTimingCallback;", "saveTaskTimeToCache", "setCanDoTaskThisTime", "canDoTask", "nextRequestCanDoTaskTs", "", "setLastTaskTimeForContent", "setMaxTaskTimePerContent", "maxTaskTimeInMs", "setRead", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mfc
{
  public static final mfc a = new mfc();
  
  @JvmStatic
  @NotNull
  public static final mfc a()
  {
    return a;
  }
  
  private final mez b()
  {
    Object localObject2 = null;
    mew localmew = mex.a.a();
    Object localObject1 = localObject2;
    if (localmew != null) {}
    try
    {
      localObject1 = localmew.a();
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("RIJAidlClientRedPacketModule", 2, localRemoteException.getMessage());
    }
    return null;
  }
  
  public final boolean Dr()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        boolean bool = localmez.Dr();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final boolean Ds()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        boolean bool = localmez.Ds();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final boolean Dt()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        boolean bool = localmez.Dt();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final boolean Dx()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        boolean bool = localmez.Dx();
        return bool;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return false;
  }
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2, @Nullable RIJRedPacketManager.e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.a(paramString, paramInt1, paramInt2, (mfa)new mfd(parame));
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final void b(@NotNull RIJRedPacketManager.f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "callback");
    mez localmez = b();
    if (localmez != null) {
      try
      {
        localmez.a((mfb)new mfe(paramf));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
        paramf.lJ(false);
        return;
      }
    }
    paramf.lJ(false);
  }
  
  public final boolean dR(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    mez localmez = b();
    if (localmez != null) {
      try
      {
        boolean bool = localmez.dR(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
      }
    }
    return false;
  }
  
  @Nullable
  public final String jD()
  {
    Object localObject = b();
    if (localObject != null) {
      try
      {
        localObject = ((mez)localObject).jD();
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return null;
  }
  
  @NotNull
  public final String jF()
  {
    Object localObject = b();
    if (localObject != null) {
      try
      {
        localObject = ((mez)localObject).jF();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "aidlInterface.currentContentTaskRowkey");
        return localObject;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return "";
  }
  
  public final void nA(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.nA(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)paramString));
    }
  }
  
  public final int oT()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.oT();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int oU()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.oU();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int oY()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.oY();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int pb()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.pb();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int pc()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.pc();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int pd()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.pd();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int pe()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.pe();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final int pf()
  {
    mez localmez = b();
    if (localmez != null) {
      try
      {
        int i = localmez.pf();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
      }
    }
    return 0;
  }
  
  public final void rE(int paramInt)
  {
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.rE(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final void rF(int paramInt)
  {
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.rF(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final void rG(int paramInt)
  {
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.rG(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
  
  public final void rH(int paramInt)
  {
    mez localmez = b();
    if (localmez != null) {}
    try
    {
      localmez.rH(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("RIJAidlClientRedPacketModule", 1, QLog.getStackTraceString((Throwable)localRemoteException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfc
 * JD-Core Version:    0.7.0.1
 */