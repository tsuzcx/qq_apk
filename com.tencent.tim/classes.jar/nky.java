import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;

public class nky
  implements aebf
{
  public nky(FastWebActivity paramFastWebActivity) {}
  
  public ColorNote getColorNote()
  {
    String str2 = "";
    String str1 = str2;
    if (FastWebActivity.a(this.this$0) != null)
    {
      str1 = str2;
      if (FastWebActivity.a(this.this$0).amh != null) {
        str1 = FastWebActivity.a(this.this$0).amh;
      }
    }
    ColorNote.a locala = new ColorNote.a().a(16908290);
    StringBuilder localStringBuilder = new StringBuilder().append("mainFeeds:");
    if (FastWebActivity.a(this.this$0) == null)
    {
      str2 = "";
      locala = locala.a(str2);
      if (FastWebActivity.a(this.this$0) != null) {
        break label164;
      }
      str2 = "";
      label108:
      locala = locala.b(str2);
      if (FastWebActivity.a(this.this$0) != null) {
        break label178;
      }
    }
    label164:
    label178:
    for (str2 = "";; str2 = FastWebActivity.a(this.this$0).mSubscribeName)
    {
      return locala.c(str2).d(str1).a(FastWebActivity.a(this.this$0)).a();
      str2 = FastWebActivity.a(this.this$0).innerUniqueID;
      break;
      str2 = FastWebActivity.a(this.this$0).mTitle;
      break label108;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nky
 * JD-Core Version:    0.7.0.1
 */