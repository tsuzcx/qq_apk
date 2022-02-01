package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferUploadChnConfigInfo
{
  public long nConnectTimeout = 7000L;
  public long nDataTimeout = 21000L;
  public int nMaxEachHostErrorCount = 27;
  public int nMaxEachHostParallelUseCount = 10;
  public int nMaxEachHostTotalUseCount = 200;
  public long nTotoalDataTimeout = 120000L;
  public int uMaxChannelNum = 3;
  public long uMuliFileSizeLimit = 10485760L;
  public int uPieceSize = 524288;
  
  @NonNull
  public String toString()
  {
    return "uMuliFileSizeLimit:" + this.uMuliFileSizeLimit + " uMaxChannelNum:" + this.uMaxChannelNum + " uPieceSize:" + this.uPieceSize + "nMaxEachHostTotalUseCount:" + this.nMaxEachHostTotalUseCount + " nMaxEachHostErrorCount:" + this.nMaxEachHostErrorCount + " nMaxEachHostParallelUseCount:" + this.nMaxEachHostParallelUseCount + " nConnectTimeout:" + this.nConnectTimeout + " nDataTimeout:" + this.nDataTimeout + " nTotoalDataTimeout:" + this.nTotoalDataTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo
 * JD-Core Version:    0.7.0.1
 */