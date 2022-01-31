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

class avd
  implements Runnable
{
  avd(avc paramavc, boolean paramBoolean, List paramList, int paramInt) {}
  
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
        if (this.jdField_a_of_type_Avc.a.jdField_a_of_type_JavaUtilList.size() > 30000) {
          this.jdField_a_of_type_Avc.a.jdField_a_of_type_JavaUtilList.remove(0);
        }
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_JavaUtilList.add(localObject2);
      }
      if (this.jdField_a_of_type_Avc.a.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Avc.a.setTitle(2131363211);
        localObject1 = (List)((ArrayList)this.jdField_a_of_type_Avc.a.jdField_a_of_type_JavaUtilList).clone();
        this.jdField_a_of_type_Avc.a.app.a(new ave(this, (List)localObject1));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131363193);
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_a_of_type_Avc.a.d();
      localObject1 = (ProgressBar)this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.findViewById(2131296558);
      localObject2 = (ImageView)this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.findViewById(2131297314);
      ((ProgressBar)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      return;
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Avc.a.setTitle(this.jdField_a_of_type_Avc.a.getString(2131363211) + "(" + this.jdField_a_of_type_Int + ")");
      if (this.jdField_a_of_type_Avc.a.jdField_a_of_type_Avi == null)
      {
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_Avi = new avi(this.jdField_a_of_type_Avc.a, this.jdField_a_of_type_Avc.a, this.jdField_a_of_type_Avc.a.app, this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Avc.a.jdField_a_of_type_Avi);
      }
      while (this.jdField_a_of_type_Avc.a.c * 10 >= this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.findViewById(2131296558).setVisibility(8);
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.findViewById(2131297314).setVisibility(8);
        localObject1 = (TextView)this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.findViewById(2131297315);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(2131363787);
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Avc.a.d();
        return;
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_Avi.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      if (this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidAppDialog != null)
      {
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_Avc.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_Avc.a.b.setText(2131363786);
        this.jdField_a_of_type_Avc.a.d();
        return;
      }
      QQToast.a(this.jdField_a_of_type_Avc.a, this.jdField_a_of_type_Avc.a.getString(2131363784), 0).b(this.jdField_a_of_type_Avc.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avd
 * JD-Core Version:    0.7.0.1
 */