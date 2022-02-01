import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class wow
  implements View.OnLayoutChangeListener
{
  wow(woo paramwoo, wjl paramwjl) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ykq.b(woo.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Woo.d) || (this.jdField_a_of_type_Woo.e)) && (!this.jdField_a_of_type_Woo.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      ykq.b(woo.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Woo.d)
      {
        this.jdField_a_of_type_Woo.d = false;
        this.jdField_a_of_type_Wjl.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Woo.e = false;
      if (this.jdField_a_of_type_Woo.a()) {
        this.jdField_a_of_type_Woo.jdField_a_of_type_Woa.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wow
 * JD-Core Version:    0.7.0.1
 */