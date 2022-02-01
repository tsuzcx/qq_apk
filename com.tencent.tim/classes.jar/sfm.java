import android.os.Bundle;
import android.text.TextUtils;

class sfm
  implements sfl.b
{
  sfm(sfl paramsfl) {}
  
  public void bl(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("fakeVid", paramString);
    }
    localBundle.putInt("progress", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfm
 * JD-Core Version:    0.7.0.1
 */