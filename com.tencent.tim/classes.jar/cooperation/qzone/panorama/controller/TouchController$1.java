package cooperation.qzone.panorama.controller;

import avws;
import java.util.Timer;
import java.util.TimerTask;

public class TouchController$1
  extends TimerTask
{
  private int[] tI = { 0, 0 };
  
  public TouchController$1(avws paramavws, int paramInt1, int[] paramArrayOfInt, int paramInt2) {}
  
  public void run()
  {
    if (this.eyU == 1) {
      if (this.tJ[0] <= 0)
      {
        this.tI[0] = 1;
        if (this.eyV != 1) {
          break label202;
        }
        if (this.tJ[1] > 0) {
          break label178;
        }
        this.tI[1] = 1;
      }
    }
    for (;;)
    {
      if ((this.tI[1] == 1) && (this.tI[0] == 1))
      {
        avws.a(this.this$0).cancel();
        cancel();
      }
      float f1 = this.tJ[0];
      float f2 = avws.a(this.this$0);
      avws.a(this.this$0, 0.0F, f1 * f2);
      return;
      this.tI[0] = 0;
      this.tJ[0] -= 3;
      break;
      if (this.tJ[0] >= 0)
      {
        this.tI[0] = 1;
        break;
      }
      this.tI[0] = 0;
      this.tJ[0] += 3;
      break;
      label178:
      this.tI[1] = 0;
      this.tJ[1] -= 3;
      continue;
      label202:
      if (this.tJ[1] >= 0)
      {
        this.tI[1] = 1;
      }
      else
      {
        this.tI[1] = 0;
        this.tJ[1] += 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.panorama.controller.TouchController.1
 * JD-Core Version:    0.7.0.1
 */