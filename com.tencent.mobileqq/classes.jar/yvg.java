import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;

public class yvg
  implements CmGameStartChecker.ICmGameConfirmListener
{
  public yvg(CmGameStartChecker paramCmGameStartChecker, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    CmGameStartChecker localCmGameStartChecker = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker;
    String str;
    if (this.jdField_a_of_type_Boolean)
    {
      str = this.jdField_a_of_type_JavaLangString;
      localCmGameStartChecker.a(paramStartCheckParam, str);
      if (!"message".equals(this.c)) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 0)
    {
      VipUtils.a(null, "cmshow", "Apollo", "download_confirm", i, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
      return;
      str = this.b;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvg
 * JD-Core Version:    0.7.0.1
 */