import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.qphone.base.util.QLog;

class xai
  implements ajlt
{
  xai(xah paramxah, xah.b paramb, String paramString) {}
  
  public void a(ajlq paramajlq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramajlq != null)
    {
      if (paramajlq.result != 0) {
        break label133;
      }
      ajlr.eB(this.this$0.mContext);
    }
    for (;;)
    {
      paramajlq.a.b(this);
      if (this.a.a != null)
      {
        this.a.a.setVisibility(8);
        this.a.a.setProgressKey(this.aUE);
        this.a.a.Wt(this.aUE);
        this.a.a.setProcessor(null);
        ((RelativeLayout)this.a.E).removeView(this.a.a);
        this.a.a = null;
      }
      return;
      label133:
      ajlr.eC(this.this$0.mContext);
    }
  }
  
  public void a(ajlq paramajlq, int paramInt)
  {
    if (this.a.a != null)
    {
      this.a.a.setProgress(paramInt);
      this.a.a.invalidate();
    }
  }
  
  public void b(ajlq paramajlq) {}
  
  public void bKe()
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(8);
      this.a.a.setProgressKey(this.aUE);
      this.a.a.Wt(this.aUE);
      this.a.a.setProcessor(null);
      ((RelativeLayout)this.a.E).removeView(this.a.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xai
 * JD-Core Version:    0.7.0.1
 */