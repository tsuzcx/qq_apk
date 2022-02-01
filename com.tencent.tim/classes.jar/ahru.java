import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;

public final class ahru
  implements Parcelable.Creator<GameCenterSessionInfo>
{
  public GameCenterSessionInfo a(Parcel paramParcel)
  {
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.sessionType = paramParcel.readInt();
    localGameCenterSessionInfo.sessionId = paramParcel.readString();
    localGameCenterSessionInfo.gameId = paramParcel.readString();
    localGameCenterSessionInfo.gameName = paramParcel.readString();
    localGameCenterSessionInfo.faceUrl = paramParcel.readString();
    localGameCenterSessionInfo.nickName = paramParcel.readString();
    localGameCenterSessionInfo.bLw = paramParcel.readString();
    localGameCenterSessionInfo.aaO = paramParcel.readLong();
    localGameCenterSessionInfo.requestCount = paramParcel.readInt();
    localGameCenterSessionInfo.bLx = paramParcel.readString();
    localGameCenterSessionInfo.lastMsgTime = paramParcel.readLong();
    localGameCenterSessionInfo.daT = paramParcel.readInt();
    localGameCenterSessionInfo.daU = paramParcel.readInt();
    localGameCenterSessionInfo.bLy = paramParcel.readString();
    localGameCenterSessionInfo.bLz = paramParcel.readString();
    localGameCenterSessionInfo.bLA = paramParcel.readString();
    return localGameCenterSessionInfo;
  }
  
  public GameCenterSessionInfo[] a(int paramInt)
  {
    return new GameCenterSessionInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahru
 * JD-Core Version:    0.7.0.1
 */