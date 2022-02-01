import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class afnb
  extends afic<CustomEmotionData>
{
  afnb(afna paramafna) {}
  
  public void Ms(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "download_finish");
    }
    this.this$0.dak();
    anot.a(this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.this$0.dak();
  }
  
  public void cZH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "roaming_finish");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app != null) {
      ((afhv)this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.app.getManager(103)).b(this.this$0.jdField_a_of_type_Afic);
    }
    this.this$0.dak();
  }
  
  public void cZk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "upload_finish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnb
 * JD-Core Version:    0.7.0.1
 */