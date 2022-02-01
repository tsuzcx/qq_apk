import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;

class akge
  implements IphonePickerView.c
{
  akge(akfk paramakfk, IphonePickerView paramIphonePickerView, ausj paramausj) {}
  
  public void dn()
  {
    if ((this.val$actionSheet != null) && (this.val$actionSheet.isShowing()))
    {
      akfk.a(this.this$0, this.this$0.bo, false);
      this.val$actionSheet.dismiss();
    }
  }
  
  public void w(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.e != null)
      {
        if ((paramInt1 == 0) || (paramInt1 == 1)) {
          this.e.LV(2);
        }
        this.this$0.aT(this.e.ha(0), this.e.ha(1), this.e.ha(2));
      }
      return;
      this.this$0.yG = paramInt2;
      continue;
      this.this$0.yH = paramInt2;
      continue;
      this.this$0.yI = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akge
 * JD-Core Version:    0.7.0.1
 */