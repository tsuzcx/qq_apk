import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBInt32Field;

public class uke
{
  private double a;
  private double b;
  
  public uke(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }
  
  public double a()
  {
    return this.a;
  }
  
  public qqstory_struct.GpsMsg a()
  {
    qqstory_struct.GpsMsg localGpsMsg = new qqstory_struct.GpsMsg();
    localGpsMsg.setHasFlag(true);
    localGpsMsg.lat.set((int)(a() * 1000000.0D));
    localGpsMsg.lng.set((int)(b() * 1000000.0D));
    return localGpsMsg;
  }
  
  public double b()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof uke)) {
      return false;
    }
    return (((uke)paramObject).a == this.a) && (((uke)paramObject).b == this.b);
  }
  
  public int hashCode()
  {
    return "Gps".hashCode() + (int)(this.a * 1000000.0D) + (int)(this.b * 1000000.0D);
  }
  
  public String toString()
  {
    return "Gps{lat=" + this.a + ", lng=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uke
 * JD-Core Version:    0.7.0.1
 */