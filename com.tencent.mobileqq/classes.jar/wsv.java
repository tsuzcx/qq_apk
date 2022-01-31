import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class wsv
{
  static CharSequence a(@NonNull bgxo parambgxo)
  {
    if (parambgxo.a) {
      return parambgxo.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    parambgxo = parambgxo.toString();
    SpannableString localSpannableString = new SpannableString(parambgxo);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, parambgxo.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsv
 * JD-Core Version:    0.7.0.1
 */