import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import java.util.List;

class apkc
  extends Handler
{
  apkc(apkb paramapkb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.b.jdField_a_of_type_Apkb$b == null) {}
    WordInfo localWordInfo;
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localWordInfo = (WordInfo)paramMessage.obj;
        this.b.jdField_a_of_type_Apkb$b.b(localWordInfo);
        if (this.b.b == null) {
          this.b.c(localWordInfo);
        }
        break;
      }
    } while ((!localWordInfo.isDetected) || (localWordInfo.paragraphPos != this.b.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.size() - 1));
    paramMessage = ((ParagraphInfo)this.b.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.paragraphs.get(localWordInfo.paragraphPos)).generateOrGetWordInfoList(localWordInfo.paragraphPos);
    int i = localWordInfo.wordPos + 1;
    label148:
    if (i < paramMessage.size())
    {
      localWordInfo = (WordInfo)paramMessage.get(i);
      if ((localWordInfo == null) || (!localWordInfo.isNormalWord())) {}
    }
    for (i = 0; i != 0; i = 1)
    {
      this.b.ear();
      return;
      i += 1;
      break label148;
      this.b.jdField_a_of_type_Apkb$b.eaa();
      return;
      this.b.jdField_a_of_type_Apkb$b.bd(this.b.dUG, this.b.clt, this.b.dUH);
      this.b.dUG = 0;
      this.b.dUH = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkc
 * JD-Core Version:    0.7.0.1
 */