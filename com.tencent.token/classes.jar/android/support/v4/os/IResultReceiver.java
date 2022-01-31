package android.support.v4.os;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IResultReceiver
  extends IInterface
{
  public abstract void send(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.IResultReceiver
 * JD-Core Version:    0.7.0.1
 */