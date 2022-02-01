package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.token.dr;
import com.tencent.token.dr.a;

public class ResultReceiver
  implements Parcelable
{
  public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator() {};
  final boolean a = false;
  final Handler b = null;
  dr c;
  
  ResultReceiver(Parcel paramParcel)
  {
    this.c = dr.a.a(paramParcel.readStrongBinder());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      if (this.c == null) {
        this.c = new a();
      }
      paramParcel.writeStrongBinder(this.c.asBinder());
      return;
    }
    finally {}
  }
  
  final class a
    extends dr.a
  {
    a() {}
    
    public final void a(int paramInt, Bundle paramBundle)
    {
      if (ResultReceiver.this.b != null) {
        ResultReceiver.this.b.post(new ResultReceiver.b(ResultReceiver.this, paramInt, paramBundle));
      }
    }
  }
  
  final class b
    implements Runnable
  {
    final int a;
    final Bundle b;
    
    b(int paramInt, Bundle paramBundle)
    {
      this.a = paramInt;
      this.b = paramBundle;
    }
    
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.os.ResultReceiver
 * JD-Core Version:    0.7.0.1
 */