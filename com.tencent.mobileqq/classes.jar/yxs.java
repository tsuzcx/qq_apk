import android.graphics.Color;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;

class yxs
  implements Runnable
{
  yxs(yxr paramyxr, ImageView paramImageView) {}
  
  public void run()
  {
    if ((yxr.a(this.jdField_a_of_type_Yxr) == null) && (yxr.a(this.jdField_a_of_type_Yxr) != null) && (yxr.a(this.jdField_a_of_type_Yxr).get() != null))
    {
      Object localObject = (ApolloGameViewBinder)yxr.a(this.jdField_a_of_type_Yxr).get();
      if ((ApolloGameViewBinder.a((ApolloGameViewBinder)localObject) != null) && (ApolloGameViewBinder.a((ApolloGameViewBinder)localObject).a != null))
      {
        localObject = CalloutPopupWindow.a(ApolloGameViewBinder.a((ApolloGameViewBinder)yxr.a(this.jdField_a_of_type_Yxr).get()).a).b(8).a(ApolloConstant.am).a(16.0F).a(-1);
        ((CalloutPopupWindow.Builder)localObject).c(50);
        localObject = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          yxr.a(this.jdField_a_of_type_Yxr, ((CalloutPopupWindow.Builder)localObject).a());
        }
      }
    }
    if (yxr.a(this.jdField_a_of_type_Yxr) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.jdField_a_of_type_AndroidWidgetImageView.getX() + " " + this.jdField_a_of_type_AndroidWidgetImageView.getY());
      }
      yxr.a(this.jdField_a_of_type_Yxr).a(83);
      yxr.a(this.jdField_a_of_type_Yxr).c(2);
      yxr.a(this.jdField_a_of_type_Yxr).b(this.jdField_a_of_type_AndroidWidgetImageView, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxs
 * JD-Core Version:    0.7.0.1
 */