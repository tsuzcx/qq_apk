package com.tencent.qqmail.model.uidomain;

import android.database.Cursor;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMNNote;
import com.tencent.qqmail.model.qmdomain.QMNNoteCategory;
import com.tencent.qqmail.model.qmdomain.QMNNoteInformation;
import com.tencent.qqmail.model.qmdomain.QMNoteAttachList;
import com.tencent.qqmail.utilities.json.JSONReader;
import java.util.ArrayList;
import java.util.HashMap;

public class NoteUI
{
  private static final boolean OPEN_MEMORY = true;
  private final int abs_index;
  private final String[] abstractMemory;
  private final int attachList_index;
  private final int attachType_index;
  private final int audio_index;
  private final int catId_index;
  private final String[] catalogIdMemory;
  private final int content_index;
  private final int createTime_index;
  private final HashMap<String, String> mCategoryCache;
  private final int mCount;
  private final Cursor mCursor;
  private boolean mServerSearch = true;
  private final String[] noteidMemory;
  private final int noteid_index;
  private final int read_index;
  private final int sequence_index;
  private final Boolean[] starredMemory;
  private final int starred_index;
  private final int status_index;
  private final String[] subjectMemory;
  private final int subject_index;
  private final String[] thumbUrlMemory;
  private final int thumbUrl_index;
  private final Double[] updateTimeMemory;
  private final int updateTime_index;
  
