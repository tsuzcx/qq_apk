import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.qphone.base.util.QLog;

public class aklu
  extends BroadcastReceiver
{
  public aklu(OCRPerformFragment paramOCRPerformFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction()))
    {
      QLog.d("OCRPerformFragment", 4, "receive videochat");
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklu
 * JD-Core Version:    0.7.0.1
 */