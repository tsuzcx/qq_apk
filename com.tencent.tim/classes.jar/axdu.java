import android.support.annotation.Nullable;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;

class axdu
  implements axzv<String>
{
  axdu(axdr paramaxdr, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void onChanged(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = acfp.m(2131702126);
    }
    paramString = this.b.getLayoutParams();
    if (str.indexOf('\n') > 0) {}
    for (int i = axdr.a(this.a) * 3 / 10;; i = axdr.a(this.a) * 11 / 50)
    {
      paramString.height = i;
      this.b.setTextSize(aqcx.sp2px(axdr.a(this.a), 23.0F));
      this.b.setOutlineWidth(aqcx.dip2px(axdr.a(this.a), 2.0F));
      this.b.setText(str);
      this.b.setLayoutParams(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdu
 * JD-Core Version:    0.7.0.1
 */