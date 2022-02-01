import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.ReportInfo;

public final class akyc
  implements Parcelable.Creator<ReportInfo>
{
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.dpS = paramParcel.readInt();
    localReportInfo.dpT = paramParcel.readInt();
    localReportInfo.dpU = paramParcel.readInt();
    localReportInfo.dpX = paramParcel.readInt();
    localReportInfo.dpV = paramParcel.readInt();
    localReportInfo.dpW = paramParcel.readInt();
    localReportInfo.afA = paramParcel.readLong();
    localReportInfo.afB = paramParcel.readLong();
    localReportInfo.afC = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */