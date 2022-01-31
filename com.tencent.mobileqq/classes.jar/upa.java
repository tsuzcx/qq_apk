import com.tencent.mobileqq.activity.aio.doodle.DoodleParam;
import com.tencent.mobileqq.activity.aio.doodle.MyParcel;
import com.tencent.mobileqq.activity.aio.doodle.MyParcelable.Creator;

public final class upa
  implements MyParcelable.Creator
{
  public DoodleParam a(MyParcel paramMyParcel)
  {
    return new DoodleParam(paramMyParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upa
 * JD-Core Version:    0.7.0.1
 */