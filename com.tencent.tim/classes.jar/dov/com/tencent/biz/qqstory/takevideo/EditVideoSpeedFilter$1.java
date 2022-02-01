package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import aygz;
import ayhz;
import ayii;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class EditVideoSpeedFilter$1
  implements Runnable
{
  public EditVideoSpeedFilter$1(ayhz paramayhz) {}
  
  public void run()
  {
    if (!ayhz.a(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.this$0.b.b() == null);
        localObject = this.this$0.b.b().getActivity();
      } while ((localObject == null) || (((Activity)localObject).isFinishing()) || ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())));
      ayhz.a(this.this$0, (ViewStub)this.this$0.y(2131373285));
    } while (this.this$0.a != null);
    Object localObject = ayhz.a(this.this$0).getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {}
    for (this.this$0.a = ((PickerContainer)ayhz.a(this.this$0).inflate());; this.this$0.a = ((PickerContainer)this.this$0.y(2131377486)))
    {
      this.this$0.a.a(this.this$0.b.a, this.this$0);
      this.this$0.a.cE(2, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */