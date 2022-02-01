import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.BaseApplication;

class acju
  implements jjq.a
{
  acju(acjq paramacjq, long paramLong1, int paramInt, long paramLong2) {}
  
  public void a(int paramInt1, jjq.c paramc, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (this.b.b != null)
      {
        this.b.b.a(3, this.Bf, this.cxx, 0, 0, 20, 1);
        this.b.b.w(this.Bf, true);
        this.b.b.b(21, 1, Long.valueOf(this.Bf).longValue(), 0L);
      }
      VideoMsgTools.a(this.b.mApp, 1, 13, false, Long.toString(this.Bf), Long.toString(this.QH), false, null, false, this.cxx, new Object[0]);
      if (this.cxx == 2) {
        new avfi(this.b.mApp).a(new acjv(this));
      }
    }
    else
    {
      return;
    }
    new iuq(BaseApplication.getContext()).a(new acjw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acju
 * JD-Core Version:    0.7.0.1
 */