package com.tencent.qapmsdk.base.meta;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;", "Lcom/tencent/qapmsdk/base/meta/MonitorMeta;", "dropCount", "", "duration", "", "dropIntervals", "", "scene", "", "(IF[JLjava/lang/String;)V", "state", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "reset", "", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DropFrameResultMeta
  extends MonitorMeta
{
  @JvmField
  public int dropCount;
  @JvmField
  @NotNull
  public long[] dropIntervals;
  @JvmField
  public float duration;
  @JvmField
  @NotNull
  public String scene;
  @JvmField
  public int state;
  
  public DropFrameResultMeta()
  {
    this(0, 0.0F, null, null, 15, null);
  }
  
  public DropFrameResultMeta(int paramInt, float paramFloat, @NotNull long[] paramArrayOfLong, @NotNull String paramString)
  {
    this.dropCount = paramInt;
    this.duration = paramFloat;
    this.dropIntervals = paramArrayOfLong;
    this.scene = paramString;
  }
  
  public final int component1()
  {
    return this.dropCount;
  }
  
  public final float component2()
  {
    return this.duration;
  }
  
  @NotNull
  public final long[] component3()
  {
    return this.dropIntervals;
  }
  
  @NotNull
  public final String component4()
  {
    return this.scene;
  }
  
  @NotNull
  public final DropFrameResultMeta copy(int paramInt, float paramFloat, @NotNull long[] paramArrayOfLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "dropIntervals");
    Intrinsics.checkParameterIsNotNull(paramString, "scene");
    return new DropFrameResultMeta(paramInt, paramFloat, paramArrayOfLong, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof DropFrameResultMeta)) {
        break label96;
      }
      paramObject = (DropFrameResultMeta)paramObject;
      if (this.dropCount != paramObject.dropCount) {
        break label98;
      }
    }
    label96:
    label98:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (Float.compare(this.duration, paramObject.duration) == 0)
        {
          bool1 = bool2;
          if (Intrinsics.areEqual(this.dropIntervals, paramObject.dropIntervals))
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(this.scene, paramObject.scene)) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = this.dropCount;
    int m = Float.floatToIntBits(this.duration);
    Object localObject = this.dropIntervals;
    if (localObject != null) {}
    for (int i = Arrays.hashCode((long[])localObject);; i = 0)
    {
      localObject = this.scene;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return (i + (k * 31 + m) * 31) * 31 + j;
    }
  }
  
  public void reset()
  {
    this.dropCount = 0;
    this.duration = 0.0F;
    int j = this.dropIntervals.length;
    int i = 0;
    while (i < j)
    {
      this.dropIntervals[i] = 0L;
      i += 1;
    }
    this.scene = "";
    this.state = 0;
  }
  
  @NotNull
  public String toString()
  {
    return "DropFrameResultMeta(dropCount=" + this.dropCount + ", duration=" + this.duration + ", dropIntervals=" + Arrays.toString(this.dropIntervals) + ", scene=" + this.scene + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.DropFrameResultMeta
 * JD-Core Version:    0.7.0.1
 */