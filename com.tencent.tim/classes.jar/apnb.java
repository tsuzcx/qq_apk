import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apnb
  extends apmr
{
  public apnb(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.mType = 11;
  }
  
  @Nullable
  public apmr.a a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = apab.a.a(paramInt1, paramLong1, paramInt2);
    String str1 = this.context.getString(2131700848);
    paramList = "";
    boolean bool2 = false;
    MessageRecord localMessageRecord = this.app.b().d(this.sessionInfo.aTl, this.sessionInfo.cZ, paramLong1);
    if (localMessageRecord != null) {
      paramList = localMessageRecord.senderuin;
    }
    boolean bool1 = bool2;
    if (paramLong2 != apmz.arI)
    {
      bool1 = bool2;
      if (paramLong1 < paramLong2) {
        bool1 = true;
      }
    }
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = this.TAG + ".troop.special_msg.confess_to_me";
      localStringBuilder = new StringBuilder().append("需要定位的第一条消息是否已经拉到本地：");
      if (localMessageRecord == null) {
        break label188;
      }
    }
    label188:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d(str2, 2, bool2 + ", isShow = " + bool1);
      if (!bool1) {
        break;
      }
      return new apmr.a(true, str1, paramObject, paramList);
    }
    return null;
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    paramTextView1.setText(acfp.m(2131715518));
    paramTextView2.setText(acfp.m(2131715529));
    paramTextView1.setTextSize(1, 13.0F);
    paramTextView2.setTextSize(1, 13.0F);
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apnb
 * JD-Core Version:    0.7.0.1
 */