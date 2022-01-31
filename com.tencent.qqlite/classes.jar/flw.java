import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QzonePerformanceTracer;

public class flw
  implements View.OnClickListener
{
  public flw(QzonePerformanceTracer paramQzonePerformanceTracer) {}
  
  public void onClick(View paramView)
  {
    QzonePerformanceTracer.a(this.a, true);
    paramView = new Intent("mqql.intent.action.EXIT_" + BaseApplicationImpl.a().getPackageName());
    BaseApplication.getContext().sendBroadcast(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     flw
 * JD-Core Version:    0.7.0.1
 */