import android.content.Context;
import android.view.OrientationEventListener;

class akna
  extends OrientationEventListener
{
  akna(akmz paramakmz, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.this$0.cjn = 0;
    }
    do
    {
      return;
      this.this$0.cjn = ((paramInt + 45) / 90 * 90);
    } while (this.this$0.cjn >= 0);
    this.this$0.cjn = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akna
 * JD-Core Version:    0.7.0.1
 */