package com.tencent.qqmail.ftn.model;

import android.database.Cursor;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.QMFtnSQLite;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.HashMap;

public class FtnUI
{
  public static final int SORT_EXPIRE = 3;
  public static final int SORT_FILE_TYPE = 4;
  public static final int SORT_NAME = 2;
  public static final int SORT_UPLOAD = 1;
  private HashMap<Integer, FileInfo> mCache = new HashMap();
  public Cursor mHeadCursor = null;
  public Cursor mItemCursor = null;
  
  public FtnUI(Cursor paramCursor1, Cursor paramCursor2)
  {
    this.mHeadCursor = paramCursor1;
    this.mItemCursor = paramCursor2;
  }
  
  private FileInfo getItem(int paramInt)
  {
    this.mItemCursor.moveToPosition(paramInt);
    return QMFtnSQLite.fillFileInfo(this.mItemCursor);
  }
  
  public FileInfo get(int paramInt)
  {
    FileInfo localFileInfo = (FileInfo)this.mCache.get(Integer.valueOf(paramInt));
    if (localFileInfo != null) {
      return localFileInfo;
    }
    if (this.mItemCursor == null) {
      return null;
    }
    try
    {
      localFileInfo = getItem(paramInt);
      this.mCache.put(Integer.valueOf(paramInt), localFileInfo);
      return localFileInfo;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      localIndexOutOfBoundsException.printStackTrace();
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.mItemCursor != null) {
      return this.mItemCursor.getCount();
    }
    return 0;
  }
  
  public FileInfo getItemByFid(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {}
    while (!this.mItemCursor.moveToFirst()) {
      return null;
    }
    do
    {
      FileInfo localFileInfo = QMFtnSQLite.fillFileInfo(this.mItemCursor);
      if (localFileInfo.fid.equals(paramString)) {
        return localFileInfo;
      }
    } while (this.mItemCursor.moveToNext());
    return null;
  }
  
  public void release()
  {
    if ((this.mHeadCursor != null) && (!this.mHeadCursor.isClosed()))
    {
      this.mHeadCursor.close();
      this.mHeadCursor = null;
    }
    if ((this.mItemCursor != null) && (!this.mItemCursor.isClosed()))
    {
      this.mItemCursor.close();
      this.mItemCursor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.model.FtnUI
 * JD-Core Version:    0.7.0.1
 */