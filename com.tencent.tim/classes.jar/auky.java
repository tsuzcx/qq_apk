import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public final class auky
  implements Parcelable.Creator<TeamWorkFileImportInfo>
{
  public TeamWorkFileImportInfo a(Parcel paramParcel)
  {
    return new TeamWorkFileImportInfo(paramParcel);
  }
  
  public TeamWorkFileImportInfo[] a(int paramInt)
  {
    return new TeamWorkFileImportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auky
 * JD-Core Version:    0.7.0.1
 */