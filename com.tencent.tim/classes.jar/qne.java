import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class qne
  extends qmm.b
{
  private boolean aEu;
  private String axL = "";
  private String axR;
  private qjq c;
  
  private ptx a(StoryVideoItem paramStoryVideoItem)
  {
    pty localpty = paramStoryVideoItem.getOALinkInfo();
    if ((localpty != null) && (localpty.a != null))
    {
      ram.d("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    ram.d("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public boolean F(View paramView)
  {
    if (!super.F(paramView)) {
      return false;
    }
    if ((this.c != null) && (this.c.b().isGameVideo())) {
      rar.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.axR, this.c.b().mVid });
    }
    return true;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    this.c = paramqjq;
    Object localObject2 = paramqjq.b();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.b.hide();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.axR = ((ptw)localObject2).id;
    }
    paramc.xk.setVisibility(0);
    paramc.content.setVisibility(0);
    paramc.imageView.setVisibility(0);
    paramc.itemView.setBackgroundResource(2130840146);
    paramc.itemView.setPadding(paramc.itemView.getPaddingLeft(), paramc.itemView.getPaddingTop(), paramc.itemView.getPaddingRight(), paramc.itemView.getPaddingBottom());
    Object localObject3 = ((ptf)psx.a(2)).b(paramqjq.b().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((ptx)localObject1).avk;
      localObject2 = ((ptx)localObject1).avl;
      localObject1 = ((ptx)localObject1).avm;
      localObject3 = paramc.xk;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      qmm.a(str, paramc.imageView, paramc.defaultDrawable, paramc.bnm, paramc.bnm);
      paramc.content.setText((CharSequence)localObject2);
      paramc.content.setTextColor(-1);
      if (!TextUtils.equals(this.axL, paramqjq.vid)) {
        break label348;
      }
      this.aEu = false;
    }
    for (;;)
    {
      if ((this.aEu) && (this.c != null)) {
        rar.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.axR, this.c.b().mVid });
      }
      return;
      str = ((ptx)localObject1).avh;
      localObject2 = ((ptx)localObject1).avi;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((ptx)localObject1).avj;
        break;
      }
      localObject1 = acfp.m(2131706715);
      break;
      label339:
      localObject1 = acfp.m(2131706714);
      break label176;
      label348:
      this.aEu = true;
      if (!awsw.O(this.b.getActivity())) {
        awsw.gC(this.b.getActivity());
      }
      this.axL = paramqjq.vid;
    }
  }
  
  public Set<qig> v()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new qne.a());
    return localHashSet;
  }
  
  public class a
    extends qjh
  {
    public a() {}
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      if ((paramInt1 == 66666) && (paramInt2 == -1)) {
        qne.this.b.getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qne
 * JD-Core Version:    0.7.0.1
 */