import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

public class vnq
  implements AnimationTextView.OnSingleClick
{
  public vnq(TextItemBuilder paramTextItemBuilder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject = (AnimationTextView)paramView;
    float f1 = ((AnimationTextView)localObject).a - TextItemBuilder.f;
    float f2 = ((AnimationTextView)localObject).b;
    float f3 = TextItemBuilder.d;
    if (this.jdField_a_of_type_Boolean) {
      f1 = ((AnimationTextView)localObject).a - TextItemBuilder.g;
    }
    localObject = ((AnimationTextView)localObject).getText();
    int k;
    boolean bool2;
    int j;
    boolean bool1;
    if ((localObject instanceof QQText))
    {
      localObject = (QQText)localObject;
      localObject = (QQText.EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.EmoticonSpan.class);
      if (!(paramView instanceof ETTextView)) {
        break label325;
      }
      paramView = (ETTextView)paramView;
      k = paramView.b;
      int m = paramView.c;
      if ((paramView.a == null) || (paramView.a.mFontId == 0) || (paramView.a.mFontType != 1)) {
        break label307;
      }
      bool2 = true;
      i = k;
      j = m;
      bool1 = bool2;
      if (bool2)
      {
        i = k;
        j = m;
        bool1 = bool2;
        if (paramView.a() != null)
        {
          paramView = paramView.a();
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "isHanYiFont, onlyEmoji: " + paramView.jdField_a_of_type_Boolean);
          }
          if (paramView.jdField_a_of_type_Boolean) {
            break label313;
          }
          bool1 = true;
          label241:
          j = m;
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool2 = true;; bool2 = false)
      {
        EmoticonUtils.a((QQText.EmoticonSpan[])localObject, f1, f2 - f3, bool2, i, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.jdField_a_of_type_AndroidContentContext, bool1);
        return;
        label307:
        bool2 = false;
        break;
        label313:
        bool1 = false;
        break label241;
      }
      label325:
      bool1 = false;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vnq
 * JD-Core Version:    0.7.0.1
 */