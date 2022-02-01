import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

class yah
  implements View.OnClickListener
{
  yah(xzp paramxzp) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.jdField_a_of_type_Aree == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.this$0.jdField_a_of_type_Aree.a();
      if (localObject != null)
      {
        HashMap localHashMap = ((ared)localObject).ad();
        localObject = ((ared)localObject).A();
        if (paramView == this.this$0.ua)
        {
          if (this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0)
          {
            if (localHashMap != null) {
              this.this$0.ua.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.this$0.b.setVisibility(0);
            this.this$0.KF.setVisibility(4);
            xzp.a(this.this$0).abp(25);
            if ((this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) && (localObject != null)) {
              this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
            }
          }
          else
          {
            if (localHashMap != null) {
              this.this$0.ua.setImageDrawable((Drawable)localHashMap.get("textIcon"));
            }
            this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
            this.this$0.b.setVisibility(4);
            this.this$0.KF.setVisibility(0);
            this.this$0.hideAllPanels();
          }
        }
        else if (paramView == this.this$0.ub) {
          if (xzp.b(this.this$0).vm() != 3)
          {
            this.this$0.k(Integer.valueOf(3));
            if (localHashMap != null) {
              this.this$0.ua.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.this$0.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.this$0.b.setVisibility(0);
            this.this$0.KF.setVisibility(4);
          }
          else
          {
            this.this$0.hideAllPanels();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yah
 * JD-Core Version:    0.7.0.1
 */