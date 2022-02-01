package com.tencent.qapmsdk.base.protect;

import android.app.Application;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/protect/SoProtect;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SoProtect
{
  public static final Companion Companion;
  private static final File soCrashFile;
  
  static
  {
    File localFile = null;
    Companion = new Companion(null);
    Application localApplication = BaseInfo.app;
    if (localApplication != null)
    {
      localFile = localApplication.getDir("apmcrash", 0);
      Intrinsics.checkExpressionValueIsNotNull(localFile, "it.getDir(\"apmcrash\", Context.MODE_PRIVATE)");
      localFile = new File(localFile.getAbsolutePath(), "so_crash.txt");
    }
    soCrashFile = localFile;
  }
  
  @JvmStatic
  public static final void createRestrictFile()
  {
    Companion.createRestrictFile();
  }
  
  @JvmStatic
  public static final boolean hasApmSoCrash()
  {
    return Companion.hasApmSoCrash();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/protect/SoProtect$Companion;", "", "()V", "soCrashFile", "Ljava/io/File;", "createRestrictFile", "", "hasApmSoCrash", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @JvmStatic
    public final void createRestrictFile()
    {
      File localFile = SoProtect.access$getSoCrashFile$cp();
      if (localFile != null) {
        FileUtil.Companion.writeFile(localFile.getAbsolutePath(), "", false);
      }
    }
    
    @JvmStatic
    public final boolean hasApmSoCrash()
    {
      File localFile = SoProtect.access$getSoCrashFile$cp();
      if (localFile != null) {
        return localFile.exists();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.protect.SoProtect
 * JD-Core Version:    0.7.0.1
 */