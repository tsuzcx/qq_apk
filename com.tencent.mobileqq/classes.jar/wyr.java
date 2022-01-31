import android.annotation.TargetApi;
import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class wyr
  implements AdapterView.OnItemClickListener
{
  public wyr(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  @TargetApi(11)
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.b)
    {
      this.a.h();
      return;
    }
    paramAdapterView = (String)paramAdapterView.getItemAtPosition(paramInt);
    if (PhotoPreviewActivity.a(this.a, paramAdapterView) == 1)
    {
      this.a.p = paramAdapterView;
      switch (this.a.b())
      {
      default: 
        return;
      case 0: 
        this.a.a(0);
        return;
      case 1: 
        this.a.l();
        return;
      case 2: 
        this.a.k();
        return;
      }
      this.a.a(0);
      return;
    }
    if (this.a.e)
    {
      this.a.c();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyr
 * JD-Core Version:    0.7.0.1
 */