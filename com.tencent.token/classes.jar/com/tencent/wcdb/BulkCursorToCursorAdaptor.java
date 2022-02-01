package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.wcdb.support.Log;
import java.lang.reflect.Method;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private static final String TAG = "BulkCursor";
  private IBulkCursor mBulkCursor;
  private String[] mColumns;
  private int mCount;
  private AbstractCursor.SelfContentObserver mObserverBridge = new AbstractCursor.SelfContentObserver(this);
  private boolean mWantsAllOnMoveCalls;
  
  private void throwIfCursorIsClosed()
  {
    if (this.mBulkCursor != null) {
      return;
    }
    throw new StaleDataException("Attempted to access a cursor after it has been closed.");
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 45	com/tencent/wcdb/AbstractWindowedCursor:close	()V
    //   4: aload_0
    //   5: getfield 33	com/tencent/wcdb/BulkCursorToCursorAdaptor:mBulkCursor	Lcom/tencent/wcdb/IBulkCursor;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnull +36 -> 46
    //   13: aload_1
    //   14: invokeinterface 48 1 0
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 33	com/tencent/wcdb/BulkCursorToCursorAdaptor:mBulkCursor	Lcom/tencent/wcdb/IBulkCursor;
    //   24: return
    //   25: astore_1
    //   26: goto +13 -> 39
    //   29: ldc 8
    //   31: ldc 50
    //   33: invokestatic 56	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: goto -17 -> 19
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 33	com/tencent/wcdb/BulkCursorToCursorAdaptor:mBulkCursor	Lcom/tencent/wcdb/IBulkCursor;
    //   44: aload_1
    //   45: athrow
    //   46: return
    //   47: astore_1
    //   48: goto -19 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	BulkCursorToCursorAdaptor
    //   8	6	1	localIBulkCursor	IBulkCursor
    //   25	20	1	localObject	Object
    //   47	1	1	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   13	19	25	finally
    //   29	36	25	finally
    //   13	19	47	android/os/RemoteException
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    IBulkCursor localIBulkCursor = this.mBulkCursor;
    if (localIBulkCursor != null) {}
    try
    {
      localIBulkCursor.deactivate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      label20:
      break label20;
    }
    Log.w("BulkCursor", "Remote process exception when deactivating");
  }
  
  public String[] getColumnNames()
  {
    throwIfCursorIsClosed();
    return this.mColumns;
  }
  
  public int getCount()
  {
    throwIfCursorIsClosed();
    return this.mCount;
  }
  
  public Bundle getExtras()
  {
    throwIfCursorIsClosed();
    try
    {
      Bundle localBundle = this.mBulkCursor.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public IContentObserver getObserver()
  {
    try
    {
      IContentObserver localIContentObserver = (IContentObserver)this.mObserverBridge.getClass().getMethod("getContentObserver", new Class[0]).invoke(this.mObserverBridge, new Object[0]);
      return localIContentObserver;
    }
    catch (Exception localException)
    {
      label33:
      break label33;
    }
    return null;
  }
  
  public void initialize(BulkCursorDescriptor paramBulkCursorDescriptor)
  {
    this.mBulkCursor = paramBulkCursorDescriptor.cursor;
    this.mColumns = paramBulkCursorDescriptor.columnNames;
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    this.mWantsAllOnMoveCalls = paramBulkCursorDescriptor.wantsAllOnMoveCalls;
    this.mCount = paramBulkCursorDescriptor.count;
    if (paramBulkCursorDescriptor.window != null) {
      setWindow(paramBulkCursorDescriptor.window);
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    throwIfCursorIsClosed();
    try
    {
      if ((this.mWindow != null) && (paramInt2 >= this.mWindow.getStartPosition()) && (paramInt2 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()))
      {
        if (this.mWantsAllOnMoveCalls) {
          this.mBulkCursor.onMove(paramInt2);
        }
      }
      else {
        setWindow(this.mBulkCursor.getWindow(paramInt2));
      }
      return this.mWindow != null;
    }
    catch (RemoteException localRemoteException)
    {
      label89:
      break label89;
    }
    Log.e("BulkCursor", "Unable to get window because the remote process is dead");
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    throwIfCursorIsClosed();
    try
    {
      this.mCount = this.mBulkCursor.requery(getObserver());
      if (this.mCount != -1)
      {
        this.mPos = -1;
        closeWindow();
        super.requery();
        return true;
      }
      deactivate();
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to requery because the remote process exception ");
      localStringBuilder.append(localException.getMessage());
      Log.e("BulkCursor", localStringBuilder.toString());
      deactivate();
    }
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throwIfCursorIsClosed();
    try
    {
      paramBundle = this.mBulkCursor.respond(paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", new Object[] { paramBundle });
    }
    return Bundle.EMPTY;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorToCursorAdaptor
 * JD-Core Version:    0.7.0.1
 */