import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class vhl
  extends vhn
{
  private vjg a;
  
  public vhl(vjg paramvjg, Pattern paramPattern)
  {
    super(paramPattern);
    this.jdField_a_of_type_Vjg = paramvjg;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, vjg paramvjg, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramvjg = via.a().a(this.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_Vjg);
    paramvjg.cellIndex = 0;
    paramArrayList.add(paramvjg);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhl
 * JD-Core Version:    0.7.0.1
 */