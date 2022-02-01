import android.content.Intent;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;

public class aidm
  implements aido.a
{
  public aidm(HuayangLoadbackgroudActivity paramHuayangLoadbackgroudActivity) {}
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    this.a.finish();
  }
  
  public void onProgressUpdate(int paramInt)
  {
    Intent localIntent = new Intent(aidi.lx(HuayangLoadbackgroudActivity.a(this.a)));
    localIntent.putExtra("key_state", 4);
    localIntent.putExtra("key_progress", paramInt);
    localIntent.putExtra("key_totalSize", 100L);
    this.a.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidm
 * JD-Core Version:    0.7.0.1
 */