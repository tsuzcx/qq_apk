import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class kro
  implements ViewBase.OnClickListener
{
  kro(kqz paramkqz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_b_of_type_Ktm.articleInfo != null)
    {
      paramViewBase = new krx(this.a.jdField_b_of_type_Ktm).a().build();
      kbp.a(null, ksz.a(this.a.jdField_b_of_type_Ktm.articleInfo), "0X8009010", "0X8009010", 0, 0, String.valueOf(this.a.jdField_b_of_type_Ktm.articleInfo.mArticleID), String.valueOf(this.a.jdField_b_of_type_Ktm.articleInfo.mStrategyId), this.a.jdField_b_of_type_Ktm.articleInfo.innerUniqueID, paramViewBase, false);
    }
    if (((this.a.jdField_b_of_type_Ktm.a instanceof CommentData)) && (((CommentData)this.a.jdField_b_of_type_Ktm.a).subCommentNum > 0))
    {
      if ((this.a.jdField_b_of_type_Kte instanceof ksm)) {
        ((ksm)this.a.jdField_b_of_type_Kte).a(this.a.jdField_b_of_type_Ktm, kqy.a(this.a.jdField_b_of_type_Ktm, 0));
      }
      return;
    }
    this.a.jdField_b_of_type_Kte.a(this.a.jdField_b_of_type_Ktm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kro
 * JD-Core Version:    0.7.0.1
 */