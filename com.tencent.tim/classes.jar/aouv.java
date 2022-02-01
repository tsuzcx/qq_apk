import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TEditText.a;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.List;

public class aouv
  implements TEditText.a
{
  public aouv(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onSelectionChanged(int paramInt1, int paramInt2)
  {
    int m = 1;
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0) {
      break label37;
    }
    label37:
    while ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return;
    }
    int j = this.this$0.jdField_a_of_type_Aorm$d.cmJ.length();
    int k = this.this$0.jdField_a_of_type_Aorm$d.cmI.length();
    int n = this.this$0.jdField_a_of_type_Aorm$d.cmK.length() + (j + k);
    if ((paramInt1 < this.this$0.cni.length() + n) && (paramInt2 < this.this$0.cni.length() + n))
    {
      if (TroopBarPublishActivity.a(this.this$0).size() > 1)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.clearFocus();
        aurd.hide(this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
    }
    if (paramInt1 < 0) {
      if (paramInt2 > this.this$0.cni.length() + n)
      {
        paramInt1 = paramInt2;
        label203:
        if (paramInt1 <= i) {
          break label439;
        }
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
      paramInt1 = this.this$0.cni.length() + n;
      break label203;
      if (paramInt2 < 0) {
        if (paramInt1 > this.this$0.cni.length() + n) {
          label258:
          if (paramInt1 <= i) {
            break label434;
          }
        }
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
        return;
        paramInt1 = this.this$0.cni.length() + n;
        break label258;
        if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Aorm$d.cmJ)) {
          break;
        }
        k = 0;
        j = paramInt1;
        if (paramInt1 < this.this$0.cni.length() + n)
        {
          j = n + this.this$0.cni.length();
          k = 1;
        }
        if (paramInt2 < this.this$0.cni.length() + n)
        {
          paramInt1 = n + this.this$0.cni.length();
          k = 1;
        }
        for (;;)
        {
          paramInt2 = j;
          if (j > i)
          {
            k = 1;
            paramInt2 = i;
          }
          if (paramInt1 > i) {
            k = m;
          }
          while (k != 0)
          {
            this.this$0.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(paramInt2, i);
            return;
            i = paramInt1;
          }
          break;
          paramInt1 = paramInt2;
        }
        label434:
        i = paramInt1;
      }
      label439:
      i = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouv
 * JD-Core Version:    0.7.0.1
 */