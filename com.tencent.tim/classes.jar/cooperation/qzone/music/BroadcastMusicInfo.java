package cooperation.qzone.music;

import NS_NEXTRADIO_QZONEBGMUSIC.BroadcastForQzone;
import acfp;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import avvm;
import com.tencent.mobileqq.music.SongInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BroadcastMusicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BroadcastMusicInfo> CREATOR = new avvm();
  public BroadcastAudio broadcastAudioUrl;
  public String broadcastID = "";
  public String broadcastName = "";
  public String detailUrl = "";
  public ArrayList<BroadcastOneShow> showList;
  
  public BroadcastMusicInfo() {}
  
  public BroadcastMusicInfo(Parcel paramParcel)
  {
    this.broadcastID = paramParcel.readString();
    this.broadcastName = paramParcel.readString();
    this.detailUrl = paramParcel.readString();
    this.broadcastAudioUrl = ((BroadcastAudio)paramParcel.readParcelable(BroadcastAudio.class.getClassLoader()));
    this.showList = paramParcel.readArrayList(BroadcastOneShow.class.getClassLoader());
  }
  
  public static BroadcastMusicInfo createFromJce(BroadcastForQzone paramBroadcastForQzone)
  {
    BroadcastMusicInfo localBroadcastMusicInfo = new BroadcastMusicInfo();
    localBroadcastMusicInfo.broadcastID = paramBroadcastForQzone.broadcastID;
    localBroadcastMusicInfo.broadcastName = paramBroadcastForQzone.broadcastName;
    localBroadcastMusicInfo.broadcastAudioUrl = BroadcastAudio.createFromJce(paramBroadcastForQzone.broadcastAudioUrl);
    localBroadcastMusicInfo.showList = new ArrayList();
    if (paramBroadcastForQzone.showList != null)
    {
      paramBroadcastForQzone = paramBroadcastForQzone.showList.iterator();
      while (paramBroadcastForQzone.hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.createFromJce((NS_NEXTRADIO_QZONEBGMUSIC.BroadcastOneShow)paramBroadcastForQzone.next());
        localBroadcastMusicInfo.showList.add(localBroadcastOneShow);
      }
    }
    return localBroadcastMusicInfo;
  }
  
  public static BroadcastMusicInfo createFromJsonString(String paramString)
  {
    localBroadcastMusicInfo = new BroadcastMusicInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localBroadcastMusicInfo.broadcastID = paramString.optString("broadcastID");
      localBroadcastMusicInfo.broadcastName = paramString.optString("broadcastName");
      localBroadcastMusicInfo.detailUrl = paramString.optString("detailUrl");
      localBroadcastMusicInfo.broadcastAudioUrl = BroadcastAudio.createFromJsonString(paramString.getString("broadcastAudioUrl"));
      paramString = paramString.getJSONArray("showList");
      localBroadcastMusicInfo.showList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BroadcastOneShow localBroadcastOneShow = BroadcastOneShow.createFromJsonString(paramString.optString(i));
        localBroadcastMusicInfo.showList.add(localBroadcastOneShow);
        i += 1;
      }
      return localBroadcastMusicInfo;
    }
    catch (Exception paramString) {}
  }
  
  public static List<SongInfo> toQusicInfoList(List<BroadcastMusicInfo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SongInfo localSongInfo = ((BroadcastMusicInfo)paramList.next()).toQusicInfo(paramBoolean);
      if (localSongInfo != null) {
        localArrayList.add(localSongInfo);
      }
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long getNearestTime()
  {
    long l = System.currentTimeMillis() / 1000L;
    if (this.showList != null)
    {
      Iterator localIterator = this.showList.iterator();
      while (localIterator.hasNext())
      {
        BroadcastOneShow localBroadcastOneShow = (BroadcastOneShow)localIterator.next();
        if (localBroadcastOneShow.startTime > l) {
          return localBroadcastOneShow.startTime;
        }
        if (localBroadcastOneShow.endTime > l) {
          return localBroadcastOneShow.endTime;
        }
      }
    }
    return -1L;
  }
  
  public String getSongUrl(boolean paramBoolean)
  {
    if (paramBoolean) {
      return (String)this.broadcastAudioUrl.masterUrl.mapBroadcastUrl.get(Byte.valueOf((byte)0));
    }
    return (String)this.broadcastAudioUrl.masterUrl.mapBroadcastUrl.get(Byte.valueOf((byte)1));
  }
  
  public String getTitle()
  {
    long l = System.currentTimeMillis() / 1000L;
    Object localObject2;
    if (this.showList != null)
    {
      localObject1 = this.showList.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (BroadcastOneShow)((Iterator)localObject1).next();
      } while ((((BroadcastOneShow)localObject2).startTime > l) || (((BroadcastOneShow)localObject2).endTime <= l));
    }
    for (Object localObject1 = this.broadcastName + "：" + ((BroadcastOneShow)localObject2).bcShowName;; localObject1 = "")
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131703262);
      }
      return localObject2;
    }
  }
  
  public SongInfo toQusicInfo(boolean paramBoolean)
  {
    SongInfo localSongInfo = new SongInfo();
    try
    {
      localSongInfo.id = Long.parseLong(this.broadcastID);
      localSongInfo.title = getTitle();
      localSongInfo.type = 9;
      localSongInfo.detailUrl = this.detailUrl;
      localSongInfo.url = getSongUrl(paramBoolean);
      localSongInfo.b = this;
      return localSongInfo;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.broadcastID);
    paramParcel.writeString(this.broadcastName);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeParcelable(this.broadcastAudioUrl, paramInt);
    paramParcel.writeList(this.showList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.music.BroadcastMusicInfo
 * JD-Core Version:    0.7.0.1
 */