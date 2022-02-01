import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class akzw
{
  public static int[] mr = new int[0];
  public static Bitmap[] q;
  public int agh;
  public int agi;
  boolean cvy = false;
  public int dqG;
  public int dqH;
  public int dqI;
  public int dqJ;
  int dqK = 0;
  public Bitmap fG;
  public Bitmap fH;
  Bitmap fI = null;
  public int height;
  public int imageHeight;
  public int imageWidth;
  private Paint mPaint = new Paint();
  private RectF rectF = new RectF();
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
  private Rect src = new Rect();
  long startTime;
  public int width;
  public int x;
  public int y;
  
  public akzw(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.imageHeight = paramInt8;
    this.imageWidth = paramInt7;
    this.x = paramInt3;
    this.y = paramInt4;
    this.agh = paramInt5;
    this.agi = paramInt6;
    init(paramContext);
  }
  
  public void aa(Bitmap paramBitmap)
  {
    if (this.fG == null)
    {
      this.fG = paramBitmap;
      this.fH = paramBitmap;
      return;
    }
    this.fH = paramBitmap;
  }
  
  public void ab(Bitmap paramBitmap)
  {
    this.fI = paramBitmap;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.imageHeight = paramInt8;
    this.imageWidth = paramInt7;
    this.x = paramInt3;
    this.y = paramInt4;
    this.agh = paramInt5;
    this.agi = paramInt6;
  }
  
  public void cYv()
  {
    this.cvy = false;
  }
  
  public boolean draw(Canvas paramCanvas)
  {
    long l1 = 880L;
    if (this.fG == null) {
      return false;
    }
    paramCanvas.save();
    paramCanvas.translate(this.x, this.y);
    paramCanvas.scale(this.scaleX, this.scaleY, this.width / 2, this.height / 2);
    this.rectF.set(this.agh, this.agi, this.agh + this.imageWidth, this.agi + this.imageHeight);
    this.src.set(0, 0, this.fG.getWidth(), this.fG.getHeight());
    paramCanvas.drawBitmap(this.fG, this.src, this.rectF, null);
    if (this.fI != null)
    {
      this.src.set(this.width - this.dqI - this.dqG, this.height - this.dqJ - this.dqH, this.width - this.dqI, this.height - this.dqJ);
      paramCanvas.drawBitmap(this.fI, null, this.src, null);
    }
    long l2;
    if (this.cvy)
    {
      l2 = System.currentTimeMillis() - this.startTime;
      if (l2 >= 440L) {
        this.fG = this.fH;
      }
      if (l2 < 880L) {
        break label436;
      }
      cYv();
    }
    for (;;)
    {
      this.dqK = ((int)(l1 / 40L));
      if (this.dqK >= mr.length) {
        this.dqK %= mr.length;
      }
      int i = (int)(this.imageWidth * 0.35F / 2.0F);
      int j = (int)(this.imageHeight * 0.35F / 2.0F);
      this.rectF.set(this.agh - i, this.agi - j, i + this.agh + this.imageWidth, j + (this.agi + this.imageHeight));
      if (q[this.dqK] != null)
      {
        this.src.set(0, 0, q[this.dqK].getWidth(), q[this.dqK].getHeight());
        paramCanvas.drawBitmap(q[this.dqK], this.src, this.rectF, null);
      }
      paramCanvas.restore();
      return true;
      paramCanvas.restore();
      return false;
      label436:
      l1 = l2;
    }
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void init(Context paramContext)
  {
    if (q == null)
    {
      q = new Bitmap[mr.length];
      int i = 0;
      try
      {
        for (;;)
        {
          int j = mr.length;
          if (i < j) {
            try
            {
              q[i] = BitmapFactory.decodeResource(paramContext.getResources(), mr[i]);
              i += 1;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              for (;;)
              {
                localOutOfMemoryError.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
        this.mPaint.setAntiAlias(true);
      }
    }
  }
  
  public void setLogo(Bitmap paramBitmap)
  {
    this.fG = paramBitmap;
    this.fH = paramBitmap;
  }
  
  public void startAnim()
  {
    this.cvy = true;
    this.dqK = 0;
    this.startTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzw
 * JD-Core Version:    0.7.0.1
 */