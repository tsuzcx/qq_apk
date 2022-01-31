import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.IMagicCallback;
import com.tencent.qphone.base.util.QLog;

class vbm
  implements PngFrameManager.IMagicCallback
{
  vbm(vbl paramvbl) {}
  
  public void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "func downloadVideoDetails, 【callback】 try to download video details.");
    }
    MarketFaceItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, paramHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      MarketFaceItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbm
 * JD-Core Version:    0.7.0.1
 */