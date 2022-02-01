import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.a;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class qmx
  extends qmm.b
{
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private qmm.e jdField_a_of_type_Qmm$e;
  private qmx.c jdField_a_of_type_Qmx$c;
  private boolean aEu;
  private String axL = "";
  private String axO;
  private String axP;
  private pty jdField_c_of_type_Pty;
  private qjq jdField_c_of_type_Qjq;
  private int mType;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.b);
      if (this.jdField_a_of_type_Qmm$e != null) {
        this.jdField_a_of_type_Qmm$e.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Qmx$c != null) {
        this.jdField_a_of_type_Qmx$c.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher.a(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
  }
  
  private void bpr()
  {
    if ((this.mType != 1) && (this.mType != 2)) {}
    StoryVideoItem localStoryVideoItem;
    int i;
    label190:
    do
    {
      return;
      localStoryVideoItem = this.jdField_c_of_type_Qjq.b();
      Object localObject2 = this.jdField_c_of_type_Pty.a;
      i = this.jdField_c_of_type_Qjq.b().comparedLevel;
      if (this.mType == 1)
      {
        localObject1 = ((ptv)localObject2).bgUrl;
        str = ((ptv)localObject2).comparedVid;
        int j = ((ptv)localObject2).taskId;
        localObject2 = (psu)psx.a(5);
        ptf localptf = (ptf)psx.a(2);
        localObject2 = ((psu)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localptf.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            rar.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
            return;
            i = 0;
            break;
          }
        }
        this.axO = str;
        this.axP = ((String)localObject1);
        return;
      }
    } while (this.mType != 2);
    String str = localStoryVideoItem.mVid;
    a(str, "", true, i, 0);
    Object localObject1 = ((ptf)psx.a(2)).b(localStoryVideoItem.mOwnerUid);
    if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
    {
      i = 1;
      if (i == 0) {
        break label311;
      }
    }
    label311:
    for (localObject1 = "2";; localObject1 = "1")
    {
      rar.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public boolean F(View paramView)
  {
    if (!super.F(paramView)) {
      return false;
    }
    bpr();
    return true;
  }
  
  public Map<Subscriber, String> N()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Qmx$c == null) {
      this.jdField_a_of_type_Qmx$c = new qmx.c(this);
    }
    localHashMap.put(this.jdField_a_of_type_Qmx$c, "");
    localHashMap.put(new qmx.b(this), "");
    localHashMap.put(new qmx.a(this), "");
    return localHashMap;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    this.jdField_c_of_type_Qjq = paramqjq;
    this.axO = null;
    this.axP = null;
    StoryVideoItem localStoryVideoItem = paramqjq.b();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    pty localpty = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((pty)localObject).a != null) && (!TextUtils.isEmpty(((pty)localObject).a.comparedVid)))
    {
      this.mType = 1;
      this.jdField_c_of_type_Pty = ((pty)localObject);
      ram.d("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramqjq.vid, this.jdField_c_of_type_Pty.title, this.jdField_c_of_type_Pty.a.comparedVid, Integer.valueOf(this.jdField_c_of_type_Pty.a.taskId), this.jdField_c_of_type_Pty.a.bgUrl, this.jdField_c_of_type_Pty.a.iconUrl });
      this.b.show();
      localObject = this.jdField_c_of_type_Pty.a;
      if (!TextUtils.equals(this.axL, paramqjq.vid)) {
        break label487;
      }
      this.aEu = false;
      paramc.content.setVisibility(0);
      paramc.mJ.setVisibility(0);
      paramc.imageView.setVisibility(0);
      paramqjq = this.jdField_c_of_type_Pty.title;
      if (TextUtils.isEmpty(paramqjq)) {
        break label503;
      }
      paramc.content.setText(paramqjq);
      paramc.content.setContentDescription(paramqjq);
      paramc.imageView.setImageResource(2130847301);
      if ((localObject != null) && (!TextUtils.isEmpty(((ptv)localObject).iconUrl))) {
        qmm.a(((ptv)localObject).iconUrl, paramc.imageView, paramc.itemView.getContext().getResources().getDrawable(2130847301), paramc.bnm, paramc.bnm);
      }
      paramc = ((ptf)psx.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.aEu)
      {
        if ((paramc == null) || (!paramc.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((ptv)localObject).taskId;
        label355:
        if (i == 0) {
          break label543;
        }
        paramc = "2";
        label362:
        if (localObject == null) {
          break label549;
        }
      }
    }
    label532:
    label537:
    label543:
    label549:
    for (paramqjq = ((ptv)localObject).comparedVid;; paramqjq = "")
    {
      rar.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramc, paramqjq, "", localStoryVideoItem.mVid });
      return;
      if ((localpty != null) && (localpty.styleType == 3))
      {
        this.mType = 2;
        this.jdField_c_of_type_Pty = localpty;
        ram.b("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramqjq.vid, this.jdField_c_of_type_Pty.title);
        break;
      }
      ram.b("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramqjq.vid);
      this.b.hide();
      this.mType = -1;
      this.jdField_c_of_type_Pty = null;
      return;
      label487:
      this.aEu = true;
      this.axL = paramqjq.vid;
      break label192;
      label503:
      paramc.content.setText(acfp.m(2131703492));
      paramc.content.setContentDescription(acfp.m(2131703493));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramc = "1";
      break label362;
    }
  }
  
  public Set<qig> v()
  {
    HashSet localHashSet = new HashSet(1);
    qmm.e locale = new qmm.e();
    this.jdField_a_of_type_Qmm$e = locale;
    localHashSet.add(locale);
    return localHashSet;
  }
  
  public static class a
    extends pml<qmx, pxn.a>
  {
    public a(qmx paramqmx)
    {
      super();
    }
    
    public void a(@NonNull qmx paramqmx, @NonNull pxn.a parama)
    {
      if ((qmx.a(paramqmx) != null) && (parama.b.isSuccess()) && (parama.mS.contains(qmx.a(paramqmx).vid)))
      {
        ram.b("CaptureTogetherBannerVideoInfoController", "GetStoryTagInfoReceiver receive tag info change event. %s", parama.mT.toString());
        paramqmx.b.updateUI();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxn.a.class;
    }
    
    public void b(@NonNull qmx paramqmx, @NonNull pxn.a parama) {}
  }
  
  public static class b
    extends pml<qmx, pyc.a>
  {
    public b(qmx paramqmx)
    {
      super();
    }
    
    public void a(@NonNull qmx paramqmx, @NonNull pyc.a parama)
    {
      if (qmx.a(paramqmx) != 1) {}
      label149:
      label209:
      label218:
      for (;;)
      {
        return;
        int i = 0;
        StoryVideoItem localStoryVideoItem;
        if (i < parama.mVideoList.size())
        {
          localStoryVideoItem = (StoryVideoItem)parama.mVideoList.get(i);
          if (!localStoryVideoItem.mVid.equals(qmx.a(paramqmx))) {}
        }
        for (parama = localStoryVideoItem;; parama = null)
        {
          if ((parama == null) || (parama.mErrorCode != 0)) {
            break label218;
          }
          localStoryVideoItem = qmx.a(paramqmx).b();
          i = localStoryVideoItem.comparedLevel;
          int j = qmx.a(paramqmx).a.taskId;
          String str = qmx.a(paramqmx).a.bgUrl;
          qmx.a(paramqmx, qmx.a(paramqmx), str, false, i, j);
          paramqmx = ((ptf)psx.a(2)).b(parama.mOwnerUid);
          if ((paramqmx != null) && (paramqmx.isVip))
          {
            i = 1;
            if (i == 0) {
              break label209;
            }
          }
          for (paramqmx = "2";; paramqmx = "1")
          {
            rar.a("play_video", "multishoot_entry_clk", 0, j, new String[] { paramqmx, parama.mVid, parama.mOwnerUid, localStoryVideoItem.mVid });
            return;
            i += 1;
            break;
            i = 0;
            break label149;
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return pyc.a.class;
    }
    
    public void b(@NonNull qmx paramqmx, @NonNull pyc.a parama) {}
  }
  
  public static class c
    extends QQUIEventReceiver<qmx, StoryPlayerGroupHolder.a>
  {
    private WeakReference<qmm.f> cX;
    
    public c(@NonNull qmx paramqmx)
    {
      super();
    }
    
    public void a(qmm.f paramf)
    {
      this.cX = new WeakReference(paramf);
    }
    
    public void a(@NonNull qmx paramqmx, @NonNull StoryPlayerGroupHolder.a parama)
    {
      if (parama.isSuccess) {
        if ((parama.vid != null) && (this.cX != null))
        {
          paramqmx = (qmm.f)this.cX.get();
          if (paramqmx != null) {
            paramqmx.rC(parama.vid);
          }
        }
      }
      do
      {
        do
        {
          return;
          ram.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { parama.vid });
        } while (this.cX == null);
        paramqmx = (qmm.f)this.cX.get();
      } while (paramqmx == null);
      paramqmx.bnS();
    }
    
    public Class acceptEventClass()
    {
      return StoryPlayerGroupHolder.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmx
 * JD-Core Version:    0.7.0.1
 */