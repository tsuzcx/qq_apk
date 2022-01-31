import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.SendingFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class trl
  extends FMObserver
{
  public trl(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferProgress");
    if (this.a.jdField_a_of_type_JavaUtilList != null)
    {
      paramInt = 0;
      if (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label232;
      }
      if (((SendMultiPictureHelper.SendingFileInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a != paramLong1) {}
    }
    for (;;)
    {
      if (paramInt != -1) {
        paramInt = 0;
      }
      for (;;)
      {
        if (paramInt < this.a.jdField_a_of_type_JavaUtilList.size())
        {
          paramString = (FileManagerEntity)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
          if (paramString.uniseq != paramLong1) {
            break label202;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.d, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf((int)(paramString.fProgress * 100.0F)) }));
          }
        }
        return;
        paramInt += 1;
        break;
        label202:
        paramInt += 1;
      }
      this.a.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      return;
      label232:
      paramInt = -1;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String arg6, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferEnd");
    if (!this.a.jdField_b_of_type_Boolean) {
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        this.a.a();
        return;
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QLog.w("SendMultiPictureHelper", 2, "OnFileTransferStart");
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.d, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(0) }));
    }
    this.a.jdField_a_of_type_JavaUtilList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trl
 * JD-Core Version:    0.7.0.1
 */