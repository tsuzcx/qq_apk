import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.business.sougou.WordMatchManager.e;
import com.tencent.mobileqq.business.sougou.WordMatchManager.f;

public class vxf
  implements WordMatchManager.e
{
  public vxf(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a(WordMatchManager.f paramf)
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$f = paramf;
    if (this.this$0.bLj != 0) {
      paramf.LJ(this.this$0.bLj);
    }
    this.this$0.bLj = paramf.a(1, this.this$0.textString, 3, this.this$0.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */