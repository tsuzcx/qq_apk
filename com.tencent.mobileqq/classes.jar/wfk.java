import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract interface wfk<Request extends wfm, Respond extends wfh>
{
  public abstract void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfk
 * JD-Core Version:    0.7.0.1
 */