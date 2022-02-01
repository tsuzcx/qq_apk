import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TeamWorkTransparentShareActivity;
import com.tencent.tim.teamworkforgroup.GPadInfo;

public class aulr
  extends aumy
{
  public aulr(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString, GPadInfo paramGPadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, " onAddGroupTeamWorkLink success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      QQToast.a(this.this$0.app.getApp(), 2, this.this$0.getString(2131689833), 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulr
 * JD-Core Version:    0.7.0.1
 */