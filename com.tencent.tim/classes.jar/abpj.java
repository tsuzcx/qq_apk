import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.utils.VipUtils;

class abpj
  implements CmGameStartChecker.b
{
  abpj(abpi paramabpi) {}
  
  public void b(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    abpi localabpi = this.this$0;
    if (abpi.a(this.this$0).isPatch)
    {
      paramStartCheckParam = abpi.a(this.this$0).patchUrl;
      abpi.a(localabpi, paramStartCheckParam);
      if (!"message".equals(abpi.a(this.this$0).from)) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(abpi.a(this.this$0).gameId) });
      return;
      paramStartCheckParam = abpi.a(this.this$0).bhl;
      break;
    }
  }
  
  public void c(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (abpi.a(this.this$0) != null) {
      abpi.a(this.this$0).bK(-10001, abpi.a(this.this$0).packName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpj
 * JD-Core Version:    0.7.0.1
 */