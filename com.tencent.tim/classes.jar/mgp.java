import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;

public class mgp
{
  public int aRt;
  public String agH = "";
  public String agI = "";
  public String agJ = "";
  public int cardStyle;
  
  public static mgp a(articlesummary.AnswerDetail paramAnswerDetail)
  {
    mgp localmgp = new mgp();
    if (paramAnswerDetail.question_rowkey.has()) {
      localmgp.agH = paramAnswerDetail.question_rowkey.get();
    }
    if (paramAnswerDetail.question_title.has()) {
      localmgp.agI = paramAnswerDetail.question_title.get();
    }
    if (paramAnswerDetail.answer_content.has()) {
      localmgp.agJ = paramAnswerDetail.answer_content.get();
    }
    if (paramAnswerDetail.agreed_num.has()) {
      localmgp.aRt = paramAnswerDetail.agreed_num.get();
    }
    if (paramAnswerDetail.card_style.has()) {
      localmgp.cardStyle = paramAnswerDetail.card_style.get();
    }
    return localmgp;
  }
  
  public articlesummary.AnswerDetail a()
  {
    articlesummary.AnswerDetail localAnswerDetail = new articlesummary.AnswerDetail();
    if (!TextUtils.isEmpty(this.agH)) {
      localAnswerDetail.question_rowkey.set(this.agH);
    }
    if (!TextUtils.isEmpty(this.agI)) {
      localAnswerDetail.question_title.set(this.agI);
    }
    if (!TextUtils.isEmpty(this.agJ)) {
      localAnswerDetail.answer_content.set(this.agJ);
    }
    localAnswerDetail.agreed_num.set(this.aRt);
    localAnswerDetail.card_style.set(this.cardStyle);
    return localAnswerDetail;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgp
 * JD-Core Version:    0.7.0.1
 */