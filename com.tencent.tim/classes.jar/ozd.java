import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

class ozd
  implements ouy.a
{
  ozd(oyu.c paramc, FeedCloudMeta.StComment paramStComment) {}
  
  public void onClick(int paramInt)
  {
    Object localObject;
    if (paramInt == ouy.b.bgp)
    {
      oyu.a(this.b.this$0, 48);
      if (this.b.this$0.a().a(oyu.a(this.b.this$0), this.g))
      {
        localObject = oyu.a(this.b.this$0).getString(2131700168);
        aqha.a(oyu.a(this.b.this$0), 230, (String)localObject, null, 2131721058, 2131691042, new oze(this), new ozf(this)).show();
      }
    }
    do
    {
      do
      {
        return;
        this.b.this$0.a().b(oyu.a(this.b.this$0), this.g);
        oyu.b(this.b.this$0, true);
        return;
        if (paramInt == ouy.b.bgq)
        {
          oyu.a(this.b.this$0, 49);
          localObject = oyu.b(this.b.this$0).getString(2131700070);
          aqha.a(oyu.b(this.b.this$0), 230, (String)localObject, null, 2131721058, 2131691042, new ozg(this), new ozh(this)).show();
          return;
        }
        if (paramInt != ouy.b.bgr) {
          break;
        }
        oyu.a(this.b.this$0, 46);
        localObject = (ClipboardManager)oyu.c(this.b.this$0).getSystemService("clipboard");
      } while (localObject == null);
      ClipData localClipData = ClipData.newPlainText("", this.g.content.get());
      alkw.a((ClipboardManager)localObject, localClipData);
      ((ClipboardManager)localObject).setPrimaryClip(localClipData);
      return;
    } while (paramInt != ouy.b.bgt);
    oyu.a(this.b.this$0, 47);
    if (ovd.a((FeedCloudMeta.StUser)this.g.postUser.get())) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = oyu.c(this.b.this$0).getString(2131700074);
      aqha.a(oyu.d(this.b.this$0), 230, (String)localObject, null, 2131721058, 2131691042, new ozi(this, paramInt), new ozj(this)).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozd
 * JD-Core Version:    0.7.0.1
 */