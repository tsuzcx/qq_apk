import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.util.ArrayList;
import java.util.List;

public class pkx
{
  private static String asW = "0123456789bcdefghjkmnpqrstuvwxyz";
  private static final String[] bL = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
  
  public static List<pkx.a> K(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Error("Invalid geoHash");
    }
    paramString = paramString.toLowerCase();
    int i = 1;
    double d3 = -90.0D;
    double d4 = 90.0D;
    double d1 = -180.0D;
    double d2 = 180.0D;
    int j = 0;
    while (j < paramString.length())
    {
      int k = paramString.charAt(j);
      int m = asW.indexOf(k);
      if (m == -1) {
        throw new Error("Invalid geoHash");
      }
      k = 4;
      if (k >= 0)
      {
        double d6 = m >> k & 0x1;
        double d5;
        if (i != 0)
        {
          d5 = (d1 + d2) / 2.0D;
          if (d6 == 1.0D)
          {
            d1 = d5;
            label135:
            if (i != 0) {
              break label190;
            }
          }
        }
        label190:
        for (i = 1;; i = 0)
        {
          k -= 1;
          break;
          d2 = d5;
          break label135;
          d5 = (d3 + d4) / 2.0D;
          if (d6 == 1.0D)
          {
            d3 = d5;
            break label135;
          }
          d4 = d5;
          break label135;
        }
      }
      j += 1;
    }
    paramString = new pkx.a(d3, d1);
    pkx.a locala = new pkx.a(d4, d2);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(paramString);
    localArrayList.add(locala);
    return localArrayList;
  }
  
  public static String a(double paramDouble1, double paramDouble2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d5 = 90.0D;
    double d3 = -90.0D;
    double d2 = 0.0D;
    double d6 = 180.0D;
    double d4 = -180.0D;
    double d1 = 0.0D;
    int i = 1;
    int k = 0;
    while (k < paramInt)
    {
      int m = 0;
      int n = 0;
      int j = i;
      i = n;
      if (m < 5)
      {
        double d8;
        double d7;
        if (j != 0)
        {
          i <<= 1;
          if (paramDouble2 >= d1)
          {
            d8 = (d6 + d1) / 2.0D;
            i += 1;
            d4 = d6;
            d7 = d2;
            d2 = d3;
            d6 = d5;
            d5 = d7;
            d3 = d1;
            d1 = d8;
            label131:
            if (j != 0) {
              break label309;
            }
          }
        }
        label309:
        for (j = 1;; j = 0)
        {
          m += 1;
          d7 = d6;
          d8 = d2;
          d2 = d5;
          d6 = d4;
          d4 = d3;
          d3 = d8;
          d5 = d7;
          break;
          d8 = (d1 + d4) / 2.0D;
          d6 = d3;
          d7 = d5;
          d3 = d4;
          d4 = d1;
          d1 = d8;
          d5 = d2;
          d2 = d6;
          d6 = d7;
          break label131;
          i <<= 1;
          if (paramDouble1 >= d2)
          {
            d3 = (d5 + d2) / 2.0D;
            i += 1;
            d7 = d5;
            d5 = d3;
            d3 = d4;
            d4 = d6;
            d6 = d7;
            break label131;
          }
          d5 = (d2 + d3) / 2.0D;
          d7 = d2;
          d2 = d3;
          d3 = d4;
          d4 = d6;
          d6 = d7;
          break label131;
        }
      }
      localStringBuilder.append(bL[i]);
      k += 1;
      i = j;
    }
    return localStringBuilder.toString();
  }
  
  public static pkx.a a(String paramString)
  {
    Object localObject = K(paramString);
    pkx.a locala = (pkx.a)((List)localObject).get(0);
    localObject = (pkx.a)((List)localObject).get(1);
    double d3 = pkx.a.a(locala);
    double d1 = pkx.a.b(locala);
    double d4 = pkx.a.a((pkx.a)localObject);
    double d2 = pkx.a.b((pkx.a)localObject);
    d3 = (d3 + d4) / 2.0D;
    d1 = (d2 + d1) / 2.0D;
    locala = new pkx.a(d3, d1);
    ram.a("Q.qqstory.recommendAlbum.logic.decodeGeoHash", " geoHash=%s, lat=%s, lon=%s", paramString, Double.valueOf(d3), Double.valueOf(d1));
    return locala;
  }
  
  public static class a
  {
    private double lat;
    private double lng;
    
    public a(double paramDouble1, double paramDouble2)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
    }
    
    public qqstory_struct.GpsMsg a()
    {
      qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
      localGpsMsg.setHasFlag(true);
      localGpsMsg.lat.set((int)(getLat() * 1000000.0D));
      localGpsMsg.lng.set((int)(getLng() * 1000000.0D));
      return localGpsMsg;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      return (((a)paramObject).lat == this.lat) && (((a)paramObject).lng == this.lng);
    }
    
    public double getLat()
    {
      return this.lat;
    }
    
    public double getLng()
    {
      return this.lng;
    }
    
    public int hashCode()
    {
      return "Gps".hashCode() + (int)(this.lat * 1000000.0D) + (int)(this.lng * 1000000.0D);
    }
    
    public String toString()
    {
      return "Gps{lat=" + this.lat + ", lng=" + this.lng + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pkx
 * JD-Core Version:    0.7.0.1
 */