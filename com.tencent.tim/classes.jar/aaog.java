import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup.LayoutParams;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView.a;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class aaog
  implements TextWatcher
{
  public aaog(TimLoginQQView paramTimLoginQQView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    TimLoginQQView.c(this.this$0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramCharSequence.length() > 0) {
      if (this.this$0.pj != null)
      {
        localObject = (TimLoginQQView.a)this.this$0.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
        if ((localObject != null) && (((TimLoginQQView.a)localObject).getCount() != 0)) {
          break label139;
        }
        localObject = (RelativeLayout.LayoutParams)this.this$0.pj.getLayoutParams();
        paramInt1 = (int)(15.0F * TimLoginQQView.a(this.this$0) + 0.5F);
        if (((RelativeLayout.LayoutParams)localObject).rightMargin != paramInt1)
        {
          ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
          this.this$0.pj.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        this.this$0.pj.setVisibility(0);
      }
    }
    for (;;)
    {
      if (paramCharSequence.length() <= 4) {
        break label237;
      }
      this.this$0.Ay(paramCharSequence.toString());
      return;
      label139:
      localObject = (RelativeLayout.LayoutParams)this.this$0.pj.getLayoutParams();
      paramInt1 = (int)(40.0F * TimLoginQQView.a(this.this$0) + 0.5F);
      if (((RelativeLayout.LayoutParams)localObject).rightMargin == paramInt1) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = paramInt1;
      this.this$0.pj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      if ((this.this$0.pj != null) && (this.this$0.pj.isShown())) {
        this.this$0.pj.setVisibility(8);
      }
    }
    label237:
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.bE(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaog
 * JD-Core Version:    0.7.0.1
 */