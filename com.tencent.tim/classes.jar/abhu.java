import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionPush;
import com.tencent.qphone.base.util.QLog;

class abhu
  implements abht.a
{
  abhu(abht paramabht) {}
  
  public void a(int paramInt, ApolloActionPush paramApolloActionPush)
  {
    if ((abht.a(this.this$0) != null) && (paramApolloActionPush != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPushManager", 2, "[onActionPush], aioType:" + paramInt + ";pushData:" + paramApolloActionPush.toString());
      }
      if ((abht.a(this.this$0).cZ == paramInt) && (paramInt == abht.a(this.this$0).cZ) && (!TextUtils.isEmpty(abht.a(this.this$0).aTl)) && (abht.a(this.this$0).aTl.equals(String.valueOf(paramApolloActionPush.mSessionId)))) {
        this.this$0.a(paramApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhu
 * JD-Core Version:    0.7.0.1
 */