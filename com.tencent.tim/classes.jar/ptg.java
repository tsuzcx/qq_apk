import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import java.util.List;

class ptg
  implements ppv.b<pym, pzz>
{
  ptg(ptf paramptf, QQUserUIItem.a parama, boolean paramBoolean, long paramLong) {}
  
  public void a(pym arg1, pzz parampzz, ErrorMessage paramErrorMessage)
  {
    long l = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess())
    {
      ??? = parampzz.nn;
      if (???.size() > 0)
      {
        ??? = (QQUserUIItem)???.get(0);
        ??? = this.this$0.a(???);
        this.a.qq = ???.qq;
        this.a.unionId = ???.uid;
        if (this.aBA)
        {
          ??? = (psr)psx.a(10);
          ???.n("qqstory_my_uin", this.a.qq);
          ???.n("qqstory_my_union_id", this.a.unionId);
        }
      }
      ram.w("Q.qqstory.user.UserManager", "get server inf success ,%s , time :%d", new Object[] { this.a, Long.valueOf(l - this.val$startTime) });
    }
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
      ram.w("Q.qqstory.user.UserManager", "get server info fail , %s, time :%d", new Object[] { paramErrorMessage, Long.valueOf(l - this.val$startTime) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptg
 * JD-Core Version:    0.7.0.1
 */