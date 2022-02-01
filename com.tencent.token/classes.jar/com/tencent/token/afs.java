package com.tencent.token;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.support.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class afs
  implements afw
{
  @Deprecated
  protected HashMap<Long, Map<String, Object>> a = new HashMap();
  protected int b = -1;
  @Deprecated
  protected int c = -1;
  @Deprecated
  protected Long d = null;
  protected boolean e;
  protected ContentResolver f;
  final Object g = new Object();
  final ContentObservable h = new ContentObservable();
  private Uri i;
  private ContentObserver j;
  private boolean k;
  private final DataSetObservable l = new DataSetObservable();
  private Bundle m = Bundle.EMPTY;
  
  protected void a()
  {
    ContentObserver localContentObserver = this.j;
    if (localContentObserver != null)
    {
      this.f.unregisterContentObserver(localContentObserver);
      this.k = false;
    }
    this.l.notifyInvalidated();
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  protected void b()
  {
    if ((-1 != this.b) && (getCount() != this.b)) {
      return;
    }
    throw new CursorIndexOutOfBoundsException(this.b, getCount());
  }
  
  public void close()
  {
    this.e = true;
    this.h.unregisterAll();
    a();
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
    a();
  }
  
  protected void finalize()
  {
    ContentObserver localContentObserver = this.j;
    if ((localContentObserver != null) && (this.k == true)) {
      this.f.unregisterContentObserver(localContentObserver);
    }
    try
    {
      if (!this.e) {
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
    int i1 = paramString.lastIndexOf('.');
    int n = 0;
    Object localObject = paramString;
    if (i1 != -1)
    {
      localObject = new Exception();
      Log.a("Cursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
      localObject = paramString.substring(i1 + 1);
    }
    paramString = getColumnNames();
    i1 = paramString.length;
    while (n < i1)
    {
      if (paramString[n].equalsIgnoreCase((String)localObject)) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int n = getColumnIndex(paramString);
    if (n >= 0) {
      return n;
    }
    StringBuilder localStringBuilder = new StringBuilder("column '");
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
  
  public Bundle getExtras()
  {
    return this.m;
  }
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return this.i;
  }
  
  public final int getPosition()
  {
    return this.b;
  }
  
  public abstract String getString(int paramInt);
  
  public int getType(int paramInt)
  {
    return 3;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public final boolean isAfterLast()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.b == getCount();
  }
  
  public final boolean isBeforeFirst()
  {
    if (getCount() == 0) {
      return true;
    }
    return this.b == -1;
  }
  
  public boolean isClosed()
  {
    return this.e;
  }
  
  public final boolean isFirst()
  {
    return (this.b == 0) && (getCount() != 0);
  }
  
  public final boolean isLast()
  {
    int n = getCount();
    return (this.b == n - 1) && (n != 0);
  }
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(this.b + paramInt);
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
    return moveToPosition(this.b + 1);
  }
  
  public boolean moveToPosition(int paramInt)
  {
    int n = getCount();
    if (paramInt >= n)
    {
      this.b = n;
      return false;
    }
    if (paramInt < 0)
    {
      this.b = -1;
      return false;
    }
    if (paramInt == this.b) {
      return true;
    }
    a(paramInt);
    this.b = paramInt;
    paramInt = this.c;
    if (paramInt != -1) {
      this.d = Long.valueOf(getLong(paramInt));
    }
    return true;
  }
  
  public final boolean moveToPrevious()
  {
    return moveToPosition(this.b - 1);
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.h.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.l.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    ContentObserver localContentObserver = this.j;
    if ((localContentObserver != null) && (!this.k))
    {
      this.f.registerContentObserver(this.i, true, localContentObserver);
      this.k = true;
    }
    this.l.notifyChanged();
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
    this.m = localBundle;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    synchronized (this.g)
    {
      this.i = paramUri;
      this.f = paramContentResolver;
      if (this.j != null) {
        this.f.unregisterContentObserver(this.j);
      }
      this.j = new a(this);
      this.f.registerContentObserver(this.i, true, this.j);
      this.k = true;
      return;
    }
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!this.e) {
      this.h.unregisterObserver(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.l.unregisterObserver(paramDataSetObserver);
  }
  
  public static final class a
    extends ContentObserver
  {
    WeakReference<afs> a;
    
    public a(afs paramafs)
    {
      super();
      this.a = new WeakReference(paramafs);
    }
    
    public final boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      afs localafs = (afs)this.a.get();
      if (localafs != null) {
        synchronized (localafs.g)
        {
          localafs.h.dispatchChange(false);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afs
 * JD-Core Version:    0.7.0.1
 */