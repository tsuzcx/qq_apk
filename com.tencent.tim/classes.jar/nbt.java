import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "", "playType", "", "vid", "", "(ILjava/lang/String;)V", "urls", "", "(ILjava/lang/String;[Ljava/lang/String;)V", "pid", "isPreload", "", "duration", "", "playMode", "keepLastframe", "coverFrame", "hwCodec", "hwBackupUrls", "preloadDuration", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)V", "getCoverFrame", "()Z", "setCoverFrame", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getHwBackupUrls", "()Ljava/lang/String;", "setHwBackupUrls", "(Ljava/lang/String;)V", "getHwCodec", "setHwCodec", "setPreload", "getKeepLastframe", "setKeepLastframe", "getPid", "getPlayMode", "setPlayMode", "getPlayType", "()I", "getPreloadDuration", "setPreloadDuration", "(I)V", "getUrls", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getVid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;ZZZLjava/lang/String;I)Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "equals", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class nbt
{
  private final int aXh;
  private int aXj;
  @Nullable
  private String alc;
  @Nullable
  private String ald;
  private boolean arb;
  private boolean arc;
  private boolean ard;
  private long duration;
  private boolean isPreload;
  @Nullable
  private final String pid;
  @Nullable
  private final String[] urls;
  @Nullable
  private final String vid;
  
  public nbt(int paramInt, @Nullable String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public nbt(int paramInt, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    this(paramInt, paramString, paramArrayOfString, null, false, 0L, null, false, false, false, null, 0, 4080, null);
  }
  
  public nbt(int paramInt1, @Nullable String paramString1, @Nullable String[] paramArrayOfString, @Nullable String paramString2, boolean paramBoolean1, long paramLong, @Nullable String paramString3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable String paramString4, int paramInt2)
  {
    this.aXh = paramInt1;
    this.vid = paramString1;
    this.urls = paramArrayOfString;
    this.pid = paramString2;
    this.isPreload = paramBoolean1;
    this.duration = paramLong;
    this.alc = paramString3;
    this.arb = paramBoolean2;
    this.arc = paramBoolean3;
    this.ard = paramBoolean4;
    this.ald = paramString4;
    this.aXj = paramInt2;
  }
  
  @Nullable
  public final String[] B()
  {
    return this.urls;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof nbt))
      {
        paramObject = (nbt)paramObject;
        if ((this.aXh != paramObject.aXh) || (!Intrinsics.areEqual(this.vid, paramObject.vid)) || (!Intrinsics.areEqual(this.urls, paramObject.urls)) || (!Intrinsics.areEqual(this.pid, paramObject.pid)) || (this.isPreload != paramObject.isPreload) || (this.duration != paramObject.duration) || (!Intrinsics.areEqual(this.alc, paramObject.alc)) || (this.arb != paramObject.arb) || (this.arc != paramObject.arc) || (this.ard != paramObject.ard) || (!Intrinsics.areEqual(this.ald, paramObject.ald)) || (this.aXj != paramObject.aXj)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final String getPid()
  {
    return this.pid;
  }
  
  public final int getPlayType()
  {
    return this.aXh;
  }
  
  @Nullable
  public final String getVid()
  {
    return this.vid;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void od(@Nullable String paramString)
  {
    this.ald = paramString;
  }
  
  public final void pi(boolean paramBoolean)
  {
    this.isPreload = paramBoolean;
  }
  
  public final void pj(boolean paramBoolean)
  {
    this.arb = paramBoolean;
  }
  
  public final void pk(boolean paramBoolean)
  {
    this.arc = paramBoolean;
  }
  
  public final void pl(boolean paramBoolean)
  {
    this.ard = paramBoolean;
  }
  
  public final void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public final void setPlayMode(@Nullable String paramString)
  {
    this.alc = paramString;
  }
  
  public final void tj(int paramInt)
  {
    this.aXj = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return "PlayerVideoInfo(playType=" + this.aXh + ", vid=" + this.vid + ", urls=" + Arrays.toString(this.urls) + ", pid=" + this.pid + ", isPreload=" + this.isPreload + ", duration=" + this.duration + ", playMode=" + this.alc + ", keepLastframe=" + this.arb + ", coverFrame=" + this.arc + ", hwCodec=" + this.ard + ", hwBackupUrls=" + this.ald + ", preloadDuration=" + this.aXj + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbt
 * JD-Core Version:    0.7.0.1
 */