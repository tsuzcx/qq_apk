import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class sba
  implements shp.a
{
  sba(sat paramsat, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void yl(int paramInt)
  {
    QLog.d(sat.TAG, 2, "count:" + paramInt);
    if ((sat.n(this.this$0) != null) && (paramInt == 1))
    {
      if (shp.a().r(sat.o(this.this$0), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.this$0.a != null) && (!this.this$0.a.Mx())) {
        this.this$0.bxL();
      }
    }
    label90:
    while ((shp.a().r(sat.p(this.this$0), "subscribe_sp_key_show_follow_guide") != 0) || (rze.a(this.b))) {
      return;
    }
    this.this$0.bxK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sba
 * JD-Core Version:    0.7.0.1
 */