import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;
import com.tencent.mobileqq.activity.aio.doodle.PathDrawer;

public final class upu
  implements MyParcelable.Creator
{
  public PathDrawer a(MyParcel paramMyParcel)
  {
    return new PathDrawer(paramMyParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */