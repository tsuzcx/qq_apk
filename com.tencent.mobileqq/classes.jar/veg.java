import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRead.ConfidentCircleMemberRsp;

class veg
  implements zxa<QQCircleRead.ConfidentCircleMemberRsp>
{
  veg(vee paramvee) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleRead.ConfidentCircleMemberRsp paramConfidentCircleMemberRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramConfidentCircleMemberRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QLog.e("QCircleTopAuthPart", 1, "confirmCircleMemberShip error:" + paramString);
      }
      return;
    }
    QLog.e("QCircleTopAuthPart", 1, "confirmCircleMemberShip success!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veg
 * JD-Core Version:    0.7.0.1
 */