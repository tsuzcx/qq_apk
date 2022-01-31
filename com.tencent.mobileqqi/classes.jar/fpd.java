import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.app.proxy.TroopInfoProxy;
import com.tencent.mobileqq.data.TroopInfo;

public final class fpd
  implements Parcelable.Creator
{
  public TroopInfoProxy a(Parcel paramParcel)
  {
    TroopInfo localTroopInfo = new TroopInfo();
    localTroopInfo.uin = paramParcel.readString();
    localTroopInfo.timeSec = paramParcel.readLong();
    localTroopInfo.troopuin = paramParcel.readString();
    localTroopInfo.troopcode = paramParcel.readString();
    localTroopInfo.troopowneruin = paramParcel.readString();
    localTroopInfo.troopname = paramParcel.readString();
    localTroopInfo.troopface = ((short)paramParcel.readInt());
    localTroopInfo.troopmemo = paramParcel.readString();
    localTroopInfo.fingertroopmemo = paramParcel.readString();
    localTroopInfo.troopmask = paramParcel.readInt();
    localTroopInfo.trooptype = paramParcel.readInt();
    localTroopInfo.troopCreateTime = paramParcel.readLong();
    localTroopInfo.dwGroupFlag = paramParcel.readLong();
    localTroopInfo.troopmask = paramParcel.readInt();
    localTroopInfo.cGroupOption = ((short)paramParcel.readInt());
    localTroopInfo.wMemberMax = paramParcel.readInt();
    localTroopInfo.wSpecialClass = paramParcel.readInt();
    localTroopInfo.cGroupLevel = ((short)paramParcel.readInt());
    localTroopInfo.wMemberNum = paramParcel.readInt();
    localTroopInfo.Administrator = paramParcel.readString();
    localTroopInfo.dwGroupClassExt = paramParcel.readLong();
    localTroopInfo.dwGroupFlagExt = paramParcel.readLong();
    return new TroopInfoProxy(localTroopInfo);
  }
  
  public TroopInfoProxy[] a(int paramInt)
  {
    return new TroopInfoProxy[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpd
 * JD-Core Version:    0.7.0.1
 */