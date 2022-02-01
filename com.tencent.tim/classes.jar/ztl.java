import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ztl
  extends ztk
  implements zrq.a
{
  private ztk.a a;
  private Map<Long, Float> ir = new ConcurrentHashMap();
  
  public ztl()
  {
    this.jdField_a_of_type_Zrt = new zrq();
    ((zrq)this.jdField_a_of_type_Zrt).a(this);
  }
  
  public void aNX()
  {
    if (this.jdField_a_of_type_Ztn == null) {
      super.aNX();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
      }
      if ((this.jdField_a_of_type_Ztn.btg) && (this.jdField_a_of_type_Ztn.btf) && (VL()))
      {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "file[" + this.jdField_a_of_type_Ztn.id + "] is downloading return!");
        return;
      }
      super.aNX();
    } while ((!this.jdField_a_of_type_Ztn.btg) || (!this.jdField_a_of_type_Ztn.bth) || (this.jdField_a_of_type_Ztn.cJ.length <= 0) || (TextUtils.isEmpty(this.jdField_a_of_type_Ztn.cJ[0])));
  }
  
  public void b(ztk.a parama)
  {
    this.jdField_a_of_type_Ztk$a = parama;
    ((zrq)this.jdField_a_of_type_Zrt).a(new ztm(this));
  }
  
  public void crN()
  {
    if (this.jdField_a_of_type_Ztn == null) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("PauseDebug", 1, "OnFileVideoPause : " + this.jdField_a_of_type_Ztn.id);
        }
        if (!this.isCancel) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      return;
    } while ((this.entrance != 3) || (!this.jdField_a_of_type_Ztn.btg) || (!this.jdField_a_of_type_Ztn.isPlayed) || (this.b == null));
    this.jdField_a_of_type_Ztn.isPlayed = false;
    Bundle localBundle = new Bundle();
    localBundle.putFloat("progress", g(this.jdField_a_of_type_Ztn.id));
    this.b.onFileVideoStatusChange(this.jdField_a_of_type_Ztn.id, 10, localBundle);
    this.jdField_a_of_type_Zrt.azR();
  }
  
  public long eE()
  {
    if (zrq.class.isInstance(this.jdField_a_of_type_Zrt)) {
      return ((zrq)this.jdField_a_of_type_Zrt).eE();
    }
    return 0L;
  }
  
  public float g(long paramLong)
  {
    if (this.ir.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.ir.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void stopPlayAudio()
  {
    if (this.jdField_a_of_type_Zrt != null) {
      this.jdField_a_of_type_Zrt.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztl
 * JD-Core Version:    0.7.0.1
 */