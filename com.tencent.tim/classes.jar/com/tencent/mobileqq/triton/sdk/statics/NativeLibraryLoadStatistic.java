package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

public class NativeLibraryLoadStatistic
{
  @Nullable
  public final File file;
  public final boolean isOptional;
  @Nullable
  public final Throwable loadException;
  public final long loadTimeMs;
  @NonNull
  public final String name;
  public final boolean success;
  
  public NativeLibraryLoadStatistic(boolean paramBoolean1, @NonNull String paramString, @Nullable File paramFile, boolean paramBoolean2, long paramLong, @Nullable Throwable paramThrowable)
  {
    this.success = paramBoolean1;
    this.name = paramString;
    this.file = paramFile;
    this.isOptional = paramBoolean2;
    this.loadTimeMs = paramLong;
    this.loadException = paramThrowable;
  }
  
  public String toString()
  {
    return "NativeLibraryLoadStatistic{success=" + this.success + ", name='" + this.name + '\'' + ", path='" + this.file + '\'' + ", isOptional=" + this.isOptional + ", loadTimeMs=" + this.loadTimeMs + ", loadException=" + this.loadException + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.NativeLibraryLoadStatistic
 * JD-Core Version:    0.7.0.1
 */