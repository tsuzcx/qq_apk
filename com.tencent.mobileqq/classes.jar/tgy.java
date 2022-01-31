import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.NearbyActivity.TabInfo;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import java.util.ArrayList;

public class tgy
  extends FragmentPagerAdapter
{
  public HotChatFragment a;
  public NearbyHybridFragment a;
  public NowLiveFragment a;
  
  public tgy(NearbyActivity paramNearbyActivity, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a(paramInt);
    Object localObject2 = localObject1;
    NearbyActivity.TabInfo localTabInfo;
    if (localObject1 == null)
    {
      localTabInfo = (NearbyActivity.TabInfo)this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a.get(paramInt);
      if (localTabInfo.b != 2) {
        break label82;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment = new NowLiveFragment();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        ((NearbyBaseFragment)localObject1).a(localTabInfo);
        localObject2 = localObject1;
      }
      return localObject2;
      label82:
      if (localTabInfo.b == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment = new HotChatFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
      }
      else if (localTabInfo.b == 4)
      {
        localObject1 = new CommonTabFragment();
      }
      else if (localTabInfo.b == 5)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment == null) {
          this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = new NearbyHybridFragment();
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgy
 * JD-Core Version:    0.7.0.1
 */