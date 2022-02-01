package com.tencent.weiyun.callback;

import com.tencent.weiyun.data.CBundleReader;
import com.tencent.weiyun.data.FileItem;
import java.util.ArrayList;
import java.util.List;

public abstract class FetchFileListCallback
  extends WeiyunCallback
{
  public abstract void onError(int paramInt1, String paramString, int paramInt2, boolean paramBoolean);
  
  protected void onNativeCallback(long paramLong, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 0)
    {
      if (paramLong == 0L)
      {
        onSuccess(new ArrayList(0), new ArrayList(0), paramInt1, paramBoolean);
        return;
      }
      long l1 = CBundleReader.getLong(paramLong, "add_list", 0L);
      long l2 = CBundleReader.getLong(paramLong, "delete_list", 0L);
      CBundleReader.deleteBundle(paramLong);
      long[] arrayOfLong;
      label77:
      label109:
      ArrayList localArrayList1;
      if (l1 == 0L)
      {
        paramString = null;
        if (l2 != 0L) {
          break label213;
        }
        arrayOfLong = null;
        if (l1 != 0L) {
          CBundleReader.deleteBundle(l1);
        }
        if (l2 != 0L) {
          CBundleReader.deleteBundle(l2);
        }
        if (paramString != null) {
          break label225;
        }
        paramInt2 = 0;
        localArrayList1 = new ArrayList(paramInt2);
        if (arrayOfLong != null) {
          break label233;
        }
      }
      ArrayList localArrayList2;
      int i;
      label213:
      label225:
      label233:
      for (paramInt2 = 0;; paramInt2 = arrayOfLong.length)
      {
        localArrayList2 = new ArrayList(paramInt2);
        if (paramString == null) {
          break label241;
        }
        i = paramString.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramLong = paramString[paramInt2];
          if (paramLong != 0L)
          {
            FileItem localFileItem = FileItem.newInstance(paramLong);
            if (localFileItem != null) {
              localArrayList1.add(localFileItem);
            }
          }
          paramInt2 += 1;
        }
        paramString = CBundleReader.getLongArray(l1, "file_list");
        break;
        arrayOfLong = CBundleReader.getLongArray(l2, "file_list");
        break label77;
        paramInt2 = paramString.length;
        break label109;
      }
      label241:
      if (arrayOfLong != null)
      {
        i = arrayOfLong.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramLong = arrayOfLong[paramInt2];
          if (paramLong != 0L)
          {
            paramString = FileItem.newInstance(paramLong);
            if (paramString != null) {
              localArrayList2.add(paramString);
            }
          }
          paramInt2 += 1;
        }
      }
      onSuccess(localArrayList1, localArrayList2, paramInt1, paramBoolean);
      return;
    }
    onError(paramInt2, paramString, paramInt1, paramBoolean);
  }
  
  public abstract void onSuccess(List<FileItem> paramList1, List<FileItem> paramList2, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.callback.FetchFileListCallback
 * JD-Core Version:    0.7.0.1
 */