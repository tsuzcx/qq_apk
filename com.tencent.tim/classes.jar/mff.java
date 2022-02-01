import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.c;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.e;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlServerRedPacketModule;", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IRIJAidlInterfaceForRedPacket$Stub;", "()V", "currentTaskContentType", "", "currentTaskRowkey", "", "currentTaskTimeInMs", "hasLoadFromDB", "", "maxTaskTimePerContentInMs", "canDoTaskThisTime", "getArticleShareWording", "getCurrentContentTaskRowkey", "getCurrentContentTaskTimeInMs", "getCurrentContentType", "getGlobalCurrentTaskTimeInMs", "getGlobalTotalTaskTimeInMs", "getLastTaskContentRowkey", "getLastTaskTimeForContentInMs", "getMaxTaskTimePerContentInMs", "getMaxTaskTimeWhenArticleStationary", "getMaximumTaskTimeForArticleInMs", "getShareTipsShowDurationInMs", "getTaskTimeFromCache", "rowKey", "getTaskTimePerRoundInMs", "getTipsShowTimeInMs", "getTotalRound", "hasRead", "hasRedPacketPermission", "isHighestRedPacketAuthorityOn", "isNowInKanDianTab", "reportTaskProgress", "", "rowkey", "type", "taskTimeInMs", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IReportTaskProgressCallback;", "requestShouldDoTaskTiming", "Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/IShouldDoTaskTimingCallback;", "saveTaskTimeToCache", "setCanDoTaskThisTime", "canDoTask", "nextRequestCanDoTaskTs", "", "setCurrentContentTaskRowkey", "setCurrentContentTaskTimeInMs", "setCurrentContentType", "setGlobalCurrentTaskTimeInMs", "curTaskTime", "setLastTaskTimeForContent", "setMaxTaskTimePerContent", "maxTaskTimeInMs", "setRead", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class mff
  extends mez.a
{
  public static final mff.a a = new mff.a(null);
  private int aQF;
  private int aQG;
  private int aQH = 20000;
  private String agn = "";
  private boolean amf;
  
  public boolean Dr()
  {
    return RIJRedPacketManager.a().Dr();
  }
  
  public boolean Ds()
  {
    return RIJRedPacketManager.a().Ds();
  }
  
  public boolean Dt()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.Dt();
  }
  
  public boolean Dx()
  {
    return ReadinjoyTabFrame.Dx();
  }
  
  public void a(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable mfa parammfa)
  {
    RIJRedPacketManager.a().a(paramString, paramInt1, paramInt2, (RIJRedPacketManager.e)new mfh(parammfa));
  }
  
  public void a(@NotNull mfb parammfb)
  {
    Intrinsics.checkParameterIsNotNull(parammfb, "callback");
    RIJRedPacketManager.a().a(1, (RIJRedPacketManager.f)new mfi(parammfb));
  }
  
  public void aJ(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    RIJRedPacketManager.a().aI(paramString, paramInt);
  }
  
  public boolean dQ(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    return RIJRedPacketManager.a().dQ(paramString);
  }
  
  public boolean dR(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    boolean bool = RIJRedPacketManager.a().dQ(paramString);
    if ((!bool) && (!this.amf))
    {
      this.amf = true;
      RIJRedPacketManager.a().a(paramString, (RIJRedPacketManager.c)new mfg(this, paramString));
    }
    return bool;
  }
  
  @NotNull
  public String jD()
  {
    Object localObject = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getInstance()");
    localObject = ((RIJRedPacketManager)localObject).jD();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getI…e().lastTaskContentRowkey");
    return localObject;
  }
  
  @NotNull
  public String jE()
  {
    Object localObject = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getInstance()");
    localObject = ((RIJRedPacketManager)localObject).jE();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJRedPacketManager.getI…nce().articleShareWording");
    return localObject;
  }
  
  @NotNull
  public String jF()
  {
    return this.agn;
  }
  
  public void nA(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowkey");
    this.agn = paramString;
  }
  
  public void nB(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    ny(paramString);
    RIJRedPacketManager.a().nz(paramString);
  }
  
  public void ny(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rowKey");
    RIJRedPacketManager.a().ny(paramString);
  }
  
  public int oT()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oT();
  }
  
  public int oU()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oU();
  }
  
  public int oV()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oV();
  }
  
  public int oW()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oW();
  }
  
  public int oY()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oY();
  }
  
  public int oZ()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.oZ();
  }
  
  public int pa()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.pa();
  }
  
  public int pb()
  {
    RIJRedPacketManager localRIJRedPacketManager = RIJRedPacketManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localRIJRedPacketManager, "RIJRedPacketManager.getInstance()");
    return localRIJRedPacketManager.pb();
  }
  
  public int pc()
  {
    return this.aQF;
  }
  
  public int pd()
  {
    return this.aQG;
  }
  
  public int pe()
  {
    return oU() / pb();
  }
  
  public int pf()
  {
    return this.aQH;
  }
  
  public void r(boolean paramBoolean, long paramLong)
  {
    RIJRedPacketManager.a().r(paramBoolean, paramLong);
  }
  
  public void rE(int paramInt)
  {
    this.aQF = paramInt;
  }
  
  public void rF(int paramInt)
  {
    this.aQG = paramInt;
  }
  
  public void rG(int paramInt)
  {
    this.aQH = paramInt;
  }
  
  public void rH(int paramInt)
  {
    RIJRedPacketManager.a().rz(paramInt);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/service/redpacket/RIJAidlServerRedPacketModule$Companion;", "", "()V", "TAG", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mff
 * JD-Core Version:    0.7.0.1
 */