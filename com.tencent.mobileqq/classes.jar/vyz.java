import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class vyz
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private List<Long> jdField_a_of_type_JavaUtilList;
  private vzb jdField_a_of_type_Vzb;
  private vzc jdField_a_of_type_Vzc;
  
  public void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373944));
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380940);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Vzc = new vzc(this, null);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Vzc);
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList))
    {
      this.jdField_a_of_type_JavaUtilList = ((ArrayList)paramObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label69;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_Vzc != null) {
        this.jdField_a_of_type_Vzc.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    label69:
    do
    {
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(vzb paramvzb)
  {
    this.jdField_a_of_type_Vzb = paramvzb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyz
 * JD-Core Version:    0.7.0.1
 */