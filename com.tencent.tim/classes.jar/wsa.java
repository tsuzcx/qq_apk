import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wsa
  implements wrv
{
  public static final wrv.a<wsa> a;
  private wrw jdField_a_of_type_Wrw;
  private wrx.a jdField_a_of_type_Wrx$a;
  private Rect bi = new Rect();
  private Rect bj = new Rect();
  public int mID = -1;
  private Paint mPaint = new Paint();
  private Path mPath = new Path();
  private int mTextureID = -1;
  private ArrayList<wsa.a> qs = new ArrayList();
  private List<wrx.a> rQ = new ArrayList();
  
  static
  {
    jdField_a_of_type_Wrv$a = new wsb();
  }
  
  public wsa(wru paramwru)
  {
    paramwru.readInt();
    if (this.rQ != null) {
      paramwru.a(this.rQ, wrx.a.jdField_a_of_type_Wrv$a);
    }
    paramwru.a(this.qs, wsa.a.jdField_a_of_type_Wrv$a);
    int i = paramwru.readInt();
    fx(paramwru.readInt(), i);
    this.bi = paramwru.r();
    this.bj = paramwru.r();
    this.jdField_a_of_type_Wrx$a = ((wrx.a)paramwru.a(wrx.a.jdField_a_of_type_Wrv$a));
    this.mID = paramwru.readInt();
    this.jdField_a_of_type_Wrw = new HalfAlgorithm();
    if (this.rQ != null)
    {
      this.jdField_a_of_type_Wrw.a(this.rQ, this.mPath, this.qs);
      this.rQ = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wrw = null;
      if (!this.bj.equals(this.bi)) {
        break;
      }
      QLog.d("PathDrawer", 2, "data area equal draw area, no scale.");
      return;
      this.mPath.reset();
    }
    float f = aL();
    QLog.d("PathDrawer", 2, "scale:" + f);
    f(f, false);
  }
  
  public wsa(wrx paramwrx, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    this.mID = paramwrx.mID;
    this.bi.set(0, 0, paramInt1, paramInt2);
    this.rQ.addAll(paramwrx.bJ());
    this.jdField_a_of_type_Wrw = new HalfAlgorithm();
    this.jdField_a_of_type_Wrw.d(paramInt5, paramInt6, paramFloat);
    this.jdField_a_of_type_Wrw.a(paramwrx.bJ(), this.mPath, this.qs, 1000);
    QLog.d("PathDrawer", 2, "after transPath, segments count:" + this.qs.size());
    this.jdField_a_of_type_Wrw = null;
    if (paramwrx.wa() > 0) {
      this.jdField_a_of_type_Wrx$a = new wrx.a(paramwrx.a());
    }
    fx(paramwrx.getColor(), paramwrx.getTextureID());
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      C(0, 0, paramInt3, paramInt4);
      return;
    }
    this.bj.set(this.bi);
  }
  
  private void a(Canvas paramCanvas, wrx.a parama)
  {
    if ((paramCanvas != null) && (parama != null) && (this.mPaint != null))
    {
      this.mPaint.setStrokeWidth(parama.getWidth() / 2.0F);
      paramCanvas.drawCircle(parama.getX(), parama.getY(), parama.getWidth() / 4.0F, this.mPaint);
    }
  }
  
  private void a(Canvas paramCanvas, wsa.a parama)
  {
    if (paramCanvas != null)
    {
      this.mPaint.setStrokeWidth(parama.getWidth());
      paramCanvas.drawPath(parama.getPath(), this.mPaint);
    }
  }
  
  private float aL()
  {
    float f1 = this.bj.width() * 1.0F / this.bi.width();
    float f2 = this.bj.height() * 1.0F / this.bi.height();
    if (f1 < f2) {
      return f1;
    }
    return f2;
  }
  
  private int b(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    int j = this.qs.size();
    if (j == 0) {
      i = -1;
    }
    long l;
    do
    {
      do
      {
        return i;
        if (j != 1) {
          break label67;
        }
        l = ((wsa.a)this.qs.get(0)).getTime();
        if (!paramBoolean) {
          break;
        }
      } while (l >= paramLong);
      return -1;
    } while (l > paramLong);
    return -1;
    label67:
    if (((wsa.a)this.qs.get(j - 1)).getTime() < paramLong) {
      return -1;
    }
    i = 0;
    int k;
    if (j > i)
    {
      k = (j + i) / 2;
      l = ((wsa.a)this.qs.get(k)).getTime();
      if (l == paramLong)
      {
        if (paramBoolean) {
          return k - ((wsa.a)this.qs.get(k)).getSeq();
        }
        j = k + 1;
        for (;;)
        {
          if ((j >= this.qs.size()) || (l < ((wsa.a)this.qs.get(j)).getTime()))
          {
            i = j;
            if (j != this.qs.size()) {
              break;
            }
            return -1;
          }
          j += 1;
        }
      }
      if (l < paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      break;
      if (l > paramLong)
      {
        k -= ((wsa.a)this.qs.get(k)).getSeq();
        j = i;
        i = k;
        continue;
        return j - ((wsa.a)this.qs.get(j)).getSeq();
      }
      else
      {
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  private void fx(int paramInt1, int paramInt2)
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setXfermode(null);
    if (paramInt2 > 0) {}
    setColor(paramInt1);
    setTexture(paramInt2);
  }
  
  public void C(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 == 0) || (paramInt4 - paramInt2 == 0)) {}
    while (this.bj == null) {
      return;
    }
    if ((this.bj.width() == paramInt3 - paramInt1) && (this.bj.height() == paramInt4 - paramInt2))
    {
      QLog.d("PathDrawer", 2, "draw area not change.");
      return;
    }
    if ((!this.bj.isEmpty()) && (!this.bi.isEmpty()) && (!this.bj.equals(this.bi))) {}
    for (float f1 = aL();; f1 = 1.0F)
    {
      this.bj.set(paramInt1, paramInt2, paramInt3, paramInt4);
      QLog.d("PathDrawer", 2, "setArea:" + this.bj);
      float f2 = aL();
      QLog.d("PathDrawer", 2, "scale:" + f2 + "  Old:" + f1);
      if ((f2 / f1 - 1.0F < 1.0E-006D) && (f2 / f1 - 1.0F > -1.0E-006D)) {
        QLog.d("PathDrawer", 2, "scale no change, return:");
      }
      f(f2 / f1, true);
      return;
    }
  }
  
  public void a(wru paramwru, int paramInt)
  {
    paramwru.writeInt(1);
    paramwru.writeTypedList(this.rQ);
    paramwru.writeTypedList(this.qs);
    paramwru.writeInt(this.mTextureID);
    paramwru.writeInt(this.mPaint.getColor());
    paramwru.g(this.bi);
    paramwru.g(this.bj);
    paramwru.a(this.jdField_a_of_type_Wrx$a);
    paramwru.writeInt(this.mID);
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return false;
    }
    if (paramInt1 > paramInt2) {
      return false;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (this.qs.size() == 0))
      {
        if (this.jdField_a_of_type_Wrx$a != null) {
          a(paramCanvas, this.jdField_a_of_type_Wrx$a);
        }
        return true;
      }
      if (this.qs.size() == 0)
      {
        if ((paramInt1 == 0) && (this.jdField_a_of_type_Wrx$a != null)) {
          a(paramCanvas, this.jdField_a_of_type_Wrx$a);
        }
        return false;
      }
      int i = paramInt2;
      if (paramInt2 > this.qs.size()) {
        i = this.qs.size();
      }
      while (paramInt1 < i)
      {
        a(paramCanvas, (wsa.a)this.qs.get(paramInt1));
        paramInt1 += 1;
      }
      return i < this.qs.size();
    }
  }
  
  public boolean a(Canvas paramCanvas, long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      return false;
    }
    if (paramLong1 > paramLong2) {
      return false;
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    if ((paramLong2 == 0L) && (this.qs.size() == 0))
    {
      if (this.jdField_a_of_type_Wrx$a != null) {
        a(paramCanvas, this.jdField_a_of_type_Wrx$a);
      }
      return true;
    }
    if (this.qs.size() == 0)
    {
      if ((l == 0L) && (this.jdField_a_of_type_Wrx$a != null)) {
        a(paramCanvas, this.jdField_a_of_type_Wrx$a);
      }
      return false;
    }
    if ((paramLong2 == 0L) && (this.qs.size() != 0)) {
      return true;
    }
    int j = b(l, true);
    int i = b(paramLong2, false);
    if (j < 0) {
      return true;
    }
    if (i < 0) {
      i = this.qs.size();
    }
    for (;;)
    {
      if (j < i)
      {
        a(paramCanvas, (wsa.a)this.qs.get(j));
        j += 1;
        continue;
        if (i == j)
        {
          if (this.qs.size() <= i) {
            return true;
          }
          a(paramCanvas, (wsa.a)this.qs.get(j));
          return false;
        }
      }
      else
      {
        return i < this.qs.size();
      }
    }
  }
  
  public void aD(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Wrw != null)
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_Wrw.a(this.mPath, this.qs);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Wrw.H(this.qs, 0);
    this.jdField_a_of_type_Wrw = null;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    if (this.jdField_a_of_type_Wrw != null) {
      this.jdField_a_of_type_Wrw.b(paramFloat1, paramFloat2, paramFloat3, paramLong, this.mPath, this.qs);
    }
  }
  
  public void cbs()
  {
    this.rQ = null;
  }
  
  public void d(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_Wrx$a = new wrx.a(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (this.jdField_a_of_type_Wrw == null) {
      this.jdField_a_of_type_Wrw = new HalfAlgorithm();
    }
    this.jdField_a_of_type_Wrw.a(paramFloat1, paramFloat2, paramFloat3, 0L, this.mPath, this.qs);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.qs.size() == 0) {
      if (this.jdField_a_of_type_Wrx$a != null) {
        a(paramCanvas, this.jdField_a_of_type_Wrx$a);
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.qs.iterator();
      while (localIterator.hasNext()) {
        a(paramCanvas, (wsa.a)localIterator.next());
      }
    }
  }
  
  public long ep()
  {
    long l = 0L;
    if (this.qs.size() > 0) {
      l = ((wsa.a)this.qs.get(this.qs.size() - 1)).getTime();
    }
    while (this.jdField_a_of_type_Wrx$a == null) {
      return l;
    }
    return 0L;
  }
  
  public void f(float paramFloat, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!this.mPath.isEmpty())
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(paramFloat, paramFloat);
      localObject2 = new Path();
      ((Path)localObject2).addPath(this.mPath, (Matrix)localObject1);
      this.mPath = ((Path)localObject2);
    }
    if (this.qs.size() > 0)
    {
      localObject1 = this.qs.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wsa.a)((Iterator)localObject1).next();
        ((wsa.a)localObject2).k(paramFloat);
        if (paramBoolean) {
          ((wsa.a)localObject2).setWidth(((wsa.a)localObject2).getWidth() * paramFloat);
        }
      }
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Wrx$a != null)) {
      this.jdField_a_of_type_Wrx$a.k(paramFloat);
    }
  }
  
  public int getSegmentCount()
  {
    if (this.qs.size() > 0) {
      return this.qs.size();
    }
    if (this.jdField_a_of_type_Wrx$a != null) {
      return 1;
    }
    return 0;
  }
  
  public int getTexture()
  {
    return this.mTextureID;
  }
  
  public boolean isValid()
  {
    return ((this.qs.size() > 0) && (!this.mPath.isEmpty())) || ((this.qs.size() == 0) && (this.jdField_a_of_type_Wrx$a != null));
  }
  
  public void reset()
  {
    this.mPaint.reset();
    this.mPath.reset();
    this.qs.clear();
    this.jdField_a_of_type_Wrx$a = null;
    this.mTextureID = -1;
  }
  
  public void setColor(int paramInt)
  {
    setTexture(-1);
    this.mPaint.setColor(paramInt);
  }
  
  public void setTexture(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mPaint.setShader(null);
      Object localObject = wrq.a().getBitmap(0, paramInt);
      if (localObject != null)
      {
        localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        if (localObject != null) {
          this.mPaint.setShader((Shader)localObject);
        }
      }
    }
    for (;;)
    {
      this.mTextureID = paramInt;
      return;
      this.mPaint.setShader(null);
    }
  }
  
  public static class a
    implements wrv
  {
    public static final wrv.a<a> a = new wsc();
    private Path mPath;
    private int mSeq;
    private long mTime;
    private float qd;
    private float qe;
    
    public a(Path paramPath)
    {
      this.mPath = paramPath;
    }
    
    public a(wru paramwru)
    {
      paramwru.readInt();
      this.qd = paramwru.readFloat();
      this.mTime = paramwru.readLong();
      this.mSeq = paramwru.readInt();
      this.qe = paramwru.readFloat();
    }
    
    public void a(Path paramPath)
    {
      this.mPath = paramPath;
    }
    
    public void a(wru paramwru, int paramInt)
    {
      paramwru.writeInt(1);
      paramwru.writeFloat(this.qd);
      paramwru.writeLong(this.mTime);
      paramwru.writeInt(this.mSeq);
      paramwru.writeFloat(this.qe);
    }
    
    public void a(a parama)
    {
      if (this.mPath != null)
      {
        this.mPath.addPath(parama.mPath);
        this.qe += parama.qe;
      }
    }
    
    public void as(float paramFloat)
    {
      this.qe = paramFloat;
    }
    
    public float getLength()
    {
      return this.qe;
    }
    
    public Path getPath()
    {
      return this.mPath;
    }
    
    public int getSeq()
    {
      return this.mSeq;
    }
    
    public long getTime()
    {
      return this.mTime;
    }
    
    public float getWidth()
    {
      return this.qd;
    }
    
    public void k(float paramFloat)
    {
      if (this.mPath == null) {
        return;
      }
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      Path localPath = new Path();
      localPath.addPath(this.mPath, localMatrix);
      this.mPath = localPath;
    }
    
    public void setSeq(int paramInt)
    {
      this.mSeq = paramInt;
    }
    
    public void setTime(long paramLong)
    {
      this.mTime = paramLong;
    }
    
    public void setWidth(float paramFloat)
    {
      this.qd = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */