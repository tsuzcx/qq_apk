import android.text.Spanned;
import android.text.TextUtils;

class axul
  extends aykw.d
{
  axul(axuj paramaxuj, int paramInt)
  {
    super(paramInt);
  }
  
  public int d(CharSequence paramCharSequence)
  {
    return 0;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    Object localObject = paramSpanned.subSequence(0, paramInt3).toString() + paramCharSequence.subSequence(paramInt1, paramInt2).toString() + paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString();
    String str1 = apsv.filterEmoji((String)localObject);
    String str2 = this.a.sL(str1);
    this.max = (((String)localObject).length() - str1.length() + 20);
    localObject = str2.split("\n");
    int m = localObject.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      int k = localObject[j].length();
      int n = k / 5;
      if (k % 5 > 0) {}
      for (k = 1;; k = 0)
      {
        i += k + n;
        j += 1;
        break;
      }
    }
    if (TextUtils.equals(paramCharSequence, "\n")) {
      i += 1;
    }
    for (;;)
    {
      if (i > axuj.p().length)
      {
        if (!TextUtils.equals("", paramCharSequence)) {
          eSu();
        }
        return "";
      }
      return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axul
 * JD-Core Version:    0.7.0.1
 */