import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ajqn
  extends altk
{
  ajqn(ajqm paramajqm, QQAppInterface paramQQAppInterface) {}
  
  public void g(String paramString, List<NumRedMsg.NumMsgBusi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "updateNumMsg: appid msgList.size = " + paramList.size());
    }
    if (("nearby_num_red_dot".equals(paramString)) && (paramList != null))
    {
      this.b.j(this.val$app, paramList);
      acks.cw(this.val$app);
      paramString = this.val$app.a();
      if ((paramString != null) && (paramString.a("businessbase_processor") != null)) {
        paramString.a("businessbase_processor").b(105, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqn
 * JD-Core Version:    0.7.0.1
 */