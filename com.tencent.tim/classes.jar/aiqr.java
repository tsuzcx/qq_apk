import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class aiqr
{
  private static String TAG = "LocationDataHandler";
  private final List<aiqr.a> CD = new ArrayList();
  private final Map<LocationRoom.b, LocationRoom> lz = new LinkedHashMap();
  private String mSelfUin;
  
  aiqr(String paramString)
  {
    this.mSelfUin = paramString;
  }
  
  public LocationRoom a(LocationRoom.b paramb)
  {
    synchronized (this.lz)
    {
      LocationRoom localLocationRoom2 = (LocationRoom)this.lz.get(paramb);
      LocationRoom localLocationRoom1 = localLocationRoom2;
      if (localLocationRoom2 == null)
      {
        localLocationRoom1 = new LocationRoom(paramb, this.mSelfUin);
        this.lz.put(paramb, localLocationRoom1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getLocationRoom: invoked. mLocationRoomMap size: " + this.lz.size() + " locationRoom: " + localLocationRoom1);
      }
      return localLocationRoom1;
    }
  }
  
  public void a(aiqr.a parama)
  {
    synchronized (this.CD)
    {
      this.CD.remove(parama);
      return;
    }
  }
  
  public void b(aiqr.a parama)
  {
    synchronized (this.CD)
    {
      if (!this.CD.contains(parama)) {
        this.CD.add(parama);
      }
      return;
    }
  }
  
  void b(LocationRoom.b paramb)
  {
    synchronized (this.lz)
    {
      paramb = (LocationRoom)this.lz.get(paramb);
      if ((paramb != null) && (paramb.a() != null)) {
        paramb.a().dtM();
      }
      return;
    }
  }
  
  void b(LocationRoom.b paramb, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.CD.iterator();
    while (localIterator.hasNext()) {
      ((aiqr.a)localIterator.next()).a(paramb, paramInt1, paramInt2);
    }
  }
  
  void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList)
  {
    LocationRoom localLocationRoom = a(paramb);
    localLocationRoom.setVenue(paramVenue);
    localLocationRoom.li(paramList);
    paramList = this.CD.iterator();
    while (paramList.hasNext()) {
      ((aiqr.a)paramList.next()).a(paramb, paramVenue, localLocationRoom.fs());
    }
  }
  
  void c(LocationRoom.b paramb, int paramInt)
  {
    if (this.lz.containsKey(paramb)) {
      synchronized (this.lz)
      {
        this.lz.remove(paramb);
        ??? = this.CD.iterator();
        if (((Iterator)???).hasNext()) {
          ((aiqr.a)((Iterator)???).next()).b(paramb, paramInt);
        }
      }
    }
  }
  
  public void clear()
  {
    synchronized (this.lz)
    {
      this.lz.clear();
      return;
    }
  }
  
  void d(LocationRoom.b paramb, int paramInt)
  {
    synchronized (this.lz)
    {
      this.lz.remove(paramb);
      ??? = this.CD.iterator();
      if (((Iterator)???).hasNext()) {
        ((aiqr.a)((Iterator)???).next()).a(paramb, paramInt);
      }
    }
  }
  
  void dj(int paramInt, String paramString)
  {
    paramString = new LocationRoom.b(paramInt, paramString);
    LocationRoom localLocationRoom = a(paramString);
    if (localLocationRoom != null)
    {
      Iterator localIterator = this.CD.iterator();
      while (localIterator.hasNext()) {
        ((aiqr.a)localIterator.next()).a(paramString, localLocationRoom.a(), localLocationRoom.fs());
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(LocationRoom.b paramb, int paramInt);
    
    public abstract void a(LocationRoom.b paramb, int paramInt1, int paramInt2);
    
    public abstract void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue, List<aiqn> paramList);
    
    public abstract void b(LocationRoom.b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqr
 * JD-Core Version:    0.7.0.1
 */