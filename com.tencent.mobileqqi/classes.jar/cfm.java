import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.gaudio.GAudioObserver;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class cfm
  extends GAudioObserver
{
  private cfm(ChatActivity paramChatActivity) {}
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioObserver", 2, "OnAudioChatting uinType: " + paramInt + ", peerUin: " + paramString1);
    }
    if ((this.a.a.jdField_a_of_type_Int != 3000) && (paramInt == this.a.a.jdField_a_of_type_Int) && (this.a.a.jdField_a_of_type_JavaLangString.equals(paramString1))) {
      ChatActivity.a(this.a, paramInt, paramString1, paramString2);
    }
    super.a(paramInt, paramString1, paramString2);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    try
    {
      if (paramLong1 == Long.parseLong(this.a.a.jdField_a_of_type_JavaLangString)) {
        ChatActivity.a(this.a, this.a.a.jdField_a_of_type_JavaLangString, 3, 0L);
      }
      super.a(paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberInfo", localNumberFormatException);
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    int i;
    String str;
    if ((this.a.a.jdField_a_of_type_JavaLangString.equals(paramString1)) && (ChatActivity.b(this.a) != null))
    {
      TextView localTextView = (TextView)ChatActivity.b(this.a).findViewById(2131231106);
      localTextView.setVisibility(0);
      i = this.a.b.a().a();
      if (localTextView != null)
      {
        str = "";
        if (this.a.a.jdField_a_of_type_Int != 3000) {
          break label153;
        }
        long l = Long.valueOf(paramString1).longValue();
        l = this.a.b.a().a(l);
        String.format(this.a.getString(2131561858), new Object[] { Long.valueOf(l) });
        localTextView.setText(paramString2);
      }
    }
    return;
    label153:
    if (i == 2) {
      paramString1 = this.a.getString(2131560249);
    }
    for (;;)
    {
      i = this.a.getResources().getColor(2131362073);
      this.a.a(null, paramString1, i);
      break;
      paramString1 = str;
      if (i == 1) {
        paramString1 = this.a.getString(2131560248);
      }
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    try
    {
      if (paramLong1 == Long.parseLong(this.a.a.jdField_a_of_type_JavaLangString)) {
        ChatActivity.a(this.a, this.a.a.jdField_a_of_type_JavaLangString, 1, paramLong2);
      }
      super.b(paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberJoin", localNumberFormatException);
        }
      }
    }
  }
  
  protected void c(long paramLong1, long paramLong2)
  {
    try
    {
      if (paramLong1 == Long.parseLong(this.a.a.jdField_a_of_type_JavaLangString)) {
        ChatActivity.a(this.a, this.a.a.jdField_a_of_type_JavaLangString, 2, paramLong2);
      }
      super.c(paramLong1, paramLong2);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioObserver", 2, "OnMemberQuit", localNumberFormatException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cfm
 * JD-Core Version:    0.7.0.1
 */