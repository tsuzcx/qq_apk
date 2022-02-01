import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class abjt
  extends abjr
{
  public void a(abjv paramabjv, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramabjv == null) || (TextUtils.isEmpty(paramabjv.mText))) {
      return;
    }
    String str2 = paramabjv.bgG;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramabjv = str1 + paramabjv.mText;
    this.im.put(paramabjv, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(abjv paramabjv)
  {
    if ((paramabjv == null) || (TextUtils.isEmpty(paramabjv.mText))) {
      return null;
    }
    String str2 = paramabjv.bgG;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramabjv = str1 + paramabjv.mText;
    paramabjv = (WeakReference)this.im.get(paramabjv);
    if (paramabjv != null) {
      return (Bitmap)paramabjv.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjt
 * JD-Core Version:    0.7.0.1
 */