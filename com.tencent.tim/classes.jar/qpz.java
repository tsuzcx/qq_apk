import android.text.TextUtils;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupInnerListView.a;

public class qpz
  implements rsn.a
{
  public qpz(ShareGroupInnerListView paramShareGroupInnerListView) {}
  
  public boolean R(boolean paramBoolean)
  {
    if (this.a.a != null) {
      return this.a.a.fm(this.a.mKey);
    }
    return false;
  }
  
  public void aXi()
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(this.a.mKey))) {
      this.a.a.fm(this.a.mKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpz
 * JD-Core Version:    0.7.0.1
 */