package wf7;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface gn
  extends IInterface
{
  public abstract IBinder P(String paramString)
    throws RemoteException;
  
  public abstract IBinder Q(String paramString)
    throws RemoteException;
  
  public abstract void a(String paramString, IBinder paramIBinder, boolean paramBoolean)
    throws RemoteException;
  
  public abstract String[] eY()
    throws RemoteException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gn
 * JD-Core Version:    0.7.0.1
 */