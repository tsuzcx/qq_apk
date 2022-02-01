import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.QCirclePersonInfoAndStatusWidget;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;

public class pgc
  extends ClickableSpan
{
  public pgc(QCirclePersonInfoAndStatusWidget paramQCirclePersonInfoAndStatusWidget, int paramInt) {}
  
  public void onClick(@NonNull View paramView)
  {
    QLog.d("QCirclePersonInfoAndStatusWidget", 1, "addClickReport click location" + this.biu);
    pco.b(QCirclePersonInfoAndStatusWidget.a(this.this$0).id.get(), 11, 6L, this.biu);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.this$0.getResources().getColor(2131165381));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgc
 * JD-Core Version:    0.7.0.1
 */