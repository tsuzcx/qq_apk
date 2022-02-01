import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

final class vvx
  extends ayxn
{
  vvx(boolean paramBoolean) {}
  
  public void a(cmd0x9ae.RspBody paramRspBody)
  {
    int j = 1;
    if (paramRspBody != null)
    {
      boolean bool = paramRspBody.bool_has_been_authenticated.get();
      paramRspBody = paramRspBody.msg_auth_tips.string_tips_action_url.get();
      if ((paramRspBody != null) && (paramRspBody.trim().length() > 0))
      {
        uyk localuyk = uyk.a();
        if (!bool) {
          break label88;
        }
        i = 1;
        localuyk.b(i);
        localuyk.a(paramRspBody);
      }
      if (this.a) {
        if (!bool) {
          break label93;
        }
      }
    }
    label88:
    label93:
    for (int i = j;; i = 2)
    {
      vtq.a("", 53, 4, i);
      return;
      i = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvx
 * JD-Core Version:    0.7.0.1
 */