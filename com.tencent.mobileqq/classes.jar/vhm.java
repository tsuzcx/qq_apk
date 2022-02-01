import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class vhm
  extends vhn
{
  private vjg a;
  
  public vhm(vjg paramvjg, Pattern paramPattern)
  {
    super(paramPattern);
    this.jdField_a_of_type_Vjg = paramvjg;
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, vjg paramvjg, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    paramInt = Math.max(paramInt, bhtq.a(10.0F));
    paramCharSequence = via.a().a(this.jdField_a_of_type_JavaLangString, paramInt, this.jdField_a_of_type_Vjg);
    paramvjg = paramCharSequence;
    if (paramCharSequence == null) {
      paramvjg = new TextCell(0, this.jdField_a_of_type_JavaLangString);
    }
    paramArrayList.add(paramvjg);
    return paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhm
 * JD-Core Version:    0.7.0.1
 */