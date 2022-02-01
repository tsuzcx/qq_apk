import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class wyl
  implements View.OnLayoutChangeListener
{
  wyl(wyd paramwyd, wta paramwta) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    yuk.b(wyd.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Wyd.d) || (this.jdField_a_of_type_Wyd.e)) && (!this.jdField_a_of_type_Wyd.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      yuk.b(wyd.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Wyd.d)
      {
        this.jdField_a_of_type_Wyd.d = false;
        this.jdField_a_of_type_Wta.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Wyd.e = false;
      if (this.jdField_a_of_type_Wyd.a()) {
        this.jdField_a_of_type_Wyd.jdField_a_of_type_Wxp.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyl
 * JD-Core Version:    0.7.0.1
 */