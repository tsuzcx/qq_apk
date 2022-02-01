import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.TranslateController;
import com.tencent.mobileqq.ocr.TranslateController.ImageTranslateTask;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aknh
  implements adgp.a
{
  public aknh(TranslateController.ImageTranslateTask paramImageTranslateTask, adhv paramadhv) {}
  
  public void a(int paramInt, String paramString, adhr paramadhr)
  {
    Object localObject;
    label82:
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (paramadhr != null)
      {
        localObject = paramadhr.a;
        QLog.d("TranslateController", 2, "imageTranslate, retCode:" + paramInt + ",sessionId:" + paramString + ",result: " + localObject);
      }
    }
    else
    {
      int i = 0;
      if ((paramadhr == null) || (paramadhr.a == null)) {
        break label241;
      }
      paramString = paramadhr.a;
      i = 1;
      paramadhr = this.jdField_a_of_type_Adhv.a.bsZ;
      localObject = this.jdField_a_of_type_Adhv.a.fileName;
      paramString.imagePath = paramadhr;
      if ((ahbj.isFileExists((String)localObject)) && (!((String)localObject).equals(paramadhr))) {
        ahbj.deleteFile((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqOcrTranslateController$ImageTranslateTask.this$0;
      if (paramInt != 0) {
        break label260;
      }
      bool = true;
      label149:
      TranslateController.a((TranslateController)localObject, bool, paramadhr, paramString);
      paramadhr = new HashMap();
      paramadhr.put("costTime", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Adhv.Tb));
      paramadhr.put("retCode", String.valueOf(paramInt));
      if (i == 0) {
        break label266;
      }
    }
    label260:
    label266:
    for (paramString = "1";; paramString = "0")
    {
      paramadhr.put("hasResult", paramString);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_IMAGE_TRANSLATE_COST", true, 0L, 0L, paramadhr, "", false);
      return;
      localObject = null;
      break;
      label241:
      paramString = new TranslateResult(2);
      paramString.errCode = 1002;
      break label82;
      bool = false;
      break label149;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknh
 * JD-Core Version:    0.7.0.1
 */