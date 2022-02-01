import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class aigx
  extends acfd
{
  aigx(aigv paramaigv) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("FetchOpenIdManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)paramObject).longValue();
      paramObject = aigv.a(this.this$0).keySet().toArray();
      int i = paramObject.length - 1;
      while (i >= 0)
      {
        Long localLong = (Long)paramObject[i];
        this.this$0.y(localLong.longValue(), l);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aigx
 * JD-Core Version:    0.7.0.1
 */