import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class alfn
  implements alfl.a
{
  alfn(alfl paramalfl) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (alfl.a(this.b) == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          break label195;
        }
        if ((paramUniBusiGetOneItemWithCheckRsp == null) || (paramUniBusiGetOneItemWithCheckRsp.stDetail == null)) {
          break;
        }
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != alfl.a(this.b).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        alfl.a(this.b, false);
        this.b.dFA();
        return;
      }
    } while (!alfl.a(this.b));
    alfl.a(this.b, alfl.a(this.b), alfl.a(this.b).stAidInfo.androidAid, alfl.a(this.b).stAidInfo.payType, alfl.a(this.b).stAidInfo.errMsg, alfl.a(this.b).stAidInfo.month);
    return;
    alfl.a(this.b, false);
    QQToast.a(alfl.a(this.b), acfp.m(2131715484), 0).show();
    alfl.a(this.b, null);
    alfl.a(this.b, -1);
    return;
    label195:
    this.b.dFA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfn
 * JD-Core Version:    0.7.0.1
 */