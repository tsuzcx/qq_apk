import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer.PathSegment;

public final class uxx
  implements MyParcelable.Creator
{
  public PathDrawer.PathSegment a(MyParcel paramMyParcel)
  {
    return new PathDrawer.PathSegment(paramMyParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */