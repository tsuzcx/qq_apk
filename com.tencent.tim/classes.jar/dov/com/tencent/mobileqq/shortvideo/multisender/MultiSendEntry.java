package dov.com.tencent.mobileqq.shortvideo.multisender;

import android.database.Cursor;
import android.text.TextUtils;
import azbd;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiSendEntry
  extends Entity
{
  @unique
  public String fakeVid;
  public String md5;
  @notColumn
  List<azbd> messageDataList;
  public String messageInfos;
  public int syncToStory;
  public long time;
  public String uploadInfo;
  @notColumn
  azbd uploadMessageData;
  public String uuid;
  public String videoPath;
  
  public boolean entityByCursor(Cursor paramCursor)
  {
    this.fakeVid = paramCursor.getString(paramCursor.getColumnIndex("fakeVid"));
    this.md5 = paramCursor.getString(paramCursor.getColumnIndex("md5"));
    this.uuid = paramCursor.getString(paramCursor.getColumnIndex("uuid"));
    this.videoPath = paramCursor.getString(paramCursor.getColumnIndex("videoPath"));
    this.messageInfos = paramCursor.getString(paramCursor.getColumnIndex("messageInfos"));
    this.uploadInfo = paramCursor.getString(paramCursor.getColumnIndex("uploadInfo"));
    this.syncToStory = paramCursor.getInt(paramCursor.getColumnIndex("syncToStory"));
    this.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    if (!TextUtils.isEmpty(this.uploadInfo)) {}
    try
    {
      this.uploadMessageData = new azbd();
      this.uploadMessageData.adN(this.uploadInfo);
      if (TextUtils.isEmpty(this.messageInfos)) {}
    }
    catch (IllegalArgumentException paramCursor)
    {
      for (;;)
      {
        try
        {
          this.messageDataList = azbd.bt(this.messageInfos);
          return true;
          paramCursor = paramCursor;
          paramCursor.printStackTrace();
        }
        catch (IllegalArgumentException paramCursor)
        {
          paramCursor.printStackTrace();
          continue;
        }
        this.messageDataList = new ArrayList();
      }
    }
  }
  
  public void removeMessageBaseData(MessageRecord paramMessageRecord)
  {
    if ((this.messageDataList == null) || (this.messageDataList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.messageDataList.iterator();
    while (localIterator.hasNext()) {
      if (((azbd)localIterator.next()).g(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq)) {
        localIterator.remove();
      }
    }
    this.messageInfos = azbd.listToString(this.messageDataList);
  }
  
  public void setMessageDataList(List<azbd> paramList)
  {
    this.messageDataList = paramList;
    this.messageInfos = azbd.listToString(paramList);
  }
  
  public void setUploadMessageData(azbd paramazbd)
  {
    this.uploadMessageData = paramazbd;
    this.uploadInfo = paramazbd.IE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.multisender.MultiSendEntry
 * JD-Core Version:    0.7.0.1
 */