import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class tid
  implements View.OnLayoutChangeListener
{
  tid(thv paramthv, tcs paramtcs) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ved.b(thv.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Thv.d) || (this.jdField_a_of_type_Thv.e)) && (!this.jdField_a_of_type_Thv.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      ved.b(thv.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Thv.d)
      {
        this.jdField_a_of_type_Thv.d = false;
        this.jdField_a_of_type_Tcs.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Thv.e = false;
      if (this.jdField_a_of_type_Thv.a()) {
        this.jdField_a_of_type_Thv.jdField_a_of_type_Thh.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tid
 * JD-Core Version:    0.7.0.1
 */