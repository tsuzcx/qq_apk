import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amrx
  implements View.OnClickListener
{
  amrx(amrv paramamrv, amow paramamow) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_Amow.dDq == 1)
    {
      anot.a(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
      localObject = (acff)amrv.a(this.jdField_a_of_type_Amrv).getManager(51);
      if ((((acff)localObject).isFriend(this.jdField_a_of_type_Amow.id)) || (((acff)localObject).kd(this.jdField_a_of_type_Amow.id))) {
        break label210;
      }
      localObject = AddFriendLogicActivity.a(paramView.getContext(), 1, this.jdField_a_of_type_Amow.id, null, 3020, 3, this.jdField_a_of_type_Amow.name, null, null, paramView.getContext().getString(2131721053), null);
      paramView.getContext().startActivity((Intent)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
      anot.a(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
      break;
      label210:
      if (((acff)localObject).isFriend(this.jdField_a_of_type_Amow.id))
      {
        this.jdField_a_of_type_Amow.friendStatus = 2;
        amrv.a(this.jdField_a_of_type_Amrv).notifyDataSetChanged();
      }
      else
      {
        this.jdField_a_of_type_Amow.friendStatus = 1;
        amrv.a(this.jdField_a_of_type_Amrv).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrx
 * JD-Core Version:    0.7.0.1
 */