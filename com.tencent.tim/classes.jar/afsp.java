import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class afsp
  extends aczc.b
{
  afsp(afsi paramafsi, String paramString, boolean paramBoolean, afxt paramafxt)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    afsi localafsi;
    if (this.a != null)
    {
      localafsi = this.this$0;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      afsi.a(localafsi, bool, paramSosoLbsInfo, this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsp
 * JD-Core Version:    0.7.0.1
 */