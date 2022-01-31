package com.dataline.mpfile;

import java.util.Comparator;

public class LiteMpFileDownloadActivity$SortComparator
  implements Comparator
{
  public LiteMpFileDownloadActivity$SortComparator(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (MpfileTaskInfo)paramObject1;
    paramObject2 = (MpfileTaskInfo)paramObject2;
    if ((paramObject1.g == MpfileTaskInfo.b) && (paramObject2.g != MpfileTaskInfo.b)) {}
    do
    {
      return -1;
      if ((paramObject1.g != MpfileTaskInfo.b) && (paramObject2.g == MpfileTaskInfo.b)) {
        return 1;
      }
    } while (paramObject1.e > paramObject2.e);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileDownloadActivity.SortComparator
 * JD-Core Version:    0.7.0.1
 */