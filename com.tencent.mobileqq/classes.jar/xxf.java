import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class xxf
  extends xqm
{
  public xxf(xwr paramxwr) {}
  
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
      if ((paramInt1 == 467) && (paramInt2 == -1) && (xwr.a(this.a) != null)) {
        xwr.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "BottomVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Xfj == null);
    this.a.jdField_a_of_type_Xfj.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void d()
  {
    super.d();
    if ((LiuHaiUtils.a) && (!bdep.a(this.a.jdField_a_of_type_AndroidViewView.getContext())) && (xwr.a(this.a) - zps.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 9.0F) > 0))
    {
      Object localObject = xwr.a(this.a).getBackground();
      if ((localObject instanceof StateListDrawable))
      {
        localObject = (DrawableContainer.DrawableContainerState)((StateListDrawable)localObject).getConstantState();
        if (localObject != null) {
          ((GradientDrawable)localObject.getChildren()[0]).setColor(this.a.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167307));
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (xwr.a(this.a) != null) {
      xwr.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxf
 * JD-Core Version:    0.7.0.1
 */