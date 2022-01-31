import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;
import com.tencent.mobileqq.activity.aio.doodle.PathData.PointData;

public final class upt
  implements MyParcelable.Creator
{
  public PathData.PointData a(MyParcel paramMyParcel)
  {
    return new PathData.PointData(paramMyParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upt
 * JD-Core Version:    0.7.0.1
 */