import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class wuq
  implements View.OnLayoutChangeListener
{
  wuq(wui paramwui, wpf paramwpf) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    yqp.b(wui.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Wui.d) || (this.jdField_a_of_type_Wui.e)) && (!this.jdField_a_of_type_Wui.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      yqp.b(wui.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Wui.d)
      {
        this.jdField_a_of_type_Wui.d = false;
        this.jdField_a_of_type_Wpf.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Wui.e = false;
      if (this.jdField_a_of_type_Wui.a()) {
        this.jdField_a_of_type_Wui.jdField_a_of_type_Wtu.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuq
 * JD-Core Version:    0.7.0.1
 */