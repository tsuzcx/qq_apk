import com.tencent.qphone.base.util.QLog;

class acht
  extends aquy
{
  acht(achs paramachs) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + paramaquz.httpCode + ", url: " + paramaquz.key);
    }
    int i = paramaquz.key.indexOf("?");
    String str;
    if (i == -1)
    {
      str = paramaquz.key;
      if (!achr.boE.contains(str)) {
        break label105;
      }
      this.this$0.d(paramaquz);
    }
    label105:
    do
    {
      return;
      str = paramaquz.key.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.this$0.e(paramaquz);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + paramaquz.key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acht
 * JD-Core Version:    0.7.0.1
 */