import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class apje
  implements DialogInterface.OnClickListener
{
  public apje(ReciteFragment paramReciteFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.RN(false);
    this.b.dZW();
    QQAppInterface localQQAppInterface;
    String str1;
    String str2;
    if (this.val$app != null)
    {
      localQQAppInterface = this.val$app;
      str1 = this.b.jdField_a_of_type_Apkp.mTroopUin;
      str2 = this.b.jdField_a_of_type_Apkp.mTroopUin;
      if (this.b.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) {
        break label108;
      }
    }
    label108:
    for (paramDialogInterface = this.b.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; paramDialogInterface = "")
    {
      aqfr.a(localQQAppInterface, str1, "Grp_recite", "Out_Recite_Clk", 0, 0, new String[] { str2, "", paramDialogInterface, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apje
 * JD-Core Version:    0.7.0.1
 */