package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor
  implements CrossProcessCursor
{
  private static final String TAG = "Cursor";
  protected boolean mClosed;
  private final ContentObservable mContentObservable = new ContentObservable();
  protected ContentResolver mContentResolver;
  @Deprecated
  protected Long mCurrentRowID = null;
  private final DataSetObservable mDataSetObservable = new DataSetObservable();
  private Bundle mExtras = Bundle.EMPTY;
  private Uri mNotifyUri;
  protected int mPos = -1;
  @Deprecated
  protected int mRowIdColumnIndex = -1;
  private ContentObserver mSelfObserver;
  private final Object mSelfObserverLock = new Object();
  private boolean mSelfObserverRegistered;
  @Deprecated
  protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();
  
  protected void checkPosition()
  {
    if ((-1 != this.mPos) && (getCount() != this.mPos)) {
      return;
    }
    throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
  }
  
  public void close()
  {
    this.mClosed = true;
    this.mContentObservable.unregisterAll();
    onDeactivateOrClose();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    String str = getString(paramInt);
    if (str != null)
    {
      char[] arrayOfChar = paramCharArrayBuffer.data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= str.length())) {
        str.getChars(0, str.length(), arrayOfChar, 0);
      } else {
        paramCharArrayBuffer.data = str.toCharArray();
      }
      paramCharArrayBuffer.sizeCopied = str.length();
      return;
    }
    paramCharArrayBuffer.sizeCopied = 0;
  }
  
  public void deactivate()
  {
    onDeactivateOrClose();
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    DatabaseUtils.cursorFillWindow(this, paramInt, paramCursorWindow);
  }
  
  protected void finalize()
  {
    ContentObserver localContentObserver = this.mSelfObserver;
    if ((localContentObserver != null) && (this.mSelfObserverRegistered == true)) {
      this.mContentResolver.unregisterContentObserver(localContentObserver);
    }
    try
    {
      if (!this.mClosed) {
        close();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }
  
  public int getColumnCount()
  {
    return getColumnNames().length;
  }
  
  public int getColumnIndex(String paramString)
  {
    int j = paramString.lastIndexOf('.');
    int i = 0;
    Object localObject = paramString;
    if (j != -1)
    {
      localObject = new Exception();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requesting column name with table name -- ");
      localStringBuilder.append(paramString);
      Log.e("Cursor", localStringBuilder.toString(), new Object[] { localObject });
      localObject = paramString.substring(j + 1);
    }
    paramString = getColumnNames();
    j = paramString.length;
    while (i < j)
    {
      if (paramString[i].equalsIgnoreCase((String)localObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int i = getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("column '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("' does not exist");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  public abstract double getDouble(int paramInt);
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public abstract float getFloat(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return this.mNotifyUri;
  }
  
  public final int getPosition()
  {
    return this.mPos;
  }
  
  public abstract short getShort(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public int getType(int paramInt)
  {
    return 3;
  }
  
  @Deprecated
  protected Object getUpdatedField(int paramInt)
  {
    return null;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public final boolean isAfterLast()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.mPos == getCount();
  }
  
  public final boolean isBeforeFirst()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.mPos == -1;
  }
  
  public boolean isClosed()
  {
    return this.mClosed;
  }
  
  @Deprecated
  protected boolean isFieldUpdated(int paramInt)
  {
    return false;
  }
  
  public final boolean isFirst()
  {
    return (this.mPos == 0) && (getCount() != 0);
  }
  
  public final boolean isLast()
  {
    int i = getCount();
    return (this.mPos == i - 1) && (i != 0);
  }
  
  public abstract boolean isNull(int paramInt);
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(this.mPos + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public final boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public final boolean moveToNext()
  {
    return moveToPosition(this.mPos + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int i = getCount();
    if (paramInt >= i)
    {
      this.mPos = i;
      return false;
    }
    if (paramInt < 0)
    {
      this.mPos = -1;
      return false;
    }
    i = this.mPos;
    if (paramInt == i) {
      return true;
    }
    boolean bool = onMove(i, paramInt);
    if (!bool)
    {
      this.mPos = -1;
      return bool;
    }
    this.mPos = paramInt;
    paramInt = this.mRowIdColumnIndex;
    if (paramInt != -1) {
      this.mCurrentRowID = Long.valueOf(getLong(paramInt));
    }
    return bool;
  }
  
  public final boolean moveToPrevious()
  {
    return moveToPosition(this.mPos - 1);
  }
  
  protected void onChange(boolean paramBoolean)
  {
    synchronized (this.mSelfObserverLock)
    {
      this.mContentObservable.dispatchChange(paramBoolean);
      if ((this.mNotifyUri != null) && (paramBoolean)) {
        this.mContentResolver.notifyChange(this.mNotifyUri, this.mSelfObserver);
      }
      return;
    }
  }
  
  protected void onDeactivateOrClose()
  {
    ContentObserver localContentObserver = this.mSelfObserver;
    if (localContentObserver != null)
    {
      this.mContentResolver.unregisterContentObserver(localContentObserver);
      this.mSelfObserverRegistered = false;
    }
    this.mDataSetObservable.notifyInvalidated();
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.mContentObservable.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    ContentObserver localContentObserver = this.mSelfObserver;
    if ((localContentObserver != null) && (!this.mSelfObserverRegistered))
    {
      this.mContentResolver.registerContentObserver(this.mNotifyUri, true, localContentObserver);
      this.mSelfObserverRegistered = true;
    }
    this.mDataSetObservable.notifyChanged();
    return true;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = Bundle.EMPTY;
    }
    this.mExtras = localBundle;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    synchronized (this.mSelfObserverLock)
    {
      this.mNotifyUri = paramUri;
      this.mContentResolver = paramContentResolver;
      if (this.mSelfObserver != null) {
        this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
      }
      this.mSelfObserver = new SelfContentObserver(this);
      this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
      this.mSelfObserverRegistered = true;
      return;
    }
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!this.mClosed) {
      this.mContentObservable.unregisterObserver(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
  
  protected static class SelfContentObserver
    extends ContentObserver
  {
    WeakReference<AbstractCursor> mCursor;
    
    public SelfContentObserver(AbstractCursor paramAbstractCursor)
    {
      super();
      this.mCursor = new WeakReference(paramAbstractCursor);
    }
    
    public boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public void onChange(boolean paramBoolean)
    {
      AbstractCursor localAbstractCursor = (AbstractCursor)this.mCursor.get();
      if (localAbstractCursor != null) {
        localAbstractCursor.onChange(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.AbstractCursor
 * JD-Core Version:    0.7.0.1
 */