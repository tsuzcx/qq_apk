package com.tencent.kingkong;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IBulkCursor
  extends IInterface
{
  public static final int CLOSE_TRANSACTION = 7;
  public static final int DEACTIVATE_TRANSACTION = 2;
  public static final int GET_CURSOR_WINDOW_TRANSACTION = 1;
  public static final int GET_EXTRAS_TRANSACTION = 5;
  public static final int ON_MOVE_TRANSACTION = 4;
  public static final int REQUERY_TRANSACTION = 3;
  public static final int RESPOND_TRANSACTION = 6;
  public static final String descriptor = "android.content.IBulkCursor";
  
  public abstract void close()
    throws RemoteException;
  
  public abstract void deactivate()
    throws RemoteException;
  
  public abstract Bundle getExtras()
    throws RemoteException;
  
  public abstract CursorWindow getWindow(int paramInt)
    throws RemoteException;
  
  public abstract void onMove(int paramInt)
    throws RemoteException;
  
  public abstract int requery(IContentObserver paramIContentObserver)
    throws RemoteException;
  
  public abstract Bundle respond(Bundle paramBundle)
    throws RemoteException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.IBulkCursor
 * JD-Core Version:    0.7.0.1
 */