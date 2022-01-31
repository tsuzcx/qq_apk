package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DataLineMsgSet
  implements Cloneable
{
  private static final boolean IS_MUTIPLE_FILE = false;
  private static final boolean IS_MUTIPLE_PIC = true;
  public static String TAG = "dataline.DataLineMsgSet";
  private int groupId = 0;
  private int groupType = 0;
  public boolean isReportPause = false;
  private ArrayList mComeList = new ArrayList();
  private long mFirstArriveTime = 0L;
  private DataLineMsgRecord mFirstCome = null;
  private boolean mIsNewCome = false;
  private boolean mIsPaused = false;
  private long mLastArriveTime = 0L;
  private DataLineMsgRecord[] mSet = null;
  public long mUpdateMutiViewTick = 0L;
  public long mUpdateProcessTick = 0L;
  private long nFirstId = 0L;
  private long nLastId = 0L;
  
  public DataLineMsgSet(int paramInt)
  {
    this.groupId = paramInt;
  }
  
  public static boolean isCanReciveOrResend(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!paramDataLineMsgRecord.issuc) || (paramDataLineMsgRecord.fileMsgStatus == 1L) || (paramDataLineMsgRecord.fileMsgStatus == 2L);
  }
  
  public static boolean isCanceled(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord != null) && (paramDataLineMsgRecord.fileMsgStatus == 2L);
  }
  
  public static boolean isCompleted(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord != null) && (paramDataLineMsgRecord.issuc) && (paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.fileMsgStatus == 0L);
  }
  
  public static boolean isFileType(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord.msgtype == -2000) || (paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2335);
  }
  
  public static boolean isSingle(DataLineHandler.EFILETYPE paramEFILETYPE, int paramInt)
  {
    return (paramInt == 0) || (paramEFILETYPE != DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE);
  }
  
  public static boolean isSingle(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord.groupId == 0) || (paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (this == null) {
          return false;
        }
        if (!(paramObject instanceof DataLineMsgSet)) {
          return false;
        }
        paramObject = (DataLineMsgSet)paramObject;
        if (paramObject.getTotalCount() != getTotalCount()) {
          return false;
        }
        if (!paramObject.isSingle()) {
          break;
        }
      } while (paramObject.mSet[0].sessionid == this.mSet[0].sessionid);
      return false;
    } while (paramObject.getGroupId() == getGroupId());
    return false;
  }
  
  public DataLineMsgRecord getAt(int paramInt)
  {
    return this.mSet[paramInt];
  }
  
  public int getComeCount()
  {
    int j = 0;
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int m = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfDataLineMsgRecord[i] != null) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getCompletedCount()
  {
    int j = 0;
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int m = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < m)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      int k = j;
      if (localDataLineMsgRecord != null)
      {
        k = j;
        if (localDataLineMsgRecord.issuc)
        {
          k = j;
          if (localDataLineMsgRecord.progress == 1.0F) {
            k = j + 1;
          }
        }
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public String getFileNames()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.mSet.length - 1)
    {
      localDataLineMsgRecord = this.mSet[i];
      if (localDataLineMsgRecord != null)
      {
        localStringBuilder.append(localDataLineMsgRecord.filename);
        localStringBuilder.append("、");
      }
      i += 1;
    }
    DataLineMsgRecord localDataLineMsgRecord = this.mSet[(this.mSet.length - 1)];
    if (localDataLineMsgRecord != null) {
      localStringBuilder.append(localDataLineMsgRecord.filename);
    }
    return localStringBuilder.toString();
  }
  
  public long getFileTotalSize()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      long l2 = l1;
      if (localDataLineMsgRecord != null) {
        l2 = l1 + localDataLineMsgRecord.filesize;
      }
      i += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public long getFirstId()
  {
    return this.nFirstId;
  }
  
  public DataLineMsgRecord getFirstItem()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if (localDataLineMsgRecord != null) {
        return localDataLineMsgRecord;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupId()
  {
    return this.groupId;
  }
  
  public int getGroupType()
  {
    return this.groupType;
  }
  
  public DataLineMsgRecord getItemBySessionId(long paramLong)
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.sessionid == paramLong)) {
        return localDataLineMsgRecord;
      }
      i += 1;
    }
    return null;
  }
  
  public long getLastId()
  {
    return this.nLastId;
  }
  
  public DataLineMsgRecord getLastItem()
  {
    int i = this.mSet.length - 1;
    while (i >= 0)
    {
      DataLineMsgRecord localDataLineMsgRecord = this.mSet[i];
      if (localDataLineMsgRecord != null) {
        return localDataLineMsgRecord;
      }
      i -= 1;
    }
    return null;
  }
  
  public long getMsgId()
  {
    return this.mFirstCome.msgId;
  }
  
  public long getTime()
  {
    return this.mFirstArriveTime;
  }
  
  public int getTotalCount()
  {
    return this.mSet.length;
  }
  
  public float getTotalProcess()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < j; f1 = f2)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      f2 = f1;
      if (localDataLineMsgRecord != null)
      {
        f2 = f1;
        if (localDataLineMsgRecord.issuc)
        {
          f2 = f1;
          if (localDataLineMsgRecord.fileMsgStatus == 0L) {
            f2 = f1 + localDataLineMsgRecord.progress;
          }
        }
      }
      i += 1;
    }
    if ((getTotalCount() == 0) || (this.mSet == null)) {
      return 0.0F;
    }
    return f1 / getTotalCount();
  }
  
  public boolean hasFailed()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    if (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord == null) && (isTimeOut())) {
        return true;
      }
      if (localDataLineMsgRecord == null) {}
      while ((localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.fileMsgStatus == 1L) || (localDataLineMsgRecord.fileMsgStatus == 2L))
      {
        i += 1;
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean hasSendingOrRecving()
  {
    boolean bool2 = false;
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
        if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean hasWaiting()
  {
    boolean bool2 = false;
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((arrayOfDataLineMsgRecord[i] == null) && (!isTimeOut())) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isAllCompleted()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord == null) || ((localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isCanReciveOrResend()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.fileMsgStatus == 1L) || (localDataLineMsgRecord.fileMsgStatus == 2L)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isCanceled()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int m = arrayOfDataLineMsgRecord.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      int k;
      if (isCanceled(localDataLineMsgRecord)) {
        k = j + 1;
      }
      label65:
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          if (localDataLineMsgRecord == null) {
            break label65;
          }
          k = j;
        } while (localDataLineMsgRecord.fileMsgStatus == 1L);
        k = j;
      } while (isCompleted(localDataLineMsgRecord));
      return false;
    }
    return j > 0;
  }
  
  public boolean isFileComing()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord == null) && (isTimeOut())) {}
      while ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.fileMsgStatus != 1L)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isFileType()
  {
    return (this.groupType == -2000) || (this.groupType == -2005) || (this.groupType == -2009) || (this.groupType == -2335);
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isSendFromLocal()
  {
    return this.mFirstCome.isSendFromLocal();
  }
  
  public boolean isSingle()
  {
    return (this.groupId == 0) || (this.groupType == -2005) || (this.groupType == -2009);
  }
  
  public boolean isTimeOut()
  {
    return MessageCache.a() - this.mLastArriveTime > 90L;
  }
  
  public void printlog()
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        boolean bool = QLog.isColorLevel();
        if (!bool) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("状态汇总: groupId[");
        localStringBuilder.append(this.groupId);
        localStringBuilder.append("]; size[");
        localStringBuilder.append(getTotalCount());
        localStringBuilder.append("]; isTimeOut[");
        localStringBuilder.append(isTimeOut());
        localStringBuilder.append("]; mLastArriveTime[");
        localStringBuilder.append(this.mLastArriveTime);
        localStringBuilder.append("]; ");
        DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
        int k = arrayOfDataLineMsgRecord.length;
        j = 0;
        if (i < k)
        {
          DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
          if (localDataLineMsgRecord == null)
          {
            localStringBuilder.append("{index[");
            localStringBuilder.append(j);
            localStringBuilder.append("]; 未有session}; ");
          }
          else
          {
            localStringBuilder.append("{index[");
            localStringBuilder.append(j);
            localStringBuilder.append("/");
            localStringBuilder.append(localDataLineMsgRecord.groupIndex);
            localStringBuilder.append("]; sessionid[");
            localStringBuilder.append(localDataLineMsgRecord.sessionid);
            localStringBuilder.append("]; issuc[");
            localStringBuilder.append(localDataLineMsgRecord.issuc);
            localStringBuilder.append("]; progress[");
            localStringBuilder.append(localDataLineMsgRecord.progress);
            localStringBuilder.append("]; fileMsgStatus[");
            localStringBuilder.append(localDataLineMsgRecord.fileMsgStatus);
            localStringBuilder.append("]; time[");
            localStringBuilder.append(localDataLineMsgRecord.time);
            localStringBuilder.append("]}; ");
          }
        }
      }
      finally {}
      QLog.d(TAG, 1, localObject.toString());
      continue;
      j += 1;
      i += 1;
    }
  }
  
  public DataLineMsgRecord put(Integer paramInteger, DataLineMsgRecord paramDataLineMsgRecord)
  {
    for (;;)
    {
      try
      {
        if ((this.nLastId == 0L) || (paramDataLineMsgRecord.msgId > this.nLastId)) {
          this.nLastId = paramDataLineMsgRecord.msgId;
        }
        if ((this.nFirstId == 0L) || (paramDataLineMsgRecord.msgId < this.nFirstId)) {
          this.nFirstId = paramDataLineMsgRecord.msgId;
        }
        if ((this.mFirstArriveTime == 0L) || (this.mFirstArriveTime > paramDataLineMsgRecord.time))
        {
          this.mFirstArriveTime = paramDataLineMsgRecord.time;
          this.mFirstCome = paramDataLineMsgRecord;
        }
        if ((this.mLastArriveTime == 0L) || (this.mLastArriveTime < paramDataLineMsgRecord.time)) {
          this.mLastArriveTime = paramDataLineMsgRecord.time;
        }
        if (this.groupType == 0)
        {
          this.groupType = paramDataLineMsgRecord.msgtype;
          this.mIsNewCome = true;
          paramInteger = null;
          if (isSingle(paramDataLineMsgRecord))
          {
            if (this.mSet == null) {
              this.mSet = new DataLineMsgRecord[1];
            }
            paramInteger = this.mSet[0];
            this.mSet[0] = paramDataLineMsgRecord;
            return paramInteger;
          }
        }
        else
        {
          if ((this.groupType != -2000) || ((paramDataLineMsgRecord.msgtype != -2005) && (paramDataLineMsgRecord.msgtype != -2009))) {
            continue;
          }
          this.groupType = -2005;
          continue;
        }
        if (this.mSet != null) {
          break label248;
        }
      }
      finally {}
      this.mSet = new DataLineMsgRecord[paramDataLineMsgRecord.groupSize];
      label248:
      if (paramDataLineMsgRecord.groupIndex < paramDataLineMsgRecord.groupSize)
      {
        paramInteger = this.mSet[paramDataLineMsgRecord.groupIndex];
        this.mSet[paramDataLineMsgRecord.groupIndex] = paramDataLineMsgRecord;
        QLog.d(TAG, 1, "插入Session[" + paramDataLineMsgRecord.sessionid + "], groupIndex[" + paramDataLineMsgRecord.groupIndex + "], fileMsgStatus[" + paramDataLineMsgRecord.fileMsgStatus + "], time[" + paramDataLineMsgRecord.time + "], mLastArriveTime[" + this.mLastArriveTime + "]");
      }
    }
  }
  
  public void setPaused(boolean paramBoolean)
  {
    try
    {
      this.mIsPaused = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPausedFalse(int paramInt)
  {
    try
    {
      this.mIsPaused = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTimeOut()
  {
    this.mLastArriveTime = (MessageCache.a() - 95L);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "设置timeOut, mLastArriveTime[" + this.mLastArriveTime);
    }
  }
  
  public ArrayList values()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.mIsNewCome)
        {
          this.mIsNewCome = false;
          this.mComeList.clear();
          localObject1 = this.mSet;
          int j = localObject1.length;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            if (localObject3 == null) {
              break label73;
            }
            this.mComeList.add(localObject3);
            break label73;
          }
        }
        Object localObject1 = this.mComeList;
        return localObject1;
      }
      finally {}
      label73:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgSet
 * JD-Core Version:    0.7.0.1
 */