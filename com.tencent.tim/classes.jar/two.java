import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.layer.Layer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class two
  extends twe
{
  @Nullable
  private ttg<Integer, Integer> F;
  @Nullable
  private ttg<Float, Float> G;
  @Nullable
  private ttg<Float, Float> H;
  private final trx jdField_a_of_type_Trx;
  private final trz jdField_a_of_type_Trz;
  private final ttv jdField_a_of_type_Ttv;
  private final Map<tuf, List<tsp>> contentsForCharacter = new HashMap();
  @Nullable
  private ttg<Integer, Integer> f;
  private final Paint fillPaint = new twp(this, 1);
  private final char[] m = new char[1];
  private final Matrix matrix = new Matrix();
  private final RectF rectF = new RectF();
  private final Paint strokePaint = new twq(this, 1);
  
  two(trz paramtrz, Layer paramLayer)
  {
    super(paramtrz, paramLayer);
    this.jdField_a_of_type_Trz = paramtrz;
    this.jdField_a_of_type_Trx = paramLayer.a();
    this.jdField_a_of_type_Ttv = paramLayer.a().a();
    this.jdField_a_of_type_Ttv.b(this);
    a(this.jdField_a_of_type_Ttv);
    paramtrz = paramLayer.a();
    if ((paramtrz != null) && (paramtrz.a != null))
    {
      this.f = paramtrz.a.g();
      this.f.b(this);
      a(this.f);
    }
    if ((paramtrz != null) && (paramtrz.b != null))
    {
      this.F = paramtrz.b.g();
      this.F.b(this);
      a(this.F);
    }
    if ((paramtrz != null) && (paramtrz.c != null))
    {
      this.G = paramtrz.c.g();
      this.G.b(this);
      a(this.G);
    }
    if ((paramtrz != null) && (paramtrz.d != null))
    {
      this.H = paramtrz.d.g();
      this.H.b(this);
      a(this.H);
    }
  }
  
  private List<tsp> a(tuf paramtuf)
  {
    if (this.contentsForCharacter.containsKey(paramtuf)) {
      return (List)this.contentsForCharacter.get(paramtuf);
    }
    List localList = paramtuf.getShapes();
    int j = localList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      tvz localtvz = (tvz)localList.get(i);
      localArrayList.add(new tsp(this.jdField_a_of_type_Trz, this, localtvz));
      i += 1;
    }
    this.contentsForCharacter.put(paramtuf, localArrayList);
    return localArrayList;
  }
  
  private void a(char paramChar, tuc paramtuc, Canvas paramCanvas)
  {
    this.m[0] = paramChar;
    if (paramtuc.strokeOverFill)
    {
      a(this.m, this.fillPaint, paramCanvas);
      a(this.m, this.strokePaint, paramCanvas);
      return;
    }
    a(this.m, this.strokePaint, paramCanvas);
    a(this.m, this.fillPaint, paramCanvas);
  }
  
  private void a(tuc paramtuc, Matrix paramMatrix, tue paramtue, Canvas paramCanvas)
  {
    float f2 = paramtuc.size / 100.0F;
    float f3 = twy.getScale(paramMatrix);
    String str = paramtuc.text;
    int i = 0;
    float f4;
    float f5;
    float f1;
    while (i < str.length())
    {
      int j = tuf.hashFor(str.charAt(i), paramtue.getFamily(), paramtue.getStyle());
      tuf localtuf = (tuf)this.jdField_a_of_type_Trx.U().get(Integer.valueOf(j));
      if (localtuf == null)
      {
        i += 1;
      }
      else
      {
        a(localtuf, paramMatrix, f2, paramtuc, paramCanvas);
        f4 = (float)localtuf.getWidth();
        f5 = this.jdField_a_of_type_Trx.aE();
        f1 = paramtuc.tracking / 10.0F;
        if (this.H == null) {
          break label182;
        }
        f1 = ((Float)this.H.getValue()).floatValue() + f1;
      }
    }
    label182:
    for (;;)
    {
      paramCanvas.translate(f1 * f3 + f4 * f2 * f5 * f3, 0.0F);
      break;
      return;
    }
  }
  
  private void a(tuc paramtuc, tue paramtue, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f2 = twy.getScale(paramMatrix);
    paramMatrix = this.jdField_a_of_type_Trz.getTypeface(paramtue.getFamily(), paramtue.getStyle());
    if (paramMatrix == null) {
      return;
    }
    paramtue = paramtuc.text;
    tsk localtsk = this.jdField_a_of_type_Trz.a();
    if (localtsk != null) {
      paramtue = localtsk.getTextInternal(paramtue);
    }
    for (;;)
    {
      this.fillPaint.setTypeface(paramMatrix);
      this.fillPaint.setTextSize(paramtuc.size * this.jdField_a_of_type_Trx.aE());
      this.strokePaint.setTypeface(this.fillPaint.getTypeface());
      this.strokePaint.setTextSize(this.fillPaint.getTextSize());
      int i = 0;
      label114:
      float f3;
      float f1;
      if (i < paramtue.length())
      {
        char c = paramtue.charAt(i);
        a(c, paramtuc, paramCanvas);
        this.m[0] = c;
        f3 = this.fillPaint.measureText(this.m, 0, 1);
        f1 = paramtuc.tracking / 10.0F;
        if (this.H == null) {
          break label221;
        }
        f1 = ((Float)this.H.getValue()).floatValue() + f1;
      }
      label221:
      for (;;)
      {
        paramCanvas.translate(f1 * f2 + f3, 0.0F);
        i += 1;
        break label114;
        break;
      }
    }
  }
  
  private void a(tuf paramtuf, Matrix paramMatrix, float paramFloat, tuc paramtuc, Canvas paramCanvas)
  {
    paramtuf = a(paramtuf);
    int i = 0;
    if (i < paramtuf.size())
    {
      Path localPath = ((tsp)paramtuf.get(i)).getPath();
      localPath.computeBounds(this.rectF, false);
      this.matrix.set(paramMatrix);
      this.matrix.preScale(paramFloat, paramFloat);
      localPath.transform(this.matrix);
      if (paramtuc.strokeOverFill)
      {
        drawGlyph(localPath, this.fillPaint, paramCanvas);
        drawGlyph(localPath, this.strokePaint, paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        drawGlyph(localPath, this.strokePaint, paramCanvas);
        drawGlyph(localPath, this.fillPaint, paramCanvas);
      }
    }
  }
  
  private void a(char[] paramArrayOfChar, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawText(paramArrayOfChar, 0, 1, 0.0F, 0.0F, paramPaint);
  }
  
  private void drawGlyph(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.jdField_a_of_type_Trz.useTextGlyphs()) {
      paramCanvas.setMatrix(paramMatrix);
    }
    tuc localtuc = (tuc)this.jdField_a_of_type_Ttv.getValue();
    tue localtue = (tue)this.jdField_a_of_type_Trx.getFonts().get(localtuc.fontName);
    if (localtue == null) {
      return;
    }
    if (this.f != null)
    {
      this.fillPaint.setColor(((Integer)this.f.getValue()).intValue());
      if (this.F == null) {
        break label221;
      }
      this.strokePaint.setColor(((Integer)this.F.getValue()).intValue());
      label114:
      paramInt = ((Integer)this.b.d().getValue()).intValue() * 255 / 100;
      this.fillPaint.setAlpha(paramInt);
      this.strokePaint.setAlpha(paramInt);
      if (this.G == null) {
        break label236;
      }
      this.strokePaint.setStrokeWidth(((Float)this.G.getValue()).floatValue());
      label181:
      if (!this.jdField_a_of_type_Trz.useTextGlyphs()) {
        break label269;
      }
      a(localtuc, paramMatrix, localtue, paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.fillPaint.setColor(localtuc.color);
      break;
      label221:
      this.strokePaint.setColor(localtuc.strokeColor);
      break label114;
      label236:
      float f1 = twy.getScale(paramMatrix);
      this.strokePaint.setStrokeWidth(f1 * (localtuc.strokeWidth * this.jdField_a_of_type_Trx.aE()));
      break label181;
      label269:
      a(localtuc, localtue, paramMatrix, paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     two
 * JD-Core Version:    0.7.0.1
 */