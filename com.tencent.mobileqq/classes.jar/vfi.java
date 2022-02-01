import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class vfi
  extends vfj
{
  private vhc a;
  
  public vfi(vhc paramvhc, Pattern paramPattern)
  {
    super(paramPattern);
    this.jdField_a_of_type_Vhc = paramvhc;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, vhc paramvhc, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramInt = Math.max(paramInt, bgtn.a(10.0F));
    paramCharSequence = vfw.a().a(this.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_Vhc);
    paramvhc = paramCharSequence;
    if (paramCharSequence == null) {
      paramvhc = new TextCell(0, this.jdField_a_of_type_JavaLangString);
    }
    paramArrayList.add(paramvhc);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfi
 * JD-Core Version:    0.7.0.1
 */