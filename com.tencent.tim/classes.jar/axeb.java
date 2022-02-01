import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axeb
  implements View.OnClickListener
{
  axeb(axea paramaxea, int paramInt, axea.a parama) {}
  
  public void onClick(View paramView)
  {
    if (this.val$position != axea.a(this.jdField_a_of_type_Axea))
    {
      axea.a locala = (axea.a)axea.a(this.jdField_a_of_type_Axea).findViewHolderForAdapterPosition(axea.a(this.jdField_a_of_type_Axea));
      if (locala == null) {
        break label101;
      }
      locala.setSelected(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Axea$a.setSelected(true);
      this.jdField_a_of_type_Axea.adL(this.val$position);
      if (axea.a(this.jdField_a_of_type_Axea) != null) {
        axea.a(this.jdField_a_of_type_Axea).setTextColor(Color.parseColor(axea.a(this.jdField_a_of_type_Axea)));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      this.jdField_a_of_type_Axea.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axeb
 * JD-Core Version:    0.7.0.1
 */