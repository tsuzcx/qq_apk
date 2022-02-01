import java.util.ArrayList;
import java.util.List;

public class wrx
{
  private int mColor;
  public int mID = -1;
  private int mTextureID = -1;
  private ArrayList<wrx.a> qr = new ArrayList();
  
  public wrx.a a()
  {
    if (this.qr.size() > 0) {
      return (wrx.a)this.qr.get(0);
    }
    return null;
  }
  
  public wrx.a b()
  {
    if (this.qr.size() > 0) {
      return (wrx.a)this.qr.get(this.qr.size() - 1);
    }
    return null;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    wrx.a locala = new wrx.a();
    locala.setX(paramFloat1);
    locala.setY(paramFloat2);
    locala.setWidth(paramFloat3);
    locala.setTime(paramLong);
    this.qr.add(locala);
  }
  
  public void b(wrx paramwrx)
  {
    this.mColor = paramwrx.mColor;
    this.mTextureID = paramwrx.mTextureID;
    this.mID = paramwrx.mID;
    this.qr.addAll(paramwrx.bJ());
  }
  
  public ArrayList<wrx.a> bJ()
  {
    return this.qr;
  }
  
  public void cbs()
  {
    this.qr.clear();
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public int getTextureID()
  {
    return this.mTextureID;
  }
  
  public long getTotalTime()
  {
    if (this.qr.size() > 0) {
      return ((wrx.a)this.qr.get(this.qr.size() - 1)).getTime();
    }
    return 0L;
  }
  
  public void gh(List<wrx.a> paramList)
  {
    if (paramList != null) {
      this.qr.addAll(paramList);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setTextureID(int paramInt)
  {
    this.mTextureID = paramInt;
  }
  
  public int wa()
  {
    return this.qr.size();
  }
  
  public static class a
    implements wrv
  {
    public static final wrv.a<a> a = new wry();
    private long mTime;
    private float mWidth;
    private float mX;
    private float mY;
    
    public a() {}
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
    {
      c(paramFloat1, paramFloat2, paramFloat3, paramLong);
    }
    
    public a(wru paramwru)
    {
      paramwru.readInt();
      this.mX = paramwru.readFloat();
      this.mY = paramwru.readFloat();
      this.mWidth = paramwru.readFloat();
      this.mTime = paramwru.readLong();
    }
    
    public a(a parama)
    {
      if (parama != null) {
        c(parama.getX(), parama.getY(), parama.getWidth(), 0L);
      }
    }
    
    public void a(wru paramwru, int paramInt)
    {
      paramwru.writeInt(1);
      paramwru.writeFloat(this.mX);
      paramwru.writeFloat(this.mY);
      paramwru.writeFloat(this.mWidth);
      paramwru.writeLong(this.mTime);
    }
    
    public void c(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
    {
      this.mWidth = paramFloat3;
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.mTime = paramLong;
    }
    
    public long getTime()
    {
      return this.mTime;
    }
    
    public float getWidth()
    {
      return this.mWidth;
    }
    
    public float getX()
    {
      return this.mX;
    }
    
    public float getY()
    {
      return this.mY;
    }
    
    public void k(float paramFloat)
    {
      this.mX *= paramFloat;
      this.mY *= paramFloat;
      this.mWidth *= paramFloat;
    }
    
    public void setTime(long paramLong)
    {
      this.mTime = paramLong;
    }
    
    public void setWidth(float paramFloat)
    {
      this.mWidth = paramFloat;
    }
    
    public void setX(float paramFloat)
    {
      this.mX = paramFloat;
    }
    
    public void setY(float paramFloat)
    {
      this.mY = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wrx
 * JD-Core Version:    0.7.0.1
 */