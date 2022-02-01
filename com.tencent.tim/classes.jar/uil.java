import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class uil
  implements View.OnLayoutChangeListener
{
  public uil(BaseChatPie paramBaseChatPie) {}
  
  private boolean d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    wur localwur = (wur)this.this$0.a(52);
    return ((this.this$0.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 1) && (paramInt2 - paramInt1 != paramInt4 - paramInt3)) || ((localwur != null) && (localwur.RW()));
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onLayoutChange() called with: v = [" + paramView + "], left = [" + paramInt1 + "], top = [" + paramInt2 + "], right = [" + paramInt3 + "], bottom = [" + paramInt4 + "], oldLeft = [" + paramInt5 + "], oldTop = [" + paramInt6 + "], oldRight = [" + paramInt7 + "], oldBottom = [" + paramInt8 + "], scrollY=" + this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() + ", diff=" + (paramInt6 - paramInt2));
    }
    paramInt5 = this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.this$0.a.getTop();
    paramView = (wur)this.this$0.a(52);
    paramInt7 = 0;
    paramInt3 = paramInt7;
    paramInt1 = paramInt5;
    if (paramView != null)
    {
      paramInt3 = paramInt7;
      paramInt1 = paramInt5;
      if (paramView.bgd)
      {
        paramInt3 = wja.dp2px(40.0F, this.this$0.mActivity.getResources());
        paramInt1 = paramInt5 + paramInt3;
      }
    }
    paramView = (wxk)this.this$0.a(23);
    if ((paramView != null) && (paramView.Ss()))
    {
      paramInt5 = paramView.wn();
      paramInt1 += paramInt5;
    }
    for (;;)
    {
      if ((this.this$0.a.getVisibility() == 0) && (this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() != paramInt1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.TAG, 2, "onLayoutChange() update list.paddingBottom from " + this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + paramInt1);
        }
        this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), paramInt1);
      }
      if (!d(paramInt2, paramInt4, paramInt6, paramInt8)) {
        break label402;
      }
      label402:
      while (this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0) {
        return;
      }
      paramInt8 = paramInt6 - paramInt5 - paramInt3;
      paramInt6 = -1;
      paramInt7 = 0;
      paramInt2 = this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
      for (;;)
      {
        paramInt4 = paramInt7;
        paramInt1 = paramInt6;
        if (paramInt2 >= 0)
        {
          paramView = this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt2);
          if ((paramInt8 > paramView.getTop()) && (paramInt8 <= paramView.getBottom()))
          {
            paramInt1 = this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() + paramInt2;
            paramInt4 = paramInt8 - paramView.getBottom();
          }
        }
        else
        {
          if (paramInt1 == -1) {
            break;
          }
          this.this$0.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(new uim(this, paramInt1, paramInt5 + paramInt4 + paramInt3));
          return;
        }
        paramInt2 -= 1;
      }
      paramInt5 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uil
 * JD-Core Version:    0.7.0.1
 */