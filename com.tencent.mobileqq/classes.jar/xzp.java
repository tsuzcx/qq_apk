import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;

class xzp
  implements Runnable
{
  xzp(xzn paramxzn, int paramInt) {}
  
  public void run()
  {
    if (QzDynamicVideoPreviewActivity.d(this.jdField_a_of_type_Xzn.a)) {
      QzDynamicVideoPreviewActivity.b(this.jdField_a_of_type_Xzn.a);
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (this.jdField_a_of_type_Int != -1)
      {
        QQToast.a(this.jdField_a_of_type_Xzn.a, "合成错误(" + this.jdField_a_of_type_Int + ")，请稍后重试", 0).a();
        return;
      }
      break;
    case 4: 
    case 5: 
      QQToast.a(this.jdField_a_of_type_Xzn.a, "存在不支持格式的素材，合成错误(" + this.jdField_a_of_type_Int + ")", 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Xzn.a, "合成错误，请稍后重试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzp
 * JD-Core Version:    0.7.0.1
 */