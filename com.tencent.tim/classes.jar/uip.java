import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.c;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

public class uip
  implements PhotoListPanel.c
{
  public uip(BaseChatPie paramBaseChatPie) {}
  
  public void bF(Intent paramIntent)
  {
    ((wwg)this.this$0.a.a(7)).F(this.this$0.hashCode(), paramIntent);
  }
  
  public boolean fX(int paramInt)
  {
    Object localObject = ((wwg)this.this$0.a.a(7)).a(this.this$0.hashCode());
    int i = paramInt;
    if (localObject != null)
    {
      i = paramInt;
      if (((Intent)localObject).hasExtra("PhotoConst.SELECTED_PATHS"))
      {
        localObject = ((Intent)localObject).getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
        i = paramInt;
        if (localObject != null) {
          i = ((ArrayList)localObject).size();
        }
      }
    }
    PanelIconLinearLayout localPanelIconLinearLayout;
    if ((this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!this.this$0.aSM))
    {
      boolean bool = jof.a().dd(this.this$0.sessionInfo.aTl);
      if ((this.this$0.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) && (this.this$0.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 4)) {}
      localPanelIconLinearLayout = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
      if (!bool) {
        break label179;
      }
    }
    label179:
    for (localObject = xro.hM;; localObject = xro.hL)
    {
      localPanelIconLinearLayout.e((int[])localObject, i);
      if ((i > 0) && (!this.this$0.Pg())) {
        this.this$0.vS(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uip
 * JD-Core Version:    0.7.0.1
 */