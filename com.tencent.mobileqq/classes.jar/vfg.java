import com.tencent.biz.qqcircle.bizparts.danmaku.element.ColorElement;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.ColorTextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class vfg
  extends vfj
{
  public vfg(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, vhc paramvhc, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramvhc = vgg.a(this.a);
    paramCharSequence = new ColorTextCell();
    if (paramvhc == null)
    {
      paramArrayList.add(paramCharSequence);
      return paramArrayList;
    }
    paramCharSequence.type = 9;
    paramCharSequence.setTextColor(paramvhc.color);
    paramCharSequence.setClickable(false);
    paramCharSequence.text = paramvhc.text;
    paramCharSequence.useDefaultFont = paramvhc.useDefaultFont;
    paramCharSequence.useSuperFont = paramvhc.useSuperFont;
    paramCharSequence.setTextBold(paramvhc.isBold);
    paramCharSequence.setFontFamilyUrl(paramvhc.fontFamilyUrl);
    paramArrayList.add(paramCharSequence);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfg
 * JD-Core Version:    0.7.0.1
 */