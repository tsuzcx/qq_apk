import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tribe.async.dispatch.Dispatcher;

public class pwl
  extends pwp
{
  public static final String auW = ppf.getString(2131701926);
  public QQUserUIItem b;
  private boolean mIsVip;
  
  public pwl(ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 2131561902);
  }
  
  protected void a(String paramString, boolean paramBoolean, puh parampuh)
  {
    this.a.setNodeName(paramString, paramBoolean);
  }
  
  protected String c(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return null;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public void r(puh parampuh)
  {
    super.r(parampuh);
    ram.b("FollowNodeViewHolder", "bindData %s", parampuh);
    this.itemView.setTag(parampuh.unionId);
    this.b = ((ptf)psx.a(2)).a(parampuh.unionId, false);
    this.mIsVip = true;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (pvz.aCs)
    {
      if ((this.b != null) && (this.b.isVipButNoFriend()))
      {
        bool = true;
        this.mIsVip = bool;
      }
    }
    else
    {
      localObject2 = c(this.b);
      if (!this.mIsVip) {
        break label194;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = acfp.m(2131706384);
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = auW;
        if (!TextUtils.isEmpty(parampuh.title)) {
          localObject1 = parampuh.title;
        }
        ram.b("FollowNodeViewHolder", "bindData() with fallback nickname %s, unionId = %s", localObject1, parampuh.unionId);
        pmi.a().dispatch(new pug(parampuh.unionId));
        localObject2 = localObject1;
      }
      a((String)localObject2, this.mIsVip, parampuh);
      setCoverUrl(parampuh.videoCover);
      return;
      bool = false;
      break;
      label194:
      localObject1 = localObject2;
      if (this.b != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.b.qq;
        }
      }
    }
  }
  
  protected void setCoverUrl(String paramString)
  {
    rt(rpn.gn(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwl
 * JD-Core Version:    0.7.0.1
 */