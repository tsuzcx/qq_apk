import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.timfiletab.data.TeamFileEntity;

public final class aunk
  implements Parcelable.Creator<TeamFileEntity>
{
  public TeamFileEntity a(Parcel paramParcel)
  {
    return new TeamFileEntity(paramParcel);
  }
  
  public TeamFileEntity[] a(int paramInt)
  {
    return new TeamFileEntity[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunk
 * JD-Core Version:    0.7.0.1
 */