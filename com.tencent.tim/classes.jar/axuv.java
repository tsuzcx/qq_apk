import android.text.Spanned;
import android.text.TextUtils;

class axuv
  extends aykw.d
{
  axuv(axus paramaxus, int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    String str1;
    String str2;
    int i;
    if (this.a.Rw() == 0)
    {
      str1 = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
      str2 = apsv.filterEmoji(str1);
      String[] arrayOfString = this.a.sL(str2).split("\n");
      int m = arrayOfString.length;
      int j = 0;
      i = 0;
      if (j < m)
      {
        int k = arrayOfString[j].length();
        int n = k / 5;
        if (k % 5 > 0) {}
        for (k = 1;; k = 0)
        {
          i += k + n;
          j += 1;
          break;
        }
      }
      if (!TextUtils.equals(paramCharSequence, "\n")) {
        break label261;
      }
      i += 1;
    }
    label261:
    for (;;)
    {
      if (i > 4)
      {
        if (!TextUtils.equals("", paramCharSequence)) {
          eSu();
        }
        return "";
      }
      this.max = (str1.length() - str2.length() + 20);
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      this.max = 20;
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axuv
 * JD-Core Version:    0.7.0.1
 */