import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import cooperation.qzone.widgetai.WidgetAIFileUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdBlurUtils;", "", "()V", "TAG", "", "cropBitmap", "Landroid/graphics/Bitmap;", "bitmap", "cropWidth", "", "cropHeight", "getBitmapFromURL", "imageUrl", "getLargeImgAdBlurBitmap", "context", "Landroid/content/Context;", "originWidth", "originHeight", "blurWidth", "blurHeight", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvt
{
  private static final String a = "AdBlurUtils";
  public static final tvt a;
  
  static
  {
    jdField_a_of_type_Tvt = new tvt();
    jdField_a_of_type_JavaLangString = "AdBlurUtils";
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.getWidth();
    paramBitmap.getHeight();
    return Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - paramInt1) / 2, (paramBitmap.getHeight() - paramInt2) / 2, paramInt1, paramInt2);
  }
  
  @Nullable
  public final Bitmap a(@Nullable Bitmap paramBitmap, @NotNull Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramBitmap != null)
    {
      twp.a(jdField_a_of_type_JavaLangString, "1:originWidth = " + paramInt1 + "  originHeight = " + paramInt2 + "  blurWidth = " + paramInt3 + "  blurHeight = " + paramInt4);
      paramBitmap = yoy.a(paramBitmap, paramInt1, paramInt2, false);
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder().append("2:originBPWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "originBP");
      twp.a((String)localObject1, paramBitmap.getWidth() + "  originBPHeight = " + paramBitmap.getHeight());
      paramContext = bfvo.a(paramContext, paramBitmap, paramInt3 / paramInt1, 20.0F);
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("3:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      twp.a((String)localObject1, paramContext.getWidth() + "  blurBitmapHeight = " + paramContext.getHeight());
      paramContext = jdField_a_of_type_Tvt.a(paramContext, paramInt3, paramInt4);
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("4:blurBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "blurBitmap");
      twp.a((String)localObject1, paramContext.getWidth() + "  blurBitmapHeight = " + paramContext.getHeight());
      localObject1 = WidgetAIFileUtil.mergeBitmap(paramContext, paramBitmap, (paramInt3 - paramInt1) / 2, 0, 1);
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("5:mergeBitmapWidth = ");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mergeBitmap");
      twp.a((String)localObject2, ((Bitmap)localObject1).getWidth() + "  mergeBitmapHeight = " + ((Bitmap)localObject1).getHeight());
      paramBitmap.recycle();
      paramContext.recycle();
      return localObject1;
    }
    return null;
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString)
  {
    try
    {
      paramString = new URL(paramString).openConnection();
      if (paramString == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.net.HttpURLConnection");
      }
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
      paramString = (HttpURLConnection)paramString;
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */