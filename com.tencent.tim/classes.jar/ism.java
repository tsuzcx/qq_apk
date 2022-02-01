import com.tencent.av.redpacket.AVRedPacketManager;

public class ism
  extends isq
{
  public int HEIGHT = 667;
  
  public ism()
  {
    this.c = new itc[8];
    this.mDuration = 1250L;
  }
  
  public void c(AVRedPacketManager paramAVRedPacketManager)
  {
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_excellent_" + i * 2 + ".png"));
      i += 1;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(0, 0, paramInt1, this.HEIGHT * paramInt1 / 750);
  }
  
  public void update(long paramLong)
  {
    super.update(paramLong);
    long l = this.mStartTime;
    int i = 0;
    if (paramLong - l <= this.mDuration) {
      i = 255;
    }
    setAlpha(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ism
 * JD-Core Version:    0.7.0.1
 */