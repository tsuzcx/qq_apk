import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ahcd
  implements View.OnClickListener
{
  ahcd(QQAppInterface paramQQAppInterface, String paramString, ahcc.a parama, aett.a parama1) {}
  
  public void onClick(View paramView)
  {
    if (this.val$app != null) {
      anot.a(this.val$app, "dc00898", "", "", this.bJS, this.bJS, 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Ahcc$a.run(this.jdField_a_of_type_Aett$a.getClickType());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcd
 * JD-Core Version:    0.7.0.1
 */