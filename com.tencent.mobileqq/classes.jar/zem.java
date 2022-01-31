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

class zem
  implements Runnable
{
  zem(zel paramzel, ImageView paramImageView) {}
  
  public void run()
  {
    if ((zel.a(this.jdField_a_of_type_Zel) == null) && (zel.a(this.jdField_a_of_type_Zel) != null) && (zel.a(this.jdField_a_of_type_Zel).get() != null))
    {
      Object localObject = (ApolloGameViewBinder)zel.a(this.jdField_a_of_type_Zel).get();
      if ((ApolloGameViewBinder.a((ApolloGameViewBinder)localObject) != null) && (ApolloGameViewBinder.a((ApolloGameViewBinder)localObject).a != null))
      {
        localObject = CalloutPopupWindow.a(ApolloGameViewBinder.a((ApolloGameViewBinder)zel.a(this.jdField_a_of_type_Zel).get()).a).b(8).a(ApolloConstant.an).a(16.0F).a(-1);
        ((CalloutPopupWindow.Builder)localObject).c(50);
        localObject = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a();
        if (localObject != null) {
          zel.a(this.jdField_a_of_type_Zel, ((CalloutPopupWindow.Builder)localObject).a());
        }
      }
    }
    if (zel.a(this.jdField_a_of_type_Zel) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameListAdapter", 2, "show guide window inner " + this.jdField_a_of_type_AndroidWidgetImageView.getX() + " " + this.jdField_a_of_type_AndroidWidgetImageView.getY());
      }
      zel.a(this.jdField_a_of_type_Zel).a(83);
      zel.a(this.jdField_a_of_type_Zel).c(2);
      zel.a(this.jdField_a_of_type_Zel).b(this.jdField_a_of_type_AndroidWidgetImageView, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zem
 * JD-Core Version:    0.7.0.1
 */