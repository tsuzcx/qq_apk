import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.HightlightHotWordText;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.ContainerView;

public class tsi
  implements WordMatchManager.MatchCallback
{
  public tsi(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(int paramInt, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    paramArrayOfHotWordItem = new QQText(HightlightHotWordText.a(this.a.app, this.a.c, paramArrayOfHotWordItem), 13, 32, this.a.jdField_a_of_type_Int);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTextQQText = paramArrayOfHotWordItem;
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(paramArrayOfHotWordItem);
    this.a.h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsi
 * JD-Core Version:    0.7.0.1
 */