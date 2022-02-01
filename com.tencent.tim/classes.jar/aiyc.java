import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1;
import com.tencent.qphone.base.util.QLog;

public abstract class aiyc
{
  aiyb a;
  public aiyc.a a;
  public aiyc.b a;
  public volatile boolean cmH;
  public int dgI = 1000 / this.fps;
  public int fps = 8;
  
  public aiyc()
  {
    init();
  }
  
  public void a(aiyb paramaiyb)
  {
    this.jdField_a_of_type_Aiyb = paramaiyb;
  }
  
  public void a(aiyc.a parama)
  {
    this.jdField_a_of_type_Aiyc$a = parama;
  }
  
  public void a(aiyc.b paramb)
  {
    this.jdField_a_of_type_Aiyc$b = paramb;
  }
  
  public void ank()
  {
    this.cmH = false;
  }
  
  public abstract void dvr();
  
  protected void init()
  {
    this.cmH = false;
  }
  
  protected void reSet() {}
  
  public void release() {}
  
  public void setFps(int paramInt)
  {
    this.fps = paramInt;
    this.dgI = (1000 / paramInt);
  }
  
  public void startDecoder()
  {
    reSet();
    if (!this.cmH) {}
    try
    {
      new Thread(new MagicfaceDecoder.1(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagicfaceDecoder", 2, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public static abstract interface a
  {
    public abstract void dvm();
    
    public abstract void dvn();
  }
  
  public static abstract interface b
  {
    public abstract void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat);
    
    public abstract void b(int[] paramArrayOfInt, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyc
 * JD-Core Version:    0.7.0.1
 */