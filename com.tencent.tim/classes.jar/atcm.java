import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class atcm
  implements View.OnClickListener
{
  public static atcm.a a;
  public static auuw.a a;
  public static atcm.a b;
  public static auuw.a b;
  public static atcm.a c;
  public static atcm.a d;
  public static auuw.a d;
  public static auuw.a e = new auuw.a(2131364752, BaseApplicationImpl.getContext().getString(2131691605), BaseApplicationImpl.getContext().getString(2131691605), 2130839376);
  public static auuw.a f = new auuw.a(2131364749, BaseApplicationImpl.getContext().getString(2131691604), BaseApplicationImpl.getContext().getString(2131691604), 2130839377);
  public static auuw.a g;
  public static auuw.a h;
  public static auuw.a i = new auuw.a(2131364754, BaseApplicationImpl.getContext().getString(2131689825), BaseApplicationImpl.getContext().getString(2131689825), 2130839381);
  public static auuw.a j = new auuw.a(2131364756, BaseApplicationImpl.getContext().getString(2131719042), BaseApplicationImpl.getContext().getString(2131719042), 2130842272);
  RedTouch E = null;
  private auuw.c a;
  public Activity activity;
  private auuw.b jdField_b_of_type_Auuw$b;
  private auuw jdField_b_of_type_Auuw;
  private Dialog dialog;
  private View.OnClickListener onClickListener;
  private List<auuw.a> vm;
  
  static
  {
    jdField_a_of_type_Atcm$a = new atcm.a(2131364750, 2131720885, 2131720885, 2130845185);
    jdField_b_of_type_Atcm$a = new atcm.a(2131364751, 2131720886, 2131720886, 2130845184);
    c = new atcm.a(2131364752, 2131691605, 2131691605, 2130839376);
    jdField_d_of_type_Atcm$a = new atcm.a(2131364749, 2131691604, 2131691604, 2130839377);
    g = new auuw.a(2131364777, BaseApplicationImpl.getContext().getString(2131693715), BaseApplicationImpl.getContext().getString(2131693715), 2130839390);
    jdField_a_of_type_Auuw$a = new auuw.a(2131364750, BaseApplicationImpl.getContext().getString(2131720885), BaseApplicationImpl.getContext().getString(2131720885), 2130851561);
    jdField_b_of_type_Auuw$a = new auuw.a(2131364751, BaseApplicationImpl.getContext().getString(2131720886), BaseApplicationImpl.getContext().getString(2131720886), 2130851562);
    h = new auuw.a(2131364753, BaseApplicationImpl.getContext().getString(2131720884), BaseApplicationImpl.getContext().getString(2131720884), 2130851563);
    jdField_d_of_type_Auuw$a = new auuw.a(2131364757, BaseApplicationImpl.getContext().getString(2131720887), BaseApplicationImpl.getContext().getString(2131720887), 2130851564);
  }
  
  public atcm(Activity paramActivity, List<auuw.a> paramList, auuw.b paramb)
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
      int k = 0;
      while (k < this.vm.size())
      {
        localArrayList.add(this.vm.get(k));
        k += 1;
      }
    }
    this.jdField_b_of_type_Auuw = auuw.a(this.activity, localArrayList, this.jdField_b_of_type_Auuw$b, this.jdField_a_of_type_Auuw$c);
  }
  
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
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364746) {
      this.dialog.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.dialog.dismiss();
      if (this.onClickListener != null) {
        this.onClickListener.onClick(paramView);
      }
    }
  }
  
  public void t(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, paramInt1, paramInt2, -1);
  }
  
  public static class a
  {
    public int contentDescription;
    public int iconId;
    public int id;
    public int title;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.id = paramInt1;
      this.title = paramInt2;
      this.contentDescription = paramInt3;
      this.iconId = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcm
 * JD-Core Version:    0.7.0.1
 */