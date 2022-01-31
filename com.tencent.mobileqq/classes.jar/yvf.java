import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.FileUtils;

public class yvf
  implements Runnable
{
  public yvf(CmGameStartChecker paramCmGameStartChecker, CmGameStartChecker.StartCheckParam paramStartCheckParam, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) {
      return;
    }
    String str = ApolloConstant.n + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.gameId + ".patch";
    FileUtils.a(this.jdField_a_of_type_ArrayOfByte, str);
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker.c(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvf
 * JD-Core Version:    0.7.0.1
 */