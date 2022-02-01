import android.text.Layout.Alignment;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;

class axvj
  extends aykw.d
{
  axvj(axvh paramaxvh, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str1 = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
    String str2 = apsv.filterEmoji(str1);
    Object localObject = this.a.sL(str2);
    localObject = this.a.F((String)localObject);
    localObject = this.a.a((String[])localObject);
    if (axvp.create((CharSequence)localObject, 0, ((CharSequence)localObject).length(), this.a.mPaint, this.a.eIe, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4).getLineCount() > 3)
    {
      if (!TextUtils.equals("", paramCharSequence)) {
        eSu();
      }
      return "";
    }
    this.max = (str1.length() - str2.length() + 20);
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvj
 * JD-Core Version:    0.7.0.1
 */