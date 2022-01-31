import android.support.v4.view.ViewPager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPageIndicator;
import com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.RecentAndFavPanelViewBinder;
import java.util.ArrayList;
import java.util.List;

public class dex
  implements Runnable
{
  public dex(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    Object localObject;
    int i;
    int k;
    if ((EmoticonMainPanel.g == 1) && (EmoticonMainPanel.h == 0) && (this.a.b != null) && (this.a.b.size() > 0))
    {
      localObject = (EmoticonViewBinder)this.a.b.get(0);
      if ((localObject != null) && ((localObject instanceof RecentAndFavPanelViewBinder)))
      {
        localObject = (RecentAndFavPanelViewBinder)localObject;
        ((RecentAndFavPanelViewBinder)localObject).a(true);
        if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.notifyDataSetChanged();
        }
        this.a.jdField_a_of_type_JavaUtilList = this.a.b;
        i = ((RecentAndFavPanelViewBinder)localObject).a();
        k = ((RecentAndFavPanelViewBinder)localObject).b();
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setRecent(true);
        if (i != 0) {
          break label258;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(4);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      int j = this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem();
      i = j;
      if (j >= k) {
        i = k - 1;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
        this.a.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i, false);
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(true);
      }
      return;
      label258:
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPageIndicator.a(i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dex
 * JD-Core Version:    0.7.0.1
 */