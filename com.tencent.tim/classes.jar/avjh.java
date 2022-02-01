import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class avjh
{
  private static avjh a;
  public boolean dni;
  private ArrayList<avjh.a> ed = new ArrayList();
  
  public static avjh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avjh();
      }
      return a;
    }
    finally {}
  }
  
  public avjh.a a(long paramLong)
  {
    synchronized (this.ed)
    {
      if (this.ed.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QfavRequestQueue", 2, "pop, request list is empty");
        }
        return null;
      }
      Iterator localIterator = this.ed.iterator();
      while (localIterator.hasNext())
      {
        avjh.a locala = (avjh.a)localIterator.next();
        if (locala.mID == paramLong)
        {
          this.ed.remove(locala);
          if (QLog.isColorLevel()) {
            QLog.d("QfavRequestQueue", 2, "pop, id: " + paramLong + "pendingsize:" + this.ed.size());
          }
          return locala;
        }
      }
    }
    return null;
  }
  
  public byte[] aK()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.ed)
    {
      if (this.ed.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.ed.iterator();
      if (localIterator.hasNext()) {
        localArrayList1.add(((avjh.a)localIterator.next()).mIntent.getExtras());
      }
    }
    if (localArrayList2.isEmpty()) {
      return null;
    }
    ??? = new Bundle();
    ((Bundle)???).putParcelableArrayList("pendingData", localArrayList2);
    Parcel localParcel = Parcel.obtain();
    ((Bundle)???).writeToParcel(localParcel, 0);
    ??? = localParcel.marshall();
    localParcel.recycle();
    return ???;
  }
  
  public List<Bundle> d(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (Bundle)Bundle.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte.getParcelableArrayList("pendingData");
  }
  
  public boolean isEmpty()
  {
    synchronized (this.ed)
    {
      boolean bool = this.ed.isEmpty();
      return bool;
    }
  }
  
  static class a
  {
    public long mID;
    public Intent mIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avjh
 * JD-Core Version:    0.7.0.1
 */