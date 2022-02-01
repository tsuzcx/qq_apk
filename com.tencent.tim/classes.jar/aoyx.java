import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;

public class aoyx
  implements View.OnFocusChangeListener
{
  public aoyx(NewTroopContactView paramNewTroopContactView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.b.a();
      if (paramView != null)
      {
        paramView.Pt(true);
        paramView.N(NewTroopContactView.a(this.b), this.b.so);
        FragmentTransaction localFragmentTransaction = this.b.a.getSupportFragmentManager().beginTransaction();
        if (this.b.c != null) {
          localFragmentTransaction.remove(this.b.c);
        }
        localFragmentTransaction.add(2131377207, paramView);
        localFragmentTransaction.commitAllowingStateLoss();
        this.b.c = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyx
 * JD-Core Version:    0.7.0.1
 */