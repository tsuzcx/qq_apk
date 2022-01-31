import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pic.ReportInfo;

public final class dzx
  implements Parcelable.Creator
{
  public ReportInfo a(Parcel paramParcel)
  {
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.e = paramParcel.readInt();
    localReportInfo.f = paramParcel.readInt();
    localReportInfo.g = paramParcel.readInt();
    localReportInfo.j = paramParcel.readInt();
    localReportInfo.h = paramParcel.readInt();
    localReportInfo.i = paramParcel.readInt();
    localReportInfo.a = paramParcel.readLong();
    localReportInfo.b = paramParcel.readLong();
    localReportInfo.c = paramParcel.readLong();
    return localReportInfo;
  }
  
  public ReportInfo[] a(int paramInt)
  {
    return new ReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dzx
 * JD-Core Version:    0.7.0.1
 */