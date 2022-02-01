import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

public class ksr
  implements kva.a
{
  public ksr(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void pE(int paramInt)
  {
    if (paramInt != 2) {
      this.this$0.aGG();
    }
    kxm.b localb1 = new kxm.b();
    kxm.b localb2 = localb1.j().b("rowkey", ReadInJoyCommentListFragment.a(this.this$0).innerUniqueID).b("entry", "2");
    if (paramInt == 2) {}
    for (String str = "1";; str = "0")
    {
      localb2.b("result", str);
      ksz.a("0X800A00F", ReadInJoyCommentListFragment.a(this.this$0), localb1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksr
 * JD-Core Version:    0.7.0.1
 */