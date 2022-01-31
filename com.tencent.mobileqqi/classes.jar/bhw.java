import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

@SuppressLint({"HandlerLeak"})
public class bhw
  extends Handler
{
  public bhw(QQGAudioCtrl paramQQGAudioCtrl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.a.mVideoController == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQGAudioCtrl", 2, "handleMessage-->mVideoControl = null");
          }
          return;
        }
        i = paramMessage.what;
        paramMessage = (bhx)paramMessage.obj;
        if (paramMessage == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("QQGAudioCtrl", 2, "handleMessage-->NativeEventParams is null");
          continue;
        }
        arrayOfByte = paramMessage.jdField_a_of_type_ArrayOfByte;
      }
      finally {}
      byte[] arrayOfByte;
      long l1 = paramMessage.jdField_a_of_type_Long;
      long l2 = paramMessage.jdField_b_of_type_Long;
      int k = paramMessage.jdField_a_of_type_Int;
      int m = paramMessage.jdField_b_of_type_Int;
      int j = paramMessage.c;
      if (QLog.isColorLevel())
      {
        QLog.d("QQGAudioCtrl", 2, "GroupId= " + l2 + "multiAVType=" + k + "MultiSubType=" + m + "relationType=" + j + "info=" + l1 + "eventId=" + i);
        break label1063;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        this.a.onRecvUserList(6, l2, paramMessage, l1, m);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (i == 72)
        {
          this.a.mVideoController.a(l2, paramMessage, 2);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 3);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (i == 74)
        {
          this.a.mVideoController.a(l2, paramMessage, 8);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 9);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (i == 76)
        {
          this.a.mVideoController.a(l2, paramMessage, 4);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 5);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (i == 78)
        {
          this.a.mVideoController.a(l2, paramMessage, 6);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 7);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (i == 70)
        {
          this.a.mVideoController.a(l2, paramMessage, 0);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 1);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        if (paramMessage == null) {
          continue;
        }
        if (i == 42)
        {
          this.a.mVideoController.a(l2, paramMessage, 10);
          continue;
        }
        this.a.mVideoController.a(l2, paramMessage, 11);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQGAudioCtrl", 2, "EV_GA_SDK_Creat_SUC.");
        }
        if (j == 2)
        {
          if (this.a.mInviteGAudioUinList == null)
          {
            QLog.e("QQGAudioCtrl", 2, "mInviteGAudioUinList == null");
            continue;
          }
          if (this.a.mInviteGAudioUinList.size() <= 0) {
            continue;
          }
          k = this.a.mInviteGAudioUinList.size();
          paramMessage = new long[k];
          i = 0;
          while (i < k)
          {
            paramMessage[i] = ((Long)this.a.mInviteGAudioUinList.get(i)).longValue();
            i += 1;
          }
          this.a.invite(j, this.a.mGroupId, paramMessage, this.a.mIsSwitchGroup);
          this.a.mVideoController.j(l2);
          continue;
        }
        this.a.invite(j, this.a.mGroupId, null, this.a.mIsSwitchGroup);
        continue;
        this.a.mVideoController.f(l2);
        continue;
        this.a.mVideoController.e(l2);
        continue;
        this.a.mVideoController.a(l2, 17);
        continue;
        this.a.mVideoController.a(l2, 16);
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QQGAudioCtrl", 2, "quit room failed.groupid=" + l2 + "reason=" + i);
        continue;
        this.a.mVideoController.a(l2, 15);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        this.a.onRecvUserList(44, l2, paramMessage, 0L, 0);
        continue;
        this.a.mVideoController.g(l2);
        continue;
        paramMessage = QQGAudioCtrl.access$000(this.a, arrayOfByte);
        this.a.onRecvUserList(44, l2, paramMessage, 0L, 0);
        continue;
        this.a.mVideoController.k(l2);
        continue;
        this.a.mVideoController.c(61, l1);
        continue;
        this.a.mVideoController.j(91);
        continue;
        this.a.mVideoController.j(92);
        continue;
        this.a.mVideoController.j(90);
        continue;
        this.a.mVideoController.k(93);
        continue;
        this.a.mVideoController.k(95);
        continue;
        this.a.mVideoController.k(94);
        continue;
        this.a.mVideoController.d(96, l1);
        continue;
        this.a.mVideoController.d(97, l1);
        continue;
        this.a.mVideoController.d(98, l1);
        continue;
      }
      label1063:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhw
 * JD-Core Version:    0.7.0.1
 */