import android.os.Handler;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.utils.UITools;

public class bho
  implements Runnable
{
  public bho(GAudioNotifyCenter paramGAudioNotifyCenter) {}
  
  public void run()
  {
    Object localObject = this.a;
    ((GAudioNotifyCenter)localObject).b += 1L;
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1000L);
    }
    if (this.a.e)
    {
      localObject = UITools.a(this.a.b);
      if (this.a.jdField_a_of_type_Int == 3)
      {
        String str = Long.toString(this.a.jdField_a_of_type_Long);
        this.a.a(29, 0, str, (String)localObject);
      }
    }
    else
    {
      return;
    }
    this.a.a(29, 0, this.a.c, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bho
 * JD-Core Version:    0.7.0.1
 */