import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.av.doodle.MySurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ims
  extends imu
{
  private Queue<ims.a> i = new LinkedList();
  private Paint mPaint = new Paint();
  
  public ims()
  {
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(-65536);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public void aom()
  {
    this.i.offer(new ims.a(this.mPathMeasure.getLength()));
  }
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.mPaint.setColor(this.mColor);
    float f4 = 0.01111111F * this.mScreenWidth;
    this.mPaint.setStrokeWidth(f4);
    this.mPaint.setStyle(Paint.Style.STROKE);
    int j;
    if ((this.lV != -1L) && (paramMySurfaceView.mCurTime - this.lV > 1200L))
    {
      j = (int)(255L - (paramMySurfaceView.mCurTime - this.lV - 1200L) * 255L / 800L);
      this.mPaint.setAlpha(j);
      this.mPaint.setMaskFilter(null);
      if (this.mPathMeasure.getLength() <= 0.0F) {
        break label259;
      }
      j = 1;
      label128:
      if (j == 0) {
        break label265;
      }
      paramCanvas.drawPath(this.mPath, this.mPaint);
    }
    long l;
    Object localObject1;
    ims.a locala;
    Object localObject2;
    label259:
    label265:
    float f2;
    float f1;
    for (;;)
    {
      if ((paramBoolean) && (this.i.size() > 0))
      {
        l = SystemClock.elapsedRealtime() - 500L;
        localObject1 = null;
        paramMySurfaceView = null;
        locala = (ims.a)((LinkedList)this.i).getLast();
        Iterator localIterator = this.i.iterator();
        for (;;)
        {
          localObject2 = paramMySurfaceView;
          if (!localIterator.hasNext()) {
            break;
          }
          paramMySurfaceView = (ims.a)localIterator.next();
          localObject2 = paramMySurfaceView;
          if (paramMySurfaceView.mTime - l >= 0L) {
            break;
          }
          localObject1 = paramMySurfaceView;
        }
        this.mPaint.setAlpha(255);
        break;
        j = 0;
        break label128;
        paramCanvas.drawPoint(this.d.x, this.d.y, this.mPaint);
        continue;
        f2 = locala.gi;
        if (localObject2 == null) {
          break label684;
        }
        if ((localObject1 != null) && (localObject1 != localObject2)) {
          f1 = (((ims.a)localObject1).gi * (float)(((ims.a)localObject2).mTime - l) + ((ims.a)localObject2).gi * (float)(l - ((ims.a)localObject1).mTime)) / (float)(((ims.a)localObject2).mTime - ((ims.a)localObject1).mTime);
        }
      }
    }
    for (;;)
    {
      float f3 = 0.01481482F * this.mScreenWidth * (float)(locala.mTime - l) / 500.0F;
      f4 /= 2.0F;
      paramMySurfaceView = new float[2];
      localObject1 = new float[2];
      localObject2 = new Path();
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(-1);
      ((Path)localObject2).setFillType(Path.FillType.WINDING);
      float f5 = f2 - f1;
      float f6 = (f3 - f4) / f5;
      j = this.mColor;
      j = this.mColor;
      float f7 = 0.005555556F * this.mScreenWidth;
      for (;;)
      {
        if (f1 <= locala.gi)
        {
          this.mPathMeasure.getPosTan(f1, paramMySurfaceView, (float[])localObject1);
          float f8 = (f2 - f1) / f5;
          int k = imr.a(new int[] { j, -1 }, 1.0F - f8);
          this.mPaint.setColor(k);
          paramCanvas.drawCircle(paramMySurfaceView[0], paramMySurfaceView[1], f3 - (f2 - f1) * f6, this.mPaint);
          f1 += f7;
          continue;
          f1 = ((ims.a)localObject2).gi;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "doDrawDoodle, mScreenWidth[" + this.mScreenWidth + "], maxRadius[" + f3 + "], minRadius[" + f4 + "], mPoint[" + this.d.x + ", " + this.d.y + "], startAnimationPathPointDistance[" + f7 + "]");
      }
      return;
      label684:
      f1 = 0.0F;
    }
  }
  
  public void ch(long paramLong) {}
  
  public class a
  {
    public float gi;
    public long mTime;
    
    public a(float paramFloat)
    {
      this.gi = paramFloat;
      this.mTime = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ims
 * JD-Core Version:    0.7.0.1
 */