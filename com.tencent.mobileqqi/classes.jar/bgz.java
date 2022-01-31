import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgz
  extends BroadcastReceiver
{
  public bgz(VideoAppInterface paramVideoAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    label11:
    label488:
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                break label11;
                break label11;
                break label11;
                break label11;
                do
                {
                  return;
                } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
                if (QLog.isColorLevel()) {
                  QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "recv gaudio msg broadcast: " + paramIntent.getAction());
                }
                if (!paramIntent.getAction().equals("tencent.video.q2v.MultiVideo")) {
                  break label488;
                }
                i = paramIntent.getIntExtra("type", -1);
                if (QLog.isColorLevel()) {
                  QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "GAudioMsgReceiver type: " + i);
                }
                if (i != 26) {
                  break;
                }
                l = paramIntent.getLongExtra("discussId", 0L);
              } while ((!this.a.jdField_a_of_type_ComTencentAvVideoController.f) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a != l));
              this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a);
              this.a.jdField_a_of_type_ComTencentAvVideoController.a();
              return;
              if (i == 27)
              {
                paramContext = paramIntent.getByteArrayExtra("buffer");
                this.a.jdField_a_of_type_ComTencentAvVideoController.b(paramContext);
                return;
              }
              if (i == 30)
              {
                paramContext = paramIntent.getByteArrayExtra("buffer");
                this.a.jdField_a_of_type_ComTencentAvVideoController.c(paramContext);
                return;
              }
              if (i == 24)
              {
                l = paramIntent.getLongExtra("discussId", 0L);
                paramContext = paramIntent.getStringExtra("cmdUin");
                paramIntent = paramIntent.getStringArrayExtra("uins");
                this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, paramContext, paramIntent);
                return;
              }
            } while (i != 31);
            l = paramIntent.getLongExtra("discussId", 0L);
            paramContext = paramIntent.getStringExtra("cmdUin");
            paramIntent = paramIntent.getStringArrayExtra("uins");
            if ((paramIntent != null) && (paramIntent.length != 0)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "GAudioMsgReceiver-->uinlist is null");
          return;
          str1 = paramIntent[0];
          str2 = this.a.a();
          if (QLog.isColorLevel()) {
            QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "TYPE_GAUDIO_MEMBER_KICKOUT-->discuss id=" + l + "cmdUin =" + paramContext + "outUin=" + str1 + "selfUin=" + str2 + "uinList.size=" + paramIntent.length);
          }
        } while ((!this.a.jdField_a_of_type_ComTencentAvVideoController.f) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a != l) || (str1.compareTo(str2) != 0));
        this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a);
        this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        return;
        if (!paramIntent.getAction().equals("tencent.video.q2v.AddDiscussMember")) {
          break;
        }
      } while (!paramIntent.getBooleanExtra("result", false));
      l = paramIntent.getLongExtra("roomId", this.a.jdField_a_of_type_ComTencentAvVideoController.a);
      paramContext = paramIntent.getStringArrayListExtra("newMemberUin");
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(l, paramContext);
      return;
    } while ((!paramIntent.getAction().equals("tencent.video.q2v.SwitchToDiscuss")) || (!paramIntent.getBooleanExtra("result", false)));
    long l = paramIntent.getLongExtra("roomId", 0L);
    paramContext = paramIntent.getLongArrayExtra("memberUin");
    this.a.jdField_a_of_type_ComTencentAvVideoController.b(l, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgz
 * JD-Core Version:    0.7.0.1
 */