package com.tencent.qapmsdk.common.device;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceStore;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceStore
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_common_DeviceStore";
  
  @JvmStatic
  @TargetApi(18)
  public static final long getBlockSize(@NotNull String paramString)
  {
    return Companion.getBlockSize(paramString);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceStore$Companion;", "", "()V", "TAG", "", "getBlockSize", "", "path", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @JvmStatic
    @TargetApi(18)
    public final long getBlockSize(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "path");
      Logger localLogger;
      try
      {
        long l = new StatFs(paramString).getBlockSizeLong();
        return l;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        localLogger = Logger.INSTANCE;
        paramString = localNoSuchMethodError.getMessage();
        if (paramString != null) {}
        for (;;)
        {
          localLogger.d(new String[] { "QAPM_common_DeviceStore", paramString, ": StatFs not method blockSizeLong" });
          try
          {
            paramString = Environment.getExternalStorageDirectory();
            Intrinsics.checkExpressionValueIsNotNull(paramString, "path");
            int i = new StatFs(paramString.getPath()).getBlockSize();
            return i;
          }
          catch (NoSuchMethodError paramString)
          {
            localLogger = Logger.INSTANCE;
            paramString = localNoSuchMethodError.getMessage();
            if (paramString == null) {
              break;
            }
          }
          paramString = "NoSuchMethodError";
        }
      }
      for (;;)
      {
        localLogger.d(new String[] { "QAPM_common_DeviceStore", paramString, ": StatFs not method blockSize" });
        return 0L;
        paramString = "NoSuchMethodError";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceStore
 * JD-Core Version:    0.7.0.1
 */