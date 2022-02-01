package cooperation.qzone.statistic.serverip;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import awbp;
import common.config.service.QzoneConfig;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class WebAppIpRecord
  implements Parcelable
{
  public static final Parcelable.Creator<WebAppIpRecord> CREATOR = new awbp();
  public FixedSizeLinkedHashMap<Integer, Long> a;
  public long aAI;
  
  public WebAppIpRecord() {}
  
  public WebAppIpRecord(Parcel paramParcel)
  {
    this.aAI = paramParcel.readLong();
    paramParcel = paramParcel.readHashMap(getClass().getClassLoader());
    this.a = new FixedSizeLinkedHashMap();
    this.a.putAll(paramParcel);
  }
  
  public void ack(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (this.a == null) {
      this.a = new FixedSizeLinkedHashMap();
    }
    this.a.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.aAI);
    paramParcel.writeMap(this.a);
  }
  
  public static class FixedSizeLinkedHashMap<K, V>
    extends LinkedHashMap<K, V>
  {
    private static int ezP = QzoneConfig.getInstance().getConfig("QZoneSetting", "LatestWebappIPCount", 3);
    private static final long serialVersionUID = 6918023506928428613L;
    
    public static int getMAX_ENTRIES()
    {
      return ezP;
    }
    
    public static void setMAX_ENTRIES(int paramInt)
    {
      ezP = paramInt;
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > ezP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpRecord
 * JD-Core Version:    0.7.0.1
 */