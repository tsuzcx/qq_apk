import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aiqx
  implements aira.a
{
  aiqx(aiqs paramaiqs, int paramInt, String paramString) {}
  
  public aiqn b()
  {
    if (aiqs.a(this.this$0) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new aiqn(this.this$0.app.getCurrentUin(), aiqs.a(this.this$0), aiqs.a(this.this$0));
  }
  
  public Pair<Integer, String> o()
  {
    return new Pair(Integer.valueOf(this.deX), this.bfK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqx
 * JD-Core Version:    0.7.0.1
 */