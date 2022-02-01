import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.concurrent.Executor;

class atsp
  implements audt.a
{
  atsp(atso paramatso, FileManagerEntity paramFileManagerEntity, Runnable paramRunnable) {}
  
  public void Za(String paramString)
  {
    this.d.fileName = paramString;
    audx.a.getExecutor().execute(this.val$job);
  }
  
  public void Zb(String paramString)
  {
    this.d.strApkPackageName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atsp
 * JD-Core Version:    0.7.0.1
 */