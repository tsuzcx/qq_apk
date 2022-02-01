import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteActivity.d;
import com.dataline.activities.LiteActivity.e;
import java.util.ArrayList;

public class bd
  implements ahal.a
{
  public bd(LiteActivity paramLiteActivity, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void aD()
  {
    Bundle localBundle;
    if (!this.val$photoPaths.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.val$photoPaths);
      new LiteActivity.d(this.this$0).execute(new Bundle[] { localBundle });
    }
    if (!this.D.isEmpty())
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.PHOTO_PATHS", this.D);
      new LiteActivity.e(this.this$0).execute(new Bundle[] { localBundle });
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */