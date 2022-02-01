import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1;
import com.tencent.qphone.base.util.QLog;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mer
{
  @NotNull
  private meg.a jdField_a_of_type_Meg$a;
  @Nullable
  private meg.b jdField_a_of_type_Meg$b;
  private Handler handler = new Handler(Looper.getMainLooper());
  private Runnable runnable;
  
  public mer(@NotNull meg.a parama)
  {
    this.jdField_a_of_type_Meg$a = parama;
  }
  
  private long c(long paramLong)
  {
    return (TimeZone.getDefault().getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  private boolean r(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (c(paramLong1) == c(paramLong2));
  }
  
  public void a(meg.b paramb)
  {
    this.jdField_a_of_type_Meg$b = paramb;
  }
  
  public void aOM()
  {
    int i = this.jdField_a_of_type_Meg$a.pd();
    if (!this.jdField_a_of_type_Meg$a.Ds()) {}
    while ((i <= 100) && (this.jdField_a_of_type_Meg$a.oT() + i < this.jdField_a_of_type_Meg$a.oU())) {
      return;
    }
    String str = this.jdField_a_of_type_Meg$a.jF();
    this.jdField_a_of_type_Meg$a.q(str, this.jdField_a_of_type_Meg$a.pc(), i);
    this.jdField_a_of_type_Meg$a.rF(0);
    this.jdField_a_of_type_Meg$a.nA("");
  }
  
  public void detachView()
  {
    this.jdField_a_of_type_Meg$b = null;
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public void r(@NotNull String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("RIJRedPacketProgressPresenter", 1, "start timing: rowkey: " + paramString);
    if (this.jdField_a_of_type_Meg$b != null)
    {
      this.jdField_a_of_type_Meg$b.setState(1);
      this.jdField_a_of_type_Meg$b.setProgress(this.jdField_a_of_type_Meg$a.oT() % this.jdField_a_of_type_Meg$a.pe() / this.jdField_a_of_type_Meg$a.pe() * 100.0F);
      this.jdField_a_of_type_Meg$a.rG(paramInt1);
      this.handler.removeCallbacksAndMessages(null);
      this.runnable = new RIJRedPacketProgressPresenter.1(this, paramString, paramInt2);
      this.handler.post(this.runnable);
    }
  }
  
  public void refresh()
  {
    if (this.jdField_a_of_type_Meg$b == null) {
      return;
    }
    int i = this.jdField_a_of_type_Meg$a.oT();
    int j = this.jdField_a_of_type_Meg$a.pe();
    if ((i <= 0) || (i >= this.jdField_a_of_type_Meg$a.oU()))
    {
      this.jdField_a_of_type_Meg$b.setState(0);
      return;
    }
    this.jdField_a_of_type_Meg$b.setState(1);
    this.jdField_a_of_type_Meg$b.setProgress(i % j / j * 100.0F);
  }
  
  public void stopTiming()
  {
    this.handler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mer
 * JD-Core Version:    0.7.0.1
 */