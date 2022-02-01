import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class apgr
  implements ppv.b<apgq.b, ppu>
{
  apgr(apgq paramapgq) {}
  
  public void a(@NonNull apgq.b paramb, @Nullable ppu paramppu, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      ram.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      apgq.a(this.a, paramErrorMessage);
      return;
    }
    if (paramppu.errorCode == 0)
    {
      paramb = new apgq.c();
      paramb.url = apgq.a(this.a);
      paramb.coS = apgq.a(this.a).coS;
      apgq.a(this.a, paramb);
      return;
    }
    ram.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramppu.errorMsg);
    apgq.b(this.a, new ErrorMessage(paramppu.errorCode, paramppu.errorMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgr
 * JD-Core Version:    0.7.0.1
 */