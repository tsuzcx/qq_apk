import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class afgk
  implements affx.a
{
  afgk(afgf paramafgf) {}
  
  public void jS(List<afmi> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (afgf.a(this.c) != null) {
      afgf.a(this.c).obtainMessage(206, localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgk
 * JD-Core Version:    0.7.0.1
 */