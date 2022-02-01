import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "", "()V", "mainBusinessId", "", "subBusinessId", "pushId", "notifyId", "title", "", "iconUrl", "contentText", "jumpScheme", "isUrlJump", "", "isRevokePush", "needForegroundPush", "needBackgroundPush", "bytesExtData", "", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ[B)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "notifyIdValid", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aklc
{
  @JvmField
  @NotNull
  public String contentText;
  @JvmField
  public boolean csH;
  @JvmField
  public boolean csI;
  @JvmField
  public boolean csJ;
  @JvmField
  public boolean csK;
  @JvmField
  public int dnv;
  @JvmField
  public int dnw;
  @JvmField
  public int dnx;
  @JvmField
  public int dny;
  @JvmField
  @NotNull
  public byte[] eU;
  @JvmField
  @NotNull
  public String iconUrl;
  @JvmField
  @NotNull
  public String title;
  @JvmField
  @NotNull
  public String wV;
  
  public aklc()
  {
    this(0, 0, 0, 0, null, null, null, null, false, false, false, false, null, 8190, null);
  }
  
  public aklc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @NotNull byte[] paramArrayOfByte)
  {
    this.dnv = paramInt1;
    this.dnw = paramInt2;
    this.dnx = paramInt3;
    this.dny = paramInt4;
    this.title = paramString1;
    this.iconUrl = paramString2;
    this.contentText = paramString3;
    this.wV = paramString4;
    this.csH = paramBoolean1;
    this.csI = paramBoolean2;
    this.csJ = paramBoolean3;
    this.csK = paramBoolean4;
    this.eU = paramArrayOfByte;
  }
  
  public final boolean arW()
  {
    int i = this.dny;
    if (528 > i) {}
    while (3000528 < i) {
      return false;
    }
    return true;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof aklc))
      {
        paramObject = (aklc)paramObject;
        if ((this.dnv != paramObject.dnv) || (this.dnw != paramObject.dnw) || (this.dnx != paramObject.dnx) || (this.dny != paramObject.dny) || (!Intrinsics.areEqual(this.title, paramObject.title)) || (!Intrinsics.areEqual(this.iconUrl, paramObject.iconUrl)) || (!Intrinsics.areEqual(this.contentText, paramObject.contentText)) || (!Intrinsics.areEqual(this.wV, paramObject.wV)) || (this.csH != paramObject.csH) || (this.csI != paramObject.csI) || (this.csJ != paramObject.csJ) || (this.csK != paramObject.csK) || (!Intrinsics.areEqual(this.eU, paramObject.eU))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "PushComponent(mainBusinessId=" + this.dnv + ", subBusinessId=" + this.dnw + ", pushId=" + this.dnx + ", notifyId=" + this.dny + ", title=" + this.title + ", iconUrl=" + this.iconUrl + ", contentText=" + this.contentText + ", jumpScheme=" + this.wV + ", isUrlJump=" + this.csH + ", isRevokePush=" + this.csI + ", needForegroundPush=" + this.csJ + ", needBackgroundPush=" + this.csK + ", bytesExtData=" + Arrays.toString(this.eU) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklc
 * JD-Core Version:    0.7.0.1
 */