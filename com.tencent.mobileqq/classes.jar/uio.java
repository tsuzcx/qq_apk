import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.qphone.base.util.QLog;

public class uio
  extends uaf
{
  public uio(uhw paramuhw) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject == null) || (!this.a.jdField_a_of_type_Twl.equals(localObject))) {}
    do
    {
      return;
      if (paramInt1 == this.a.hashCode())
      {
        ved.b(this.a.b, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(false);
        }
        if (paramInt2 == -1) {
          ttf.a().a(paramIntent.getExtras());
        }
      }
      if ((paramInt1 == 10002) && (paramInt2 == -1))
      {
        svl.b(this.a.b + " onActivityResult");
        bcql.a(this.a.b(), this.a.b().getString(2131719515), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (uhw.a(this.a) != null)) {
        uhw.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "MoreVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Tpb == null);
    this.a.jdField_a_of_type_Tpb.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void g()
  {
    super.g();
    if (uhw.a(this.a) != null) {
      uhw.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uio
 * JD-Core Version:    0.7.0.1
 */