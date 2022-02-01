import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class lvm
  implements anlz
{
  lvm(lvl paramlvl, String paramString) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    QLog.i("PTSSoLoader", 1, "[onLoadResult], resCode = " + paramInt);
    if (paramInt == 0)
    {
      QLog.i("PTSSoLoader", 1, "[onLoadResult], load so succeeded, name = " + this.val$name + ", version = " + anlp.nw(this.val$name));
      lvl.a(this.b, true);
    }
    lvl.a(this.b, this.val$name, paramInt, anlp.nw(this.val$name));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvm
 * JD-Core Version:    0.7.0.1
 */