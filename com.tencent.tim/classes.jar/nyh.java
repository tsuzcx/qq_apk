import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderBaseTabFragment;
import java.util.ArrayList;

public class nyh
  implements ViewPager.OnPageChangeListener
{
  public nyh(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  private void ur(int paramInt)
  {
    if (paramInt == FolderBaseTabFragment.bdd)
    {
      if (ServiceAccountFolderActivityNew.a(this.a)) {}
      for (str = "1";; str = "2")
      {
        sqn.d("auth_discover", "tofollow", 0, 0, new String[] { str });
        return;
      }
    }
    if (ServiceAccountFolderActivityNew.a(this.a)) {}
    for (String str = "1";; str = "2")
    {
      sqn.d("auth_follow", "todiscover", 0, 0, new String[] { str });
      return;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ryx.clearMemoryCache();
    ur(paramInt);
    if ((ServiceAccountFolderActivityNew.a(this.a) != null) && (ServiceAccountFolderActivityNew.a(this.a).getChildCount() > paramInt))
    {
      ServiceAccountFolderActivityNew.a(this.a).getChildAt(paramInt).performClick();
      ServiceAccountFolderActivityNew.a(this.a, false);
    }
    ((FolderBaseTabFragment)ServiceAccountFolderActivityNew.a(this.a).get(paramInt)).a(this.a, paramInt);
    long l1;
    long l2;
    if (ServiceAccountFolderActivityNew.a(this.a) > 0L)
    {
      l1 = System.currentTimeMillis();
      l2 = ServiceAccountFolderActivityNew.a(this.a);
      if (ServiceAccountFolderActivityNew.a(this.a) != FolderBaseTabFragment.bdd) {
        break label173;
      }
    }
    label173:
    for (String str = "auth_follow";; str = "auth_discover")
    {
      sqn.a(str, "exp", 0, 0, new String[] { String.valueOf(l1 - l2) });
      ServiceAccountFolderActivityNew.a(this.a, 0L);
      ServiceAccountFolderActivityNew.a(this.a, System.currentTimeMillis());
      ServiceAccountFolderActivityNew.a(this.a, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyh
 * JD-Core Version:    0.7.0.1
 */