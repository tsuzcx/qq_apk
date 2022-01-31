import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

public class vao
  implements AnimationTextView.OnSingleClick
{
  public vao(LongMsgItemBuilder paramLongMsgItemBuilder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LongMsgItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject;
    float f1;
    float f2;
    float f3;
    int k;
    boolean bool2;
    int j;
    boolean bool1;
    if ((paramView instanceof AnimationTextView))
    {
      localObject = (AnimationTextView)paramView;
      f1 = ((AnimationTextView)localObject).a - LongMsgItemBuilder.a();
      f2 = ((AnimationTextView)localObject).b;
      f3 = LongMsgItemBuilder.b();
      if (this.jdField_a_of_type_Boolean) {
        f1 = ((AnimationTextView)localObject).a - LongMsgItemBuilder.c();
      }
      localObject = ((AnimationTextView)localObject).getText();
      if ((localObject instanceof QQText))
      {
        localObject = (QQText)localObject;
        localObject = (QQText.EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), QQText.EmoticonSpan.class);
        if (!(paramView instanceof ETTextView)) {
          break label332;
        }
        paramView = (ETTextView)paramView;
        k = paramView.b;
        int m = paramView.c;
        if ((paramView.a == null) || (paramView.a.mFontId == 0) || (paramView.a.mFontType != 1)) {
          break label314;
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
              break label320;
            }
            bool1 = true;
            label248:
            j = m;
          }
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool2 = true;; bool2 = false)
      {
        EmoticonUtils.a((QQText.EmoticonSpan[])localObject, f1, f2 - f3, bool2, i, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder.jdField_a_of_type_AndroidContentContext, bool1);
        return;
        label314:
        bool2 = false;
        break;
        label320:
        bool1 = false;
        break label248;
      }
      label332:
      bool1 = false;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vao
 * JD-Core Version:    0.7.0.1
 */