package com.tencent.biz.subscribe.other.story;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import plu;

public class VSUploadVideoEntry
  extends Entity
  implements plu
{
  public long createTime;
  public String fakeId;
  public String localVideoPath;
  @notColumn
  public PublishVideoEntry originalEntry;
  public long originalEntryId;
  public ErrorMessage result;
  public int retryTimes;
  public String uid;
  public volatile int uploadStatus = 0;
  public String vid;
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (VSUploadVideoEntry)paramObject;
    if (paramObject.originalEntry != null)
    {
      PublishVideoEntry localPublishVideoEntry = new PublishVideoEntry();
      localPublishVideoEntry.copy(paramObject.originalEntry);
      this.originalEntry = localPublishVideoEntry;
      this.originalEntry.setId(paramObject.originalEntry.getId());
      this.originalEntry.setStatus(paramObject.originalEntry.getStatus());
    }
    setId(paramObject.getId());
    setStatus(paramObject.getStatus());
    this.uploadStatus = paramObject.uploadStatus;
    this.fakeId = paramObject.fakeId;
    this.localVideoPath = paramObject.localVideoPath;
    this.vid = paramObject.vid;
    this.uid = paramObject.uid;
    this.originalEntryId = paramObject.originalEntryId;
    this.retryTimes = paramObject.retryTimes;
    this.createTime = paramObject.createTime;
  }
  
  public boolean isAutoRetry()
  {
    return this.retryTimes < 1;
  }
  
  public boolean isFail()
  {
    return (this.uploadStatus == 4) || (this.uploadStatus == 7) || (this.uploadStatus == 10) || (this.uploadStatus == 11);
  }
  
  public boolean isSuccess()
  {
    return this.uploadStatus == 9;
  }
  
  public String statusToInfo()
  {
    String str = this.uploadStatus + "";
    switch (this.uploadStatus)
    {
    default: 
      return str;
    case 0: 
      return str + "(task init)";
    case 1: 
      return str + "(task start)";
    case 2: 
      return str + "(task composite...)";
    case 3: 
      return str + "(task composite success)";
    case 4: 
      return str + "(task composite fail)";
    case 5: 
      return str + "(task upload mp4...)";
    case 6: 
      return str + "(task upload mp4 success)";
    case 7: 
      return str + "(task upload mp4 fail)";
    case 8: 
      return str + "(task send feed...)";
    case 9: 
      return str + "(task send feed success)";
    case 10: 
      return str + "(task send feed fail)";
    case 11: 
      return str + "(task cancel)";
    }
    return str + "(task retry upload)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoEntry
 * JD-Core Version:    0.7.0.1
 */