import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class advs
  extends advq
{
  advs(advr paramadvr) {}
  
  protected void a(boolean paramBoolean1, advo paramadvo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str4 = advr.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo not success: " + paramInt1 + " " + paramLong + " " + paramInt2);
      }
      advr.a(this.this$0, str4, null, null);
      return;
    }
    if ((paramadvo != null) && (paramadvo.uQ != null) && (!paramadvo.uQ.isEmpty())) {}
    for (paramadvo = DynamicAvatar.convertFrom((advo.a)paramadvo.uQ.get(0));; paramadvo = null)
    {
      if (paramadvo == null)
      {
        advr.a(this.this$0, str4, null, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.dynamicAvatar", 2, "onGetDynamicAvatarInfo: " + paramadvo);
      }
      String str2 = advr.a(paramInt2, paramInt3, paramadvo);
      String str3 = advr.a(paramInt2, 640, paramadvo);
      String str1 = str3;
      paramLong = str2;
      if (TextUtils.isEmpty(str2))
      {
        str1 = str3;
        paramLong = str2;
        if (paramBoolean2)
        {
          paramLong = advr.a(17, paramInt3, paramadvo);
          str1 = advr.a(17, 640, paramadvo);
        }
      }
      advr.a(this.this$0, str4, paramLong, str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */