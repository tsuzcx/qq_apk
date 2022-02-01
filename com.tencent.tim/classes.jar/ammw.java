import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.ListView;

public class ammw
  extends amlu<ampx, amxy>
{
  public ammw(ContactSearchFragment paramContactSearchFragment, ListView paramListView, aqdf paramaqdf)
  {
    super(paramListView, paramaqdf);
  }
  
  protected amsq<ampx, amxy> a(int paramInt)
  {
    if (ContactSearchFragment.a(this.d) == -1) {
      return new amtx(this.a, ContactSearchFragment.a(this.d), ContactSearchFragment.a(this.d), ContactSearchFragment.b(this.d));
    }
    if (ContactSearchFragment.a(this.d) == 17) {
      return new amsd(this.a, ContactSearchFragment.a(this.d));
    }
    if (ContactSearchFragment.a(this.d) == 19) {
      return new amsc(this.a, ContactSearchFragment.a(this.d), ContactSearchFragment.a(this.d));
    }
    if (ContactSearchFragment.a(this.d) == 23) {
      return new amtz(this.a, null);
    }
    if (ContactSearchFragment.a(this.d) == 24) {
      return new amty(this.a, ContactSearchFragment.a(this.d), ContactSearchFragment.a(this.d));
    }
    return new amsf(this.a, ContactSearchFragment.a(this.d), ContactSearchFragment.a(this.d));
  }
  
  protected amxz a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((amxk.lo(ContactSearchFragment.a(this.d))) || (ContactSearchFragment.a(this.d) == 5) || (ContactSearchFragment.a(this.d) == 8)) {
      return new amxs(paramViewGroup, 2131563034);
    }
    if ((ContactSearchFragment.a(this.d) == -1) || (ContactSearchFragment.a(this.d) == 19) || (ContactSearchFragment.a(this.d) == 24)) {
      return new amxs(paramViewGroup, 2131563033);
    }
    if (ContactSearchFragment.a(this.d) == 17) {
      return new amxr(paramViewGroup, 2131561283);
    }
    if (ContactSearchFragment.a(this.d) == 23) {
      return new amzm(paramViewGroup, 2131561283);
    }
    return new amxs(paramViewGroup, 2131563032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ammw
 * JD-Core Version:    0.7.0.1
 */