import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract interface woy<Request extends wpa, Respond extends wov>
{
  public abstract void a(@NonNull Request paramRequest, @Nullable Respond paramRespond, @NonNull ErrorMessage paramErrorMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woy
 * JD-Core Version:    0.7.0.1
 */