package moai.core.utilities;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Patterns$1
  extends ThreadLocal<Matcher>
{
  Patterns$1(String paramString) {}
  
  protected Matcher initialValue()
  {
    Log.d("pattern", "regex: " + this.val$regex);
    return Pattern.compile(this.val$regex).matcher("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Patterns.1
 * JD-Core Version:    0.7.0.1
 */