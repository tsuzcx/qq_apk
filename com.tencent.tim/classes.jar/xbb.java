import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;

class xbb
  implements ausj.a
{
  xbb(xaz paramxaz, MessageForDeviceFile paramMessageForDeviceFile, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ("device_groupchat".equals(this.b.extStr)) {
      ((szy)this.a.app.getBusinessHandler(49)).a().q(this.b);
    }
    for (;;)
    {
      this.a.notifyDataSetChanged();
      this.c.dismiss();
      return;
      this.a.e(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbb
 * JD-Core Version:    0.7.0.1
 */