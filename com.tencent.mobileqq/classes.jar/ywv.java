import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;

public class ywv
  implements ViewPager.OnPageChangeListener
{
  private ywv(EditVideoFilter paramEditVideoFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localObject != null) {}
    for (paramInt1 = ((zfy)localObject).jdField_a_of_type_Int;; paramInt1 = 0)
    {
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a());
      if (localObject != null) {
        paramInt2 = ((zfy)localObject).jdField_a_of_type_Int;
      }
      localObject = (yyf)this.a.a(yyf.class);
      if (localObject != null) {
        ((yyf)localObject).a(paramInt1, paramInt2, paramFloat);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
    if (localObject != null) {}
    for (int i = ((zfy)localObject).jdField_a_of_type_Int;; i = 0)
    {
      this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_Yxt.a(), localObject);
      if ((i == 2) || (i == 1) || (i == 3))
      {
        localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
        if ((localObject != null) && (TextUtils.isEmpty(((zfz)localObject).jdField_a_of_type_Zfy.b))) {
          EditVideoFilter.a((zfz)localObject);
        }
      }
      localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt - 1);
      zfz localzfz = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt + 1);
      if (localObject != null) {
        ((zfz)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (localzfz != null) {
        localzfz.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_Int = i;
      EditVideoFilter.a(this.a).put(this.a.jdField_a_of_type_Yxt.a(), paramInt);
      localObject = (yyf)this.a.a(yyf.class);
      if (localObject != null) {
        ((yyf)localObject).b(i);
      }
      if (i != 0)
      {
        this.a.jdField_a_of_type_Yxt.a("608", "9", "0", true);
        yuq.a("0X80076DE");
      }
      yuk.a("Q.qqstory.publish.edit.EditVideoFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(this.a.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywv
 * JD-Core Version:    0.7.0.1
 */