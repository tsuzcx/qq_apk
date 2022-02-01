import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;

public class adii
  extends adim
{
  public long Tl;
  public adii.b a;
  public adii.c a;
  
  public adii()
  {
    this.jdField_a_of_type_Adii$c = new adii.c();
    this.jdField_a_of_type_Adii$b = new adii.b();
    reset();
  }
  
  public void reset()
  {
    QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecogResult.reset");
    this.Sl = 4096L;
    this.Tl = 0L;
    this.jdField_a_of_type_Adii$c.reset();
    this.jdField_a_of_type_Adii$b.reset();
  }
  
  public String toString()
  {
    return "ARLocalGestureCircleRecogResult{recogType = " + this.Sl + ", frameIdx = " + this.Tl + ", gestureResult = " + this.jdField_a_of_type_Adii$c + ", circleResult = " + this.jdField_a_of_type_Adii$b + '}';
  }
  
  public static class a
  {
    public boolean bNu = true;
    public float r = 0.0F;
    public float x = 0.0F;
    public float y = 0.0F;
  }
  
  public static class b
  {
    public adii.a a = new adii.a();
    public PointF[] b = new PointF[1000];
    public int cGA;
    public int cGB;
    public int cGC;
    public int cGv;
    public int cGw;
    public int cGx = 80;
    public int cGy = 8;
    public int cGz;
    public PointF[] d = new PointF[1000];
    public int[] kw = new int[1000];
    public int lastState = -2;
    public int state = -2;
    
    public void reset()
    {
      this.state = -2;
      this.lastState = -2;
      this.a.x = 0.0F;
      this.a.y = 0.0F;
      this.a.r = 0.0F;
      this.cGv = 0;
      this.cGw = 0;
      this.cGy = 10;
      this.cGz = 0;
      this.cGA = 0;
      this.cGB = 0;
      this.cGC = 0;
    }
    
    public String toString()
    {
      return "ARCircleResult{, state = " + this.state + ", lastState = " + this.lastState + ", pointCnt = " + this.cGv + ", lastPointCnt = " + this.cGw + ", genIdx = " + this.cGz + ", gesturePointCnt = " + this.cGA + ", stillPointCnt = " + this.cGB + ", goodPointCnt = " + this.cGC + ", circle(r,x,y,c) = (" + (int)this.a.r + "," + (int)this.a.x + "," + (int)this.a.y + "," + this.a.bNu + ")" + '}';
    }
  }
  
  public static class c
  {
    public PointF[] b;
    public boolean bNv;
    public int cFS;
    public int cGv;
    public int mode = -1;
    public int state = -1;
    public String type = "";
    
    public c()
    {
      this.b = new PointF[1000];
      reset();
    }
    
    public c(int paramInt)
    {
      this.b = new PointF[paramInt];
      reset();
    }
    
    public void reset()
    {
      this.bNv = false;
      this.state = -1;
      this.type = "";
      this.cGv = 0;
      this.cFS = 0;
      this.mode = -1;
    }
    
    public String toString()
    {
      if (this.cGv > 0) {}
      for (String str = "(" + (int)this.b[(this.cGv - 1)].x + "," + (int)this.b[(this.cGv - 1)].y + ")";; str = "(-1,-1)") {
        return "ARGestureResult{, state = " + this.state + ", type = " + this.type + ", pointCnt = " + this.cGv + ", newPoint(x,y) = " + str + ", mode = " + this.mode + '}';
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adii
 * JD-Core Version:    0.7.0.1
 */