import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.NegativeChildrenLayout;

class auty
  implements View.OnClickListener
{
  auty(autw paramautw) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.this$0.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.this$0.Eu, acfp.m(2131707569), this.this$0.jdField_a_of_type_Autw$b);
      this.this$0.Wh(true);
      this.this$0.mType = 1;
      this.this$0.mTypeName = acfp.m(2131707574);
      autw.a(this.this$0, paramView.getTag(), false);
      continue;
      this.this$0.mg.getLayoutParams();
      this.this$0.mg.getParent();
      this.this$0.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.this$0.Ev, acfp.m(2131707568), this.this$0.jdField_a_of_type_Autw$b);
      this.this$0.Wh(true);
      this.this$0.mType = 2;
      this.this$0.mTypeName = acfp.m(2131707577);
      autw.a(this.this$0, paramView.getTag(), false);
      continue;
      this.this$0.iV(paramView);
      this.this$0.showToast();
      this.this$0.mType = 3;
      this.this$0.mTypeName = acfp.m(2131707573);
      autw.a(this.this$0, paramView.getTag(), true);
      continue;
      this.this$0.iV(paramView);
      this.this$0.showToast();
      this.this$0.mType = 4;
      this.this$0.mTypeName = this.this$0.cIW;
      autw.a(this.this$0, paramView.getTag(), false);
      continue;
      this.this$0.iV(paramView);
      this.this$0.showToast();
      this.this$0.mType = 5;
      autw.a(this.this$0, paramView.getTag(), false);
      continue;
      this.this$0.Wh(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auty
 * JD-Core Version:    0.7.0.1
 */