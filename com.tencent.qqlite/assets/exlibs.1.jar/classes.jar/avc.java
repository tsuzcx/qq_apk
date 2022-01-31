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

class avc
  implements Runnable
{
  avc(avb paramavb, boolean paramBoolean, List paramList, int paramInt) {}
  
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
        if (this.jdField_a_of_type_Avb.a.jdField_a_of_type_JavaUtilList.size() > 30000) {
          this.jdField_a_of_type_Avb.a.jdField_a_of_type_JavaUtilList.remove(0);
        }
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_JavaUtilList.add(localObject2);
      }
      if (this.jdField_a_of_type_Avb.a.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Avb.a.setTitle(2131363214);
        localObject1 = (List)((ArrayList)this.jdField_a_of_type_Avb.a.jdField_a_of_type_JavaUtilList).clone();
        this.jdField_a_of_type_Avb.a.app.a(new avd(this, (List)localObject1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131363196);
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_Avb.a.d();
      localObject1 = (ProgressBar)this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.findViewById(2131296558);
      localObject2 = (ImageView)this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.findViewById(2131297310);
      ((ProgressBar)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      return;
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Avb.a.setTitle(this.jdField_a_of_type_Avb.a.getString(2131363214) + "(" + this.jdField_a_of_type_Int + ")");
      if (this.jdField_a_of_type_Avb.a.jdField_a_of_type_Avh == null)
      {
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_Avh = new avh(this.jdField_a_of_type_Avb.a, this.jdField_a_of_type_Avb.a, this.jdField_a_of_type_Avb.a.app, this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Avb.a.jdField_a_of_type_Avh);
      }
      while (this.jdField_a_of_type_Avb.a.c * 10 >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.findViewById(2131296558).setVisibility(8);
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.findViewById(2131297310).setVisibility(8);
        localObject1 = (TextView)this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.findViewById(2131297311);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131363779);
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Avb.a.d();
        return;
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_Avh.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Avb.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Avb.a.b.setText(2131363778);
        this.jdField_a_of_type_Avb.a.d();
        return;
      }
      QQToast.a(this.jdField_a_of_type_Avb.a, this.jdField_a_of_type_Avb.a.getString(2131363776), 0).b(this.jdField_a_of_type_Avb.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avc
 * JD-Core Version:    0.7.0.1
 */