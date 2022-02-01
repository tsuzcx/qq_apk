import com.tencent.av.redpacket.AVRedPacketManager;

public class isw
  extends isq
{
  public isw()
  {
    this.c = new itc[6];
    this.mDuration = 1000L;
    setAlpha(255);
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_lightning_" + (i + 1) + ".png"));
      i += 1;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setBounds(0, paramInt2 - paramInt1 * 120 / 750, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isw
 * JD-Core Version:    0.7.0.1
 */