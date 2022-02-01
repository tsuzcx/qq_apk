import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class xnl
  extends xgs
{
  public xnl(xmx paramxmx) {}
  
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
      if ((paramInt1 == 467) && (paramInt2 == -1) && (xmx.a(this.a) != null)) {
        xmx.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "BottomVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Wvu == null);
    this.a.jdField_a_of_type_Wvu.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void d()
  {
    super.d();
    if ((LiuHaiUtils.a) && (!ScreenUtil.checkDeviceHasNavigationBar(this.a.jdField_a_of_type_AndroidViewView.getContext())) && (xmx.a(this.a) - UIUtils.dip2px(this.a.jdField_a_of_type_AndroidViewView.getContext(), 9.0F) > 0))
    {
      Object localObject = xmx.a(this.a).getBackground();
      if ((localObject instanceof StateListDrawable))
      {
        localObject = (DrawableContainer.DrawableContainerState)((StateListDrawable)localObject).getConstantState();
        if (localObject != null) {
          ((GradientDrawable)localObject.getChildren()[0]).setColor(this.a.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167368));
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (xmx.a(this.a) != null) {
      xmx.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnl
 * JD-Core Version:    0.7.0.1
 */