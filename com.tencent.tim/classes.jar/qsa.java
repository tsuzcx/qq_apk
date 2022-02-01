import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class qsa
  implements ppv.b<pyk, pyk.a>
{
  qsa(qrz paramqrz) {}
  
  public void a(@NonNull pyk parampyk, @Nullable pyk.a arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.b("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb return:%s", paramErrorMessage.toString());
    if (qrz.a(this.this$0))
    {
      ram.i("Q.qqstory.home.data:VideoListPageLoader", "don't nothing after terminate");
      return;
    }
    parampyk = new qrz.b(paramErrorMessage, qrz.a(this.this$0));
    parampyk.aCv = this.this$0.aCx;
    if ((??? == null) || (paramErrorMessage.isFail()) || (???.nm.size() == 0))
    {
      ram.b("Q.qqstory.home.data:VideoListPageLoader", "get video list with home pb fail feedId:%s", qrz.a(this.this$0));
      qrz.a(this.this$0, parampyk);
      return;
    }
    ??? = (qwa)???.nm.get(0);
    if (!(??? instanceof qwc))
    {
      parampyk.b = new ErrorMessage(940001, acfp.m(2131716420));
      qrz.a(this.this$0, parampyk);
      rom.fail(???.a().toString() + " is not a video feed", new Object[0]);
      return;
    }
    ??? = (qwc)???;
    qrz.a(this.this$0, ???.c().mVideoNextCookie);
    qrz.a(this.this$0, ???.c().mVideoPullType);
    qrz.b(this.this$0, ???.c().mVideoSeq);
    parampyk.isEnd = ???.c().mIsVideoEnd;
    parampyk.oj = ???.bS();
    parampyk.isFirstPage = true;
    if ((!parampyk.isEnd) && (TextUtils.isEmpty(qrz.b(this.this$0)))) {
      parampyk.isEnd = true;
    }
    parampyk.mUnionId = ???.c().getOwner().getUnionId();
    parampyk.oj = ((qvf)psx.a(11)).a(qrz.a(this.this$0), parampyk.oj, parampyk.isFirstPage);
    parampyk.a = new FeedVideoInfo(qrz.a(this.this$0), qrz.b(this.this$0), qrz.a(this.this$0), qrz.b(this.this$0), parampyk.isEnd);
    ??? = new ArrayList(parampyk.oj.size());
    paramErrorMessage = parampyk.oj.iterator();
    while (paramErrorMessage.hasNext()) {
      ???.add(((StoryVideoItem)paramErrorMessage.next()).mVid);
    }
    pxt.ei(???);
    synchronized (this.this$0)
    {
      this.this$0.aCy = true;
      qrz.a(this.this$0, parampyk);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsa
 * JD-Core Version:    0.7.0.1
 */