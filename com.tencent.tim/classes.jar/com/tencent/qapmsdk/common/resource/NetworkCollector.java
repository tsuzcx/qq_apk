package com.tencent.qapmsdk.common.resource;

import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/NetworkCollector;", "Lcom/tencent/qapmsdk/common/resource/ResourceCollector;", "()V", "networkStatsFile", "Ljava/io/RandomAccessFile;", "getTotalBytes", "", "initFile", "", "filePath", "", "isLocalInterface", "", "ifaceHash", "", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class NetworkCollector
  extends ResourceCollector
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_common_NetworkCollector";
  private RandomAccessFile networkStatsFile;
  
  private final void initFile(String paramString)
  {
    Arrays.fill(getBufferBytes(), (byte)-1);
    RandomAccessFile localRandomAccessFile = this.networkStatsFile;
    if (localRandomAccessFile != null) {}
    for (paramString = localRandomAccessFile;; paramString = openFile(paramString))
    {
      paramString.seek(0L);
      if (paramString.read(getBufferBytes(), 0, getBufferBytes().length) != -1) {
        break;
      }
      throw ((Throwable)new IOException("read sys stats error"));
    }
    this.networkStatsFile = paramString;
    setCurIndex(0);
    setReachedEof(false);
    setValid(true);
  }
  
  private final boolean isLocalInterface(int paramInt)
  {
    boolean bool2 = false;
    int j = ResourceConstant.Companion.getLOCAL_IFACE_HASHES().length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == ResourceConstant.Companion.getLOCAL_IFACE_HASHES()[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  @Nullable
  public final long[] getTotalBytes()
  {
    label307:
    for (;;)
    {
      try
      {
        if (isValid())
        {
          boolean bool = getCanReadStat();
          if (bool) {}
        }
        else
        {
          arrayOfLong = null;
          return arrayOfLong;
        }
        long[] arrayOfLong = new long[4];
        Arrays.fill(arrayOfLong, 0L);
        Object localObject1;
        try
        {
          initFile("/proc/net/xt_qtaguid/stats");
          skipPast('\n');
          if ((getReachedEof()) || (!isValid()) || (!peek())) {
            break label307;
          }
          skipPast(' ');
          j = readHash();
          skipPast(' ');
          long l = readNumber();
          if (j == ResourceConstant.Companion.getWLAN0_HASH())
          {
            i = 1;
            if ((i != 0) || (isLocalInterface(j))) {
              continue;
            }
            j = 1;
            if ((l == ResourceConstant.Companion.getUID()) && ((i != 0) || (j != 0))) {
              continue;
            }
            skipPast('\n');
            continue;
          }
        }
        catch (Exception localException)
        {
          setValid(true);
          closeFile(CollectionsKt.listOf(this.networkStatsFile));
          Logger.INSTANCE.d(new String[] { "QAPM_common_NetworkCollector", localException + ": read stat file error." });
          localObject1 = null;
        }
        int i = 0;
        continue;
        int j = 0;
        continue;
        skipPast(' ');
        localObject1[0] += readNumber();
        localObject1[1] += readNumber();
        localObject1[2] += readNumber();
        localObject1[3] += readNumber();
        setCurIndex(getCurIndex() + 23);
        skipPast('\n');
        continue;
        setValid(true);
      }
      finally {}
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/resource/NetworkCollector$Companion;", "", "()V", "TAG", "", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.resource.NetworkCollector
 * JD-Core Version:    0.7.0.1
 */