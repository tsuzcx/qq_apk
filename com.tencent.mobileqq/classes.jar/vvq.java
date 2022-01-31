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

public class vvq
  extends vox
{
  public vvq(vvc paramvvc) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.a.a();
    if ((localObject == null) || (!this.a.jdField_a_of_type_Vld.equals(localObject))) {}
    do
    {
      return;
      if (paramInt1 == this.a.hashCode())
      {
        wsv.b(this.a.b, "onActivityResult, onChooseFriendResult");
        localObject = ((StoryPlayerGroupHolder)this.a.a()).a();
        if (localObject != null) {
          ((VideoViewVideoHolder)localObject).c(false);
        }
        if (paramInt2 == -1) {
          vhx.a().a(paramIntent.getExtras());
        }
      }
      if ((paramInt1 == 10002) && (paramInt2 == -1))
      {
        ukd.b(this.a.b + " onActivityResult");
        QQToast.a(this.a.b(), this.a.b().getString(2131720047), 1).a();
      }
      if ((paramInt1 == 467) && (paramInt2 == -1) && (vvc.a(this.a) != null)) {
        vvc.a(this.a).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, new Object[] { "BottomVideoInfoWidget.MyActivityLifeCycle onActivityResult. hashCode=", Integer.valueOf(hashCode()) });
      }
    } while (this.a.jdField_a_of_type_Vdt == null);
    this.a.jdField_a_of_type_Vdt.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void d()
  {
    super.d();
    if ((bngs.a) && (!azgq.a(this.a.jdField_a_of_type_AndroidViewView.getContext())) && (vvc.a(this.a) - xod.a(this.a.jdField_a_of_type_AndroidViewView.getContext(), 9.0F) > 0))
    {
      Object localObject = vvc.a(this.a).getBackground();
      if ((localObject instanceof StateListDrawable))
      {
        localObject = (DrawableContainer.DrawableContainerState)((StateListDrawable)localObject).getConstantState();
        if (localObject != null) {
          ((GradientDrawable)localObject.getChildren()[0]).setColor(this.a.jdField_a_of_type_AndroidViewView.getResources().getColor(2131167196));
        }
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (vvc.a(this.a) != null) {
      vvc.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vvq
 * JD-Core Version:    0.7.0.1
 */