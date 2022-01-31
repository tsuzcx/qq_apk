import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;

public class vtn
  extends UiCallBack.DownAdapter
{
  public vtn(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, 0L, true);
    }
  }
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (paramShortVideoResult.jdField_a_of_type_Int == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.jdField_a_of_type_JavaLangObject;
      if (localIAIOImageProviderCallBack != null) {
        localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, 1, paramShortVideoResult.b, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramShortVideoResult.b);
      return;
    }
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, 2, "step:" + paramShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.a + ", desc:" + paramShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, "I:E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vtn
 * JD-Core Version:    0.7.0.1
 */