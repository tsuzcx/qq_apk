import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class auun
{
  private static final int etW = Color.parseColor("#6BCB1F");
  private static final int etX = Color.parseColor("#9CF05B");
  private static final int etY = Color.parseColor("#50A80C");
  private static final int etZ = Color.parseColor("#FA4242");
  private static final int eua = Color.parseColor("#FFA194");
  private static final int eub = Color.parseColor("#E91D32");
  private int bottomMargin;
  private Paint cW = new Paint(1);
  private int etU;
  private int etV;
  private int height;
  private LinearGradient i;
  private LinearGradient j;
  private BitmapDrawable k;
  private int leftMargin;
  private int mType;
  private int topMargin;
  private int width;
  
  private void a(Canvas paramCanvas, Context paramContext)
  {
    paramContext = paramContext.getResources();
    if (this.mType == 0) {}
    for (int m = 2130838185;; m = 2130839674)
    {
      paramContext = paramContext.getDrawable(m);
      paramContext.setBounds(0, 0, this.width, this.height);
      paramContext.draw(paramCanvas);
      return;
    }
  }
  
  private void g(Canvas paramCanvas, int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 100);
    Paint localPaint = this.cW;
    if (paramInt > 20) {}
    for (LinearGradient localLinearGradient = this.i;; localLinearGradient = this.j)
    {
      localPaint.setShader(localLinearGradient);
      paramInt = this.etU * paramInt / 100;
      paramCanvas.drawRect(new Rect(this.leftMargin, this.topMargin, paramInt + this.leftMargin, this.height - this.bottomMargin), this.cW);
      return;
    }
  }
  
  private void init(int paramInt)
  {
    float f3 = 4.0F;
    float f2 = 3.0F;
    this.mType = paramInt;
    Object localObject = BaseApplicationImpl.getContext().getApplicationContext();
    this.leftMargin = wja.dp2px(1.0F, ((Context)localObject).getResources());
    if (this.mType == 0)
    {
      f1 = 3.0F;
      this.topMargin = wja.dp2px(f1, ((Context)localObject).getResources());
      f1 = f3;
      if (this.mType == 0) {
        f1 = 3.0F;
      }
      this.bottomMargin = wja.dp2px(f1, ((Context)localObject).getResources());
      f1 = f2;
      if (this.mType == 0) {
        f1 = 2.0F;
      }
      paramInt = wja.dp2px(f1, ((Context)localObject).getResources());
      if (this.mType != 0) {
        break label352;
      }
    }
    label352:
    for (float f1 = 12.0F;; f1 = 16.0F)
    {
      int m = wja.dp2px(f1, ((Context)localObject).getResources());
      this.height = m;
      this.width = m;
      this.etU = (this.width - this.leftMargin - paramInt);
      f1 = this.leftMargin;
      f2 = this.topMargin;
      f3 = this.leftMargin;
      float f4 = this.height - this.bottomMargin;
      paramInt = etW;
      m = etX;
      int n = etY;
      int i1 = etY;
      localObject = Shader.TileMode.MIRROR;
      this.i = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, m, n, i1 }, null, (Shader.TileMode)localObject);
      f1 = this.leftMargin;
      f2 = this.topMargin;
      f3 = this.leftMargin;
      f4 = this.height - this.bottomMargin;
      paramInt = etZ;
      m = eua;
      n = eub;
      i1 = eub;
      localObject = Shader.TileMode.MIRROR;
      this.j = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, m, n, i1 }, null, (Shader.TileMode)localObject);
      return;
      f1 = 4.0F;
      break;
    }
  }
  
  public Drawable i(int paramInt1, int paramInt2)
  {
    if ((this.etV == paramInt1) && (this.k != null) && (paramInt2 == this.mType)) {
      return this.k;
    }
    init(paramInt2);
    this.etV = paramInt1;
    long l = System.currentTimeMillis();
    Context localContext = BaseApplicationImpl.getContext().getApplicationContext();
    Bitmap localBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    a(localCanvas, localContext);
    g(localCanvas, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineBatteryProducer", 2, "createBatteryDrawable cost time : " + (System.currentTimeMillis() - l));
    }
    this.k = new BitmapDrawable(localContext.getResources(), localBitmap);
    this.k.setBounds(0, 0, this.width, this.height);
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auun
 * JD-Core Version:    0.7.0.1
 */