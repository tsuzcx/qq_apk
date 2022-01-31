import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;

public class uee
  extends ClickableSpan
{
  public uee(QCirclePersonInfoAndStatusWidget paramQCirclePersonInfoAndStatusWidget, int paramInt) {}
  
  public void onClick(@NonNull View paramView)
  {
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, "addClickReport click location" + this.jdField_a_of_type_Int);
    tzv.a(QCirclePersonInfoAndStatusWidget.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget).id.get(), 11, 6L, this.jdField_a_of_type_Int);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePersonInfoAndStatusWidget.getResources().getColor(2131165307));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */