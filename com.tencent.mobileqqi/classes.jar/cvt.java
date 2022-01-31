import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cannon.Visitor;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class cvt
  implements Runnable
{
  cvt(cvs paramcvs, boolean paramBoolean, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Visitor)((Iterator)localObject1).next();
        if (this.jdField_a_of_type_Cvs.a.jdField_a_of_type_JavaUtilList.size() > 30000) {
          this.jdField_a_of_type_Cvs.a.jdField_a_of_type_JavaUtilList.remove(0);
        }
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_JavaUtilList.add(localObject2);
      }
      if (this.jdField_a_of_type_Cvs.a.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Cvs.a.setTitle(2131562734);
        localObject1 = (List)((ArrayList)this.jdField_a_of_type_Cvs.a.jdField_a_of_type_JavaUtilList).clone();
        this.jdField_a_of_type_Cvs.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new cvu(this, (List)localObject1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131562926);
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_Cvs.a.d();
      localObject1 = (ProgressBar)this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.findViewById(2131231066);
      localObject2 = (ImageView)this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.findViewById(2131231868);
      ((ProgressBar)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      return;
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Cvs.a.setTitle(this.jdField_a_of_type_Cvs.a.getString(2131562734) + "(" + this.jdField_a_of_type_Int + ")");
      if (this.jdField_a_of_type_Cvs.a.jdField_a_of_type_Cvy == null)
      {
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_Cvy = new cvy(this.jdField_a_of_type_Cvs.a, this.jdField_a_of_type_Cvs.a, this.jdField_a_of_type_Cvs.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Cvs.a.jdField_a_of_type_Cvy);
      }
      while (this.jdField_a_of_type_Cvs.a.c * 10 >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.findViewById(2131231066).setVisibility(8);
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.findViewById(2131231868).setVisibility(8);
        localObject1 = (TextView)this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.findViewById(2131231869);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131562501);
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Cvs.a.d();
        return;
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_Cvy.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Cvs.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Cvs.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131562495);
        this.jdField_a_of_type_Cvs.a.d();
        return;
      }
      QQToast.a(this.jdField_a_of_type_Cvs.a, this.jdField_a_of_type_Cvs.a.getString(2131562076), 0).b(this.jdField_a_of_type_Cvs.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvt
 * JD-Core Version:    0.7.0.1
 */