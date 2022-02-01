import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class xpb
  extends xgs
{
  public xpb(xoj paramxoj) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject == null) || (!this.a.jdField_a_of_type_Xcy.equals(localObject))) {}
    do
    {
      return;
      if (paramInt1 == this.a.hashCode())
      {
        ykq.b(this.a.b, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(false);
        }
        if (paramInt2 == -1) {
          wzy.a().a(paramIntent.getExtras());
        }
      }
      if ((paramInt1 == 10002) && (paramInt2 == -1))
      {
        wcn.b(this.a.b + " onActivityResult");
        QQToast.a(this.a.b(), this.a.b().getString(2131718792), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (xoj.a(this.a) != null)) {
        xoj.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Wvu == null);
    this.a.jdField_a_of_type_Wvu.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void g()
  {
    super.g();
    if (xoj.a(this.a) != null) {
      xoj.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpb
 * JD-Core Version:    0.7.0.1
 */