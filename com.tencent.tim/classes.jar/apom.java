import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.Arrays;

class apom
  implements AbsListView.e
{
  apom(apol paramapol) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(apol.a(this.c), paramInt1);
    if ((paramInt1 >= 0) && (apol.a(this.c).c != null)) {
      apol.a(this.c).c.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apom
 * JD-Core Version:    0.7.0.1
 */