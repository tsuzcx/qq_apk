import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class tig
  implements View.OnLayoutChangeListener
{
  tig(thy paramthy, tcv paramtcv) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    veg.b(thy.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Thy.d) || (this.jdField_a_of_type_Thy.e)) && (!this.jdField_a_of_type_Thy.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      veg.b(thy.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Thy.d)
      {
        this.jdField_a_of_type_Thy.d = false;
        this.jdField_a_of_type_Tcv.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Thy.e = false;
      if (this.jdField_a_of_type_Thy.a()) {
        this.jdField_a_of_type_Thy.jdField_a_of_type_Thk.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tig
 * JD-Core Version:    0.7.0.1
 */