import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.ItemBase;
import com.tencent.mobileqq.activity.richmedia.subtitles.TextItem;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;

public class ybx
  extends ItemBase
{
  private static int jdField_a_of_type_Int = 50;
  private float jdField_a_of_type_Float;
  private String jdField_a_of_type_JavaLangString;
  private ycc jdField_a_of_type_Ycc;
  private int jdField_b_of_type_Int;
  private ycc jdField_b_of_type_Ycc;
  
  public ybx(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Typeface paramTypeface)
  {
    super(paramLong1, paramLong2, paramBoolean);
    a(8, paramFloat1);
    a(9, paramFloat2);
    a(6, paramFloat5);
    this.jdField_a_of_type_Float = paramFloat5;
    a(5, a(paramFloat3, paramFloat2 * paramFloat1));
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Ycc = new ycc(a(this.jdField_b_of_type_Int), paramFloat4, paramInt, paramFloat7, paramFloat9, paramTypeface);
    this.jdField_b_of_type_Ycc = new ycc(a(this.jdField_b_of_type_Int + jdField_a_of_type_Int), paramFloat4, paramInt, paramFloat7, paramFloat9, paramTypeface);
    a(3, this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float);
    a(4, this.jdField_a_of_type_Ycc.b.b);
    a(7, (paramFloat8 - this.jdField_a_of_type_Ycc.b.b) / 2.0F + paramFloat6);
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 * paramFloat2;
  }
  
  private String a(int paramInt)
  {
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = "";
      return localObject;
    }
    if (this.jdField_a_of_type_JavaLangString.length() <= paramInt) {
      return "";
    }
    if (this.jdField_a_of_type_JavaLangString.length() > jdField_a_of_type_Int + paramInt) {}
    for (String str = this.jdField_a_of_type_JavaLangString.substring(paramInt, jdField_a_of_type_Int + paramInt);; str = this.jdField_a_of_type_JavaLangString.substring(paramInt, this.jdField_a_of_type_JavaLangString.length()))
    {
      localObject = str;
      if (str != null) {
        break;
      }
      return "";
    }
  }
  
  private void a(Canvas paramCanvas, RenderBuffer paramRenderBuffer)
  {
    if ((paramCanvas == null) && (paramRenderBuffer == null)) {}
    float f;
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Ycc != null)
      {
        f = a(6) + this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float;
        if (f >= 0.0F)
        {
          if (paramCanvas == null) {
            break label102;
          }
          this.jdField_a_of_type_Ycc.a(paramCanvas, a(6), a(7));
        }
        while ((f - this.jdField_a_of_type_Float <= 0.0F) && (this.jdField_b_of_type_Ycc != null))
        {
          if (paramCanvas == null) {
            break label125;
          }
          this.jdField_b_of_type_Ycc.a(paramCanvas, f, a(7));
          return;
          label102:
          this.jdField_a_of_type_Ycc.a(paramRenderBuffer, a(6), a(7));
        }
      }
    }
    label125:
    this.jdField_b_of_type_Ycc.a(paramRenderBuffer, f, a(7));
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Ycc != null) && (this.jdField_b_of_type_Ycc != null) && (this.jdField_b_of_type_Ycc.jdField_a_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_Ycc;
      this.jdField_a_of_type_Ycc = this.jdField_b_of_type_Ycc;
      this.jdField_b_of_type_Ycc = ((ycc)localObject);
      a(3, this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float);
      a(6, a(6) + ((ycc)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesTextItem.jdField_a_of_type_Float);
      if (((ycc)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesTextItem.jdField_a_of_type_JavaLangString != null)
      {
        int i = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = (((ycc)localObject).jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesTextItem.jdField_a_of_type_JavaLangString.length() + i);
      }
      localObject = a(this.jdField_b_of_type_Int + jdField_a_of_type_Int);
      this.jdField_b_of_type_Ycc.a((String)localObject);
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Ycc != null) && (a(6) + this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float <= 0.0F)) {
      h();
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    a(paramCanvas, null);
  }
  
  public void a(RenderBuffer paramRenderBuffer)
  {
    a(null, paramRenderBuffer);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (paramString.equals(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_JavaLangString = paramString;
      paramString = a(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_Ycc != null)
      {
        this.jdField_a_of_type_Ycc.a(paramString);
        a(3, this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float);
        a(4, this.jdField_a_of_type_Ycc.b.b);
      }
      paramString = a(this.jdField_b_of_type_Int + jdField_a_of_type_Int);
      if (this.jdField_b_of_type_Ycc != null) {
        this.jdField_b_of_type_Ycc.a(paramString);
      }
    } while ((this.jdField_a_of_type_Ycc == null) || (a(6) + this.jdField_a_of_type_Ycc.b.jdField_a_of_type_Float >= 0.0F));
    h();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ycc != null)
    {
      this.jdField_a_of_type_Ycc.a();
      this.jdField_a_of_type_Ycc = null;
    }
    if (this.jdField_b_of_type_Ycc != null)
    {
      this.jdField_b_of_type_Ycc.a();
      this.jdField_b_of_type_Ycc = null;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    a(this.jdField_a_of_type_JavaLangString);
    a(6, this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ybx
 * JD-Core Version:    0.7.0.1
 */