import com.tencent.widget.TCWNumberPicker.a;
import java.util.Formatter;

public final class auvi
  implements TCWNumberPicker.a
{
  final Object[] mArgs = new Object[1];
  final StringBuilder mBuilder = new StringBuilder();
  final Formatter mFmt = new Formatter(this.mBuilder);
  
  public String toString(int paramInt)
  {
    this.mArgs[0] = Integer.valueOf(paramInt);
    this.mBuilder.delete(0, this.mBuilder.length());
    this.mFmt.format("%02d", this.mArgs);
    return this.mFmt.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auvi
 * JD-Core Version:    0.7.0.1
 */