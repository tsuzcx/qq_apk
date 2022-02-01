import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class ayks
  implements ppv.b<pyz, qak>
{
  ayks(aykn paramaykn, WeakReference paramWeakReference) {}
  
  public void a(@NonNull pyz parampyz, @Nullable qak paramqak, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramqak == null)
    {
      parampyz = (aykn.e)this.dd.get();
      if (parampyz != null) {
        parampyz.D(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    parampyz = (aykn.e)this.dd.get();
    if (parampyz != null)
    {
      parampyz.D(0, paramqak.mV);
      return;
    }
    ram.i("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayks
 * JD-Core Version:    0.7.0.1
 */