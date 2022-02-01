import com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.ColorTextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class vhk
  extends vhn
{
  public vhk(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, vjg paramvjg, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramvjg = vik.a(this.a);
    paramCharSequence = new ColorTextCell();
    if (paramvjg == null)
    {
      paramArrayList.add(paramCharSequence);
      return paramArrayList;
    }
    paramCharSequence.type = 9;
    paramCharSequence.setTextColor(paramvjg.color);
    paramCharSequence.setClickable(false);
    paramCharSequence.text = paramvjg.text;
    paramCharSequence.useDefaultFont = paramvjg.useDefaultFont;
    paramCharSequence.useSuperFont = paramvjg.useSuperFont;
    paramCharSequence.setTextBold(paramvjg.isBold);
    paramCharSequence.setFontFamilyUrl(paramvjg.fontFamilyUrl);
    paramArrayList.add(paramCharSequence);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhk
 * JD-Core Version:    0.7.0.1
 */