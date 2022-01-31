import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class vbe
  implements View.OnLayoutChangeListener
{
  vbe(vaw paramvaw, uvt paramuvt) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    wxe.b(vaw.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Vaw.d) || (this.jdField_a_of_type_Vaw.e)) && (!this.jdField_a_of_type_Vaw.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      wxe.b(vaw.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Vaw.d)
      {
        this.jdField_a_of_type_Vaw.d = false;
        this.jdField_a_of_type_Uvt.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Vaw.e = false;
      if (this.jdField_a_of_type_Vaw.a()) {
        this.jdField_a_of_type_Vaw.jdField_a_of_type_Vai.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbe
 * JD-Core Version:    0.7.0.1
 */