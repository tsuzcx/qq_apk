import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;

public class ehr
  extends UiCallBack.DownAdapter
{
  public ehr(AIOImageProviderService paramAIOImageProviderService, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString) {}
  
  public void a(int paramInt)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long);
    }
  }
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localIAIOImageProviderCallBack != null)
    {
      if (paramPicResult.d == 0) {
        localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2, "step:" + paramPicResult.a.jdField_a_of_type_JavaLangString + ", desc:" + paramPicResult.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehr
 * JD-Core Version:    0.7.0.1
 */