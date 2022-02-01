import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/RIJBlackWhiteModeHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "blackWhiteConfig", "", "getBlackWhiteConfig", "()Z", "setBlackWhiteConfig", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "addBlackWhiteMode", "", "canvas", "Landroid/graphics/Canvas;", "needConfig", "drawCanvas", "Lkotlin/Function1;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uad
{
  @NotNull
  private static final Paint jdField_a_of_type_AndroidGraphicsPaint;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "RIJBlackWhiteModeHelper";
  public static final uad a;
  private static boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Uad = new uad();
    jdField_a_of_type_JavaLangString = "RIJBlackWhiteModeHelper";
    jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    jdField_a_of_type_AndroidGraphicsPaint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(localColorMatrix));
  }
  
  public final void a(@NotNull Canvas paramCanvas, boolean paramBoolean, @NotNull Function1<? super Canvas, Unit> paramFunction1)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "drawCanvas");
    if (Aladdin.get(320).getIntegerFromString("is_black_white_mode", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      if ((!paramBoolean) || (jdField_a_of_type_Boolean)) {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      paramCanvas.saveLayer(null, jdField_a_of_type_AndroidGraphicsPaint, 31);
      paramFunction1.invoke(paramCanvas);
      paramCanvas.restore();
      return;
    }
    paramFunction1.invoke(paramCanvas);
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */