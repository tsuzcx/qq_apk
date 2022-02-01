import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.tim.todo.data.TodoInfo;

public final class aupu
  implements Parcelable.Creator<TodoInfo>
{
  public TodoInfo a(Parcel paramParcel)
  {
    return new TodoInfo(paramParcel);
  }
  
  public TodoInfo[] a(int paramInt)
  {
    return new TodoInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupu
 * JD-Core Version:    0.7.0.1
 */