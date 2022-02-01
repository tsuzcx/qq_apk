import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class abno
  extends acfd
{
  abno(abnn paramabnn) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((abnn.a(this.a) != null) && (abnn.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)abnn.a(this.a).remove(paramString + "nick")).intValue();
      this.a.u(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abno
 * JD-Core Version:    0.7.0.1
 */