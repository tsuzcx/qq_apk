import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class kth
  implements View.OnClickListener
{
  kth(kte paramkte, ktm paramktm, boolean paramBoolean, Activity paramActivity, BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    label50:
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      if (this.d.a != null)
      {
        localObject = this.d.a;
        if (!(this.d instanceof ksm)) {
          break label239;
        }
      }
      break;
    }
    for (;;)
    {
      ((ksx)localObject).a(j, i, this.jdField_b_of_type_Ktm);
      this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      if (TextUtils.isEmpty(this.jdField_b_of_type_Ktm.p)) {
        break;
      }
      CharSequence localCharSequence = this.jdField_b_of_type_Ktm.p;
      alkw.a((ClipboardManager)localObject, localCharSequence);
      ((ClipboardManager)localObject).setText(localCharSequence);
      i = -1;
      break label50;
      this.d.o(this.jdField_b_of_type_Ktm);
      i = 1;
      break label50;
      this.d.p(this.jdField_b_of_type_Ktm);
      i = 5;
      break label50;
      if (this.ahI)
      {
        this.d.n(this.jdField_b_of_type_Ktm);
        i = 4;
        break label50;
      }
      this.d.a(this.val$context, new kti(this));
      i = 3;
      break label50;
      label239:
      j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kth
 * JD-Core Version:    0.7.0.1
 */