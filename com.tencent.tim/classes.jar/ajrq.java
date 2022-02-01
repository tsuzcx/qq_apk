import android.graphics.Path;
import android.view.View;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ajrq
  extends ahym
{
  public ajrq(HeartLayout paramHeartLayout)
  {
    super(paramHeartLayout);
  }
  
  public Path a(int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger, View paramView)
  {
    Random localRandom = this.mRandom;
    Path localPath = new Path();
    label95:
    label107:
    int i;
    int j;
    int k;
    int m;
    if (!this.a.ciZ) {
      if ((paramInt1 < 0) || (paramInt1 > paramView.getWidth()))
      {
        this.a.dcg = ((paramView.getWidth() - (int)(20.0F * this.a.density)) / 2);
        if ((paramInt2 >= 0) && (paramInt2 <= paramView.getHeight())) {
          break label415;
        }
        this.a.dch = ((int)(20.0F * this.a.density));
        if (!this.mRandom.nextBoolean()) {
          break label447;
        }
        paramInt1 = 1;
        i = paramInt1 * (localRandom.nextInt(this.a.dci) + this.a.dcj);
        j = paramInt1 * (localRandom.nextInt(this.a.dci) + this.a.dcj);
        k = paramView.getHeight() - this.a.dch;
        paramInt1 = (int)(paramAtomicInteger.intValue() * 4 * this.a.density);
        paramInt2 = this.a.dcm;
        paramInt2 = localRandom.nextInt(this.a.dcl) + (paramInt1 + paramInt2);
        m = paramInt2 / this.a.dck;
        paramInt1 = k - paramInt2;
        if (paramInt1 >= 0) {
          break label666;
        }
        paramInt1 = 0;
      }
    }
    label653:
    label666:
    for (;;)
    {
      paramInt2 = k - paramInt2 / 2;
      if (paramInt2 < 0) {
        paramInt2 = 0;
      }
      for (;;)
      {
        localPath.moveTo(this.a.dcg, k);
        localPath.cubicTo(this.a.dcg, k - m, this.a.dcg + i, paramInt2 + m, this.a.dcg + i, paramInt2);
        localPath.moveTo(this.a.dcg + i, paramInt2);
        if (paramInt2 - m >= 0) {
          localPath.cubicTo(this.a.dcg + i, paramInt2 - m, this.a.dcg + j, paramInt1 + m, this.a.dcg + j, paramInt1);
        }
        return localPath;
        this.a.dcg = (paramInt1 - (int)(20.0F * this.a.density / 3.0F));
        break;
        label415:
        this.a.dch = (paramView.getHeight() - paramInt2 + (int)(20.0F * this.a.density / 3.0F));
        break label95;
        label447:
        paramInt1 = -1;
        break label107;
        k = this.a.dcq;
        m = this.a.dcp;
        int n = this.a.dcn / 2;
        int i1;
        int i2;
        int i3;
        int i4;
        if (this.mRandom.nextBoolean())
        {
          i = 1;
          i1 = localRandom.nextInt(this.a.dci);
          i2 = this.a.dcj;
          i3 = localRandom.nextInt(this.a.dci);
          i4 = this.a.dcj;
          j = Math.abs(k - paramInt2) / (this.mRandom.nextInt(3) + 2);
          if (k <= paramInt2) {
            break label653;
          }
          j = k - j;
        }
        for (;;)
        {
          localPath.moveTo(paramInt1 - this.a.dcn / 2, paramInt2 - this.a.dco / 2);
          localPath.cubicTo(i * (i1 + i2) + paramInt1, j, paramInt1 - i * (i3 + i4), j, m - n, k);
          return localPath;
          i = -1;
          break;
          j += k;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrq
 * JD-Core Version:    0.7.0.1
 */