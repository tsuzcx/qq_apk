import android.widget.ProgressBar;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardPhotoOption.a;

public class ahiz
  implements ahgq.a
{
  public ahiz(ForwardPhotoOption paramForwardPhotoOption) {}
  
  public void onDownloadFinish()
  {
    ForwardPhotoOption.a(this.this$0).progressBar.setVisibility(8);
  }
  
  public void onDownloadStart()
  {
    ForwardPhotoOption.a(this.this$0).progressBar.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahiz
 * JD-Core Version:    0.7.0.1
 */