  public NoteUI(Cursor paramCursor, HashMap<String, String> paramHashMap)
  {
    if (paramCursor == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    if (paramHashMap == null) {
      throw new IllegalArgumentException("cannot be not null");
    }
    this.mCursor = paramCursor;
    this.mCategoryCache = paramHashMap;
    this.noteid_index = paramCursor.getColumnIndex("id");
    this.subject_index = paramCursor.getColumnIndex("subject");
    this.abs_index = paramCursor.getColumnIndex("abstract");
    this.catId_index = paramCursor.getColumnIndex("catId");
    this.createTime_index = paramCursor.getColumnIndex("createTime");
    this.updateTime_index = paramCursor.getColumnIndex("updateTime");
    this.starred_index = paramCursor.getColumnIndex("starred");
    this.content_index = paramCursor.getColumnIndex("content");
    this.read_index = paramCursor.getColumnIndex("read");
    this.sequence_index = paramCursor.getColumnIndex("sequence");
    this.status_index = paramCursor.getColumnIndex("status");
    this.thumbUrl_index = paramCursor.getColumnIndex("thumbUrl");
    this.attachType_index = paramCursor.getColumnIndex("attachType");
    this.attachList_index = paramCursor.getColumnIndex("attachList");
    this.audio_index = paramCursor.getColumnIndex("audio");
    this.mCount = paramCursor.getCount();
    this.noteidMemory = new String[this.mCount];
    this.subjectMemory = new String[this.mCount];
    this.abstractMemory = new String[this.mCount];
    this.catalogIdMemory = new String[this.mCount];
    this.updateTimeMemory = new Double[this.mCount];
    this.starredMemory = new Boolean[this.mCount];
    this.thumbUrlMemory = new String[this.mCount];
  }
  
  public void close()
  {
    if (!this.mCursor.isClosed()) {
      this.mCursor.close();
    }
  }
  
  protected void finalize()
  {
    close();
  }
  
  public String getAbstract()
  {
    int i = this.mCursor.getPosition();
    if (this.abstractMemory[i] == null) {
      this.abstractMemory[i] = this.mCursor.getString(this.abs_index);
    }
    return this.abstractMemory[i];
  }
  
  public QMNoteAttachList getAttachList()
  {
    String str = new String(this.mCursor.getBlob(this.attachList_index));
    QMNoteAttachList localQMNoteAttachList = new QMNoteAttachList();
    localQMNoteAttachList.parseWithDictionary((JSONObject)JSONReader.parse(str));
    return localQMNoteAttachList;
  }
  
  public String getAttachType()
  {
    return this.mCursor.getString(this.attachType_index);
  }
  
  public String getAudio()
  {
    return this.mCursor.getString(this.audio_index);
  }
  
  public String getCatalogId()
  {
    int i = this.mCursor.getPosition();
    if (this.catalogIdMemory[i] == null) {
      this.catalogIdMemory[i] = this.mCursor.getString(this.catId_index);
    }
    return this.catalogIdMemory[i];
  }
  
  public String getCatalogName()
  {
    return (String)this.mCategoryCache.get(getCatalogId());
  }
  
  public String getContent()
  {
    return this.mCursor.getString(this.content_index);
  }
  
  public double getCreateTime()
  {
    return this.mCursor.getDouble(this.createTime_index);
  }
  
  public String getNoteId()
  {
    int i = this.mCursor.getPosition();
    if (this.noteidMemory[i] == null) {
      this.noteidMemory[i] = this.mCursor.getString(this.noteid_index);
    }
    return this.noteidMemory[i];
  }
  
  public boolean getReaded()
  {
    return this.mCursor.getLong(this.read_index) != 0L;
  }
  
  public double getSequence()
  {
    return this.mCursor.getDouble(this.sequence_index);
  }
  
  public boolean getServerSearch()
  {
    return this.mServerSearch;
  }
  
  public boolean getStarred()
  {
    int i = this.mCursor.getPosition();
    Boolean[] arrayOfBoolean;
    if (this.starredMemory[i] == null)
    {
      arrayOfBoolean = this.starredMemory;
      if (this.mCursor.getLong(this.starred_index) == 0L) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      arrayOfBoolean[i] = Boolean.valueOf(bool);
      return this.starredMemory[i].booleanValue();
    }
  }
  
  public int getStatus()
  {
    return (int)this.mCursor.getLong(this.status_index);
  }
  
  public String getSubject()
  {
    int i = this.mCursor.getPosition();
    if (this.subjectMemory[i] == null) {
      this.subjectMemory[i] = this.mCursor.getString(this.subject_index);
    }
    return this.subjectMemory[i];
  }
  
  public String getThumbUrl()
  {
    int i = this.mCursor.getPosition();
    if (this.thumbUrlMemory[i] == null) {
      this.thumbUrlMemory[i] = this.mCursor.getString(this.thumbUrl_index);
    }
    return this.thumbUrlMemory[i];
  }
  
  public double getUpdatetime()
  {
    int i = this.mCursor.getPosition();
    if (this.updateTimeMemory[i] == null) {
      this.updateTimeMemory[i] = Double.valueOf(this.mCursor.getDouble(this.updateTime_index));
    }
    return this.updateTimeMemory[i].doubleValue();
  }
  
  public boolean isClosed()
  {
    return this.mCursor.isClosed();
  }
  
  public boolean moveToPosition(int paramInt)
  {
    return this.mCursor.moveToPosition(paramInt);
  }
  
  public int position()
  {
    return this.mCursor.getPosition();
  }
  
  public void setSeverSearch(boolean paramBoolean)
  {
    this.mServerSearch = paramBoolean;
  }
  
  public int size()
  {
    return this.mCount;
  }
  
  public QMNNote toNote()
  {
    QMNNote localQMNNote = new QMNNote();
    localQMNNote.attachList = getAttachList();
    localQMNNote.information.noteId = getNoteId();
    localQMNNote.information.subject = getSubject();
    localQMNNote.information.abs = getAbstract();
    localQMNNote.information.category.setCatalogId(getCatalogId());
    localQMNNote.information.category.setCatalogName(getCatalogName());
    localQMNNote.information.thumbURL = getThumbUrl();
    localQMNNote.information.attachType = getAttachType();
    localQMNNote.information.audio = getAudio();
    localQMNNote.status.createUTC = getCreateTime();
    localQMNNote.status.updateUTC = getUpdatetime();
    localQMNNote.status.starred = getStarred();
    localQMNNote.status.status = getStatus();
    localQMNNote.status.sequence = getSequence();
    localQMNNote.content = getContent();
    localQMNNote.read = getReaded();
    return localQMNNote;
  }
  
  public ArrayList<String> toNoteIds()
  {
    int j = this.mCursor.getPosition();
    ArrayList localArrayList = new ArrayList(this.mCount);
    int i = 0;
    while (i < this.mCount)
    {
      this.mCursor.moveToPosition(i);
      localArrayList.add(getNoteId());
      i += 1;
    }
    this.mCursor.moveToPosition(j);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.uidomain.NoteUI
 * JD-Core Version:    0.7.0.1
 */