import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class qwm
{
  public static final String[] bW = ppf.getStringArray(2130968665);
  public long Bs;
  public ptp a = new ptp();
  public boolean aFS;
  public boolean aFT;
  public String atv = "";
  public String ayX;
  public String ayY;
  public int blJ;
  public int boo;
  public int bop;
  public int boq;
  protected String cookie = "";
  public int fansCount;
  protected HashMap<String, StoryVideoItem> fu = new HashMap();
  protected boolean isOpen;
  public boolean isVip;
  public int mCommentCount;
  protected ArrayList<StoryVideoItem> nn = new ArrayList();
  protected int state;
  
  public String a(int paramInt, TextPaint paramTextPaint)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.blJ;
    int n = this.mCommentCount;
    int i1 = this.boo;
    long l2 = this.Bs;
    switch (this.state)
    {
    }
    String str;
    do
    {
      str = localStringBuilder.toString();
      int i;
      do
      {
        return str;
        if (j == 0) {
          return ppf.getString(2131701940);
        }
        localStringBuilder.append(rpq.aL(j)).append("个小视频");
        if (j > 0) {
          localStringBuilder.append(bW[0]).append("浏览").append(this.Bs);
        }
        return localStringBuilder.toString();
        if (this.isOpen)
        {
          localStringBuilder.append(rpq.aL(j)).append("个小视频");
          return localStringBuilder.toString();
        }
        localStringBuilder.append(ppf.getString(2131701954, new Object[] { Integer.valueOf(this.boq) }));
        return localStringBuilder.toString();
        if (this.isOpen)
        {
          localStringBuilder.append(rpq.aL(j)).append("个小视频");
          if (this.Bs > 0L) {
            localStringBuilder.append(bW[0]).append("浏览").append(this.Bs);
          }
          if (this.boo > 0) {
            localStringBuilder.append(bW[1]).append("赞").append(rpq.aL(this.boo));
          }
          if (this.mCommentCount <= 0) {
            break;
          }
          localStringBuilder.append(bW[1]).append("评论").append(rpq.aL(this.mCommentCount));
          break;
        }
        localStringBuilder.append(rpq.aL(this.bop)).append("个小视频发送失败");
        break;
        long l1 = l2;
        int k = i1;
        i = n;
        if (this.nn.size() > 0)
        {
          localStringBuilder.append("最近");
          int m = this.nn.size();
          l1 = l2;
          k = i1;
          i = n;
          j = m;
          if (this.a != null)
          {
            i = this.a.bkl;
            k = this.a.totalLikeCount;
            l1 = this.a.bkm;
            j = m;
          }
        }
        localStringBuilder.append(rpq.aL(j)).append("个小视频");
        str = localStringBuilder.toString();
        if (l1 > 0L) {
          localStringBuilder.append(bW[0]).append("浏览").append(l1);
        }
        if ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt)) {
          return str;
        }
        str = localStringBuilder.toString();
        if (k > 0) {
          localStringBuilder.append(bW[1]).append("赞").append(rpq.aL(k));
        }
      } while ((paramTextPaint != null) && (paramTextPaint.measureText(localStringBuilder.toString()) > paramInt));
      str = localStringBuilder.toString();
      if (i > 0) {
        localStringBuilder.append(bW[1]).append("评论").append(rpq.aL(i));
      }
    } while ((paramTextPaint == null) || (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt));
    return str;
  }
  
  public void a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    for (;;)
    {
      return;
      this.fu.remove(paramString);
      this.fu.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      int i = 0;
      while (i < this.nn.size())
      {
        if (((StoryVideoItem)this.nn.get(i)).mVid.equals(paramString))
        {
          this.nn.set(i, paramStoryVideoItem);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void brj()
  {
    qxh.a(this);
    this.state = 0;
    this.bop = 0;
    this.aFT = false;
    this.boq = 0;
    if ((this.nn == null) || (this.nn.size() == 0)) {
      if (this.blJ > 0) {}
    }
    do
    {
      return;
      this.state = 3;
      return;
      Iterator localIterator = this.nn.iterator();
      while (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
        int i = qwq.dY(localStoryVideoItem.mUploadStatus);
        if ((i == 1) || (i == 0))
        {
          this.state = 1;
          this.boq += 1;
        }
        if (localStoryVideoItem.isUploadFail()) {
          this.bop += 1;
        }
        if (!TextUtils.isEmpty(localStoryVideoItem.mDoodleText)) {
          this.aFT = true;
        }
      }
    } while (this.state == 1);
    if (this.bop > 0)
    {
      this.state = 2;
      return;
    }
    this.state = 3;
  }
  
  public ArrayList<StoryVideoItem> bu()
  {
    return this.nn;
  }
  
  public void clear()
  {
    try
    {
      this.nn.clear();
      this.fu.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public StoryVideoItem d(String paramString)
  {
    return (StoryVideoItem)this.fu.get(paramString);
  }
  
  public void eH(List<StoryVideoItem> paramList)
  {
    try
    {
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        if (localStoryVideoItem != null)
        {
          this.nn.add(localStoryVideoItem);
          this.fu.put(localStoryVideoItem.mVid, localStoryVideoItem);
        }
      }
    }
    finally {}
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void p(StoryVideoItem paramStoryVideoItem)
  {
    try
    {
      this.nn.add(0, paramStoryVideoItem);
      this.fu.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      return;
    }
    finally
    {
      paramStoryVideoItem = finally;
      throw paramStoryVideoItem;
    }
  }
  
  public void q(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    for (;;)
    {
      return;
      this.fu.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      int i = 0;
      while (i < this.nn.size())
      {
        if (((StoryVideoItem)this.nn.get(i)).mVid.equals(paramStoryVideoItem.mVid))
        {
          this.nn.set(i, paramStoryVideoItem);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void r(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.fu.remove(paramStoryVideoItem.mVid);
        i = 0;
        if (i < this.nn.size())
        {
          if (((StoryVideoItem)this.nn.get(i)).mVid.equals(paramStoryVideoItem.mVid)) {
            this.nn.remove(i);
          }
        }
        else
        {
          if ((this.nn.size() != 0) || (this.a == null)) {
            break;
          }
          this.a.bkl = 0;
          this.a.totalLikeCount = 0;
          this.a.bkm = 0;
          paramStoryVideoItem = (psr)psx.a(10);
          paramStoryVideoItem.n("qqstory_my_visiter_count", Integer.valueOf(0));
          paramStoryVideoItem.n("qqstory_my_newest_video_cover", "");
          paramStoryVideoItem.n("qqstory_my_newest_video_vid", "");
          break;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int sQ()
  {
    if (this.isOpen) {
      return this.nn.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qwm
 * JD-Core Version:    0.7.0.1
 */