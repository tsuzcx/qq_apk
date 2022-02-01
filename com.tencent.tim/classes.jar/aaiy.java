import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class aaiy
{
  public static auuw.a a;
  public static auuw.a b;
  public static auuw.a c = new auuw.a(2131364747, BaseApplicationImpl.getContext().getString(2131720884), BaseApplicationImpl.getContext().getString(2131720884), 2130845183);
  public static auuw.a d = new auuw.a(2131364757, BaseApplicationImpl.getContext().getString(2131720887), BaseApplicationImpl.getContext().getString(2131720887), 2130851564);
  public static auuw.a e = new auuw.a(2131364752, BaseApplicationImpl.getContext().getString(2131691605), BaseApplicationImpl.getContext().getString(2131691605), 2130839376);
  public static auuw.a f = new auuw.a(2131364749, BaseApplicationImpl.getContext().getString(2131691604), BaseApplicationImpl.getContext().getString(2131691604), 2130839377);
  RedTouch E = null;
  private auuw.c a;
  public Activity activity;
  private auuw.b jdField_b_of_type_Auuw$b;
  private auuw jdField_b_of_type_Auuw;
  private List<auuw.a> vm;
  
  static
  {
    jdField_a_of_type_Auuw$a = new auuw.a(2131364750, BaseApplicationImpl.getContext().getString(2131720885), BaseApplicationImpl.getContext().getString(2131720885), 2130845185);
    jdField_b_of_type_Auuw$a = new auuw.a(2131364751, BaseApplicationImpl.getContext().getString(2131720886), BaseApplicationImpl.getContext().getString(2131720886), 2130845184);
  }
  
  public aaiy(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb)
  {
    this.activity = paramActivity;
    this.vm = paramList;
    this.jdField_b_of_type_Auuw$b = paramb;
  }
  
  private void cuB()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.vm != null) && (this.vm.size() > 0))
    {
      int i = 0;
      while (i < this.vm.size())
      {
        localArrayList.add(this.vm.get(i));
        i += 1;
      }
    }
    this.jdField_b_of_type_Auuw = auuw.a(this.activity, localArrayList, this.jdField_b_of_type_Auuw$b, this.jdField_a_of_type_Auuw$c);
  }
  
  @NonNull
  private boolean isShowing()
  {
    return (this.jdField_b_of_type_Auuw != null) && (this.jdField_b_of_type_Auuw.isShowing());
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Auuw == null) {
      cuB();
    }
    this.jdField_b_of_type_Auuw.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.jdField_b_of_type_Auuw.dismiss();
    }
  }
  
  public void t(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, paramInt1, paramInt2, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaiy
 * JD-Core Version:    0.7.0.1
 */