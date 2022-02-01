import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xyv
  extends xqm
{
  public xyv(xyd paramxyd) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject == null) || (!this.a.jdField_a_of_type_Xms.equals(localObject))) {}
    do
    {
      return;
      if (paramInt1 == this.a.hashCode())
      {
        yuk.b(this.a.b, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(false);
        }
        if (paramInt2 == -1) {
          xjn.a().a(paramIntent.getExtras());
        }
      }
      if ((paramInt1 == 10002) && (paramInt2 == -1))
      {
        wlt.b(this.a.b + " onActivityResult");
        QQToast.a(this.a.b(), this.a.b().getString(2131718165), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (xyd.a(this.a) != null)) {
        xyd.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Xfj == null);
    this.a.jdField_a_of_type_Xfj.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void g()
  {
    super.g();
    if (xyd.a(this.a) != null) {
      xyd.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyv
 * JD-Core Version:    0.7.0.1
 */